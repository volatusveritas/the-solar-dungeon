package com.desanimados.thesolardungeon.util;

import com.desanimados.thesolardungeon.Renderer;

public class Position {
    public int x;
    public int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void add(Position other) {
        x += other.x;
        y += other.y;
    }

    public void drawLineTo(Position other, float width) {
        Renderer.getGraphicsContext().setLineWidth(width);
        Renderer.getInstance().drawLine(x, y, other.x, other.y);
    }
}
