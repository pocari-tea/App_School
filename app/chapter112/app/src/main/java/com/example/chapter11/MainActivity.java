package com.example.chapter11;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et =(EditText)findViewById(R.id.sendToSecondString);
        btn = (Button)findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent
                        (getApplicationContext(), dualactivity.class);
                intent.putExtra("sendData", et.getText().toString());
                // 양방향으로 하고싶을 때 이 부분을 다른 메소드를 사용
                // startActivityForResult(인텐트, 응답코드: -1 이상 아무숫자)
                startActivityForResult(intent, 0);
            }
        });
    }

    // onActivityResult라는 메소드가 필요함. 메소드 오버라이딩
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK){
            //To-do Code
            String str = data.getStringExtra("outData");
            Toast.makeText(getApplicationContext(),
                    str, Toast.LENGTH_LONG).show();
        }
    }
}
