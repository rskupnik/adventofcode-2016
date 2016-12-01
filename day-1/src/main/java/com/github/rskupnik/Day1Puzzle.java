package com.github.rskupnik;

import java.io.IOException;
import java.util.Arrays;

public class Day1Puzzle extends Puzzle {

    @Override
    public String solvePart1() throws IOException {
        return Arrays.stream(loadFromClasspath().split(","))
                .map(Step::new)
                .reduce(new Step(), (a, b) -> a.resolve(b))
                .getOutput();
    }

    @Override
    public String solvePart2() throws IOException {
        return null;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Day 1: "+new Day1Puzzle().solvePart1());
    }
}
