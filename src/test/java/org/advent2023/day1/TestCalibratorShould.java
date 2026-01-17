package org.advent2023.day1;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class TestCalibratorShould {
    @Test
    void have_return_the_right_two_digit_number() {

        MatcherAssert.assertThat(Calibrator.getCalibrationValue("1abc2"), equalTo(12));
        MatcherAssert.assertThat(Calibrator.getCalibrationValue("pqr3stu8vwx"), equalTo(38));
        MatcherAssert.assertThat(Calibrator.getCalibrationValue("a1b2c3d4e5f"), equalTo(15));
        MatcherAssert.assertThat(Calibrator.getCalibrationValue("treb7uchet"), equalTo(77));
    }

    @Test
    void have_return_the_right_two_digit_number_if_text_is_given() {

        MatcherAssert.assertThat(Calibrator.getCalibrationValueText("two1nine"), equalTo(29));
        MatcherAssert.assertThat(Calibrator.getCalibrationValueText("eightwothree"), equalTo(83));
        MatcherAssert.assertThat(Calibrator.getCalibrationValueText("abcone2threexyz"), equalTo(13));
        MatcherAssert.assertThat(Calibrator.getCalibrationValueText("xtwone3four"), equalTo(24));
        MatcherAssert.assertThat(Calibrator.getCalibrationValueText("4nineeightseven2"), equalTo(42));
        MatcherAssert.assertThat(Calibrator.getCalibrationValueText("zoneight234"), equalTo(14));
        MatcherAssert.assertThat(Calibrator.getCalibrationValueText("7pqrstsixteen"), equalTo(76));
        MatcherAssert.assertThat(Calibrator.getCalibrationValueText("eighthree"), equalTo(83));
        MatcherAssert.assertThat(Calibrator.getCalibrationValueText("1five7eight1"), equalTo(11));
        MatcherAssert.assertThat(Calibrator.getCalibrationValueText("six78fivethreesix7fivetwo"), equalTo(62));

    }


    @Test
    void have_return_the_right_first_numeric_character() {

        MatcherAssert.assertThat(Calibrator.getFirstDigit("1abc2"), equalTo('1'));
        MatcherAssert.assertThat(Calibrator.getFirstDigit("abc2"), equalTo('2'));
    }

    @Test
    void have_return_a_if_there_is_no_numeric_character() {

        MatcherAssert.assertThat(Calibrator.getFirstDigit("yuio"), equalTo('a'));
        MatcherAssert.assertThat(Calibrator.getFirstDigit("abcd"), equalTo('a'));
    }

    @Test
    void have_return_the_right_last_numeric_character() {

        MatcherAssert.assertThat(Calibrator.getLastDigit("1abc2"), equalTo('2'));
        MatcherAssert.assertThat(Calibrator.getLastDigit("2abc"), equalTo('2'));
    }

    @Test
    void have_return_a_if_the_string_is_empty() {

        MatcherAssert.assertThat(Calibrator.getLastDigit(""), equalTo('a'));
    }

    @Test
    void have_returned_the_first_number() {

        MatcherAssert.assertThat(Calibrator.getFirstNumber("one"), equalTo("1"));
        MatcherAssert.assertThat(Calibrator.getFirstNumber("two"), equalTo("2"));
        MatcherAssert.assertThat(Calibrator.getFirstNumber("three"), equalTo("3"));
        MatcherAssert.assertThat(Calibrator.getFirstNumber("four"), equalTo("4"));
        MatcherAssert.assertThat(Calibrator.getFirstNumber("five"), equalTo("5"));
        MatcherAssert.assertThat(Calibrator.getFirstNumber("six"), equalTo("6"));
        MatcherAssert.assertThat(Calibrator.getFirstNumber("seven"), equalTo("7"));
        MatcherAssert.assertThat(Calibrator.getFirstNumber("eight"), equalTo("8"));
        MatcherAssert.assertThat(Calibrator.getFirstNumber("nine"), equalTo("9"));
        MatcherAssert.assertThat(Calibrator.getFirstNumber("nineight"), equalTo("9"));
        MatcherAssert.assertThat(Calibrator.getFirstNumber("twone"), equalTo("2"));
        MatcherAssert.assertThat(Calibrator.getFirstNumber("1nineight"), equalTo("1"));
        MatcherAssert.assertThat(Calibrator.getFirstNumber("tw2one"), equalTo("2"));
        MatcherAssert.assertThat(Calibrator.getFirstNumber("twne3"), equalTo("3"));
        MatcherAssert.assertThat(Calibrator.getFirstNumber("9hcj"), equalTo("9"));
    }

    @Test
    void have_returned_the_last_number() {

        MatcherAssert.assertThat(Calibrator.getLastNumber("one"), equalTo("1"));
        MatcherAssert.assertThat(Calibrator.getLastNumber("two"), equalTo("2"));
        MatcherAssert.assertThat(Calibrator.getLastNumber("three"), equalTo("3"));
        MatcherAssert.assertThat(Calibrator.getLastNumber("four"), equalTo("4"));
        MatcherAssert.assertThat(Calibrator.getLastNumber("five"), equalTo("5"));
        MatcherAssert.assertThat(Calibrator.getLastNumber("six"), equalTo("6"));
        MatcherAssert.assertThat(Calibrator.getLastNumber("seven"), equalTo("7"));
        MatcherAssert.assertThat(Calibrator.getLastNumber("eight"), equalTo("8"));
        MatcherAssert.assertThat(Calibrator.getLastNumber("nine"), equalTo("9"));
        MatcherAssert.assertThat(Calibrator.getLastNumber("nineight"), equalTo("8"));
        MatcherAssert.assertThat(Calibrator.getLastNumber("twone"), equalTo("1"));
        MatcherAssert.assertThat(Calibrator.getLastNumber("1nineight"), equalTo("8"));
        MatcherAssert.assertThat(Calibrator.getLastNumber("tw2one"), equalTo("1"));
        MatcherAssert.assertThat(Calibrator.getLastNumber("twne3"), equalTo("3"));
        MatcherAssert.assertThat(Calibrator.getLastNumber("9hcj"), equalTo("9"));
        MatcherAssert.assertThat(Calibrator.getLastNumber("fourtwo15nine1"), equalTo("1"));


    }
}
