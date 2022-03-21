package com.example.firstohm_yu.newproject;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.chip.ChipGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;
import static com.example.firstohm_yu.newproject.adminActivity.addAndSubtractDaysByCalendar;

public class platingActivity<current> extends AppCompatActivity {
    private int checkNum; // 记录选中的条目数量
    String strflow,flowBar,Process,Message,mfo_id,subit="",startDate="",machineID="";
    JSONObject g_list, dataobj, testarrobj, g_json,preNaiBeiJson;
    String packID,BatchID,Str_diffWeight_texted2="0",Str_stdWeight="0",Str_diffWeight="0",Str_diffVal="0",Str_ifSameSize="0",packBID,packAID;
    int select_flag=1,auto_flag=0;
    public ArrayList<HashMap<String, String>> list;

    String action,MID="",click,jsonStr,g_json_string = "",selectedJson_sring;//g_json_string
    TextView info_title,info_value,selectedJson;
    final ArrayList<String> options = new ArrayList<String>();
    final Map<String, String> submit_flow_list = new HashMap<String, String>();
    JSONArray contactsObj;
    ListView listview,listview2;
    private HashMap<Integer, Boolean> hashMap = new HashMap<Integer,Boolean>();
    private List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
    final List<Map<String, Object>> mList= new ArrayList<Map<String,Object>>();
    final List<Map<String, Object>> mList2= new ArrayList<Map<String,Object>>();
    Button bnt_sumit_spil;
    CheckBox checkBox3;
    int over_ch=0,error_range=20;
    SimpleAdapter adapter2,adapter3;
    String verified_F="",pack,barCodeType,day,url_stting , host,userBar,sunNaiBei,BASE_ID,StepLeft,DELDATE,RTYPE,BATCH_QTY,TOL,Size,VAL,BATSEQ,BATCH_NO,TestTimes,order_ppm,PPM ,COLOR_NUM,CUTTYPE,START_TIME,FINISH_TIME ,SUBFLOWID ,DONE_QTY,USER_ID,SIGNID ,notec ,MachineID_Befor,USER_ID_Befor,InputQuan,AccQuan ,FLOW_STEP ,preNaiBei,ACCDefect,StaticParams;
    Spinner date_spinner,Process_spinner,MEGA_spinner1;
    final ArrayList<String> options_date= new ArrayList<String>();
    final ArrayList<String> options_Process= new ArrayList<String>();
    final ArrayList<String> options_MEGA= new ArrayList<String>();
    final ArrayList<String> options_MEGA2= new ArrayList<String>();
    RadioGroup radioGroup;


