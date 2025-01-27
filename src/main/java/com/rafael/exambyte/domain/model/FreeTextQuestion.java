package com.rafael.exambyte.domain.model;


import com.rafael.exambyte.dto.QuestionDetails;

public class FreeTextQuestion implements Question <String>{
    private boolean evaluated;
    private boolean finished;
    private double score;
    private final double maxScore;
    private final String question;
    private final String suggestedSolution;
    private String userAnswer;
    private String feedback;
    public FreeTextQuestion(QuestionDetails questionDetails) {
        this.maxScore = questionDetails.maxScore();
        this.question = questionDetails.question();
        this.suggestedSolution = questionDetails.suggestedSolution();
    }
    @Override
    public boolean hasFreeText(){
        return true;
    }
    @Override
    public boolean isEvaluated() {
        return evaluated;
    }
    @Override
    public boolean isFinished() {
        return finished;
    }
    @Override
    public double getScore() {
        return score;
    }
    public void setScore(Integer score) {
        this.score = score;
        evaluated = true;
    }
    @Override
    public double getMaxScore() {
        return maxScore;
    }
    @Override
    public String getQuestion() {
        return question;
    }
    @Override
    public String getUserAnswer() {
        return userAnswer;
    }
    @Override
    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
        finished = true;
    }
    public String getFeedback() {
        return feedback;
    }
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    public String getSuggestedSolution() {
        return suggestedSolution;
    }
}