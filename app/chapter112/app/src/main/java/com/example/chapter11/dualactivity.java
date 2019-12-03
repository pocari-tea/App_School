package com.example.chapter11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class dualactivity extends Activity {

    TextView tv;
    EditText et;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv = (TextView)findViewById(R.id.recieveFromMainString);
        et = (EditText)findViewById(R.id.sendToMainString);
        btn = (Button)findViewById(R.id.returnToMainBtn);

        Intent intent = getIntent();
        String str = intent.getStringExtra("sendData");
        tv.setText(str); // Main에서 넘겨받은 문장이 출력되겠죠

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 인텐트에 담아서 setResult()라는 메소드로 전송
                Intent outIntent = new Intent
                        (getApplicationContext(), MainActivity.class);
                outIntent.putExtra("outData", et.getText().toString());
                // 여기에 setResult()라는 메소드가 추가됨
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}
