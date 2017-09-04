package com.orbiter.techni.compatability;

import com.orbiter.techni.compatability.probe.TOPCompatibility;
import net.minecraftforge.fml.common.Loader;

/**
 * Created by Cam on 9/4/2017.
 */
public class CompatabilityHandler {
    public static void registerTOP() {
        if (Loader.isModLoaded("theoneprobe")) {
            TOPCompatibility.register();
        }
    }
}
