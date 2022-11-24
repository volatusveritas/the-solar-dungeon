package com.desanimados.thesolardungeon.util;

import java.util.Random;

public class Randomizer {
    private static Random instance;

    public static Random getInstance() {
        if (instance == null) {
            instance = new Random();
        }

        return instance;
    }

    public static boolean getChance(float chance) {
        return getInstance().nextFloat() <= (chance / 100.0f);
    }

    public static int getBetween(int min, int max) {
        return min + getInstance().nextInt(max - min + 1);
    }

    public static Position getPointInRectangle(Rectangle rectangle) {
        Position endAnchor = rectangle.getEndAnchor();

        return new Position(
            getBetween(rectangle.position.x, endAnchor.x),
            getBetween(rectangle.position.y, endAnchor.y)
        );
    }
}
