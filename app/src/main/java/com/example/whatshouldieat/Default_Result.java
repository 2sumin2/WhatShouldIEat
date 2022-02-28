package com.example.whatshouldieat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import static com.example.whatshouldieat.MainActivity.sub;

public class Default_Result extends AppCompatActivity {

    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences("shared", MODE_PRIVATE);
        String color = sharedPreferences.getString("color", "");
        if(color.equals("1")){
            setTheme(R.style.AppTheme);
        }
        if(color.equals("2")){
            setTheme(R.style.AppTheme2);
        }
        setContentView(R.layout.default_result);

        ImageView iv_1 = findViewById(R.id.backpink);
        ImageView iv_2 = findViewById(R.id.backblue);
        if(color.equals("1")){
            iv_1.setVisibility(View.VISIBLE);
            iv_2.setVisibility(View.GONE);
        }
        if(color.equals("2")){
            iv_2.setVisibility(View.VISIBLE);
            iv_1.setVisibility(View.GONE);
        }
        String value = sharedPreferences.getString("value", "");

        //result_text에 글자출력----------------------------------------------------------------------------------------------
        String result = "";


        if(value.equals("1111")){
            result = "무거운 한끼 식사로 빨갛고 국물 있는 밥도둑 음식";
            layout = (LinearLayout) findViewById(R.id.m_1);
            layout.setVisibility(View.VISIBLE);
        } //1
        else if(value.equals("1112")){
            result = "무거운 한끼 식사로 빨갛고 국물 있는 칼로리도둑 음식";
            layout = (LinearLayout) findViewById(R.id.m_2);
            layout.setVisibility(View.VISIBLE);}//2
        else if(value.equals("1121")){
            result = "무거운 한끼 식사로 빨갛고 국물 없는 밥도둑 음식";
            layout = (LinearLayout) findViewById(R.id.m_3);
            layout.setVisibility(View.VISIBLE);}//3
        else if(value.equals("1122")){
            result = "무거운 한끼 식사로 빨갛고 국물 없는 밥도둑 음식";
            layout = (LinearLayout) findViewById(R.id.m_4);
            layout.setVisibility(View.VISIBLE);}//4
        else if(value.equals("1211")){
            result = "무거운 한끼 식사로 안 빨갛고 국물 있는 밥도둑 음식";
            layout = (LinearLayout) findViewById(R.id.m_5);
            layout.setVisibility(View.VISIBLE);}//5
        else if(value.equals("1212")){
            result = "무거운 한끼 식사로 안 빨갛고 국물 있는 칼로리도둑 음식";
            layout = (LinearLayout) findViewById(R.id.m_6);
            layout.setVisibility(View.VISIBLE);}//6
        else if(value.equals("1221")){
            result = "무거운 한끼 식사로 안 빨갛고 국물 없는 밥도둑 음식";
            layout = (LinearLayout) findViewById(R.id.m_7);
            layout.setVisibility(View.VISIBLE);}//7
        else if(value.equals("1222")){
            result = "무거운 한끼 식사로 안 빨갛고 국물 없는 칼로리도둑 음식";
            layout = (LinearLayout) findViewById(R.id.m_8);
            layout.setVisibility(View.VISIBLE);}//8
        else if(value.equals("2111")){
            result = "가벼운 한끼 식사로 빨갛고 고기가 들어간 달달한 음식";
            layout = (LinearLayout) findViewById(R.id.m_9);
            layout.setVisibility(View.VISIBLE);}//9
        else if(value.equals("2112")){
            result = "가벼운 한끼 식사로 빨갛고 고기가 들어간 안 달달한 음식";
            layout = (LinearLayout) findViewById(R.id.m_10);
            layout.setVisibility(View.VISIBLE);}//10
        else if(value.equals("21211")){
            result = "가벼운 한끼 식사로 빨갛고 고기가 안 들어가고 면은 들어간 국물요리";
            layout = (LinearLayout) findViewById(R.id.m_11);
            layout.setVisibility(View.VISIBLE);}//11
        else if(value.equals("21212")){
            result = "가벼운 한끼 식사로 빨갛고 고기가 안 들어가고 면은 들어간 국물 없는 음식";
            layout = (LinearLayout) findViewById(R.id.m_12);
            layout.setVisibility(View.VISIBLE);}//12
        else if(value.equals("2122")){
            result = "가벼운 한끼 식사로 빨갛고 고기와 면이 안 들어간 음식";
            layout = (LinearLayout) findViewById(R.id.m_21);
            layout.setVisibility(View.VISIBLE);}//21
        else if(value.equals("22111")){
            result = "가벼운 한끼 식사로 안 빨갛고 육지 고기가 들어간 고기요리";
            layout = (LinearLayout) findViewById(R.id.m_13);
            layout.setVisibility(View.VISIBLE);}
        else if(value.equals("22112")){
            result = "가벼운 한끼 식사로 안 빨간 육지 고기";
            layout = (LinearLayout) findViewById(R.id.m_14);
            layout.setVisibility(View.VISIBLE);}
        else if(value.equals("22121")){
            result = "가벼운 한끼 식사로 안 빨갛고 고기가 들어간 물고기 음식";
            layout = (LinearLayout) findViewById(R.id.m_15);
            layout.setVisibility(View.VISIBLE);}
        else if(value.equals("22122")){
            result = "가벼운 한끼 식사로 안 빨갛고 고기가 들어간 해산물 음식";
            layout = (LinearLayout) findViewById(R.id.m_16);
            layout.setVisibility(View.VISIBLE);}
        else if(value.equals("22211")){
            result = "가벼운 한끼 식사로 안 빨갛고 고기가 안 들어간 달달한 빵";
            layout = (LinearLayout) findViewById(R.id.m_17);
            layout.setVisibility(View.VISIBLE);}
        else if(value.equals("22212")){
            result = "가벼운 한끼 식사로 안 빨갛고 고기가 안 들어간 달달한 디저트";
            layout = (LinearLayout) findViewById(R.id.m_18);
            layout.setVisibility(View.VISIBLE);}
        else if(value.equals("22221")){
            result = "가벼운 한끼 식사로 안 빨갛고 고기가 안 들어간 안 달달한 식사";
            layout = (LinearLayout) findViewById(R.id.m_19);
            layout.setVisibility(View.VISIBLE);}
        else if(value.equals("22222")){
            result = "가벼운 한끼 식사로 안 빨갛고 고기가 안 들어간 안 달달한 간식";
            layout = (LinearLayout) findViewById(R.id.m_20);
            layout.setVisibility(View.VISIBLE);}


        TextView text_1 = findViewById(R.id.result_text);
        text_1.setText(result + "을(를) 먹고싶다.");

    }//end of onCreate

    public void back(View v) {
        finish();
    }
    public void Main(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);//Default_1 로 intent
        startActivityForResult(intent, sub);
    }
    public void displayrandom (View v) {
        Intent intent = new Intent(getApplicationContext(), Default_Random.class);//Default_1 로 intent
        startActivityForResult(intent, sub);
    }
}
