package cn.qy.MomoTech.NullEnchantment;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Field;

import static cn.qy.MomoTech.Items.Items.*;

public class Register {

    public static <T> void setStaticValue(Class<T> clazz, String field, Object value) {
        try {
            Field declaredField = clazz.getDeclaredField(field);
            declaredField.setAccessible(true);
            declaredField.set(null, value);
        } catch (IllegalAccessException | NoSuchFieldException var4) {
            var4.printStackTrace();
        }
    }

    public static void add(ItemStack[] it) {
        for (ItemStack it1 : it)
            NullEnchantment.addAndHidden(it1);
    }

    public static void run() {
        setStaticValue(Enchantment.class, "acceptingNew", true);
        Enchantment.registerEnchantment(NullEnchantment.ENCHANTMENT);
        add(new ItemStack[]{QUANTITY_ITEM, FROG_LIGHT_GENERATOR, STONE_GENERATOR, ORE_GENERATOR, SAND_GENERATOR,
                STONE_GENERATOR_I, GLASS_GENERATOR, TEMPLATE_GENERATOR, FISH_GENERATOR, DUST_GENERATOR,
                STONES_GENERATOR, ICE_GENERATOR, Generator, LINE_GENERATOR, COMMAND_BLOCK_GENERATOR, CREATIVE__,
                C_GENERATOR, MOMOTECH_LETTER, MOMOTECH_ID_CARD, MOMOTECH_FINAL_STAR, MOMOTECH_UNCONTROLLABLE_EMPTY,
                MOMOTECH_RANDOM_COPIER, MOMOTECH_FINAL_COPIER, MOMOTECH_ORE_COLLECTOR, MOMOTECH_NONE, MOMOTECH_NUMBER_BUG,
                MOMOTECH_NUMBER_BUG_I, MOMOTECH_NUMBER_BUG_II, MOMOTECH_NUMBER_BUG_III, MOMOTECH_NUMBER_BUG_IV,
                MOMOTECH_NUMBER_BUG_V, MOMOTECH_ORDINARY_NUMBER_COMBINATOR, MOMOTECH_CREATIVE_ITEM_I, MOMOTECH_CREATIVE_ITEM,
                MOMOTECH_CREATIVE_ITEM_II, MOMOTECH_CREATIVE_ITEM_GENERATOR, CREATIVE__, MOMOTECH_BUG_CRYSTAL, MOMOTECH_QUANTITY_CONSTRUCTOR,
                QY, wbx, sky, plugin, BUGGGGG, FULL, DAMAGE_ITEM, PROTECT_ITEM, MOMOTECH_CREATIVE_ITEM_GENERATOR, MOMOTECH_UNCONTROLLABLE_EMPTY,
                MOMOTECH_EMPTY_SHELL_GENERATOR, MOMOTECH_EMPTY_SHELL_GENERATOR_I, MOMOTECH_FINAL_ITEM, BEE_GENERATOR, SPIDER_EYE_GENERATOR, MOMOTECH_UNCONTROLLABLE_EMPTY_GENERATOR,
                SEA_ITEM_GENERATOR, MOMOTECH_PUMPKIN_CARVER, MOMOTECH_ID_CHANGER, MOMOTECH_ID_PUTTER, MOMOTECH_LETTER_CONSTRUCTOR,
                MOMOTECH_EMPTY_SHELL, MOMOTECH_SYMBOL_DIVISION, MOMOTECH_SYMBOL_ADDITION, MOMOTECH_SYMBOL_MULTIPLICATION, MOMOTECH_SYMBOL_SUBTRACTION,
                CreativeGenerator, Cobblestone[49], MOMOTECH_NONE_GENERATOR, STAR_OF_ALL, MOMOTECH_BOX_OF_QUANTUM, MOMOTECH_QUANTUM, MOMOTECH_QUANTUM1,
                COBBLE_STONE_GENERATOR_II, MOMOTECH_FIXER, CHEST_GENERATOR, MOMOTECH_TRANSPORTER,
                MOMOTECH_OPEN_BOX_ITEM, MOMOTECH_SHINE1, MOMOTECH_DARK1, DIAMOND_PICKAXE_GENERATOR, MOMOTECH_DIAMOND1,
                MOMOTECH_IRON1, MOMOTECH_GOLD1, MOMOTECH_QUARTZ1, MOMOTECH_EMERALD1, MOMOTECH_LAPIS1, MOMOTECH_REDSTONE1, MOMOTECH_Cu1, MOMOTECH_Pb1, MOMOTECH_Mg1, MOMOTECH_Zn1, MOMOTECH_Sn1, MOMOTECH_Ag1,
                MOMOTECH_Au1, MOMOTECH_Al1, MOMOTECH_IRON_STAR, MOMOTECH_INFINITY, MOMOTECH_FAST_GEO, MOMOTECH_COAL1, MOMOTECH_COBBLESTONE_GENERATOR_FINAL, MOMOTECH_MINERAL_, MOMOTECH_METAL_,
                FLINT_GENERATOR, MOMOTECH_RULE_STAR, MOMOTECH_ENTROPY_RECONSTRUCT, MOMOTECH_RULE_CONSTRUCTOR, MOMOTECH_RULE_RECONSTRUCT, MOMOTECH_RULE_MACHINE_STAR, MOMOTECH_SHINE_AND_DARK_INGOT,
                MOMOTECH_RULE_DUST_GENERATOR, MOMOTECH_RULE_DUST_GENERATOR1, MOMOTECH_RULE_DUST_GENERATOR2, MOMOTECH_RULE_DUST_GENERATOR3, MOMOTECH_RULE_DUST_GENERATOR4, MOMOTECH_RULE_DUST_GENERATOR5, MOMOTECH_RULE_DUST_GENERATOR6, MOMOTECH_RULE_DUST_GENERATOR7, MOMOTECH_RULE_DUST_GENERATOR8, MOMOTECH_RULE_DUST_GENERATOR9,
                MOMOTECH_RULE_U_GENERATOR, MOMOTECH_RULE_GEO, MOMOTECH_RULE_REACTOR, MOMOTECH_QUICK_CRAFTER1, MOMOTECH_MINERAL_GENERATOR, MOMOTECH_MINERAL_BLOCK_GENERATOR, MOMOTECH_INGOT_GENERATOR, MOMOTECH_CAST_INGOT,
                MOMOTECH_PLANT, MOMOTECH_WOOD, LINE_GENERATOR, MOMOTECH_RULE_SHINE_AND_DARK_CONSTRUCTOR
        });
    }
}
