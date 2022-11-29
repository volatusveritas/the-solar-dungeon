package com.desanimados.thesolardungeon.util;

import com.desanimados.thesolardungeon.Renderer;

public class Position {
    public int x;
    public int y;

    public Position() {
        x = 0;
        y = 0;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void add(Position other) {
        x += other.x;
        y += other.y;
    }

    public void drawLineTo(Position other, float width, Position offset) {
        Renderer.getGraphicsContext().setLineWidth(width);
        Renderer.getInstance().drawLine(
            x + offset.x, y + offset.y,
            other.x + offset.x, other.y + offset.y
        );
    }
}
