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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //далее инициализируем переменные
        int partA = 9;
        int partB = 9;
        correctAnswer = partA * partB;
        int wrongAnswer1 = correctAnswer - 1;
        int wrongAnswer2 = correctAnswer + 1;
        /*Здесь мы создаём объект, основанный на классе
        TextView и Button соответственно, а также связываем эти объекты
        к соответствующим элементам графического интерфейса, созданного нами ранее*/
        TextView textObjectPartA =(TextView)findViewById(R.id.textPartA);
        TextView textObjectPartB =(TextView)findViewById(R.id.textPartB);
        buttonObjectChoice1 =(Button)findViewById(R.id.buttonChoice1);
        buttonObjectChoice2 =(Button)findViewById(R.id.buttonChoice2);
        buttonObjectChoice3 =(Button)findViewById(R.id.buttonChoice3);
        //Используем метод(функцию) setText, который описан в классах Button и //TextView для вывода на графический интерфейс значений переменных.
        textObjectPartA.setText("" + partA);
        textObjectPartB.setText("" + partB);
        //на данный момент нам не важно, какая кнопка будет
        //показывать правильный ответ,
        //а какая неправильный.
        buttonObjectChoice1.setText("" + correctAnswer);
        buttonObjectChoice2.setText("" + wrongAnswer1);
        buttonObjectChoice3.setText("" + wrongAnswer2);
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
                //получен верный овтет?
                if (answerGiven == correctAnswer) {//да - это верный ответ
                    Toast.makeText(getApplicationContext(), "Well done!", Toast.LENGTH_LONG).show();
                } else {//нет, неверно!
                    Toast.makeText(getApplicationContext(), "Sorry that's wrong", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.buttonChoice2:
                //то же самое, что и предыдущий case, только используем следующую кнопку
                answerGiven = Integer.parseInt("" + buttonObjectChoice2.getText());
                if (answerGiven == correctAnswer) {
                    Toast.makeText(getApplicationContext(), "Well done!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry that's wrong", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.buttonChoice3:
                //то же самое, что и предыдущий case, только используем следующую кнопку
                answerGiven = Integer.parseInt("" + buttonObjectChoice3.getText());
                if (answerGiven == correctAnswer) {
                    Toast.makeText(getApplicationContext(), "Well  done!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry  that's wrong", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}//gameActivity