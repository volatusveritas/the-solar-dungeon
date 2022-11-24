package com.desanimados.thesolardungeon;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public final class Renderer {
    private static Renderer instance;
    Stage stage;
    GraphicsContext graphicsContext;

    public static Renderer getInstance() {
        return instance;
    }

    public static void init(Stage stage) {
        instance = new Renderer();
        instance.stage = stage;

        final Group group = new Group();
        final Scene scene = new Scene(group, 640, 480);
        final Canvas canvas = new Canvas(640, 480);

        instance.graphicsContext = canvas.getGraphicsContext2D();
        instance.graphicsContext.setFill(Color.BLACK);

        group.getChildren().add(canvas);

        stage.setTitle("The Solar Dungeon");
        stage.setScene(scene);
    }

    public void drawRect(int x, int y, int width, int height) {
        graphicsContext.fillRect(x, y, width, height);
    }

    public void start() {
        stage.show();
    }
}
