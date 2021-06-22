package com.tzaranthony.modernvanilla.util;

import com.tzaranthony.modernvanilla.ModernVanilla;
import com.tzaranthony.modernvanilla.block.*;
import com.tzaranthony.modernvanilla.item.IronScaffoldingItem;
import com.tzaranthony.modernvanilla.item.SteelScaffoldingItem;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.loading.FMLEnvironment;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

@Mod.EventBusSubscriber(modid = ModernVanilla.MOD_ID, bus = Bus.MOD)
public class MVBlocks {
    // steel
    public static final Block STEEL_BLOCK = new MVBlock("steel_block", MVBlockProperties.StandardMetal(2, 6.0F, 8.0F));
    public static final Block STEEL_FRAME = new MVBlock("steel_frame", MVBlockProperties.NonFullMetal(2, 6.0F, 8.0F));
    public static final Block IRON_FRAME = new MVBlock("iron_frame", MVBlockProperties.NonFullMetal(1, 5.0F, 6.0F));

    //TODO: Cushion -- like a half slab of wool, but sittable, make it have a better texture please. Maybe a chair???


    //TODO: pallets -- storage that looks like shipping pallets
    public static final Block CARDBOARD_BOX = new CardboardBox("cardboard_box", MVBlockProperties.Cardboard(0.1F), false);
    public static final Block SHIPPING_PALLET = new CardboardBox("shipping_pallet", MVBlockProperties.Cardboard(1.5F), true);
//    public static final Block CARDBOARD_BOX = new CardboardBox("cardboard_box", MVBlockProperties.Cardboard(0.1F));
//    public static final Block SHIPPING_PALLET = new CardboardBox("shipping_pallet", MVBlockProperties.Cardboard(1.5F));

    // reinforced concrete
    public static final Block REINFORCED_CONCRETE = new MVBlock("reinforced_concrete", MVBlockProperties.StandardRock(2.0F, 9.0F));
    public static final Block REINFORCED_CONCRETE_POWDER = new MVConcretePowder("reinforced_concrete_powder", REINFORCED_CONCRETE, MaterialColor.SNOW);
    public static final Block REINFORCED_CONCRETE_STAIRS = new MVStairs("reinforced_concrete_stairs", REINFORCED_CONCRETE.defaultBlockState(), REINFORCED_CONCRETE);
    public static final Block REINFORCED_CONCRETE_SLAB = new MVSlab("reinforced_concrete_slab", MVBlockProperties.StandardRock(2.0F, 9.0F));
    // worn and cracked
    public static final Block WORN_REINFORCED_CONCRETE = new MVBlock("worn_reinforced_concrete", MVBlockProperties.StandardRock(2.0F, 9.0F));
    public static final Block CRACKED_REINFORCED_CONCRETE = new MVBlock("cracked_reinforced_concrete", MVBlockProperties.StandardRock(2.0F, 9.0F));
    public static final Block WORN_REINFORCED_CONCRETE_SLAB = new MVSlab("worn_reinforced_concrete_slab", MVBlockProperties.StandardRock(2.0F, 9.0F));
    public static final Block CRACKED_REINFORCED_CONCRETE_SLAB = new MVSlab("cracked_reinforced_concrete_slab", MVBlockProperties.StandardRock(2.0F, 9.0F));
    public static final Block WORN_REINFORCED_CONCRETE_STAIRS = new MVStairs("worn_reinforced_concrete_stairs", WORN_REINFORCED_CONCRETE.defaultBlockState(), WORN_REINFORCED_CONCRETE);
    public static final Block CRACKED_REINFORCED_CONCRETE_STAIRS = new MVStairs("cracked_reinforced_concrete_stairs", CRACKED_REINFORCED_CONCRETE.defaultBlockState(), CRACKED_REINFORCED_CONCRETE);

    // peripherals -- grate, barbed wire, metal scaffolding, pipes?, Iron blinds, steel blinds
    public static final Block BARBED_WIRE_ROLL = new BarbedWire("barbed_wire_roll");
    public static final Block BARBED_WIRE_EDGING = new MVStairsDmg("barbed_wire_edging", BARBED_WIRE_ROLL.defaultBlockState(), BARBED_WIRE_ROLL);
    public static final Block IRON_SCAFFOLDING = new IronScaffolding("iron_scaffolding");
    public static final Block STEEL_SCAFFOLDING = new SteelScaffolding("steel_scaffolding");
    public static final Block STEEL_ROD = new Rod("steel_rod", MVBlockProperties.NonFullMetal(2, 5.0F, 6.0F));

    // metal fence, steel trap door, steel door
    public static final Block IRON_FENCE = new MVFence("iron_fence", Blocks.IRON_BLOCK);
    public static final Block STEEL_FENCE = new MVFence("steel_fence", STEEL_BLOCK);
    public static final Block CHAIN_LINK_FENCE = new MVClimbPane("chain_link_fence");
    public static final Block STEEL_TRAPDOOR = new MetalTrapdoor("steel_trapdoor");
    public static final Block STEEL_DOOR = new MVDoor("steel_door", MVBlockProperties.MetalDoor(2, 5.0F));

    // glass trapdoors
    public static final Block GLASS_TRAPDOOR = new GlassTrapdoor("glass_trapdoor", MaterialColor.NONE);
    public static final Block WHITE_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("white_stained_glass_trapdoor", MaterialColor.SNOW);
    public static final Block ORANGE_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("orange_stained_glass_trapdoor", MaterialColor.COLOR_ORANGE);
    public static final Block MAGENTA_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("magenta_stained_glass_trapdoor", MaterialColor.COLOR_MAGENTA);
    public static final Block LIGHT_BLUE_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("light_blue_stained_glass_trapdoor", MaterialColor.COLOR_LIGHT_BLUE);
    public static final Block YELLOW_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("yellow_stained_glass_trapdoor", MaterialColor.COLOR_YELLOW);
    public static final Block LIME_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("lime_stained_glass_trapdoor", MaterialColor.COLOR_LIGHT_GREEN);
    public static final Block PINK_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("pink_stained_glass_trapdoor", MaterialColor.COLOR_PINK);
    public static final Block GRAY_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("gray_stained_glass_trapdoor", MaterialColor.COLOR_GRAY);
    public static final Block LIGHT_GRAY_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("light_gray_stained_glass_trapdoor", MaterialColor.COLOR_LIGHT_GRAY);
    public static final Block CYAN_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("cyan_stained_glass_trapdoor", MaterialColor.COLOR_CYAN);
    public static final Block PURPLE_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("purple_stained_glass_trapdoor", MaterialColor.COLOR_PURPLE);
    public static final Block BLUE_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("blue_stained_glass_trapdoor", MaterialColor.COLOR_BLUE);
    public static final Block BROWN_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("brown_stained_glass_trapdoor", MaterialColor.COLOR_BROWN);
    public static final Block GREEN_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("green_stained_glass_trapdoor", MaterialColor.COLOR_GREEN);
    public static final Block RED_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("red_stained_glass_trapdoor", MaterialColor.COLOR_RED);
    public static final Block BLACK_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("black_stained_glass_trapdoor", MaterialColor.COLOR_BLACK);
    // glass doors
    public static final Block GLASS_DOOR = new MVDoor("glass_door", MVBlockProperties.GlassDoor(MaterialColor.NONE));
    public static final Block WHITE_STAINED_GLASS_DOOR = new MVDoor("white_stained_glass_door", MVBlockProperties.GlassDoor(MaterialColor.SNOW));
    public static final Block ORANGE_STAINED_GLASS_DOOR = new MVDoor("orange_stained_glass_door", MVBlockProperties.GlassDoor(MaterialColor.COLOR_ORANGE));
    public static final Block MAGENTA_STAINED_GLASS_DOOR = new MVDoor("magenta_stained_glass_door", MVBlockProperties.GlassDoor(MaterialColor.COLOR_MAGENTA));
    public static final Block LIGHT_BLUE_STAINED_GLASS_DOOR = new MVDoor("light_blue_stained_glass_door", MVBlockProperties.GlassDoor(MaterialColor.COLOR_LIGHT_BLUE));
    public static final Block YELLOW_STAINED_GLASS_DOOR = new MVDoor("yellow_stained_glass_door", MVBlockProperties.GlassDoor(MaterialColor.COLOR_YELLOW));
    public static final Block LIME_STAINED_GLASS_DOOR = new MVDoor("lime_stained_glass_door", MVBlockProperties.GlassDoor(MaterialColor.COLOR_LIGHT_GREEN));
    public static final Block PINK_STAINED_GLASS_DOOR = new MVDoor("pink_stained_glass_door", MVBlockProperties.GlassDoor(MaterialColor.COLOR_PINK));
    public static final Block GRAY_STAINED_GLASS_DOOR = new MVDoor("gray_stained_glass_door", MVBlockProperties.GlassDoor(MaterialColor.COLOR_GRAY));
    public static final Block LIGHT_GRAY_STAINED_GLASS_DOOR = new MVDoor("light_gray_stained_glass_door", MVBlockProperties.GlassDoor(MaterialColor.COLOR_LIGHT_GRAY));
    public static final Block CYAN_STAINED_GLASS_DOOR = new MVDoor("cyan_stained_glass_door", MVBlockProperties.GlassDoor(MaterialColor.COLOR_CYAN));
    public static final Block PURPLE_STAINED_GLASS_DOOR = new MVDoor("purple_stained_glass_door", MVBlockProperties.GlassDoor(MaterialColor.COLOR_PURPLE));
    public static final Block BLUE_STAINED_GLASS_DOOR = new MVDoor("blue_stained_glass_door", MVBlockProperties.GlassDoor(MaterialColor.COLOR_BLUE));
    public static final Block BROWN_STAINED_GLASS_DOOR = new MVDoor("brown_stained_glass_door", MVBlockProperties.GlassDoor(MaterialColor.COLOR_BROWN));
    public static final Block GREEN_STAINED_GLASS_DOOR = new MVDoor("green_stained_glass_door", MVBlockProperties.GlassDoor(MaterialColor.COLOR_GREEN));
    public static final Block RED_STAINED_GLASS_DOOR = new MVDoor("red_stained_glass_door", MVBlockProperties.GlassDoor(MaterialColor.COLOR_RED));
    public static final Block BLACK_STAINED_GLASS_DOOR = new MVDoor("black_stained_glass_door", MVBlockProperties.GlassDoor(MaterialColor.COLOR_BLACK));

