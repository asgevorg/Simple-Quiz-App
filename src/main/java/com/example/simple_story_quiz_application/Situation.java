package com.example.simple_story_quiz_application;

//=======ситуация=======
public class Situation {
    Situation[] direction;
    String subject, text;
    int creativity, homeworks, mind;

    public Situation(String subject, String text, int variants, int creativity, int homeworks, int mind) {
        this.subject = subject;
        this.text = text;
        this.creativity = creativity;
        this.homeworks = homeworks;
        this.mind = mind;
        direction = new Situation[variants];
    }
}

