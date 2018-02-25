package com.example.android.quizapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    int possibleScore = 26;
    EditText user_answered_question_one;
    RadioButton mysteryMachineButton;
    CheckBox velmaCheckBox;
    CheckBox shaggyCheckBox;
    EditText user_answered_question_four;
    RadioButton frankWelkerButton;
    RadioButton scoobySnacksButton;
    EditText user_answered_question_seven;
    RadioButton greatDaneButton;
    RadioButton year1969Button;
    CheckBox doobyDooCheckBox;
    CheckBox spookyDooCheckBox;
    CheckBox scoobyDumCheckBox;

    /*
        hide the keyboard when user hits enter button
     */
    View.OnKeyListener listener = new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                v.setFocusable(false);
                v.setFocusableInTouchMode(true);
                    return true;
                } else {
                    return false;
                }
            }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_answered_question_one = findViewById(R.id.question_one_answer);
        mysteryMachineButton = findViewById(R.id.question_two_correct_answer);
        velmaCheckBox = findViewById(R.id.question_three_answer_velma);
        shaggyCheckBox = findViewById(R.id.question_three_answer_shaggy);
        user_answered_question_four = findViewById(R.id.question_four_answer);
        frankWelkerButton =  findViewById(R.id.question_five_correct_answer);
        scoobySnacksButton = findViewById(R.id.question_six_correct_answer);
        user_answered_question_seven = findViewById(R.id.question_seven_answer);
        greatDaneButton = findViewById(R.id.question_eight_correct_answer);
        year1969Button = findViewById(R.id.question_nine_correct_answer);
        doobyDooCheckBox =  findViewById(R.id.question_ten_answer_Dooby_Doo);
        spookyDooCheckBox = findViewById(R.id.question_ten_answer_Spooky_Doo);
        scoobyDumCheckBox = findViewById(R.id.question_ten_answer_Scooby_Dum);

        user_answered_question_one.setOnKeyListener(listener);
        user_answered_question_four.setOnKeyListener(listener);
        user_answered_question_seven.setOnKeyListener(listener);


    }

    /**
        get the user's answer, compare it to the correct answer
     */
    public int question_one_points(){
        String user_answer =  user_answered_question_one.getText().toString().trim();

        if(user_answer.equals("Scoobert Doo")){
            score += 2 ;
        }

        return score;
    }

    /*
        Determine if right radio button chosen for question 2
     */

    public int question_two_points() {
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
        boolean isVelmaChecked = velmaCheckBox.isChecked();
        boolean isShaggyChecked = shaggyCheckBox.isChecked();

        if(isVelmaChecked){

            score +=2;
        }

        if(isShaggyChecked){
            score += 2;
        }

        return score;
    }

    /*
        get the user's answer, compare it to the correct answer
     */
    public int question_four_points(){
        String user_answer =  user_answered_question_four.getText().toString().trim();

        if(user_answer.equals("Coolsville")){
            return score += 2 ;
        }

        return score;
    }

     /*
        Determine if right radio button chosen for question 5
     */
    public int question_five_points() {
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
        String user_answer =  user_answered_question_seven.getText().toString().trim();

        if(user_answer.equals("Scrappy")){
            return score += 2 ;
        }else if(user_answer.equals("Scrappy Doo")){
            score += 2;
        }

        return score;
    }

    public int question_eight_points() {
        boolean isGreatDane = greatDaneButton.isChecked();

        if(isGreatDane){
            return score += 2;
        }

        return score;
    }

    public int question_nine_points() {
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
        boolean isDoobyDooChecked = doobyDooCheckBox.isChecked();
        boolean isSpookyDooChecked = spookyDooCheckBox.isChecked();
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
        Show toast message of points vs total possible points
        Display the score
     */
    public void submitScore(View view)
    {
        Button submitButton = (Button) findViewById(R.id.submit);
        submitButton.setEnabled(false);
        display(calculateScore());
        Toast.makeText(this, String.format(getString(R.string.scoreMessage), score, possibleScore), Toast.LENGTH_SHORT).show();
    }

    /*
        clear the users answers and restart the quiz
     */
    public void clearScreen(View view){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    /*
        hide keyboard when edit text view is not in focus
     */

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }



}
