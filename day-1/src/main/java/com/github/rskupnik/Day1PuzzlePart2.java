package com.github.rskupnik;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day1PuzzlePart2 extends Puzzle {

    private Step current = new Step();
    private Set<Point> visited = new HashSet<>();
    private Point firstDuplicate;

    @Override
    public String solve() throws IOException {
        Arrays.stream(loadFromClasspath().split(","))
                .map(Step::new)
                .forEach(step -> {
                    List<Point> visitedPoints = current.resolve2(step);
                    current = step;
                    for (Point p : visitedPoints) {
                        if (firstDuplicate == null && visited.contains(p)) {
                            firstDuplicate = p;
                        }
                        else visited.add(p);
                    }
                });

        return String.valueOf(Math.abs(firstDuplicate.getX()) + Math.abs(firstDuplicate.getY()));
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Day 1 part 2: "+new Day1PuzzlePart2().solve());
    }
}
