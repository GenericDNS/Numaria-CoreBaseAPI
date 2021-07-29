package com.generic.modules.coreplayer;

import com.generic.Numaria;
import com.generic.types.Color;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CorePlayer {

    private final ExecutorService executorService = Executors.newCachedThreadPool();

    private boolean changed;

    private Color mainColor;

    private Color secondColor;

    private ItemStack colorStack;

    private int coins;

    private final Player player;

    public static CorePlayer get(Player player) {
        for (CorePlayer corePlayers : Numaria.getInstance().getServerData().corePlayers) {
            if (corePlayers.player == player) return corePlayers;
        } return null;
    }

    public CorePlayer(Player player) {
        this.changed = false;
        this.player = player;
        if (!Numaria.getInstance().getAdapter().existsInTable("module_player", "uuid", player.getUniqueId().toString())) {
            this.createPlayer();
        }

        if (!Numaria.getInstance().getServerData().corePlayers.contains(this)) {
            Numaria.getInstance().getServerData().corePlayers.add(this);
        }
    }

    public void setMainColor(Color color) {
        this.executorService.execute(() -> {
            Numaria.getInstance().getAdapter().updateInTable("module_player", "mainColor", color.getColor(), "uuid", this.player.getUniqueId().toString());
        });
    }

    public void setSecondColor(Color color) {
        this.executorService.execute(() -> {
            Numaria.getInstance().getAdapter().updateInTable("module_player", "secondColor", color.getColor(), "uuid", this.player.getUniqueId().toString());
        });
    }

    public String getMainColor() {
        return Numaria.getInstance().getAdapter().getEntryFromTable("module_player", "uuid", this.player.getUniqueId().toString(), "mainColor");
    }

    public String getSecondColor() {
        return Numaria.getInstance().getAdapter().getEntryFromTable("module_player", "uuid", this.player.getUniqueId().toString(), "secondColor");
    }

    public void setCoins(int coins) {
        this.executorService.execute(() -> {
            Numaria.getInstance().getAdapter().updateInTable("module_player", "coins", String.valueOf(coins), "uuid", this.player.getUniqueId().toString());
        });
    }

    public int getCoins() {
        return Integer.parseInt(Numaria.getInstance().getAdapter().getEntryFromTable("module_player", "uuid", this.player.getUniqueId().toString(), "coins"));
    }

    public void createPlayer() {
        this.executorService.execute(() -> {
            Numaria.getInstance().getAdapter().addMoreInTable("module_player", Arrays.asList("uuid", "mainColor", "secondColor"), Arrays.asList(this.player.getUniqueId().toString(), Color.YELLOW.getColor(), Color.ORANGE.getColor()));
        });
    }

    public void login() {
        this.coins = this.getCoins();
        this.mainColor = this.getColor(this.getMainColor());
        this.secondColor = this.getColor(this.getSecondColor());
    };

    public void logout() {
        if (changed) {
            this.setCoins(this.coins);
            this.setMainColor(this.mainColor);
            this.setSecondColor(this.secondColor);
        }
    };

    public Color getColor(String colorCode) {
        byte var3 = -1;
        switch(colorCode.hashCode()) {
            case 5225:
                if (colorCode.equals("§0")) {
                    var3 = 0;
                }
                break;
            case 5227:
                if (colorCode.equals("§2")) {
                    var3 = 4;
                }
                break;
            case 5229:
                if (colorCode.equals("§4")) {
                    var3 = 1;
                }
                break;
            case 5231:
                if (colorCode.equals("§6")) {
                    var3 = 3;
                }
                break;
            case 5234:
                if (colorCode.equals("§9")) {
                    var3 = 2;
                }
                break;
            case 5274:
                if (colorCode.equals("§a")) {
                    var3 = 6;
                }
                break;
            case 5275:
                if (colorCode.equals("§b")) {
                    var3 = 5;
                }
                break;
            case 5276:
                if (colorCode.equals("§c")) {
                    var3 = 7;
                }
                break;
            case 5277:
                if (colorCode.equals("§d")) {
                    var3 = 8;
                }
                break;
            case 5278:
                if (colorCode.equals("§e")) {
                    var3 = 10;
                }
                break;
            case 5291:
                if (colorCode.equals("§r")) {
                    var3 = 9;
                }
        }

        switch (var3) {
            case 0 : return Color.BLACK;
            case 1 : return Color.RED;
            case 2 : return Color.BLUE;
            case 3 : return Color.ORANGE;
            case 4 : return Color.GREEN;
            case 5 : return Color.LIGHT_BLUE;
            case 6 : return Color.LIGHT_GREEN;
            case 7 : return Color.LIGHT_RED;
            case 8 : return Color.PINK;
            case 9 : return Color.WHITE;
            case 10 : return Color.YELLOW;
            default : return null;
        }
    }

    public Player player() {
        return player;
    }

    public Color getDataSecondColor() {
        return this.secondColor;
    }

    public Color getDataMainColor() {
        return this.mainColor;
    }

    public ItemStack getDataStack() {
        return colorStack;
    }

    public void setDataCoins(int coins) {
        if (!changed) this.changed = true;
        this.coins = coins;
    }

    public void setDataMainColor(Color color) {
        if (!changed) this.changed = true;
        this.mainColor = color;
    }

    public void setDataSecondColor(Color color) {
        if (!changed) this.changed = true;
        this.secondColor = color;
    }

    public int getDataCoins() {
        return coins;
    }
}
