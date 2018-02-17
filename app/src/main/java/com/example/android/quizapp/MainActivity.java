package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    int question_one_points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int question_one_points(){
        String correct_answer = "Scoobert Doo";

        EditText user_answered = (EditText) findViewById(R.id.question_one_answer);
        String user_answer =  user_answered.getText().toString();

        if(user_answer.equals(correct_answer)){
            question_one_points += 2 ;
            return question_one_points;
        }

        return question_one_points;

    }

    public int calculateScore(){
        score += question_one_points();
        return score;

    }



    /**
     * This method displays the score value on the screen.
     */
    private void display(int number) {
        TextView totalScore = (TextView) findViewById(R.id.total_score);
        totalScore.setText("" + number);
    }

    public void submitScore(View view){
        display(calculateScore());
    }
}
