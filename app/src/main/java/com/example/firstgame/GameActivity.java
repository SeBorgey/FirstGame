package com.example.firstgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
        TextView textObjectPartA =(TextView)findViewById(R.id.textPartA);
        TextView textObjectPartB =(TextView)findViewById(R.id.textPartB);
        textObjectScore = (TextView)findViewById(R.id.textScore);
        textObjectLevel = (TextView)findViewById(R.id.textLevel);
        buttonObjectChoice1 =(Button)findViewById(R.id.buttonChoice1);
        buttonObjectChoice2 =(Button)findViewById(R.id.buttonChoice2);
        buttonObjectChoice3 =(Button)findViewById(R.id.buttonChoice3);
        buttonObjectChoice1.setOnClickListener(this);
        buttonObjectChoice2.setOnClickListener(this);
        buttonObjectChoice3.setOnClickListener(this);
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
    }
}//gameActivity