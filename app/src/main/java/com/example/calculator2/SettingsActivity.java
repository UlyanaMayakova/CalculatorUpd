package com.example.calculator2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class SettingsActivity extends AppCompatActivity {

    public static final int READ_REQUEST_CODE = 78;
    public static final String IMAGE_FILE_RESULT_KEY = "IMAGE_FILE_RESULT_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        int permissionStatus = ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE);
        if (permissionStatus == PackageManager.PERMISSION_GRANTED) {
            inIt();
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    READ_REQUEST_CODE);
        }
    }

    private void inIt() {
        if (isExternalStorageReadable()) {
            final EditText pictureName = findViewById(R.id.picture_name);
            Button ok = findViewById(R.id.ok_button);

            ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final String picNameStr = pictureName.getText().toString();
                    File pic = new File(Environment.getExternalStoragePublicDirectory(
                            Environment.DIRECTORY_DOWNLOADS), picNameStr);
                    setBackground(pic);
                }
            });
        }
    }

    private void setBackground(File pic) {
        if (pic.exists()) {
            setResult(RESULT_OK, new Intent().putExtra(IMAGE_FILE_RESULT_KEY, pic));
            finish();
        } else {
            Toast.makeText(this, "Картинка с таким именем не найдена", Toast.LENGTH_LONG).show();
        }
    }

    private boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == READ_REQUEST_CODE) {
            if (grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                inIt();
            } else {
                Toast.makeText(this, "Невозможно загрузить информацию без разрешения",
                        Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }
}