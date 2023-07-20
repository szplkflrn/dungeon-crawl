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

    public boolean freeToMove(Cell nextcell){
        return nextcell.getType() == CellType.FLOOR ||
                nextcell.getType() == CellType.OPENEDDOOR;
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (cell.getActor() != null) {
            if (freeToMove(nextCell) && nextCell.getActor() == null) {
                if (nextCell.getItem() != null) {
                    inventory.add(nextCell.getItem().getTileName());
                }
                nextCell.setItem(null);
                cell.setActor(null);
                nextCell.setActor(this);
                cell = nextCell;
            } else if (nextCell.getActor() != null) {
                battleTheMonsters(nextCell);
            } else if (nextCell.getType() == CellType.CLOSEDDOOR) {
                openTheDoor(nextCell);
            }
        }
    }

    public void skeletonMove(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.getType() == CellType.FLOOR) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
        isTheMonsterDead(nextCell);
    }

    public void wizardMove() {
        Cell nextCell = cell.getNeighbor(random.nextInt(3) - 1, random.nextInt(3) - 1);
        if (cell.getActor() != null) {
            if (nextCell.getActor() == null && (nextCell.getX() > 0 && nextCell.getX() < 24 &&
                    nextCell.getY() > 0 && nextCell.getY() < 19)) {
                cell.setActor(null);
                nextCell.setActor(this);
                cell = nextCell;
            }
        }
    }


    public void battleTheMonsters(Cell nextCell){
        if (inventory.contains("sword")) {
        nextCell.getActor().setHealth(10);
        } else {
            nextCell.getActor().setHealth(5);
        }
        cell.getActor().setHealth(2);
        isTheMonsterDead(nextCell);
        areWeDead();
    }

    public void openTheDoor(Cell nextCell) {
        if (cell.getActor().inventory.contains("key")) {
            nextCell.setType(CellType.OPENEDDOOR);
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }

    public void isTheMonsterDead(Cell nextCell){
        if (nextCell.getActor().getHealth() <= 0) {
            nextCell.setActor(null);
        }
    }
    public void areWeDead(){
        if (cell.getActor().getHealth() <= 0) {
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
