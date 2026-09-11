package de.kizzyjune.randomstuff.Mixin;

import net.minecraft.util.ModCheck;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Supplier;

@Mixin(ModCheck.class)
public class ModCheckMixin {
    @Inject(method = "identify", at = @At("RETURN"), cancellable = true)
    private static void yesWereModded(String expectedBrand, Supplier<String> actualBrand, String component, Class<?> canaryClass, CallbackInfoReturnable<ModCheck> cir) {
        cir.setReturnValue(new ModCheck(ModCheck.Confidence.DEFINITELY,"yes lol"));
    }
}