package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Wizard;
import com.codecool.dungeoncrawl.data.actors.Zombie;
import com.codecool.dungeoncrawl.data.items.Key;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.Skeleton;
import com.codecool.dungeoncrawl.data.items.Portal;
import com.codecool.dungeoncrawl.data.items.Sword;
import com.codecool.dungeoncrawl.data.items.Wand;

import java.io.InputStream;
import java.util.Scanner;

public class MapLoader {
        public static GameMap loadMap(String path) {
            InputStream is = MapLoader.class.getResourceAsStream(path);
            Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine(); // empty line

        GameMap map = new GameMap(width, height, CellType.EMPTY);
        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case 'k':
                            cell.setType(CellType.FLOOR);
                            new Key(cell);
                            break;
                        case 'v':
                            cell.setType(CellType.FLOOR);
                            new Sword(cell);
                            break;
                        case 't':
                            cell.setType(CellType.TREE);
                            break;
                        case 'p':
                            cell.setType(CellType.FLOOR);
                            new Portal(cell);
                            break;
                        case 'e':
                            cell.setType(CellType.ENDTILE);
                            break;
                        case 'x':
                            cell.setType(CellType.FLOOR);
                            new Wand(cell);
                            break;
                        case 'c':
                            cell.setType(CellType.CLOSEDDOOR);
                            break;
                        case 'o':
                            cell.setType(CellType.OPENEDDOOR);
                            break;
                        case 's':
                            cell.setType(CellType.FLOOR);
                            map.setSkeleton(new Skeleton(cell));
                            break;
                        case 'w':
                            cell.setType(CellType.FLOOR);
                            map.setWizard(new Wizard(cell));
                            break;
                        case 'z':
                            cell.setType(CellType.FLOOR);
                            new Zombie(cell);
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            map.setPlayer(new Player(cell));
                            break;
                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }

}
