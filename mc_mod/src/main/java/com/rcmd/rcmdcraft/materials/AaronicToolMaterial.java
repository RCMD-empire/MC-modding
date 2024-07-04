package com.rcmd.rcmdcraft.materials;

import com.rcmd.rcmdcraft.items.ModItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum AaronicToolMaterial implements ToolMaterial {
    MATERIAL(4,
            3600,
            12.0F,
            4.0F,
            10,
            ()->{return Ingredient.ofItems(ModItems.AARE);});

    AaronicToolMaterial(int miningLevel, int durability, float miningSpeedMultiplier, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        MiningLevel = miningLevel;
        Durability = durability;
        MiningSpeedMultiplier = miningSpeedMultiplier;
        AttackDamage = attackDamage;
        Enchantability = enchantability;
        RepairIngredient = repairIngredient;
    }

    private final int MiningLevel;
    private final int Durability;
    private final float MiningSpeedMultiplier;
    private final float AttackDamage;
    private final int Enchantability;
    private final Supplier<Ingredient> RepairIngredient;
    @Override
    public int getDurability() {
        return Durability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return MiningSpeedMultiplier;
    }

    @Override
    public float getAttackDamage() {
        return AttackDamage;
    }

    @Override
    public int getMiningLevel() {
        return MiningLevel;
    }

    @Override
    public int getEnchantability() {
        return Enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return RepairIngredient.get();
    }
}
