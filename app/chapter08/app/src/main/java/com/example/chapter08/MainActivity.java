package com.example.chapter08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText inputArea;
    Button read, write;
    TextView outputArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputArea = (EditText)findViewById(R.id.inputArea);
        read = (Button) findViewById(R.id.read);
        write = (Button) findViewById(R.id.write);
        outputArea = (TextView) findViewById(R.id.outputArea);

        // write 버튼을 눌렀을 때 setOnClickListener를 사용해서 파일 쓰기
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // FileInput(Output)Stream 이라는 클래스를 이용.
                try{
                    FileOutputStream outFs =
                            openFileOutput("file.txt", MODE_PRIVATE);
                    String str = inputArea.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                } catch (FileNotFoundException e) {
                    // 파일을 찾지 못했을 때의 예외처리 부분
                } catch (IOException e){
                    // 입출력에 대한 예외처리 부분
                }
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileInputStream inFs = openFileInput("file.txt");
                    // 버퍼랑 비슷... 한 번에 읽어들일 최대의 byte 수를 넣기
                    byte[] txt = new byte[3000];
                    inFs.read(txt);
                    String str = new String(txt);
                    outputArea.setText(str);
                } catch (FileNotFoundException e) {

                } catch (IOException e) {

                }
            }
        });
    }
}
