package com.holgergarcia.advent.problems;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day4 {

    public static void main(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Path.of("src/main/resources/inputs/2024/day4Input"));

        System.out.println("day 4 step 1:" + solveStep1(inputs));
        System.out.println("day 4 step 2:" + solveStep2(inputs));
    }

    record Position(int row, int col) {
    }

    static final List<Position> directions = List
            .of(new Position(0, 1), new Position(0, -1), new Position(1, 0), new Position(-1, 0),
                    new Position(1, 1), new Position(-1, -1), new Position(1, -1), new Position(-1, 1));

    static final char[] letters = new char[] { 'X', 'M', 'A', 'S' };

    static int solveStep1(List<String> input) {
        int rows = input.size();
        int cols = input.get(0).length();
        char[][] charInput = new char[rows][cols];

        int result = 0;

        for (int i = 0; i < input.size(); i++) {
            charInput[i] = input.get(i).toCharArray();
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (charInput[r][c] == letters[0]) {
                    for (Position direction : directions) {
                        Position dirPos = new Position(r + direction.row(), c + direction.col());
                        for (int l = 1; l < letters.length; l++) {

                            if (inRange(dirPos.row(), rows) && inRange(dirPos.col(), cols)
                                    && charInput[dirPos.row()][dirPos.col()] == letters[l]) {
                                if (l == letters.length - 1) {
                                    result++;
                                } else {
                                    dirPos = new Position(dirPos.row() + direction.row(), dirPos.col() + direction.col);
                                }
                            } else {
                                break;
                            }
                        }

                    }
                }
            }
        }

        return result;

    }

    static final List<List<Position>> opposites = List.of(List.of(new Position(1, 1), new Position(-1, -1)),
            List.of(new Position(1, -1), new Position(-1, 1)));

    static final List<Character> letters2 = List.of('M', 'S');

    static int solveStep2(List<String> input) {
        int rows = input.size();
        int cols = input.get(0).length();
        char[][] charInput = new char[rows][cols];

        int result = 0;

        for (int i = 0; i < input.size(); i++) {
            charInput[i] = input.get(i).toCharArray();
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (charInput[r][c] == 'A') {
                    boolean isMas = true;
                    for (List<Position> oppositePair : opposites) {
                        List<Character> currentChars = new ArrayList<>(letters2);
                        for (Position opposite : oppositePair) {
                            if (inRange(r + opposite.row(), rows) && inRange(c + opposite.col(), cols)
                                    && currentChars.contains(charInput[r + opposite.row()][c + opposite.col()])) {
                                currentChars
                                        .remove(Character.valueOf(charInput[r + opposite.row()][c + opposite.col()]));
                            }
                        }
                        if (!currentChars.isEmpty()) {
                            isMas = false;
                        }
                    }
                    if (isMas) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    static boolean inRange(int val, int max) {
        return val >= 0 && val < max;
    }
}
