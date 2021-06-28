package com.tzaranthony.citydecor.util;

import com.tzaranthony.citydecor.CityDecor;
import com.tzaranthony.citydecor.block.*;
import com.tzaranthony.citydecor.item.IronScaffoldingItem;
import com.tzaranthony.citydecor.item.SteelScaffoldingItem;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.MaterialColor;
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

@Mod.EventBusSubscriber(modid = CityDecor.MOD_ID, bus = Bus.MOD)
public class CDBlocks {
    // steel
    public static final Block STEEL_BLOCK = new CDBlock("steel_block", CDBlockProperties.StandardMetal(2, 6.0F, 8.0F));
    public static final Block STEEL_FRAME = new CDBlock("steel_frame", CDBlockProperties.NonFullMetal(2, 6.0F, 8.0F));
    public static final Block IRON_FRAME = new CDBlock("iron_frame", CDBlockProperties.NonFullMetal(1, 5.0F, 6.0F));

    //TODO: Cushion -- like a half slab of wool, but sittable, make it have a better texture please. Maybe a chair???


    // shipping
    public static final Block CARDBOARD_BOX = new CardboardBox("cardboard_box", CDBlockProperties.Cardboard(0.1F), false);
    public static final Block SHIPPING_PALLET = new CardboardBox("shipping_pallet", CDBlockProperties.Cardboard(1.5F), true);

    // reinforced concrete
    public static final Block REINFORCED_CONCRETE = new CDBlock("reinforced_concrete", CDBlockProperties.StandardRock(2.0F, 9.0F));
    public static final Block REINFORCED_CONCRETE_POWDER = new CDConcretePowder("reinforced_concrete_powder", REINFORCED_CONCRETE, MaterialColor.SNOW);
    public static final Block REINFORCED_CONCRETE_STAIRS = new CDStairs("reinforced_concrete_stairs", REINFORCED_CONCRETE.defaultBlockState(), REINFORCED_CONCRETE);
    public static final Block REINFORCED_CONCRETE_SLAB = new CDSlab("reinforced_concrete_slab", CDBlockProperties.StandardRock(2.0F, 9.0F));
    // worn and cracked
    public static final Block WORN_REINFORCED_CONCRETE = new CDBlock("worn_reinforced_concrete", CDBlockProperties.StandardRock(2.0F, 9.0F));
    public static final Block CRACKED_REINFORCED_CONCRETE = new CDBlock("cracked_reinforced_concrete", CDBlockProperties.StandardRock(2.0F, 9.0F));
    public static final Block WORN_REINFORCED_CONCRETE_SLAB = new CDSlab("worn_reinforced_concrete_slab", CDBlockProperties.StandardRock(2.0F, 9.0F));
    public static final Block CRACKED_REINFORCED_CONCRETE_SLAB = new CDSlab("cracked_reinforced_concrete_slab", CDBlockProperties.StandardRock(2.0F, 9.0F));
    public static final Block WORN_REINFORCED_CONCRETE_STAIRS = new CDStairs("worn_reinforced_concrete_stairs", WORN_REINFORCED_CONCRETE.defaultBlockState(), WORN_REINFORCED_CONCRETE);
    public static final Block CRACKED_REINFORCED_CONCRETE_STAIRS = new CDStairs("cracked_reinforced_concrete_stairs", CRACKED_REINFORCED_CONCRETE.defaultBlockState(), CRACKED_REINFORCED_CONCRETE);

    // peripherals -- grate, barbed wire, metal scaffolding, pipes?, Iron blinds, steel blinds
    public static final Block BARBED_WIRE_ROLL = new BarbedWire("barbed_wire_roll");
    public static final Block BARBED_WIRE_EDGING = new CDStairsDmg("barbed_wire_edging", BARBED_WIRE_ROLL.defaultBlockState(), BARBED_WIRE_ROLL);
    public static final Block IRON_SCAFFOLDING = new IronScaffolding("iron_scaffolding");
    public static final Block STEEL_SCAFFOLDING = new SteelScaffolding("steel_scaffolding");
    public static final Block STEEL_ROD = new Rod("steel_rod", CDBlockProperties.NonFullMetal(2, 5.0F, 6.0F));

    // metal fence, steel trap door, steel door
    public static final Block IRON_FENCE = new CDFence("iron_fence", Blocks.IRON_BLOCK);
    public static final Block STEEL_FENCE = new CDFence("steel_fence", STEEL_BLOCK);
    public static final Block CHAIN_LINK_FENCE = new CDClimbPane("chain_link_fence");
    public static final Block STEEL_TRAPDOOR = new MetalTrapdoor("steel_trapdoor");
    public static final Block STEEL_DOOR = new CDDoor("steel_door", CDBlockProperties.MetalDoor(2, 5.0F));

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
    public static final Block GLASS_DOOR = new CDDoor("glass_door", CDBlockProperties.GlassDoor(MaterialColor.NONE));
    public static final Block WHITE_STAINED_GLASS_DOOR = new CDDoor("white_stained_glass_door", CDBlockProperties.GlassDoor(MaterialColor.SNOW));
    public static final Block ORANGE_STAINED_GLASS_DOOR = new CDDoor("orange_stained_glass_door", CDBlockProperties.GlassDoor(MaterialColor.COLOR_ORANGE));
    public static final Block MAGENTA_STAINED_GLASS_DOOR = new CDDoor("magenta_stained_glass_door", CDBlockProperties.GlassDoor(MaterialColor.COLOR_MAGENTA));
    public static final Block LIGHT_BLUE_STAINED_GLASS_DOOR = new CDDoor("light_blue_stained_glass_door", CDBlockProperties.GlassDoor(MaterialColor.COLOR_LIGHT_BLUE));
    public static final Block YELLOW_STAINED_GLASS_DOOR = new CDDoor("yellow_stained_glass_door", CDBlockProperties.GlassDoor(MaterialColor.COLOR_YELLOW));
    public static final Block LIME_STAINED_GLASS_DOOR = new CDDoor("lime_stained_glass_door", CDBlockProperties.GlassDoor(MaterialColor.COLOR_LIGHT_GREEN));
    public static final Block PINK_STAINED_GLASS_DOOR = new CDDoor("pink_stained_glass_door", CDBlockProperties.GlassDoor(MaterialColor.COLOR_PINK));
    public static final Block GRAY_STAINED_GLASS_DOOR = new CDDoor("gray_stained_glass_door", CDBlockProperties.GlassDoor(MaterialColor.COLOR_GRAY));
    public static final Block LIGHT_GRAY_STAINED_GLASS_DOOR = new CDDoor("light_gray_stained_glass_door", CDBlockProperties.GlassDoor(MaterialColor.COLOR_LIGHT_GRAY));
    public static final Block CYAN_STAINED_GLASS_DOOR = new CDDoor("cyan_stained_glass_door", CDBlockProperties.GlassDoor(MaterialColor.COLOR_CYAN));
    public static final Block PURPLE_STAINED_GLASS_DOOR = new CDDoor("purple_stained_glass_door", CDBlockProperties.GlassDoor(MaterialColor.COLOR_PURPLE));
    public static final Block BLUE_STAINED_GLASS_DOOR = new CDDoor("blue_stained_glass_door", CDBlockProperties.GlassDoor(MaterialColor.COLOR_BLUE));
    public static final Block BROWN_STAINED_GLASS_DOOR = new CDDoor("brown_stained_glass_door", CDBlockProperties.GlassDoor(MaterialColor.COLOR_BROWN));
    public static final Block GREEN_STAINED_GLASS_DOOR = new CDDoor("green_stained_glass_door", CDBlockProperties.GlassDoor(MaterialColor.COLOR_GREEN));
    public static final Block RED_STAINED_GLASS_DOOR = new CDDoor("red_stained_glass_door", CDBlockProperties.GlassDoor(MaterialColor.COLOR_RED));
    public static final Block BLACK_STAINED_GLASS_DOOR = new CDDoor("black_stained_glass_door", CDBlockProperties.GlassDoor(MaterialColor.COLOR_BLACK));

