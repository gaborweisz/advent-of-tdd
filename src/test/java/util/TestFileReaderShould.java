package util;

import org.advent.day1.Calibrator;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestFileReaderShould {
    @Test
    void read_a_file_into_a_string_array_list() {

       FileReader fr = new FileReader();
       List<String > aList = fr.readFileAndConvertToStringArray("puzzleinput_day1_a.txt");

       MatcherAssert.assertThat(aList.size(), equalTo(1000));
       MatcherAssert.assertThat(aList.get(0), equalTo("gtlbhbjgkrb5sixfivefivetwosix"));
       MatcherAssert.assertThat(aList.get(999), equalTo("eightrtsjszc2"));
    }
}
