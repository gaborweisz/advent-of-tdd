package org.advent.day5;


import java.util.*;

public class Almanac {

    List<Double> seeds;
    List<SeedRange> seedRanges;
    Map<String, GardenMap> maps;

    public Almanac(List<String> rows) {
        parseRows(rows);
    }

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

    public Double getLowestLocationNumber() {
        return seeds.stream().mapToDouble(this::getCorrespondingLocation).min().getAsDouble();
    }

    public Double getLowestLocationNumberFromSeedRanges  () {
        return seedRanges.stream().mapToDouble(seedRange -> getLowestLocationNumberFromSeedRange(seedRange.from, seedRange.rangeLength)).min().getAsDouble();
    }

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

    public Double getCorrespondingLocation(Double seedNumber) {

        Double lastSeed = seedNumber;
        for (GardenMap map : maps.values()) {
            lastSeed = map.getCorrespondingNumber(lastSeed);
        }

        return lastSeed;
    }

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

    public static List<SeedRange> parseSeedRanges(String row) {
        List<Double> seeds = parseSeeds(row);
        List<SeedRange> ranges = new ArrayList<>();

        for (int i = 0; i < Objects.requireNonNull(seeds).size()-1; i+=2) {
           ranges.add(new SeedRange(seeds.get(i), seeds.get(i+1)));
        }

        return ranges;
    }

}
