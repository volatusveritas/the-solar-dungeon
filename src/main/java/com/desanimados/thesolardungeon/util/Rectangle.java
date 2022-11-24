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

    public void draw() {
        Renderer.getInstance().drawRect(position.x, position.y, size.width, size.height);
    }
}
