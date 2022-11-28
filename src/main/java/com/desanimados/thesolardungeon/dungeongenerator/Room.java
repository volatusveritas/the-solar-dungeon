package com.desanimados.thesolardungeon.dungeongenerator;

import com.desanimados.thesolardungeon.util.Rectangle;

public class Room {
    Rectangle rectangle;
    int connectionAmount = 0;

    public Room(int centerX, int centerY, int width, int height) {
        rectangle = new Rectangle(
            centerX - width / 2,
            centerY - height / 2,
            width, height
        );
    }

    public int getConnectionAmount() { return connectionAmount; }

    public Corridor makeRoomTo(Room target) {
        connectionAmount++;
        target.connectionAmount++;

        return new Corridor(rectangle.getCenter(), target.rectangle.getCenter());
    }

    public void draw(int arcSize) {
        rectangle.draw(arcSize);
    }
}
