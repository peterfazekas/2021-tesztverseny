package hu.testathon.model.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestValidator {

    private static final int[] POINTS = {3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 6};

    private final String answers;

    public TestValidator(String answers) {
        this.answers = answers;
    }

    public String getAnswers() {
        return answers;
    }

    public String checkResults(String competitorAnswers) {
        return IntStream.range(0, answers.length())
                .mapToObj(i -> checkAnswer(competitorAnswers, i))
                .collect(Collectors.joining());
    }

    public int calculateScore(String competitorAnswers) {
        return IntStream.range(0, answers.length())
                .map(i -> getScore(competitorAnswers, i))
                .sum();
    }

    private String checkAnswer(String competitorAnswers, int i) {
        return isCorrect(competitorAnswers, i) ? "+" : " ";
    }

    private int getScore(String competitorAnswers, int i) {
        return isCorrect(competitorAnswers, i) ? POINTS[i] : 0;
    }

    public boolean isCorrect(String competitorAnswers, int i) {
        return answers.charAt(i) == competitorAnswers.charAt(i);
    }
}
