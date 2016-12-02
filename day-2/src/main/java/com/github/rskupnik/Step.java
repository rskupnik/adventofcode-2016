package com.github.rskupnik;

public final class Step {
    private Direction direction;
    private int previousNumber = 5;
    private int nextNumber;

    protected Step() {

    }

    protected Step(String input) {
        this.direction = input.equals("U") ? Direction.N : input.equals("D") ? Direction.S : input.equals("R") ? Direction.E : Direction.W;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getPreviousNumber() {
        return previousNumber;
    }

    public void setPreviousNumber(int previousNumber) {
        this.previousNumber = previousNumber;
    }

    public int getNextNumber() {
        return nextNumber;
    }

    public void setNextNumber(int nextNumber) {
        this.nextNumber = nextNumber;
    }
}
