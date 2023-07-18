package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Actor;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Right implements KeyHandler {
    public static final KeyCode code = KeyCode.RIGHT;

    @Override
    public void perform(KeyEvent event, GameMap map) {
        CellType neighbour = map.getCell(map.getPlayer().getX(), map.getPlayer().getY()).getNeighbor(1,0).getType();
        Actor neighbourOccupied = map.getCell(map.getPlayer().getX(), map.getPlayer().getY()).getNeighbor(1,0).getActor();
        if(code.equals(event.getCode())  && neighbour == CellType.FLOOR && neighbourOccupied == null)
            map.getPlayer().move(1, 0);
        map.getCell(map.getPlayer().getX(), map.getPlayer().getY()).setItem(null);
    }
}
