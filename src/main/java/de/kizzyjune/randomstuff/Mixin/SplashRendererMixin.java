package de.kizzyjune.randomstuff.Mixin;

import de.kizzyjune.randomstuff.Misc.Consts;
import net.minecraft.client.gui.components.SplashRenderer;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.concurrent.ThreadLocalRandom;

@Mixin(SplashRenderer.class)
public class SplashRendererMixin {
    @SuppressWarnings("ShadowModifiers")
    @Mutable
    @Shadow
    private Component splash;
    @Inject(method = "<init>", at = @At("TAIL"))
    private void changeSplash1(Component splash, CallbackInfo ci) {
        String[] splashes = {"Just Monika... No wait, just, uhh, Steve", "I don't know what to put here"};
        // Hehe the second one will never show up
        int index = ThreadLocalRandom.current().nextInt(0,splashes.length - 1);
        if (index == 0) {
            this.splash = Component.literal(splashes[index]).withColor(-3047306);
            // Thanks to pixiesp1991arts for the DDLC colour palette.
            // https://www.color-hex.com/color-palette/1034923
            return;
        }
        this.splash = Component.literal(splashes[index]).withColor(Consts.colour);

    }
}