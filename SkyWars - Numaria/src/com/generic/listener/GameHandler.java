package com.generic.listener;

import com.generic.protocol.game.api.GameBase;

public class GameHandler extends GameBase {

    static GameHandler instance;

    public GameHandler() {
        instance = this;
    }

    @Override
    public void onEnterVoted() {

    }

    @Override
    public void onEnterFight() {

    }

    @Override
    public void onEnterGameEnd() {

    }

    @Override
    public void onEnterLobby() {

    }

    public static GameHandler getInstance() {
        return instance;
    }
}
