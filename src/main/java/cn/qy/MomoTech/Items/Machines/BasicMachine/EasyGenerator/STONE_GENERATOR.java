package cn.qy.MomoTech.Items.Machines.BasicMachine.EasyGenerator;

import cn.qy.MomoTech.GUI.AbstractEasyGeneratorGUI;
import cn.qy.MomoTech.utils.Maths;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class STONE_GENERATOR extends AbstractEasyGeneratorGUI {
    public STONE_GENERATOR(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, id, it, recipeType, recipe);
    }

    @Override
    public ItemStack getOut() {
        Material[] list = {Material.STONE, Material.COBBLESTONE, Material.GRANITE, Material.DIORITE, Material.COBBLED_DEEPSLATE, Material.ANDESITE};
        return new ItemStack(list[Maths.GetRandom(5)], 8);
    }

    @NotNull
    @Override
    public String getMachineIdentifier() {
        return "MOMOTECH_STONE_GENERATOR";
    }
}
