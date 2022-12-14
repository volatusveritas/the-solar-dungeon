package com.desanimados.thesolardungeon.dungeongenerator.settings;

public class GridLimits implements ValidatedSetting {
    public static final int MIN_AMOUNT_LIMIT = 2;

    public int maxRowRooms = 5;
    public int maxColumnRooms = 5;

    public boolean isValid() {
        return maxRowRooms >= MIN_AMOUNT_LIMIT
            && maxColumnRooms >= MIN_AMOUNT_LIMIT;
    }
}
