package com.desanimados.thesolardungeon;

import com.desanimados.thesolardungeon.dungeongenerator.Corridor;
import com.desanimados.thesolardungeon.dungeongenerator.DungeonGenerator;
import com.desanimados.thesolardungeon.dungeongenerator.Room;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        Renderer.init(stage);
        Renderer.getInstance().start();

        DungeonGenerator dungeonGenerator = new DungeonGenerator();
        boolean[][] dungeonGrid = dungeonGenerator.generateDungeonGrid();
        Room[][] roomGrid = dungeonGenerator.generateRooms(dungeonGrid);
        List<Corridor> corridorList = dungeonGenerator.generateCorridors(roomGrid);

        for (int x = 0; x < dungeonGenerator.settings.gridSize.width; x++) {
            for (int y = 0; y < dungeonGenerator.settings.gridSize.height; y++) {
                if (roomGrid[x][y] == null) continue;

                roomGrid[x][y].draw();
            }
        }

        for (Corridor corridor : corridorList) {
            corridor.draw(dungeonGenerator.settings.corridorSize.size);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}