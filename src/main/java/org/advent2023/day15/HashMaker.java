package org.advent2023.day15;

public class HashMaker {


    /**
     * The HASH algorithm is a way to turn any string of characters into a single number in the range 0 to 255. To run the HASH algorithm on a string, start with a current value of 0. Then, for each character in the string starting from the beginning:
     * <p>
     * Determine the ASCII code for the current character of the string.
     * Increase the current value by the ASCII code you just determined.
     * Set the current value to itself multiplied by 17.
     * Set the current value to the remainder of dividing itself by 256.
     *
     * @param s input string
     * @return hash code
     */
    static int calculateHash(String s) {

        int current_value = 0;
        for (char c : s.toCharArray()) {
            current_value += c;
            current_value *= 17;
            current_value %= 256;
        }

        return current_value;
    }

    public static int sumHashes(String input) {

        String[] split = input.split(",");
        int sum = 0;
        for (String s : split) {
            sum += calculateHash(s);
        }
        return sum;
    }
}
