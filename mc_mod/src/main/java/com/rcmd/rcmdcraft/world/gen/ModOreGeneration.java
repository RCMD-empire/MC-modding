package com.rcmd.rcmdcraft.world.gen;

import com.rcmd.rcmdcraft.Rcmdcraft;
import com.rcmd.rcmdcraft.world.feature.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

import static com.rcmd.rcmdcraft.Rcmdcraft.ModID;

public class ModOreGeneration {
    public static void GenerateOre()
    {
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.AARE_ORE_PLACED.getKey().get()
        );
        Rcmdcraft.LOGGER.info("Generating ores for "+ ModID);
    }
}
