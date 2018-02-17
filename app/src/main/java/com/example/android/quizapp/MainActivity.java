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
    int question_three_points = 0;
    int question_four_points = 0;

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

    public int question_two_points() {

        RadioButton mysteryMachineButton = (RadioButton) findViewById(R.id.question_two_correct_answer);
        boolean isMysteryMachine = mysteryMachineButton.isChecked();

        if(isMysteryMachine){
            return question_two_points += 2;
        }

        return question_two_points;
    }

    /*
        determine if correct boxes for question 3 are checked, add points for each box checked
     */

    public int question_three_points(){

        CheckBox velmaCheckBox = (CheckBox) findViewById(R.id.question_three_answer_velma);
        boolean isVelmaChecked = velmaCheckBox.isChecked();

        CheckBox shaggyCheckBox = (CheckBox) findViewById(R.id.question_three_answer_shaggy);
        boolean isShaggyChecked = shaggyCheckBox.isChecked();

        if(isVelmaChecked){

            question_three_points +=2;
        }

        if(isShaggyChecked){
            question_three_points += 2;
        }

        return question_three_points;
    }

    /**
     get the user's answer, compare it to the correct answer
     */
    public int question_four_points(){
        String correct_answer = "Coolsville";

        EditText user_answered = (EditText) findViewById(R.id.question_four_answer);
        String user_answer =  user_answered.getText().toString();

        if(user_answer.equals(correct_answer)){
            return question_four_points += 2 ;
        }

        return question_four_points;
    }

     /*
        Determine if right radio button chosen for question 5
     */

    public int question_five_points() {

        RadioButton frankWelkerButton = (RadioButton) findViewById(R.id.question_five_correct_answer);
        boolean isFrankWelker = frankWelkerButton.isChecked();

        if(isFrankWelker){
            return question_two_points += 2;
        }

        return question_two_points;
    }



    /*
        add the points for each question to the total score
     */
    public int calculateScore(){
        score += question_one_points();
        score += question_two_points();
        score += question_three_points();
        score += question_four_points();
        score += question_five_points();
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
