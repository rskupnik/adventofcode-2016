package com.github.rskupnik;

public final class Step {
    // Current location and direction
    private Point location = new Point(0, 0);
    private Direction direction = Direction.N;

    // Turn that we should take and distance to travel
    private String turn;
    private int distance;

    public Step() {

    }

    public Step(String turn, int distance) {
        this.turn = turn;
        this.distance = distance;
    }

    public Step(String action) {
        this(action.trim().substring(0, 1), Integer.parseInt(action.trim().substring(1).trim()));
    }

    /**
     * Resolves the next step based on the current one
     * and returns the next
     */
    public Step resolve(Step next) {
        next.setDirection(direction.turn(next.getTurn()));
        next.setLocation(getLocation().travel(next.getDirection(), next.getDistance()));
        return next;
    }

    public String getOutput() {
        return String.valueOf(Math.abs(location.getX()) + Math.abs(location.getY()));
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public String getTurn() {
        return turn;
    }

    public int getDistance() {
        return distance;
    }
}
