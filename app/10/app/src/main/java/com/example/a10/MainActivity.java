package com.example.a10;

import android.app.TabActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

// TabHost ~ extends TabActivity (탭액티비티기능상속)
// 약간 최신의 기능은 아니다보니 약한 경고가 발생
// 무시하기 위해서 아래의 명령어를 추가로 삽입

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabhost);

        // 1. XML 에서 생성한 탭 호스트를 연결한다.
        // 예약어로 탭호스트를 지정했기 때문에
        // (TabHost)findview... 하지 않아도 됨.
        TabHost th = getTabHost();

        // 2. 탭 위젯에 필요한 탭들을 등록하는 java코드부분
        // 3줄의 내용을 반복하여 등록 가능.
        TabHost.TabSpec redTab = th.newTabSpec("red").setIndicator("빨강탭");
        redTab.setContent(R.id.tab1);
        th.addTab(redTab);

        TabHost.TabSpec greenTab = th.newTabSpec("green").setIndicator("초록탭");
        greenTab.setContent(R.id.tab2);
        th.addTab(greenTab);

        TabHost.TabSpec blueTab = th.newTabSpec("blue").setIndicator("파랑탭");
        blueTab.setContent(R.id.tab3);
        th.addTab(blueTab);

        // 3. 탭 호스트를 액티비티에 띄움
        th.setCurrentTab(0);
    }


}