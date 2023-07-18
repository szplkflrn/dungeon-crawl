package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Actor;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Objects;

public class Down implements KeyHandler {
    public static final KeyCode code = KeyCode.DOWN;

    @Override
    public void perform(KeyEvent event, GameMap map) {
        CellType neighbour = map.getCell(map.getPlayer().getX(), map.getPlayer().getY()).getNeighbor(0,1).getType();
        Actor neighbourOccupied = map.getCell(map.getPlayer().getX(), map.getPlayer().getY()).getNeighbor(0,1).getActor();
        if (code.equals(event.getCode()) && neighbour == CellType.FLOOR && neighbourOccupied == null)
            map.getPlayer().move(0, 1);
            map.getCell(map.getPlayer().getX(), map.getPlayer().getY()).setItem(null);
    }
}
