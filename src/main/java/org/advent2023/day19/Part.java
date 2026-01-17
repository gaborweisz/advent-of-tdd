package org.advent2023.day19;


import java.util.Map;


/**
 * Represents a part of the workflow
 */
public class Part {
    enum State {
        ACCEPTED, REJECTED, NONE
    }

    Map<String, Integer> partMap;
    State state = State.NONE;


    public Part() {
    }

    int get(String key) {
        return partMap.get(key);
    }

    int sum() {
        return partMap.get("x") + partMap.get("m") + partMap.get("a") + partMap.get("s");
    }

    /**
     * Create a Part instance from string
     * e.g. "{x=787,m=2655,a=1222,s=2876}"
     *
     * @param part as string
     * @return part instance
     */
    static Part parse(String part) {
        Part p = new Part();

        part = part.replace("{", "");
        part = part.replace("}", "");

        String[] parts = part.split(",");

        p.partMap = Map.of(
                "x", Integer.parseInt(parts[0].split("=")[1]),
                "m", Integer.parseInt(parts[1].split("=")[1]),
                "a", Integer.parseInt(parts[2].split("=")[1]),
                "s", Integer.parseInt(parts[3].split("=")[1]));


        return p;
    }

}
