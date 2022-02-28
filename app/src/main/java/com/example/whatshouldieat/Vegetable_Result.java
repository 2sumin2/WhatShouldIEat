package com.example.whatshouldieat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.whatshouldieat.MainActivity.sub;

public class Vegetable_Result extends AppCompatActivity {
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
        setContentView(R.layout.vegetable_result);

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


        if(value.equals("1")){
            LinearLayout layout = (LinearLayout) findViewById(R.id.v_1);
            layout.setVisibility(View.VISIBLE);
        } else if(value.equals("2")){
            LinearLayout layout = (LinearLayout) findViewById(R.id.v_2);
            layout.setVisibility(View.VISIBLE);
        }
        else if(value.equals("3")){
            LinearLayout layout = (LinearLayout) findViewById(R.id.v_3);
            layout.setVisibility(View.VISIBLE);
        }else if(value.equals("4")){
            LinearLayout layout = (LinearLayout) findViewById(R.id.v_4);
            layout.setVisibility(View.VISIBLE);
        }
       }
    public void back(View v) {
        finish();
    }
    public void Main(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);//Default_1 로 intent
        startActivityForResult(intent, sub);
    }
}

