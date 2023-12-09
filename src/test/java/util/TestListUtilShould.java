package util;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestListUtilShould {

    @Test
    void copies_list_of_list() {

        List<List<Long>> originalList = Arrays.asList(
                Arrays.asList(1L, 2L, 3L),
                Arrays.asList(4L, 5L, 6L)
        );
        List<List<Long>> copiedList = ListUtil.copyListOfLists(originalList);

        MatcherAssert.assertThat(copiedList.size(), equalTo(2));
        MatcherAssert.assertThat(copiedList.get(0).size(), equalTo(3));
        MatcherAssert.assertThat(copiedList.get(0).get(0), equalTo(1L));
        MatcherAssert.assertThat(copiedList.get(0).get(1), equalTo(2L));
        MatcherAssert.assertThat(copiedList.get(0).get(2), equalTo(3L));

        MatcherAssert.assertThat(copiedList.get(1).size(), equalTo(3));
        MatcherAssert.assertThat(copiedList.get(1).get(0), equalTo(4L));
        MatcherAssert.assertThat(copiedList.get(1).get(1), equalTo(5L));
        MatcherAssert.assertThat(copiedList.get(1).get(2), equalTo(6L));

        List<List<Integer>> originalList2 = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6)
        );
        List<List<Integer>> copiedList2 = ListUtil.copyListOfLists(originalList2);

        MatcherAssert.assertThat(copiedList2.size(), equalTo(2));
        MatcherAssert.assertThat(copiedList2.get(0).size(), equalTo(3));
        MatcherAssert.assertThat(copiedList2.get(0).get(0), equalTo(1));
        MatcherAssert.assertThat(copiedList2.get(0).get(1), equalTo(2));
        MatcherAssert.assertThat(copiedList2.get(0).get(2), equalTo(3));

        MatcherAssert.assertThat(copiedList2.get(1).size(), equalTo(3));
        MatcherAssert.assertThat(copiedList2.get(1).get(0), equalTo(4));
        MatcherAssert.assertThat(copiedList2.get(1).get(1), equalTo(5));
        MatcherAssert.assertThat(copiedList2.get(1).get(2), equalTo(6));

    }
}
