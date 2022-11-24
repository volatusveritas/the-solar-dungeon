package com.desanimados.thesolardungeon.dungeongenerator.settings;

public class GridSize implements ValidatedSetting {
    public static final int MIN_SIDE_LENGTH = 4;

    public int width = 10;
    public int height = 10;

    public boolean isValid() {
        return width >= MIN_SIDE_LENGTH
            && height >= MIN_SIDE_LENGTH;
    }
}
