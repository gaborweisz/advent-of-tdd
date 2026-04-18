package org.advent2025.day8;

import util.FileReader;

import java.util.*;

public class SolverPart1 extends AbstractSolver {


    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_2025_day8.txt");

        System.out.println("Solution for day 2025 / day 8 / a : " + new SolverPart1().solvePuzzle(rows, 1000));
    }

    public long solvePuzzle(List<String> input, int maxNumberOfConnections) {
        List<JunctionBox> junctionBoxes = parseInput(input);
        List<Connection> closesConnections = getClosesConnections(junctionBoxes, maxNumberOfConnections);
        Map<Integer, List<JunctionBox>> circuitMap = new HashMap<>();

        int[] circuitId = {1};
        closesConnections.forEach(c -> processConnection(c, circuitMap, circuitId));

        printCircuits(circuitMap);

        return top3Product(circuitMap);
    }


    private long top3Product(Map<Integer, List<JunctionBox>> circuitMap) {
        List<Integer> top3 = circuitMap.values().stream()
                .map(List::size)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .toList();
        top3.forEach(size -> System.out.println("Top circuit size: " + size));
        return top3.stream().mapToLong(Integer::longValue).reduce(1L, (a, b) -> a * b);
    }



}
