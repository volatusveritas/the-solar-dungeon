package com.desanimados.thesolardungeon.dungeongenerator;

import com.desanimados.thesolardungeon.Renderer;
import com.desanimados.thesolardungeon.dungeongenerator.settings.DungeonGenerationSettings;
import com.desanimados.thesolardungeon.util.Position;

import java.util.ArrayList;
import java.util.List;

public class Dungeon {
    private DungeonGenerationSettings settings;
    private List<Room> rooms = null;
    private List<Corridor> corridors = null;

    public Dungeon() {
        settings = new DungeonGenerationSettings();
    }

    public Dungeon(DungeonGenerationSettings settings) {
        this.settings = settings;
    }

    public DungeonGenerationSettings getSettings() { return settings; }

    public List<Room> getRooms() { return rooms; }

    public List<Corridor> getCorridors() { return corridors; }

    public void generate() {
        DungeonGenerator dungeonGenerator = new DungeonGenerator(settings);
        boolean[][] dungeonGrid = dungeonGenerator.generateDungeonGrid();
        Room[][] roomGrid = dungeonGenerator.generateRooms(dungeonGrid);

        corridors = dungeonGenerator.generateCorridors(roomGrid);

        dungeonGenerator.clearUnconnectedRooms(roomGrid);

        rooms = new ArrayList<Room>();

        for (int x = 0; x < settings.gridSize.width; x++) {
            for (int y = 0; y < settings.gridSize.height; y++) {
                if (roomGrid[x][y] == null) continue;

                rooms.add(roomGrid[x][y]);
            }
        }
    }

    public void draw(Position offset) {
        for (Room room : rooms) {
            room.draw(settings.roomCornerRadius.radius, offset);
        }

        for (Corridor corridor : corridors) {
            corridor.draw(settings.corridorSize.size, offset);
        }
    }

    public void cleanDraw(Position offset) {
        Renderer.getInstance().clearCanvas();
        draw(offset);
    }
}
