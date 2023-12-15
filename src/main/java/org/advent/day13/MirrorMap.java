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
            int verticalMirrorAxisIndex = MatrixUtil.getVerticalMirrorAxisIndex(map, -1);
            int horizontalMirrorAxisIndex = MatrixUtil.getHorizontalMirrorAxisIndex(map, -1);

            count += horizontalMirrorAxisIndex == -1 ? 0 : (horizontalMirrorAxisIndex + 1) * 100;
            count += verticalMirrorAxisIndex == -1 ? 0 : verticalMirrorAxisIndex + 1;

        }

        return count;
    }


    public static int countRowsAfterFixingSmudge(List<String> input) {
        int count = 0;

        List<char[][]> maps = ListUtil.convertToCharMatrixList(input);

        for (char[][] map : maps) {
            int verticalMirrorAxisIndexOrig = MatrixUtil.getVerticalMirrorAxisIndex(map, -1);
            int horizontalMirrorAxisIndexOrig = MatrixUtil.getHorizontalMirrorAxisIndex(map, -1);

            map = fixSmudge(map);

            int verticalMirrorAxisIndexNew = MatrixUtil.getVerticalMirrorAxisIndex(map, verticalMirrorAxisIndexOrig);
            int horizontalMirrorAxisIndexNew = MatrixUtil.getHorizontalMirrorAxisIndex(map, horizontalMirrorAxisIndexOrig);

            if (verticalMirrorAxisIndexNew != -1 && verticalMirrorAxisIndexNew != verticalMirrorAxisIndexOrig) {

                System.out.println(">>>>>>>>>>>>> New vert axis. Found at " + verticalMirrorAxisIndexNew );
                count += (verticalMirrorAxisIndexNew + 1);
            }

            if (horizontalMirrorAxisIndexNew != -1 && horizontalMirrorAxisIndexNew != horizontalMirrorAxisIndexOrig) {
                System.out.println(">>>>>>>>>>>>> New horiz axis. Found at " + horizontalMirrorAxisIndexNew);
                count += (horizontalMirrorAxisIndexNew + 1) * 100;
            }

        }

        return count;
    }


    public static char[][] fixSmudge(char[][] map) {
        int verticalMirrorAxisIndex = MatrixUtil.getVerticalMirrorAxisIndex(map, -1);
        int horizontalMirrorAxisIndex = MatrixUtil.getHorizontalMirrorAxisIndex(map, -1);

        if (verticalMirrorAxisIndex == -1 && horizontalMirrorAxisIndex == -1) {
            return map;
        }

        System.out.println("------------------------------");
        System.out.println("Map before fixing smudge:");
        System.out.println("vert : " + verticalMirrorAxisIndex + " horiz : " + horizontalMirrorAxisIndex);
        MatrixUtil.printMatrix(map);
        System.out.println("------------------------------");
        System.out.println("Map after fixing smudge:");
        System.out.println("------------------------------");

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {

                // try to fix smudge
                if (map[i][j] == '.') {
                    map[i][j] = '#';
                } else if (map[i][j] == '#') {
                    map[i][j] = '.';
                }

                int verticalMirrorAxisIndexNew = MatrixUtil.getVerticalMirrorAxisIndex(map, verticalMirrorAxisIndex);
                int horizontalMirrorAxisIndexNew = MatrixUtil.getHorizontalMirrorAxisIndex(map, horizontalMirrorAxisIndex);

                if (horizontalMirrorAxisIndexNew != -1 && horizontalMirrorAxisIndex != horizontalMirrorAxisIndexNew) {

                    System.out.println("New horiz axis. Found smudge at " + i + " " + j + " || vert axis " + verticalMirrorAxisIndexNew + " horiz axis : " + horizontalMirrorAxisIndexNew);
                    System.out.println("------------------------------");
                    MatrixUtil.printMatrix(map);
                    return map;
                }

                if (verticalMirrorAxisIndexNew != -1 && verticalMirrorAxisIndex != verticalMirrorAxisIndexNew) {
                    System.out.println("New vertical axis. Found smudge at " + i + " " + j + " || vert axis " + verticalMirrorAxisIndexNew + " horiz axis : " + horizontalMirrorAxisIndexNew);
                    System.out.println("------------------------------");
                    MatrixUtil.printMatrix(map);
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

        System.out.println("------------------------------");
        System.out.println("------------------------------");

        return map;
    }
}
