package util;

import java.util.ArrayList;

public class StringParser {

    /**
     * Parses a string into an ArrayList of Integers based on a separator
     *
     * @param input     string to parse
     * @param separator separator
     * @return ArrayList of Integers
     */
    public static ArrayList<Integer> parseStringToIntArrayList(String input, String separator) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.isEmpty()) {
            return result;
        }
        String[] parts = input.trim().split(separator);
        if (parts.length == 1) {
            result.add(Integer.parseInt(parts[0].trim()));
        } else if (parts.length > 1){
            for (String part : parts) {
                if (part.length() > 0)
                    result.add(Integer.parseInt(part.trim()));
            }
        }
        return result;
    }
}
