package com.generic;

import com.generic.modules.coreplayer.CorePlayer;
import com.generic.protocol.ServerData;

public class NumariaService {


    /**
     *
     * Help with the first colors and the one
     * next to colors.
     *
     * @param text text to be replaced for the player
     * @param corePlayer target player
     * @return the replaced text with the main color and the second color
     * of the player
     */
    public String returnText(String text, CorePlayer corePlayer) {
        return text.replace(ServerData.mainColor, corePlayer.getDataMainColor().getColor())
                .replace(ServerData.secondColor, corePlayer.getDataSecondColor().getColor());
    }

}
