package com.rcmd.rcmdcraft.items;

import com.rcmd.rcmdcraft.itemgroups.ModItemGroups;
import com.rcmd.rcmdcraft.materials.RcmdcraftToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.rcmd.rcmdcraft.Rcmdcraft.ModID;

public class ModItems {
    public static final Item AARE = new Item(new Item.Settings().group(ModItemGroups.RCMD_GROUP));
    public static final Item AARONIC = new Item(new Item.Settings().group(ModItemGroups.RCMD_GROUP));
    public static final Item SMELTED_AARE = new Item(new Item.Settings().group(ModItemGroups.RCMD_GROUP));
    public static final Item ION = new Item(new Item.Settings().group(ModItemGroups.RCMD_GROUP));
    public static final Item IONIZED_ION = new Item(new Item.Settings().group(ModItemGroups.RCMD_GROUP));
    public static final PickaxeItem  AARE_PICKAXE = new PickaxeItem(RcmdcraftToolMaterial.AARE,1,1,new Item.Settings().group(ModItemGroups.RCMD_GROUP));
    public static final PickaxeItem AARONIC_MULTITOOL = new PickaxeItem(RcmdcraftToolMaterial.AARONIC,1,1,new Item.Settings().group(ModItemGroups.RCMD_GROUP));

    public static void RegisterModItems(){
        Registry.register(Registry.ITEM,new Identifier(ModID, "aare"),AARE);
        Registry.register(Registry.ITEM,new Identifier(ModID, "aaronic"),AARONIC);
        Registry.register(Registry.ITEM,new Identifier(ModID, "smelted_aare"),SMELTED_AARE);
        Registry.register(Registry.ITEM,new Identifier(ModID, "ion"),ION);
        Registry.register(Registry.ITEM,new Identifier(ModID, "ionized_ion"),IONIZED_ION);
        Registry.register(Registry.ITEM,new Identifier(ModID, "aare_pickaxe"), AARE_PICKAXE);
        Registry.register(Registry.ITEM,new Identifier(ModID, "aaronic_multitool"),AARONIC_MULTITOOL);
    }
}
