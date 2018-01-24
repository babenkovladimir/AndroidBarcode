package com.example.vladimirbabenko.barcode;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImageView;
    private Random mRandom;
    private EditText mEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
    }

    private void setupUI() {
        findViewById(R.id.btnBarcodeCreate).setOnClickListener(this);
        findViewById(R.id.btnBarcodGenerate).setOnClickListener(this);
        mImageView = findViewById(R.id.imageViewBarCode);
        mEditText = findViewById(R.id.etData);
    }

    @Override
    public void onClick(View v) {
        String data;

        switch (v.getId()) {
            case (R.id.btnBarcodeCreate):
                data = mEditText.getText().toString();

                if (String.valueOf(data).isEmpty()) {
                    mEditText.setText("empty");
                    data = "empty";
                }
                break;
            case (R.id.btnBarcodGenerate):
                mRandom = new Random();
                data = Integer.toString(mRandom.nextInt(10000000));
                mEditText.setText(data);
                break;
            default:
                throw new RuntimeException();
        }

        Bitmap barcodeBitmap = BarcodeGenerator.getGeneratedBarcode(data, BarcodeFormat.QR_CODE, 300, 300);
        mImageView.setImageBitmap(barcodeBitmap);

    }
}
