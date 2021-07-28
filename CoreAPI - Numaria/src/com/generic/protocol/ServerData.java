package com.generic.protocol;

import com.generic.execute.ExecuteService;
import com.generic.modules.coreplayer.CorePlayer;
import com.generic.protocol.game.api.modules.coreteam.CoreTeam;

import java.util.ArrayList;
import java.util.List;

public class ServerData {

    public static String mainColor = "§b";

    public static String secondColor = "§2";

    private final String consolePrefix = "§bNumaria §8| §7";

    public static List<ExecuteService> executeServices = new ArrayList<>();

    public List<CorePlayer> corePlayers = new ArrayList<>();

    public String getConsolePrefix() {
        return consolePrefix;
    }

    public static List<CoreTeam> coreTeams = new ArrayList<>();

}
