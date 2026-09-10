package de.kizzyjune.randomstuff;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    public static final ModConfigSpec.BooleanValue STRETCH_MODE;
    public static final ModConfigSpec.BooleanValue THE_FOG_IS_COMING;
    public static final ModConfigSpec.BooleanValue APPLY_FALLDAMAGE_EVERY_HEIGHT;
    public static final ModConfigSpec.BooleanValue JUST_MONIKA;


    static {
        STRETCH_MODE = BUILDER
                .comment("Stretches rendering.")
                .define("stretchMode", false);
        THE_FOG_IS_COMING = BUILDER
                .comment("Makes the fog way more intense")
                .define("theFogIsComing",false);
        APPLY_FALLDAMAGE_EVERY_HEIGHT = BUILDER
                .comment("Applies fall damage on every fall height")
                .define("applyFallDamageEveryHeight",false);
        JUST_MONIKA = BUILDER
                .comment("Just Monika.")
                .define("justMonika",false);

        SPEC = BUILDER.build();
    }
}