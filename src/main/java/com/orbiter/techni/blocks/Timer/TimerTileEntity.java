package com.orbiter.techni.blocks.Timer;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.List;

/**
 * Created by Cam on 9/4/2017.
 */
public class TimerTileEntity extends TileEntity implements ITickable{
    private boolean lit = false;

    private int counter = 0;

    private int delayCounter = 10;
    private int lastCount = 0;

    public boolean isLit() {
        return lit;
    }

    @Override
    public void update() {
        if (world.isRemote) {
            updateCounter();
            counter -= lastCount * 3;
        }
        if (counter <= 0) {
            lit =! lit;
            counter = 400;
            world.markBlockRangeForRenderUpdate(getPos(), getPos());
        }
    }

    private void updateCounter() {
        delayCounter--;
        if (delayCounter <= 0 ){
            List<EntityLivingBase> list = world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(getPos().add(-10, -10, -10), getPos().add(10,10,10)));
            delayCounter = 10;
            lastCount = list.size();
        }
    }
}
