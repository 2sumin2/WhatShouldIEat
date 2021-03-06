package com.example.whatshouldieat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.whatshouldieat.MainActivity.sub;

public class Default_4_0 extends AppCompatActivity {

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
        setContentView(R.layout.default_4_0);


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
    public void select4_0 (View v) {
        SharedPreferences sharedPreferences = getSharedPreferences("shared", MODE_PRIVATE);
        String selection = sharedPreferences.getString("selection", "");
        String selection1 = sharedPreferences.getString("selection1", "");
        String selection3 = sharedPreferences.getString("selection3", "");
        String selection3_1 = sharedPreferences.getString("selection3_1", "");

        String value4_0 = selection + selection1 + selection3 + selection3_1 + v.getTag();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("value", value4_0);

        editor.commit();//??????

        Intent intent = new Intent(getApplicationContext(), Default_Result.class);//??????
        startActivityForResult(intent, sub);//??????
    }
    public void back (View v) {

        finish();
    }
}