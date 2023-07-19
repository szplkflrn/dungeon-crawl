package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMap;
import javafx.scene.input.KeyEvent;

import java.util.Random;

public interface KeyHandler {

    void perform(KeyEvent event, GameMap map);
}
