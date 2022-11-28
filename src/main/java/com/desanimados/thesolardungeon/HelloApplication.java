package com.desanimados.thesolardungeon;

import com.desanimados.thesolardungeon.dungeongenerator.Corridor;
import com.desanimados.thesolardungeon.dungeongenerator.Dungeon;
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

        Dungeon dungeon = new Dungeon();
        dungeon.generate();
        dungeon.draw();
    }

    public static void main(String[] args) {
        launch();
    }
}