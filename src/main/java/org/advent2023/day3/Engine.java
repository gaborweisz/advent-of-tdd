package org.advent2023.day3;

import java.util.*;

public class Engine {

    List<String> input;
    List<Part> parts = new ArrayList<>();
    HashMap<String, Set<Part>> gears = new HashMap<>();
    static final List<Character> DIGIT_ARRAY = List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');

    public Engine(List<String> input) {
        this.input = input;
    }

    /**
     * Parse the input into parts
     */
    public void parseParts() {
        int lineNumber = 0;
        for (String line : input) {
            lineNumber++;
            parseLine(lineNumber, line);
        }
    }

    /**
     * Find the gears based on the parts
     */
    public void parseGears() {
        for (Part part : parts) {
            if (part.valid) {
                findGear(part);
            }
        }
    }

    private void parseLine(int lineNumber, String line) {
        int startPos = -1;
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);
            if (DIGIT_ARRAY.contains(symbol)) {
                number.append(symbol);
                if (startPos == -1) {
                    startPos = i;

                }
            } else if (startPos > -1) {
                //flush and reset
                parts.add(new Part(Integer.parseInt(number.toString()), startPos, i - 1, lineNumber, isValid(lineNumber, startPos, i - 1)));
                startPos = -1;
                number = new StringBuilder();
            }

            if (i == line.length()-1 && startPos > -1) {
                //flush and reset at the end of the line
                parts.add(new Part(Integer.parseInt(number.toString()), startPos, i, lineNumber, isValid(lineNumber, startPos, i-1)));
                startPos = -1;
                number = new StringBuilder();
            }
        }
    }

    private boolean isValid(int lineNumber, int startPos, int endPos) {

        int startLine = lineNumber > 1 ? lineNumber - 1 : 1;
        int endLine = lineNumber < input.size() ? lineNumber + 1 : input.size();

        for (int i = startLine; i <= endLine; i++) {
            String line = input.get(i-1);
            int start = startPos > 0 ? startPos - 1 : 0;
            int end = endPos < line.length() - 1 ? endPos + 1 : line.length() - 1;

            for (int j = start; j <= end; j++) {
                if (isSymbol(line.charAt(j))) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean findGear(Part part) {

        int startLine = part.lineNumber > 1 ? part.lineNumber - 1 : 1;
        int endLine = part.lineNumber < input.size() ? part.lineNumber + 1 : input.size();

        for (int i = startLine; i <= endLine; i++) {
            String line = input.get(i-1);
            int start = part.startPos > 0 ? part.startPos - 1 : 0;
            int end = part.endPos < line.length() - 1 ? part.endPos + 1 : line.length() - 1;

            for (int j = start; j <= end; j++) {
                if ('*'==line.charAt(j)) {
                    addToGear(part, i, j);
                }
            }
        }

        return false;
    }

    private void addToGear(Part part, int i, int j) {
        String key = i + "_" + j;
        if (gears.containsKey(key)) {
            Set<Part> parts = gears.get(key);
            parts.add(part);
        } else {
            Set<Part> parts = new HashSet<>();
            parts.add(part);
            gears.put(key, parts);
        }
    }

    private boolean isSymbol(char c) {
        return !(DIGIT_ARRAY.contains(c) || c == '.') ;
    }
}



