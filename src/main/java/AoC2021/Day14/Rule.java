package AoC2021.Day14;

public class Rule {

    private String pair;
    private String letterToInsert;

    public Rule(String pair, String letterToInsert) {
        this.pair = pair;
        this.letterToInsert = letterToInsert;
    }

    public String getStringAfterInsertion() {
        String output = "";
        output += pair.substring(0, 1);
        output += letterToInsert;
        output += pair.substring(1);
        return output;
    }

    public String getPair() {
        return pair;
    }
}
