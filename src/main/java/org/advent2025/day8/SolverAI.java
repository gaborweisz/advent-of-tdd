package org.advent2025.day8;

import java.io.*;
import java.util.*;

public class SolverAI {
    record Point(int x, int y, int z) {}
    record Edge(double distSq, int u, int v) {}

    public static void main(String[] args) throws IOException {

        var f = new util.FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_2025_day8.txt");

        System.out.println("Solution for day 2025 / day 8 / a : " + new SolverAI().solvePuzzle(rows, 1000));

    }
    
    long solvePuzzle(List<String> rows , int maxNumberOfConnections)  {

        List<Point> points = new ArrayList<>();
        
        for (String line : rows) {
            String[] parts = line.split(",");
            points.add(new Point(
                    Integer.parseInt(parts[0].trim()),
                    Integer.parseInt(parts[1].trim()),
                    Integer.parseInt(parts[2].trim())
            ));
        }

        // Összes lehetséges él kiszámítása
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                double d2 = Math.pow(points.get(i).x - points.get(j).x, 2) +
                        Math.pow(points.get(i).y - points.get(j).y, 2) +
                        Math.pow(points.get(i).z - points.get(j).z, 2);
                edges.add(new Edge(d2, i, j));
            }
        }

        // Élek rendezése távolság alapján
        edges.sort(Comparator.comparingDouble(Edge::distSq));

        // Union-Find inicializálása
        int n = points.size();
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        // Az első 1000 legközelebbi él összekötése
        for (int i = 0; i < Math.min(maxNumberOfConnections, edges.size()); i++) {
            union(edges.get(i).u, edges.get(i).v, parent, size);
        }

        // Komponens méretek kigyűjtése
        List<Integer> finalSizes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                finalSizes.add(size[i]);
            }
        }
        finalSizes.sort(Collections.reverseOrder());

        // Eredmény: a 3 legnagyobb szorzata
        long result = (long) finalSizes.get(0) * finalSizes.get(1) * finalSizes.get(2);
        return result;
    }

    private static int find(int i, int[] parent) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i], parent);
    }

    private static void union(int i, int j, int[] parent, int[] size) {
        int rootI = find(i, parent);
        int rootJ = find(j, parent);
        if (rootI != rootJ) {
            if (size[rootI] < size[rootJ]) {
                int temp = rootI; rootI = rootJ; rootJ = temp;
            }
            parent[rootJ] = rootI;
            size[rootI] += size[rootJ];
        }
    }
}
