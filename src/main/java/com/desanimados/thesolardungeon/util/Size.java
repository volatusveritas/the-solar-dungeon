package com.desanimados.thesolardungeon.util;

public class Size {
    public int width;
    public int height;

    public Size(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void subtract(int width, int height) {
        this.width -= width;
        this.height -= height;
    }
}
