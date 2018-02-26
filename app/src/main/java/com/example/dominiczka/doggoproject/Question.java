package com.example.dominiczka.doggoproject;

/**
 * Created by Dominiczka on 03.01.2018.
 */

public class Question {

    private String question;
    private String[] answer = new String[4];

    public Question(){}

    public Question(String question, String[] answer) {
        this.question = question;
        this.answer[0] = answer[0];
        this.answer[1] = answer[1];
        this.answer[2] = answer[2];
        this.answer[3] = answer[3];
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer(int i) {
        return answer[i];
    }

    public void setAnswer(int i, String answer) {
        this.answer[i] = answer;
    }
}
