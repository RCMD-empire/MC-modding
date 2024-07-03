package com.rcmd.rcmdcraft.materials;

import com.rcmd.rcmdcraft.items.ModItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public enum AaronicToolMaterial implements ToolMaterial {
    MATERIAL(4,3600,12.0F,4.0F,10, ()->{return Ingredient.ofItems(ModItems.AARE);});
    @Override
    public int getDurability() {
        return 0;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 0;
    }

    @Override
    public float getAttackDamage() {
        return 0;
    }

    @Override
    public int getMiningLevel() {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
