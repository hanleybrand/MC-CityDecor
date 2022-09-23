package com.tzaranthony.citydecor.util;

import com.tzaranthony.citydecor.CityDecor;
import com.tzaranthony.citydecor.block.*;
import com.tzaranthony.citydecor.item.IronScaffoldingItem;
import com.tzaranthony.citydecor.item.SteelScaffoldingItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = CityDecor.MOD_ID, bus = Bus.MOD)
public class CDBlocks {
    public static final DeferredRegister<Block> reg = DeferredRegister.create(ForgeRegistries.BLOCKS, CityDecor.MOD_ID);

    // steel
    public static final RegistryObject<Block> STEEL_BLOCK = registerBlockAndItem("steel_block", () -> new Block(CDBlockProperties.StandardMetal(2, 6.0F, 8.0F)));
    public static final RegistryObject<Block> STEEL_FRAME = registerBlockAndItem("steel_frame", () -> new Block(CDBlockProperties.NonFullMetal(2, 6.0F, 8.0F)));
    public static final RegistryObject<Block> IRON_FRAME = registerBlockAndItem("iron_frame", () -> new Block(CDBlockProperties.NonFullMetal(1, 5.0F, 6.0F)));
    //TODO: Cushion -- like a half slab of wool, but sittable, make it have a better texture please. Maybe a chair???

    // shipping
    public static final RegistryObject<Block> CARDBOARD_BOX = registerBlockAndItem("cardboard_box", () -> new CardboardBox(CDBlockProperties.Cardboard(0.1F), false), 1);
    public static final RegistryObject<Block> SHIPPING_PALLET = registerBlockAndItem("shipping_pallet", () -> new CardboardBox(CDBlockProperties.Cardboard(1.5F), true), 1);

    // reinforced concrete
    public static final RegistryObject<Block> REINFORCED_CONCRETE = registerBlockAndItem("reinforced_concrete", () -> new Block(CDBlockProperties.StandardRock(2.0F, 9.0F)));
    public static final RegistryObject<Block> REINFORCED_CONCRETE_POWDER = registerBlockAndItem("reinforced_concrete_powder", () -> new CDConcretePowder(REINFORCED_CONCRETE.get(), MaterialColor.SNOW));
    public static final RegistryObject<Block> REINFORCED_CONCRETE_STAIRS = registerBlockAndItem("reinforced_concrete_stairs", () -> new StairBlock(REINFORCED_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(REINFORCED_CONCRETE.get())));
    public static final RegistryObject<Block> REINFORCED_CONCRETE_SLAB = registerBlockAndItem("reinforced_concrete_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(REINFORCED_CONCRETE.get())));
    // worn and cracked
    public static final RegistryObject<Block> WORN_REINFORCED_CONCRETE = registerBlockAndItem("worn_reinforced_concrete", () -> new Block(CDBlockProperties.StandardRock(2.0F,9.0F)));
    public static final RegistryObject<Block> CRACKED_REINFORCED_CONCRETE = registerBlockAndItem("cracked_reinforced_concrete", () -> new Block(CDBlockProperties.StandardRock(2.0F,9.0F)));
    public static final RegistryObject<Block> WORN_REINFORCED_CONCRETE_SLAB = registerBlockAndItem("worn_reinforced_concrete_slab", () -> new SlabBlock(CDBlockProperties.StandardRock(2.0F,9.0F)));
    public static final RegistryObject<Block> CRACKED_REINFORCED_CONCRETE_SLAB = registerBlockAndItem("cracked_reinforced_concrete_slab", () -> new SlabBlock(CDBlockProperties.StandardRock(2.0F,9.0F)));
    public static final RegistryObject<Block> WORN_REINFORCED_CONCRETE_STAIRS = registerBlockAndItem("worn_reinforced_concrete_stairs", () -> new StairBlock(WORN_REINFORCED_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(WORN_REINFORCED_CONCRETE.get())));
    public static final RegistryObject<Block> CRACKED_REINFORCED_CONCRETE_STAIRS = registerBlockAndItem("cracked_reinforced_concrete_stairs", () -> new StairBlock(CRACKED_REINFORCED_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(CRACKED_REINFORCED_CONCRETE.get())));

    //TODO: peripherals -- grate, barbed wire, metal scaffolding, pipes?, Iron blinds, steel blinds
    public static final RegistryObject<Block> BARBED_WIRE_ROLL = registerBlockAndItem("barbed_wire_roll", () -> new BarbedWire());
    public static final RegistryObject<Block> BARBED_WIRE_EDGING = registerBlockAndItem("barbed_wire_edging", () -> new CDStairsDmg(BARBED_WIRE_ROLL.get().defaultBlockState(), BARBED_WIRE_ROLL.get()));
    public static final RegistryObject<Block> IRON_SCAFFOLDING = registerBlockAndItem("iron_scaffolding", () -> new IronScaffolding(), true);
    public static final RegistryObject<Block> STEEL_SCAFFOLDING = registerBlockAndItem("steel_scaffolding", () -> new SteelScaffolding(), false);
    public static final RegistryObject<Block> STEEL_ROD = registerBlockAndItem("steel_rod", () -> new CDRod(CDBlockProperties.NonFullMetal(2,5.0F,6.0F)));
    // metal fence, steel trap door, steel door
    public static final RegistryObject<Block> IRON_FENCE = registerBlockAndItem("iron_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> STEEL_FENCE = registerBlockAndItem("steel_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(STEEL_BLOCK.get())));
    public static final RegistryObject<Block> CHAIN_LINK_FENCE = registerBlockAndItem("chain_link_fence", () -> new IronBarsBlock(CDBlockProperties.ChainFence()));
    public static final RegistryObject<Block> STEEL_TRAPDOOR = registerBlockAndItem("steel_trapdoor", () -> new TrapDoorBlock(CDBlockProperties.MetalTrapdoor()));
    public static final RegistryObject<Block> STEEL_DOOR = registerBlockAndItem("steel_door", () -> new CDDoor(CDBlockProperties.MetalDoor(2,5.0F)));

