package com.github.rskupnik;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day3Part2 extends Puzzle {

    private class Triangle {
        protected int a, b, c;

        protected Triangle(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    private List<Triangle> triangles = new ArrayList<>();

    @Override
    public String solve() throws IOException {
        List<String> lines = loadLinesFromClasspath();
        for (int i = 0; i < lines.size() - 2; i += 3) {
            int[] nums = parseToNumbers(lines.get(i));
            triangles.add(new Triangle(nums[0], 0, 0));
            triangles.add(new Triangle(nums[1], 0, 0));
            triangles.add(new Triangle(nums[2], 0, 0));
        }
        int c = 0;
        for (int i = 1; i < lines.size() - 1; i += 3) {
            int[] nums = parseToNumbers(lines.get(i));
            triangles.get(c).b = nums[0];
            c++;
            triangles.get(c).b = nums[1];
            c++;
            triangles.get(c).b = nums[2];
        }
        c = 0;
        for (int i = 2; i < lines.size(); i += 3) {
            int[] nums = parseToNumbers(lines.get(i));
            triangles.get(c).c = nums[0];
            c++;
            triangles.get(c).c = nums[1];
            c++;
            triangles.get(c).c = nums[2];
        }
        int o = 0;
        for (Triangle t : triangles) {
            if ((t.a+t.b > t.c) && (t.b+t.c > t.a) && (t.a+t.c > t.b))
                    o++;
        }

        return String.valueOf(o);
    }

    private int[] parseToNumbers(String line) {
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
        return nums;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Day 3 Part 2: "+new Day3Part2().solve());
    }
}
