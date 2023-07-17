package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Sword extends Actor {
    public Sword(Cell cell) {

        super(cell);
    }

    @Override
    public String getTileName() {
        return "sword";
    }
}
