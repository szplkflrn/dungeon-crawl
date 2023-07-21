package com.codecool.dungeoncrawl.data;

public enum CellType {
    EMPTY("empty"),
    FLOOR("floor"),
    CLOSEDDOOR("closeddoor"),
    ENDTILE("endtile"),
    OPENEDDOOR("openeddoor"),
    WALL("wall"),
    TREE("tree");


    private final String tileName;

    CellType(String tileName) {
        this.tileName = tileName;
    }

    public String getTileName() {
        return tileName;
    }
}
