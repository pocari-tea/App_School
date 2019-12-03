package com.cookandroid.adapterviewexercise;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DynamicListView extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_listview);
        setTitle("동적 리스트 뷰 테스트");

        // (자료구조에서 배운!!!!)ArayList를 사용해서
        // add, remove <- 데이터를 자유롭게 추가 삭제
        final ArrayList<String> list = new ArrayList<String>();

        ListView listView = (ListView)findViewById(R.id.listView);

        // 어댑터를 사용.
        // 두 번째 파라미터: 리스트뷰의 형식
        // 세 번째 파라미터: 리스트뷰에 적용할 내용들 (ListView)
        final ArrayAdapter<String> adapter =
                new ArrayAdapter<String>( this,
                        android.R.layout.simple_list_item_1,
                        list);

        // 리스트뷰에 어댑터를 사용하겠다고 연결.
        listView.setAdapter(adapter);

        final EditText et = (EditText)findViewById(R.id.addItemText);
        Button addBtn = (Button)findViewById(R.id.addListViewBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add(et.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        // add()를 통해 listView에 포함된 친구들이
        // 각자 기능을 수행할 수 있도록 하기 위해서는
        // listview 객체의 Listner를 사용해야 합니다.

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // OnItemClick의 입력인자 중 int i <- 리스트 뷰의 순서 (position)
                Toast.makeText(getApplicationContext(),
                        (i+1) + "번째 리스트뷰 아이템이 선택됌",
                Toast.LENGTH_LONG).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long id) {
                final int index = i;
                AlertDialog.Builder dlg = new AlertDialog.Builder
                        (DynamicListView.this);
                dlg.setMessage((index+1) + "번째 리스트뷰의 아이템 " + "\n" + list.get(i).toString() + "제거할꺼야? ㅠㅠ");
                dlg.setNegativeButton("아니", null);
                dlg.setPositiveButton("응응", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        list.remove(index);
                        adapter.notifyDataSetChanged();
                    }
                });
                dlg.show();
                return false;
            }
        });
    }
}
