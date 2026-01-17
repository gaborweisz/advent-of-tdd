package org.advent2023.day8;

import util.MathUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DesertMap {

    String instructions;
    Map<String, Node> nodeMap;

    public DesertMap(List<String> input) {
        parseInput(input);
    }

    void parseInput(List<String> input) {
        instructions = input.get(0);
        nodeMap = new java.util.LinkedHashMap<>();
        for (int i = 2; i < input.size(); i++) {

            //"AAA = (BBB, CCC)"
            String[] parts = input.get(i).split(" = ");
            String[] children = parts[1].substring(1, parts[1].length() - 1).split(", ");
            nodeMap.put(parts[0], new Node(parts[0], children[0], children[1]));
        }
    }

    /**
     * Starting from AAA element, find the path to ZZZ in the map
     *
     * @return number of steps required
     */
    double findPath() {

        double steps = 0.0;
        Node current = nodeMap.get("AAA");
        while (!current.id.equals("ZZZ")) {
            for (char instruction : instructions.toCharArray()) {
                steps++;
                if (current.id.equals("ZZZ")) {
                    return steps;
                }
                if (instruction == 'R') {
                    current = nodeMap.get(current.right);
                } else {
                    current = nodeMap.get(current.left);
                }
            }
        }
        return steps;
    }

    /**
     * Starting from AAA element, find the path to ZZZ in the map
     *
     * @return number of steps required
     */
    double findPath(String key) {

        double steps = 0.0;
        Node current = nodeMap.get(key);
        while (true) {
            for (char instruction : instructions.toCharArray()) {
                if (current.id.charAt(2) == 'Z') {
                    return steps;
                }
                steps++;
                if (instruction == 'R') {
                    current = nodeMap.get(current.right);
                } else {
                    current = nodeMap.get(current.left);
                }
            }
        }
    }

    /**
     * Starting from all nodes starting with A, find the path to all nodes ending with Z in the map
     * too slow -> it will never finish
     * @return number of steps required
     */
    double findMultiPath() {

        double steps = 0.0;
        List<Node> currentNodes = getStartingNodes();
        while (true) {
            for (char instruction : instructions.toCharArray()) {
                if (steps % 10000000 == 0) {
                    System.out.printf("%.0f\n",steps);
                }

                if (allEndsWithZ(currentNodes)) {
                    return steps;
                }
                steps++;
                for (int i=0 ;i< currentNodes.size();i++) {
                    Node node = currentNodes.get(i);
                    if (instruction == 'R') {
                        currentNodes.set(i, nodeMap.get(node.right));
                    } else {
                        currentNodes.set(i, nodeMap.get(node.left));
                    }
                }
            }
        }
    }

    /**
     * Starting from all nodes starting with A, find the path to all nodes ending with Z in the map
     *
     * @return number of steps required
     */
    double findMultiPathQuick() {

        double steps = 1.0;
        List<Node> currentNodes = getStartingNodes();
        List<Double> stepsList = new ArrayList<>();
        for (Node currentNode : currentNodes) {
            double s = findPath(currentNode.id);
            stepsList.add(s);
        }
        return MathUtil.calculateLCM(stepsList);
    }

    boolean allEndsWithZ(List<Node> nodes) {
        for (Node node : nodes) {
            if (node.id.charAt(2) != 'Z') {
                return false;
            }
        }
        return true;

    }

    /**
     * Get all nodes where the id starts with A
     * @return starting nodes
     */
    List<Node> getStartingNodes() {
        List<Node> startNodes = new ArrayList<>();
        for (String id : nodeMap.keySet()) {
            if (id.charAt(2) == 'A') {
                startNodes.add(nodeMap.get(id));
            }
        }
        return startNodes;
    }

}
