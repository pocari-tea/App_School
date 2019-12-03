package com.cookandroid.jjapkaotalk;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout myLayout, friendLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLayout = (LinearLayout)findViewById(R.id.me);
        friendLayout = (LinearLayout)findViewById(R.id.friend);

        registerForContextMenu(friendLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater minf = getMenuInflater();
        minf.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v == friendLayout) {
            MenuInflater contextMenuInf = getMenuInflater();
            contextMenuInf.inflate(R.menu.context_menu, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        super.onContextItemSelected(item);
        switch(item.getItemId()) {
            case R.id.favorite:
                // 2. 대화상자를 커스터마이징하여서 연결시켜주기
                // 특정한 레이아웃을 따로 만들어서 대화상자에 이식?
                AlertDialog.Builder favorDialog = new AlertDialog.Builder(MainActivity.this);
                final View favorLayout = (View)View.inflate(MainActivity.this,R.layout.favorite_alert_dialog,null);
                favorDialog.setTitle("커스텀 대화상자 실습");
                // setView매소드로 Layout을 대화상자에 이식
                favorDialog.setView(favorLayout);
                favorDialog.setNegativeButton("취소",null);
                favorDialog.setPositiveButton("변경", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText et = (EditText) favorLayout.findViewById(R.id.friendSangme);
                        TextView tv = (TextView) findViewById(R.id.friendSangme);
                        tv.setText(et.getText().toString());
                    }
                });
                favorDialog.show();
                return true;
            case R.id.delete:
                // 1. 대화상자를 띄워서 확실하게 지울지 말지 물어보기
                AlertDialog.Builder delDialog = new AlertDialog.Builder(MainActivity.this);
                delDialog.setMessage("진짜로 나 손절할꺼야?? 8ㅅ8");
                delDialog.setNegativeButton("취소",null);
                delDialog.setPositiveButton("응 너 손절", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        friendLayout.setVisibility(View.GONE);
                    }
                });
                delDialog.show();
                return true;
        }
        return false;
    }
}