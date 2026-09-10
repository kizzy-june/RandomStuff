package de.kizzyjune.randomstuff;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    public static final ModConfigSpec.BooleanValue STRETCH_MODE;


    static {
        STRETCH_MODE = BUILDER
                .comment("Stretches rendering.")
                .define("stretchMode", false);

        SPEC = BUILDER.build();
    }
}