package hu.testathon.colntroller;

import hu.testathon.model.domain.FinalResult;
import hu.testathon.model.domain.TestResult;
import hu.testathon.model.domain.TestValidator;

import java.util.List;
import java.util.stream.Collectors;

public class TestService {

    private final TestValidator testValidator;
    private final List<TestResult> results;

    public TestService(TestValidator testValidator, List<TestResult> results) {
        this.testValidator = testValidator;
        this.results = results;
    }

    public int countCompetitors() {
        return results.size();
    }

    public String getAnswersById(String id) {
        return getTestResultById(id).getAnswers();
    }

    public String getCorrectAnswers() {
        return testValidator.getAnswers();
    }

    public String getCheckedResultById(String id) {
        return testValidator.checkResults(getAnswersById(id));
    }

    public long countCorrectAnswersByTaskId(int taskId) {
        return results.stream()
                .filter(i -> testValidator.isCorrect(i.getAnswers(), taskId))
                .count();
    }

    public List<String> printScores() {
        return calculateScores().stream()
                .map(i -> i.getId() + " " + i.getScore())
                .collect(Collectors.toList());
    }

    private List<FinalResult> calculateScores() {
        return results.stream()
                .map(i -> new FinalResult(i.getId(),
                        testValidator.calculateScore(i .getAnswers())))
                .collect(Collectors.toList());
    }

    private TestResult getTestResultById(String id) {
        return results.stream()
                .filter(result -> result.getId().equals(id))
                .findAny()
                .get();
    }
}
