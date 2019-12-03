package com.example.practice02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BActivity extends Activity {

    TextView tv;
    EditText et;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        tv = (TextView)findViewById(R.id.B_tv);
        et = (EditText)findViewById(R.id.get_B);
        btn = (Button)findViewById(R.id.get_btn_B);

        Intent intent = getIntent();
        String str = intent.getStringExtra("sendData");
        tv.setText(str);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outIntent = new Intent
                        (getApplicationContext(), MainActivity.class);
                outIntent.putExtra("outData", et.getText().toString());
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}
