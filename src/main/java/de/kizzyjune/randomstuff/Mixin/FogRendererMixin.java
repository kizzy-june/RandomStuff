package de.kizzyjune.randomstuff.Mixin;

import com.llamalad7.mixinextras.sugar.Local;
import de.kizzyjune.randomstuff.Config;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.fog.FogData;
import net.minecraft.client.renderer.fog.FogRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FogRenderer.class)
public class FogRendererMixin {
    @ModifyVariable(
            method = "computeFogColor",
            at = @At(value = "STORE", ordinal = 0),
            name = "brightness"
    )
    private float changeBrightness(float original) {
        if (Config.THE_FOG_IS_COMING.getAsBoolean()) {
            return 1.0F;
        }
        return original;
    }
    @Inject(method = "setupFog", at = @At("TAIL"))
    private void changeIntensity(Camera camera, int renderDistanceInChunks, DeltaTracker deltaTracker, float darkenWorldAmount, ClientLevel level, CallbackInfoReturnable<FogData> cir, @Local FogData fog) {
      if (Config.THE_FOG_IS_COMING.getAsBoolean()) {
          fog.renderDistanceStart = -275;
      }
    }
}