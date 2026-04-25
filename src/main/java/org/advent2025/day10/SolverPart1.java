package org.advent2025.day10;

import util.FileReader;

import java.util.ArrayList;
import java.util.List;

public class SolverPart1 {

    static class Indicator {
        int lights;
        String lightString;
        List<Integer> buttons = new ArrayList<>();
        List<String> buttonStrings = new ArrayList<>();
    }

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_2025_day10.txt" );

        System.out.println("Solution for day 2025 / day 10/ a : " + new SolverPart1().solvePuzzle(rows));
    }

    int solvePuzzle(List<String> rows) {
        List<Indicator> indicators = processInput(rows);
        int totalButtonPresses = 0;
        
        for (Indicator indicator : indicators) {
            
            int maxNumOfButtonPresses = Integer.MAX_VALUE;
            int maxIndex = (int) Math.pow(2.0, indicator.buttons.size());
            for (int index = 0; index < maxIndex; index++) {
                String binary = Integer.toBinaryString(index);
                int xorResult = 0;
                StringBuilder sb = new StringBuilder();
                //System.out.println("Testing combination " + binary + " for indicator " + indicator.lightString + " Expected state : " + indicator.lights);
                int buttonPresses = 0;
                for (int i = 0; i< binary.length(); i++) {
                    if (binary.charAt(binary.length() - 1 - i) == '1') {
                        int button = indicator.buttons.get(i);
                        //System.out.println("......button "  + Integer.toBinaryString(button) + " (" + indicator.buttonStrings.get(i) + ") is pressed");
                        sb.append(indicator.buttonStrings.get(i)).append(", ");
                        xorResult = xorResult ^ button;
                        buttonPresses++;
                        //System.out.print("  - Pressing buttons " + sb +  "results in new state " + xorResult + "\n");
                    }
                }
                if (xorResult == indicator.lights) {
                    if (maxNumOfButtonPresses > buttonPresses) {
                        maxNumOfButtonPresses = buttonPresses;
                    } 
                    System.out.println("Found solution : " + indicator.lightString + " with buttons " +  sb);
                }
            }
            
            totalButtonPresses += maxNumOfButtonPresses;
        }

        return totalButtonPresses;
    }

    /**
     * Gets the indexes where the binary representation of the decimal number is 1
     * [.##.] -> 0110 (binary) -> [1,2]
     * @param number
     * @return list of indexts
     */
    List<Integer> getIndexes(int number) {
        List <Integer> indexes = new ArrayList<>();
        String binary = Integer.toBinaryString(number);

        for (int i = 0; i< binary.length(); i++) {
            if (binary.charAt(binary.length() - 1 - i) == '1') {
                indexes.add(i);
            }
        }
        
        return indexes;
    }

    List<Indicator> processInput(List<String> rows) {
        List<Indicator> indicators = new ArrayList<>();
        for (String row : rows) {
            Indicator indicator = new Indicator();
            indicators.add(indicator);
            String[] parts = row.split(" " );
            indicator.lights = convertToBitmap(parts[0]);
            indicator.lightString = parts[0];
            for (int i = parts.length - 2 ; i >=  1; i--) {
                String buttonPart = parts[i];
                indicator.buttonStrings.add(buttonPart);
                buttonPart = buttonPart.substring(1, buttonPart.length() - 1);
                List<Integer> button = new ArrayList<>();
                for (String index : buttonPart.split("," )) {
                    button.add(Integer.parseInt(index));
                }
                indicator.buttons.add(convertButtonToBitmap(button));
            }
        }

        return indicators;
    }

    /**
     * Convert the button list to a bitmap representation, where each button index is represented by a bit set to 1 and each non-pressed button index is represented by a bit set to 0.
     * example :
     * (1,3) -> 1010 (binary) -> 10 (decimal
     */
    int convertButtonToBitmap(List<Integer> button) {
        int bitmap = 0;
        for (int index : button) {
            bitmap += Math.pow(2, index);
        }
        return bitmap;
    }

    /**
     * Convert the lights string to a bitmap representation, where each '#' is represented by a bit set to 1 and each '.' is represented by a bit set to 0.
     * example :
     * [.##.] -> 0110 (binary) -> 6 (decimal)
     *
     * @param lights
     * @return bitmap
     */
    int convertToBitmap(String lights) {
        int bitmap = 0;
        int base = 1;
        for (int i = 1; i < lights.length() -1 ; i++) {
            char c = lights.charAt(i);
            if (c == '#') {
                bitmap += base;
            }
            base *= 2;
        }
        return bitmap;
    }
}
