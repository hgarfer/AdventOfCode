package com.holgergarcia.advent.problems;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {

    public static void main(String[] args) throws IOException {
        String inputs = Files.readString(Path.of("src/main/resources/inputs/2024/day3Input"));

        System.out.println("day 3 step 1:" + solveStep1(inputs));
        System.out.println("day 3 step 2:" + solveStep2(inputs));
    }

    static int solveStep1(String input) {
        Pattern regex = Pattern.compile("mul\\(-?\\d+,-?\\d+\\)");
        Matcher matcher = regex.matcher(input);

        int result = 0;

        while (matcher.find()) {
            String group = matcher.group();

            String[] cleanGroup = group.replace("mul(", "")
                    .replace(")", "")
                    .split(",");

            result += Integer.parseInt(cleanGroup[0]) * Integer.parseInt(cleanGroup[1]);
        }
        return result;
    }

    static int solveStep2(String input) {
        int result = 0;
        String[] splitted = input.split("(((?=do\\(\\)))|((?=don't\\(\\))))");
        for (String s : splitted) {
            if (s.startsWith("don't()")) {
                continue;
            }
            result += solveStep1(s);
        }
        return result;
    }
}
