package com.tzaranthony.modernvanilla.util;

import com.tzaranthony.modernvanilla.ModernVanilla;
import com.tzaranthony.modernvanilla.block.*;
import com.tzaranthony.modernvanilla.item.IronScaffoldingItem;
import com.tzaranthony.modernvanilla.item.SteelScaffoldingItem;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeColor;
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
    public static final Block STEEL_BLOCK = new MetalBlock("steel_block", 3, 6.0F, 8.0F);
    public static final Block STEEL_FRAME = new MetalBlock("steel_frame", 3, 6.0F, 8.0F);
    public static final Block IRON_FRAME = new MetalBlock("iron_frame", 2, 5.0F, 6.0F);

    //TODO: Cushion -- like a half slab of wool, but sittable, make it have a better texture please. Maybe a chair???


    // new concrete
    public static final Block REINFORCED_CONCRETE = new MVRockBlock("reinforced_concrete", 2.0F, 9.0F);
    public static final Block REINFORCED_CONCRETE_POWDER = new MVConcretePowder(REINFORCED_CONCRETE, "reinforced_concrete_powder");
    public static final Block REINFORCED_CONCRETE_STAIRS = new MVAbsStairs("reinforced_concrete_stairs", REINFORCED_CONCRETE.defaultBlockState(), REINFORCED_CONCRETE);
    public static final Block REINFORCED_CONCRETE_SLAB = new MVAbsSlabD("reinforced_concrete_slab", Material.STONE, DyeColor.WHITE, 1.8F, 1.8F);

    // peripherals -- grate, barbed wire, metal scaffolding, pipes?, Iron blinds, steel blinds
    public static final Block BARBED_WIRE_ROLL = new BarbedWire("barbed_wire_roll");
    public static final Block BARBED_WIRE_EDGING = new MVAbsStairsDmg("barbed_wire_edging", BARBED_WIRE_ROLL.defaultBlockState(), BARBED_WIRE_ROLL);
    public static final Block IRON_SCAFFOLDING = new IronScaffolding("iron_scaffolding");
    public static final Block STEEL_SCAFFOLDING = new SteelScaffolding("steel_scaffolding");
    public static final Block STEEL_ROD = new Rod("steel_rod");

    // metal fence, steel trap door TODO: steel door
    public static final Block IRON_FENCE = new MVFence("iron_fence", Blocks.IRON_BLOCK);
    public static final Block STEEL_FENCE = new MVFence("steel_fence", STEEL_BLOCK);
    public static final Block CHAIN_LINK_FENCE = new MVClimbPane("chain_link_fence");
    public static final Block STEEL_TRAPDOOR = new MetalTrapdoor("steel_trapdoor");

    //TODO: glass door
    public static final Block WHITE_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("`white_stained_glass_trapdoor", DyeColor.WHITE);
    public static final Block ORANGE_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("`orange_stained_glass_trapdoor", DyeColor.ORANGE);
    public static final Block MAGENTA_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("`magenta_stained_glass_trapdoor", DyeColor.MAGENTA);
    public static final Block LIGHT_BLUE_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("`light_blue_stained_glass_trapdoor", DyeColor.LIGHT_BLUE);
    public static final Block YELLOW_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("`yellow_stained_glass_trapdoor", DyeColor.YELLOW);
    public static final Block LIME_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("`lime_stained_glass_trapdoor", DyeColor.LIME);
    public static final Block PINK_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("`pink_stained_glass_trapdoor", DyeColor.PINK);
    public static final Block GRAY_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("`gray_stained_glass_trapdoor", DyeColor.GRAY);
    public static final Block LIGHT_GRAY_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("`light_gray_stained_glass_trapdoor", DyeColor.LIGHT_GRAY);
    public static final Block CYAN_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("`cyan_stained_glass_trapdoor", DyeColor.CYAN);
    public static final Block PURPLE_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("`purple_stained_glass_trapdoor", DyeColor.PURPLE);
    public static final Block BLUE_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("`blue_stained_glass_trapdoor", DyeColor.BLUE);
    public static final Block BROWN_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("`brown_stained_glass_trapdoor", DyeColor.BROWN);
    public static final Block GREEN_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("`green_stained_glass_trapdoor", DyeColor.GREEN);
    public static final Block RED_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("`red_stained_glass_trapdoor", DyeColor.RED);
    public static final Block BLACK_STAINED_GLASS_TRAPDOOR = new GlassTrapdoor("`black_stained_glass_trapdoor", DyeColor.BLACK);

    //TODO: lightbulb? (wall, ceiling)
    public static final Block CEILING_LIGHT = new MVLightBlock("ceiling_light", 0.8F, 30);
    // neon light tubes
    public static final Block WHITE_NEON_LIGHT = new NeonLight("white_neon_light", 15);
    public static final Block ORANGE_NEON_LIGHT = new NeonLight("orange_neon_light", 15);
    public static final Block MAGENTA_NEON_LIGHT = new NeonLight("magenta_neon_light", 15);
    public static final Block LIGHT_BLUE_NEON_LIGHT = new NeonLight("light_blue_neon_light", 15);
    public static final Block YELLOW_NEON_LIGHT = new NeonLight("yellow_neon_light", 15);
    public static final Block LIME_NEON_LIGHT = new NeonLight("lime_neon_light", 15);
    public static final Block PINK_NEON_LIGHT = new NeonLight("pink_neon_light", 15);
    public static final Block GRAY_NEON_LIGHT = new NeonLight("gray_neon_light", 15);
    public static final Block LIGHT_GRAY_NEON_LIGHT = new NeonLight("light_gray_neon_light", 15);
    public static final Block CYAN_NEON_LIGHT = new NeonLight("cyan_neon_light", 15);
    public static final Block PURPLE_NEON_LIGHT = new NeonLight("purple_neon_light", 15);
    public static final Block BLUE_NEON_LIGHT = new NeonLight("blue_neon_light", 15);
    public static final Block BROWN_NEON_LIGHT = new NeonLight("brown_neon_light", 15);
    public static final Block GREEN_NEON_LIGHT = new NeonLight("green_neon_light", 15);
    public static final Block RED_NEON_LIGHT = new NeonLight("red_neon_light", 15);
    public static final Block BLACK_NEON_LIGHT = new NeonLight("black_neon_light", 15);

    // metal plating
    public static final Block IRON_SIDING = new SidingBlock("iron_siding");
    public static final Block STEEL_SIDING = new SidingBlock("steel_siding");
    // iron colours
    public static final Block WHITE_IRON_SIDING = new SidingBlock("white_iron_siding");
    public static final Block ORANGE_IRON_SIDING = new SidingBlock("orange_iron_siding");
    public static final Block MAGENTA_IRON_SIDING = new SidingBlock("magenta_iron_siding");
    public static final Block LIGHT_BLUE_IRON_SIDING = new SidingBlock("light_blue_iron_siding");
    public static final Block YELLOW_IRON_SIDING = new SidingBlock("yellow_iron_siding");
    public static final Block LIME_IRON_SIDING = new SidingBlock("lime_iron_siding");
    public static final Block PINK_IRON_SIDING = new SidingBlock("pink_iron_siding");
    public static final Block GRAY_IRON_SIDING = new SidingBlock("gray_iron_siding");
    public static final Block LIGHT_GRAY_IRON_SIDING = new SidingBlock("light_gray_iron_siding");
    public static final Block CYAN_IRON_SIDING = new SidingBlock("cyan_iron_siding");
    public static final Block PURPLE_IRON_SIDING = new SidingBlock("purple_iron_siding");
    public static final Block BLUE_IRON_SIDING = new SidingBlock("blue_iron_siding");
    public static final Block BROWN_IRON_SIDING = new SidingBlock("brown_iron_siding");
    public static final Block GREEN_IRON_SIDING = new SidingBlock("green_iron_siding");
    public static final Block RED_IRON_SIDING = new SidingBlock("red_iron_siding");
    public static final Block BLACK_IRON_SIDING = new SidingBlock("black_iron_siding");
    // steel colours
    public static final Block WHITE_STEEL_SIDING = new SidingBlock("white_steel_siding");
    public static final Block ORANGE_STEEL_SIDING = new SidingBlock("orange_steel_siding");
    public static final Block MAGENTA_STEEL_SIDING = new SidingBlock("magenta_steel_siding");
    public static final Block LIGHT_BLUE_STEEL_SIDING = new SidingBlock("light_blue_steel_siding");
    public static final Block YELLOW_STEEL_SIDING = new SidingBlock("yellow_steel_siding");
    public static final Block LIME_STEEL_SIDING = new SidingBlock("lime_steel_siding");
    public static final Block PINK_STEEL_SIDING = new SidingBlock("pink_steel_siding");
    public static final Block GRAY_STEEL_SIDING = new SidingBlock("gray_steel_siding");
    public static final Block LIGHT_GRAY_STEEL_SIDING = new SidingBlock("light_gray_steel_siding");
    public static final Block CYAN_STEEL_SIDING = new SidingBlock("cyan_steel_siding");
    public static final Block PURPLE_STEEL_SIDING = new SidingBlock("purple_steel_siding");
    public static final Block BLUE_STEEL_SIDING = new SidingBlock("blue_steel_siding");
    public static final Block BROWN_STEEL_SIDING = new SidingBlock("brown_steel_siding");
    public static final Block GREEN_STEEL_SIDING = new SidingBlock("green_steel_siding");
    public static final Block RED_STEEL_SIDING = new SidingBlock("red_steel_siding");
    public static final Block BLACK_STEEL_SIDING = new SidingBlock("black_steel_siding");


    //TODO: cracked bricks, mossy bricks
    public static final Block CRACKED_BRICKS = new MVRockBlock("cracked_bricks", 2.0F, 6.0F);
    public static final Block MOSSY_BRICKS = new MVRockBlock("mossy_bricks", 2.0F, 6.0F);

    //TODO: cracked concrete, worn concrete
    public static final Block CRACKED_CONCRETE = new MVRockBlock("cracked_concrete", 1.8F, 1.8F);
    public static final Block WORN_CONCRETE = new MVRockBlock("worn_concrete", 1.8F, 1.8F);

    // muddy sandstone
    public static final Block MUDDY_SANDSTONE = new MVRockBlock("muddy_sandstone", 0.8F, 0.8F);
    public static final Block CUT_MUDDY_SANDSTONE = new MVRockBlock("cut_muddy_sandstone", 0.8F, 0.8F);
    public static final Block SMOOTH_MUDDY_SANDSTONE = new MVRockBlock("smooth_muddy_sandstone", 0.8F, 0.8F);
    public static final Block MUDDY_SANDSTONE_STAIRS = new MVAbsStairs("muddy_sandstone_stairs", MUDDY_SANDSTONE.defaultBlockState(), MUDDY_SANDSTONE);
    public static final Block MUDDY_SANDSTONE_SLAB = new MVAbsSlab("muddy_sandstone_slab", Material.STONE, MaterialColor.WOOL, 0.8F, 0.8F);
    public static final Block MUDDY_SANDSTONE_WALL = new MVWall("muddy_sandstone_wall", MUDDY_SANDSTONE);
    public static final Block CUT_MUDDY_SANDSTONE_SLAB = new MVAbsSlab("cut_muddy_sandstone_slab", Material.STONE, MaterialColor.WOOL, 0.8F, 0.8F);
    public static final Block SMOOTH_MUDDY_SANDSTONE_STAIRS = new MVAbsStairs("smooth_muddy_sandstone_stairs", SMOOTH_MUDDY_SANDSTONE.defaultBlockState(), SMOOTH_MUDDY_SANDSTONE);
    public static final Block SMOOTH_MUDDY_SANDSTONE_SLAB = new MVAbsSlab("smooth_muddy_sandstone_slab", Material.STONE, MaterialColor.WOOL, 0.8F, 0.8F);

    // coloured bricks
    public static final Block WHITE_BRICKS = new MVRockBlock("white_bricks", 2.0F, 6.0F);
    public static final Block ORANGE_BRICKS = new MVRockBlock("orange_bricks", 2.0F, 6.0F);
    public static final Block MAGENTA_BRICKS = new MVRockBlock("magenta_bricks", 2.0F, 6.0F);
    public static final Block LIGHT_BLUE_BRICKS = new MVRockBlock("light_blue_bricks", 2.0F, 6.0F);
    public static final Block YELLOW_BRICKS = new MVRockBlock("yellow_bricks", 2.0F, 6.0F);
    public static final Block LIME_BRICKS = new MVRockBlock("lime_bricks", 2.0F, 6.0F);
    public static final Block PINK_BRICKS = new MVRockBlock("pink_bricks", 2.0F, 6.0F);
    public static final Block GRAY_BRICKS = new MVRockBlock("gray_bricks", 2.0F, 6.0F);
    public static final Block LIGHT_GRAY_BRICKS = new MVRockBlock("light_gray_bricks", 2.0F, 6.0F);
    public static final Block CYAN_BRICKS = new MVRockBlock("cyan_bricks", 2.0F, 6.0F);
    public static final Block PURPLE_BRICKS = new MVRockBlock("purple_bricks", 2.0F, 6.0F);
    public static final Block BLUE_BRICKS = new MVRockBlock("blue_bricks", 2.0F, 6.0F);
    public static final Block BROWN_BRICKS = new MVRockBlock("brown_bricks", 2.0F, 6.0F);
    public static final Block GREEN_BRICKS = new MVRockBlock("green_bricks", 2.0F, 6.0F);
    public static final Block RED_BRICKS = new MVRockBlock("red_bricks", 2.0F, 6.0F);
    public static final Block BLACK_BRICKS = new MVRockBlock("black_bricks", 2.0F, 6.0F);
    // stairs
    public static final Block WHITE_BRICKS_STAIRS = new MVAbsStairs("white_bricks_stairs", WHITE_BRICKS.defaultBlockState(), WHITE_BRICKS);
    public static final Block ORANGE_BRICKS_STAIRS = new MVAbsStairs("orange_bricks_stairs", ORANGE_BRICKS.defaultBlockState(), ORANGE_BRICKS);
    public static final Block MAGENTA_BRICKS_STAIRS = new MVAbsStairs("magenta_bricks_stairs", MAGENTA_BRICKS.defaultBlockState(), MAGENTA_BRICKS);
    public static final Block LIGHT_BLUE_BRICKS_STAIRS = new MVAbsStairs("light_blue_bricks_stairs", LIGHT_BLUE_BRICKS.defaultBlockState(), LIGHT_BLUE_BRICKS);
    public static final Block YELLOW_BRICKS_STAIRS = new MVAbsStairs("yellow_bricks_stairs", YELLOW_BRICKS.defaultBlockState(), YELLOW_BRICKS);
    public static final Block LIME_BRICKS_STAIRS = new MVAbsStairs("lime_bricks_stairs", LIME_BRICKS.defaultBlockState(), LIME_BRICKS);
    public static final Block PINK_BRICKS_STAIRS = new MVAbsStairs("pink_bricks_stairs", PINK_BRICKS.defaultBlockState(), PINK_BRICKS);
    public static final Block GRAY_BRICKS_STAIRS = new MVAbsStairs("gray_bricks_stairs", GRAY_BRICKS.defaultBlockState(), GRAY_BRICKS);
    public static final Block LIGHT_GRAY_BRICKS_STAIRS = new MVAbsStairs("light_gray_bricks_stairs", LIGHT_GRAY_BRICKS.defaultBlockState(), LIGHT_GRAY_BRICKS);
    public static final Block CYAN_BRICKS_STAIRS = new MVAbsStairs("cyan_bricks_stairs", CYAN_BRICKS.defaultBlockState(), CYAN_BRICKS);
    public static final Block PURPLE_BRICKS_STAIRS = new MVAbsStairs("purple_bricks_stairs", PURPLE_BRICKS.defaultBlockState(), PURPLE_BRICKS);
    public static final Block BLUE_BRICKS_STAIRS = new MVAbsStairs("blue_bricks_stairs", BLUE_BRICKS.defaultBlockState(), BLUE_BRICKS);
    public static final Block BROWN_BRICKS_STAIRS = new MVAbsStairs("brown_bricks_stairs", BROWN_BRICKS.defaultBlockState(), BROWN_BRICKS);
    public static final Block GREEN_BRICKS_STAIRS = new MVAbsStairs("green_bricks_stairs", GREEN_BRICKS.defaultBlockState(), GREEN_BRICKS);
    public static final Block RED_BRICKS_STAIRS = new MVAbsStairs("red_bricks_stairs", RED_BRICKS.defaultBlockState(), RED_BRICKS);
    public static final Block BLACK_BRICKS_STAIRS = new MVAbsStairs("black_bricks_stairs", BLACK_BRICKS.defaultBlockState(), BLACK_BRICKS);
    // slabs
    public static final Block WHITE_BRICKS_SLAB = new MVAbsSlab("white_bricks_slab", Material.STONE, MaterialColor.WOOL, 2.0F, 6.0F);
    public static final Block ORANGE_BRICKS_SLAB = new MVAbsSlab("orange_bricks_slab", Material.STONE, MaterialColor.COLOR_ORANGE, 2.0F, 6.0F);
    public static final Block MAGENTA_BRICKS_SLAB = new MVAbsSlab("magenta_bricks_slab", Material.STONE, MaterialColor.COLOR_MAGENTA, 2.0F, 6.0F);
    public static final Block LIGHT_BLUE_BRICKS_SLAB = new MVAbsSlab("light_blue_bricks_slab", Material.STONE, MaterialColor.COLOR_LIGHT_BLUE, 2.0F, 6.0F);
    public static final Block YELLOW_BRICKS_SLAB = new MVAbsSlab("yellow_bricks_slab", Material.STONE, MaterialColor.COLOR_YELLOW, 2.0F, 6.0F);
    public static final Block LIME_BRICKS_SLAB = new MVAbsSlab("lime_bricks_slab", Material.STONE, MaterialColor.COLOR_LIGHT_GREEN, 2.0F, 6.0F);
    public static final Block PINK_BRICKS_SLAB = new MVAbsSlab("pink_bricks_slab", Material.STONE, MaterialColor.COLOR_PINK, 2.0F, 6.0F);
    public static final Block GRAY_BRICKS_SLAB = new MVAbsSlab("gray_bricks_slab", Material.STONE, MaterialColor.COLOR_GRAY, 2.0F, 6.0F);
    public static final Block LIGHT_GRAY_BRICKS_SLAB = new MVAbsSlab("light_gray_bricks_slab", Material.STONE, MaterialColor.COLOR_LIGHT_GRAY, 2.0F, 6.0F);
    public static final Block CYAN_BRICKS_SLAB = new MVAbsSlab("cyan_bricks_slab", Material.STONE, MaterialColor.COLOR_CYAN, 2.0F, 6.0F);
    public static final Block PURPLE_BRICKS_SLAB = new MVAbsSlab("purple_bricks_slab", Material.STONE, MaterialColor.COLOR_PURPLE, 2.0F, 6.0F);
    public static final Block BLUE_BRICKS_SLAB = new MVAbsSlab("blue_bricks_slab", Material.STONE, MaterialColor.COLOR_BLUE, 2.0F, 6.0F);
    public static final Block BROWN_BRICKS_SLAB = new MVAbsSlab("brown_bricks_slab", Material.STONE, MaterialColor.COLOR_BROWN, 2.0F, 6.0F);
    public static final Block GREEN_BRICKS_SLAB = new MVAbsSlab("green_bricks_slab", Material.STONE, MaterialColor.COLOR_GREEN, 2.0F, 6.0F);
    public static final Block RED_BRICKS_SLAB = new MVAbsSlab("red_bricks_slab", Material.STONE, MaterialColor.COLOR_RED, 2.0F, 6.0F);
    public static final Block BLACK_BRICKS_SLAB = new MVAbsSlab("black_bricks_slab", Material.STONE, MaterialColor.COLOR_BLACK, 2.0F, 6.0F);

    // terracotta bricks
    public static final Block TERRACOTTA_BRICKS = new TerracottaBricks("terracotta_bricks", MaterialColor.COLOR_ORANGE);
    public static final Block WHITE_TERRACOTTA_BRICKS = new TerracottaBricks("white_terracotta_bricks", MaterialColor.TERRACOTTA_WHITE);
    public static final Block ORANGE_TERRACOTTA_BRICKS = new TerracottaBricks("orange_terracotta_bricks", MaterialColor.TERRACOTTA_ORANGE);
    public static final Block MAGENTA_TERRACOTTA_BRICKS = new TerracottaBricks("magenta_terracotta_bricks", MaterialColor.TERRACOTTA_MAGENTA);
    public static final Block LIGHT_BLUE_TERRACOTTA_BRICKS = new TerracottaBricks("light_blue_terracotta_bricks", MaterialColor.TERRACOTTA_LIGHT_BLUE);
    public static final Block YELLOW_TERRACOTTA_BRICKS = new TerracottaBricks("yellow_terracotta_bricks", MaterialColor.TERRACOTTA_YELLOW);
    public static final Block LIME_TERRACOTTA_BRICKS = new TerracottaBricks("lime_terracotta_bricks", MaterialColor.TERRACOTTA_LIGHT_GREEN);
    public static final Block PINK_TERRACOTTA_BRICKS = new TerracottaBricks("pink_terracotta_bricks", MaterialColor.TERRACOTTA_PINK);
    public static final Block GRAY_TERRACOTTA_BRICKS = new TerracottaBricks("gray_terracotta_bricks", MaterialColor.TERRACOTTA_GRAY);
    public static final Block LIGHT_GRAY_TERRACOTTA_BRICKS = new TerracottaBricks("light_gray_terracotta_bricks", MaterialColor.TERRACOTTA_LIGHT_GRAY);
    public static final Block CYAN_TERRACOTTA_BRICKS = new TerracottaBricks("cyan_terracotta_bricks", MaterialColor.TERRACOTTA_CYAN);
    public static final Block PURPLE_TERRACOTTA_BRICKS = new TerracottaBricks("purple_terracotta_bricks", MaterialColor.TERRACOTTA_PURPLE);
    public static final Block BLUE_TERRACOTTA_BRICKS = new TerracottaBricks("blue_terracotta_bricks", MaterialColor.TERRACOTTA_BLUE);
    public static final Block BROWN_TERRACOTTA_BRICKS = new TerracottaBricks("brown_terracotta_bricks", MaterialColor.TERRACOTTA_BROWN);
    public static final Block GREEN_TERRACOTTA_BRICKS = new TerracottaBricks("green_terracotta_bricks", MaterialColor.TERRACOTTA_GREEN);
    public static final Block RED_TERRACOTTA_BRICKS = new TerracottaBricks("red_terracotta_bricks", MaterialColor.TERRACOTTA_RED);
    public static final Block BLACK_TERRACOTTA_BRICKS = new TerracottaBricks("black_terracotta_bricks", MaterialColor.TERRACOTTA_BLACK);
    // stairs
    public static final Block TERRACOTTA_BRICKS_STAIRS = new MVAbsStairs("terracotta_bricks_stairs", TERRACOTTA_BRICKS.defaultBlockState(), TERRACOTTA_BRICKS);
    public static final Block WHITE_TERRACOTTA_BRICKS_STAIRS = new MVAbsStairs("white_terracotta_bricks_stairs", WHITE_TERRACOTTA_BRICKS.defaultBlockState(), WHITE_TERRACOTTA_BRICKS);
    public static final Block ORANGE_TERRACOTTA_BRICKS_STAIRS = new MVAbsStairs("orange_terracotta_bricks_stairs", ORANGE_TERRACOTTA_BRICKS.defaultBlockState(), ORANGE_TERRACOTTA_BRICKS);
    public static final Block MAGENTA_TERRACOTTA_BRICKS_STAIRS = new MVAbsStairs("magenta_terracotta_bricks_stairs", MAGENTA_TERRACOTTA_BRICKS.defaultBlockState(), MAGENTA_TERRACOTTA_BRICKS);
    public static final Block LIGHT_BLUE_TERRACOTTA_BRICKS_STAIRS = new MVAbsStairs("light_blue_terracotta_bricks_stairs", LIGHT_BLUE_TERRACOTTA_BRICKS.defaultBlockState(), LIGHT_BLUE_TERRACOTTA_BRICKS);
    public static final Block YELLOW_TERRACOTTA_BRICKS_STAIRS = new MVAbsStairs("yellow_terracotta_bricks_stairs", YELLOW_TERRACOTTA_BRICKS.defaultBlockState(), YELLOW_TERRACOTTA_BRICKS);
    public static final Block LIME_TERRACOTTA_BRICKS_STAIRS = new MVAbsStairs("lime_terracotta_bricks_stairs", LIME_TERRACOTTA_BRICKS.defaultBlockState(), LIME_TERRACOTTA_BRICKS);
    public static final Block PINK_TERRACOTTA_BRICKS_STAIRS = new MVAbsStairs("pink_terracotta_bricks_stairs", PINK_TERRACOTTA_BRICKS.defaultBlockState(), PINK_TERRACOTTA_BRICKS);
    public static final Block GRAY_TERRACOTTA_BRICKS_STAIRS = new MVAbsStairs("gray_terracotta_bricks_stairs", GRAY_TERRACOTTA_BRICKS.defaultBlockState(), GRAY_TERRACOTTA_BRICKS);
    public static final Block LIGHT_GRAY_TERRACOTTA_BRICKS_STAIRS = new MVAbsStairs("light_gray_terracotta_bricks_stairs", LIGHT_GRAY_TERRACOTTA_BRICKS.defaultBlockState(), LIGHT_GRAY_TERRACOTTA_BRICKS);
    public static final Block CYAN_TERRACOTTA_BRICKS_STAIRS = new MVAbsStairs("cyan_terracotta_bricks_stairs", CYAN_TERRACOTTA_BRICKS.defaultBlockState(), CYAN_TERRACOTTA_BRICKS);
    public static final Block PURPLE_TERRACOTTA_BRICKS_STAIRS = new MVAbsStairs("purple_terracotta_bricks_stairs", PURPLE_TERRACOTTA_BRICKS.defaultBlockState(), PURPLE_TERRACOTTA_BRICKS);
    public static final Block BLUE_TERRACOTTA_BRICKS_STAIRS = new MVAbsStairs("blue_terracotta_bricks_stairs", BLUE_TERRACOTTA_BRICKS.defaultBlockState(), BLUE_TERRACOTTA_BRICKS);
    public static final Block BROWN_TERRACOTTA_BRICKS_STAIRS = new MVAbsStairs("brown_terracotta_bricks_stairs", BROWN_TERRACOTTA_BRICKS.defaultBlockState(), BROWN_TERRACOTTA_BRICKS);
    public static final Block GREEN_TERRACOTTA_BRICKS_STAIRS = new MVAbsStairs("green_terracotta_bricks_stairs", GREEN_TERRACOTTA_BRICKS.defaultBlockState(), GREEN_TERRACOTTA_BRICKS);
    public static final Block RED_TERRACOTTA_BRICKS_STAIRS = new MVAbsStairs("red_terracotta_bricks_stairs", RED_TERRACOTTA_BRICKS.defaultBlockState(), RED_TERRACOTTA_BRICKS);
    public static final Block BLACK_TERRACOTTA_BRICKS_STAIRS = new MVAbsStairs("black_terracotta_bricks_stairs", BLACK_TERRACOTTA_BRICKS.defaultBlockState(), BLACK_TERRACOTTA_BRICKS);
    // slabs
    public static final Block TERRACOTTA_BRICKS_SLAB = new MVAbsSlabSound("terracotta_bricks_slab", Material.STONE, MaterialColor.COLOR_ORANGE, 1.25F, 4.2F);
    public static final Block WHITE_TERRACOTTA_BRICKS_SLAB = new MVAbsSlabSound("white_terracotta_bricks_slab", Material.STONE, MaterialColor.TERRACOTTA_WHITE, 1.25F, 4.2F);
    public static final Block ORANGE_TERRACOTTA_BRICKS_SLAB = new MVAbsSlabSound("orange_terracotta_bricks_slab", Material.STONE, MaterialColor.TERRACOTTA_ORANGE, 1.25F, 4.2F);
    public static final Block MAGENTA_TERRACOTTA_BRICKS_SLAB = new MVAbsSlabSound("magenta_terracotta_bricks_slab", Material.STONE, MaterialColor.TERRACOTTA_MAGENTA, 1.25F, 4.2F);
    public static final Block LIGHT_BLUE_TERRACOTTA_BRICKS_SLAB = new MVAbsSlabSound("light_blue_terracotta_bricks_slab", Material.STONE, MaterialColor.TERRACOTTA_LIGHT_BLUE, 1.25F, 4.2F);
    public static final Block YELLOW_TERRACOTTA_BRICKS_SLAB = new MVAbsSlabSound("yellow_terracotta_bricks_slab", Material.STONE, MaterialColor.TERRACOTTA_YELLOW, 1.25F, 4.2F);
    public static final Block LIME_TERRACOTTA_BRICKS_SLAB = new MVAbsSlabSound("lime_terracotta_bricks_slab", Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GREEN, 1.25F, 4.2F);
    public static final Block PINK_TERRACOTTA_BRICKS_SLAB = new MVAbsSlabSound("pink_terracotta_bricks_slab", Material.STONE, MaterialColor.TERRACOTTA_PINK, 1.25F, 4.2F);
    public static final Block GRAY_TERRACOTTA_BRICKS_SLAB = new MVAbsSlabSound("gray_terracotta_bricks_slab", Material.STONE, MaterialColor.TERRACOTTA_GRAY, 1.25F, 4.2F);
    public static final Block LIGHT_GRAY_TERRACOTTA_BRICKS_SLAB = new MVAbsSlabSound("light_gray_terracotta_bricks_slab", Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GRAY, 1.25F, 4.2F);
    public static final Block CYAN_TERRACOTTA_BRICKS_SLAB = new MVAbsSlabSound("cyan_terracotta_bricks_slab", Material.STONE, MaterialColor.TERRACOTTA_CYAN, 1.25F, 4.2F);
    public static final Block PURPLE_TERRACOTTA_BRICKS_SLAB = new MVAbsSlabSound("purple_terracotta_bricks_slab", Material.STONE, MaterialColor.TERRACOTTA_PURPLE, 1.25F, 4.2F);
    public static final Block BLUE_TERRACOTTA_BRICKS_SLAB = new MVAbsSlabSound("blue_terracotta_bricks_slab", Material.STONE, MaterialColor.TERRACOTTA_BLUE, 1.25F, 4.2F);
    public static final Block BROWN_TERRACOTTA_BRICKS_SLAB = new MVAbsSlabSound("brown_terracotta_bricks_slab", Material.STONE, MaterialColor.TERRACOTTA_BROWN, 1.25F, 4.2F);
    public static final Block GREEN_TERRACOTTA_BRICKS_SLAB = new MVAbsSlabSound("green_terracotta_bricks_slab", Material.STONE, MaterialColor.TERRACOTTA_GREEN, 1.25F, 4.2F);
    public static final Block RED_TERRACOTTA_BRICKS_SLAB = new MVAbsSlabSound("red_terracotta_bricks_slab", Material.STONE, MaterialColor.TERRACOTTA_RED, 1.25F, 4.2F);
    public static final Block BLACK_TERRACOTTA_BRICKS_SLAB = new MVAbsSlabSound("black_terracotta_bricks_slab", Material.STONE, MaterialColor.TERRACOTTA_BLACK, 1.25F, 4.2F);

    // vanilla additions
    // polished walls
    public static final Block POLISHED_DIORITE_WALL = new MVWall("polished_diorite_wall", Blocks.POLISHED_DIORITE);
    public static final Block POLISHED_ANDESITE_WALL = new MVWall("polished_andesite_wall", Blocks.POLISHED_ANDESITE);
    public static final Block POLISHED_GRANITE_WALL = new MVWall("polished_granite_wall", Blocks.POLISHED_GRANITE);

    // terracotta
    // stairs
    public static final Block TERRACOTTA_STAIRS = new MVAbsStairs("terracotta_stairs", net.minecraft.block.Blocks.TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.TERRACOTTA);
    public static final Block WHITE_TERRACOTTA_STAIRS = new MVAbsStairs("white_terracotta_stairs", net.minecraft.block.Blocks.WHITE_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.WHITE_TERRACOTTA);
    public static final Block ORANGE_TERRACOTTA_STAIRS = new MVAbsStairs("orange_terracotta_stairs", net.minecraft.block.Blocks.ORANGE_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.ORANGE_TERRACOTTA);
    public static final Block MAGENTA_TERRACOTTA_STAIRS = new MVAbsStairs("magenta_terracotta_stairs", net.minecraft.block.Blocks.MAGENTA_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.MAGENTA_TERRACOTTA);
    public static final Block LIGHT_BLUE_TERRACOTTA_STAIRS = new MVAbsStairs("light_blue_terracotta_stairs", net.minecraft.block.Blocks.LIGHT_BLUE_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.LIGHT_BLUE_TERRACOTTA);
    public static final Block YELLOW_TERRACOTTA_STAIRS = new MVAbsStairs("yellow_terracotta_stairs", net.minecraft.block.Blocks.YELLOW_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.YELLOW_TERRACOTTA);
    public static final Block LIME_TERRACOTTA_STAIRS = new MVAbsStairs("lime_terracotta_stairs", net.minecraft.block.Blocks.LIME_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.LIME_TERRACOTTA);
    public static final Block PINK_TERRACOTTA_STAIRS = new MVAbsStairs("pink_terracotta_stairs", net.minecraft.block.Blocks.PINK_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.PINK_TERRACOTTA);
    public static final Block GRAY_TERRACOTTA_STAIRS = new MVAbsStairs("gray_terracotta_stairs", net.minecraft.block.Blocks.GRAY_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.GRAY_TERRACOTTA);
    public static final Block LIGHT_GRAY_TERRACOTTA_STAIRS = new MVAbsStairs("light_gray_terracotta_stairs", net.minecraft.block.Blocks.LIGHT_GRAY_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.LIGHT_GRAY_TERRACOTTA);
    public static final Block CYAN_TERRACOTTA_STAIRS = new MVAbsStairs("cyan_terracotta_stairs", net.minecraft.block.Blocks.CYAN_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.CYAN_TERRACOTTA);
    public static final Block PURPLE_TERRACOTTA_STAIRS = new MVAbsStairs("purple_terracotta_stairs", net.minecraft.block.Blocks.PURPLE_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.PURPLE_TERRACOTTA);
    public static final Block BLUE_TERRACOTTA_STAIRS = new MVAbsStairs("blue_terracotta_stairs", net.minecraft.block.Blocks.BLUE_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.BLUE_TERRACOTTA);
    public static final Block BROWN_TERRACOTTA_STAIRS = new MVAbsStairs("brown_terracotta_stairs", net.minecraft.block.Blocks.BROWN_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.BROWN_TERRACOTTA);
    public static final Block GREEN_TERRACOTTA_STAIRS = new MVAbsStairs("green_terracotta_stairs", net.minecraft.block.Blocks.GREEN_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.GREEN_TERRACOTTA);
    public static final Block RED_TERRACOTTA_STAIRS = new MVAbsStairs("red_terracotta_stairs", net.minecraft.block.Blocks.RED_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.RED_TERRACOTTA);
    public static final Block BLACK_TERRACOTTA_STAIRS = new MVAbsStairs("black_terracotta_stairs", net.minecraft.block.Blocks.BLACK_TERRACOTTA.defaultBlockState(), net.minecraft.block.Blocks.BLACK_TERRACOTTA);
    // slabs
    public static final Block TERRACOTTA_SLAB = new MVAbsSlab("terracotta_slab", Material.STONE, MaterialColor.COLOR_ORANGE, 1.25F, 4.2F);
    public static final Block WHITE_TERRACOTTA_SLAB = new MVAbsSlab("white_terracotta_slab", Material.STONE, MaterialColor.TERRACOTTA_WHITE, 1.25F, 4.2F);
    public static final Block ORANGE_TERRACOTTA_SLAB = new MVAbsSlab("orange_terracotta_slab", Material.STONE, MaterialColor.TERRACOTTA_ORANGE, 1.25F, 4.2F);
    public static final Block MAGENTA_TERRACOTTA_SLAB = new MVAbsSlab("magenta_terracotta_slab", Material.STONE, MaterialColor.TERRACOTTA_MAGENTA, 1.25F, 4.2F);
    public static final Block LIGHT_BLUE_TERRACOTTA_SLAB = new MVAbsSlab("light_blue_terracotta_slab", Material.STONE, MaterialColor.TERRACOTTA_LIGHT_BLUE, 1.25F, 4.2F);
    public static final Block YELLOW_TERRACOTTA_SLAB = new MVAbsSlab("yellow_terracotta_slab", Material.STONE, MaterialColor.TERRACOTTA_YELLOW, 1.25F, 4.2F);
    public static final Block LIME_TERRACOTTA_SLAB = new MVAbsSlab("lime_terracotta_slab", Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GREEN, 1.25F, 4.2F);
    public static final Block PINK_TERRACOTTA_SLAB = new MVAbsSlab("pink_terracotta_slab", Material.STONE, MaterialColor.TERRACOTTA_PINK, 1.25F, 4.2F);
    public static final Block GRAY_TERRACOTTA_SLAB = new MVAbsSlab("gray_terracotta_slab", Material.STONE, MaterialColor.TERRACOTTA_GRAY, 1.25F, 4.2F);
    public static final Block LIGHT_GRAY_TERRACOTTA_SLAB = new MVAbsSlab("light_gray_terracotta_slab", Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GRAY, 1.25F, 4.2F);
    public static final Block CYAN_TERRACOTTA_SLAB = new MVAbsSlab("cyan_terracotta_slab", Material.STONE, MaterialColor.TERRACOTTA_CYAN, 1.25F, 4.2F);
    public static final Block PURPLE_TERRACOTTA_SLAB = new MVAbsSlab("purple_terracotta_slab", Material.STONE, MaterialColor.TERRACOTTA_PURPLE, 1.25F, 4.2F);
    public static final Block BLUE_TERRACOTTA_SLAB = new MVAbsSlab("blue_terracotta_slab", Material.STONE, MaterialColor.TERRACOTTA_BLUE, 1.25F, 4.2F);
    public static final Block BROWN_TERRACOTTA_SLAB = new MVAbsSlab("brown_terracotta_slab", Material.STONE, MaterialColor.TERRACOTTA_BROWN, 1.25F, 4.2F);
    public static final Block GREEN_TERRACOTTA_SLAB = new MVAbsSlab("green_terracotta_slab", Material.STONE, MaterialColor.TERRACOTTA_GREEN, 1.25F, 4.2F);
    public static final Block RED_TERRACOTTA_SLAB = new MVAbsSlab("red_terracotta_slab", Material.STONE, MaterialColor.TERRACOTTA_RED, 1.25F, 4.2F);
    public static final Block BLACK_TERRACOTTA_SLAB = new MVAbsSlab("black_terracotta_slab", Material.STONE, MaterialColor.TERRACOTTA_BLACK, 1.25F, 4.2F);

    // concrete
    // stairs
    public static final Block WHITE_CONCRETE_STAIRS = new MVAbsStairs("white_concrete_stairs", net.minecraft.block.Blocks.WHITE_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.WHITE_CONCRETE);
    public static final Block ORANGE_CONCRETE_STAIRS = new MVAbsStairs("orange_concrete_stairs", net.minecraft.block.Blocks.ORANGE_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.ORANGE_CONCRETE);
    public static final Block MAGENTA_CONCRETE_STAIRS = new MVAbsStairs("magenta_concrete_stairs", net.minecraft.block.Blocks.MAGENTA_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.MAGENTA_CONCRETE);
    public static final Block LIGHT_BLUE_CONCRETE_STAIRS = new MVAbsStairs("light_blue_concrete_stairs", net.minecraft.block.Blocks.LIGHT_BLUE_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.LIGHT_BLUE_CONCRETE);
    public static final Block YELLOW_CONCRETE_STAIRS = new MVAbsStairs("yellow_concrete_stairs", net.minecraft.block.Blocks.YELLOW_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.YELLOW_CONCRETE);
    public static final Block LIME_CONCRETE_STAIRS = new MVAbsStairs("lime_concrete_stairs", net.minecraft.block.Blocks.LIME_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.LIME_CONCRETE);
    public static final Block PINK_CONCRETE_STAIRS = new MVAbsStairs("pink_concrete_stairs", net.minecraft.block.Blocks.PINK_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.PINK_CONCRETE);
    public static final Block GRAY_CONCRETE_STAIRS = new MVAbsStairs("gray_concrete_stairs", net.minecraft.block.Blocks.GRAY_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.GRAY_CONCRETE);
    public static final Block LIGHT_GRAY_CONCRETE_STAIRS = new MVAbsStairs("light_gray_concrete_stairs", net.minecraft.block.Blocks.LIGHT_GRAY_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.LIGHT_GRAY_CONCRETE);
    public static final Block CYAN_CONCRETE_STAIRS = new MVAbsStairs("cyan_concrete_stairs", net.minecraft.block.Blocks.CYAN_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.CYAN_CONCRETE);
    public static final Block PURPLE_CONCRETE_STAIRS = new MVAbsStairs("purple_concrete_stairs", net.minecraft.block.Blocks.PURPLE_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.PURPLE_CONCRETE);
    public static final Block BLUE_CONCRETE_STAIRS = new MVAbsStairs("blue_concrete_stairs", net.minecraft.block.Blocks.BLUE_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.BLUE_CONCRETE);
    public static final Block BROWN_CONCRETE_STAIRS = new MVAbsStairs("brown_concrete_stairs", net.minecraft.block.Blocks.BROWN_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.BROWN_CONCRETE);
    public static final Block GREEN_CONCRETE_STAIRS = new MVAbsStairs("green_concrete_stairs", net.minecraft.block.Blocks.GREEN_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.GREEN_CONCRETE);
    public static final Block RED_CONCRETE_STAIRS = new MVAbsStairs("red_concrete_stairs", net.minecraft.block.Blocks.RED_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.RED_CONCRETE);
    public static final Block BLACK_CONCRETE_STAIRS = new MVAbsStairs("black_concrete_stairs", net.minecraft.block.Blocks.BLACK_CONCRETE.defaultBlockState(), net.minecraft.block.Blocks.BLACK_CONCRETE);
    // slabs
    public static final Block WHITE_CONCRETE_SLAB = new MVAbsSlabD("white_concrete_slab", Material.STONE, DyeColor.WHITE, 1.8F, 1.8F);
    public static final Block ORANGE_CONCRETE_SLAB = new MVAbsSlabD("orange_concrete_slab", Material.STONE, DyeColor.ORANGE, 1.8F, 1.8F);
    public static final Block MAGENTA_CONCRETE_SLAB = new MVAbsSlabD("magenta_concrete_slab", Material.STONE, DyeColor.MAGENTA, 1.8F, 1.8F);
    public static final Block LIGHT_BLUE_CONCRETE_SLAB = new MVAbsSlabD("light_blue_concrete_slab", Material.STONE, DyeColor.LIGHT_BLUE, 1.8F, 1.8F);
    public static final Block YELLOW_CONCRETE_SLAB = new MVAbsSlabD("yellow_concrete_slab", Material.STONE, DyeColor.YELLOW, 1.8F, 1.8F);
    public static final Block LIME_CONCRETE_SLAB = new MVAbsSlabD("lime_concrete_slab", Material.STONE, DyeColor.LIME, 1.8F, 1.8F);
    public static final Block PINK_CONCRETE_SLAB = new MVAbsSlabD("pink_concrete_slab", Material.STONE, DyeColor.PINK, 1.8F, 1.8F);
    public static final Block GRAY_CONCRETE_SLAB = new MVAbsSlabD("gray_concrete_slab", Material.STONE, DyeColor.GRAY, 1.8F, 1.8F);
    public static final Block LIGHT_GRAY_CONCRETE_SLAB = new MVAbsSlabD("light_gray_concrete_slab", Material.STONE, DyeColor.LIGHT_GRAY, 1.8F, 1.8F);
    public static final Block CYAN_CONCRETE_SLAB = new MVAbsSlabD("cyan_concrete_slab", Material.STONE, DyeColor.CYAN, 1.8F, 1.8F);
    public static final Block PURPLE_CONCRETE_SLAB = new MVAbsSlabD("purple_concrete_slab", Material.STONE, DyeColor.PURPLE, 1.8F, 1.8F);
    public static final Block BLUE_CONCRETE_SLAB = new MVAbsSlabD("blue_concrete_slab", Material.STONE, DyeColor.BLUE, 1.8F, 1.8F);
    public static final Block BROWN_CONCRETE_SLAB = new MVAbsSlabD("brown_concrete_slab", Material.STONE, DyeColor.BROWN, 1.8F, 1.8F);
    public static final Block GREEN_CONCRETE_SLAB = new MVAbsSlabD("green_concrete_slab", Material.STONE, DyeColor.GREEN, 1.8F, 1.8F);
    public static final Block RED_CONCRETE_SLAB = new MVAbsSlabD("red_concrete_slab", Material.STONE, DyeColor.RED, 1.8F, 1.8F);
    public static final Block BLACK_CONCRETE_SLAB = new MVAbsSlabD("black_concrete_slab", Material.STONE, DyeColor.BLACK, 1.8F, 1.8F);

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
            RenderType cutout = RenderType.cutout();
            RenderTypeLookup.setRenderLayer(STEEL_TRAPDOOR, cutout);
            RenderTypeLookup.setRenderLayer(CHAIN_LINK_FENCE, cutout);
            RenderTypeLookup.setRenderLayer(BARBED_WIRE_ROLL, cutout);
            RenderTypeLookup.setRenderLayer(BARBED_WIRE_EDGING, cutout);
            RenderTypeLookup.setRenderLayer(STEEL_FRAME, cutout);
            RenderTypeLookup.setRenderLayer(IRON_FRAME, cutout);

            RenderType clear = RenderType.translucent();
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

        }
    }

    @SubscribeEvent
    public static void registerBlockItems(RegistryEvent.Register<Item> regBlockItems) {
        try {
            for (Field f : MVBlocks.class.getDeclaredFields()) {
                Object obj = f.get(null);
                if (obj instanceof IronScaffolding) {
                    BlockItem blockItem = new IronScaffoldingItem((Block) obj, new Item.Properties().tab(ModernVanilla.TAB));
                    blockItem.setRegistryName(((Block) obj).getRegistryName());
                    regBlockItems.getRegistry().register(blockItem);
                } else if (obj instanceof SteelScaffolding) {
                    BlockItem blockItem = new SteelScaffoldingItem((Block) obj, new Item.Properties().tab(ModernVanilla.TAB));
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
