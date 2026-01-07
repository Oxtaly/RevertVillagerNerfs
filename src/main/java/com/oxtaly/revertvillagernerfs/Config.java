package com.oxtaly.revertvillagernerfs;

import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue REVERT_CURING_STACKING = BUILDER
            .comment("Whether to revert curing stacking to pre 1.20.2")
            .gameRestart()
            .define("curingStacks", true);

    static final ModConfigSpec SPEC = BUILDER.build();
}
