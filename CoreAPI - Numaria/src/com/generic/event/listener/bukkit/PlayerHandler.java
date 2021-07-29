package com.generic.event.listener.bukkit;

import com.generic.Numaria;
import com.generic.modules.coreplayer.CorePlayer;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerHandler implements Listener {

    public void handle(PlayerLoginEvent event) {
        CorePlayer corePlayer = new CorePlayer(event.getPlayer());
        Numaria.getInstance().getServerData().corePlayers.add(corePlayer);
        corePlayer.login();
    }

    public void handle(PlayerKickEvent event) {
        Numaria.getInstance().getServerData().corePlayers.remove(CorePlayer.get(event.getPlayer()));
        CorePlayer.get(event.getPlayer()).logout();
    }

}
