package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Wand extends Item{

    public Wand(Cell cell) {

        super(cell);
    }

    @Override
    public String getTileName() {
        return "wand";
    }
}
