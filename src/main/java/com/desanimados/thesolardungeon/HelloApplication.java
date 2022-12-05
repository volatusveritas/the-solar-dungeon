package com.desanimados.thesolardungeon;

import com.desanimados.thesolardungeon.dungeongenerator.Dungeon;
import com.desanimados.thesolardungeon.util.Position;
import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicBoolean;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        Renderer.init(stage);
        Renderer.getInstance().start();

        Dungeon dungeon = new Dungeon();
        dungeon.generate();

        Position offset = new Position();

        dungeon.cleanDraw(offset);

        AtomicBoolean speedBonusActive = new AtomicBoolean(false);

        final int MOVEMENT_SPEED = 16;
        final int SPEED_BONUS = 48;

        Renderer.getInstance().getScene().addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
            if (key.getCode() == KeyCode.SHIFT) {
                speedBonusActive.set(false);
            }
        });

        Renderer.getInstance().getScene().addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            switch (key.getCode()) {
                case SHIFT:
                    speedBonusActive.set(true);
                    break;
                case ENTER:
                    dungeon.generate();
                    break;
                case D:
                    offset.x -= MOVEMENT_SPEED + (speedBonusActive.get() ? SPEED_BONUS : 0);
                    break;
                case A:
                    offset.x += MOVEMENT_SPEED + (speedBonusActive.get() ? SPEED_BONUS : 0);
                    break;
                case W:
                    offset.y += MOVEMENT_SPEED + (speedBonusActive.get() ? SPEED_BONUS : 0);
                    break;
                case S:
                    offset.y -= MOVEMENT_SPEED + (speedBonusActive.get() ? SPEED_BONUS : 0);
                    break;
                default:
                    return;
            }

            dungeon.cleanDraw(offset);
        });
    }

    public static void main(String[] args) {
        launch();
    }
}