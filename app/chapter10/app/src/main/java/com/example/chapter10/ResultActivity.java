package com.example.chapter10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("정답 집개 결과");

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("voteNums");

        TextView tv[] = new TextView[voteResult.length];
        Integer tvId[] = {R.id.choice1, R.id.choice2, R.id.choice3, R.id.choice4, R.id.choice5};

        for (int i = 0; i < tv.length; i++)
        {
            tv[i] = (TextView)findViewById(tvId[i]);
            String str = String.valueOf(voteResult[i]);
            tv[i].setText(str);
        }
    }
}
