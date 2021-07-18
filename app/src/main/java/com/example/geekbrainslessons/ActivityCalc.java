package com.example.geekbrainslessons;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.HashMap;

public class ActivityCalc extends AppCompatActivity {

    private final int[] numbersButtonIds;

    {
        numbersButtonIds = new int[]{
                R.id.buttonZero,
                R.id.buttonOne,
                R.id.buttonTwo,
                R.id.buttonThree,
                R.id.buttonFour,
                R.id.buttonFive,
                R.id.buttonSix,
                R.id.buttonSeven,
                R.id.buttonEight,
                R.id.buttonNine
        };
    }

    private final int[] operationsButtonIds;

    {
        operationsButtonIds = new int[]{
                R.id.buttonDivision,
                R.id.buttonMultiplication,
                R.id.buttonSubtraction,
                R.id.buttonAddition,
                R.id.buttonEqually,
                R.id.buttonClear
        };
    }

    Calculation calc = new Calculation();

    private TextView viewResult;

    HashMap<Integer, String> numbersHashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Button numberButton;

        int i = 0;

        for (int id : numbersButtonIds) {
            numberButton = (Button) findViewById(id);
            numberButton.setOnClickListener(clickNumberBut);
            numbersHashMap.put(id,"" + i++);
        }

        for (int id : operationsButtonIds) {
            numberButton = (Button) findViewById(id);
            numberButton.setOnClickListener(clickOperationBut);
        }

        viewResult = (TextView) findViewById(R.id.textViewResult);
    }

    View.OnClickListener clickNumberBut = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button btn = (Button) v;
            calc.setMember(numbersHashMap.get(btn.getId()));
            viewResult.setText(calc.getMember());
        }
    };

    View.OnClickListener clickOperationBut = new View.OnClickListener() {
        @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
        @Override
        public void onClick(View v) {

            if (calc.getLastOperationKey() == '=') {
                viewResult.setText("");
               calc.setMember("");
            }

            switch (v.getId()) {
                case R.id.buttonDivision:
                    viewResult.setText(calc.getMember() + "/");
                    calc.setLefVal();
                    calc.setLastOperationKey('/');
                    break;
                case R.id.buttonMultiplication:
                    viewResult.setText(calc.getMember() + "*");
                    calc.setLefVal();
                    calc.setLastOperationKey('*');
                    break;
                case R.id.buttonSubtraction:
                    viewResult.setText(calc.getMember() + "-");
                    calc.setLefVal();
                    calc.setLastOperationKey('-');
                    break;
                case R.id.buttonAddition:
                    viewResult.setText(calc.getMember() + "+");
                    calc.setLefVal();
                    calc.setLastOperationKey('+');
                    break;
                case R.id.buttonEqually:
                    viewResult.setText(calc.getResult());
                    calc.setLastOperationKey('=');
                    calc.setMember("");
                    break;
                case R.id.buttonClear:
                    viewResult.setText("");
                    calc.setLastOperationKey('c');
                    calc.setMember("");
                    break;
            }
        }
    };
}