package com.rcmd.rcmdcraft.blocks.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class IonizatorBlockEntity extends BlockEntity {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2,ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress=0;
    private int maxProgress =72;
    public IonizatorBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(ModBlockEntites.IONIZATOR, pos, state);
        this.propertyDelegate=new PropertyDelegate() {
            @Override
            public int get(int index) {
                switch (index) {
                    case 0: return IonizatorBlockEntity.this.progress;
                    case 1: return IonizatorBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch (index)
                {
                    case 0: progress = value; break;
                    case 1: maxProgress = value; break;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt,inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("ionizator.progress");
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt,inventory);
        nbt.putInt("ionizator.progress", progress);
    }
    private void resetProgress() {progress=0;}
}
