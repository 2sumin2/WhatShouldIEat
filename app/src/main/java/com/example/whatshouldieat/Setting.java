package com.example.whatshouldieat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class Setting extends AppCompatActivity {

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
        setContentView(R.layout.setting);

        //data에 저장한 값 불러오기
        String data = sharedPreferences.getString("data", "");

        if(data.equals("1")){   //만약 data값이 1이면
            CheckBox checkBox = (CheckBox) findViewById(R.id.c2_1) ;
            checkBox.setChecked(true) ;
        }
        if(data.equals("2")){   //만약 data값이 2이면
            CheckBox checkBox = (CheckBox) findViewById(R.id.c2_2) ;
            checkBox.setChecked(true) ;
        }
        if(data.equals("3")){   //만약 data값이 3이면
            CheckBox checkBox = (CheckBox) findViewById(R.id.c2_2) ;
            checkBox.setChecked(true) ;
        }
        if(color.equals("1")){   //만약 data값이 1이면
            CheckBox checkBox = (CheckBox) findViewById(R.id.c3_1) ;
            checkBox.setChecked(true) ;
        }
        if(color.equals("2")){   //만약 data값이 2이면
            CheckBox checkBox = (CheckBox) findViewById(R.id.c3_2) ;
            checkBox.setChecked(true) ;
        }


    }//end of onCreate

    //클릭하면 레이아웃/텍스트뷰 보이기/숨기기------------------------------------------------------------
    public void clickc2(View v) {   //기본설정 클릭
        LinearLayout layout = (LinearLayout) findViewById(R.id.c1);
        if(layout.getVisibility() == View.GONE)     //보이기
        layout.setVisibility(View.VISIBLE);
        else if(layout.getVisibility() == View.VISIBLE)
        layout.setVisibility(View.GONE);        //숨기기
    }
    public void clickc3(View v) {   //테마 클릭
        LinearLayout layout = (LinearLayout) findViewById(R.id.c2);
        if(layout.getVisibility() == View.GONE)
            layout.setVisibility(View.VISIBLE);
        else if(layout.getVisibility() == View.VISIBLE)
            layout.setVisibility(View.GONE);
    }
    public void clickc4(View v) {   //플랫폼버전 클릭
        TextView tv = (TextView) findViewById(R.id.c3);
        if(tv.getVisibility() == View.GONE)
            tv.setVisibility(View.VISIBLE);
        else if(tv.getVisibility() == View.VISIBLE)
            tv.setVisibility(View.GONE);
    }


    //기본설정-------------------------------------------------------------------------------------------
    public void data(View v) {
        int id = v.getId();
        TextView tv = (TextView) v.findViewById(id);
        String tag = (String) tv.getTag();
        //getSharedPreferences(String name, int mode)
        SharedPreferences sharedPreferences = getSharedPreferences("shared", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //putString("어떤 key 값으로 저장", key에 입력할 데이터);
        editor.putString("data", tag);

        editor.commit();

        CheckBox checkBox_1 = (CheckBox) findViewById(R.id.c2_1) ;
        CheckBox checkBox_2 = (CheckBox) findViewById(R.id.c2_2) ;
        CheckBox checkBox_3 = (CheckBox) findViewById(R.id.c2_3) ;
        if(tag.equals("1")){   //만약 data값이 1이면
            checkBox_1.setChecked(true) ;
            checkBox_2.setChecked(false) ;
            checkBox_3.setChecked(false) ;
        }
        if(tag.equals("2")){   //만약 data값이 2이면
            checkBox_2.setChecked(true) ;
            checkBox_1.setChecked(false) ;
            checkBox_3.setChecked(false) ;
        }
        if(tag.equals("3")){   //만약 data값이 3이면
            checkBox_3.setChecked(true) ;
            checkBox_2.setChecked(false) ;
            checkBox_1.setChecked(false) ;
        }

    }
    public void color(View v){
        int id = v.getId();
        TextView tv = (TextView) v.findViewById(id);
        String tag = (String) tv.getTag();
        //getSharedPreferences(String name, int mode)
        SharedPreferences sharedPreferences = getSharedPreferences("shared", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //putString("어떤 key 값으로 저장", key에 입력할 데이터);
        editor.putString("color", tag);

        editor.commit();

        CheckBox checkBox_1 = (CheckBox) findViewById(R.id.c3_1) ;
        CheckBox checkBox_2 = (CheckBox) findViewById(R.id.c3_2) ;
        if(tag.equals("1")){   //만약 data값이 1이면
            checkBox_1.setChecked(true) ;
            checkBox_2.setChecked(false);
            setTheme(R.style.AppTheme);
        }
        if(tag.equals("2")){   //만약 data값이 2이면
            checkBox_2.setChecked(true) ;
            checkBox_1.setChecked(false) ;
            setTheme(R.style.AppTheme2);
        }
    }

    //설정아이콘 클릭하면 창 닫기----------------------------------------------------------------------
    public void closeSetting(View v) {
        Intent intent  = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }//end of displaySetting


}//end of MainActivity
