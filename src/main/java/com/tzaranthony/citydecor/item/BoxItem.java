package com.tzaranthony.citydecor.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class BoxItem extends BlockItem {

    public BoxItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public boolean canFitInsideContainerItems() {
        return false;
    }
}