package com.example.practice02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AActivity extends Activity {

    TextView tv;
    EditText et;
    Button btn_send, btn_get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        tv = (TextView)findViewById(R.id.A_tv);
        et = (EditText)findViewById(R.id.send_A);
        btn_send = (Button)findViewById(R.id.send_btn_A);
        btn_get = (Button)findViewById(R.id.get_btn_A) ;

        Intent intent = getIntent();
        String str = intent.getStringExtra("sendData");
        tv.setText(str);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent
                        (getApplicationContext(), BActivity.class);
                intent.putExtra("sendData", et.getText().toString());
                // 양방향으로 하고싶을 때 이 부분을 다른 메소드를 사용
                // startActivityForResult(인텐트, 응답코드: -1 이상 아무숫자)
                startActivityForResult(intent, 0);
            }
        });

        btn_get.setOnClickListener(new View.OnClickListener() {
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

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK){
            //To-do Code
            String str = data.getStringExtra("outData");
            Toast.makeText(getApplicationContext(),
                    str, Toast.LENGTH_LONG).show();
        }
    }
}
