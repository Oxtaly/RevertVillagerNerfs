package com.oxtaly.revertvillagernerfs.mixin;

import com.oxtaly.revertvillagernerfs.Config;
import net.minecraft.world.entity.ai.gossip.GossipType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin({GossipType.class})
public abstract class GossipTypeMixin {
    private static String currentKey;

    // Ordinal 0 string is ENUM key, Ordinal 0 int is ENUM value

    @ModifyVariable(
            method = "<init>",
            at = @At("HEAD"),
            ordinal = 1,
            argsOnly = true
    )
    private static String interceptId(String id) {
        currentKey = id;
        return id;
    }

    @ModifyVariable(
            method = "<init>",
            at = @At("HEAD"),
            ordinal = 4,
            argsOnly = true
    )
    private static int modifyDecayPerTransfer(int decayPerTransfer) {
        if(Config.REVERT_CURING_STACKING.isTrue() && currentKey.equalsIgnoreCase("MAJOR_POSITIVE")) {
            return 100;
        }
        return decayPerTransfer;
    }
    @ModifyVariable(
            method = "<init>",
            at = @At("HEAD"),
            ordinal = 2,
            argsOnly = true
    )
    private static int modifyMax(int max) {
        if(Config.REVERT_CURING_STACKING.isTrue()) {
            if(currentKey.equalsIgnoreCase("MAJOR_POSITIVE")) {
                return 100;
            } else if (currentKey.equalsIgnoreCase("MINOR_POSITIVE")) {
                return 200;
            }
        }
        return max;
    }
}
