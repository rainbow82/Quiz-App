package com.example.android.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;

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
            score += 2 ;
        }

        return score;
    }

    /*
        Determine if right radio button chosen for question 2
     */

    public int question_two_points() {

        RadioButton mysteryMachineButton = (RadioButton) findViewById(R.id.question_two_correct_answer);
        boolean isMysteryMachine = mysteryMachineButton.isChecked();

        if(isMysteryMachine){
            score += 2;
        }

        return score;
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

            score +=2;
        }

        if(isShaggyChecked){
            score += 2;
        }

        return score;
    }

    /**
     get the user's answer, compare it to the correct answer
     */
    public int question_four_points(){
        String correct_answer = "Coolsville";

        EditText user_answered = (EditText) findViewById(R.id.question_four_answer);
        String user_answer =  user_answered.getText().toString();

        if(user_answer.equals(correct_answer)){
            return score += 2 ;
        }

        return score;
    }

     /*
        Determine if right radio button chosen for question 5
     */

    public int question_five_points() {

        RadioButton frankWelkerButton = (RadioButton) findViewById(R.id.question_five_correct_answer);
        boolean isFrankWelker = frankWelkerButton.isChecked();

        if(isFrankWelker){
            return score += 2;
        }

        return score;
    }

         /*
        Determine if right radio button chosen for question 6
     */

    public int question_six_points() {

        RadioButton scoobySnacksButton = (RadioButton) findViewById(R.id.question_six_correct_answer);
        boolean isScoobySnacks = scoobySnacksButton.isChecked();

        if(isScoobySnacks){
            return score += 2;
        }

        return score;
    }

    /**
     get the user's answer, compare it to the correct answer
     allow first or full name to count as correct
     */
    public int question_seven_points(){

        EditText user_answered = (EditText) findViewById(R.id.question_seven_answer);
        String user_answer =  user_answered.getText().toString();

        if(user_answer.equals("Scrappy")){
            return score += 2 ;
        }else if(user_answer.equals("Scrappy Doo")){
            score += 2;
        }

        return score;
    }

    public int question_eight_points() {

        RadioButton greatDaneButton = (RadioButton) findViewById(R.id.question_eight_correct_answer);
        boolean isGreatDane = greatDaneButton.isChecked();

        if(isGreatDane){
            return score += 2;
        }

        return score;
    }

    public int question_nine_points() {

        RadioButton year1969Button = (RadioButton) findViewById(R.id.question_nine_correct_answer);
        boolean isyear1969 = year1969Button.isChecked();

        if(isyear1969){

            return score += 2;
        }

        return score;
    }


     /*
        determine if correct boxes for question 10 are checked, add points for each box checked
     */

    public int question_ten_points(){

        CheckBox doobyDooCheckBox = (CheckBox) findViewById(R.id.question_ten_answer_Dooby_Doo);
        boolean isDoobyDooChecked = doobyDooCheckBox.isChecked();

        CheckBox spookyDooCheckBox = (CheckBox) findViewById(R.id.question_ten_answer_Spooky_Doo);
        boolean isSpookyDooChecked = spookyDooCheckBox.isChecked();

        CheckBox scoobyDumCheckBox = (CheckBox) findViewById(R.id.question_ten_answer_Scooby_Dum);
        boolean isScoobyDumChecked = scoobyDumCheckBox.isChecked();

        if(isDoobyDooChecked){

            score +=2;
        }

        if(isSpookyDooChecked){
            score += 2;
        }

        if(isScoobyDumChecked){
            score += 2;
        }

        return score;
    }


    /*
        add the points for each question to the total score
     */
    public int calculateScore(){
        return question_one_points() + question_two_points() + question_three_points() +
                question_four_points() + question_five_points() + question_six_points() +
                question_seven_points() + question_eight_points() + question_nine_points() + question_ten_points();
    }

    /**
     * This method displays the score value on the screen.
     */
    private void display(int number) {
        TextView totalScore = (TextView) findViewById(R.id.total_score);
        totalScore.setText("" + score);
    }

    /*
        Disable the button so it can't be pressed again
        Display the score
     */
    public void submitScore(View view)
    {
        Button submitButton = (Button) findViewById(R.id.submit);
        submitButton.setEnabled(false);
        display(calculateScore());
        Toast.makeText(this, String.format(getString(R.string.scoreMessage), score), Toast.LENGTH_SHORT).show();
    }


    public void clearScreen(View view){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

}
