package util;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class MathShould {

    @Test
    void calculate_the_least_common_multiple() {

        double[] array1 = {2.5, 3.0, 1.5, 2.0};
        MatcherAssert.assertThat(30.0, equalTo(MathUtil.calculateLCM(array1)));

        double[] array2 = {5.0, 7.5, 10.0};
        MatcherAssert.assertThat(30.0, equalTo(MathUtil.calculateLCM(array2)));

        double[] array3 = {1.5, 2.5, 3.0};
        MatcherAssert.assertThat(15.0, equalTo(MathUtil.calculateLCM(array3)));

        double[] array4 = {1.5, 2.5, 3.0, 5.0};
        MatcherAssert.assertThat(15.0, equalTo(MathUtil.calculateLCM(array4)));
    }
}
