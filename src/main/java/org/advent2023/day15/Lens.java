package org.advent2023.day15;

import java.util.Objects;

public class Lens {

    String id;
    int focalLength;

    public Lens(String lens) {
        String[] parts = lens.split("=");
        this.id = parts[0];
        this.focalLength = Integer.parseInt(parts[1]);
    }

    public Lens(String id, Integer focalLength) {
        this.id = id;
        this.focalLength = focalLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lens lens = (Lens) o;
        return Objects.equals(id, lens.id);
    }
}
