package hu.testathon.model.domain;

public class FinalResult {

    private final int order;
    private final String id;
    private final int score;

    public FinalResult(String id, int score) {
        this(0, id, score);
    }

    public FinalResult(int order, String id, int score) {
        this.order = order;
        this.id = id;
        this.score = score;
    }

    public int getOrder() {
        return order;
    }

    public String getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return order + ". díj (" + score + " pont): " + id;
    }
}
