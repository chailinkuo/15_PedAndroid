package com.example.firstohm_yu.newproject;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.AnimatedImageDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.GestureDetectorCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;
public final class getcolor  extends Activity {
    public static void sendMessage(Message message, View view){
        clolr.handleMessage(message);
    }
    static final Handler clolr = new Handler() {
        public void handleMessage(Message msg1, View view) {
            super.handleMessage(msg1);
            int mcolor_Black = Color.parseColor("#000000"); //黑
            int mcolor_Brown = Color.parseColor("#993300"); //棕
            int mcolor_Red = Color.parseColor("#FF0000"); //紅
            int mcolor_Orange = Color.parseColor("#FFB300"); //橙
            int mcolor_Yellow = Color.parseColor("#FFFF00"); //黃
            int mcolor_Green = Color.parseColor("#009900"); //綠
            int mcolor_Blue = Color.parseColor("#0000FF"); //藍
            int mcolor_Purple = Color.parseColor("#9900FF"); //藍
            int mcolor_Gray = Color.parseColor("#999999"); //灰
            int mcolor_White = Color.parseColor("#FFFFFF"); //白
            int mcolor_Gold = Color.parseColor("#FFCC00"); //金
            int mcolor_Silver = Color.parseColor("#CCCCCC"); //銀

            int rcolor_blue = Color.parseColor("#9900FF"); //7921 藍色B
            int rcolor_ag = Color.parseColor("#9BFFAA"); //蘋果綠
            int rcolor_bred = Color.parseColor("#FFBEBE"); //磚紅
            int rcolor_mblue = Color.parseColor("#64A6CE"); //MO 藍色
            int rcolor_purple = Color.parseColor("#CC99CC"); //紫色
            int rcolor_mp106 = Color.parseColor("#FACCBA"); //MP106 粉紅
            int rcolor_gd = Color.parseColor("#73AD8F"); //金屬 墨綠
            int rcolor_mp1062 = Color.parseColor("#FFBEBE"); //內 MP106    外 磚紅
            int rcolor_green = Color.parseColor("#4B854B"); //綠色
            int rcolor_my = Color.parseColor("#E8D296"); //碳膜 乳黃
            int rcolor_cm02my = Color.parseColor("#FFE0A0"); //CM02 碳膜乳黃
            int rcolor_pa = Color.parseColor("#FFCCAF"); //粉紅A
            int rcolor_mm02 = Color.parseColor("#1E82C8"); //MM02 藍色A
            int rcolor_106b = Color.parseColor("#FACCBA"); //MP106 粉紅B
            int rcolor_pink = Color.parseColor("#ff60af"); //MP106 粉紅BImageView bg=(ImageView)findViewById(R.id.imageView);
            ImageView bg2=(ImageView)view.findViewById(R.id.imageView);
            ImageView bg=(ImageView)view.findViewById(R.id.imageView2);
            ImageView color_left=(ImageView)view.findViewById(R.id.color_left);
            ImageView color_left2=(ImageView)view.findViewById(R.id.color_left2);
            ImageView color_left3=(ImageView)view.findViewById(R.id.color_left3);
            ImageView color_right=(ImageView)view.findViewById(R.id.color_right);
            ImageView color_right2=(ImageView)view.findViewById(R.id.color_right2);
            ImageView color_right3=(ImageView)view.findViewById(R.id.color_right3);
            if  (MainActivity.COLOR_inverse  == 0) {  //左至右
                bg2=(ImageView)view.findViewById(R.id.imageView);
                bg=(ImageView)view.findViewById(R.id.imageViewb);
                color_right.setVisibility(VISIBLE);
                color_right2.setVisibility(VISIBLE);
                color_right3.setVisibility(VISIBLE);
                color_left.setVisibility(INVISIBLE);
                color_left2.setVisibility(INVISIBLE);
                color_left3.setVisibility(INVISIBLE);
            }else {//右至左
                bg2=(ImageView)view.findViewById(R.id.imageViewb);
                bg=(ImageView)view.findViewById(R.id.imageView);
                color_left.setVisibility(VISIBLE);
                color_left2.setVisibility(VISIBLE);
                color_left3.setVisibility(VISIBLE);
                color_right.setVisibility(INVISIBLE);
                color_right2.setVisibility(INVISIBLE);
                color_right3.setVisibility(INVISIBLE);
            }
            bg.setVisibility(VISIBLE);
            bg2.setVisibility(INVISIBLE);
            TextView bg_t=(TextView)view.findViewById(R.id.textView17);
            TextView last_t=(TextView)view.findViewById(R.id.textView16);
            ImageView last=(ImageView)view.findViewById(R.id.imageView7);
            if  (MainActivity.COLOR_inverse  == 0) {
                last_t=(TextView)view.findViewById(R.id.textView16);
                last=(ImageView)view.findViewById(R.id.imageView7);
            }
            else {
                last_t=(TextView)view.findViewById(R.id.textView21);
                last=(ImageView)view.findViewById(R.id.imageView10);
            }
            TextView Colorinfo=(TextView)view.findViewById(R.id.Colorinfo);
            Colorinfo.setText("");
            ImageView[] letters = new ImageView[6];
            letters[0]=(ImageView)view.findViewById(R.id.imageView2);letters[0].setVisibility(INVISIBLE);
            letters[1]=(ImageView)view.findViewById(R.id.imageView3);letters[1].setVisibility(INVISIBLE);
            letters[2]=(ImageView)view.findViewById(R.id.imageView4);letters[2].setVisibility(INVISIBLE);
            letters[3]=(ImageView)view.findViewById(R.id.imageView5);letters[3].setVisibility(INVISIBLE);
            letters[4]=(ImageView)view.findViewById(R.id.imageView6);letters[4].setVisibility(INVISIBLE);
            TextView[] VColor = new TextView[6];
            VColor[0]=(TextView)view.findViewById(R.id.textView5);VColor[0].setVisibility(INVISIBLE);
            VColor[1]=(TextView)view.findViewById(R.id.textView12);VColor[1].setVisibility(INVISIBLE);
            VColor[2]=(TextView)view.findViewById(R.id.textView13);VColor[2].setVisibility(INVISIBLE);
            VColor[3]=(TextView)view.findViewById(R.id.textView14);VColor[3].setVisibility(INVISIBLE);
            VColor[4]=(TextView)view.findViewById(R.id.textView15);VColor[4].setVisibility(INVISIBLE);

            String input=MainActivity.COLOR_NUM;
            String[] parts = input.split("-");
            int i = parts[0].length();String first=parts[0];
            String reverse = new StringBuffer(first).reverse().toString();
            char content[] = first.toCharArray();
            if  (MainActivity.COLOR_inverse  == 0) {
                letters[0].setVisibility(VISIBLE);
                letters[0].getLayoutParams().width = 40;
                letters[4].getLayoutParams().width = 25;
                content = first.toCharArray();
            }
            else
            {
                content = reverse.toCharArray();
                letters[0].getLayoutParams().width = 25;
                letters[4].getLayoutParams().width = 40;
            }
            for (int j = 0; j < content.length; j++) {
                switch (content[j]) {
                    case '棕':
                        letters[j].setColorFilter(Color.parseColor("#993300"));
                        VColor[j].setText("棕");
                        letters[j].setVisibility(VISIBLE);
                        VColor[j].setVisibility(VISIBLE);
                        break;
                    case '黑':
                        letters[j].setColorFilter(Color.parseColor("#000000"));
                        letters[j].setVisibility(VISIBLE);
                        VColor[j].setVisibility(VISIBLE);
                        VColor[j].setText("黑");
                        break;
                    case '紅':
                        letters[j].setColorFilter(mcolor_Red);
                        VColor[j].setText("紅");
                        letters[j].setVisibility(VISIBLE);
                        VColor[j].setVisibility(VISIBLE);
                        break;
                    case '橙':
                        letters[j].setColorFilter(mcolor_Orange);
                        VColor[j].setText("橙");
                        letters[j].setVisibility(VISIBLE);
                        VColor[j].setVisibility(VISIBLE);
                        break;
                    case '黃':
                        letters[j].setColorFilter(mcolor_Yellow);
                        VColor[j].setText("黃");
                        letters[j].setVisibility(VISIBLE);
                        VColor[j].setVisibility(VISIBLE);
                        break;
                    case '綠':
                        letters[j].setColorFilter(mcolor_Green);
                        VColor[j].setText("綠");
                        letters[j].setVisibility(VISIBLE);
                        VColor[j].setVisibility(VISIBLE);
                        break;
                    case '藍':
                        letters[j].setColorFilter(mcolor_Blue);
                        VColor[j].setText("藍");
                        letters[j].setVisibility(VISIBLE);
                        VColor[j].setVisibility(VISIBLE);
                        break;
                    case '紫':
                        letters[j].setColorFilter(mcolor_Purple);
                        VColor[j].setText("紫");
                        letters[j].setVisibility(VISIBLE);
                        VColor[j].setVisibility(VISIBLE);
                        break;
                    case '灰':
                        letters[j].setColorFilter(mcolor_Gray);
                        VColor[j].setText("灰");
                        letters[j].setVisibility(VISIBLE);
                        VColor[j].setVisibility(VISIBLE);
                        break;
                    case '白':
                        letters[j].setColorFilter(mcolor_White);
                        VColor[j].setText("白");
                        letters[j].setVisibility(VISIBLE);
                        VColor[j].setVisibility(VISIBLE);
                        break;
                    case '金':
                        letters[j].setColorFilter(mcolor_Gold);
                        VColor[j].setText("金");
                        letters[j].setVisibility(VISIBLE);
                        VColor[j].setVisibility(VISIBLE);
                        break;
                    case '銀':
                        letters[j].setColorFilter(mcolor_Silver);
                        VColor[j].setText("銀");
                        letters[j].setVisibility(VISIBLE);
                        VColor[j].setVisibility(VISIBLE);
                        break;
                    default:
                        MainActivity.cerro2(content[j]);
                        Colorinfo.setText("查無色碼請通知系統資訊部");
                        break;
                }
            }
            if(parts[1].length()!=0){ //TYPE2
                last_t.setVisibility(VISIBLE);
                last.setVisibility(VISIBLE);
                String in=parts[1].toString();
                char content2[] = in.toCharArray();
                switch (content2[0]) {
                    case '棕':
                        last.setColorFilter(Color.parseColor("#993300"));
                        last_t.setText("棕");
                        break;
                    case '黑':
                        last.setColorFilter(Color.parseColor("#000000"));
                        last_t.setText("黑");
                        break;
                    case '紅':
                        last.setColorFilter(mcolor_Red);
                        last_t.setText("紅");
                        break;
                    case '橙':
                        last.setColorFilter(mcolor_Orange);
                        last_t.setText("橙");
                        break;
                    case '黃':
                        last.setColorFilter(mcolor_Yellow);
                        last_t.setText("黃");
                        break;
                    case '綠':
                        last.setColorFilter(mcolor_Green);
                        last_t.setText("綠");
                        break;
                    case '藍':
                        last.setColorFilter(mcolor_Blue);
                        last_t.setText("藍");
                        break;
                    case '紫':
                        last.setColorFilter(mcolor_Purple);
                        last_t.setText("紫");
                        break;
                    case '灰':
                        last.setColorFilter(mcolor_Gray);
                        last_t.setText("灰");
                        break;
                    case '白':
                        last.setColorFilter(mcolor_White);
                        last_t.setText("白");
                        break;
                    case '金':
                        last.setColorFilter(mcolor_Gold);
                        last_t.setText("金");
                        break;
                    case '銀':
                        last.setColorFilter(mcolor_Silver);
                        last_t.setText("銀");
                        break;
                    default:
                        MainActivity.cerro2(content2[0]);
                        Colorinfo.setText("查無色碼請通知系統資訊部");
                        break;
                }
            }
            else
            {
                last_t.setVisibility(INVISIBLE);
                last.setVisibility(INVISIBLE);
            }
            String secpart=parts[2];
            bg_t.setText("底色 : "+secpart);
        }
    };
}
