package com.rcmd.rcmdcraft.blocks.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

public class IonizatorBlockEntity extends BlockEntity {

    public IonizatorBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(ModBlockEntites.IONIZATOR, pos, state);
        
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
    }
}
