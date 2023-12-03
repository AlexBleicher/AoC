package AoC2023.Day2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private List<Information> information = new ArrayList<>();

    public Game(List<String> input) {
        for (String s : input) {
            String[] split = s.split(", ");
            Information i = new Information();
            for (String string : split) {
                if (string.contains("blue")) {
                    String[] split1 = string.split(" ");
                    i.setBlue(Integer.parseInt(split1[0]));
                } else if (string.contains("green")) {
                    String[] split1 = string.split(" ");
                    i.setGreen(Integer.parseInt(split1[0]));
                } else if (string.contains("red")) {
                    String[] split1 = string.split(" ");
                    i.setRed(Integer.parseInt(split1[0]));
                }
            }
            information.add(i);
        }
    }

    public boolean isPossible(int lr, int lg, int lb) {
        List<Information> collect = information.stream()
                .filter((information1 -> {
                    return information1.getRed() <= lr && information1.getGreen() <= lg && information1.getBlue() <= lb;
                }))
                .collect(Collectors.toList());
        return collect.size() == information.size();
    }

    public int getPower() {
        int blue = information.stream().max(Comparator.comparingInt(Information::getBlue)).get().getBlue();
        int red = information.stream().max(Comparator.comparingInt(Information::getRed)).get().getRed();
        int green = information.stream().max(Comparator.comparingInt(Information::getGreen)).get().getGreen();
        return red * blue * green;
    }
}
