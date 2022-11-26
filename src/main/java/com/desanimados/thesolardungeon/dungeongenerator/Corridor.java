package com.desanimados.thesolardungeon.dungeongenerator;

import com.desanimados.thesolardungeon.util.Position;

public class Corridor {
    Position begin;
    Position end;

    public Corridor(Position begin, Position end) {
        this.begin = begin;
        this.end = end;
    }

    public void draw(float width) {
        begin.drawLineTo(end, width);
    }
}
