package com.generic;

import com.generic.execute.ExecuteService;
import com.generic.file.syntax.MySQLFile;
import com.generic.mysql.Adapter;
import com.generic.protocol.ServerData;
import org.bukkit.plugin.java.JavaPlugin;

public class Numaria extends JavaPlugin {

    private static Numaria instance;

    private ServerData serverData;

    private Adapter adapter;

    private MySQLFile mySQLFile;

    public Numaria() {
    }

    @Override
    public void onEnable() {
        instance = this;
        this.serverData = new ServerData();
        this.mySQLFile = new MySQLFile();
        this.mySQLFile.setStandard();
        this.mySQLFile.readData();
        this.adapter = new Adapter(this.mySQLFile.host, this.mySQLFile.port, this.mySQLFile.user, this.mySQLFile.password, this.mySQLFile.database);
        this.adapter.connectDatabase();
    }

    public MySQLFile getMySQLFile() {
        return mySQLFile;
    }

    public Adapter getAdapter() {
        return adapter;
    }

    public static Numaria getInstance() {
        return instance;
    }

    public ServerData getServerData() {
        return serverData;
    }

    public ExecuteService getExecuteService() {
        return new ExecuteService() {
        };
    }
}
