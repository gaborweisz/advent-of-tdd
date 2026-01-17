package org.advent2023.day2;

public class GameSet {
    public static final String RED = "red";
    public static final String GREEN = "green";
    public static final String BLUE = "blue";

    int red;
    int green;
    int blue;

    /**
     * Parse a game set from a string .e.g. " 3 green, 1 blue, 9 red"
     *
     * @param input game set as string
     * @return game set
     */
    public static GameSet parse(String input) {

        GameSet gameSet = new GameSet();
        String[] parts = input.split(",");
        gameSet.red = parseNumber(parts, RED);
        gameSet.green = parseNumber(parts, GREEN);
        gameSet.blue = parseNumber(parts, BLUE);

        return gameSet;
    }

    private static int parseNumber(String[] parts, String cubeColor) {
        for (String part : parts) {
            String[] subParts = part.trim().split(" ");
            int number = Integer.parseInt(subParts[0]);
            String color = subParts[1].trim();
            if (color.equals(cubeColor)) {
                return number;
            }
        }
        return 0;
    }

    /**
     * Check if a game set is possible
     *
     * @param red   number of red cubes
     * @param green number of green cubes
     * @param blue  number of blue cubes
     * @return true if game set is possible
     */
    public boolean isGameSetPossible(int red, int green, int blue) {
        if (this.red > red) {
            return false;
        }
        if (this.green > green) {
            return false;
        }
        if (this.blue > blue) {
            return false;
        }
        return true;
    }
}
