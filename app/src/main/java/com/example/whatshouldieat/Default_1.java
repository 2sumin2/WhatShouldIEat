package com.example.whatshouldieat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.whatshouldieat.MainActivity.sub;

public class Default_1 extends AppCompatActivity {



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
        setContentView(R.layout.default_1);

        String selection = sharedPreferences.getString("selection", "");

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

        TextView tv = findViewById(R.id.selection);
        tv.setTag(selection);

    }//end of onCreate


    public void select1 (View v) {

        //getSharedPreferences(String name, int mode)
        SharedPreferences sharedPreferences = getSharedPreferences("shared", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String selection = sharedPreferences.getString("selection", "");

        String tag = (String) v.getTag();
        editor.putString("selection1", tag); //tag 값 저장

        TextView tv = findViewById(R.id.selection);
        tv.setTag(v.getTag() + tag);



        editor.commit();

        if(selection.equals("1")) { //이 전의 창에서 클린한 텍스트가 "무거운 한끼"라면

            Intent intent = new Intent(getApplicationContext(), Default_2.class);//Default_2 로 intent
            startActivityForResult(intent, sub);
        }
        else if(selection.equals("2")){//이 전의 창에서 클린한 텍스트가 "가벼운 한끼"라면

            Intent intent = new Intent(getApplicationContext(), Default_3.class);//Default_3 로 intent
            startActivityForResult(intent, sub);
        }


    }//end of select

    public void back (View v) {

        finish();
    }

}