package com.github.rskupnik;

public enum Direction {
    N, E, S, W;

    /**
     * Turns into the specified direction and return the resulting Direction
     */
    public Direction turn(String direction) {
        switch (this) {
            default:
            case N: return direction.equals("R") ? E : W;
            case S: return direction.equals("R") ? W : E;
            case E: return direction.equals("R") ? S : N;
            case W: return direction.equals("R") ? N : S;
        }
    }
}
