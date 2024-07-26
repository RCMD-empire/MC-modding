package com.rcmd.rcmdcraft.blocks.entity;

import com.rcmd.rcmdcraft.Rcmdcraft;
import com.rcmd.rcmdcraft.items.ModItems;
import com.rcmd.rcmdcraft.screen.IonizatorScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class IonizatorBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory{
    public static final int invSize=2;
    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(invSize, ItemStack.EMPTY);
    protected final PropertyDelegate propertyDelegate;
    private int currentProgress=0;
    private int maxProgress=72;
    public IonizatorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntites.IONIZATOR, pos, state);
        propertyDelegate=new PropertyDelegate() {
            @Override
            public int get(int index) {
                switch (index) {
                    case 0:
                        return currentProgress;
                    case 1:
                        return maxProgress;
                    default:
                        return 0;
                }
            }
            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0:
                        currentProgress=value;
                        break;
                    case 1:
                        maxProgress=value;
                        break;
                }
            }
            @Override
            public int size() {
                return invSize;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, inventory);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("screen.rcmdcraft.ionizator_menutitle");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new IonizatorScreenHandler(syncId,inv,this,this.propertyDelegate);
    }
    public static void tick(World world, BlockPos blockPos, BlockState state, IonizatorBlockEntity entity) {
        if(world.isClient()) {
            return;
        }
        if(hasRecipe(entity)) {

            entity.currentProgress++;
            markDirty(world, blockPos, state);
            if(entity.currentProgress >= entity.maxProgress) {
                craftItem(entity);
            }
        } else {
            entity.resetProgress();
            markDirty(world, blockPos, state);
        }
    }

    private static void craftItem(IonizatorBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        if(hasRecipe(entity)) {
            entity.removeStack(INPUT_SLOT, 1);

            entity.setStack(OUTPUT_SLOT, new ItemStack(ModItems.IONIZED_ION,
                    entity.getStack(OUTPUT_SLOT).getCount() + 1));

            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(IonizatorBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        boolean hasIonInFirstSlot = entity.getStack(INPUT_SLOT).getItem() == ModItems.ION; //todo

        return hasIonInFirstSlot && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, ModItems.IONIZED_ION);
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        return inventory.getStack(OUTPUT_SLOT).getItem() == output || inventory.getStack(OUTPUT_SLOT).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(OUTPUT_SLOT).getMaxCount() > inventory.getStack(OUTPUT_SLOT).getCount();
    }
    private void resetProgress() {currentProgress=0;}
}