    //TODO: lightbulb? (wall, ceiling)
    public static final Block CEILING_LIGHT = new MVRotateableBlock("ceiling_light", MVBlockProperties.MetalLightBlock(15));
    // neon light tubes
    public static final Block NEON_LIGHT = new NeonLight("neon_light", MVBlockProperties.NeonLight(15));
    public static final Block BLACK_LIGHT = new NeonLight("black_light", MVBlockProperties.NeonLight(7));
    // end rods
    public static final Block WHITE_END_ROD = new Rod("white_end_rod", MVBlockProperties.EndRod());
    public static final Block ORANGE_END_ROD = new Rod("orange_end_rod", MVBlockProperties.EndRod());
    public static final Block MAGENTA_END_ROD = new Rod("magenta_end_rod", MVBlockProperties.EndRod());
    public static final Block LIGHT_BLUE_END_ROD = new Rod("light_blue_end_rod", MVBlockProperties.EndRod());
    public static final Block YELLOW_END_ROD = new Rod("yellow_end_rod", MVBlockProperties.EndRod());
    public static final Block LIME_END_ROD = new Rod("lime_end_rod", MVBlockProperties.EndRod());
    public static final Block PINK_END_ROD = new Rod("pink_end_rod", MVBlockProperties.EndRod());
    public static final Block GRAY_END_ROD = new Rod("gray_end_rod", MVBlockProperties.EndRod());
    public static final Block LIGHT_GRAY_END_ROD = new Rod("light_gray_end_rod", MVBlockProperties.EndRod());
    public static final Block CYAN_END_ROD = new Rod("cyan_end_rod", MVBlockProperties.EndRod());
    public static final Block PURPLE_END_ROD = new Rod("purple_end_rod", MVBlockProperties.EndRod());
    public static final Block BLUE_END_ROD = new Rod("blue_end_rod", MVBlockProperties.EndRod());
    public static final Block BROWN_END_ROD = new Rod("brown_end_rod", MVBlockProperties.EndRod());
    public static final Block GREEN_END_ROD = new Rod("green_end_rod", MVBlockProperties.EndRod());
    public static final Block RED_END_ROD = new Rod("red_end_rod", MVBlockProperties.EndRod());
    public static final Block BLACK_END_ROD = new Rod("black_end_rod", MVBlockProperties.EndRod());

