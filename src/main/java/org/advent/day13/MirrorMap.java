package org.advent.day13;

import util.ListUtil;
import util.MatrixUtil;

import java.util.List;

public class MirrorMap {

    /**
     * To summarizes the pattern notes, add up the number of columns to the left of each vertical line of reflection; t
     * o that, also add 100 multiplied by the number of rows above each horizontal line of reflection.
     * In the above example, the first pattern's vertical line has 5 columns to its left and the second pattern's horizontal line has 4 rows above it,
     * a total of 405.
     *
     * @param input input of the puzzle
     * @return solution for puzzle a
     */
    public static int countRows(List<String> input) {
        int count = 0;

        List<char[][]> maps = ListUtil.convertToCharMatrixList(input);

        for (char[][] map : maps) {
            int verticalMirrorAxisIndex = MatrixUtil.getVerticalMirrorAxisIndex(map);
            int horizontalMirrorAxisIndex = MatrixUtil.getHorizontalMirrorAxisIndex(map);

            count += horizontalMirrorAxisIndex == -1 ? 0 : (horizontalMirrorAxisIndex + 1) * 100;
            count += verticalMirrorAxisIndex == -1 ? 0 : verticalMirrorAxisIndex + 1;

        }

        return count;
    }


    public static int countRowsAfterFixingSmudge(List<String> input) {
        int count = 0;

        List<char[][]> maps = ListUtil.convertToCharMatrixList(input);

        for (char[][] map : maps) {
            int verticalMirrorAxisIndexOrig = MatrixUtil.getVerticalMirrorAxisIndex(map);
            int horizontalMirrorAxisIndexOrig = MatrixUtil.getHorizontalMirrorAxisIndex(map);
            System.out.println("Map before fixing smudge:");
            MatrixUtil.printMatrix(map);
            map = fixSmudge(map);
            System.out.println("Map after fixing smudge:");
            MatrixUtil.printMatrix(map);


            int verticalMirrorAxisIndexNew = MatrixUtil.getVerticalMirrorAxisIndex(map);
            int horizontalMirrorAxisIndexNew = MatrixUtil.getHorizontalMirrorAxisIndex(map);

            if (verticalMirrorAxisIndexNew != verticalMirrorAxisIndexOrig) {
                count += verticalMirrorAxisIndexNew == -1 ? 0 : verticalMirrorAxisIndexNew + 1;
            }

            if (horizontalMirrorAxisIndexNew != horizontalMirrorAxisIndexOrig) {
                count += horizontalMirrorAxisIndexNew == -1 ? 0 : (horizontalMirrorAxisIndexNew + 1) * 100;
            }

        }

        return count;
    }


    public static char[][] fixSmudge(char[][] map) {
        int verticalMirrorAxisIndex = MatrixUtil.getVerticalMirrorAxisIndex(map);
        int horizontalMirrorAxisIndex = MatrixUtil.getHorizontalMirrorAxisIndex(map);

        if (verticalMirrorAxisIndex == -1 && horizontalMirrorAxisIndex == -1) {
            return map;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {

                // try to fix smudge
                if (map[i][j] == '.') {
                    map[i][j] = '#';
                } else if (map[i][j] == '#') {
                    map[i][j] = '.';
                }

                int verticalMirrorAxisIndexNew = MatrixUtil.getVerticalMirrorAxisIndex(map);
                int horizontalMirrorAxisIndexNew = MatrixUtil.getHorizontalMirrorAxisIndex(map);

                if (horizontalMirrorAxisIndexNew != -1 && horizontalMirrorAxisIndex != horizontalMirrorAxisIndexNew) {
                    return map;
                }

                if (verticalMirrorAxisIndexNew != -1 && verticalMirrorAxisIndex != verticalMirrorAxisIndexNew) {
                    return map;
                }

                // unfix smudge
                if (map[i][j] == '#') {
                    map[i][j] = '.';
                } else if (map[i][j] == '.') {
                    map[i][j] = '#';
                }
            }
        }

        return map;
    }
}
