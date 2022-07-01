package mikeshafter.discordafk;

import github.scarsz.discordsrv.DiscordSRV;
import github.scarsz.discordsrv.util.DiscordUtil;
import net.ess3.api.IUser;
import net.ess3.api.events.AfkStatusChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public final class DiscordAFK extends JavaPlugin implements Listener {
  
  @Override
  public void onEnable() {
    // Plugin startup logic
    this.getServer().getConsoleSender().sendMessage(ChatColor.AQUA+"DiscordAFK has been invoked!");
    Bukkit.getPluginManager().registerEvents(this, this);
  }
  
  @Override
  public void onDisable() {
    // Plugin shutdown logic
    this.getServer().getConsoleSender().sendMessage(ChatColor.RED+"DiscordAFK has been disabled!");
  }
  
  @EventHandler
  public void onAFK(AfkStatusChangeEvent event) {
    IUser iUser = event.getAffected();
    Player player = iUser.getBase();
    String name = player.getDisplayName();
    if (event.getValue()) DiscordUtil.sendMessage(DiscordUtil.getTextChannelById(DiscordSRV.config().get("Channels.global")), "> "+name+" is now AFK!");
    else DiscordUtil.sendMessage(DiscordUtil.getTextChannelById(DiscordSRV.config().get("Channels.global")), "> "+name+" is no longer AFK!");
  }
}
