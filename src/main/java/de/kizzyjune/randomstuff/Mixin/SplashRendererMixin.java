package de.kizzyjune.randomstuff.Mixin;

import de.kizzyjune.randomstuff.Misc.ConstsAndVars;
import net.minecraft.client.gui.components.SplashRenderer;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.time.MonthDay;
import java.util.concurrent.ThreadLocalRandom;

@Mixin(SplashRenderer.class)
public class SplashRendererMixin {
    @SuppressWarnings("ShadowModifiers")
    @Mutable
    @Shadow
    private Component splash;
    @Inject(method = "<init>", at = @At("TAIL"))
    private void changeSplash(Component splash, CallbackInfo ci) {
        int index = ThreadLocalRandom.current().nextInt(0, ConstsAndVars.splashes.length);
        boolean moniBirthday = JustMonika.current.equals(JustMonika.moni);
        this.splash = (moniBirthday) ? Component.literal("Happy birthday Monika") : Component.literal(ConstsAndVars.splashes[index]).withColor(-3047306);
    }
    public static class JustMonika {
        private static final MonthDay moni = MonthDay.of(9, 22);
        private static MonthDay current = MonthDay.now();
    }
}