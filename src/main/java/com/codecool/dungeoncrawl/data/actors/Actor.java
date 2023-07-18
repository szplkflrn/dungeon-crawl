package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health = 10;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.getType() == CellType.FLOOR && nextCell.getActor() == null) {
            cell.setItem(null);
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        } else if (nextCell.getType() == CellType.FLOOR && nextCell.getActor() != null){
            battle(nextCell);
        }
    }

    public void battle(Cell nextCell){
        nextCell.getActor().setHealth(5);
        cell.getActor().setHealth(2);
        if(nextCell.getActor().getHealth()<=0){
            nextCell.setActor(null);
        } else if(cell.getActor().getHealth()<=0){
            System.out.println("Game OVER");

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
}
