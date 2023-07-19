package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Actor;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Random;

public class Up implements KeyHandler {
    public static final KeyCode code = KeyCode.UP;
    Random random = new Random();

    @Override
    public void perform(KeyEvent event, GameMap map) {
        if(code.equals(event.getCode())) {
            map.getPlayer().move(0, -1);
            map.getSkeleton().skeletonMove(random.nextInt(2),random.nextInt(2));
            map.getWizard().wizardMove(0,-1);
        }
    }
}
