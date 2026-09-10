package de.kizzyjune.randomstuff.Mixin;

import de.kizzyjune.randomstuff.Config;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @ModifyVariable(
            method = "renderLevel",
            at = @At(value = "STORE", ordinal = 0),
            name = "spinningEffectIntensity"
    )
    private float modifySpinningIntensity(float original) {
        if (Config.STRETCH_MODE.getAsBoolean()) {
            return 1.55F;
        }
        return original;
    }
}