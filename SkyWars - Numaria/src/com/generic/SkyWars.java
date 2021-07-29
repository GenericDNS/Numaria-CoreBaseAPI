package com.generic;

import com.generic.listener.GameHandler;
import com.generic.mysql.Adapter;
import com.generic.protocol.MySQLFile;
import com.generic.protocol.game.api.GameBase;

public class SkyWars extends GameBase {

    static SkyWars instance;

    private GameHandler gameHandler;

    private Adapter adapter;

    private MySQLFile mySQLFile;

    @Override
    public void onEnable() {
        instance = this;
        this.gameHandler = new GameHandler();
        this.mySQLFile = new MySQLFile();
        this.mySQLFile.setStandard();
        this.mySQLFile.readData();
        this.adapter = new Adapter(this.mySQLFile.host,
                this.mySQLFile.port,
                this.mySQLFile.user,
                this.mySQLFile.password,
                this.mySQLFile.database);
    }

    public GameHandler getGameHandler() {
        return gameHandler;
    }

    public static SkyWars getInstance() {
        return instance;
    }
}
