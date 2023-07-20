package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Actor;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Random;

public class Left implements KeyHandler {

    @Override
    public void perform(KeyEvent event, GameMap map) {
        if (KeyCode.LEFT.equals(event.getCode()) || KeyCode.A.equals(event.getCode())) {
            map.getPlayer().move(-1, 0);
            map.getWizard().wizardMove();
        }
    }
}
