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
            List<T> copyLine = new ArrayList<>();
            copyLine.addAll(l);
            copy.add(copyLine);
        }
        return copy;
    }
}
