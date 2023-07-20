package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMap;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Random;

public class Down implements KeyHandler {

    @Override
    public void perform(KeyEvent event, GameMap map) {
        if (KeyCode.DOWN.equals(event.getCode()) || KeyCode.S.equals(event.getCode())) {
            map.getPlayer().move(0, 1);
            map.getWizard().wizardMove();
        }
    }
}
