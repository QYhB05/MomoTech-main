package cn.qy.MomoTech.Listeners;

import cn.qy.MomoTech.Items.Items;
import cn.qy.MomoTech.utils.Maths;
import cn.qy.MomoTech.utils.MomotechItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public final class Listeners implements Listener {
    public static int[] get(int i) {
        return new int[]{i % 9, i / 9};
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void blockBreakEvent(BlockBreakEvent e) {
        int i = Maths.GetRandom(100);
        if (i <= 5) {
            World w = e.getBlock().getWorld();
            Location l = e.getBlock().getLocation();
            w.dropItem(l, MomotechItem.empty_shell);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void entityDamageByEntityEvent(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player)
            if (SlimefunUtils.isItemSimilar(((Player) e.getEntity()).getInventory().getHelmet(), new SlimefunItemStack("PROTECT_ITEM", Items.PROTECT_ITEM), true, false)) {
                e.setDamage(0);
                e.setCancelled(true);
            }
        if (e.getDamager() instanceof Player)
            if (SlimefunUtils.isItemSimilar(((Player) e.getDamager()).getInventory().getItemInMainHand(), new SlimefunItemStack("DAMAGE_ITEM", Items.DAMAGE_ITEM), true, false)) {
                if (e.getEntity() instanceof Player) {
                    ((Player) e.getEntity()).setHealth(0.0);
                } else e.getEntity().remove();
            }
        if (e.getDamager() instanceof Player)
            if (SlimefunUtils.isItemSimilar(((Player) e.getDamager()).getInventory().getItemInMainHand(), new SlimefunItemStack("MOMOTECH_LIGHT_", Items.MOMOTECH_LIGHT_), true, false)) {
                if (e.getEntity() instanceof Player) {
                    Player p = ((Player)e.getEntity());
                    ((Player) e.getEntity()).setHealth(p.getHealthScale() - p.getHealthScale() * 3 / 4);
                } else e.getEntity().remove();
            }
    }
}
