package com.desanimados.thesolardungeon.dungeongenerator.settings;

public class RoomSize implements ValidatedSetting {
    public static final int MIN_SIDE_LENGTH = 18;

    public int minRoomWidth = 18;
    public int maxRoomWidth = 40;
    public int minRoomHeight = 18;
    public int maxRoomHeight = 40;

    public boolean isValid() {
        return minRoomWidth >= MIN_SIDE_LENGTH
            && maxRoomWidth >= MIN_SIDE_LENGTH
            && minRoomHeight >= MIN_SIDE_LENGTH
            && maxRoomHeight >= MIN_SIDE_LENGTH
            && minRoomWidth <= maxRoomWidth
            && minRoomHeight <= maxRoomHeight;
    }
}
