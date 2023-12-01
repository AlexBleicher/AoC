package AoC2023.Day1;

import java.util.List;

public class Day1 {

    private List<String> lines;

    public Day1(String in) {
        lines = new Input(in).parseInput();
    }

    public int task1() {
        int res = 0;
        for (String line : lines) {
            char numberFront = ' ';
            char numberBack = ' ';
            for (int i = 0; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    if (numberFront == ' ') {
                        numberFront = line.charAt(i);
                    }
                    numberBack = line.charAt(i);
                }
            }
            String numberString = "" + numberFront + numberBack;
            res += Integer.parseInt(numberString);
        }
        return res;
    }

    public int task2() {
        int res = 0;
        for (String line : lines) {
            String numberFront = "";
            String numberBack = "";
            String substring = "";
            for (int i = 0; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    if (numberFront == "") {
                        numberFront = "" + line.charAt(i);
                    }
                    numberBack = "" + line.charAt(i);
                } else {
                    substring += line.charAt(i);
                    if (substring.contains("one")) {
                        if (numberFront == "") {
                            numberFront = "1";
                        }
                        numberBack = "1";
                        substring = "";
                    } else if (substring.contains("two")) {
                        if (numberFront == "") {
                            numberFront = "2";
                        }
                        numberBack = "2";
                        substring = "";
                    } else if (substring.contains("three")) {
                        if (numberFront == "") {
                            numberFront = "3";
                        }
                        numberBack = "3";
                        substring = "";
                    } else if (substring.contains("four")) {
                        if (numberFront == "") {
                            numberFront = "4";
                        }
                        numberBack = "4";
                        substring = "";
                    } else if (substring.contains("five")) {
                        if (numberFront == "") {
                            numberFront = "5";
                        }
                        numberBack = "5";
                        substring = "";
                    } else if (substring.contains("six")) {
                        if (numberFront == "") {
                            numberFront = "6";
                        }
                        numberBack = "6";
                        substring = "";
                    } else if (substring.contains("seven")) {
                        if (numberFront == "") {
                            numberFront = "7";
                        }
                        numberBack = "7";
                        substring = "";
                    } else if (substring.contains("eight")) {
                        if (numberFront == "") {
                            numberFront = "8";
                        }
                        numberBack = "8";
                        substring = "";
                    } else if (substring.contains("nine")) {
                        if (numberFront == "") {
                            numberFront = "9";
                        }
                        numberBack = "9";
                        substring = "";
                    }
                }
            }
            String numberString = "" + numberFront + numberBack;
            res += Integer.parseInt(numberString);
        }
        return res;
    }
}
