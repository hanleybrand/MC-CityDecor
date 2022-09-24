package com.tzaranthony.citydecor.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class CDBlockProperties {
    public static BlockBehaviour.Properties Block(Material material, SoundType sound, float hardness, float resistance) {
        return BlockBehaviour.Properties.of(material)
                .sound(sound)
                .strength(hardness, resistance);
    }

    public static BlockBehaviour.Properties ColoredBlock(Material material, MaterialColor color, SoundType sound, float hardness, float resistance) {
        return BlockBehaviour.Properties.of(material, color)
                .sound(sound)
                .strength(hardness, resistance);
    }

    // metals
    public static BlockBehaviour.Properties StandardMetal(SoundType sound, float hardness, float resistance) {
        return Block(Material.METAL, sound, hardness, resistance)
                .requiresCorrectToolForDrops();
    }

    public static BlockBehaviour.Properties StandardMetal(float hardness, float resistance) {
        return StandardMetal(SoundType.METAL, hardness, resistance);
    }

    public static BlockBehaviour.Properties NetheriteSoundMetal(float hardness, float resistance) {
        return StandardMetal(SoundType.NETHERITE_BLOCK, hardness, resistance);
    }

    public static BlockBehaviour.Properties StandardNetheriteSoundMetal() {
        return NetheriteSoundMetal(4.0F, 15.0F);
    }

    public static BlockBehaviour.Properties NonFullMetal(float hardness, float resistance) {
        return StandardMetal(hardness, resistance)
                .noOcclusion();
    }

    // wood
    public static BlockBehaviour.Properties Cardboard(float hardnessAndResistance) {
        return Block(Material.WOOD, SoundType.WOOD, hardnessAndResistance, hardnessAndResistance)
                .noOcclusion();
    }

    // rocks
    public static BlockBehaviour.Properties StandardRock(float hardness, float resistance) {
        return Block(Material.STONE, SoundType.STONE, hardness, resistance)
                .requiresCorrectToolForDrops();
    }

    public static BlockBehaviour.Properties StandardRock() {
        return StandardRock(2.0F, 6.0F);
    }

    // rocks with material color
    public static BlockBehaviour.Properties ColoredRock(MaterialColor color, float hardness, float resistance) {
        return ColoredBlock(Material.STONE, color, SoundType.STONE, hardness, resistance)
                .requiresCorrectToolForDrops();
    }

    public static BlockBehaviour.Properties Concrete(MaterialColor color) {
        return ColoredRock(color, 1.8F, 1.8F);
    }

    public static BlockBehaviour.Properties Terracotta(MaterialColor color) {
        return ColoredRock(color, 1.8F, 1.8F);
    }

    public static BlockBehaviour.Properties ColoredRock(MaterialColor color) {
        return ColoredRock(color, 2.0F, 6.0F);
    }

    // concrete powder
    public static BlockBehaviour.Properties ConcretePowder(MaterialColor color) {
        return ColoredBlock(Material.SAND, color, SoundType.SAND, 0.5F, 0.5F);
    }

    public static BlockBehaviour.Properties MetalLightBlock(int light) {
        return StandardMetal(SoundType.GLASS, 1.5F, 9.0F)
                .lightLevel((state) -> {
                    return light;
                });
    }

    // uniques
    public static BlockBehaviour.Properties BarbedWire() {
        return Block(Material.DECORATION, SoundType.CHAIN, 20, 0.5F)
                .noCollission()
                .noOcclusion();
    }

    public static BlockBehaviour.Properties Scaffolding() {
        return BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.METAL)
                .noCollission()
                .sound(SoundType.SCAFFOLDING)
                .dynamicShape();
    }

    public static BlockBehaviour.Properties EndRod() {
        return BlockBehaviour.Properties.of(Material.DECORATION)
                .instabreak()
                .lightLevel((p_235454_0_) -> {
                    return 14;
                })
                .sound(SoundType.WOOD)
                .noOcclusion();
    }

    public static BlockBehaviour.Properties NeonLight(int light) {
        return BlockBehaviour.Properties.of(Material.DECORATION)
                .strength(0.1F, 9.0F)
                .sound(SoundType.GLASS)
                .lightLevel((p_235454_0_) -> {
                    return light;
                })
                .noOcclusion();
    }

    // iron bars
    public static BlockBehaviour.Properties IronBarLike(MaterialColor color, SoundType sound, float hardness, float resistance) {
        return ColoredBlock(Material.METAL, color, sound, hardness, resistance)
                .requiresCorrectToolForDrops()
                .noOcclusion();
    }

    public static BlockBehaviour.Properties ChainFence() {
        return IronBarLike(MaterialColor.COLOR_GRAY, SoundType.CHAIN, 5.0F, 6.0F);
    }

    // doors
    public static BlockBehaviour.Properties Door(Material material, MaterialColor color, SoundType sound, float HardnessAndResistance) {
        return ColoredBlock(material, color, sound, HardnessAndResistance, HardnessAndResistance)
                .noOcclusion();
    }

    public static BlockBehaviour.Properties MetalDoor(float HardnessAndResistance) {
        return Door(Material.METAL, MaterialColor.METAL, SoundType.METAL, HardnessAndResistance)
                .requiresCorrectToolForDrops();
    }

    public static BlockBehaviour.Properties GlassDoor(MaterialColor color) {
        return Door(Material.GLASS, color, SoundType.GLASS, 0.3F)
                .isValidSpawn(CDBlockProperties::never)
                .isRedstoneConductor(CDBlockProperties::never)
                .isSuffocating(CDBlockProperties::never)
                .isViewBlocking(CDBlockProperties::never);
    }

    // trapdoors
    public static BlockBehaviour.Properties Trapdoor(Material material, MaterialColor color, SoundType sound, float HardnessAndResistance) {
        return Door(material, color, sound, HardnessAndResistance)
                .isValidSpawn(CDBlockProperties::never);
    }

    public static BlockBehaviour.Properties MetalTrapdoor() {
        return Trapdoor(Material.METAL, MaterialColor.METAL, SoundType.METAL, 5.0F)
                .requiresCorrectToolForDrops();
    }

    public static BlockBehaviour.Properties GlassTrapdoor(MaterialColor color) {
        return Trapdoor(Material.GLASS, color, SoundType.GLASS, 0.3F)
                .isRedstoneConductor(CDBlockProperties::never)
                .isSuffocating(CDBlockProperties::never)
                .isViewBlocking(CDBlockProperties::never);
    }

    private static Boolean never(BlockState p_235427_0_, BlockGetter p_235427_1_, BlockPos p_235427_2_, EntityType<?> p_235427_3_) {
        return (boolean) false;
    }

    private static boolean never(BlockState p_235436_0_, BlockGetter p_235436_1_, BlockPos p_235436_2_) {
        return false;
    }
}