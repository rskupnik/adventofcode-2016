package com.github.rskupnik;

import java.io.IOException;
import java.util.Arrays;

public class Day1PuzzlePart1 extends Puzzle {

    @Override
    public String solve() throws IOException {
        return Arrays.stream(loadFromClasspath().split(","))
                .map(Step::new)
                .reduce(new Step(), (a, b) -> a.resolve(b))
                .getOutput();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Day 1 part 1: "+new Day1PuzzlePart1().solve());
    }
}
