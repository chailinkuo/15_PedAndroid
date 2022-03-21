package com.example.firstohm_yu.newproject;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static android.view.View.GONE;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;
import static com.example.firstohm_yu.newproject.MainActivity.MEG_INVALIDATE;

public class adminActivity extends AppCompatActivity {
    String userselect_flag,barCode,mUSER_ID,loginuserBar,NG1,NG2,NG3,userBar,EMPNAME,ifLeader,name,Message,host,MASTER_MFO_ID,USER_ID,MachineID,SUBFLOWID,FLOWID,SIGNID,mfo_id,sumOfNaiBei,BASE_ID,DELDATE,RTYPE,BATCH_QTY,TOL,Size,VAL,BATSEQ,BATCH_NO,TestTimes,order_ppm,PPM,COLOR_NUM,CUTTYPE,START_TIME,FINISH_TIME,DONE_QTY,StepLeft,notec,popMsg,dy_msgdy_msg,lastSignID,MachineID_Befor,USER_ID_Befor,InputQuan,OutputQuan,AccQuan,FLOW_STEP,preNaiBei,DefectQuan;
    int NG_flag=0;
    final ArrayList<String> optionsu = new ArrayList<String>();
    final ArrayList<String> optionsm = new ArrayList<String>();
    final ArrayList<String> optionsi = new ArrayList<String>();
    final ArrayList<String> options = new ArrayList<String>();
    Button sucheck,submit;
    static ProgressBar adminprogressBar;
    int sumacc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        //取的intent中的bundle物件
        Bundle bundle =this.getIntent().getExtras();
        loginuserBar = bundle.getString("userBar");
        name=bundle.getString("name");
        host = bundle.getString("host");
        userselect_flag= bundle.getString("userselect_flag");
        SIGNID= bundle.getString("SIGNID");
        Spinner date_spinner=(Spinner)findViewById(R.id.date_spinner);
        LayoutInflater inflater = LayoutInflater.from(adminActivity.this);
        final View view = inflater.inflate(R.layout.activity_admin, null);
        final Spinner user_spinner=(Spinner)findViewById(R.id.user_spinner);
        final Spinner mid_spinner=(Spinner)findViewById(R.id.mid_spinner);
        final Spinner F_spinner=(Spinner)findViewById(R.id.F_spinner);
        TextView inp=(TextView)findViewById(R.id.editText62);
        TextView out=(TextView)findViewById(R.id.editText64);
        TextView def=(TextView)findViewById(R.id.editText65);
        TextView acc=(TextView)findViewById(R.id.editText66);
        inp.addTextChangedListener(textWatcher);
        out.addTextChangedListener(textWatcher);
        def.addTextChangedListener(textWatcher);
        acc.addTextChangedListener(textWatcher);
        submit=(Button) findViewById(R.id.button14);
        sucheck=(Button) findViewById(R.id.sucheck);
        TextView Title_NG1=(TextView)findViewById(R.id.Title_NG1);
        TextView Title_NG2=(TextView)findViewById(R.id.Title_NG2);
        TextView Title_NG3=(TextView)findViewById(R.id.Title_NG3);
        TextView Value_NG1=(TextView)findViewById(R.id.Value_NG1);
        TextView Value_NG2=(TextView)findViewById(R.id.Value_NG2);
        TextView Value_NG3=(TextView)findViewById(R.id.Value_NG3);
        adminprogressBar=(ProgressBar)findViewById(R.id.adminprogressBar);
        //先定義時間格式
        if (!userselect_flag.equals("0")){
            getFlow(view);
        }else{

            Date now = new Date();
            Date dts1=addAndSubtractDaysByCalendar(now,-1);
            Date dts2=addAndSubtractDaysByCalendar(now,-2);
            Date dts3=addAndSubtractDaysByCalendar(now,-3);
            Date dts4=addAndSubtractDaysByCalendar(now,-4);
            Date dts5=addAndSubtractDaysByCalendar(now,-5);
            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date current = new Date();
            options.add(sdFormat.format(current).toString());
            options.add(sdFormat.format(dts1).toString());
            options.add(sdFormat.format(dts2).toString());
            options.add(sdFormat.format(dts3).toString());
            options.add(sdFormat.format(dts4).toString());
            options.add(sdFormat.format(dts5).toString());
            Value_NG1.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count,int after) { }
                @Override
                public void onTextChanged(CharSequence s, int start, int before,int count) { }
                @Override
                public void afterTextChanged(Editable s) {
                    ///Message m = new Message();                m.what = MEG_INVALIDATE;                updatext.sendMessage(m);
                }});
            Value_NG3.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count,int after) { }
                @Override
                public void onTextChanged(CharSequence s, int start, int before,int count) { }
                @Override
                public void afterTextChanged(Editable s) {
                    //   Message m = new Message();                m.what = MEG_INVALIDATE;                updatext.sendMessage(m);
                }});
            Value_NG2.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count,int after) { }
                @Override
                public void onTextChanged(CharSequence s, int start, int before,int count) { }
                @Override
                public void afterTextChanged(Editable s) {
                    Message m = new Message();                m.what = MEG_INVALIDATE;                updatext.sendMessage(m);
                }});
            def.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count,int after) { }
                @Override
                public void onTextChanged(CharSequence s, int start, int before,int count) { }
                @Override
                public void afterTextChanged(Editable s) {
                    Message m = new Message();                m.what = MEG_INVALIDATE;                updatext2.sendMessage(m);
                }});
            out.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count,int after) { }
                @Override
                public void onTextChanged(CharSequence s, int start, int before,int count) { }
                @Override
                public void afterTextChanged(Editable s) {
                    Message m = new Message();                m.what = MEG_INVALIDATE;                updatext2.sendMessage(m);
                }});

            acc.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count,int after) { }
                @Override
                public void onTextChanged(CharSequence s, int start, int before,int count) { }
                @Override
                public void afterTextChanged(Editable s) {
                    //Message m = new Message();                m.what = MEG_INVALIDATE;                updatext2.sendMessage(m);
                }});
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,options);
            adapter.setDropDownViewResource(R.layout.spinner_layout);
            date_spinner.setAdapter(adapter);
            date_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                    Message msg1 = new Message();
                    msg1.what = MEG_INVALIDATE;
                    moreprogressBar.sendMessage(msg1);
                    getOpertorInfoByDate(view);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parentView) {

                }

            });
            user_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                    Message msg1 = new Message();
                    msg1.what = MEG_INVALIDATE;
                    moreprogressBar.sendMessage(msg1); getOpertorInfoByuser(view);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parentView) {

                }

            });
            mid_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                    Message msg1 = new Message();
                    msg1.what = MEG_INVALIDATE;
                    moreprogressBar.sendMessage(msg1);getSignsFromUserMachine(view);
                    //Supervisor_check(view);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parentView) {

                }

            });

            F_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                    Message msg1 = new Message();
                    msg1.what = MEG_INVALIDATE;
                    moreprogressBar.sendMessage(msg1); getFlow(view);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parentView) {

                }
            });
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        }
    }

    public void Supervisor_check(View view) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    loginuserBar = loginuserBar.replaceAll("\\*", "");
                    String encodedUrl = "";
                    encodedUrl = URLEncoder.encode(loginuserBar, "UTF-8");
                    call_rest restObj = new call_rest();
                    JSONObject rtnRestObj = restObj.callRest(host +
                            "/PrdMgn/getUserInfo?UID=" + encodedUrl );
                    try {
                        JSONArray array = new JSONArray(rtnRestObj.getString("Data"));
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject ob = array.getJSONObject(i);
                            ifLeader=ob.getString("ifLeader")== null ? "" : ob.getString("ifLeader");
                            Message m = new Message();
                            m.what = MEG_INVALIDATE;
                            ifLeader_handler.sendMessage(m);
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    //REhandler.sendMessage(m);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();  //user info
    }
    public void getOpertorInfoByDate(View view ) {
        try {
            call_rest restObj = new call_rest();
            Spinner date_spinner=(Spinner)findViewById(R.id.date_spinner);
            String date=date_spinner.getSelectedItem().toString();
            //System.out.println("facroryNo===>"+host+"PrdMgn/Login?userBar="+encodedUrl2+"&Dept="+encodedUrl3+"&facroryNo="+facroryNo);
            JSONObject rtnRestObj = restObj.callRest(host+"/PrdMgn/getOpertorInfoByDate?signDate="+date);
            fillUserPent(rtnRestObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getSignsFromUserMachine(View view ) { //Select mid
        try {
            call_rest restObj = new call_rest();
            //Spinner F_spinner=(Spinner)findViewById(R.id.F_spinner);
            //String ID=F_spinner.getSelectedItem().toString();
            Spinner date_spinner=(Spinner)findViewById(R.id.date_spinner);
            String date=date_spinner.getSelectedItem().toString();
            Spinner u_spinner=(Spinner)findViewById(R.id.user_spinner);
            String uid=u_spinner.getSelectedItem().toString();
            Spinner m_spinner=(Spinner)findViewById(R.id.mid_spinner);
            String mid=m_spinner.getSelectedItem().toString();
            String[] parts = uid.split("\\|");
            //GETMID TEST
            //String u=host+"/firstohmWebapi/PrdMgn/getSignsFromUserMachine?signDate="+date+"&userID="+uid+"&achineID="+mid;
            JSONObject rtnRestObj = restObj.callRest(host+"/PrdMgn/getSignsFromUserMachine?signDate="+date+"&userID="+parts[1]+"&machineID="+mid);
            //JSONObject rtnRestObj = restObj.callRest(host+"/firstohmWebapi/PrdMgn/getSignsFromUserMachine?signDate=2019-10-29&userID=B_006&machineID=A");
            fillflowPent(rtnRestObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void fillflowPent(JSONObject rtnRestObj) {
        try {
            optionsi.clear();

            try {
                JSONArray array = new JSONArray(rtnRestObj.getString("Data"));
                for (int i = 0; i < array.length(); i++) {
                    JSONObject ob = array.getJSONObject(i);
                    SIGNID = ob.getString("SIGNID") == null ? "" : ob.getString("SIGNID");
                    MASTER_MFO_ID = ob.getString("MASTER_MFO_ID") == null ? "" : ob.getString("MASTER_MFO_ID");
                    SIGNID=SIGNID+"|"+MASTER_MFO_ID;
                    optionsi.add(SIGNID);
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
            final ArrayAdapter<String> si_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,optionsi);
            si_adapter.setDropDownViewResource(R.layout.spinner_layout);

            Spinner si_spinner=(Spinner)findViewById(R.id.F_spinner);
           si_spinner.setAdapter(si_adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getFlow(View view ) {
        try {
            call_rest restObj = new call_rest();
            JSONObject rtnRestObj;
            if (!userselect_flag.equals("0")){;
                 rtnRestObj = restObj.callRest(host+"/PrdMgn/getSignInfo?signID="+SIGNID);

            }else{

                Spinner date_spinner=(Spinner)findViewById(R.id.date_spinner);
                Spinner F_spinner=(Spinner)findViewById(R.id.F_spinner);
                String date=date_spinner.getSelectedItem().toString();
                String FLOW=F_spinner.getSelectedItem().toString();
                String[] items;
                items = FLOW.split("\\|");
                 rtnRestObj = restObj.callRest(host+"/PrdMgn/getSignInfo?signID="+items[0]);

            }
            try {
                Thread.sleep(3000); //1000為1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fillflowINFOPent(rtnRestObj,view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getNG(View view ) {
        //System.out.println("nnnnnnnnnnnggggggggggggggggg");
        try {
            call_rest restObj = new call_rest();
            Spinner date_spinner=(Spinner)findViewById(R.id.date_spinner);
            Spinner F_spinner=(Spinner)findViewById(R.id.F_spinner);
            String date=date_spinner.getSelectedItem().toString();
            String FLOW=F_spinner.getSelectedItem().toString();
            String[] items;
            items = FLOW.split("\\|");
            System.out.println(host+"/PrdMgn/getOutChkInfo?SIGNID="+items[0]+"&outchk_SEQ=1");
            JSONObject rtnRestObj2 = restObj.callRest(host+"/PrdMgn/getOutChkInfo?SIGNID="+items[0]+"&outchk_SEQ=1");
            fillflowCheckout(rtnRestObj2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getOpertorInfoByuser(View view ) {
        try {
            Spinner date_spinner=(Spinner)findViewById(R.id.date_spinner);
            String date=date_spinner.getSelectedItem().toString();
            call_rest restObj = new call_rest();
            JSONObject rtnRestObj = restObj.callRest(host+"/PrdMgn/getOpertorInfoByDate?signDate="+date);
            fillmidPent(rtnRestObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void fillflowCheckout(JSONObject rtnRestObj2) {
        //System.out.println("000mid");
        try {
            JSONArray array2 = new JSONArray(rtnRestObj2.getString("Data"));
            for (int i = 0; i < array2.length(); i++) {
                JSONObject ob = array2.getJSONObject(i);
                NG1 = ob.getString("NG1") == null ? "" : ob.getString("NG1");
                NG2= ob.getString("NG2") == null ? "" : ob.getString("NG2");
                NG3= ob.getString("NG3") == null ? "" : ob.getString("NG3");
            }
            //System.out.println("ng123"+NG1+NG2+NG3);
            Message m = new Message();
            m.what = MEG_INVALIDATE;
            nghandler.sendMessage(m);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void fillmidPent(JSONObject rtnRestObj) {
        //System.out.println("000mid");
        Spinner u_spinner=(Spinner)findViewById(R.id.user_spinner);
        String uid=u_spinner.getSelectedItem().toString();
        String[] parts = uid.split("\\|");
        optionsm.clear();
        try {
            JSONArray array = new JSONArray(rtnRestObj.getString("Data"));
            for (int i = 0; i < array.length(); i++) {
                JSONObject ob = array.getJSONObject(i);
                MachineID = ob.getString("MachineID") == null ? "" : ob.getString("MachineID");
                mUSER_ID= ob.getString("USER_ID") == null ? "" : ob.getString("USER_ID");
                if(mUSER_ID.equals(parts[1])){
                    optionsm.add(MachineID);
                }

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        final ArrayAdapter<String> m_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,optionsm);
        m_adapter.setDropDownViewResource(R.layout.spinner_layout);
        Spinner mid_spinner=(Spinner)findViewById(R.id.mid_spinner);
        mid_spinner.setAdapter(m_adapter);
    }
    public void fillflowINFOPent(JSONObject rtnRestObj, View view) {
        try {
            JSONArray array = new JSONArray(rtnRestObj.getString("Data"));
            for (int i = 0; i < array.length(); i++) {
                JSONObject ob = array.getJSONObject(i);
                mfo_id=ob.getString("mfo_id")== null ? "" : ob.getString("mfo_id");
                BASE_ID=ob.getString("BASE_ID")== null ? "" : ob.getString("BASE_ID");
                DELDATE=ob.getString("DELDATE") == null ? "" : ob.getString("DELDATE");
                barCode=ob.getString("barCode") == null ? "" : ob.getString("barCode");
                RTYPE=ob.getString("RTYPE") == null ? "" : ob.getString("RTYPE");
                BATCH_QTY=ob.getString("BATCH_QTY") == null ? "" : ob.getString("BATCH_QTY");
                TOL=ob.getString("TOL") == null ? "" : ob.getString("TOL");
                Size=ob.getString("Size") == null ? "" : ob.getString("Size");
                USER_ID_Befor=ob.getString("USER_ID") == null ? "" : ob.getString("USER_ID");
                VAL=ob.getString("VAL") == null ? "" : ob.getString("VAL");
                BATSEQ=ob.getString("BATSEQ") == null ? "" : ob.getString("BATSEQ");
                BATCH_NO=ob.getString("BATCH_NO") == null ? "" : ob.getString("BATCH_NO");
                PPM=ob.getString("PPM") == null ? "" : ob.getString("PPM");
                COLOR_NUM=ob.getString("COLOR_NUM") == null ? "" : ob.getString("COLOR_NUM");
               BATCH_NO=ob.getString("BATCH_NO") == null ? "" : ob.getString("BATCH_NO");
                BATCH_QTY=ob.getString("BATCH_QTY") == null ? "" : ob.getString("BATCH_QTY");
                SUBFLOWID=ob.getString("SUBFLOWID") == null ? "" : ob.getString("SUBFLOWID");
                DONE_QTY=ob.getString("DONE_QTY") == null ? "" : ob.getString("DONE_QTY");
                InputQuan=ob.getString("InputQuan") == null ? "" : ob.getString("InputQuan");  //開始
                OutputQuan=ob.getString("OutputQuan") == null ? "" : ob.getString("OutputQuan");
                AccQuan=ob.getString("AccQuan") == null ? "" : ob.getString("AccQuan");
                FLOW_STEP=ob.getString("FLOW_STEP") == null ? "" : ob.getString("FLOW_STEP");
                DefectQuan=ob.getString("DefectQuan") == null ? "" : ob.getString("DefectQuan");
                //System.out.println("===>"+FLOW_STEP);
                Message m = new Message();
                m.what = MEG_INVALIDATE;
                handler.sendMessage(m);
                if(FLOW_STEP.indexOf("外檢")>-1){
                    NG_flag=1;
                    getNG(view);
                }else{
                    NG_flag=0;
                    TextView Title_NG1=(TextView)findViewById(R.id.Title_NG1);
                    TextView Title_NG2=(TextView)findViewById(R.id.Title_NG2);
                    TextView Title_NG3=(TextView)findViewById(R.id.Title_NG3);
                    TextView Value_NG1=(TextView)findViewById(R.id.Value_NG1);
                    TextView Value_NG2=(TextView)findViewById(R.id.Value_NG2);
                    TextView Value_NG3=(TextView)findViewById(R.id.Value_NG3);
                    Title_NG1.setVisibility(INVISIBLE);Title_NG2.setVisibility(INVISIBLE);Title_NG3.setVisibility(INVISIBLE);
                    Value_NG1.setVisibility(INVISIBLE);Value_NG2.setVisibility(INVISIBLE);Value_NG3.setVisibility(INVISIBLE);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void fillUserPent(JSONObject rtnRestObj) {
        try {
            JSONArray array = new JSONArray(rtnRestObj.getString("Data"));
            Message = rtnRestObj.getString("Message");
            optionsu.clear();
            String temp="";
            for (int i = 0; i < array.length(); i++) {
                JSONObject ob = array.getJSONObject(i);
                USER_ID = ob.getString("USER_ID") == null ? "" : ob.getString("USER_ID");
                EMPNAME = ob.getString("EMPNAME") == null ? "" : ob.getString("EMPNAME");
                if (!temp.equals(USER_ID))optionsu.add(EMPNAME+"|"+USER_ID);
                temp=USER_ID;
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        final ArrayAdapter<String> u_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,optionsu);
        u_adapter.setDropDownViewResource(R.layout.spinner_layout);
        Spinner user_spinner=(Spinner)findViewById(R.id.user_spinner);
        user_spinner.setAdapter(u_adapter);
    }


    Handler handler = new Handler()
    {
        public void handleMessage(Message msg)
        {
            TextView info=(TextView)findViewById(R.id.info);
            TextView info2=(TextView)findViewById(R.id.info2);
            TextView inp=(TextView)findViewById(R.id.editText62);
            TextView out=(TextView)findViewById(R.id.editText64);
            TextView def=(TextView)findViewById(R.id.editText65);
            TextView acc=(TextView)findViewById(R.id.editText66);
            String no="";
            inp.setText(InputQuan);
            out.setText(OutputQuan);
            def.setText(DefectQuan);
            info.setGravity(Gravity.RIGHT);
            try {
                int in = Integer.valueOf(BATSEQ);
                in = in + 1;
                no=in + " / " + BATCH_NO;
            } catch (NullPointerException e) {
            }
            String in="工令單號\t"+"\n" +
                    "支數\t\n" +
                    "流程單號\t\n" +
                    "阻值範圍\t\n" +
                    "阻值\t\n" +
                    "PPM\t\n" ;
            String in2="\t"+mfo_id+"\n" +
                    "\t"+BATCH_QTY+"\n" +
                    "\t"+no+"\n" +
                    "\t"+VAL+"\n" +
                    "\t"+TOL+"\n" +
                    "\t"+PPM+"\n" ;
            info.setText(in);
            info2.setText(in2);
            adminprogressBar.setVisibility(GONE);
        }
        //get flow end

    };

    public static Date addAndSubtractDaysByCalendar(Date dateTime/*待處理的日期*/,int n/*加減天數*/){
//日期格式
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dd=new SimpleDateFormat("yyyy-MM-dd");
        java.util.Calendar calstart = java.util.Calendar.getInstance();
        calstart.setTime(dateTime);
        calstart.add(java.util.Calendar.DAY_OF_WEEK, n);
        System.out.println(df.format(calstart.getTime()));
        return calstart.getTime();
    }

    public void submit(View view) {  //送出
        TextView info=(TextView)findViewById(R.id.info);
        TextView info2=(TextView)findViewById(R.id.info2);
        TextView inp=(TextView)findViewById(R.id.editText62);
        TextView acc=(TextView)findViewById(R.id.editText66);
        Spinner F_spinner=(Spinner)findViewById(R.id.F_spinner);
        if(NG_flag==1){///update ng
            TextView Value_NG1=(TextView)findViewById(R.id.Value_NG1);
            TextView Value_NG2=(TextView)findViewById(R.id.Value_NG2);
            TextView Value_NG3=(TextView)findViewById(R.id.Value_NG3);
            NG1=Value_NG1.getText().toString();
            NG2=Value_NG2.getText().toString();
            NG3=Value_NG3.getText().toString();
            call_rest restObj2 = new call_rest();
            String FLOW1=F_spinner.getSelectedItem().toString();
            String[] items1;
            items1 = FLOW1.split("\\|");
            call_rest restObj = new call_rest();
            JSONObject rtnRestObj2 = restObj.callRest(host + "PrdMgn/updOutCheckLog?" +
                    "flowBar="+barCode+"&NG1="+NG1+"&NG2="+NG2
                    +"&NG3="+NG3+"&checkourSeq=1&signID="+items1[0]+"&preOperatorID="+USER_ID_Befor );
            String g = rtnRestObj2.toString();
        }
        /////////sumit
        try {
            call_rest restObj2 = new call_rest();
            if(!SIGNID.equals("")){

            }else {

                String FLOW=F_spinner.getSelectedItem().toString();
                String[] items;
                items = FLOW.split("\\|");
                SIGNID=items[0];
            }

            TextView out=(TextView)findViewById(R.id.editText64);
            TextView def=(TextView)findViewById(R.id.editText65);
            OutputQuan=out.getText().toString();
            DefectQuan=def.getText().toString();
            String u=host+"PrdMgn/reviseSignInfo?signID="+SIGNID+
                    "&outputQuan="+OutputQuan+"&defectQuan="+DefectQuan+"&note=abcde&userName="+name;
            JSONObject rtnRestObj = restObj2.callRest(
                    host+"/PrdMgn/reviseSignInfo?signID="
                    +SIGNID+"&outputQuan="+OutputQuan+"&defectQuan="+DefectQuan+"&note=abcde&userName="+name);
            String k = rtnRestObj.toString();
            System.out.println(k);
            System.out.println(u);
            Message m = new Message();
            m.what = MEG_INVALIDATE;
            handlerf.sendMessage(m);
            ///////////UPDATE NG
            //
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    Handler handlerf = new Handler()
    {
        public void handleMessage(Message msg)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(adminActivity.this);
            builder.setMessage("修改完成");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    if (!userselect_flag.equals("0")) {
                        finish();
                    }
                }
            });
            builder.show();
        }
    };
    Handler update_submit = new Handler()
    {
        public void handleMessage(Message msg, View view)
        {
            Supervisor_check(view);

        }
    };
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub
            try {
                TextView inp=(TextView)findViewById(R.id.editText62);
                TextView out=(TextView)findViewById(R.id.editText64);
                TextView def=(TextView)findViewById(R.id.editText65);
                TextView acc=(TextView)findViewById(R.id.editText66);

                int in = Integer.valueOf(inp.getText().toString());
                int fi = Integer.valueOf(out.getText().toString());
                int fu = Integer.valueOf(def.getText().toString());
                sumacc = in - fi - fu;
                Message m = new Message();
                m.what = MEG_INVALIDATE;
                updateacc.sendMessage(m);
            } catch (Exception e) {

            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
            // TODO Auto-generated method stub
            //System.out.println("beforeTextChanged--------------->");
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            //System.out.println("onTextChanged--------------->");
        }
    };

    final Handler ifLeader_handler = new Handler() {
        public void handleMessage(Message msg1) {
            super.handleMessage(msg1);
            submit.performClick();
/*
            Spinner u_spinner=(Spinner)findViewById(R.id.user_spinner);
            String uid=u_spinner.getSelectedItem().toString();
            String[] parts = uid.split("\\|");
            if (ifLeader.equals("1")){
                submit.setEnabled(true);submit.performClick();

            }else if(loginuserBar.equals(parts[1])){
                submit.setEnabled(true);

            }else
            {

                AlertDialog.Builder builder = new AlertDialog.Builder(adminActivity.this);
                builder.setMessage("權限不足無法修改");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
                builder.show();
                submit.setEnabled(false);
            }*/
        }
    };
    final Handler updatext = new Handler() {
        public void handleMessage(Message msg1) {
            try {
                //////算ng
                TextView Value_NG1 = (TextView) findViewById(R.id.Value_NG1);
                TextView Value_NG2 = (TextView) findViewById(R.id.Value_NG2);
                TextView Value_NG3 = (TextView) findViewById(R.id.Value_NG3);
                if (Value_NG1.getText().toString().equals("")) Value_NG1.setText("0");
                if (Value_NG2.getText().toString().equals("")) Value_NG2.setText("0");
                if (Value_NG3.getText().toString().equals("")) Value_NG3.setText("0");
                int ngg1, ngg2, ngg3;
                ngg1 = Integer.valueOf(Value_NG1.getText().toString());
                ngg2 = Integer.valueOf(Value_NG2.getText().toString());
                ngg3 = Integer.valueOf(Value_NG3.getText().toString());
                int sum = ngg1 + ngg2 + ngg3;
                String stringValue = Integer.toString(sum);
                TextView editText65 = (TextView) findViewById(R.id.editText65);
                editText65.setText(stringValue);
                /////////////////////////////////////

            } catch (Exception e) {

            }
        }
    };

    final Handler updatext2 = new Handler() {
        public void handleMessage(Message msg1) {
            try{
                TextView inp=(TextView)findViewById(R.id.editText62);
                TextView out=(TextView)findViewById(R.id.editText64);
                TextView def=(TextView)findViewById(R.id.editText65);
                TextView acc=(TextView)findViewById(R.id.editText66);
                if (inp.getText().toString().equals("")) inp.setText("0");
                if (out.getText().toString().equals("")) out.setText("0");
                if (def.getText().toString().equals("")) def.setText("0");
                int inp1, out1, def1;
                inp1 = Integer.valueOf(inp.getText().toString());
                out1 = Integer.valueOf(out.getText().toString());
                def1 = Integer.valueOf(def.getText().toString());
                int sum2 = inp1 - out1 - def1;
                String stringValue2 = Integer.toString(sum2);
                acc.setText(stringValue2);
            } catch (Exception e) {

            }
        }
    };


    final Handler updateacc = new Handler() {
        public void handleMessage(Message msg1) {
            super.handleMessage(msg1);
            try {
                TextView acc=(TextView)findViewById(R.id.editText66);
                String i=String.valueOf(sumacc);
                acc.setText(i);
            } catch (Exception e) {
                TextView acc=(TextView)findViewById(R.id.editText66);

            }
        }
    };
    final Handler nghandler = new Handler() {
        public void handleMessage(Message msg1) {
            super.handleMessage(msg1);
            try {
                TextView Title_NG1=(TextView)findViewById(R.id.Title_NG1);
                TextView Title_NG2=(TextView)findViewById(R.id.Title_NG2);
                TextView Title_NG3=(TextView)findViewById(R.id.Title_NG3);
                TextView Value_NG1=(TextView)findViewById(R.id.Value_NG1);
                TextView Value_NG2=(TextView)findViewById(R.id.Value_NG2);
                TextView Value_NG3=(TextView)findViewById(R.id.Value_NG3);
                Title_NG1.setVisibility(VISIBLE);Title_NG2.setVisibility(VISIBLE);Title_NG3.setVisibility(VISIBLE);
                Value_NG1.setVisibility(VISIBLE);Value_NG2.setVisibility(VISIBLE);Value_NG3.setVisibility(VISIBLE);
                Value_NG1.setText(NG1);
                Value_NG2.setText(NG2);
                Value_NG3.setText(NG3);
            } catch (Exception e) {

            }
        }
    };
    Handler moreprogressBar = new Handler() {
        public void handleMessage(Message msg) {
            adminprogressBar.setVisibility(VISIBLE);
            super.handleMessage(msg);
        }
    };
    Handler HmoreprogressBar = new Handler() {
        public void handleMessage(Message msg) {
            adminprogressBar.setVisibility(GONE);
            super.handleMessage(msg);
        }
    };
}
