package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Actor;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Random;

public class Up implements KeyHandler {

    @Override
    public void perform(KeyEvent event, GameMap map) {
        if (KeyCode.UP.equals(event.getCode()) || KeyCode.W.equals(event.getCode())) {
            map.getPlayer().move(0, -1);
            map.getWizard().wizardMove();
        }
    }
}
