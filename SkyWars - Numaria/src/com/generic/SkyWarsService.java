package com.generic;

import com.generic.modules.coreplayer.CorePlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SkyWarsService {

    public void broadcast(String text) {
        for (Player players : Bukkit.getOnlinePlayers()) {
            Numaria.getInstance().getNumariaService().returnText(text, CorePlayer.get(players));
        }
    }

}
