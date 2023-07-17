package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Up implements KeyHandler {
    public static final KeyCode code = KeyCode.UP;

    @Override
    public void perform(KeyEvent event, GameMap map) {
        CellType neighbour = map.getCell(map.getPlayer().getX(), map.getPlayer().getY()).getNeighbor(0,-1).getType();
        if(code.equals(event.getCode()) && neighbour != CellType.WALL)
            map.getPlayer().move(0, -1);
    }
}
