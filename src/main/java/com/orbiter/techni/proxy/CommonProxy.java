package com.orbiter.techni.proxy;

import com.orbiter.techni.Config;
import com.orbiter.techni.blocks.ModBlocks;
import com.orbiter.techni.Reference;
import com.orbiter.techni.blocks.*;
import com.orbiter.techni.blocks.Counter.Counter;
import com.orbiter.techni.blocks.Counter.CounterTileEntity;
import com.orbiter.techni.blocks.Timer.Timer;
import com.orbiter.techni.blocks.Timer.TimerTileEntity;
import com.orbiter.techni.compatability.CompatabilityHandler;
import com.orbiter.techni.items.EnrichedIron;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.io.File;

/**
 * Created by Cam on 9/3/2017.
 */
@Mod.EventBusSubscriber()
public class CommonProxy {

    public static Configuration config;

    public void preInit(FMLPreInitializationEvent e) {
        File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "techni.cfg"));
        Config.readConfig();

        CompatabilityHandler.registerTOP();
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
        if (config.hasChanged()) {
            config.save();
        }
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new Generator());

        event.getRegistry().register(new Counter());
        GameRegistry.registerTileEntity(CounterTileEntity.class, Reference.MODID + ".counter");

        event.getRegistry().register(new Timer());
        GameRegistry.registerTileEntity(TimerTileEntity.class, Reference.MODID+".timer");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new EnrichedIron());

        event.getRegistry().register(new ItemBlock(ModBlocks.generator).setRegistryName(ModBlocks.generator.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.counter).setRegistryName(ModBlocks.counter.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.timer).setRegistryName(ModBlocks.timer.getRegistryName()));
    }
}
