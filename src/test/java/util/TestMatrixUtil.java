package util;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
    public void test_is_row_empty() {
        char[][] matrix = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {' ', ' ', ' '}
        };

        int emptyRowIndex = 3;
        int nonEmptyRowIndex = 0;

        MatcherAssert.assertThat(MatrixUtil.isRowEmpty(matrix, emptyRowIndex, ' ' ), equalTo(true));
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

        MatcherAssert.assertThat(MatrixUtil.isColumnEmpty(matrix, emptyColIndex, ' ' ), equalTo(true));
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

        char[][] enlargedMatrix = MatrixUtil.addNewColumns(matrix, List.of( 0, 2), '.');
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

        char[][] enlargedMatrix = MatrixUtil.addNewRows(matrix, List.of( 0, 2), '.');
        assert MatrixUtil.areEqual(enlargedMatrix, expectedMatrix);

    }

}
