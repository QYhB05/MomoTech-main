package cn.qy.MomoTech.GUI.MachineGUI;

import cn.qy.MomoTech.Exceptions;
import cn.qy.MomoTech.GUI.AbstractGUI;
import cn.qy.MomoTech.Items.Items;
import cn.qy.MomoTech.utils.MomotechItem;
import cn.qy.MomoTech.utils.NumberCombinator;
import cn.qy.MomoTech.utils.Utils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Objects;

public abstract class OrdinaryNumberCombinator_ extends AbstractGUI {
    protected OrdinaryNumberCombinator_(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    public static boolean check(ItemStack it) {
        if (SlimefunUtils.isItemSimilar(it, Items.MOMOTECH_SYMBOL_ADDITION, false, false)) return true;
        if (SlimefunUtils.isItemSimilar(it, Items.MOMOTECH_SYMBOL_DIVISION, false, false)) return true;
        if (SlimefunUtils.isItemSimilar(it, Items.MOMOTECH_SYMBOL_MULTIPLICATION, false, false)) return true;
        return SlimefunUtils.isItemSimilar(it, Items.MOMOTECH_SYMBOL_SUBTRACTION, false, false);
    }

    public static String check1(ItemStack it) {
        if (SlimefunUtils.isItemSimilar(it, Items.MOMOTECH_SYMBOL_ADDITION, false, false)) return "+";
        if (SlimefunUtils.isItemSimilar(it, Items.MOMOTECH_SYMBOL_DIVISION, false, false)) return "/";
        if (SlimefunUtils.isItemSimilar(it, Items.MOMOTECH_SYMBOL_MULTIPLICATION, false, false)) return "*";
        if (SlimefunUtils.isItemSimilar(it, Items.MOMOTECH_SYMBOL_SUBTRACTION, false, false)) return "-";
        return "";
    }

    @Override
    public int[] IN() {
        return new int[]{0, 1, 2, 3, 4, 9, 13, 18, 19, 20, 21, 22};
    }

    @Override
    public int[] OUT() {
        return new int[]{6, 7, 8, 15, 17, 24, 25, 26};
    }

    @Override
    public int[] EMPTY() {
        return new int[]{5, 14, 23};
    }

    public int[] getInputSlots() {
        return new int[]{10, 11, 12};
    }

    public int[] getOutputSlots() {
        return new int[]{16};
    }

    private ItemStack out(String a, String b, String c) {
        double answer = 0;
        double A = Double.parseDouble(a);
        double B = Double.parseDouble(b);
        try {
            answer = Double.parseDouble(Objects.requireNonNull(NumberCombinator.Ordinary(A, B, c)));
            return MomotechItem.digital(answer);
        } catch (Exceptions.NumberBugException e) {
            //输出NUMBER_BUG
            return MomotechItem.bug;
        } catch (Exceptions.NumberBugIException e) {
            //输出NUMBER_BUG_I
            return MomotechItem.bug1;
        } catch (Exceptions.NumberBugIIException e) {
            //输出NUMBER_BUG_II
            return MomotechItem.bug2;
        } catch (Exceptions.NumberBugIIIException e) {
            //输出NUMBER_BUG_III
            return MomotechItem.bug3;
        } catch (Exceptions.NumberBugIVException e) {
            //输出NUMBER_BUG_IV
            return MomotechItem.bug4;
        } catch (Exceptions.NumberBugVException e) {
            //输出NUMBER_BUG_V
            return MomotechItem.bug5;
        }

    }

    protected MachineRecipe findNextRecipe(BlockMenu inv) {
        if (!Utils.checkOutput(inv, getOutputSlots())) return null;
        for (int i : getInputSlots()) {
            if (inv.getItemInSlot(i) == null) return null;
            if (!Utils.checkCombinator(inv.getItemInSlot(i))) return null;
        }
        ItemStack it1 = inv.getItemInSlot(getInputSlots()[0]).clone(),
                it2 = inv.getItemInSlot(getInputSlots()[1]).clone(),
                it3 = inv.getItemInSlot(getInputSlots()[2]).clone();
        if (SlimefunUtils.isItemSimilar(it1, Items.MOMOTECH_DIGITAL, false, false))
            if (SlimefunUtils.isItemSimilar(it3, Items.MOMOTECH_DIGITAL, false, false))
                if (check(it2)) {
                    for (int i : getInputSlots()) inv.consumeItem(i, 1);
                    ItemMeta meta1 = it1.getItemMeta(), meta2 = it3.getItemMeta(), meta;
                    List lore1 = Utils.getLore(meta1), lore2 = Utils.getLore(meta2);
                    ItemStack ans = out(((String) lore1.get(0)).substring(((String) lore1.get(0)).indexOf('f') + 1), ((String) lore2.get(0)).substring(((String) lore2.get(0)).indexOf('f') + 1), check1(it2));

                    inv.pushItem(ans, 16);
                    return null;
                }
        return null;
    }

}
