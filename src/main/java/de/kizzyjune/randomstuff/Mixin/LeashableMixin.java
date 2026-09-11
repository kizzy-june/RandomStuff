package de.kizzyjune.randomstuff.Mixin;

import de.kizzyjune.randomstuff.Config;
import net.minecraft.world.entity.Leashable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Leashable.class)
public interface LeashableMixin {
    @Inject(method = "mayBeLeashed", at = @At("TAIL"), cancellable = true)
    default void allowLeashed1(CallbackInfoReturnable<Boolean> cir) {
        if (Config.MAKE_ALMOST_EVERYTHING_LEASHABLE.getAsBoolean()) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "canHaveALeashAttachedTo", at = @At("TAIL"), cancellable = true)
    default void allowLeashed2(CallbackInfoReturnable<Boolean> cir) {
        if (Config.MAKE_ALMOST_EVERYTHING_LEASHABLE.getAsBoolean()) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "canBeLeashed", at = @At("TAIL"), cancellable = true)
    default void allowLeashed3(CallbackInfoReturnable<Boolean> cir) {
        if (Config.MAKE_ALMOST_EVERYTHING_LEASHABLE.getAsBoolean()) {
            cir.setReturnValue(true);
        }
    }
}