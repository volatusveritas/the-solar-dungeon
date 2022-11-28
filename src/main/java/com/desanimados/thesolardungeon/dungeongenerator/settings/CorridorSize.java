package com.desanimados.thesolardungeon.dungeongenerator.settings;

public class CorridorSize implements ValidatedSetting {
    public static final int MIN_SIZE = 2;

    public int size = MIN_SIZE;

    public boolean isValid() {
        return size >= MIN_SIZE;
    }
}
