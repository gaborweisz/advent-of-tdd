package org.advent2023.day5;


import java.util.*;

/**
 * The almanac (your puzzle input) lists all of the seeds that need to be planted.
 * It also lists what type of soil to use with each kind of seed, what type of fertilizer
 * to use with each kind of soil, what type of water to use with each kind of fertilizer,
 * and so on.
 *
 * For example:
 *
 * seeds: 79 14 55 13
 *
 * seed-to-soil map:
 * 50 98 2
 * 52 50 48
 *
 * soil-to-fertilizer map:
 * 0 15 37
 * 37 52 2
 * 39 0 15
 */
public class Almanac {

    List<Double> seeds;
    List<SeedRange> seedRanges;
    Map<String, GardenMap> maps;

    public Almanac(List<String> rows) {
        parseRows(rows);
    }

    /**
     * Process the puzzle input and create necessary objects
     * @param rows
     */
    private void parseRows(List<String> rows) {
        maps = new LinkedHashMap<>();
        GardenMap currentMap = null;

        for (String row : rows) {
            if (row.startsWith("seeds:")) {
                seeds = parseSeeds(row);
                seedRanges= parseSeedRanges(row);
            } else if (row.contains("map:")) {
                GardenMap map = new GardenMap(row);
                maps.put(map.name,map);
                currentMap = map;
            } else if (row.isEmpty()) {
                // ignore
            } else {
                currentMap.addRange(row);
            }
        }
    }

    /**
     * Answer to part 1
     * @return
     */
    public Double getLowestLocationNumber() {
        return seeds.stream().mapToDouble(this::getCorrespondingLocation).min().getAsDouble();
    }

    /**
     * Answer to part 2
     * @return
     */
    public Double getLowestLocationNumberFromSeedRanges  () {
        return seedRanges.stream().mapToDouble(seedRange -> getLowestLocationNumberFromSeedRange(seedRange.from, seedRange.rangeLength)).min().getAsDouble();
    }


    /**
     * Pocesses a range to find the lowest location number
     * @param from
     * @param range
     * @return lowest location number
     */
    public Double getLowestLocationNumberFromSeedRange(Double from, Double range) {
        Double min = Double.MAX_VALUE;
        for (Double i = from; i <= from + range-1; i++) {
            Double location = getCorrespondingLocation(i);
            if (i%1000000 == 0) {
                System.out.println("i: " + i + " location: " + location);
            }
            if (location < min) {
                min = location;
            }

        }
        return min;
    }

    /**
     * Get the corresponding location number for a seed number
     * @param seedNumber
     * @return lowest location number
     */
    public Double getCorrespondingLocation(Double seedNumber) {

        Double lastSeed = seedNumber;
        for (GardenMap map : maps.values()) {
            lastSeed = map.getCorrespondingNumber(lastSeed);
        }

        return lastSeed;
    }

    /**
     * Parse the seeds from the first row according to part 1
     * @param row
     * @return list of seeds
     */
    public static List<Double> parseSeeds(String row) {
        if (!row.startsWith("seeds:")) {
            return null;
        }
        String[] parts = row.split(":");
        List<Double> s = new ArrayList<>();
        String[] seedStrings = parts[1].split(" ");
        for (int i = 1; i < seedStrings.length; i++) {
            s.add(Double.parseDouble(seedStrings[i]));
        }

        return s;
    }

    /**
     * Parse the seeds from the first row according to part 2
     * @param row
     * @return list of seed ranges
     */
    public static List<SeedRange> parseSeedRanges(String row) {
        List<Double> seeds = parseSeeds(row);
        List<SeedRange> ranges = new ArrayList<>();

        for (int i = 0; i < Objects.requireNonNull(seeds).size()-1; i+=2) {
           ranges.add(new SeedRange(seeds.get(i), seeds.get(i+1)));
        }

        return ranges;
    }

}
