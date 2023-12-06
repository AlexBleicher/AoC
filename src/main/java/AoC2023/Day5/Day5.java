package AoC2023.Day5;

import java.util.*;

public class Day5 {
    private List<Long> seeds;
    private Map<String, Long> seedToSoilMap = new HashMap<>();
    private Map<String, Long> soilToFertilizerMap = new HashMap<>();
    private Map<String, Long> fertilizerToWaterMap = new HashMap<>();
    private Map<String, Long> waterToLightMap = new HashMap<>();
    private Map<String, Long> lightToTemperatureMap = new HashMap<>();
    private Map<String, Long> temperatureToHumidityMap = new HashMap<>();
    private Map<String, Long> humidityToLocationMap = new HashMap<>();
    private List<Map<String, Long>> mapList = new ArrayList<>();

    public Day5(String in) {
        mapList.add(seedToSoilMap);
        mapList.add(soilToFertilizerMap);
        mapList.add(fertilizerToWaterMap);
        mapList.add(waterToLightMap);
        mapList.add(lightToTemperatureMap);
        mapList.add(temperatureToHumidityMap);
        mapList.add(humidityToLocationMap);
        List<List<List<Long>>> parsedInput = new Input(in).parseInput();
        seeds = parsedInput.get(0).get(0);

        for (int i = 1; i < parsedInput.size(); i++) {
            List<List<Long>> mapInts = parsedInput.get(i);
            Map<String, Long> map = mapList.get(i - 1);
            for (int i1 = 0; i1 < mapInts.size(); i1++) {
                List<Long> values = mapInts.get(i1);
                long destRangeStart = values.get(0);
                long sourceRangeStart = values.get(1);
                long rangeLength = values.get(2);
                long sourceRangeEnd = sourceRangeStart + rangeLength - 1;
                map.put(sourceRangeStart + "-" + sourceRangeEnd, destRangeStart);
            }
        }
    }

    public long task1() {
        long currentlowest = Long.MAX_VALUE;
        for (long seed : seeds) {
            long currentNumber = seed;
            for (Map<String, Long> map : mapList) {
                Set<String> strings = map.keySet();
                boolean set = false;
                for (String string : strings) {
                    String[] split = string.split("-");
                    long start = Long.parseLong(split[0]);
                    long end = Long.parseLong(split[1]);
                    if (end - currentNumber >= 0 && currentNumber - start >= 0 && !set) {
                        long startDest = map.get(string);
                        currentNumber = startDest + (currentNumber - start);
                        set = true;
                    }
                }
            }
            if (currentNumber < currentlowest) {
                currentlowest = currentNumber;
            }
        }
        return currentlowest;
    }

    public long task2() {
        List<Long> seedsTask2 = new ArrayList<>();
        List<Long> ranges = new ArrayList<>();
        long currentLowest = Long.MAX_VALUE;
        for (int i = 0; i < seeds.size(); i += 2) {
            seedsTask2.add(seeds.get(i));
        }
        for (int i = 1; i < seeds.size(); i += 2) {
            ranges.add(seeds.get(i));
        }
        for (int i = 0; i < seedsTask2.size(); i++) {
            long seed = seedsTask2.get(i);
            long range = ranges.get(i);
            long stop = Long.MAX_VALUE;
            for (long j = seed; j < seed + range; j += stop) {
                stop = Long.MAX_VALUE;
                long currentNumber = j;
                for (Map<String, Long> map : mapList) {
                    Set<String> strings = map.keySet();
                    boolean set = false;
                    for (String string : strings) {
                        String[] split = string.split("-");
                        long start = Long.parseLong(split[0]);
                        long end = Long.parseLong(split[1]);
                        if (end - currentNumber >= 0 && currentNumber - start >= 0 && !set) {
                            long stopThisMap = (end - start + 1) - (currentNumber - start);
                            if (stop > stopThisMap) {
                                stop = stopThisMap;
                            }
                            long startDest = map.get(string);
                            currentNumber = startDest + (currentNumber - start);
                            set = true;
                        }
                    }
                }
                if (currentNumber < currentLowest) {
                    currentLowest = currentNumber;
                }
            }
        }
        return currentLowest;
    }

}
