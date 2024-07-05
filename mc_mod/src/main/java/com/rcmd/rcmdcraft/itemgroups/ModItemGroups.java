package com.rcmd.rcmdcraft.itemgroups;

import com.rcmd.rcmdcraft.Rcmdcraft;
import com.rcmd.rcmdcraft.items.ModItems;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup RCMD_GROUP= FabricItemGroupBuilder.build(
            new Identifier(Rcmdcraft.ModID,"rcmd_group"),
            () -> new ItemStack(ModItems.AARE)
    );
    public static void RegisterModItemGroups(){
        Rcmdcraft.LOGGER.info("Mod Item Groups registered for "+ Rcmdcraft.ModID);
    }
}
