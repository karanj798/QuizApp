package com.jariwala.karan.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Karan on 07/05/2016.
 */
public class QuizActivity extends AppCompatActivity {

    private Button btnTrue, btnFalse;
    private ArrayList<Question> questions = new ArrayList<>();
    private TextView txtQuestions, txtGameStatus;
    private Question question;
    private int randomIndex;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        txtQuestions = (TextView) findViewById(R.id.txtQuestions);
        txtGameStatus =(TextView) findViewById(R.id.txtGameStatus);
        btnTrue = (Button) findViewById(R.id.button_true);
        btnFalse = (Button) findViewById(R.id.button_false);

        // Adding Questions to ArrayList
        questions.add(new Question(R.string.question_eyes, true));
        questions.add(new Question(R.string.question_million, false));
        questions.add(new Question(R.string.question_square_root, false));
        questions.add(new Question(R.string.question_water, true));
        questions.add(new Question(R.string.question_ice, false));
        questions.add(new Question(R.string.question_rainbow, true));
        questions.add(new Question(R.string.question_math, true));
        randomIndex();
        updateQuestion();
        txtGameStatus.setText("Game ON!");
        btnTrue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(isCorrectAnswer(question, true)){
                    Toast.makeText(QuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    questions.remove(randomIndex);
                }
                else{
                    Toast.makeText(QuizActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                }

                if (questions.size() > 0){
                    randomIndex();
                    updateQuestion();
                }
                else{
                    btnTrue.setEnabled(false);
                    btnFalse.setEnabled(false);
                    txtGameStatus.setText("Game Over!");
                }
            }
        });

        btnFalse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(isCorrectAnswer(question, false)){
                    Toast.makeText(QuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    questions.remove(randomIndex);
                }
                else{
                    Toast.makeText(QuizActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                }

                if (questions.size() > 0){
                    randomIndex();
                    updateQuestion();
                }
                else{
                    btnTrue.setEnabled(false);
                    btnFalse.setEnabled(false);
                    txtGameStatus.setText("Game Over!");
                }
            }
        });

    }

    public void randomIndex (){
        Random rn = new Random();
        int random = rn.nextInt (questions.size());
        setIndex(random);
        setQuestion(random);
    }

    public void setIndex (int index){
        this.randomIndex = index;
    }

    public void setQuestion (int index){
        question = questions.get(index);
    }

    public void updateQuestion (){
        txtQuestions.setText(question.getQuestionID());
    }

    public boolean isCorrectAnswer (Question currentQuestion, boolean b){
        return currentQuestion.isQuestionTrue() == b;
    }
}
