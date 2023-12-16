package org.advent.day15;

import java.util.HashMap;
import java.util.Map;

public class Boxes {

    Map<Integer, Box> boxes = new HashMap<>();

    public void addBox(Box box) {
        boxes.put(box.id, box);
    }

    public int calculateSumFocusingPower(String input) {
        processAllLens(input);

        int sum = 0;
        for (Map.Entry<Integer, Box> entry : boxes.entrySet()) {
            int boxId = entry.getKey() + 1;
            for (int i = 0; i < entry.getValue().lenses.size(); i++) {
                Lens l = entry.getValue().lenses.get(i);
                sum += boxId * (i + 1) * l.focalLength;
            }
        }
        return sum;
    }

    public void processAllLens(String input) {
        String[] parts = input.split(",");
        for (String part : parts) {
            processLens(part);
        }
    }

    public void processLens(String lens) {
        int hashCode = HashMaker.calculateHash(parseId(lens));
        Box box = getBox(hashCode);
        addBox(box);

        if (lens.contains("=")) {
            Lens l = new Lens(lens);
            box.addLens(l);
        } else {
            String[] parts = lens.split("-");
            Lens l = new Lens(parts[0], -1);
            box.removeLens(l);
        }
    }

    private Box getBox(int n) {
        Box b = boxes.get(n);
        if (b == null) {
            b = new Box(n);
            addBox(b);
        }
        return b;
    }

    private String parseId(String lens) {
        String[] parts;
        if (lens.contains("=")) {
            parts = lens.split("=");
        } else {
            parts = lens.split("-");
        }
        return parts[0];
    }
}
