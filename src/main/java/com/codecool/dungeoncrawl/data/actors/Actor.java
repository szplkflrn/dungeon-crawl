package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Actor implements Drawable {

    private List<String> inventory = new ArrayList<>();
    private Cell cell;
    private int health = 10;

    Random random = new Random();
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
        } else if (nextCell.getActor() != null){
            battle(nextCell);
        }
    }

    public void skeletonMove(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.getType() == CellType.FLOOR) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }

    public void wizardMove(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.getType() != CellType.WALL) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }

    public void battle(Cell nextCell){
        if (inventory.contains("sword")) {
        nextCell.getActor().setHealth(10);
        } else {
            nextCell.getActor().setHealth(5);
        }
        cell.getActor().setHealth(2);
        if(nextCell.getActor().getHealth()<=0){
            nextCell.setActor(null);
        } else if(cell.getActor().getHealth()<=0){
            cell.setActor(null);
        }
    }


    public int getHealth() {

        return health;
    }

    public int setHealth(int hit) {
        return health = health - hit;
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
