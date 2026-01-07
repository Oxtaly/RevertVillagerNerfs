package com.oxtaly.revertvillagernerfs;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue REVERT_CURING_STACKING = BUILDER
            .comment("Whether to revert curing stacking to pre 1.20.2")
            .gameRestart()
            .define("curingStacks", true);

    static final ModConfigSpec SPEC = BUILDER.build();
}
