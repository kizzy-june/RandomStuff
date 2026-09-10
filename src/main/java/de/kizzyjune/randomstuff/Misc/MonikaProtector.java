package de.kizzyjune.randomstuff.Misc;

import com.mojang.logging.LogUtils;
import net.minecraft.CrashReport;
import net.minecraft.client.Minecraft;
import org.slf4j.Logger;

public class MonikaProtector {
    public static void verifyIfMonika() {
        Logger LOGGER = LogUtils.getLogger();
        boolean monikaExists = false;
        if (Consts.splashes[0].contains("monika") || (Consts.splashes[0].contains("Monika"))) {
            LOGGER.info("Monika exists, moving on...");
            monikaExists = true;
        }
        if (!monikaExists) {
            IllegalStateException e = new IllegalStateException("Monika must exist on index 0 of the splash array.");
            Minecraft.getInstance().emergencySaveAndCrash(new CrashReport("Monika not found", e));
        }
    }
}