package com.github.rskupnik;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * Resolves the next step based on the current one
     * and returns a list of points visited on the path
     */
    public List<Point> resolve2(Step next) {
        List<Point> output = new ArrayList<>();
        next.setDirection(direction.turn(next.getTurn()));
        Point loc = getLocation();
        next.setLocation(getLocation().travel(next.getDirection(), next.getDistance()));
        switch (next.getDirection()) {
            case N:
                for (int y = loc.getY(); y < loc.getY() + next.getDistance(); y++) {
                    output.add(new Point(loc.getX(), y));
                }
                break;
            case S:
                for (int y = loc.getY(); y > loc.getY() - next.getDistance(); y--) {
                    output.add(new Point(loc.getX(), y));
                }
                break;
            case E:
                for (int x = loc.getX(); x < loc.getX() + next.getDistance(); x++) {
                    output.add(new Point(x, loc.getY()));
                }
                break;
            case W:
                for (int x = loc.getX(); x > loc.getX() - next.getDistance(); x--) {
                    output.add(new Point(x, loc.getY()));
                }
                break;
        }

        return output;
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
