package util;

import org.junit.jupiter.api.Test;

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

}
