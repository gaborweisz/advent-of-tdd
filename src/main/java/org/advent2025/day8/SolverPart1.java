package org.advent2025.day8;

import util.FileReader;

import java.util.*;

public class SolverPart1 {

    static class JunctionBox {
        double x;
        double y;
        double z;
        long circuitId;

        JunctionBox(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            JunctionBox that = (JunctionBox) o;
            if (this.x == that.x && this.y == that.y && this.z == that.z) {
                return true;
            }

            return false;
        }
    }

    static class Connection implements Comparable<Connection> {
        JunctionBox jb1;
        JunctionBox jb2;
        double distance;

        Connection(JunctionBox jb1, JunctionBox jb2, double distance) {
            this.jb1 = jb1;
            this.jb2 = jb2;
            this.distance = distance;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Connection that = (Connection) o;
            if ((this.jb1.equals(that.jb1) && this.jb2.equals(that.jb2)) || (this.jb1.equals(that.jb2) && this.jb2.equals(that.jb1))) {
                return true;
            }

            return false;
        }


        @Override
        public int compareTo(Connection connection) {
            if (this.jb1 == connection.jb1 && this.jb2 == connection.jb2)
                return 0;
            if (this.jb1 == connection.jb2 && this.jb2 == connection.jb1)
                return 0;

            return Double.compare(this.distance, connection.distance);
        }

    }

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_2025_day8.txt");

        System.out.println("Solution for day 2025 / day 8 / a : " + new SolverPart1().solvePuzzle(rows, 1000));
    }

    public long solvePuzzle(List<String> input, int maxNumberOfConnections) {

        List<JunctionBox> junctionBoxes = parseInput(input);
        List<Connection> closesConnections = getClosesConnections(junctionBoxes, maxNumberOfConnections);
        for (Connection closesConnection: closesConnections) {
            System.out.println("Connection between (" + closesConnection.jb1.x + "," + closesConnection.jb1.y + "," + closesConnection.jb1.z + ") and (" + closesConnection.jb2.x + "," + closesConnection.jb2.y + "," + closesConnection.jb2.z + ") with distance " + closesConnection.distance);
        }
        Map<Integer, List<JunctionBox>> circuitMap = new HashMap<>();


        int circuitId = 1;
        for (int i=0; i<maxNumberOfConnections; i++) {
            Connection connection = closesConnections.get(i);

            JunctionBox jb1 = connection.jb1;
            JunctionBox jb2 = connection.jb2;

            System.out.println("Processing connection between (" + jb1.x + "," + jb1.y + "," + jb1.z + ") and (" + jb2.x + "," + jb2.y + "," + jb2.z + ") with distance " + connection.distance);
            if (jb1.circuitId != 0 && jb2.circuitId != 0) {
                System.out.println("Both junction boxes already belong to a circuit, skipping connection between (" + jb1.x + "," + jb1.y + "," + jb1.z + ") and (" + jb2.x + "," + jb2.y + "," + jb2.z + ")");
                continue;
            }

            if (jb1.circuitId == 0 && jb2.circuitId == 0) {
                jb1.circuitId = circuitId;
                jb2.circuitId = circuitId;
                List<JunctionBox> circuits = new ArrayList<>();
                circuits.add(jb1);
                circuits.add(jb2);
                circuitMap.put(circuitId, circuits);
                System.out.println("Assigning new circuit id " + circuitId + " to junction boxes at (" + jb1.x + "," + jb1.y + "," + jb1.z + ") and (" + jb2.x + "," + jb2.y + "," + jb2.z + ")");
                circuitId++;

            } else if (jb1.circuitId != 0) {
                jb2.circuitId = jb1.circuitId;
                List<JunctionBox> circuits = circuitMap.get((int) jb1.circuitId);
                circuits.add(jb2);
                System.out.println("Assigning existing circuit id " + jb1.circuitId + " to junction box at (" + jb2.x + "," + jb2.y + "," + jb2.z + ") because it is connected to junction box at (" + jb1.x + "," + jb1.y + "," + jb1.z + ")");

            } else if (jb2.circuitId != 0) {
                jb1.circuitId = jb2.circuitId;
                List<JunctionBox> circuits = circuitMap.get((int) jb2.circuitId);
                circuits.add(jb1);
                System.out.println("Assigning existing circuit id " + jb2.circuitId + " to junction box at (" + jb1.x + "," + jb1.y + "," + jb1.z + ") because it is connected to junction box at (" + jb2.x + "," + jb2.y + "," + jb2.z + ")");
            }
        }

        for (int cid : circuitMap.keySet()) {
            System.out.println("Circuit " + cid + " has " + circuitMap.get(cid).size() + " junction boxes.");
            for (JunctionBox jb : circuitMap.get(cid)) {
                if (jb.circuitId == cid) {
                    System.out.println("  Junction Box at (" + jb.x + "," + jb.y + "," + jb.z + ")");
                }
            }
        }


        return 0L;
    }


    List<JunctionBox> parseInput(List<String> input) {
        return input.stream().map(line -> {
            String[] parts = line.split(",");
            double x = Double.parseDouble(parts[0]);
            double y = Double.parseDouble(parts[1]);
            double z = Double.parseDouble(parts[2]);
            return new JunctionBox(x, y, z);
        }).toList();
    }

    List<Connection> getClosesConnections(List<JunctionBox> junctionBoxes, int maxNumberOfConnections) {
        List<Connection> connections = new java.util.ArrayList<>();
        for (int i = 0; i < junctionBoxes.size(); i++) {
            for (int j = i + 1; j < junctionBoxes.size(); j++) {
                JunctionBox jb1 = junctionBoxes.get(i);
                JunctionBox jb2 = junctionBoxes.get(j);

                double distance = calculateDistance(jb1, jb2);
                Connection connection = new Connection(jb1, jb2, distance);
                connections.add(connection);
            }
        }

        return connections.stream().sorted().limit(maxNumberOfConnections).toList();
    }

    List<JunctionBox> findClosestBox(List<JunctionBox> junctionBoxes) {
        List<JunctionBox> closestBoxes = null;
        double minDistance = Double.MAX_VALUE;
        for (JunctionBox jb : junctionBoxes) {
            for (JunctionBox jb2 : junctionBoxes) {
                if (!jb.equals(jb2) && !(jb.circuitId != 0 && jb2.circuitId != 0)) {
                    double distance = calculateDistance(jb, jb2);
                    if (distance < minDistance) {
                        minDistance = distance;
                        closestBoxes = List.of(jb, jb2);
                    }
                }
            }
        }
        return closestBoxes;
    }

    double calculateDistance(JunctionBox jb1, JunctionBox jb2) {
        return Math.sqrt(Math.pow(jb1.x - jb2.x, 2) + Math.pow(jb1.y - jb2.y, 2) + Math.pow(jb1.z - jb2.z, 2));
    }

}
