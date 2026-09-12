package de.kizzyjune.randomstuff;

import com.mojang.blaze3d.platform.MessageBox;
import net.neoforged.fml.config.ModConfig;

import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(RandomStuff.MODID)
public class RandomStuff {
    static {
        final String[] goofyAhhMessagesIdk = {"weelcom to the mincraft hoep u hav fun", "sory for me no good english"};
        final int arrayLength = goofyAhhMessagesIdk.length;
        int index = 0;
        while (index != arrayLength) {
            MessageBox.error(goofyAhhMessagesIdk[index]);
            index++;
        }
    }
    // Define mod id in a common place for everything to reference
    public static final String MODID = "randomstuff";

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public RandomStuff(ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, de.kizzyjune.randomstuff.Config.SPEC);
    }
}