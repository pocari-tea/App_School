package com.example.startingpokemon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Switch onoff;
    RadioButton rb1, rb2, rb3;
    ImageView iv1, iv2, iv3;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onoff = (Switch)findViewById(R.id.onoff);
        rb1 = (RadioButton)findViewById(R.id.rb1);
        rb2 = (RadioButton)findViewById(R.id.rb2);
        rb3 = (RadioButton)findViewById(R.id.rb3);

        rg = (RadioGroup)findViewById(R.id.rg);

        iv1 = (ImageView)findViewById(R.id.iv1);
        iv2 = (ImageView)findViewById(R.id.iv2);
        iv3 = (ImageView)findViewById(R.id.iv3);

        onoff.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (onoff.isChecked()) {
                    rg.setVisibility(View.INVISIBLE);

                    iv1.setVisibility(View.INVISIBLE);
                    iv2.setVisibility(View.INVISIBLE);
                    iv3.setVisibility(View.INVISIBLE);
                }
                else{
                    rg.setVisibility(View.GONE);

                    iv1.setVisibility(View.GONE);
                    iv2.setVisibility(View.GONE);
                    iv3.setVisibility(View.GONE);
                }
            }
        });

        rb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(rb1.isChecked()){
                    iv1.setVisibility(View.VISIBLE);
                    iv2.setVisibility(View.GONE);
                    iv3.setVisibility(View.GONE);
                }
                else {
                    iv1.setVisibility(View.GONE);
                }
            }
        });

        rb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(rb2.isChecked()){
                    iv1.setVisibility(View.GONE);
                    iv2.setVisibility(View.VISIBLE);
                    iv3.setVisibility(View.GONE);
                }
                else {
                    iv1.setVisibility(View.GONE);
                }
            }
        });

        rb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(rb3.isChecked()){
                    iv1.setVisibility(View.GONE);
                    iv2.setVisibility(View.GONE);
                    iv3.setVisibility(View.VISIBLE);
                }
                else {
                    iv1.setVisibility(View.GONE);
                }
            }
        });
    }
}
