package de.kizzyjune.randomstuff.Mixin;

import de.kizzyjune.randomstuff.Config;
import net.minecraft.client.renderer.SkyRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(SkyRenderer.class)
public class SkyRendererMixin {
    @ModifyVariable(
            method = "buildStars",
            at = @At(value = "STORE", ordinal = 0),
            name = "starSize"
    )
    private float changeSize(float original) {
        if (Config.BIG_STARS.getAsBoolean() && !Config.VERY_BIG_STARS.getAsBoolean()) {
            return 1.0F;
        }
        else if (Config.VERY_BIG_STARS.getAsBoolean() && !Config.BIG_STARS.getAsBoolean()) {
            return 10.0F;
        }
        return original;
    }
}
