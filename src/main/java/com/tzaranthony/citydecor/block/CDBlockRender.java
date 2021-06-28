package com.tzaranthony.citydecor.block;

import com.tzaranthony.citydecor.util.CDBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

public class CDBlockRender {
    public static void renderBlocks() {
        RenderType cutout = RenderType.cutoutMipped();
        RenderTypeLookup.setRenderLayer(CDBlocks.STEEL_TRAPDOOR, cutout);
        RenderTypeLookup.setRenderLayer(CDBlocks.CHAIN_LINK_FENCE, cutout);
        RenderTypeLookup.setRenderLayer(CDBlocks.BARBED_WIRE_ROLL, cutout);
        RenderTypeLookup.setRenderLayer(CDBlocks.BARBED_WIRE_EDGING, cutout);
        RenderTypeLookup.setRenderLayer(CDBlocks.STEEL_DOOR, cutout);
        RenderTypeLookup.setRenderLayer(CDBlocks.IRON_FRAME, cutout);
        RenderTypeLookup.setRenderLayer(CDBlocks.STEEL_FRAME, cutout);

        RenderType clear = RenderType.translucent();
        RenderTypeLookup.setRenderLayer(CDBlocks.GLASS_TRAPDOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.WHITE_STAINED_GLASS_TRAPDOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.ORANGE_STAINED_GLASS_TRAPDOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.MAGENTA_STAINED_GLASS_TRAPDOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.LIGHT_BLUE_STAINED_GLASS_TRAPDOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.YELLOW_STAINED_GLASS_TRAPDOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.LIME_STAINED_GLASS_TRAPDOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.PINK_STAINED_GLASS_TRAPDOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.GRAY_STAINED_GLASS_TRAPDOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.LIGHT_GRAY_STAINED_GLASS_TRAPDOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.CYAN_STAINED_GLASS_TRAPDOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.PURPLE_STAINED_GLASS_TRAPDOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.BLUE_STAINED_GLASS_TRAPDOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.BROWN_STAINED_GLASS_TRAPDOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.GREEN_STAINED_GLASS_TRAPDOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.RED_STAINED_GLASS_TRAPDOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.BLACK_STAINED_GLASS_TRAPDOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.GLASS_DOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.WHITE_STAINED_GLASS_DOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.ORANGE_STAINED_GLASS_DOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.MAGENTA_STAINED_GLASS_DOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.LIGHT_BLUE_STAINED_GLASS_DOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.YELLOW_STAINED_GLASS_DOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.LIME_STAINED_GLASS_DOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.PINK_STAINED_GLASS_DOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.GRAY_STAINED_GLASS_DOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.LIGHT_GRAY_STAINED_GLASS_DOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.CYAN_STAINED_GLASS_DOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.PURPLE_STAINED_GLASS_DOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.BLUE_STAINED_GLASS_DOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.BROWN_STAINED_GLASS_DOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.GREEN_STAINED_GLASS_DOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.RED_STAINED_GLASS_DOOR, clear);
        RenderTypeLookup.setRenderLayer(CDBlocks.BLACK_STAINED_GLASS_DOOR, clear);
    }
}
