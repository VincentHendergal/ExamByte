package com.rafael.exambyte;

import com.rafael.exambyte.domain.model.MultipleChoiceQuestion;
import com.rafael.exambyte.domain.model.Question;
import com.rafael.exambyte.dto.QuestionDetails;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class QuestionTest {
    @Test
    @DisplayName("MultipleChoiceQuestion 0 fails takes max score")
    public void MultipleChoiceRightAnswers() {
        //Arrange
        double maxScore = 100;
        String questionText = "question";
        String suggestedSolution = "solution";
        QuestionDetails questionDetails = new QuestionDetails(maxScore, questionText, suggestedSolution);
        List<String> options = new ArrayList<>(Arrays.asList("one", "two", "three", "four"));
        List<Boolean> rightAnswers = new ArrayList<>(Arrays.asList(false, true, false, true));
        Question<List<Boolean>> question = new MultipleChoiceQuestion(questionDetails, options, rightAnswers);
        //Act
        question.setUserAnswer(rightAnswers);
        //Assert
        assertThat(question.getScore()).isEqualTo(maxScore);
    }
    @Test
    @DisplayName("MultipleChoiceQuestion 2 fails takes 0 score")
    public void MultipleChoiceWrongAnswers() {
        //Arrange
        double maxScore = 100;
        String questionText = "question";
        String suggestedSolution = "solution";
        QuestionDetails questionDetails = new QuestionDetails(maxScore, questionText, suggestedSolution);
        List<String> options = new ArrayList<>(Arrays.asList("one", "two", "three", "four"));
        List<Boolean> rightAnswers = new ArrayList<>(Arrays.asList(false, true, false, true));
        List<Boolean> userAnswers = new ArrayList<>(Arrays.asList(false, false, false, false));
        Question<List<Boolean>> question = new MultipleChoiceQuestion(questionDetails, options, rightAnswers);
        //Act
        question.setUserAnswer(userAnswers);
        //Assert
        assertThat(question.getScore()).isEqualTo(0);
    }
}
