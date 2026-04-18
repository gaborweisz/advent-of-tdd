package org.advent2025.day8;

public class Connection implements Comparable<Connection> {
    public JunctionBox jb1;
    public JunctionBox jb2;
    public double distance;

    public Connection(JunctionBox jb1, JunctionBox jb2, double distance) {
        this.jb1 = jb1;
        this.jb2 = jb2;
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connection that = (Connection) o;
        return (this.jb1.equals(that.jb1) && this.jb2.equals(that.jb2))
                || (this.jb1.equals(that.jb2) && this.jb2.equals(that.jb1));
    }

    @Override
    public int compareTo(Connection connection) {
        if (this.jb1 == connection.jb1 && this.jb2 == connection.jb2) return 0;
        if (this.jb1 == connection.jb2 && this.jb2 == connection.jb1) return 0;
        return Double.compare(this.distance, connection.distance);
    }
}

