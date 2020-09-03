package com.example.firstgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
    int correctAnswer;
    Button buttonObjectChoice1;
    Button buttonObjectChoice2;
    Button buttonObjectChoice3;
    TextView textObjectPartA;
    TextView textObjectPartB;
    TextView textObjectScore;
    TextView textObjectLevel;
    int currentScore = 0;
    int currentLevel = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        /*Здесь мы создаём объект, основанный на классе
        TextView и Button соответственно, а также связываем эти объекты
        к соответствующим элементам графического интерфейса, созданного нами ранее*/
        textObjectPartA = (TextView)findViewById(R.id.textPartA);
        textObjectPartB = (TextView)findViewById(R.id.textPartB);
        textObjectScore = (TextView)findViewById(R.id.textScore);
        textObjectLevel = (TextView)findViewById(R.id.textLevel);
        buttonObjectChoice1 =(Button)findViewById(R.id.buttonChoice1);
        buttonObjectChoice2 =(Button)findViewById(R.id.buttonChoice2);
        buttonObjectChoice3 =(Button)findViewById(R.id.buttonChoice3);
        buttonObjectChoice1.setOnClickListener(this);
        buttonObjectChoice2.setOnClickListener(this);
        buttonObjectChoice3.setOnClickListener(this);

        setQuestion();
    }//onCreate

    @Override
    public void onClick(View view) {
        //объявим новую переменную типа int, которую будем использовать в каждом case
        int answerGiven=0;

        switch (view.getId()) {
            case R.id.buttonChoice1:
                //присваиваем переменной answerGiven значение, содержащееся в buttonObjectChoice1
                //это значение мы сами поместили туда ранее
                answerGiven = Integer.parseInt("" + buttonObjectChoice1.getText());

                break;

            case R.id.buttonChoice2:
                //то же самое, что и предыдущий case, только используем следующую кнопку
                answerGiven = Integer.parseInt("" + buttonObjectChoice2.getText());

                break;

            case R.id.buttonChoice3:
                //то же самое, что и предыдущий case, только используем следующую кнопку
                answerGiven = Integer.parseInt("" + buttonObjectChoice3.getText());

                break;
        }
        updateScoreAndLevel(answerGiven);
        setQuestion();
    }//onClick
    void setQuestion(){
//        генерируем части вопроса
        int numberRange = currentLevel * 3;
        Random randInt = new Random();
        int partA = randInt.nextInt(numberRange);
        partA++;//для того, чтобы не получился 0
        int partB = randInt.nextInt(numberRange);
        partB++;//для того, чтобы не получился 0
        correctAnswer = partA * partB;
        int wrongAnswer1 = correctAnswer-2;
        int wrongAnswer2 = correctAnswer+2;
        textObjectPartA.setText(String.valueOf(partA));
        textObjectPartB.setText(String.valueOf(partB));
        //устанавливаем числа в кнопки
        //генерируем случайное число между 0 и 2
        int buttonLayout = randInt.nextInt(3);
        switch (buttonLayout){
            case 0:
                buttonObjectChoice1.setText(""+correctAnswer);
                buttonObjectChoice2.setText(""+wrongAnswer1);
                buttonObjectChoice3.setText(""+wrongAnswer2);
                break;
            case 1:
                buttonObjectChoice2.setText(""+correctAnswer);
                buttonObjectChoice3.setText(""+wrongAnswer1);
                buttonObjectChoice1.setText(""+wrongAnswer2);
                break;
            case 2:
                buttonObjectChoice3.setText(""+correctAnswer);
                buttonObjectChoice1.setText(""+wrongAnswer1);
                buttonObjectChoice2.setText(""+wrongAnswer2);
                break;
        }
    }//setQuestion
    void updateScoreAndLevel(int answerGiven){
        if(isCorrect(answerGiven)){
            for(int i = 1; i <= currentLevel; i++){
                currentScore = currentScore + i;
            }//for
            currentLevel++;
        }//if
        else{
            currentScore = 0;
            currentLevel = 1;
        }//else
        //Отображаем текущие значения в наших TextView
        textObjectScore.setText("Score: " + currentScore);
        textObjectLevel.setText("Level: " + currentLevel);
    }//updateScoreAndLevel
    boolean isCorrect(int answerGiven){
        boolean correctTrueOrFalse;
        if(answerGiven == correctAnswer){
            Toast.makeText(getApplicationContext(), "Well done!", Toast.LENGTH_LONG).show();
            correctTrueOrFalse=true;
        } else {
            Toast.makeText(getApplicationContext(), "Sorry", Toast.LENGTH_LONG).show();
            correctTrueOrFalse=false;
        }
        return correctTrueOrFalse;
    }//boolean

}//gameActivity