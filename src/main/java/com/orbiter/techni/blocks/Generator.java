package com.orbiter.techni.blocks;

import com.orbiter.techni.Reference;
import com.orbiter.techni.Techni;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import scala.tools.nsc.backend.icode.analysis.TypeFlowAnalysis;

/**
 * Created by Cam on 9/3/2017.
 */
public class Generator extends Block {
    public Generator() {
        super(Material.IRON);
        setUnlocalizedName(Reference.MODID + ".generator");
        setRegistryName("generator");
    }
}
