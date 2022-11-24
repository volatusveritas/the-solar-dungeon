package com.desanimados.thesolardungeon;

import com.desanimados.thesolardungeon.dungeongenerator.DungeonGenerator;
import com.desanimados.thesolardungeon.dungeongenerator.Room;
import com.desanimados.thesolardungeon.util.Rectangle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        Renderer.init(stage);
        Renderer.getInstance().start();

        DungeonGenerator dungeonGenerator = new DungeonGenerator();
        boolean[][] roomGrid = dungeonGenerator.generateRoomGrid();
        List<Room> roomList = dungeonGenerator.generateRooms(roomGrid);

        for (Room room : roomList) {
            room.draw();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}