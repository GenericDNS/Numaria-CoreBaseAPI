package com.generic.protocol.game.api;

import com.generic.types.GameStates;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class GameBase extends JavaPlugin {

    private GameStates currentGameState;

    public void setGameState(GameStates gameState) {
        this.currentGameState = gameState;
        onGameStatesChange();
        switch (gameState) {
            case LOBBY: this.onEnterLobby();
                break;
            case STARTING: this.onEnterStarting();
                break;
            case VOTED: this.onEnterVoted();
                break;
            case RUNNING: this.onEnterRunning();
                break;
            case END_FIGHT: this.onEnterFight();
                break;
            case GAME_END: this.onEnterGameEnd();
                break;
            case RESETTING: this.onEnterResetting();
                break;
        }
    }

    public GameStates getCurrentGameState() {
        return currentGameState;
    }

    public abstract void onEnterStarting();

    public abstract void onEnterVoted();

    public abstract void onEnterRunning();

    public abstract void onEnterFight();

    public abstract void onEnterGameEnd();

    public abstract void onEnterResetting();

    public abstract void onEnterLobby();

    public abstract void onGameStatesChange();

}
