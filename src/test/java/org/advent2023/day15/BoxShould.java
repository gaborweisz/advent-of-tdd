package org.advent2023.day15;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

public class BoxShould {

    @Test
    void add_lens_with_different_ids() {

        //rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7";
        Lens lens1 = new Lens("rn=1");
        Lens lens2 = new Lens("cm=2");
        Box box = new Box(1);
        box.addLens(lens1);
        box.addLens(lens2);

        MatcherAssert.assertThat(box.lenses.size(), org.hamcrest.Matchers.equalTo(2));
        MatcherAssert.assertThat(box.lenses.get(0).id, org.hamcrest.Matchers.equalTo("rn"));
        MatcherAssert.assertThat(box.lenses.get(1).id, org.hamcrest.Matchers.equalTo("cm"));
    }

    @Test
    void remove_lens() {

        //rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7";
        Lens lens1 = new Lens("rn=1");
        Lens lens2 = new Lens("qp=3");
        Lens lens3 = new Lens("cm=2");
        Box box = new Box(1);
        box.addLens(lens1);
        box.addLens(lens2);
        box.addLens(lens3);
        box.removeLens(lens2);

        MatcherAssert.assertThat(box.lenses.size(), org.hamcrest.Matchers.equalTo(2));
        MatcherAssert.assertThat(box.lenses.get(0).id, org.hamcrest.Matchers.equalTo("rn"));
        MatcherAssert.assertThat(box.lenses.get(1).id, org.hamcrest.Matchers.equalTo("cm"));
    }

    @Test
    void add_lens_with_same_ids_replaces_the_focal_length() {

        //rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7";
        Lens lens1 = new Lens("pc=4");
        Lens lens2 = new Lens("pc=6");
        Box box = new Box(1);

        box.addLens(lens1);
        MatcherAssert.assertThat(box.lenses.size(), org.hamcrest.Matchers.equalTo(1));
        MatcherAssert.assertThat(box.lenses.get(0).id, org.hamcrest.Matchers.equalTo("pc"));
        MatcherAssert.assertThat(box.lenses.get(0).focalLength, org.hamcrest.Matchers.equalTo(4));

        box.addLens(lens2);
        MatcherAssert.assertThat(box.lenses.size(), org.hamcrest.Matchers.equalTo(1));
        MatcherAssert.assertThat(box.lenses.get(0).id, org.hamcrest.Matchers.equalTo("pc"));
        MatcherAssert.assertThat(box.lenses.get(0).focalLength, org.hamcrest.Matchers.equalTo(6));
    }
}
