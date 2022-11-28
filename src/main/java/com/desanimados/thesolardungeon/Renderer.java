package com.desanimados.thesolardungeon;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public final class Renderer {
    private static final String FOREGROUND_COLOR = "#70798C";
    private static final String BACKGROUND_COLOR = "#252323";
    private static Renderer instance;
    Stage stage;
    GraphicsContext graphicsContext;

    public static Renderer getInstance() {
        return instance;
    }

    public static GraphicsContext getGraphicsContext() { return instance.graphicsContext; }

    public static void init(Stage stage) {
        instance = new Renderer();
        instance.stage = stage;

        final Group group = new Group();
        final Scene scene = new Scene(group, 640, 640);
        final Canvas canvas = new Canvas(640, 640);

        instance.graphicsContext = canvas.getGraphicsContext2D();
        instance.graphicsContext.setFill(Color.valueOf(BACKGROUND_COLOR));
        instance.graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        instance.graphicsContext.setFill(Color.valueOf(FOREGROUND_COLOR));
        instance.graphicsContext.setStroke(Color.valueOf(FOREGROUND_COLOR));

        group.getChildren().add(canvas);

        stage.setTitle("The Solar Dungeon");
        stage.setScene(scene);
    }

    public void drawRoundRect(int x, int y, int width, int height, int arcSize) {
        graphicsContext.fillRoundRect(x, y, width, height, arcSize, arcSize);
    }

    public void drawLine(int fromX, int fromY, int toX, int toY) {
        graphicsContext.strokeLine(fromX, fromY, toX, toY);
    }

    public void start() {
        stage.show();
    }
}
