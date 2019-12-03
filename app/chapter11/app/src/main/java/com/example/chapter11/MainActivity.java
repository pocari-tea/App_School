package com.example.chapter11;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button callBtn, webBtn, cameraBtn, mapBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callBtn = (Button)findViewById(R.id.callBtn);
        webBtn = (Button)findViewById(R.id.webBtn);
        mapBtn = (Button)findViewById(R.id.mapBtn);
        cameraBtn = (Button)findViewById(R.id.cameraBtn);

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 암시적(묵시적) 인텐트
                Intent callIntent =
                        new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0629496881"));
                startActivity(callIntent);
            }
        });

        webBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webUri = Uri.parse("https://www.gsm.hs.kr");
                Intent webIntent =
                        new Intent(Intent.ACTION_VIEW, webUri);
                startActivity(webIntent);
            }
        });

        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri mapUri = Uri.parse("http://maps.google.com/maps?q="
                        + "광주소프트웨어마이스터고등학교");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW,
                        mapUri);
                startActivity(mapIntent);
            }
        });


        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE);
                startActivity(cameraIntent);
            }
        });
    }
}
