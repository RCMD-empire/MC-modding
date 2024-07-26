package com.rcmd.rcmdcraft;

import com.rcmd.rcmdcraft.blocks.custom.ModCustomBlocks;
import com.rcmd.rcmdcraft.blocks.entity.ModBlockEntites;
import com.rcmd.rcmdcraft.itemgroups.ModItemGroups;
import com.rcmd.rcmdcraft.items.ModItems;
import com.rcmd.rcmdcraft.screen.ModScreenHandlers;
import com.rcmd.rcmdcraft.world.feature.ModConfiguredFeatures;
import com.rcmd.rcmdcraft.world.gen.ModOreGeneration;
import net.fabricmc.api.ModInitializer;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rcmdcraft implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("rcmdcraft");
	public static final String ModID = "rcmdcraft";



	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModConfiguredFeatures.RegisterConfiguredFeatures(); // need to be the first one
		ModScreenHandlers.registerAllScreenHandlers();

		ModItems.RegisterModItems();
		ModItemGroups.RegisterModItemGroups();
		ModCustomBlocks.RegisterModBlocks();
		ModOreGeneration.GenerateOre();
		ModBlockEntites.RegisterBlockEntities();
		LOGGER.info(ModID +" has loaded!");
	}
}