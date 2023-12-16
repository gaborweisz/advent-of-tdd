package util;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestFileReaderShould {
    @Test
    void read_a_file_into_a_string_array_list() {

        FileReader fr = new FileReader();
        List<String> aList = fr.readFileAndConvertToStringArray("puzzleinput_day1.txt");

        MatcherAssert.assertThat(aList.size(), equalTo(1000));
        MatcherAssert.assertThat(aList.get(0), equalTo("gtlbhbjgkrb5sixfivefivetwosix"));
        MatcherAssert.assertThat(aList.get(999), equalTo("eightrtsjszc2"));
    }


    @Test
    void read_a_file_into_a_string() {

        FileReader fr = new FileReader();
        String line = fr.readFileAndConvertToString("puzzleinput_day15.txt");

        MatcherAssert.assertThat(line.length(), equalTo(22835));
    }

}
