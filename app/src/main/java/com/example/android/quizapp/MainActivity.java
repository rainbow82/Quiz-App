package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    int question_one_points = 0;
    int question_two_points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
        get the user's answer, compare it to the correct answer
     */
    public int question_one_points(){
        String correct_answer = "Scoobert Doo";

        EditText user_answered = (EditText) findViewById(R.id.question_one_answer);
        String user_answer =  user_answered.getText().toString();

        if(user_answer.equals(correct_answer)){
            return question_one_points += 2 ;
        }

        return question_one_points;
    }

    /*
        Determine if right radio button chosen for question 2
     */

    public int getQuestion_two_points() {

        RadioButton mysteryMachineButton = (RadioButton) findViewById(R.id.question_two_correct_answer);
        boolean isMysteryMachine = mysteryMachineButton.isChecked();

        if(isMysteryMachine){
            return question_two_points += 2;
//           / Toast.makeText(this, "Only one answer can be chosen", Toast.LENGTH_SHORT).show();

        }

        return question_two_points;
    }



    public int calculateScore(){
        score += question_one_points();
        score += getQuestion_two_points();
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
