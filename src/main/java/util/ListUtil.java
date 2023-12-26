package util;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {

    /**
     * Copy a list of lists
     * @param list of lists to be copied
     * @return copied list of lists
     */
    public static <T> List<List<T>> copyListOfLists(List<List<T>> list) {
        List<List<T>> copy = new ArrayList<>();
        for (List<T> l : list) {
            List<T> copyLine = new ArrayList<>(l);
            copy.add(copyLine);
        }
        return copy;
    }

    public static char[][] convertToCharArrayMatrix(List<String> stringList) {
        if (stringList == null || stringList.isEmpty()) {
            return new char[0][0]; // Return an empty matrix if the list is null or empty
        }

        int numRows = stringList.size();
        int numCols = stringList.get(0).length();

        char[][] charMatrix = new char[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            String currentString = stringList.get(i);
            if (currentString.length() != numCols) {
                throw new IllegalArgumentException("All strings in the list must have the same length");
            }

            char[] charArray = currentString.toCharArray();
            System.arraycopy(charArray, 0, charMatrix[i], 0, numCols);
        }

        return charMatrix;
    }

    public static int[][] convertToIntArrayMatrix(List<String> stringList) {
        if (stringList == null || stringList.isEmpty()) {
            return new int[0][0]; // Return an empty matrix if the list is null or empty
        }

        int numRows = stringList.size();
        int numCols = stringList.get(0).length();

        int[][] charMatrix = new int[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            String currentString = stringList.get(i);
            if (currentString.length() != numCols) {
                throw new IllegalArgumentException("All strings in the list must have the same length");
            }

            for (int j = 0; j < numCols; j++) {
                charMatrix[i][j] = Character.getNumericValue(currentString.charAt(j));
            }
        }

        return charMatrix;
    }

    /**
     * Convert a list of strings to a list of char matrices. The strings in the list are separated by empty strings.
     * @param stringList list of strings
     * @return list of char matrices
     */
    public static List<char[][]> convertToCharMatrixList(List<String> stringList) {
        if (stringList == null || stringList.isEmpty()) {
            return new ArrayList<>(); // Return an empty matrix if the list is null or empty
        }

        List<char[][]> charMatrix = new ArrayList<>();

        List<String> currentStringList = new ArrayList<>();

        for (String s : stringList) {
            if (s.isEmpty()) {
                charMatrix.add(convertToCharArrayMatrix(currentStringList));
                currentStringList.clear();
            } else {
                currentStringList.add(s);
            }
        }

        if (!currentStringList.isEmpty()) {
            charMatrix.add(convertToCharArrayMatrix(currentStringList));
        }

        return charMatrix;
    }
}
