package com.desanimados.thesolardungeon.util;

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
}
