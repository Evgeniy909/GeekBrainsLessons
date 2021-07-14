package com.example.geekbrainslessons;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityCalc extends AppCompatActivity {

    TextView viewResult;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calc);

        viewResult = (TextView) findViewById(R.id.textViewResult);
    }

    public static char lastOtherKey;
    public static String member = "";
    public static String lefVal = "";
    char otherKey = 'a';

    public void ButtonClick(View view) {

        this.view = view;

        if (lastOtherKey == '=') {
            viewResult.setText("");
            otherKey = 'a';
            member = "";
        }

        int number;

        switch (view.getId()) {
            case R.id.buttonZero:
                number = 0;
                viewResult.setText(viewResult.getText() + "" + number + "");
                member = member + number;
                break;
            case R.id.buttonOne:
                number = 1;
                viewResult.setText(viewResult.getText() + "" + number + "");
                member = member + number;
                break;
            case R.id.buttonTwo:
                number = 2;
                viewResult.setText(viewResult.getText() + "" + number + "");
                member = member + number;
                break;
            case R.id.buttonThree:
                number = 3;
                viewResult.setText(viewResult.getText() + "" + number + "");
                member = member + number;
                break;
            case R.id.buttonFour:
                number = 4;
                viewResult.setText(viewResult.getText() + "" + number + "");
                member = member + number;
                break;
            case R.id.buttonFive:
                number = 5;
                viewResult.setText(viewResult.getText() + "" + number + "");
                member = member + number;
                break;
            case R.id.buttonSix:
                number = 6;
                viewResult.setText(viewResult.getText() + "" + number + "");
                member = member + number;
                break;
            case R.id.buttonSeven:
                number = 7;
                viewResult.setText(viewResult.getText() + "" + number + "");
                member = member + number;
                break;
            case R.id.buttonEight:
                number = 8;
                viewResult.setText(viewResult.getText() + "" + number + "");
                member = member + number;
                break;
            case R.id.buttonNine:
                number = 9;
                viewResult.setText(viewResult.getText() + "" + number + "");
                member = member + number;
                break;
            case R.id.buttonDivision:
                otherKey = '/';
                viewResult.setText(viewResult.getText() + "/");
                lefVal = member;
                member = "";
                break;
            case R.id.buttonMultiplication:
                otherKey = '*';
                viewResult.setText(viewResult.getText() + "*");
                lefVal = member;
                member = "";
                break;
            case R.id.buttonSubtraction:
                otherKey = '-';
                viewResult.setText(viewResult.getText() + "-");
                lefVal = member;
                member = "";
                break;
            case R.id.buttonAddition:
                otherKey = '+';
                viewResult.setText(viewResult.getText() + "+");
                lefVal = member;
                member = "";
                break;
            case R.id.buttonEqually:
                otherKey = '=';
                break;
            case R.id.buttonClear:
                otherKey = 'c';
                break;
        }

        if (otherKey == 'c') {
            otherKey = 'a';
            viewResult.setText("");
            member = "";
            lefVal = "";

        } else if (otherKey == '=') {

            number = 0;

            int currentVal = Integer.parseInt(member);
            int memVal = Integer.parseInt(lefVal);
            int result = 0;

            if (lastOtherKey == '/') {

                if (currentVal == 0) {
                    viewResult.setText("Нельзя делить на ноль!");
                    return;
                } else {
                    result =  memVal / currentVal;
                }

            } else if (lastOtherKey == '*') {
                result = memVal * currentVal;
            } else if (lastOtherKey == '-') {
                result = memVal - currentVal;
            } else if (lastOtherKey == '+') {
                result = memVal + currentVal;
            }
            viewResult.setText("" + result + "");
        }

        lastOtherKey = otherKey;
    }
}