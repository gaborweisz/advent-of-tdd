package util;

import java.util.ArrayList;
import java.util.List;

public class MatrixUtil {

    /**
     * Doubles the given matrix by adding empty spaces between the elements
     *
     * @param originalMatrix the matrix to be doubled
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
     * @param matrix1 the first matrix
     * @param matrix2  the second matrix
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
     *Cuts the submatrix from the given matrix
     * @param matrix  the matrix from which the submatrix will be cut
     * @param startRow the row from which the submatrix starts (inclusive)
     * @param endRow the row at which the submatrix ends (inclusive)
     * @param startCol the column from which the submatrix starts (inclusive)
     * @param endCol    the column at which the submatrix ends (inclusive)
     * @return the submatrix
     */
    public static char[][]  cutMatrix(char[][] matrix, int startRow, int startCol, int endRow, int endCol) {
        char[][] cutMatrix = new char[endRow - startRow + 1][endCol - startCol + 1];

        for (int i = startRow; i <= endRow; i++) {
            if (endCol + 1 - startCol >= 0)
                System.arraycopy(matrix[i], startCol, cutMatrix[i - startRow], 0, endCol + 1 - startCol);
        }

        return cutMatrix;
    }

    /**
     * Prints the given matrix
     */
    public static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char cell : row) {
                if (cell == '\u0000') {
                    System.out.print('.');
                } else {
                    System.out.print(cell);
                }
            }
            System.out.println();
        }
    }

    /**
     * Prints the given matrix
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                if (cell == '\u0000') {
                    System.out.print('.');
                } else {
                    System.out.print(cell + " ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Copies the given matrix
     */
    public static char[][]  copyMatrix(char[][] matrix) {
        char[][] copy = new char[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, copy[i], 0, matrix[0].length);
        }
        return copy;
    }

    /**
     * Fills the matrix with the givenn character
     */
    public static void fillMatrix(char[][] matrix, char filler) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = filler;
            }
        }
    }

    /**
     * Counts the number of occurrences of the given character in the matrix
     */
    public static int countField(char[][] matrix, char c) {
        int count = 0;
        for (char[] chars : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (chars[j] == c) {
                    count++;
                }
            }
        }
        return count;
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

        for (char[] chars : matrix) {
            if (chars[colIndex] != emptyCell) {
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

    /**
     * Compares the elements in the specified columns of the given matrix
     *
     * @param matrix    the matrix containing the row
     * @param column1  the index of column 1
     * @param column2 the index of column 2
     * @return true if the two columns matches, false otherwise
     */
    public static boolean compareColumns(char[][] matrix, int column1, int column2) {
        // Check if the matrix is valid
        if (matrix == null || matrix.length == 0 || matrix[0].length <= Math.max(column1, column2)) {
            throw new IllegalArgumentException("Invalid matrix or column indexes");
        }

        // Iterate through the rows and compare corresponding elements in the specified columns
        for (char[] chars : matrix) {
            if (chars[column1] != chars[column2]) {
                return false; // Columns don't match
            }
        }

        return true; // All elements in the specified columns match
    }

    /**
     * Compares the elements in the specified columns of the given matrix
     *
     * @param matrix    the matrix containing the row
     * @param row1  the index of column 1
     * @param row2 the index of column 2
     * @return true if the two columns matches, false otherwise
     */
    public static boolean compareRows(char[][] matrix, int row1, int row2) {
        // Check if the matrix is valid
        if (matrix == null || matrix.length == 0 || matrix.length <= Math.max(row1, row2)) {
            throw new IllegalArgumentException("Invalid matrix or column indexes");
        }

        // Iterate through the rows and compare corresponding elements in the specified columns
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[row1][i] != matrix[row2][i]) {
                return false; // Columns don't match
            }
        }

        return true; // All elements in the specified columns match
    }

    /**
     * Finds all columns in the given matrix that are mirror images of each other
     * @param matrix the matrix to be searched
     * @return list of column indexes that are mirror images of each other in the given matrix. Only include the leftmost column of each pair of mirror columns.
     */
    public static List<Integer> findMirrorColumns(char[][] matrix) {
        // Check if the matrix is valid
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Invalid matrix");
        }

        List<Integer> mirrorColumns = new ArrayList<>();

        // Iterate through the columns and compare it with the next column
        for (int i = 0; i < matrix[0].length-1; i++) {
            if (compareColumns(matrix, i, i + 1)) {
                mirrorColumns.add(i);
            }
        }

        return mirrorColumns;
    }

    /**
     * Finds all rows in the given matrix that are mirror images of each other
     * @param matrix the matrix to be searched
     * @return list of row indexes that are mirror images of each other in the given matrix. Only include the topmost row of each pair of mirror rows.
     */
    public static List<Integer> findMirrorRows(char[][] matrix) {
        // Check if the matrix is valid
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Invalid matrix");
        }

        List<Integer> mirrorRows = new ArrayList<>();

        // Iterate through the columns and compare it with the next column
        for (int i = 0; i < matrix.length-1; i++) {
            if (compareRows(matrix, i, i + 1)) {
                mirrorRows.add(i);
            }
        }

        return mirrorRows;
    }

    /**
     * Converts the given string to a matrix of the specified size
     * @param input the string to be converted
     * @param rows number of rows in the matrix
     * @param cols number of columns in the matrix
     * @return the matrix containing the characters in the given string
     */
    public static char[][] convertStringToMatrix(String input, int rows, int cols) {
        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = input.charAt(i * cols + j);
            }
        }

        return matrix;
    }

    /**
     * Checks if the given column index is a vertical mirror axis in the given matrix
     * @param matrix the matrix to be converted
     * @param columnIndex the index of the column to be checked
     * @return true if the given column index is a vertical mirror axis in the given matrix, false otherwise
     */
    public static boolean isVerticalMirrorAxis(char[][] matrix, int columnIndex) {
        // Check if the matrix is valid
        if (matrix == null || matrix.length == 0 || matrix[0].length <= columnIndex || columnIndex < 0) {
            throw new IllegalArgumentException("Invalid matrix");
        }

        if (columnIndex == matrix[0].length - 1) {
            // The last column cannot be a vertical mirror axis
            return false;
        }

        for (int j = columnIndex, i = columnIndex + 1; j >= 0 && i < matrix[0].length; j--) {
            if (!compareColumns(matrix, j, i)) {
                return false;
            }
            i++;
        }

        return true;
    }

    /**
     * Checks if the given ros index is a horizontal mirror axis in the given matrix
     * @param matrix the matrix to be converted
     * @param rowIndex the index of the row to be checked
     * @return true if the given row index is a horizontal mirror axis in the given matrix, false otherwise
     */
    public static boolean isHorizontalMirrorAxis(char[][] matrix, int rowIndex) {
        // Check if the matrix is valid
        if (matrix == null || matrix.length <= rowIndex || rowIndex < 0) {
            throw new IllegalArgumentException("Invalid matrix");
        }

        if (rowIndex == matrix.length - 1) {
            // The last row cannot be a vertical mirror axis
            return false;
        }

        for (int j = rowIndex, i = rowIndex + 1; j >= 0 && i < matrix.length; j--) {
            if (!compareRows(matrix, j, i)) {
                return false;
            }
            i++;
        }

        return true;
    }

    /**
     * Finds the index of the vertical mirror axis in the given matrix
     * @param matrix the matrix to be processed
     * @return the index of the vertical mirror axis in the given matrix, -1 if there is no vertical mirror axis
     */
    public static int getVerticalMirrorAxisIndex(char[][] matrix, int skipIndex) {

        for (int i = 0; i < matrix[0].length; i++) {
            if (i == skipIndex) {
                continue;
            }
            if (isVerticalMirrorAxis(matrix, i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Finds the index of the horizontal mirror axis in the given matrix
     * @param matrix the matrix to be processed
     * @return the index of the horizontal mirror axis in the given matrix, -1 if there is no horizontal mirror axis
     */
    public static int getHorizontalMirrorAxisIndex(char[][] matrix, int skipIndex) {

        for (int i = 0; i < matrix.length; i++) {
            if (i == skipIndex) {
                continue;
            }
            if (isHorizontalMirrorAxis(matrix, i)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Moves all stones represented by 'O' north until it's blocked.Empty fields are represented by '.'.
     * @param dish matrix to be tilted
     * @return the dish after tilting north
     */
    public static char[][] tiltNorth(char[][] dish) {

        char[][] newDish = MatrixUtil.copyMatrix(dish);

        for (int k = 1; k < newDish.length; k++) {
            for (int i = 1; i < newDish.length; i++) {
                for (int j = 0; j < newDish[0].length; j++) {
                    if (newDish[i - 1][j] == '.' && newDish[i][j] == 'O') {
                        //move one step north
                        newDish[i][j] = '.';
                        newDish[i - 1][j] = 'O';
                    }
                }
            }
        }
        return newDish;
    }

    /**
     * Moves all stones represented by 'O' south until it's blocked. Empty fields are represented by '.'.
     * @param dish matrix to be tilted
     * @return the dish after tilting south
     */
    public static char[][] tiltSouth(char[][] dish) {

        char[][] newDish = MatrixUtil.copyMatrix(dish);

        for (int k = 1; k < newDish.length; k++) {
            for (int i = newDish.length - 2; i >= 0; i--) {
                for (int j = 0; j < newDish[0].length; j++) {
                    if (newDish[i +1][j] == '.' && newDish[i][j] == 'O') {
                        //move one step south
                        newDish[i][j] = '.';
                        newDish[i + 1][j] = 'O';
                    }
                }
            }
        }
        return newDish;
    }

    /**
     * Moves all stones represented by 'O' west until it's blocked.Empty fields are represented by '.'.
     * @param dish matrix to be tilted
     * @return the dish after tilting west
     */
    public static char[][] tiltWest(char[][] dish) {
        char[][] newDish = MatrixUtil.copyMatrix(dish);

        for (int k = 1; k < newDish[0].length; k++) {
            for (int i = 0; i < newDish.length; i++) {
                for (int j = 1; j < newDish[0].length; j++) {
                    if (newDish[i][j-1] == '.' && newDish[i][j] == 'O') {
                        //move one step north
                        newDish[i][j] = '.';
                        newDish[i][j-1] = 'O';
                    }
                }
            }
        }
        return newDish;
    }

    /**
     * Moves all stones represented by 'O' east until it's blocked.Empty fields are represented by '.'.
     * @param dish matrix to be tilted
     * @return the dish after tilting east
     */
    public static char[][] tiltEast(char[][] dish) {
        char[][] newDish = MatrixUtil.copyMatrix(dish);

        for (int k = 1; k < newDish[0].length; k++) {
            for (int i = 0; i < newDish.length; i++) {
                for (int j = newDish[0].length - 2; j >=0; j--) {
                    if (newDish[i][j+1] == '.' && newDish[i][j] == 'O') {
                        //move one step north
                        newDish[i][j] = '.';
                        newDish[i][j+1] = 'O';
                    }
                }
            }
        }
        return newDish;
    }


}
