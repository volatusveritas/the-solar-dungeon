package com.desanimados.thesolardungeon.dungeongenerator.settings;

interface ValidatedSetting {
    boolean isValid();
}

public class DungeonGenerationSettings {
    public GridSize gridSize;
    public CellSize cellSize;
    public CellPadding cellPadding;
    public GridLimits gridLimits;
    public RoomSize roomSize;
    public CorridorSize corridorSize;

    public boolean isValid() {
        return gridSize.isValid()
            && cellSize.isValid()
            && cellPadding.isValid()
            && gridLimits.isValid()
            && roomSize.isValid()
            && corridorSize.isValid();
    }
}

class GridSize implements ValidatedSetting {
    public static final int MIN_SIDE_LENGTH = 4;

    public int width;
    public int height;

    public boolean isValid() {
        return width >= MIN_SIDE_LENGTH
            && height >= MIN_SIDE_LENGTH;
    }
}

class CellSize implements ValidatedSetting {
    public static final int MIN_SIDE_LENGTH = 80;

    public int width;
    public int height;

    public boolean isValid() {
        return width >= MIN_SIDE_LENGTH
            && height >= MIN_SIDE_LENGTH;
    }
}

class CellPadding implements ValidatedSetting {
    public static final int MIN_SIZE = 16;

    public int left;
    public int right;
    public int top;
    public int bottom;

    public boolean isValid() {
        return left >= MIN_SIZE
            && right >= MIN_SIZE
            && top >= MIN_SIZE
            && bottom >= MIN_SIZE;
    }
}

class GridLimits implements ValidatedSetting {
    public static final int MIN_AMOUNT_LIMIT = 2;

    public int maxRowRooms;
    public int maxColumnRooms;

    public boolean isValid() {
        return maxRowRooms >= MIN_AMOUNT_LIMIT
            && maxColumnRooms >= MIN_AMOUNT_LIMIT;
    }
}

class RoomSize implements ValidatedSetting {
    public static final int MIN_SIDE_LENGTH = 32;

    public int minRoomWidth;
    public int maxRoomWidth;
    public int minRoomHeight;
    public int maxRoomHeight;

    public boolean isValid() {
        return minRoomWidth >= MIN_SIDE_LENGTH
            && maxRoomWidth >= MIN_SIDE_LENGTH
            && minRoomHeight >= MIN_SIDE_LENGTH
            && maxRoomHeight >= MIN_SIDE_LENGTH
            && minRoomWidth <= maxRoomWidth
            && minRoomHeight <= maxRoomHeight;
    }
}

class CorridorSize implements ValidatedSetting {
    public static final int MIN_SIZE = 8;

    public int size;

    public boolean isValid() {
        return size >= MIN_SIZE;
    }
}