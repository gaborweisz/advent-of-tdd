package org.advent2023.day3;

import java.util.Objects;

public class Part {
    int number;
    int startPos;
    int endPos;
    int lineNumber;
    boolean valid;

    public Part(int number, int startPos, int endPos, int lineNumber, boolean valid) {
        this.number = number;
        this.startPos = startPos;
        this.endPos = endPos;
        this.lineNumber = lineNumber;
        this.valid = valid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Part part)) return false;
        return startPos == part.startPos && endPos == part.endPos && lineNumber == part.lineNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startPos, endPos, lineNumber);
    }
}
