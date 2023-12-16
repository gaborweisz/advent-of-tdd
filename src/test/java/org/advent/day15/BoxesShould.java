package org.advent.day15;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class BoxesShould {
    @Test
    void process_input() {

        String inputString = "rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7";
        Boxes boxes = new Boxes();
        String[] input = inputString .split(",");

        boxes.processLens(input[0]); //rn=1
        MatcherAssert.assertThat(boxes.boxes.get(0).id, equalTo(0));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.size(), equalTo(1));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(0).id, equalTo("rn"));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(0).focalLength, equalTo(1));

        boxes.processLens(input[1]); //cm-
        MatcherAssert.assertThat(boxes.boxes.get(0).id, equalTo(0));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.size(), equalTo(1));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(0).id, equalTo("rn"));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(0).focalLength, equalTo(1));

        boxes.processLens(input[2]); //qp=3
        MatcherAssert.assertThat(boxes.boxes.get(0).id, equalTo(0));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.size(), equalTo(1));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(0).id, equalTo("rn"));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(0).focalLength, equalTo(1));

        MatcherAssert.assertThat(boxes.boxes.get(1).id, equalTo(1));
        MatcherAssert.assertThat(boxes.boxes.get(1).lenses.size(), equalTo(1));
        MatcherAssert.assertThat(boxes.boxes.get(1).lenses.get(0).id, equalTo("qp"));
        MatcherAssert.assertThat(boxes.boxes.get(1).lenses.get(0).focalLength, equalTo(3));

        boxes.processLens(input[3]); //cm=2
        MatcherAssert.assertThat(boxes.boxes.get(0).id, equalTo(0));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.size(), equalTo(2));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(0).id, equalTo("rn"));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(0).focalLength, equalTo(1));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(1).id, equalTo("cm"));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(1).focalLength, equalTo(2));

        MatcherAssert.assertThat(boxes.boxes.get(1).id, equalTo(1));
        MatcherAssert.assertThat(boxes.boxes.get(1).lenses.size(), equalTo(1));
        MatcherAssert.assertThat(boxes.boxes.get(1).lenses.get(0).id, equalTo("qp"));
        MatcherAssert.assertThat(boxes.boxes.get(1).lenses.get(0).focalLength, equalTo(3));


        boxes.processLens(input[4]); //qp-
        MatcherAssert.assertThat(boxes.boxes.get(0).id, equalTo(0));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.size(), equalTo(2));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(0).id, equalTo("rn"));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(0).focalLength, equalTo(1));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(1).id, equalTo("cm"));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(1).focalLength, equalTo(2));

        MatcherAssert.assertThat(boxes.boxes.get(1).id, equalTo(1));
        MatcherAssert.assertThat(boxes.boxes.get(1).lenses.size(), equalTo(0));

        boxes.processLens(input[5]); //pc=4
        MatcherAssert.assertThat(boxes.boxes.get(0).id, equalTo(0));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.size(), equalTo(2));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(0).id, equalTo("rn"));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(0).focalLength, equalTo(1));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(1).id, equalTo("cm"));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(1).focalLength, equalTo(2));

        MatcherAssert.assertThat(boxes.boxes.get(3).id, equalTo(3));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.size(), equalTo(1));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.get(0).id, equalTo("pc"));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.get(0).focalLength, equalTo(4));

        boxes.processLens(input[6]); //ot=9
        MatcherAssert.assertThat(boxes.boxes.get(0).id, equalTo(0));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.size(), equalTo(2));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(0).id, equalTo("rn"));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(0).focalLength, equalTo(1));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(1).id, equalTo("cm"));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(1).focalLength, equalTo(2));

        MatcherAssert.assertThat(boxes.boxes.get(3).id, equalTo(3));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.size(), equalTo(2));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.get(0).id, equalTo("pc"));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.get(0).focalLength, equalTo(4));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.get(1).id, equalTo("ot"));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.get(1).focalLength, equalTo(9));

        boxes.processLens(input[7]); //ab=5
        MatcherAssert.assertThat(boxes.boxes.get(0).id, equalTo(0));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.size(), equalTo(2));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(0).id, equalTo("rn"));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(0).focalLength, equalTo(1));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(1).id, equalTo("cm"));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(1).focalLength, equalTo(2));

        MatcherAssert.assertThat(boxes.boxes.get(3).id, equalTo(3));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.size(), equalTo(3));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.get(0).id, equalTo("pc"));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.get(0).focalLength, equalTo(4));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.get(1).id, equalTo("ot"));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.get(1).focalLength, equalTo(9));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.get(2).id, equalTo("ab"));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.get(2).focalLength, equalTo(5));

        boxes.processLens(input[8]); //pc-
        MatcherAssert.assertThat(boxes.boxes.get(0).id, equalTo(0));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.size(), equalTo(2));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(0).id, equalTo("rn"));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(0).focalLength, equalTo(1));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(1).id, equalTo("cm"));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(1).focalLength, equalTo(2));

        MatcherAssert.assertThat(boxes.boxes.get(3).id, equalTo(3));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.size(), equalTo(2));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.get(0).id, equalTo("ot"));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.get(0).focalLength, equalTo(9));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.get(1).id, equalTo("ab"));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.get(1).focalLength, equalTo(5));

        boxes.processLens(input[9]); //pc=6
        MatcherAssert.assertThat(boxes.boxes.get(0).id, equalTo(0));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.size(), equalTo(2));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(0).id, equalTo("rn"));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(0).focalLength, equalTo(1));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(1).id, equalTo("cm"));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(1).focalLength, equalTo(2));

        MatcherAssert.assertThat(boxes.boxes.get(3).id, equalTo(3));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.size(), equalTo(3));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.get(0).id, equalTo("ot"));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.get(0).focalLength, equalTo(9));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.get(1).id, equalTo("ab"));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.get(1).focalLength, equalTo(5));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.get(2).id, equalTo("pc"));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.get(2).focalLength, equalTo(6));

        boxes.processLens(input[10]); //ot=7
        MatcherAssert.assertThat(boxes.boxes.get(0).id, equalTo(0));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.size(), equalTo(2));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(0).id, equalTo("rn"));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(0).focalLength, equalTo(1));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(1).id, equalTo("cm"));
        MatcherAssert.assertThat(boxes.boxes.get(0).lenses.get(1).focalLength, equalTo(2));

        MatcherAssert.assertThat(boxes.boxes.get(3).id, equalTo(3));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.size(), equalTo(3));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.get(0).id, equalTo("ot"));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.get(0).focalLength, equalTo(7));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.get(1).id, equalTo("ab"));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.get(1).focalLength, equalTo(5));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.get(2).id, equalTo("pc"));
        MatcherAssert.assertThat(boxes.boxes.get(3).lenses.get(2).focalLength, equalTo(6));

    }

    @Test
    void calculate_the_combined_focusing_power_of_all_lenses() {

        String inputString = "rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7";
        Boxes boxes = new Boxes();
        MatcherAssert.assertThat(boxes.calculateSumFocusingPower(inputString), equalTo(145));
    }

}
