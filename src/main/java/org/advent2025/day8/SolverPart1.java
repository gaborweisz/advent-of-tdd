package org.advent2025.day8;

import util.FileReader;

import java.util.*;

public class SolverPart1 {

    static class JunctionBox {
        double x;
        double y;
        double z;
        int circuitId;

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
        Map<Integer, List<JunctionBox>> circuitMap = new HashMap<>();


        int circuitId = 1;
        for (int i=0; i<maxNumberOfConnections; i++) {
            Connection connection = closesConnections.get(i);

            JunctionBox jb1 = connection.jb1;
            JunctionBox jb2 = connection.jb2;
            
            if (jb1.circuitId != 0 && jb2.circuitId != 0) {
                if (jb1.circuitId != jb2.circuitId) {
                    System.out.println("UNION : Both junction boxes already belong to a different circuit, needs union (" + jb1.circuitId + " + " + jb2.circuitId + " -> " + circuitId);
                    List<JunctionBox> junctionBoxListUnion = new LinkedList<>();
                    junctionBoxListUnion.addAll(circuitMap.get(jb1.circuitId));
                    junctionBoxListUnion.addAll(circuitMap.get(jb2.circuitId));
                    circuitMap.remove(jb1.circuitId);
                    circuitMap.remove(jb2.circuitId);
                    for (JunctionBox box : junctionBoxListUnion) {
                        box.circuitId = circuitId;
                    }
                    circuitMap.put(circuitId, junctionBoxListUnion);
                    circuitId++;
                }
            } else if (jb1.circuitId == 0 && jb2.circuitId == 0) {
                jb1.circuitId = circuitId;
                jb2.circuitId = circuitId;
                List<JunctionBox> circuits = new ArrayList<>();
                circuits.add(jb1);
                circuits.add(jb2);
                circuitMap.put(circuitId, circuits);
                circuitId++;

            } else if (jb1.circuitId != 0) {
                jb2.circuitId = jb1.circuitId;
                List<JunctionBox> circuits = circuitMap.get(jb1.circuitId);
                circuits.add(jb2);

            } else {
                jb1.circuitId = jb2.circuitId;
                List<JunctionBox> circuits = circuitMap.get(jb2.circuitId);
                if (circuits == null) {
                    System.out.println("Ops");
                }
                circuits.add(jb1);
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

        circuitMap.values().stream().map(List::size).sorted(Comparator.reverseOrder()).limit(3).forEach(key -> System.out.println("Top key: " + key));

        return circuitMap.values().stream().map(List::size).sorted(Comparator.reverseOrder()).limit(3).mapToLong(Integer::longValue).reduce(1L, (a, b) -> a * b);
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
