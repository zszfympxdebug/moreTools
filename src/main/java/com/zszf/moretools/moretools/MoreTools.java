package com.zszf.moretools.moretools;

import com.mojang.logging.LogUtils;
import com.zszf.moretools.moretools.items.moreToolItems;
import com.zszf.moretools.moretools.setup.ModSetup;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MoreTools.MOD_ID)
public class MoreTools {
    public static final String MOD_ID = "moreTools";

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public MoreTools(){
        ModSetup.setup();
        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
        modbus.addListener(ModSetup::init);
        moreToolItems.ITEMS.register(modbus);
    }
}