    // metal plating
    public static final Block IRON_SIDING = new MVBlock("iron_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block STEEL_SIDING = new MVBlock("steel_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    // iron colours
    public static final Block WHITE_IRON_SIDING = new MVBlock("white_iron_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block ORANGE_IRON_SIDING = new MVBlock("orange_iron_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block MAGENTA_IRON_SIDING = new MVBlock("magenta_iron_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block LIGHT_BLUE_IRON_SIDING = new MVBlock("light_blue_iron_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block YELLOW_IRON_SIDING = new MVBlock("yellow_iron_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block LIME_IRON_SIDING = new MVBlock("lime_iron_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block PINK_IRON_SIDING = new MVBlock("pink_iron_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block GRAY_IRON_SIDING = new MVBlock("gray_iron_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block LIGHT_GRAY_IRON_SIDING = new MVBlock("light_gray_iron_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block CYAN_IRON_SIDING = new MVBlock("cyan_iron_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block PURPLE_IRON_SIDING = new MVBlock("purple_iron_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block BLUE_IRON_SIDING = new MVBlock("blue_iron_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block BROWN_IRON_SIDING = new MVBlock("brown_iron_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block GREEN_IRON_SIDING = new MVBlock("green_iron_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block RED_IRON_SIDING = new MVBlock("red_iron_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block BLACK_IRON_SIDING = new MVBlock("black_iron_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    // steel colours
    public static final Block WHITE_STEEL_SIDING = new MVBlock("white_steel_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block ORANGE_STEEL_SIDING = new MVBlock("orange_steel_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block MAGENTA_STEEL_SIDING = new MVBlock("magenta_steel_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block LIGHT_BLUE_STEEL_SIDING = new MVBlock("light_blue_steel_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block YELLOW_STEEL_SIDING = new MVBlock("yellow_steel_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block LIME_STEEL_SIDING = new MVBlock("lime_steel_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block PINK_STEEL_SIDING = new MVBlock("pink_steel_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block GRAY_STEEL_SIDING = new MVBlock("gray_steel_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block LIGHT_GRAY_STEEL_SIDING = new MVBlock("light_gray_steel_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block CYAN_STEEL_SIDING = new MVBlock("cyan_steel_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block PURPLE_STEEL_SIDING = new MVBlock("purple_steel_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block BLUE_STEEL_SIDING = new MVBlock("blue_steel_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block BROWN_STEEL_SIDING = new MVBlock("brown_steel_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block GREEN_STEEL_SIDING = new MVBlock("green_steel_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block RED_STEEL_SIDING = new MVBlock("red_steel_siding", MVBlockProperties.StandardNetheriteSoundMetal());
    public static final Block BLACK_STEEL_SIDING = new MVBlock("black_steel_siding", MVBlockProperties.StandardNetheriteSoundMetal());


    // cracked bricks, mossy bricks
    public static final Block CRACKED_BRICKS = new MVBlock("cracked_bricks", MVBlockProperties.StandardRock());
    public static final Block MOSSY_BRICKS = new MVBlock("mossy_bricks", MVBlockProperties.StandardRock());
    // slabs
    public static final Block CRACKED_BRICKS_SLAB = new MVSlab("cracked_bricks_slab", MVBlockProperties.StandardRock());
    public static final Block MOSSY_BRICKS_SLAB = new MVSlab("mossy_bricks_slab", MVBlockProperties.StandardRock());
    //stairs
    public static final Block CRACKED_BRICKS_STAIRS = new MVStairs("cracked_bricks_stairs", CRACKED_BRICKS.defaultBlockState(), CRACKED_BRICKS);
    public static final Block MOSSY_BRICKS_STAIRS = new MVStairs("mossy_bricks_stairs", MOSSY_BRICKS.defaultBlockState(), MOSSY_BRICKS);

    // cracked concrete
    public static final Block CRACKED_WHITE_CONCRETE = new MVBlock("cracked_white_concrete", MVBlockProperties.Concrete(MaterialColor.SNOW));
    public static final Block CRACKED_ORANGE_CONCRETE = new MVBlock("cracked_orange_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_ORANGE));
    public static final Block CRACKED_MAGENTA_CONCRETE = new MVBlock("cracked_magenta_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_MAGENTA));
    public static final Block CRACKED_LIGHT_BLUE_CONCRETE = new MVBlock("cracked_light_blue_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_BLUE));
    public static final Block CRACKED_YELLOW_CONCRETE = new MVBlock("cracked_yellow_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_YELLOW));
    public static final Block CRACKED_LIME_CONCRETE = new MVBlock("cracked_lime_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GREEN));
    public static final Block CRACKED_PINK_CONCRETE = new MVBlock("cracked_pink_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_PINK));
    public static final Block CRACKED_GRAY_CONCRETE = new MVBlock("cracked_gray_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_GRAY));
    public static final Block CRACKED_LIGHT_GRAY_CONCRETE = new MVBlock("cracked_light_gray_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GRAY));
    public static final Block CRACKED_CYAN_CONCRETE = new MVBlock("cracked_cyan_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_CYAN));
    public static final Block CRACKED_PURPLE_CONCRETE = new MVBlock("cracked_purple_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_PURPLE));
    public static final Block CRACKED_BLUE_CONCRETE = new MVBlock("cracked_blue_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_BLUE));
    public static final Block CRACKED_BROWN_CONCRETE = new MVBlock("cracked_brown_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_BROWN));
    public static final Block CRACKED_GREEN_CONCRETE = new MVBlock("cracked_green_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_GREEN));
    public static final Block CRACKED_RED_CONCRETE = new MVBlock("cracked_red_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_RED));
    public static final Block CRACKED_BLACK_CONCRETE = new MVBlock("cracked_black_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_BLACK));
    // worn concrete
    public static final Block WORN_WHITE_CONCRETE = new MVBlock("worn_white_concrete", MVBlockProperties.Concrete(MaterialColor.SNOW));
    public static final Block WORN_ORANGE_CONCRETE = new MVBlock("worn_orange_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_ORANGE));
    public static final Block WORN_MAGENTA_CONCRETE = new MVBlock("worn_magenta_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_MAGENTA));
    public static final Block WORN_LIGHT_BLUE_CONCRETE = new MVBlock("worn_light_blue_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_BLUE));
    public static final Block WORN_YELLOW_CONCRETE = new MVBlock("worn_yellow_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_YELLOW));
    public static final Block WORN_LIME_CONCRETE = new MVBlock("worn_lime_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GREEN));
    public static final Block WORN_PINK_CONCRETE = new MVBlock("worn_pink_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_PINK));
    public static final Block WORN_GRAY_CONCRETE = new MVBlock("worn_gray_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_GRAY));
    public static final Block WORN_LIGHT_GRAY_CONCRETE = new MVBlock("worn_light_gray_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GRAY));
    public static final Block WORN_CYAN_CONCRETE = new MVBlock("worn_cyan_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_CYAN));
    public static final Block WORN_PURPLE_CONCRETE = new MVBlock("worn_purple_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_PURPLE));
    public static final Block WORN_BLUE_CONCRETE = new MVBlock("worn_blue_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_BLUE));
    public static final Block WORN_BROWN_CONCRETE = new MVBlock("worn_brown_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_BROWN));
    public static final Block WORN_GREEN_CONCRETE = new MVBlock("worn_green_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_GREEN));
    public static final Block WORN_RED_CONCRETE = new MVBlock("worn_red_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_RED));
    public static final Block WORN_BLACK_CONCRETE = new MVBlock("worn_black_concrete", MVBlockProperties.Concrete(MaterialColor.COLOR_BLACK));
    // slabs
    public static final Block WORN_WHITE_CONCRETE_SLAB = new MVSlab("worn_white_concrete_slab", MVBlockProperties.Concrete(MaterialColor.SNOW));
    public static final Block WORN_ORANGE_CONCRETE_SLAB = new MVSlab("worn_orange_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_ORANGE));
    public static final Block WORN_MAGENTA_CONCRETE_SLAB = new MVSlab("worn_magenta_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_MAGENTA));
    public static final Block WORN_LIGHT_BLUE_CONCRETE_SLAB = new MVSlab("worn_light_blue_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_BLUE));
    public static final Block WORN_YELLOW_CONCRETE_SLAB = new MVSlab("worn_yellow_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_YELLOW));
    public static final Block WORN_LIME_CONCRETE_SLAB = new MVSlab("worn_lime_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GREEN));
    public static final Block WORN_PINK_CONCRETE_SLAB = new MVSlab("worn_pink_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_PINK));
    public static final Block WORN_GRAY_CONCRETE_SLAB = new MVSlab("worn_gray_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_GRAY));
    public static final Block WORN_LIGHT_GRAY_CONCRETE_SLAB = new MVSlab("worn_light_gray_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GRAY));
    public static final Block WORN_CYAN_CONCRETE_SLAB = new MVSlab("worn_cyan_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_CYAN));
    public static final Block WORN_PURPLE_CONCRETE_SLAB = new MVSlab("worn_purple_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_PURPLE));
    public static final Block WORN_BLUE_CONCRETE_SLAB = new MVSlab("worn_blue_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_BLUE));
    public static final Block WORN_BROWN_CONCRETE_SLAB = new MVSlab("worn_brown_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_BROWN));
    public static final Block WORN_GREEN_CONCRETE_SLAB = new MVSlab("worn_green_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_GREEN));
    public static final Block WORN_RED_CONCRETE_SLAB = new MVSlab("worn_red_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_RED));
    public static final Block WORN_BLACK_CONCRETE_SLAB = new MVSlab("worn_black_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_BLACK));
    public static final Block CRACKED_WHITE_CONCRETE_SLAB = new MVSlab("cracked_white_concrete_slab", MVBlockProperties.Concrete(MaterialColor.SNOW));
    public static final Block CRACKED_ORANGE_CONCRETE_SLAB = new MVSlab("cracked_orange_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_ORANGE));
    public static final Block CRACKED_MAGENTA_CONCRETE_SLAB = new MVSlab("cracked_magenta_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_MAGENTA));
    public static final Block CRACKED_LIGHT_BLUE_CONCRETE_SLAB = new MVSlab("cracked_light_blue_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_BLUE));
    public static final Block CRACKED_YELLOW_CONCRETE_SLAB = new MVSlab("cracked_yellow_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_YELLOW));
    public static final Block CRACKED_LIME_CONCRETE_SLAB = new MVSlab("cracked_lime_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GREEN));
    public static final Block CRACKED_PINK_CONCRETE_SLAB = new MVSlab("cracked_pink_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_PINK));
    public static final Block CRACKED_GRAY_CONCRETE_SLAB = new MVSlab("cracked_gray_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_GRAY));
    public static final Block CRACKED_LIGHT_GRAY_CONCRETE_SLAB = new MVSlab("cracked_light_gray_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GRAY));
    public static final Block CRACKED_CYAN_CONCRETE_SLAB = new MVSlab("cracked_cyan_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_CYAN));
    public static final Block CRACKED_PURPLE_CONCRETE_SLAB = new MVSlab("cracked_purple_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_PURPLE));
    public static final Block CRACKED_BLUE_CONCRETE_SLAB = new MVSlab("cracked_blue_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_BLUE));
    public static final Block CRACKED_BROWN_CONCRETE_SLAB = new MVSlab("cracked_brown_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_BROWN));
    public static final Block CRACKED_GREEN_CONCRETE_SLAB = new MVSlab("cracked_green_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_GREEN));
    public static final Block CRACKED_RED_CONCRETE_SLAB = new MVSlab("cracked_red_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_RED));
    public static final Block CRACKED_BLACK_CONCRETE_SLAB = new MVSlab("cracked_black_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_BLACK));
    // stairs
    public static final Block WORN_WHITE_CONCRETE_STAIRS = new MVStairs("worn_white_concrete_stairs", WORN_WHITE_CONCRETE.defaultBlockState(), WORN_WHITE_CONCRETE);
    public static final Block WORN_ORANGE_CONCRETE_STAIRS = new MVStairs("worn_orange_concrete_stairs", WORN_ORANGE_CONCRETE.defaultBlockState(), WORN_ORANGE_CONCRETE);
    public static final Block WORN_MAGENTA_CONCRETE_STAIRS = new MVStairs("worn_magenta_concrete_stairs", WORN_MAGENTA_CONCRETE.defaultBlockState(), WORN_MAGENTA_CONCRETE);
    public static final Block WORN_LIGHT_BLUE_CONCRETE_STAIRS = new MVStairs("worn_light_blue_concrete_stairs", WORN_LIGHT_BLUE_CONCRETE.defaultBlockState(), WORN_LIGHT_BLUE_CONCRETE);
    public static final Block WORN_YELLOW_CONCRETE_STAIRS = new MVStairs("worn_yellow_concrete_stairs", WORN_YELLOW_CONCRETE.defaultBlockState(), WORN_YELLOW_CONCRETE);
    public static final Block WORN_LIME_CONCRETE_STAIRS = new MVStairs("worn_lime_concrete_stairs", WORN_LIME_CONCRETE.defaultBlockState(), WORN_LIME_CONCRETE);
    public static final Block WORN_PINK_CONCRETE_STAIRS = new MVStairs("worn_pink_concrete_stairs", WORN_PINK_CONCRETE.defaultBlockState(), WORN_PINK_CONCRETE);
    public static final Block WORN_GRAY_CONCRETE_STAIRS = new MVStairs("worn_gray_concrete_stairs", WORN_GRAY_CONCRETE.defaultBlockState(), WORN_GRAY_CONCRETE);
    public static final Block WORN_LIGHT_GRAY_CONCRETE_STAIRS = new MVStairs("worn_light_gray_concrete_stairs", WORN_LIGHT_GRAY_CONCRETE.defaultBlockState(), WORN_LIGHT_GRAY_CONCRETE);
    public static final Block WORN_CYAN_CONCRETE_STAIRS = new MVStairs("worn_cyan_concrete_stairs", WORN_CYAN_CONCRETE.defaultBlockState(), WORN_CYAN_CONCRETE);
    public static final Block WORN_PURPLE_CONCRETE_STAIRS = new MVStairs("worn_purple_concrete_stairs", WORN_PURPLE_CONCRETE.defaultBlockState(), WORN_PURPLE_CONCRETE);
    public static final Block WORN_BLUE_CONCRETE_STAIRS = new MVStairs("worn_blue_concrete_stairs", WORN_BLUE_CONCRETE.defaultBlockState(), WORN_BLUE_CONCRETE);
    public static final Block WORN_BROWN_CONCRETE_STAIRS = new MVStairs("worn_brown_concrete_stairs", WORN_BROWN_CONCRETE.defaultBlockState(), WORN_BROWN_CONCRETE);
    public static final Block WORN_GREEN_CONCRETE_STAIRS = new MVStairs("worn_green_concrete_stairs", WORN_GREEN_CONCRETE.defaultBlockState(), WORN_GREEN_CONCRETE);
    public static final Block WORN_RED_CONCRETE_STAIRS = new MVStairs("worn_red_concrete_stairs", WORN_RED_CONCRETE.defaultBlockState(), WORN_RED_CONCRETE);
    public static final Block WORN_BLACK_CONCRETE_STAIRS = new MVStairs("worn_black_concrete_stairs", WORN_BLACK_CONCRETE.defaultBlockState(), WORN_BLACK_CONCRETE);
    public static final Block CRACKED_WHITE_CONCRETE_STAIRS = new MVStairs("cracked_white_concrete_stairs", CRACKED_WHITE_CONCRETE.defaultBlockState(), CRACKED_WHITE_CONCRETE);
    public static final Block CRACKED_ORANGE_CONCRETE_STAIRS = new MVStairs("cracked_orange_concrete_stairs", CRACKED_ORANGE_CONCRETE.defaultBlockState(), CRACKED_ORANGE_CONCRETE);
    public static final Block CRACKED_MAGENTA_CONCRETE_STAIRS = new MVStairs("cracked_magenta_concrete_stairs", CRACKED_MAGENTA_CONCRETE.defaultBlockState(), CRACKED_MAGENTA_CONCRETE);
    public static final Block CRACKED_LIGHT_BLUE_CONCRETE_STAIRS = new MVStairs("cracked_light_blue_concrete_stairs", CRACKED_LIGHT_BLUE_CONCRETE.defaultBlockState(), CRACKED_LIGHT_BLUE_CONCRETE);
    public static final Block CRACKED_YELLOW_CONCRETE_STAIRS = new MVStairs("cracked_yellow_concrete_stairs", CRACKED_YELLOW_CONCRETE.defaultBlockState(), CRACKED_YELLOW_CONCRETE);
    public static final Block CRACKED_LIME_CONCRETE_STAIRS = new MVStairs("cracked_lime_concrete_stairs", CRACKED_LIME_CONCRETE.defaultBlockState(), CRACKED_LIME_CONCRETE);
    public static final Block CRACKED_PINK_CONCRETE_STAIRS = new MVStairs("cracked_pink_concrete_stairs", CRACKED_PINK_CONCRETE.defaultBlockState(), CRACKED_PINK_CONCRETE);
    public static final Block CRACKED_GRAY_CONCRETE_STAIRS = new MVStairs("cracked_gray_concrete_stairs", CRACKED_GRAY_CONCRETE.defaultBlockState(), CRACKED_GRAY_CONCRETE);
    public static final Block CRACKED_LIGHT_GRAY_CONCRETE_STAIRS = new MVStairs("cracked_light_gray_concrete_stairs", CRACKED_LIGHT_GRAY_CONCRETE.defaultBlockState(), CRACKED_LIGHT_GRAY_CONCRETE);
    public static final Block CRACKED_CYAN_CONCRETE_STAIRS = new MVStairs("cracked_cyan_concrete_stairs", CRACKED_CYAN_CONCRETE.defaultBlockState(), CRACKED_CYAN_CONCRETE);
    public static final Block CRACKED_PURPLE_CONCRETE_STAIRS = new MVStairs("cracked_purple_concrete_stairs", CRACKED_PURPLE_CONCRETE.defaultBlockState(), CRACKED_PURPLE_CONCRETE);
    public static final Block CRACKED_BLUE_CONCRETE_STAIRS = new MVStairs("cracked_blue_concrete_stairs", CRACKED_BLUE_CONCRETE.defaultBlockState(), CRACKED_BLUE_CONCRETE);
    public static final Block CRACKED_BROWN_CONCRETE_STAIRS = new MVStairs("cracked_brown_concrete_stairs", CRACKED_BROWN_CONCRETE.defaultBlockState(), CRACKED_BROWN_CONCRETE);
    public static final Block CRACKED_GREEN_CONCRETE_STAIRS = new MVStairs("cracked_green_concrete_stairs", CRACKED_GREEN_CONCRETE.defaultBlockState(), CRACKED_GREEN_CONCRETE);
    public static final Block CRACKED_RED_CONCRETE_STAIRS = new MVStairs("cracked_red_concrete_stairs", CRACKED_RED_CONCRETE.defaultBlockState(), CRACKED_RED_CONCRETE);
    public static final Block CRACKED_BLACK_CONCRETE_STAIRS = new MVStairs("cracked_black_concrete_stairs", CRACKED_BLACK_CONCRETE.defaultBlockState(), CRACKED_BLACK_CONCRETE);

    // muddy sandstone
    public static final Block MUDDY_SANDSTONE = new MVBlock("muddy_sandstone", MVBlockProperties.StandardRock(0.8F, 0.8F));
    public static final Block CUT_MUDDY_SANDSTONE = new MVBlock("cut_muddy_sandstone", MVBlockProperties.StandardRock(0.8F, 0.8F));
    public static final Block SMOOTH_MUDDY_SANDSTONE = new MVBlock("smooth_muddy_sandstone", MVBlockProperties.StandardRock(0.8F, 0.8F));
    public static final Block MUDDY_SANDSTONE_STAIRS = new MVStairs("muddy_sandstone_stairs", MUDDY_SANDSTONE.defaultBlockState(), MUDDY_SANDSTONE);
    public static final Block MUDDY_SANDSTONE_SLAB = new MVSlab("muddy_sandstone_slab", MVBlockProperties.StandardRock(0.8F, 0.8F));
    public static final Block MUDDY_SANDSTONE_WALL = new MVWall("muddy_sandstone_wall", MUDDY_SANDSTONE);
    public static final Block CUT_MUDDY_SANDSTONE_SLAB = new MVSlab("cut_muddy_sandstone_slab", MVBlockProperties.StandardRock(0.8F, 0.8F));
    public static final Block SMOOTH_MUDDY_SANDSTONE_STAIRS = new MVStairs("smooth_muddy_sandstone_stairs", SMOOTH_MUDDY_SANDSTONE.defaultBlockState(), SMOOTH_MUDDY_SANDSTONE);
    public static final Block SMOOTH_MUDDY_SANDSTONE_SLAB = new MVSlab("smooth_muddy_sandstone_slab", MVBlockProperties.StandardRock(0.8F, 0.8F));

    // coloured bricks
    public static final Block WHITE_BRICKS = new MVBlock("white_bricks", MVBlockProperties.ColoredRock(MaterialColor.SNOW));
    public static final Block ORANGE_BRICKS = new MVBlock("orange_bricks", MVBlockProperties.ColoredRock(MaterialColor.COLOR_ORANGE));
    public static final Block MAGENTA_BRICKS = new MVBlock("magenta_bricks", MVBlockProperties.ColoredRock(MaterialColor.COLOR_MAGENTA));
    public static final Block LIGHT_BLUE_BRICKS = new MVBlock("light_blue_bricks", MVBlockProperties.ColoredRock(MaterialColor.COLOR_LIGHT_BLUE));
    public static final Block YELLOW_BRICKS = new MVBlock("yellow_bricks", MVBlockProperties.ColoredRock(MaterialColor.COLOR_YELLOW));
    public static final Block LIME_BRICKS = new MVBlock("lime_bricks", MVBlockProperties.ColoredRock(MaterialColor.COLOR_LIGHT_GREEN));
    public static final Block PINK_BRICKS = new MVBlock("pink_bricks", MVBlockProperties.ColoredRock(MaterialColor.COLOR_PINK));
    public static final Block GRAY_BRICKS = new MVBlock("gray_bricks", MVBlockProperties.ColoredRock(MaterialColor.COLOR_GRAY));
    public static final Block LIGHT_GRAY_BRICKS = new MVBlock("light_gray_bricks", MVBlockProperties.ColoredRock(MaterialColor.COLOR_LIGHT_GRAY));
    public static final Block CYAN_BRICKS = new MVBlock("cyan_bricks", MVBlockProperties.ColoredRock(MaterialColor.COLOR_CYAN));
    public static final Block PURPLE_BRICKS = new MVBlock("purple_bricks", MVBlockProperties.ColoredRock(MaterialColor.COLOR_PURPLE));
    public static final Block BLUE_BRICKS = new MVBlock("blue_bricks", MVBlockProperties.ColoredRock(MaterialColor.COLOR_BLUE));
    public static final Block BROWN_BRICKS = new MVBlock("brown_bricks", MVBlockProperties.ColoredRock(MaterialColor.COLOR_BROWN));
    public static final Block GREEN_BRICKS = new MVBlock("green_bricks", MVBlockProperties.ColoredRock(MaterialColor.COLOR_GREEN));
    public static final Block RED_BRICKS = new MVBlock("red_bricks", MVBlockProperties.ColoredRock(MaterialColor.COLOR_RED));
    public static final Block BLACK_BRICKS = new MVBlock("black_bricks", MVBlockProperties.ColoredRock(MaterialColor.COLOR_BLACK));
    // stairs
    public static final Block WHITE_BRICKS_STAIRS = new MVStairs("white_bricks_stairs", WHITE_BRICKS.defaultBlockState(), WHITE_BRICKS);
    public static final Block ORANGE_BRICKS_STAIRS = new MVStairs("orange_bricks_stairs", ORANGE_BRICKS.defaultBlockState(), ORANGE_BRICKS);
    public static final Block MAGENTA_BRICKS_STAIRS = new MVStairs("magenta_bricks_stairs", MAGENTA_BRICKS.defaultBlockState(), MAGENTA_BRICKS);
    public static final Block LIGHT_BLUE_BRICKS_STAIRS = new MVStairs("light_blue_bricks_stairs", LIGHT_BLUE_BRICKS.defaultBlockState(), LIGHT_BLUE_BRICKS);
    public static final Block YELLOW_BRICKS_STAIRS = new MVStairs("yellow_bricks_stairs", YELLOW_BRICKS.defaultBlockState(), YELLOW_BRICKS);
    public static final Block LIME_BRICKS_STAIRS = new MVStairs("lime_bricks_stairs", LIME_BRICKS.defaultBlockState(), LIME_BRICKS);
    public static final Block PINK_BRICKS_STAIRS = new MVStairs("pink_bricks_stairs", PINK_BRICKS.defaultBlockState(), PINK_BRICKS);
    public static final Block GRAY_BRICKS_STAIRS = new MVStairs("gray_bricks_stairs", GRAY_BRICKS.defaultBlockState(), GRAY_BRICKS);
    public static final Block LIGHT_GRAY_BRICKS_STAIRS = new MVStairs("light_gray_bricks_stairs", LIGHT_GRAY_BRICKS.defaultBlockState(), LIGHT_GRAY_BRICKS);
    public static final Block CYAN_BRICKS_STAIRS = new MVStairs("cyan_bricks_stairs", CYAN_BRICKS.defaultBlockState(), CYAN_BRICKS);
    public static final Block PURPLE_BRICKS_STAIRS = new MVStairs("purple_bricks_stairs", PURPLE_BRICKS.defaultBlockState(), PURPLE_BRICKS);
    public static final Block BLUE_BRICKS_STAIRS = new MVStairs("blue_bricks_stairs", BLUE_BRICKS.defaultBlockState(), BLUE_BRICKS);
    public static final Block BROWN_BRICKS_STAIRS = new MVStairs("brown_bricks_stairs", BROWN_BRICKS.defaultBlockState(), BROWN_BRICKS);
    public static final Block GREEN_BRICKS_STAIRS = new MVStairs("green_bricks_stairs", GREEN_BRICKS.defaultBlockState(), GREEN_BRICKS);
    public static final Block RED_BRICKS_STAIRS = new MVStairs("red_bricks_stairs", RED_BRICKS.defaultBlockState(), RED_BRICKS);
    public static final Block BLACK_BRICKS_STAIRS = new MVStairs("black_bricks_stairs", BLACK_BRICKS.defaultBlockState(), BLACK_BRICKS);
    // slabs
    public static final Block WHITE_BRICKS_SLAB = new MVSlab("white_bricks_slab", MVBlockProperties.ColoredRock(MaterialColor.SNOW));
    public static final Block ORANGE_BRICKS_SLAB = new MVSlab("orange_bricks_slab", MVBlockProperties.ColoredRock(MaterialColor.COLOR_ORANGE));
    public static final Block MAGENTA_BRICKS_SLAB = new MVSlab("magenta_bricks_slab", MVBlockProperties.ColoredRock(MaterialColor.COLOR_MAGENTA));
    public static final Block LIGHT_BLUE_BRICKS_SLAB = new MVSlab("light_blue_bricks_slab", MVBlockProperties.ColoredRock(MaterialColor.COLOR_LIGHT_BLUE));
    public static final Block YELLOW_BRICKS_SLAB = new MVSlab("yellow_bricks_slab", MVBlockProperties.ColoredRock(MaterialColor.COLOR_YELLOW));
    public static final Block LIME_BRICKS_SLAB = new MVSlab("lime_bricks_slab", MVBlockProperties.ColoredRock(MaterialColor.COLOR_LIGHT_GREEN));
    public static final Block PINK_BRICKS_SLAB = new MVSlab("pink_bricks_slab", MVBlockProperties.ColoredRock(MaterialColor.COLOR_PINK));
    public static final Block GRAY_BRICKS_SLAB = new MVSlab("gray_bricks_slab", MVBlockProperties.ColoredRock(MaterialColor.COLOR_GRAY));
    public static final Block LIGHT_GRAY_BRICKS_SLAB = new MVSlab("light_gray_bricks_slab", MVBlockProperties.ColoredRock(MaterialColor.COLOR_LIGHT_GRAY));
    public static final Block CYAN_BRICKS_SLAB = new MVSlab("cyan_bricks_slab", MVBlockProperties.ColoredRock(MaterialColor.COLOR_CYAN));
    public static final Block PURPLE_BRICKS_SLAB = new MVSlab("purple_bricks_slab", MVBlockProperties.ColoredRock(MaterialColor.COLOR_PURPLE));
    public static final Block BLUE_BRICKS_SLAB = new MVSlab("blue_bricks_slab", MVBlockProperties.ColoredRock(MaterialColor.COLOR_BLUE));
    public static final Block BROWN_BRICKS_SLAB = new MVSlab("brown_bricks_slab", MVBlockProperties.ColoredRock(MaterialColor.COLOR_BROWN));
    public static final Block GREEN_BRICKS_SLAB = new MVSlab("green_bricks_slab", MVBlockProperties.ColoredRock(MaterialColor.COLOR_GREEN));
    public static final Block RED_BRICKS_SLAB = new MVSlab("red_bricks_slab", MVBlockProperties.ColoredRock(MaterialColor.COLOR_RED));
    public static final Block BLACK_BRICKS_SLAB = new MVSlab("black_bricks_slab", MVBlockProperties.ColoredRock(MaterialColor.COLOR_BLACK));

    // terracotta bricks
    public static final Block TERRACOTTA_BRICKS = new MVBlock("terracotta_bricks", MVBlockProperties.Terracotta(MaterialColor.COLOR_ORANGE));
    public static final Block WHITE_TERRACOTTA_BRICKS = new MVBlock("white_terracotta_bricks", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_WHITE));
    public static final Block ORANGE_TERRACOTTA_BRICKS = new MVBlock("orange_terracotta_bricks", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_ORANGE));
    public static final Block MAGENTA_TERRACOTTA_BRICKS = new MVBlock("magenta_terracotta_bricks", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_MAGENTA));
    public static final Block LIGHT_BLUE_TERRACOTTA_BRICKS = new MVBlock("light_blue_terracotta_bricks", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_LIGHT_BLUE));
    public static final Block YELLOW_TERRACOTTA_BRICKS = new MVBlock("yellow_terracotta_bricks", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_YELLOW));
    public static final Block LIME_TERRACOTTA_BRICKS = new MVBlock("lime_terracotta_bricks", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_LIGHT_GREEN));
    public static final Block PINK_TERRACOTTA_BRICKS = new MVBlock("pink_terracotta_bricks", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_PINK));
    public static final Block GRAY_TERRACOTTA_BRICKS = new MVBlock("gray_terracotta_bricks", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_GRAY));
    public static final Block LIGHT_GRAY_TERRACOTTA_BRICKS = new MVBlock("light_gray_terracotta_bricks", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_LIGHT_GRAY));
    public static final Block CYAN_TERRACOTTA_BRICKS = new MVBlock("cyan_terracotta_bricks", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_CYAN));
    public static final Block PURPLE_TERRACOTTA_BRICKS = new MVBlock("purple_terracotta_bricks", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_PURPLE));
    public static final Block BLUE_TERRACOTTA_BRICKS = new MVBlock("blue_terracotta_bricks", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_BLUE));
    public static final Block BROWN_TERRACOTTA_BRICKS = new MVBlock("brown_terracotta_bricks", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_BROWN));
    public static final Block GREEN_TERRACOTTA_BRICKS = new MVBlock("green_terracotta_bricks", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_GREEN));
    public static final Block RED_TERRACOTTA_BRICKS = new MVBlock("red_terracotta_bricks", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_RED));
    public static final Block BLACK_TERRACOTTA_BRICKS = new MVBlock("black_terracotta_bricks", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_BLACK));
    // stairs
    public static final Block TERRACOTTA_BRICKS_STAIRS = new MVStairs("terracotta_bricks_stairs", TERRACOTTA_BRICKS.defaultBlockState(), TERRACOTTA_BRICKS);
    public static final Block WHITE_TERRACOTTA_BRICKS_STAIRS = new MVStairs("white_terracotta_bricks_stairs", WHITE_TERRACOTTA_BRICKS.defaultBlockState(), WHITE_TERRACOTTA_BRICKS);
    public static final Block ORANGE_TERRACOTTA_BRICKS_STAIRS = new MVStairs("orange_terracotta_bricks_stairs", ORANGE_TERRACOTTA_BRICKS.defaultBlockState(), ORANGE_TERRACOTTA_BRICKS);
    public static final Block MAGENTA_TERRACOTTA_BRICKS_STAIRS = new MVStairs("magenta_terracotta_bricks_stairs", MAGENTA_TERRACOTTA_BRICKS.defaultBlockState(), MAGENTA_TERRACOTTA_BRICKS);
    public static final Block LIGHT_BLUE_TERRACOTTA_BRICKS_STAIRS = new MVStairs("light_blue_terracotta_bricks_stairs", LIGHT_BLUE_TERRACOTTA_BRICKS.defaultBlockState(), LIGHT_BLUE_TERRACOTTA_BRICKS);
    public static final Block YELLOW_TERRACOTTA_BRICKS_STAIRS = new MVStairs("yellow_terracotta_bricks_stairs", YELLOW_TERRACOTTA_BRICKS.defaultBlockState(), YELLOW_TERRACOTTA_BRICKS);
    public static final Block LIME_TERRACOTTA_BRICKS_STAIRS = new MVStairs("lime_terracotta_bricks_stairs", LIME_TERRACOTTA_BRICKS.defaultBlockState(), LIME_TERRACOTTA_BRICKS);
    public static final Block PINK_TERRACOTTA_BRICKS_STAIRS = new MVStairs("pink_terracotta_bricks_stairs", PINK_TERRACOTTA_BRICKS.defaultBlockState(), PINK_TERRACOTTA_BRICKS);
    public static final Block GRAY_TERRACOTTA_BRICKS_STAIRS = new MVStairs("gray_terracotta_bricks_stairs", GRAY_TERRACOTTA_BRICKS.defaultBlockState(), GRAY_TERRACOTTA_BRICKS);
    public static final Block LIGHT_GRAY_TERRACOTTA_BRICKS_STAIRS = new MVStairs("light_gray_terracotta_bricks_stairs", LIGHT_GRAY_TERRACOTTA_BRICKS.defaultBlockState(), LIGHT_GRAY_TERRACOTTA_BRICKS);
    public static final Block CYAN_TERRACOTTA_BRICKS_STAIRS = new MVStairs("cyan_terracotta_bricks_stairs", CYAN_TERRACOTTA_BRICKS.defaultBlockState(), CYAN_TERRACOTTA_BRICKS);
    public static final Block PURPLE_TERRACOTTA_BRICKS_STAIRS = new MVStairs("purple_terracotta_bricks_stairs", PURPLE_TERRACOTTA_BRICKS.defaultBlockState(), PURPLE_TERRACOTTA_BRICKS);
    public static final Block BLUE_TERRACOTTA_BRICKS_STAIRS = new MVStairs("blue_terracotta_bricks_stairs", BLUE_TERRACOTTA_BRICKS.defaultBlockState(), BLUE_TERRACOTTA_BRICKS);
    public static final Block BROWN_TERRACOTTA_BRICKS_STAIRS = new MVStairs("brown_terracotta_bricks_stairs", BROWN_TERRACOTTA_BRICKS.defaultBlockState(), BROWN_TERRACOTTA_BRICKS);
    public static final Block GREEN_TERRACOTTA_BRICKS_STAIRS = new MVStairs("green_terracotta_bricks_stairs", GREEN_TERRACOTTA_BRICKS.defaultBlockState(), GREEN_TERRACOTTA_BRICKS);
    public static final Block RED_TERRACOTTA_BRICKS_STAIRS = new MVStairs("red_terracotta_bricks_stairs", RED_TERRACOTTA_BRICKS.defaultBlockState(), RED_TERRACOTTA_BRICKS);
    public static final Block BLACK_TERRACOTTA_BRICKS_STAIRS = new MVStairs("black_terracotta_bricks_stairs", BLACK_TERRACOTTA_BRICKS.defaultBlockState(), BLACK_TERRACOTTA_BRICKS);
    // slabs
    public static final Block TERRACOTTA_BRICKS_SLAB = new MVSlab("terracotta_bricks_slab", MVBlockProperties.Terracotta(MaterialColor.COLOR_ORANGE));
    public static final Block WHITE_TERRACOTTA_BRICKS_SLAB = new MVSlab("white_terracotta_bricks_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_WHITE));
    public static final Block ORANGE_TERRACOTTA_BRICKS_SLAB = new MVSlab("orange_terracotta_bricks_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_ORANGE));
    public static final Block MAGENTA_TERRACOTTA_BRICKS_SLAB = new MVSlab("magenta_terracotta_bricks_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_MAGENTA));
    public static final Block LIGHT_BLUE_TERRACOTTA_BRICKS_SLAB = new MVSlab("light_blue_terracotta_bricks_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_LIGHT_BLUE));
    public static final Block YELLOW_TERRACOTTA_BRICKS_SLAB = new MVSlab("yellow_terracotta_bricks_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_YELLOW));
    public static final Block LIME_TERRACOTTA_BRICKS_SLAB = new MVSlab("lime_terracotta_bricks_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_LIGHT_GREEN));
    public static final Block PINK_TERRACOTTA_BRICKS_SLAB = new MVSlab("pink_terracotta_bricks_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_PINK));
    public static final Block GRAY_TERRACOTTA_BRICKS_SLAB = new MVSlab("gray_terracotta_bricks_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_GRAY));
    public static final Block LIGHT_GRAY_TERRACOTTA_BRICKS_SLAB = new MVSlab("light_gray_terracotta_bricks_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_LIGHT_GRAY));
    public static final Block CYAN_TERRACOTTA_BRICKS_SLAB = new MVSlab("cyan_terracotta_bricks_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_CYAN));
    public static final Block PURPLE_TERRACOTTA_BRICKS_SLAB = new MVSlab("purple_terracotta_bricks_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_PURPLE));
    public static final Block BLUE_TERRACOTTA_BRICKS_SLAB = new MVSlab("blue_terracotta_bricks_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_BLUE));
    public static final Block BROWN_TERRACOTTA_BRICKS_SLAB = new MVSlab("brown_terracotta_bricks_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_BROWN));
    public static final Block GREEN_TERRACOTTA_BRICKS_SLAB = new MVSlab("green_terracotta_bricks_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_GREEN));
    public static final Block RED_TERRACOTTA_BRICKS_SLAB = new MVSlab("red_terracotta_bricks_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_RED));
    public static final Block BLACK_TERRACOTTA_BRICKS_SLAB = new MVSlab("black_terracotta_bricks_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_BLACK));

    // vanilla additions
    // polished walls
    public static final Block POLISHED_DIORITE_WALL = new MVWall("polished_diorite_wall", Blocks.POLISHED_DIORITE);
    public static final Block POLISHED_ANDESITE_WALL = new MVWall("polished_andesite_wall", Blocks.POLISHED_ANDESITE);
    public static final Block POLISHED_GRANITE_WALL = new MVWall("polished_granite_wall", Blocks.POLISHED_GRANITE);

    // terracotta
    // stairs
    public static final Block TERRACOTTA_STAIRS = new MVStairs("terracotta_stairs", net.minecraft.block.Blocks.TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.TERRACOTTA);
    public static final Block WHITE_TERRACOTTA_STAIRS = new MVStairs("white_terracotta_stairs", net.minecraft.block.Blocks.WHITE_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.WHITE_TERRACOTTA);
    public static final Block ORANGE_TERRACOTTA_STAIRS = new MVStairs("orange_terracotta_stairs", net.minecraft.block.Blocks.ORANGE_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.ORANGE_TERRACOTTA);
    public static final Block MAGENTA_TERRACOTTA_STAIRS = new MVStairs("magenta_terracotta_stairs", net.minecraft.block.Blocks.MAGENTA_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.MAGENTA_TERRACOTTA);
    public static final Block LIGHT_BLUE_TERRACOTTA_STAIRS = new MVStairs("light_blue_terracotta_stairs", net.minecraft.block.Blocks.LIGHT_BLUE_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.LIGHT_BLUE_TERRACOTTA);
    public static final Block YELLOW_TERRACOTTA_STAIRS = new MVStairs("yellow_terracotta_stairs", net.minecraft.block.Blocks.YELLOW_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.YELLOW_TERRACOTTA);
    public static final Block LIME_TERRACOTTA_STAIRS = new MVStairs("lime_terracotta_stairs", net.minecraft.block.Blocks.LIME_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.LIME_TERRACOTTA);
    public static final Block PINK_TERRACOTTA_STAIRS = new MVStairs("pink_terracotta_stairs", net.minecraft.block.Blocks.PINK_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.PINK_TERRACOTTA);
    public static final Block GRAY_TERRACOTTA_STAIRS = new MVStairs("gray_terracotta_stairs", net.minecraft.block.Blocks.GRAY_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.GRAY_TERRACOTTA);
    public static final Block LIGHT_GRAY_TERRACOTTA_STAIRS = new MVStairs("light_gray_terracotta_stairs", net.minecraft.block.Blocks.LIGHT_GRAY_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.LIGHT_GRAY_TERRACOTTA);
    public static final Block CYAN_TERRACOTTA_STAIRS = new MVStairs("cyan_terracotta_stairs", net.minecraft.block.Blocks.CYAN_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.CYAN_TERRACOTTA);
    public static final Block PURPLE_TERRACOTTA_STAIRS = new MVStairs("purple_terracotta_stairs", net.minecraft.block.Blocks.PURPLE_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.PURPLE_TERRACOTTA);
    public static final Block BLUE_TERRACOTTA_STAIRS = new MVStairs("blue_terracotta_stairs", net.minecraft.block.Blocks.BLUE_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.BLUE_TERRACOTTA);
    public static final Block BROWN_TERRACOTTA_STAIRS = new MVStairs("brown_terracotta_stairs", net.minecraft.block.Blocks.BROWN_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.BROWN_TERRACOTTA);
    public static final Block GREEN_TERRACOTTA_STAIRS = new MVStairs("green_terracotta_stairs", net.minecraft.block.Blocks.GREEN_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.GREEN_TERRACOTTA);
    public static final Block RED_TERRACOTTA_STAIRS = new MVStairs("red_terracotta_stairs", net.minecraft.block.Blocks.RED_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.RED_TERRACOTTA);
    public static final Block BLACK_TERRACOTTA_STAIRS = new MVStairs("black_terracotta_stairs", net.minecraft.block.Blocks.BLACK_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.BLACK_TERRACOTTA);
    // slabs
    public static final Block TERRACOTTA_SLAB = new MVSlab("terracotta_slab", MVBlockProperties.Terracotta(MaterialColor.COLOR_ORANGE));
    public static final Block WHITE_TERRACOTTA_SLAB = new MVSlab("white_terracotta_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_WHITE));
    public static final Block ORANGE_TERRACOTTA_SLAB = new MVSlab("orange_terracotta_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_ORANGE));
    public static final Block MAGENTA_TERRACOTTA_SLAB = new MVSlab("magenta_terracotta_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_MAGENTA));
    public static final Block LIGHT_BLUE_TERRACOTTA_SLAB = new MVSlab("light_blue_terracotta_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_LIGHT_BLUE));
    public static final Block YELLOW_TERRACOTTA_SLAB = new MVSlab("yellow_terracotta_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_YELLOW));
    public static final Block LIME_TERRACOTTA_SLAB = new MVSlab("lime_terracotta_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_LIGHT_GREEN));
    public static final Block PINK_TERRACOTTA_SLAB = new MVSlab("pink_terracotta_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_PINK));
    public static final Block GRAY_TERRACOTTA_SLAB = new MVSlab("gray_terracotta_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_GRAY));
    public static final Block LIGHT_GRAY_TERRACOTTA_SLAB = new MVSlab("light_gray_terracotta_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_LIGHT_GRAY));
    public static final Block CYAN_TERRACOTTA_SLAB = new MVSlab("cyan_terracotta_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_CYAN));
    public static final Block PURPLE_TERRACOTTA_SLAB = new MVSlab("purple_terracotta_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_PURPLE));
    public static final Block BLUE_TERRACOTTA_SLAB = new MVSlab("blue_terracotta_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_BLUE));
    public static final Block BROWN_TERRACOTTA_SLAB = new MVSlab("brown_terracotta_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_BROWN));
    public static final Block GREEN_TERRACOTTA_SLAB = new MVSlab("green_terracotta_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_GREEN));
    public static final Block RED_TERRACOTTA_SLAB = new MVSlab("red_terracotta_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_RED));
    public static final Block BLACK_TERRACOTTA_SLAB = new MVSlab("black_terracotta_slab", MVBlockProperties.Terracotta(MaterialColor.TERRACOTTA_BLACK));

    // concrete
    // stairs
    public static final Block WHITE_CONCRETE_STAIRS = new MVStairs("white_concrete_stairs", net.minecraft.block.Blocks.WHITE_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.WHITE_CONCRETE);
    public static final Block ORANGE_CONCRETE_STAIRS = new MVStairs("orange_concrete_stairs", net.minecraft.block.Blocks.ORANGE_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.ORANGE_CONCRETE);
    public static final Block MAGENTA_CONCRETE_STAIRS = new MVStairs("magenta_concrete_stairs", net.minecraft.block.Blocks.MAGENTA_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.MAGENTA_CONCRETE);
    public static final Block LIGHT_BLUE_CONCRETE_STAIRS = new MVStairs("light_blue_concrete_stairs", net.minecraft.block.Blocks.LIGHT_BLUE_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.LIGHT_BLUE_CONCRETE);
    public static final Block YELLOW_CONCRETE_STAIRS = new MVStairs("yellow_concrete_stairs", net.minecraft.block.Blocks.YELLOW_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.YELLOW_CONCRETE);
    public static final Block LIME_CONCRETE_STAIRS = new MVStairs("lime_concrete_stairs", net.minecraft.block.Blocks.LIME_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.LIME_CONCRETE);
    public static final Block PINK_CONCRETE_STAIRS = new MVStairs("pink_concrete_stairs", net.minecraft.block.Blocks.PINK_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.PINK_CONCRETE);
    public static final Block GRAY_CONCRETE_STAIRS = new MVStairs("gray_concrete_stairs", net.minecraft.block.Blocks.GRAY_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.GRAY_CONCRETE);
    public static final Block LIGHT_GRAY_CONCRETE_STAIRS = new MVStairs("light_gray_concrete_stairs", net.minecraft.block.Blocks.LIGHT_GRAY_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.LIGHT_GRAY_CONCRETE);
    public static final Block CYAN_CONCRETE_STAIRS = new MVStairs("cyan_concrete_stairs", net.minecraft.block.Blocks.CYAN_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.CYAN_CONCRETE);
    public static final Block PURPLE_CONCRETE_STAIRS = new MVStairs("purple_concrete_stairs", net.minecraft.block.Blocks.PURPLE_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.PURPLE_CONCRETE);
    public static final Block BLUE_CONCRETE_STAIRS = new MVStairs("blue_concrete_stairs", net.minecraft.block.Blocks.BLUE_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.BLUE_CONCRETE);
    public static final Block BROWN_CONCRETE_STAIRS = new MVStairs("brown_concrete_stairs", net.minecraft.block.Blocks.BROWN_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.BROWN_CONCRETE);
    public static final Block GREEN_CONCRETE_STAIRS = new MVStairs("green_concrete_stairs", net.minecraft.block.Blocks.GREEN_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.GREEN_CONCRETE);
    public static final Block RED_CONCRETE_STAIRS = new MVStairs("red_concrete_stairs", net.minecraft.block.Blocks.RED_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.RED_CONCRETE);
    public static final Block BLACK_CONCRETE_STAIRS = new MVStairs("black_concrete_stairs", net.minecraft.block.Blocks.BLACK_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.BLACK_CONCRETE);
    // slabs
    public static final Block WHITE_CONCRETE_SLAB = new MVSlab("white_concrete_slab", MVBlockProperties.Concrete(MaterialColor.SNOW));
    public static final Block ORANGE_CONCRETE_SLAB = new MVSlab("orange_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_ORANGE));
    public static final Block MAGENTA_CONCRETE_SLAB = new MVSlab("magenta_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_MAGENTA));
    public static final Block LIGHT_BLUE_CONCRETE_SLAB = new MVSlab("light_blue_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_BLUE));
    public static final Block YELLOW_CONCRETE_SLAB = new MVSlab("yellow_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_YELLOW));
    public static final Block LIME_CONCRETE_SLAB = new MVSlab("lime_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GREEN));
    public static final Block PINK_CONCRETE_SLAB = new MVSlab("pink_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_PINK));
    public static final Block GRAY_CONCRETE_SLAB = new MVSlab("gray_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_GRAY));
    public static final Block LIGHT_GRAY_CONCRETE_SLAB = new MVSlab("light_gray_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GRAY));
    public static final Block CYAN_CONCRETE_SLAB = new MVSlab("cyan_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_CYAN));
    public static final Block PURPLE_CONCRETE_SLAB = new MVSlab("purple_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_PURPLE));
    public static final Block BLUE_CONCRETE_SLAB = new MVSlab("blue_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_BLUE));
    public static final Block BROWN_CONCRETE_SLAB = new MVSlab("brown_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_BROWN));
    public static final Block GREEN_CONCRETE_SLAB = new MVSlab("green_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_GREEN));
    public static final Block RED_CONCRETE_SLAB = new MVSlab("red_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_RED));
    public static final Block BLACK_CONCRETE_SLAB = new MVSlab("black_concrete_slab", MVBlockProperties.Concrete(MaterialColor.COLOR_BLACK));

    // ignore class list
    private static final List<Class<?>> IGNORE_CLASS_LIST = Arrays.asList();

    // registry functions things
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> regBlocks) {
        try {
            for (Field f : MVBlocks.class.getDeclaredFields()) {
                Object obj = f.get(null);
                if (obj instanceof Block) {
                    regBlocks.getRegistry().register((Block) obj);
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        if (FMLEnvironment.dist == Dist.CLIENT) {
            RenderType cutout = RenderType.cutoutMipped();
            RenderTypeLookup.setRenderLayer(STEEL_TRAPDOOR, cutout);
            RenderTypeLookup.setRenderLayer(CHAIN_LINK_FENCE, cutout);
            RenderTypeLookup.setRenderLayer(BARBED_WIRE_ROLL, cutout);
            RenderTypeLookup.setRenderLayer(BARBED_WIRE_EDGING, cutout);
            RenderTypeLookup.setRenderLayer(STEEL_DOOR, cutout);
            RenderTypeLookup.setRenderLayer(IRON_FRAME, cutout);
            RenderTypeLookup.setRenderLayer(STEEL_FRAME, cutout);

            RenderType clear = RenderType.translucent();
            RenderTypeLookup.setRenderLayer(GLASS_TRAPDOOR, clear);
            RenderTypeLookup.setRenderLayer(WHITE_STAINED_GLASS_TRAPDOOR, clear);
            RenderTypeLookup.setRenderLayer(ORANGE_STAINED_GLASS_TRAPDOOR, clear);
            RenderTypeLookup.setRenderLayer(MAGENTA_STAINED_GLASS_TRAPDOOR, clear);
            RenderTypeLookup.setRenderLayer(LIGHT_BLUE_STAINED_GLASS_TRAPDOOR, clear);
            RenderTypeLookup.setRenderLayer(YELLOW_STAINED_GLASS_TRAPDOOR, clear);
            RenderTypeLookup.setRenderLayer(LIME_STAINED_GLASS_TRAPDOOR, clear);
            RenderTypeLookup.setRenderLayer(PINK_STAINED_GLASS_TRAPDOOR, clear);
            RenderTypeLookup.setRenderLayer(GRAY_STAINED_GLASS_TRAPDOOR, clear);
            RenderTypeLookup.setRenderLayer(LIGHT_GRAY_STAINED_GLASS_TRAPDOOR, clear);
            RenderTypeLookup.setRenderLayer(CYAN_STAINED_GLASS_TRAPDOOR, clear);
            RenderTypeLookup.setRenderLayer(PURPLE_STAINED_GLASS_TRAPDOOR, clear);
            RenderTypeLookup.setRenderLayer(BLUE_STAINED_GLASS_TRAPDOOR, clear);
            RenderTypeLookup.setRenderLayer(BROWN_STAINED_GLASS_TRAPDOOR, clear);
            RenderTypeLookup.setRenderLayer(GREEN_STAINED_GLASS_TRAPDOOR, clear);
            RenderTypeLookup.setRenderLayer(RED_STAINED_GLASS_TRAPDOOR, clear);
            RenderTypeLookup.setRenderLayer(BLACK_STAINED_GLASS_TRAPDOOR, clear);
            RenderTypeLookup.setRenderLayer(GLASS_DOOR, clear);
            RenderTypeLookup.setRenderLayer(WHITE_STAINED_GLASS_DOOR, clear);
            RenderTypeLookup.setRenderLayer(ORANGE_STAINED_GLASS_DOOR, clear);
            RenderTypeLookup.setRenderLayer(MAGENTA_STAINED_GLASS_DOOR, clear);
            RenderTypeLookup.setRenderLayer(LIGHT_BLUE_STAINED_GLASS_DOOR, clear);
            RenderTypeLookup.setRenderLayer(YELLOW_STAINED_GLASS_DOOR, clear);
            RenderTypeLookup.setRenderLayer(LIME_STAINED_GLASS_DOOR, clear);
            RenderTypeLookup.setRenderLayer(PINK_STAINED_GLASS_DOOR, clear);
            RenderTypeLookup.setRenderLayer(GRAY_STAINED_GLASS_DOOR, clear);
            RenderTypeLookup.setRenderLayer(LIGHT_GRAY_STAINED_GLASS_DOOR, clear);
            RenderTypeLookup.setRenderLayer(CYAN_STAINED_GLASS_DOOR, clear);
            RenderTypeLookup.setRenderLayer(PURPLE_STAINED_GLASS_DOOR, clear);
            RenderTypeLookup.setRenderLayer(BLUE_STAINED_GLASS_DOOR, clear);
            RenderTypeLookup.setRenderLayer(BROWN_STAINED_GLASS_DOOR, clear);
            RenderTypeLookup.setRenderLayer(GREEN_STAINED_GLASS_DOOR, clear);
            RenderTypeLookup.setRenderLayer(RED_STAINED_GLASS_DOOR, clear);
            RenderTypeLookup.setRenderLayer(BLACK_STAINED_GLASS_DOOR, clear);
        }
    }

    @SubscribeEvent
    public static void registerBlockItems(RegistryEvent.Register<Item> regBlockItems) {
        try {
            for (Field f : MVBlocks.class.getDeclaredFields()) {
                Object obj = f.get(null);
                if (obj instanceof SteelScaffolding) {
                    BlockItem blockItem = new SteelScaffoldingItem((Block) obj, new Item.Properties().tab(ModernVanilla.TAB));
                    blockItem.setRegistryName(((Block) obj).getRegistryName());
                    regBlockItems.getRegistry().register(blockItem);
                } else if (obj instanceof IronScaffolding) {
                    BlockItem blockItem = new IronScaffoldingItem((Block) obj, new Item.Properties().tab(ModernVanilla.TAB));
                    blockItem.setRegistryName(((Block) obj).getRegistryName());
                    regBlockItems.getRegistry().register(blockItem);
                } else if (obj instanceof CardboardBox) {
                    BlockItem blockItem = new IronScaffoldingItem((Block) obj, new Item.Properties().tab(ModernVanilla.TAB).stacksTo(1));
                    blockItem.setRegistryName(((Block) obj).getRegistryName());
                    regBlockItems.getRegistry().register(blockItem);
                } else if (obj instanceof Block && !IGNORE_CLASS_LIST.contains(obj.getClass())) {
                    BlockItem blockItem = new BlockItem((Block) obj, new Item.Properties().tab(ModernVanilla.TAB));
                    blockItem.setRegistryName(((Block) obj).getRegistryName());
                    regBlockItems.getRegistry().register(blockItem);
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
