package com.generic.protocol.game.api.modules.coreteam;

import com.generic.error.NullPlayerException;
import org.bukkit.entity.Player;

public abstract class AbstractCoreTeam {

    public abstract void addPlayer(Player player) throws NullPlayerException;

}
