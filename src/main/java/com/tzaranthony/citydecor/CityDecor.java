package com.tzaranthony.citydecor;

import com.tzaranthony.citydecor.block.CDBlockRender;
import com.tzaranthony.citydecor.util.CDBlocks;
import com.tzaranthony.citydecor.util.CDItems;
import com.tzaranthony.citydecor.util.CDTileEntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("citydecor")
public class CityDecor {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "citydecor";

    public CityDecor() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::ClientSetup);

        CDBlocks.reg.register(FMLJavaModLoadingContext.get().getModEventBus());
        CDItems.reg.register(FMLJavaModLoadingContext.get().getModEventBus());
        CDTileEntityType.reg.register(FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(this);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void ClientSetup(final FMLClientSetupEvent event) {
        CDBlockRender.renderBlocks();
    }


    public static final CreativeModeTab TAB = new CreativeModeTab("CityDecor") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CDBlocks.SHIPPING_PALLET.get());
        }
    };
}