package com.generic.file.syntax;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class MySQLFile {
    public String user;
    public String host;
    public String database;
    public String password;
    public String port;

    public MySQLFile() {
    }

    public void setStandard() {
        FileConfiguration fileConfiguration = this.getFileConfiguration();
        fileConfiguration.options().copyDefaults(true);
        fileConfiguration.addDefault("mysql.user", "network");
        fileConfiguration.addDefault("mysql.host", "localhost");
        fileConfiguration.addDefault("mysql.database", "core_base");
        fileConfiguration.addDefault("mysql.password", "password");
        fileConfiguration.addDefault("mysql.port", "3306");

        try {
            fileConfiguration.save(this.getFile());
        } catch (IOException var3) {
            var3.printStackTrace();
        }

    }

    public void readData() {
        FileConfiguration fileConfiguration = this.getFileConfiguration();
        this.user = fileConfiguration.getString("mysql.user");
        this.host = fileConfiguration.getString("mysql.host");
        this.database = fileConfiguration.getString("mysql.database");
        this.password = fileConfiguration.getString("mysql.password");
        this.port = fileConfiguration.getString("mysql.port");
    }

    private File getFile() {
        return new File("plugins/corebase", "database.yml");
    }

    private FileConfiguration getFileConfiguration() {
        return YamlConfiguration.loadConfiguration(this.getFile());
    }
}
