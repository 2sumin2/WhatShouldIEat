package com.example.whatshouldieat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.whatshouldieat.MainActivity.sub;

public class Default_3_0 extends AppCompatActivity {

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
        setContentView(R.layout.default_3_0);


        String selection3 = sharedPreferences.getString("selection3", "");

        TextView tv = findViewById(R.id.selection);
        tv.setTag(selection3);
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
    }//end of onCreate

    public void select3_0 (View v) {

        //getSharedPreferences(String name, int mode)
        SharedPreferences sharedPreferences = getSharedPreferences("shared", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        String selection3 = sharedPreferences.getString("selection3", "");

        String tag = (String) v.getTag();
        editor.putString("selection3_0", tag); //tag 값 저장

        editor.commit();


        if(selection3.equals("1")) { //이 전의 창에서 클린한 텍스트가 "무거운 한끼"라면

            String selection = sharedPreferences.getString("selection", ""); //Default_Main 선택값
            String selection1 = sharedPreferences.getString("selection1", ""); //Default_1 선택값

            String value3_0 = selection + selection1 + selection3 + v.getTag();

            editor.putString("value", value3_0);

            editor.commit();

            Intent intent = new Intent(getApplicationContext(), Default_Result.class);
            startActivityForResult(intent, sub);
        }
        else if(selection3.equals("2")){//이 전의 창에서 클린한 텍스트가 "가벼운 한끼"라면
            if(v.getTag().equals("1")){
                Intent intent = new Intent(getApplicationContext(), Default_4_3.class);
                startActivityForResult(intent, sub);
            }
            else if(v.getTag().equals("2")){
                Intent intent = new Intent(getApplicationContext(), Default_4_4.class);
                startActivityForResult(intent, sub);
            }
        }

    }
    public void back (View v) {

        finish();
    }
}
