package com.generic;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class BootedNumariaBase {

    private JavaPlugin javaPlugin;

    public BootedNumariaBase(JavaPlugin javaPlugin) {
        this.javaPlugin = javaPlugin;
    }

    public void onEnable() {
        Numaria.getInstance().getExecuteService().execute(new Runnable() {
            @Override
            public void run() {

                javaPlugin.onEnable();

            }
        });
    }

}
