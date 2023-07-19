package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Wizard extends Actor {

    public Wizard(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "wizard";
    }
}
