package com.desanimados.thesolardungeon.dungeongenerator.settings;

public class CellPadding implements ValidatedSetting {
    public static final int MIN_SIZE = 16;

    public int left = 16;
    public int right = 16;
    public int top = 16;
    public int bottom = 16;

    public boolean isValid() {
        return left >= MIN_SIZE
            && right >= MIN_SIZE
            && top >= MIN_SIZE
            && bottom >= MIN_SIZE;
    }
}
