package hu.testathon.colntroller;

import hu.testathon.model.domain.TestResult;
import hu.testathon.model.domain.TestValidator;

import java.util.List;

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

    private TestResult getTestResultById(String id) {
        return results.stream()
                .filter(result -> result.getId().equals(id))
                .findAny()
                .get();
    }
}
