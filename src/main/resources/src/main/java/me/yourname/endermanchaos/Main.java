
package me.example.endermanchaos;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private Listener listener;

    @Override
    public void onEnable() {

        listener = new Listener(this);

        Bukkit.getPluginManager().registerEvents(
                listener,
                this
        );

        // Проверяем эндерменов каждые 20 тиков.
        Bukkit.getScheduler().runTaskTimer(
                this,
                listener::runBlockTheft,
                20L,
                20L
        );

        getLogger().info("EndermanChaos enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("EndermanChaos disabled!");
    }
}
