package com.rafael.exambyte.domain.model;


public interface Question <T>{
    boolean isEvaluated();
    boolean isFinished();
    boolean hasFreeText();
    double getScore();
    double getMaxScore();
    String getQuestion();
    String getSuggestedSolution();
    T getUserAnswer();
    void setUserAnswer(T answer);
}