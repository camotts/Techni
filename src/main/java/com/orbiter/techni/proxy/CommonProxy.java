package com.orbiter.techni.proxy;

import com.orbiter.techni.Config;
import com.orbiter.techni.ModBlocks;
import com.orbiter.techni.Reference;
import com.orbiter.techni.Techni;
import com.orbiter.techni.blocks.Counter;
import com.orbiter.techni.blocks.CounterTileEntity;
import com.orbiter.techni.blocks.Generator;
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
import org.apache.logging.log4j.Level;

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
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new EnrichedIron());

        event.getRegistry().register(new ItemBlock(ModBlocks.generator).setRegistryName(ModBlocks.generator.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.counter).setRegistryName(ModBlocks.counter.getRegistryName()));
    }
}
