package util;

import java.util.List;

public class MatrixUtil {

    /**
     * Doubles the given matrix by adding empty spaces between the elements
     *
     * @param originalMatrix
     * @return the doubled matrix
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
     *
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


    /**
     * Checks if the given row is empty
     *
     * @param matrix    the matrix containing the row
     * @param rowIndex  the index of the row
     * @param emptyCell the character representing an empty cell
     * @return true if the row is empty, false otherwise
     */
    public static boolean isRowEmpty(char[][] matrix, int rowIndex, char emptyCell) {
        if (matrix == null || rowIndex < 0 || rowIndex >= matrix.length) {
            // Handle invalid input
            return false;
        }

        for (int colIndex = 0; colIndex < matrix[rowIndex].length; colIndex++) {
            if (matrix[rowIndex][colIndex] != emptyCell) {
                // If any character is not a space, the row is not empty
                return false;
            }
        }

        // All characters in the row are spaces, so the row is empty
        return true;
    }

    /**
     * Checks if the given column is empty
     *
     * @param matrix    the matrix containing the column
     * @param colIndex  the index of the column
     * @param emptyCell the character representing an empty cell
     * @return true if the column is empty, false otherwise
     */
    public static boolean isColumnEmpty(char[][] matrix, int colIndex, char emptyCell) {
        if (matrix == null || colIndex < 0 || colIndex >= matrix[0].length) {
            // Handle invalid input
            return false;
        }

        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            if (matrix[rowIndex][colIndex] != emptyCell) {
                // If any cell in the column is not the empty cell, the column is not empty
                return false;
            }
        }

        // All cells in the column are the empty cell, so the column is empty
        return true;
    }


    /**
     * Add a new column to the matrix in the specified positions
     *
     * @param matrix        the matrix to which the columns will be added
     * @param columnIndexes the indexes of the columns to be added
     * @param emptyCell     the character representing an empty cell
     * @return the matrix with the new columns added
     */
    public static char[][] addNewColumns(char[][] matrix, List<Integer> columnIndexes, char emptyCell) {
        if (matrix == null || columnIndexes == null || columnIndexes.isEmpty()) {
            // Handle invalid input
            return matrix;
        }

        int originalRows = matrix.length;
        int originalColumns = matrix[0].length;
        int newColumns = columnIndexes.size();
        int totalColumns = originalColumns + newColumns;

        // Create a new matrix with an additional column for each specified column index
        char[][] enlargedMatrix = new char[originalRows][totalColumns];

        // Initialize the new matrix with the empty cells
        for (int rowIndex = 0; rowIndex < originalRows; rowIndex++) {
            for (int colIndex = 0; colIndex < totalColumns; colIndex++) {
                enlargedMatrix[rowIndex][colIndex] = emptyCell;
            }
        }

        // copy the original matrix into the new matrix
        for (int colIndex = 0, enlargedColIndex = 0; colIndex < originalColumns; colIndex++, enlargedColIndex++) {

            if (columnIndexes.contains(colIndex)) {
                enlargedColIndex++;
            }

            for (int rowIndex = 0; rowIndex < originalRows; rowIndex++) {
                enlargedMatrix[rowIndex][enlargedColIndex] = matrix[rowIndex][colIndex];
            }
        }


        return enlargedMatrix;
    }

    /**
     * Add a new rows to the matrix in the specified positions
     *
     * @param matrix     the matrix to which the rows will be added
     * @param rowIndexes the indexes of the rows to be added
     * @param emptyCell  the character representing an empty cell
     * @return the matrix with the new rows added
     */
    public static char[][] addNewRows(char[][] matrix, List<Integer> rowIndexes, char emptyCell) {
        if (matrix == null || rowIndexes == null || rowIndexes.isEmpty()) {
            // Handle invalid input
            return matrix;
        }

        int originalRows = matrix.length;
        int originalColumns = matrix[0].length;
        int newRows = rowIndexes.size();
        int totalRows = originalRows + newRows;

        // Create a new matrix with an additional rows for each specified row index
        char[][] enlargedMatrix = new char[totalRows][originalColumns];

        // Initialize the new matrix with the empty cells
        for (int rowIndex = 0; rowIndex < totalRows; rowIndex++) {
            for (int colIndex = 0; colIndex < originalColumns; colIndex++) {
                enlargedMatrix[rowIndex][colIndex] = emptyCell;
            }
        }

        // copy the original matrix into the new matrix
        for (int rowIndex = 0, enlargedRowIndex = 0; rowIndex < originalRows; rowIndex++, enlargedRowIndex++) {

            if (rowIndexes.contains(rowIndex)) {
                enlargedRowIndex++;
            }

            System.arraycopy(matrix[rowIndex], 0, enlargedMatrix[enlargedRowIndex], 0, originalColumns);
        }


        return enlargedMatrix;
    }
}
