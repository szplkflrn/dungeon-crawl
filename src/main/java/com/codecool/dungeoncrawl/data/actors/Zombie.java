package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Zombie extends Actor{
    private  int health = 15;
    public Zombie(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "zombie";
    }
}
