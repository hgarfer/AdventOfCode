package com.holgergarcia.advent.problems;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day7 {
        public static void main(String[] args){
         List<String> inputs = Files.readAllLines(Path.of("src/main/resources/inputs/2024/day7Input"));

        System.out.println("day 7 step 1:" + solveStep1(inputs));
        System.out.println("day 7 step 2:" + solveStep2(inputs));
    }

}
