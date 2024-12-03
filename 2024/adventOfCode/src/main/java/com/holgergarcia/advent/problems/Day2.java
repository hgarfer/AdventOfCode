package com.holgergarcia.advent.problems;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day2 {

    public static void main(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Path.of("inputs/day2Input"));
        List<List<Integer>> lines = new ArrayList<>();

        inputs.forEach(input -> {
            String[] splitted = input.split("\\s+");
            List<Integer> line = new ArrayList<>();
            for (String split : splitted) {
                line.add(Integer.parseInt(split));
            }
            lines.add(line);
        });

        System.out.println("day 2 step 1:" + solveStep1(lines));
        System.out.println("day 2 step 2:" + solveStep2(lines));

    }

    static int solveStep2(List<List<Integer>> lines) {
        int safeCount = 0;

        for (List<Integer> line : lines) {
            int previous = line.getFirst();
            boolean safe = true;
            boolean dampenerUsed = false;
            boolean increasing = line.get(1) > line.get(0);
            for (int i = 1; i < line.size(); i++) {
                if (!increasing && line.get(i) > previous) {
                    safe = false;
                } else if (increasing && line.get(i) > previous + 3) {
                    safe = false;
                } else if (increasing && line.get(i) < previous) {
                    safe = false;
                } else if (!increasing && line.get(i) < previous - 3) {
                    safe = false;
                } else if (line.get(i) == previous) {
                    safe = false;
                }
                if (!safe) {
                    if (!dampenerUsed) {
                        dampenerUsed = true;
                        safe = true;
                    } else {
                        break;
                    }
                }
                previous = line.get(i);
            }
            if (safe) {
                safeCount++;
            }
        }

        return safeCount;
    }

    static int solveStep1(List<List<Integer>> lines) {
        int safeCount = 0;

        for (List<Integer> line : lines) {
            int previous = line.get(0);
            boolean safe = true;
            boolean increasing = line.get(1) > line.get(0);
            for (int i = 1; i < line.size(); i++) {
                if (!increasing && line.get(i) > previous) {
                    safe = false;
                } else if (increasing && line.get(i) > previous + 3) {
                    safe = false;
                } else if (increasing && line.get(i) < previous) {
                    safe = false;
                } else if (!increasing && line.get(i) < previous - 3) {
                    safe = false;
                } else if (line.get(i) == previous) {
                    safe = false;
                }
                if (!safe) {
                    break;
                }
                previous = line.get(i);
            }
            if (safe) {
                safeCount++;
            }
        }

        return safeCount;
    }
}