    //先行定義時間格式
    Date now = new Date();
    Date dts1=addAndSubtractDaysByCalendar(now,-1);
    Date dts2=addAndSubtractDaysByCalendar(now,-2);
    Date dts3=addAndSubtractDaysByCalendar(now,-3);
    Date dts4=addAndSubtractDaysByCalendar(now,-4);
    Date dts5=addAndSubtractDaysByCalendar(now,-5);
    Date dts6=addAndSubtractDaysByCalendar(now,-6);
    Date dts7=addAndSubtractDaysByCalendar(now,-7);
    Date dts8=addAndSubtractDaysByCalendar(now,-8);
    Date dts9=addAndSubtractDaysByCalendar(now,-9);
    Date dts10=addAndSubtractDaysByCalendar(now,-10);
    SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle =this.getIntent().getExtras();
        userBar = bundle.getString("userBar");
        day = bundle.getString("startday");
        machineID = "";
        MID = bundle.getString("MachineID","");
        host = bundle.getString("host");
        //host=host+"firstohmWebapi/";
        userBar = userBar.replaceAll("\\*", "");
        String error_ranget= bundle.getString("error_range","1");
        error_range=Integer.valueOf(error_ranget);
        action = bundle.getString("action");  // start / finsh
        setContentView(R.layout.activity_plating);
        Button list_bnt,finsh_bnt;
        //host="http://220.128.234.48:1119/";
        finsh_bnt = (Button) findViewById(R.id.finsh_bnt);
        //list_bnt = (Button) findViewById(R.id.list_bnt);
        //list_bnt.setOnClickListener(get_flow);
        Process_spinner=(Spinner)findViewById(R.id.Process_spinner);
        date_spinner=(Spinner)findViewById(R.id.date_spinner1);
        MEGA_spinner1=(Spinner)findViewById(R.id.MEGA_spinner1);
        Date current = new Date();
        options_date.add(sdFormat.format(current).toString());
        options_date.add(sdFormat.format(dts1).toString());
        options_date.add(sdFormat.format(dts2).toString());
        options_date.add(sdFormat.format(dts3).toString());
        options_date.add(sdFormat.format(dts4).toString());
        options_date.add(sdFormat.format(dts5).toString());
        options_date.add(sdFormat.format(dts6).toString());
        options_date.add(sdFormat.format(dts7).toString());
        options_date.add(sdFormat.format(dts8).toString());
        options_date.add(sdFormat.format(dts9).toString());
        options_date.add(sdFormat.format(dts10).toString());
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,options_date);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        date_spinner.setAdapter(adapter);
        options_Process.add("花蓮底漆");
        options_Process.add("花蓮色碼");
        final ArrayAdapter<String> Process_adapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,options_Process);
        Process_adapter.setDropDownViewResource(R.layout.spinner_layout);
        Process_spinner.setAdapter(Process_adapter);
        options_MEGA.add("廠別");
        options_MEGA.add("CS");
        options_MEGA.add("EG");
        options_MEGA.add("JK");
        options_MEGA2.add("廠別");
        options_MEGA2.add("CS");
        options_MEGA2.add("EG");
        options_MEGA2.add("JK");
        options_MEGA2.add("全部");
        final ArrayAdapter<String> MEGA_adapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,options_MEGA);
        MEGA_adapter.setDropDownViewResource(R.layout.spinner_layout);
        MEGA_spinner1.setAdapter(MEGA_adapter);
        MEGA_spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                machineID = MEGA_spinner1.getSelectedItem().toString();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });
        //radioGroup = (RadioGroup) findViewById(R.id.midsele);
        /*if (action.equals("start")){
            list_bnt.performClick();
        }else if (action.equals("finsh")){
            finsh_bnt.performClick();
        }else{
            flansh();
        }*/
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    private View.OnClickListener get_flow = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            click="start";
            show(v);
        }
    };

    public void finish(View view) {
        click="finish";
        startDate=date_spinner.getSelectedItem().toString();
        //machineID=radioButton.getText().toString();
        show(view);
    }
    //排除電鍍
    public void show(View view) {
        if(machineID.equals("") ||machineID.equals("廠別")){

            AlertDialog.Builder builder = new AlertDialog.Builder(platingActivity.this);
            builder.setMessage("請選擇廠別");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
            builder.show();
        }else
        {
            JSONObject rtnRestObj;JSONArray array;
            try {
                url_stting = host + "PrdMgn/getPlattingInit";
                call_rest restObj = new call_rest();
                rtnRestObj = restObj.callRest(url_stting);
                g_json_string = rtnRestObj.getString("Data");
                fillPent(rtnRestObj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
    //排除電鍍
    public void fillPent(final JSONObject rtnRestObj) {
        try {
            JSONArray array = new JSONArray(rtnRestObj.getString("Data"));
            Message = "Message";
            ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
            options.clear();
            mList.clear();
            machineID = machineID.replaceAll("&machineID=", "");
            machineID = URLEncoder.encode(machineID, "UTF-8");
            options.add("ID\t\t\t\tsignID" + "\t\t\t\t工令單號\t\t\t\t\t\t型號\t\t\t\t\t阻值\t\t\t\t流程單號\t\t\t送出量");
            click="start";
            if (click.equals("start")) {
                for (int i = 0; i < array.length(); i++) {
                    Map<String, Object> itemBooks = new HashMap<String, Object>();
                    JSONObject ob2 = array.getJSONObject(i);
                    String MASTER_MFO_ID = ob2.getString("MASTER_MFO_ID");
                    String RTYPE = ob2.getString("RTYPE");
                    String VAL = ob2.getString("VAL");
                    String Tol = ob2.getString("Tol");
                    String Flow_Step = ob2.getString("FLOW_STEP");
                    String OutputQuan = ob2.getString("OutputQuan");
                    String plattingType = ob2.getString("plattingType");
                    String subflowID = ob2.getString("subflowID");
                    String splitWeight = ob2.getString("splitWeight");
                    String SID = ob2.getString("SID");
                    String batchNo = ob2.getString("batchNo");
                    String size = ob2.getString("size");
                    itemBooks.put("MASTER_MFO_ID", MASTER_MFO_ID);
                    itemBooks.put("subflowID", subflowID);
                    itemBooks.put("status", "0");
                    itemBooks.put("RTYPE", RTYPE);
                    itemBooks.put("SID", SID);
                    itemBooks.put("VAL", VAL);
                    itemBooks.put("size", size);
                    itemBooks.put("batchNo", batchNo);
                    itemBooks.put("OutputQuan", OutputQuan);
                    itemBooks.put("Flow_Step", Flow_Step);
                    itemBooks.put("Tol", Tol);
                    /*if (plattingType.equals("0")){plattingType="庫存";}else
                    if (plattingType.equals("1")){plattingType="色碼";}else
                    if (plattingType.equals("2")){plattingType="底漆";}*/
                    itemBooks.put("plattingType", plattingType);
                    itemBooks.put("splitWeight", splitWeight);
                    mList.add(itemBooks);

                }
            }
            LayoutInflater inflater = LayoutInflater.from(platingActivity.this);

            final View v2 = inflater.inflate(R.layout.views, null);   //   get viwe layout\
            final View v3 = inflater.inflate(R.layout.plating_seletion2, null);   //   get viwe layout\
            final AlertDialog.Builder dialog = new AlertDialog.Builder(platingActivity.this);
            bnt_sumit_spil=(Button) v2.findViewById(R.id.bnt_sumit_spil);
            listview = (ListView) v2.findViewById(R.id.dynamic);
            final CheckBox checkBox_over=(CheckBox) v2.findViewById(R.id.checkBox_over);
            final Button cls_bnt=(Button) v2.findViewById(R.id.cls_bnt);
            final Button select_all=(Button) v2.findViewById(R.id.select_all);
            final Button quick_bnt=(Button) v2.findViewById(R.id.quick_bnt);
            final Button not_spil=(Button) v2.findViewById(R.id.del_item);
            final Button remove_item=(Button) v2.findViewById(R.id.remove_item);

            dialog.setCancelable(true);
            final AlertDialog dlg;
            dialog.setView(v2);
            TextView title = new TextView(this);
            checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
            ImageButton delButton= (ImageButton) v3.findViewById(R.id.delButton);
            adapter2 = new MySimpleAdapter(this, mList, R.layout.plating_seletion2,
                    new String[]{"status","MASTER_MFO_ID", "RTYPE", "VAL", "OutputQuan","batchNo","size", "plattingType",
                            "splitWeight","SID","Tol","Flow_Step","subflowID"},
                    new int[]{R.id.checkBox3, R.id.SIGNID, R.id.textView44, R.id.textView45,  R.id.textView451, R.id.textView452,  R.id.textView46,
                            R.id.textView47,
                            R.id.editText63,R.id.textView25,R.id.Tol,R.id.Flow_Step,R.id.subflowID});
            listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
            listview.setAdapter(adapter2);
            View header = (View)getLayoutInflater().inflate(R.layout.plating_seletion_headr,null);
            listview.addHeaderView(header);
            title.setGravity(Gravity.CENTER);
            title.setTextSize(24);
            dialog.setCustomTitle(title);
            dialog.setView(v2);
            dlg = dialog.show();
            //InputPlattingInit 拆單submit
            bnt_sumit_spil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedJson_sring = "";
                    if (checkBox_over.isChecked()==true){over_ch=1;}else{over_ch=0;}
                    int error_flag=0;
                    if (error_flag==0){
                        JSONArray json_arr=new JSONArray();
                        for (Map<String, Object> map : mList) {
                            JSONObject json_obj = new JSONObject();
                            for (Map.Entry<String, Object> entry : map.entrySet()) {
                                String key = entry.getKey();
                                Object value = entry.getValue();
                                try {
                                    json_obj.put(key, value);
                                } catch (JSONException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                            }
                            json_arr.put(json_obj);
                        }
                        View rootView = getWindow().getDecorView().getRootView();
                        Log.d("kuo",mList.toString());
                        InputPlattingInit(rootView);
                        dlg.dismiss();
                    }
                }
            });  //1.排除刪除
            remove_item.setVisibility(VISIBLE);
            remove_item.setText("確認送電鍍");
            remove_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("kuo","mList.size()"+mList.size());
                    for (int k=0; k<=5;k++){

                        for (int i = 0; i < mList.size(); i++) {
                            if (mList.get(i).get("status").equals("0")){
                                mList.remove(i);
                                Log.d("kuo","re"+i);
                            }
                            Log.d("kuo","nore"+i);
                        }
                        adapter2.notifyDataSetChanged();
                    }

                    }
                });
            //1.排除電鍍
            not_spil.setVisibility(View.GONE);
            not_spil.setText("不拆送出");
            not_spil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {//不拆送出
                    selectedJson_sring = "";
                    if (checkBox_over.isChecked()==true){over_ch=1;}else{over_ch=0;}
                    int error_flag=0,skip=0;
                    if (error_flag==0){
                        JSONArray json_arr=new JSONArray();
                        for (Map<String, Object> map : mList) {
                            JSONObject json_obj = new JSONObject();
                            skip=0;
                            for (Map.Entry<String, Object> entry : map.entrySet()) {
                                String key = entry.getKey();
                                Object value = entry.getValue();
                                try {
                                    if (key.equals("status")&&value.equals("1")) {

                                    }else{
                                        skip=1;
                                    }json_obj.put(key, value);
                                } catch (JSONException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                            }
                            if (skip==1){
                                json_arr.put(json_obj);
                            }

                        }
                        View rootView = getWindow().getDecorView().getRootView();
                        Log.d("kuo",json_arr.toString());
                        InputPlattingInit(rootView);
                        dlg.dismiss();
                    }
                }
            });


            select_all.setVisibility(VISIBLE);//全選
            select_all.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int i = 0; i < mList.size(); i++) {
                        mList.get(i).put("status", select_flag);
                    }
                    if(select_flag==1){
                        select_flag=0;
                    }else{
                        select_flag=1;
                    }
                    adapter2.notifyDataSetChanged();

                }
            });
            quick_bnt.setVisibility(VISIBLE);
            quick_bnt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LayoutInflater inflater = LayoutInflater.from(platingActivity.this);
                    final View v_box = inflater.inflate(R.layout.plating_quick_search, null);
                    AlertDialog.Builder dialog = new AlertDialog.Builder(platingActivity.this);
                    final TextView textView68=v_box.findViewById(R.id.textView68);
                    dialog.setView(v_box);
                    dialog.setPositiveButton("送出", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {//送出速碼
                            final EditText subflowID_T=v_box.findViewById(R.id.editText67);
                            for (int i = 0; i < mList.size(); i++) {
                                if (mList.get(i).get("subflowID").toString().indexOf(subflowID_T.getText().toString())>-1){
                                    adapter2.notifyDataSetChanged();
                                    mList.get(i).put("status", select_flag);
                                    listview.setSelection(i);
                                    break;
                                }
                            }
                            if(select_flag==1){
                                select_flag=0;
                            }else{
                                select_flag=1;
                            }
                        }
                    });
                    dialog.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //mothing
                        }
                    });
                    AlertDialog dlg = dialog.show();
                    WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
                    //視窗長寬
                    params.width = 1000;
                    params.height = 700;
                    //button text size
                    dlg.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
                    dlg.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
                    dlg.getWindow().setAttributes(params);
                }
            });
            cls_bnt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dlg.dismiss();
                }
            });
            WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
            //視窗長寬
            params.width = 1800;
            params.height = 1000;
            dlg.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
            dlg.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
            dlg.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
            dlg.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
            dlg.getWindow().setAttributes(params);
            showmessage("請先刪除不送電鍍的資料再輸入勾選");
        } catch (Exception e) {
            AlertDialog.Builder builder = new AlertDialog.Builder(platingActivity.this);
            builder.setMessage("沒有資料");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
            builder.show();
        }
    }

    //手動併單
    public void fillPent_confirm(final JSONObject rtnRestObj) {
        try {
            JSONArray array = new JSONArray(rtnRestObj.getString("Data"));
            Message = "Message";
            ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
            options.clear();
            mList.clear();
            machineID = machineID.replaceAll("&machineID=", "");
            machineID = URLEncoder.encode(machineID, "UTF-8");
            options.add("ID\t\t\t\tsignID" + "\t\t\t\t工令單號\t\t\t\t\t\t型號\t\t\t\t\t阻值\t\t\t\t流程單號\t\t\t送出量");
            click = "start";
            if (click.equals("start")) {
                for (int i = 0; i < array.length(); i++) {
                    Map<String, Object> itemBooks = new HashMap<String, Object>();
                    JSONObject ob2 = array.getJSONObject(i);

                    String PackID = ob2.getString("PackID");
                    String MASTER_MFO_ID = ob2.getString("MASTER_MFO_ID");
                    String RTYPE = ob2.getString("RTYPE");
                    String Val = ob2.getString("Val");
                    String Size = ob2.getString("Size");
                    itemBooks.put("PackID", PackID);
                    itemBooks.put("MASTER_MFO_ID", MASTER_MFO_ID);
                    itemBooks.put("RTYPE", RTYPE);
                    itemBooks.put("Val", Val);
                    itemBooks.put("Size", Size);
                    mList.add(itemBooks);
                }
            }
            LayoutInflater inflater = LayoutInflater.from(platingActivity.this);
            final View v = inflater.inflate(R.layout.views, null);   //   get viwe layout\
            //listview
            final View v2 = inflater.inflate(R.layout.plating_seletion_notext, null);   //   get viwe layout\
            final AlertDialog.Builder dialog = new AlertDialog.Builder(platingActivity.this);
            bnt_sumit_spil = (Button) v.findViewById(R.id.bnt_sumit_spil);
            listview = (ListView) v.findViewById(R.id.dynamic);
            final Button cls_bnt = (Button) v.findViewById(R.id.cls_bnt);
            dialog.setCancelable(true);
            final AlertDialog dlg;
            dialog.setView(v2);
            TextView title = new TextView(this);
            if (click.equals("start")) {
                title.setText("勾選送電鍍"+MID+"(電鍍)數量");
            } else {
                title.setText("電鍍完成");
            }
            checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
            adapter2 = new MySimpleAdapter(this, mList, R.layout.plating_seletion_conf,
                    new String[]{"PackID","MASTER_MFO_ID","RTYPE","Val","Size"},
                    new int[]{R.id.textView25,R.id.SIGNID,R.id.textView44,R.id.textView45,R.id.textView46});
            listview.setAdapter(adapter2);
            title.setGravity(Gravity.CENTER);
            title.setTextSize(24);
            dialog.setCustomTitle(title);
            dialog.setView(v);
            dlg = dialog.show();
            bnt_sumit_spil.setText("配對");


            bnt_sumit_spil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedJson_sring = "";
                    int error_flag=0;
                    for (int i = 0; i < listview.getChildCount(); i++) {
                        error_flag=0;
                        View view = listview.getChildAt(i);
                        CheckBox C3 = view.findViewById(R.id.checkBox3);
                        TextView PackID= view.findViewById(R.id.textView25);
                        if (C3.isChecked()) {
                            if (i >= 1 && !selectedJson_sring.equals("")) {
                                selectedJson_sring = selectedJson_sring + ",";
                            }
                            selectedJson_sring=selectedJson_sring+PackID.getText().toString();

                        }
                        C3.setChecked(false);
                    }
                    System.out.println("PackID===>"+selectedJson_sring);

                    View rootView = getWindow().getDecorView().getRootView();
                    InputPlattingInit(rootView);
                    //if (error_flag==0){
                        dlg.dismiss();
                    //}
                }
            });

            cls_bnt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(int i = 0; i<listview.getChildCount();i++) {
                        View view = listview.getChildAt(i);
                        CheckBox C3 = view.findViewById(R.id.checkBox3);
                        TextView PackID = view.findViewById(R.id.textView25);
                        C3.setChecked(false);
                    }
                    dlg.dismiss();
                }
            });
            WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
            //視窗長寬
            params.width = 1800;
            params.height = 1000;
            dlg.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
            dlg.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
            dlg.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
            dlg.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
            dlg.getWindow().setAttributes(params);
        } catch (Exception e) {
            AlertDialog.Builder builder = new AlertDialog.Builder(platingActivity.this);
            builder.setMessage("沒有資料");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                }
            });
            builder.show();
        }
    }

    private void InputPlattingInit(View rootView) {
        //selectedJson_sring7
        Date todayDate = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String todayString = formatter.format(todayDate);
        String url=host+"PrdMgn/InputPlattingInit?" +
                "expectReceive="+todayString +
                "&userID="+userBar+
                "&supplier="+machineID;
        if (over_ch==1){
            url=url+"&resetFlag=1";
        }else{
            url=url+"&resetFlag=0";
        }
        String platingJson="["+selectedJson_sring+"]";
        List myList = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(mList);
        System.out.println(url+"&platingJson="+jsonArray.toString());
        call_rest restObj = new call_rest();
        JSONObject rtnRestObj = restObj.postRest_platingdata(url,"platingJson",jsonArray.toString());
        try{
            g_json_string = rtnRestObj.getString("Data");
            if (g_json_string.indexOf("錯")>-1){
                showmessage(g_json_string);
            }else {
                g_json_string = rtnRestObj.getString("Data");
                showmessage(g_json_string);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showmessage(String g_json_string) {

        AlertDialog.Builder builder = new AlertDialog.Builder( platingActivity.this);
        builder.setMessage(g_json_string);
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        builder.show();
    }

    public void confirm(View view) {

        JSONObject rtnRestObj;JSONArray array;
        try {
            url_stting = host + "PrdMgn/plattingMatchedList?searchFlag=1";
            call_rest restObj = new call_rest();
            rtnRestObj = restObj.callRest(url_stting);
            g_json_string = rtnRestObj.getString("Data");
            fillPent_confirm(rtnRestObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void autom(View view) {
        LayoutInflater inflater = LayoutInflater.from(platingActivity.this);
        final View v = inflater.inflate(R.layout.plating_automerge, null);
        final AlertDialog.Builder dialog = new AlertDialog.Builder(platingActivity.this);
        TextView title = new TextView(this);
        title.setText("自動併單");
        title.setGravity(Gravity.CENTER);
        title.setTextSize(24);
        dialog.setCustomTitle(title);
        dialog.setView(v);
        final EditText stdWeight_texted = (EditText) v.findViewById(R.id.stdWeight_texted);
        final Button Auto_cl = (Button) v.findViewById(R.id.Auto_cl);
        final Button auto_ok = (Button) v.findViewById(R.id.auto_ok);
        final EditText diffWeight_texted = (EditText) v.findViewById(R.id.diffWeight_texted);
        final EditText diffVal_texted = (EditText) v.findViewById(R.id.diffVal_texted);
        final AlertDialog dlg = dialog.show();
        final RadioGroup size_rd = (RadioGroup) v.findViewById(R.id.size_rd);
        final EditText diffWeight_texted2= (EditText) v.findViewById(R.id.diffWeight_texted2);
        final TextView textView73= (TextView) v.findViewById(R.id.textView73);
        final RadioButton size_rd1=(RadioButton) v.findViewById(R.id.size_rd1);
        final RadioButton size_rd2=(RadioButton) v.findViewById(R.id.size_rd2);
        size_rd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                diffWeight_texted2.setVisibility(VISIBLE);
                textView73.setVisibility(VISIBLE);
            }
        });
        size_rd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diffWeight_texted2.setVisibility(View.GONE);
                textView73.setVisibility(View.GONE);
            }
        });
        Auto_cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dlg.dismiss();
            }
        });
        auto_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Str_diffWeight_texted2=diffWeight_texted2.getText().toString();
                Str_stdWeight=stdWeight_texted.getText().toString();
                if (!Str_diffWeight_texted2.equals("")||!Str_diffWeight_texted2.equals("0"))
                {
                    Str_stdWeight=Str_diffWeight_texted2+"-"+Str_stdWeight;
                }
                Str_diffWeight=diffWeight_texted.getText().toString();
                Str_diffVal=diffVal_texted.getText().toString();
                switch (size_rd.getCheckedRadioButtonId()) {
                    case R.id.size_rd1:
                        Str_ifSameSize="0";
                        break;
                    case R.id.size_rd2:
                        Str_ifSameSize="1";
                        break;
                }
                auto_flag=1;
                View rootView = getWindow().getDecorView().getRootView();
                get_auto_list(rootView);
                dlg.dismiss();
            }
        });
        WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
        //視窗長寬
        params.width = 1800;
        params.height = 1000;
        //button text size
        dlg.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
        dlg.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
        dlg.getWindow().setAttributes(params);
    }

    public void get_auto_list12(View view) {

        View rootView = getWindow().getDecorView().getRootView();
        get_auto_list(rootView);
    }
    private void get_auto_list(View rootView) {
        JSONObject rtnRestObj;JSONArray array;
        try {
            if (auto_flag==0){
                url_stting=host+"PrdMgn/plattingMatchedList?searchFlag=1";
            }else{
                url_stting  =host+"PrdMgn/plattingAutoMatching?" +
                        "stdWeight="+Str_diffVal+
                        "&diffWeight="+Str_diffWeight
                        +"&diffVal="+Str_stdWeight+
                        "&ifSameSize="+Str_ifSameSize;
            }
            auto_flag=0;
            System.out.println(url_stting);
            call_rest restObj = new call_rest();
            rtnRestObj = restObj.callRest(url_stting);
            g_json_string = rtnRestObj.getString("Data");
            fillPent_m(rtnRestObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void fillPent_m(final JSONObject rtnRestObj) {
        try {
            JSONArray array = new JSONArray(rtnRestObj.getString("Data"));
            Message = "Message";
            ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
            options.clear();
            mList.clear();
            machineID = machineID.replaceAll("&machineID=", "");
            machineID = URLEncoder.encode(machineID, "UTF-8");
            options.add("ID\t\t\t\tsignID" + "\t\t\t\t工令單號\t\t\t\t\t\t型號\t\t\t\t\t阻值\t\t\t\t流程單號\t\t\t送出量");
            click="start";
            if (click.equals("start")) {
                for (int i = 0; i < array.length(); i++) {
                    Map<String, Object> itemBooks = new HashMap<String, Object>();
                    JSONObject ob2 = array.getJSONObject(i);
                    String PackID = ob2.getString("PackID");
                    String dataSource = ob2.getString("dataSource");
                    String packQuant = ob2.getString("packQuant");
                    String Size = ob2.getString("Size");
                    String status = ob2.getString("status");
                    String MASTER_MFO_ID = ob2.getString("MASTER_MFO_ID");
                    String Val = ob2.getString("Val");
                    String RTYPE = ob2.getString("RTYPE");
                    itemBooks.put("MASTER_MFO_ID", MASTER_MFO_ID);
                    itemBooks.put("PackID", PackID);
                    itemBooks.put("Val", Val);
                    itemBooks.put("RTYPE", RTYPE);
                    itemBooks.put("dataSource", dataSource);
                    itemBooks.put("Size", Size);
                    itemBooks.put("status", status);
                    itemBooks.put("packQuant", packQuant);
                    mList.add(itemBooks);
                    System.out.println("1010010===========>"+MASTER_MFO_ID+RTYPE+ Val+Size+packQuant+status
                            +PackID+status+status);
                }
            }
            LayoutInflater inflater = LayoutInflater.from(platingActivity.this);
            final View v2 = inflater.inflate(R.layout.views, null);   //   get viwe layout\
            final View v3 = inflater.inflate(R.layout.plating_seletion2, null);   //   get viwe layout\
            final AlertDialog.Builder dialog = new AlertDialog.Builder(platingActivity.this);
            bnt_sumit_spil=(Button) v2.findViewById(R.id.bnt_sumit_spil);
            listview = (ListView) v2.findViewById(R.id.dynamic);
            final Button cls_bnt=(Button) v2.findViewById(R.id.cls_bnt);
            final Button quick_bnt=(Button) v2.findViewById(R.id.quick_bnt);

            quick_bnt.setVisibility(VISIBLE);
            quick_bnt.setText("單筆送出");
            bnt_sumit_spil.setText("配對");
            dialog.setCancelable(true);
            final AlertDialog dlg;
            dialog.setView(v2);
            TextView title = new TextView(this);
            if (click.equals("start")) {
                title.setText("勾選送電鍍"+MID+"(電鍍)數量");
            } else {
                title.setText("電鍍完成");
            }
            checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
            ImageButton delButton= (ImageButton) v3.findViewById(R.id.delButton);
            adapter2 = new MySimpleAdapter2(this, mList, R.layout.plating_seletion_notext,
                    new String[]{"PackID","MASTER_MFO_ID", "RTYPE", "Val","Size", "packQuant", "status",
                            "PackID","dataSource","status","status"},
                    new int[]{R.id.checkBox3, R.id.SIGNID, R.id.textView44, R.id.textView45, R.id.textView46,
                            R.id.textView47,R.id.editText63,R.id.textView25,R.id.Tol,R.id.Flow_Step});
            listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
            listview.setAdapter(adapter2);
            View header = (View)getLayoutInflater().inflate(R.layout.plating_seletion_headr3,null);
            listview.addHeaderView(header);
            title.setGravity(Gravity.CENTER);
            title.setTextSize(24);
            dialog.setCustomTitle(title);
            dialog.setView(v2);
            dlg = dialog.show();
            bnt_sumit_spil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedJson_sring = "";
                    int error_flag=0,checked=0;

                    for (int i = 1; i < listview.getChildCount(); i++) {
                        error_flag=0;
                        View view = listview.getChildAt(i);
                        CheckBox C3 = view.findViewById(R.id.checkBox3);
                        if (C3.isChecked()) {
                            TextView textView25=view.findViewById(R.id.textView25);
                            checked++;
                            if(checked==1){packBID=textView25.getText().toString();}
                            if(checked==2){packAID=textView25.getText().toString();}
                        }
                    }
                    //System.out.println("checked="+checked);
                    if(checked==2){
                        View rootView = getWindow().getDecorView().getRootView();
                        Log.d("kuo",packBID+"  "+packAID);
                        for (int i = 1; i < listview.getChildCount(); i++) {
                            error_flag = 0;
                            View view = listview.getChildAt(i);
                            CheckBox C3 = view.findViewById(R.id.checkBox3);

                            C3.setChecked(false);
                        }
                        plattingMenualMatching(rootView);
                    }else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(platingActivity.this);
                        builder.setMessage("需選擇2個");
                        builder.setCancelable(false);
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {                      }                        });
                        builder.show();
                    }
                }
            });
            quick_bnt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int checked=0;pack="";
                    for (int i = 1; i < listview.getChildCount(); i++) {
                        View view = listview.getChildAt(i);
                        CheckBox C3 = view.findViewById(R.id.checkBox3);
                        TextView textView25=view.findViewById(R.id.textView25);
                        if (C3.isChecked()) {
                            checked++;
                            if (checked>1)pack=pack+",";
                            pack=pack+textView25.getText().toString();
                        }

                    }
                    if (checked==0){
                        AlertDialog.Builder builder = new AlertDialog.Builder(platingActivity.this);
                        builder.setMessage("需選擇1個或以上");
                        builder.setCancelable(false);
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {                      }                        });
                        builder.show();
                    }else{
                        System.out.println("單胞送出"+pack);
                       // 單胞送出
                        View rootView = getWindow().getDecorView().getRootView();
                        platting_pack_send(rootView);

                    }
                }
            });
            cls_bnt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dlg.dismiss();
                }
            });
            WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
            //視窗長寬
            params.width = 1800;
            params.height = 1000;
            dlg.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
            dlg.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
            dlg.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
            dlg.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
            dlg.getWindow().setAttributes(params);
        } catch (Exception e) {
            AlertDialog.Builder builder = new AlertDialog.Builder(platingActivity.this);
            builder.setMessage("沒有資料");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    //  finish();
                }
            });
            builder.show();
        }
    }

    private void platting_pack_send(View rootView) {

        JSONObject rtnRestObj;
        String url=host+"PrdMgn/plattingCommand?command=5&supplier="+machineID+"&singlePackList="+pack;
        System.out.println(url);
        call_rest restObj = new call_rest();
        rtnRestObj = restObj.callRest(url);
        try {
            g_json_string = rtnRestObj.getString("Message");
            showmessage(g_json_string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        pack="";
    }

    private void plattingMenualMatching(View rootView) {
        JSONObject rtnRestObj;
        String url=host+"PrdMgn/plattingMenualMatching?" +
                "packAID="+packAID +
                "&packBID="+packBID;
        call_rest restObj = new call_rest();
        rtnRestObj = restObj.callRest(url);
        try {
            g_json_string = rtnRestObj.getString("Message");
            showmessage(g_json_string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void Manual(View view) {//修改確認

        JSONObject rtnRestObj;JSONArray array;
        try {

            url_stting = host + "PrdMgn/plattingMatchedList?searchFlag=0";
            call_rest restObj = new call_rest();
            rtnRestObj=null;
            rtnRestObj = restObj.callRest(url_stting);
            g_json_string="";
            g_json_string = rtnRestObj.getString("Data");

            fillPent_Manual(rtnRestObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fillPent_Manual(final JSONObject rtnRestObj) {//手動併單

        try {
            JSONArray array = new JSONArray(rtnRestObj.getString("Data"));
            Message = "Message";
            ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
            options.clear();
            mList.clear();
            machineID = machineID.replaceAll("&machineID=", "");
            machineID = URLEncoder.encode(machineID, "UTF-8");
            options.add("ID\t\t\t\tsignID" + "\t\t\t\t工令單號\t\t\t\t\t\t型號\t\t\t\t\t阻值\t\t\t\t流程單號\t\t\t送出量");
            click="start";
            if (click.equals("start")) {
                //{\"AID\":0,\"AMater\":\"F-5-YB28M\",\"AVAL\":\"1K2\",\"ASIZE\":\"1x3.15\",
                // \"AQUANT\":43.7,\"BID\":0,\"BMater\":\"F-5-YB28M\",\"BVAL\":\"1K2\",\"BSIZE\":\"1x3.15\"
                // ,\"BQUANT\":43.7,\"totalQuant\":87.4000015258789}
                for (int i = 0; i < array.length(); i++) {
                    Map<String, Object> itemBooks = new HashMap<String, Object>();
                    JSONObject ob2 = array.getJSONObject(i);
                    String AID = ob2.getString("AID");
                    String BID = ob2.getString("BID");
                    String AMater = ob2.getString("AMater");
                    String BMater = ob2.getString("BMater");
                    String BSIZE = ob2.getString("BSIZE");
                    String ASIZE = ob2.getString("ASIZE");
                    String AQUANT = ob2.getString("AQUANT");
                    String BQUANT = ob2.getString("BQUANT");
                    String AVAL = ob2.getString("AVAL");
                    String BVAL = ob2.getString("BVAL");
                    String BATCHID = ob2.getString("BATCHID");
                    itemBooks.put("AID", AID);
                    itemBooks.put("BID", BID);
                    Log.d("kuo","A"+AID+"B"+BID);
                    itemBooks.put("AMater", AMater);
                    itemBooks.put("BMater", BMater);
                    itemBooks.put("AVAL", AVAL);
                    itemBooks.put("BVAL", BVAL);
                    itemBooks.put("AQUANT", AQUANT);
                    itemBooks.put("BQUANT", BQUANT);
                    itemBooks.put("ASIZE", ASIZE);
                    itemBooks.put("BSIZE", BSIZE);
                    itemBooks.put("BATCHID", BATCHID);
                    mList.add(itemBooks);
                }
            }
            LayoutInflater inflater = LayoutInflater.from(platingActivity.this);
            final View v2 = inflater.inflate(R.layout.views, null);   //   get viwe layout\
            final View v3 = inflater.inflate(R.layout.plating_seletion2, null);   //   get viwe layout\
            final AlertDialog.Builder dialog = new AlertDialog.Builder(platingActivity.this);
            bnt_sumit_spil=(Button) v2.findViewById(R.id.bnt_sumit_spil);
            final Button send_bnt=(Button) v2.findViewById(R.id.bnt_sumit_spil);
            final Button del_item=(Button) v2.findViewById(R.id.del_item);
            listview = (ListView) v2.findViewById(R.id.dynamic);
            final Button cls_bnt=(Button) v2.findViewById(R.id.cls_bnt);
            bnt_sumit_spil.setText("取消配對");
            del_item.setVisibility(View.GONE);
            //del_item.setText("送出電鍍");
            dialog.setCancelable(true);
            final AlertDialog dlg;
            dialog.setView(v2);
            TextView title = new TextView(this);
            checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
            ImageButton delButton= (ImageButton) v3.findViewById(R.id.delButton);
            adapter2 = new MySimpleAdapter2(this, mList, R.layout.plating_seletion_notext_2line,
                    new String[]{"", "AID","ASIZE","AVAL","AQUANT","",
                                     "BID","BSIZE","BVAL","BQUANT",
                            "BATCHID","BATCHID","AID","BID"},
                    new int[]{R.id.checkBox3, R.id.textView1,
                            R.id.textView2, R.id.textView3, R.id.textView4,R.id.textView5,
                            R.id.textView6,R.id.textView7,R.id.textView8,
                            R.id.textView9,R.id.textView10,R.id.textView11,R.id.textView70,R.id.textView71});
            listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
            listview.setAdapter(adapter2);
            View header = (View)getLayoutInflater().inflate(R.layout.plating_seletion_headr3,null);
            //listview.addHeaderView(header);
            title.setGravity(Gravity.CENTER);
            title.setTextSize(24);
            dialog.setCustomTitle(title);
            dialog.setView(v2);
            dlg = dialog.show();
            del_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {// 取消配對
                    View rootView = getWindow().getDecorView().getRootView();
                    plattingDone(rootView);
                    dlg.dismiss();
                }

            });
            bnt_sumit_spil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {// 取消配對
                    selectedJson_sring = "";
                    int k=0;
                    for (int i = 0; i < listview.getChildCount(); i++) {
                        View view = listview.getChildAt(i);
                        CheckBox C3 = view.findViewById(R.id.checkBox3);
                        if (C3.isChecked()) {
                            k++;
                        }
                    }
                    if (k!=1){

                        AlertDialog.Builder builder = new AlertDialog.Builder(platingActivity.this);
                        builder.setMessage("取消請選一組");
                        builder.setCancelable(false);
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
                        builder.show();
                    }else {

                        for (int i = 0; i < listview.getChildCount(); i++) {
                            View view = listview.getChildAt(i);
                            CheckBox C3 = view.findViewById(R.id.checkBox3);
                            if (C3.isChecked()) {
                                TextView textView1=view.findViewById(R.id.textView70);
                                TextView textView70=view.findViewById(R.id.textView10);
                                TextView textView11=view.findViewById(R.id.textView71);
                                packBID=textView11.getText().toString();
                                selectedJson_sring=selectedJson_sring+packBID+","+textView70.getText().toString()+"-"+textView1.getText().toString()                            ;
                            }
                        }
                        System.out.println("1113==>>"+selectedJson_sring);
                        View rootView = getWindow().getDecorView().getRootView();
                        plattingUnMatching(rootView);
                        dlg.dismiss();
                    }
                }
            });

            cls_bnt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dlg.dismiss();
                }
            });
            WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
            //視窗長寬
            params.width = 1800;
            params.height = 1000;
            dlg.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
            dlg.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
            dlg.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
            dlg.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
            dlg.getWindow().setAttributes(params);
        } catch (Exception e) {
            Log.d("kuo",e.toString());
            AlertDialog.Builder builder = new AlertDialog.Builder(platingActivity.this);
            builder.setMessage("沒有資料");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                }
            });
            builder.show();
        }
    }

    private void plattingDone(View rootView) {

        LayoutInflater inflater = LayoutInflater.from(platingActivity.this);
        final View v = inflater.inflate(R.layout.platting_done, null);
        AlertDialog.Builder dialog = new AlertDialog.Builder(platingActivity.this);
        TextView title = new TextView(this);
        final Spinner mid_spinner=(Spinner)v.findViewById(R.id.spinner4);
        final ArrayAdapter<String> MEGA_adapter2 =
                new ArrayAdapter<String>(platingActivity.this,R.layout.spinner_layout,options_MEGA2);
        MEGA_adapter2.setDropDownViewResource(R.layout.spinner_layout);
        mid_spinner.setAdapter(MEGA_adapter2);

        title.setGravity(Gravity.CENTER);
        title.setTextSize(24);
        dialog.setCustomTitle(title);
        dialog.setView(v);
        dialog.setPositiveButton("送出", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //mid_spinner.
                String mid = mid_spinner.getSelectedItem().toString();

                url_stting = host
                        +"PrdMgn/plattingCommand?command=1&supplier="+mid;
                try{
                    call_rest restObj = new call_rest();
                    JSONObject rtnRestObj = restObj.callRest(url_stting);
                    g_json_string = rtnRestObj.getString("Message");
                    showmessage(g_json_string);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        AlertDialog dlg = dialog.show();
        WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
        //視窗長寬
        params.width = 1200;
        params.height = 700;
        //button text size
        dlg.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
        dlg.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
        dlg.getWindow().setAttributes(params);
        /*JSONObject rtnRestObj;JSONArray array;
        try {
            url_stting = host
                    +"PrdMgn/plattingDone";
            call_rest restObj = new call_rest();
            rtnRestObj = restObj.callRest(url_stting);
            g_json_string = rtnRestObj.getString("Data");
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }


    private void plattingUnMatching(View rootView) {
        String url =host
                +"PrdMgn/plattingUnMatchingList?BatchID="+selectedJson_sring;
        System.out.println(url);
        JSONObject rtnRestObj;JSONArray array;
        try {
            url_stting = host
                    +"PrdMgn/plattingUnMatchingList?BatchID="+selectedJson_sring;
            call_rest restObj = new call_rest();
            rtnRestObj = restObj.callRest(url_stting);
            g_json_string = rtnRestObj.getString("Message");
            showmessage(g_json_string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public void start(View view) {
        if(MID.equals("")){

        }else{
            try {
                String encodedUrl = "", encodedUr2 = "", encodedUr3 = "",encodedUr4 = "";
                encodedUrl = URLEncoder.encode(flowBar, "UTF-8");
                encodedUr2 = URLEncoder.encode(userBar, "UTF-8");
                encodedUr3 = URLEncoder.encode(Process, "UTF-8");
                encodedUr4 = URLEncoder.encode(MID, "UTF-8");

                url_stting = host + "PrdMgn/ScanOperate?command=12" +
                        "&UID=" + encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr3+
                        "&MID=" + MID;
                call_rest restObj = new call_rest();
                JSONObject rtnRestObj = restObj.callRest(url_stting);
                //fillGldPent(rtnRestObj, view);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void recall(View view) {//撤回已送出資料
        LayoutInflater inflater = LayoutInflater.from(platingActivity.this);
        final View v = inflater.inflate(R.layout.plating_recall, null);
        AlertDialog.Builder dialog = new AlertDialog.Builder(platingActivity.this);
        TextView title = new TextView(this);
        title.setText("撤回");
        title.setGravity(Gravity.CENTER);
        title.setTextSize(24);
        dialog.setCustomTitle(title);
        dialog.setView(v);
        final Spinner mid_spinner2=(Spinner)v.findViewById(R.id.spinner4);
        final ArrayAdapter<String> MEGA_adapter2 =
                new ArrayAdapter<String>(platingActivity.this,android.R.layout.simple_spinner_item,options_MEGA);
        MEGA_adapter2.setDropDownViewResource(R.layout.spinner_layout);
        mid_spinner2.setAdapter(MEGA_adapter2);
        final CalendarView calendarView=(CalendarView) v.findViewById(R.id.calendarView2);
        final String[] day = {""};
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                String z1="",z2="";
                month =month+ 1;
                if(month<10){z1="0";}
                if(dayOfMonth<10){z2="0";}
                System.out.println(year+z1+month+z2+dayOfMonth);
                day[0] =year+z1+month+z2+dayOfMonth;
            }
        });
        dialog.setPositiveButton("送出", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ///http://localhost:54791/PrdMgn/plattingCommand?
                // comman=1&supplier=CU&actionDate=20210122
                String mid = mid_spinner2.getSelectedItem().toString();

                url_stting = host
                        +"PrdMgn/plattingCommand?command=2&supplier="+mid+"&actionDate="+day[0];
                System.out.println(url_stting);
                try{
                    call_rest restObj = new call_rest();
                    JSONObject rtnRestObj = restObj.callRest(url_stting);
                    g_json_string = rtnRestObj.getString("Message");
                    showmessage(g_json_string);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        AlertDialog dlg = dialog.show();
        WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
        //視窗長寬
        params.width = 1200;
        params.height = 700;
        //button text size
        dlg.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
        dlg.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
        dlg.getWindow().setAttributes(params);
    }

    public void send_platting(View view) {//送出電鍍   拆與不拆資料
        JSONObject rtnRestObj;JSONArray array;
        try {
            url_stting=host+"PrdMgn/plattingTobeSent";
            call_rest restObj = new call_rest();
            rtnRestObj = restObj.callRest(url_stting);
            g_json_string = rtnRestObj.getString("Data");
            fillPent_all(rtnRestObj);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void acceptance(View view) {//驗收
        JSONObject rtnRestObj;JSONArray array;
        try {
            url_stting=host+"PrdMgn/plattingTobeSent";
            call_rest restObj = new call_rest();
            rtnRestObj = restObj.callRest(url_stting);
            g_json_string = rtnRestObj.getString("Data");
            fillPent_acceptance(rtnRestObj);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void fillPent_acceptance(final JSONObject rtnRestObj) {//驗收
        try {
            JSONArray array = new JSONArray(rtnRestObj.getString("Data"));
            Message = "Message";
            ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
            options.clear();
            mList.clear();
            for (int i = 0; i < array.length(); i++) {
                Map<String, Object> itemBooks = new HashMap<String, Object>();
                JSONObject ob2 = array.getJSONObject(i);
                //"Data": "[{\"編號\":\"14-30, 14-29\",\"尺寸\":\"1x3.15, 1x3.15\",
                // \"packQuant\":\"18, 13\",\"送貨日期\":\"02-20\",\"回電日期\":\"02-20\"}]"
                String PackID = ob2.getString("編號");
                String dataSource = ob2.getString("尺寸");
                String packQuant = ob2.getString("packQuant");
                String Size = ob2.getString("送貨日期");
                String status = ob2.getString("回電日期");
                itemBooks.put("PackID", PackID);
                itemBooks.put("dataSource", dataSource);
                itemBooks.put("Size", Size);
                itemBooks.put("status", status);
                itemBooks.put("packQuant", packQuant);
                mList.add(itemBooks);
            }
            LayoutInflater inflater = LayoutInflater.from(platingActivity.this);
            final View v2 = inflater.inflate(R.layout.views, null);   //   get viwe layout\
            final View v3 = inflater.inflate(R.layout.plating_seletion_views, null);   //   get viwe layout\
            final AlertDialog.Builder dialog = new AlertDialog.Builder(platingActivity.this);
            bnt_sumit_spil=(Button) v2.findViewById(R.id.bnt_sumit_spil);
            listview = (ListView) v2.findViewById(R.id.dynamic);

            final Button del_item=(Button) v2.findViewById(R.id.del_item);
            final Button cls_bnt=(Button) v2.findViewById(R.id.cls_bnt);
            cls_bnt.setText("取消");
            dialog.setCancelable(true);
            final AlertDialog dlg;
            dialog.setView(v2);
            TextView title = new TextView(this);
            checkBox3 = (CheckBox) v3.findViewById(R.id.checkBox3);
            checkBox3.setVisibility(VISIBLE);
            ImageButton delButton= (ImageButton) v3.findViewById(R.id.delButton);
            adapter2 = new MySimpleAdapter2(this, mList, R.layout.plating_seletion_views_check,
                    new String[]{"","PackID", "dataSource", "Size","status", "packQuant", "status",
                            "PackID","dataSource","status","status"},
                    new int[]{R.id.checkBox3, R.id.SIGNID, R.id.textView44, R.id.textView45, R.id.textView46,
                            R.id.textView47,R.id.editText63,R.id.textView25,R.id.Tol,R.id.Flow_Step});
            listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
            listview.setAdapter(adapter2);
            //View header = (View)getLayoutInflater().inflate(R.layout.plating_seletion_headr3,null);
            //listview.addHeaderView(header);
            title.setGravity(Gravity.CENTER);
            title.setTextSize(24);
            dialog.setCustomTitle(title);
            dialog.setView(v2);
            dlg = dialog.show();
            del_item.setVisibility(VISIBLE);
            bnt_sumit_spil.setText("驗收完成");
            bnt_sumit_spil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedJson_sring="";
                    for (int i = 0; i < listview.getChildCount(); i++) {
                        View view = listview.getChildAt(i);
                        CheckBox C3 = view.findViewById(R.id.checkBox3);
                        if (C3.isChecked()) {
                            TextView textView1=view.findViewById(R.id.SIGNID);
                            if (i >= 1 && !selectedJson_sring.equals("")) {
                                selectedJson_sring = selectedJson_sring + ",";
                            }
                            packBID=textView1.getText().toString();
                            selectedJson_sring=selectedJson_sring+packBID;
                        }
                    }
                    selectedJson_sring=selectedJson_sring.replace(" ","");
                    verified_F="3";
                    View rootView = getWindow().getDecorView().getRootView();
                    verified(rootView);
                }
            });
            del_item.setText("驗收退貨");

            del_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    selectedJson_sring="";
                    for (int i = 0; i < listview.getChildCount(); i++) {
                        View view = listview.getChildAt(i);
                        CheckBox C3 = view.findViewById(R.id.checkBox3);
                        if (C3.isChecked()) {
                            TextView textView1=view.findViewById(R.id.SIGNID);
                            if (i >= 1 && !selectedJson_sring.equals("")) {
                                selectedJson_sring = selectedJson_sring + ",";
                            }
                            packBID=textView1.getText().toString();
                            selectedJson_sring=selectedJson_sring+packBID;
                        }
                    }
                    selectedJson_sring=selectedJson_sring.replace(" ","");
                    verified_F="4";
                    View rootView = getWindow().getDecorView().getRootView();
                    verified(rootView);
                }

            });
            cls_bnt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dlg.dismiss();
                }
            });
            WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
            //視窗長寬
            params.width = 1800;
            params.height = 1000;
            dlg.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
            dlg.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
            dlg.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
            dlg.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
            dlg.getWindow().setAttributes(params);
        } catch (Exception e) {
            AlertDialog.Builder builder = new AlertDialog.Builder(platingActivity.this);
            builder.setMessage("沒有資料");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    //  finish();
                }
            });
            builder.show();
        }
    }

    private void verified(View rootView) {
        JSONObject rtnRestObj;JSONArray array;
        try {
            url_stting=host+"PrdMgn/plattingCommand?command="+verified_F+"&supplier="+machineID+"&verifiedStr="+selectedJson_sring;
            call_rest restObj = new call_rest();
            rtnRestObj = restObj.callRest(url_stting);
            g_json_string = rtnRestObj.getString("Message");
            showmessage(g_json_string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fillPent_all(final JSONObject rtnRestObj) {//送出電鍍   拆與不拆資料
        try {
            JSONArray array = new JSONArray(rtnRestObj.getString("Data"));
            Message = "Message";
            ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
            options.clear();
            mList.clear();
            for (int i = 0; i < array.length(); i++) {
                Map<String, Object> itemBooks = new HashMap<String, Object>();
                JSONObject ob2 = array.getJSONObject(i);
                //"Data": "[{\"編號\":\"14-30, 14-29\",\"尺寸\":\"1x3.15, 1x3.15\",
                // \"packQuant\":\"18, 13\",\"送貨日期\":\"02-20\",\"回電日期\":\"02-20\"}]"
                String PackID = ob2.getString("編號");
                String supplier = ob2.getString("supplier");
                String dataSource = ob2.getString("尺寸");
                String packQuant = ob2.getString("packQuant");
                String Size = ob2.getString("送貨日期");
                String status = ob2.getString("回電日期");
                itemBooks.put("PackID", PackID);
                itemBooks.put("supplier", supplier);
                itemBooks.put("dataSource", dataSource);
                itemBooks.put("Size", Size);
                itemBooks.put("status", status);
                itemBooks.put("packQuant", packQuant);
                mList.add(itemBooks);
            }
            LayoutInflater inflater = LayoutInflater.from(platingActivity.this);
            final View v2 = inflater.inflate(R.layout.views, null);   //   get viwe layout\
            final View v3 = inflater.inflate(R.layout.plating_seletion2, null);   //   get viwe layout\
            final AlertDialog.Builder dialog = new AlertDialog.Builder(platingActivity.this);
            bnt_sumit_spil=(Button) v2.findViewById(R.id.bnt_sumit_spil);
            listview = (ListView) v2.findViewById(R.id.dynamic);
            final Button cls_bnt=(Button) v2.findViewById(R.id.cls_bnt);
            cls_bnt.setText("取消");
            dialog.setCancelable(true);
            final AlertDialog dlg;
            dialog.setView(v2);
            TextView title = new TextView(this);
            checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
            ImageButton delButton= (ImageButton) v3.findViewById(R.id.delButton);
            adapter2 = new MySimpleAdapter2(this, mList, R.layout.plating_seletion_views,
                    new String[]{"supplier","supplier","PackID", "dataSource", "Size","status", "packQuant", "status",
                            "dataSource","status","status"},
                    new int[]{R.id.checkBox3, R.id.SIGNID, R.id.textView44, R.id.textView45, R.id.textView46,
                            R.id.textView47,R.id.editText63,R.id.textView25,R.id.Tol,R.id.Flow_Step});
            listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
            listview.setAdapter(adapter2);
            //View header = (View)getLayoutInflater().inflate(R.layout.plating_seletion_headr3,null);
            //listview.addHeaderView(header);
            title.setGravity(Gravity.CENTER);
            title.setTextSize(24);
            dialog.setCustomTitle(title);
            dialog.setView(v2);
            dlg = dialog.show();
            bnt_sumit_spil.setText("送出電鍍");
            bnt_sumit_spil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    JSONObject rtnRestObj;JSONArray array;
                    try {
                        View rootView = getWindow().getDecorView().getRootView();
                        plattingDone(rootView);
                        dlg.dismiss();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            cls_bnt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dlg.dismiss();
                }
            });
            WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
            //視窗長寬
            params.width = 1800;
            params.height = 1000;
            dlg.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
            dlg.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
            dlg.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
            dlg.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
            dlg.getWindow().setAttributes(params);
        } catch (Exception e) {
            AlertDialog.Builder builder = new AlertDialog.Builder(platingActivity.this);
            builder.setMessage("沒有資料");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    //  finish();
                }
            });
            builder.show();
        }
    }
    private class MySimpleAdapter extends SimpleAdapter
    {
        platingActivity context;
        List<Map<String, Object>> productlist= null;
        ArrayList<String> selectedPosition = new ArrayList<String>();
        private Map<Integer, Boolean> map = new HashMap<>();
        private String[] beans;
        private  HashMap<Integer, Boolean> isSelected;



        String finalText=null;
        int currPos = -1;
        public MySimpleAdapter(Context context, List<Map<String, Object>> data, int resource, String[] from, int[] to) {
            super(context, data, resource, from, to);
            this.productlist= data;
            this.context = (platingActivity) context;
            // TODO Auto-generated constructor stub
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return productlist.size();
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return arg0;
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return arg0;
        }
        public View getView(final int position, View convertView, final ViewGroup parent) {
            // TODO Auto-generated method stub
            final ViewHolder holder;
            LayoutInflater mInflater = LayoutInflater.from(platingActivity.this);
            convertView=null;
            System.out.println("=>1010");
            try{
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.plating_seletion2, null);
                holder.cbxStatus= (CheckBox) convertView.findViewById(R.id.checkBox3);
                holder.caption = (EditText) convertView.findViewById(R.id.editText63);
                holder.caption.setTag(position);
                holder.caption.setText(productlist.get(position).get("splitWeight").toString());
                holder.textView44 = (TextView) convertView.findViewById(R.id.textView44);
                holder.textView45 = (TextView) convertView.findViewById(R.id.textView45);
                holder.textView451 = (TextView) convertView.findViewById(R.id.textView451);
                holder.textView452 = (TextView) convertView.findViewById(R.id.textView452);
                holder.textView46 = (TextView) convertView.findViewById(R.id.textView46);
                holder.textView47 = (TextView) convertView.findViewById(R.id.textView47);
                holder.textView25 =  (TextView)convertView.findViewById(R.id.textView25);
                holder.Flow_Step =  (TextView)convertView.findViewById(R.id.Flow_Step);
                holder.SIGNID = (TextView) convertView.findViewById(R.id.SIGNID);
                holder.SIGNID.setText(productlist.get(position).get("MASTER_MFO_ID").toString());
                holder.textView44.setText(productlist.get(position).get("RTYPE").toString());
                holder.Flow_Step.setText(productlist.get(position).get("Flow_Step").toString());
                holder.textView45.setText(productlist.get(position).get("VAL").toString());
                holder.textView451.setText(productlist.get(position).get("batchNo").toString());
                holder.textView452.setText(productlist.get(position).get("size").toString());
                holder.textView46.setText(productlist.get(position).get("OutputQuan").toString());
                String plattingType="";
                if (productlist.get(position).get("plattingType").toString().equals("0")){plattingType="庫存";}else
                if (productlist.get(position).get("plattingType").toString().equals("1")){plattingType="色碼";}else
                if (productlist.get(position).get("plattingType").toString().equals("2")){plattingType="底漆";}
                holder.textView47.setText(plattingType);
                holder.textView25.setText(productlist.get(position).get("SID").toString());
                if (productlist.get(position).get("status").toString().equals("0")){
                    holder.cbxStatus.setChecked(false);
                }else {
                    holder.cbxStatus.setChecked(true);
                }
                listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            int tag_position=(Integer) holder.caption.getTag();
            holder.caption.setId(tag_position);
            holder.cbxStatus.setId(tag_position);
            holder.cbxStatus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        final int position2 = holder.caption.getId();
                        if (holder.cbxStatus.isChecked()==true) {
                            mList.get(position2).put("status", "1");
                        } else {
                            mList.get(position2).put("status", "0");
                        }
                    }
                });

                //holder.cbxStatus.setChecked(getIsSelected().get(position));

            holder.caption.addTextChangedListener(new TextWatcher() {

                @Override
                public void onTextChanged(CharSequence s, int start, int before,
                                          int count) {
                    final int position2 = holder.caption.getId();
                    final EditText Caption = (EditText) holder.caption;
                    if(Caption.getText().toString().length()>0){
                        System.out.println("=>"+position);
                        mList.get(position2).put("splitWeight", Caption.getText().toString());
                    }else{
                        Toast.makeText(context, "Please enter some value", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count,
                                              int after) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                }

            });
            } catch (Exception e) {
                e.printStackTrace();
            }


            return convertView;
        }
    }
    class ViewHolder {
        EditText caption;
        TextView SIGNID;
        TextView textView44;
        TextView textView45,textView451,textView452;
        TextView textView46;
        TextView textView47,Flow_Step,textView25;
        CheckBox cbxStatus;

    }

    public void setChecked(int position,boolean m){
        Map<String, Object> map = (Map<String, Object>) adapter2.getItem(position);
        map.put("ckb", m);
        mList.set(position, map);
        adapter2.notifyDataSetChanged();
        //listview.invalidate();
    }
    public void puquant(int position,String m){
        Map<String, Object> map = (Map<String, Object>) adapter2.getItem(position);
        map.put("splitWeight", m);
        Log.d("kuo", position+"puquant -----"  + map.get("splitWeight").toString());
        //mList.set(position, map);
        adapter2.notifyDataSetChanged();
        //listview.invalidate();
    }


    private class MySimpleAdapter2 extends SimpleAdapter
    {
        platingActivity context;

        public MySimpleAdapter2(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
            super(context, data, resource, from, to);
            this.context = (platingActivity) context;
            // TODO Auto-generated constructor stub
        }

        public View getView(final int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            View v = super.getView(position, convertView, parent);
            //Button btn=(Button) v.findViewById(R.id.button1);
            final CheckBox ckb = (CheckBox)v.findViewById(R.id.checkBox3);
            final int p = position;
            Log.d("Position", Integer.toString(position));
            //复选框的响应
            ckb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked)
                    {
                        hashMap.put(position, isChecked);
                    }else{
                        hashMap.remove(position);
                    }
                }});
            ckb.setChecked(hashMap.get(position)==null? false : true);

            ckb.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    String s = (p+":"+ckb.isChecked());
                    Toast.makeText(context, s, Toast.LENGTH_LONG).show();
                    if(ckb.isChecked()){
                        context.setChecked(p, true);
                    }else if(!ckb.isChecked()){
                        context.setChecked(p, false);
                    }
                }

            });
            return v;
        }
    }
    }

