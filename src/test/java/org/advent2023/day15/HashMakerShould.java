package org.advent2023.day15;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class HashMakerShould {


    @Test
    void calculate_hash_for_HASH() {

        MatcherAssert.assertThat(HashMaker.calculateHash("HASH"), equalTo(52));
    }

    @Test
    void calculate_hash_for_a_string() {

        MatcherAssert.assertThat(HashMaker.calculateHash("rn=1"), equalTo(30));
        MatcherAssert.assertThat(HashMaker.calculateHash("cm-"), equalTo(253));
        MatcherAssert.assertThat(HashMaker.calculateHash("qp=3"), equalTo(97));
        MatcherAssert.assertThat(HashMaker.calculateHash("cm=2"), equalTo(47));
        MatcherAssert.assertThat(HashMaker.calculateHash("qp-"), equalTo(14));
        MatcherAssert.assertThat(HashMaker.calculateHash("pc=4"), equalTo(180));
        MatcherAssert.assertThat(HashMaker.calculateHash("ot=9"), equalTo(9));
        MatcherAssert.assertThat(HashMaker.calculateHash("ab=5"), equalTo(197));
        MatcherAssert.assertThat(HashMaker.calculateHash("pc-"), equalTo(48));
        MatcherAssert.assertThat(HashMaker.calculateHash("pc=6"), equalTo(214));
        MatcherAssert.assertThat(HashMaker.calculateHash("ot=7"), equalTo(231));
    }

    @Test
    void calculate_the_sum_of_the_hashes() {

        String input = "rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7";

        MatcherAssert.assertThat(HashMaker.sumHashes(input), equalTo(1320));

    }
}
