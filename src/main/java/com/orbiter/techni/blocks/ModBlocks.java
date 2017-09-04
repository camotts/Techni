package com.orbiter.techni.blocks;

import com.orbiter.techni.blocks.Counter.Counter;
import com.orbiter.techni.blocks.Generator;
import com.orbiter.techni.blocks.Timer.Timer;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Cam on 9/3/2017.
 */
public class ModBlocks {

    @GameRegistry.ObjectHolder("techni:generator")
    public static Generator generator;

    @GameRegistry.ObjectHolder("techni:counter")
    public static Counter counter;

    @GameRegistry.ObjectHolder("techni:timer")
    public static Timer timer;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        //counter.initModel();
        timer.initModel();
    }
}
