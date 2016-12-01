package com.github.rskupnik;

public final class Point {

    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Point && ((Point) obj).x == x && ((Point) obj).y == y;
    }

    @Override
    public int hashCode() {
        return x * y;
    }

    public Point travel(Direction direction, int distance) {
        return new Point(
            direction == Direction.E ? x+distance : direction == Direction.W ? x-distance : x,
            direction == Direction.N ? y+distance : direction == Direction.S ? y-distance : y
        );
    }
}
