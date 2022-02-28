package com.example.whatshouldieat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.whatshouldieat.MainActivity.sub;

public class Default_4_2 extends AppCompatActivity {

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
        setContentView(R.layout.default_4_2);


        String selection3_1 = sharedPreferences.getString("selection3_1", "");

        TextView tv = findViewById(R.id.selection);
        tv.setTag(selection3_1);

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
    public void select4_2 (View v) {
        SharedPreferences sharedPreferences = getSharedPreferences("shared", MODE_PRIVATE);
        String selection = sharedPreferences.getString("selection", ""); //Default_Main 선택값
        String selection1 = sharedPreferences.getString("selection1", ""); //Default_1 선택값
        String selection3 = sharedPreferences.getString("selection3", ""); //Default_3 선택값
        String selection3_2 = sharedPreferences.getString("selection3_2", ""); //Default_3_2 선택값

        String value4_2 = selection + selection1 + selection3 + selection3_2 + v.getTag();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("value", value4_2);

        editor.commit();

        Intent intent = new Intent(getApplicationContext(), Default_Result.class);
        startActivityForResult(intent, sub);
    }
    public void back (View v) {

        finish();
    }
}