    // glass trapdoors
    public static final RegistryObject<Block> GLASS_TRAPDOOR = registerBlockAndItem("glass_trapdoor", () -> new GlassTrapdoor(MaterialColor.NONE));
    public static final RegistryObject<Block> WHITE_STAINED_GLASS_TRAPDOOR = registerBlockAndItem("white_stained_glass_trapdoor", () -> new GlassTrapdoor(MaterialColor.SNOW));
    public static final RegistryObject<Block> ORANGE_STAINED_GLASS_TRAPDOOR = registerBlockAndItem("orange_stained_glass_trapdoor", () -> new GlassTrapdoor(MaterialColor.COLOR_ORANGE));
    public static final RegistryObject<Block> MAGENTA_STAINED_GLASS_TRAPDOOR = registerBlockAndItem("magenta_stained_glass_trapdoor", () -> new GlassTrapdoor(MaterialColor.COLOR_MAGENTA));
    public static final RegistryObject<Block> LIGHT_BLUE_STAINED_GLASS_TRAPDOOR = registerBlockAndItem("light_blue_stained_glass_trapdoor", () -> new GlassTrapdoor(MaterialColor.COLOR_LIGHT_BLUE));
    public static final RegistryObject<Block> YELLOW_STAINED_GLASS_TRAPDOOR = registerBlockAndItem("yellow_stained_glass_trapdoor", () -> new GlassTrapdoor(MaterialColor.COLOR_YELLOW));
    public static final RegistryObject<Block> LIME_STAINED_GLASS_TRAPDOOR = registerBlockAndItem("lime_stained_glass_trapdoor", () -> new GlassTrapdoor(MaterialColor.COLOR_LIGHT_GREEN));
    public static final RegistryObject<Block> PINK_STAINED_GLASS_TRAPDOOR = registerBlockAndItem("pink_stained_glass_trapdoor", () -> new GlassTrapdoor(MaterialColor.COLOR_PINK));
    public static final RegistryObject<Block> GRAY_STAINED_GLASS_TRAPDOOR = registerBlockAndItem("gray_stained_glass_trapdoor", () -> new GlassTrapdoor(MaterialColor.COLOR_GRAY));
    public static final RegistryObject<Block> LIGHT_GRAY_STAINED_GLASS_TRAPDOOR = registerBlockAndItem("light_gray_stained_glass_trapdoor", () -> new GlassTrapdoor(MaterialColor.COLOR_LIGHT_GRAY));
    public static final RegistryObject<Block> CYAN_STAINED_GLASS_TRAPDOOR = registerBlockAndItem("cyan_stained_glass_trapdoor", () -> new GlassTrapdoor(MaterialColor.COLOR_CYAN));
    public static final RegistryObject<Block> PURPLE_STAINED_GLASS_TRAPDOOR = registerBlockAndItem("purple_stained_glass_trapdoor", () -> new GlassTrapdoor(MaterialColor.COLOR_PURPLE));
    public static final RegistryObject<Block> BLUE_STAINED_GLASS_TRAPDOOR = registerBlockAndItem("blue_stained_glass_trapdoor", () -> new GlassTrapdoor(MaterialColor.COLOR_BLUE));
    public static final RegistryObject<Block> BROWN_STAINED_GLASS_TRAPDOOR = registerBlockAndItem("brown_stained_glass_trapdoor", () -> new GlassTrapdoor(MaterialColor.COLOR_BROWN));
    public static final RegistryObject<Block> GREEN_STAINED_GLASS_TRAPDOOR = registerBlockAndItem("green_stained_glass_trapdoor", () -> new GlassTrapdoor(MaterialColor.COLOR_GREEN));
    public static final RegistryObject<Block> RED_STAINED_GLASS_TRAPDOOR = registerBlockAndItem("red_stained_glass_trapdoor", () -> new GlassTrapdoor(MaterialColor.COLOR_RED));
    public static final RegistryObject<Block> BLACK_STAINED_GLASS_TRAPDOOR = registerBlockAndItem("black_stained_glass_trapdoor", () -> new GlassTrapdoor(MaterialColor.COLOR_BLACK));
    // glass doors
    public static final RegistryObject<Block> GLASS_DOOR = registerBlockAndItem("glass_door", () -> new CDDoor(CDBlockProperties.GlassDoor(MaterialColor.NONE)));
    public static final RegistryObject<Block> WHITE_STAINED_GLASS_DOOR = registerBlockAndItem("white_stained_glass_door", () -> new CDDoor(CDBlockProperties.GlassDoor(MaterialColor.SNOW)));
    public static final RegistryObject<Block> ORANGE_STAINED_GLASS_DOOR = registerBlockAndItem("orange_stained_glass_door", () -> new CDDoor(CDBlockProperties.GlassDoor(MaterialColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> MAGENTA_STAINED_GLASS_DOOR = registerBlockAndItem("magenta_stained_glass_door", () -> new CDDoor(CDBlockProperties.GlassDoor(MaterialColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> LIGHT_BLUE_STAINED_GLASS_DOOR = registerBlockAndItem("light_blue_stained_glass_door", () -> new CDDoor(CDBlockProperties.GlassDoor(MaterialColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> YELLOW_STAINED_GLASS_DOOR = registerBlockAndItem("yellow_stained_glass_door", () -> new CDDoor(CDBlockProperties.GlassDoor(MaterialColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> LIME_STAINED_GLASS_DOOR = registerBlockAndItem("lime_stained_glass_door", () -> new CDDoor(CDBlockProperties.GlassDoor(MaterialColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> PINK_STAINED_GLASS_DOOR = registerBlockAndItem("pink_stained_glass_door", () -> new CDDoor(CDBlockProperties.GlassDoor(MaterialColor.COLOR_PINK)));
    public static final RegistryObject<Block> GRAY_STAINED_GLASS_DOOR = registerBlockAndItem("gray_stained_glass_door", () -> new CDDoor(CDBlockProperties.GlassDoor(MaterialColor.COLOR_GRAY)));
    public static final RegistryObject<Block> LIGHT_GRAY_STAINED_GLASS_DOOR = registerBlockAndItem("light_gray_stained_glass_door", () -> new CDDoor(CDBlockProperties.GlassDoor(MaterialColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> CYAN_STAINED_GLASS_DOOR = registerBlockAndItem("cyan_stained_glass_door", () -> new CDDoor(CDBlockProperties.GlassDoor(MaterialColor.COLOR_CYAN)));
    public static final RegistryObject<Block> PURPLE_STAINED_GLASS_DOOR = registerBlockAndItem("purple_stained_glass_door", () -> new CDDoor(CDBlockProperties.GlassDoor(MaterialColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> BLUE_STAINED_GLASS_DOOR = registerBlockAndItem("blue_stained_glass_door", () -> new CDDoor(CDBlockProperties.GlassDoor(MaterialColor.COLOR_BLUE)));
    public static final RegistryObject<Block> BROWN_STAINED_GLASS_DOOR = registerBlockAndItem("brown_stained_glass_door", () -> new CDDoor(CDBlockProperties.GlassDoor(MaterialColor.COLOR_BROWN)));
    public static final RegistryObject<Block> GREEN_STAINED_GLASS_DOOR = registerBlockAndItem("green_stained_glass_door", () -> new CDDoor(CDBlockProperties.GlassDoor(MaterialColor.COLOR_GREEN)));
    public static final RegistryObject<Block> RED_STAINED_GLASS_DOOR = registerBlockAndItem("red_stained_glass_door", () -> new CDDoor(CDBlockProperties.GlassDoor(MaterialColor.COLOR_RED)));
    public static final RegistryObject<Block> BLACK_STAINED_GLASS_DOOR = registerBlockAndItem("black_stained_glass_door", () -> new CDDoor(CDBlockProperties.GlassDoor(MaterialColor.COLOR_BLACK)));
    //TODO: lightbulb? (wall, ceiling)
    public static final RegistryObject<Block> CEILING_LIGHT = registerBlockAndItem("ceiling_light", () -> new RotatedPillarBlock(CDBlockProperties.MetalLightBlock(15)));
    // neon light tubes
    public static final RegistryObject<Block> NEON_LIGHT = registerBlockAndItem("neon_light", () -> new NeonLight(CDBlockProperties.NeonLight(15)));
    public static final RegistryObject<Block> BLACK_LIGHT = registerBlockAndItem("black_light", () -> new NeonLight(CDBlockProperties.NeonLight(7)));
    // end rods
    public static final RegistryObject<Block> WHITE_END_ROD  = registerBlockAndItem("white_end_rod", () -> new CDRod(CDBlockProperties.EndRod()));
    public static final RegistryObject<Block> ORANGE_END_ROD = registerBlockAndItem("orange_end_rod", () -> new CDRod(CDBlockProperties.EndRod()));
    public static final RegistryObject<Block> MAGENTA_END_RO = registerBlockAndItem("magenta_end_rod", () -> new CDRod(CDBlockProperties.EndRod()));
    public static final RegistryObject<Block> LIGHT_BLUE_END_ROD = registerBlockAndItem("light_blue_end_rod", () -> new CDRod(CDBlockProperties.EndRod()));
    public static final RegistryObject<Block> YELLOW_END_ROD = registerBlockAndItem("yellow_end_rod", () -> new CDRod(CDBlockProperties.EndRod()));
    public static final RegistryObject<Block> LIME_END_ROD = registerBlockAndItem("lime_end_rod", () -> new CDRod(CDBlockProperties.EndRod()));
    public static final RegistryObject<Block> PINK_END_ROD = registerBlockAndItem("pink_end_rod", () -> new CDRod(CDBlockProperties.EndRod()));
    public static final RegistryObject<Block> GRAY_END_ROD = registerBlockAndItem("gray_end_rod", () -> new CDRod(CDBlockProperties.EndRod()));
    public static final RegistryObject<Block> LIGHT_GRAY_END_ROD = registerBlockAndItem("light_gray_end_rod", () -> new CDRod(CDBlockProperties.EndRod()));
    public static final RegistryObject<Block> CYAN_END_ROD = registerBlockAndItem("cyan_end_rod", () -> new CDRod(CDBlockProperties.EndRod()));
    public static final RegistryObject<Block> PURPLE_END_ROD = registerBlockAndItem("purple_end_rod", () -> new CDRod(CDBlockProperties.EndRod()));
    public static final RegistryObject<Block> BLUE_END_ROD = registerBlockAndItem("blue_end_rod", () -> new CDRod(CDBlockProperties.EndRod()));
    public static final RegistryObject<Block> BROWN_END_ROD  = registerBlockAndItem("brown_end_rod", () -> new CDRod(CDBlockProperties.EndRod()));
    public static final RegistryObject<Block> GREEN_END_ROD  = registerBlockAndItem("green_end_rod", () -> new CDRod(CDBlockProperties.EndRod()));
    public static final RegistryObject<Block> RED_END_ROD = registerBlockAndItem("red_end_rod", () -> new CDRod(CDBlockProperties.EndRod()));
    public static final RegistryObject<Block> BLACK_END_ROD  = registerBlockAndItem("black_end_rod", () -> new CDRod(CDBlockProperties.EndRod()));
    //TODO: glass light blocks
    //TODO: pastel blocks
    //TODO: muted pastel blocks

    // metal plating
    public static final RegistryObject<Block> IRON_SIDING = registerBlockAndItem("iron_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> STEEL_SIDING = registerBlockAndItem("steel_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    // iron colours
    public static final RegistryObject<Block> WHITE_IRON_SIDING = registerBlockAndItem("white_iron_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> ORANGE_IRON_SIDING = registerBlockAndItem("orange_iron_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> MAGENTA_IRON_SIDING = registerBlockAndItem("magenta_iron_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> LIGHT_BLUE_IRON_SIDING = registerBlockAndItem("light_blue_iron_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> YELLOW_IRON_SIDING = registerBlockAndItem("yellow_iron_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> LIME_IRON_SIDING = registerBlockAndItem("lime_iron_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> PINK_IRON_SIDING = registerBlockAndItem("pink_iron_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> GRAY_IRON_SIDING = registerBlockAndItem("gray_iron_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> LIGHT_GRAY_IRON_SIDING = registerBlockAndItem("light_gray_iron_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> CYAN_IRON_SIDING = registerBlockAndItem("cyan_iron_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> PURPLE_IRON_SIDING = registerBlockAndItem("purple_iron_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> BLUE_IRON_SIDING = registerBlockAndItem("blue_iron_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> BROWN_IRON_SIDING = registerBlockAndItem("brown_iron_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> GREEN_IRON_SIDING = registerBlockAndItem("green_iron_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> RED_IRON_SIDING = registerBlockAndItem("red_iron_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> BLACK_IRON_SIDING = registerBlockAndItem("black_iron_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    // steel colours
    public static final RegistryObject<Block> WHITE_STEEL_SIDING = registerBlockAndItem("white_steel_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> ORANGE_STEEL_SIDING = registerBlockAndItem("orange_steel_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> MAGENTA_STEEL_SIDING = registerBlockAndItem("magenta_steel_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> LIGHT_BLUE_STEEL_SIDING = registerBlockAndItem("light_blue_steel_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> YELLOW_STEEL_SIDING = registerBlockAndItem("yellow_steel_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> LIME_STEEL_SIDING = registerBlockAndItem("lime_steel_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> PINK_STEEL_SIDING = registerBlockAndItem("pink_steel_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> GRAY_STEEL_SIDING = registerBlockAndItem("gray_steel_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> LIGHT_GRAY_STEEL_SIDING = registerBlockAndItem("light_gray_steel_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> CYAN_STEEL_SIDING = registerBlockAndItem("cyan_steel_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> PURPLE_STEEL_SIDING = registerBlockAndItem("purple_steel_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> BLUE_STEEL_SIDING = registerBlockAndItem("blue_steel_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> BROWN_STEEL_SIDING = registerBlockAndItem("brown_steel_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> GREEN_STEEL_SIDING = registerBlockAndItem("green_steel_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> RED_STEEL_SIDING = registerBlockAndItem("red_steel_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));
    public static final RegistryObject<Block> BLACK_STEEL_SIDING = registerBlockAndItem("black_steel_siding", () -> new Block(CDBlockProperties.StandardNetheriteSoundMetal()));

    // cracked bricks, mossy bricks
    public static final RegistryObject<Block> CRACKED_BRICKS = registerBlockAndItem("cracked_bricks", () -> new Block(CDBlockProperties.StandardRock()));
    public static final RegistryObject<Block> MOSSY_BRICKS = registerBlockAndItem("mossy_bricks", () -> new Block(CDBlockProperties.StandardRock()));
    // slabs
    public static final RegistryObject<Block> CRACKED_BRICKS_SLAB = registerBlockAndItem("cracked_bricks_slab", () -> new SlabBlock(CDBlockProperties.StandardRock()));
    public static final RegistryObject<Block> MOSSY_BRICKS_SLAB = registerBlockAndItem("mossy_bricks_slab", () -> new SlabBlock(CDBlockProperties.StandardRock()));
    //stairs
    public static final RegistryObject<Block> CRACKED_BRICKS_STAIRS = registerBlockAndItem("cracked_bricks_stairs", () -> new StairBlock(CRACKED_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(CRACKED_BRICKS.get())));
    public static final RegistryObject<Block> MOSSY_BRICKS_STAIRS = registerBlockAndItem("mossy_bricks_stairs", () -> new StairBlock(MOSSY_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(MOSSY_BRICKS.get())));

    // cracked concrete
    public static final RegistryObject<Block> CRACKED_WHITE_CONCRETE = registerBlockAndItem("cracked_white_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.SNOW)));
    public static final RegistryObject<Block> CRACKED_ORANGE_CONCRETE = registerBlockAndItem("cracked_orange_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> CRACKED_MAGENTA_CONCRETE = registerBlockAndItem("cracked_magenta_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> CRACKED_LIGHT_BLUE_CONCRETE = registerBlockAndItem("cracked_light_blue_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> CRACKED_YELLOW_CONCRETE = registerBlockAndItem("cracked_yellow_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> CRACKED_LIME_CONCRETE = registerBlockAndItem("cracked_lime_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> CRACKED_PINK_CONCRETE = registerBlockAndItem("cracked_pink_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_PINK)));
    public static final RegistryObject<Block> CRACKED_GRAY_CONCRETE = registerBlockAndItem("cracked_gray_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_GRAY)));
    public static final RegistryObject<Block> CRACKED_LIGHT_GRAY_CONCRETE = registerBlockAndItem("cracked_light_gray_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> CRACKED_CYAN_CONCRETE = registerBlockAndItem("cracked_cyan_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_CYAN)));
    public static final RegistryObject<Block> CRACKED_PURPLE_CONCRETE = registerBlockAndItem("cracked_purple_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> CRACKED_BLUE_CONCRETE = registerBlockAndItem("cracked_blue_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_BLUE)));
    public static final RegistryObject<Block> CRACKED_BROWN_CONCRETE = registerBlockAndItem("cracked_brown_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_BROWN)));
    public static final RegistryObject<Block> CRACKED_GREEN_CONCRETE = registerBlockAndItem("cracked_green_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_GREEN)));
    public static final RegistryObject<Block> CRACKED_RED_CONCRETE = registerBlockAndItem("cracked_red_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_RED)));
    public static final RegistryObject<Block> CRACKED_BLACK_CONCRETE = registerBlockAndItem("cracked_black_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_BLACK)));
    // worn concrete
    public static final RegistryObject<Block> WORN_WHITE_CONCRETE = registerBlockAndItem("worn_white_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.SNOW)));
    public static final RegistryObject<Block> WORN_ORANGE_CONCRETE = registerBlockAndItem("worn_orange_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> WORN_MAGENTA_CONCRETE = registerBlockAndItem("worn_magenta_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> WORN_LIGHT_BLUE_CONCRETE = registerBlockAndItem("worn_light_blue_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> WORN_YELLOW_CONCRETE = registerBlockAndItem("worn_yellow_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> WORN_LIME_CONCRETE = registerBlockAndItem("worn_lime_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> WORN_PINK_CONCRETE = registerBlockAndItem("worn_pink_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_PINK)));
    public static final RegistryObject<Block> WORN_GRAY_CONCRETE = registerBlockAndItem("worn_gray_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_GRAY)));
    public static final RegistryObject<Block> WORN_LIGHT_GRAY_CONCRETE = registerBlockAndItem("worn_light_gray_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> WORN_CYAN_CONCRETE = registerBlockAndItem("worn_cyan_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_CYAN)));
    public static final RegistryObject<Block> WORN_PURPLE_CONCRETE = registerBlockAndItem("worn_purple_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> WORN_BLUE_CONCRETE = registerBlockAndItem("worn_blue_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_BLUE)));
    public static final RegistryObject<Block> WORN_BROWN_CONCRETE = registerBlockAndItem("worn_brown_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_BROWN)));
    public static final RegistryObject<Block> WORN_GREEN_CONCRETE = registerBlockAndItem("worn_green_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_GREEN)));
    public static final RegistryObject<Block> WORN_RED_CONCRETE = registerBlockAndItem("worn_red_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_RED)));
    public static final RegistryObject<Block> WORN_BLACK_CONCRETE = registerBlockAndItem("worn_black_concrete", () -> new Block(CDBlockProperties.Concrete(MaterialColor.COLOR_BLACK)));
    // slabs
    public static final RegistryObject<Block> WORN_WHITE_CONCRETE_SLAB = registerBlockAndItem("worn_white_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.SNOW)));
    public static final RegistryObject<Block> WORN_ORANGE_CONCRETE_SLAB = registerBlockAndItem("worn_orange_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> WORN_MAGENTA_CONCRETE_SLAB = registerBlockAndItem("worn_magenta_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> WORN_LIGHT_BLUE_CONCRETE_SLAB = registerBlockAndItem("worn_light_blue_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> WORN_YELLOW_CONCRETE_SLAB = registerBlockAndItem("worn_yellow_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> WORN_LIME_CONCRETE_SLAB = registerBlockAndItem("worn_lime_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> WORN_PINK_CONCRETE_SLAB = registerBlockAndItem("worn_pink_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_PINK)));
    public static final RegistryObject<Block> WORN_GRAY_CONCRETE_SLAB = registerBlockAndItem("worn_gray_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_GRAY)));
    public static final RegistryObject<Block> WORN_LIGHT_GRAY_CONCRETE_SLAB = registerBlockAndItem("worn_light_gray_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> WORN_CYAN_CONCRETE_SLAB = registerBlockAndItem("worn_cyan_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_CYAN)));
    public static final RegistryObject<Block> WORN_PURPLE_CONCRETE_SLAB = registerBlockAndItem("worn_purple_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> WORN_BLUE_CONCRETE_SLAB = registerBlockAndItem("worn_blue_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_BLUE)));
    public static final RegistryObject<Block> WORN_BROWN_CONCRETE_SLAB = registerBlockAndItem("worn_brown_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_BROWN)));
    public static final RegistryObject<Block> WORN_GREEN_CONCRETE_SLAB = registerBlockAndItem("worn_green_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_GREEN)));
    public static final RegistryObject<Block> WORN_RED_CONCRETE_SLAB = registerBlockAndItem("worn_red_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_RED)));
    public static final RegistryObject<Block> WORN_BLACK_CONCRETE_SLAB = registerBlockAndItem("worn_black_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_BLACK)));
    public static final RegistryObject<Block> CRACKED_WHITE_CONCRETE_SLAB = registerBlockAndItem("cracked_white_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.SNOW)));
    public static final RegistryObject<Block> CRACKED_ORANGE_CONCRETE_SLAB = registerBlockAndItem("cracked_orange_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> CRACKED_MAGENTA_CONCRETE_SLAB = registerBlockAndItem("cracked_magenta_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> CRACKED_LIGHT_BLUE_CONCRETE_SLAB = registerBlockAndItem("cracked_light_blue_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> CRACKED_YELLOW_CONCRETE_SLAB = registerBlockAndItem("cracked_yellow_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> CRACKED_LIME_CONCRETE_SLAB = registerBlockAndItem("cracked_lime_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> CRACKED_PINK_CONCRETE_SLAB = registerBlockAndItem("cracked_pink_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_PINK)));
    public static final RegistryObject<Block> CRACKED_GRAY_CONCRETE_SLAB = registerBlockAndItem("cracked_gray_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_GRAY)));
    public static final RegistryObject<Block> CRACKED_LIGHT_GRAY_CONCRETE_SLAB = registerBlockAndItem("cracked_light_gray_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> CRACKED_CYAN_CONCRETE_SLAB = registerBlockAndItem("cracked_cyan_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_CYAN)));
    public static final RegistryObject<Block> CRACKED_PURPLE_CONCRETE_SLAB = registerBlockAndItem("cracked_purple_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> CRACKED_BLUE_CONCRETE_SLAB = registerBlockAndItem("cracked_blue_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_BLUE)));
    public static final RegistryObject<Block> CRACKED_BROWN_CONCRETE_SLAB = registerBlockAndItem("cracked_brown_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_BROWN)));
    public static final RegistryObject<Block> CRACKED_GREEN_CONCRETE_SLAB = registerBlockAndItem("cracked_green_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_GREEN)));
    public static final RegistryObject<Block> CRACKED_RED_CONCRETE_SLAB = registerBlockAndItem("cracked_red_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_RED)));
    public static final RegistryObject<Block> CRACKED_BLACK_CONCRETE_SLAB = registerBlockAndItem("cracked_black_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_BLACK)));
    // stairs
    public static final RegistryObject<Block> WORN_WHITE_CONCRETE_STAIRS = registerBlockAndItem("worn_white_concrete_stairs", () -> new StairBlock(WORN_WHITE_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(WORN_WHITE_CONCRETE.get())));
    public static final RegistryObject<Block> WORN_ORANGE_CONCRETE_STAIRS = registerBlockAndItem("worn_orange_concrete_stairs", () -> new StairBlock(WORN_ORANGE_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(WORN_ORANGE_CONCRETE.get())));
    public static final RegistryObject<Block> WORN_MAGENTA_CONCRETE_STAIRS = registerBlockAndItem("worn_magenta_concrete_stairs", () -> new StairBlock(WORN_MAGENTA_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(WORN_MAGENTA_CONCRETE.get())));
    public static final RegistryObject<Block> WORN_LIGHT_BLUE_CONCRETE_STAIRS = registerBlockAndItem("worn_light_blue_concrete_stairs", () -> new StairBlock(WORN_LIGHT_BLUE_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(WORN_LIGHT_BLUE_CONCRETE.get())));
    public static final RegistryObject<Block> WORN_YELLOW_CONCRETE_STAIRS = registerBlockAndItem("worn_yellow_concrete_stairs", () -> new StairBlock(WORN_YELLOW_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(WORN_YELLOW_CONCRETE.get())));
    public static final RegistryObject<Block> WORN_LIME_CONCRETE_STAIRS = registerBlockAndItem("worn_lime_concrete_stairs", () -> new StairBlock(WORN_LIME_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(WORN_LIME_CONCRETE.get())));
    public static final RegistryObject<Block> WORN_PINK_CONCRETE_STAIRS = registerBlockAndItem("worn_pink_concrete_stairs", () -> new StairBlock(WORN_PINK_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(WORN_PINK_CONCRETE.get())));
    public static final RegistryObject<Block> WORN_GRAY_CONCRETE_STAIRS = registerBlockAndItem("worn_gray_concrete_stairs", () -> new StairBlock(WORN_GRAY_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(WORN_GRAY_CONCRETE.get())));
    public static final RegistryObject<Block> WORN_LIGHT_GRAY_CONCRETE_STAIRS = registerBlockAndItem("worn_light_gray_concrete_stairs", () -> new StairBlock(WORN_LIGHT_GRAY_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(WORN_LIGHT_GRAY_CONCRETE.get())));
    public static final RegistryObject<Block> WORN_CYAN_CONCRETE_STAIRS = registerBlockAndItem("worn_cyan_concrete_stairs", () -> new StairBlock(WORN_CYAN_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(WORN_CYAN_CONCRETE.get())));
    public static final RegistryObject<Block> WORN_PURPLE_CONCRETE_STAIRS = registerBlockAndItem("worn_purple_concrete_stairs", () -> new StairBlock(WORN_PURPLE_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(WORN_PURPLE_CONCRETE.get())));
    public static final RegistryObject<Block> WORN_BLUE_CONCRETE_STAIRS = registerBlockAndItem("worn_blue_concrete_stairs", () -> new StairBlock(WORN_BLUE_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(WORN_BLUE_CONCRETE.get())));
    public static final RegistryObject<Block> WORN_BROWN_CONCRETE_STAIRS = registerBlockAndItem("worn_brown_concrete_stairs", () -> new StairBlock(WORN_BROWN_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(WORN_BROWN_CONCRETE.get())));
    public static final RegistryObject<Block> WORN_GREEN_CONCRETE_STAIRS = registerBlockAndItem("worn_green_concrete_stairs", () -> new StairBlock(WORN_GREEN_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(WORN_GREEN_CONCRETE.get())));
    public static final RegistryObject<Block> WORN_RED_CONCRETE_STAIRS = registerBlockAndItem("worn_red_concrete_stairs", () -> new StairBlock(WORN_RED_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(WORN_RED_CONCRETE.get())));
    public static final RegistryObject<Block> WORN_BLACK_CONCRETE_STAIRS = registerBlockAndItem("worn_black_concrete_stairs", () -> new StairBlock(WORN_BLACK_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(WORN_BLACK_CONCRETE.get())));
    public static final RegistryObject<Block> CRACKED_WHITE_CONCRETE_STAIRS = registerBlockAndItem("cracked_white_concrete_stairs", () -> new StairBlock(CRACKED_WHITE_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(CRACKED_WHITE_CONCRETE.get())));
    public static final RegistryObject<Block> CRACKED_ORANGE_CONCRETE_STAIRS = registerBlockAndItem("cracked_orange_concrete_stairs", () -> new StairBlock(CRACKED_ORANGE_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(CRACKED_ORANGE_CONCRETE.get())));
    public static final RegistryObject<Block> CRACKED_MAGENTA_CONCRETE_STAIRS = registerBlockAndItem("cracked_magenta_concrete_stairs", () -> new StairBlock(CRACKED_MAGENTA_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(CRACKED_MAGENTA_CONCRETE.get())));
    public static final RegistryObject<Block> CRACKED_LIGHT_BLUE_CONCRETE_STAIRS = registerBlockAndItem("cracked_light_blue_concrete_stairs", () -> new StairBlock(CRACKED_LIGHT_BLUE_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(CRACKED_LIGHT_BLUE_CONCRETE.get())));
    public static final RegistryObject<Block> CRACKED_YELLOW_CONCRETE_STAIRS = registerBlockAndItem("cracked_yellow_concrete_stairs", () -> new StairBlock(CRACKED_YELLOW_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(CRACKED_YELLOW_CONCRETE.get())));
    public static final RegistryObject<Block> CRACKED_LIME_CONCRETE_STAIRS = registerBlockAndItem("cracked_lime_concrete_stairs", () -> new StairBlock(CRACKED_LIME_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(CRACKED_LIME_CONCRETE.get())));
    public static final RegistryObject<Block> CRACKED_PINK_CONCRETE_STAIRS = registerBlockAndItem("cracked_pink_concrete_stairs", () -> new StairBlock(CRACKED_PINK_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(CRACKED_PINK_CONCRETE.get())));
    public static final RegistryObject<Block> CRACKED_GRAY_CONCRETE_STAIRS = registerBlockAndItem("cracked_gray_concrete_stairs", () -> new StairBlock(CRACKED_GRAY_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(CRACKED_GRAY_CONCRETE.get())));
    public static final RegistryObject<Block> CRACKED_LIGHT_GRAY_CONCRETE_STAIRS = registerBlockAndItem("cracked_light_gray_concrete_stairs", () -> new StairBlock(CRACKED_LIGHT_GRAY_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(CRACKED_LIGHT_GRAY_CONCRETE.get())));
    public static final RegistryObject<Block> CRACKED_CYAN_CONCRETE_STAIRS = registerBlockAndItem("cracked_cyan_concrete_stairs", () -> new StairBlock(CRACKED_CYAN_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(CRACKED_CYAN_CONCRETE.get())));
    public static final RegistryObject<Block> CRACKED_PURPLE_CONCRETE_STAIRS = registerBlockAndItem("cracked_purple_concrete_stairs", () -> new StairBlock(CRACKED_PURPLE_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(CRACKED_PURPLE_CONCRETE.get())));
    public static final RegistryObject<Block> CRACKED_BLUE_CONCRETE_STAIRS = registerBlockAndItem("cracked_blue_concrete_stairs", () -> new StairBlock(CRACKED_BLUE_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(CRACKED_BLUE_CONCRETE.get())));
    public static final RegistryObject<Block> CRACKED_BROWN_CONCRETE_STAIRS = registerBlockAndItem("cracked_brown_concrete_stairs", () -> new StairBlock(CRACKED_BROWN_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(CRACKED_BROWN_CONCRETE.get())));
    public static final RegistryObject<Block> CRACKED_GREEN_CONCRETE_STAIRS = registerBlockAndItem("cracked_green_concrete_stairs", () -> new StairBlock(CRACKED_GREEN_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(CRACKED_GREEN_CONCRETE.get())));
    public static final RegistryObject<Block> CRACKED_RED_CONCRETE_STAIRS = registerBlockAndItem("cracked_red_concrete_stairs", () -> new StairBlock(CRACKED_RED_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(CRACKED_RED_CONCRETE.get())));
    public static final RegistryObject<Block> CRACKED_BLACK_CONCRETE_STAIRS = registerBlockAndItem("cracked_black_concrete_stairs", () -> new StairBlock(CRACKED_BLACK_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.copy(CRACKED_BLACK_CONCRETE.get())));

    // muddy sandstone
    public static final RegistryObject<Block> MUDDY_SANDSTONE = registerBlockAndItem("muddy_sandstone", () -> new Block(CDBlockProperties.StandardRock(0.8F,0.8F)));
    public static final RegistryObject<Block> CUT_MUDDY_SANDSTONE = registerBlockAndItem("cut_muddy_sandstone", () -> new Block(CDBlockProperties.StandardRock(0.8F,0.8F)));
    public static final RegistryObject<Block> SMOOTH_MUDDY_SANDSTONE = registerBlockAndItem("smooth_muddy_sandstone", () -> new Block(CDBlockProperties.StandardRock(0.8F,0.8F)));
    public static final RegistryObject<Block> MUDDY_SANDSTONE_STAIRS = registerBlockAndItem("muddy_sandstone_stairs", () -> new StairBlock(MUDDY_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(MUDDY_SANDSTONE.get())));
    public static final RegistryObject<Block> MUDDY_SANDSTONE_SLAB = registerBlockAndItem("muddy_sandstone_slab", () -> new SlabBlock(CDBlockProperties.StandardRock(0.8F,0.8F)));
    public static final RegistryObject<Block> MUDDY_SANDSTONE_WALL = registerBlockAndItem("muddy_sandstone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(MUDDY_SANDSTONE.get())));
    public static final RegistryObject<Block> CUT_MUDDY_SANDSTONE_SLAB = registerBlockAndItem("cut_muddy_sandstone_slab", () -> new SlabBlock(CDBlockProperties.StandardRock(0.8F,0.8F)));
    public static final RegistryObject<Block> SMOOTH_MUDDY_SANDSTONE_STAIRS = registerBlockAndItem("smooth_muddy_sandstone_stairs", () -> new StairBlock(SMOOTH_MUDDY_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(SMOOTH_MUDDY_SANDSTONE.get())));
    public static final RegistryObject<Block> SMOOTH_MUDDY_SANDSTONE_SLAB = registerBlockAndItem("smooth_muddy_sandstone_slab", () -> new SlabBlock(CDBlockProperties.StandardRock(0.8F,0.8F)));

    // coloured bricks
    public static final RegistryObject<Block> WHITE_BRICKS = registerBlockAndItem("white_bricks", () -> new Block(CDBlockProperties.ColoredRock(MaterialColor.SNOW)));
    public static final RegistryObject<Block> ORANGE_BRICKS = registerBlockAndItem("orange_bricks", () -> new Block(CDBlockProperties.ColoredRock(MaterialColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> MAGENTA_BRICKS = registerBlockAndItem("magenta_bricks", () -> new Block(CDBlockProperties.ColoredRock(MaterialColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> LIGHT_BLUE_BRICKS = registerBlockAndItem("light_blue_bricks", () -> new Block(CDBlockProperties.ColoredRock(MaterialColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> YELLOW_BRICKS = registerBlockAndItem("yellow_bricks", () -> new Block(CDBlockProperties.ColoredRock(MaterialColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> LIME_BRICKS = registerBlockAndItem("lime_bricks", () -> new Block(CDBlockProperties.ColoredRock(MaterialColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> PINK_BRICKS = registerBlockAndItem("pink_bricks", () -> new Block(CDBlockProperties.ColoredRock(MaterialColor.COLOR_PINK)));
    public static final RegistryObject<Block> GRAY_BRICKS = registerBlockAndItem("gray_bricks", () -> new Block(CDBlockProperties.ColoredRock(MaterialColor.COLOR_GRAY)));
    public static final RegistryObject<Block> LIGHT_GRAY_BRICKS = registerBlockAndItem("light_gray_bricks", () -> new Block(CDBlockProperties.ColoredRock(MaterialColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> CYAN_BRICKS = registerBlockAndItem("cyan_bricks", () -> new Block(CDBlockProperties.ColoredRock(MaterialColor.COLOR_CYAN)));
    public static final RegistryObject<Block> PURPLE_BRICKS = registerBlockAndItem("purple_bricks", () -> new Block(CDBlockProperties.ColoredRock(MaterialColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> BLUE_BRICKS = registerBlockAndItem("blue_bricks", () -> new Block(CDBlockProperties.ColoredRock(MaterialColor.COLOR_BLUE)));
    public static final RegistryObject<Block> BROWN_BRICKS = registerBlockAndItem("brown_bricks", () -> new Block(CDBlockProperties.ColoredRock(MaterialColor.COLOR_BROWN)));
    public static final RegistryObject<Block> GREEN_BRICKS = registerBlockAndItem("green_bricks", () -> new Block(CDBlockProperties.ColoredRock(MaterialColor.COLOR_GREEN)));
    public static final RegistryObject<Block> RED_BRICKS = registerBlockAndItem("red_bricks", () -> new Block(CDBlockProperties.ColoredRock(MaterialColor.COLOR_RED)));
    public static final RegistryObject<Block> BLACK_BRICKS = registerBlockAndItem("black_bricks", () -> new Block(CDBlockProperties.ColoredRock(MaterialColor.COLOR_BLACK)));
    // stairs
    public static final RegistryObject<Block> WHITE_BRICKS_STAIRS = registerBlockAndItem("white_bricks_stairs", () -> new StairBlock(WHITE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(WHITE_BRICKS.get())));
    public static final RegistryObject<Block> ORANGE_BRICKS_STAIRS = registerBlockAndItem("orange_bricks_stairs", () -> new StairBlock(ORANGE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(ORANGE_BRICKS.get())));
    public static final RegistryObject<Block> MAGENTA_BRICKS_STAIRS = registerBlockAndItem("magenta_bricks_stairs", () -> new StairBlock(MAGENTA_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(MAGENTA_BRICKS.get())));
    public static final RegistryObject<Block> LIGHT_BLUE_BRICKS_STAIRS = registerBlockAndItem("light_blue_bricks_stairs", () -> new StairBlock(LIGHT_BLUE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(LIGHT_BLUE_BRICKS.get())));
    public static final RegistryObject<Block> YELLOW_BRICKS_STAIRS = registerBlockAndItem("yellow_bricks_stairs", () -> new StairBlock(YELLOW_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(YELLOW_BRICKS.get())));
    public static final RegistryObject<Block> LIME_BRICKS_STAIRS = registerBlockAndItem("lime_bricks_stairs", () -> new StairBlock(LIME_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(LIME_BRICKS.get())));
    public static final RegistryObject<Block> PINK_BRICKS_STAIRS = registerBlockAndItem("pink_bricks_stairs", () -> new StairBlock(PINK_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(PINK_BRICKS.get())));
    public static final RegistryObject<Block> GRAY_BRICKS_STAIRS = registerBlockAndItem("gray_bricks_stairs", () -> new StairBlock(GRAY_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(GRAY_BRICKS.get())));
    public static final RegistryObject<Block> LIGHT_GRAY_BRICKS_STAIRS = registerBlockAndItem("light_gray_bricks_stairs", () -> new StairBlock(LIGHT_GRAY_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(LIGHT_GRAY_BRICKS.get())));
    public static final RegistryObject<Block> CYAN_BRICKS_STAIRS = registerBlockAndItem("cyan_bricks_stairs", () -> new StairBlock(CYAN_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(CYAN_BRICKS.get())));
    public static final RegistryObject<Block> PURPLE_BRICKS_STAIRS = registerBlockAndItem("purple_bricks_stairs", () -> new StairBlock(PURPLE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(PURPLE_BRICKS.get())));
    public static final RegistryObject<Block> BLUE_BRICKS_STAIRS = registerBlockAndItem("blue_bricks_stairs", () -> new StairBlock(BLUE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(BLUE_BRICKS.get())));
    public static final RegistryObject<Block> BROWN_BRICKS_STAIRS = registerBlockAndItem("brown_bricks_stairs", () -> new StairBlock(BROWN_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(BROWN_BRICKS.get())));
    public static final RegistryObject<Block> GREEN_BRICKS_STAIRS = registerBlockAndItem("green_bricks_stairs", () -> new StairBlock(GREEN_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(GREEN_BRICKS.get())));
    public static final RegistryObject<Block> RED_BRICKS_STAIRS = registerBlockAndItem("red_bricks_stairs", () -> new StairBlock(RED_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(RED_BRICKS.get())));
    public static final RegistryObject<Block> BLACK_BRICKS_STAIRS = registerBlockAndItem("black_bricks_stairs", () -> new StairBlock(BLACK_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(BLACK_BRICKS.get())));
    // slabs
    public static final RegistryObject<Block> WHITE_BRICKS_SLAB = registerBlockAndItem("white_bricks_slab", () -> new SlabBlock(CDBlockProperties.ColoredRock(MaterialColor.SNOW)));
    public static final RegistryObject<Block> ORANGE_BRICKS_SLAB = registerBlockAndItem("orange_bricks_slab", () -> new SlabBlock(CDBlockProperties.ColoredRock(MaterialColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> MAGENTA_BRICKS_SLAB = registerBlockAndItem("magenta_bricks_slab", () -> new SlabBlock(CDBlockProperties.ColoredRock(MaterialColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> LIGHT_BLUE_BRICKS_SLAB = registerBlockAndItem("light_blue_bricks_slab", () -> new SlabBlock(CDBlockProperties.ColoredRock(MaterialColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> YELLOW_BRICKS_SLAB = registerBlockAndItem("yellow_bricks_slab", () -> new SlabBlock(CDBlockProperties.ColoredRock(MaterialColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> LIME_BRICKS_SLAB = registerBlockAndItem("lime_bricks_slab", () -> new SlabBlock(CDBlockProperties.ColoredRock(MaterialColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> PINK_BRICKS_SLAB = registerBlockAndItem("pink_bricks_slab", () -> new SlabBlock(CDBlockProperties.ColoredRock(MaterialColor.COLOR_PINK)));
    public static final RegistryObject<Block> GRAY_BRICKS_SLAB = registerBlockAndItem("gray_bricks_slab", () -> new SlabBlock(CDBlockProperties.ColoredRock(MaterialColor.COLOR_GRAY)));
    public static final RegistryObject<Block> LIGHT_GRAY_BRICKS_SLAB = registerBlockAndItem("light_gray_bricks_slab", () -> new SlabBlock(CDBlockProperties.ColoredRock(MaterialColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> CYAN_BRICKS_SLAB = registerBlockAndItem("cyan_bricks_slab", () -> new SlabBlock(CDBlockProperties.ColoredRock(MaterialColor.COLOR_CYAN)));
    public static final RegistryObject<Block> PURPLE_BRICKS_SLAB = registerBlockAndItem("purple_bricks_slab", () -> new SlabBlock(CDBlockProperties.ColoredRock(MaterialColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> BLUE_BRICKS_SLAB = registerBlockAndItem("blue_bricks_slab", () -> new SlabBlock(CDBlockProperties.ColoredRock(MaterialColor.COLOR_BLUE)));
    public static final RegistryObject<Block> BROWN_BRICKS_SLAB = registerBlockAndItem("brown_bricks_slab", () -> new SlabBlock(CDBlockProperties.ColoredRock(MaterialColor.COLOR_BROWN)));
    public static final RegistryObject<Block> GREEN_BRICKS_SLAB = registerBlockAndItem("green_bricks_slab", () -> new SlabBlock(CDBlockProperties.ColoredRock(MaterialColor.COLOR_GREEN)));
    public static final RegistryObject<Block> RED_BRICKS_SLAB = registerBlockAndItem("red_bricks_slab", () -> new SlabBlock(CDBlockProperties.ColoredRock(MaterialColor.COLOR_RED)));
    public static final RegistryObject<Block> BLACK_BRICKS_SLAB = registerBlockAndItem("black_bricks_slab", () -> new SlabBlock(CDBlockProperties.ColoredRock(MaterialColor.COLOR_BLACK)));
    // terracotta bricks
    public static final RegistryObject<Block> TERRACOTTA_BRICKS = registerBlockAndItem("terracotta_bricks", () -> new Block(CDBlockProperties.Terracotta(MaterialColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> WHITE_TERRACOTTA_BRICKS = registerBlockAndItem("white_terracotta_bricks", () -> new Block(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_WHITE)));
    public static final RegistryObject<Block> ORANGE_TERRACOTTA_BRICKS = registerBlockAndItem("orange_terracotta_bricks", () -> new Block(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_ORANGE)));
    public static final RegistryObject<Block> MAGENTA_TERRACOTTA_BRICKS = registerBlockAndItem("magenta_terracotta_bricks", () -> new Block(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_MAGENTA)));
    public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_BRICKS = registerBlockAndItem("light_blue_terracotta_bricks", () -> new Block(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_LIGHT_BLUE)));
    public static final RegistryObject<Block> YELLOW_TERRACOTTA_BRICKS = registerBlockAndItem("yellow_terracotta_bricks", () -> new Block(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_YELLOW)));
    public static final RegistryObject<Block> LIME_TERRACOTTA_BRICKS = registerBlockAndItem("lime_terracotta_bricks", () -> new Block(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_LIGHT_GREEN)));
    public static final RegistryObject<Block> PINK_TERRACOTTA_BRICKS = registerBlockAndItem("pink_terracotta_bricks", () -> new Block(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_PINK)));
    public static final RegistryObject<Block> GRAY_TERRACOTTA_BRICKS = registerBlockAndItem("gray_terracotta_bricks", () -> new Block(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_GRAY)));
    public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_BRICKS = registerBlockAndItem("light_gray_terracotta_bricks", () -> new Block(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_LIGHT_GRAY)));
    public static final RegistryObject<Block> CYAN_TERRACOTTA_BRICKS = registerBlockAndItem("cyan_terracotta_bricks", () -> new Block(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_CYAN)));
    public static final RegistryObject<Block> PURPLE_TERRACOTTA_BRICKS = registerBlockAndItem("purple_terracotta_bricks", () -> new Block(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_PURPLE)));
    public static final RegistryObject<Block> BLUE_TERRACOTTA_BRICKS = registerBlockAndItem("blue_terracotta_bricks", () -> new Block(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_BLUE)));
    public static final RegistryObject<Block> BROWN_TERRACOTTA_BRICKS = registerBlockAndItem("brown_terracotta_bricks", () -> new Block(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_BROWN)));
    public static final RegistryObject<Block> GREEN_TERRACOTTA_BRICKS = registerBlockAndItem("green_terracotta_bricks", () -> new Block(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_GREEN)));
    public static final RegistryObject<Block> RED_TERRACOTTA_BRICKS = registerBlockAndItem("red_terracotta_bricks", () -> new Block(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_RED)));
    public static final RegistryObject<Block> BLACK_TERRACOTTA_BRICKS = registerBlockAndItem("black_terracotta_bricks", () -> new Block(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_BLACK)));
    // stairs
    public static final RegistryObject<Block> TERRACOTTA_BRICKS_STAIRS = registerBlockAndItem("terracotta_bricks_stairs", () -> new StairBlock(TERRACOTTA_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(TERRACOTTA_BRICKS.get())));
    public static final RegistryObject<Block> WHITE_TERRACOTTA_BRICKS_STAIRS = registerBlockAndItem("white_terracotta_bricks_stairs", () -> new StairBlock(WHITE_TERRACOTTA_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(WHITE_TERRACOTTA_BRICKS.get())));
    public static final RegistryObject<Block> ORANGE_TERRACOTTA_BRICKS_STAIRS = registerBlockAndItem("orange_terracotta_bricks_stairs", () -> new StairBlock(ORANGE_TERRACOTTA_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(ORANGE_TERRACOTTA_BRICKS.get())));
    public static final RegistryObject<Block> MAGENTA_TERRACOTTA_BRICKS_STAIRS = registerBlockAndItem("magenta_terracotta_bricks_stairs", () -> new StairBlock(MAGENTA_TERRACOTTA_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(MAGENTA_TERRACOTTA_BRICKS.get())));
    public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_BRICKS_STAIRS = registerBlockAndItem("light_blue_terracotta_bricks_stairs", () -> new StairBlock(LIGHT_BLUE_TERRACOTTA_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(LIGHT_BLUE_TERRACOTTA_BRICKS.get())));
    public static final RegistryObject<Block> YELLOW_TERRACOTTA_BRICKS_STAIRS = registerBlockAndItem("yellow_terracotta_bricks_stairs", () -> new StairBlock(YELLOW_TERRACOTTA_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(YELLOW_TERRACOTTA_BRICKS.get())));
    public static final RegistryObject<Block> LIME_TERRACOTTA_BRICKS_STAIRS = registerBlockAndItem("lime_terracotta_bricks_stairs", () -> new StairBlock(LIME_TERRACOTTA_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(LIME_TERRACOTTA_BRICKS.get())));
    public static final RegistryObject<Block> PINK_TERRACOTTA_BRICKS_STAIRS = registerBlockAndItem("pink_terracotta_bricks_stairs", () -> new StairBlock(PINK_TERRACOTTA_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(PINK_TERRACOTTA_BRICKS.get())));
    public static final RegistryObject<Block> GRAY_TERRACOTTA_BRICKS_STAIRS = registerBlockAndItem("gray_terracotta_bricks_stairs", () -> new StairBlock(GRAY_TERRACOTTA_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(GRAY_TERRACOTTA_BRICKS.get())));
    public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_BRICKS_STAIRS = registerBlockAndItem("light_gray_terracotta_bricks_stairs", () -> new StairBlock(LIGHT_GRAY_TERRACOTTA_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(LIGHT_GRAY_TERRACOTTA_BRICKS.get())));
    public static final RegistryObject<Block> CYAN_TERRACOTTA_BRICKS_STAIRS = registerBlockAndItem("cyan_terracotta_bricks_stairs", () -> new StairBlock(CYAN_TERRACOTTA_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(CYAN_TERRACOTTA_BRICKS.get())));
    public static final RegistryObject<Block> PURPLE_TERRACOTTA_BRICKS_STAIRS = registerBlockAndItem("purple_terracotta_bricks_stairs", () -> new StairBlock(PURPLE_TERRACOTTA_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(PURPLE_TERRACOTTA_BRICKS.get())));
    public static final RegistryObject<Block> BLUE_TERRACOTTA_BRICKS_STAIRS = registerBlockAndItem("blue_terracotta_bricks_stairs", () -> new StairBlock(BLUE_TERRACOTTA_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(BLUE_TERRACOTTA_BRICKS.get())));
    public static final RegistryObject<Block> BROWN_TERRACOTTA_BRICKS_STAIRS = registerBlockAndItem("brown_terracotta_bricks_stairs", () -> new StairBlock(BROWN_TERRACOTTA_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(BROWN_TERRACOTTA_BRICKS.get())));
    public static final RegistryObject<Block> GREEN_TERRACOTTA_BRICKS_STAIRS = registerBlockAndItem("green_terracotta_bricks_stairs", () -> new StairBlock(GREEN_TERRACOTTA_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(GREEN_TERRACOTTA_BRICKS.get())));
    public static final RegistryObject<Block> RED_TERRACOTTA_BRICKS_STAIRS = registerBlockAndItem("red_terracotta_bricks_stairs", () -> new StairBlock(RED_TERRACOTTA_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(RED_TERRACOTTA_BRICKS.get())));
    public static final RegistryObject<Block> BLACK_TERRACOTTA_BRICKS_STAIRS = registerBlockAndItem("black_terracotta_bricks_stairs", () -> new StairBlock(BLACK_TERRACOTTA_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(BLACK_TERRACOTTA_BRICKS.get())));
    // slabs
    public static final RegistryObject<Block> TERRACOTTA_BRICKS_SLAB = registerBlockAndItem("terracotta_bricks_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> WHITE_TERRACOTTA_BRICKS_SLAB = registerBlockAndItem("white_terracotta_bricks_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_WHITE)));
    public static final RegistryObject<Block> ORANGE_TERRACOTTA_BRICKS_SLAB = registerBlockAndItem("orange_terracotta_bricks_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_ORANGE)));
    public static final RegistryObject<Block> MAGENTA_TERRACOTTA_BRICKS_SLAB = registerBlockAndItem("magenta_terracotta_bricks_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_MAGENTA)));
    public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_BRICKS_SLAB = registerBlockAndItem("light_blue_terracotta_bricks_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_LIGHT_BLUE)));
    public static final RegistryObject<Block> YELLOW_TERRACOTTA_BRICKS_SLAB = registerBlockAndItem("yellow_terracotta_bricks_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_YELLOW)));
    public static final RegistryObject<Block> LIME_TERRACOTTA_BRICKS_SLAB = registerBlockAndItem("lime_terracotta_bricks_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_LIGHT_GREEN)));
    public static final RegistryObject<Block> PINK_TERRACOTTA_BRICKS_SLAB = registerBlockAndItem("pink_terracotta_bricks_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_PINK)));
    public static final RegistryObject<Block> GRAY_TERRACOTTA_BRICKS_SLAB = registerBlockAndItem("gray_terracotta_bricks_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_GRAY)));
    public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_BRICKS_SLAB = registerBlockAndItem("light_gray_terracotta_bricks_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_LIGHT_GRAY)));
    public static final RegistryObject<Block> CYAN_TERRACOTTA_BRICKS_SLAB = registerBlockAndItem("cyan_terracotta_bricks_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_CYAN)));
    public static final RegistryObject<Block> PURPLE_TERRACOTTA_BRICKS_SLAB = registerBlockAndItem("purple_terracotta_bricks_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_PURPLE)));
    public static final RegistryObject<Block> BLUE_TERRACOTTA_BRICKS_SLAB = registerBlockAndItem("blue_terracotta_bricks_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_BLUE)));
    public static final RegistryObject<Block> BROWN_TERRACOTTA_BRICKS_SLAB = registerBlockAndItem("brown_terracotta_bricks_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_BROWN)));
    public static final RegistryObject<Block> GREEN_TERRACOTTA_BRICKS_SLAB = registerBlockAndItem("green_terracotta_bricks_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_GREEN)));
    public static final RegistryObject<Block> RED_TERRACOTTA_BRICKS_SLAB = registerBlockAndItem("red_terracotta_bricks_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_RED)));
    public static final RegistryObject<Block> BLACK_TERRACOTTA_BRICKS_SLAB = registerBlockAndItem("black_terracotta_bricks_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_BLACK)));

    // vanilla additions
    // walls
    public static final RegistryObject<Block> POLISHED_DIORITE_WALL = registerBlockAndItem("polished_diorite_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_DIORITE)));
    public static final RegistryObject<Block> POLISHED_ANDESITE_WALL = registerBlockAndItem("polished_andesite_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_ANDESITE)));
    public static final RegistryObject<Block> POLISHED_GRANITE_WALL = registerBlockAndItem("polished_granite_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_GRANITE)));
    public static final RegistryObject<Block> OAK_WOOD_WALL = registerBlockAndItem("oak_wood_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> SPRUCE_WOOD_WALL = registerBlockAndItem("spruce_wood_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_WOOD)));
    public static final RegistryObject<Block> BIRCH_WOOD_WALL = registerBlockAndItem("birch_wood_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_WOOD)));
    public static final RegistryObject<Block> DARK_OAK_WOOD_WALL = registerBlockAndItem("dark_oak_wood_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_WOOD)));
    public static final RegistryObject<Block> ACACIA_WOOD_WALL = registerBlockAndItem("acacia_wood_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));
    public static final RegistryObject<Block> JUNGLE_WOOD_WALL = registerBlockAndItem("jungle_wood_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_WOOD)));
    public static final RegistryObject<Block> WARPED_HYPHAE_WALL = registerBlockAndItem("warped_hyphae_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_HYPHAE)));
    public static final RegistryObject<Block> CRIMSON_HYPHAE_WALL = registerBlockAndItem("crimson_hyphae_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_HYPHAE)));
    // terracotta
    // stairs
    public static final RegistryObject<Block> TERRACOTTA_STAIRS = registerBlockAndItem("terracotta_stairs", () -> new StairBlock(Blocks.TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)));
    public static final RegistryObject<Block> WHITE_TERRACOTTA_STAIRS = registerBlockAndItem("white_terracotta_stairs", () -> new StairBlock(Blocks.WHITE_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA)));
    public static final RegistryObject<Block> ORANGE_TERRACOTTA_STAIRS = registerBlockAndItem("orange_terracotta_stairs", () -> new StairBlock(Blocks.ORANGE_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.ORANGE_TERRACOTTA)));
    public static final RegistryObject<Block> MAGENTA_TERRACOTTA_STAIRS = registerBlockAndItem("magenta_terracotta_stairs", () -> new StairBlock(Blocks.MAGENTA_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.MAGENTA_TERRACOTTA)));
    public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_STAIRS = registerBlockAndItem("light_blue_terracotta_stairs", () -> new StairBlock(Blocks.LIGHT_BLUE_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_TERRACOTTA)));
    public static final RegistryObject<Block> YELLOW_TERRACOTTA_STAIRS = registerBlockAndItem("yellow_terracotta_stairs", () -> new StairBlock(Blocks.YELLOW_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.YELLOW_TERRACOTTA)));
    public static final RegistryObject<Block> LIME_TERRACOTTA_STAIRS = registerBlockAndItem("lime_terracotta_stairs", () -> new StairBlock(Blocks.LIME_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.LIME_TERRACOTTA)));
    public static final RegistryObject<Block> PINK_TERRACOTTA_STAIRS = registerBlockAndItem("pink_terracotta_stairs", () -> new StairBlock(Blocks.PINK_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.PINK_TERRACOTTA)));
    public static final RegistryObject<Block> GRAY_TERRACOTTA_STAIRS = registerBlockAndItem("gray_terracotta_stairs", () -> new StairBlock(Blocks.GRAY_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.GRAY_TERRACOTTA)));
    public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_STAIRS = registerBlockAndItem("light_gray_terracotta_stairs", () -> new StairBlock(Blocks.LIGHT_GRAY_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_TERRACOTTA)));
    public static final RegistryObject<Block> CYAN_TERRACOTTA_STAIRS = registerBlockAndItem("cyan_terracotta_stairs", () -> new StairBlock(Blocks.CYAN_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.CYAN_TERRACOTTA)));
    public static final RegistryObject<Block> PURPLE_TERRACOTTA_STAIRS = registerBlockAndItem("purple_terracotta_stairs", () -> new StairBlock(Blocks.PURPLE_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.PURPLE_TERRACOTTA)));
    public static final RegistryObject<Block> BLUE_TERRACOTTA_STAIRS = registerBlockAndItem("blue_terracotta_stairs", () -> new StairBlock(Blocks.BLUE_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.BLUE_TERRACOTTA)));
    public static final RegistryObject<Block> BROWN_TERRACOTTA_STAIRS = registerBlockAndItem("brown_terracotta_stairs", () -> new StairBlock(Blocks.BROWN_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.BROWN_TERRACOTTA)));
    public static final RegistryObject<Block> GREEN_TERRACOTTA_STAIRS = registerBlockAndItem("green_terracotta_stairs", () -> new StairBlock(Blocks.GREEN_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.GREEN_TERRACOTTA)));
    public static final RegistryObject<Block> RED_TERRACOTTA_STAIRS = registerBlockAndItem("red_terracotta_stairs", () -> new StairBlock(Blocks.RED_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.RED_TERRACOTTA)));
    public static final RegistryObject<Block> BLACK_TERRACOTTA_STAIRS = registerBlockAndItem("black_terracotta_stairs", () -> new StairBlock(Blocks.BLACK_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.BLACK_TERRACOTTA)));
    // slabs
    public static final RegistryObject<Block> TERRACOTTA_SLAB = registerBlockAndItem("terracotta_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> WHITE_TERRACOTTA_SLAB = registerBlockAndItem("white_terracotta_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_WHITE)));
    public static final RegistryObject<Block> ORANGE_TERRACOTTA_SLAB = registerBlockAndItem("orange_terracotta_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_ORANGE)));
    public static final RegistryObject<Block> MAGENTA_TERRACOTTA_SLAB = registerBlockAndItem("magenta_terracotta_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_MAGENTA)));
    public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_SLAB = registerBlockAndItem("light_blue_terracotta_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_LIGHT_BLUE)));
    public static final RegistryObject<Block> YELLOW_TERRACOTTA_SLAB = registerBlockAndItem("yellow_terracotta_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_YELLOW)));
    public static final RegistryObject<Block> LIME_TERRACOTTA_SLAB = registerBlockAndItem("lime_terracotta_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_LIGHT_GREEN)));
    public static final RegistryObject<Block> PINK_TERRACOTTA_SLAB = registerBlockAndItem("pink_terracotta_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_PINK)));
    public static final RegistryObject<Block> GRAY_TERRACOTTA_SLAB = registerBlockAndItem("gray_terracotta_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_GRAY)));
    public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_SLAB = registerBlockAndItem("light_gray_terracotta_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_LIGHT_GRAY)));
    public static final RegistryObject<Block> CYAN_TERRACOTTA_SLAB = registerBlockAndItem("cyan_terracotta_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_CYAN)));
    public static final RegistryObject<Block> PURPLE_TERRACOTTA_SLAB = registerBlockAndItem("purple_terracotta_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_PURPLE)));
    public static final RegistryObject<Block> BLUE_TERRACOTTA_SLAB = registerBlockAndItem("blue_terracotta_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_BLUE)));
    public static final RegistryObject<Block> BROWN_TERRACOTTA_SLAB = registerBlockAndItem("brown_terracotta_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_BROWN)));
    public static final RegistryObject<Block> GREEN_TERRACOTTA_SLAB = registerBlockAndItem("green_terracotta_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_GREEN)));
    public static final RegistryObject<Block> RED_TERRACOTTA_SLAB = registerBlockAndItem("red_terracotta_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_RED)));
    public static final RegistryObject<Block> BLACK_TERRACOTTA_SLAB = registerBlockAndItem("black_terracotta_slab", () -> new SlabBlock(CDBlockProperties.Terracotta(MaterialColor.TERRACOTTA_BLACK)));
    // concrete
    // stairs
    public static final RegistryObject<Block> WHITE_CONCRETE_STAIRS = registerBlockAndItem("white_concrete_stairs", () -> new StairBlock(Blocks.WHITE_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
    public static final RegistryObject<Block> ORANGE_CONCRETE_STAIRS = registerBlockAndItem("orange_concrete_stairs", () -> new StairBlock(Blocks.ORANGE_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)));
    public static final RegistryObject<Block> MAGENTA_CONCRETE_STAIRS = registerBlockAndItem("magenta_concrete_stairs", () -> new StairBlock(Blocks.MAGENTA_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)));
    public static final RegistryObject<Block> LIGHT_BLUE_CONCRETE_STAIRS = registerBlockAndItem("light_blue_concrete_stairs", () -> new StairBlock(Blocks.LIGHT_BLUE_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final RegistryObject<Block> YELLOW_CONCRETE_STAIRS = registerBlockAndItem("yellow_concrete_stairs", () -> new StairBlock(Blocks.YELLOW_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));
    public static final RegistryObject<Block> LIME_CONCRETE_STAIRS = registerBlockAndItem("lime_concrete_stairs", () -> new StairBlock(Blocks.LIME_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)));
    public static final RegistryObject<Block> PINK_CONCRETE_STAIRS = registerBlockAndItem("pink_concrete_stairs", () -> new StairBlock(Blocks.PINK_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)));
    public static final RegistryObject<Block> GRAY_CONCRETE_STAIRS = registerBlockAndItem("gray_concrete_stairs", () -> new StairBlock(Blocks.GRAY_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));
    public static final RegistryObject<Block> LIGHT_GRAY_CONCRETE_STAIRS = registerBlockAndItem("light_gray_concrete_stairs", () -> new StairBlock(Blocks.LIGHT_GRAY_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final RegistryObject<Block> CYAN_CONCRETE_STAIRS = registerBlockAndItem("cyan_concrete_stairs", () -> new StairBlock(Blocks.CYAN_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)));
    public static final RegistryObject<Block> PURPLE_CONCRETE_STAIRS = registerBlockAndItem("purple_concrete_stairs", () -> new StairBlock(Blocks.PURPLE_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)));
    public static final RegistryObject<Block> BLUE_CONCRETE_STAIRS = registerBlockAndItem("blue_concrete_stairs", () -> new StairBlock(Blocks.BLUE_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)));
    public static final RegistryObject<Block> BROWN_CONCRETE_STAIRS = registerBlockAndItem("brown_concrete_stairs", () -> new StairBlock(Blocks.BROWN_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)));
    public static final RegistryObject<Block> GREEN_CONCRETE_STAIRS = registerBlockAndItem("green_concrete_stairs", () -> new StairBlock(Blocks.GREEN_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)));
    public static final RegistryObject<Block> RED_CONCRETE_STAIRS = registerBlockAndItem("red_concrete_stairs", () -> new StairBlock(Blocks.RED_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)));
    public static final RegistryObject<Block> BLACK_CONCRETE_STAIRS = registerBlockAndItem("black_concrete_stairs", () -> new StairBlock(Blocks.BLACK_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)));
    // slabs
    public static final RegistryObject<Block> WHITE_CONCRETE_SLAB = registerBlockAndItem("white_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.SNOW)));
    public static final RegistryObject<Block> ORANGE_CONCRETE_SLAB = registerBlockAndItem("orange_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> MAGENTA_CONCRETE_SLAB = registerBlockAndItem("magenta_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> LIGHT_BLUE_CONCRETE_SLAB = registerBlockAndItem("light_blue_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> YELLOW_CONCRETE_SLAB = registerBlockAndItem("yellow_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> LIME_CONCRETE_SLAB = registerBlockAndItem("lime_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> PINK_CONCRETE_SLAB = registerBlockAndItem("pink_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_PINK)));
    public static final RegistryObject<Block> GRAY_CONCRETE_SLAB = registerBlockAndItem("gray_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_GRAY)));
    public static final RegistryObject<Block> LIGHT_GRAY_CONCRETE_SLAB = registerBlockAndItem("light_gray_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> CYAN_CONCRETE_SLAB = registerBlockAndItem("cyan_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_CYAN)));
    public static final RegistryObject<Block> PURPLE_CONCRETE_SLAB = registerBlockAndItem("purple_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> BLUE_CONCRETE_SLAB = registerBlockAndItem("blue_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_BLUE)));
    public static final RegistryObject<Block> BROWN_CONCRETE_SLAB = registerBlockAndItem("brown_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_BROWN)));
    public static final RegistryObject<Block> GREEN_CONCRETE_SLAB = registerBlockAndItem("green_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_GREEN)));
    public static final RegistryObject<Block> RED_CONCRETE_SLAB = registerBlockAndItem("red_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_RED)));
    public static final RegistryObject<Block> BLACK_CONCRETE_SLAB = registerBlockAndItem("black_concrete_slab", () -> new SlabBlock(CDBlockProperties.Concrete(MaterialColor.COLOR_BLACK)));

    public static RegistryObject<Block> registerBlockAndItem(String name, Supplier<Block> block){
        RegistryObject<Block> blockObj = reg.register(name, block);
        CDItems.reg.register(name, () -> new BlockItem(blockObj.get(), new Item.Properties().tab(CityDecor.TAB)));
        return blockObj;
    }

    public static RegistryObject<Block> registerBlockAndItem(String name, Supplier<Block> block, int stacksize){
        RegistryObject<Block> blockObj = reg.register(name, block);
        CDItems.reg.register(name, () -> new BlockItem(blockObj.get(), new Item.Properties().stacksTo(stacksize).tab(CityDecor.TAB)));
        return blockObj;
    }

    public static RegistryObject<Block> registerBlockAndItem(String name, Supplier<Block> block, boolean isIronScaffolding){
        RegistryObject<Block> blockObj = reg.register(name, block);
        if (isIronScaffolding) {
            CDItems.reg.register(name, () -> new IronScaffoldingItem(blockObj.get(), new Item.Properties().tab(CityDecor.TAB)));
        } else {
            CDItems.reg.register(name, () -> new SteelScaffoldingItem(blockObj.get(), new Item.Properties().tab(CityDecor.TAB)));
        }
        return blockObj;
    }
}