package com.orbiter.techni;

import com.orbiter.techni.blocks.Counter;
import com.orbiter.techni.blocks.Generator;
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

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        //counter.initModel();
    }
}
