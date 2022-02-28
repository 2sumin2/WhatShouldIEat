package com.example.whatshouldieat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.whatshouldieat.MainActivity.sub;

public class Diet_Main extends AppCompatActivity {

    public static final int sub = 1001;

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
        setContentView(R.layout.diet_main);
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
    public void dnext (View v){
        String value_d = (String) v.getTag();

        SharedPreferences sharedPreferences = getSharedPreferences("shared", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("value", value_d);

        editor.commit();

        Intent intent = new Intent(getApplicationContext(), Diet_Result.class);
        startActivityForResult(intent, sub);
    }
    public void back (View v) {

        finish();
    }
}
