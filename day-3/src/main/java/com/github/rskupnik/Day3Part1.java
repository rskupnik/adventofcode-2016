package com.github.rskupnik;

import java.io.IOException;

public class Day3Part1 extends Puzzle {

    @Override
    public String solve() throws IOException {
        return String.valueOf(loadLinesFromClasspath()
                .stream()
                .filter(line -> isValidTriangle(line))
                .count());
    }

    private boolean isValidTriangle(String line) {
        int[] nums = new int[3];
        int c = 0;
        for (String n : line.trim().split("  ")) {
            if (!n.trim().equals("") && !n.trim().contains(" ")) {
                nums[c] = Integer.parseInt(n.trim());
                c++;
                if (c > 2)
                    break;
            }
        }
        int num1 = nums[0];
        int num2 = nums[1];
        int num3 = nums[2];
        return (num1+num2 > num3) && (num2+num3 > num1) && (num1+num3 > num2);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Day 3 Part 1: "+new Day3Part1().solve());
    }
}
