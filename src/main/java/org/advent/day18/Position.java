package org.advent.day18;

import java.util.Objects;

/**
 * Represents a position in the field
 */
public class Position implements Comparable<Position>{

    long i;
    long j;

    public Position(long i, long j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Long.compare(position.i, i) == 0;
    }

    @Override
    public int compareTo(Position o) {
        if (this.j == o.j) {
            return 0;
        }
        return this.j > o.j ? 1 : -1;
    }
}
