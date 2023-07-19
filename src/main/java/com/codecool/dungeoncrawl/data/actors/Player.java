package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.List;

public class Player extends Actor {
    private static List<String> inventory;

    public Player(Cell cell) {

        super(cell);
    }

    public String getTileName() {

        return "player";
    }
}
