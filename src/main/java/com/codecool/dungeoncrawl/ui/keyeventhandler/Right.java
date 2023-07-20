package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Actor;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Random;

public class Right implements KeyHandler {
    public static final KeyCode code = KeyCode.RIGHT;
    Random random = new Random();

    @Override
    public void perform(KeyEvent event, GameMap map) {
        if(code.equals(event.getCode())) {
            map.getPlayer().move(1, 0);
            if (map.getWizard().getCell() != map.getPlayer().getCell() &&
                    map.getSkeleton().getCell() != map.getPlayer().getCell() &&
                    map.getWizard().getCell() != map.getSkeleton().getCell()) {
                map.getWizard().wizardMove();
                map.getSkeleton().skeletonMove();
            }
        }
    }
}
