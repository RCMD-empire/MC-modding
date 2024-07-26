package com.rcmd.rcmdcraft.blocks.entity;

import com.rcmd.rcmdcraft.screen.IonizatorScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
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
    public DefaultedList<ItemStack> getInventory() {
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

    public static void tick(World world, BlockPos blockPos, BlockState blockState, IonizatorBlockEntity ionizatorBlockEntity) {
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
}
