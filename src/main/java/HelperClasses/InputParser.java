package HelperClasses;

import java.util.List;

public abstract class InputParser {

    private String input;

    public abstract <T> List<T> parseInput();
}
