package AoC2024.Day13;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private String input;

    public Input(String i) {
        input = i;
    }

    public List<DiophantEquation> parseInput() {
        String[] split = input.split("\n\n");
        List<DiophantEquation> res = new ArrayList<>();
        for (String s : split) {
            List<Long> xs = new ArrayList<>();
            List<Long> ys = new ArrayList<>();
            String[] split1 = s.split("\n");
            for (String string : split1) {
                String[] split2 = string.split(":");
                String[] split3 = split2[1].split(",");
                String s1 = split3[0];
                String s2 = split3[1];
                String[] s3 = s1.split("\\+|=");
                xs.add(Long.parseLong(s3[1]));
                ys.add(Long.parseLong(s2.split("\\+|=")[1]));
            }
            DiophantEquation equation = new DiophantEquation();
            equation.setX1(xs.get(0));
            equation.setX2(xs.get(1));
            equation.setXres(xs.get(2));
            equation.setY1(ys.get(0));
            equation.setY2(ys.get(1));
            equation.setYres(ys.get(2));
            res.add(equation);
        }
        return res;
    }
}
