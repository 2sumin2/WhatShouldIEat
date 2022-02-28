package com.example.whatshouldieat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.whatshouldieat.MainActivity.sub;


public class Default_3 extends AppCompatActivity {

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
        setContentView(R.layout.default_3);

        String selection1 = sharedPreferences.getString("selection1", "");

        TextView tv = findViewById(R.id.selection);
        tv.setTag(selection1);

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

    public void select3 (View v) {

        //getSharedPreferences(String name, int mode)
        SharedPreferences sharedPreferences = getSharedPreferences("shared", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        String selection = sharedPreferences.getString("selection1", "");
        String tag = (String) v.getTag();
        editor.putString("selection3", tag); //tag 값 저장

        editor.commit();


        if(selection.equals("1")) { //이 전의 창에서 클린한 텍스트가 "무거운 한끼"라면


            if (v.getTag().equals("1")) {
                Intent intent = new Intent(getApplicationContext(), Default_3_0.class);
                startActivityForResult(intent, sub);
            } else if (v.getTag().equals("2")) {
                Intent intent = new Intent(getApplicationContext(), Default_3_1.class);
                startActivityForResult(intent, sub);
            }
        }
        else if(selection.equals("2")){//이 전의 창에서 클린한 텍스트가 "가벼운 한끼"라면
                if(v.getTag().equals("1")){
                    Intent intent = new Intent(getApplicationContext(), Default_3_2.class);
                    startActivityForResult(intent, sub);
                }
                else if(v.getTag().equals("2")){
                    Intent intent = new Intent(getApplicationContext(), Default_3_0.class);
                    startActivityForResult(intent, sub);
                }
        }
    }
    public void back (View v) {

        finish();
    }

}
