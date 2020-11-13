package com.example.calculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private Button dot;
    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private TextView input;
    private Button delete;
    private Button plusMinus;
    private Button percent;
    private Button divide;
    private Button multiply;
    private Button minus;
    private Button plus;
    private Button equal;
    private Double inputDouble = null;
    private Double number;
    private Double result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inIt();
    }

    private void inIt() {

        input = findViewById(R.id.result);
//        final List<Double> information = new ArrayList<>();
//        final Scanner scanner = new Scanner(System.in);

        dot = findViewById(R.id.dot_btn);

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.append(dot.getText().toString());
            }
        });

        one = findViewById(R.id.one_btn);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.append(one.getText().toString());
            }
        });

        zero = findViewById(R.id.zero_btn);

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.append(zero.getText().toString());
            }
        });

        two = findViewById(R.id.two_btn);

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.append(two.getText().toString());
            }
        });

        three = findViewById(R.id.three_btn);

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.append(three.getText().toString());
            }
        });

        four = findViewById(R.id.four_btn);

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.append(four.getText().toString());
            }
        });

        five = findViewById(R.id.five_btn);

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.append(five.getText().toString());
            }
        });

        six = findViewById(R.id.six_btn);

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.append(six.getText().toString());
            }
        });

        seven = findViewById(R.id.seven_btn);

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.append(seven.getText().toString());
            }
        });

        eight = findViewById(R.id.eight_btn);

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.append(eight.getText().toString());
            }
        });

        nine = findViewById(R.id.nine_btn);

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.append(nine.getText().toString());
            }
        });

        delete = findViewById(R.id.delete_btn);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText("");
            }
        });

        plusMinus = findViewById(R.id.plus_minus_btn);

        plusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDouble = Double.parseDouble(input.getText().toString());
                double convertedInput = - inputDouble;
                input.setText("" + convertedInput);
            }
        });

        percent = findViewById(R.id.percent_btn);

        divide = findViewById(R.id.divide_btn);

//        divide.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                inputDouble = Double.parseDouble(input.getText().toString());
//                information.add(inputDouble);
//                input.setText("");
//                Double secondInput = Double.valueOf(scanner.next());
//                Double secondInput = Double.parseDouble(input.getText().toString());
//                Double firstInput = information.get(information.size()-1);
//                input.setText("" + (firstInput / secondInput));
//
//                inputDouble = Double.parseDouble(input.getText().toString());
//                input.setText("");
//                number = Double.parseDouble(input.getText().toString());
//                if (inputDouble == null) {
//                    inputDouble = number;
//                } else if(number == 0) {
//                    inputDouble = 0.0;
//                } else {
//                    result = inputDouble / number;
//                }
//            }
//        });

        multiply = findViewById(R.id.multiply_btn);

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDouble = Double.parseDouble(input.getText().toString());
                input.setText("");
                number = Double.parseDouble(input.getText().toString());
                result = inputDouble * number;
            }
        });

        plus = findViewById(R.id.plus_btn);

        minus = findViewById(R.id.minus_btn);

        equal = findViewById(R.id.equal_btn);

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(result.toString());
            }
        });

    }
}