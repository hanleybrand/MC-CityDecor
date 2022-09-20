package com.tzaranthony.citydecor;

import com.tzaranthony.citydecor.util.CDBlocks;
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
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }


    public static final CreativeModeTab TAB = new CreativeModeTab("CityDecor") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CDBlocks.SHIPPING_PALLET);
        }
    };
}