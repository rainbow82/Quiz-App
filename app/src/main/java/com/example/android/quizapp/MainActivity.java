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

        // As an FYI you see how all your type casts are gray? That's because they're
        // redundant and not required.  You can safely remove them if you like.
        user_answered_question_one = (EditText) findViewById(R.id.question_one_answer);
        mysteryMachineButton = (RadioButton) findViewById(R.id.question_two_correct_answer);
        velmaCheckBox = (CheckBox) findViewById(R.id.question_three_answer_velma);
        shaggyCheckBox = (CheckBox) findViewById(R.id.question_three_answer_shaggy);
        user_answered_question_four = (EditText) findViewById(R.id.question_four_answer);
        frankWelkerButton = (RadioButton) findViewById(R.id.question_five_correct_answer);
        scoobySnacksButton = (RadioButton) findViewById(R.id.question_six_correct_answer);
        user_answered_question_seven = (EditText) findViewById(R.id.question_seven_answer);
        greatDaneButton = (RadioButton) findViewById(R.id.question_eight_correct_answer);
        year1969Button = (RadioButton) findViewById(R.id.question_nine_correct_answer);
        doobyDooCheckBox = (CheckBox) findViewById(R.id.question_ten_answer_Dooby_Doo);
        spookyDooCheckBox = (CheckBox) findViewById(R.id.question_ten_answer_Spooky_Doo);
        scoobyDumCheckBox = (CheckBox) findViewById(R.id.question_ten_answer_Scooby_Dum);

        user_answered_question_one.setOnKeyListener(listener);
        user_answered_question_four.setOnKeyListener(listener);
        user_answered_question_seven.setOnKeyListener(listener);
    }

    /**
        get the user's answer, compare it to the correct answer
     */

    // Is there a way to dismiss the keyboard after answering this?
    // your question methods are in snake_case, they should be camelCase.
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


    // You don't need to create an incremental boolean to do the check
    // you could just test mysterMachineButton.isChecked() directly.
    // example below.  I'll leave this one comment here, but it applies below.

    // Your questions don't word wrap, so on the device I was testing
    // you couldn't read the whole question.
    public int question_two_points() {
//        boolean isMysteryMachine = mysteryMachineButton.isChecked();
//
//        if(isMysteryMachine){
//            score += 2;
//        }

        // You may want to be more verbose with some of your variables so it's more
        // obvious as to what it is by reading it.  i.e. I had to check around the code to
        // confirm this was a Radio button (vs checkbox button)
        if (mysteryMachineButton.isChecked()) { score += 2; }

        return score;
    }

    /*
        determine if correct boxes for question 3 are checked, add points for each box checked
     */


    // You may want to revisit the logic here.  If a user ticks off all your boxes, they get
    // maximum score.
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

    // I'd recommend taking the users answer and your answer, making both lowercase and then
    // doing the comparison.  It'll make the check a little more robust and forgiving.
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

     // Have you thought about supplying a warning or any feedback if
    // The user choose not to select anything?  You may want to do a check at the end
    // And pop a toast that all questions weren't answered.
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

     // You may want to revisit the logic here.  If a user ticks off all your boxes, they get
    // maximum score.
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

    // Prior to calculating, you may want to verify whether all the questions have been answered.

    public int calculateScore(){
        return question_one_points() + question_two_points() + question_three_points() +
                question_four_points() + question_five_points() + question_six_points() +
                question_seven_points() + question_eight_points() + question_nine_points() + question_ten_points();
    }

    /**
     * This method displays the score value on the screen.
     */

    // You never use your variable parameter.  Consider removing it or using it.
    // Why did you label this one private while all the others are public.  You should review that.
    private void display(int number) {
        TextView totalScore = (TextView) findViewById(R.id.total_score);
        totalScore.setText("" + score);
    }

    /*
        Disable the button so it can't be pressed again
        Display the score
     */

    // Perhaps you might want to supply some feedback as to how well they did.
    // What is the maximum score they could have gotten?
    // What did they get right vs wrong?
    public void submitScore(View view)
    {
        Button submitButton = (Button) findViewById(R.id.submit);
        submitButton.setEnabled(false);
        display(calculateScore());
        Toast.makeText(this, String.format(getString(R.string.scoreMessage), score), Toast.LENGTH_SHORT).show();
    }

    /*
        clear the users answers and restart the quiz
     */
    public void clearScreen(View view){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

}
