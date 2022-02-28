package com.example.whatshouldieat;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import static com.example.whatshouldieat.MainActivity.sub;

public class Default_Random extends AppCompatActivity {

    ImageView iv_roulette;
    float startDegree = 0f;
    float endDegree = 0f;
    public int degree_rand;



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
        setContentView(R.layout.default_random);

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
        iv_roulette = (ImageView) findViewById(R.id.roulette);

        String value = sharedPreferences.getString("value", "");

        if (value.equals("1111")) {
            iv_roulette.setImageDrawable(getResources().getDrawable(R.drawable.r_1));
        } if (value.equals("1112")) {
            iv_roulette.setImageDrawable(getResources().getDrawable(R.drawable.r_2));
        } else if (value.equals("1121")) {
            iv_roulette.setImageDrawable(getResources().getDrawable(R.drawable.r_3));
        } else if (value.equals("1122")) {
            iv_roulette.setImageDrawable(getResources().getDrawable(R.drawable.r_4));
        } else if (value.equals("1211")) {
            iv_roulette.setImageDrawable(getResources().getDrawable(R.drawable.r_5));
        } else if (value.equals("1212")) {
            iv_roulette.setImageDrawable(getResources().getDrawable(R.drawable.r_6));
        } else if (value.equals("1221")) {
            iv_roulette.setImageDrawable(getResources().getDrawable(R.drawable.r_7));
        } else if (value.equals("1222")) {
            iv_roulette.setImageDrawable(getResources().getDrawable(R.drawable.r_8));
        } else if (value.equals("2111")) {
            iv_roulette.setImageDrawable(getResources().getDrawable(R.drawable.r_9));
        } else if (value.equals("2112")) {
            iv_roulette.setImageDrawable(getResources().getDrawable(R.drawable.r_10));
        } else if (value.equals("21211")) {
            iv_roulette.setImageDrawable(getResources().getDrawable(R.drawable.r_11));
        } else if (value.equals("21212")) {
            iv_roulette.setImageDrawable(getResources().getDrawable(R.drawable.r_12));
        } else if (value.equals("2122")) {
            iv_roulette.setImageDrawable(getResources().getDrawable(R.drawable.r_21));
        } else if (value.equals("22111")) {
            iv_roulette.setImageDrawable(getResources().getDrawable(R.drawable.r_13));
        } else if (value.equals("22112")) {
            iv_roulette.setImageDrawable(getResources().getDrawable(R.drawable.r_14));
        } else if (value.equals("22121")) {
            iv_roulette.setImageDrawable(getResources().getDrawable(R.drawable.r_15));
        } else if (value.equals("22122")) {
            iv_roulette.setImageDrawable(getResources().getDrawable(R.drawable.r_16));
        } else if (value.equals("22211")) {
            iv_roulette.setImageDrawable(getResources().getDrawable(R.drawable.r_17));
        } else if (value.equals("22212")) {
            iv_roulette.setImageDrawable(getResources().getDrawable(R.drawable.r_18));
        } else if (value.equals("22221")) {
            iv_roulette.setImageDrawable(getResources().getDrawable(R.drawable.r_19));
        } else if (value.equals("22222")) {
            iv_roulette.setImageDrawable(getResources().getDrawable(R.drawable.r_20));
        }
    }

    public void rotate(View v) {
        iv_roulette = (ImageView) findViewById(R.id.roulette);
        startDegree = endDegree;

        Random rand = new Random();
        degree_rand = rand.nextInt(360);
        endDegree = startDegree + 360 * 7 + degree_rand;

        ObjectAnimator object = ObjectAnimator.ofFloat(iv_roulette, "rotation", startDegree, endDegree);
        object.setInterpolator(new AccelerateDecelerateInterpolator());
        object.setDuration(5000);
        object.addListener(new Animator.AnimatorListener() {
            TextView tv = findViewById(R.id.result);
            TextView text_result = findViewById(R.id.re);
            TextView text = findViewById(R.id.blank);
            @Override
            public void onAnimationStart(Animator animation) { //룰렛이 동작하면 결과출력 뷰에 "result..."라고 출력하기
                tv.setText("과연 오늘의 운명은...");
                tv.setVisibility(View.VISIBLE);
                text_result.setVisibility(View.GONE);
            }
            @Override
            public void onAnimationEnd(Animator animation) {//룰렛의 동작이 끝나면

                TextView tv_roulette = findViewById(R.id.roulette_text);
                tv_roulette.setText("-결과가 마음에 안들면 다시 눌러봐!-");
                TextView goYoutube = findViewById(R.id.goYoutube);
                SharedPreferences sharedPreferences = getSharedPreferences("shared", MODE_PRIVATE);
                String value = sharedPreferences.getString("value", "");

                float degree = (float) startDegree + degree_rand;
                if (degree > 360) {
                    degree = degree % 360;
                }
                //룰렛의 결과----------------------------------------------------------------------------------------------------------------------
                if (value.equals("1111") || value.equals("2111") || value.equals("22111") || value.equals("22112") || value.equals("22122")) {
                    if (((degree >= 0) && (degree <= 36)) || ((degree > 324) && (degree <= 360))) {//항목이 5개인 룰렛
                        switch (value) {
                            case "1111":
                                text.setText("매운탕");
                                break;
                            case "2111":
                                text.setText("물회");
                                break;
                            case "22111":
                                text.setText("양꼬치");
                                break;
                            case "22112":
                                text.setText("육회");
                                break;
                            case "22122":
                                text.setText("감바스");
                                break;
                        }
                    } else if ((degree > 36) && (degree <= 108)) {
                        switch (value) {
                            case "1111":
                                text.setText("육개장");
                                break;
                            case "2111":
                                text.setText("닭꼬치");
                                break;
                            case "22111":
                                text.setText("햄버거");
                                break;
                            case "22112":
                                text.setText("막창");
                                break;
                            case "22122":
                                text.setText("대게");
                                break;
                        }
                    } else if ((degree > 108) && (degree <= 180)) {
                        switch (value) {
                            case "1111":
                                text.setText("김치찌개");
                                break;
                            case "2111":
                                text.setText("닭강정");
                                break;
                            case "22111":
                                text.setText("고기만두");
                                break;
                            case "22112":
                                text.setText("항정살");
                                break;
                            case "22122":
                                text.setText("킹크랩");
                                break;
                        }
                    } else if ((degree > 180) && (degree <= 252)) {
                        switch (value) {
                            case "1111":
                                text.setText("부대찌개");
                                break;
                            case "2111":
                                text.setText("소떡소떡");
                                break;
                            case "22111":
                                text.setText("육포");
                                break;
                            case "22112":
                                text.setText("대창");
                                break;
                            case "22122":
                                text.setText("성게");
                                break;
                        }
                    } else if ((degree > 252) && (degree <= 324)) {
                        switch (value) {
                            case "1111":
                                text.setText("순두부찌개");
                                break;
                            case "2111":
                                text.setText("닭발");
                                break;
                            case "22111":
                                text.setText("닭꼬치");
                                break;
                            case "22112":
                                text.setText("곱창");
                                break;
                            case "22122":
                                text.setText("조개구이");
                                break;
                        }
                    }
                } //항목이 5개인 룰렛의 if문 종료-------------------------------------------------------------------------------------------------------------
                else if (value.equals("1112") || value.equals("1121") || value.equals("1211") || value.equals("2112") || value.equals("22121") || value.equals("22222")) {
                    if (((degree >= 0) && (degree <= 90))) {//항목이 4개인 룰렛
                        switch (value) {
                            case "1112":
                                text.setText("훠궈");
                                break;
                            case "1121":
                                text.setText("쭈꾸미 삼겹살");
                                break;
                            case "1211":
                                text.setText("순대국");
                                break;
                            case "22121":
                                text.setText("회");
                                break;
                            case "2112":
                                text.setText("하몽");
                                break;
                            case "22222":
                                text.setText("감자전");
                                break;
                        }
                    } else if ((degree > 90) && (degree <= 180)) {
                        switch (value) {
                            case "1112":
                                text.setText("국물떡볶이");
                                break;
                            case "1121":
                                text.setText("닭갈비");
                                break;
                            case "1211":
                                text.setText("오리백숙");
                                break;
                            case "22121":
                                text.setText("장어");
                                break;
                            case "2112":
                                text.setText("양꼬치");
                                break;
                            case "22222":
                                text.setText("타코야끼");
                                break;
                        }
                    } else if ((degree > 180) && (degree <= 270)) {
                        switch (value) {
                            case "1112":
                                text.setText("물회");
                                break;
                            case "1121":
                                text.setText("두루치기");
                                break;
                            case "1211":
                                text.setText("삼계탕");
                                break;
                            case "22121":
                                text.setText("초밥");
                                break;
                            case "2112":
                                text.setText("닭꼬치");
                                break;
                            case "22222":
                                text.setText("만두");
                                break;
                        }
                    } else if ((degree > 270) && (degree <= 360)) {
                        switch (value) {
                            case "1112":
                                text.setText("라면");
                                break;
                            case "1121":
                                text.setText("김치찜");
                                break;
                            case "1211":
                                text.setText("된장찌개");
                                break;
                            case "22121":
                                text.setText("갈치구이");
                                break;
                            case "2112":
                                text.setText("닭발");
                                break;
                            case "22222":
                                text.setText("샌드위치");
                                break;
                        }
                    }
                    } //항목이 4개인 룰렛의 if문 종료-------------------------------------------------------------------------------------------------------
                    else if (value.equals("1122") || value.equals("21211") || value.equals("21212")) {
                        if (((degree >= 0) && (degree <= 120))) {//항목이 3개인 룰렛
                            switch (value) {
                                case "1122":
                                    text.setText("김치볶음밥");
                                    break;
                                case "21211":
                                    text.setText("해물칼국수");
                                    break;
                                case "21212":
                                    text.setText("비빔국수");
                                    break;
                            }
                        } else if ((degree > 120) && (degree <= 240)) {
                            switch (value) {
                                case "1122":
                                    text.setText("떡볶이");
                                    break;
                                case "21211":
                                    text.setText("라볶이");
                                    break;
                                case "21212":
                                    text.setText("비빔면");
                                    break;
                            }
                        } else if ((degree > 240) && (degree <= 360)) {
                            switch (value) {
                                case "1122":
                                    text.setText("제육덮밥");
                                    break;
                                case "21211":
                                    text.setText("컵라면");
                                    break;
                                case "21212":
                                    text.setText("쫄면");
                                    break;
                            }
                        }
                    } //항목이 3개인 룰렛의 if문 종료-----------------------------------------------------------------------------------------
                    if (value.equals("1212") || value.equals("1221") || value.equals("1222") || value.equals("2122") || value.equals("22211")|| value.equals("22212")|| value.equals("22221")) {
                        if (((degree >= 0) && (degree <= 60))) {//항목이 6개인 룰렛
                            switch (value) {
                                case "1212": text.setText("쌀국수"); break;
                                case "1221": text.setText("보쌈"); break;
                                case "1222": text.setText("쌈밥"); break;
                                case "2122":  text.setText("떡꼬치");  break;
                                case "22211": text.setText("도넛"); break;
                                case "22212": text.setText("쿠키"); break;
                                case "22221": text.setText("샐러드"); break;
                            }

                        } else if ((degree > 60) && (degree <= 120)) {
                            switch (value) {
                                case "1212": text.setText("잔치국수"); break;
                                case "1221": text.setText("갈비찜"); break;
                                case "1222": text.setText("파스타"); break;
                                case "2122":  text.setText("김치전");  break;
                                case "22211": text.setText("호빵"); break;
                                case "22212": text.setText("마카롱"); break;
                                case "22221": text.setText("죽"); break;
                            }
                        } else if ((degree > 120) && (degree <= 180)) {
                            switch (value) {
                                case "1212": text.setText("샤브샤브"); break;
                                case "1221": text.setText("카레라이스"); break;
                                case "1222": text.setText("햄버거"); break;
                                case "2122":  text.setText("홍합탕");  break;
                                case "22211": text.setText("붕어빵"); break;
                                case "22212": text.setText("호떡"); break;
                                case "22221": text.setText("딤섬"); break;
                            }
                        } else if ((degree > 180) && (degree <= 240)) {
                            switch (value) {
                                case "1212": text.setText("소바"); break;
                                case "1221": text.setText("탕수육"); break;
                                case "1222": text.setText("짜장면"); break;
                                case "2122":  text.setText("떡볶이");  break;
                                case "22211": text.setText("토스트"); break;
                                case "22212": text.setText("와플"); break;
                                case "22221": text.setText("김밥"); break;
                            }
                        } else if ((degree > 240) && (degree <= 300)) {
                            switch (value) {
                                case "1212": text.setText("우동"); break;
                                case "1221": text.setText("돈가스"); break;
                                case "1222": text.setText("치킨"); break;
                                case "2122":  text.setText("두부김치");  break;
                                case "22211": text.setText("케이크"); break;
                                case "22212": text.setText("빙수"); break;
                                case "22221": text.setText("만두"); break;
                            }
                        }else if ((degree > 300) && (degree <= 360)) {
                            switch (value) {
                                case "1212": text.setText("국밥"); break;
                                case "1221": text.setText("삼겹살"); break;
                                case "1222": text.setText("스테이크"); break;
                                case "2122":  text.setText("떙초김밥");  break;
                                case "22211": text.setText("빵"); break;
                                case "22212": text.setText("아이스크림"); break;
                                case "22221": text.setText("샌드위치"); break;
                            }
                        }

                    }//항목이 6개인 룰렛의 if문 종료-----------------------------------------------------------------------------------------
                text_result.setVisibility(View.VISIBLE);
                tv.setVisibility(View.GONE);
                text_result.setText("오늘은 '" +text.getText()+"' (이)다~!");
                goYoutube.setVisibility(View.VISIBLE);
                }//end of onAnimationEnd
                @Override
                public void onAnimationCancel (Animator animation){
                }//end of onAnimationCancel
                @Override
                public void onAnimationRepeat (Animator animation){
                }//end of onAnimationRepeat

        });// end of addListener
        object.start();

    }//end of rotate
    public void back(View v) {
        finish();
    }
    public void Main(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);//Default_1 로 intent
        startActivityForResult(intent, sub);
    }
/*
    public void youtube(View v) {
        startActivity(new Intent(Intent.ACTION_VIEW)
                .setData(Uri.parse("https://www.youtube.com"))
                .setPackage("com.google.android.youtube"));
    }

 */
        public void youtube(View v) {
            TextView text = findViewById(R.id.blank);
            String str = (text.getText()+" 만드는 법");
            Intent intent = new Intent(Intent.ACTION_SEARCH);
            intent.setPackage("com.google.android.youtube");
            intent.putExtra("query", str);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

}// end of Default_Random


