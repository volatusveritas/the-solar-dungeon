package com.desanimados.thesolardungeon.dungeongenerator.settings;

public class CellSize implements ValidatedSetting {
    public static final int MIN_SIDE_LENGTH = 80;

    public int width = 80;
    public int height = 80;

    public boolean isValid() {
        return width >= MIN_SIDE_LENGTH
            && height >= MIN_SIDE_LENGTH;
    }
}
