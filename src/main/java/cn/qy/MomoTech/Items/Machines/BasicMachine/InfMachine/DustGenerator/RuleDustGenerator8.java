package cn.qy.MomoTech.Items.Machines.BasicMachine.InfMachine.DustGenerator;

import cn.qy.MomoTech.GUI.RuleDustGenerator;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.inventory.ItemStack;

public class RuleDustGenerator8 extends RuleDustGenerator {
    public RuleDustGenerator8(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, id, it, recipeType, recipe);
    }

    @Override
    protected ItemStack getItems() {
        return new SlimefunItemStack(SlimefunItems.ZINC_DUST, 64);
    }
}
