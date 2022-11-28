package com.desanimados.thesolardungeon.dungeongenerator.settings;

public class DungeonGenerationSettings {
    public GridSize gridSize;
    public CellSize cellSize;
    public CellPadding cellPadding;
    public GridLimits gridLimits;
    public RoomSize roomSize;
    public CorridorSize corridorSize;
    public RoomChance roomChance;
    public RoomCornerRadius roomCornerRadius;

    public DungeonGenerationSettings() {
        gridSize = new GridSize();
        cellSize = new CellSize();
        cellPadding = new CellPadding();
        gridLimits = new GridLimits();
        roomSize = new RoomSize();
        corridorSize = new CorridorSize();
        roomChance = new RoomChance();
        roomCornerRadius = new RoomCornerRadius();
    }

    public boolean isValid() {
        return gridSize.isValid()
            && cellSize.isValid()
            && cellPadding.isValid()
            && gridLimits.isValid()
            && roomSize.isValid()
            && roomChance.isValid()
            && roomCornerRadius.isValid()
            && corridorSize.isValid()
            && corridorSize.size <= roomSize.maxRoomWidth
            && corridorSize.size <= roomSize.maxRoomHeight;
    }
}

