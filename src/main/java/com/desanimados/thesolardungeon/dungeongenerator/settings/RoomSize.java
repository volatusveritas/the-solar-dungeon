package com.desanimados.thesolardungeon.dungeongenerator.settings;

public class RoomSize implements ValidatedSetting {
    public static final int MIN_SIDE_LENGTH = 32;

    public int minRoomWidth = 32;
    public int maxRoomWidth = 64;
    public int minRoomHeight = 32;
    public int maxRoomHeight = 64;

    public boolean isValid() {
        return minRoomWidth >= MIN_SIDE_LENGTH
            && maxRoomWidth >= MIN_SIDE_LENGTH
            && minRoomHeight >= MIN_SIDE_LENGTH
            && maxRoomHeight >= MIN_SIDE_LENGTH
            && minRoomWidth <= maxRoomWidth
            && minRoomHeight <= maxRoomHeight;
    }
}
