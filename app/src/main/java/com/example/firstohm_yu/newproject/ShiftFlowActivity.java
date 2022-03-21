package com.example.firstohm_yu.newproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import static android.view.View.GONE;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;
import static com.example.firstohm_yu.newproject.MainActivity.MEG_INVALIDATE;
import static com.example.firstohm_yu.newproject.MainActivity.check_scan;

public class ShiftFlowActivity extends AppCompatActivity {
    String targetBar,sourceBar,rollQty,userBar, host, flowBar, Message,MASTER_MFO_ID,RTYPE,VAL,TOL,PPM,SIZE,leftQty,TD_Date,batchNo,ifFoot,tieDaiQuant,ORD_QTY;
    int camera_str,sance=1/*掃描單左1右2*/,radio=0;
    Button start,shiftbnt;
    EditText submit_text,bartext;
    TextView Text_L,Text_R,rotext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shift_flow);
        Bundle bundle = this.getIntent().getExtras();
        camera_str = bundle.getInt("camera_str");
        userBar = bundle.getString("userBar");
        host = bundle.getString("host");
        flowBar= bundle.getString("flowBar");
        userBar = userBar.replaceAll("\\*", "");
        start = (Button) findViewById(R.id.start);
        shiftbnt = (Button) findViewById(R.id.shiftbnt);
        submit_text=(EditText) findViewById(R.id.submit_text1) ;
        Text_L = (TextView) findViewById(R.id.Text_L);
        Text_R = (TextView) findViewById(R.id.Text_R);
        rotext=(TextView) findViewById(R.id.rotext);
        bartext=(EditText) findViewById(R.id.bartext);
        sance=1;
        View rootView = getWindow().getDecorView().getRootView();
        start(rootView);
       // host="http://220.128.234.48:1119/firstohmWebApi/";
    //    flowBar="4049-1-180558-0-%";
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        String strIsbn;
        if (result != null && check_scan == 0) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                strIsbn = result.getContents();
                Toast.makeText(this, strIsbn, Toast.LENGTH_LONG).show();
                if (strIsbn.indexOf("%") > -1) {
                    Toast.makeText(this, "讀入變數 工令單: " + result.getContents(), Toast.LENGTH_LONG).show();
                    flowBar = result.getContents();//得到flowBar
                    start.performClick();
                }
            }
        } else if (result != null && check_scan == 1) {
            check_scan = 0;
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void sance_source(View view) {
        sance=1;
        IntentIntegrator integrator = new IntentIntegrator(ShiftFlowActivity.this);
        if (camera_str == 1) {
            integrator.setCameraId(1);
        } else {
            integrator.setCameraId(0);
        }
        integrator.initiateScan();
    }

    public void sance_tage(View view) {

        sance=2;
        IntentIntegrator integrator = new IntentIntegrator(ShiftFlowActivity.this);
        if (camera_str == 1) {
            integrator.setCameraId(1);
        } else {
            integrator.setCameraId(0);
        }
        integrator.initiateScan();
    }
    public void start(View view) {
        call_rest restObj = new call_rest();

        if (sance == 1) {
            sourceBar=flowBar;
            try{
                if (!sourceBar.equals("")&&!targetBar.equals("")){
                    Message m = new Message();
                    m.what = MEG_INVALIDATE;
                    HmoreprogressBar.sendMessage(m);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            JSONObject rtnRestObj = restObj.callRest(host + "PrdMgn/getTiedaiLeftInfo?flowBar="+flowBar);
            //JSONObject rtnRestObj = restObj.callRest(host + "PrdMgn/getTiedaiLeftInfo?flowBar=4049-1-16389-%");
            fillPent(rtnRestObj);
        } else{
            targetBar=flowBar;
            try{
                if (!sourceBar.equals("")&&!targetBar.equals("")){
                    Message m = new Message();
                    m.what = MEG_INVALIDATE;
                    HmoreprogressBar.sendMessage(m);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            JSONObject rtnRestObj = restObj.callRest(host + "PrdMgn/getTiedaiInfo?flowBar="+flowBar);
            fillPent_2(rtnRestObj);
        }

    }

    public void fillPent(JSONObject rtnRestObj) {
        try {
            JSONArray array = new JSONArray(rtnRestObj.getString("Data"));
            Message = rtnRestObj.getString("Message");
            for (int i = 0; i < array.length(); i++) {
                JSONObject ob = array.getJSONObject(i);
                MASTER_MFO_ID= ob.getString("MASTER_MFO_ID") == null ? "" : ob.getString("MASTER_MFO_ID");
                RTYPE= ob.getString("RTYPE") == null ? "" : ob.getString("RTYPE");
                VAL= ob.getString("VAL") == null ? "" : ob.getString("VAL");
                TOL= ob.getString("TOL") == null ? "" : ob.getString("TOL");
                PPM= ob.getString("PPM") == null ? "" : ob.getString("PPM");
                SIZE= ob.getString("SIZE") == null ? "" : ob.getString("SIZE");
                leftQty= ob.getString("leftQty") == null ? "" : ob.getString("leftQty");
                TD_Date= ob.getString("TD_Date") == null ? "" : ob.getString("TD_Date");
                System.out.println("============>"+MASTER_MFO_ID);
            }
            Message m = new Message();
            m.what = MEG_INVALIDATE;
            flow_1_Handler.sendMessage(m);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void fillPent_2(JSONObject rtnRestObj) {
        try {
            JSONArray array = new JSONArray(rtnRestObj.getString("Data"));
            Message = rtnRestObj.getString("Message");
            for (int i = 0; i < array.length(); i++) {
                JSONObject ob = array.getJSONObject(i);
                MASTER_MFO_ID= ob.getString("MASTER_MFO_ID") == null ? "" : ob.getString("MASTER_MFO_ID");
                RTYPE= ob.getString("RTYPE") == null ? "" : ob.getString("RTYPE");
                VAL= ob.getString("VAL") == null ? "" : ob.getString("VAL");
                TOL= ob.getString("Tol") == null ? "" : ob.getString("Tol");
                SIZE= ob.getString("SIZE") == null ? "" : ob.getString("SIZE");
                batchNo= ob.getString("batchNo") == null ? "" : ob.getString("batchNo");
                ifFoot= ob.getString("ifFoot") == null ? "" : ob.getString("ifFoot");
                tieDaiQuant= ob.getString("tieDaiQuant") == null ? "" : ob.getString("tieDaiQuant");
                ORD_QTY= ob.getString("ORD_QTY") == null ? "" : ob.getString("ORD_QTY");
                rollQty= ob.getString("ROLL") == null ? "" : ob.getString("ROLL");
                System.out.println("============>"+MASTER_MFO_ID);
                //System.out.println("============>?");
            }
            Message m = new Message();
            m.what = MEG_INVALIDATE;
            flow_2_Handler.sendMessage(m);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    final Handler flow_1_Handler = new Handler() {
        public void handleMessage(Message msg1) {
            super.handleMessage(msg1);
            Text_L = (TextView) findViewById(R.id.Text_L);

            Text_L.setText("工令單號"+MASTER_MFO_ID+"\n型號\t\t\t\t\t\t"+RTYPE+"\n阻值\t\t\t\t\t\t"+VAL+"\nTOL\t\t\t\t\t\t\t"+TOL+"\nPPM\t\t\t\t\t\t"+PPM+
                    "\n尺寸\t\t\t\t\t\t"+SIZE+"\n可挪用量\t\t\t\t\t\t"+leftQty);
        }
    };
    final Handler flow_2_Handler = new Handler() {
        public void handleMessage(Message msg1) {
            super.handleMessage(msg1);

            rotext = (TextView) findViewById(R.id.rotext);
            rotext.setText("  "+rollQty+" / 捲");
            Text_R = (TextView) findViewById(R.id.Text_R);
            Text_R.setText("工令單號"+MASTER_MFO_ID+"\n型號\t\t\t\t\t\t"+RTYPE+"\n阻值\t\t\t\t\t\t"+VAL+"\nTOL\t\t\t\t\t\t\t"+TOL+
                    "\n尺寸\t\t\t\t\t\t"+SIZE+"\n貼帶數量"+tieDaiQuant+"\n訂單量\t\t\t"+ORD_QTY+"(KPCS)");
        }
    };
    final Handler finsh_Handler = new Handler() {
        public void handleMessage(Message msg1) {
            super.handleMessage(msg1);

            AlertDialog.Builder builder = new AlertDialog.Builder(ShiftFlowActivity.this);
            builder.setMessage(Message);
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Text_L.setText("挪用工令單");
                    Text_R.setText("目標工令單");
                }
            });
            builder.show();
        }
    };

    public void start_move(View view) {

        //選捲數 * rollQty  radio=1 支數 2捲數 0未選
        int shifQuant= Integer.valueOf(submit_text.getText().toString());;
        if(radio==2){
            int rollQty_int= Integer.valueOf(rollQty);
            shifQuant=shifQuant*rollQty_int;
        }
        //leftQty
        int int_leftQty= Integer.valueOf(leftQty);//可挪量
        if (shifQuant>int_leftQty){
            AlertDialog.Builder builder = new AlertDialog.Builder(ShiftFlowActivity.this);
            builder.setMessage("可挪量不足");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
            builder.show();
        }else{
            call_rest restObj = new call_rest();
            JSONObject rtnRestObj = restObj.callRest(host + "PrdMgn/" +
                    "shiftTiedai?sourceBar="+sourceBar +
                    "&targetBar=" +targetBar+
                    "&shifQuant=" + shifQuant +"&empID="+userBar);
            mesgPent(rtnRestObj);
        }

    }
    public void mesgPent(JSONObject rtnRestObj) {
        try {
            Message = rtnRestObj.getString("Message")+rtnRestObj.getString("Data");
            Message m = new Message();
            m.what = MEG_INVALIDATE;
            finsh_Handler.sendMessage(m);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void r1(View view) {
        radio=1;
    }

    public void r2(View view) {
        radio=2;
    }

    public void move_bar(View view) {
        String targetMfono=bartext.getText().toString();
        if(targetMfono.equals("")){

            AlertDialog.Builder builder = new AlertDialog.Builder(ShiftFlowActivity.this);
            builder.setMessage("未輸入目標工令單或來源工令單號");
            builder.setCancelable(false);
            builder.setPositiveButton("確認", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
            builder.show();
        } if (submit_text.getText().toString().equals("")){

            AlertDialog.Builder builder = new AlertDialog.Builder(ShiftFlowActivity.this);
            builder.setMessage("未輸入數量");
            builder.setCancelable(false);
            builder.setPositiveButton("確認", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
            builder.show();
        }else {
            //[下午3:14] ICD-曾建明
            //    localhost:54791/PrdMgn/shiftTiedaiInByMFONO?sourceBar=4049-1-180558-0-%
            // &targetMfono=F-3-MAT22MA&shifQuant=2300&empID=B_006
            //選捲數 * rollQty  radio=1 支數 2捲數 0未選
            int shifQuant = Integer.valueOf(submit_text.getText().toString());
            if (radio == 2) {
                int rollQty_int = Integer.valueOf(rollQty);
                shifQuant = shifQuant * rollQty_int;
            }
            call_rest restObj = new call_rest();
            JSONObject rtnRestObj = restObj.callRest(host + "PrdMgn/" +
                    "shiftTiedaiInByMFONO?sourceBar=" + sourceBar +
                    "&targetMfono=" + targetMfono +
                    "&shifQuant=" + shifQuant + "&empID=" + userBar);

            if (!sourceBar.equals("")&&!rtnRestObj.equals("")){
                shiftbnt.setVisibility(VISIBLE);
            }
            mesgPent(rtnRestObj);
        }
    }

    Handler HmoreprogressBar = new Handler() {
        public void handleMessage(Message msg) {
            shiftbnt.setVisibility(VISIBLE);
            super.handleMessage(msg);
        }
    };
}