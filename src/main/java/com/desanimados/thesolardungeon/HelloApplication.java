package com.desanimados.thesolardungeon;

import com.desanimados.thesolardungeon.dungeongenerator.Corridor;
import com.desanimados.thesolardungeon.dungeongenerator.Dungeon;
import com.desanimados.thesolardungeon.dungeongenerator.DungeonGenerator;
import com.desanimados.thesolardungeon.dungeongenerator.Room;
import com.desanimados.thesolardungeon.util.Position;
import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        Renderer.init(stage);
        Renderer.getInstance().start();

        Dungeon dungeon = new Dungeon();
        dungeon.generate();

        Position offset = new Position();

        dungeon.cleanDraw(offset);

        final int MOVEMENT_SPEED = 16;

        Renderer.getInstance().getScene().addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if (key.getCode() == KeyCode.D) {
                offset.x -= MOVEMENT_SPEED;
            } else if (key.getCode() == KeyCode.A) {
                offset.x += MOVEMENT_SPEED;
            } else if (key.getCode() == KeyCode.W) {
                offset.y += MOVEMENT_SPEED;
            } else if (key.getCode() == KeyCode.S) {
                offset.y -= MOVEMENT_SPEED;
            } else {
                return;
            }

            dungeon.cleanDraw(offset);
        });
    }

    public static void main(String[] args) {
        launch();
    }
}