package util;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;

public class StringParserShould {

    @Test
    void read_parse_a_string_into_an_array_list_based_on_a_separator() {
        String input = "41 48 83 86 17";
        ArrayList<Integer> aList = StringParser.parseStringToIntArrayList(input, " ");

        MatcherAssert.assertThat(aList.size(), equalTo(5));
        MatcherAssert.assertThat(aList.get(0), equalTo(41));
        MatcherAssert.assertThat(aList.get(1), equalTo(48));
        MatcherAssert.assertThat(aList.get(2), equalTo(83));
        MatcherAssert.assertThat(aList.get(3), equalTo(86));
        MatcherAssert.assertThat(aList.get(4), equalTo(17));

    }

    @Test
    void read_return_an_empty_list_if_input_is_empty() {
        String input = "";
        ArrayList<Integer> aList = StringParser.parseStringToIntArrayList(input, " ");

        MatcherAssert.assertThat(aList.size(), equalTo(0));
    }

    @Test
    void read_return_list_of_one_if_input_contains_one_element() {
        String input = "55";
        ArrayList<Integer> aList = StringParser.parseStringToIntArrayList(input, " ");

        MatcherAssert.assertThat(aList.size(), equalTo(1));
        MatcherAssert.assertThat(aList.get(0), equalTo(55));
    }
}
