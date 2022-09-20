package com.example.simple_story_quiz_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static Character manager;
    public Story story;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        start_screen();
    }
    //start game screen
    public void start_game(){
        manager = new Character("gevorg");
        TextView mind = findViewById(R.id.mind);
        TextView creativity = findViewById(R.id.creativity);
        TextView homework = findViewById(R.id.homework);

        if (story.isEnd()) {
            setContentView(R.layout.how_to_page);
            //putting onClickListener on back to start button
            Button back_to_start = findViewById(R.id.back_to_start);
            back_to_start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    start_screen();
                }
            });

            TextView end_text = findViewById(R.id.endText);
            end_text.setText(story.current_situation.subject);
        }else{
            TextView qst = findViewById(R.id.topic);
            LinearLayout quiz_buttons = findViewById(R.id.quiz_buttons);

            qst.setText(story.current_situation.subject);
            String[] options = story.current_situation.text.split("\n");
            for (String option: options){
                Button myButton = new Button(this);
                myButton.setText(option);
                quiz_buttons.addView(myButton);
                btn_clicker(myButton, options, quiz_buttons);
            }
        }

        mind.setText("Mind: " + (manager.mind += story.current_situation.mind));
        creativity.setText("Creativity: " + (manager.creativity += story.current_situation.creativity));
        homework.setText("Homework: " + (manager.homeworks += story.current_situation.homeworks));
    }

    public void btn_clicker(Button btn, String[] options, LinearLayout ll){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = 0; i < options.length;i++){
                    if (btn.getText().equals(options[i])) {
                        story.go(i+1);
                    }
                }
                ll.removeAllViews();
                start_game();
            }
        });
    }

    public void start_screen(){
        story = new Story();
        setContentView(R.layout.start_screen);
        Button start_btn = findViewById(R.id.start_button);
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_main);
                start_game();
            }
        });
    }

}