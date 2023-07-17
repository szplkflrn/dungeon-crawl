package com.codecool.dungeoncrawl.data;

public enum CellType {
    EMPTY("empty"),
    FLOOR("floor"),
    WALL("wall"),
    SWORD("sword"),
    KEY("key"),
    SKELETON("skeleton");


    private final String tileName;

    CellType(String tileName) {
        this.tileName = tileName;
    }

    public String getTileName() {
        return tileName;
    }
}
