package com.desanimados.thesolardungeon.util;

import com.desanimados.thesolardungeon.Renderer;

public class Rectangle {
    public Position position;
    public Size size;

    public Rectangle(int x, int y, int width, int height) {
        position = new Position(x, y);
        size = new Size(width, height);
    }

    public Position getEndAnchor() {
        return new Position(
            position.x + size.width - 1,
            position.y + size.height - 1
        );
    }

    public Position getCenter() {
        return new Position(
            position.x + size.width / 2,
            position.y + size.height / 2
        );
    }

    public void draw(int arcSize, Position offset) {
        Renderer.getInstance().drawRoundRect(
            position.x + offset.x, position.y + offset.y,
            size.width, size.height,
            arcSize
        );
    }
}
