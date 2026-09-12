package de.kizzyjune.randomstuff.Mixin;

import de.kizzyjune.randomstuff.Misc.MonikaProtector;
import net.minecraft.client.GameLoadCookie;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MainClientClassMixin {
    @Inject(method = "onGameLoadFinished", at = @At("TAIL"))
    private void runStuffAfterGameLoad(GameLoadCookie cookie, CallbackInfo ci) {
        MonikaProtector.verifyIfMonika();
    }
}