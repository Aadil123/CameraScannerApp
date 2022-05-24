package com.example.camerascannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.zynksoftware.documentscanner.ui.DocumentScanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DocumentScanner.Configuration configuration = new DocumentScanner.Configuration();
        configuration.setImageQuality(100);
        configuration.setImageSize(1000000);
        configuration.setImageType(Bitmap.CompressFormat.JPEG);
        DocumentScanner documentScanner = DocumentScanner.INSTANCE;
        documentScanner.init(this,configuration);
        startActivity(new Intent(this,AppScanActivity.class));
    }
}