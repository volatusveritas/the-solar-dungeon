package com.desanimados.thesolardungeon.dungeongenerator;

import com.desanimados.thesolardungeon.util.Position;
import com.desanimados.thesolardungeon.util.Rectangle;

public class Room {
    Rectangle rectangle;

    public Room(int centerX, int centerY, int width, int height) {
        rectangle = new Rectangle(
            centerX - width / 2,
            centerY - height / 2,
            width, height
        );
    }

    public void draw() {
        rectangle.draw();
    }
}
