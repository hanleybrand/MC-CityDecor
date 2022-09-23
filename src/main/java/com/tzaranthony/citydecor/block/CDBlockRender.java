package com.tzaranthony.citydecor.block;

import com.tzaranthony.citydecor.util.CDBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;

public class CDBlockRender {
    public static void renderBlocks() {
        RenderType cutout = RenderType.cutoutMipped();
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.STEEL_TRAPDOOR.get(), cutout);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.CHAIN_LINK_FENCE.get(), cutout);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.BARBED_WIRE_ROLL.get(), cutout);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.BARBED_WIRE_EDGING.get(), cutout);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.STEEL_DOOR.get(), cutout);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.IRON_FRAME.get(), cutout);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.STEEL_FRAME.get(), cutout);

        RenderType clear = RenderType.translucent();
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.GLASS_TRAPDOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.WHITE_STAINED_GLASS_TRAPDOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.ORANGE_STAINED_GLASS_TRAPDOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.MAGENTA_STAINED_GLASS_TRAPDOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.LIGHT_BLUE_STAINED_GLASS_TRAPDOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.YELLOW_STAINED_GLASS_TRAPDOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.LIME_STAINED_GLASS_TRAPDOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.PINK_STAINED_GLASS_TRAPDOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.GRAY_STAINED_GLASS_TRAPDOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.LIGHT_GRAY_STAINED_GLASS_TRAPDOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.CYAN_STAINED_GLASS_TRAPDOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.PURPLE_STAINED_GLASS_TRAPDOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.BLUE_STAINED_GLASS_TRAPDOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.BROWN_STAINED_GLASS_TRAPDOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.GREEN_STAINED_GLASS_TRAPDOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.RED_STAINED_GLASS_TRAPDOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.BLACK_STAINED_GLASS_TRAPDOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.GLASS_DOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.WHITE_STAINED_GLASS_DOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.ORANGE_STAINED_GLASS_DOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.MAGENTA_STAINED_GLASS_DOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.LIGHT_BLUE_STAINED_GLASS_DOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.YELLOW_STAINED_GLASS_DOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.LIME_STAINED_GLASS_DOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.PINK_STAINED_GLASS_DOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.GRAY_STAINED_GLASS_DOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.LIGHT_GRAY_STAINED_GLASS_DOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.CYAN_STAINED_GLASS_DOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.PURPLE_STAINED_GLASS_DOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.BLUE_STAINED_GLASS_DOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.BROWN_STAINED_GLASS_DOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.GREEN_STAINED_GLASS_DOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.RED_STAINED_GLASS_DOOR.get(), clear);
        ItemBlockRenderTypes.setRenderLayer(CDBlocks.BLACK_STAINED_GLASS_DOOR.get(), clear);
    }
}