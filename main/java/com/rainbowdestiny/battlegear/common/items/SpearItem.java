package com.rainbowdestiny.battlegear.common.items;

import java.util.UUID;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.ItemFrameEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.item.IItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.item.ItemStack;
import net.minecraft.util.LazyValue;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent.ClickInputEvent;
import net.minecraftforge.common.ForgeMod;

@EventBusSubscriber
public class SpearItem extends SwordItem {

	private static int addedRange = 5;
	private Effect effect = null;
	public static final AttributeModifier RangeAttributeModifier = new AttributeModifier(UUID.randomUUID(),
			"Range modifier", addedRange, AttributeModifier.Operation.ADDITION);
	private static LazyValue<Multimap<Attribute, AttributeModifier>> rangeModifier = new LazyValue<>(
			() -> ImmutableMultimap.of(ForgeMod.REACH_DISTANCE.get(), RangeAttributeModifier));

	@SuppressWarnings("resource")
	private static boolean isPlayerHolding() {
		if (Minecraft.getInstance().getCameraEntity() == null)
			return false;
		return Minecraft.getInstance().player.getMainHandItem().getItem() instanceof SpearItem;
	}

	// Contructors
	public SpearItem(IItemTier tier, int attackDamage, float attackSpeed, Properties properties) {
		super(tier, attackDamage, attackSpeed, properties);
	}

	public SpearItem(IItemTier tier, int attackDamage, float attackSpeed, Properties properties, Effect effect) {
		super(tier, attackDamage, attackSpeed, properties);
		this.setEffect(effect);
	}

	@Override
	public boolean hurtEnemy(ItemStack item, LivingEntity entity, LivingEntity player) {
		if (this.getEffect() != null)
			entity.addEffect(new EffectInstance(this.getEffect(), 200, 0, true, true));
		return super.hurtEnemy(item, entity, player);
	}

	@SubscribeEvent
	public static void holdingSpear(LivingUpdateEvent event) {
		if (!(event.getEntity() instanceof PlayerEntity))
			return;

		PlayerEntity player = (PlayerEntity) event.getEntityLiving();
		CompoundNBT persistentData = player.getPersistentData();

		if (SpearItem.isPlayerHolding()) {
			player.getAttributes().addTransientAttributeModifiers(rangeModifier.get());
			persistentData.putBoolean("BGSpearRange", true);
		} else {
			player.getAttributes().removeAttributeModifiers(rangeModifier.get());
			persistentData.remove("BGSpearRange");
		}
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
//	Edited GameRenderer.pick
	public static void dontMissEntitiesWhenYouHaveHighReachDistance(ClickInputEvent event) {
		Minecraft mc = Minecraft.getInstance();
		Entity entity = mc.getCameraEntity();
		float f0 = 1.0f;

		if (entity != null && SpearItem.isPlayerHolding()) {
			if (mc.level != null) {
				mc.crosshairPickEntity = null;
				double d0 = (double) mc.gameMode.getPickRange() + addedRange;
				mc.hitResult = entity.pick(d0, f0, false);
				Vector3d vector3d = entity.getEyePosition(f0);
				double d1 = d0;
				if (mc.gameMode.hasFarPickRange()) {
					d1 += 0.5f;
					d0 = d1;
				}

				d1 = d1 * d1;
				Vector3d vector3d1 = entity.getViewVector(1.0F);
				Vector3d vector3d2 = vector3d.add(vector3d1.x * d0, vector3d1.y * d0, vector3d1.z * d0);
				AxisAlignedBB axisalignedbb = entity.getBoundingBox().expandTowards(vector3d1.scale(d0)).inflate(1.0D,
						1.0D, 1.0D);
				EntityRayTraceResult entityraytraceresult = ProjectileHelper.getEntityHitResult(entity, vector3d,
						vector3d2, axisalignedbb, (hitEntity) -> {
							return !hitEntity.isSpectator() && hitEntity.isPickable();
						}, d1);
				if (entityraytraceresult != null) {
					Entity entity1 = entityraytraceresult.getEntity();
					Vector3d vector3d3 = entityraytraceresult.getLocation();
					double d2 = vector3d.distanceToSqr(vector3d3);
					if (d2 < d1 || mc.hitResult == null) {
						mc.hitResult = entityraytraceresult;
						if (entity1 instanceof LivingEntity || entity1 instanceof ItemFrameEntity) {
							mc.crosshairPickEntity = entity1;

							System.out.println("Entity Detected & Found");
						}
					}
				}
			}
		}
	}

	public Effect getEffect() {
		return effect;
	}

	public void setEffect(Effect effect) {
		this.effect = effect;
	}
}
