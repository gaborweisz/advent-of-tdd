package org.advent.day11;


import java.util.ArrayList;
import java.util.List;

public class Galaxy {
    int posX;
    int posY;

    /**
     * Galaxies that are paired with this galaxy
     */
    List<Galaxy> pairedGalaxies = new ArrayList<>();

    public Galaxy(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    int distanceTo(Galaxy g, Observatory o, int expandRatio){
        pairedGalaxies.add(g);
        int expandX = emptyRowsBetweenPosX(this.posX, g.posX, o) * expandRatio;
        int expandY = emptyRowsBetweenPosY(this.posY, g.posY, o) * expandRatio;
        return Math.abs(this.posX - g.posX)  + expandX + Math.abs(this.posY - g.posY)  + expandY;
    }

    int emptyRowsBetweenPosX(int posX1, int posX2, Observatory o) {
        int count = 0;
        for (int i : o.emptyRowIndexes ) {
            if (i > posX1 && i < posX2 || i > posX2 && i < posX1) {
                count++;
            }
        }
        return count;
    }

    int emptyRowsBetweenPosY(int posY1, int posY2, Observatory o) {
        int count = 0;
        for (int i : o.emptyColIndexes ) {
            if (i > posY1 && i < posY2 || i > posY2 && i < posY1) {
                count++;
            }
        }
        return count;
    }

    boolean isPaired(Galaxy g) {
        return pairedGalaxies.contains(g);
    }

}
