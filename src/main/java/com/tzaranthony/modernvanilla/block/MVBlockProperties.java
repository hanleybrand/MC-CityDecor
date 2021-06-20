package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class MVBlockProperties {
    public static AbstractBlock.Properties Block(Material material, SoundType sound, float hardness, float resistance) {
        return AbstractBlock.Properties.of(material)
                .sound(sound)
                .strength(hardness, resistance);
    }

    public static AbstractBlock.Properties ColoredBlock(Material material, MaterialColor color, SoundType sound, float hardness, float resistance) {
        return AbstractBlock.Properties.of(material, color)
                .sound(sound)
                .strength(hardness, resistance);
    }

    // metals
    public static AbstractBlock.Properties StandardMetal(SoundType sound, int harvestLevel, float hardness, float resistance) {
        return Block(Material.METAL, sound, hardness, resistance)
                .harvestLevel(harvestLevel)
                .requiresCorrectToolForDrops()
                .harvestTool(ToolType.PICKAXE);
    }

    public static AbstractBlock.Properties StandardMetal(int harvestLevel, float hardness, float resistance) {
        return StandardMetal(SoundType.METAL, harvestLevel, hardness, resistance);
    }

    public static AbstractBlock.Properties NetheriteSoundMetal(int harvestLevel, float hardness, float resistance) {
        return StandardMetal(SoundType.NETHERITE_BLOCK, harvestLevel, hardness, resistance);
    }

    public static AbstractBlock.Properties StandardNetheriteSoundMetal() {
        return NetheriteSoundMetal(3, 4.0F, 15.0F);
    }

    public static AbstractBlock.Properties NonFullMetal(int harvestLevel, float hardness, float resistance) {
        return StandardMetal(harvestLevel, hardness, resistance)
                .noOcclusion();
    }

    // wood
    public static AbstractBlock.Properties Cardboard(float hardnessAndResistance) {
        return Block(Material.WOOD, SoundType.WOOD, hardnessAndResistance, hardnessAndResistance)
                .noOcclusion()
                .harvestTool(ToolType.AXE);
    }

    // rocks
    public static AbstractBlock.Properties StandardRock(float hardness, float resistance) {
        return Block(Material.STONE, SoundType.STONE, hardness, resistance)
                .requiresCorrectToolForDrops()
                .harvestTool(ToolType.PICKAXE);
    }

    public static AbstractBlock.Properties StandardRock() {
        return StandardRock(2.0F, 6.0F);
    }

    // rocks with material color
    public static AbstractBlock.Properties ColoredRock(MaterialColor color, float hardness, float resistance) {
        return ColoredBlock(Material.STONE, color, SoundType.STONE, hardness, resistance)
                .requiresCorrectToolForDrops()
                .harvestTool(ToolType.PICKAXE);
    }

    public static AbstractBlock.Properties Concrete(MaterialColor color) {
        return ColoredRock(color, 1.8F, 1.8F);
    }

    public static AbstractBlock.Properties Terracotta(MaterialColor color) {
        return ColoredRock(color, 1.8F, 1.8F);
    }

    public static AbstractBlock.Properties ColoredRock(MaterialColor color) {
        return ColoredRock(color, 2.0F, 6.0F);
    }

    // concrete powder
    public static AbstractBlock.Properties ConcretePowder(MaterialColor color) {
        return ColoredBlock(Material.SAND, color, SoundType.SAND, 0.5F, 0.5F);
    }

    public static AbstractBlock.Properties MetalLightBlock(int light) {
        return StandardMetal(SoundType.GLASS, 1, 1.5F, 9.0F)
                .lightLevel((state) -> {
                    return light;
                });
    }

    // uniques
    public static AbstractBlock.Properties BarbedWire() {
        return Block(Material.DECORATION, SoundType.CHAIN, 20, 0.5F)
                .noCollission()
                .noOcclusion();
    }

    public static AbstractBlock.Properties Scaffolding() {
        return AbstractBlock.Properties.of(Material.DECORATION, MaterialColor.METAL)
                .noCollission()
                .sound(SoundType.SCAFFOLDING)
                .dynamicShape();
    }

    public static AbstractBlock.Properties EndRod() {
        return AbstractBlock.Properties.of(Material.DECORATION)
                .instabreak()
                .lightLevel((p_235454_0_) -> {
                    return 14;
                })
                .sound(SoundType.WOOD)
                .noOcclusion();
    }

    public static AbstractBlock.Properties NeonLight(int light) {
        return AbstractBlock.Properties.of(Material.DECORATION)
                .harvestLevel(0)
                .strength(0.1F, 9.0F)
                .sound(SoundType.GLASS)
                .lightLevel((p_235454_0_) -> {
                    return light;
                })
                .noOcclusion();
    }

    // iron bars
    public static AbstractBlock.Properties IronBarLike(MaterialColor color, SoundType sound, float hardness, float resistance) {
        return ColoredBlock(Material.METAL, color, sound, hardness, resistance)
                .requiresCorrectToolForDrops()
                .harvestTool(ToolType.PICKAXE)
                .noOcclusion();
    }

    public static AbstractBlock.Properties ChainFence() {
        return IronBarLike(MaterialColor.COLOR_GRAY, SoundType.CHAIN, 5.0F, 6.0F);
    }

    // doors
    public static AbstractBlock.Properties Door(Material material, MaterialColor color, SoundType sound, float HardnessAndResistance) {
        return ColoredBlock(material, color, sound, HardnessAndResistance, HardnessAndResistance)
                .noOcclusion();
    }

    public static AbstractBlock.Properties MetalDoor(int harvestLevel, float HardnessAndResistance) {
        return Door(Material.METAL, MaterialColor.METAL, SoundType.METAL, HardnessAndResistance)
                .harvestLevel(harvestLevel)
                .requiresCorrectToolForDrops()
                .harvestTool(ToolType.PICKAXE);
    }

    public static AbstractBlock.Properties GlassDoor(MaterialColor color) {
        return Door(Material.GLASS, color, SoundType.GLASS, 0.3F)
                .isValidSpawn(MVBlockProperties::never)
                .isRedstoneConductor(MVBlockProperties::never)
                .isSuffocating(MVBlockProperties::never)
                .isViewBlocking(MVBlockProperties::never);
    }

    // trapdoors
    public static AbstractBlock.Properties Trapdoor(Material material, MaterialColor color, SoundType sound, float HardnessAndResistance) {
        return Door(material, color, sound, HardnessAndResistance)
                .isValidSpawn(MVBlockProperties::never);
    }

    public static AbstractBlock.Properties MetalTrapdoor() {
        return Trapdoor(Material.METAL, MaterialColor.METAL, SoundType.METAL, 5.0F)
                .requiresCorrectToolForDrops()
                .harvestTool(ToolType.PICKAXE);
    }

    public static AbstractBlock.Properties GlassTrapdoor(MaterialColor color) {
        return Trapdoor(Material.GLASS, color, SoundType.GLASS, 0.3F)
                .isRedstoneConductor(MVBlockProperties::never)
                .isSuffocating(MVBlockProperties::never)
                .isViewBlocking(MVBlockProperties::never);
    }

    private static Boolean never(BlockState p_235427_0_, IBlockReader p_235427_1_, BlockPos p_235427_2_, EntityType<?> p_235427_3_) {
        return (boolean) false;
    }

    private static boolean never(BlockState p_235436_0_, IBlockReader p_235436_1_, BlockPos p_235436_2_) {
        return false;
    }
}
