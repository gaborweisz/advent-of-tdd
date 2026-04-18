package org.advent2025.day8;

public class JunctionBox {
    public double x;
    public double y;
    public double z;
    public int circuitId;

    public JunctionBox(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JunctionBox that = (JunctionBox) o;
        return this.x == that.x && this.y == that.y && this.z == that.z;
    }
}

