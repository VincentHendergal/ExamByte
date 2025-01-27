package com.rafael.exambyte.domain.model;


import com.rafael.exambyte.dto.QuestionDetails;

import java.util.List;

public class MultipleChoiceQuestion implements Question <List<Boolean>>{
    private boolean finished = false;
    private double score;
    private final double maxScore;
    private final String question;
    private final String suggestedSolution;
    private final List<String> options;
    private List<Boolean> userAnswer;
    private final List<Boolean> rightAnswers;
    public MultipleChoiceQuestion(QuestionDetails questionDetails, List<String> options, List<Boolean> rightAnswers) {
        this.maxScore = questionDetails.maxScore();
        this.question = questionDetails.question();
        this.suggestedSolution = questionDetails.suggestedSolution();
        this.options = options;
        this.rightAnswers = rightAnswers;
    }
    @Override
    public boolean hasFreeText(){
        return false;
    }
    @Override
    public boolean isEvaluated() {
        return finished;
    }
    @Override
    public boolean isFinished() {
        return finished;
    }
    @Override
    public double getScore() {
        return score;
    }
    private void calculateScore() {
        switch(getFalseAnswerCount()){
            case 0:
                score = maxScore;
                break;
            case 1:
                score = maxScore / 2;
                break;
            default:
                score = 0;
        }
    }
    private int getFalseAnswerCount(){
        int count = 0;
        try{
            for(int i = 0; i < options.size(); i++){
                if(!rightAnswers.get(i)
                        .equals(userAnswer.get(i))){
                    count++;
                }
            }
            return count;
        }
        catch(IndexOutOfBoundsException e){
            throw new IllegalArgumentException("User answer is shorter than expected");
        }
    }
    @Override
    public double getMaxScore() {
        return maxScore;
    }
    @Override
    public String getQuestion() {
        return question;
    }
    public List<String> getOptions() {
        return options;
    }
    @Override
    public List<Boolean> getUserAnswer() {
        return userAnswer;
    }
    @Override
    public void setUserAnswer(List<Boolean> userAnswer) {
        this.userAnswer = userAnswer;
        calculateScore();
        finished = true;
    }
    public List<Boolean> getRightAnswers() {
        return rightAnswers;
    }
    @Override
    public String getSuggestedSolution() {
        return suggestedSolution;
    }
}