package util;

public class MatrixUtil {

    /**
     * Doubles the given matrix by adding empty spaces between the elements
     * @param originalMatrix
     * @return the doubled matrix
     *
     */
    public static char[][] doubleMatrix(char[][] originalMatrix) {
        int originalRows = originalMatrix.length;
        int originalCols = originalMatrix[0].length;

        int doubledRows = originalRows * 2;
        int doubledCols = originalCols * 2;

        char[][] doubledMatrix = new char[doubledRows][doubledCols];

        for (int i = 0; i < originalRows; i++) {
            for (int j = 0; j < originalCols; j++) {
                char value = originalMatrix[i][j];

                // Copy the value to the corresponding position in the doubled matrix and fill the empty spaces with '.'
                doubledMatrix[i * 2][j * 2] = value;
                doubledMatrix[i * 2][j * 2 + 1] = '.';
                doubledMatrix[i * 2 + 1][j * 2] = '.';
                doubledMatrix[i * 2 + 1][j * 2 + 1] = '.';
            }
        }

        return doubledMatrix;
    }

    /**
     * Checks if the given matrices are equal
     * @param matrix1
     * @param matrix2
     * @return ture if equal, false otherwise
     */
    public static boolean areEqual(char[][] matrix1, char[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            return false; // Matrices have different dimensions
        }

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false; // Elements at corresponding positions are different
                }
            }
        }

        return true;
    }

    /**
     * Prints the given matrix
     */
    public static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}
