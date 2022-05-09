package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textScreen;
    private boolean isHasOperator = false;
    String bufferScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Number Button in layout
        Button zero = (Button) findViewById(R.id.button_0);
        Button one = (Button) findViewById(R.id.button_1);
        Button two = (Button) findViewById(R.id.button_2);
        Button three = (Button) findViewById(R.id.button_3);
        Button four = (Button) findViewById(R.id.button_4);
        Button five = (Button) findViewById(R.id.button_5);
        Button six = (Button) findViewById(R.id.button_6);
        Button seven = (Button) findViewById(R.id.button_7);
        Button eight = (Button) findViewById(R.id.button_8);
        Button nine = (Button) findViewById(R.id.button_9);

        // Operator Button in layout
        Button plus = (Button) findViewById(R.id.button_plus);
        Button subtract = (Button) findViewById(R.id.button_subtract);
        Button divide = (Button) findViewById(R.id.divide_button);
        Button mul = (Button) findViewById(R.id.button_multiple);

        Button equal = (Button) findViewById(R.id.button_equal);

        // Set TextView
        textScreen = (TextView) findViewById(R.id.text_button);

        // Set onClick method
        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);



        plus.setOnClickListener(this);
        subtract.setOnClickListener(this);
        mul.setOnClickListener(this);
        divide.setOnClickListener(this);
        equal.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_0:
                numberButtonEvent(0);
                break;

            case R.id.button_1:
                numberButtonEvent(1);
                break;

            case R.id.button_2:
                numberButtonEvent(2);
                break;

            case R.id.button_3:
                numberButtonEvent(3);
                break;

            case R.id.button_4:
                numberButtonEvent(4);
                break;

            case R.id.button_5:
                numberButtonEvent(5);
                break;

            case R.id.button_6:
                numberButtonEvent(6);
                break;

            case R.id.button_7:
                numberButtonEvent(7);
                break;

            case R.id.button_8:
                numberButtonEvent(8);
                break;

            case R.id.button_9:
                numberButtonEvent(9);
                break;

            case R.id.button_plus:
                operatorButtonEvent('+');
                break;

            case R.id.button_subtract:
                operatorButtonEvent('-');
                break;

            case R.id.button_multiple:
                operatorButtonEvent('x');
                break;

            case R.id.divide_button:
                operatorButtonEvent('/');
                break;

            case R.id.button_equal:
                calculateResult();
                isHasOperator = false;
                break;
        }
    }

    private void numberButtonEvent(int numberValue) {
        if (textScreen.getText().toString().equals("0")) {
            textScreen.setText(Integer.toString(numberValue));
        } else {
            textScreen.append(Integer.toString(numberValue));
        }
    }

    private void operatorButtonEvent(char operator) {
        if (isHasOperator) {
            calculateResult();
            textScreen.append(Character.toString(operator));
        }
        else {
            textScreen.append(Character.toString(operator));
            isHasOperator = true;
        }
    }

    private void calculateResult() {
        String equation = textScreen.getText().toString();
        int firstNumber = 0;
        int secondNumber = 0;
        // Find the position of operator
        int i;
        for (i = 0; i < equation.length(); i++) {
            char operator = equation.charAt(i);
            if (operator == '+' || operator == '-'
                || operator == '/' || operator == 'x') {
                break;
            }
        }

        firstNumber = Integer.parseInt(equation.substring(0, i));
        secondNumber = Integer.parseInt(equation.substring(i+1, equation.length()));

        int result = 0;

        switch (equation.charAt(i)) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '/':
                result = firstNumber / secondNumber;
                break;
            case 'x':
                result = firstNumber * secondNumber;
                break;
        }
        textScreen.setText(Integer.toString(result));
    }


}