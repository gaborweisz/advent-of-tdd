package util;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestMatrixUtil {
    @Test
    void double_the_matrix() {
        char[][] matrix = {{'a', 'b'},
                {'c', 'd'}};
        char[][] doubledMatrix = MatrixUtil.doubleMatrix(matrix);
        char[][] expectedMatrix = {
                {'a', '.', 'b', '.'},
                {'.', '.', '.', '.'},
                {'c', '.', 'd', '.'},
                {'.', '.', '.', '.'}};
        assert MatrixUtil.areEqual(doubledMatrix, expectedMatrix);
    }

    @Test
    public void copy_a_matrix() {
        char[][] matrix = {
                {4, 4, 6, 6},
                {4, 4, 6, 6},
                {7, 7, 9, 9},
                {1, 1, 3, 3},
                {1, 1, 3, 3},
        };

        char[][] copy = MatrixUtil.copyMatrix(matrix);

        MatcherAssert.assertThat(MatrixUtil.areEqual(matrix, copy), equalTo(true));
    }

    @Test
    public void cut_a_matrix() {
        char[][] matrix = {
                {4, 4, 6, 6},
                {4, 4, 6, 6},
                {7, 7, 9, 9},
                {1, 1, 3, 3},
                {1, 1, 3, 3},
        };

        char[][] cut = MatrixUtil.cutMatrix(matrix,1,1,3,3);

        char[][] expected = {
                {4, 6, 6},
                {7, 9, 9},
                {1, 3, 3},
        };


        MatcherAssert.assertThat(MatrixUtil.areEqual(cut, expected), equalTo(true));
    }

    @Test
    public void test_is_row_empty() {
        char[][] matrix = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {' ', ' ', ' '}
        };

        int emptyRowIndex = 3;
        int nonEmptyRowIndex = 0;

        MatcherAssert.assertThat(MatrixUtil.isRowEmpty(matrix, emptyRowIndex, ' '), equalTo(true));
        MatcherAssert.assertThat(MatrixUtil.isRowEmpty(matrix, nonEmptyRowIndex, ' '), equalTo(false));
    }

    @Test
    public void test_is_column_empty() {
        char[][] matrix = {
                {'a', 'b', ' '},
                {'d', 'e', ' '},
                {'g', 'h', ' '},
                {'j', 'k', ' '}
        };

        int emptyColIndex = 2;
        int nonEmptyColIndex = 1;

        MatcherAssert.assertThat(MatrixUtil.isColumnEmpty(matrix, emptyColIndex, ' '), equalTo(true));
        MatcherAssert.assertThat(MatrixUtil.isColumnEmpty(matrix, nonEmptyColIndex, ' '), equalTo(false));
    }

    @Test
    public void add_columns_to_specified_positions() {
        char[][] matrix = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'}
        };

        char[][] expectedMatrix = {
                {'.', 'a', 'b', '.', 'c'},
                {'.', 'd', 'e', '.', 'f'},
                {'.', 'g', 'h', '.', 'i'},
                {'.', 'j', 'k', '.', 'l'}
        };

        char[][] enlargedMatrix = MatrixUtil.addNewColumns(matrix, List.of(0, 2), '.');
        assert MatrixUtil.areEqual(enlargedMatrix, expectedMatrix);

    }

    @Test
    public void add_rows_to_specified_positions() {
        char[][] matrix = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'}
        };

        char[][] expectedMatrix = {
                {'.', '.', '.'},
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'.', '.', '.'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},

        };

        char[][] enlargedMatrix = MatrixUtil.addNewRows(matrix, List.of(0, 2), '.');
        assert MatrixUtil.areEqual(enlargedMatrix, expectedMatrix);

    }

    @Test
    public void compare_columns() {
        char[][] matrix = {
                {1, 1, 3},
                {4, 4, 6},
                {7, 7, 9}
        };

        int matchingColumn1 = 0;
        int matchingColumn2 = 1;
        int nonMatchingColumn = 2;

        MatcherAssert.assertThat(MatrixUtil.compareColumns(matrix, matchingColumn1, matchingColumn2), equalTo(true));
        MatcherAssert.assertThat(MatrixUtil.compareColumns(matrix, matchingColumn1, nonMatchingColumn), equalTo(false));
        MatcherAssert.assertThat(MatrixUtil.compareColumns(matrix, matchingColumn2, nonMatchingColumn), equalTo(false));
    }

    @Test
    public void compare_rows() {
        char[][] matrix = {
                {1, 1, 3},
                {1, 1, 3},
                {7, 7, 9}
        };

        int matchingRow1 = 0;
        int matchingRow2 = 1;
        int nonMatchingRow = 2;

        MatcherAssert.assertThat(MatrixUtil.compareRows(matrix, matchingRow1, matchingRow2), equalTo(true));
        MatcherAssert.assertThat(MatrixUtil.compareRows(matrix, matchingRow1, nonMatchingRow), equalTo(false));
        MatcherAssert.assertThat(MatrixUtil.compareRows(matrix, matchingRow2, nonMatchingRow), equalTo(false));
    }

    @Test
    public void find_mirror_columns() {
        char[][] matrix = {
                {1, 1, 3, 3},
                {4, 4, 6, 6},
                {7, 7, 9, 9},
                {1, 1, 3, 3},
                {7, 7, 9, 9}
        };

        var mirrorColumns = MatrixUtil.findMirrorColumns(matrix);

        MatcherAssert.assertThat(mirrorColumns.size(), equalTo(2));
        MatcherAssert.assertThat(mirrorColumns.get(0), equalTo(0));
        MatcherAssert.assertThat(mirrorColumns.get(1), equalTo(2));

    }

    @Test
    public void find_mirror_rows() {
        char[][] matrix = {
                {4, 4, 6, 6},
                {4, 4, 6, 6},
                {7, 7, 9, 9},
                {1, 1, 3, 3},
                {1, 1, 3, 3},
        };

        var mirrorRows = MatrixUtil.findMirrorRows(matrix);

        MatcherAssert.assertThat(mirrorRows.size(), equalTo(2));
        MatcherAssert.assertThat(mirrorRows.get(0), equalTo(0));
        MatcherAssert.assertThat(mirrorRows.get(1), equalTo(3));

    }

    @Test
    public void convert_string_matrix_to_char_matrix() {
        String inputString =
                "#.##..##." +
                "..#.##.#." +
                "##......#" +
                "##......#" +
                "..#.##.#." +
                "..##..##." +
                "#.#.##.#.";

        char[][] expectedMatrix = {
                {'#', '.', '#', '#', '.', '.', '#', '#', '.'},
                {'.', '.', '#', '.', '#', '#', '.', '#', '.'},
                {'#', '#', '.', '.', '.', '.', '.', '.', '#'},
                {'#', '#', '.', '.', '.', '.', '.', '.', '#'},
                {'.', '.', '#', '.', '#', '#', '.', '#', '.'},
                {'.', '.', '#', '#', '.', '.', '#', '#', '.'},
                {'#', '.', '#', '.', '#', '#', '.', '#', '.'}};

        char[][] matrix = MatrixUtil.convertStringToMatrix(inputString, 7, 9);

        MatrixUtil.printMatrix(matrix);


        MatcherAssert.assertThat(MatrixUtil.areEqual(matrix, expectedMatrix), equalTo(true));

    }

    @Test
    public void find_vertical_mirror_axis() {
        char[][] matrix = {
                {'#', '.', '#', '#', '.', '.', '#', '#', '.'},
                {'.', '.', '#', '.', '#', '#', '.', '#', '.'},
                {'#', '#', '.', '.', '.', '.', '.', '.', '#'},
                {'#', '#', '.', '.', '.', '.', '.', '.', '#'},
                {'.', '.', '#', '.', '#', '#', '.', '#', '.'},
                {'.', '.', '#', '#', '.', '.', '#', '#', '.'},
                {'#', '.', '#', '.', '#', '#', '.', '#', '.'}};


        MatcherAssert.assertThat(MatrixUtil.isVerticalMirrorAxis(matrix, 0), equalTo(false));
        MatcherAssert.assertThat(MatrixUtil.isVerticalMirrorAxis(matrix, 1), equalTo(false));
        MatcherAssert.assertThat(MatrixUtil.isVerticalMirrorAxis(matrix, 2), equalTo(false));
        MatcherAssert.assertThat(MatrixUtil.isVerticalMirrorAxis(matrix, 3), equalTo(false));
        MatcherAssert.assertThat(MatrixUtil.isVerticalMirrorAxis(matrix, 4), equalTo(true));
        MatcherAssert.assertThat(MatrixUtil.isVerticalMirrorAxis(matrix, 5), equalTo(false));
        MatcherAssert.assertThat(MatrixUtil.isVerticalMirrorAxis(matrix, 6), equalTo(false));
        MatcherAssert.assertThat(MatrixUtil.isVerticalMirrorAxis(matrix, 7), equalTo(false));
        MatcherAssert.assertThat(MatrixUtil.isVerticalMirrorAxis(matrix, 8), equalTo(false));

    }


    @Test
    public void check_horizontal_mirror_axis() {
        String inputString =
                "#...##..#" +
                "#....#..#" +
                "..##..###" +
                "#####.##." +
                "#####.##." +
                "..##..###" +
                "#....#..#";

        char[][] matrix = MatrixUtil.convertStringToMatrix(inputString, 7, 9);


        MatcherAssert.assertThat(MatrixUtil.isHorizontalMirrorAxis(matrix, 0), equalTo(false));
        MatcherAssert.assertThat(MatrixUtil.isHorizontalMirrorAxis(matrix, 1), equalTo(false));
        MatcherAssert.assertThat(MatrixUtil.isHorizontalMirrorAxis(matrix, 2), equalTo(false));
        MatcherAssert.assertThat(MatrixUtil.isHorizontalMirrorAxis(matrix, 3), equalTo(true));
        MatcherAssert.assertThat(MatrixUtil.isHorizontalMirrorAxis(matrix, 4), equalTo(false));
        MatcherAssert.assertThat(MatrixUtil.isHorizontalMirrorAxis(matrix, 5), equalTo(false));
        MatcherAssert.assertThat(MatrixUtil.isHorizontalMirrorAxis(matrix, 6), equalTo(false));


    }


    @Test
    public void find_vertical_mirror_axis_index() {
        char[][] matrix = {
                {'#', '.', '#', '#', '.', '.', '#', '#', '.'},
                {'.', '.', '#', '.', '#', '#', '.', '#', '.'},
                {'#', '#', '.', '.', '.', '.', '.', '.', '#'},
                {'#', '#', '.', '.', '.', '.', '.', '.', '#'},
                {'.', '.', '#', '.', '#', '#', '.', '#', '.'},
                {'.', '.', '#', '#', '.', '.', '#', '#', '.'},
                {'#', '.', '#', '.', '#', '#', '.', '#', '.'}};


        MatcherAssert.assertThat(MatrixUtil.getVerticalMirrorAxisIndex(matrix, -1), equalTo(4));
    }

    @Test
    public void find_horizontal_mirror_axis_index() {
        String inputString =
                "#...##..#" +
                "#....#..#" +
                "..##..###" +
                "#####.##." +
                "#####.##." +
                "..##..###" +
                "#....#..#";

        char[][] matrix = MatrixUtil.convertStringToMatrix(inputString, 7, 9);


        MatcherAssert.assertThat(MatrixUtil.getHorizontalMirrorAxisIndex(matrix, -1), equalTo(3));
    }

    @Test
    void tilt_the_dish_north() {

        List<String> input = List.of(
                "O....#...." ,
                "O.OO#....#" ,
                ".....##..." ,
                "OO.#O....O" ,
                ".O.....O#." ,
                "O.#..O.#.#" ,
                "..O..#O..O" ,
                ".......O.." ,
                "#....###.." ,
                "#OO..#....");

        List<String> expectedResult = List.of(
                "OOOO.#.O.." ,
                "OO..#....#" ,
                "OO..O##..O" ,
                "O..#.OO..." ,
                "........#." ,
                "..#....#.#" ,
                "..O..#.O.O" ,
                "..O......." ,
                "#....###.." ,
                "#....#....");

        char[][] result = MatrixUtil.tiltNorth(ListUtil.convertToCharArrayMatrix(input));

        System.out.println("Tilted North");
        MatrixUtil.printMatrix(result);

        MatcherAssert.assertThat(MatrixUtil.areEqual(result,ListUtil.convertToCharArrayMatrix(expectedResult)), equalTo(true));

    }

    @Test
    void tilt_the_dish_east() {

        List<String> input = List.of(
                "O....#...." ,
                "O.OO#....#" ,
                ".....##..." ,
                "OO.#O....O" ,
                ".O.....O#." ,
                "O.#..O.#.#" ,
                "..O..#O..O" ,
                ".......O.." ,
                "#....###.." ,
                "#OO..#....");

        List<String> expectedResult = List.of(
                "....O#...." ,
                ".OOO#....#" ,
                ".....##..." ,
                ".OO#....OO" ,
                "......OO#." ,
                ".O#...O#.#" ,
                "....O#..OO" ,
                ".........O" ,
                "#....###.." ,
                "#..OO#....");


        char[][] result = MatrixUtil.tiltEast(ListUtil.convertToCharArrayMatrix(input));

        System.out.println("Tilted East");
        MatrixUtil.printMatrix(result);

        MatcherAssert.assertThat(MatrixUtil.areEqual(result,ListUtil.convertToCharArrayMatrix(expectedResult)), equalTo(true));
    }

    @Test
    void tilt_the_dish_west() {

        List<String> input = List.of(
                "O....#...." ,
                "O.OO#....#" ,
                ".....##..." ,
                "OO.#O....O" ,
                ".O.....O#." ,
                "O.#..O.#.#" ,
                "..O..#O..O" ,
                ".......O.." ,
                "#....###.." ,
                "#OO..#....");

        List<String> expectedResult = List.of(
                "O....#...." ,
                "OOO.#....#" ,
                ".....##..." ,
                "OO.#OO...." ,
                "OO......#." ,
                "O.#O...#.#" ,
                "O....#OO.." ,
                "O........." ,
                "#....###.." ,
                "#OO..#....");

        char[][] result = MatrixUtil.tiltWest(ListUtil.convertToCharArrayMatrix(input));

        System.out.println("Tilted West");
        MatrixUtil.printMatrix(result);

        MatcherAssert.assertThat(MatrixUtil.areEqual(result,ListUtil.convertToCharArrayMatrix(expectedResult)), equalTo(true));
    }

    @Test
    void tilt_the_dish_south() {

        List<String> input = List.of(
                "O....#...." ,
                "O.OO#....#" ,
                ".....##..." ,
                "OO.#O....O" ,
                ".O.....O#." ,
                "O.#..O.#.#" ,
                "..O..#O..O" ,
                ".......O.." ,
                "#....###.." ,
                "#OO..#....");

        List<String> expectedResult = List.of(
                ".....#...." ,
                "....#....#" ,
                "...O.##..." ,
                "...#......" ,
                "O.O....O#O" ,
                "O.#..O.#.#" ,
                "O....#...." ,
                "OO....OO.." ,
                "#OO..###.." ,
                "#OO.O#...O");

        char[][] result = MatrixUtil.tiltSouth(ListUtil.convertToCharArrayMatrix(input));

        System.out.println("Tilted South");
        MatrixUtil.printMatrix(result);

        MatcherAssert.assertThat(MatrixUtil.areEqual(result,ListUtil.convertToCharArrayMatrix(expectedResult)), equalTo(true));
    }


}
