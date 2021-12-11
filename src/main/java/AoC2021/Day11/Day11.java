package AoC2021.Day11;

import java.util.List;

public class Day11 {

    private List<Octopus> allOctopus;

    public Day11(String input) {
        allOctopus = new Input(input).splitInput();
    }

    public int task1() {
        int scoreTotal = 0;
        for (int i = 0; i < 100; i++) {
            scoreTotal += flashstep();
        }
        return scoreTotal;
    }

    public int flashstep() {
        int score = 0;
        for (Octopus octopus : allOctopus) {
            octopus.increaseEnergyLevel();
        }
        for (Octopus octopus : allOctopus) {
            score += octopus.flash();
        }
        for (Octopus octopus : allOctopus) {
            octopus.resetEnergy();
        }
        return score;
    }

    public int task2() {
        return calculateFirstSimStep();
    }

    public int calculateFirstSimStep() {
        int step = 0;
        int stepscore = 0;
        while (stepscore != 100) {
            step++;
            stepscore = flashstep();
        }
        return step;
    }
}
