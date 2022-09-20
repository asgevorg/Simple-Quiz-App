package com.example.simple_story_quiz_application;

// =======история=======
public class Story {

    private Situation start_story;
    public Situation current_situation;

    Story() {
        //has 2 variants
        start_story = new Situation(
                "Please answer questions about your age ",
                "(1) You are under 14 years old\n" +
                        "(2) You are above 18 years old(Adult)",
                2, 0, 0, 0);
        //You are under 14
        start_story.direction[0] = new Situation(
                "You are under 14 years old\n",
                        "(1) Watching cartoons\n" +
                        "(2) Playing outside",
                3, 0,0,0

        );
        start_story.direction[0].direction[0] = new Situation(
                "Choose what to watch", "A\n" + "B\n" + "C", 3,10,0,-1
        );

        start_story.direction[0].direction[0].direction[0] = new Situation(
                "A", "", 0,10,0,-1
        );
        start_story.direction[0].direction[0].direction[1] = new Situation(
                "B", "", 0,10,0,-1
        );
        start_story.direction[0].direction[0].direction[2] = new Situation(
                "C", "", 0,10,0,-1
        );
//
        start_story.direction[0].direction[1] = new Situation(
                "You have played outside whole you evening", "", 0,1,0,1
        );
        //you are above 18 years old(Adult)
        start_story.direction[1] = new Situation(
                "You are above 18 so you will need",
                        "(1) Find work and go to university\n"+
                        "(2) Only go to university",
                2, 0, 0,0
        );
        start_story.direction[1].direction[0] = new Situation(
                "You studied but not that well, and now you have experiance", "", 0, 10,8, 8
        );
        start_story.direction[1].direction[1] = new Situation(
                "You only studied, now you have very well theorothical knowledge but you do not have experiance", "", 0, 0,10, 10
        );

        current_situation = start_story;
    }

    public void go(int num) {
        if (num <= current_situation.direction.length)
            current_situation = current_situation.direction[num - 1];
        else
            System.out.println("Вы можете выбирать из "
                    + current_situation.direction.length + " вариантов");
    }

    public boolean isEnd() {
        return current_situation.direction.length == 0;
    }
}