    //TODO: lightbulb? (wall, ceiling)
    public static final Block CEILING_LIGHT = new CDRotateableBlock("ceiling_light", CDBlockProperties.MetalLightBlock(15));
    // neon light tubes
    public static final Block NEON_LIGHT = new NeonLight("neon_light", CDBlockProperties.NeonLight(15));
    public static final Block BLACK_LIGHT = new NeonLight("black_light", CDBlockProperties.NeonLight(7));
    // end rods
    public static final Block WHITE_END_ROD = new Rod("white_end_rod", CDBlockProperties.EndRod());
    public static final Block ORANGE_END_ROD = new Rod("orange_end_rod", CDBlockProperties.EndRod());
    public static final Block MAGENTA_END_ROD = new Rod("magenta_end_rod", CDBlockProperties.EndRod());
    public static final Block LIGHT_BLUE_END_ROD = new Rod("light_blue_end_rod", CDBlockProperties.EndRod());
    public static final Block YELLOW_END_ROD = new Rod("yellow_end_rod", CDBlockProperties.EndRod());
    public static final Block LIME_END_ROD = new Rod("lime_end_rod", CDBlockProperties.EndRod());
    public static final Block PINK_END_ROD = new Rod("pink_end_rod", CDBlockProperties.EndRod());
    public static final Block GRAY_END_ROD = new Rod("gray_end_rod", CDBlockProperties.EndRod());
    public static final Block LIGHT_GRAY_END_ROD = new Rod("light_gray_end_rod", CDBlockProperties.EndRod());
    public static final Block CYAN_END_ROD = new Rod("cyan_end_rod", CDBlockProperties.EndRod());
    public static final Block PURPLE_END_ROD = new Rod("purple_end_rod", CDBlockProperties.EndRod());
    public static final Block BLUE_END_ROD = new Rod("blue_end_rod", CDBlockProperties.EndRod());
    public static final Block BROWN_END_ROD = new Rod("brown_end_rod", CDBlockProperties.EndRod());
    public static final Block GREEN_END_ROD = new Rod("green_end_rod", CDBlockProperties.EndRod());
    public static final Block RED_END_ROD = new Rod("red_end_rod", CDBlockProperties.EndRod());
    public static final Block BLACK_END_ROD = new Rod("black_end_rod", CDBlockProperties.EndRod());

