package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;

import java.util.ArrayList;
import java.util.List;

public abstract class Actor implements Drawable {

    private List<String> inventory = new ArrayList<>();
    private Cell cell;
    private int health = 10;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if(nextCell.getType() == CellType.FLOOR && nextCell.getActor() == null) {
            if (nextCell.getItem() != cell.getItem()) {
            inventory.add(nextCell.getItem().getTileName());
            }
            nextCell.setItem(null);
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
        System.out.println(inventory);
    }

    public int getHealth() {

        return health;
    }

    public Cell getCell() {

        return cell;
    }

    public int getX() {

        return cell.getX();
    }

    public int getY() {

        return cell.getY();
    }

    public List<String> getInventory() {
        return inventory;
    }
}
