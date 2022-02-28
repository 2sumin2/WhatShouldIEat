package com.example.whatshouldieat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.whatshouldieat.MainActivity.sub;

public class Default_3_1 extends AppCompatActivity {


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
        setContentView(R.layout.default_3_1);


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

    public void select3_1 (View v) {

        //getSharedPreferences(String name, int mode)
        SharedPreferences sharedPreferences = getSharedPreferences("shared", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String tag = (String) v.getTag();
        editor.putString("selection3_1", tag); //tag 값 저장

        editor.commit();

            if (v.getTag().equals("1")) {
                Intent intent = new Intent(getApplicationContext(), Default_4_0.class);
                startActivityForResult(intent, sub);
            }
            else if (v.getTag().equals("2")) {

                String selection = sharedPreferences.getString("selection", "");
                String selection1 = sharedPreferences.getString("selection1", "");
                String selection3 = sharedPreferences.getString("selection3", "");

                String value3_1 = selection + selection1 + selection3 + v.getTag();
                editor.putString("value", value3_1);

                editor.commit();//고정

                Intent intent = new Intent(getApplicationContext(), Default_Result.class);
                startActivityForResult(intent, sub);
            }
        }

    public void back (View v) {

        finish();
    }
}
