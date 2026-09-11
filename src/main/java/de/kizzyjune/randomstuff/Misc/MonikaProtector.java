package de.kizzyjune.randomstuff.Misc;

import com.mojang.logging.LogUtils;
import net.minecraft.CrashReport;
import net.minecraft.client.Minecraft;
import org.slf4j.Logger;

public class MonikaProtector {
    private static final boolean alwaysCrash = false;
    public static void verifyIfMonika() {
        Logger LOGGER = LogUtils.getLogger();
        boolean monikaExists = false;
        if (Consts.splashes[0].contains("monika") || (Consts.splashes[0].contains("Monika"))) {
            LOGGER.info("Monika exists, moving on...");
            monikaExists = true;
        }
        if (!monikaExists || alwaysCrash) {
            JustMonika jm = new JustMonika("Monika must exist on index 0 of the splash array.");
            Minecraft.getInstance().emergencySaveAndCrash(new CrashReport("Monika not found", jm));
        }
    }
    public static class JustMonika extends RuntimeException {
      private JustMonika(String in) {
          super(in);
      }
    }
}