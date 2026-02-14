package org.advent2025.day8;

import util.FileReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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


        long circuitId = 1;
        for (int i=0; i<maxNumberOfConnections; i++) {
            List<JunctionBox> closestBoxes = findClosestBox(junctionBoxes);
            
            if (closestBoxes == null) {
                break;
            }

            JunctionBox jb1 = closestBoxes.get(0);
            JunctionBox jb2 = closestBoxes.get(1);

            if (jb1.circuitId == 0 && jb2.circuitId == 0) {
                jb1.circuitId = circuitId;
                jb2.circuitId = circuitId;
                circuitId++;

            } else if (jb1.circuitId != 0 && jb2.circuitId == 0) {
                jb2.circuitId = jb1.circuitId;

            } else if (jb1.circuitId == 0 && jb2.circuitId != 0) {
                jb1.circuitId = jb2.circuitId;
            }
        }

        Map<Integer, Integer> circuitCounts = new HashMap<>();
        for (JunctionBox jb : junctionBoxes) {
            if (jb.circuitId != 0) {
                circuitCounts.put((int) jb.circuitId, circuitCounts.getOrDefault((int) jb.circuitId, 0) + 1);
            }
        }

        for (int cid : circuitCounts.keySet()) {
            System.out.println("Circuit " + cid + " has " + circuitCounts.get(cid) + " junction boxes.");
            for (JunctionBox jb : junctionBoxes) {
                if (jb.circuitId == cid) {
                    System.out.println("  Junction Box at (" + jb.x + "," + jb.y + "," + jb.z + ")");
                }
            }
        }

        List<Integer> largestCircuits = circuitCounts.values().stream()
                .sorted(java.util.Comparator.reverseOrder())
                .limit(3)
                .toList();

        return largestCircuits.stream().mapToLong(Integer::longValue).reduce(1L, (a, b) -> a * b);
    }


    public long solvePuzzle1(List<String> input, int maxNumberOfConnections) {

        List<JunctionBox> junctionBoxes = parseInput(input);
        List<Connection> connections = getClosesConnections(junctionBoxes, maxNumberOfConnections);

        long circuitId = 1;
        for (Connection connection : connections) {
            JunctionBox jb1 = connection.jb1;
            JunctionBox jb2 = connection.jb2;

            if (jb1.circuitId == 0 && jb2.circuitId == 0) {
                jb1.circuitId = circuitId;
                jb2.circuitId = circuitId;
                circuitId++;
            } else if (jb1.circuitId != 0 && jb2.circuitId == 0) {
                jb2.circuitId = jb1.circuitId;
            } else if (jb1.circuitId == 0 && jb2.circuitId != 0) {
                jb1.circuitId = jb2.circuitId;
            }
        }

        Map<Integer, Integer> circuitCounts = new HashMap<>();
        for (JunctionBox jb : junctionBoxes) {
            if (jb.circuitId != 0) {
                circuitCounts.put((int) jb.circuitId, circuitCounts.getOrDefault((int) jb.circuitId, 0) + 1);
            }
        }

        for (int cid : circuitCounts.keySet()) {
            System.out.println("Circuit " + cid + " has " + circuitCounts.get(cid) + " junction boxes.");
            for (JunctionBox jb : junctionBoxes) {
                if (jb.circuitId == cid) {
                    System.out.println("  Junction Box at (" + jb.x + "," + jb.y + "," + jb.z + ")");
                }
            }
        }

        List<Integer> largestCircuits = circuitCounts.values().stream()
                .sorted(java.util.Comparator.reverseOrder())
                .limit(3)
                .toList();

        return largestCircuits.stream().mapToLong(Integer::longValue).reduce(1L, (a, b) -> a * b);
    }

    List<JunctionBox> parseInput(List<String> input) {
        return input.stream().map(line -> {
            String[] parts = line.split(",");
            double x = Double.parseDouble(parts[0]);
            double y = Double.parseDouble(parts[1]);
            double z = Long.parseLong(parts[2]);
            return new JunctionBox(x, y, z);
        }).toList();
    }

    List<Connection> getClosesConnections(List<JunctionBox> junctionBoxes, int maxNumberOfConnections) {
        List<Connection> connections = new java.util.ArrayList<>();
        for (JunctionBox jb1 : junctionBoxes) {
            for (JunctionBox jb2 : junctionBoxes) {
                if (!jb1.equals(jb2)) {
                    double distance = calculateDistance(jb1, jb2);
                    Connection connection = new Connection(jb1, jb2, distance);
                    if (!connections.contains(connection))
                        connections.add(new Connection(jb1, jb2, distance));
                }
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
