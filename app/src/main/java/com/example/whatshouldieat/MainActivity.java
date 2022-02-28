package com.example.whatshouldieat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int sub = 1001;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //id가 change인 Tag에 data값(기본설정의 옵션 값) 불러와서 저장하기!
        SharedPreferences sharedPreferences = getSharedPreferences("shared", MODE_PRIVATE);
        String color = sharedPreferences.getString("color", "");
        TextView textview_2 = findViewById(R.id.color);
        TextView textview = findViewById(R.id.change);
        String data = sharedPreferences.getString("data", "");

        if(data.equals("")){
            data = "1";
        }
        textview.setTag(data);

        if(color.equals("")){
            color = "1";
        }
        textview_2.setTag(color);

        ImageView iv = findViewById(R.id.pink);
        ImageView iv_2 = findViewById(R.id.blue);
        if(color.equals("1")){
            iv.setVisibility(View.VISIBLE);
            iv_2.setVisibility(View.GONE);
        }
        if(color.equals("2")){
            iv_2.setVisibility(View.VISIBLE);
            iv.setVisibility(View.GONE);
        }



        //첫 화면 클릭했을 떄, 기본설정에 옵션값에 해당하는 메인화면으로 넘어가기!--------------------------
        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getTag().equals("1")) {//클린한 뷰의 Tag값이 1이면
                    Intent intent = new Intent(getApplicationContext(), Default_Main.class);
                    startActivityForResult(intent, sub);//'기본값' 액티비티 띄우기
                }
                else if(v.getTag().equals("2")){//클린한 뷰의 Tag값이 2이면
                    Intent intent = new Intent(getApplicationContext(),Vegetable_Main.class);
                    startActivityForResult(intent,sub);//'채식' 액티비티 띄우기
                }
                else if(v.getTag().equals("3")){//클린한 뷰의 Tag값이 3이면
                    Intent intent = new Intent(getApplicationContext(),Diet_Main.class);
                    startActivityForResult(intent,sub);//'다이어트' 액티비티 띄우기
                }
            }
        });
    }   //end of onCreate

    public void displaySetting(View v) {    //설정 창 열기------------------------------------------
        //int id = v.getId();
        //LinearLayout layout = (LinearLayout)v.findViewById(id);
        Intent intent = new Intent(getApplicationContext(),Setting.class);
        startActivityForResult(intent,sub);
    }   //end of displaySetting

}   //end of MainActivity
