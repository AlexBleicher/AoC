package AoC2020.Day19.Task1;

public class EvaluationResult {

    private String wordAfterEvaluation;
    private boolean checksOut;

    public EvaluationResult(String wordAfterEvaluation, boolean checksOut) {
        this.wordAfterEvaluation = wordAfterEvaluation;
        this.checksOut = checksOut;
    }

    public String getWordAfterEvaluation() {
        return wordAfterEvaluation;
    }

    public boolean isChecksOut() {
        return checksOut;
    }
}
