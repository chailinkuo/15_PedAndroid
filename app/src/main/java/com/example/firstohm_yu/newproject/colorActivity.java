package com.example.firstohm_yu.newproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URLEncoder;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;
import static com.example.firstohm_yu.newproject.MainActivity.MEG_INVALIDATE;

public class colorActivity extends AppCompatActivity {
    Button button21,cls,bnt_num_1,bnt_num_2,bnt_num_3,bnt_num_4,bnt_num_5,bnt_num_6,bnt_num_7,bnt_num_8,bnt_num_9,bnt_num_0,
            bnt_num_k,bnt_num_e,bnt_num_m,bnt_tol_005,bnt_tol_01,bnt_tol_025,bnt_tol_05,
            bnt_tol_1,bnt_tol_2,bnt_tol_5,bnt_tol_10,submit,clear;
    EditText tol_edit,val_edit;
    TextView siru,bg_t,RTYPE;
    int foot=0,COLOR_inverse=0;
    RadioGroup radioGroup;
    RadioButton rb_1,rb_2;
    String rtype,strIsbn,flowBar,warehouseBar;
    Spinner spinnerC1;
    Spinner spinnerC2;
    String host,COLOR_NUM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color2);
        Bundle bundle =this.getIntent().getExtras();
        host = bundle.getString("host");
        //host="http://211.23.138.230:1119/firstohmwebapi/";
        COLOR_inverse=bundle.getInt("COLOR_inverse");
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        tol_edit=(EditText) findViewById(R.id.tol_edit);
        val_edit=(EditText) findViewById(R.id.val_edit);
        submit=(Button) findViewById(R.id.submit);
        RTYPE=(TextView) findViewById(R.id.RTYPE);
        bg_t=(TextView) findViewById(R.id.bg_t);
        siru=(TextView) findViewById(R.id.siru);
        submit.setOnClickListener(sub);
        spinnerC1=(Spinner) findViewById(R.id.spinnerC1);
        spinnerC2=(Spinner) findViewById(R.id.spinnerC2);
        radioGroup = (RadioGroup) findViewById(R.id.mfgbutton);
        String[] arraySpinner = new String[] {
                "??????","C3","CSR","EFR","FGE","HDR","HVR","IG","M","R","MO","MP","MSD","MVR","NFR","NL","PMA","PPR","PSR","PWR","SCP","SSR","SWA","WA","SWAT","ZOM","SGS"
        };


        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                arraySpinner) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView tv = (TextView) view.findViewById(android.R.id.text1);
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 36);
                return view;
            }
        };
        adapter.setDropDownViewResource(R.layout.simple_list_item_1);

        spinnerC1.setAdapter(adapter);

        String[] arraySpinner2 = new String[] {
                "??????", "CM", "CSM", "EFP", "FM", "HFT", "HVM", "MM", "MMP", "MM(P)", "SFP", "SFPV", "SL", "SLC", "SM", "SRM", "SRMT", "SWM", "ZMM"
        };

        ArrayAdapter adapter2 = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                arraySpinner2) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView tv = (TextView) view.findViewById(android.R.id.text1);
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 36);
                return view;
            }
        };

        adapter2.setDropDownViewResource(R.layout.simple_list_item_1);
        spinnerC2.setAdapter(adapter2);
        spinnerC1.setEnabled(false);
        spinnerC2.setEnabled(false);
        rb_1=(RadioButton) findViewById(R.id.rb1);
        rb_2=(RadioButton) findViewById(R.id.rb2);
        clear=(Button) findViewById(R.id.clear);
        clear.setOnClickListener(clearv);
        rb_1.setOnClickListener(first_radio_listener);
        rb_2.setOnClickListener(sence_radio_listener);
        button21=(Button) findViewById(R.id.button21);
        bnt_tol_005=(Button) findViewById(R.id.bnt_tol_005);
        bnt_tol_005.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {val_edit.setText("??0.05%");}
        });
        bnt_tol_01=(Button) findViewById(R.id.bnt_tol_01);
        bnt_tol_01.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {val_edit.setText("??0.1%");}
        });
        bnt_tol_025=(Button) findViewById(R.id.bnt_tol_025);
        bnt_tol_025.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {val_edit.setText("??0.25%");}
        });
        bnt_tol_05=(Button) findViewById(R.id.bnt_tol_05);
        bnt_tol_05.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {val_edit.setText("??0.5%");}
        });
        bnt_tol_2=(Button) findViewById(R.id.bnt_tol_2);
        bnt_tol_2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {val_edit.setText("??2%");}
        });
        bnt_tol_1=(Button) findViewById(R.id.bnt_tol_1);
        bnt_tol_1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {val_edit.setText("??1%");}
        });
        bnt_tol_5=(Button) findViewById(R.id.bnt_tol_5);
        bnt_tol_5.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {val_edit.setText("??5%");}
        });
        bnt_tol_10=(Button) findViewById(R.id.bnt_tol_10);
        bnt_tol_10.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {val_edit.setText("??10%");}
        });
        ///////////////////////////////////////////////////////
        bnt_num_1=(Button) findViewById(R.id.bnt_num_1);
        bnt_num_1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {tol_edit.setText(tol_edit.getText().toString()+"1");}
        });
        bnt_num_2=(Button) findViewById(R.id.bnt_num_2);
        bnt_num_2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {tol_edit.setText(tol_edit.getText().toString()+"2");}
        });
        bnt_num_3=(Button) findViewById(R.id.bnt_num_3);
        bnt_num_3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {tol_edit.setText(tol_edit.getText().toString()+"3");}
        });
        bnt_num_4=(Button) findViewById(R.id.bnt_num_4);
        bnt_num_4.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {tol_edit.setText(tol_edit.getText().toString()+"4");}
        });
        bnt_num_5=(Button) findViewById(R.id.bnt_num_5);
        bnt_num_5.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {tol_edit.setText(tol_edit.getText().toString()+"5");}
        });
        bnt_num_6=(Button) findViewById(R.id.bnt_num_6);
        bnt_num_6.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {tol_edit.setText(tol_edit.getText().toString()+"6");}
        });
        bnt_num_7=(Button) findViewById(R.id.bnt_num_7);
        bnt_num_7.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {tol_edit.setText(tol_edit.getText().toString()+"7");}
        });
        bnt_num_8=(Button) findViewById(R.id.bnt_num_8);
        bnt_num_8.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {tol_edit.setText(tol_edit.getText().toString()+"8");}
        });
        bnt_num_9=(Button) findViewById(R.id.bnt_num_9);
        bnt_num_9.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {tol_edit.setText(tol_edit.getText().toString()+"9");}
        });
        bnt_num_0=(Button) findViewById(R.id.bnt_num_0);
        bnt_num_0.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {tol_edit.setText(tol_edit.getText().toString()+"0");}
        });
        bnt_num_m=(Button) findViewById(R.id.bnt_num_m);
        bnt_num_m.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {tol_edit.setText(tol_edit.getText().toString()+"M");}
        });
        bnt_num_e=(Button) findViewById(R.id.bnt_num_e);
        bnt_num_e.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {tol_edit.setText(tol_edit.getText().toString()+"E");}
        });
        bnt_num_k=(Button) findViewById(R.id.bnt_num_k);
        bnt_num_k.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {tol_edit.setText(tol_edit.getText().toString()+"K");}
        });
    }
    private View.OnClickListener sub = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // ??????
            System.out.println("===>"+tol_edit.getText().toString()+"   "+val_edit.getText().toString());
            String tol,val;
            rtype=spinnerC1.getSelectedItem().toString()+spinnerC2.getSelectedItem().toString();
            tol = tol_edit.getText().toString();
            val = val_edit.getText().toString();
            val= val.replaceAll("??", "");
            //val= val.replaceAll("\\.", "");
            val= val.replaceAll("%", "");
            rtype= rtype.replaceAll("??????", "");
            System.out.println("===>"+rtype+"  "+tol+"   "+val);
            //SRM-T, MM-P, SFP-V
            if (rtype.indexOf("SRMT") > -1){rtype="SRM-T";}
            if (rtype.indexOf("MM(P)") > -1){rtype="MM-P";}
            if (rtype.indexOf("SFPV") > -1){rtype="SFP-V";}
            String url =  host+"PrdMgn/getColorPrdAttribute?rtype="+rtype+"&tol="+val+"&val="+tol+"&ifFoot="+foot;
            System.out.println(url);
            call_rest restObj = new call_rest();
            JSONObject rtnRestObj = restObj.callRest(url);
            JSONObject all = null;
            try {
                all = new JSONObject(rtnRestObj.toString());
                COLOR_NUM = all.getString("Data");
                //System.out.println(Message);
                android.os.Message m = new Message();
                m.what = MEG_INVALIDATE;
                clolr.sendMessage(m);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        }
    };
    private View.OnClickListener clearv = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = getIntent();
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            finish();
            overridePendingTransition(0, 0);

            startActivity(intent);
            overridePendingTransition(0, 0);
        }
    };

    View.OnClickListener first_radio_listener = new View.OnClickListener(){
        public void onClick(View v) {
            foot=1;
            spinnerC2.setSelection(0);
            spinnerC2.setEnabled(false);
            spinnerC1.setEnabled(true);
        }
    };
    View.OnClickListener sence_radio_listener = new View.OnClickListener(){
        public void onClick(View v) {
            foot=0;
            spinnerC1.setSelection(0);
            spinnerC1.setEnabled(false);
            spinnerC2.setEnabled(true);
        }
    };
    final Handler clolr = new Handler() {
        public void handleMessage(Message msg1) {
            super.handleMessage(msg1);
            ImageView[] letters = new ImageView[8];
            FrameLayout bg = (FrameLayout) findViewById(R.id.bg_frame);
            if (COLOR_inverse == 0) {  //?????????
                letters[0] = (ImageView) findViewById(R.id.cp_c1);
                letters[1] = (ImageView) findViewById(R.id.cp_c2);
                letters[2] = (ImageView) findViewById(R.id.cp_c3);
                letters[3] = (ImageView) findViewById(R.id.cp_c4);
                letters[4] = (ImageView) findViewById(R.id.cp_c5);
                letters[5] = (ImageView) findViewById(R.id.cp_c6);
                siru.setText("????????????");
            }else {
                letters[5] = (ImageView) findViewById(R.id.cp_c1);
                letters[4] = (ImageView) findViewById(R.id.cp_c2);
                letters[3] = (ImageView) findViewById(R.id.cp_c3);
                letters[2] = (ImageView) findViewById(R.id.cp_c4);
                letters[1] = (ImageView) findViewById(R.id.cp_c5);
                letters[0] = (ImageView) findViewById(R.id.cp_c6);


                siru.setText("???????????????");
            }
            int rcolor_blue = Color.parseColor("#73C3AA"); //7921 ??????B
            int rcolor_ag = Color.parseColor("#9BFFAA"); //?????????
            int rcolor_bred = Color.parseColor("#FFBEBE"); //??????
            int rcolor_mblue = Color.parseColor("#64A6CE"); //MO ??????
            int rcolor_purple = Color.parseColor("#CC99CC"); //??????
            int rcolor_mp106 = Color.parseColor("#FACCBA"); //MP106 ??????
            int rcolor_gd = Color.parseColor("#73AD8F"); //?????? ??????
            int rcolor_mp1062 = Color.parseColor("#FFBEBE"); //??? MP106    ??? ??????
            int rcolor_green = Color.parseColor("#4B854B"); //??????
            int rcolor_my = Color.parseColor("#E8D296"); //?????? ??????
            int rcolor_cm02my = Color.parseColor("#FFE0A0"); //CM02 ????????????
            int rcolor_pa = Color.parseColor("#FFCCAF"); //??????A
            int rcolor_mm02 = Color.parseColor("#1E82C8"); //MM02 ??????A
            int rcolor_106b = Color.parseColor("#FACCBA"); //MP106 ??????B
            int rcolor_pink = Color.parseColor("#ff60af"); //MP106 ??????B
            int mcolor_Red = Color.parseColor("#FF0000"); //???
            int mcolor_Orange = Color.parseColor("#FF6600"); //???
            int mcolor_Yellow = Color.parseColor("#FFFF00"); //???
            int mcolor_Green = Color.parseColor("#009900"); //???
            int mcolor_Blue = Color.parseColor("#0000FF"); //???
            int mcolor_Purple = Color.parseColor("#9900FF"); //???
            int mcolor_Gray = Color.parseColor("#999999"); //???
            int mcolor_White = Color.parseColor("#FFFFFF"); //???
            int mcolor_Gold = Color.parseColor("#FFCC00"); //???
            int mcolor_Silver = Color.parseColor("#CCCCCC"); //???

            int mcolor_pinkb = Color.parseColor("#FACCBA"); //MP106???-MP106 ??????B(250, 204, 186)- #FACCBA-pinkb
            int mcolor_bluea = Color.parseColor("#1E82C8"); //2070-   MM02 ??????A(30, 130, 200)-        #1E82C8-bluea
            int mcolor_blue2 = Color.parseColor("#73C3AA"); //7921???- 7921 ??????(115, 195, 170)-         #73C3AA-blue2
            int mcolor_pinka = Color.parseColor("#FFCCAF"); //Z0415-  ??????A(255, 204, 175)-                #FFCCAF-pinka
            int mcolor_yellow = Color.parseColor("#FFE0A0"); //Z360-   CM02 ????????????(255, 224, 160)-  #FFE0A0-yellow
            int mcolor_apple = Color.parseColor("#9BFFAA"); //?????????????????????-?????????(155, 255, 170)-  #9BFFAA-apple
            int mcolor_green2 = Color.parseColor("#4B854B"); //??????????????????-  ??????(75, 133, 75)-           #4B854B-green2
            int mcolor_bluem = Color.parseColor("#64A6CE"); //??????????????????-  MO ??????(100, 166, 206)-#64A6CE-bluem
            int mcolor_purple2 = Color.parseColor("#CE99CC"); //??????????????????-  ??????(204, 153, 204)-       #CE99CC-purple2
            int mcolor_red = Color.parseColor("#FFBEBE"); //??????????????????-  ??????(255, 190, 190)-       #FFBEBE-red
            int mcolor_metal = Color.parseColor("#73AD8F"); // ????????????-      ?????? ??????(115, 173, 143)-  #73AD8F-metal

            //COLOR_NUM="?????????-???-MP106 ??????";
            String input = COLOR_NUM;
            String[] parts = input.split("-");
            int i = parts[0].length();
            bg_t.setText(input);
            String first = parts[0];
            if(input.indexOf("??????") > -1){

            }
            else {
                TextView[] VColor = new TextView[6];
                if (COLOR_inverse == 0) {  //?????????
                    VColor[0] = (TextView) findViewById(R.id.textViewc_1);
                    VColor[0].setVisibility(INVISIBLE);
                    VColor[1] = (TextView) findViewById(R.id.textViewc_2);
                    VColor[1].setVisibility(INVISIBLE);
                    VColor[2] = (TextView) findViewById(R.id.textViewc_3);
                    VColor[2].setVisibility(INVISIBLE);
                    VColor[3] = (TextView) findViewById(R.id.textViewc_4);
                    VColor[3].setVisibility(INVISIBLE);
                    VColor[4] = (TextView) findViewById(R.id.textViewc_5);
                    VColor[4].setVisibility(INVISIBLE);
                    VColor[4] = (TextView) findViewById(R.id.textViewc_5);
                    VColor[4].setVisibility(INVISIBLE);
                    VColor[5] = (TextView) findViewById(R.id.textViewc_6);
                    VColor[5].setVisibility(INVISIBLE);
                }else{
                    VColor[5] = (TextView) findViewById(R.id.textViewc_1);
                    VColor[5].setVisibility(INVISIBLE);
                    VColor[4] = (TextView) findViewById(R.id.textViewc_2);
                    VColor[4].setVisibility(INVISIBLE);
                    VColor[3] = (TextView) findViewById(R.id.textViewc_3);
                    VColor[3].setVisibility(INVISIBLE);
                    VColor[2] = (TextView) findViewById(R.id.textViewc_4);
                    VColor[2].setVisibility(INVISIBLE);
                    VColor[1] = (TextView) findViewById(R.id.textViewc_5);
                    VColor[1].setVisibility(INVISIBLE);
                    VColor[0] = (TextView) findViewById(R.id.textViewc_6);
                    VColor[0].setVisibility(INVISIBLE);
                }
                String reverse = new StringBuffer(first).reverse().toString();
                char content[] = first.toCharArray();
                for (int j =0 ; j < content.length; j++) {
                    switch (content[j]) {
                        case '???':
                            letters[j].setColorFilter(Color.parseColor("#993300"));
                            VColor[j].setText("???");
                            letters[j].setVisibility(VISIBLE);
                            VColor[j].setVisibility(VISIBLE);
                            break;
                        case '???':
                            letters[j].setColorFilter(Color.parseColor("#000000"));
                            letters[j].setVisibility(VISIBLE);
                            VColor[j].setVisibility(VISIBLE);
                            VColor[j].setText("???");
                            break;
                        case '???':
                            letters[j].setColorFilter(mcolor_Red);
                            VColor[j].setText("???");
                            letters[j].setVisibility(VISIBLE);
                            VColor[j].setVisibility(VISIBLE);
                            break;
                        case '???':
                            letters[j].setColorFilter(mcolor_Orange);
                            VColor[j].setText("???");
                            letters[j].setVisibility(VISIBLE);
                            VColor[j].setVisibility(VISIBLE);
                            break;
                        case '???':
                            letters[j].setColorFilter(mcolor_Yellow);
                            VColor[j].setText("???");
                            letters[j].setVisibility(VISIBLE);
                            VColor[j].setVisibility(VISIBLE);
                            break;
                        case '???':
                            letters[j].setColorFilter(mcolor_Green);
                            VColor[j].setText("???");
                            letters[j].setVisibility(VISIBLE);
                            VColor[j].setVisibility(VISIBLE);
                            break;
                        case '???':
                            letters[j].setColorFilter(mcolor_Blue);
                            VColor[j].setText("???");
                            letters[j].setVisibility(VISIBLE);
                            VColor[j].setVisibility(VISIBLE);
                            break;
                        case '???':
                            letters[j].setColorFilter(mcolor_Purple);
                            VColor[j].setText("???");
                            letters[j].setVisibility(VISIBLE);
                            VColor[j].setVisibility(VISIBLE);
                            break;
                        case '???':
                            letters[j].setColorFilter(mcolor_Gray);
                            VColor[j].setText("???");
                            letters[j].setVisibility(VISIBLE);
                            VColor[j].setVisibility(VISIBLE);
                            break;
                        case '???':
                            letters[j].setColorFilter(mcolor_White);
                            VColor[j].setText("???");
                            letters[j].setVisibility(VISIBLE);
                            VColor[j].setVisibility(VISIBLE);
                            break;
                        case '???':
                            letters[j].setColorFilter(mcolor_Gold);
                            VColor[j].setText("???");
                            letters[j].setVisibility(VISIBLE);
                            VColor[j].setVisibility(VISIBLE);
                            break;
                        case '???':
                            letters[j].setColorFilter(mcolor_Silver);
                            VColor[j].setText("???");
                            letters[j].setVisibility(VISIBLE);
                            VColor[j].setVisibility(VISIBLE);
                            break;
                        default:
                            //cerro2(content[j]);
                            //Colorinfo.setText("????????????????????????????????????");
                            break;
                    }
                }
                ///////////////////
                try{
                    if (parts[1].length() != 0) { //TYPE2
                        letters[4].setVisibility(VISIBLE);
                        VColor[4].setVisibility(VISIBLE);
                        String in = parts[1].toString();
                        char content2[] = in.toCharArray();
                        switch (content2[0]) {
                            case '???':
                                letters[4].setColorFilter(Color.parseColor("#993300"));
                                VColor[4].setText("???");
                                break;
                            case '???':
                                letters[4].setColorFilter(Color.parseColor("#000000"));
                                VColor[4].setText("???");
                                break;
                            case '???':
                                letters[4].setColorFilter(mcolor_Red);
                                VColor[4].setText("???");
                                break;
                            case '???':
                                letters[4].setColorFilter(mcolor_Orange);
                                VColor[4].setText("???");
                                break;
                            case '???':
                                letters[4].setColorFilter(mcolor_Yellow);
                                VColor[4].setText("???");
                                break;
                            case '???':
                                letters[4].setColorFilter(mcolor_Green);
                                VColor[4].setText("???");
                                break;
                            case '???':
                                letters[4].setColorFilter(mcolor_Blue);
                                VColor[4].setText("???");
                                break;
                            case '???':
                                letters[4].setColorFilter(mcolor_Purple);
                                VColor[4].setText("???");
                                break;
                            case '???':
                                letters[4].setColorFilter(mcolor_Gray);
                                VColor[4].setText("???");
                                break;
                            case '???':
                                letters[4].setColorFilter(mcolor_White);
                                VColor[4].setText("???");
                                break;
                            case '???':
                                letters[4].setColorFilter(mcolor_Gold);
                                VColor[4].setText("???");
                                break;
                            case '???':
                                letters[4].setColorFilter(mcolor_Silver);
                                VColor[4].setText("???");
                                break;
                            default:
                                //cerro2(content2[0]);
                                VColor[4].setText("????????????????????????????????????");
                                break;
                        }
                    } else {
                        VColor[4].setVisibility(INVISIBLE);
                        letters[4].setVisibility(INVISIBLE);
                    }
                }catch  (Exception e) {
                }
                ///////////////
                ///////////////////
                try{
                    if (parts[3].length() != 0) { //TYPE2
                        letters[5].setVisibility(VISIBLE);
                        VColor[5].setVisibility(VISIBLE);
                        String in = parts[3].toString();
                        char content2[] = in.toCharArray();
                        switch (content2[0]) {
                            case '???':
                                letters[5].setColorFilter(Color.parseColor("#993300"));
                                VColor[5].setText("???");
                                break;
                            case '???':
                                letters[5].setColorFilter(Color.parseColor("#000000"));
                                VColor[5].setText("???");
                                break;
                            case '???':
                                letters[5].setColorFilter(mcolor_Red);
                                VColor[5].setText("???");
                                break;
                            case '???':
                                letters[5].setColorFilter(mcolor_Orange);
                                VColor[5].setText("???");
                                break;
                            case '???':
                                letters[5].setColorFilter(mcolor_Yellow);
                                VColor[5].setText("???");
                                break;
                            case '???':
                                letters[5].setColorFilter(mcolor_Green);
                                VColor[5].setText("???");
                                break;
                            case '???':
                                letters[5].setColorFilter(mcolor_Blue);
                                VColor[5].setText("???");
                                break;
                            case '???':
                                letters[5].setColorFilter(mcolor_Purple);
                                VColor[5].setText("???");
                                break;
                            case '???':
                                letters[5].setColorFilter(mcolor_Gray);
                                VColor[5].setText("???");
                                break;
                            case '???':
                                letters[5].setColorFilter(mcolor_White);
                                VColor[5].setText("???");
                                break;
                            case '???':
                                letters[5].setColorFilter(mcolor_Gold);
                                VColor[5].setText("???");
                                break;
                            case '???':
                                letters[5].setColorFilter(mcolor_Silver);
                                VColor[5].setText("???");
                                break;
                            default:
                                //cerro2(content2[0]);
                                VColor[5].setText("????????????????????????????????????");
                                break;
                        }
                    } else {
                        VColor[5].setVisibility(INVISIBLE);
                        letters[5].setVisibility(INVISIBLE);
                    }
                }catch  (Exception e) {
                }
                ///////////////\
                String secpart;
                try {
                    secpart = parts[2];
                }catch  (Exception e) {
                    secpart="";
                }
                //bg_t.setVisibility(VISIBLE);
                //bg_t.setText("?????? : " + secpart);
                switch (secpart) {  //??????
                    case "MM02-??????A":
                        bg.setBackgroundColor(rcolor_blue);
                        bg_t.setText("?????? : MM02-??????A");
                        break;
                    case "?????????":
                        bg.setBackgroundColor(rcolor_ag);
                        bg_t.setText("?????? : ?????????");
                        break;
                    case "??????":
                        bg.setBackgroundColor(rcolor_bred);
                        bg_t.setText("?????? : ??????");
                        break;
                    case "MO ??????":
                        bg.setBackgroundColor(rcolor_mblue);
                        bg_t.setText("?????? : MO ??????");
                        break;
                    case "??????B":
                        bg.setBackgroundColor(rcolor_pink);
                        bg_t.setText("?????? : ??????B");
                        break;
                    case "??????":
                        bg.setBackgroundColor(rcolor_purple);
                        bg_t.setText("?????? : ??????");
                        break;
                    case "MP106 ??????":
                        bg.setBackgroundColor(rcolor_mp106);
                        bg_t.setText("?????? : MP106 ??????");
                        break;
                    case "?????? ??????":
                        bg.setBackgroundColor(rcolor_gd);
                        bg_t.setText("?????? : ?????? ??????");
                        break;
                    case "??? MP106":
                        bg.setBackgroundColor(rcolor_mp1062);
                        bg_t.setText("?????? : ??? MP106");
                        break;
                    case "??????":
                        bg.setBackgroundColor(rcolor_green);
                        bg_t.setText("?????? : ??????");
                        break;
                    case "?????? ??????":
                        bg.setBackgroundColor(rcolor_my);
                        bg_t.setText("?????? : ?????? ??????");
                        break;
                    case "CM02 ????????????":
                        bg.setBackgroundColor(rcolor_cm02my);
                        bg_t.setText("?????? : CM02 ????????????");
                        break;
                    case "??????A":
                        bg.setBackgroundColor(rcolor_pa);
                        bg_t.setText("?????? : ??????A");
                        break;
                    case "??????A ":
                        bg.setBackgroundColor(rcolor_pa);
                        bg_t.setText("?????? : ??????A");
                        break;
                    case "MM02 ??????A":
                        bg.setBackgroundColor(rcolor_mm02);
                        bg_t.setText("?????? : MM02 ??????A");
                        break;
                    case "7921 ??????B":
                        bg.setBackgroundColor(rcolor_blue);
                        bg_t.setText("?????? : 7921 ??????B");
                        break;
                    case "MP106 ??????B":
                        bg.setBackgroundColor(rcolor_106b);
                        bg_t.setText("?????? : MP106 ??????B");
                        break;
                    case "???":
                        bg.setBackgroundColor(mcolor_Blue);
                        bg_t.setText("?????? :???");
                        break;
                    case "MP106???":
                        bg.setBackgroundColor( mcolor_pinkb);
                        bg_t.setText("?????? : MP106???");
                        break;
                    case "2070":
                        bg.setBackgroundColor(mcolor_bluea);
                        bg_t.setText("?????? : 2070");
                        break;
                    case "7921???":
                        bg.setBackgroundColor(mcolor_blue2);
                        bg_t.setText("?????? : 7921???");
                        break;
                    case "7921":
                        bg.setBackgroundColor(mcolor_blue2);
                        bg_t.setText("?????? : 7921???");
                        break;

                    case "MP106":
                        bg.setBackgroundColor( mcolor_pinkb);
                        bg_t.setText("?????? : MP106");
                        break;
                    case "Z0415":
                        bg.setBackgroundColor(mcolor_pinka);
                        bg_t.setText("?????? : Z0415");
                        break;
                    case "Z360":
                        bg.setBackgroundColor(mcolor_yellow);
                        bg_t.setText("?????? : Z360");
                        break;
                    case "?????????????????????":
                        bg.setBackgroundColor(mcolor_apple);
                        bg_t.setText("?????? : ?????????????????????");
                        break;
                    case "??????????????????":
                        bg.setBackgroundColor(mcolor_green2);
                        bg_t.setText("?????? : ??????????????????");
                        break;
                    case "??????????????????":
                        bg.setBackgroundColor(mcolor_bluem);
                        bg_t.setText("?????? : ??????????????????");
                        break;
                    case "??????????????????":
                        bg.setBackgroundColor(mcolor_purple2);
                        bg_t.setText("?????? : ??????????????????");
                        break;
                    case "??????????????????":
                        bg.setBackgroundColor(mcolor_red);
                        bg_t.setText("?????? : ??????????????????");
                        break;
                    case "????????????":
                        bg.setBackgroundColor(mcolor_metal);
                        bg_t.setText("?????? : ????????????");
                        break;
                    default:
                        System.out.println("??????==>"+secpart);
                        break;
                }
            }
        }


    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null ) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                strIsbn = result.getContents();
                Toast.makeText(this, strIsbn, Toast.LENGTH_LONG).show();
                if (strIsbn.indexOf("%") > -1) {
                    flowBar = result.getContents();//??????flowBar
                    warehouseBar="";
                } else if (strIsbn.indexOf("|") > -1) {
                    warehouseBar = result.getContents();//??????iuserBar
                    flowBar="";
                    button21.performClick();
                    //get_sance(view);
                }
                try {
                    Thread.sleep(1000); //1000???1???
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (flowBar != null && warehouseBar != null) {
                        }
                    }
                }, 1000);
            }
        }  else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void get_sance(View view) {
        try {
            call_rest restObj = new call_rest();
            //System.out.println("facroryNo===>"+host+"PrdMgn/Login?userBar="+encodedUrl2+"&Dept="+encodedUrl3+"&facroryNo="+facroryNo);
            //warehouseBar="|F-10-SRMNS255|SRM101|1|4E7||6";
            JSONObject rtnRestObj = restObj.callRest( host+"PrdMgn/getColorFromWareHouseBarCode?warehouseBar="+warehouseBar);

            JSONObject all = new JSONObject(rtnRestObj.toString());
            String g_json_string = all.getString("Data");
            JSONObject all2 = new JSONObject(g_json_string.toString());
            COLOR_NUM=all2.getString("Color");
            RTYPE.setText(all2.getString("RTYPE"));
            val_edit.setText(all2.getString("Tol"));
            tol_edit.setText(all2.getString("VAL"));
            System.out.println(all2.getString("Color"));
            android.os.Message m = new Message();
            m.what = MEG_INVALIDATE;
            clolr.sendMessage(m);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void sance(View view) {
        IntentIntegrator integrator = new IntentIntegrator(colorActivity.this);
        integrator.setCameraId(0);
        integrator.initiateScan();
    }
}
