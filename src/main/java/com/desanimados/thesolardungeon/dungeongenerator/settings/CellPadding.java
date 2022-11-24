package com.desanimados.thesolardungeon.dungeongenerator.settings;

public class CellPadding implements ValidatedSetting {
    public static final int MIN_SIZE = 8;

    public int left = 8;
    public int right = 8;
    public int top = 8;
    public int bottom = 8;

    public boolean isValid() {
        return left >= MIN_SIZE
            && right >= MIN_SIZE
            && top >= MIN_SIZE
            && bottom >= MIN_SIZE;
    }
}
