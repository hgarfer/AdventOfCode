package com.holgergarcia.advent.problems;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day8 {

        public static void main(String[] args) throws IOException{
         List<String> inputs = Files.readAllLines(Path.of("src/main/resources/inputs/2024/day8Input"));

        System.out.println("day 8 step 1:" + solveStep1(inputs));
        System.out.println("day 8 step 2:" + solveStep2(inputs));
    }

}
