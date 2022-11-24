package com.desanimados.thesolardungeon.dungeongenerator.settings;

public class RoomSize implements ValidatedSetting {
    public static final int MIN_SIDE_LENGTH = 24;

    public int minRoomWidth = 24;
    public int maxRoomWidth = 48;
    public int minRoomHeight = 24;
    public int maxRoomHeight = 48;

    public boolean isValid() {
        return minRoomWidth >= MIN_SIDE_LENGTH
            && maxRoomWidth >= MIN_SIDE_LENGTH
            && minRoomHeight >= MIN_SIDE_LENGTH
            && maxRoomHeight >= MIN_SIDE_LENGTH
            && minRoomWidth <= maxRoomWidth
            && minRoomHeight <= maxRoomHeight;
    }
}
