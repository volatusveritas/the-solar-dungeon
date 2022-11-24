package com.desanimados.thesolardungeon.dungeongenerator;

import com.desanimados.thesolardungeon.util.Position;
import com.desanimados.thesolardungeon.util.Randomizer;
import com.desanimados.thesolardungeon.dungeongenerator.settings.DungeonGenerationSettings;
import com.desanimados.thesolardungeon.util.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class DungeonGenerator extends Thread {
    private DungeonGenerationSettings settings = new DungeonGenerationSettings();

    public Rectangle getCellRectangle(int cellX, int cellY) {
        return new Rectangle(
            cellX * settings.cellSize.width + settings.cellPadding.left + settings.roomSize.maxRoomWidth / 2,
            cellY * settings.cellSize.height + settings.cellPadding.top + settings.roomSize.maxRoomHeight / 2,
            settings.cellSize.width - settings.cellPadding.right - settings.roomSize.maxRoomWidth / 2,
            settings.cellSize.height - settings.cellPadding.bottom - settings.roomSize.maxRoomHeight / 2
        );
    }

    public boolean[][] generateRoomGrid() {
        boolean[][] roomGrid = new boolean[settings.gridSize.width][settings.gridSize.height];

        int[] rowRooms = new int[settings.gridSize.width];
        int[] columnRooms = new int[settings.gridSize.height];

        for (int x = 0; x < settings.gridSize.width; x++) {
            if (columnRooms[x] >= settings.gridLimits.maxColumnRooms) continue;

            for (int y = 0; y < settings.gridSize.height; y++) {
                if (
                    rowRooms[y] >= settings.gridLimits.maxRowRooms
                    || !Randomizer.getChance(settings.roomChance.chance)
                ) continue;

                roomGrid[x][y] = true;
                columnRooms[x]++;
                rowRooms[y]++;
            }
        }

        return roomGrid;
    }

    public List<Room> generateRooms(boolean[][] roomGrid) {
        List<Room> roomList = new ArrayList<Room>();

        for (int x = 0; x < settings.gridSize.width; x++) {
            for (int y = 0; y < settings.gridSize.height; y++) {
                if (!roomGrid[x][y]) continue;

                Rectangle cellRectangle = getCellRectangle(x, y);
                Position roomCenter = Randomizer.getPointInRectangle(cellRectangle);

                roomList.add(new Room(
                    roomCenter.x,
                    roomCenter.y,
                    Randomizer.getBetween(settings.roomSize.minRoomWidth, settings.roomSize.maxRoomWidth),
                    Randomizer.getBetween(settings.roomSize.minRoomHeight, settings.roomSize.maxRoomHeight)
                ));
            }
        }

        return roomList;
    }
}
