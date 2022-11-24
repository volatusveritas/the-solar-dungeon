package com.desanimados.thesolardungeon.dungeongenerator.settings;

public class RoomChance {
    public static final float MIN_CHANCE = 25.0f;

    public float chance = 75.0f;

    public boolean isValid() { return chance >= MIN_CHANCE; }
}
