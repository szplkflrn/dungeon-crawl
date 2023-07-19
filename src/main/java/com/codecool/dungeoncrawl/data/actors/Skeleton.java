package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.List;

public class Skeleton extends Actor {
    private static List<String> inventory;

    public Skeleton(Cell cell) {

        super(cell);
    }

    @Override
    public String getTileName() {

        return "skeleton";
    }
}
