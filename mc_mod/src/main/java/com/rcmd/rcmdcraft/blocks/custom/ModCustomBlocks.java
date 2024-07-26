package com.rcmd.rcmdcraft.blocks.custom;

import com.rcmd.rcmdcraft.Rcmdcraft;
import com.rcmd.rcmdcraft.itemgroups.ModItemGroups;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.rcmd.rcmdcraft.Rcmdcraft.ModID;

public class ModCustomBlocks {
    static final Block AARE_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(1f,6f));
   public static final Block AARE_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.3f).requiresTool());
    static final Block IONIZATION_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(1f));
    static final Block IONIZED_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(1f));
    static final Block BLACK_HOLE_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(1f));
    static final Block ION_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1f));
    public static final Block IONIZATOR = new IonizatorBlock(FabricBlockSettings.of(Material.STONE).strength(1f));
    public static void RegisterModBlocks() {
        Registry.register(Registry.BLOCK,new Identifier(ModID, "aare_block"),AARE_BLOCK);
        Registry.register(Registry.ITEM,new Identifier(ModID, "aare_block"),
                new BlockItem(AARE_BLOCK, new Item.Settings().group(ModItemGroups.RCMD_GROUP)));

        Registry.register(Registry.BLOCK,new Identifier(ModID, "aare_ore"),AARE_ORE);
        Registry.register(Registry.ITEM,new Identifier(ModID, "aare_ore"),
                new BlockItem(AARE_ORE, new Item.Settings().group(ModItemGroups.RCMD_GROUP)));

        Registry.register(Registry.BLOCK,new Identifier(ModID, "ionization_block"),IONIZATION_BLOCK);
        Registry.register(Registry.ITEM,new Identifier(ModID, "ionization_block"),
                new BlockItem(IONIZATION_BLOCK, new Item.Settings().group(ModItemGroups.RCMD_GROUP)));

        Registry.register(Registry.BLOCK,new Identifier(ModID, "ionized_block"),IONIZED_BLOCK);
        Registry.register(Registry.ITEM,new Identifier(ModID, "ionized_block"),
                new BlockItem(IONIZED_BLOCK, new Item.Settings().group(ModItemGroups.RCMD_GROUP)));

        Registry.register(Registry.BLOCK,new Identifier(ModID, "black_hole_block"),BLACK_HOLE_BLOCK);
        Registry.register(Registry.ITEM,new Identifier(ModID, "black_hole_block"),
                new BlockItem(BLACK_HOLE_BLOCK, new Item.Settings().group(ModItemGroups.RCMD_GROUP)));

        Registry.register(Registry.BLOCK,new Identifier(ModID, "ion_ore"),ION_ORE);
        Registry.register(Registry.ITEM,new Identifier(ModID, "ion_ore"),
                new BlockItem(ION_ORE, new Item.Settings().group(ModItemGroups.RCMD_GROUP)));

        Registry.register(Registry.BLOCK,new Identifier(ModID, "ionizator"),IONIZATOR);
        Registry.register(Registry.ITEM,new Identifier(ModID, "ionizator"),
                new BlockItem(IONIZATOR, new Item.Settings().group(ModItemGroups.RCMD_GROUP)));

        Rcmdcraft.LOGGER.info("Registered blocks for "+ ModID);
    }

}
