package org.advent2025.day8;

import java.util.*;

public abstract class AbstractSolver {

    List<JunctionBox> parseInput(List<String> input) {
        return input.stream().map(line -> {
            String[] parts = line.split(",");
            double x = Double.parseDouble(parts[0]);
            double y = Double.parseDouble(parts[1]);
            double z = Double.parseDouble(parts[2]);
            return new JunctionBox(x, y, z);
        }).toList();
    }

    List<Connection> getClosesConnections(List<JunctionBox> junctionBoxes) {
        List<Connection> connections = new ArrayList<>();
        for (int i = 0; i < junctionBoxes.size(); i++) {
            for (int j = i + 1; j < junctionBoxes.size(); j++) {
                JunctionBox jb1 = junctionBoxes.get(i);
                JunctionBox jb2 = junctionBoxes.get(j);
                connections.add(new Connection(jb1, jb2, calculateDistance(jb1, jb2)));
            }
        }
        return connections.stream().sorted().toList();
    }

    List<Connection> getClosesConnections(List<JunctionBox> junctionBoxes, int maxNumberOfConnections) {
        return getClosesConnections(junctionBoxes).stream()
                .limit(maxNumberOfConnections)
                .toList();
    }

    double calculateDistance(JunctionBox jb1, JunctionBox jb2) {
        return Math.sqrt(
                Math.pow(jb1.x - jb2.x, 2) +
                Math.pow(jb1.y - jb2.y, 2) +
                Math.pow(jb1.z - jb2.z, 2)
        );
    }

    void processConnection(Connection connection, Map<Integer, List<JunctionBox>> circuitMap, int[] circuitId) {
        JunctionBox jb1 = connection.jb1;
        JunctionBox jb2 = connection.jb2;

        if (bothAssigned(jb1, jb2)) {
            if (jb1.circuitId != jb2.circuitId) {
                mergeCircuits(jb1, jb2, circuitMap, circuitId);
            }
        } else if (noneAssigned(jb1, jb2)) {
            createNewCircuit(jb1, jb2, circuitMap, circuitId);
        } else if (jb1.circuitId != 0) {
            addToCircuit(jb2, jb1.circuitId, circuitMap);
        } else {
            addToCircuit(jb1, jb2.circuitId, circuitMap);
        }
    }

    boolean bothAssigned(JunctionBox jb1, JunctionBox jb2) {
        return jb1.circuitId != 0 && jb2.circuitId != 0;
    }

    boolean noneAssigned(JunctionBox jb1, JunctionBox jb2) {
        return jb1.circuitId == 0 && jb2.circuitId == 0;
    }

    void mergeCircuits(JunctionBox jb1, JunctionBox jb2, Map<Integer, List<JunctionBox>> circuitMap, int[] circuitId) {
        System.out.println("UNION : circuits " + jb1.circuitId + " + " + jb2.circuitId + " -> " + circuitId[0]);
        List<JunctionBox> merged = new LinkedList<>();
        merged.addAll(circuitMap.remove(jb1.circuitId));
        merged.addAll(circuitMap.remove(jb2.circuitId));
        merged.forEach(box -> {
            box.circuitId = circuitId[0];
            System.out.println("      - Junction Box at (" + box.x + "," + box.y + "," + box.z + ") now belongs to circuit " + circuitId[0]);
        });
        circuitMap.put(circuitId[0]++, merged);
    }

    void createNewCircuit(JunctionBox jb1, JunctionBox jb2, Map<Integer, List<JunctionBox>> circuitMap, int[] circuitId) {
        jb1.circuitId = jb2.circuitId = circuitId[0];
        System.out.println("NEW CIRCUIT id=" + circuitId[0] + " : (" + jb1.x + "," + jb1.y + "," + jb1.z + ") - (" + jb2.x + "," + jb2.y + "," + jb2.z + ")");
        circuitMap.put(circuitId[0]++, new ArrayList<>(List.of(jb1, jb2)));
    }

    void addToCircuit(JunctionBox jb, int targetCircuitId, Map<Integer, List<JunctionBox>> circuitMap) {
        jb.circuitId = targetCircuitId;
        circuitMap.get(targetCircuitId).add(jb);
    }

    void printCircuits(Map<Integer, List<JunctionBox>> circuitMap) {
        circuitMap.forEach((cid, boxes) -> {
            System.out.println("Circuit " + cid + " has " + boxes.size() + " junction boxes.");
            boxes.stream()
                 .filter(jb -> jb.circuitId == cid)
                 .forEach(jb -> System.out.println("  Junction Box at (" + jb.x + "," + jb.y + "," + jb.z + ")"));
        });
    }
}
