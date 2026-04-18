package org.advent2025.day8;

import util.FileReader;

import java.util.*;

public class SolverPart2 extends AbstractSolver {


    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_2025_day8.txt");

        double solution = new SolverPart2().solvePuzzle(rows);
        System.out.printf(Locale.US,
                """
                ==============================
                Advent of TDD - 2025 Day 8 B
                ==============================
                Input rows         : %d
                Computed solution  : %.0f
                ==============================
                """,
                rows.size(),
                solution
        );
    }

    public double solvePuzzle(List<String> input) {

        List<JunctionBox> junctionBoxes = parseInput(input);
        List<Connection> closesConnections = getClosesConnections(junctionBoxes);
        Map<Integer, List<JunctionBox>> circuitMap = new HashMap<>();
        double latsProduct = 0;


        int circuitId = 1;
        for (int i=0; i<closesConnections.size(); i++) {
            Connection connection = closesConnections.get(i);

            JunctionBox jb1 = connection.jb1;
            JunctionBox jb2 = connection.jb2;

            if (jb1.circuitId != 0 && jb2.circuitId != 0) {
                if (jb1.circuitId != jb2.circuitId) {
                    System.out.println("UNION : Both junction boxes (" +  jb1.x + "," + jb1.y + "," + jb1.z  + " )  - (" + jb2.x + "," + jb2.y + "," + jb2.z  +  ") needs union (" + jb1.circuitId + " + " + jb2.circuitId + " -> " + circuitId);
                    List<JunctionBox> junctionBoxListUnion = new LinkedList<>();
                    junctionBoxListUnion.addAll(circuitMap.get(jb1.circuitId));
                    junctionBoxListUnion.addAll(circuitMap.get(jb2.circuitId));
                    circuitMap.remove(jb1.circuitId);
                    circuitMap.remove(jb2.circuitId);
                    for (JunctionBox box : junctionBoxListUnion) {
                        box.circuitId = circuitId;
                        System.out.println("      - Junction Box at (" + box.x + "," + box.y + "," + box.z + ") now belongs to circuit " + circuitId);
                    }
                    circuitMap.put(circuitId, junctionBoxListUnion);
                    circuitId++;
                }
            } else if (jb1.circuitId == 0 && jb2.circuitId == 0) {
                jb1.circuitId = circuitId;
                jb2.circuitId = circuitId;
                System.out.println("NEW CIRCUIT : Both junction boxes (" +  jb1.x + "," + jb1.y + "," + jb1.z  + " )  - (" + jb2.x + "," + jb2.y + "," + jb2.z  +  ") are not connected to any circuit, create new circuit with id " + circuitId);
                List<JunctionBox> circuits = new ArrayList<>();
                circuits.add(jb1);
                circuits.add(jb2);
                circuitMap.put(circuitId, circuits);
                circuitId++;

            } else if (jb1.circuitId != 0) {
                jb2.circuitId = jb1.circuitId;
                List<JunctionBox> circuits = circuitMap.get(jb1.circuitId);
                circuits.add(jb2);
                latsProduct = jb1.x * jb2.x;

            } else {
                jb1.circuitId = jb2.circuitId;
                List<JunctionBox> circuits = circuitMap.get(jb2.circuitId);
                if (circuits == null) {
                    System.out.println("Ops");
                }
                latsProduct = jb1.x * jb2.x;
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

        return  latsProduct;
    }



}
