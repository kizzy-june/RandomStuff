package de.kizzyjune.randomstuff.Mixin;

import de.kizzyjune.randomstuff.Config;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.concurrent.ThreadLocalRandom;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(method = "calculateFallDamage", at = @At("RETURN"), cancellable = true)
    private void changeFallDamage(double fallDistance, float damageModifier, CallbackInfoReturnable<Integer> cir) {
      if (Config.APPLY_FALLDAMAGE_EVERY_HEIGHT.getAsBoolean()) {
          cir.setReturnValue((ThreadLocalRandom.current().nextBoolean()) ? 1 : 3);
      }
    }
}