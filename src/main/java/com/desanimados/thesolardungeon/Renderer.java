package com.desanimados.thesolardungeon;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public final class Renderer {
    private static final Color FOREGROUND_COLOR = Color.valueOf("#70798C");
    private static final Color BACKGROUND_COLOR = Color.valueOf("#252323");
    private static Renderer instance;
    private Stage stage;
    private Scene scene;
    GraphicsContext graphicsContext;

    public static Renderer getInstance() {
        return instance;
    }

    public static GraphicsContext getGraphicsContext() { return instance.graphicsContext; }

    public static void init(Stage stage) {
        instance = new Renderer();
        instance.stage = stage;

        final Group group = new Group();
        instance.scene = new Scene(group, 640, 640);
        final Canvas canvas = new Canvas(640, 640);

        instance.graphicsContext = canvas.getGraphicsContext2D();
        instance.graphicsContext.setFill(FOREGROUND_COLOR);
        instance.graphicsContext.setStroke(FOREGROUND_COLOR);
        instance.clearCanvas();

        group.getChildren().add(canvas);

        stage.setTitle("The Solar Dungeon");
        stage.setScene(instance.scene);
    }

    public Stage getState() { return stage; }

    public Scene getScene() { return scene; }

    public void clearCanvas() {
        graphicsContext.setFill(BACKGROUND_COLOR);
        graphicsContext.fillRect(
            0, 0,
            graphicsContext.getCanvas().getWidth(),
            graphicsContext.getCanvas().getHeight()
        );
        graphicsContext.setFill(FOREGROUND_COLOR);
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
