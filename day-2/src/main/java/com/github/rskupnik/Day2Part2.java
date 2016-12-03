package com.github.rskupnik;

import java.io.IOException;
import java.util.Arrays;

public class Day2Part2 extends Puzzle {

    private static final int[][] DIGITS = new int[][]{
           {1},
        {2, 3, 4},
     {5, 6, 7, 8, 9},
       {10, 11, 12},
           {13}
    };

    @Override
    public String solve() throws IOException {
        return loadLinesFromClasspath()
                .stream()
                .map(line -> Arrays.stream(line.trim().split(""))
                        .map(Step::new)
                        .reduce(new Step(), (prev, cur) -> {
                            cur.setPreviousNumber(move(prev.getPreviousNumber(), cur.getDirection()));
                            return cur;
                        }).getPreviousNumber())
                .map(digit -> digitToString(digit))
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
        return null;
    }

    private String digitToString(int digit) {
        return digit <= 9 ? String.valueOf(digit) : digit == 10 ? "A" : digit == 11 ? "B" : digit == 12 ? "C" : "D";
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Day 2 Part 1: "+new Day2Part1().solve());
    }
}
