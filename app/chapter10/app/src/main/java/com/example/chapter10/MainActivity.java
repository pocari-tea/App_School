package com.example.chapter10;

import android.app.Activity;
import android.content.Intent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("정답률 45%를 자랑하는 마의 문제 2번");

        final int voteCount[] = new int[5];
        for(int i = 0; i < voteCount.length; i++)
            voteCount[i] = 0;

        // 자주 써먹을 수 있으니 꼭 익혀두어야 한다.
        Button btn[] = new Button[5];
        Integer btnId[] = {R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5};
        Button resultBtn; // 이친구는 배열처리 안함

        // 버튼 연결과 클릭 리스너를 for문으로 간편하게 반복 등록
        for (int i = 0; i < btnId.length; i++)
        {
            final int index;
            index = i;
            btn[index] = (Button)findViewById(btnId[index]);
            btn[index].setOnClickListener(new View.OnClickListener(){
                public  void onClick(View view){
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),
                            (index+1)+"번을 답이라고 선택함",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
        resultBtn = (Button)findViewById(R.id.goToResultActivityBtn);
        resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    // 이 아래에 이제 내용물을 넘겨주는 코드 작성할 것
                intent.putExtra("voteNums", voteCount);
                startActivity(intent);
            }
        });

    }
}

//public class MainActivity extends Second_Activity {
//
//    Button goToAnotherActivity;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        goToAnotherActivity = (Button)findViewById(R.id.goToAnotherActivity);
//        goToAnotherActivity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Intent 액티비티를 불러들이는 등의
//                // 간단한 상호작용? 에 사용됨
//                // 4대 컴포넌트(액티빝, 서비스, 브리시버, 콘프로바이더)가
//                // 서로 데이터를 주고받기 위해 사용하는 메시지 객체
//                // 입력인자 두개 존재
//                // -> 컨텍스트? (문맥)
//                // 액티비티, 어플리케이션
//                // getApplicationContext() ≒ MainActivity.this
//                // 두 번째 입력 인자, 인텐트에 포함시킬 액티비티
//
//                Intent intent = new Intent(getApplicationContext(),Second_Activity.class);
//                startActivity(intent);
//            }
//        });
//    }
//}