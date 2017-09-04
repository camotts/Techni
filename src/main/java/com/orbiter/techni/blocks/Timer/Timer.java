package com.orbiter.techni.blocks.Timer;

import com.orbiter.techni.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Cam on 9/4/2017.
 */
public class Timer extends Block implements ITileEntityProvider {
    public static final PropertyBool LIT = PropertyBool.create("lit");

    public Timer() {
        super(Material.ROCK);
        setUnlocalizedName(Reference.MODID + ".timer");
        setRegistryName("timer");
    }

    @SideOnly(Side.CLIENT)
    public void initModel(){
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TimerTileEntity();
    }

    private TimerTileEntity getTE(IBlockAccess world, BlockPos pos) {
        return (TimerTileEntity) world.getTileEntity(pos);
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
        return state.withProperty(LIT, getTE(world, pos).isLit());
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer (this, LIT);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return 0;
    }
}
