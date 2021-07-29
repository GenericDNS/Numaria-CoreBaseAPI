package com.generic.listener.bukkit;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    public void handle(PlayerDeathEvent event) {
        Player killer = event.getEntity().getKiller();
        Player target = event.getEntity().getPlayer();
    }

}
