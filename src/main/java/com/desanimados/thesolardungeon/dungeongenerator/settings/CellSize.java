package com.desanimados.thesolardungeon.dungeongenerator.settings;

public class CellSize implements ValidatedSetting {
    public static final int MIN_SIDE_LENGTH = 64;

    public int width = 64;
    public int height = 64;

    public boolean isValid() {
        return width >= MIN_SIDE_LENGTH
            && height >= MIN_SIDE_LENGTH;
    }
}
