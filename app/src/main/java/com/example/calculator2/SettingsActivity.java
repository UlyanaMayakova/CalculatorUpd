package com.example.calculator2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class SettingsActivity extends AppCompatActivity {

    public static final int WRITE_REQUEST_CODE = 78;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        int permissionStatus = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permissionStatus == PackageManager.PERMISSION_GRANTED) {
            inIt();
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    WRITE_REQUEST_CODE);
        }
    }

    private void inIt() {
        if (isExternalStorageReadable()) {
            EditText pictureName = findViewById(R.id.picture_name);
            final String picNameStr = pictureName.toString();
            Button ok = findViewById(R.id.ok_button);

            ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    File pic = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                            picNameStr);
                    setBackground(pic);
                }
            });
        }
    }

    private void setBackground(File pic) {
        if (pic.exists()) {
            Bitmap bitmap = BitmapFactory.decodeFile(pic.getAbsolutePath());
            ImageView imageView = findViewById(R.id.image);
            imageView.setImageBitmap(bitmap);
            finish();
        } else {
            Toast.makeText(this, "Картинка с таким именем не найдена", Toast.LENGTH_LONG).show();
        }
    }

    private boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    public void onRequestPermissionResult(int requestCode, String[] permissions,
                                          int[] grantedResults) {
        if (requestCode == WRITE_REQUEST_CODE) {
            if (grantedResults.length > 0 &&
                    grantedResults[0] == PackageManager.PERMISSION_GRANTED) {
                inIt();
            } else {
                Toast.makeText(this, "Невозможно загрузить информацию без разрешения",
                        Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }
}