package de.kizzyjune.randomstuff.Mixin;

import de.kizzyjune.randomstuff.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelEventHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.JukeboxSong;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LevelEventHandler.class)
public class LevelEventHandlerMixin {
    @Shadow
    @Final
    private Minecraft minecraft;

    @Inject(method = "playJukeboxSong", at = @At("TAIL"))
    private void gooGooGaGa(Holder<JukeboxSong> songHolder, BlockPos pos, CallbackInfo ci) {
     this.minecraft.gui.hud.setNowPlaying(Component.literal((Config.JUST_MONIKA.getAsBoolean() ? "Just Monika" : "goo goo ga ga")));
    }
}