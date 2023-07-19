package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMap;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Random;

public class Down implements KeyHandler {
    public static final KeyCode code = KeyCode.DOWN;

    Random random = new Random();

    @Override
    public void perform(KeyEvent event, GameMap map) {
        if (code.equals(event.getCode())) {
            map.getPlayer().move(0, 1);
            map.getSkeleton().skeletonMove(random.nextInt(2),random.nextInt(2));
            map.getWizard().wizardMove(random.nextInt(2),random.nextInt(2));
        }
    }
}
