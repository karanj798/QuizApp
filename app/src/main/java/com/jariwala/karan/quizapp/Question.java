package com.jariwala.karan.quizapp;

/**
 * Created by Karan on 07/05/2016.
 */
public class Question {
    private boolean isQuestionTrue;
    private int questionID;

    public Question(int questionID, boolean isQuestionTrue) {
        this.questionID = questionID;
        this.isQuestionTrue = isQuestionTrue;
    }

    public boolean isQuestionTrue() {
        return isQuestionTrue;
    }

    public void setQuestionTrue(boolean questionTrue) {
        isQuestionTrue = questionTrue;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }
}
