package org.advent.day6;

public class Boat {

    double raceTime;
    double recordDistance;

    public Boat(double time, double record) {
        this.raceTime = time;
        this.recordDistance = record;
    }

    /**
     * Calculates how far the boat will travel based on the chargeTime given and the raceTime constraint
     *
     * @param chargeTime time in milliseconds
     * @return distance in millimeters
     */
    public double travelDistance(double chargeTime) {

        if (chargeTime > this.raceTime || chargeTime < 0) {
            return 0;
        }

        return (this.raceTime - chargeTime) * chargeTime;
    }

    /**
     * Calculates how many ways the current record can be beaten
     *
     * @return the number
     */
    public Double numberOfWaysToBeatTheRecord() {

        double beaten = 0;
        for (double time = 0; time <= this.raceTime; time++) {
            if (travelDistance(time) > this.recordDistance) {
                beaten++;
            }
        }
        return beaten;
    }


}
