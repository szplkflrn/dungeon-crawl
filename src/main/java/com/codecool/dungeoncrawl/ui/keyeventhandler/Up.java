package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Actor;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Up implements KeyHandler {
    public static final KeyCode code = KeyCode.UP;

    @Override
    public void perform(KeyEvent event, GameMap map) {
        if (KeyCode.UP.equals(event.getCode()) || KeyCode.W.equals(event.getCode())) {
            map.getPlayer().move(0, -1);
            if (map.getWizard().getCell() != map.getPlayer().getCell() &&
                    map.getSkeleton().getCell() != map.getPlayer().getCell() &&
                    map.getWizard().getCell() != map.getSkeleton().getCell()) {
                map.getWizard().wizardMove();
                map.getSkeleton().skeletonMove();
            }

        }
    }
}
