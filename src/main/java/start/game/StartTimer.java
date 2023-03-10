package start.game;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class StartTimer implements Listener {
    private static Plugin plugin;
    private int taskid;
    private int time = 11;
    private int clickItemsTimes = 4;

    public void timer() {
        taskid = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {

            time--;
            if(Bukkit.getOnlinePlayers().size() < 2) {
                return;
            }
            if (time == 0) {

                for (Player player : Bukkit.getOnlinePlayers()) {

                    if (player.getItemInHand().getType() == Material.COMPASS) {
                        Bukkit.getScheduler().cancelTask(clickItemsTimes);

                    }

                    Bukkit.getScheduler().cancelTask(taskid);
                    player.sendTitle("§4Убивай игроков", "§2и получай вещи");
                    player.setHealth(player.getMaxHealth());
                    player.getInventory().setItem(0, new ItemStack(Material.WOOD_SWORD));
                    player.teleport(new Location(Bukkit.getWorld("world"), -250, 70, 230));

                    return;
                }

                for (Player player : Bukkit.getOnlinePlayers()) {

                    player.sendTitle("§cДо начала", "§c " + time + " §cСекунд");
                    player.getInventory().clear();
                }
            }
        }, 20, 20);
    }
}