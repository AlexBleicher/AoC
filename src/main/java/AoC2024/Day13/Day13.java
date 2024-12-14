package AoC2024.Day13;

import java.util.List;

public class Day13 {

    private List<DiophantEquation> equations;

    public Day13(String i) {
        equations = new Input(i).parseInput();
    }

    public long task1() {
        long tokens = 0;
        for (DiophantEquation equation : equations) {
            long l = equation.tryEverythingUnder100();
            if (l >= 0) {
                tokens += l;
            }
        }
        return tokens;
    }

    public long task2() {
        long tokens = 0;
        for (DiophantEquation equation : equations) {
            equation.setXres(equation.getXres()+10000000000000L);
            equation.setYres(equation.getYres()+10000000000000L);
            long l = equation.solveWithEquation();
            //long l2 = equation.tryEverythingUnder100();
            if (l > 0) {
                tokens += l;
            }
        }
        return tokens;
    }
}