    // metal plating
    public static final Block IRON_SIDING = new CDBlock("iron_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block STEEL_SIDING = new CDBlock("steel_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    // iron colours
    public static final Block WHITE_IRON_SIDING = new CDBlock("white_iron_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block ORANGE_IRON_SIDING = new CDBlock("orange_iron_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block MAGENTA_IRON_SIDING = new CDBlock("magenta_iron_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block LIGHT_BLUE_IRON_SIDING = new CDBlock("light_blue_iron_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block YELLOW_IRON_SIDING = new CDBlock("yellow_iron_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block LIME_IRON_SIDING = new CDBlock("lime_iron_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block PINK_IRON_SIDING = new CDBlock("pink_iron_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block GRAY_IRON_SIDING = new CDBlock("gray_iron_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block LIGHT_GRAY_IRON_SIDING = new CDBlock("light_gray_iron_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block CYAN_IRON_SIDING = new CDBlock("cyan_iron_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block PURPLE_IRON_SIDING = new CDBlock("purple_iron_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block BLUE_IRON_SIDING = new CDBlock("blue_iron_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block BROWN_IRON_SIDING = new CDBlock("brown_iron_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block GREEN_IRON_SIDING = new CDBlock("green_iron_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block RED_IRON_SIDING = new CDBlock("red_iron_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block BLACK_IRON_SIDING = new CDBlock("black_iron_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    // steel colours
    public static final Block WHITE_STEEL_SIDING = new CDBlock("white_steel_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block ORANGE_STEEL_SIDING = new CDBlock("orange_steel_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block MAGENTA_STEEL_SIDING = new CDBlock("magenta_steel_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block LIGHT_BLUE_STEEL_SIDING = new CDBlock("light_blue_steel_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block YELLOW_STEEL_SIDING = new CDBlock("yellow_steel_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block LIME_STEEL_SIDING = new CDBlock("lime_steel_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block PINK_STEEL_SIDING = new CDBlock("pink_steel_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block GRAY_STEEL_SIDING = new CDBlock("gray_steel_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block LIGHT_GRAY_STEEL_SIDING = new CDBlock("light_gray_steel_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block CYAN_STEEL_SIDING = new CDBlock("cyan_steel_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block PURPLE_STEEL_SIDING = new CDBlock("purple_steel_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block BLUE_STEEL_SIDING = new CDBlock("blue_steel_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block BROWN_STEEL_SIDING = new CDBlock("brown_steel_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block GREEN_STEEL_SIDING = new CDBlock("green_steel_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block RED_STEEL_SIDING = new CDBlock("red_steel_siding", CDBlockProperties.StandardNetheriteSoundMetal());
    public static final Block BLACK_STEEL_SIDING = new CDBlock("black_steel_siding", CDBlockProperties.StandardNetheriteSoundMetal());


    // cracked bricks, mossy bricks
    public static final Block CRACKED_BRICKS = new CDBlock("cracked_bricks", CDBlockProperties.StandardRock());
    public static final Block MOSSY_BRICKS = new CDBlock("mossy_bricks", CDBlockProperties.StandardRock());
    // slabs
    public static final Block CRACKED_BRICKS_SLAB = new CDSlab("cracked_bricks_slab", CDBlockProperties.StandardRock());
    public static final Block MOSSY_BRICKS_SLAB = new CDSlab("mossy_bricks_slab", CDBlockProperties.StandardRock());
    //stairs
    public static final Block CRACKED_BRICKS_STAIRS = new CDStairs("cracked_bricks_stairs", CRACKED_BRICKS.defaultBlockState(), CRACKED_BRICKS);
    public static final Block MOSSY_BRICKS_STAIRS = new CDStairs("mossy_bricks_stairs", MOSSY_BRICKS.defaultBlockState(), MOSSY_BRICKS);

    // cracked concrete
    public static final Block CRACKED_WHITE_CONCRETE = new CDBlock("cracked_white_concrete", CDBlockProperties.Concrete(MaterialColor.SNOW));
    public static final Block CRACKED_ORANGE_CONCRETE = new CDBlock("cracked_orange_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_ORANGE));
    public static final Block CRACKED_MAGENTA_CONCRETE = new CDBlock("cracked_magenta_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_MAGENTA));
    public static final Block CRACKED_LIGHT_BLUE_CONCRETE = new CDBlock("cracked_light_blue_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_BLUE));
    public static final Block CRACKED_YELLOW_CONCRETE = new CDBlock("cracked_yellow_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_YELLOW));
    public static final Block CRACKED_LIME_CONCRETE = new CDBlock("cracked_lime_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GREEN));
    public static final Block CRACKED_PINK_CONCRETE = new CDBlock("cracked_pink_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_PINK));
    public static final Block CRACKED_GRAY_CONCRETE = new CDBlock("cracked_gray_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_GRAY));
    public static final Block CRACKED_LIGHT_GRAY_CONCRETE = new CDBlock("cracked_light_gray_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GRAY));
    public static final Block CRACKED_CYAN_CONCRETE = new CDBlock("cracked_cyan_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_CYAN));
    public static final Block CRACKED_PURPLE_CONCRETE = new CDBlock("cracked_purple_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_PURPLE));
    public static final Block CRACKED_BLUE_CONCRETE = new CDBlock("cracked_blue_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_BLUE));
    public static final Block CRACKED_BROWN_CONCRETE = new CDBlock("cracked_brown_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_BROWN));
    public static final Block CRACKED_GREEN_CONCRETE = new CDBlock("cracked_green_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_GREEN));
    public static final Block CRACKED_RED_CONCRETE = new CDBlock("cracked_red_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_RED));
    public static final Block CRACKED_BLACK_CONCRETE = new CDBlock("cracked_black_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_BLACK));
    // worn concrete
    public static final Block WORN_WHITE_CONCRETE = new CDBlock("worn_white_concrete", CDBlockProperties.Concrete(MaterialColor.SNOW));
    public static final Block WORN_ORANGE_CONCRETE = new CDBlock("worn_orange_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_ORANGE));
    public static final Block WORN_MAGENTA_CONCRETE = new CDBlock("worn_magenta_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_MAGENTA));
    public static final Block WORN_LIGHT_BLUE_CONCRETE = new CDBlock("worn_light_blue_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_BLUE));
    public static final Block WORN_YELLOW_CONCRETE = new CDBlock("worn_yellow_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_YELLOW));
    public static final Block WORN_LIME_CONCRETE = new CDBlock("worn_lime_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GREEN));
    public static final Block WORN_PINK_CONCRETE = new CDBlock("worn_pink_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_PINK));
    public static final Block WORN_GRAY_CONCRETE = new CDBlock("worn_gray_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_GRAY));
    public static final Block WORN_LIGHT_GRAY_CONCRETE = new CDBlock("worn_light_gray_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GRAY));
    public static final Block WORN_CYAN_CONCRETE = new CDBlock("worn_cyan_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_CYAN));
    public static final Block WORN_PURPLE_CONCRETE = new CDBlock("worn_purple_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_PURPLE));
    public static final Block WORN_BLUE_CONCRETE = new CDBlock("worn_blue_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_BLUE));
    public static final Block WORN_BROWN_CONCRETE = new CDBlock("worn_brown_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_BROWN));
    public static final Block WORN_GREEN_CONCRETE = new CDBlock("worn_green_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_GREEN));
    public static final Block WORN_RED_CONCRETE = new CDBlock("worn_red_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_RED));
    public static final Block WORN_BLACK_CONCRETE = new CDBlock("worn_black_concrete", CDBlockProperties.Concrete(MaterialColor.COLOR_BLACK));
    // slabs
    public static final Block WORN_WHITE_CONCRETE_SLAB = new CDSlab("worn_white_concrete_slab", CDBlockProperties.Concrete(MaterialColor.SNOW));
    public static final Block WORN_ORANGE_CONCRETE_SLAB = new CDSlab("worn_orange_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_ORANGE));
    public static final Block WORN_MAGENTA_CONCRETE_SLAB = new CDSlab("worn_magenta_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_MAGENTA));
    public static final Block WORN_LIGHT_BLUE_CONCRETE_SLAB = new CDSlab("worn_light_blue_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_BLUE));
    public static final Block WORN_YELLOW_CONCRETE_SLAB = new CDSlab("worn_yellow_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_YELLOW));
    public static final Block WORN_LIME_CONCRETE_SLAB = new CDSlab("worn_lime_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GREEN));
    public static final Block WORN_PINK_CONCRETE_SLAB = new CDSlab("worn_pink_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_PINK));
    public static final Block WORN_GRAY_CONCRETE_SLAB = new CDSlab("worn_gray_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_GRAY));
    public static final Block WORN_LIGHT_GRAY_CONCRETE_SLAB = new CDSlab("worn_light_gray_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GRAY));
    public static final Block WORN_CYAN_CONCRETE_SLAB = new CDSlab("worn_cyan_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_CYAN));
    public static final Block WORN_PURPLE_CONCRETE_SLAB = new CDSlab("worn_purple_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_PURPLE));
    public static final Block WORN_BLUE_CONCRETE_SLAB = new CDSlab("worn_blue_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_BLUE));
    public static final Block WORN_BROWN_CONCRETE_SLAB = new CDSlab("worn_brown_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_BROWN));
    public static final Block WORN_GREEN_CONCRETE_SLAB = new CDSlab("worn_green_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_GREEN));
    public static final Block WORN_RED_CONCRETE_SLAB = new CDSlab("worn_red_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_RED));
    public static final Block WORN_BLACK_CONCRETE_SLAB = new CDSlab("worn_black_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_BLACK));
    public static final Block CRACKED_WHITE_CONCRETE_SLAB = new CDSlab("cracked_white_concrete_slab", CDBlockProperties.Concrete(MaterialColor.SNOW));
    public static final Block CRACKED_ORANGE_CONCRETE_SLAB = new CDSlab("cracked_orange_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_ORANGE));
    public static final Block CRACKED_MAGENTA_CONCRETE_SLAB = new CDSlab("cracked_magenta_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_MAGENTA));
    public static final Block CRACKED_LIGHT_BLUE_CONCRETE_SLAB = new CDSlab("cracked_light_blue_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_BLUE));
    public static final Block CRACKED_YELLOW_CONCRETE_SLAB = new CDSlab("cracked_yellow_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_YELLOW));
    public static final Block CRACKED_LIME_CONCRETE_SLAB = new CDSlab("cracked_lime_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GREEN));
    public static final Block CRACKED_PINK_CONCRETE_SLAB = new CDSlab("cracked_pink_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_PINK));
    public static final Block CRACKED_GRAY_CONCRETE_SLAB = new CDSlab("cracked_gray_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_GRAY));
    public static final Block CRACKED_LIGHT_GRAY_CONCRETE_SLAB = new CDSlab("cracked_light_gray_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GRAY));
    public static final Block CRACKED_CYAN_CONCRETE_SLAB = new CDSlab("cracked_cyan_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_CYAN));
    public static final Block CRACKED_PURPLE_CONCRETE_SLAB = new CDSlab("cracked_purple_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_PURPLE));
    public static final Block CRACKED_BLUE_CONCRETE_SLAB = new CDSlab("cracked_blue_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_BLUE));
    public static final Block CRACKED_BROWN_CONCRETE_SLAB = new CDSlab("cracked_brown_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_BROWN));
    public static final Block CRACKED_GREEN_CONCRETE_SLAB = new CDSlab("cracked_green_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_GREEN));
    public static final Block CRACKED_RED_CONCRETE_SLAB = new CDSlab("cracked_red_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_RED));
    public static final Block CRACKED_BLACK_CONCRETE_SLAB = new CDSlab("cracked_black_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_BLACK));
    // stairs
    public static final Block WORN_WHITE_CONCRETE_STAIRS = new CDStairs("worn_white_concrete_stairs", WORN_WHITE_CONCRETE.defaultBlockState(), WORN_WHITE_CONCRETE);
    public static final Block WORN_ORANGE_CONCRETE_STAIRS = new CDStairs("worn_orange_concrete_stairs", WORN_ORANGE_CONCRETE.defaultBlockState(), WORN_ORANGE_CONCRETE);
    public static final Block WORN_MAGENTA_CONCRETE_STAIRS = new CDStairs("worn_magenta_concrete_stairs", WORN_MAGENTA_CONCRETE.defaultBlockState(), WORN_MAGENTA_CONCRETE);
    public static final Block WORN_LIGHT_BLUE_CONCRETE_STAIRS = new CDStairs("worn_light_blue_concrete_stairs", WORN_LIGHT_BLUE_CONCRETE.defaultBlockState(), WORN_LIGHT_BLUE_CONCRETE);
    public static final Block WORN_YELLOW_CONCRETE_STAIRS = new CDStairs("worn_yellow_concrete_stairs", WORN_YELLOW_CONCRETE.defaultBlockState(), WORN_YELLOW_CONCRETE);
    public static final Block WORN_LIME_CONCRETE_STAIRS = new CDStairs("worn_lime_concrete_stairs", WORN_LIME_CONCRETE.defaultBlockState(), WORN_LIME_CONCRETE);
    public static final Block WORN_PINK_CONCRETE_STAIRS = new CDStairs("worn_pink_concrete_stairs", WORN_PINK_CONCRETE.defaultBlockState(), WORN_PINK_CONCRETE);
    public static final Block WORN_GRAY_CONCRETE_STAIRS = new CDStairs("worn_gray_concrete_stairs", WORN_GRAY_CONCRETE.defaultBlockState(), WORN_GRAY_CONCRETE);
    public static final Block WORN_LIGHT_GRAY_CONCRETE_STAIRS = new CDStairs("worn_light_gray_concrete_stairs", WORN_LIGHT_GRAY_CONCRETE.defaultBlockState(), WORN_LIGHT_GRAY_CONCRETE);
    public static final Block WORN_CYAN_CONCRETE_STAIRS = new CDStairs("worn_cyan_concrete_stairs", WORN_CYAN_CONCRETE.defaultBlockState(), WORN_CYAN_CONCRETE);
    public static final Block WORN_PURPLE_CONCRETE_STAIRS = new CDStairs("worn_purple_concrete_stairs", WORN_PURPLE_CONCRETE.defaultBlockState(), WORN_PURPLE_CONCRETE);
    public static final Block WORN_BLUE_CONCRETE_STAIRS = new CDStairs("worn_blue_concrete_stairs", WORN_BLUE_CONCRETE.defaultBlockState(), WORN_BLUE_CONCRETE);
    public static final Block WORN_BROWN_CONCRETE_STAIRS = new CDStairs("worn_brown_concrete_stairs", WORN_BROWN_CONCRETE.defaultBlockState(), WORN_BROWN_CONCRETE);
    public static final Block WORN_GREEN_CONCRETE_STAIRS = new CDStairs("worn_green_concrete_stairs", WORN_GREEN_CONCRETE.defaultBlockState(), WORN_GREEN_CONCRETE);
    public static final Block WORN_RED_CONCRETE_STAIRS = new CDStairs("worn_red_concrete_stairs", WORN_RED_CONCRETE.defaultBlockState(), WORN_RED_CONCRETE);
    public static final Block WORN_BLACK_CONCRETE_STAIRS = new CDStairs("worn_black_concrete_stairs", WORN_BLACK_CONCRETE.defaultBlockState(), WORN_BLACK_CONCRETE);
    public static final Block CRACKED_WHITE_CONCRETE_STAIRS = new CDStairs("cracked_white_concrete_stairs", CRACKED_WHITE_CONCRETE.defaultBlockState(), CRACKED_WHITE_CONCRETE);
    public static final Block CRACKED_ORANGE_CONCRETE_STAIRS = new CDStairs("cracked_orange_concrete_stairs", CRACKED_ORANGE_CONCRETE.defaultBlockState(), CRACKED_ORANGE_CONCRETE);
    public static final Block CRACKED_MAGENTA_CONCRETE_STAIRS = new CDStairs("cracked_magenta_concrete_stairs", CRACKED_MAGENTA_CONCRETE.defaultBlockState(), CRACKED_MAGENTA_CONCRETE);
    public static final Block CRACKED_LIGHT_BLUE_CONCRETE_STAIRS = new CDStairs("cracked_light_blue_concrete_stairs", CRACKED_LIGHT_BLUE_CONCRETE.defaultBlockState(), CRACKED_LIGHT_BLUE_CONCRETE);
    public static final Block CRACKED_YELLOW_CONCRETE_STAIRS = new CDStairs("cracked_yellow_concrete_stairs", CRACKED_YELLOW_CONCRETE.defaultBlockState(), CRACKED_YELLOW_CONCRETE);
    public static final Block CRACKED_LIME_CONCRETE_STAIRS = new CDStairs("cracked_lime_concrete_stairs", CRACKED_LIME_CONCRETE.defaultBlockState(), CRACKED_LIME_CONCRETE);
    public static final Block CRACKED_PINK_CONCRETE_STAIRS = new CDStairs("cracked_pink_concrete_stairs", CRACKED_PINK_CONCRETE.defaultBlockState(), CRACKED_PINK_CONCRETE);
    public static final Block CRACKED_GRAY_CONCRETE_STAIRS = new CDStairs("cracked_gray_concrete_stairs", CRACKED_GRAY_CONCRETE.defaultBlockState(), CRACKED_GRAY_CONCRETE);
    public static final Block CRACKED_LIGHT_GRAY_CONCRETE_STAIRS = new CDStairs("cracked_light_gray_concrete_stairs", CRACKED_LIGHT_GRAY_CONCRETE.defaultBlockState(), CRACKED_LIGHT_GRAY_CONCRETE);
    public static final Block CRACKED_CYAN_CONCRETE_STAIRS = new CDStairs("cracked_cyan_concrete_stairs", CRACKED_CYAN_CONCRETE.defaultBlockState(), CRACKED_CYAN_CONCRETE);
    public static final Block CRACKED_PURPLE_CONCRETE_STAIRS = new CDStairs("cracked_purple_concrete_stairs", CRACKED_PURPLE_CONCRETE.defaultBlockState(), CRACKED_PURPLE_CONCRETE);
    public static final Block CRACKED_BLUE_CONCRETE_STAIRS = new CDStairs("cracked_blue_concrete_stairs", CRACKED_BLUE_CONCRETE.defaultBlockState(), CRACKED_BLUE_CONCRETE);
    public static final Block CRACKED_BROWN_CONCRETE_STAIRS = new CDStairs("cracked_brown_concrete_stairs", CRACKED_BROWN_CONCRETE.defaultBlockState(), CRACKED_BROWN_CONCRETE);
    public static final Block CRACKED_GREEN_CONCRETE_STAIRS = new CDStairs("cracked_green_concrete_stairs", CRACKED_GREEN_CONCRETE.defaultBlockState(), CRACKED_GREEN_CONCRETE);
    public static final Block CRACKED_RED_CONCRETE_STAIRS = new CDStairs("cracked_red_concrete_stairs", CRACKED_RED_CONCRETE.defaultBlockState(), CRACKED_RED_CONCRETE);
    public static final Block CRACKED_BLACK_CONCRETE_STAIRS = new CDStairs("cracked_black_concrete_stairs", CRACKED_BLACK_CONCRETE.defaultBlockState(), CRACKED_BLACK_CONCRETE);

    // muddy sandstone
    public static final Block MUDDY_SANDSTONE = new CDBlock("muddy_sandstone", CDBlockProperties.StandardRock(0.8F, 0.8F));
    public static final Block CUT_MUDDY_SANDSTONE = new CDBlock("cut_muddy_sandstone", CDBlockProperties.StandardRock(0.8F, 0.8F));
    public static final Block SMOOTH_MUDDY_SANDSTONE = new CDBlock("smooth_muddy_sandstone", CDBlockProperties.StandardRock(0.8F, 0.8F));
    public static final Block MUDDY_SANDSTONE_STAIRS = new CDStairs("muddy_sandstone_stairs", MUDDY_SANDSTONE.defaultBlockState(), MUDDY_SANDSTONE);
    public static final Block MUDDY_SANDSTONE_SLAB = new CDSlab("muddy_sandstone_slab", CDBlockProperties.StandardRock(0.8F, 0.8F));
    public static final Block MUDDY_SANDSTONE_WALL = new CDWall("muddy_sandstone_wall", MUDDY_SANDSTONE);
    public static final Block CUT_MUDDY_SANDSTONE_SLAB = new CDSlab("cut_muddy_sandstone_slab", CDBlockProperties.StandardRock(0.8F, 0.8F));
    public static final Block SMOOTH_MUDDY_SANDSTONE_STAIRS = new CDStairs("smooth_muddy_sandstone_stairs", SMOOTH_MUDDY_SANDSTONE.defaultBlockState(), SMOOTH_MUDDY_SANDSTONE);
    public static final Block SMOOTH_MUDDY_SANDSTONE_SLAB = new CDSlab("smooth_muddy_sandstone_slab", CDBlockProperties.StandardRock(0.8F, 0.8F));

    // coloured bricks
    public static final Block WHITE_BRICKS = new CDBlock("white_bricks", CDBlockProperties.ColoredRock(MaterialColor.SNOW));
    public static final Block ORANGE_BRICKS = new CDBlock("orange_bricks", CDBlockProperties.ColoredRock(MaterialColor.COLOR_ORANGE));
    public static final Block MAGENTA_BRICKS = new CDBlock("magenta_bricks", CDBlockProperties.ColoredRock(MaterialColor.COLOR_MAGENTA));
    public static final Block LIGHT_BLUE_BRICKS = new CDBlock("light_blue_bricks", CDBlockProperties.ColoredRock(MaterialColor.COLOR_LIGHT_BLUE));
    public static final Block YELLOW_BRICKS = new CDBlock("yellow_bricks", CDBlockProperties.ColoredRock(MaterialColor.COLOR_YELLOW));
    public static final Block LIME_BRICKS = new CDBlock("lime_bricks", CDBlockProperties.ColoredRock(MaterialColor.COLOR_LIGHT_GREEN));
    public static final Block PINK_BRICKS = new CDBlock("pink_bricks", CDBlockProperties.ColoredRock(MaterialColor.COLOR_PINK));
    public static final Block GRAY_BRICKS = new CDBlock("gray_bricks", CDBlockProperties.ColoredRock(MaterialColor.COLOR_GRAY));
    public static final Block LIGHT_GRAY_BRICKS = new CDBlock("light_gray_bricks", CDBlockProperties.ColoredRock(MaterialColor.COLOR_LIGHT_GRAY));
    public static final Block CYAN_BRICKS = new CDBlock("cyan_bricks", CDBlockProperties.ColoredRock(MaterialColor.COLOR_CYAN));
    public static final Block PURPLE_BRICKS = new CDBlock("purple_bricks", CDBlockProperties.ColoredRock(MaterialColor.COLOR_PURPLE));
    public static final Block BLUE_BRICKS = new CDBlock("blue_bricks", CDBlockProperties.ColoredRock(MaterialColor.COLOR_BLUE));
    public static final Block BROWN_BRICKS = new CDBlock("brown_bricks", CDBlockProperties.ColoredRock(MaterialColor.COLOR_BROWN));
    public static final Block GREEN_BRICKS = new CDBlock("green_bricks", CDBlockProperties.ColoredRock(MaterialColor.COLOR_GREEN));
    public static final Block RED_BRICKS = new CDBlock("red_bricks", CDBlockProperties.ColoredRock(MaterialColor.COLOR_RED));
    public static final Block BLACK_BRICKS = new CDBlock("black_bricks", CDBlockProperties.ColoredRock(MaterialColor.COLOR_BLACK));
    // stairs
    public static final Block WHITE_BRICKS_STAIRS = new CDStairs("white_bricks_stairs", WHITE_BRICKS.defaultBlockState(), WHITE_BRICKS);
    public static final Block ORANGE_BRICKS_STAIRS = new CDStairs("orange_bricks_stairs", ORANGE_BRICKS.defaultBlockState(), ORANGE_BRICKS);
    public static final Block MAGENTA_BRICKS_STAIRS = new CDStairs("magenta_bricks_stairs", MAGENTA_BRICKS.defaultBlockState(), MAGENTA_BRICKS);
    public static final Block LIGHT_BLUE_BRICKS_STAIRS = new CDStairs("light_blue_bricks_stairs", LIGHT_BLUE_BRICKS.defaultBlockState(), LIGHT_BLUE_BRICKS);
    public static final Block YELLOW_BRICKS_STAIRS = new CDStairs("yellow_bricks_stairs", YELLOW_BRICKS.defaultBlockState(), YELLOW_BRICKS);
    public static final Block LIME_BRICKS_STAIRS = new CDStairs("lime_bricks_stairs", LIME_BRICKS.defaultBlockState(), LIME_BRICKS);
    public static final Block PINK_BRICKS_STAIRS = new CDStairs("pink_bricks_stairs", PINK_BRICKS.defaultBlockState(), PINK_BRICKS);
    public static final Block GRAY_BRICKS_STAIRS = new CDStairs("gray_bricks_stairs", GRAY_BRICKS.defaultBlockState(), GRAY_BRICKS);
    public static final Block LIGHT_GRAY_BRICKS_STAIRS = new CDStairs("light_gray_bricks_stairs", LIGHT_GRAY_BRICKS.defaultBlockState(), LIGHT_GRAY_BRICKS);
    public static final Block CYAN_BRICKS_STAIRS = new CDStairs("cyan_bricks_stairs", CYAN_BRICKS.defaultBlockState(), CYAN_BRICKS);
    public static final Block PURPLE_BRICKS_STAIRS = new CDStairs("purple_bricks_stairs", PURPLE_BRICKS.defaultBlockState(), PURPLE_BRICKS);
    public static final Block BLUE_BRICKS_STAIRS = new CDStairs("blue_bricks_stairs", BLUE_BRICKS.defaultBlockState(), BLUE_BRICKS);
    public static final Block BROWN_BRICKS_STAIRS = new CDStairs("brown_bricks_stairs", BROWN_BRICKS.defaultBlockState(), BROWN_BRICKS);
    public static final Block GREEN_BRICKS_STAIRS = new CDStairs("green_bricks_stairs", GREEN_BRICKS.defaultBlockState(), GREEN_BRICKS);
    public static final Block RED_BRICKS_STAIRS = new CDStairs("red_bricks_stairs", RED_BRICKS.defaultBlockState(), RED_BRICKS);
    public static final Block BLACK_BRICKS_STAIRS = new CDStairs("black_bricks_stairs", BLACK_BRICKS.defaultBlockState(), BLACK_BRICKS);
    // slabs
    public static final Block WHITE_BRICKS_SLAB = new CDSlab("white_bricks_slab", CDBlockProperties.ColoredRock(MaterialColor.SNOW));
    public static final Block ORANGE_BRICKS_SLAB = new CDSlab("orange_bricks_slab", CDBlockProperties.ColoredRock(MaterialColor.COLOR_ORANGE));
    public static final Block MAGENTA_BRICKS_SLAB = new CDSlab("magenta_bricks_slab", CDBlockProperties.ColoredRock(MaterialColor.COLOR_MAGENTA));
    public static final Block LIGHT_BLUE_BRICKS_SLAB = new CDSlab("light_blue_bricks_slab", CDBlockProperties.ColoredRock(MaterialColor.COLOR_LIGHT_BLUE));
    public static final Block YELLOW_BRICKS_SLAB = new CDSlab("yellow_bricks_slab", CDBlockProperties.ColoredRock(MaterialColor.COLOR_YELLOW));
    public static final Block LIME_BRICKS_SLAB = new CDSlab("lime_bricks_slab", CDBlockProperties.ColoredRock(MaterialColor.COLOR_LIGHT_GREEN));
    public static final Block PINK_BRICKS_SLAB = new CDSlab("pink_bricks_slab", CDBlockProperties.ColoredRock(MaterialColor.COLOR_PINK));
    public static final Block GRAY_BRICKS_SLAB = new CDSlab("gray_bricks_slab", CDBlockProperties.ColoredRock(MaterialColor.COLOR_GRAY));
    public static final Block LIGHT_GRAY_BRICKS_SLAB = new CDSlab("light_gray_bricks_slab", CDBlockProperties.ColoredRock(MaterialColor.COLOR_LIGHT_GRAY));
    public static final Block CYAN_BRICKS_SLAB = new CDSlab("cyan_bricks_slab", CDBlockProperties.ColoredRock(MaterialColor.COLOR_CYAN));
    public static final Block PURPLE_BRICKS_SLAB = new CDSlab("purple_bricks_slab", CDBlockProperties.ColoredRock(MaterialColor.COLOR_PURPLE));
    public static final Block BLUE_BRICKS_SLAB = new CDSlab("blue_bricks_slab", CDBlockProperties.ColoredRock(MaterialColor.COLOR_BLUE));
    public static final Block BROWN_BRICKS_SLAB = new CDSlab("brown_bricks_slab", CDBlockProperties.ColoredRock(MaterialColor.COLOR_BROWN));
    public static final Block GREEN_BRICKS_SLAB = new CDSlab("green_bricks_slab", CDBlockProperties.ColoredRock(MaterialColor.COLOR_GREEN));
    public static final Block RED_BRICKS_SLAB = new CDSlab("red_bricks_slab", CDBlockProperties.ColoredRock(MaterialColor.COLOR_RED));
    public static final Block BLACK_BRICKS_SLAB = new CDSlab("black_bricks_slab", CDBlockProperties.ColoredRock(MaterialColor.COLOR_BLACK));

    // terracotta bricks
    public static final Block TERRACOTTA_BRICKS = new CDBlock("terracotta_bricks", CDBlockProperties.Terracotta(MaterialColor.COLOR_ORANGE));
    public static final Block WHITE_TERRACOTTA_BRICKS = new CDBlock("white_terracotta_bricks", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_WHITE));
    public static final Block ORANGE_TERRACOTTA_BRICKS = new CDBlock("orange_terracotta_bricks", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_ORANGE));
    public static final Block MAGENTA_TERRACOTTA_BRICKS = new CDBlock("magenta_terracotta_bricks", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_MAGENTA));
    public static final Block LIGHT_BLUE_TERRACOTTA_BRICKS = new CDBlock("light_blue_terracotta_bricks", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_LIGHT_BLUE));
    public static final Block YELLOW_TERRACOTTA_BRICKS = new CDBlock("yellow_terracotta_bricks", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_YELLOW));
    public static final Block LIME_TERRACOTTA_BRICKS = new CDBlock("lime_terracotta_bricks", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_LIGHT_GREEN));
    public static final Block PINK_TERRACOTTA_BRICKS = new CDBlock("pink_terracotta_bricks", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_PINK));
    public static final Block GRAY_TERRACOTTA_BRICKS = new CDBlock("gray_terracotta_bricks", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_GRAY));
    public static final Block LIGHT_GRAY_TERRACOTTA_BRICKS = new CDBlock("light_gray_terracotta_bricks", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_LIGHT_GRAY));
    public static final Block CYAN_TERRACOTTA_BRICKS = new CDBlock("cyan_terracotta_bricks", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_CYAN));
    public static final Block PURPLE_TERRACOTTA_BRICKS = new CDBlock("purple_terracotta_bricks", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_PURPLE));
    public static final Block BLUE_TERRACOTTA_BRICKS = new CDBlock("blue_terracotta_bricks", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_BLUE));
    public static final Block BROWN_TERRACOTTA_BRICKS = new CDBlock("brown_terracotta_bricks", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_BROWN));
    public static final Block GREEN_TERRACOTTA_BRICKS = new CDBlock("green_terracotta_bricks", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_GREEN));
    public static final Block RED_TERRACOTTA_BRICKS = new CDBlock("red_terracotta_bricks", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_RED));
    public static final Block BLACK_TERRACOTTA_BRICKS = new CDBlock("black_terracotta_bricks", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_BLACK));
    // stairs
    public static final Block TERRACOTTA_BRICKS_STAIRS = new CDStairs("terracotta_bricks_stairs", TERRACOTTA_BRICKS.defaultBlockState(), TERRACOTTA_BRICKS);
    public static final Block WHITE_TERRACOTTA_BRICKS_STAIRS = new CDStairs("white_terracotta_bricks_stairs", WHITE_TERRACOTTA_BRICKS.defaultBlockState(), WHITE_TERRACOTTA_BRICKS);
    public static final Block ORANGE_TERRACOTTA_BRICKS_STAIRS = new CDStairs("orange_terracotta_bricks_stairs", ORANGE_TERRACOTTA_BRICKS.defaultBlockState(), ORANGE_TERRACOTTA_BRICKS);
    public static final Block MAGENTA_TERRACOTTA_BRICKS_STAIRS = new CDStairs("magenta_terracotta_bricks_stairs", MAGENTA_TERRACOTTA_BRICKS.defaultBlockState(), MAGENTA_TERRACOTTA_BRICKS);
    public static final Block LIGHT_BLUE_TERRACOTTA_BRICKS_STAIRS = new CDStairs("light_blue_terracotta_bricks_stairs", LIGHT_BLUE_TERRACOTTA_BRICKS.defaultBlockState(), LIGHT_BLUE_TERRACOTTA_BRICKS);
    public static final Block YELLOW_TERRACOTTA_BRICKS_STAIRS = new CDStairs("yellow_terracotta_bricks_stairs", YELLOW_TERRACOTTA_BRICKS.defaultBlockState(), YELLOW_TERRACOTTA_BRICKS);
    public static final Block LIME_TERRACOTTA_BRICKS_STAIRS = new CDStairs("lime_terracotta_bricks_stairs", LIME_TERRACOTTA_BRICKS.defaultBlockState(), LIME_TERRACOTTA_BRICKS);
    public static final Block PINK_TERRACOTTA_BRICKS_STAIRS = new CDStairs("pink_terracotta_bricks_stairs", PINK_TERRACOTTA_BRICKS.defaultBlockState(), PINK_TERRACOTTA_BRICKS);
    public static final Block GRAY_TERRACOTTA_BRICKS_STAIRS = new CDStairs("gray_terracotta_bricks_stairs", GRAY_TERRACOTTA_BRICKS.defaultBlockState(), GRAY_TERRACOTTA_BRICKS);
    public static final Block LIGHT_GRAY_TERRACOTTA_BRICKS_STAIRS = new CDStairs("light_gray_terracotta_bricks_stairs", LIGHT_GRAY_TERRACOTTA_BRICKS.defaultBlockState(), LIGHT_GRAY_TERRACOTTA_BRICKS);
    public static final Block CYAN_TERRACOTTA_BRICKS_STAIRS = new CDStairs("cyan_terracotta_bricks_stairs", CYAN_TERRACOTTA_BRICKS.defaultBlockState(), CYAN_TERRACOTTA_BRICKS);
    public static final Block PURPLE_TERRACOTTA_BRICKS_STAIRS = new CDStairs("purple_terracotta_bricks_stairs", PURPLE_TERRACOTTA_BRICKS.defaultBlockState(), PURPLE_TERRACOTTA_BRICKS);
    public static final Block BLUE_TERRACOTTA_BRICKS_STAIRS = new CDStairs("blue_terracotta_bricks_stairs", BLUE_TERRACOTTA_BRICKS.defaultBlockState(), BLUE_TERRACOTTA_BRICKS);
    public static final Block BROWN_TERRACOTTA_BRICKS_STAIRS = new CDStairs("brown_terracotta_bricks_stairs", BROWN_TERRACOTTA_BRICKS.defaultBlockState(), BROWN_TERRACOTTA_BRICKS);
    public static final Block GREEN_TERRACOTTA_BRICKS_STAIRS = new CDStairs("green_terracotta_bricks_stairs", GREEN_TERRACOTTA_BRICKS.defaultBlockState(), GREEN_TERRACOTTA_BRICKS);
    public static final Block RED_TERRACOTTA_BRICKS_STAIRS = new CDStairs("red_terracotta_bricks_stairs", RED_TERRACOTTA_BRICKS.defaultBlockState(), RED_TERRACOTTA_BRICKS);
    public static final Block BLACK_TERRACOTTA_BRICKS_STAIRS = new CDStairs("black_terracotta_bricks_stairs", BLACK_TERRACOTTA_BRICKS.defaultBlockState(), BLACK_TERRACOTTA_BRICKS);
    // slabs
    public static final Block TERRACOTTA_BRICKS_SLAB = new CDSlab("terracotta_bricks_slab", CDBlockProperties.Terracotta(MaterialColor.COLOR_ORANGE));
    public static final Block WHITE_TERRACOTTA_BRICKS_SLAB = new CDSlab("white_terracotta_bricks_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_WHITE));
    public static final Block ORANGE_TERRACOTTA_BRICKS_SLAB = new CDSlab("orange_terracotta_bricks_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_ORANGE));
    public static final Block MAGENTA_TERRACOTTA_BRICKS_SLAB = new CDSlab("magenta_terracotta_bricks_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_MAGENTA));
    public static final Block LIGHT_BLUE_TERRACOTTA_BRICKS_SLAB = new CDSlab("light_blue_terracotta_bricks_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_LIGHT_BLUE));
    public static final Block YELLOW_TERRACOTTA_BRICKS_SLAB = new CDSlab("yellow_terracotta_bricks_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_YELLOW));
    public static final Block LIME_TERRACOTTA_BRICKS_SLAB = new CDSlab("lime_terracotta_bricks_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_LIGHT_GREEN));
    public static final Block PINK_TERRACOTTA_BRICKS_SLAB = new CDSlab("pink_terracotta_bricks_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_PINK));
    public static final Block GRAY_TERRACOTTA_BRICKS_SLAB = new CDSlab("gray_terracotta_bricks_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_GRAY));
    public static final Block LIGHT_GRAY_TERRACOTTA_BRICKS_SLAB = new CDSlab("light_gray_terracotta_bricks_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_LIGHT_GRAY));
    public static final Block CYAN_TERRACOTTA_BRICKS_SLAB = new CDSlab("cyan_terracotta_bricks_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_CYAN));
    public static final Block PURPLE_TERRACOTTA_BRICKS_SLAB = new CDSlab("purple_terracotta_bricks_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_PURPLE));
    public static final Block BLUE_TERRACOTTA_BRICKS_SLAB = new CDSlab("blue_terracotta_bricks_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_BLUE));
    public static final Block BROWN_TERRACOTTA_BRICKS_SLAB = new CDSlab("brown_terracotta_bricks_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_BROWN));
    public static final Block GREEN_TERRACOTTA_BRICKS_SLAB = new CDSlab("green_terracotta_bricks_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_GREEN));
    public static final Block RED_TERRACOTTA_BRICKS_SLAB = new CDSlab("red_terracotta_bricks_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_RED));
    public static final Block BLACK_TERRACOTTA_BRICKS_SLAB = new CDSlab("black_terracotta_bricks_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_BLACK));

    // vanilla additions
    // polished walls
    public static final Block POLISHED_DIORITE_WALL = new CDWall("polished_diorite_wall", Blocks.POLISHED_DIORITE);
    public static final Block POLISHED_ANDESITE_WALL = new CDWall("polished_andesite_wall", Blocks.POLISHED_ANDESITE);
    public static final Block POLISHED_GRANITE_WALL = new CDWall("polished_granite_wall", Blocks.POLISHED_GRANITE);
    public static final Block OAK_WOOD_WALL = new CDWall("oak_wood_wall", Blocks.OAK_WOOD);
    public static final Block SPRUCE_WOOD_WALL = new CDWall("spruce_wood_wall", Blocks.SPRUCE_WOOD);
    public static final Block BIRCH_WOOD_WALL = new CDWall("birch_wood_wall", Blocks.BIRCH_WOOD);
    public static final Block DARK_OAK_WOOD_WALL = new CDWall("dark_oak_wood_wall", Blocks.DARK_OAK_WOOD);
    public static final Block ACACIA_WOOD_WALL = new CDWall("acacia_wood_wall", Blocks.ACACIA_WOOD);
    public static final Block JUNGLE_WOOD_WALL = new CDWall("jungle_wood_wall", Blocks.JUNGLE_WOOD);
    public static final Block WARPED_HYPHAE_WALL = new CDWall("warped_hyphae_wall", Blocks.WARPED_HYPHAE);
    public static final Block CRIMSON_HYPHAE_WALL = new CDWall("crimson_hyphae_wall", Blocks.CRIMSON_HYPHAE);

    // terracotta
    // stairs
    public static final Block TERRACOTTA_STAIRS = new CDStairs("terracotta_stairs", net.minecraft.block.Blocks.TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.TERRACOTTA);
    public static final Block WHITE_TERRACOTTA_STAIRS = new CDStairs("white_terracotta_stairs", net.minecraft.block.Blocks.WHITE_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.WHITE_TERRACOTTA);
    public static final Block ORANGE_TERRACOTTA_STAIRS = new CDStairs("orange_terracotta_stairs", net.minecraft.block.Blocks.ORANGE_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.ORANGE_TERRACOTTA);
    public static final Block MAGENTA_TERRACOTTA_STAIRS = new CDStairs("magenta_terracotta_stairs", net.minecraft.block.Blocks.MAGENTA_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.MAGENTA_TERRACOTTA);
    public static final Block LIGHT_BLUE_TERRACOTTA_STAIRS = new CDStairs("light_blue_terracotta_stairs", net.minecraft.block.Blocks.LIGHT_BLUE_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.LIGHT_BLUE_TERRACOTTA);
    public static final Block YELLOW_TERRACOTTA_STAIRS = new CDStairs("yellow_terracotta_stairs", net.minecraft.block.Blocks.YELLOW_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.YELLOW_TERRACOTTA);
    public static final Block LIME_TERRACOTTA_STAIRS = new CDStairs("lime_terracotta_stairs", net.minecraft.block.Blocks.LIME_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.LIME_TERRACOTTA);
    public static final Block PINK_TERRACOTTA_STAIRS = new CDStairs("pink_terracotta_stairs", net.minecraft.block.Blocks.PINK_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.PINK_TERRACOTTA);
    public static final Block GRAY_TERRACOTTA_STAIRS = new CDStairs("gray_terracotta_stairs", net.minecraft.block.Blocks.GRAY_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.GRAY_TERRACOTTA);
    public static final Block LIGHT_GRAY_TERRACOTTA_STAIRS = new CDStairs("light_gray_terracotta_stairs", net.minecraft.block.Blocks.LIGHT_GRAY_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.LIGHT_GRAY_TERRACOTTA);
    public static final Block CYAN_TERRACOTTA_STAIRS = new CDStairs("cyan_terracotta_stairs", net.minecraft.block.Blocks.CYAN_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.CYAN_TERRACOTTA);
    public static final Block PURPLE_TERRACOTTA_STAIRS = new CDStairs("purple_terracotta_stairs", net.minecraft.block.Blocks.PURPLE_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.PURPLE_TERRACOTTA);
    public static final Block BLUE_TERRACOTTA_STAIRS = new CDStairs("blue_terracotta_stairs", net.minecraft.block.Blocks.BLUE_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.BLUE_TERRACOTTA);
    public static final Block BROWN_TERRACOTTA_STAIRS = new CDStairs("brown_terracotta_stairs", net.minecraft.block.Blocks.BROWN_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.BROWN_TERRACOTTA);
    public static final Block GREEN_TERRACOTTA_STAIRS = new CDStairs("green_terracotta_stairs", net.minecraft.block.Blocks.GREEN_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.GREEN_TERRACOTTA);
    public static final Block RED_TERRACOTTA_STAIRS = new CDStairs("red_terracotta_stairs", net.minecraft.block.Blocks.RED_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.RED_TERRACOTTA);
    public static final Block BLACK_TERRACOTTA_STAIRS = new CDStairs("black_terracotta_stairs", net.minecraft.block.Blocks.BLACK_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.BLACK_TERRACOTTA);
    // slabs
    public static final Block TERRACOTTA_SLAB = new CDSlab("terracotta_slab", CDBlockProperties.Terracotta(MaterialColor.COLOR_ORANGE));
    public static final Block WHITE_TERRACOTTA_SLAB = new CDSlab("white_terracotta_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_WHITE));
    public static final Block ORANGE_TERRACOTTA_SLAB = new CDSlab("orange_terracotta_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_ORANGE));
    public static final Block MAGENTA_TERRACOTTA_SLAB = new CDSlab("magenta_terracotta_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_MAGENTA));
    public static final Block LIGHT_BLUE_TERRACOTTA_SLAB = new CDSlab("light_blue_terracotta_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_LIGHT_BLUE));
    public static final Block YELLOW_TERRACOTTA_SLAB = new CDSlab("yellow_terracotta_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_YELLOW));
    public static final Block LIME_TERRACOTTA_SLAB = new CDSlab("lime_terracotta_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_LIGHT_GREEN));
    public static final Block PINK_TERRACOTTA_SLAB = new CDSlab("pink_terracotta_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_PINK));
    public static final Block GRAY_TERRACOTTA_SLAB = new CDSlab("gray_terracotta_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_GRAY));
    public static final Block LIGHT_GRAY_TERRACOTTA_SLAB = new CDSlab("light_gray_terracotta_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_LIGHT_GRAY));
    public static final Block CYAN_TERRACOTTA_SLAB = new CDSlab("cyan_terracotta_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_CYAN));
    public static final Block PURPLE_TERRACOTTA_SLAB = new CDSlab("purple_terracotta_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_PURPLE));
    public static final Block BLUE_TERRACOTTA_SLAB = new CDSlab("blue_terracotta_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_BLUE));
    public static final Block BROWN_TERRACOTTA_SLAB = new CDSlab("brown_terracotta_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_BROWN));
    public static final Block GREEN_TERRACOTTA_SLAB = new CDSlab("green_terracotta_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_GREEN));
    public static final Block RED_TERRACOTTA_SLAB = new CDSlab("red_terracotta_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_RED));
    public static final Block BLACK_TERRACOTTA_SLAB = new CDSlab("black_terracotta_slab", CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_BLACK));

    // concrete
    // stairs
    public static final Block WHITE_CONCRETE_STAIRS = new CDStairs("white_concrete_stairs", net.minecraft.block.Blocks.WHITE_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.WHITE_CONCRETE);
    public static final Block ORANGE_CONCRETE_STAIRS = new CDStairs("orange_concrete_stairs", net.minecraft.block.Blocks.ORANGE_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.ORANGE_CONCRETE);
    public static final Block MAGENTA_CONCRETE_STAIRS = new CDStairs("magenta_concrete_stairs", net.minecraft.block.Blocks.MAGENTA_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.MAGENTA_CONCRETE);
    public static final Block LIGHT_BLUE_CONCRETE_STAIRS = new CDStairs("light_blue_concrete_stairs", net.minecraft.block.Blocks.LIGHT_BLUE_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.LIGHT_BLUE_CONCRETE);
    public static final Block YELLOW_CONCRETE_STAIRS = new CDStairs("yellow_concrete_stairs", net.minecraft.block.Blocks.YELLOW_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.YELLOW_CONCRETE);
    public static final Block LIME_CONCRETE_STAIRS = new CDStairs("lime_concrete_stairs", net.minecraft.block.Blocks.LIME_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.LIME_CONCRETE);
    public static final Block PINK_CONCRETE_STAIRS = new CDStairs("pink_concrete_stairs", net.minecraft.block.Blocks.PINK_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.PINK_CONCRETE);
    public static final Block GRAY_CONCRETE_STAIRS = new CDStairs("gray_concrete_stairs", net.minecraft.block.Blocks.GRAY_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.GRAY_CONCRETE);
    public static final Block LIGHT_GRAY_CONCRETE_STAIRS = new CDStairs("light_gray_concrete_stairs", net.minecraft.block.Blocks.LIGHT_GRAY_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.LIGHT_GRAY_CONCRETE);
    public static final Block CYAN_CONCRETE_STAIRS = new CDStairs("cyan_concrete_stairs", net.minecraft.block.Blocks.CYAN_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.CYAN_CONCRETE);
    public static final Block PURPLE_CONCRETE_STAIRS = new CDStairs("purple_concrete_stairs", net.minecraft.block.Blocks.PURPLE_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.PURPLE_CONCRETE);
    public static final Block BLUE_CONCRETE_STAIRS = new CDStairs("blue_concrete_stairs", net.minecraft.block.Blocks.BLUE_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.BLUE_CONCRETE);
    public static final Block BROWN_CONCRETE_STAIRS = new CDStairs("brown_concrete_stairs", net.minecraft.block.Blocks.BROWN_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.BROWN_CONCRETE);
    public static final Block GREEN_CONCRETE_STAIRS = new CDStairs("green_concrete_stairs", net.minecraft.block.Blocks.GREEN_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.GREEN_CONCRETE);
    public static final Block RED_CONCRETE_STAIRS = new CDStairs("red_concrete_stairs", net.minecraft.block.Blocks.RED_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.RED_CONCRETE);
    public static final Block BLACK_CONCRETE_STAIRS = new CDStairs("black_concrete_stairs", net.minecraft.block.Blocks.BLACK_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.BLACK_CONCRETE);
    // slabs
    public static final Block WHITE_CONCRETE_SLAB = new CDSlab("white_concrete_slab", CDBlockProperties.Concrete(MaterialColor.SNOW));
    public static final Block ORANGE_CONCRETE_SLAB = new CDSlab("orange_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_ORANGE));
    public static final Block MAGENTA_CONCRETE_SLAB = new CDSlab("magenta_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_MAGENTA));
    public static final Block LIGHT_BLUE_CONCRETE_SLAB = new CDSlab("light_blue_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_BLUE));
    public static final Block YELLOW_CONCRETE_SLAB = new CDSlab("yellow_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_YELLOW));
    public static final Block LIME_CONCRETE_SLAB = new CDSlab("lime_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GREEN));
    public static final Block PINK_CONCRETE_SLAB = new CDSlab("pink_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_PINK));
    public static final Block GRAY_CONCRETE_SLAB = new CDSlab("gray_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_GRAY));
    public static final Block LIGHT_GRAY_CONCRETE_SLAB = new CDSlab("light_gray_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GRAY));
    public static final Block CYAN_CONCRETE_SLAB = new CDSlab("cyan_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_CYAN));
    public static final Block PURPLE_CONCRETE_SLAB = new CDSlab("purple_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_PURPLE));
    public static final Block BLUE_CONCRETE_SLAB = new CDSlab("blue_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_BLUE));
    public static final Block BROWN_CONCRETE_SLAB = new CDSlab("brown_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_BROWN));
    public static final Block GREEN_CONCRETE_SLAB = new CDSlab("green_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_GREEN));
    public static final Block RED_CONCRETE_SLAB = new CDSlab("red_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_RED));
    public static final Block BLACK_CONCRETE_SLAB = new CDSlab("black_concrete_slab", CDBlockProperties.Concrete(MaterialColor.COLOR_BLACK));

    // ignore class list
    private static final List<Class<?>> IGNORE_CLASS_LIST = Arrays.asList();

    // registry functions things
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> regBlocks) {
        try {
            for (Field f : CDBlocks.class.getDeclaredFields()) {
                Object obj = f.get(null);
                if (obj instanceof Block) {
                    regBlocks.getRegistry().register((Block) obj);
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        if (FMLEnvironment.dist == Dist.CLIENT) {
            CDBlockRender.renderBlocks();
        }
    }

    @SubscribeEvent
    public static void registerBlockItems(RegistryEvent.Register<Item> regBlockItems) {
        try {
            for (Field f : CDBlocks.class.getDeclaredFields()) {
                Object obj = f.get(null);
                if (obj instanceof SteelScaffolding) {
                    BlockItem blockItem = new SteelScaffoldingItem((Block) obj, new Item.Properties().tab(CityDecor.TAB));
                    blockItem.setRegistryName(((Block) obj).getRegistryName());
                    regBlockItems.getRegistry().register(blockItem);
                } else if (obj instanceof IronScaffolding) {
                    BlockItem blockItem = new IronScaffoldingItem((Block) obj, new Item.Properties().tab(CityDecor.TAB));
                    blockItem.setRegistryName(((Block) obj).getRegistryName());
                    regBlockItems.getRegistry().register(blockItem);
                } else if (obj instanceof CardboardBox) {
                    BlockItem blockItem = new IronScaffoldingItem((Block) obj, new Item.Properties().tab(CityDecor.TAB).stacksTo(1));
                    blockItem.setRegistryName(((Block) obj).getRegistryName());
                    regBlockItems.getRegistry().register(blockItem);
                } else if (obj instanceof Block && !IGNORE_CLASS_LIST.contains(obj.getClass())) {
                    BlockItem blockItem = new BlockItem((Block) obj, new Item.Properties().tab(CityDecor.TAB));
                    blockItem.setRegistryName(((Block) obj).getRegistryName());
                    regBlockItems.getRegistry().register(blockItem);
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
