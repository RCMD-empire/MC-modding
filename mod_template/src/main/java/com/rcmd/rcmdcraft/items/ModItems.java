package com.rcmd.rcmdcraft.items;

import com.rcmd.rcmdcraft.itemgroups.ModItemGroups;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.rcmd.rcmdcraft.Rcmdcraft.ModID;

public class ModItems {
    public static final Item AARE = new Item(new Item.Settings().group(ModItemGroups.RCMD_GROUP));
    public static final Item SMELTED_AARE = new Item(new Item.Settings().group(ModItemGroups.RCMD_GROUP));

    public static void RegisterModItems(){
        Registry.register(Registry.ITEM,new Identifier(ModID, "aare"),AARE);
        Registry.register(Registry.ITEM,new Identifier(ModID, "smelted_aare"),SMELTED_AARE);
    }
}
