package com.github.rskupnik;

import java.io.IOException;
import java.util.Arrays;

public class Day2Part1 extends Puzzle {

    private int currentNumber = 5;
    private int x = 1;
    private int y = 1;

    private static final int[][] DIGITS = new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    @Override
    public String solve() throws IOException {
        return loadLinesFromClasspath()
                .stream()
                .map(line -> {
                    return Arrays.stream(line.trim().split(""))
                            .map(Step::new)
                            .reduce(new Step(), (prev, cur) -> {
                                cur.setPreviousNumber(move(prev.getPreviousNumber(), cur.getDirection()));
                                return cur;
                            }).getPreviousNumber();
                })
                .map(digit -> String.valueOf(digit))
                .reduce("", (prev, cur) -> prev+cur);
    }

    private int move(int digit, Direction direction) {
        int[] loc = locateDigit(digit);
        int x = direction == Direction.N ? -1 : direction == Direction.S ? 1 : 0;
        int y = direction == Direction.E ? 1 : direction == Direction.W ? -1 : 0;
        x = loc[0]+x;
        y = loc[1]+y;
        x = x > 2 ? 2 : x;
        x = x < 0 ? 0 : x;
        y = y > 2 ? 2 : y;
        y = y < 0 ? 0 : y;
        return DIGITS[x][y];
    }

    private int[] locateDigit(int digit) {
        int x = digit >= 1 && digit <= 3 ? 0 : digit >= 4 && digit <= 6 ? 1 : 2;
        int y = digit == 1 || digit == 4 || digit == 7 ? 0 : digit == 2 || digit == 5 || digit == 8 ? 1 : 2;
        return new int[] {x, y};
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Day 2 Part 1: "+new Day2Part1().solve());
    }
}
