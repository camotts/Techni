package com.orbiter.techni;

import com.orbiter.techni.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

/**
 * Created by Cam on 9/3/2017.
 */
public class Config {

    private static final String CATEGORY_GENERAL = "general";

    public static boolean isModdable = true;

    public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            initGeneralConfig(cfg);
        } catch (Exception e1) {
            Techni.logger.log(Level.ERROR, "Problem loading config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    private static void initGeneralConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(Configuration.CATEGORY_GENERAL, "General configuration");
        isModdable = cfg.getBoolean("moddable", CATEGORY_GENERAL, isModdable, "Set to false if you don't want this to be moddable");

    }
}
