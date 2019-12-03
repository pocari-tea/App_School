package com.example.chapter07;

import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

// <실습 1> 옵션메뉴를 포함시키기 위해 Java 코딩에서 필요한 것
// 1. onCreateOptionsMenu() 메소드 ~ 오버라이딩
// 2. onOptionsItemSelected() 메소드 ~ 오버라이딩
// <실습 2> 컨텍스트메뉴 <- 특정한 위젯과 연동되는 메뉴
// 1. 특정한 위젯과 연동 하는 메소드
//    onCreate() 내부 위젯에 registerForContextMenu() 등록
// 2. onCreateContextMenu() 메소드 오버라딩
// 3. onContextItemSelected() 메소드 오버라이딩
// (<실습1>의 2.와 거의 유사함)
public class MainActivity extends AppCompatActivity {

    // 메뉴의 각 기능들을 선택했을 때 연동될 수 있도록...
    LinearLayout menuLayout;
    TextView menuTextView;
    Button menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuLayout = (LinearLayout)findViewById(R.id.baseLayout);
        menuTextView = (TextView)findViewById(R.id.textView);
        menuButton = (Button)findViewById(R.id.button);

        // <실습2> 부분의 1. 위젯과 컨텍스트메뉴 연결
        registerForContextMenu(menuButton);

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 대화상자(약간 팝업창같은것)를 하나 만들거에요
                AlertDialog.Builder popup = new AlertDialog.Builder(/*액티비티명.this*/MainActivity.this);
                popup.setTitle("대화상자의 제목");
                popup.setMessage("대화상자가 사용자에게 물어볼 내용부분");
                popup.setIcon(R.drawable.ic_launcher_foreground);
                // PositiveButton, NegativeButton의 입력 인자는 2개
                // 입력인자가 2개. 버튼의 표현되는 이름????, 리스너(동작 연결)
                popup.setPositiveButton("홬인",null);
                popup.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 자동완성된 다음의 내용을 다음과 같이 바꾼다.
        super.onCreateOptionsMenu(menu);

        // Inflater(인플레이터) ~ 부풀리게 하는 장치?!
        // xml로 정의된 View를 실제 객체화 시키는 용도
        // inflation - xml에 명시한 위젯(뷰)이 실제 위젯(뷰)
        // 으로 메모리에 형성되는 과정
        // MenuInflater, LayoutInflater 등이 존재
        MenuInflater mInf = getMenuInflater();

        //inflate ~ 부풀리기
        mInf.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // switch~case 문으로 각 메뉴의 기능을 연결함
        // switch(item.getItemId()){}
        switch(item.getItemId()) {
            case R.id.setBlack:
                // To-do 내가 실행할 기능을 쓰면 됨
                menuLayout.setBackgroundColor(Color.BLACK);
                // Toast 연습도 함께 해봅시다!
                // 간단하게 사용할 수 있는 메시지 상자
                Toast msg = Toast.makeText
                        (MainActivity.this
                                , "띄우고싶은 메시지"
                                , Toast.LENGTH_LONG);
                msg.show();
                // Toast.makeText(........).show();
                //
                return true;
            case R.id.setYourColor:
                menuLayout.setBackgroundColor
                        (Color.rgb(221, 221, 225));
                return true;
            case R.id.changeTV:
                menuTextView.setText("텍스트 바꿨따리~");
                return true;
            case R.id.changeBTN:
                menuButton.setScaleX(2);
                menuButton.setScaleY(2);
                return true;
        }
        return false;
    }

    // <실습2>의 두번째 부분
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        // 역시 자동 완성된 부분에 코드를 추가해서 사용
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater cmInf = getMenuInflater();
        if(v == menuButton) {
            cmInf.inflate(R.menu.btn_menu, menu);
            menu.setHeaderTitle("메뉴의 제목 설정 쌉가능");
        }
    }
}

//// MainActivity 기본 형태 복사본
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}