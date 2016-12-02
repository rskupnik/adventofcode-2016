package com.github.rskupnik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Puzzle {

    public abstract String solve() throws IOException;

    protected String load() throws IOException {
        return load("input.txt");
    }

    protected String load(String path) throws IOException {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get(path))))) {
            return buffer.lines().collect(Collectors.joining("\n"));
        }
    }

    protected String loadFromClasspath() throws IOException {
        return loadFromClasspath("input.txt");
    }

    protected String loadFromClasspath(String path) throws IOException {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(path)))) {
            return buffer.lines().collect(Collectors.joining("\n"));
        }
    }

    protected List<String> loadLines() throws IOException {
        return loadLines("input.txt");
    }

    protected List<String> loadLines(String path) throws IOException {
        return Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
    }

    protected List<String> loadLinesFromClasspath() throws IOException {
        return loadLinesFromClasspath("input.txt");
    }

    protected List<String> loadLinesFromClasspath(String path) throws IOException {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(path)))) {
            return buffer.lines().collect(Collectors.toList());
        }
    }
}
