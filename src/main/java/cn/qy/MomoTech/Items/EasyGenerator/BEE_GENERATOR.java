package cn.qy.MomoTech.Items.EasyGenerator;

import cn.qy.MomoTech.GUI.AbstractEasyGeneratorGUI;
import cn.qy.MomoTech.utils.Maths;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class BEE_GENERATOR extends AbstractEasyGeneratorGUI {
    public BEE_GENERATOR(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, id, it, recipeType, recipe);
    }

    @Override
    public ItemStack getOut() {
        Material[] list = {Material.BEE_SPAWN_EGG, Material.BEEHIVE, Material.HONEYCOMB, Material.HONEY_BOTTLE, Material.HONEYCOMB_BLOCK, Material.HONEY_BLOCK};
        return new ItemStack(list[Maths.GetRandom(5)], 1);
    }

    @NotNull
    @Override
    public String getMachineIdentifier() {
        return "MOMOTECH_BEE_GENERATOR";
    }
}
