package com.rcmd.rcmdcraft.blocks.entity;

import com.rcmd.rcmdcraft.Rcmdcraft;
import com.rcmd.rcmdcraft.blocks.custom.ModCustomBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntites {
    public static BlockEntityType<IonizatorBlockEntity> IONIZATOR;
    public static void RegisterBlockEntities() {
        IONIZATOR = Registry.register(Registry.BLOCK_ENTITY_TYPE,
        new Identifier(Rcmdcraft.ModID,"ionizator"),
                FabricBlockEntityTypeBuilder.create(
                        IonizatorBlockEntity::new,
                        ModCustomBlocks.IONIZATOR).build(null));
    }
}
