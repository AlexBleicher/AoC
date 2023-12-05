package AoC2023.Day5;

import java.util.*;

public class Day5 {
    private List<Long> seeds;
    private Map<Long, Long> seedToSoilMap = new HashMap<>();
    private Map<Long, Long> soilToFertilizerMap = new HashMap<>();
    private Map<Long, Long> fertilizerToWaterMap = new HashMap<>();
    private Map<Long, Long> waterToLightMap = new HashMap<>();
    private Map<Long, Long> lightToTemperatureMap = new HashMap<>();
    private Map<Long, Long> temperatureToHumidityMap = new HashMap<>();
    private Map<Long, Long> humidityToLocationMap = new HashMap<>();
    private List<Map<Long, Long>> mapList = new ArrayList<>();

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
            Map<Long, Long> map = mapList.get(i - 1);
            for (int i1 = 0; i1 < mapInts.size(); i1++) {
                List<Long> values = mapInts.get(i1);
                long destRangeStart = values.get(0);
                long sourceRangeStart = values.get(1);
                long rangeLength = values.get(2);
                int count = 0;
                for (long sRange = sourceRangeStart; sRange < sourceRangeStart + rangeLength; sRange++) {
                    map.put(sRange, destRangeStart + count++);
                }
            }
        }
    }

    public long task1() {
        List<Long> locations = new ArrayList<>();
        for (long seed : seeds) {
            long currentNumber = seed;
            for (Map<Long, Long> integerIntegerMap : mapList) {
                if (integerIntegerMap.containsKey(currentNumber)) {
                    currentNumber = integerIntegerMap.get(currentNumber);
                }
            }
            locations.add(currentNumber);
        }
        return locations.stream().min(Comparator.comparingInt(Long::intValue)).get();
    }
}
