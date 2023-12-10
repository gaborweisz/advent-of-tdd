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
}
