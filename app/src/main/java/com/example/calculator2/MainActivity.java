package com.example.calculator2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

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
    private Double inputDouble;
    private static final int SETTINGS_REQUEST_CODE = 37;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inIt();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.settings) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivityForResult(intent, SETTINGS_REQUEST_CODE);
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SETTINGS_REQUEST_CODE && data != null
                && data.hasExtra(SettingsActivity.IMAGE_FILE_RESULT_KEY)) {
            File imageFile = (File) data.getSerializableExtra(SettingsActivity.IMAGE_FILE_RESULT_KEY);
            Bitmap bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
            imageView.setImageBitmap(bitmap);
        }
    }

    private void inIt() {

        imageView = findViewById(R.id.image);

        input = findViewById(R.id.result);

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
                double convertedInput = -inputDouble;
                input.setText("" + convertedInput);
            }
        });
    }
}