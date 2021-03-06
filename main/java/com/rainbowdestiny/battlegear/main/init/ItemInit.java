package com.rainbowdestiny.battlegear.main.init;

import com.rainbowdestiny.battlegear.Battlegear;
import com.rainbowdestiny.battlegear.common.items.DaggerItem;
import com.rainbowdestiny.battlegear.common.items.SpearItem;
import com.rainbowdestiny.battlegear.common.items.WarAxeItem;

import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Battlegear.MOD_ID);
	
	//Misc
	public static final RegistryObject<Item> HERELDRY = ITEMS.register("hereldry", () -> new Item (new Item.Properties().tab(Battlegear.BATTLEGEAR_GROUP)));
	
	
	//Clubs & Maces
	//public static final RegistryObject<Item> IRON_MACE = ITEMS.register("iron_mace", () -> new MaceItem(ItemTier.IRON, 5, 4, new Item.Properties().tab(Battlegear.BATTLEGEAR_GROUP), "Test 1", 0));
	
	
	//War Axe
	public static final RegistryObject<Item> WOOD_WAR_AXE = ITEMS.register("wood_war_axe", () -> new WarAxeItem(ItemTier.WOOD, 3, 4, new Item.Properties().tab(Battlegear.BATTLEGEAR_GROUP), "A powerful weapon", 0));
	public static final RegistryObject<Item> STONE_WAR_AXE = ITEMS.register("stone_war_axe", () -> new WarAxeItem(ItemTier.STONE, 4, 4, new Item.Properties().tab(Battlegear.BATTLEGEAR_GROUP), "A powerful weapon", 0));
	public static final RegistryObject<Item> GOLD_WAR_AXE = ITEMS.register("gold_war_axe", () -> new WarAxeItem(ItemTier.GOLD, 3, 4, new Item.Properties().tab(Battlegear.BATTLEGEAR_GROUP), "A powerful weapon", 0));
	public static final RegistryObject<Item> IRON_WAR_AXE = ITEMS.register("iron_war_axe", () -> new WarAxeItem(ItemTier.IRON, 5, 4, new Item.Properties().tab(Battlegear.BATTLEGEAR_GROUP), "A powerful weapon", 0));
	public static final RegistryObject<Item> DIAMOND_WAR_AXE = ITEMS.register("diamond_war_axe", () -> new WarAxeItem(ItemTier.DIAMOND, 6, 4, new Item.Properties().tab(Battlegear.BATTLEGEAR_GROUP), "A powerful weapon", 0));
	public static final RegistryObject<Item> NETHERITE_WAR_AXE = ITEMS.register("netherite_war_axe", () -> new WarAxeItem(ItemTier.NETHERITE, 7, 4, new Item.Properties().tab(Battlegear.BATTLEGEAR_GROUP), "A powerful weapon", 0));

	
	//Spears
	public static final RegistryObject<Item> WOOD_SPEAR = ITEMS.register("wood_spear", () -> new SpearItem(ItemTier.WOOD, 2, 4, new Item.Properties().tab(Battlegear.BATTLEGEAR_GROUP)));
	public static final RegistryObject<Item> STONE_SPEAR = ITEMS.register("stone_spear", () -> new SpearItem(ItemTier.STONE, 3, 4, new Item.Properties().tab(Battlegear.BATTLEGEAR_GROUP)));
	public static final RegistryObject<Item> GOLD_SPEAR = ITEMS.register("gold_spear", () -> new SpearItem(ItemTier.GOLD, 6, 4, new Item.Properties().tab(Battlegear.BATTLEGEAR_GROUP)));
	public static final RegistryObject<Item> IRON_SPEAR = ITEMS.register("iron_spear", () -> new SpearItem(ItemTier.IRON, 4, 4, new Item.Properties().tab(Battlegear.BATTLEGEAR_GROUP)));
	public static final RegistryObject<Item> DIAMOND_SPEAR = ITEMS.register("diamond_spear", () -> new SpearItem(ItemTier.DIAMOND, 5, 4, new Item.Properties().tab(Battlegear.BATTLEGEAR_GROUP)));
	public static final RegistryObject<Item> NETHERITE_SPEAR = ITEMS.register("netherite_spear", () -> new SpearItem(ItemTier.NETHERITE, 7, 4, new Item.Properties().tab(Battlegear.BATTLEGEAR_GROUP)));

	public static final RegistryObject<Item> SERPENT_AXE = ITEMS.register("serpent_axe", () -> new SpearItem(ItemTier.IRON, 4, 4, new Item.Properties().tab(Battlegear.BATTLEGEAR_GROUP), Effects.POISON));

	
	//Daggers
	public static final RegistryObject<Item> WOOD_DAGGER = ITEMS.register("wood_dagger", () -> new DaggerItem(ItemTier.WOOD, 2, 4, new Item.Properties().tab(Battlegear.BATTLEGEAR_GROUP)));
	public static final RegistryObject<Item> STONE_DAGGER = ITEMS.register("stone_dagger", () -> new DaggerItem(ItemTier.STONE, 3, 4, new Item.Properties().tab(Battlegear.BATTLEGEAR_GROUP)));
	public static final RegistryObject<Item> GOLD_DAGGER = ITEMS.register("gold_dagger", () -> new DaggerItem(ItemTier.GOLD, 2, 4, new Item.Properties().tab(Battlegear.BATTLEGEAR_GROUP)));
	public static final RegistryObject<Item> IRON_DAGGER = ITEMS.register("iron_dagger", () -> new DaggerItem(ItemTier.IRON, 4, 4, new Item.Properties().tab(Battlegear.BATTLEGEAR_GROUP)));
	public static final RegistryObject<Item> DIAMOND_DAGGER = ITEMS.register("diamond_dagger", () -> new DaggerItem(ItemTier.DIAMOND, 5, 4, new Item.Properties().tab(Battlegear.BATTLEGEAR_GROUP)));
	public static final RegistryObject<Item> NETHERITE_DAGGER = ITEMS.register("netherite_dagger", () -> new DaggerItem(ItemTier.NETHERITE, 6, 4, new Item.Properties().tab(Battlegear.BATTLEGEAR_GROUP)));

	
	//Shields
	//public static final RegistryObject<Item> IRON_SHIELD = ITEMS.register("iron_shield", () -> new BGShieldItem(ItemGroup.TAB_COMBAT))));
	//public static final RegistryObject<Item> DIAMOND_SHIELD = ITEMS.register("diamond_shield", () -> new BGShieldItem(ItemGroup.TAB_COMBAT))));

}
