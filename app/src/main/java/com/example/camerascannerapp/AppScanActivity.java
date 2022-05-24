package com.example.camerascannerapp;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.style.IconMarginSpan;
import android.widget.ImageView;

import com.zynksoftware.documentscanner.ScanActivity;
import com.zynksoftware.documentscanner.model.DocumentScannerErrorModel;
import com.zynksoftware.documentscanner.model.ScannerResults;
import com.zynksoftware.documentscanner.ui.DocumentScanner;

import java.io.File;

public class AppScanActivity extends ScanActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_scan);
        imageView = findViewById(R.id.imageView);
        DocumentScanner.Configuration configuration = new DocumentScanner.Configuration();
        configuration.setImageQuality(100);
        configuration.setImageSize(1000000);
        configuration.setImageType(Bitmap.CompressFormat.JPEG);
        DocumentScanner documentScanner = DocumentScanner.INSTANCE;
        documentScanner.init(this,configuration);
        addFragmentContentLayout();
    }

    @Override
    public void onClose() {
        finish();
    }

    @Override
    public void onError(DocumentScannerErrorModel documentScannerErrorModel) {

    }

    @Override
    public void onSuccess(ScannerResults scannerResults) {
        File imageFile = scannerResults.getCroppedImageFile();
        imageView.setImageURI(Uri.fromFile(imageFile));
    }
}