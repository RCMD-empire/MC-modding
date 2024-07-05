package com.rcmd.rcmdcraft.world.feature;

import com.rcmd.rcmdcraft.Rcmdcraft;
import com.rcmd.rcmdcraft.blocks.custom.ModCustomBlocks;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

import static com.rcmd.rcmdcraft.Rcmdcraft.ModID;

public class ModConfiguredFeatures {
    public static final List<OreFeatureConfig.Target> OVERWORLD_AARE_ORE= List.of(
            OreFeatureConfig.createTarget(
                    OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    ModCustomBlocks.AARE_ORE.getDefaultState())
    );
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig,?>> AARE_ORE=
            ConfiguredFeatures.register("aare_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_AARE_ORE,
                    15)); // 9 is the avg
    public static void RegisterConfiguredFeatures(){
        Rcmdcraft.LOGGER.info("Features are loaded for "+ ModID);
    }
}
