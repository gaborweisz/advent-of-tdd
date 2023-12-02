package org.advent.day2;

import java.util.ArrayList;
import java.util.List;

public class Game {

    List<GameSet> gameSets = new ArrayList<>();
    int id;
    int fewestRed = 0;
    int fewestGreen = 0;
    int fewestBlue = 0;


    /**
     * Parse a row and create a game
     * @param input game set as string e.g. "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"
     * @return game
     */
    public static Game parse(String input) {
        Game game = new Game();

        String[] parts = input.split(":");
        game.id = Integer.parseInt(parts[0].split(" ")[1]);
        for (String gameSet : parts[1].split(";")) {
            game.gameSets.add(GameSet.parse(gameSet));
        }
        return game;
    }

    /**
     * Check if a game is possible
     * @param red number of red cubes
     * @param green number of green cubes
     * @param blue number of blue cubes
     * @return true if game is possible
     */
    public boolean  isGamePossible(int red, int green, int blue){
        for (GameSet gameSet : gameSets) {
            if(!gameSet.isGameSetPossible(red, green, blue)){
                return false;
            }
        }
        return true;
    }

    /**
     * Calculate the fewest cubes needed for a game
     */
    public void calculateFewestCubesNeeded() {
        for (GameSet gameSet : gameSets) {
            if (gameSet.red > fewestRed || fewestRed == 0) {
                fewestRed = gameSet.red;
            }
            if (gameSet.green > fewestGreen || fewestGreen == 0) {
                fewestGreen = gameSet.green;
            }
            if (gameSet.blue > fewestBlue || fewestBlue == 0) {
                fewestBlue = gameSet.blue;
            }
        }
    }

    /**
     * Calculate the power of the fewest cubes needed
     * @return power of the fewest cubes needed
     */
    public int powerOfTheFewestCubesNeeded() {
        return fewestRed * fewestGreen * fewestBlue;
    }
}
