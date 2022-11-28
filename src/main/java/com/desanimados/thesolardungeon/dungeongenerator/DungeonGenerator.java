package com.desanimados.thesolardungeon.dungeongenerator;

import com.desanimados.thesolardungeon.util.Position;
import com.desanimados.thesolardungeon.util.Randomizer;
import com.desanimados.thesolardungeon.dungeongenerator.settings.DungeonGenerationSettings;
import com.desanimados.thesolardungeon.util.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class DungeonGenerator extends Thread {
    public DungeonGenerationSettings settings;

    public DungeonGenerator(DungeonGenerationSettings settings) {
        this.settings = settings;
    }

    public Rectangle getSafeCellRectangle(int cellX, int cellY) {
        return new Rectangle(
            cellX * settings.cellSize.width
                + settings.cellPadding.left
                + settings.roomSize.maxRoomWidth / 2,
            cellY * settings.cellSize.height
                + settings.cellPadding.top
                + settings.roomSize.maxRoomHeight / 2,
            settings.cellSize.width
                - settings.cellPadding.left
                - settings.cellPadding.right
                - settings.roomSize.maxRoomWidth,
            settings.cellSize.height
                - settings.cellPadding.top
                - settings.cellPadding.bottom
                - settings.roomSize.maxRoomHeight
        );
    }

    public boolean[][] generateDungeonGrid() {
        boolean[][] dungeonGrid = new boolean[settings.gridSize.width][settings.gridSize.height];

        int[] rowRooms = new int[settings.gridSize.width];
        int[] columnRooms = new int[settings.gridSize.height];

        for (int x = 0; x < settings.gridSize.width; x++) {
            if (columnRooms[x] >= settings.gridLimits.maxColumnRooms) continue;

            for (int y = 0; y < settings.gridSize.height; y++) {
                if (
                    rowRooms[y] >= settings.gridLimits.maxRowRooms
                    || !Randomizer.getChance(settings.roomChance.chance)
                ) continue;

                dungeonGrid[x][y] = true;
                columnRooms[x]++;
                rowRooms[y]++;
            }
        }

        return dungeonGrid;
    }

    public Room[][] generateRooms(boolean[][] dungeonGrid) {
        Room[][] roomGrid = new Room[settings.gridSize.width][settings.gridSize.height];

        for (int x = 0; x < settings.gridSize.width; x++) {
            for (int y = 0; y < settings.gridSize.height; y++) {
                if (!dungeonGrid[x][y]) continue;

                Rectangle cellRectangle = getSafeCellRectangle(x, y);
                Position roomCenter = Randomizer.getPointInRectangle(cellRectangle);

                roomGrid[x][y] = new Room(
                    roomCenter.x,
                    roomCenter.y,
                    Randomizer.getBetween(settings.roomSize.minRoomWidth, settings.roomSize.maxRoomWidth),
                    Randomizer.getBetween(settings.roomSize.minRoomHeight, settings.roomSize.maxRoomHeight)
                );
            }
        }

        return roomGrid;
    }

    public List<Corridor> generateCorridors(Room[][] roomGrid) {
        List<Corridor> corridorList = new ArrayList<Corridor>();

        for (int x = 0; x < settings.gridSize.width; x++) {
            for (int y = 0; y < settings.gridSize.height; y++) {
                if (roomGrid[x][y] == null) continue;

                // Connect to room at right
                if (x < settings.gridSize.width - 1 && roomGrid[x + 1][y] != null) {
                    corridorList.add(roomGrid[x][y].makeRoomTo(roomGrid[x + 1][y]));
                }
                // Connect to room below
                if (y < settings.gridSize.height - 1 && roomGrid[x][y + 1] != null) {
                    corridorList.add(roomGrid[x][y].makeRoomTo(roomGrid[x][y + 1]));
                }
            }
        }

        return corridorList;
    }

    public void clearUnconnectedRooms(Room[][] roomGrid) {
        for (int x = 0; x < settings.gridSize.width; x++) {
            for (int y = 0; y < settings.gridSize.height; y++) {
                if (roomGrid[x][y] == null) continue;

                if (roomGrid[x][y].getConnectionAmount() == 0) {
                    roomGrid[x][y] = null;
                }
            }
        }
    }
}
