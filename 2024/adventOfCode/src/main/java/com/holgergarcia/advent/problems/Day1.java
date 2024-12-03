package com.holgergarcia.advent.problems;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1 {

    public static void main(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Path.of("src/main/resources/inputs/2024/day1Input"));

        System.out.println("day1 solution part 1: " + solutionPart1(inputs));
        System.out.println("day1 solution part 2: " + solutionPart2(inputs));
    }

    static int solutionPart1(List<String> inputs) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        inputs.forEach(line -> {
            String[] splitted = line.split("\\s+");
            left.add(Integer.parseInt(splitted[0]));
            right.add(Integer.parseInt(splitted[1]));
        });

        Collections.sort(left);
        Collections.sort(right);

        int result = 0;
        for (int i = 0; i < inputs.size(); i++) {
            result += Math.abs(right.get(i) - left.get(i));
        }

        return result;
    }

    static int solutionPart2(List<String> inputs) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        inputs.forEach(line -> {
            String[] splitted = line.split("\\s+");
            left.add(Integer.parseInt(splitted[0]));
            right.add(Integer.parseInt(splitted[1]));
        });

        return left.stream().mapToInt(val -> (int) (val * right.stream().filter(r -> r.equals(val)).count())).sum();

    }
}
