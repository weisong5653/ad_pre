package entity;

public class Evaluation {
    private int scores;
    private int maxScores;
    private String content;
    private String subject;


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    public int getMaxScores() {
        return maxScores;
    }

    public void setMaxScores(int maxScores) {
        this.maxScores = maxScores;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Evaluation{" +
                "scores=" + scores +
                ", maxScores=" + maxScores +
                ", content='" + content + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
