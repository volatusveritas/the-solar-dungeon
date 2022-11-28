package com.desanimados.thesolardungeon.dungeongenerator.settings;

public class RoomCornerRadius {
    public static final int MIN_RADIUS = 8;

    public int radius = MIN_RADIUS;

    public boolean isValid() { return radius >= MIN_RADIUS; }
}
