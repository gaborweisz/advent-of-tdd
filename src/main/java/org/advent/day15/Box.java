package org.advent.day15;

import java.util.ArrayList;
import java.util.List;

public class Box {

    Integer id;
    List<Lens> lenses;

    public Box(Integer id) {
        this.id = id;
        this.lenses = new ArrayList<>();
    }

    void addLens(Lens lens) {
        if (lenses.contains(lens)) {
            Lens l = lenses.get(lenses.indexOf(lens));
            l.focalLength = lens.focalLength;
        } else {
            lenses.add(lens);
        }
    }

    void removeLens(Lens lens) {
        lenses.remove(lens);
    }
}
