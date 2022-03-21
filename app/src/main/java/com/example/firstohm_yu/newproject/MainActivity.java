package com.example.firstohm_yu.newproject;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlarmManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.util.TypedValue;
import android.view.*;
import android.widget.*;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.AlertDialog;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

import static android.view.View.GONE;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;
import static com.example.firstohm_yu.newproject.adminActivity.addAndSubtractDaysByCalendar;
import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity implements  MainFragment.OnListFragmentInteractionListener {
    public static int COLOR_inverse;
    public static String location = "H";
    String chkinput="",TestConnection="",Process_CUT,Process_SWT="",logouttype="",coworker_bar = "",ifLeader_forinput=";",speed_value="",trace="",reFullChk="0",tempurl="";
    int cf=0;
    //public static String location="T";
    //先行定義時間格式電鍍用
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
    SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");private List<Integer> list;
    public static List params = new ArrayList();
    private ArrayAdapter<String> adapter;
    private android.support.v4.app.FragmentManager manager;
    private android.support.v4.app.FragmentTransaction transaction;
    public static final int MEG_INVALIDATE = 9527; //自訂一個號碼
    /////////Host setting//////
    //static String host= "http://192.168.1.110/";
    ///public static String testmode="true";
    public static String testmode="f";
    final ArrayList<String> mylist = new ArrayList<String>();
    static String ng1_afinsh="",ng2_afinsh="",ng3_afinsh="",select_size="",temp_elect_size="",ipString,host = "",strsttext="";
    public String Process2="",edit_sign,g_listTE,testNote="",conf_flag = null, userBar = "", flowBar = "";  //    220-16-1950-%   userBar
    public static double input_couint = 0, correct = 0, input = 0, correct_rate = 0;
    public static String colorUser,testdata, Size, tempu, gflowBar, popMsg = "",warehouseBar;
    public static int outa=0,upmid=0,coworker_flag=0,firtst_select=0,check_scan, midflag, facroryNo = 1;
    public static String url, facroryNoT = "",startCommand="1";
    public int chang_color = 0, del_mod = 0, camera_str = 0;
    int Painting_flag=0,CHINTO=0,logout_flag=0,relogin=0,warehouse_flag=0,perf = 0, temp_int = 0, finsh_flag = 0, part_finish = 0, setting_status = 1, restf = 0,start_edit=0;
    //////////
    public static final List<Map<String, Object>> mList= new ArrayList<Map<String,Object>>();
    public static final List<Map<String, Object>> o2mList= new ArrayList<Map<String,Object>>();
    public static final List<Map<String, Object>> mList_plating= new ArrayList<Map<String,Object>>();
    float c_input = 0, c_final = 0, c_furtu = 0, c_acc = 0;
    int check_loc,ng1,ng2,ng3,temp_input = 0, secmod = 0;
    int  urlclick=0 ;
    float sumacc = 0;
    String g_json_string = "",userselect_flag="0";//g_json_string
    final ArrayList<String> options = new ArrayList<String>();
    final ArrayList<String> options_plating = new ArrayList<String>();
    final ArrayList<String> midlist = new ArrayList<String>();
    final ArrayList<String> material_issue = new ArrayList<String>();
    String out_EMPNAME,out_InputQuan,out_OutputQuan,out_DefectQuan,out_StepLeft,out_AccQuan,out_ACCDefect,out_PRE_USERID,out_NG1,out_NG2,out_NG3,out_SEL_NG;
    int si_f=0;
    String ifLeader_user="",check_userid="",shiftType="",u="",temp_glist,check_user="",ExtraValue, ExtraInfo, ip_str, sysGenFlag, jsonStr, notec, camera, ifAvailable, USER_ID, ifLeader = "0", validateBottom, validateTop;

    final ArrayList<String> options_date= new ArrayList<String>();
    LinearLayout Painting_layout,input_lay,Process_sw_block,ful_lay,terrible_layout;
    TextView TV_COLOR_V,finsh_thai,def_thai;
    float old_InputQuan;
    TextView shotsub_title;
    TextView textView51;
    TextView WAREHouse_QTY_text_value,preNaiBei_text;
    TextView sumOfNaiBei_text_title;
    TextView name_textView;
    TextView version,ver;
    TextView note_title;
    TextView testviews;
    TextView v_flow_title;
    TextView TV_mfo_id_V;
    TextView TV_mfo_id_V2;
    TextView textView9;
    TextView textView10;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView;
    TextView textView6;
    TextView textView19;
    TextView textView20;
    TextView mfo_id_text_title;
    TextView BATCH_QTY_text_title;
    TextView DELDATE_text_title;
    TextView RTYPE_text_title;
    TextView TOL_text_title;
    TextView PPM_text_title;
    TextView COLOR_NUM_text_title;
    TextView mfo_id_text_value;
    TextView BATCH_QTY_text_value;
    TextView DELDATE_text_value;
    TextView RTYPE_text_value;
    TextView TOL_text_value;
    TextView PPM_text_value;
    TextView COLOR_NUM_text_value;
    TextView v_text_title;
    TextView MachineIM;
    static TextView messageview;
    TextView VAL_text_title;
    TextView VAL_text_value;
    TextView SUBFLOWID_text_title,SUBFLOWID_text_value,BATCH_NO_text_value;
    TextView BATCH_NO_text_title,WAREHouse_QTY_text_title;
    EditText shotsub_text,NG1,NG2,NG3,barCodeType_Texted, url_Texted, DEPT_Texted, note_value, MachineParams_Texted, FLOW_STEP_Texted, InputQuan_Texted, AccQuan_Texted, machineID_Texted, final_Texted, furyu_Texted;
    ImageView imageView11,ficon, imageView, bnt_myPrd,views2;
    ImageButton setting, views, viewsbutton, report;
    Button coworker_bnt,shotsub_button,button41,material_issue_bnt,button29,color_userbnt,color_bnt,send_bnt,user_select,outcheck_edit,part_finish_bnt, mid_select, reget, Supervisor_check, testnbnnt, testbnt, check_7, button, button4, button5, test, loginbnt, button1, button11, sum, getu, getg, check_p, accident, testbutton;
    String sent_type="重量 Kg",tdDoneQty,tdRollQty ,tfLeftQty ,lastSignID, sumOfNaiBei = null, TestCnt, sumit = "", USER_ID_Befor, MachineID_Befor, starttime = "", endtime = "", Process, DefectQuan;
    Button bnt_todef,button38,back_acc,hide_bnt1,hide_bnt2,shift_bnt;
    Spinner terrible_spinner,Painting_select,spinner_ng_in,NGselecdt,date_spinner,spinner,my_size_spinner;
    String code,Succ,cpuInfo;
    RadioButton rd_roll;
    Button wifi_bnt2,wifi_bnt,Process_bnt,out_shift1,out_shift2,out_shift3,edit_buttom,def_bnt,getinfo, sptest, check_g,warehouse;
    JSONObject g_list, dataobj, testarrobj, g_json,preNaiBeiJson;
    JSONArray test_array;
    static ProgressBar progressBar,moreprogressBar;
    int ngsum,witness = 0,cut_flag=0;//切割測試;
    int sunNaiBei = 0, wqty=0,Press_flag = 0, machine_but_flag = 0, startflig = 0, onajif, startf, check_ver = 1, chm = 0;
    static String now_version, new_version;
    String NGOptions="0";
    String SIGNID = "";
    String shortSubFlow="";
    TextView accident_text;
    CheckBox TieDaiL_check;
    RadioButton radio_new, radio_search, radio_continue, radio_chang,per_ressurize,after_ressurize;
    String WAREHouse_QTY,error_range,ngsunt,url_stting, exitMessage;
    java.text.DecimalFormat df = new java.text.DecimalFormat("#.0000");
    String dy_msgdy_msg, NaiBei_input, res_witness, notfind_c;
    RadioGroup TieDaigroup,reFullChk_Group,tied_f_group;
    private android.app.AlertDialog.Builder builder;
    public static final int FLAG_HOMEKEY_DISPATCHED = 0x80000000;
    HashMap<String,String> optionsNG=new HashMap<String,String>();
    final Map<String, Integer> weight = new HashMap<String, Integer> ();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cpuInfo = readCpuInfo();
        System.out.println("cpu==>"+cpuInfo);
        String serial = Build.SERIAL;
        getSupportFragmentManager().beginTransaction().commit();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);  //開始時不開鍵盤
        setContentView(R.layout.activity_main);

        weight.put("1x3.15", 52000);
        weight.put("1.7x5.4", 12300);
        weight.put("2.5x8", 4400);
        weight.put("3.5x10", 1700);
        weight.put("4x12", 1300);
        weight.put("4.5x14", 1000);
        TieDaigroup=(RadioGroup) findViewById(R.id.TieDaigroup);
        tied_f_group=(RadioGroup) findViewById(R.id.tied_f_group);
        date_spinner=(Spinner)findViewById(R.id.time);
        terrible_spinner=(Spinner)findViewById(R.id.terrible_spinner);
        imageView11 = (ImageView) findViewById(R.id.imageView11);
        NGselecdt=(Spinner)findViewById(R.id.NGselecdt);
        Painting_select=(Spinner)findViewById(R.id.Painting_select);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        String[] ngarraySpinner = new String[] {
                "非重複性檢測","NG1", "NG2", "NG3", "NG1+2", "NG1+3", "NG2+3", "NG1+2+3"
        };
        final ArrayAdapter<String> adapterNG = new ArrayAdapter<String>(this,
                R.layout.spinner_layout, ngarraySpinner);
        adapterNG.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        NGselecdt.setAdapter(adapterNG);
        ////////////////
        String[] terriblearraySpinner = new String[] {
                "0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10以上"
        };
        final ArrayAdapter<String> adapterterrible = new ArrayAdapter<String>(this,
                R.layout.spinner_layout, terriblearraySpinner);
        adapterterrible.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        terrible_spinner.setAdapter(adapterterrible);
        /////////////////////
        String[] PaintingSpinner = new String[] {
                "重量 Kg","數量"
        };
        final ArrayAdapter<String> adapterPainting = new ArrayAdapter<String>(this,
                R.layout.spinner_layout, PaintingSpinner);
        //adapterPainting.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Painting_select.setAdapter(adapterPainting);
        Painting_select.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
               sent_type = String.valueOf(position);//設定單位
               System.out.println("======>" + sent_type);
               if (sent_type.equals("0")) {
                   final_Texted.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
               } else {
                   final_Texted.setInputType(InputType.TYPE_CLASS_NUMBER);
               }

           }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
            });
        NGselecdt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                //System.out.println("======>"+NGselecdt.getItemIdAtPosition(position));
                //NGOptions=NGselecdt.getItemIdAtPosition(position);
                // NGOptions -- 外檢2 使用
                //        //1:NG1, 2:NG2, 3:NG3, 4:NG1+2, 5:NG1+3, 6:NG1+3, 7:NG1+2+3, 8：從前製程數量重做
                NGOptions= String.valueOf(position); // it will return your String so you can safely cast to it
                System.out.println("======>"+NGOptions);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        check_p = (Button) findViewById(R.id.check_p);
        Process_bnt= (Button) findViewById(R.id.Process_bnt);
        //Spinner s = (Spinner) findViewById(R.id.Spinner01);
        edit_buttom=(Button) findViewById(R.id.button9);
        button38=(Button) findViewById(R.id.button38);
        button41=(Button) findViewById(R.id.button41);
        coworker_bnt=(Button) findViewById(R.id.coworker_bnt);
        shift_bnt=(Button) findViewById(R.id.shift_bnt);
        bnt_todef=(Button) findViewById(R.id.bnt_todef);
        material_issue_bnt=(Button) findViewById(R.id.material_issue_bnt);
        url_Texted = (EditText) findViewById(R.id.url_Texted);
        input_lay= (LinearLayout) findViewById(R.id.input_lay);
        ful_lay= (LinearLayout) findViewById(R.id.ful);
        terrible_layout= (LinearLayout) findViewById(R.id.terrible_layout);
        Process_sw_block= (LinearLayout) findViewById(R.id.Process_sw_block);
        //LinearLayout.LayoutParams k;
        //k.setMargins(0,0,0);
       // layoutParams.setMargins(0, 250, 0, 0);
        wifi_bnt= (Button) findViewById(R.id.wifi);
        views2= (ImageButton) findViewById(R.id.views2);
        views = (ImageButton) findViewById(R.id.views);
        user_select = (Button) findViewById(R.id.user_select);
        color_userbnt= (Button) findViewById(R.id.color_userbnt);
        color_bnt= (Button) findViewById(R.id.color_bnt);
        bnt_myPrd = (ImageButton) findViewById(R.id.bnt_myPrd);
        warehouse= (Button) findViewById(R.id.warehouse);
        accident = (Button) findViewById(R.id.accident);
        testbutton = (Button) findViewById(R.id.test);
        send_bnt = (Button) findViewById(R.id.send_bnt);
        wifi_bnt2= (Button) findViewById(R.id.wifi_bnt2);
        accident_text=(TextView) findViewById(R.id.textView52);
        ver=(TextView) findViewById(R.id.ver);
        accident_text.bringToFront();
        TieDaiL_check= (CheckBox) findViewById(R.id.TieDaicheck);
        ////////////
        date_spinner=(Spinner)findViewById(R.id.time);
        date_spinner=(Spinner)findViewById(R.id.time);
        Date current = new Date();
        options_date.add("請選擇日期");
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
        /////////////
        finsh_thai=(TextView) findViewById(R.id.finsh_thai);
        def_thai=(TextView) findViewById(R.id.def_thai);
        textView51=(TextView) findViewById(R.id.textView51);
        WAREHouse_QTY_text_value=(TextView) findViewById(R.id.WAREHouse_QTY_text_value);
        WAREHouse_QTY_text_title=(TextView) findViewById(R.id.WAREHouse_QTY_text_title);
        finsh_thai.setVisibility(INVISIBLE);
        def_thai.setVisibility(INVISIBLE);
        button41=(Button) findViewById(R.id.button41);
        SharedPreferences saveip = getPreferences(Activity.MODE_PRIVATE);
        SharedPreferences saveC = getPreferences(Activity.MODE_PRIVATE);
        ip_str = saveip.getString("ip", "");
        start_edit=saveip.getInt("start_edit", 0);
        error_range = saveip.getString("error_range", "0");
        facroryNo=1;
        Process = saveip.getString("Process", "花蓮切割");
        if (Process.equals("選擇部門"))Process="花蓮切割";
        //load setting config from memory
        camera_str=saveip.getInt("camera_str", 1);
        facroryNo = saveip.getInt("facroryNo", 1);
        COLOR_inverse = saveip.getInt("COLOR_inverse", 1);
        String last_user= saveip.getString("last_user", "");
        coworker_bar= saveip.getString("coworker", "");
        COW_name= saveip.getString("COW_name", "");
        if(last_user.equals("")){
            button1 = (Button) findViewById(R.id.button2);
            button1.setVisibility(VISIBLE);
            button41.setVisibility(INVISIBLE);//閃退重登紐
        }else {
            button1 = (Button) findViewById(R.id.button2);
            //button1.setVisibility(INVISIBLE);
            button1.setEnabled(false);
            button41.setVisibility(VISIBLE);//閃退重登紐
        }
        host= "http://"+ip_str+"/firstohmWebApi/";
        if (check_ver == 1) {
            manager = getSupportFragmentManager();
            transaction = manager.beginTransaction();
            transaction.commit();
            check_ver = 0;
        }
        update();
        def_bnt = (Button) findViewById(R.id.def_bnt);
        button11 = (Button) findViewById(R.id.button);
        spinner = (Spinner) findViewById(R.id.spinner);
        version = (TextView) findViewById(R.id.version);
        if (start_edit==1){
            strsttext="可改開始";
        }else {
            strsttext="不可改開始";
        }
        DEPT_Texted = (EditText) findViewById(R.id.DEPT_Texted);
        button29=(Button) findViewById(R.id.button29);//調整隱藏button
        if (cpuInfo.indexOf("aarch64") > -1 ){ //華為  縮調整隱藏button
            button29.setVisibility(GONE);
        }else {//聯想 開button
            button29.setVisibility(INVISIBLE);
        }
        version.setText("Version. " + now_version + "\n廠區:" + facroryNo + " : " + Process+"\n"+strsttext);
        preNaiBei_text = (TextView) findViewById(R.id.preNaiBei_text);
        spinner.post(new Runnable() {
            public void run() {
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1,
                                               int arg2, long arg36) {
                        // TODO Auto-generated method stub
                        String mselection = spinner.getSelectedItem().toString();
                        machineBar = mselection;
                        check_p = (Button) findViewById(R.id.check_p);
                        check_7 = (Button) findViewById(R.id.button7);
                        check_g = (Button) findViewById(R.id.button);
                        accident = (Button) findViewById(R.id.accident);
                        //check_p.setVisibility(VISIBLE);
                        DEPT_Texted = (EditText) findViewById(R.id.DEPT_Texted);
                        MachineParams_Texted = (EditText) findViewById(R.id.MachineParams_Texted);
                        InputQuan_Texted = (EditText) findViewById(R.id.InputQuan_Texted);
                        AccQuan_Texted = (EditText) findViewById(R.id.AccQuan_Texted);
                        final_Texted = (EditText) findViewById(R.id.final_Texted);
                        furyu_Texted = (EditText) findViewById(R.id.furyu_Texted);
                        MachineParams_Texted.setVisibility(INVISIBLE);
                        if (!Process.equals("花蓮貼帶")) {
                            try {
                                float i2 = Float.parseFloat(AccQuan);
                                v_flow_title.setText("本製程已完成" + i2);
                            } catch (NullPointerException e) {
                                //v_flow_title.setText(AccQuan);
                            }
                        }
                        AccQuan_Texted.setText(StepLeft);
                        DEPT_Texted.setVisibility(INVISIBLE);
                        //MachineParams_Texted.setVisibility(VISIBLE);
                        if (Process.equals("花蓮切割")) {
                            textView9.setVisibility(VISIBLE);
                            InputQuan_Texted.setVisibility(VISIBLE);
                        }else{
                            InputQuan_Texted.setVisibility(VISIBLE);
                            textView9.setVisibility(VISIBLE);
                        }
                        AccQuan_Texted.setVisibility(VISIBLE);
                        final_Texted.setVisibility(VISIBLE);
                        furyu_Texted.setVisibility(VISIBLE);
                        //textView9.setVisibility(VISIBLE);
                        textView10.setVisibility(VISIBLE);
                        textView19.setVisibility(VISIBLE);
                        //  textView20.setVisibility(VISIBLE);
                        if (Process.equals("底漆")) {
                            textView2.setVisibility(VISIBLE);
                            textView2.setText("機台         A001");
                        }else if (Process.equals("花蓮電鍍")) {
                            AccQuan_Texted.setVisibility(INVISIBLE);
                            textView10.setVisibility(INVISIBLE);
                            textView2.setText("電鍍");
                        }else {
                            textView2.setVisibility(VISIBLE);
                            textView2.setText("機台");
                        }
                        textView4.setVisibility(VISIBLE);
                        textView.setVisibility(VISIBLE);
                      //  textView6.setVisibility(VISIBLE);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
                        // TODO Auto-generated method stub
                    }
                });            }
        });

        textView2 = (TextView) findViewById(R.id.textView2);
        textView6 = (TextView) findViewById(R.id.textView6);
        textView = (TextView) findViewById(R.id.textView);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView9 = (TextView) findViewById(R.id.textView9);
        textView10 = (TextView) findViewById(R.id.textView10);
        textView19 = (TextView) findViewById(R.id.textView19);
        textView20 = (TextView) findViewById(R.id.textView20);
        DEPT_Texted = (EditText) findViewById(R.id.DEPT_Texted);
        MachineParams_Texted = (EditText) findViewById(R.id.MachineParams_Texted);
        InputQuan_Texted = (EditText) findViewById(R.id.InputQuan_Texted);
        final_Texted = (EditText) findViewById(R.id.final_Texted);
        furyu_Texted = (EditText) findViewById(R.id.furyu_Texted);
        AccQuan_Texted = (EditText) findViewById(R.id.AccQuan_Texted);
        messageview = (TextView) findViewById(R.id.messageview);
        note_title = (TextView) findViewById(R.id.note_title);
        note_value = (EditText) findViewById(R.id.note_value);
        setting = (ImageButton) findViewById(R.id.setting);
        messageview = (TextView) findViewById(R.id.messageview);
        name_textView = (TextView) findViewById(R.id.name_textView);
        DEPT_Texted = (EditText) findViewById(R.id.DEPT_Texted);
        spinner = (Spinner) findViewById(R.id.spinner);
        textView2 = (TextView) findViewById(R.id.textView2);
        sptest = (Button) findViewById(R.id.sptest);
        shotsub_text = (EditText) findViewById(R.id.shotsub_text);
        shotsub_button = (Button) findViewById(R.id.shotsub_button);
        //shotsub_title= (TextView) findViewById(R.id.shotsub_title);
        //if(Process.indexOf("外檢") > -1){
            AccQuan_Texted.setText("0");
            //AccQuan_Texted.addTextChangedListener(textWatcher);
        //}else {
            final_Texted.addTextChangedListener(textWatcher);
        //}
        furyu_Texted.addTextChangedListener(textWatcher);
        //AccQuan_Texted.addTextChangedListener(textWatcher2);
        shotsub_text.addTextChangedListener(textWatcher);
        test = (Button) findViewById(R.id.test);
        accident = (Button) findViewById(R.id.accident);
        testnbnnt = (Button) findViewById(R.id.testbnt);
        v_flow_title = (TextView) findViewById(R.id.v_flow_title);
        MachineIM = (TextView) findViewById(R.id.Machine);
        messageview = (TextView) findViewById(R.id.messageview);
        BATCH_NO_text_value = (TextView) findViewById(R.id.BATCH_NO_text_value);
        BATCH_NO_text_title = (TextView) findViewById(R.id.BATCH_NO_text_title);
        SUBFLOWID_text_value= (TextView) findViewById(R.id.SUBFLOWID_text_value);
        SUBFLOWID_text_title= (TextView) findViewById(R.id.SUBFLOWID_text_title);
        mfo_id_text_title = (TextView) findViewById(R.id.mfo_id_text_title);
        BATCH_QTY_text_title = (TextView) findViewById(R.id.BATCH_QTY_text_title);
        DELDATE_text_title = (TextView) findViewById(R.id.DELDATE_text_title);
        RTYPE_text_title = (TextView) findViewById(R.id.RTYPE_text_title);
        TOL_text_title = (TextView) findViewById(R.id.TOL_text_title);
        PPM_text_title = (TextView) findViewById(R.id.PPM_text_title);
        COLOR_NUM_text_title = (TextView) findViewById(R.id.COLOR_NUM_text_title);
        VAL_text_title = (TextView) findViewById(R.id.VAL_text_title);
        VAL_text_value = (TextView) findViewById(R.id.VAL_text_value);
        sumOfNaiBei_text_title = (TextView) findViewById(R.id.sumOfNaiBei_text_title);
        mfo_id_text_value = (TextView) findViewById(R.id.mfo_id_text_value);
        BATCH_QTY_text_value = (TextView) findViewById(R.id.BATCH_QTY_text_value);
        DELDATE_text_value = (TextView) findViewById(R.id.DELDATE_text_value);
        RTYPE_text_value = (TextView) findViewById(R.id.RTYPE_text_value);
        TOL_text_value = (TextView) findViewById(R.id.TOL_text_value);
        PPM_text_value = (TextView) findViewById(R.id.PPM_text_value);
        COLOR_NUM_text_value = (TextView) findViewById(R.id.COLOR_NUM_text_value);
        TV_mfo_id_V = (TextView) findViewById(R.id.Machine);
        name_textView = (TextView) findViewById(R.id.name_textView);
        v_flow_title = (TextView) findViewById(R.id.v_flow_title);
        textView9 = (TextView) findViewById(R.id.textView9);
        textView10 = (TextView) findViewById(R.id.textView10);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView = (TextView) findViewById(R.id.textView);
        textView6 = (TextView) findViewById(R.id.textView9);
        note_title = (TextView) findViewById(R.id.note_title);
        note_value = (EditText) findViewById(R.id.note_value);
        part_finish_bnt = (Button) findViewById(R.id.part_finish);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        hide_bnt1= (Button) findViewById(R.id.hide_bnt1);
        hide_bnt2= (Button) findViewById(R.id.hide_bnt2);
        reget = (Button) findViewById(R.id.button3);
        if ((cpuInfo.contains("intel") || cpuInfo.contains("amd")))
            reget.setVisibility(VISIBLE);
        textView51.setVisibility(View.INVISIBLE);
        //progressBar.setVisibility(VISIBLE);
    }

    int fugu;
    String ooo, MachineID="", DEPT, MachineParams, preNaiBei="null", StaticParams, FLOW_STEP="",FLOW_STEP_CURR="", Start_TIME, Finish_Time, OutputQuan, InputQuan, AccQuan, deptp;

    String encodedUrl, encodedUrl2, encodedUrl3, g_text, return_barcode, strIsbn, machineBar = "", maeVAL, maeRTYPE, BATSEQ="0", BATCH_NO1, TestTimes, ACCDefect, StepLeft, Message, SUBFLOWID;
    String barCodeType, BASE_ID, mfo_id, DELDATE, RTYPE, BATCH_NO, VAL, TOL, BATCH_QTY, DONE_QTY, PPM, order_ppm, CUTTYPE, FINISH_TIME, START_TIME, name,nameout;
    static String COW_name="",COLOR_NUM;
    public void insertIntoDb(View v) {

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { //TV_mfo_id_V=(TextView)findViewById(R.id.Machine);
        button1 = (Button) findViewById(R.id.button2);
        getinfo = (Button) findViewById(R.id.GET_INFO);
        button11 = (Button) findViewById(R.id.button);
        warehouse=(Button) findViewById(R.id.warehouse);
        Supervisor_check = (Button) findViewById(R.id.Supervisor_check);
        sum = (Button) findViewById(R.id.test);
        getu = (Button) findViewById(R.id.getu);
        TV_mfo_id_V = (TextView) findViewById(R.id.Machine);
        InputQuan_Texted = (EditText) findViewById(R.id.InputQuan_Texted);
        AccQuan_Texted = (EditText) findViewById(R.id.AccQuan_Texted);
        final_Texted = (EditText) findViewById(R.id.final_Texted);
        furyu_Texted = (EditText) findViewById(R.id.furyu_Texted);
        getg = (Button) findViewById(R.id.getg);
        testbnt = (Button) findViewById(R.id.testbnt);
        reget = (Button) findViewById(R.id.button3);
        if ((cpuInfo.contains("intel") || cpuInfo.contains("amd")))
            reget.setVisibility(VISIBLE);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null && check_scan == 0&& coworker_flag == 0) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                strIsbn = result.getContents();
                Toast.makeText(this, strIsbn, Toast.LENGTH_LONG).show();
                if (strIsbn.indexOf("%") > -1) {
                    Toast.makeText(this, "讀入變數 工令單: " + result.getContents(), Toast.LENGTH_LONG).show();
                    flowBar = result.getContents();//得到flowBar
                    button38.performClick();
                } else if (strIsbn.indexOf("|") > -1) {
                    Toast.makeText(this, "讀入變數 取庫單: " + result.getContents(), Toast.LENGTH_LONG).show();
                    warehouseBar = result.getContents();//得到iuserBar
                    warehouse.performClick();
                } else if (strIsbn.indexOf("*") > -1) {
                    Toast.makeText(this, "讀入變數員工編號: " + result.getContents(), Toast.LENGTH_LONG).show();
                    if (userBar.equals("")){userBar = result.getContents();}//得到imachineBar
                    fugu = 1;
                    testbnt.performClick();
                }
                try {
                    Thread.sleep(1000); //1000為1秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (flowBar != null && userBar != null) {
                        }
                    }
                }, 1000);
            }
        }else if(coworker_flag == 1&&result.getContents().indexOf("*")>-1){//合作
            coworker_bar = result.getContents();//得到iuserBar
            coworker_flag = 0;
            coworker_bar=coworker_bar.replaceAll("\\*", "");
            try
            {
                g_list.put("coworker", coworker_bar);
                coworker_bnt.setBackgroundResource(R.drawable.ic_people_green);
                call_rest restObj = new call_rest();
                String encodedUrl2 = "", encodedUrl3 = "";
                encodedUrl2 = URLEncoder.encode(userBar, "UTF-8");
                encodedUrl3 = URLEncoder.encode(Process, "UTF-8");//製程
                JSONObject rtnRestObj=restObj.callRest(host+"PrdMgn/Login?userBar=" +
                        coworker_bar + "&Dept=" + encodedUrl3 + "&facroryNo=" + facroryNo+"&coworker=1");//+192.168.1.1);
                SharedPreferences remdname = getPreferences(Activity.MODE_PRIVATE);
                SharedPreferences.Editor edit = remdname.edit();

                JSONArray array = new JSONArray(rtnRestObj.getString("Data"));
                for (int i = 0; i < array.length(); i++) {
                    JSONObject ob = array.getJSONObject(i);
                    COW_name = ob.getString("EMPNAME") == null ? "" : ob.getString("EMPNAME");
                }

                edit.putString("coworker", coworker_bar);
                edit.putString("COW_name", COW_name);
                edit.commit();
                Message m = new Message();
                m.what = MEG_INVALIDATE;
                cow.sendMessage(m);
            }catch (Exception e) {

            }
        } else if (result != null && check_scan == 1) {
            witness = 1;
            check_scan = 0;
            res_witness = result.getContents();
            Supervisor_check.performClick();
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void scan(View view) {
        IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
        if (camera_str == 1) {
            integrator.setCameraId(1);
        } else {
            integrator.setCameraId(0);
        }
        integrator.initiateScan();
    }

    @SuppressLint("WrongViewCast")
    Float input_int;
    Float newACCDefect;
    Float furtu;
    Float finalint;
    Float newacc;

    public void edit_set01(View view) {
        if( machineBar.equals("選擇機台") || machineBar.equals("")){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("需要選擇機台");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                }
            });
            builder.show();
        }else if( Process.equals("花蓮加壓")||Process.equals("花蓮切割")){
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            final View v = inflater.inflate(R.layout.get_value, null);   //   get viwe layout\
            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            TextView title = new TextView(this);
            title.setText(Process);
            final TextView KEY= (TextView) v.findViewById(R.id.KEY);//全檢分類
            final TextView VAL=(TextView) v.findViewById(R.id.VAL);//全檢分類
            if( Process.equals("花蓮加壓")){
                KEY.setText("電壓");
            }
            if(Process.equals("花蓮切割")){
                KEY.setText("速度");
            }
            //ipe.setFocusable(false);// ip不能改
            title.setGravity(Gravity.CENTER);
            title.setTextSize(24);
            dialog.setCustomTitle(title);
            dialog.setView(v);
            dialog.setPositiveButton("送出", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    speed_value=VAL.getText().toString();
                    View rootView = getWindow().getDecorView().getRootView();
                    edit_set1(rootView);
                }
            });
            dialog.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

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
        }else{
            View rootView = getWindow().getDecorView().getRootView();
            edit_set2(rootView);
        }
    }
    public void edit_set2(View view) {
        if(!InputQuan_Texted.getText().toString().equals(InputQuan)){
            if(Process.indexOf("檢")>-1){
                View rootView = getWindow().getDecorView().getRootView();
                edit_set1(rootView);
            }else {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("開始量已修改是否送出");
                builder.setCancelable(false);
                builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        try {
                            g_list.put("Note", URLEncoder.encode(note_value.getText().toString(), "UTF-8")+"翻車X"+terrible_spinner.getSelectedItem().toString());
                            note_value.setText("開始量由"+InputQuan+"改為"+InputQuan_Texted.getText().toString()+"修改人"+userBar);
                            View rootView = getWindow().getDecorView().getRootView();
                            edit_set1(rootView);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        InputQuan_Texted.setText(InputQuan);
                        dialog.cancel();
                    }
                });
                builder.show();
            }
        }else{
            edit_set1(view);
        }
    }
    public void edit_set1(View view) {//完成送出
        float c;
        try {
           c = Float.parseFloat(AccQuan_Texted.getText().toString());
        } catch (NumberFormatException e) {
            c=0;
        }
        if (c<=1000 && c>0&&Process.equals("花蓮切割")){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("「交接料只剩1000不到，請問是否要繼續做完」");
            builder.setCancelable(false);
            builder.setPositiveButton("否", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    try {
                        View rootView = getWindow().getDecorView().getRootView();
                        edit(rootView);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            });
            builder.setNegativeButton("是", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // TODO Auto-generated method stub
                            dialog.cancel();
                        }
                    });
            builder.show();
        }else if(Process.equals("花蓮貼帶")){
            int selected = TieDaigroup.getCheckedRadioButtonId();
            RadioButton radioBtn1 = (RadioButton) findViewById(selected);
            if (radioBtn1.getText().equals("捲數")){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("確定送出為捲數?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                                try {
                                    View rootView = getWindow().getDecorView().getRootView();
                                    edit(rootView);
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                                dialog.cancel();
                            }
                        });
                AlertDialog about_dialog = builder.create();
                about_dialog.show();

            }else{
                try {
                View rootView = getWindow().getDecorView().getRootView();
                edit(rootView);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            }
        }else{
            try {
            View rootView = getWindow().getDecorView().getRootView();
            edit(rootView);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        }

    }
    public void edit(View view) throws UnsupportedEncodingException {
        //finsh button  完成
        System.out.println("finalcmd=====>" + final_Texted.getText().toString());
        if(final_Texted.getText().toString().equals("")){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("需要輸入完成量");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {}
            });
            builder.show();
        }
        else{
            firtst_select=0;//重置全檢開始可選全檢1.2//mothing
            if(!Process.equals("花蓮電鍍")) {
                finsh_flag = 1;
                conf_flag = "";
                popMsg = "";
                if (Process.equals("外檢1") || Process.equals("花蓮外檢")) {
                    //Process = "外檢1";
                    checkout_finsh(view); //NG 1.2.3
                    try {
                        Thread.sleep(3000); //1000為1秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                final String[] finshtext = {""};
                final Button test = (Button) findViewById(R.id.test);
                accident.setVisibility(VISIBLE);
                accident_text.setVisibility(VISIBLE);
                sptest.setVisibility(INVISIBLE);
                part_finish_bnt.setVisibility(INVISIBLE);
                startflig = 0;
                try {
                    c_input = Float.parseFloat(InputQuan_Texted.getText().toString());
                    c_final = Float.parseFloat(final_Texted.getText().toString());
                    c_furtu = Float.parseFloat(furyu_Texted.getText().toString());
                    c_acc = Float.parseFloat(AccQuan_Texted.getText().toString());
                } catch (NumberFormatException e) {
                }
                final Thread thread = new Thread(new Runnable() {
                    public void run() {
                        String note, new_MachineID, new_DEPT, new_MachineParams, new_FLOW_STEP, new_Start_TIME, new_Finish_Time, new_InputQuan = "0", new_AccQuan = "0", new_final = "0", new_furtu = "0", old_InputQuan;
                        //new_MachineID = spinner.getSelectedItem().toString();
                        //new_DEPT = DEPT_Texted.getText().toString();
                        note = note_value.getText().toString();
                        //int finalcmd = 6;
                        int finalcmd = 11;
                        if (start_edit == 1 || Process.equals("花蓮色碼")) {  //改開始量完成cmd改11
                            finalcmd = 11;
                        }
                        if (Process.equals("花蓮貼帶")) {//貼帶完成cmd改36
                            finalcmd = 36;
                        }
                        if (Process.indexOf("檢") > -1) {//貼帶完成cmd改36
                            finalcmd = 11;
                        }
                        try {
                            new_MachineParams = MachineParams_Texted.getText().toString();
                            new_InputQuan = InputQuan_Texted.getText().toString();
                            new_AccQuan = AccQuan_Texted.getText().toString();
                            new_final = final_Texted.getText().toString();
                            new_furtu = furyu_Texted.getText().toString();
                            if (new_InputQuan.equals("") || new_InputQuan.equals(null)) {
                                new_InputQuan = "0";
                            }
                            if (new_final.equals("") || new_final.equals(null)) {
                                new_final = "0";
                            }
                            if (new_furtu.equals("") || new_furtu.equals(null)) {
                                new_furtu = "0";
                            }
                            int newacc =Integer.valueOf(new_InputQuan.toString());
                            int  finalint =Integer.valueOf(new_final.toString());
                            int furtu =Integer.valueOf(new_furtu.toString());
                            int input_int = Integer.valueOf(new_InputQuan.toString());
                            int   newACCDefect = newacc + furtu;
                            String ACCsrt = valueOf(newACCDefect);//newACCDefect.toString()
                        } catch (NumberFormatException e) {

                        }
                        String new_uid = userBar.replaceAll("\\*", "");
                        try {
                            if(!coworker_bar.equals("")){
                                g_list.put("coworker", coworker_bar);
                            }
                            new_AccQuan = new_AccQuan.replaceAll("\\.0", "");
                            if (new_AccQuan.equals("")){new_AccQuan="0";}
                            if (Process.equals("花蓮加壓")|| Process.equals("花蓮切割") && !speed_value.equals("")) {
                                g_list.put("machineSpeed", speed_value);
                            }
                            g_list.put("material_issue", material_issue);
                            if(!WAREHouse_QTY.equals("0") &&InputQuan.equals("0")){
                                g_list.put("FLOW_STEP", Process);
                            }
                            if (Process.equals("花蓮貼帶")) {//貼帶完成選支數或捲數
                                int selected = TieDaigroup.getCheckedRadioButtonId();
                                RadioButton radioBtn1 = (RadioButton) findViewById(selected);
                                if (radioBtn1.getText().equals("支數")){
                                    float tdRoll =  Float.parseFloat(tdRollQty.toString());
                                    g_list.put("tdDoneQty", valueOf(c_final/(tdRoll*1000)));
                                    // g_list.put("tdRollQty", valueOf(c_furtu/(tdRoll*1000)));
                                    g_list.put("tfLeftQty", valueOf(c_acc/(tdRoll*1000)));
                                    g_list.put("OutputQuan", new_final);
                                }else{
                                    float tdRoll = Float.parseFloat(tdRollQty.toString());
                                    float new_fina =  Float.parseFloat(new_final.toString());
                                    g_list.put("OutputQuan",new_fina*tdRoll*1000);
                                    g_list.put("tdDoneQty", new_final);
                                    // g_list.put("tdRollQty", new_furtu);
                                    g_list.put("tfLeftQty", new_AccQuan);
                                }//送出統一換捲數
                                g_list.put("InputQuan", new_InputQuan);
                                g_list.put("DefectQuan", new_furtu);
                                g_list.put("StepLeft", new_AccQuan);
                                if(Process.equals("花蓮貼帶")&&si_f==0){
                                    g_list.put("StepLeft", "0");
                                    //g_list.put("tfLeftQty", newacc-finalint);
                                }else{
                                    g_list.put("StepLeft", new_AccQuan);
                                }
                            }else if (!Process_SWT.equals("")&&!Size.equals("")&&sent_type.equals("0")) {
                                float fin = Float.parseFloat(new_final)*Integer.valueOf(weight.get(Size));
                                g_list.put("InputQuan", new_InputQuan);
                                g_list.put("OutputQuan", String.valueOf(fin));
                                g_list.put("DefectQuan", new_furtu);
                                g_list.put("StepLeft", new_AccQuan);
                            }else{
                                g_list.put("InputQuan", new_InputQuan);
                                g_list.put("OutputQuan", new_final);
                                g_list.put("DefectQuan", new_furtu);
                                g_list.put("StepLeft", new_AccQuan);
                            }

                            if((Process.equals("花蓮外檢") || FLOW_STEP_CURR.equals("外檢2")) ||
                                    (Process.equals("花蓮外檢") || FLOW_STEP_CURR.equals("外檢1") )) {
                                g_list.put("colorUser", check_userid);
                            }
                            g_list.put("Note", URLEncoder.encode(note, "UTF-8"));
                            if(Process.equals("花蓮底漆")&&!terrible_spinner.getSelectedItem().toString().equals("0")){
                                g_list.put("Note", URLEncoder.encode(note, "UTF-8")+"翻車次數"+terrible_spinner.getSelectedItem().toString()+"次");
                            }
                            String encodedUrl = "", encodedUr2 = "", encodedUr3 = "", encodedUr4 = "";
                            encodedUrl = URLEncoder.encode(flowBar, "UTF-8");
                            encodedUr2 = URLEncoder.encode(userBar, "UTF-8");
                            encodedUr3 = URLEncoder.encode(machineBar, "UTF-8");
                            encodedUr4 = URLEncoder.encode(Process, "UTF-8");
                            String u = host + "PrdMgn/ScanOperate?command=" + finalcmd + "&UID=" + encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3;
                            HttpClient http = new DefaultHttpClient();
                            HttpPost post = new HttpPost(u);
                            //完成送出
                            String g_list2 = g_list.toString();
                            url_stting = host + "PrdMgn/ScanOperate?command=" + finalcmd + "&UID=" + encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3 + "&jsonStr=" + g_list2;
                            System.out.println("finalcmd=====>" + url_stting+g_list2);
                            List params = new ArrayList();
                            params.add(new BasicNameValuePair("jsonStr", g_list2));
                            UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params, HTTP.UTF_8);
                            post.setEntity(ent);
                            HttpResponse responsePOST = http.execute(post);
                            HttpEntity resEntity = responsePOST.getEntity();
                            String result = EntityUtils.toString(resEntity);
                            JSONObject loginJson = new JSONObject(result.toString());
                            StringBuilder sb = new StringBuilder();
                            String line = "";
                            Message = loginJson.getString("Message");
                            if (Message.indexOf("錯誤") > -1 || Message.indexOf("無法") > -1) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage(Message);
                                builder.setCancelable(false);
                                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {

                                    }
                                });
                                //builder.show();

                            }
                            Succ = loginJson.getString("Succ");
                            code = loginJson.getString("Code");
                            String Data = loginJson.getString("Data");
                            if (Data.length() > 100) {
                                dataobj = new JSONObject(Data);
                                conf_flag = "n";
                                g_list = dataobj;
                                MachineID_Befor = dataobj.getString("MachineID") == null ? "" : g_list.getString("MachineID");
                                USER_ID_Befor = dataobj.getString("USER_ID") == null ? "" : g_list.getString("USER_ID");
                                SIGNID = dataobj.getString("SIGNID") == null ? "" : dataobj.getString("SIGNID");
                                AccQuan = dataobj.getString("AccQuan") == null ? "" : dataobj.getString("AccQuan");
                                OutputQuan = dataobj.getString("OutputQuan") == null ? "" : dataobj.getString("OutputQuan");
                                InputQuan = dataobj.getString("InputQuan") == null ? "" : dataobj.getString("InputQuan");
                                TestCnt = dataobj.getString("TestCnt") == null ? "" : dataobj.getString("TestCnt");
                                popMsg = dataobj.getString("popMsg") == null ? "" : dataobj.getString("popMsg");
                                material_issue.clear();
                                Message m2 = new Message();
                                m2.what = MEG_INVALIDATE;
                                AfterFinshMessageHandle.sendMessage(m2);
                            } else {
                                conf_flag = Data;
                                material_issue.clear();
                                Message m2 = new Message();
                                m2.what = MEG_INVALIDATE;
                                AfterFinshMessageHandle.sendMessage(m2);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            View rootView = getWindow().getDecorView().getRootView();
                            send_urlsting(rootView);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            View rootView = getWindow().getDecorView().getRootView();
                            send_urlsting(rootView);
                        }catch (Exception e) {
                        }
                    }
                });  //Thread  end
                float temp1 = Float.parseFloat(InputQuan.toString());
                InputQuan = valueOf(temp1);
                witness = 1;//送出條件判斷
                if (witness == 0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("需要見證人才能更改開始數量");
                    builder.setCancelable(false);
                    test.setVisibility(VISIBLE);
                    accident.setVisibility(INVISIBLE);
                    accident_text.setVisibility(INVISIBLE);
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            InputQuan_Texted = (EditText) findViewById(R.id.InputQuan_Texted);
                            InputQuan_Texted.setText(InputQuan.toString());
                            testbutton.setVisibility(VISIBLE);
                            accident.setText("刪除");
                            accident.setVisibility(INVISIBLE);
                            accident_text.setVisibility(INVISIBLE);
                            startflig = 1;
                        }
                    });
                    builder.show();
                } else {
                    int testcount = 0;
                    if (sumOfNaiBei.equals(null) || sumOfNaiBei.equals("null") || sumOfNaiBei == null)
                        sumOfNaiBei = "0";
                    int sumsumOfNaiBei = Integer.valueOf(sumOfNaiBei);
                    c_input = c_input - sumsumOfNaiBei;
                    try {
                        testcount = Integer.parseInt(TestTimes);
                    } catch (Exception e) {

                        CharArrayWriter cw = new CharArrayWriter();
                        PrintWriter w = new PrintWriter(cw);
                        e.printStackTrace(w);
                        w.close();
                        trace = cw.toString();
                    }//加壓次數


                    String old_InputQuan = InputQuan.toString();
                    if (InputQuan == null) {
                        InputQuan = "0";
                    }
                    if (c_final>=1) {}else{c_final = 0;}
                    if (c_furtu>=1) {}else{c_furtu = 0;}
                    if (c_acc>=1) {}else{c_acc = 0;}
                    System.out.println("--------------------"+c_final+c_furtu+c_acc);
                    if (chang_color == 1) {   ///換色完成
                        accident.setVisibility(VISIBLE);
                        accident.setText("開始");
                        accident.setVisibility(VISIBLE);
                        accident_text.setVisibility(VISIBLE);

                        test.setVisibility(INVISIBLE);
                        sptest.setVisibility(INVISIBLE);
                        part_finish_bnt.setVisibility(INVISIBLE);
                        thread.start();//送出完成
                        int i1 = 0;
                        while (true) {
                            i1++;
                            if (i1 == 9) break;
                            if (conf_flag.indexOf("2") > -1) { //需要確認                                   //
                                conf_flag = "0";
                                ShowpopMsg_confrn(view);//confrn popup
                            } else if (conf_flag.indexOf("1") > -1) { //停止                                   //
                                conf_flag = "0";
                                ShowpopMsg_stop(view);//confrn popup
                            }
                        }
                    } else if (testcount < 2 && Process.equals("加壓")) {  //加壓需2次測試
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("完成前請先做製成測試");
                        builder.setCancelable(false);
                        accident.setVisibility(VISIBLE);
                        accident_text.setVisibility(INVISIBLE);

                        test.setVisibility(VISIBLE);
                        testbutton.setVisibility(VISIBLE);
                        accident.setText("刪除");
                        accident.setVisibility(INVISIBLE);
                        startflig = 1;
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
                        builder.show();
                    }  else if (((Size.equals("1x3.15")
                            && (c_input - 1000 > c_final + c_furtu + c_acc) ))
                            && Process.equals("花蓮切割")
                            && !ifLeader_forinput.equals("1")
                        //||((Size.equals("1x3.15") && (c_input + 1000 < c_final + c_furtu + c_acc)))&& !(Process.indexOf("切") ==2)) ) && !(Process.indexOf("貼") ==2)
                    )
                    {
                        //開始          完成    不良   交接
                        System.out.println("1.3error");
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("1x3.15送出的完成量、不良量與交接量需介於開始量+-1000支內");
                        builder.setCancelable(false);
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                testbutton.setVisibility(VISIBLE);
                                //accident.setVisibility(INVISIBLE);
                                accident.setText("刪除");
                                accident.setVisibility(INVISIBLE);
                                startflig = 1;
                            }
                        });
                        builder.show();
                    } else if (((((Size.equals("0.8x1.9")
                            && (c_input - 2000 > c_final + c_furtu + c_acc)
                            && Process.equals("花蓮切割")
                            && !ifLeader_forinput.equals("1")
                            //||((Size.equals("0.8x1.9") && (c_input + 2000 < c_final + c_furtu + c_acc)))
                    ) //||
                    )))&& !(Process.indexOf("貼") ==2)) {
                        ifLeader_forinput="1";
                        System.out.println("0.8error");
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("0.8x1.9送出的完成量、不良量與交接量需介於開始量+-2000支內\n0.8x1.9送出的完成量、不良量與交接量需介於開始量+-2000支內");
                        builder.setCancelable(false);
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                testbutton.setVisibility(VISIBLE);
                                //accident.setVisibility(INVISIBLE);
                                accident.setText("刪除");
                                accident.setVisibility(INVISIBLE);
                                startflig = 1;
                            }
                        });
                        builder.show();
                    }/* else if (((Size.equals("1.7x5.4")
                        && (c_input - 500 > c_final + c_furtu + c_acc) ))&& Process.equals("花蓮切割")
                        //||
                        //((Size.equals("1.7x5.4") && (c_input + 500 < c_final + c_furtu + c_acc)) ))&& !(Process.indexOf("貼") ==2))
                ) {
                    System.out.println("1.7error");
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("1.7x5.4送出的完成量、不良量與交接量需介於開始量+-500支內");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            testbutton.setVisibility(VISIBLE);
                            //accident.setVisibility(INVISIBLE);
                            accident.setText("刪除");
                            accident.setVisibility(INVISIBLE);
                            startflig = 1;
                        }
                    });
                    builder.show();
                } */
                /*else if (((
                        //(c_input - 2000 > c_final + c_furtu + c_acc)&& Process.equals("花蓮切割")
                (c_input + 2000 < c_final + c_furtu + c_acc))&& Process.equals("花蓮切割")
                        && !(Process.indexOf("貼") >-1))//數量
                ) {  // 允許值 + / - 2000
                    System.out.println("1.error"+c_input+"  "+c_final+"   "+c_furtu+"  "+c_acc+"  ");
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("送出的完成量、不良量與交接量需介於開始量+-2000支內");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            testbutton.setVisibility(VISIBLE);
                            //accident.setVisibility(INVISIBLE);
                            accident.setText("刪除");
                            accident.setVisibility(INVISIBLE);
                            startflig = 1;
                        }
                    });
                    builder.show();
                }*/else if (correct_rate < 0.8 && ifLeader.equals("0") && !final_Texted.getText().toString().equals("0")) {//正確率
                        accident.setVisibility(INVISIBLE);
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("檢驗結果正確率未達80%");//，需要主管見證才能送出
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                        builder.setCancelable(false);
                        //builder.show();
                        accident.setVisibility(VISIBLE);
                        accident.setText("開始");          //  6213559680000
                        accident.setVisibility(VISIBLE);
                        test.setVisibility(INVISIBLE);
                        sptest.setVisibility(INVISIBLE);
                        part_finish_bnt.setVisibility(INVISIBLE);
                        ifLeader = "0";
                        thread.start();//送出完成
                        int i1 = 0;
                        while (true) {
                            i1++;
                            if (i1 == 3) break;
                            if (conf_flag.indexOf("2") > -1) { //需要確認
                                ShowpopMsg_confrn(view);//confrn popup
                                break;
                            } else if (conf_flag.indexOf("1") > -1) { //停止
                                ShowpopMsg_stop(view);//confrn popup
                                break;
                            }
                        }
                    } else if (input_couint < (c_input / 1000)
                            && (Process.equals("花蓮切割")
                            && !final_Texted.getText().toString().equals("0"))) {//切割測試數量
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("製成檢驗數量不足");
                        builder.setCancelable(false);
                        accident.setText("開始");          //  6213559680000
                        accident.setVisibility(VISIBLE);
                        accident_text.setVisibility(VISIBLE);
                        test.setVisibility(INVISIBLE);
                        sptest.setVisibility(INVISIBLE);
                        part_finish_bnt.setVisibility(INVISIBLE);
                        ifLeader = "0";
                        thread.start();//送出完成
                        int i1 = 0;
                        while (true) {
                            i1++;
                            if (i1 == 9) break;
                            if (conf_flag.indexOf("2") > -1) { //需要確認                                   //
                                conf_flag = "0";
                                ShowpopMsg_confrn(view);//confrn popup
                            } else if (conf_flag.indexOf("1") > -1) { //停止                                   //
                                conf_flag = "0";
                                ShowpopMsg_stop(view);//confrn popup
                            }
                        }
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                        //builder.show();
                    } else {
                        url_Texted.invalidate();
                        url_Texted.setText(url_stting);
                        messageview.setText("訊息:" + Message);
                        try {
                            float i2 = Float.parseFloat(AccQuan);
                            v_flow_title.setText("本製程已完成" + i2);
                        } catch (NullPointerException e) {
                            v_flow_title.setText("本製程已完成" + AccQuan);
                        }
                        if (Message.indexOf("錯誤") > -1 || Message.indexOf("無法") > -1) {
                            messageview.setTextColor(android.graphics.Color.RED);
                        } else {
                            messageview.setTextColor(android.graphics.Color.BLUE);
                        }
                        accident.setVisibility(VISIBLE);
                        accident.setText("開始");          //  6213559680000
                        accident.setVisibility(VISIBLE);
                        test.setVisibility(INVISIBLE);
                        sptest.setVisibility(INVISIBLE);
                        part_finish_bnt.setVisibility(INVISIBLE);
                        ifLeader = "0";
                        witness = 0;
                        thread.start();//送出完成

                        int i1 = 0;
                        while (true) {
                            i1++;
                            if (i1 == 9) break;
                            if (conf_flag.indexOf("2") > -1) { //需要確認                                   //
                                conf_flag = "0";
                                ShowpopMsg_confrn(view);//confrn popup
                            } else if (conf_flag.indexOf("1") > -1) { //停止                                   //
                                conf_flag = "0";
                                ShowpopMsg_stop(view);//confrn popup
                            }
                        }
                    }
                }
            }else {

                plating_views_f(view);//電鍍
            }
        }

    }

    public void viwes(View view) {
        TV_mfo_id_V = (TextView) findViewById(R.id.Machine);
        TV_mfo_id_V.setText("讀入變數\n工令單: " + flowBar + "\n機台: " + machineBar + "\n員工編號: " + userBar);
    }

    @Override
    public void onListFragmentInteraction(Map<String, Object> item) {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void login(View view) {
        if (Process == "") {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("請設定此台平板所屬部門");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
            builder.show();
        } else {
            Button button4 = (Button) findViewById(R.id.button4);
            Button accident = (Button) findViewById(R.id.accident);
            Button sptest = (Button) findViewById(R.id.sptest);
            Button part_finish_bnt = (Button) findViewById(R.id.part_finish);
            Button test = (Button) findViewById(R.id.test);
            Button logout = (Button) findViewById(R.id.logout);
            ImageView imageView8 = (ImageView) findViewById(R.id.imageView8);
            ImageView report = (ImageView) findViewById(R.id.report);
            report.setVisibility(INVISIBLE);
            TextView version = (TextView) findViewById(R.id.version);
            version.setVisibility(INVISIBLE);
            button4.setVisibility(VISIBLE);
            //accident.setVisibility(VISIBLE);
            sptest.setVisibility(VISIBLE);
            if (Process.equals("花蓮切割") ){
                part_finish_bnt.setVisibility(VISIBLE);
            }else {
                part_finish_bnt.setVisibility(INVISIBLE);
            }
            logout.setVisibility(VISIBLE);
            imageView8.setVisibility(INVISIBLE);
            button1 = (Button) findViewById(R.id.button2);
            button1.setVisibility(INVISIBLE);
            IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
            if (camera_str == 1) {
                integrator.setCameraId(1);
            } else {
                integrator.setCameraId(0);
            }
            integrator.initiateScan();
        }
    }

    public void update_ui(JSONObject view) throws JSONException {
        SIGNID = null;
        barCodeType = null;
        FINISH_TIME = null;
        g_list = null;
        jsonStr = null;
        if (Message.indexOf("順序錯誤")>-1){
            Message=Message+" 如確認要開始，請掃描見證人繼續，並在開始後修改開始數量。";
        }
        if (Message.indexOf("錯誤") > -1 || Message.indexOf("無法") > -1) {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage(Message);
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
            //builder.show();

        }
        try
        {
        //allstr=rtnRestObj.getString("Message");
        g_list = null;
        popMsg = null;
        g_list = new JSONObject(g_json_string);
        jsonStr = g_json_string;
        mfo_id = g_list.getString("mfo_id") == null ? "" : g_list.getString("mfo_id");
        sumOfNaiBei = g_list.getString("sumOfNaiBei") == null ? "" : g_list.getString("sumOfNaiBei");
        //System.out.println("sumOfNaiBei"+sumOfNaiBei);
        BASE_ID = g_list.getString("BASE_ID") == null ? "" : g_list.getString("BASE_ID");
        DELDATE = g_list.getString("DELDATE") == null ? "" : g_list.getString("DELDATE");
        RTYPE = g_list.getString("RTYPE") == null ? "" : g_list.getString("RTYPE");
        BATCH_QTY = g_list.getString("BATCH_QTY") == null ? "" : g_list.getString("BATCH_QTY");
        if(Process.equals("花蓮貼帶")) {
            tdDoneQty = g_list.getString("tdDoneQty") == null ? "" : g_list.getString("tdDoneQty");
            tdRollQty = g_list.getString("tdRollQty") == null ? "" : g_list.getString("tdRollQty");
            tfLeftQty = g_list.getString("tfLeftQty") == null ? "" : g_list.getString("tfLeftQty");
        }
        TOL = g_list.getString("TOL") == null ? "" : g_list.getString("TOL");
        Size = g_list.getString("Size") == null ? "" : g_list.getString("Size");
        VAL = g_list.getString("VAL") == null ? "" : g_list.getString("VAL");
        BATSEQ = g_list.getString("BATSEQ") == null ? "" : g_list.getString("BATSEQ");
        BATCH_NO = g_list.getString("BATCH_NO") == null ? "" : g_list.getString("BATCH_NO");
        TestTimes = g_list.getString("TestTimes") == null ? "" : g_list.getString("TestTimes");//加壓用
        order_ppm = g_list.getString("order_ppm") == null ? "" : g_list.getString("order_ppm");
        PPM = g_list.getString("PPM") == null ? "" : g_list.getString("PPM");
        COLOR_NUM = g_list.getString("COLOR_NUM") == null ? "" : g_list.getString("COLOR_NUM");
        CUTTYPE = g_list.getString("CUTTYPE") == null ? "" : g_list.getString("CUTTYPE");
        START_TIME = g_list.getString("Start_TIME") == null ? "" : g_list.getString("Start_TIME");
        FINISH_TIME = g_list.getString("Finish_Time") == null ? "" : g_list.getString("Finish_Time");
        BATCH_NO = g_list.getString("BATCH_NO") == null ? "" : g_list.getString("BATCH_NO");
        BATCH_QTY = g_list.getString("BATCH_QTY") == null ? "" : g_list.getString("BATCH_QTY");
        if(Process.equals("花蓮貼帶")) {
            tdDoneQty = g_list.getString("tdDoneQty") == null ? "" : g_list.getString("tdDoneQty");
            tdRollQty = g_list.getString("tdRollQty") == null ? "" : g_list.getString("tdRollQty");
            tfLeftQty = g_list.getString("tfLeftQty") == null ? "" : g_list.getString("tfLeftQty");
        }SUBFLOWID = g_list.getString("SUBFLOWID") == null ? "" : g_list.getString("SUBFLOWID");
        DONE_QTY = g_list.getString("DONE_QTY") == null ? "" : g_list.getString("DONE_QTY");
        USER_ID = g_list.getString("USER_ID") == null ? "" : g_list.getString("USER_ID");
        SIGNID = g_list.getString("SIGNID") == null ? "" : g_list.getString("SIGNID");
        StepLeft = g_list.getString("StepLeft") == null ? "" : g_list.getString("StepLeft");
        notec = g_list.getString("Note") == null ? "" : g_list.getString("Note");
        popMsg = g_list.getString("popMsg") == null ? "" : g_list.getString("popMsg");
        dy_msgdy_msg = g_list.getString("dy_msgdy_msg") == null ? "" : g_list.getString("dy_msgdy_msg");
        lastSignID = g_list.getString("lastSignID") == null ? "" : g_list.getString("lastSignID");
        MachineID_Befor = g_list.getString("MachineID") == null ? "" : g_list.getString("MachineID");
        USER_ID_Befor = g_list.getString("USER_ID") == null ? "" : g_list.getString("USER_ID");
        InputQuan = g_list.getString("InputQuan") == null ? "" : g_list.getString("InputQuan");  //開始
        OutputQuan = g_list.getString("OutputQuan") == null ? "" : g_list.getString("OutputQuan");
        AccQuan = g_list.getString("AccQuan") == null ? "" : g_list.getString("AccQuan");
        FLOW_STEP = g_list.getString("FLOW_STEP") == null ? "" : g_list.getString("FLOW_STEP");
        preNaiBei = g_list.getString("preNaiBei") == null ? "" : g_list.getString("preNaiBei");
        DefectQuan = g_list.getString("DefectQuan") == null ? "" : g_list.getString("DefectQuan");

        if (!preNaiBei.equals("null")) {
            sunNaiBei = 0;
            JSONArray preNaiBeiJson_array = new JSONArray(g_list.getString("preNaiBei"));
            for (int j = 0; j < preNaiBeiJson_array.length(); j++) {
                preNaiBeiJson = preNaiBeiJson_array.getJSONObject(j);
                NaiBei_input = preNaiBeiJson.getString("InputQuan") == null ? "" : preNaiBeiJson.getString("InputQuan");
                int in = Integer.valueOf(NaiBei_input);
                sunNaiBei = sunNaiBei + in;
            }
        }
        ACCDefect = g_list.getString("ACCDefect") == null ? "" : g_list.getString("ACCDefect");
        StaticParams = g_list.getString("StaticParams") == null ? "" : g_list.getString("StaticParams");
        if (restf == 1) {
            int in = Integer.valueOf(OutputQuan);
            int in1 = Integer.valueOf(DefectQuan);
            int in2 = Integer.valueOf(StepLeft);
            in = in + in1 + in2;
            InputQuan = Integer.toString(in);
            restf = 0;
        }
        Message m = new Message();
        m.what = MEG_INVALIDATE;
        handler.sendMessage(m);
        if (Process.indexOf("外")>-1){
            View rootView = getWindow().getDecorView().getRootView();
            outcheck_getinfo(rootView);
        }
        }
        catch (Exception e) {
            Message m = new Message();
            m.what = MEG_INVALIDATE;
            messstobox.sendMessage(m);

    }

    }

    public void initUserPent(View view) {
        mid_select = (Button) findViewById(R.id.mid_select);
        if (Process.equals("花蓮切割")|| Process.equals("花蓮外檢")|| Process.equals("花蓮加壓")||
                Process.equals("花蓮外檢")|| Process.equals("花蓮全檢")|| Process.equals("全檢1")||
                Process.equals("全檢2")|| Process.equals("外檢1")|| Process.equals("外檢2")) {
            mid_select.setVisibility(VISIBLE);
        } else {
            mid_select.setVisibility(INVISIBLE);
        }
        //spinner.setDropDownWidth(400); //下拉寬度
        //spinner.setDropDownHorizontalOffset(100); //下拉的橫向偏移
        //spinner.setDropDownVerticalOffset(100); //下拉的縱向偏移
        if (startflig == 1)
            accident.setVisibility(INVISIBLE);
            accident_text.setVisibility(INVISIBLE);
        if (Process.equals("底漆")) {
            spinner.setVisibility(INVISIBLE);
            textView2.setText("機台         A001");
        } else {
            if (Process.equals("花蓮切割")|| Process.equals("花蓮外檢")|| Process.equals("花蓮加壓")||
                    Process.equals("花蓮外檢")|| Process.equals("花蓮全檢")|| Process.equals("全檢1")||
                    Process.equals("全檢2")|| Process.equals("外檢1")|| Process.equals("外檢2")) {}else{

                spinner.setVisibility(VISIBLE);
            }
            if (Process.equals("底漆")) {
                textView2.setText("機台         A001");
            } else {
                textView2.setVisibility(VISIBLE);
                textView2.setText("機台");
            }
        }
    }

    public void fillUserPent(JSONObject rtnRestObj) {
        try {
            JSONArray array = new JSONArray(rtnRestObj.getString("Data"));
            Message = rtnRestObj.getString("Message");
            Succ = rtnRestObj.getString("Succ");
            code = rtnRestObj.getString("Code");
            for (int i = 0; i < array.length(); i++) {
                options.clear();
                JSONObject ob = array.getJSONObject(i);
                name = ob.getString("EMPNAME") == null ? "" : ob.getString("EMPNAME");
                deptp = ob.getString("DEPT") == null ? "" : ob.getString("DEPT");
                ifLeader = ob.getString("ifLeader") == null ? "" : ob.getString("ifLeader");
                ifLeader_user = ob.getString("ifLeader") == null ? "" : ob.getString("ifLeader");
                ifAvailable = ob.getString("ifAvailable") == null ? "" : ob.getString("ifAvailable");
                if (Process.equals("花蓮切割") ||Process.equals("花蓮加壓")|| Process.equals("花蓮外檢")|| Process.equals("花蓮全檢")) {
                    if (Process.equals("花蓮電鍍")){
                        options.add("選擇廠別");//花蓮全檢
                    }else{
                        options.add("選擇機台");
                    }
                    if(testmode.equals("true"))options.add("NO.5");//花蓮全檢
                    JSONArray data = ob.getJSONArray("Machins");
                    for (int j = 0; j < data.length(); j++) {
                        String Jasonobject = data.getString(j);//O
                        JSONArray array2 = new JSONArray(Jasonobject);//o
                        for (int k = 0; k < array2.length(); k++) {
                            String Jasonobject2 = array2.getString(k);//O
                            JSONObject ob2 = array2.getJSONObject(k);
                            String mid = ob2.getString("mid");
                            String attr2 = ob2.getString("attr2");
                            String status = ob2.getString("status");
                            //System.out.println("status==>"+mid+"01120"+status);
                            if (mid.equals("null")) {
                                midlist.add("null");
                            } else {
                                //midlist.add(attr2 +"\n"+mid+"status"+status);
                                attr2 = attr2.replaceAll("\\\\", "");
                                attr2 = attr2.replaceAll("n", "  ");
                                midlist.add(attr2 + "  " + mid + "status" + status);
                            }
                        }
                        midlist.add("new");
                    }
                } else {
                    JSONArray array2 = new JSONArray(ob.getString("Machins"));
                    String mmm = ob.getString("Machins") == null ? "" : ob.getString("Machins");
                    options.clear();
                    if (Process.equals("花蓮電鍍")){
                        options.add("選擇廠別");
                    }else{
                        options.add("選擇機台");
                    }
                    for (int j = 0; j < array2.length(); j++) {
                        Map<String, Object> itemBooks =  new HashMap<String, Object>();
                        JSONObject ob2 = array2.getJSONObject(j);
                        String MachineID = ob2.getString("MachineID") == null ? "" : ob2.getString("MachineID");
                        options.add(MachineID);
                        itemBooks.put("MachineID",MachineID);
                        itemBooks.put("InputQuan",MachineID);
                        mList_plating.add(itemBooks);
                    }
                }
                Message m = new Message();
                m.what = MEG_INVALIDATE;
                userMessageHandler.sendMessage(m);
                break;
            }
            list = new ArrayList<Integer>();
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, options);
            adapter.setDropDownViewResource(R.layout.spinner_layout);
            if (Process.equals("花蓮切割") ||
            Process.equals("花蓮加壓")|| Process.equals("花蓮外檢")|| Process.equals("花蓮全檢")) {

            }else{
                spinner.setAdapter(adapter);
            }

            name_textView.setVisibility(VISIBLE);
            Calendar mCal = Calendar.getInstance();
            if (startflig == 1) {
                accident.setVisibility(INVISIBLE);
                accident_text.setVisibility(INVISIBLE);
            }
            String dateformat = "yyyy-MM-dd kk:mm:ss";
            SimpleDateFormat df = new SimpleDateFormat(dateformat);
            df.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
            String today = df.format(mCal.getTime());
            name_textView.invalidate();
            url_Texted.invalidate();
        } catch (Exception e) {
            CharArrayWriter cw = new CharArrayWriter();
            PrintWriter w = new PrintWriter(cw);
            e.printStackTrace(w);
            w.close();
            trace = cw.toString();
            View rootView = getWindow().getDecorView().getRootView();
            send_urlsting(rootView);
        }
    }

    public void getu(View view) {
        initUserPent(view);
        try {
            String encodedUrl2 = "", encodedUrl3 = "";
            encodedUrl2 = URLEncoder.encode(userBar, "UTF-8");
            encodedUrl3 = URLEncoder.encode(Process, "UTF-8");//製程
            //Process="花蓮切割";
            if (Process.indexOf("塗裝")>-1 ||!Process_SWT.equals("")){//測試後移除
                encodedUrl3 = URLEncoder.encode("花蓮塗裝", "UTF-8");//製程//測試後移除
            }else{//測試後移除
                encodedUrl3 = URLEncoder.encode(Process, "UTF-8");//製程//測試後留
            }//測試後移除
            int facroryNo_2=1;//燈入場別
            if(Process.equals("花蓮電鍍")){ //
                facroryNo_2=1;
            }else
            {
                facroryNo_2=facroryNo;
            }
            call_rest restObj = new call_rest();
            JSONObject rtnRestObj;
            SharedPreferences saveip = getPreferences(Activity.MODE_PRIVATE);
            String last_user = saveip.getString("last_user", "");
            //System.out.println("facroryNo===>"+host+"PrdMgn/Login?userBar="+encodedUrl2+"&Dept="+encodedUrl3+"&facroryNo="+facroryNo);
            if (relogin==1&&!last_user.equals("")){
                userBar=last_user;
                encodedUrl2 = URLEncoder.encode(last_user, "UTF-8");
                rtnRestObj = restObj.callRest(host + "PrdMgn/Login?userBar=" +
                        encodedUrl2 + "&Dept=" + encodedUrl3 + "&facroryNo=" + facroryNo_2
                        +"&ifCrash=1&PadIP="+ipString);//+192.168.1.1);
            }else{
                encodedUrl2 = URLEncoder.encode(userBar, "UTF-8");
                rtnRestObj = restObj.callRest(host + "PrdMgn/Login?userBar=" +
                        encodedUrl2 + "&Dept=" + encodedUrl3 + "&facroryNo=" + facroryNo_2);
            }

            SharedPreferences remdname = getPreferences(Activity.MODE_PRIVATE);
            SharedPreferences.Editor edit = remdname.edit();
            edit.putString("last_user", userBar);
            edit.commit();
            relogin=0;
            fillUserPent(rtnRestObj);

        } catch (Exception e) {
            CharArrayWriter cw = new CharArrayWriter();
            PrintWriter w = new PrintWriter(cw);
            e.printStackTrace(w);
            w.close();
            trace = cw.toString();
            View rootView = getWindow().getDecorView().getRootView();
            send_urlsting(rootView);
        }
    }

    public void initGldPent(View view) {
        //spinner = (Spinner) findViewById(R.id.spinner);
        if (machine_but_flag == 0) {
            if (part_finish != 0) {
            } else {
                //spinner.setSelection(0);
            }
        } else {
            //spinner.setVisibility(INVISIBLE);
        }
        gflowBar = flowBar;
        test = (Button) findViewById(R.id.test);
        accident = (Button) findViewById(R.id.accident);
        testnbnnt = (Button) findViewById(R.id.testbnt);
        v_flow_title = (TextView) findViewById(R.id.v_flow_title);
        MachineIM = (TextView) findViewById(R.id.Machine);
        messageview = (TextView) findViewById(R.id.messageview);
        BATCH_NO_text_value = (TextView) findViewById(R.id.BATCH_NO_text_value);
        BATCH_NO_text_title = (TextView) findViewById(R.id.BATCH_NO_text_title);
        mfo_id_text_title = (TextView) findViewById(R.id.mfo_id_text_title);
        BATCH_QTY_text_title = (TextView) findViewById(R.id.BATCH_QTY_text_title);
        DELDATE_text_title = (TextView) findViewById(R.id.DELDATE_text_title);
        RTYPE_text_title = (TextView) findViewById(R.id.RTYPE_text_title);
        TOL_text_title = (TextView) findViewById(R.id.TOL_text_title);
        PPM_text_title = (TextView) findViewById(R.id.PPM_text_title);
        COLOR_NUM_text_title = (TextView) findViewById(R.id.COLOR_NUM_text_title);
        VAL_text_title = (TextView) findViewById(R.id.VAL_text_title);
        VAL_text_value = (TextView) findViewById(R.id.VAL_text_value);
        sumOfNaiBei_text_title = (TextView) findViewById(R.id.sumOfNaiBei_text_title);
        mfo_id_text_value = (TextView) findViewById(R.id.mfo_id_text_value);
        BATCH_QTY_text_value = (TextView) findViewById(R.id.BATCH_QTY_text_value);
        DELDATE_text_value = (TextView) findViewById(R.id.DELDATE_text_value);
        RTYPE_text_value = (TextView) findViewById(R.id.RTYPE_text_value);
        TOL_text_value = (TextView) findViewById(R.id.TOL_text_value);
        PPM_text_value = (TextView) findViewById(R.id.PPM_text_value);
        COLOR_NUM_text_value = (TextView) findViewById(R.id.COLOR_NUM_text_value);
        DEPT_Texted.setText(Process);
        v_flow_title.setVisibility(VISIBLE);
        mfo_id_text_title.setVisibility(VISIBLE);
        sumOfNaiBei_text_title.setVisibility(VISIBLE);
        BATCH_QTY_text_title.setVisibility(VISIBLE);
        DELDATE_text_title.setVisibility(VISIBLE);
        RTYPE_text_title.setVisibility(VISIBLE);
        TOL_text_title.setVisibility(VISIBLE);
        PPM_text_title.setVisibility(VISIBLE);
        COLOR_NUM_text_title.setVisibility(VISIBLE);
        MachineIM.setVisibility(VISIBLE);
        VAL_text_title.setVisibility(VISIBLE);
        VAL_text_value.setVisibility(VISIBLE);
        BATCH_NO_text_value.setVisibility(VISIBLE);
        BATCH_NO_text_title.setVisibility(VISIBLE);
        TV_mfo_id_V = (TextView) findViewById(R.id.Machine);
        name_textView = (TextView) findViewById(R.id.name_textView);
        v_flow_title = (TextView) findViewById(R.id.v_flow_title);
        textView9 = (TextView) findViewById(R.id.textView9);
        textView10 = (TextView) findViewById(R.id.textView10);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView = (TextView) findViewById(R.id.textView);
        textView6 = (TextView) findViewById(R.id.textView9);
        note_title = (TextView) findViewById(R.id.note_title);
        note_value = (EditText) findViewById(R.id.note_value);
        note_title.setVisibility(VISIBLE);
        note_value.setVisibility(VISIBLE);
        send_bnt.setVisibility(VISIBLE);
        }
    public void fillGldPent(JSONObject g_json, View view) {
        try {
            g_json_string = g_json.getString("Data");
            Message = g_json.getString("Message");
            Succ = g_json.getString("Succ");
            code = g_json.getString("Code");
            if ( Message.indexOf("使用中") > -1) {//釋放機台
                Message="";
            }
            if (Message.indexOf("使用中") > -1) {//釋放機台
                View rootView = getWindow().getDecorView().getRootView();
                Message_confinsh(rootView);
            }
            if (Message.indexOf("查無") > -1) {//查無set start
                Message m = new Message();
                m.what = MEG_INVALIDATE;
                setstart.sendMessage(m);
            }
            if (Message.indexOf("錯誤") > -1) {//查無set start
                if (Message.indexOf("**2-31") > -1) {
                    Message="流程單錯誤，流程單未發料 或 已完成！";
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage(Message);
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
                builder.show();
            }
            if (Message.indexOf("尚未完成") > -1 && !(url_stting.indexOf("d=8") > -1)) {//尚未完成 start
                try{
                    g_list = new JSONObject(g_json_string);
                    //get input
                }catch (Exception e) {}
                Message m = new Message();
                m.what = MEG_INVALIDATE;
                agent.sendMessage(m);//call代理完成
            }
            if (g_json_string.indexOf("錯誤") > -1) {
                Message = Message;
            }
            if (g_json_string.length()>=100 ) {
                g_listTE=g_json_string;
            }
            messageview.setText(Message);
            SIGNID = null;            barCodeType = null;            FINISH_TIME = null;            g_list = null;            jsonStr = null;            g_list = null;
            g_list = new JSONObject(g_json_string);
            jsonStr = g_json_string; //for post data
            flowBar = g_list.getString("barCode") == null ? "" : g_list.getString("barCode");
            mfo_id = g_list.getString("mfo_id") == null ? "" : g_list.getString("mfo_id");
            sumOfNaiBei = g_list.getString("sumOfNaiBei") == null ? "" : g_list.getString("sumOfNaiBei");
            preNaiBei = g_list.getString("preNaiBei") == null ? "" : g_list.getString("preNaiBei");
            if (!preNaiBei.equals("null")) {
                sunNaiBei = 0;
                JSONArray preNaiBeiJson_array = new JSONArray(g_list.getString("preNaiBei"));
                for (int j = 0; j < preNaiBeiJson_array.length(); j++) {
                    preNaiBeiJson = preNaiBeiJson_array.getJSONObject(j);
                    NaiBei_input = preNaiBeiJson.getString("InputQuan") == null ? "" : preNaiBeiJson.getString("InputQuan");
                    int in = Integer.valueOf(NaiBei_input);
                    sunNaiBei = sunNaiBei + in;
                }
            }
            BASE_ID = g_list.getString("BASE_ID") == null ? "" : g_list.getString("BASE_ID");
            StepLeft = g_list.getString("StepLeft") == null ? "" : g_list.getString("StepLeft");
            DELDATE = g_list.getString("DELDATE") == null ? "" : g_list.getString("DELDATE");
            RTYPE = g_list.getString("RTYPE") == null ? "" : g_list.getString("RTYPE");
            BATCH_QTY = g_list.getString("BATCH_QTY") == null ? "" : g_list.getString("BATCH_QTY");
            FLOW_STEP = g_list.getString("FLOW_STEP") == null ? "" : g_list.getString("FLOW_STEP");
            FLOW_STEP_CURR=g_list.getString("FLOW_STEP_CURR") == null ? "" : g_list.getString("FLOW_STEP_CURR");//目前step
            try{
                o2mList.clear();
                if(Process.equals("花蓮外檢") || Process.equals("花蓮全檢"))FLOW_STEP_CURR = g_list.getString("FLOW_STEP_CURR") == null ? "" : g_list.getString("FLOW_STEP_CURR");
                // GET check_user20200918
                if(FLOW_STEP_CURR.indexOf("外檢")>-1) {
                    o2mList.clear();
                    Message m = new Message();
                    m.what = MEG_INVALIDATE;
                    cls_user.sendMessage(m);

                    JSONArray array2 = new JSONArray(g_list.getString("colorUser"));//o
                    if (outa==0){
                    String EMPNAME = null;
                    for (int j = 0; j < array2.length(); j++) {
                        JSONObject ob2 = array2.getJSONObject(j);
                        EMPNAME = ob2.getString("EMPNAME");
                        check_userid= ob2.getString("USER_ID");
                        Map<String, Object> itemBooks =  new HashMap<String, Object>();
                        itemBooks.put("check_user",EMPNAME);
                        o2mList.add(itemBooks);
                    }
                    if (array2.length()==1){  //人員只有一個自動選
                        check_user=EMPNAME;
                        check_userid= check_userid;
                        user_select.setText(EMPNAME);
                        View rootView = getWindow().getDecorView().getRootView();
                        outcheck_getinfo(rootView);
                    }
                    }else {
                        String EMPNAME = null;
                        for (int j = 0; j < array2.length(); j++) {
                            JSONObject ob2 = array2.getJSONObject(j);
                            EMPNAME = ob2.getString("EMPNAME");
                            check_userid= ob2.getString("USER_ID");
                            Map<String, Object> itemBooks =  new HashMap<String, Object>();
                            itemBooks.put("check_user",EMPNAME);
                            o2mList.add(itemBooks);
                        }
                        if (array2.length()==1){  //人員只有一個自動選
                            check_user=EMPNAME;
                            check_userid= check_userid;
                            user_select.setText(EMPNAME);
                            View rootView = getWindow().getDecorView().getRootView();
                            outcheck_getinfo(rootView);
                        }
                    }
                }
            }catch (Exception e) {
            }
            if(Process.equals("花蓮貼帶")) {
                tdDoneQty = g_list.getString("tdDoneQty") == null ? "" : g_list.getString("tdDoneQty");
                tdRollQty = g_list.getString("tdRollQty") == null ? "" : g_list.getString("tdRollQty");
                tfLeftQty = g_list.getString("tfLeftQty") == null ? "" : g_list.getString("tfLeftQty");
            }
            WAREHouse_QTY = g_list.getString("WAREHouse_QTY") == null ? "" : g_list.getString("WAREHouse_QTY");

            if(Process.equals("花蓮外檢")) {
                try{////取庫單
                    wqty=Integer.parseInt(BATCH_QTY);
                }catch (Exception e) {
                }
            }
            TOL = g_list.getString("TOL") == null ? "" : g_list.getString("TOL");
            startCommand = g_list.getString("startCommand") == null ? "" : g_list.getString("startCommand");
            Size = g_list.getString("Size") == null ? "" : g_list.getString("Size");
            VAL = g_list.getString("VAL") == null ? "" : g_list.getString("VAL");
            BATSEQ = g_list.getString("BATSEQ") == null ? "" : g_list.getString("BATSEQ");
            BATCH_NO = g_list.getString("BATCH_NO") == null ? "" : g_list.getString("BATCH_NO");
            TestTimes = g_list.getString("TestTimes") == null ? "" : g_list.getString("TestTimes");//加壓用
            order_ppm = g_list.getString("order_ppm") == null ? "" : g_list.getString("order_ppm");
            PPM = g_list.getString("PPM") == null ? "" : g_list.getString("PPM");
            COLOR_NUM = g_list.getString("COLOR_NUM") == null ? "" : g_list.getString("COLOR_NUM");
            CUTTYPE = g_list.getString("CUTTYPE") == null ? "" : g_list.getString("CUTTYPE");
            START_TIME = g_list.getString("Start_TIME") == null ? "" : g_list.getString("Start_TIME");
            FINISH_TIME = g_list.getString("Finish_Time") == null ? "" : g_list.getString("Finish_Time");
            BATCH_NO = g_list.getString("BATCH_NO") == null ? "" : g_list.getString("BATCH_NO");
            BATCH_QTY = g_list.getString("BATCH_QTY") == null ? "" : g_list.getString("BATCH_QTY");
            SUBFLOWID = g_list.getString("SUBFLOWID") == null ? "" : g_list.getString("SUBFLOWID");
            if(Process.equals("花蓮貼帶")) {
                tdDoneQty = g_list.getString("tdDoneQty") == null ? "" : g_list.getString("tdDoneQty");
                tdRollQty = g_list.getString("tdRollQty") == null ? "" : g_list.getString("tdRollQty");
                tfLeftQty = g_list.getString("tfLeftQty") == null ? "" : g_list.getString("tfLeftQty");
            }
            DONE_QTY = g_list.getString("DONE_QTY") == null ? "" : g_list.getString("DONE_QTY");
            USER_ID = g_list.getString("USER_ID") == null ? "" : g_list.getString("USER_ID");
            SIGNID = g_list.getString("SIGNID") == null ? "" : g_list.getString("SIGNID");
            StepLeft = g_list.getString("StepLeft") == null ? "" : g_list.getString("StepLeft");
            notec = g_list.getString("Note") == null ? "" : g_list.getString("Note");
            MachineID_Befor = g_list.getString("MachineID") == null ? "" : g_list.getString("MachineID");
            USER_ID_Befor = g_list.getString("USER_ID") == null ? "" : g_list.getString("USER_ID");
            InputQuan = g_list.getString("InputQuan") == null ? "" : g_list.getString("InputQuan");  //開始
           // System.out.println("InputQuan==>"+InputQuan);
            AccQuan = g_list.getString("AccQuan") == null ? "" : g_list.getString("AccQuan");
            preNaiBei = g_list.getString("preNaiBei") == null ? "" : g_list.getString("preNaiBei");
            ACCDefect = g_list.getString("ACCDefect") == null ? "" : g_list.getString("ACCDefect");
            StaticParams = g_list.getString("StaticParams") == null ? "" : g_list.getString("StaticParams");
            note_title.setVisibility(VISIBLE);
            note_value.setVisibility(VISIBLE);
            send_bnt.setVisibility(VISIBLE);
            //if (barCodeType != null) {
                v_flow_title.invalidate();
                try {
                    float i2 = Float.parseFloat(AccQuan);
                    v_flow_title.setText("本製程已完成" + i2);
                } catch (NullPointerException e) {
                    v_flow_title.setText(AccQuan);
                }
                AccQuan_Texted.setText(StepLeft);
                mfo_id_text_value.invalidate();
                BATCH_NO_text_value.invalidate();
                mfo_id_text_value.setText(" "+mfo_id);
                //開ui\;
                v_flow_title.setVisibility(VISIBLE);
                mfo_id_text_title.setVisibility(VISIBLE);
                sumOfNaiBei_text_title.setVisibility(VISIBLE);
                BATCH_QTY_text_title.setVisibility(VISIBLE);
                DELDATE_text_title.setVisibility(VISIBLE);
                RTYPE_text_title.setVisibility(VISIBLE);
                TOL_text_title.setVisibility(VISIBLE);
                PPM_text_title.setVisibility(VISIBLE);
                COLOR_NUM_text_title.setVisibility(VISIBLE);
                MachineIM.setVisibility(VISIBLE);
                VAL_text_title.setVisibility(VISIBLE);
                VAL_text_value.setVisibility(VISIBLE);
                BATCH_NO_text_value.setVisibility(VISIBLE);
                BATCH_NO_text_title.setVisibility(VISIBLE);
                BATCH_QTY_text_value.invalidate();
                BATCH_QTY_text_value.setText(BATCH_QTY);
                DELDATE_text_value.invalidate();
                DELDATE_text_value.setText(DELDATE);
                RTYPE_text_value.invalidate();
                RTYPE_text_value.setText(RTYPE);
                TOL_text_value.invalidate();
                TOL_text_value.setText(TOL);
                PPM_text_value.invalidate();
                PPM_text_value.setText(PPM);
                COLOR_NUM_text_value.invalidate();
                COLOR_NUM_text_value.setText(COLOR_NUM);
                messageview.invalidate();
                messageview.setText("訊息:取得工令單");
                url_Texted.invalidate();
                url_Texted.setText(url_stting);
                if (Message.indexOf("錯誤") > -1 || Message.indexOf("無法") > -1) {
                    messageview.setTextColor(android.graphics.Color.RED);
                } else {
                    messageview.setTextColor(android.graphics.Color.BLUE);
                }
                if (!USER_ID_Befor.equals(userBar)) {  //不同人直接給開始
                    accident.setVisibility(VISIBLE);
                    accident_text.setVisibility(VISIBLE);
                    accident.setText("開始");          //  6213559680000
                    accident.setVisibility(VISIBLE);
                    test.setVisibility(INVISIBLE);
                    sptest.setVisibility(INVISIBLE);
                    part_finish_bnt.setVisibility(INVISIBLE);
                    startflig = 0; // 機.performClick();.performClick();台狀態    已經開始為 1  尚未開始為0
                }
                String time = START_TIME.replaceAll("\\/Date\\(", "");
                String finshtime = FINISH_TIME.replaceAll("\\/Date\\(", "");
                time = time.replaceAll("\\)/", "");
                finshtime = finshtime.replaceAll("\\)/", "");
                Float starttimef = Float.parseFloat(time);
                Float finshtimef = Float.parseFloat(finshtime);
                System.out.println("finshtimef====="+finshtimef);
                if (starttimef < 0) {
                    if (SIGNID == null || starttimef < 0 || finshtimef > 0 /*||  (SIGNID == null &&!USER_ID.equals(userBar))*/) {// 機台狀態是否開始
                        accident.setVisibility(VISIBLE);
                        accident_text.setVisibility(INVISIBLE);
                        accident.setText("開始");          //  6213559680000
                        accident.setVisibility(VISIBLE);
                        test.setVisibility(INVISIBLE);
                        sptest.setVisibility(INVISIBLE);
                        part_finish_bnt.setVisibility(INVISIBLE);
                        startflig = 0; // 機台狀態    已經開始為 1  尚未開始為0
                    } else {
                        startflig = 1; // 機台狀態    已經開始為 1  尚未開始為0
                        //accident.setVisibility(VISIBLE);
                        test.setVisibility(VISIBLE);
                        sptest.setVisibility(VISIBLE);
                        part_finish_bnt.setVisibility(VISIBLE);
                        accident.setText("刪除");
                        accident.setVisibility(INVISIBLE);
                        accident_text.setVisibility(INVISIBLE);
                        testbutton.setVisibility(VISIBLE);
                        startflig = 1;
                    }
                }
            //}
            if (DONE_QTY != null) {
                onajif = 0;
                if (onajif == 1) {    //if(VAL.equals(maeVAL)){
                    onajif = 0;
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("同阻值 不同型號 不可銜接生產");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            DEPT_Texted = (EditText) findViewById(R.id.DEPT_Texted);
                            MachineParams_Texted = (EditText) findViewById(R.id.MachineParams_Texted);
                            InputQuan_Texted = (EditText) findViewById(R.id.InputQuan_Texted);
                            furyu_Texted = (EditText) findViewById(R.id.furyu_Texted);
                            AccQuan_Texted = (EditText) findViewById(R.id.AccQuan_Texted);
                            final_Texted = (EditText) findViewById(R.id.final_Texted);
                            MachineParams_Texted.setText("");
                            InputQuan_Texted.setText("");
                            final_Texted.setText("");
                            furyu_Texted.setText("");
                            AccQuan_Texted.setText("");
                            TextView bg_t = (TextView) findViewById(R.id.textView17);
                            ImageView bg = (ImageView) findViewById(R.id.imageView);
                            TextView last_t = (TextView) findViewById(R.id.textView16);
                            ImageView last = (ImageView) findViewById(R.id.imageView7);
                            //bg.setVisibility(INVISIBLE);
                            bg_t.setVisibility(INVISIBLE);
                            ImageView[] letters = new ImageView[6];
                            letters[0] = (ImageView) findViewById(R.id.imageView2);
                            letters[0].setVisibility(INVISIBLE);
                            letters[1] = (ImageView) findViewById(R.id.imageView3);
                            letters[1].setVisibility(INVISIBLE);
                            letters[2] = (ImageView) findViewById(R.id.imageView4);
                            letters[2].setVisibility(INVISIBLE);
                            letters[3] = (ImageView) findViewById(R.id.imageView5);
                            letters[3].setVisibility(INVISIBLE);
                            letters[4] = (ImageView) findViewById(R.id.imageView6);
                            letters[4].setVisibility(INVISIBLE);
                            TextView[] VColor = new TextView[6];
                            VColor[0] = (TextView) findViewById(R.id.textView5);
                            VColor[0].setVisibility(INVISIBLE);
                            VColor[1] = (TextView) findViewById(R.id.textView12);
                            VColor[1].setVisibility(INVISIBLE);
                            VColor[2] = (TextView) findViewById(R.id.textView13);
                            VColor[2].setVisibility(INVISIBLE);
                            VColor[3] = (TextView) findViewById(R.id.textView14);
                            VColor[3].setVisibility(INVISIBLE);
                            VColor[4] = (TextView) findViewById(R.id.textView15);
                            VColor[4].setVisibility(INVISIBLE);
                        }
                    });
                    builder.show();
                } else {
                    if (COLOR_NUM.equals("null") || COLOR_NUM.equals("")) {
                        TextView bg_t = (TextView) findViewById(R.id.textView17);
                        bg_t.setVisibility(INVISIBLE);
                        ImageView bg = (ImageView) findViewById(R.id.imageView);//bg.setVisibility(INVISIBLE);
                        TextView last_t = (TextView) findViewById(R.id.textView16);
                        last_t.setVisibility(INVISIBLE);
                        ImageView last = (ImageView) findViewById(R.id.imageView7);
                        //last.setVisibility(INVISIBLE);
                        ImageView[] letters = new ImageView[6];
                        letters[0] = (ImageView) findViewById(R.id.imageView2);
                        letters[0].setVisibility(INVISIBLE);
                        letters[1] = (ImageView) findViewById(R.id.imageView3);
                        letters[1].setVisibility(INVISIBLE);
                        letters[2] = (ImageView) findViewById(R.id.imageView4);
                        letters[2].setVisibility(INVISIBLE);
                        letters[3] = (ImageView) findViewById(R.id.imageView5);
                        letters[3].setVisibility(INVISIBLE);
                        letters[4] = (ImageView) findViewById(R.id.imageView6);
                        letters[4].setVisibility(INVISIBLE);

                        TextView[] VColor = new TextView[6];
                        VColor[0] = (TextView) findViewById(R.id.textView5);
                        VColor[0].setVisibility(INVISIBLE);
                        VColor[1] = (TextView) findViewById(R.id.textView12);
                        VColor[1].setVisibility(INVISIBLE);
                        VColor[2] = (TextView) findViewById(R.id.textView13);
                        VColor[2].setVisibility(INVISIBLE);
                        VColor[3] = (TextView) findViewById(R.id.textView14);
                        VColor[3].setVisibility(INVISIBLE);
                        VColor[4] = (TextView) findViewById(R.id.textView15);
                        VColor[4].setVisibility(INVISIBLE);
                    } else {
                        getcolor(view);
                    }
                }
            }
            Message m = new Message();
            m.what = MEG_INVALIDATE;
            handler.sendMessage(m);
            if (Process.indexOf("外")>-1){
                View rootView = getWindow().getDecorView().getRootView();
                outcheck_getinfo(rootView);
            }

        }catch (Exception e) {
            CharArrayWriter cw = new CharArrayWriter();
            PrintWriter w = new PrintWriter(cw);
            e.printStackTrace(w);
            w.close();
            trace = cw.toString();
            e.printStackTrace();
        }
    }

    private void outcheck_getinfo(View rootView) {
        //System.out.println("==>外");
        url_stting = host + "PrdMgn/outchkInfoByBarcode?flowBar" +
                "="+flowBar+"&currStep="+FLOW_STEP_CURR+"&PRE_USERID="+check_userid
                +"&startCommand="+startCommand;
        call_rest restObj = new call_rest();
        JSONObject rtnRestObj = restObj.callRest(url_stting);
        System.out.println("00"+rtnRestObj.toString());
        try {
            JSONArray array = new JSONArray(rtnRestObj.getString("Data"));
            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                out_InputQuan=jsonObject.getString("InputQuan").equals("null")  ? "" : jsonObject.getString("InputQuan");
                out_OutputQuan=jsonObject.getString("OutputQuan").equals("null")  ? "" : jsonObject.getString("OutputQuan");
                out_DefectQuan=jsonObject.getString("DefectQuan").equals("null")  ? "" : jsonObject.getString("DefectQuan");
                out_StepLeft=jsonObject.getString("StepLeft").equals("null")  ? "" : jsonObject.getString("StepLeft");
                out_AccQuan=jsonObject.getString("AccQuan").equals("null")  ? "" : jsonObject.getString("AccQuan");
                out_ACCDefect=jsonObject.getString("ACCDefect").equals("null")  ? "" : jsonObject.getString("ACCDefect");
                out_PRE_USERID=jsonObject.getString("PRE_USERID").equals("null")  ? "" : jsonObject.getString("PRE_USERID");
                out_NG1=jsonObject.getString("NG1").equals("null")  ? "" : jsonObject.getString("NG1");
                out_NG2=jsonObject.getString("NG2").equals("null")  ? "" : jsonObject.getString("NG2");
                out_NG3=jsonObject.getString("NG3").equals("null")  ? "" : jsonObject.getString("NG3");
                out_SEL_NG=jsonObject.getString("reCheckStatus").equals("null")  ? "" : jsonObject.getString("reCheckStatus");
                out_EMPNAME=jsonObject.getString("EMPNAME").equals("null")  ? "" : jsonObject.getString("EMPNAME");
                System.out.println("ngint==>"+out_SEL_NG+"ngint==>"+out_NG1);
            }
            } catch (Exception e) {

    }
        Message m = new Message();
        m.what = MEG_INVALIDATE;
        handler_outinfo.sendMessage(m);
        //fillGldPent(rtnRestObj, view);
    }

    Handler handler_outinfo = new Handler() {
        public void handleMessage(Message msg) {

            try {
                if (!out_EMPNAME.equals("")){
                    check_user=out_EMPNAME;
                    check_userid=out_PRE_USERID;
                    //user_select.setText(check_user);
                    //color_userbnt.setText(check_user);
                    user_select.setText("底漆人員");
                    color_userbnt.setText("色碼人員");
                    if (!out_SEL_NG.equals("0")){
                        int ngint=Integer.valueOf(out_SEL_NG.toString());
                        NGselecdt.setVisibility(VISIBLE);
                        NGselecdt.setSelection(ngint);/*
                        System.out.println("ngint==>"+out_SEL_NG+"ngint==>"+out_NG1);
                        if (out_SEL_NG.equals("1")){
                            InputQuan_Texted.setText(out_NG1);
                        }else if (out_SEL_NG.equals("2")){
                            InputQuan_Texted.setText(out_NG2);
                        }else if (out_SEL_NG.equals("3")){
                            InputQuan_Texted.setText(out_NG3);
                        }else{
                            NGselecdt.setVisibility(GONE);
                        }
                        InputQuan_Texted.setText(InputQuan);*/
                    }else{
                        NGselecdt.setVisibility(GONE);
                    }
                }

        } catch (Exception e) {

        }
            super.handleMessage(msg);
        }
    };
    public void getg(View view) {   // 取得工令單
        //initGldPent(view);
        try {//掃描
            String encodedUrl = "", encodedUr2 = "", encodedUr3 = "";
            encodedUrl = URLEncoder.encode(flowBar, "UTF-8");
            encodedUr2 = URLEncoder.encode(userBar, "UTF-8");
            encodedUr3 = URLEncoder.encode(Process, "UTF-8");
            if (Process.equals("花蓮全檢")) {
                url_stting = host + "PrdMgn/ScanOperate?command=0&UID=" + encodedUr2
                        + "&flowBar=" + encodedUrl +"&DEPT="+encodedUr3;
            }if (Process.equals("花蓮外檢")) {//外檢 Scan, 改由 Server 判斷為外檢1 還是 外檢2
                url_stting = host + "PrdMgn/ScanOperate?command=13&UID=" +
                        encodedUr2 + "&flowBar=" + encodedUrl +"&DEPT="+encodedUr3;
                if (ifLeader_forinput.equals("1")){//有見證人外檢掃描
                    url_stting = host + "PrdMgn/ScanOperate?command=13A&UID=" +
                        encodedUr2 + "&flowBar=" + encodedUrl +"&DEPT="+encodedUr3;
                    outa=1;
                    //ifLeader_forinput="0";
                }
                /*url_stting = host + "PrdMgn/ScanOperate?command=13A&UID=" +
                        encodedUr2 + "&flowBar=" + encodedUrl +"&DEPT="+encodedUr3;
                outa=1;
                ifLeader_forinput="0";*/
                System.out.println(url_stting);
            }else if(Process.equals("花蓮電鍍")) {
                url_stting = host + "PrdMgn/ScanOperate?command=16&UID=" +
                        encodedUr2 + "&flowBar=" + encodedUrl+"&DEPT="+encodedUr3;;
            }else if(Process.equals("花蓮貼帶")) {
                url_stting = host + "PrdMgn/ScanOperate?command=30&UID=" + encodedUr2 +
                        "&flowBar=" + encodedUrl+"&DEPT="+encodedUr3;;
            }else{
                url_stting = host + "PrdMgn/ScanOperate?command=0&UID=" + encodedUr2 +
                        "&flowBar=" + encodedUrl+"&DEPT="+encodedUr3;;
            }
            call_rest restObj = new call_rest();
            JSONObject rtnRestObj = restObj.callRest(url_stting);
            fillGldPent(rtnRestObj, view);
        } catch (Exception e) {
            e.printStackTrace();
            CharArrayWriter cw = new CharArrayWriter();
            PrintWriter w = new PrintWriter(cw);
            e.printStackTrace(w);
            w.close();
            trace = cw.toString();
            View rootView = getWindow().getDecorView().getRootView();
            send_urlsting(rootView);
        }
    }

    public void spedit(final View view) {
        String[] items;
        Message = null;
        final String[] Message2 = {null};
        Thread thread5 = new Thread(new Runnable() {
            public void run() {
                try {
                    String encodedUrl = "", encodedUr2 = "", encodedUr3 = "";
                    encodedUrl = URLEncoder.encode(flowBar, "UTF-8");
                    encodedUr2 = URLEncoder.encode(userBar, "UTF-8");
                    encodedUr3 = URLEncoder.encode(machineBar, "UTF-8");
                    String Process_test="";
                    if (Process.indexOf("全") > -1 ){//全檢1.2 取檢測值用 花蓮全檢==>Process_test
                        Process_test=URLEncoder.encode("花蓮全檢", "UTF-8");
                    }else{
                        Process_test=URLEncoder.encode(Process, "UTF-8");
                    }
                    url_stting = host + "PrdMgn/GetFlowTest?SIGNID=" + SIGNID + "&UID=" + encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + Process_test + "&MID=" + encodedUr3;
                    System.out.println("==>"+url_stting);
                    URL url = new URL(host + "PrdMgn/GetFlowTest?SIGNID=" + SIGNID + "&UID=" + encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + Process_test + "&MID=" + encodedUr3);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setReadTimeout(10000 /* milliseconds */);
                    conn.setConnectTimeout(15000 /* milliseconds */);
                    conn.setRequestMethod("POST");
                    conn.setDoInput(true);
                    conn.connect();//with or without it I have the same result
                    InputStream in = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder sb = new StringBuilder();
                    String line = "";
                    while ((line = reader.readLine()) != null) {
                        sb.append(line);
                    }
                    String s = sb.toString();
                    JSONObject all = new JSONObject(s);
                    Message2[0] = all.getString("Message");

                    validateBottom = all.getString("validateBottom");
                    validateTop = all.getString("validateTop");
                    sysGenFlag = all.getString("sysGenFlag");
                    ExtraInfo = all.getString("ExtraInfo");
                    ExtraValue = all.getString("ExtraValue");
                    Message = all.getString("TestSet");
                    Message2[0] = "";
                    Message msg = new Message();
                    FinshMessageHandleurl.sendMessage(msg);
                } catch (Exception e) {
                    CharArrayWriter cw = new CharArrayWriter();
                    PrintWriter w = new PrintWriter(cw);
                    e.printStackTrace(w);
                    w.close();
                    trace = cw.toString();
                    e.printStackTrace();
                    View rootView = getWindow().getDecorView().getRootView();
                    //send_urlsting(rootView);
                }
            }
        });
        if (SIGNID.equals("")||SIGNID.equals("null")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("尚未開始此單");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
            builder.show();
        }else{

            thread5.start();
            int i = 0;
            while (true) {
                try {
                    Thread.sleep(300);
                    i++;
                    if (i == 2) {
                        Message = Message2[0];
                        Message m = new Message();
                        m.what = MEG_INVALIDATE;
                        messagehandler.sendMessage(m);
                        break;
                    }
                    if (sysGenFlag != null) {
                        if (Message == null){
                            Message="0,0";
                        }
                        items = Message.split(",");
                        int i2 = 1;
                        final LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                        final View v = inflater.inflate(R.layout.edit, null);
                        final TextView count_tv = (TextView) (v.findViewById(R.id.count));
                        final Button DEL = (Button) (v.findViewById(R.id.button8));
                        final EditText Minimum_tv = (EditText) (v.findViewById(R.id.Minimum));
                        final EditText Maximum_tv = (EditText) (v.findViewById(R.id.Maximum));
                        final TextView ExtraInfo_tv = (TextView) (v.findViewById(R.id.ExtraInfo));
                        final EditText ExtraValue_tv = (EditText) (v.findViewById(R.id.ExtraValue));
                        final RadioGroup Pressurize= (RadioGroup) (v.findViewById(R.id.Pressurize));
                        if (Process.equals("花蓮加壓")) {
                            Pressurize.setVisibility(v.VISIBLE);
                        }else{
                            Pressurize.setVisibility(v.INVISIBLE);
                        }
                        if (Process.equals("花蓮底漆")) {
                            ExtraInfo_tv.setVisibility(VISIBLE);
                            ExtraValue_tv.setVisibility(VISIBLE);
                            ExtraInfo = URLEncoder.encode("鐵帽尺寸", "UTF-8");
                            ExtraInfo_tv.setText("鐵帽尺寸");
                            ExtraValue_tv.setText("");
                        }
                        DEL.setEnabled(false);
                        //允許可以自動變更檢驗上下限
                        if (sysGenFlag.equalsIgnoreCase("true")
                                || ifLeader.equals("1")
                                || (validateTop.equals("") && validateBottom.equals(""))
                                || Process.equals("花蓮全檢")
                                || Process.equals("全檢分類")
                            /*&& Process.equals("花蓮底漆")*/) {
                            Maximum_tv.setText(validateTop);
                            Minimum_tv.setText(validateBottom);
                            Maximum_tv.setFocusable(true);
                            Minimum_tv.setFocusable(true);
                        } else {
                            Maximum_tv.setText(validateTop);
                            Minimum_tv.setText(validateBottom);
                            Maximum_tv.setFocusable(false);
                            Minimum_tv.setFocusable(false);
                        }
                        final EditText[] editText = new EditText[61];
                        editText[1] = (EditText) (v.findViewById(R.id.editText));
                        editText[2] = (EditText) (v.findViewById(R.id.editText2));
                        editText[3] = (EditText) (v.findViewById(R.id.editText3));
                        editText[4] = (EditText) (v.findViewById(R.id.editText4));
                        editText[5] = (EditText) (v.findViewById(R.id.editText5));
                        editText[6] = (EditText) (v.findViewById(R.id.editText6));
                        editText[7] = (EditText) (v.findViewById(R.id.editText7));
                        editText[8] = (EditText) (v.findViewById(R.id.editText8));
                        editText[9] = (EditText) (v.findViewById(R.id.editText9));
                        editText[10] = (EditText) (v.findViewById(R.id.editText10));
                        editText[11] = (EditText) (v.findViewById(R.id.editText11));
                        editText[12] = (EditText) (v.findViewById(R.id.editText12));
                        editText[13] = (EditText) (v.findViewById(R.id.editText13));
                        editText[14] = (EditText) (v.findViewById(R.id.editText14));
                        editText[15] = (EditText) (v.findViewById(R.id.editText15));
                        editText[16] = (EditText) (v.findViewById(R.id.editText16));
                        editText[17] = (EditText) (v.findViewById(R.id.editText17));
                        editText[18] = (EditText) (v.findViewById(R.id.editText18));
                        editText[19] = (EditText) (v.findViewById(R.id.editText19));
                        editText[20] = (EditText) (v.findViewById(R.id.editText20));
                        editText[21] = (EditText) (v.findViewById(R.id.editText21));
                        editText[22] = (EditText) (v.findViewById(R.id.editText22));
                        editText[23] = (EditText) (v.findViewById(R.id.editText23));
                        editText[24] = (EditText) (v.findViewById(R.id.editText24));
                        editText[25] = (EditText) (v.findViewById(R.id.editText25));
                        editText[26] = (EditText) (v.findViewById(R.id.editText26));
                        editText[27] = (EditText) (v.findViewById(R.id.editText27));
                        editText[28] = (EditText) (v.findViewById(R.id.editText28));
                        editText[29] = (EditText) (v.findViewById(R.id.editText29));
                        editText[30] = (EditText) (v.findViewById(R.id.editText30));
                        editText[31] = (EditText) (v.findViewById(R.id.editText31));
                        editText[32] = (EditText) (v.findViewById(R.id.editText32));
                        editText[33] = (EditText) (v.findViewById(R.id.editText33));
                        editText[34] = (EditText) (v.findViewById(R.id.editText34));
                        editText[35] = (EditText) (v.findViewById(R.id.editText35));
                        editText[36] = (EditText) (v.findViewById(R.id.editText36));
                        editText[37] = (EditText) (v.findViewById(R.id.editText37));
                        editText[38] = (EditText) (v.findViewById(R.id.editText38));
                        editText[39] = (EditText) (v.findViewById(R.id.editText39));
                        editText[40] = (EditText) (v.findViewById(R.id.editText40));
                        editText[41] = (EditText) (v.findViewById(R.id.editText41));
                        editText[42] = (EditText) (v.findViewById(R.id.editText42));
                        editText[43] = (EditText) (v.findViewById(R.id.editText43));
                        editText[44] = (EditText) (v.findViewById(R.id.editText44));
                        editText[45] = (EditText) (v.findViewById(R.id.editText45));
                        editText[46] = (EditText) (v.findViewById(R.id.editText46));
                        editText[47] = (EditText) (v.findViewById(R.id.editText47));
                        editText[48] = (EditText) (v.findViewById(R.id.editText48));
                        editText[49] = (EditText) (v.findViewById(R.id.editText49));
                        editText[50] = (EditText) (v.findViewById(R.id.editText50));
                        editText[51] = (EditText) (v.findViewById(R.id.editText51));
                        editText[52] = (EditText) (v.findViewById(R.id.editText52));
                        editText[53] = (EditText) (v.findViewById(R.id.editText53));
                        editText[54] = (EditText) (v.findViewById(R.id.editText54));
                        editText[55] = (EditText) (v.findViewById(R.id.editText55));
                        editText[56] = (EditText) (v.findViewById(R.id.editText56));
                        editText[57] = (EditText) (v.findViewById(R.id.editText57));
                        editText[58] = (EditText) (v.findViewById(R.id.editText58));
                        editText[59] = (EditText) (v.findViewById(R.id.editText59));
                        editText[60] = (EditText) (v.findViewById(R.id.editText60));
                        DEL.setOnClickListener(new Button.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sumit = "[";
                                for (int i = 1; i <= 60; i++) {
                                    if (i != 1 && editText[i].getText().toString().length() != 0)
                                        sumit = sumit + ",";
                                    if (editText[i].getText().toString().length() != 0) {
                                        sumit = sumit + "\"" + editText[i].getText().toString() + "\"";
                                    }
                                }
                                sumit = sumit + "]";
                                validateBottom = Minimum_tv.getText().toString();
                                validateTop = Maximum_tv.getText().toString();
                                sun_fomv(view);
                                for (int i = 1; i <= 60; i++) {
                                    editText[i].setText("");
                                }
                                DEL.setEnabled(false);
                            }
                        });
                        for (int j = 1; j <= 60; j++) {
                            editText[j].addTextChangedListener(new TextWatcher() {
                                @Override
                                public void beforeTextChanged(CharSequence s, int start, int count,
                                                              int after) {
                                    // TODO Auto-generated method stub
                                }
                                @Override
                                public void onTextChanged(CharSequence s, int start, int before,
                                                          int count) {
                                    // TODO Auto-generated method stub
                                }
                                @Override
                                public void afterTextChanged(Editable s) {
                                    Double Minimum = Double.parseDouble(Minimum_tv.getText().toString());
                                    Double Maximum = Double.parseDouble(Maximum_tv.getText().toString());
                                    input = 0;
                                    input_couint = 0;
                                    correct = 0;
                                    try {
                                        if (!ExtraValue_tv.getText().toString().equals("")) {
                                            float ExtraCheck = Float.parseFloat(ExtraValue_tv.getText().toString());
                                            if (Size.equals("1x3.15") && (Float.valueOf(validateBottom) > ExtraCheck || ExtraCheck > Float.valueOf(validateTop)) && Process.equals("底漆")) {
                                                ExtraValue_tv.setTextColor(Color.RED);
                                            } else if (Size.equals("1.7x5.4") && (Float.valueOf(validateBottom) > ExtraCheck || ExtraCheck > Float.valueOf(validateTop)) && Process.equals("底漆")) {
                                                ExtraValue_tv.setTextColor(Color.RED);
                                            } else {
                                                ExtraValue_tv.setTextColor(Color.BLACK);
                                            }
                                            System.out.println("不0=====>>"+Size+Float.valueOf(validateBottom)+Float.valueOf(validateTop));
                                        }
                                    }catch (Exception e) {
                                        System.out.println("不0=====>>不0=====>>不可為0");
                                    }
                                    for (int l = 1; l <= 60; l++) {
                                        if (editText[l].length() == 0) {
                                        } else {
                                            int k = l + 1;
                                            if (editText[l].length() > 4 && editText[k].length() == 0) {
                                                editText[k].requestFocus();
                                            }
                                            input_couint++;
                                            if (editText[l].getText().toString().length() >= 1) {
                                                try {
                                                    if (!editText[l].getText().toString().equals("."))
                                                        input = Double.parseDouble(editText[l].getText().toString());
                                                    if (!editText[l].getText().toString().equals("-"))
                                                        input = Double.parseDouble(editText[l].getText().toString());
                                                    correct++;
                                                    if (input > Maximum || input < Minimum) {
                                                        editText[l].setTextColor(Color.RED);
                                                        correct--;
                                                    } else {
                                                        editText[l].setTextColor(Color.BLACK);
                                                    }
                                                    //System.out.println("0000000"+input+"  |  "+ Maximum+"  |  "+input+"  |  "+Minimum);
                                                    if (input_couint >= 59) { //add new input box
                                                        DEL.setEnabled(true);
                                                    } else {
                                                        DEL.setEnabled(false);
                                                    }
                                                } catch (Exception e) {

                                                    CharArrayWriter cw = new CharArrayWriter();
                                                    PrintWriter w = new PrintWriter(cw);
                                                    e.printStackTrace(w);
                                                    w.close();
                                                    trace = cw.toString();
                                                    e.printStackTrace();
                                                    View rootView = getWindow().getDecorView().getRootView();
                                                    //send_urlsting(rootView);
                                                    //System.out.println("不可為0");
                                                }
                                            } else {
                                            }
                                        }
                                    }
                                    count_tv.setText("輸入正確率" + Math.round(correct) + "/" + Math.round(input_couint));
                                    // TODO Auto-generated method stub
                                }
                            });
                        }
                        int k = 1;
                        for (String item : items) {
                            if (!item.equals("null")) {
                                //editText[k] .setText(item);
                            }
                            k++;
                        }
                        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                        TextView title = new TextView(this);
                        title.setText("輸入數值");
                        title.setGravity(Gravity.CENTER);
                        title.setTextSize(24);
                        dialog.setCustomTitle(title);
                        dialog.setView(v);
                        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        dialog.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                sumit = "[";
                                test_array=  new JSONArray();
                                for (int i = 1; i <= 60; i++) {
                                    if (editText[i].getText().toString().length() != 0 &&
                                            !editText[i].getText().toString().equals("-")) {

                                        //    sumit = sumit + ",";
                                        test_array.put(editText[i].getText().toString());
                                    }
                                    //if (editText[i].getText().toString().length() != 0) {
                                    //     sumit = sumit + "\"" + editText[i].getText().toString() + "\"";
                                    //  test_array.put(editText[i].getText().toString());
                                    // }

                                }
                                sumit = sumit + "]";
                                //correct_rate=correct/input_couint;//正確率
                                validateBottom = Minimum_tv.getText().toString();
                                validateTop = Maximum_tv.getText().toString();
                                RadioGroup Pressurize = (RadioGroup) v.findViewById(R.id.Pressurize);
                                switch (Pressurize.getCheckedRadioButtonId()) {
                                    case R.id.per_ressurize:
                                        testNote = "加壓前";
                                        break;
                                    case R.id.after_ressurize:
                                        testNote = "加壓後";
                                        break;
                                }
                                ExtraValue = ExtraValue_tv.getText().toString();
                                sun_fomv(view);
                                ShowpopMsg(view);//測後後訊息
                            }
                        });
                        AlertDialog dlg = dialog.show();
                        WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
                        params.width = 1200;
                        params.height = 700;
                        dlg.getWindow().setAttributes(params);
                        ShowpopMsg(view);//測試前訊息
                        break;
                    }
                } catch (InterruptedException e) {

                } catch (Exception e) {

                    CharArrayWriter cw = new CharArrayWriter();
                    PrintWriter w = new PrintWriter(cw);
                    e.printStackTrace(w);
                    w.close();
                    trace = cw.toString();
                    e.printStackTrace();
                    View rootView = getWindow().getDecorView().getRootView();
                    send_urlsting(rootView);
                }
            }
        }
    }

    public void sun_fomv(View view) { //送出測試數值
        Message = null;
        sumit = sumit.replaceAll("\\[,", "\\[");
        try {
            String encodedUrl = "", encodedUr2 = "", encodedUr3 = "", encodedUr4 = "", encodedUr5 = "", encodedUr6 = "";
            String Process_test="";
            if (Process.indexOf("全") > -1 ){//全檢1.2 取檢測值用 花蓮全檢==>Process_test
                Process_test="花蓮全檢";
            }else{
                Process_test=Process;
            }
            encodedUrl = URLEncoder.encode(flowBar, "UTF-8");
            encodedUr2 = URLEncoder.encode(userBar, "UTF-8");
            encodedUr3 = URLEncoder.encode(machineBar, "UTF-8");
            JSONObject testobj  =  new JSONObject();
            testobj.put("EMPID", userBar);
            testobj.put("MachineID", machineBar);
            testobj.put("DEPT", Process_test);
            testobj.put("validateTop", validateTop);
            testobj.put("validateBottom", validateBottom);
            testobj.put("SubflowID",  URLEncoder.encode(flowBar, "UTF-8"));
            testobj.put("SIGNID", SIGNID);
            testobj.put("testNote", URLEncoder.encode(testNote, "UTF-8"));
            testobj.put("ExtraValue", ExtraValue);
            testobj.put("ExtraInfo", ExtraInfo);
            testobj.put("TestSet", test_array);
            String url = host + "PrdMgn/SubmitFlowTest?SIGNID=" + SIGNID +
                    "&UID=" + encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + Process_test + "&MID=" + encodedUr3;
            url_stting = host + "PrdMgn/SubmitFlowTest?SIGNID=" + SIGNID +
                    "&UID=" + encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + Process_test + "&MID=" + encodedUr3
                    + "&jsonStr=" + testobj.toString();
            call_rest restObj = new call_rest();
            JSONObject rtnRestObj = restObj.postRest(url, testobj.toString());
            update_ui(rtnRestObj);
            JSONObject all = new JSONObject(rtnRestObj.toString());
            Message = all.getString("Message");
            Succ = all.getString("Succ");
            code = all.getString("Code");
            //計算正確率
            String[] separated = Message.split(",");
            double in = Integer.valueOf(separated[0]);
            double in2 = Integer.valueOf(separated[1]);
            correct_rate = in / in2;
            ShowpopMsg(view);//測後後訊息
            testNote="";
        }catch (Exception e) {
            CharArrayWriter cw = new CharArrayWriter();
            PrintWriter w = new PrintWriter(cw);
            e.printStackTrace(w);
            w.close();
            trace = cw.toString();
            e.printStackTrace();
            View rootView = getWindow().getDecorView().getRootView();
            //send_urlsting(rootView);

        }
    }

    public void check_scan(View view) {
        check_scan = 1;
        IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
        if (camera_str == 1) {
            integrator.setCameraId(1);
        } else {
            integrator.setCameraId(0);
        }
        integrator.initiateScan();
    }

    public void accident1(final View view) throws JSONException {//開始
        if  (Process.indexOf("外檢") > -1 && check_user.equals("")
                && (o2mList != null && !o2mList.isEmpty())
        ){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("未選擇底漆或色碼人員")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            AlertDialog about_dialog = builder.create();
            about_dialog.show();

        }else{

            if((Process.equals("花蓮外檢") || FLOW_STEP_CURR.equals("外檢2")) ||
                    (Process.equals("花蓮外檢") || FLOW_STEP_CURR.equals("外檢1") )) {
                g_list.put("colorUser", check_userid);
            }
            accident(view);
        }
    }

    public void accident(final View view) throws JSONException {//開始
        accident.setVisibility(INVISIBLE);
        Float starttimef , finshtimef ;
        try{
            String time = START_TIME.replaceAll("\\/Date\\(", "");
            String finshtime = FINISH_TIME.replaceAll("\\/Date\\(", "");
            time = time.replaceAll("\\)/", "");
            finshtime = finshtime.replaceAll("\\)/", "");
             starttimef = Float.parseFloat(time);
             finshtimef = Float.parseFloat(finshtime);
        } catch (Exception e) {
            starttimef = Float.parseFloat("1");
            finshtimef = Float.parseFloat("1");
        }
        if(flowBar.equals("")){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("無流程單無法開始");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    accident.setVisibility(VISIBLE);
                }
            });
            builder.show();

        }else  if (( starttimef > 0 && finshtimef < 0) &&!Process.equals("花蓮底漆")) {


            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("前製程尚未完成");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                    accident.setVisibility(VISIBLE);
                    View rootView = getWindow().getDecorView().getRootView();
                    Message_show(rootView);
                }
            });
            builder.show();
        }else if (Process.equals("花蓮塗裝")&&Process_SWT.equals("")){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("塗裝製程需選色碼或底漆");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    accident.setVisibility(VISIBLE);
                }
            });
            builder.show();
        }else{
            if(!coworker_bar.equals("")){
                g_list.put("coworker", coworker_bar);
            }
/*
            if ((FLOW_STEP_CURR.indexOf("外檢2") > -1 &&
                    FLOW_STEP.indexOf("外檢2") > -1 &&  NGOptions.equals("0")
            )||(FLOW_STEP_CURR.indexOf("花蓮外檢") > -1 &&
                    FLOW_STEP.indexOf("花蓮外檢") > -1 &&  NGOptions.equals("0")
            )
            ){
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("請選擇NG");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        accident.setVisibility(VISIBLE);
                    }
                });
                builder.show();
            }else*/
            if (!Process.equals("花蓮電鍍")) {
                //正常開始
                dy_msgdy_msg = "";
                Message = "";
                conf_flag = null;
                userBar = userBar.replaceAll("\\*", "");
                final Button info_bnt = (Button) findViewById(R.id.info_bnt);
                if (Process.equals("底漆") || Process.equals("色碼")) {//底漆固定機台
                    machineBar = "A001";
                }
                if (startflig != 0) {     // 機台狀態    已經開始為 1  尚未開始為0
                    test.setVisibility(INVISIBLE);
                    accident.setText("開始");
                    accident_text.setVisibility(VISIBLE);
                    sptest.setVisibility(INVISIBLE);
                    part_finish_bnt.setVisibility(INVISIBLE);
                    startflig = 0;
                    Calendar mCal1 = Calendar.getInstance();
                    String dateformat1 = "yyyy-MM-dd kk:mm:ss";
                    SimpleDateFormat df1 = new SimpleDateFormat(dateformat1);
                    df1.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
                    starttime = df1.format(mCal1.getTime());
                    //執行刪除
                    Thread thread = new Thread(new Runnable() {  //DO 刪除
                        public void run() {
                            try {
                                String encodedUrl = "", encodedUr2 = "", encodedUr3 = "", encodedUr4 = "";
                                userBar = userBar.replaceAll("\\*", "");
                                encodedUrl = URLEncoder.encode(flowBar, "UTF-8");
                                encodedUr2 = URLEncoder.encode(userBar, "UTF-8");
                                encodedUr3 = URLEncoder.encode(machineBar, "UTF-8");
                                encodedUr4 = URLEncoder.encode(Process, "UTF-8");
                                g_list.put("SIGNID", SIGNID);
                                String u = host + "PrdMgn/ScanOperate?command=5&UID=" + encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3;
                                String g_list2 = g_list.toString();
                                url_stting = host + "PrdMgn/ScanOperate?command=5&UID=" + encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3 + "&jsonStr=" + g_list2;
                                HttpPost post = new HttpPost(u);
                                HttpResponse response;
                                List params = new ArrayList();
                                params.add(new BasicNameValuePair("jsonStr", g_list2));
                                UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params, HTTP.UTF_8);
                                post.setEntity(ent);
                                response = new DefaultHttpClient().execute(post);
                                String data = null;
                                if (response.getStatusLine().getStatusCode() == 200) {
                                    data = EntityUtils.toString(response.getEntity(), "UTF-8");
                                }
                                JSONObject all = new JSONObject(data.toString());
                                g_json_string = all.getString("Data");
                                Message = all.getString("Message");
                                Succ = all.getString("Succ");
                                code = all.getString("Code");
                                update_ui(all);
                            } catch (Exception e) {
                                CharArrayWriter cw = new CharArrayWriter();
                                PrintWriter w = new PrintWriter(cw);
                                e.printStackTrace(w);
                                w.close();
                                trace = cw.toString();
                                e.printStackTrace();
                                View rootView = getWindow().getDecorView().getRootView();
                                send_urlsting(rootView);
                            }
                        }
                    });
                    try {
                        Thread.sleep(1000); //1000為1秒
                    } catch (InterruptedException e) {
                        CharArrayWriter cw = new CharArrayWriter();
                        PrintWriter w = new PrintWriter(cw);
                        e.printStackTrace(w);
                        w.close();
                        trace = cw.toString();
                        e.printStackTrace();
                        View rootView = getWindow().getDecorView().getRootView();
                        send_urlsting(rootView);
                    }
                    sptest.setVisibility(VISIBLE);
                    if (Process.equals("花蓮切割") ) {
                        part_finish_bnt.setVisibility(VISIBLE);
                    } else {
                        part_finish_bnt.setVisibility(INVISIBLE);
                    }
                    //見證人
                    //if(ifLeader.equals("0")){//關閉
                    if (ifLeader.equals("1")) {//開啟
                        thread.start();//執行刪除
                        Toast toast = Toast.makeText(MainActivity.this, "刪除", Toast.LENGTH_LONG);
                        toast.show();
                        Message m = new Message();
                        m.what = MEG_INVALIDATE;
                        delpent.sendMessage(m);
                        ifLeader = "0";
                    } else {
                        ifLeader = "0";
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("掃描主管見證人後才可以刪除");
                        builder.setCancelable(false);
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                testbutton.setVisibility(VISIBLE);
                                //accident.setVisibility(INVISIBLE);
                                accident.setText("刪除");
                                test.setVisibility(VISIBLE);
                                startflig = 1;
                            }
                        });
                        builder.show();
                    }
                }/* else if(Process.indexOf("外檢")>-1 && check_user.equals("")){

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("請先選擇該張單製作底漆或色碼的人員");
            builder.setCancelable(false);
            builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
            builder.show();
        }*/ else {
                    Process_CUT=Process;
                    //執行開始
                    System.out.print("20201001===>>>"+StepLeft+FLOW_STEP+Process);

                    LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                    final View v = inflater.inflate(R.layout.accident, null);   //   get viwe layout\
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    TextView title = new TextView(this);
                    title.setText("開始");
                    title.setGravity(Gravity.CENTER);
                    title.setTextSize(24);
                    dialog.setCustomTitle(title);
                    dialog.setView(v);
                    final TextView select_msg= (TextView) v.findViewById(R.id.select_msg);//select_msg
                    final RadioButton radio_new = (RadioButton) v.findViewById(R.id.radio_new);//新開始
                    final RadioButton radio_continue = (RadioButton) v.findViewById(R.id.radio_continue);//接續
                    final RadioButton D2 = (RadioButton) v.findViewById(R.id.D2);//底漆2
                    final RadioButton radioButton4 = (RadioButton) v.findViewById(R.id.radioButton4);//全檢1
                    final RadioButton radio_chang = (RadioButton) v.findViewById(R.id.radio_chang);//換機台
                    final RadioButton radioButton3 = (RadioButton) v.findViewById(R.id.radioButton3);//全檢2
                    final RadioButton OCHK = (RadioButton) v.findViewById(R.id.OCHK);//外檢2
                    final RadioButton reset = (RadioButton) v.findViewById(R.id.reset);//重驗
                    final RadioButton radio_changcolor = (RadioButton) v.findViewById(R.id.radio_changcolor);//換
                    final RadioButton cut = (RadioButton) v.findViewById(R.id.cut);//換漆
                    final RadioButton Remarks = (RadioButton) v.findViewById(R.id.Remarks);//全檢分類
                    final RadioButton rest1 = (RadioButton) v.findViewById(R.id.reset1);//良品重測
                    final RadioButton reochkb = (RadioButton) v.findViewById(R.id.reochkb);//外檢重驗底漆
                    final RadioButton rest2 = (RadioButton) v.findViewById(R.id.reset2);//不良品重測
                    final RadioButton cut_befor = (RadioButton) v.findViewById(R.id.cut_befor);//切割前
                    final RadioButton cut_after = (RadioButton) v.findViewById(R.id.cut_after);//切割後
                    final RadioButton color_start = (RadioButton) v.findViewById(R.id.color_start);//色碼
                    Spinner spinner_ng_in= (Spinner) v.findViewById(R.id.spinner_ng_in);//NG下拉
                    final RadioButton rest = (RadioButton) v.findViewById(R.id.reset);
                    final RadioButton reset1 = (RadioButton) v.findViewById(R.id.reset1);
                    System.out.print("20201001===>>>"+StepLeft+FLOW_STEP+Process);
                    if  ((Process.indexOf("外檢") > -1 &&  FLOW_STEP.equals(FLOW_STEP_CURR))){
                        String[] ngarraySpinner = new String[] {
                            "非重複性檢測","NG1", "NG2", "NG3", "NG1+2", "NG1+3", "NG2+3", "NG1+2+3"
                    };
                    final ArrayAdapter<String> adapterNG = new ArrayAdapter<String>(this,
                            R.layout.simple_list_item_1, ngarraySpinner);
                    adapterNG.setDropDownViewResource(R.layout.spinner_layout);
                    spinner_ng_in.setAdapter(adapterNG);
                    spinner_ng_in.setSelection( Integer.valueOf(NGOptions));
                    spinner_ng_in.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                            // NGOptions -- 外檢2 使用
                            //        //1:NG1, 2:NG2, 3:NG3, 4:NG1+2, 5:NG1+3, 6:NG1+3, 7:NG1+2+3, 8：從前製程數量重做
                            NGselecdt.setSelection( Integer.valueOf(NGOptions));
                            NGOptions= String.valueOf(position); // it will return your String so you can safely cast to it
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parentView) {
                            // your code here
                        }
                    });
                        spinner_ng_in.setVisibility(VISIBLE);//NG下拉
                    }else{
                        spinner_ng_in.setVisibility(GONE);//NG下拉
                    }
                    //Button
                    final Button radio_newb=(Button) v.findViewById(R.id.radio_newb);
                    final Button resetb=(Button) v.findViewById(R.id.resetb);
                    final Button radio_continueb=(Button) v.findViewById(R.id.radio_continueb);
                    final Button radioButton3b=(Button) v.findViewById(R.id.radioButton3b);
                    final Button radioButton4b=(Button) v.findViewById(R.id.radioButton4b);
                    final Button D2b=(Button) v.findViewById(R.id.D2b);
                    final Button Remarksb=(Button) v.findViewById(R.id.Remarksb);
                    final Button radio_changb=(Button) v.findViewById(R.id.radio_changb);
                    final Button radio_changcolorb=(Button) v.findViewById(R.id.radio_changcolorb);
                    final Button rest2b=(Button) v.findViewById(R.id.reset2b);
                    final Button rest1b=(Button) v.findViewById(R.id.reset1b);
                    final Button cut_beforb=(Button) v.findViewById(R.id.cut_beforb);
                    final Button cut_afterb=(Button) v.findViewById(R.id.cut_afterb);
                    final Button color_startb=(Button) v.findViewById(R.id.color_startb);
                    final Button cutb=(Button) v.findViewById(R.id.cutb);
                    final Button OCHKb=(Button) v.findViewById(R.id.OCHb);
                    final Button ochkbb=(Button) v.findViewById(R.id.ochkbb);
                    final Button reochkbb=(Button) v.findViewById(R.id.reochkbb);
                    //////////
                    radioButton3b.setVisibility(GONE);//全檢2
                    radio_newb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            radio_new.setChecked(true);
                            select_msg.setText(radio_new.getText());
                        }
                    });
                    reochkbb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            reochkb.setChecked(true);
                            select_msg.setText(reochkb.getText());
                        }
                    });
                    //////////
                    resetb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            reset.setChecked(true);
                            select_msg.setText(reset.getText());
                        }
                    });
                    //////////
                    radio_continueb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            radio_continue.setChecked(true);
                            select_msg.setText(radio_continue.getText());
                        }
                    });
                    radioButton3b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            radioButton3.setChecked(true);
                            select_msg.setText(radioButton3.getText());
                        }
                    });
                    radioButton4b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            radioButton4.setChecked(true);
                            select_msg.setText(radioButton4.getText());
                        }
                    });
                    D2b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            D2.setChecked(true);
                            select_msg.setText(D2.getText());
                        }
                    });
                    Remarksb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Remarks.setChecked(true);
                            select_msg.setText(Remarks.getText());
                        }
                    });
                    radio_changb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            radio_chang.setChecked(true);
                            select_msg.setText(radio_chang.getText());
                        }
                    });
                    radio_changcolorb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            radio_changcolor.setChecked(true);
                            select_msg.setText(radio_changcolor.getText());
                        }
                    });
                    resetb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            rest.setChecked(true);
                            select_msg.setText(rest.getText());
                        }
                    });
                    rest2b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            rest2.setChecked(true);
                            select_msg.setText(rest2.getText());
                        }
                    });
                    rest1b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            rest1.setChecked(true);
                            select_msg.setText(rest1.getText());
                        }
                    });
                    rest1b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            rest1.setChecked(true);
                            select_msg.setText(rest1.getText());
                        }
                    });
                    cut_beforb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            cut_befor.setChecked(true);
                            select_msg.setText(cut_befor.getText());
                        }
                    });
                    cut_afterb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            cut_after.setChecked(true);
                            select_msg.setText(cut_after.getText());
                        }
                    });
                    color_startb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            color_start.setChecked(true);
                            select_msg.setText(color_start.getText());
                        }
                    });
                    cutb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            cut.setChecked(true);
                            select_msg.setText(cut.getText());
                        }
                    });
                    OCHKb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            OCHK.setChecked(true);
                            select_msg.setText("外檢驗色碼");
                        }
                    });
                    if (FLOW_STEP_CURR.indexOf("外檢2")>-1){
                        radio_new.setVisibility(GONE);//新開始 彥底漆
                        radio_newb.setVisibility(GONE);//新開始 彥底漆
                    }
                    if (Process.indexOf("底")>-1&&FLOW_STEP.indexOf("底")>-1){
                        radio_new.setChecked(true);
                    }else{
                        radio_new.setChecked(true);
                    }
                    if (Process.indexOf("底")>-1){
                        D2.setText("底漆2");
                        D2.setVisibility(VISIBLE);//新開始
                        D2b.setVisibility(VISIBLE);//新開始
                        radio_new.setText("開始新製程");//新開始 彥底漆
                        radio_new.setVisibility(VISIBLE);//新開始 彥底漆
                        radio_newb.setVisibility(VISIBLE);//新開始 彥底漆
                    }else {
                        D2.setVisibility(GONE);//新開始
                        radio_new.setVisibility(VISIBLE);//新開始 彥底漆
                        D2b.setVisibility(GONE);//新開始
                        radio_newb.setVisibility(VISIBLE);//新開始 彥底漆
                    }

                    if(Process.indexOf("全")>-1 &&FLOW_STEP.equals("全檢2")&&ACCDefect.equals("0")){//2次全檢2
                        rest1.setVisibility(VISIBLE);//全檢2檢重測 良
                        rest2.setVisibility(VISIBLE);//全檢2檢重測 不良
                        rest1b.setVisibility(VISIBLE);//全檢2檢重測 良
                        rest2b.setVisibility(VISIBLE);//全檢2檢重測 不良
                        rest2.setChecked(true);
                    }else{
                        rest1.setVisibility(GONE);//全檢2檢重測 良
                        rest2.setVisibility(GONE);//全檢2檢重測 不良
                        rest1b.setVisibility(GONE);//全檢2檢重測 良
                        rest2b.setVisibility(GONE);//全檢2檢重測 不良
                    }
                    radioButton4.setVisibility(GONE);//全檢1
                    Remarks.setVisibility(GONE);//全檢備註
                    radioButton3.setVisibility(GONE);//全檢2
                    radioButton4b.setVisibility(GONE);//全檢1
                    Remarksb.setVisibility(GONE);//全檢備註
                    radioButton3b.setVisibility(GONE);//全檢2
                    //控制開始顯示哪些選項
                    if (Painting_flag==1)
                    {
                        radio_new.setText("開始新製程");
                        cut_befor.setVisibility(VISIBLE);//切後底漆
                        cut_after.setVisibility(VISIBLE);//切前底漆
                        color_start.setVisibility(GONE);//底漆色碼
                        cut_beforb.setVisibility(VISIBLE);//切後底漆
                        cut_afterb.setVisibility(VISIBLE);//切前底漆
                        color_startb.setVisibility(GONE);//底漆色碼
                        if (Process.indexOf("色")>-1){
                            radio_new.setText("開始新製程");
                        }
                    }else{
                        radio_new.setText("開始新製程");
                        cut_befor.setVisibility(GONE);
                        cut_after.setVisibility(GONE);
                        color_start.setVisibility(GONE);
                        cut_beforb.setVisibility(GONE);
                        cut_afterb.setVisibility(GONE);
                        color_startb.setVisibility(GONE);
                    }
                    if(Process.indexOf("底漆")>-1){
                        radio_new.setText("開始新製程");
                    }

                    if(Process.indexOf("外檢")>-1){
                        radio_new.setVisibility(GONE);
                    }
                    if (!Process.equals(FLOW_STEP) && !FLOW_STEP.equals("外檢2") && ((Process.indexOf("外") >1)))
                     {
                         radio_continue.setVisibility(GONE);//製程不同無接續可選
                         radio_continueb.setVisibility(GONE);//製程不同無接續可選
                    }
                    if (Process.equals(FLOW_STEP) && !AccQuan.equals("0")&& !Process.equals("花蓮底漆")
                    ) {
                        radio_new.setVisibility(GONE);//製程同無新開始可選  底漆2會擋
                        radio_newb.setVisibility(GONE);//製程同無新開始可選  底漆2會擋
                    }
                    if (Process.indexOf("全") > -1&& !(FLOW_STEP.indexOf("全檢1") > -1)) {
                        System.out.print("20201001===>>>７"+StepLeft+FLOW_STEP+Process);
                        radio_new.setVisibility(GONE);//新開始
                        radioButton4.setVisibility(VISIBLE);//全檢1
                        cut_befor.setVisibility(GONE);//切後底漆
                        cut_after.setVisibility(GONE);//切前底漆
                        Remarks.setVisibility(VISIBLE);//全檢分類
                        radioButton3.setVisibility(GONE);//全檢2
                        radio_continue.setVisibility(GONE);//接續
                        radio_chang.setVisibility(GONE);//換機台
                        radio_newb.setVisibility(GONE);//新開始
                        radioButton4b.setVisibility(VISIBLE);//全檢1
                        cut_beforb.setVisibility(GONE);//切後底漆
                        cut_afterb.setVisibility(GONE);//切前底漆
                        Remarksb.setVisibility(VISIBLE);//全檢分類
                        radioButton3b.setVisibility(GONE);//全檢2
                        radio_continueb.setVisibility(GONE);//接續
                        radio_changb.setVisibility(GONE);//換機台
                    }else if (Process.indexOf("全") > -1&&((MachineID_Befor.indexOf("31") > -1||MachineID_Befor.indexOf("32") > -1||MachineID_Befor.indexOf("33") > -1))) {
                        System.out.print("20201001===>>>６"+StepLeft+FLOW_STEP+Process);
                        radio_new.setVisibility(GONE);//新開始
                        radioButton4.setVisibility(GONE);//全檢1
                        radioButton3.setVisibility(VISIBLE);//全檢2
                        Remarks.setVisibility(GONE);//全檢分類
                        cut_befor.setVisibility(GONE);//切後底漆
                        cut_after.setVisibility(GONE);//切前底漆
                        radio_continue.setVisibility(GONE);//接續
                        radio_newb.setVisibility(GONE);//新開始
                        radioButton4b.setVisibility(GONE);//全檢1
                        radioButton3b.setVisibility(VISIBLE);//全檢2
                        Remarksb.setVisibility(GONE);//全檢分類
                        cut_beforb.setVisibility(GONE);//切後底漆
                        cut_afterb.setVisibility(GONE);//切前底漆
                        radio_continueb.setVisibility(GONE);//接續
                    }
                    if (!StepLeft.equals("0")&& (Process.indexOf("全檢") > -1||Process.indexOf("全檢２") > -1)) {
                        System.out.print("20201001===>>>５"+StepLeft+FLOW_STEP+Process);
                        radio_new.setVisibility(GONE);//新開始
                        radioButton4.setVisibility(GONE);//全檢1
                        radio_chang.setVisibility(VISIBLE);//換機台
                        radio_continue.setVisibility(VISIBLE);//接續
                        rest2.setVisibility(VISIBLE);//良品重測
                        rest1.setVisibility(VISIBLE);//不良品重測
                        radioButton3.setVisibility(GONE);//全檢2
                        Remarks.setVisibility(GONE);//全檢分類
                        radio_continue.setVisibility(GONE);//接續
                    }
                    if (StepLeft.equals("0")&&(FLOW_STEP.indexOf("全檢1") > -1)&&Process.indexOf("全") > -1) {
                        radio_new.setVisibility(GONE);//新開始
                        radioButton4.setVisibility(GONE);//全檢1
                        radio_chang.setVisibility(VISIBLE);//換機台
                        cut_befor.setVisibility(GONE);//切後底漆
                        cut_after.setVisibility(GONE);//切前底漆
                        radio_continue.setVisibility(GONE);//接續
                        radioButton3.setVisibility(VISIBLE);//全檢2
                        Remarks.setVisibility(GONE);//全檢分類
                        radio_continue.setVisibility(GONE);//接續
                        rest2.setVisibility(GONE);//重測
                        rest.setVisibility(VISIBLE);//重測

                        radio_newb.setVisibility(GONE);//新開始
                        radioButton4b.setVisibility(GONE);//全檢1
                        radio_changb.setVisibility(VISIBLE);//換機台
                        cut_beforb.setVisibility(GONE);//切後底漆
                        cut_afterb.setVisibility(GONE);//切前底漆
                        radio_continueb.setVisibility(GONE);//接續
                        radioButton3b.setVisibility(VISIBLE);//全檢2
                        Remarksb.setVisibility(GONE);//全檢分類
                        radio_continueb.setVisibility(GONE);//接續
                        rest2b.setVisibility(GONE);//重測
                        resetb.setVisibility(VISIBLE);//重測
                    }
                    if (FLOW_STEP_CURR.indexOf("全檢2") > -1) {
                        radioButton3.setChecked(true);
                    }else if (FLOW_STEP_CURR.indexOf("全檢1") > -1) {
                        radioButton4.setChecked(true);
                    }
                    if (Process.indexOf("外") > -1) {
                        reset.setVisibility(VISIBLE);
                        resetb.setVisibility(VISIBLE);
                    } else {
                        reset.setVisibility(GONE);
                        resetb.setVisibility(GONE);
                    }

                    if ((machineBar.equals("31") || machineBar.equals("32") || machineBar.equals("33"))
                            &&FLOW_STEP.indexOf("全檢2") > -1
                    ) {
                        reset1.setVisibility(VISIBLE);
                        rest2.setVisibility(VISIBLE);
                        rest1b.setVisibility(VISIBLE);
                        rest2b.setVisibility(VISIBLE);
                        radioButton4b.setVisibility(VISIBLE);
                    }
                    if (machineBar.equals("選擇機台") && Process.equals("花蓮切割")) {
                        cut.setVisibility(VISIBLE);
                        radio_new.setVisibility(GONE);
                        radio_continue.setVisibility(GONE);
                        radio_chang.setVisibility(GONE);
                        reset.setVisibility(GONE);
                        cutb.setVisibility(VISIBLE);
                        radio_newb.setVisibility(GONE);
                        radio_continueb.setVisibility(GONE);
                        radio_changb.setVisibility(GONE);
                        resetb.setVisibility(GONE);
                    }
                    if (Process.indexOf("底") > -1) {
                        radio_changcolor.setVisibility(VISIBLE);
                        radio_changcolorb.setVisibility(VISIBLE);
                    } else {
                        radio_changcolor.setVisibility(GONE);
                        radio_changcolorb.setVisibility(GONE);
                    }

                    reochkbb.setVisibility(GONE);//外檢重驗底漆
                    if (FLOW_STEP.equals("外檢1"))
                    {
                        radio_continue.setVisibility(VISIBLE);//外檢1續可選
                        radio_continueb.setVisibility(VISIBLE);//外檢1續可選
                    }
                    if (FLOW_STEP_CURR.indexOf("外檢1") > -1&&Process.indexOf("外") > -1) {
                        radio_new.setVisibility(VISIBLE);//外新=驗底漆
                        OCHK.setVisibility(INVISIBLE);//外交接=驗色碼
                        radio_newb.setVisibility(VISIBLE);//外新=驗底漆
                        OCHKb.setVisibility(INVISIBLE);//外交接=驗色碼
                        radio_new.setText("外檢驗底漆");
                        OCHKb.setText("外檢驗底漆");
                    }else if (FLOW_STEP_CURR.indexOf("外檢2") > -1&&Process.indexOf("外") > -1) {
                        radio_new.setVisibility(INVISIBLE);//外新=驗底漆
                        OCHK.setVisibility(VISIBLE);//外交接=驗色碼
                        radio_newb.setVisibility(INVISIBLE);//外新=驗底漆
                        OCHKb.setVisibility(VISIBLE);//外交接=驗色碼
                        ochkbb.setVisibility(GONE);
                        radio_newb.setText("外檢驗底漆");
                        OCHKb.setText("外檢驗色碼");
                        reochkbb.setVisibility(VISIBLE);//外檢重驗底漆
                   }


                    if(FLOW_STEP_CURR.indexOf("外檢")>-1&&g_list.getString("colorUser").equals("")) {
                        radio_new.setVisibility(VISIBLE);//外新=驗底漆
                        OCHK.setVisibility(VISIBLE);//外交接=驗色碼
                        radio_newb.setVisibility(VISIBLE);//外新=驗底漆
                        OCHKb.setVisibility(VISIBLE);//外交接=驗色碼
                        radio_new.setText("外檢驗底漆");
                        OCHK.setText("外檢驗色碼");
                    }
                    if (FLOW_STEP_CURR.indexOf("外檢1") > -1&&Process.indexOf("外") > -1) {
                        radio_new.setText("外檢驗底漆");
                        OCHK.setText("外檢驗底漆");
                    }else if (FLOW_STEP_CURR.indexOf("外檢2") > -1&&Process.indexOf("外") > -1) {
                        radio_new.setText("外檢驗色碼");
                        OCHK.setText("外檢驗色碼");
                        OCHKb.setVisibility(INVISIBLE);//外交接=驗色碼
                    }
                    rest.setVisibility(INVISIBLE);
///////////////////////////////
                    if (!StepLeft.equals("0")&&((FLOW_STEP.indexOf("全檢1") > -1) || (FLOW_STEP.indexOf("全檢2") > -1)) &&Process.indexOf("全") > -1) {
                        System.out.print("20201001===>>>２"+StepLeft+FLOW_STEP+Process);
                        radio_new.setVisibility(GONE);//新開始
                        radioButton4.setVisibility(GONE);//全檢1
                        radio_chang.setVisibility(VISIBLE);//換機台
                        cut_befor.setVisibility(GONE);//切後底漆
                        cut_after.setVisibility(GONE);//切前底漆
                        radio_continue.setVisibility(VISIBLE);//接續
                        radioButton3.setVisibility(GONE);//全檢2
                        rest2.setVisibility(GONE);//不良品重測
                        rest.setVisibility(GONE);//重測
                        reset1.setVisibility(GONE);//良品重測
                        Remarks.setVisibility(GONE);//全檢分類
                    }
                    if (StepLeft.equals("0")&&((FLOW_STEP.indexOf("全檢2") > -1)) &&Process.indexOf("全") > -1) {
                        radio_new.setVisibility(GONE);//新開始
                        radioButton4.setVisibility(GONE);//全檢1
                        radio_chang.setVisibility(GONE);//換機台
                        cut_befor.setVisibility(GONE);//切後底漆
                        cut_after.setVisibility(GONE);//切前底漆
                        radio_continue.setVisibility(GONE);//接續
                        radioButton3.setVisibility(GONE);//全檢2
                        rest2.setVisibility(VISIBLE);//不良品重測
                        rest.setVisibility(GONE);//重測
                        reset1.setVisibility(VISIBLE);//良品重測
                        Remarks.setVisibility(GONE);//全檢分類
                    }
                    if (StepLeft.equals("0")&&FLOW_STEP.equals("全檢2") ) {
                        Remarks.setVisibility(GONE);//全檢分類
                        radioButton3.setVisibility(GONE);//全檢2
                        radioButton4.setVisibility(GONE);//全檢1
                        rest2.setVisibility(VISIBLE);//不良品重測
                        rest1.setVisibility(VISIBLE);//良品重測
                        rest.setVisibility(GONE);//重測
                    }
                    if ((machineBar.equals("No.31") || machineBar.equals("No.32") || machineBar.equals("No.33"))) {
                        System.out.print("20201001===>>>No.31４"+StepLeft+FLOW_STEP+Process);
                        Remarks.setVisibility(VISIBLE);//全檢分類
                        radioButton3.setVisibility(VISIBLE);//全檢2
                        radioButton4.setVisibility(GONE);//全檢1
                        rest2.setVisibility(GONE);//不良品重測
                        rest1.setVisibility(GONE);//良品重測
                        rest.setVisibility(GONE);//重測
                        if (FLOW_STEP.indexOf("全檢") > -1){
                            Remarks.setVisibility(GONE);//全檢分類
                            radioButton3.setVisibility(GONE);//全檢2
                            if (StepLeft.equals("0")){
                                rest2.setVisibility(VISIBLE);//不良品重測
                                rest1.setVisibility(VISIBLE);//良品重測
                                radio_chang.setVisibility(GONE);//換機
                            }else if (!StepLeft.equals("0")){
                                radio_continue.setVisibility(VISIBLE);//接班
                                radio_chang.setVisibility(VISIBLE);//換機
                            }
                        }else{
                            radioButton3.setVisibility(VISIBLE);//全檢2
                        }
                    }
                    if (StepLeft.equals("0")&&FLOW_STEP.equals("全檢2")&&
                            (machineBar.equals("No.31") || machineBar.equals("No.32") || machineBar.equals("No.33"))) {
                        System.out.print("20201001===>>>6４"+StepLeft+FLOW_STEP+Process);
                        Remarks.setVisibility(GONE);//全檢分類
                        radioButton3.setVisibility(VISIBLE);//全檢2
                        radioButton4.setVisibility(GONE);//全檢1
                        rest2.setVisibility(VISIBLE);//不良品重測
                        rest1.setVisibility(VISIBLE);//良品重測
                        rest.setVisibility(GONE);//重測
                    }



                    if (!StepLeft.equals("0")&&((FLOW_STEP.indexOf("全檢1") > -1) || (FLOW_STEP.indexOf("全檢2") > -1)) &&Process.indexOf("全") > -1) {
                        System.out.print("20201001===>>>２"+StepLeft+FLOW_STEP+Process);
                        radio_newb.setVisibility(GONE);//新開始
                        radioButton4b.setVisibility(GONE);//全檢1
                        radio_changb.setVisibility(VISIBLE);//換機台
                        cut_beforb.setVisibility(GONE);//切後底漆
                        cut_afterb.setVisibility(GONE);//切前底漆
                        radio_continueb.setVisibility(VISIBLE);//接續
                        radioButton3b.setVisibility(GONE);//全檢2
                        rest2b.setVisibility(GONE);//不良品重測
                        resetb.setVisibility(GONE);//重測
                        rest1b.setVisibility(GONE);//良品重測
                        Remarksb.setVisibility(GONE);//全檢分類
                    }
                    if (StepLeft.equals("0")&&( (FLOW_STEP.indexOf("全檢2") > -1)) &&Process.indexOf("全") > -1) {
                        System.out.print("20201001===>>>３"+StepLeft+FLOW_STEP+Process);
                        radio_newb.setVisibility(GONE);//新開始
                        radioButton4b.setVisibility(GONE);//全檢1
                        radio_changb.setVisibility(GONE);//換機台
                        cut_beforb.setVisibility(GONE);//切後底漆
                        cut_afterb.setVisibility(GONE);//切前底漆
                        radio_continueb.setVisibility(GONE);//接續
                        radioButton3b.setVisibility(GONE);//全檢2
                        rest2b.setVisibility(VISIBLE);//不良品重測
                        resetb.setVisibility(GONE);//重測
                        rest1b.setVisibility(VISIBLE);//良品重測
                        Remarksb.setVisibility(GONE);//全檢分類
                    }

                    if ((machineBar.equals("No.31") || machineBar.equals("No.32") || machineBar.equals("No.33"))) {
                        System.out.print("20201001===>>>Nob.31４"+StepLeft+FLOW_STEP+Process);
                        Remarksb.setVisibility(VISIBLE);//全檢分類
                        radioButton3b.setVisibility(VISIBLE);//全檢2
                        radioButton4b.setVisibility(GONE);//全檢1
                        rest2b.setVisibility(GONE);//不良品重測
                        rest1b.setVisibility(GONE);//良品重測
                        resetb.setVisibility(GONE);//重測
                        if (FLOW_STEP.indexOf("全檢") > -1){
                            Remarksb.setVisibility(GONE);//全檢分類
                            radioButton3b.setVisibility(GONE);//全檢2
                            if (StepLeft.equals("0")){
                                rest2b.setVisibility(VISIBLE);//不良品重測
                                rest1b.setVisibility(VISIBLE);//良品重測
                                radio_changb.setVisibility(GONE);//換機
                            }else if (!StepLeft.equals("0")){
                                radio_continueb.setVisibility(VISIBLE);//接班
                                radio_changb.setVisibility(VISIBLE);//換機
                            }
                        }
                    }else {
                        if (Process.indexOf("全") > -1&& !(FLOW_STEP.indexOf("全檢")>-1)){
                            Remarksb.setVisibility(VISIBLE);//全檢分類
                            radioButton4b.setVisibility(VISIBLE);//全檢1
                            radioButton3b.setVisibility(GONE);//全檢2
                            rest2b.setVisibility(GONE);//不良品重測
                            rest1b.setVisibility(GONE);//良品重測
                            radio_changb.setVisibility(GONE);//換機
                            radioButton3b.setVisibility(GONE);//全檢2
                        }
                    }

                    if (StepLeft.equals("0")&&FLOW_STEP.equals("全檢2")&&
                        (machineBar.equals("No.31") || machineBar.equals("No.32") || machineBar.equals("No.33"))) {
                        System.out.print("20201001===>>>6４"+StepLeft+FLOW_STEP+Process);
                        Remarksb.setVisibility(GONE);//全檢分類
                        radioButton3b.setVisibility(GONE);//全檢2
                        radioButton4b.setVisibility(GONE);//全檢1
                        rest2b.setVisibility(VISIBLE);//不良品重測
                        rest1b.setVisibility(VISIBLE);//良品重測
                        resetb.setVisibility(GONE);//重測
                    }

                    if (FLOW_STEP_CURR.equals("外檢2") && ((Process.indexOf("外") >1)))
                    {
                        OCHKb.setVisibility(VISIBLE);//製程不同無接續可選
                        OCHK.setVisibility(VISIBLE);//製程不同無接續可選
                        //ochkbb.setVisibility(VISIBLE);//製程不同無接續可選
                    }else {
                        ochkbb.setVisibility(GONE);//製程不同無接續可選
                    }
                    try{
                        if (wqty>1&& (Process.indexOf("外") >1)){////取庫單
                            radio_newb.setVisibility(VISIBLE);//外新=驗底漆
                            OCHKb.setVisibility(VISIBLE);//外交接=驗色碼
                            radio_newb.setText("外檢驗底漆");
                            OCHKb.setText("外檢驗色碼");
                        }
                    }catch (Exception e) {
                    }

                    if(FLOW_STEP_CURR.equals("外檢1")){
                        radio_newb.setText("外檢驗底漆");
                        OCHK.setText("外檢驗色碼");

                        OCHKb.setText("外檢驗色碼");

                    }
                    ochkbb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            OCHK.setChecked(true);
                            select_msg.setText(OCHK.getText());
                        }
                    });
                    dialog.setPositiveButton("送出", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startflig = 1;
                            accident.setText("刪除");
                            testbutton.setVisibility(VISIBLE);
                            test = (Button) findViewById(R.id.test);
                            test.setVisibility(VISIBLE);
                            RadioGroup ticketType = (RadioGroup) v.findViewById(R.id.rg);
                            switch (ticketType.getCheckedRadioButtonId()) {
                                //全檢2檢重測 ： command=22 NGOptions=1 or 2
                                case R.id.D2:  //
                                    Process2="底漆2";
                                    FlowStart_Dstart(view);
                                    break;
                                case R.id.reochkb:
                                    NGOptions="1";
                                    //外檢重驗底漆
                                    FlowStart_re_d(view);
                                    break;
                                case R.id.reset1:  //
                                    NGOptions="1";
                                    FlowStart_refull(view);
                                    break;
                                case R.id.reset2:  //不良品重測
                                    NGOptions="2";
                                    FlowStart_refull(view);
                                    break;
                                case R.id.Remarks:  //全檢分類
                                    FlowStart(view);
                                    try {
                                        String encodedUrl = "", encodedUr2 = "", encodedUr3 = "", encodedUr4 = "", encodedUr5 = "";
                                        userBar = userBar.replaceAll("\\*", "");
                                        encodedUrl = URLEncoder.encode(flowBar, "UTF-8");
                                        encodedUr2 = URLEncoder.encode(userBar, "UTF-8");
                                        encodedUr3 = URLEncoder.encode(machineBar, "UTF-8");
                                        encodedUr4 = URLEncoder.encode(Process, "UTF-8");
                                        String g_list2 = g_list.toString();
                                        call_rest restObj = new call_rest();
                                        url = host + "PrdMgn/ScanOperate?command=1&UID=" +
                                                encodedUr2 +  "&MID=" + encodedUr3 +
                                                "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 +
                                                "&subCommand=1";
                                        if (!encodedUr4.equals("")){//沒人員不代
                                            url=url+"&preOperator=" + encodedUr4;
                                        }
                                        url_stting = url + "&jsonStr=" + g_list2;
                                        JSONObject rtnRestObj = restObj.postRest(url, g_list2);
                                        JSONObject all = new JSONObject(rtnRestObj.toString());
                                        Message = all.getString("Message");
                                        Succ = all.getString("Succ");
                                        code = all.getString("Code");

                                        temp_glist = g_list2;
                                        tempurl=url;
                                        if (all.getString("Data").length() > 100) {
                                            g_json_string = all.getString("Data");
                                            conf_flag = "n";
                                        } else {
                                            conf_flag = all.getString("Data");
                                        }
                                        Message = all.getString("Message");
                                        Succ = all.getString("Succ");
                                        code = all.getString("Code");
                                        update_ui(rtnRestObj);
                                        Message m = new Message();
                                        m.what = MEG_INVALIDATE;
                                        showm.sendMessage(m);
                                        if (Message.indexOf("錯誤") > -1 || Message.indexOf("無法") > -1) {
                                            Message m2 = new Message();
                                            m2.what = MEG_INVALIDATE;
                                            BUTThandler.sendMessage(m2);
                                            messageview.invalidate();
                                            messageview.setTextColor(android.graphics.Color.RED);
                                        } else {
                                            messageview.invalidate();
                                            messageview.setTextColor(android.graphics.Color.BLUE);
                                        }//System.out.print("acc===>>>"+AccQuan);
                                        update_ui(all);
                                    } catch (Exception e) {
                                        CharArrayWriter cw = new CharArrayWriter();
                                        PrintWriter w = new PrintWriter(cw);
                                        e.printStackTrace(w);
                                        w.close();
                                        trace = cw.toString();
                                        e.printStackTrace();
                                        View rootView = getWindow().getDecorView().getRootView();
                                        send_urlsting(rootView);
                                        e.printStackTrace();
                                    }
                                    startflig = 1;
                                    accident.setText("刪除");
                                    sptest.setVisibility(VISIBLE);
                                    part_finish_bnt.setVisibility(VISIBLE);
                                    testbutton.setVisibility(VISIBLE);
                                    test.setVisibility(VISIBLE);
                                    int i = 0;
                                    while (true) {
                                        if (i == 9) {
                                            break;
                                        }
                                        try {
                                            Thread.sleep(1000);
                                            i++;
                                            //開始訊息
                                            if (popMsg != null && !popMsg.equals("") && conf_flag != null) {
                                                if (conf_flag.indexOf("2") > -1) { //需要確認
                                                    conf_flag = "0";
                                                    ShowpopMsg_confrn(view);//confrn popup
                                                    break;
                                                } else if (conf_flag.indexOf("1") > -1) { //停止                                   //
                                                    conf_flag = "0";
                                                    ShowpopMsg_stop(view);//confrn popup
                                                    break;
                                                } else {  //不須確認
                                                    popMsg = popMsg.replaceAll("\",\"", "\r\n");
                                                    popMsg = popMsg.replaceAll("\\[", "");
                                                    popMsg = popMsg.replaceAll("\"", "");
                                                    popMsg = popMsg.replaceAll("\\]", "");
                                                    AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                                                    builder2.setMessage("製程注意事項\r\n" + popMsg + dy_msgdy_msg);
                                                    builder2.setCancelable(false);
                                                    builder2.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int id) {
                                                        }
                                                    });
                                                    if ((!popMsg.equals("mull") && !dy_msgdy_msg.equals("mull"))
                                                            || (!popMsg.equals("") && !dy_msgdy_msg.equals(""))) {

                                                    } else {
                                                        info_bnt.setVisibility(GONE);
                                                        info_bnt.performClick();
                                                        //builder2.show();
                                                    }
                                                    break;
                                                }
                                            } else {  //不須確認
                                                if (Message.indexOf("失敗") > -1) {
                                                    secmod = 0;
                                                    accident.setVisibility(VISIBLE);
                                                    accident.setText("開始");          //  6213559680000
                                                    accident_text.setVisibility(INVISIBLE);
                                                    sptest.setVisibility(INVISIBLE);
                                                    part_finish_bnt.setVisibility(INVISIBLE);
                                                    test.setVisibility(INVISIBLE);
                                                    startflig = 0; // 機台狀態    已經開始為 1  尚未開始為0
                                                }
                                            }
                                            if (Message.indexOf("錯誤") > -1 || Message.indexOf("無法") > -1) {
                                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                                builder.setMessage(Message);
                                                builder.setCancelable(false);
                                                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        //
                                                    }
                                                });
                                                //builder.show();
                                                if (Message.indexOf("再次啟動") > -1) {
                                                    testbutton.setVisibility(VISIBLE);
                                                    accident.setText("刪除");
                                                    startflig = 1;
                                                }
                                                break;
                                            }
                                            break;
                                        } catch (InterruptedException e) {

                                        }
                                    }
                                    break;
                                case R.id.cut:  //切割檢驗新開始
                                    startf = 1;
                                    cut_flag = 1;//切割測試
                                    FlowStart(view);
                                    try {
                                        String encodedUrl = "", encodedUr2 = "", encodedUr3 = "", encodedUr4 = "", encodedUr5 = "";
                                        userBar = userBar.replaceAll("\\*", "");
                                        encodedUrl = URLEncoder.encode(flowBar, "UTF-8");
                                        encodedUr2 = URLEncoder.encode(userBar, "UTF-8");
                                        encodedUr3 = URLEncoder.encode(machineBar, "UTF-8");
                                        encodedUr5 = URLEncoder.encode(check_user, "UTF-8");
                                        Process = "切割檢驗";
                                        //if (Process.equals("花蓮外檢")) Process = "外檢1";
                                        encodedUr4 = URLEncoder.encode(Process, "UTF-8");
                                        String g_list2 = g_list.toString();
                                        call_rest restObj = new call_rest();
                                        url = host + "PrdMgn/ScanOperate?command=1&UID=" +
                                                encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 +
                                                "&subCommand=1";
                                        if (!encodedUr5.equals("")){//沒人員不代
                                            url=url+"&preOperator=" + encodedUr5;
                                        }
                                        url_stting = url + "&jsonStr=" + g_list2;
                                        JSONObject rtnRestObj = restObj.postRest(url, g_list2);
                                        JSONObject all = new JSONObject(rtnRestObj.toString());
                                        Message = all.getString("Message");
                                        Succ = all.getString("Succ");
                                        code = all.getString("Code");
                                        if (all.getString("Data").length() > 10) {
                                            g_json_string = all.getString("Data");
                                            conf_flag = "n";
                                        } else {
                                            conf_flag = all.getString("Data");
                                        }
                                        Message = all.getString("Message");
                                        update_ui(rtnRestObj);
                                        Message m = new Message();
                                        m.what = MEG_INVALIDATE;
                                        showm.sendMessage(m);
                                        if (Message.indexOf("錯誤") > -1 || Message.indexOf("無法") > -1) {
                                            Message m2 = new Message();
                                            m2.what = MEG_INVALIDATE;
                                            BUTThandler.sendMessage(m2);
                                            messageview.invalidate();
                                            messageview.setTextColor(android.graphics.Color.RED);
                                        } else {
                                            messageview.invalidate();
                                            messageview.setTextColor(android.graphics.Color.BLUE);
                                        }//System.out.print("acc===>>>"+AccQuan);
                                        update_ui(all);
                                    } catch (Exception e) {
                                        CharArrayWriter cw = new CharArrayWriter();
                                        PrintWriter w = new PrintWriter(cw);
                                        e.printStackTrace(w);
                                        w.close();
                                        trace = cw.toString();
                                        e.printStackTrace();
                                        View rootView = getWindow().getDecorView().getRootView();
                                        send_urlsting(rootView);
                                        e.printStackTrace();
                                    }
                                    startflig = 1;
                                    accident.setText("刪除");
                                    sptest.setVisibility(VISIBLE);

                                    if (Process.equals("花蓮切割")) {
                                        part_finish_bnt.setVisibility(VISIBLE);
                                    } else {
                                        part_finish_bnt.setVisibility(INVISIBLE);
                                    }
                                    testbutton.setVisibility(VISIBLE);
                                    test.setVisibility(VISIBLE);
                                    i = 0;
                                    while (true) {
                                        if (i == 9) {
                                            break;
                                        }
                                        try {
                                            Thread.sleep(1000);
                                            i++;
                                            //開始訊息
                                            if (popMsg != null && !popMsg.equals("") && conf_flag != null) {
                                                if (conf_flag.indexOf("2") > -1) { //需要確認
                                                    conf_flag = "0";
                                                    ShowpopMsg_confrn(view);//confrn popup
                                                    break;
                                                } else if (conf_flag.indexOf("1") > -1) { //停止                                   //
                                                    conf_flag = "0";
                                                    ShowpopMsg_stop(view);//confrn popup
                                                    break;
                                                } else {  //不須確認
                                                    popMsg = popMsg.replaceAll("\",\"", "\r\n");
                                                    popMsg = popMsg.replaceAll("\\[", "");
                                                    popMsg = popMsg.replaceAll("\"", "");
                                                    popMsg = popMsg.replaceAll("\\]", "");
                                                    AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                                                    builder2.setMessage("製程注意事項\r\n" + popMsg + dy_msgdy_msg);
                                                    builder2.setCancelable(false);
                                                    builder2.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int id) {
                                                        }
                                                    });
                                                    if ((!popMsg.equals("mull") && !dy_msgdy_msg.equals("mull"))
                                                            || (!popMsg.equals("") && !dy_msgdy_msg.equals(""))) {

                                                    } else {
                                                        info_bnt.setVisibility(GONE);
                                                        info_bnt.performClick();
                                                        //builder2.show();
                                                    }
                                                    break;
                                                }
                                            } else {  //不須確認
                                                if (Message.indexOf("失敗") > -1) {
                                                    secmod = 0;
                                                    accident.setVisibility(VISIBLE);
                                                    accident.setText("開始");          //  6213559680000
                                                    accident_text.setVisibility(INVISIBLE);
                                                    sptest.setVisibility(INVISIBLE);
                                                    part_finish_bnt.setVisibility(INVISIBLE);
                                                    test.setVisibility(INVISIBLE);
                                                    startflig = 0; // 機台狀態    已經開始為 1  尚未開始為0
                                                }
                                            }
                                            if (Message.indexOf("錯誤") > -1 || Message.indexOf("無法") > -1) {
                                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                                builder.setMessage(Message);
                                                builder.setCancelable(false);
                                                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        //
                                                    }
                                                });
                                                builder.show();
                                                if (Message.indexOf("再次啟動") > -1) {
                                                    testbutton.setVisibility(VISIBLE);
                                                    accident.setText("刪除");
                                                    startflig = 1;
                                                }
                                                break;
                                            }
                                            break;
                                        } catch (InterruptedException e) {

                                        }
                                    }
                                    break;
                                case R.id.color_start:
                                    Process_CUT="花蓮色碼";
                                    newstart(view);
                                    break;
                                case R.id.cut_after:
                                    Process_CUT="底漆2";
                                    newstart(view);
                                    break;
                                case R.id.cut_befor:
                                    Process_CUT="底漆1";
                                    newstart(view);
                                    break;
                                case R.id.radio_new: //新開始
                                    startf = 1;
                                    startCommand="1";
                                    if (Process.equals(FLOW_STEP) && AccQuan.equals("0")
                                            && ((!Process.equals("花蓮切割")) || (!Process.equals("花蓮底漆")))) {

                                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                        builder.setMessage("此流程單已開始完成過，請選接續前班開始");
                                        builder.setCancelable(false);
                                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {

                                            }
                                        });
                                        builder.show();
                                    }
                                    if (Process.equals(FLOW_STEP) && AccQuan.equals("0")
                                            && ((!Process.equals("花蓮切割")) || (!Process.equals("花蓮底漆")))) {

                                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                        builder.setMessage("此流程單已開始完成過，請選接續前班開始");
                                        builder.setCancelable(false);
                                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {

                                            }
                                        });
                                        builder.show();
                                    }
                                    FlowStart(view);
                                    try {
                                        String encodedUrl = "", encodedUr2 = "", encodedUr3 = "", encodedUr4 = "", encodedUr5 = "";
                                        userBar = userBar.replaceAll("\\*", "");
                                        encodedUrl = URLEncoder.encode(flowBar, "UTF-8");
                                        encodedUr2 = URLEncoder.encode(userBar, "UTF-8");
                                        encodedUr3 = URLEncoder.encode(machineBar, "UTF-8");
                                        encodedUr5 = URLEncoder.encode(check_user, "UTF-8");
                                        System.out.println("newstart1");

                                        if(!WAREHouse_QTY.equals("0") ){//取庫單FLOW_STEP填目前製成
                                            g_list.put("FLOW_STEP", Process);
                                        }
                                        g_list.put("colorUser", check_user);
                                        String g_list2 = g_list.toString();
                                        if (Process.equals("花蓮外檢")) Process = "花蓮外檢";
                                        encodedUr4 = URLEncoder.encode(Process, "UTF-8");
                                        call_rest restObj = new call_rest();
                                        if (Process.indexOf("外檢")>-1) {
                                            FLOW_STEP_CURR="外檢1";
                                            g_list.put("FLOW_STEP_CURR", FLOW_STEP_CURR);
                                            g_list2 = g_list.toString();
                                            url = host + "PrdMgn/ScanOperate?command=21&UID=" +
                                                    encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3 +
                                                    "&subCommand=1&confirmed=2";
                                            if (FLOW_STEP_CURR.indexOf("外檢2")>-1) {

                                                url = host + "PrdMgn/ScanOperate?command=23&UID=" +
                                                        encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3 +
                                                        "&subCommand=1&confirmed=2";
                                            }
                                            if (!NGOptions.equals("0")){
                                                System.out.println("20200916"+NGOptions);
                                                int command=24;///26 外檢1重測 ; 28外檢2重測
                                                if(FLOW_STEP_CURR.equals("外檢2")){command=28;}else{command=26;}
                                                url = host + "PrdMgn/ScanOperate?command="+command+"&UID=" +
                                                        encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3 +
                                                        "&subCommand=1&confirmed=2";
                                            }
                                            if (!encodedUr5.equals("")){//沒人員不代
                                                url=url+"&preOperator=" + encodedUr5;
                                            }
                                            Process = "花蓮外檢";
                                        } else if (Process.equals("花蓮貼帶")) {
                                            url = host + "PrdMgn/ScanOperate?command=31&UID=" + encodedUr2 + "&flowBar=" + encodedUrl +
                                                    "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3;
                                        } else {
                                            url = host + "PrdMgn/ScanOperate?command=1&UID=" + encodedUr2 + "&flowBar=" + encodedUrl +
                                                    "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3;
                                        }
                                        //NGOptions -- 外檢2 使用
                                        //1:NG1, 2:NG2, 3:NG3, 4:NG1+2, 5:NG1+3, 6:NG1+3, 7:NG1+2+3, 8：從前製程數量重做
                                        if (Process.indexOf("外檢") > -1 && !NGOptions.equals("")
                                        ){
                                            url=url+"&NGOptions=" +NGOptions;
                                        }
                                        if (!Process_SWT.equals("")){
                                            url=url+ "&optionDept=" + URLEncoder.encode("花蓮塗裝", "UTF-8");
                                        }
                                        url_stting = url + "&jsonStr=" + g_list2;
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {

                                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                                builder.setMessage("message");
                                                builder.setCancelable(false);
                                                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int id) {

                                                    }
                                                });
                                                //builder.show();
                                            }
                                        });
                                        if (ifLeader_forinput.equals("1")){
                                            url=url+"&confirmed=2";
                                            ifLeader_forinput="0";
                                        }
                                        JSONObject rtnRestObj = restObj.postRest(url, g_list2);
                                        JSONObject all = new JSONObject(rtnRestObj.toString());
                                        Message = all.getString("Message");
                                        System.out.println("20201021url_stting"+url_stting);
                                        System.out.println("20201021rtnRestObj"+rtnRestObj);
                                        System.out.println("20201021Message"+Message);

                                        if (Message.indexOf("** 1-2") > -1 || Message.indexOf("** 2-12") > -1
                                                || Message.indexOf("機台生產中") > -1 || Message.indexOf("機台使用中") > -1
                                                ) {//釋放機台
                                            View rootView = getWindow().getDecorView().getRootView();
                                            Message_confinsh(rootView);
                                        }
                                        Succ = all.getString("Succ");
                                        code = all.getString("Code");
                                        if (all.getString("Data").length() > 10) {
                                            g_json_string = all.getString("Data");
                                            conf_flag = "n";
                                        } else {
                                            conf_flag = all.getString("Data");
                                        }
                                        //Message = all.getString("Message");
                                        if (Message.indexOf("錯誤") > -1 || Message.indexOf("無法") > -1|| Message.indexOf("失敗") > -1) {
                                            Message m2 = new Message();
                                            m2.what = MEG_INVALIDATE;
                                            BUTThandler.sendMessage(m2);
                                            messageview.invalidate();
                                            messageview.setTextColor(android.graphics.Color.RED);

                                        } else {
                                            messageview.invalidate();
                                            messageview.setTextColor(android.graphics.Color.BLUE);
                                        }//System.out.print("acc===>>>"+AccQuan);
                                        Succ = all.getString("Succ");
                                        code = all.getString("Code");
                                        //update_ui(rtnRestObj);
                                        System.out.println(Message+"000000000000000000");
                                        if (all.getString("Data").indexOf("尚") > -1){
                                            temp_glist=g_list2;
                                            tempurl=url;
                                            Message=all.getString("Data");

                                            //   break;
                                        }
                                        /*Message m = new Message();
                                        m.what = MEG_INVALIDATE;
                                        showm.sendMessage(m);*/
                                        update_ui(all);
                                    } catch (Exception e) {
                                        CharArrayWriter cw = new CharArrayWriter();
                                        PrintWriter w = new PrintWriter(cw);
                                        e.printStackTrace(w);
                                        w.close();
                                        trace = cw.toString();
                                        e.printStackTrace();
                                        View rootView = getWindow().getDecorView().getRootView();
                                        send_urlsting(rootView);
                                        e.printStackTrace();
                                    }
                                    startflig = 1;
                                    accident.setText("刪除");
                                    sptest.setVisibility(VISIBLE);
                                    if (Process.equals("花蓮切割") ) {
                                        part_finish_bnt.setVisibility(VISIBLE);
                                    } else {
                                        part_finish_bnt.setVisibility(INVISIBLE);
                                    }
                                    //part_finish_bnt.setVisibility(VISIBLE);
                                    testbutton.setVisibility(VISIBLE);
                                    test.setVisibility(VISIBLE);
                                    i = 0;
                                    while (true) {
                                        if (i == 9) {
                                            break;
                                        }
                                        try {
                                            Thread.sleep(1000);
                                            i++;
                                            //開始訊息
                                            if (popMsg != null && !popMsg.equals("") && conf_flag != null) {
                                                tempurl=url;
                                                if (conf_flag.indexOf("2") > -1|| Message.indexOf("尚有餘料") > -1) { //需要確認
                                                    conf_flag = "0";
                                                    ShowpopMsg_confrn(view);//confrn popup
                                                    break;
                                                } else if (conf_flag.indexOf("1") > -1) { //停止                                   //
                                                    conf_flag = "0";
                                                    ShowpopMsg_stop(view);//confrn popup
                                                    break;
                                                } else {  //不須確認
                                                    popMsg = popMsg.replaceAll("\",\"", "\r\n");
                                                    popMsg = popMsg.replaceAll("\\[", "");
                                                    popMsg = popMsg.replaceAll("\"", "");
                                                    popMsg = popMsg.replaceAll("\\]", "");
                                                    AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                                                    builder2.setMessage("製程注意事項\r\n" + popMsg + dy_msgdy_msg);
                                                    builder2.setCancelable(false);
                                                    builder2.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int id) {
                                                        }
                                                    });
                                                    if ((!popMsg.equals("mull") && !dy_msgdy_msg.equals("mull"))
                                                            || (!popMsg.equals("") && !dy_msgdy_msg.equals(""))) {

                                                    } else {
                                                        info_bnt.setVisibility(GONE);
                                                        info_bnt.performClick();
                                                        //builder2.show();
                                                    }
                                                    break;
                                                }
                                            } else {  //不須確認
                                                if (Message.indexOf("失敗") > -1) {
                                                    secmod = 0;
                                                    accident.setVisibility(VISIBLE);
                                                    accident.setText("開始");          //  6213559680000
                                                    accident_text.setVisibility(INVISIBLE);
                                                    sptest.setVisibility(INVISIBLE);
                                                    part_finish_bnt.setVisibility(INVISIBLE);
                                                    test.setVisibility(INVISIBLE);
                                                    startflig = 0; // 機台狀態    已經開始為 1  尚未開始為0
                                                }
                                            }
                                            if (Message.indexOf("錯誤") > -1 || Message.indexOf("無法") > -1) {
                                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                                builder.setMessage(Message);
                                                builder.setCancelable(false);
                                                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        //
                                                    }
                                                });
                                                //builder.show();
                                                if (Message.indexOf("再次啟動") > -1) {
                                                    testbutton.setVisibility(VISIBLE);
                                                    accident.setText("刪除");
                                                    startflig = 1;
                                                }
                                                break;
                                            }
                                            break;
                                        } catch (InterruptedException e) {

                                        }
                                    }
                                    break;

                                case R.id.OCHK:
                                    startf = 1;
                                    cf=1;
                                    //FLOW_STEP_CURR="外檢2";
                                    FlowStart(view);
                                    try {
                                        String encodedUrl = "", encodedUr2 = "", encodedUr3 = "", encodedUr4 = "", encodedUr5 = "";
                                        userBar = userBar.replaceAll("\\*", "");
                                        encodedUrl = URLEncoder.encode(flowBar, "UTF-8");
                                        encodedUr2 = URLEncoder.encode(userBar, "UTF-8");
                                        encodedUr3 = URLEncoder.encode(machineBar, "UTF-8");
                                        encodedUr5 = URLEncoder.encode(check_user, "UTF-8");
                                        if (Process.equals("花蓮外檢")) Process = "花蓮外檢";
                                        encodedUr4 = URLEncoder.encode(Process, "UTF-8");
                                        String g_list2 = g_list.toString();
                                        call_rest restObj = new call_rest();
                                        CHINTO=1;
                                        url = host + "PrdMgn/ScanOperate?command=21&UID=" +
                                                encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3 +
                                                "&subCommand=1&confirmed=2";
                                        if (FLOW_STEP_CURR.indexOf("外檢2")>-1|| cf==1

                                    ) {
                                            cf=0;
                                            url = host + "PrdMgn/ScanOperate?command=23&UID=" +
                                                    encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3 +
                                                    "&subCommand=1&confirmed=2";
                                            if (!NGOptions.equals("0")){
                                                System.out.println("20200916"+NGOptions);
                                                int command=24;///26 外檢1重測 ; 28外檢2重測
                                                if(FLOW_STEP_CURR.equals("外檢2")){
                                                    startCommand="28";
                                                    command=28;
                                                }else{
                                                    startCommand="26";
                                                    command=26;
                                                }
                                                url = host + "PrdMgn/ScanOperate?command="+command+"&UID=" +
                                                        encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3 +
                                                        "&subCommand=1";
                                            }
                                            if (!encodedUr5.equals("")){//沒人員不代
                                                url=url+"&preOperator=" + encodedUr5;
                                            }
                                        }
                                        if (!encodedUr5.equals("")){//沒人員不代
                                            url=url+"&preOperator=" + encodedUr5;
                                        }
                                        if (Process.indexOf("外檢") > -1 && !NGOptions.equals("")&& !NGOptions.equals("非重複性檢測")
                                        ){
                                            url=url+"&NGOptions=" +NGOptions;
                                        }
                                        if (ifLeader_forinput.equals("1")){
                                            url=url+"&confirmed=2";
                                            ifLeader_forinput="0";
                                        }
                                        url_stting = url + "&jsonStr=" + g_list2;
                                        JSONObject rtnRestObj = restObj.postRest(url, g_list2);
                                        JSONObject all = new JSONObject(rtnRestObj.toString());
                                        Message = all.getString("Message");
                                        if (Message.indexOf("** 1-2") > -1 || Message.indexOf("** 2-12") > -1
                                                || Message.indexOf("機台生產中") > -1 || Message.indexOf("機台使用中") > -1
                                        ) {//釋放機台
                                            View rootView = getWindow().getDecorView().getRootView();
                                            Message_confinsh(rootView);
                                        }
                                        Succ = all.getString("Succ");
                                        code = all.getString("Code");
                                        if (all.getString("Data").length() > 10) {
                                            g_json_string = all.getString("Data");
                                            conf_flag = "n";
                                        } else {
                                            conf_flag = all.getString("Data");
                                        }
                                        Message = all.getString("Message");
                                        Succ = all.getString("Succ");
                                        code = all.getString("Code");
                                        //update_ui(rtnRestObj);

                                        if (all.getString("Data").indexOf("尚") > -1){
                                            temp_glist=g_list2;
                                            tempurl=url;
                                            Message=all.getString("Data");

                                            //   break;
                                        }
                                        Message m = new Message();
                                        m.what = MEG_INVALIDATE;
                                        showm.sendMessage(m);
                                        if (Message.indexOf("錯誤") > -1 || Message.indexOf("無法") > -1) {
                                            Message m2 = new Message();
                                            m2.what = MEG_INVALIDATE;
                                            BUTThandler.sendMessage(m2);
                                            messageview.invalidate();
                                            messageview.setTextColor(android.graphics.Color.RED);
                                        } else {
                                            messageview.invalidate();
                                            messageview.setTextColor(android.graphics.Color.BLUE);
                                        }//System.out.print("acc===>>>"+AccQuan);
                                        update_ui(all);
                                    } catch (Exception e) {
                                        CharArrayWriter cw = new CharArrayWriter();
                                        PrintWriter w = new PrintWriter(cw);
                                        e.printStackTrace(w);
                                        w.close();
                                        trace = cw.toString();
                                        e.printStackTrace();
                                        View rootView = getWindow().getDecorView().getRootView();
                                        send_urlsting(rootView);
                                        e.printStackTrace();
                                    }
                                    startflig = 1;
                                    accident.setText("刪除");
                                    sptest.setVisibility(VISIBLE);
                                    if (Process.equals("花蓮切割") ) {
                                        part_finish_bnt.setVisibility(VISIBLE);
                                    } else {
                                        part_finish_bnt.setVisibility(INVISIBLE);
                                    }
                                    //part_finish_bnt.setVisibility(VISIBLE);
                                    testbutton.setVisibility(VISIBLE);
                                    test.setVisibility(VISIBLE);
                                    i = 0;
                                    while (true) {
                                        if (i == 9) {
                                            break;
                                        }
                                        try {
                                            Thread.sleep(1000);
                                            i++;
                                            //開始訊息
                                            if (popMsg != null && !popMsg.equals("") && conf_flag != null) {
                                                if (conf_flag.indexOf("2") > -1) { //需要確認
                                                    conf_flag = "0";
                                                    ShowpopMsg_confrn(view);//confrn popup
                                                    break;
                                                } else if (conf_flag.indexOf("1") > -1) { //停止                                   //
                                                    conf_flag = "0";
                                                    ShowpopMsg_stop(view);//confrn popup
                                                    break;
                                                } else {  //不須確認
                                                    popMsg = popMsg.replaceAll("\",\"", "\r\n");
                                                    popMsg = popMsg.replaceAll("\\[", "");
                                                    popMsg = popMsg.replaceAll("\"", "");
                                                    popMsg = popMsg.replaceAll("\\]", "");
                                                    AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                                                    builder2.setMessage("製程注意事項\r\n" + popMsg + dy_msgdy_msg);
                                                    builder2.setCancelable(false);
                                                    builder2.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int id) {
                                                        }
                                                    });
                                                    if ((!popMsg.equals("mull") && !dy_msgdy_msg.equals("mull"))
                                                            || (!popMsg.equals("") && !dy_msgdy_msg.equals(""))) {

                                                    } else {
                                                        info_bnt.setVisibility(GONE);
                                                        info_bnt.performClick();
                                                        //builder2.show();
                                                    }
                                                    break;
                                                }
                                            } else {  //不須確認
                                                if (Message.indexOf("失敗") > -1) {
                                                    secmod = 0;
                                                    accident.setVisibility(VISIBLE);
                                                    accident.setText("開始");          //  6213559680000
                                                    accident_text.setVisibility(INVISIBLE);
                                                    sptest.setVisibility(INVISIBLE);
                                                    part_finish_bnt.setVisibility(INVISIBLE);
                                                    test.setVisibility(INVISIBLE);
                                                    startflig = 0; // 機台狀態    已經開始為 1  尚未開始為0
                                                }
                                            }
                                            if (Message.indexOf("錯誤") > -1 || Message.indexOf("無法") > -1) {
                                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                                builder.setMessage(Message);
                                                builder.setCancelable(false);
                                                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        //
                                                    }
                                                });
                                                builder.show();
                                                if (Message.indexOf("再次啟動") > -1) {
                                                    testbutton.setVisibility(VISIBLE);
                                                    accident.setText("刪除");
                                                    startflig = 1;
                                                }
                                                break;
                                            }
                                            break;
                                        } catch (InterruptedException e) {

                                        }
                                    }
                                    break;
                                case R.id.reset:
                                    //重測
                                    startf = 1;
                                    restf = 1;
                                    if (Process.equals("花蓮全檢")) {
                                        firtst_select = 0;
                                    }//重置全檢開始可選全檢1.2
                                    FlowStart(view);
                                    try {
                                        String encodedUrl = "", encodedUr2 = "", encodedUr3 = "", encodedUr4 = "";
                                        userBar = userBar.replaceAll("\\*", "");
                                        encodedUrl = URLEncoder.encode(flowBar, "UTF-8");
                                        encodedUr2 = URLEncoder.encode(userBar, "UTF-8");
                                        encodedUr3 = URLEncoder.encode(machineBar, "UTF-8");
                                        encodedUr4 = URLEncoder.encode(Process, "UTF-8");
                                        String g_list2 = g_list.toString();
                                        call_rest restObj = new call_rest();
                                        url = host + "PrdMgn/ScanOperate?command=1&UID=" + encodedUr2 + "&flowBar=" + encodedUrl +
                                                "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3;

                                        url_stting = url + "&jsonStr=" + g_list2;
                                        if (ifLeader_forinput.equals("1")){
                                            url=url+"&confirmed=2";
                                            ifLeader_forinput="0";
                                        }
                                        JSONObject rtnRestObj = restObj.postRest(url, g_list2);
                                        JSONObject all = new JSONObject(rtnRestObj.toString());
                                        Message = all.getString("Message");
                                        Succ = all.getString("Succ");
                                        code = all.getString("Code");
                                        if (all.getString("Data").length() > 10) {
                                            g_json_string = all.getString("Data");
                                            conf_flag = "n";
                                        } else {
                                            conf_flag = all.getString("Data");
                                        }
                                        Message = all.getString("Message");
                                        update_ui(rtnRestObj);
                                        Message m = new Message();
                                        m.what = MEG_INVALIDATE;
                                        showm.sendMessage(m);
                                        if (Message.indexOf("錯誤") > -1 || Message.indexOf("無法") > -1) {
                                            Message m2 = new Message();
                                            m2.what = MEG_INVALIDATE;
                                            BUTThandler.sendMessage(m2);
                                            messageview.invalidate();
                                            messageview.setTextColor(android.graphics.Color.RED);
                                        } else {
                                            messageview.invalidate();
                                            messageview.setTextColor(android.graphics.Color.BLUE);
                                        }
                                        update_ui(all);
                                    } catch (Exception e) {
                                        CharArrayWriter cw = new CharArrayWriter();
                                        PrintWriter w = new PrintWriter(cw);
                                        e.printStackTrace(w);
                                        w.close();
                                        trace = cw.toString();
                                        e.printStackTrace();
                                        View rootView = getWindow().getDecorView().getRootView();
                                        send_urlsting(rootView);
                                        e.printStackTrace();
                                    }
                                    startflig = 1;
                                    accident.setText("刪除");
                                    sptest.setVisibility(VISIBLE);

                                    if (Process.equals("花蓮切割") ) {
                                        part_finish_bnt.setVisibility(VISIBLE);
                                    } else {
                                        part_finish_bnt.setVisibility(INVISIBLE);
                                    }
                                    //part_finish_bnt.setVisibility(VISIBLE);
                                    testbutton.setVisibility(VISIBLE);
                                    test.setVisibility(VISIBLE);
                                    break;
                                case R.id.radio_search:
                                    //查詢
                                    break;
                                case R.id.radioButton4:
                                    Thread thread = new Thread(new Runnable() {
                                        public void run() {//全檢1
                                            try {
                                                String encodedUrl = "", encodedUr2 = "", encodedUr3 = "", encodedUr4 = "";
                                                Process = "全檢1";
                                                System.out.println("0000000000" + conf_flag);

                                                userBar = userBar.replaceAll("\\*", "");
                                                encodedUrl = URLEncoder.encode(flowBar, "UTF-8");
                                                encodedUr2 = URLEncoder.encode(userBar, "UTF-8");
                                                encodedUr3 = URLEncoder.encode(machineBar, "UTF-8");
                                                encodedUr4 = URLEncoder.encode(Process, "UTF-8");
                                                u = host + "PrdMgn/ScanOperate?command=15&UID=" + encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&confirmed=3&MID=" + encodedUr3;
                                                g_list.put("FLOW_STEP_CURR","全檢1");
                                                String g_list2 = g_list.toString();
                                                temp_glist = g_list2;
                                                tempurl=u;
                                                url_stting = host + "PrdMgn/ScanOperate?command=15&UID=" + encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3 + "&confirmed=3&jsonStr=" + g_list2;
                                                System.out.println(url_stting);
                                                if (ifLeader_forinput.equals("1")){
                                                    u=u+"&confirmed=2";
                                                    ifLeader_forinput="0";
                                                }
                                                call_rest restObj = new call_rest();

                                                JSONObject rtnRestObj = restObj.postRest(u, g_list2);
                                                JSONObject all = new JSONObject(rtnRestObj.toString());
                                                g_json_string = all.getString("Data");
                                                String all2 = all.getString("Data");
                                                Message = all.getString("Message");
                                                Succ = all.getString("Succ");
                                                code = all.getString("Code");


                                                fillGldPent(all, view);
                                                if (all.getString("Data").length() > 100) {
                                                    g_list = new JSONObject(all2);
                                                    g_json_string = all.getString("Data");
                                                    conf_flag = "n";
                                                } else {
                                                    conf_flag = all.getString("Data");
                                                    g_json_string = g_json_string.replaceAll("\",\"", "\r\n");
                                                    g_json_string = g_json_string.replaceAll("\\[", "");
                                                    g_json_string = g_json_string.replaceAll("\"", "");
                                                    g_json_string = g_json_string.replaceAll("\\]", "");
                                                    g_json_string = g_json_string.replaceAll("2開", "開");
                                                    Message=Message+"\n"+g_json_string;
                                                }
                                                if (Message.indexOf("錯誤") > -1 || Message.indexOf("無法") > -1) {
                                                    Message m2 = new Message();
                                                    m2.what = MEG_INVALIDATE;
                                                    BUTThandler.sendMessage(m2);
                                                    messageview.invalidate();
                                                    messageview.setTextColor(android.graphics.Color.RED);
                                                }
                                                if (Message.indexOf("** 1-2") > -1 || Message.indexOf("** 2-12") > -1
                                                        || Message.indexOf("機台生產中") > -1 || Message.indexOf("機台使用中") > -1
                                                        ) {//釋放機台
                                                    View rootView = getWindow().getDecorView().getRootView();
                                                    Message_confinsh(rootView);
                                                }

                                            } catch (Exception e) {
                                                CharArrayWriter cw = new CharArrayWriter();
                                                PrintWriter w = new PrintWriter(cw);
                                                e.printStackTrace(w);
                                                w.close();
                                                trace = cw.toString();
                                                e.printStackTrace();
                                                View rootView = getWindow().getDecorView().getRootView();
                                                send_urlsting(rootView);
                                                e.printStackTrace();
                                            }
                                        }
                                    });
                                    thread.start();
                                    startflig = 1;
                                    sptest.setVisibility(VISIBLE);
                                    if (Process.equals("花蓮切割")) {
                                        part_finish_bnt.setVisibility(VISIBLE);
                                    } else {
                                        part_finish_bnt.setVisibility(INVISIBLE);
                                    }
                                    ;
                                    accident.setText("刪除");
                                    testbutton.setVisibility(VISIBLE);
                                    test.setVisibility(VISIBLE);
                                    int ii = 0;
                                    while (true) {
                                        if (ii == 1000000) {
                                            break;
                                        }
                                        try {
                                            Thread.sleep(3000);
                                            if (Message.indexOf("錯誤") > -1 || Message.indexOf("無法") > -1) {
                                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                                builder.setMessage(Message);
                                                builder.setCancelable(false);
                                                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        //
                                                    }
                                                });
                                                builder.show();
                                                if (Message.indexOf("再次啟動") > -1) {
                                                    sptest.setVisibility(VISIBLE);
                                                    part_finish_bnt.setVisibility(VISIBLE);
                                                    testbutton.setVisibility(VISIBLE);
                                                    //accident.setVisibility(INVISIBLE);
                                                    accident.setText("刪除");
                                                    startflig = 1;
                                                }
                                            }
                                            if (conf_flag != null) {
                                                if (conf_flag.indexOf("2") > -1) { //需要確認
                                                    ShowpopMsg_confrn(view);//confrn popup                                //
                                                    conf_flag = "0";
                                                } else if (conf_flag.indexOf("1") > -1) { //停止
                                                    ShowpopMsg_stop(view);//confrn popup                                  //
                                                    conf_flag = "0";
                                                } else {
                                                    //不須確認
                                                    AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                                                    builder2.setMessage("製程注意事項\r\n" + popMsg + dy_msgdy_msg);
                                                    builder2.setCancelable(false);
                                                    builder2.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int id) {
                                                            //
                                                        }
                                                    });
                                                    if (popMsg == null || popMsg.indexOf("null") > -1 || popMsg.equals("")) {

                                                    } else {
                                                        builder2.show();
                                                        info_bnt.setVisibility(GONE);
                                                        info_bnt.performClick();
                                                    }
                                                }
                                            }

                                            break;
                                        } catch (InterruptedException e) {
                                        }
                                        try {
                                            Thread.sleep(500);
                                            ii++;
                                        } catch (InterruptedException e) {
                                        }
                                    }
                                    break;
                                case R.id.radioButton3:
                                    Thread thread33 = new Thread(new Runnable() {
                                        public void run() {//全檢2
                                            try {
                                                String encodedUrl = "", encodedUr2 = "", encodedUr3 = "", encodedUr4 = "";
                                                Process = "全檢2";
                                                userBar = userBar.replaceAll("\\*", "");
                                                encodedUrl = URLEncoder.encode(flowBar, "UTF-8");
                                                encodedUr2 = URLEncoder.encode(userBar, "UTF-8");
                                                encodedUr3 = URLEncoder.encode(machineBar, "UTF-8");
                                                encodedUr4 = URLEncoder.encode(Process, "UTF-8");
                                                g_list.put("FLOW_STEP_CURR","全檢2");
                                                String g_list2 = g_list.toString();
                                                temp_glist = g_list2;
                                                String u = host + "PrdMgn/ScanOperate?command=17&UID=" + encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3;
                                                System.out.println(u);
                                                if (ifLeader_forinput.equals("1")){
                                                    u=u+"&confirmed=2";
                                                    ifLeader_forinput="0";
                                                }
                                                tempurl=u;
                                                HttpPost post = new HttpPost(u);
                                                HttpResponse response;
                                                List params = new ArrayList();
                                                params.add(new BasicNameValuePair("jsonStr", g_list2));
                                                UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params, HTTP.UTF_8);
                                                post.setEntity(ent);
                                                response = new DefaultHttpClient().execute(post);
                                                String data = null;
                                                if (response.getStatusLine().getStatusCode() == 200) {
                                                    data = EntityUtils.toString(response.getEntity(), "UTF-8");
                                                }
                                                JSONObject all = new JSONObject(data.toString());
                                                g_json_string = all.getString("Data");
                                                String all2 = all.getString("Data");
                                                Message = all.getString("Message");
                                                Succ = all.getString("Succ");
                                                code = all.getString("Code");
                                                if (all.getString("Data").length() > 100) {
                                                    g_list = new JSONObject(all2);
                                                    g_json_string = all.getString("Data");
                                                    conf_flag = "n";
                                                } else {
                                                    conf_flag = all.getString("Data");
                                                    g_json_string = g_json_string.replaceAll("\",\"", "\r\n");
                                                    g_json_string = g_json_string.replaceAll("\\[", "");
                                                    g_json_string = g_json_string.replaceAll("\"", "");
                                                    g_json_string = g_json_string.replaceAll("\\]", "");
                                                    g_json_string = g_json_string.replaceAll("2開", "開");
                                                    Message=Message+"\n"+g_json_string;
                                                }
                                                if (Message.indexOf("錯誤") > -1 || Message.indexOf("無法") > -1) {
                                                    Message m2 = new Message();
                                                    m2.what = MEG_INVALIDATE;
                                                    BUTThandler.sendMessage(m2);
                                                    messageview.invalidate();
                                                    messageview.setTextColor(android.graphics.Color.RED);
                                                }
                                                if (Message.indexOf("** 1-2") > -1 || Message.indexOf("** 2-12") > -1
                                                        || Message.indexOf("機台生產中") > -1 || Message.indexOf("機台使用中") > -1
                                                ) {//釋放機台
                                                    View rootView = getWindow().getDecorView().getRootView();
                                                    Message_confinsh(rootView);
                                                }
                                                Message m2 = new Message();
                                                m2.what = MEG_INVALIDATE;
                                                ALLhandler.sendMessage(m2);
                                            } catch (Exception e) {
                                                CharArrayWriter cw = new CharArrayWriter();
                                                PrintWriter w = new PrintWriter(cw);
                                                e.printStackTrace(w);
                                                w.close();
                                                trace = cw.toString();
                                                e.printStackTrace();
                                                View rootView = getWindow().getDecorView().getRootView();
                                                send_urlsting(rootView);
                                                e.printStackTrace();
                                            }
                                        }
                                    });
                                    thread33.start();
                                    startflig = 1;
                                    sptest.setVisibility(VISIBLE);
                                    if (Process.equals("花蓮切割")) {
                                        part_finish_bnt.setVisibility(VISIBLE);
                                    } else {
                                        part_finish_bnt.setVisibility(INVISIBLE);
                                    }
                                    ;
                                    accident.setText("刪除");
                                    testbutton.setVisibility(VISIBLE);
                                    test.setVisibility(VISIBLE);
                                    int iio = 0;
                                    while (true) {
                                        if (iio == 1000000) {
                                            break;
                                        }
                                        try {
                                            Thread.sleep(3000);
                                            if (Message.indexOf("錯誤") > -1 || Message.indexOf("無法") > -1) {
                                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                                builder.setMessage(Message);
                                                builder.setCancelable(false);
                                                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        //
                                                    }
                                                });
                                                builder.show();
                                                if (Message.indexOf("再次啟動") > -1) {
                                                    sptest.setVisibility(VISIBLE);
                                                    part_finish_bnt.setVisibility(VISIBLE);
                                                    testbutton.setVisibility(VISIBLE);
                                                    //accident.setVisibility(INVISIBLE);
                                                    accident.setText("刪除");
                                                    startflig = 1;
                                                }
                                            }
                                            if (conf_flag != null) {
                                                if (conf_flag.indexOf("2") > -1) { //需要確認
                                                    ShowpopMsg_confrn(view);//confrn popup                                //
                                                    conf_flag = "0";
                                                } else if (conf_flag.indexOf("1") > -1) { //停止
                                                    ShowpopMsg_stop(view);//confrn popup                                  //
                                                    conf_flag = "0";
                                                } else {
                                                    //不須確認
                                                    AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                                                    builder2.setMessage("製程注意事項\r\n" + popMsg + dy_msgdy_msg);
                                                    builder2.setCancelable(false);
                                                    builder2.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int id) {
                                                            //
                                                        }
                                                    });
                                                    if (popMsg == null || popMsg.indexOf("null") > -1 || popMsg.equals("")) {

                                                    } else {
                                                        builder2.show();
                                                        info_bnt.setVisibility(GONE);
                                                        info_bnt.performClick();
                                                    }
                                                }
                                            }

                                            break;
                                        } catch (InterruptedException e) {
                                        }
                                        try {
                                            Thread.sleep(500);
                                            iio++;
                                        } catch (InterruptedException e) {
                                        }
                                    }
                                    break;
                                case R.id.radio_changcolor:
                                    //底漆換色
                                    startf = 1;
                                    chang_color = 1;
                                    if (Process.equals("花蓮全檢")) {
                                        firtst_select = 0;
                                    }//重置全檢開始可選全檢1.2
                                    FlowStart(view);
                                    HttpResponse response4;
                                    Thread thread55 = new Thread(new Runnable() {
                                        public void run() {
                                            try {
                                                String encodedUrl = "", encodedUr2 = "", encodedUr3 = "", encodedUr4 = "";
                                                userBar = userBar.replaceAll("\\*", "");
                                                encodedUr2 = URLEncoder.encode(userBar, "UTF-8");
                                                encodedUr3 = URLEncoder.encode(machineBar, "UTF-8");
                                                encodedUr4 = URLEncoder.encode(Process, "UTF-8");
                                                String u = host + "PrdMgn/ScanOperate?command=7&UID=" + encodedUr2 + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3;
                                                url_stting = host + "PrdMgn/ScanOperate?command=7&UID=" + encodedUr2 + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3;
                                                String g_list2 = g_list.toString();
                                                HttpPost post = new HttpPost(u);
                                                System .out.println("換漆"+url_stting+"&jsonStr="+g_list.toString());
                                                HttpResponse response;
                                                List params = new ArrayList();
                                                params.add(new BasicNameValuePair("jsonStr", g_list2));
                                                UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params, HTTP.UTF_8);
                                                post.setEntity(ent);
                                                response = new DefaultHttpClient().execute(post);
                                                String data = null;
                                                if (response.getStatusLine().getStatusCode() == 200) {
                                                    data = EntityUtils.toString(response.getEntity(), "UTF-8");
                                                }
                                                JSONObject all = new JSONObject(data.toString());
                                                Message = all.getString("Message");
                                                Succ = all.getString("Succ");
                                                code = all.getString("Code");
                                                if (Message.indexOf("錯誤") > -1 || Message.indexOf("無法") > -1) {
                                                    Message m2 = new Message();
                                                    m2.what = MEG_INVALIDATE;
                                                    BUTThandler.sendMessage(m2);
                                                    messageview.invalidate();
                                                    messageview.setTextColor(android.graphics.Color.RED);
                                                } else {
                                                    messageview.invalidate();
                                                    messageview.setTextColor(android.graphics.Color.BLUE);
                                                }
                                                messageview.setText("訊息:" + Message);
                                                url_Texted.invalidate();
                                                if (all.getString("Data").length() > 10) {
                                                    g_json_string = all.getString("Data");
                                                    conf_flag = "n";
                                                } else {
                                                    conf_flag = all.getString("Data");
                                                }
                                                Message = all.getString("Message");
                                                Succ = all.getString("Succ");
                                                code = all.getString("Code");
                                                update_ui(all);
                                                Message m = new Message();
                                                m.what = MEG_INVALIDATE;
                                                showm.sendMessage(m);
                                            } catch (Exception e) {
                                                CharArrayWriter cw = new CharArrayWriter();
                                                PrintWriter w = new PrintWriter(cw);
                                                e.printStackTrace(w);
                                                w.close();
                                                trace = cw.toString();
                                                e.printStackTrace();
                                                View rootView = getWindow().getDecorView().getRootView();
                                                send_urlsting(rootView);
                                                e.printStackTrace();
                                            }
                                        }
                                    });
                                    thread55.start();
                                    startflig = 1;
                                    sptest.setVisibility(VISIBLE);
                                    part_finish_bnt.setVisibility(VISIBLE);
                                    accident.setText("刪除");
                                    testbutton.setVisibility(VISIBLE);
                                    test.setVisibility(VISIBLE);
                                    int ii2 = 0;
                                    while (true) {
                                        if (ii2 == 2) {
                                            break;
                                        }
                                        try {
                                            Thread.sleep(500);
                                            if (Message.indexOf("錯誤") > -1 || Message.indexOf("無法") > -1) {
                                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                                builder.setMessage(Message);
                                                builder.setCancelable(false);
                                                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        //
                                                    }
                                                });
                                                builder.show();
                                                if (Message.indexOf("再次啟動") > -1) {
                                                    sptest.setVisibility(VISIBLE);
                                                    part_finish_bnt.setVisibility(VISIBLE);
                                                    testbutton.setVisibility(VISIBLE);
                                                    //accident.setVisibility(INVISIBLE);
                                                    accident.setText("刪除");
                                                    startflig = 1;
                                                }
                                                if (popMsg != null && !popMsg.equals("") && conf_flag != null) {
                                                    if (conf_flag.indexOf("2") > -1) { //需要確認                                   //
                                                        conf_flag = "0";
                                                        ShowpopMsg_confrn(view);//confrn popup
                                                    } else if (conf_flag.indexOf("1") > -1) { //停止                                   //
                                                        conf_flag = "0";
                                                        ShowpopMsg_stop(view);//confrn popup
                                                    } else {
                                                        //不須確認
                                                        AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                                                        builder2.setMessage("製程注意事項\r\n" + popMsg + dy_msgdy_msg);
                                                        builder2.setCancelable(false);
                                                        builder2.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                            public void onClick(DialogInterface dialog, int id) {
                                                                //
                                                            }
                                                        });
                                                        if (popMsg == null || popMsg.indexOf("null") > -1 || popMsg.equals("")) {

                                                        } else {
                                                            builder2.show();
                                                            info_bnt.setVisibility(GONE);
                                                            info_bnt.performClick();
                                                        }
                                                    }
                                                } else {
                                                }
                                                break;
                                            }
                                        } catch (InterruptedException e) {
                                        }
                                        try {
                                            Thread.sleep(500);
                                            ii2++;
                                        } catch (InterruptedException e) {
                                        }
                                    }
                                    break;
                                case R.id.radio_continue:
                                    startf = 1;
                                    startCommand="3";
                                    FlowStart(view);
                                    if (Process.equals("花蓮全檢")) {
                                        firtst_select = 0;
                                    }//重置全檢開始可選全檢1.2
                                    // DO 接續前班
                                    Thread thread3 = new Thread(new Runnable() {
                                        public void run() {
                                            try {
                                                String encodedUrl = "", encodedUr2 = "", encodedUr3 = "", encodedUr4 = "";
                                                userBar = userBar.replaceAll("\\*", "");
                                                encodedUrl = URLEncoder.encode(flowBar, "UTF-8");
                                                encodedUr2 = URLEncoder.encode(userBar, "UTF-8");
                                                encodedUr3 = URLEncoder.encode(machineBar, "UTF-8");
                                                //換班

                                                if (Process.equals("花蓮外檢")) Process = "外檢1";
                                                encodedUr4 = URLEncoder.encode(Process, "UTF-8");

                                                String g_list2 = g_list.toString();
                                                if (Process.equals("花蓮貼帶")) {
                                                    url_stting = host + "PrdMgn/ScanOperate?command=33&UID=" + encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3 + "&jsonStr=" + g_list2;
                                                } else {
                                                    url_stting = host + "PrdMgn/ScanOperate?command=3&UID=" + encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3 + "&jsonStr=" + g_list2;
                                                }
                                                if (Process.equals("花蓮貼帶")) {
                                                    u = host + "PrdMgn/ScanOperate?command=33&UID=" + encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3;
                                                } else {
                                                    u = host + "PrdMgn/ScanOperate?command=3&UID=" + encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3;
                                                }

                                                if (Process.indexOf("外檢") > -1 && !NGOptions.equals("")
                                                ){
                                                    u=u+"&NGOptions=" +NGOptions;
                                                }
                                                if (!Process_SWT.equals("")){
                                                    u=u+ "&optionDept=" + URLEncoder.encode("花蓮塗裝", "UTF-8");
                                                }
                                                call_rest restObj = new call_rest();
                                                JSONObject rtnRestObj = restObj.postRest(u, g_list2);
                                                JSONObject all = new JSONObject(rtnRestObj.toString());
                                                Message = all.getString("Message");
                                                Succ = all.getString("Succ");
                                                code = all.getString("Code");
                                                if (all.getString("Data").length() > 10) {
                                                    g_json_string = all.getString("Data");
                                                    conf_flag = "n";
                                                } else {
                                                    conf_flag = all.getString("Data");
                                                }
                                                Message = all.getString("Message");
                                                update_ui(rtnRestObj);
                                                if (all.getString("Data").indexOf("尚") > -1){
                                                    temp_glist=g_list2;
                                                    tempurl=url;
                                                    Message=all.getString("Data");
                                                    Message_show(view);//confrn popup

                                                    //   break;
                                                }
                                                Message m = new Message();
                                                m.what = MEG_INVALIDATE;
                                                showm.sendMessage(m);
                                                if (Message.indexOf("錯誤") > -1 || Message.indexOf("無法") > -1) {
                                                    Message m2 = new Message();
                                                    m2.what = MEG_INVALIDATE;
                                                    BUTThandler.sendMessage(m2);
                                                    messageview.invalidate();
                                                    messageview.setTextColor(android.graphics.Color.RED);
                                                } else {
                                                    messageview.invalidate();
                                                    messageview.setTextColor(android.graphics.Color.BLUE);
                                                }
                                                update_ui(all);
                                            } catch (Exception e) {
                                                CharArrayWriter cw = new CharArrayWriter();
                                                PrintWriter w = new PrintWriter(cw);
                                                e.printStackTrace(w);
                                                w.close();
                                                trace = cw.toString();
                                                e.printStackTrace();
                                                View rootView = getWindow().getDecorView().getRootView();
                                                send_urlsting(rootView);
                                                Message m = new Message();
                                                m.what = MEG_INVALIDATE;
                                                messagehandler.sendMessage(m);
                                                e.printStackTrace();
                                            }
                                        }
                                    });
                                    thread3.start();
                                    test.setVisibility(VISIBLE);
                                    startflig = 1;
                                    accident.setText("刪除");
                                    accident.setVisibility(INVISIBLE);
                                    part_finish_bnt.setVisibility(VISIBLE);
                                    sptest.setVisibility(VISIBLE);
                                    testbutton.setVisibility(VISIBLE);
                                    int j = 0;
                                    while (true) {
                                        j++;
                                        if (j == 9) {
                                            break;
                                        }

                                        try {
                                            Thread.sleep(500);
                                        } catch (Exception e) {
                                            CharArrayWriter cw = new CharArrayWriter();
                                            PrintWriter w = new PrintWriter(cw);
                                            e.printStackTrace(w);
                                            w.close();
                                            trace = cw.toString();
                                            e.printStackTrace();
                                            View rootView = getWindow().getDecorView().getRootView();
                                            //send_urlsting(rootView);
                                        }
                                        if (Message.indexOf("失敗") > -1 || Message.indexOf("無法") > -1) {
                                            secmod = 0;
                                            accident.setVisibility(VISIBLE);
                                            accident.setText("開始");          //  6213559680000
                                            accident_text.setVisibility(INVISIBLE);
                                            sptest.setVisibility(INVISIBLE);
                                            part_finish_bnt.setVisibility(INVISIBLE);
                                            test.setVisibility(INVISIBLE);
                                            startflig = 0; // 機台狀態    已經開始為 1  尚未開始為0
                                        }
                                    }
                                    int k = 0;
                                    while (true) {
                                        k++;
                                        if (k == 2) {
                                            break;
                                        }
                                        try {
                                            if (conf_flag.indexOf("2") > -1) { //需要確認                                   //
                                                conf_flag = "0";
                                                ShowpopMsg_confrn(view);//confrn popup
                                                break;
                                            } else {  //不須確認
                                                AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                                                builder2.setMessage("製程注意事項\r\n" + popMsg + dy_msgdy_msg);
                                                builder2.setCancelable(false);
                                                builder2.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int id) {

                                                    }
                                                });
                                                break;
                                            }
                                        } catch (Exception e) {
                                            CharArrayWriter cw = new CharArrayWriter();
                                            PrintWriter w = new PrintWriter(cw);
                                            e.printStackTrace(w);
                                            w.close();
                                            trace = cw.toString();
                                            e.printStackTrace();
                                            View rootView = getWindow().getDecorView().getRootView();
                                            send_urlsting(rootView);
                                        }
                                        break;
                                    }
                                    break;

                                case R.id.radio_chang://換機台
                                    startf = 1;
                                    chm = 1;
                                    FlowStart(view);
                                    if (Process.equals("花蓮全檢")) {
                                        firtst_select = 0;
                                    }//重置全檢開始可選全檢1.2
                                    Thread thread4 = new Thread(new Runnable() {
                                        public void run() {
                                            try {
                                                String encodedUrl = "", encodedUr2 = "", encodedUr3 = "", encodedUr4 = "";
                                                userBar = userBar.replaceAll("\\*", "");
                                                encodedUrl = URLEncoder.encode(flowBar, "UTF-8");
                                                encodedUr2 = URLEncoder.encode(userBar, "UTF-8");
                                                encodedUr3 = URLEncoder.encode(machineBar, "UTF-8");
                                                //換機台
                                                encodedUr4 = URLEncoder.encode(Process, "UTF-8");
                                                if((Process.equals("花蓮外檢") || FLOW_STEP_CURR.equals("外檢2")) ||
                                                        (Process.equals("花蓮外檢") || FLOW_STEP_CURR.equals("外檢1") )) {
                                                    g_list.put("colorUser", check_userid);
                                                }
                                                if (Process.equals("花蓮貼帶")) {
                                                    u = host + "PrdMgn/ScanOperate?command=34&UID=" + encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3;
                                                } else {
                                                    u = host + "PrdMgn/ScanOperate?command=4&UID=" + encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3;
                                                }
                                                if (Process.indexOf("外檢") > -1 && !NGOptions.equals("")&& !NGOptions.equals("非重複性檢測")
                                                ){
                                                    u=u+"&NGOptions=" +NGOptions;
                                                }
                                                if (!Process_SWT.equals("")){
                                                    u=u+ "&optionDept=" + URLEncoder.encode("花蓮塗裝", "UTF-8");
                                                }
                                                String g_list2 = g_list.toString();
                                                temp_glist = g_list.toString();
                                                url_stting = host + "PrdMgn/ScanOperate?command=4&UID=" + encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3 + "&jsonStr=" + g_list2;
                                                if (Process.equals("花蓮貼帶")) {
                                                    url_stting = host + "PrdMgn/ScanOperate?command=34&UID=" + encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3 + "&jsonStr=" + g_list2;
                                                }
                                                //params.add(new BasicNameValuePair("jsonStr", g_list2));
                                                call_rest restObj = new call_rest();
                                                JSONObject rtnRestObj = restObj.postRest(u, g_list2);
                                                JSONObject all = new JSONObject(rtnRestObj.toString());
                                                Message = all.getString("Message");
                                                Succ = all.getString("Succ");
                                                code = all.getString("Code");
                                                String all2 = all.getString("Data");
                                                g_list = new JSONObject(all2);
                                                Message = all.getString("Message");
                                                if (all.getString("Data").length() > 10) {
                                                    g_json_string = all.getString("Data");
                                                    conf_flag = "n";
                                                } else {
                                                    conf_flag = all.getString("Data");
                                                }
                                                if (all.getString("Data").indexOf("尚") > -1){
                                                    temp_glist=g_list2;
                                                    tempurl=url;
                                                    Message=all.getString("Data");
                                                    //   break;
                                                }
                                                update_ui(g_list);
                                                Message m = new Message();
                                                m.what = MEG_INVALIDATE;
                                                showm.sendMessage(m);
                                            } catch (Exception e) {
                                                CharArrayWriter cw = new CharArrayWriter();
                                                PrintWriter w = new PrintWriter(cw);
                                                e.printStackTrace(w);
                                                w.close();
                                                trace = cw.toString();
                                                e.printStackTrace();
                                                View rootView = getWindow().getDecorView().getRootView();
                                                send_urlsting(rootView);
                                                e.printStackTrace();
                                            }
                                        }
                                    });
                                    startflig = 1;
                                    accident.setText("刪除");
                                    if (MachineID_Befor.equals(machineBar)) {
                                        accident.setText("開始");
                                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                        builder.setMessage("機台不可為同一台");
                                        test.setVisibility(INVISIBLE);
                                        part_finish_bnt.setVisibility(INVISIBLE);
                                        sptest.setVisibility(INVISIBLE);
                                        builder.setCancelable(false);
                                        startflig = 0;
                                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                            }
                                        });
                                        builder.show();
                                    } else {
                                        thread4.start();
                                        sptest.setVisibility(VISIBLE);
                                        part_finish_bnt.setVisibility(VISIBLE);
                                        test.setVisibility(VISIBLE);
                                        FlowStart(view);
                                    }
                                    if (popMsg != null && !popMsg.equals("") && conf_flag != null) {
                                        if (conf_flag.indexOf("2") > -1) { //需要確認                                   //
                                            conf_flag = "0";
                                            ShowpopMsg_confrn(view);//confrn popup
                                        } else if (conf_flag.indexOf("1") > -1) { //停止                                   //
                                            conf_flag = "0";
                                            ShowpopMsg_stop(view);//confrn popup
                                        } else {  //不須確認
                                            AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                                            builder2.setMessage("製程注意事項\r\n" + popMsg + dy_msgdy_msg);
                                            builder2.setCancelable(false);
                                            builder2.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int id) {
                                                    //
                                                }
                                            });

                                            if (popMsg == null || popMsg.indexOf("null") > -1 || popMsg.equals("")) {

                                            } else {
                                                //builder2.show();
                                                info_bnt.setVisibility(GONE);
                                                info_bnt.performClick();
                                            }
                                        }
                                    }
                                    break;
                            }//switch of end
                        }
                    });  //dialog of end
                    if ((machineBar.equals("選擇機台") || machineBar.equals("") )&&
                    (!Process.equals("花蓮切割") && !Process.equals("切割檢驗"))/* &&
                            !Process.equals("全檢1") &&
                            !Process.equals("全檢分類") && !Process.equals("全檢2")*/) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("需要選擇機台");
                        builder.setCancelable(false);
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                accident.setVisibility(VISIBLE);
                            }
                        });
                        builder.show();
                    } else if ((machineBar.equals("選擇機台") || machineBar.equals("") )&&Process.equals("花蓮全檢")){
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("需要選擇機台");
                        builder.setCancelable(false);
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                accident.setVisibility(VISIBLE);
                            }
                        });
                        builder.show();
                    }else
                    {
                        dialog.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //mothing
                                accident.setVisibility(VISIBLE);

                            }
                        });

                        //                 dialog window size ssetting
                        AlertDialog dlg = dialog.show();
                        WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
                        //視窗長寬
                        params.width = 1200;
                        params.height = 900;
                        //button text size
                        dlg.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
                        dlg.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
                        dlg.getWindow().setAttributes(params);
                    }
                }
            } else {
                //電鍍開始
                try {
                    if (!flowBar.equals("")) {//有掃
                        String g_list2 = g_list.toString();
                        call_rest restObj = new call_rest();
                        String encodedUrl = "", encodedUr2 = "", encodedUr3 = "", encodedUr4 = "";
                        userBar = userBar.replaceAll("\\*", "");
                        encodedUrl = URLEncoder.encode(flowBar, "UTF-8");
                        encodedUr2 = URLEncoder.encode(userBar, "UTF-8");
                        encodedUr3 = URLEncoder.encode(machineBar, "UTF-8");
                        encodedUr4 = URLEncoder.encode(Process, "UTF-8");
                        url = host + "PrdMgn/ScanOperate?command=12&UID="
                                + userBar + "&flowBar=" + encodedUrl +
                                "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3;
                        JSONObject rtnRestObj = restObj.postRest(url, g_list2);
                        flowBar = "";
                        JSONObject all = new JSONObject(rtnRestObj.toString());
                        try {
                            Thread.sleep(500); //1000為1秒
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        plating_views(view);
                    } else {
                        plating_views(view);
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void FlowStart_Dstart(View view) {//外檢重測
        startf = 1;
        try {
            String encodedUrl = "", encodedUr2 = "", encodedUr3 = "", encodedUr4 = "", encodedUr5 = "";
            userBar = userBar.replaceAll("\\*", "");
            encodedUrl = URLEncoder.encode(flowBar, "UTF-8");
            encodedUr2 = URLEncoder.encode(userBar, "UTF-8");
            encodedUr3 = URLEncoder.encode(machineBar, "UTF-8");
            encodedUr5 = URLEncoder.encode(check_user, "UTF-8");
            g_list.put("colorUser", check_user);
            System.out.println("check_user==="+check_user);
            if (Process.equals("花蓮外檢")) Process = "花蓮外檢";
            encodedUr4 = URLEncoder.encode(Process2, "UTF-8");
            String g_list2 = g_list.toString();
            call_rest restObj = new call_rest();
            if (Process.indexOf("外檢")>-1) {
                url = host + "PrdMgn/ScanOperate?command=21&UID=" +
                        encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3 +
                        "&subCommand=1&confirmed=2";
                if (FLOW_STEP_CURR.indexOf("外檢2")>-1) {

                    url = host + "PrdMgn/ScanOperate?command=23&UID=" +
                            encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3 +
                            "&subCommand=1&confirmed=2";
                }
                if (!NGOptions.equals("0")){
                    int command=24;///26 外檢1重測 ; 28外檢2重測
                    if(FLOW_STEP_CURR.equals("外檢2")){command=28;}else{command=26;}
                    url = host + "PrdMgn/ScanOperate?command="+command+"&UID=" +
                            encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3 +
                            "&subCommand=1";
                }
                if (!encodedUr5.equals("")){//沒人員不代
                    url=url+"&preOperator=" + encodedUr5;
                }
                Process = "花蓮外檢";
            } else if (Process.equals("花蓮貼帶")) {
                url = host + "PrdMgn/ScanOperate?command=31&UID=" + encodedUr2 + "&flowBar=" + encodedUrl +
                        "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3;
            } else {
                url = host + "PrdMgn/ScanOperate?command=1&UID=" + encodedUr2 + "&flowBar=" + encodedUrl +
                        "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3;
            }
            //NGOptions -- 外檢2 使用
            //1:NG1, 2:NG2, 3:NG3, 4:NG1+2, 5:NG1+3, 6:NG1+3, 7:NG1+2+3, 8：從前製程數量重做
            if (Process.indexOf("外檢") > -1 && !NGOptions.equals("")
            ){
                url=url+"&NGOptions=" +NGOptions;
            }
            url_stting = url + "&jsonStr=" + g_list2;
            if (ifLeader_forinput.equals("1")){
                url=url+"&confirmed=2";
                ifLeader_forinput="0";
            }
            if (!Process_SWT.equals("")){
                url=url+ "&optionDept=" + URLEncoder.encode("花蓮塗裝", "UTF-8");
            }
            JSONObject rtnRestObj = restObj.postRest(url, g_list2);
            JSONObject all = new JSONObject(rtnRestObj.toString());
            try {
                Thread.sleep(100); //1000為1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            update_ui(all);
            Message = all.getString("Message");
            if (Message.indexOf("** 1-2") > -1 || Message.indexOf("** 2-12") > -1
                    || Message.indexOf("機台生產中") > -1 || Message.indexOf("機台使用中") > -1
            ) {//釋放機台
                View rootView = getWindow().getDecorView().getRootView();
                Message_confinsh(rootView);
            }
            Succ = all.getString("Succ");
            code = all.getString("Code");
            if (all.getString("Data").length() > 10) {
                g_json_string = all.getString("Data");
                conf_flag = "n";
            } else {
                conf_flag = all.getString("Data");
            }
            Message = all.getString("Message");
            Succ = all.getString("Succ");
            code = all.getString("Code");
            //update_ui(rtnRestObj);
            if (all.getString("Data").indexOf("尚") > -1){
                temp_glist=g_list2;
                tempurl=url;
                Message=all.getString("Data");

                //   break;
            }
            Message m = new Message();
            m.what = MEG_INVALIDATE;
            showm.sendMessage(m);
            if (Message.indexOf("錯誤") > -1 || Message.indexOf("無法") > -1) {
                Message m2 = new Message();
                m2.what = MEG_INVALIDATE;
                BUTThandler.sendMessage(m2);
                messageview.invalidate();
                messageview.setTextColor(android.graphics.Color.RED);
            } else {
                messageview.invalidate();
                messageview.setTextColor(android.graphics.Color.BLUE);
            }//System.out.print("acc===>>>"+AccQuan);
        } catch (Exception e) {
            CharArrayWriter cw = new CharArrayWriter();
            PrintWriter w = new PrintWriter(cw);
            e.printStackTrace(w);
            w.close();
            trace = cw.toString();
            e.printStackTrace();
            View rootView = getWindow().getDecorView().getRootView();
            send_urlsting(rootView);
            e.printStackTrace();
        }
        startflig = 1;
        accident.setText("刪除");
        sptest.setVisibility(VISIBLE);
        if (Process.equals("花蓮切割") ) {
            part_finish_bnt.setVisibility(VISIBLE);
        } else {
            part_finish_bnt.setVisibility(INVISIBLE);
        }
        //part_finish_bnt.setVisibility(VISIBLE);
        testbutton.setVisibility(VISIBLE);
        test.setVisibility(VISIBLE);
        int i = 0;
        while (true) {
            if (i == 9) {
                break;
            }
            try {
                Thread.sleep(1000);
                i++;
                //開始訊息
                if (popMsg != null && !popMsg.equals("") && conf_flag != null) {
                    tempurl=url;
                    if (conf_flag.indexOf("2") > -1|| Message.indexOf("尚有餘料") > -1) { //需要確認
                        conf_flag = "0";
                        ShowpopMsg_confrn(view);//confrn popup
                        break;
                    } else if (conf_flag.indexOf("1") > -1) { //停止                                   //
                        conf_flag = "0";
                        ShowpopMsg_stop(view);//confrn popup
                        break;
                    } else {  //不須確認
                        popMsg = popMsg.replaceAll("\",\"", "\r\n");
                        popMsg = popMsg.replaceAll("\\[", "");
                        popMsg = popMsg.replaceAll("\"", "");
                        popMsg = popMsg.replaceAll("\\]", "");
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                        builder2.setMessage("製程注意事項\r\n" + popMsg + dy_msgdy_msg);
                        builder2.setCancelable(false);
                        builder2.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                        break;
                    }
                } else {  //不須確認
                    if (Message.indexOf("失敗") > -1) {
                        secmod = 0;
                        accident.setVisibility(VISIBLE);
                        accident.setText("開始");          //  6213559680000
                        accident_text.setVisibility(INVISIBLE);
                        sptest.setVisibility(INVISIBLE);
                        part_finish_bnt.setVisibility(INVISIBLE);
                        test.setVisibility(INVISIBLE);
                        startflig = 0; // 機台狀態    已經開始為 1  尚未開始為0
                    }
                }
                if (Message.indexOf("錯誤") > -1 || Message.indexOf("無法") > -1) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage(Message);
                    builder.setCancelable(false);
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //
                        }
                    });
                    builder.show();
                    if (Message.indexOf("再次啟動") > -1) {
                        testbutton.setVisibility(VISIBLE);
                        accident.setText("刪除");
                        startflig = 1;
                    }
                    break;
                }
                break;
            } catch (InterruptedException e) {

            }
        }
    }
    private void newstart(View view) {//塗裝
        startf = 1;
        startCommand="1";
        if (Process.equals(FLOW_STEP) && AccQuan.equals("0")
                && ((!Process.equals("花蓮切割")) || (!Process.equals("花蓮底漆")))) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("此流程單已開始完成過，請選接續前班開始");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
            builder.show();
        }
        try {
            String encodedUrl = "", encodedUr2 = "", encodedUr3 = "", encodedUr4 = "", encodedUr5 = "";
            userBar = userBar.replaceAll("\\*", "");
            encodedUrl = URLEncoder.encode(flowBar, "UTF-8");
            encodedUr2 = URLEncoder.encode(userBar, "UTF-8");
            encodedUr3 = URLEncoder.encode(machineBar, "UTF-8");
            encodedUr5 = URLEncoder.encode(Process_CUT, "UTF-8");
            encodedUr4 = URLEncoder.encode("花蓮塗裝", "UTF-8");
            String g_list2 = g_list.toString();
            url = host + "PrdMgn/ScanOperate?command=1&UID=" + encodedUr2 + "&flowBar=" + encodedUrl +
                    "&DEPT=" + encodedUr5 + "&MID=" + encodedUr3 + "&optionDept=" + encodedUr4;
            call_rest restObj = new call_rest();
            url_stting = url + "&jsonStr=" + g_list2;
            if (ifLeader_forinput.equals("1")){
                url=url+"&confirmed=2";
                ifLeader_forinput="0";
            }
            JSONObject rtnRestObj = restObj.postRest(url, g_list2);
            JSONObject all = new JSONObject(rtnRestObj.toString());
            if (Message.indexOf("** 1-2") > -1 || Message.indexOf("** 2-12") > -1
                    || Message.indexOf("機台生產中") > -1 || Message.indexOf("機台使用中") > -1
            ) {//釋放機台
                View rootView = getWindow().getDecorView().getRootView();
                Message_confinsh(rootView);
            }
            Succ = all.getString("Succ");
            code = all.getString("Code");
            if (all.getString("Data").length() > 10) {
                g_json_string = all.getString("Data");
                conf_flag = "n";
            } else {
                conf_flag = all.getString("Data");
            }
            //Message = all.getString("Message");
            if (Message.indexOf("錯誤") > -1 || Message.indexOf("無法") > -1|| Message.indexOf("失敗") > -1) {
                Message m2 = new Message();
                m2.what = MEG_INVALIDATE;
                BUTThandler.sendMessage(m2);
                messageview.invalidate();
                messageview.setTextColor(android.graphics.Color.RED);

            } else {
                messageview.invalidate();
                messageview.setTextColor(android.graphics.Color.BLUE);
            }//System.out.print("acc===>>>"+AccQuan);
            Succ = all.getString("Succ");
            code = all.getString("Code");
            if (all.getString("Data").indexOf("尚") > -1){
                temp_glist=g_list2;
                tempurl=url;
                Message=all.getString("Data");
            }
            update_ui(all);
        } catch (Exception e) {
            CharArrayWriter cw = new CharArrayWriter();
            PrintWriter w = new PrintWriter(cw);
            e.printStackTrace(w);
            w.close();
            trace = cw.toString();
            e.printStackTrace();
            View rootView = getWindow().getDecorView().getRootView();
            send_urlsting(rootView);
            e.printStackTrace();
        }
        startflig = 1;
        accident.setText("刪除");
        sptest.setVisibility(VISIBLE);
        testbutton.setVisibility(VISIBLE);
        test.setVisibility(VISIBLE);
        int i = 0;
        while (true) {
            if (i == 9) {
                break;
            }
            try {
                Thread.sleep(1000);
                i++;
                //開始訊息
                if (popMsg != null && !popMsg.equals("") && conf_flag != null) {
                    tempurl=url;
                    if (conf_flag.indexOf("2") > -1|| Message.indexOf("尚有餘料") > -1) { //需要確認
                        conf_flag = "0";
                        ShowpopMsg_confrn(view);//confrn popup
                        break;
                    } else if (conf_flag.indexOf("1") > -1) { //停止                                   //
                        conf_flag = "0";
                        ShowpopMsg_stop(view);//confrn popup
                        break;
                    } else {  //不須確認
                        popMsg = popMsg.replaceAll("\",\"", "\r\n");
                        popMsg = popMsg.replaceAll("\\[", "");
                        popMsg = popMsg.replaceAll("\"", "");
                        popMsg = popMsg.replaceAll("\\]", "");
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                        builder2.setMessage("製程注意事項\r\n" + popMsg + dy_msgdy_msg);
                        builder2.setCancelable(false);
                        builder2.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                        if ((!popMsg.equals("mull") && !dy_msgdy_msg.equals("mull"))
                                || (!popMsg.equals("") && !dy_msgdy_msg.equals(""))) {

                        } else {
                            Button info_bnt = (Button) findViewById(R.id.info_bnt);
                            info_bnt.setVisibility(GONE);
                            info_bnt.performClick();
                            //builder2.show();
                        }
                        break;
                    }
                } else {  //不須確認
                    if (Message.indexOf("失敗") > -1) {
                        secmod = 0;
                        accident.setVisibility(VISIBLE);
                        accident.setText("開始");          //  6213559680000
                        accident_text.setVisibility(INVISIBLE);
                        sptest.setVisibility(INVISIBLE);
                        part_finish_bnt.setVisibility(INVISIBLE);
                        test.setVisibility(INVISIBLE);
                        startflig = 0; // 機台狀態    已經開始為 1  尚未開始為0
                    }
                }
                if (Message.indexOf("錯誤") > -1 || Message.indexOf("無法") > -1) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage(Message);
                    builder.setCancelable(false);
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //
                        }
                    });
                    //builder.show();
                    if (Message.indexOf("再次啟動") > -1) {
                        testbutton.setVisibility(VISIBLE);
                        accident.setText("刪除");
                        startflig = 1;
                    }
                    break;
                }
                break;
            } catch (InterruptedException e) {

            }
        }
    }
    private void FlowStart_refull(View view) { // 全檢2檢重測 ： command=22 NGOptions=1 or 2
        try {
            String encodedUrl = "", encodedUr2 = "", encodedUr3 = "", encodedUr4 = "", encodedUr5 = "";
            userBar = userBar.replaceAll("\\*", "");
            encodedUrl = URLEncoder.encode(flowBar, "UTF-8");
            encodedUr2 = URLEncoder.encode(userBar, "UTF-8");
            encodedUr3 = URLEncoder.encode(machineBar, "UTF-8");
            encodedUr5 = URLEncoder.encode(FLOW_STEP, "UTF-8");
            if(Process.equals("全檢1") || Process.equals("全檢2")) {
                Process="花蓮全檢";
            }
            if(Process.equals("外檢1") || Process.equals("外檢2")) {
                Process="花蓮外檢";
            }
            encodedUr4 = URLEncoder.encode(Process, "UTF-8");
            String g_list2 = g_list.toString();
            call_rest restObj = new call_rest();
            g_list.put("colorUser", check_user);
            url = host + "PrdMgn/ScanOperate?command=22&UID=" +
                    encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3;

            if (!NGOptions.equals("")&& !NGOptions.equals("非重複性檢測"))
            {
                url=url+"&NGOptions=" +NGOptions;
            }

            if (ifLeader_forinput.equals("1")){
                url=url+"&confirmed=2";
                ifLeader_forinput="0";
            }
            url_stting = url + "&jsonStr=" + g_list2;
            System.out.println(url_stting);
            JSONObject rtnRestObj = restObj.postRest(url, g_list2);
            JSONObject all = new JSONObject(rtnRestObj.toString());
            Message = all.getString("Message");
            Succ = all.getString("Succ");
            code = all.getString("Code");
            if (all.getString("Data").length() > 10) {
                g_json_string = all.getString("Data");
                conf_flag = "n";
            } else {
                conf_flag = all.getString("Data");
            }
            Message = all.getString("Message");
            Succ = all.getString("Succ");
            code = all.getString("Code");
            update_ui(rtnRestObj);
            if (Message.indexOf("** 1-2") > -1 || Message.indexOf("** 2-12") > -1
                    || Message.indexOf("機台生產中") > -1 || Message.indexOf("機台使用中") > -1
            ) {//釋放機台
                View rootView = getWindow().getDecorView().getRootView();
                Message_confinsh(rootView);
            }
            if (Message.indexOf("錯誤") > -1 || Message.indexOf("無法") > -1) {
                Message m2 = new Message();
                m2.what = MEG_INVALIDATE;
                BUTThandler.sendMessage(m2);
                messageview.invalidate();
                messageview.setTextColor(android.graphics.Color.RED);
                update_ui(all);
            } else {
                messageview.invalidate();
                messageview.setTextColor(android.graphics.Color.BLUE);
            }//System.out.print("acc===>>>"+AccQuan);
        } catch (Exception e) {
            CharArrayWriter cw = new CharArrayWriter();
            PrintWriter w = new PrintWriter(cw);
            e.printStackTrace(w);
            w.close();
            trace = cw.toString();
            e.printStackTrace();
            View rootView = getWindow().getDecorView().getRootView();
            send_urlsting(rootView);
            e.printStackTrace();
        }
        startflig = 1;
        accident.setText("刪除");
        sptest.setVisibility(VISIBLE);
        part_finish_bnt.setVisibility(VISIBLE);
        testbutton.setVisibility(VISIBLE);
        test.setVisibility(VISIBLE);
    }
    private void FlowStart_re_d(View view) { // 外檢重驗底漆
        startf = 1;
        try {
            String encodedUrl = "", encodedUr2 = "", encodedUr3 = "", encodedUr4 = "", encodedUr5 = "";
            userBar = userBar.replaceAll("\\*", "");
            encodedUrl = URLEncoder.encode(flowBar, "UTF-8");
            encodedUr2 = URLEncoder.encode(userBar, "UTF-8");
            encodedUr3 = URLEncoder.encode(machineBar, "UTF-8");
            encodedUr5 = URLEncoder.encode(check_user, "UTF-8");
            g_list.put("colorUser", check_user);
            //if (Process.equals("花蓮外檢")) Process = "花蓮外檢";
            encodedUr4 = URLEncoder.encode("花蓮外檢", "UTF-8");
            String g_list2 = g_list.toString();
            call_rest restObj = new call_rest();
            if (Process.indexOf("外檢")>-1) {
                int command;
                command=29;// 外檢2重驗底漆
                url = host + "PrdMgn/ScanOperate?command="+command+"&UID=" +
                        encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3 +
                        "&subCommand=1";
                if (!encodedUr5.equals("")){//沒人員不代
                    url=url+"&preOperator=" + encodedUr5;
                }
                Process = "花蓮外檢";
            }
            if (Process.indexOf("外檢") > -1 && !NGOptions.equals("")){
                url=url+"&NGOptions=" +NGOptions;
            }
            url_stting = url + "&jsonStr=" + g_list2;
            if (ifLeader_forinput.equals("1")){
                url=url+"&confirmed=2";
                ifLeader_forinput="0";
            }
            if (!Process_SWT.equals("")){
                url=url+ "&optionDept=" + URLEncoder.encode("花蓮塗裝", "UTF-8");
            }
            JSONObject rtnRestObj = restObj.postRest(url, g_list2);
            JSONObject all = new JSONObject(rtnRestObj.toString());
            try {
                Thread.sleep(100); //1000為1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message = all.getString("Message");
            if (Message.indexOf("** 1-2") > -1 || Message.indexOf("** 2-12") > -1
                    || Message.indexOf("機台生產中") > -1 || Message.indexOf("機台使用中") > -1
            ) {//釋放機台
                View rootView = getWindow().getDecorView().getRootView();
                Message_confinsh(rootView);
            }
            Succ = all.getString("Succ");
            code = all.getString("Code");
            if (all.getString("Data").length() > 10) {
                g_json_string = all.getString("Data");
                conf_flag = "n";
            } else {
                conf_flag = all.getString("Data");
            }
            Message = all.getString("Message");
            Succ = all.getString("Succ");
            code = all.getString("Code");
            //update_ui(rtnRestObj);
            if (all.getString("Data").indexOf("尚") > -1){
                temp_glist=g_list2;
                tempurl=url;
                Message=all.getString("Data");

                //   break;
            }
            Message m = new Message();
            m.what = MEG_INVALIDATE;
            showm.sendMessage(m);
            if (Message.indexOf("錯誤") > -1 || Message.indexOf("無法") > -1) {
                Message m2 = new Message();
                m2.what = MEG_INVALIDATE;
                BUTThandler.sendMessage(m2);
                messageview.invalidate();
                messageview.setTextColor(android.graphics.Color.RED);
            } else {
                messageview.invalidate();
                messageview.setTextColor(android.graphics.Color.BLUE);
            }//System.out.print("acc===>>>"+AccQuan);
            update_ui(all);
        } catch (Exception e) {
            CharArrayWriter cw = new CharArrayWriter();
            PrintWriter w = new PrintWriter(cw);
            e.printStackTrace(w);
            w.close();
            trace = cw.toString();
            e.printStackTrace();
            View rootView = getWindow().getDecorView().getRootView();
            send_urlsting(rootView);
            e.printStackTrace();
        }
        startflig = 1;
        accident.setText("刪除");
        sptest.setVisibility(VISIBLE);
        if (Process.equals("花蓮切割") ) {
            part_finish_bnt.setVisibility(VISIBLE);
        } else {
            part_finish_bnt.setVisibility(INVISIBLE);
        }
        //part_finish_bnt.setVisibility(VISIBLE);
        testbutton.setVisibility(VISIBLE);
        test.setVisibility(VISIBLE);
        int i = 0;
        while (true) {
            if (i == 9) {
                break;
            }
            try {
                Thread.sleep(1000);
                i++;
                //開始訊息
                if (popMsg != null && !popMsg.equals("") && conf_flag != null) {
                    tempurl=url;
                    if (conf_flag.indexOf("2") > -1|| Message.indexOf("尚有餘料") > -1) { //需要確認
                        conf_flag = "0";
                        ShowpopMsg_confrn(view);//confrn popup
                        break;
                    } else if (conf_flag.indexOf("1") > -1) { //停止                                   //
                        conf_flag = "0";
                        ShowpopMsg_stop(view);//confrn popup
                        break;
                    } else {  //不須確認
                        popMsg = popMsg.replaceAll("\",\"", "\r\n");
                        popMsg = popMsg.replaceAll("\\[", "");
                        popMsg = popMsg.replaceAll("\"", "");
                        popMsg = popMsg.replaceAll("\\]", "");
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                        builder2.setMessage("製程注意事項\r\n" + popMsg + dy_msgdy_msg);
                        builder2.setCancelable(false);
                        builder2.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                        break;
                    }
                } else {  //不須確認
                    if (Message.indexOf("失敗") > -1) {
                        secmod = 0;
                        accident.setVisibility(VISIBLE);
                        accident.setText("開始");          //  6213559680000
                        accident_text.setVisibility(INVISIBLE);
                        sptest.setVisibility(INVISIBLE);
                        part_finish_bnt.setVisibility(INVISIBLE);
                        test.setVisibility(INVISIBLE);
                        startflig = 0; // 機台狀態    已經開始為 1  尚未開始為0
                    }
                }
                if (Message.indexOf("錯誤") > -1 || Message.indexOf("無法") > -1) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage(Message);
                    builder.setCancelable(false);
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //
                        }
                    });
                    builder.show();
                    if (Message.indexOf("再次啟動") > -1) {
                        testbutton.setVisibility(VISIBLE);
                        accident.setText("刪除");
                        startflig = 1;
                    }
                    break;
                }
                break;
            } catch (InterruptedException e) {

            }
        }
    }

    private void ShowpopMsg(View view) {
        if (popMsg == null || popMsg.equals("null") || popMsg.equals("")) {

        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage(popMsg);
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
            builder.show();
        }
    }
    private void ShowpopMsg_confrn(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        if (Message.indexOf("尚有餘料") > -1){
            Message="切割尚有餘料未完成，請問是否繼續開始新製程?";

        }
        builder.setMessage(Message);
        builder.setCancelable(false);
        if (Message.indexOf("** 1-2") > -1 || Message.indexOf("** 2-12") > -1) {
            View rootView = getWindow().getDecorView().getRootView();
            Message_confinsh(rootView);
        }else {

            builder.setPositiveButton("確認1", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    try {
                        String g_list2 = temp_glist.toString();
                        g_list = new JSONObject(g_list2);
                        call_rest restObj = new call_rest();
                        System.out.println("confirmed1");
                        System.out.println("confirmed0"+tempurl+
                                "01"+url+temp_glist);
                        url = tempurl + "&confirmed=3";
                        System.out.println("confirmed2>>>>>>>"+url+temp_glist);

                        JSONObject rtnRestObj = restObj.postRest(url, temp_glist);
                        JSONObject all = null;
                        all = new JSONObject(rtnRestObj.toString());
                        Message = all.getString("Message");
                        Succ = all.getString("Succ");
                        code = all.getString("Code");
                        if (Message.indexOf("錯誤") > -1 || Message.indexOf("無法") > -1) {
                            Message m2 = new Message();
                            m2.what = MEG_INVALIDATE;
                            BUTThandler.sendMessage(m2);
                            messageview.invalidate();
                            messageview.setTextColor(android.graphics.Color.RED);
                        } else {
                            messageview.invalidate();
                            messageview.setTextColor(android.graphics.Color.BLUE);
                        }//System.out.print("acc===>>>"+AccQuan);
                        update_ui(all);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }catch (Exception e) {
                        CharArrayWriter cw = new CharArrayWriter();
                        PrintWriter w = new PrintWriter(cw);
                        e.printStackTrace(w);
                        w.close();
                        trace = cw.toString();
                        e.printStackTrace();
                        View rootView = getWindow().getDecorView().getRootView();
                        send_urlsting(rootView);
                        e.printStackTrace();
                    }
                    //20200709 remove
                    Button button3 = (Button) findViewById(R.id.button3);
                    testnbnnt.performClick();//locoltest button
                }
            });
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    try {
                        String g_list2 = temp_glist.toString();
                        g_list = new JSONObject(g_list2);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }catch (Exception e) {
                        CharArrayWriter cw = new CharArrayWriter();
                        PrintWriter w = new PrintWriter(cw);
                        e.printStackTrace(w);
                        w.close();
                        trace = cw.toString();
                        e.printStackTrace();
                        View rootView = getWindow().getDecorView().getRootView();
                        send_urlsting(rootView);
                        e.printStackTrace();
                    }
                    testnbnnt.performClick();//locoltest button
                }
            });
            builder.show();}

    }

    private void ShowpopMsg_stop(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage(conf_flag);
        builder.setCancelable(false);
        if (Message.indexOf("2-17") > -1) {
            View rootView = getWindow().getDecorView().getRootView();
            Message_show(rootView);
        }
        builder.setPositiveButton("4確認", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Button button3 = (Button) findViewById(R.id.button3);
                button3.performClick();//locoltest button
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        if (Message.indexOf("currNaiBei") > -1) {

        }else{
            builder.show();
        }
    }

    private void ok_start(View view) {//確認送出
        AlertDialog.Builder builder4 = new AlertDialog.Builder(MainActivity.this);
        builder4.setMessage("確認送出\r\n" + popMsg);
        builder4.setCancelable(false);
        builder4.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                try {
                    userBar = userBar.replaceAll("\\*", "");
                    String g_list2 = g_list.toString();
                    call_rest restObj = new call_rest();
                    JSONObject rtnRestObj = restObj.postRest(url, g_list2);
                    g_json_string = rtnRestObj.getString("Data");
                    Message = rtnRestObj.getString("Message");
                    Succ = rtnRestObj.getString("Succ");
                    code = rtnRestObj.getString("Code");
                    update_ui(rtnRestObj);
                } catch (Exception e) {
                    CharArrayWriter cw = new CharArrayWriter();
                    PrintWriter w = new PrintWriter(cw);
                    e.printStackTrace(w);
                    w.close();
                    trace = cw.toString();
                    e.printStackTrace();
                    View rootView = getWindow().getDecorView().getRootView();
                    send_urlsting(rootView);
                    e.printStackTrace();
                }

            }
        });
        builder4.show();
    }

    public void exit_start(View view) {
        logout_flag=1;
        myUnfinishedRecords(view);
    //exit_start
    }
    public void exit(View view) {
        final String print_url;
                        try {
                            String encodedUrl2 = "", encodedUrl3 = "";
                            if (!(userBar.indexOf("*") > -1)) {
                                userBar = "*" + userBar;
                            }
                            encodedUrl2 = URLEncoder.encode(userBar, "UTF-8");
                            encodedUrl3 = URLEncoder.encode(Process, "UTF-8");//製程
                            //user Logout start
                            url_stting = host + "PrdMgn/Logout?userBar=" + encodedUrl2 + "&Dept=" + encodedUrl3 +"&shiftName="+logouttype;
                            if (!coworker_bar.equals("")){
                                url_stting=url_stting+"&coworker=" +coworker_bar;
                            }
                            final call_rest restObj = new call_rest();
                            JSONObject rtnRestObj = restObj.callRest(url_stting);
                            exitMessage = rtnRestObj.getString("Data");
                            if (exitMessage.indexOf("登出完成") > -1 ||exitMessage.equals("") || Process.equals("花蓮電鍍")) {
                                userBar = userBar.replaceAll("\\*", "");
                                print_url=host + "PrdMgn/printDailyReport?flowStep="+encodedUrl3+"&empID="+userBar
                                        +"&shiftName="+logouttype;
                                System.out.println(print_url);
                                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                                builder.setMessage("是否列印報表?")
                                        .setPositiveButton("是", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                // TODO Auto-generated method stub
                                                call_rest restObj = new call_rest();
                                                JSONObject rtnRestObj1 = restObj.callRest(print_url);
                                                try {
                                                    exitMessage = rtnRestObj1.getString("Data");
                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                }
                                                Intent i1 = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                                                i1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                SharedPreferences remdname = getPreferences(Activity.MODE_PRIVATE);
                                                SharedPreferences.Editor edit = remdname.edit();
                                                edit.putString("last_user", "");//正常登出清除最後使用者，app重開後無[閃退重登]button
                                                edit.putString("coworker", "");
                                                edit.commit();
                                                startActivity(i1);//restart app
                                            }
                                        })
                                        .setNegativeButton("否", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                // TODO Auto-generated method stub
                                                Intent i1 = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                                                i1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                SharedPreferences remdname = getPreferences(Activity.MODE_PRIVATE);
                                                SharedPreferences.Editor edit = remdname.edit();
                                                edit.putString("last_user", "");//正常登出清除最後使用者，app重開後無[閃退重登]button
                                                edit.putString("coworker", "");
                                                edit.commit();
                                                startActivity(i1);//restart app
                                            }
                                        });
                                AlertDialog about_dialog = builder.create();
                                about_dialog.show();
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                if (exitMessage.indexOf("流程單未完成")>-1){
                                    exitMessage=exitMessage+"\nLịch trình (tờ  đơn hàng  )  vẫn chưa hoàn thành , xin xác nhận rõ rồi nhấn nút đăng xuất.";
                                }
                                builder.setMessage(exitMessage);
                                builder.setCancelable(false);
                                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {

                                    }
                                });
                                builder.show();
                            }
                        } catch (Exception e) {
                            CharArrayWriter cw = new CharArrayWriter();
                            PrintWriter w = new PrintWriter(cw);
                            e.printStackTrace(w);
                            w.close();
                            trace = cw.toString();
                            e.printStackTrace();
                            View rootView = getWindow().getDecorView().getRootView();
                            send_urlsting(rootView);
                            e.printStackTrace();
                        }
    }

    public void exitold(View view) {
        new AlertDialog.Builder(MainActivity.this).setTitle("確認視窗").setMessage("確定要結束應用程式嗎?").setPositiveButton("確定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            String encodedUrl2 = "", encodedUrl3 = "";
                            if (!(userBar.indexOf("*") > -1)) {
                                userBar = "*" + userBar;
                            }
                            encodedUrl2 = URLEncoder.encode(userBar, "UTF-8");
                            encodedUrl3 = URLEncoder.encode(Process, "UTF-8");//製程
                            //user Logout start
                            url_stting = host + "PrdMgn/Logout?userBar=" + encodedUrl2 + "&Dept=" + encodedUrl3;
                            call_rest restObj = new call_rest();
                            JSONObject rtnRestObj = restObj.callRest(url_stting);
                            exitMessage = rtnRestObj.getString("Data");
                            if (exitMessage.indexOf("登出完成") > -1 ||exitMessage.equals("") || Process.equals("花蓮電鍍")) {
                                Intent i1 = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                                i1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                SharedPreferences remdname = getPreferences(Activity.MODE_PRIVATE);
                                SharedPreferences.Editor edit = remdname.edit();
                                edit.putString("last_user", "");
                                edit.commit();

                                startActivity(i1);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage(exitMessage);
                                builder.setCancelable(false);
                                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {

                                    }
                                });
                                builder.show();

                            }
                        } catch (Exception e) {
                            CharArrayWriter cw = new CharArrayWriter();
                            PrintWriter w = new PrintWriter(cw);
                            e.printStackTrace(w);
                            w.close();
                            trace = cw.toString();
                            e.printStackTrace();
                            View rootView = getWindow().getDecorView().getRootView();
                            send_urlsting(rootView);
                            e.printStackTrace();
                        }
                    }
                }
        )
                .setNegativeButton("取消",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                            }
                        }).show();
    }

    public void setting(View view) {//設定畫面
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        final View v = inflater.inflate(R.layout.setting, null);   //   get viwe layout\
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        TextView title = new TextView(this);
        title.setText("變更IP");
        final EditText ipe = (EditText) v.findViewById(R.id.ip);
        Button settinghide = (Button) v.findViewById(R.id.settinghide);
        Button bnt_reset_flow = (Button) v.findViewById(R.id.bnt_reset_flow);
        Button reset_mid = (Button) v.findViewById(R.id.reset_mid);
        reset_mid.setText("將"+machineBar+"設回待機");
        EditText error_range_tv = (EditText) v.findViewById(R.id.eg);
        if(Process.indexOf("切割")>-1||ifLeader.equals("1")){//切割或掃過見證人顯示將此單修改為未完成
            bnt_reset_flow.setVisibility(v.VISIBLE);
        }else{
            bnt_reset_flow.setVisibility(v.INVISIBLE);
        }
        if (//cpuInfo.contains("intel") ||
                ifLeader.equals("1")){//組長或模擬器顯示設定選項
            settinghide.setVisibility(v.INVISIBLE);
        }else {
            settinghide.setVisibility(v.VISIBLE);
        }
        Spinner dept = (Spinner) v.findViewById(R.id.dept);
        dept.setSelection(((ArrayAdapter<String>)dept.getAdapter()).getPosition(Process));

        RadioGroup facroryNo_g = (RadioGroup) v.findViewById(R.id.facroryNo_g);
        if (facroryNo==2)
        {
            ((RadioButton)facroryNo_g.getChildAt(1)).setChecked(true);
        }else{
            ((RadioButton)facroryNo_g.getChildAt(0)).setChecked(true);
        }
        RadioGroup rg2 = (RadioGroup) v.findViewById(R.id.rg2);
        if (camera_str==1)
        {
            ((RadioButton)rg2.getChildAt(0)).setChecked(true);
        }else{
            ((RadioButton)rg2.getChildAt(1)).setChecked(true);
        }
        SharedPreferences saveip = getPreferences(Activity.MODE_PRIVATE);
        SharedPreferences saveC = getPreferences(Activity.MODE_PRIVATE);
        SharedPreferences kamera_id = getPreferences(Activity.MODE_PRIVATE);
        ipe.setText(ip_str);
        error_range_tv.setText(error_range);
        //ipe.setFocusable(false);// ip不能改
        reset_mid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                call_rest restObj = new call_rest();
                String encodedUr3 = URLEncoder.encode(Process, "UTF-8");
                url = host + "PrdMgn/ScanOperate?command=10&UID=" + userBar + "&flowBar=" + flowBar +
                        "&DEPT=" + encodedUr3 + "&MID=" + machineBar + "&mStatus=0";
                JSONObject rtnRestObj2 = restObj.callRest(url);

                    JSONObject all = new JSONObject(rtnRestObj2.toString());
                    Message = all.getString("Message");
                } catch (Exception e) {
                }
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.imageView8);
        title.setGravity(Gravity.CENTER);
        title.setTextSize(24);
        dialog.setCustomTitle(title);
        dialog.setView(v);
        dialog.setPositiveButton("送出", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SharedPreferences remdname = getPreferences(Activity.MODE_PRIVATE);
                SharedPreferences.Editor edit = remdname.edit();
                EditText ip = (EditText) v.findViewById(R.id.ip);
                edit.putString("ip", ip.getText().toString());
                ip_str=ip.getText().toString();
                edit.commit();
                host = "http://" + ip.getText().toString() + "/";
                if (host.indexOf("211")>-1 ||host.indexOf("192")>-1){
                host= "http://"+ip_str+"/firstohmWebApi/";
                }
                host= "http://"+ip_str+"/firstohmWebApi/";
                Spinner dept = (Spinner) v.findViewById(R.id.dept);
                CheckBox checkBox_start_edit=(CheckBox) v.findViewById(R.id.checkBox_start_edit);
                Process = dept.getSelectedItem().toString();
                edit.putString("Process", Process);
                edit.commit();
                TextView version = (TextView) findViewById(R.id.version);
                if (Process.equals("選擇部門")) Process = "未設定";
                edit.putInt("facroryNo", facroryNo);
                edit.commit();
                version.setText("Version. " + now_version + "\n廠區:" + facroryNo + " : " + Process);
                RadioGroup ticketType = (RadioGroup) v.findViewById(R.id.rg);
                switch (ticketType.getCheckedRadioButtonId()) {
                    case R.id.r_radio:
                        COLOR_inverse = 0;
                        break;
                    case R.id.l_radio:
                        COLOR_inverse = 1;
                        break;
                }
                edit.putInt("COLOR_inverse", COLOR_inverse);
                edit.commit();
                RadioGroup ticketType2 = (RadioGroup) v.findViewById(R.id.rg2);
                switch (ticketType2.getCheckedRadioButtonId()) {
                    case R.id.mcamera:
                        camera_str = 1;
                        edit.commit();
                        version.setText("Version. " + now_version + "\n廠區:" + facroryNo + " : " + Process);
                        break;
                    case R.id.ucamera:
                        camera_str = 0;
                        edit.commit();
                        version.setText("Version. " + now_version + "\n廠區:" + facroryNo + " : " + Process);
                        break;
                }
                edit.putInt("camera_str", camera_str);
                edit.commit();
                RadioGroup facroryNo_g = (RadioGroup) v.findViewById(R.id.facroryNo_g);
                switch (facroryNo_g.getCheckedRadioButtonId()) {
                    case R.id.facroryNo_g1:
                        facroryNoT = "1廠";
                        facroryNo = 1;
                        edit.putInt("facroryNo", facroryNo);
                        edit.commit();
                        version.setText("Version. " + now_version + "\n廠區:" + facroryNo + " : " + Process);
                        break;
                    case R.id.facroryNo_g2:
                        facroryNoT = "2廠";
                        facroryNo = 2;
                        edit.putInt("facroryNo", facroryNo);
                        edit.commit();
                        version.setText("Version. " + now_version + "\n廠區:" + facroryNo + " : " + Process);
                        break;
                }
                if (checkBox_start_edit.isChecked()){
                    start_edit=1;
                }else{
                    start_edit=0;
                }edit.putInt("start_edit", start_edit);
                edit.commit();
                EditText eg = (EditText) v.findViewById(R.id.eg);
                if (!eg.getText().toString().equals("")){
                    error_range=eg.getText().toString();
                    edit.putString("error_range", eg.getText().toString());
                    edit.commit();
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
        params.width = 1200;
        params.height = 700;
        //button text size
        dlg.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
        dlg.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
        dlg.getWindow().setAttributes(params);
    }

    public void FlowStart(View view) {
    }

    public void testnbnnt(View view) {
        getu = (Button) findViewById(R.id.getu);
        if (userBar.equals("")) {
            userBar = tempu;
        } else {
            tempu = userBar;
        }
        getu.performClick();
        ImageView imageView8 = (ImageView) findViewById(R.id.imageView8);
        imageView8.setVisibility(INVISIBLE);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setVisibility(INVISIBLE);
        Button accident = (Button) findViewById(R.id.accident);
        Button sptest = (Button) findViewById(R.id.sptest);
        Button test = (Button) findViewById(R.id.test);
        Button button4 = (Button) findViewById(R.id.button4);
        Button logout = (Button) findViewById(R.id.logout);
        TextView version = (TextView) findViewById(R.id.version);
        version.setVisibility(INVISIBLE);
        getg = (Button) findViewById(R.id.getg);
        button4.setVisibility(VISIBLE);
        accident.setVisibility(VISIBLE);
        accident_text.setVisibility(VISIBLE);
        logout.setVisibility(VISIBLE);
        imageView8.setVisibility(INVISIBLE);
        if (flowBar.equals("")) {
        } else {
            getg.performClick();
        }
    }

    public void update() {
        String VERSION_NAME = BuildConfig.VERSION_NAME;
        check_ver = 0;
        now_version = VERSION_NAME;
        final String[] getLatestVersion = {""};
        Thread thread_ver = new Thread(new Runnable() {
            public void run() {
                try {
                    URLConnection connection = (new URL(MainActivity.host + "appver.html")).openConnection();
                    connection.setConnectTimeout(15000);
                    connection.setReadTimeout(15000);
                    connection.connect();
                    InputStream in = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder html = new StringBuilder();
                    for (String line; (line = reader.readLine()) != null; ) {
                        html.append(line);
                    }
                    MainActivity.new_version = html.toString();
                    getLatestVersion[0] = html.toString();
                    in.close();
                    if (!getLatestVersion[0].equals("")) {
                        if (now_version.equals(getLatestVersion[0])) {
                        } else {
                            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                            dialog.setTitle("更新"); //設定dialog 的title顯示內容
                            Looper.prepare();
                            dialog.setPositiveButton("是", new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent();
                                    intent.setAction(Intent.ACTION_VIEW);
                                    intent.setData(Uri.parse(host + "firstohm.apk"));
                                    startActivity(intent);
                                    android.os.Process.killProcess(android.os.Process.myPid());
                                    System.exit(1);
                                }
                            });
                            dialog.show();
                            Looper.loop();
                        }
                    }
                } catch (Exception e) {
                    CharArrayWriter cw = new CharArrayWriter();
                    PrintWriter w = new PrintWriter(cw);
                    e.printStackTrace(w);
                    w.close();
                    trace = cw.toString();
                    e.printStackTrace();
                    //View rootView = getWindow().getDecorView().getRootView();
                    //send_urlsting(rootView);
                    e.printStackTrace();
                }
            }
        });
        thread_ver.start();
    }

    public void localtest(View view) {
        Message mlo = new Message();
        mlo.what = MEG_INVALIDATE;
        loading1.sendMessage(mlo);
        userBar = "C_004";
        host= "http://172.168.1.151:1119/firstohmWebApi/";
        //host= "http://172.168.1.33:1111/firstohmWebApi/";//172.33 test server
        if ((cpuInfo.contains("intel") || cpuInfo.contains("amd"))){
            cpuInfo="intel";
            ifLeader = "1";
            host= "http://172.168.1.151:1119/firstohmWebApi/";
            ifLeader_forinput = "0";
            //userBar = "B_040";
            //userBar = "*B_077";
            //host= "http://"+ip_str+"/firstohmWebApi/";
            //host= "http://172.168.1.151:1119/firstohmWebApi/";//172.33 test server
            //flowBar = "13112-1-2036488-0-%";
            flowBar = "23413-4-2065508-0-%";
            //host= "http://220.128.234.48:1119/";
            //host= "http://211.23.138.230:1119/firstohmwebapi/";
            ////////////////
        }
        getu = (Button) findViewById(R.id.getu);
        getu.performClick();
        ImageView imageView8 = (ImageView) findViewById(R.id.imageView8);
        imageView8.setVisibility(INVISIBLE);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setVisibility(INVISIBLE);
        Button accident = (Button) findViewById(R.id.accident);
        Button sptest = (Button) findViewById(R.id.sptest);
        Button test = (Button) findViewById(R.id.test);
        Button button4 = (Button) findViewById(R.id.button4);
        Button logout = (Button) findViewById(R.id.logout);
        TextView version = (TextView) findViewById(R.id.version);
        version.setVisibility(INVISIBLE);
        getg = (Button) findViewById(R.id.getg);
        button4.setVisibility(VISIBLE);
        accident.setVisibility(VISIBLE);
        accident_text.setVisibility(VISIBLE);
        sptest.setVisibility(VISIBLE);
        if (Process.equals("花蓮切割") ){
            part_finish_bnt.setVisibility(VISIBLE);
        }else {
            part_finish_bnt.setVisibility(INVISIBLE);
        }
        logout.setVisibility(VISIBLE);
        imageView8.setVisibility(INVISIBLE);
        if (flowBar.equals("")) {
        } else {
            getg.performClick();
        }

    }

    public void check_info(View view) {
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        final View vc = inflater.inflate(R.layout.info, null);   //   get viwe layout
        final AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        TextView title = new TextView(this);
        title.setText("機台訊息");
        final AlertDialog alertDialog = dialog.create();
        TextView infotext = (TextView) vc.findViewById(R.id.infotext);
        try {
            popMsg = popMsg.replaceAll("\",\"", "\r\n");
            popMsg = popMsg.replaceAll("\\[", "");
            popMsg = popMsg.replaceAll("\"", "");
            popMsg = popMsg.replaceAll("\\]", "");
            if (popMsg.indexOf("mull") > -1 && dy_msgdy_msg.indexOf("mull") > -1) {
                dy_msgdy_msg = dy_msgdy_msg.replaceAll("\",\"", "\r\n");
                dy_msgdy_msg = dy_msgdy_msg.replaceAll(",", "\r\n");
                dy_msgdy_msg = dy_msgdy_msg.replaceAll("\\[", "");
                dy_msgdy_msg = dy_msgdy_msg.replaceAll("\"", "");
                dy_msgdy_msg = dy_msgdy_msg.replaceAll("\\]", "");
            }
            String text = "";
            if (popMsg.indexOf("mull") > -1) {
            } else {
                text = popMsg;
            }
            if (dy_msgdy_msg.indexOf("mull") > -1) {
            } else {
                text = popMsg + dy_msgdy_msg;
            }
            text = text.replaceAll("null", "");
            text = text.replaceAll("\",\"", "\r\n");
            text = text.replaceAll(",", "\r\n");
            text = text.replaceAll("\\[", "");
            text = text.replaceAll("\"", "");
            text = text.replaceAll("\\]", "");
            infotext.setText("製程注意事項\r\n" + text);
            DialogInterface.OnClickListener OkClick = new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            };
            if (text.indexOf("mull") > -1 || text.equals("")|| text.indexOf("currNaiBei")>-1) {
            } else {
                title.setGravity(Gravity.CENTER);
                title.setTextSize(24);
                dialog.setCustomTitle(title);
                dialog.setView(vc);
                dialog.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                //.if(popMsg.indexOf("mull") > -1  &&dy_msgdy_msg.indexOf("mull") > -1) {
                AlertDialog dlg = dialog.show();
                WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
                //params.width = 1000;
                params.height = 800;
                dlg.getWindow().setAttributes(params);
                //}
            }
        } catch (Exception e) {
            CharArrayWriter cw = new CharArrayWriter();
            PrintWriter w = new PrintWriter(cw);
            e.printStackTrace(w);
            w.close();
            trace = cw.toString();
            e.printStackTrace();
            View rootView = getWindow().getDecorView().getRootView();
            send_urlsting(rootView);
            e.printStackTrace();
        }
    }

    public void Supervisor_check(View view) {
        //見證
        //res_witness="B_005";
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    String encodedUrl = "", encodedUr2 = "", encodedUr3 = "", encodedUr4 = "";
                    encodedUrl = URLEncoder.encode(flowBar, "UTF-8");
                    encodedUr2 = URLEncoder.encode(res_witness, "UTF-8");
                    encodedUr4 = URLEncoder.encode(machineBar, "UTF-8");
                    encodedUr3 = URLEncoder.encode(Process, "UTF-8");
                    call_rest restObj = new call_rest();
                    JSONObject rtnRestObj2 = restObj.callRest(host + "PrdMgn/Witness?UID=" + encodedUr2 + "&flowBar=" + encodedUrl
                            + "&DEPT=" + encodedUr3 + "&MID=" + encodedUr4+"&ifLeader=0");
                    //update_ui(rtnRestObj);
                    JSONObject all = new JSONObject(rtnRestObj2.toString());
                    Message = all.getString("Message");
                    String Data = all.getString("Data");
                    Succ = rtnRestObj2.getString("Succ");
                    code = rtnRestObj2.getString("Code");ifLeader_forinput = "1";
                    if (Message.equals("通過見證人驗證")) {
                        ifLeader = "1";ifLeader_forinput = "1";
                    }
                    if (Data.indexOf("無此")>-1) {
                    }else{
                        ifLeader_forinput = "1";
                    }
                    Message m = new Message();
                    m.what = MEG_INVALIDATE;
                    superv_sance.sendMessage(m);
                } catch (Exception e) {
                    CharArrayWriter cw = new CharArrayWriter();
                    PrintWriter w = new PrintWriter(cw);
                    e.printStackTrace(w);
                    w.close();
                    trace = cw.toString();
                    e.printStackTrace();
                    View rootView = getWindow().getDecorView().getRootView();
                    send_urlsting(rootView);
                    e.printStackTrace();
                }
            }
        });

        res_witness = res_witness.replaceAll("\\*", "");
        userBar = userBar.replaceAll("\\*", "");
        if (!userBar.equals(res_witness)){
            thread.start();  //user info
            check_scan = 0;
            int ii = 0;
            while (true) {
                try {
                    Thread.sleep(1000);
                    ii++;
                    if (!Message.equals("")) {
                        messageview.setText("訊息:" + Message);
                        break;
                    }
                    if (ii == 3) {  //9秒退出
                        break;
                    }
                } catch (InterruptedException e) {

                    CharArrayWriter cw = new CharArrayWriter();
                    PrintWriter w = new PrintWriter(cw);
                    e.printStackTrace(w);
                    w.close();
                    trace = cw.toString();
                    e.printStackTrace();
                    View rootView = getWindow().getDecorView().getRootView();
                    send_urlsting(rootView);
                }
            }
        }else
        {
            messageview.setText("訊息:見證人不能為自己");
        }
    }

    public void getinfo(View view) {
        if(Process.equals("花蓮貼帶")) {
            RadioGroup TieDaigroup=(RadioGroup) findViewById(R.id.TieDaigroup);
            ((RadioButton)TieDaigroup.getChildAt(0)).setChecked(true);
            RadioGroup tied_f_group=(RadioGroup) findViewById(R.id.tied_f_group);
            ((RadioButton)tied_f_group.getChildAt(0)).setChecked(true);

        }
        try {
            String encodedUr2 = "", encodedUr3 = "", encodedUr4 = "";
            userBar = userBar.replaceAll("\\*", "");
            encodedUr2 = URLEncoder.encode(userBar, "UTF-8");
            encodedUr3 = URLEncoder.encode(machineBar, "UTF-8");
            if(Process.equals("全檢1") || Process.equals("全檢2")) {
                Process="花蓮全檢";
            }
            if(Process.equals("外檢1") || Process.equals("外檢2")) {
                Process="花蓮外檢";
            }
            encodedUr4 = URLEncoder.encode(Process, "UTF-8");
            if (!Process_SWT.equals(""))
            {
                encodedUr4 = URLEncoder.encode("花蓮塗裝", "UTF-8");

            }
            String command="8";
            if(Process.equals("花蓮貼帶")) {
                command="38";
            }
            if(Process.equals("花蓮外檢")) {
                command="48";
            }
            url_stting = host + "PrdMgn/ScanOperate?command="+command+"&UID=" + encodedUr2 +"&DEPT="+encodedUr4+"&MID="+encodedUr3;
            call_rest restObj = new call_rest();
            JSONObject rtnRestObj = restObj.callRest(url_stting);
            fillGldPent(rtnRestObj, view);
        } catch (Exception e) {
            CharArrayWriter cw = new CharArrayWriter();
            PrintWriter w = new PrintWriter(cw);
            e.printStackTrace(w);
            w.close();
            trace = cw.toString();
            e.printStackTrace();
            View rootView = getWindow().getDecorView().getRootView();
            //send_urlsting(rootView);
        }
    }

    public void views(View view) {  //查詢
        final String[] EMPNAME = new String[1];
        final String[] testcount = {""};
        final ArrayList<String> mylist = new ArrayList<String>();
        Thread thread_ver = new Thread(new Runnable() {
            public void run() {
                try {
                    String encodedUrl = "", encodedUr2 = "",Process_test="";
                    if (Process.indexOf("全") > -1 ){
                        Process_test="花蓮全檢";
                    }else{
                        Process_test=Process;
                    }
                    encodedUrl = URLEncoder.encode(Process_test, "UTF-8");
                    encodedUr2 = URLEncoder.encode(flowBar, "UTF-8");
                    call_rest restObj = new call_rest();
                    JSONObject rtnRestObj = restObj.callRest(host + "PrdMgn/GetFlowTestByStep?flowBar=" + encodedUr2 + "&FlowStep=" + encodedUrl);
                    JSONArray array = new JSONArray(rtnRestObj.getString("Data"));
                    testdata = "";
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject jsonObject = array.getJSONObject(i);
                        String EMPNAME = jsonObject.getString("EMPNAME");
                        String MachineID = jsonObject.getString("MachineID");
                        String Testset = jsonObject.getString("Testset");
                        String Test_Dept = jsonObject.getString("Dept");
                        String validat_bottom = jsonObject.getString("validat_bottom");
                        String validat_top = jsonObject.getString("validat_top");
                        String testCnt1 = jsonObject.getString("testCnt");
                        String inValidCnt = jsonObject.getString("inValidCnt");
                        String Created = jsonObject.getString("Created");
                        String ExtraInfo = jsonObject.getString("ExtraInfo");
                        String ExtraValue = jsonObject.getString("ExtraValue");
                        String testNote_value = jsonObject.getString("testNote");
                        if (!ExtraInfo.equals("null")) {
                            if (ExtraInfo.indexOf("%E9%90%B5%E5%B8%BD") > -1 || ExtraInfo.indexOf("%25E9%2590%25B5") > -1){
                                ExtraInfo = " 鐵帽尺寸 ";
                        } else {
                                ExtraInfo = "";
                                ExtraValue = "";
                            }
                        }
                        if (!testNote_value.equals("null")) {
                            if (testNote_value.indexOf("%E5%8A%A0%E5%A3%93%E5%89%8D") > -1 )
                                testNote_value = "加壓前";
                            else if (testNote_value.indexOf("%E5%8A%A0%E5%A3%93%E5%BE%8C") > -1 )
                                testNote_value = "加壓後";
                            else
                                testNote_value = "";
                        } else {
                            testNote_value = "";
                        }

                        testdata = testdata + EMPNAME + "\t" + "\t" + "\t" + MachineID + "\t" + "\t" + "\t" + Testset + "\n";
                        mylist.add("姓名:" + EMPNAME + "\t\t\t" + Test_Dept + ":" + MachineID + "\t\t\t" + "測試次數:" + testCnt1 +
                                "\n下限:" + validat_bottom + "\t\t\t\t上限:" + validat_top + "\t\t\t" +
                                "不合格數:" + inValidCnt + "\n測試時間" + Created + "\t" + ExtraInfo + ExtraValue + testNote_value+"\n" + "測試數據:" + Testset + "\n");
                    }
                    mylist.add( ""               );
                } catch (Exception e) {
                    CharArrayWriter cw = new CharArrayWriter();
                    PrintWriter w = new PrintWriter(cw);
                    e.printStackTrace(w);
                    w.close();
                    trace = cw.toString();
                    e.printStackTrace();
                    View rootView = getWindow().getDecorView().getRootView();
                    send_urlsting(rootView);
                    e.printStackTrace();
                }
            }
        });
        if(flowBar.equals("")){

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("未掃描工令單");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
            builder.show();
        }else {

            thread_ver.start();  //thread_ver
            int i = 0;
            while (true) {
                try {
                    Thread.sleep(200);
                    i++;
                    LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                    final View v = inflater.inflate(R.layout.views, null);   //   get viwe layout\
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    ListView listview = (ListView) v.findViewById(R.id.dynamic);
                    TextView title = new TextView(this);
                    title.setText("本流程單檢驗查詢");
                    ArrayAdapter adapter = new ArrayAdapter(this,
                            android.R.layout.simple_list_item_1,
                            mylist) {
                        @Override
                        public View getView(int position, View convertView, ViewGroup parent) {
                            View view = super.getView(position, convertView, parent);
                            TextView tv = (TextView) view.findViewById(android.R.id.text1);
                            tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
                            return view;
                        }
                    };
                    listview.setAdapter(adapter);
                    if (testcount[0].indexOf("查無") > -1) {
                        testcount[0] = "查無測試資料";
                    }
                    title.setGravity(Gravity.CENTER);
                    title.setTextSize(24);
                    dialog.setCustomTitle(title);
                    dialog.setView(v);
                    dialog.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //mothing
                        }
                    });
                    AlertDialog dlg = dialog.show();
                    WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
                    //視窗長寬
                    params.width = 1200;
                    params.height = 600;
                    //button text size
                    dlg.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
                    dlg.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
                    dlg.getWindow().setAttributes(params);
                    break;
                } catch (InterruptedException e) {
                    CharArrayWriter cw = new CharArrayWriter();
                    PrintWriter w = new PrintWriter(cw);
                    e.printStackTrace(w);
                    w.close();
                    trace = cw.toString();
                    e.printStackTrace();
                    View rootView = getWindow().getDecorView().getRootView();
                    send_urlsting(rootView);

                }
            }
        }
    }

    //選機台3ROW
    public void mid_select(View view) {
        final LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        final View v = inflater.inflate(R.layout.mid_select, null);
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        TextView title = new TextView(this);
        title.setGravity(Gravity.CENTER);
        title.setTextSize(24);
        dialog.setCustomTitle(title);
        dialog.setView(v);
        /////////////////////////
        final Button[] myButton = new Button[200];
        LinearLayout bnt_layout_1 = (LinearLayout) v.findViewById(R.id.buttonlayout);
        LinearLayout bnt_layout_2 = (LinearLayout) v.findViewById(R.id.buttonlayout2);
        LinearLayout bnt_layout_3 = (LinearLayout) v.findViewById(R.id.buttonlayout3);
        ImageView more_1 = (ImageView) v.findViewById(R.id.more_1);
        ImageView more_2 = (ImageView) v.findViewById(R.id.more_2);
        ImageView more_3 = (ImageView) v.findViewById(R.id.more_3);
        more_1.setVisibility(INVISIBLE);
        more_2.setVisibility(INVISIBLE);
        more_3.setVisibility(INVISIBLE);
        //                 dialog window size ssetting
        final AlertDialog dlg = dialog.show();
        WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
        //視窗長寬
        params.width = 1200;
        params.height = 600;
        //button text size
        dlg.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
        dlg.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
        dlg.getWindow().setAttributes(params);
        ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        int sub_i = 1, list1 = 0, list2 = 0, list3 = 0;
        for (int i = 1; i < midlist.size(); i++) {
            myButton[i] = new Button(this);
            myButton[i].setText(midlist.get(i).toString());
            myButton[i].setTextSize(18);
            myButton[i].setHeight(200);
            //System.out.println("midlist");
            if (midlist.get(i).indexOf("Q") > -1) {
                bnt_layout_1.addView(myButton[i], lp);
                list1++;
            } else if (midlist.get(i).indexOf("M") > -1) {
                bnt_layout_2.addView(myButton[i], lp);
                list2++;
            } else {
                bnt_layout_3.addView(myButton[i], lp);
                list3++;
            }
            final int subi = sub_i;
            myButton[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    machineBar = myButton[subi].getText().toString();
                    spinner.setVisibility(INVISIBLE);
                    TextView midtext = (TextView) findViewById(R.id.midtext);
                    midtext.setVisibility(VISIBLE);
                    midtext.setText("\t" + machineBar);
                    machine_but_flag = 1;
                    dlg.cancel();
                }
            });
            sub_i++;
        }
        if (list1 > 4) {
            more_3.setVisibility(VISIBLE);
        }
        if (list2 > 4) {
            more_2.setVisibility(VISIBLE);
        }
        if (list3 > 4) {
            more_1.setVisibility(VISIBLE);
        }
        dialog.setPositiveButton("送出", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
    }

    public void getcolor(View view) {
        if (!Process.equals("花蓮切割") ) {
            try{
                if (!COLOR_NUM.equals("--")) {
                    Message m = new Message();
                    m.what = MEG_INVALIDATE;
                    clolr.sendMessage(m);
                }

            } catch (Exception e) {
            }
        }
    }

    public static void cerro2(final char notfind_c) {  // report not found color
        call_rest restObj = new call_rest();
        JSONObject rtnRestObj = restObj.callRest(host + "PrdMgn/ErrorColor?suvFlowID=123&errorColor=" + notfind_c);
    }

    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            //掃單UI

            if (!coworker_bar.equals(""))
                coworker_bnt.setBackgroundResource(R.drawable.ic_people_green);
            if (WAREHouse_QTY.equals("null"))WAREHouse_QTY="0";
            WAREHouse_QTY_text_value.setText(WAREHouse_QTY);
            shotsub_text = (EditText) findViewById(R.id.shotsub_text);
            shotsub_button = (Button) findViewById(R.id.shotsub_button);
            //check_p.setVisibility(VISIBLE);
            if (Process.indexOf("外檢") > -1) {
                final_Texted = (EditText) findViewById(R.id.final_Texted);
                final_Texted.setText("0");
            }
            if (Message.indexOf("使用中") > -1) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("機台使用中，是否釋放機台?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub\
                                setting_status = 0;
                                View rootView = getWindow().getDecorView().getRootView();
                                maintain(rootView);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                                dialog.cancel();
                            }
                        });
                AlertDialog about_dialog = builder.create();
                about_dialog.show();

            }
            if (g_json_string.indexOf("錯誤") > -1 || g_json_string.indexOf("失敗") > -1 ||
            Message.indexOf("錯誤") > -1|| Message.indexOf("失敗") > -1
        ) {
                Message = Message + g_json_string;

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage(Message);
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
                builder.show();
            }
            String Message2 = Message + g_json_string;
            System.out.println("Message2==>==" + Message2);
            ;
            if (Message2.indexOf("** 3-8") > -1
                    || Message2.indexOf("** 2-17") > -1
                // ||Message2.indexOf("1-14") > -1
            ) {//代理完成
                View rootView = getWindow().getDecorView().getRootView();
                Message_show(rootView);
            }
            if (Message2.indexOf("** 1-2") > -1 || Message2.indexOf("** 2-12") > -1
                    || Message2.indexOf("機台生產中") > -1 || Message2.indexOf("機台使用中") > -1
            ) {//釋放機台
                View rootView = getWindow().getDecorView().getRootView();
                Message_confinsh(rootView);
            }
            if (Succ.indexOf("false") > -1) {
                View rootView = getWindow().getDecorView().getRootView();
                send_urlsting(rootView);
            }
            ImageButton report = (ImageButton) findViewById(R.id.report);
            report.setVisibility(VISIBLE);
            user_select = (Button) findViewById(R.id.user_select);
            if (Process.equals("花蓮外檢")) {//才顯示色碼人
                if (FLOW_STEP_CURR.equals("外檢2")) {
                    user_select.setVisibility(GONE);
                    color_userbnt.setVisibility(VISIBLE);
                } else {
                    user_select.setVisibility(VISIBLE);
                    color_userbnt.setVisibility(GONE);
                }
                    user_select.setVisibility(VISIBLE);
                    color_userbnt.setVisibility(VISIBLE);

                color_userbnt.setText("色碼人員");
                user_select.setText("底漆人員");
                //textView20.setVisibility(VISIBLE);
            } else {
                color_userbnt.setVisibility(views.GONE);
                user_select.setVisibility(views.GONE);
            }
            v_flow_title.setVisibility(VISIBLE);
            mfo_id_text_title.setVisibility(VISIBLE);
            sumOfNaiBei_text_title.setVisibility(VISIBLE);
            BATCH_QTY_text_title.setVisibility(VISIBLE);
            DELDATE_text_title.setVisibility(VISIBLE);
            RTYPE_text_title.setVisibility(VISIBLE);
            TOL_text_title.setVisibility(VISIBLE);
            WAREHouse_QTY_text_title.setVisibility(VISIBLE);
            PPM_text_title.setVisibility(VISIBLE);
            COLOR_NUM_text_title.setVisibility(VISIBLE);
            MachineIM.setVisibility(VISIBLE);
            VAL_text_title.setVisibility(VISIBLE);
            VAL_text_value.setVisibility(VISIBLE);
            BATCH_NO_text_value.setVisibility(VISIBLE);
            BATCH_NO_text_title.setVisibility(VISIBLE);
            SUBFLOWID_text_value.setVisibility(VISIBLE);
            SUBFLOWID_text_title.setVisibility(VISIBLE);
            BATCH_QTY_text_value.setVisibility(VISIBLE);
            DELDATE_text_value.setVisibility(VISIBLE);
            RTYPE_text_value.setVisibility(VISIBLE);
            TOL_text_value.setVisibility(VISIBLE);
            PPM_text_value.setVisibility(VISIBLE);
            COLOR_NUM_text_value.setVisibility(VISIBLE);
            if (!Process.equals("花蓮貼帶")) {
                try {
                    float i2 = Float.parseFloat(AccQuan);
                    v_flow_title.setText("本製程已完成  " + i2);
                } catch (NullPointerException e) {
                }
            }
            AccQuan_Texted.setText(StepLeft);
            mfo_id_text_value.invalidate();
            BATCH_NO_text_value.invalidate();
            BATCH_NO_text_title = (TextView) findViewById(R.id.BATCH_NO_text_title);
            BATCH_NO_text_title.setVisibility(VISIBLE);
            try {
                int in = Integer.valueOf(BATSEQ);
                if (in >= 0) {
                    in = in + 1;
                    BATCH_NO_text_value.setText("  " + in + " / " + BATCH_NO);
                }
            } catch (NullPointerException e) {
            }

            if (SUBFLOWID.equals("null"))SUBFLOWID="";
            SUBFLOWID_text_value.setText(SUBFLOWID);
            url_Texted.invalidate();
            url_Texted.setText("  " + url_stting);
            VAL_text_title.invalidate();
            VAL_text_value.invalidate();

            if (VAL.equals("null"))VAL="";
            VAL_text_value.setText("  " + VAL);
            note_value.invalidate();
            if (notec.equals("null"))notec="";
            note_value.setText("  " + notec);
            if (mfo_id.equals("null"))mfo_id="";
            mfo_id_text_value.setText("  " + mfo_id);
            if (mfo_id.length() > 8) {
                mfo_id_text_value.setHeight(50);
            } else {
                mfo_id_text_value.setHeight(50);
            }
            mfo_id_text_value.setMovementMethod(ScrollingMovementMethod.getInstance());

            BATCH_QTY_text_value.invalidate();

            if (BATCH_QTY.equals("null"))BATCH_QTY="0";
            BATCH_QTY_text_value.setText("  " + BATCH_QTY);
            DELDATE_text_value.invalidate();
            //DELDATE_text_value.setText("  " + DELDATE);
            RTYPE_text_value.invalidate();

            if (RTYPE.equals("null"))RTYPE="";
            if (TOL.equals("null"))TOL="";
            if (PPM.equals("null"))PPM="";
            RTYPE_text_value.setText("  " + RTYPE);
            TOL_text_value.invalidate();
            TOL_text_value.setText("  ±" + TOL + "%");
            PPM_text_value.invalidate();
            PPM_text_value.setText("  " + PPM);
            COLOR_NUM_text_value.invalidate();
            COLOR_NUM_text_value.setText("");
            messageview.invalidate();
            furyu_Texted.setText("0");
            messageview.setText("訊息:" + Message);
            if (Message.indexOf("外檢1") > -1) {
                DEPT_Texted.setText("外檢底漆");
            } else if (Message.indexOf("外檢2") > -1) {
                DEPT_Texted.setText("外檢色碼");
            }
            textView4.setVisibility(VISIBLE);
            DEPT_Texted.setVisibility(VISIBLE);
            DEPT_Texted.setText(Process);
            if (Message.indexOf("物體") > -1) {
                View rootView = getWindow().getDecorView().getRootView();
                send_urlsting(rootView);
            }
            /*if (Process.indexOf("全檢") > -1 && FLOW_STEP.indexOf("全檢") > -1) {
                Process = FLOW_STEP;
            }*/
            if (Process.equals("花蓮電鍍")) {
                ///////ui setting
                //textView9 = (TextView) findViewById(R.id.textView9);
                textView19 = (TextView) findViewById(R.id.textView19);
                textView20 = (TextView) findViewById(R.id.textView20);
                textView10 = (TextView) findViewById(R.id.textView10);
                AccQuan_Texted.setVisibility(INVISIBLE);
                textView10.setVisibility(INVISIBLE);
                textView19.setVisibility(INVISIBLE);
                textView20.setVisibility(INVISIBLE);
                //textView10.setVisibility(INVISIBLE);
                testnbnnt.setVisibility(INVISIBLE);
                sptest.setVisibility(INVISIBLE);
                part_finish_bnt.setVisibility(INVISIBLE);
                if (facroryNo == 1) {//藏完成    1:ST
                    accident.setVisibility(VISIBLE);
                    accident_text.setVisibility(VISIBLE);
                    accident.setText("開始");
                    test.setVisibility(INVISIBLE);
                } else {//藏開始  2:FI
                    accident.setVisibility(INVISIBLE);
                    accident_text.setVisibility(INVISIBLE);
                    test.setVisibility(VISIBLE);
                }

            }
            if (!preNaiBei.equals("null")) {
                preNaiBei_text.setText("切割小批完成 " + sunNaiBei);
            } else {
                preNaiBei_text.setText("");
            }
            sumOfNaiBei_text_title.invalidate();
            if (!sumOfNaiBei.equals("null")) {
                sumOfNaiBei_text_title.setVisibility(VISIBLE);
                sumOfNaiBei_text_title.setText("累積小批完成量" + sumOfNaiBei);
            } else {
                sumOfNaiBei_text_title.setText("");
            }
            url_Texted.invalidate();
            url_Texted.setText(url_stting);
            DEPT_Texted = (EditText) findViewById(R.id.DEPT_Texted);
            MachineParams_Texted = (EditText) findViewById(R.id.MachineParams_Texted);
            try {
                String StaticParams2 = StaticParams.toString();
                String[] separated = StaticParams2.split(":");
                MachineParams_Texted.setText(separated[1]);
            } catch (Exception e) {
                MachineParams_Texted.setText(StaticParams);
            }
            MachineParams_Texted.setFocusable(false);
            DEPT_Texted.setVisibility(INVISIBLE);
            MachineParams_Texted.setVisibility(INVISIBLE);
            InputQuan_Texted = (EditText) findViewById(R.id.InputQuan_Texted);
            AccQuan_Texted = (EditText) findViewById(R.id.AccQuan_Texted);
            final_Texted = (EditText) findViewById(R.id.final_Texted);
            furyu_Texted = (EditText) findViewById(R.id.furyu_Texted);
            //furyu_Texted.setText(ACCDefect);
            InputQuan_Texted.setVisibility(VISIBLE);
            furyu_Texted.setVisibility(VISIBLE);
            final_Texted.setVisibility(VISIBLE);
            AccQuan_Texted.setVisibility(VISIBLE);
            textView19.setVisibility(VISIBLE);
            textView10.setVisibility(VISIBLE);
            try {
                InputQuan_Texted.setText(InputQuan);
            } catch (Exception e) {
            }
            //AccQuan_Texted .setVisibility(VISIBLE);
            try {
                if (START_TIME != null && !Process.equals("花蓮電鍍")) {
                    String time = START_TIME.replaceAll("\\/Date\\(", "");
                    String finshtime = FINISH_TIME.replaceAll("\\/Date\\(", "");
                    time = time.replaceAll("\\)/", "");
                    finshtime = finshtime.replaceAll("\\)/", "");
                    Float starttimef = Float.parseFloat(time);
                    Float finshtimef = Float.parseFloat(finshtime);
                    if ((SIGNID == null || starttimef < 0 || finshtimef > 0)
                        //        || !USER_ID_Befor.equals(userBar)
                    ) {// 機台狀態是否開始
                        //                        //if(chm==0) {
                        accident.setVisibility(VISIBLE);
                        accident_text.setVisibility(VISIBLE);
                        accident.setText("開始");          //  6213559680000
                        accident.setVisibility(VISIBLE);
                        sptest.setVisibility(INVISIBLE);
                        part_finish_bnt.setVisibility(INVISIBLE);
                        test.setVisibility(INVISIBLE);
                        startflig = 0; // 機台狀態    已經開始為 1  尚未開始為0
                        //}
                        // chm=1;
                    } else {
                        startflig = 1; // 機台狀態    已經開始為 1  尚未開始為0
                        test.setVisibility(VISIBLE);
                        accident.setText("刪除");
                        accident.setVisibility(INVISIBLE);
                        accident_text.setVisibility(INVISIBLE);
                        sptest.setVisibility(VISIBLE);
                        if (Process.equals("花蓮切割")) {
                            part_finish_bnt.setVisibility(VISIBLE);
                        } else {
                            part_finish_bnt.setVisibility(INVISIBLE);
                        }
                        //part_finish_bnt.setVisibility(VISIBLE);
                        testbutton.setVisibility(VISIBLE);
                        startflig = 1;
                    }
                    if (chang_color == 1) {
                        note_value.setText("底漆換色");
                        //chang_color=0;
                    }
                }
            } catch (Exception e) {
                v_flow_title.setText(AccQuan);
            }
            if (!Process.equals("花蓮貼帶")) {
                try {
                    float i2 = Float.parseFloat(AccQuan);
                    v_flow_title.setText("本製程已完成" + i2);
                } catch (NullPointerException e) {
                    v_flow_title.setText(AccQuan);
                }
            }
            AccQuan_Texted.setText(StepLeft);
            if (FLOW_STEP_CURR.equals("外檢1")) {
                DEPT_Texted.setText("外檢底漆");
            } else if (FLOW_STEP_CURR.equals("外檢2")) {
                DEPT_Texted.setText("外檢色碼");
            } else {
                DEPT_Texted.setText(Process);
            }


            try {
                String StaticParams2 = StaticParams.toString();
                String[] separated = StaticParams2.split(":");
                separated[1] = separated[1].replaceAll("\\}", "");
                separated[1] = separated[1].replaceAll("\"", "");
                MachineParams_Texted.setText(separated[1]);
            } catch (Exception e) {
                MachineParams_Texted.setText(StaticParams);
            }
            System.out.println("InputQuan==>" + InputQuan);
if(!(Process.indexOf("外")>-1)){
            if (temp_int == 1) {
                try {
                    InputQuan_Texted.setText(InputQuan);
                } catch (Exception e) {
                }
            } else {
                InputQuan_Texted.setText(InputQuan);
            }
            System.out.println("InputQuan==>" + InputQuan);
            int in = 0, in2 = 0;
            try {
                in = Integer.valueOf(sumOfNaiBei);
                in2 = Integer.valueOf(InputQuan);
            } catch (Exception e) {
            }
            if (in > 1) {
                int temp_input = in2 - in;
                String inp = valueOf(temp_input);
                InputQuan_Texted.setText(inp);
            } else {
                temp_input = 0;
            }
        }else{
}
            if (perf == 1) {
                perf = 0;
                AccQuan_Texted.setText("");
                final_Texted.setText("0");
                furyu_Texted.setText("0");
            } else {
                final_Texted.setText("");
               // furyu_Texted.setText(ACCDefect);
            }textView9 = (TextView) findViewById(R.id.textView9);
            if (Process.equals("花蓮底漆") ||Process.equals("花蓮色碼")
                    || Process.equals("花蓮塗裝") || start_edit == 1 || InputQuan.equals("0")) {//
                //可改開始
                InputQuan_Texted.setFocusable(true);
                InputQuan_Texted.setFocusableInTouchMode(true);
            }/*else if (Process.equals("花蓮切割")) {
                textView9.setVisibility(INVISIBLE);
                InputQuan_Texted.setVisibility(INVISIBLE);
            } */else {
                InputQuan_Texted.setFocusable(true);
            }
            AccQuan_Texted.setText(StepLeft);  //剩餘
            //取庫單
            if (!WAREHouse_QTY.equals("")&&InputQuan.equals("0")){
                InputQuan_Texted.setText(BATCH_QTY);
            }
            if (Message.indexOf("失敗") > -1) {
                secmod = 0;
                accident.setVisibility(VISIBLE);
                accident_text.setVisibility(VISIBLE);
                accident.setText("開始");          //  6213559680000
                accident.setVisibility(VISIBLE);
                test.setVisibility(INVISIBLE);
                sptest.setVisibility(INVISIBLE);
                part_finish_bnt.setVisibility(INVISIBLE);
                startflig = 0; // 機台狀態    已經開始為 1  尚未開始為0
            }
            if (startflig == 1)
                accident.setVisibility(INVISIBLE);
            accident_text.setVisibility(INVISIBLE);
            if (machine_but_flag == 0) {
                if (part_finish != 0) {
                    part_finish = 0;
                } else {
                    //spinner.setSelection(0);
                }
            } else {
                //spinner.setVisibility(INVISIBLE);
            }
            if (!preNaiBei.equals("null") && ! (Process.indexOf(FLOW_STEP)>-1)) {// 小批部門不同給開始
                accident.setVisibility(VISIBLE);
                accident.setText("開始");          //  6213559680000
                accident.setVisibility(VISIBLE);
                accident_text.setVisibility(VISIBLE);
                test.setVisibility(INVISIBLE);
                sptest.setVisibility(INVISIBLE);
                part_finish_bnt.setVisibility(INVISIBLE);
                startflig = 0; // 機台狀態    已經開始為 1  尚未開始為0
            }
            def_bnt = (Button) findViewById(R.id.def_bnt);

            if (Process.indexOf("外檢") > -1) {
                def_bnt.setVisibility(VISIBLE);
                def_bnt.setText("不良量");
                def_bnt.setEnabled(true);
            } else {
                def_bnt.setVisibility(VISIBLE);
                def_bnt.setEnabled(false);
            }
            if (Process.indexOf("貼帶") > -1) {
                def_bnt.setText("不良量");
                TieDaiL_check.setVisibility(VISIBLE);
            }else{
                TieDaiL_check.setVisibility(GONE);
            }
            if (cut_flag == 1) {  //切割測試 完成=0
                //cut_flag=0;
                final_Texted.setText("0");
            } else {
                final_Texted.setText("");
            }
            if (warehouse_flag == 1) {
                warehouse_flag = 0;
                accident.setVisibility(INVISIBLE);
                accident_text.setVisibility(INVISIBLE);
                sptest.setVisibility(INVISIBLE);
                part_finish_bnt.setVisibility(INVISIBLE);
                test.setVisibility(INVISIBLE);
                sptest.setVisibility(INVISIBLE);
            }
            if (Process.equals("花蓮貼帶")) {
                //chk_TieDaiComp.setVisibility(View.VISIBLE);
                TieDaigroup.setVisibility(View.VISIBLE);
                ful_lay.setVisibility(View.VISIBLE);
                AccQuan_Texted.setText("");//餘廖
                final_Texted.setText("0");//本次
                AccQuan_Texted.setText(tdDoneQty);
                final_Texted.setText("");
                finsh_thai.setText("捲(" + tdRollQty + "千/捲)");
                def_thai.setText("捲(" + tdRollQty + "千/捲)");
                furyu_Texted.setText(tfLeftQty);
                ful_lay.setVisibility(GONE);

                tied_f_group.setVisibility(View.VISIBLE);
                //furyu_Texted.setFocusable(false);
            } else {
                TieDaigroup.setVisibility(GONE);
                ful_lay.setVisibility(View.VISIBLE);
                tied_f_group.setVisibility(GONE);
            }
            if (Process.equals("全檢備註") || cut_flag == 1) {
                final_Texted.setText(AccQuan);
            }
            if (Process.equals("花蓮貼帶")) {
                RadioGroup TieDaigroup = (RadioGroup) findViewById(R.id.TieDaigroup);
                ((RadioButton) TieDaigroup.getChildAt(0)).setChecked(true);
                //RadioButton rd_tdqty=(RadioButton) findViewById(R.id.rd_tdqty);
                View view = findViewById(android.R.id.content).getRootView();
                rd_quty_chk(view);
            }

            try {
            String finshtime = FINISH_TIME.replaceAll("\\/Date\\(", "");
            finshtime = finshtime.replaceAll("\\)/", "");
            Float finshtimef = Float.parseFloat(finshtime);
            String dept_temp=Process.replaceAll("花蓮", "");
            //拆全檢1.2
            dept_temp=dept_temp.replaceAll("1", "");
            dept_temp=dept_temp.replaceAll("2", "");
                System.out.println("裝"+finshtimef+FLOW_STEP+dept_temp+userBar+USER_ID);

                if(((finshtimef>=0 && !(FLOW_STEP.indexOf(dept_temp)>=0))
                || !(userBar.indexOf(USER_ID)>=0&&FLOW_STEP.indexOf(dept_temp)>=0))
                /*不同製程不同人一率給開始  塗裝例外*/){
                if (Process_SWT.indexOf("裝")>-1&&FLOW_STEP.indexOf(Process)>=0&&finshtimef<=0 ){

                    startflig = 1; // 機台狀態    已經開始為 1  尚未開始為0
                    //accident.setVisibility(VISIBLE);
                    test.setVisibility(VISIBLE);
                    sptest.setVisibility(VISIBLE);
                    part_finish_bnt.setVisibility(VISIBLE);
                    accident.setText("刪除");
                    accident.setVisibility(INVISIBLE);
                    accident_text.setVisibility(INVISIBLE);
                    testbutton.setVisibility(VISIBLE);
                    startflig = 1;
                }else {
                    accident.setVisibility(VISIBLE);
                    System.out.println("01010101012"+finshtimef+FLOW_STEP+dept_temp+userBar+USER_ID);
                    accident.setText("開始");          //  6213559680000
                    accident_text.setVisibility(VISIBLE);
                    accident.setVisibility(VISIBLE);
                    test.setVisibility(INVISIBLE);
                    sptest.setVisibility(INVISIBLE);
                    part_finish_bnt.setVisibility(INVISIBLE);
                    startflig = 0; // 機台狀態    已經開始為 1  尚未開始為0
                }


        }
        } catch (Exception e) {
        }
        //外檢重取
            if (Process.equals("花蓮外檢") && CHINTO==1)
            {
                CHINTO=0;
                final Button info_bnt = (Button) findViewById(R.id.info_bnt);
                info_bnt.setVisibility(GONE);
                info_bnt.performClick();
            }else if (Process.indexOf("外檢")>-1){

                CHINTO=0;
                final Button info_bnt = (Button) findViewById(R.id.info_bnt);
                info_bnt.setVisibility(GONE);
                info_bnt.performClick();
            }
            if (Process.equals("花蓮切割") ){
                part_finish_bnt.setVisibility(VISIBLE);
            }else {
                part_finish_bnt.setVisibility(INVISIBLE);
            }
            //貼帶預設捲數
                if(Process.equals("花蓮貼帶")) {
            rd_roll=(RadioButton) findViewById(R.id.rd_roll);
            rd_roll.setChecked(true);
            View rootView = getWindow().getDecorView().getRootView();
            rd_roll_chk(rootView);
        }
        super.handleMessage(msg);
        }

    };
    private void Message_confinsh(View rootView) {
        System.out.println("00000101221;33333;Message_confinsh"+Message);
        Message m = new Message();
        m.what = MEG_INVALIDATE;
        midhandler1.sendMessage(m);
        //System.out.println("00000101221;33333;Message_confinsh"+Message);

    }
        private void Message_show(View rootView) {//代理完成

        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        final View v = inflater.inflate(R.layout.finsh_list, null);   //   get viwe layout
        final AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        TextView title = new TextView(this);
        Button b32 = (Button) v.findViewById(R.id.button32);
        NG1 =(EditText) v.findViewById(R.id.fin1);
        NG2 = (EditText) v.findViewById(R.id.fin2);
        NG3 = (EditText) v.findViewById(R.id.fin3);
        Button b31 = (Button) v.findViewById(R.id.button31);
        EditText fin= (EditText) v.findViewById(R.id.fin);
        try {
            fin.setText(InputQuan.toString());
        }catch (Exception e) {
        }
        fin.setFocusable(false);
        title.setText(Message);
        title.setGravity(Gravity.CENTER);
        title.setTextSize(24);
        dialog.setCustomTitle(title);
        dialog.setView(v);
        final AlertDialog dlg = dialog.show();
        b32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg.dismiss();
            }
        });
        b31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(NG1.getText().toString().equals(""))NG1.setText("0");
                if(NG2.getText().toString().equals(""))NG2.setText("0");
                if(NG3.getText().toString().equals(""))NG3.setText("0");
                ng1_afinsh = NG1.getText().toString();
                ng2_afinsh = NG2.getText().toString();
                ng3_afinsh = NG3.getText().toString();
               finsh_lastsign(v);
                dlg.dismiss();
            }
        });
        WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
        //視窗長寬
        params.width = 1500;
        params.height = 600;
        //button text size
        dlg.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
        dlg.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
        dlg.getButton(AlertDialog.BUTTON_NEGATIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
        dlg.getWindow().setAttributes(params);
    }

    Handler messstobox = new Handler() {
        public void handleMessage(Message msg) {
            messageview.setText("訊息:" + g_json_string);
            if(Message.indexOf("外檢1")>-1){
                DEPT_Texted.setText("外檢底漆");
            }else if(Message.indexOf("外檢2")>-1){
                DEPT_Texted.setText("外檢色碼");
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage(""+g_json_string);

            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
         //   builder.show();
            super.handleMessage(msg);
        }
    };
    Handler REhandler = new Handler() {
        public void handleMessage(Message msg) {
            messageview.setText("訊息:" + Message+"0");
            accident.setText("刪除");
            accident.setVisibility(INVISIBLE);
            startflig = 1;

            super.handleMessage(msg);
        }
    };

    Handler superv_sance = new Handler() {
        public void handleMessage(Message msg) {
            messageview.setText("訊息:" + Message);
            if(ifLeader.equals("1")){
                //ifLeader="0";
                InputQuan_Texted = (EditText) findViewById(R.id.InputQuan_Texted);
                InputQuan_Texted.setFocusable(true);
                InputQuan_Texted.setFocusableInTouchMode(true);
            }
            if(ifLeader.equals("1") &&Process.indexOf("外")>-1){
                ifLeader="0";
                View rootView = getWindow().getDecorView().getRootView();

                getg(rootView);
                InputQuan_Texted = (EditText) findViewById(R.id.InputQuan_Texted);
                InputQuan_Texted.setFocusable(true);
                InputQuan_Texted.setFocusableInTouchMode(true);
            }else{

                View rootView = getWindow().getDecorView().getRootView();

                getg(rootView);
            }

            super.handleMessage(msg);
        }

    };
    Handler messagehandler = new Handler() {
        public void handleMessage(Message msg) {
            ImageButton report = (ImageButton) findViewById(R.id.report);
            if (setting_status == 2) {
                report.setImageResource(R.drawable.ic_buildr);
            } else {
                report.setImageResource(R.drawable.ic_build);
            }
            messageview.setText("訊息:" + Message);
            super.handleMessage(msg);
        }

    };
    Handler upmessagehandler = new Handler() {
        public void handleMessage(Message msg) {
            messageview.setText("訊息:" + Message);
            super.handleMessage(msg);
        }

    };
    Handler FIN = new Handler() {
        public void handleMessage(Message msg) {
            if (!Process.equals("花蓮底漆")) {
                //spinner.setSelection(0);
            }
            super.handleMessage(msg);
        }

    };
    Handler showm = new Handler() {
        public void handleMessage(Message msg) {
            final Button info_bnt = (Button) findViewById(R.id.info_bnt);
            info_bnt.setVisibility(GONE);
            //info_bnt.performClick();

            super.handleMessage(msg);
        }

    };

    Handler BUTThandler2 = new Handler() {

        public void handleMessage(Message msg) {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("message");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
            builder.show();
        }
    };

    Handler ALLhandler = new Handler() {
        public void handleMessage(Message msg) {
            if (conf_flag != null) {
                View rootView = getWindow().getDecorView().getRootView();



                if (conf_flag.indexOf("2") > -1) { //需要確認
                    ShowpopMsg_confrn(rootView);//confrn popup                                //
                    conf_flag = "0";
                } else if (conf_flag.indexOf("1") > -1) { //停止
                    ShowpopMsg_confrn(rootView);//confrn popup                                //

                    //ShowpopMsg_stop(rootView);//confrn popup                                  //
                    conf_flag = "0";
                } else {
                    //不須確認
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                    builder2.setMessage("製程注意事項\r\n" + popMsg + dy_msgdy_msg);
                    builder2.setCancelable(false);
                    builder2.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //
                        }
                    });
                    if (popMsg == null || popMsg.indexOf("null") > -1 || popMsg.equals("")) {

                    } else {
                        builder2.show();
                    }
                }
            }
            super.handleMessage(msg);
        }

        };
    Handler BUTThandler = new Handler() {

        public void handleMessage(Message msg) {
            if (Message.indexOf("錯誤") > -1 || Message.indexOf("無法") > -1) {
                accident.setVisibility(VISIBLE);
                accident.setText("開始");          //  6213559680000
                System.out.println("01010101013");

                if (Message.indexOf("順序錯誤") > -1 ) {
                    Message=code+"順序錯誤+\n\n" +
                            "Lịch trình tránh diễn ra trước khi cắt hàng ,Nếu muốn bắt đầu lịch trình (  tờ đơn hàng ) ,xin nhấn nút  nhận định, quẹt tên mã người nhận, xong nhấn nút bắt đầu.";
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage(Message);
                Message="";
                builder.setCancelable(false);
                builder.setPositiveButton("確認", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
                builder.show();
                accident_text.setVisibility(VISIBLE);
                test.setVisibility(INVISIBLE);
                sptest.setVisibility(INVISIBLE);
                part_finish_bnt.setVisibility(INVISIBLE);

                startflig = 0; // 機台狀態    已經開始為 1  尚未開始為0
            } else {
                accident.setText("刪除");
                accident.setVisibility(INVISIBLE);
                testbutton.setVisibility(VISIBLE);          //  6213559680000
                test.setVisibility(VISIBLE);
                startflig = 1; // 機台狀態    已經開始為 1  尚未開始為0
            }
            url_Texted.invalidate();
            url_Texted.setText(url_stting);
            super.handleMessage(msg);
        }

    };

    final Handler userMessageHandler = new Handler() {

        public void handleMessage(Message msg) {
            //登入後ui控制

            ver.setText("ver. "+now_version);
            wifi_bnt2.setVisibility(VISIBLE);
            wifi_bnt.setVisibility(GONE);
            if(!(Process.indexOf("外") > -1 )){
                bnt_todef.setVisibility(VISIBLE);//無余料
            }
            if(Process.indexOf("底漆") > -1 || Process.indexOf("色碼") > -1 ){

                terrible_layout.setVisibility(VISIBLE);
            }else {
                terrible_layout.setVisibility(GONE);
            }

            if(Process.indexOf("塗裝") > -1 || Painting_flag==1){
                Process_sw_block.setVisibility(VISIBLE);
                Painting_select.setVisibility(VISIBLE);
                Painting_flag=1;
                if (sent_type.equals("0")){
                    final_Texted.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
                }else {
                    final_Texted.setInputType(InputType.TYPE_CLASS_NUMBER);
                }
            }else {
                Process_sw_block.setVisibility(INVISIBLE);
                Painting_select.setVisibility(GONE);
            }

            if(Process.indexOf("底漆") > -1){
                Process_bnt.setText("底漆");
            }
            if(Process.indexOf("切割") > -1){
                Process_bnt.setText("切割");
            }

            if(Process.indexOf("電") > -1){
                View rootView = getWindow().getDecorView().getRootView();
                plating_views(rootView);
            }
            else{
                if (Process.indexOf("全檢") > -1) {
                coworker_bnt.setVisibility(VISIBLE);
            } else {
                coworker_bnt.setVisibility(INVISIBLE);
            }

            if (Process.equals("花蓮切割") ) {
                shotsub_text.setVisibility(INVISIBLE);
                shotsub_button.setVisibility(INVISIBLE);
            } else {
                shotsub_text.setVisibility(VISIBLE);
                shotsub_button.setVisibility(VISIBLE);
            }
            button41 = (Button) findViewById(R.id.button41);
            button41.setVisibility(INVISIBLE);
            if(Process.equals("花蓮加壓") ||
                    Process.equals("花蓮全檢") ||
                    Process.equals("花蓮色碼") ||
                    Process.equals("花蓮底漆") ||
                    Process.equals("花蓮切割") ||
                    Process.equals("花蓮塗裝")
            ){
                material_issue_bnt.setVisibility(VISIBLE);//不合格按鈕
            }else{
                material_issue_bnt.setVisibility(GONE);//不合格按鈕
            }

            textView9 = (TextView) findViewById(R.id.textView9);
            if (Process.equals("花蓮外檢")
                    && (FLOW_STEP_CURR.equals("外檢2")
                    || FLOW_STEP_CURR.equals("外檢1"))) {//才顯示色碼人 要驗NG
                color_userbnt.setVisibility(VISIBLE);
                user_select = (Button) findViewById(R.id.user_select);
                user_select.setVisibility(VISIBLE);
                textView10.setVisibility(VISIBLE);
                textView19.setVisibility(VISIBLE);
                NGselecdt.setVisibility(VISIBLE);
                textView9.setVisibility(GONE);

            } else if (Process.indexOf("外檢") > -1 && FLOW_STEP.indexOf(FLOW_STEP_CURR) > -1) {
                textView9.setVisibility(GONE);
                NGselecdt.setVisibility(VISIBLE);
            } else {
                textView9.setVisibility(VISIBLE);
                NGselecdt.setVisibility(GONE);
            }
            ///NGselecdt.setVisibility(VISIBLE);
                shift_bnt.setVisibility(GONE);

            if (Process.equals("花蓮切割")) {
                part_finish_bnt = (Button) findViewById(R.id.part_finish);
                part_finish_bnt.setVisibility(INVISIBLE);
            }
            ImageButton report = (ImageButton) findViewById(R.id.report);
            report.setVisibility(VISIBLE);
            views2.setVisibility(VISIBLE);
            if (ifLeader.equals("1") || cpuInfo.contains("intel")) {
                setting.setVisibility(VISIBLE);
            } else {
                setting.setVisibility(VISIBLE);
            }
            if (Process.indexOf("外檢") > -1) {
                def_bnt.setVisibility(VISIBLE);
                def_bnt.setText("不良量");
                def_bnt.setEnabled(true);
            } else {
                def_bnt.setVisibility(VISIBLE);
                def_bnt.setEnabled(false);
            }
            if (Process.indexOf("貼帶") > -1) {
                def_bnt.setText("不良量");

            }
            if (Process.equals("花蓮色碼")) {
                color_bnt.setVisibility(VISIBLE);
            } else {
                color_bnt.setVisibility(INVISIBLE);
            }
            textView51.setVisibility(View.VISIBLE);//機台下翻譯
            if (Process.equals("花蓮電鍍") && facroryNo == 2) {
                date_spinner.setVisibility(View.VISIBLE);
            } else {
                date_spinner.setVisibility(GONE);
            }
            if (!Process.equals("花蓮電鍍")) {
                hide_bnt1.setVisibility(GONE);
                hide_bnt2.setVisibility(GONE);
            } else {
                textView10.setVisibility(GONE);
                AccQuan_Texted = (EditText) findViewById(R.id.AccQuan_Texted);
                AccQuan_Texted.setVisibility(GONE);
                hide_bnt1.setVisibility(View.VISIBLE);
                hide_bnt2.setVisibility(View.VISIBLE);
            }
            if (Process.equals("花蓮貼帶")) {
                textView19 = (TextView) findViewById(R.id.textView19);
                textView20 = (TextView) findViewById(R.id.textView20);
                textView10 = (TextView) findViewById(R.id.textView10);
                textView19.setText("完成量");
                textView20.setText("已完成");
                final_Texted.setHint("已完成");
                furyu_Texted.setHint("已完成");
                textView10.setText("數量(個)");
            }
            if (Process.equals("花蓮電鍍")) {
                ///////ui setting
                //textView9 = (TextView) findViewById(R.id.textView9);
                textView19 = (TextView) findViewById(R.id.textView19);
                textView20 = (TextView) findViewById(R.id.textView20);
                textView10 = (TextView) findViewById(R.id.textView10);
                textView19.setVisibility(INVISIBLE);
                textView20.setVisibility(INVISIBLE);
                textView10.setVisibility(INVISIBLE);
                testnbnnt.setVisibility(INVISIBLE);
                sptest.setVisibility(INVISIBLE);
                part_finish_bnt.setVisibility(INVISIBLE);
                if (facroryNo == 1) {//藏完成    1:ST
                    accident.setVisibility(VISIBLE);
                    accident_text.setVisibility(VISIBLE);
                    accident.setText("開始");
                    test.setVisibility(INVISIBLE);
                } else {//藏開始  2:FI
                    accident.setVisibility(INVISIBLE);
                    accident_text.setVisibility(INVISIBLE);
                    test.setVisibility(VISIBLE);
                }

            }
            Calendar mCal = Calendar.getInstance();
            String dateformat = "yyyy-MM-dd kk:mm:ss";
            SimpleDateFormat df = new SimpleDateFormat(dateformat);
            df.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
            String today = df.format(mCal.getTime());
            name_textView.invalidate();
            //deptp
            name_textView.setText("部門:" + deptp + "\t\t\t員工:" + name + "\t\t\t登入時間:" + today);
            textView2 = (TextView) findViewById(R.id.textView2);
            setting = (ImageButton) findViewById(R.id.setting);
            viewsbutton = (ImageButton) findViewById(R.id.views);
            getinfo = (Button) findViewById(R.id.GET_INFO);
            getinfo.setVisibility(VISIBLE);
            if (ifLeader.equals("1") || (cpuInfo.contains("intel") || cpuInfo.contains("amd"))) {
                //views.setVisibility(VISIBLE);
                //bnt_myPrd.setVisibility(VISIBLE);//設定
                setting.setVisibility(VISIBLE);
            } else {
                views.setVisibility(INVISIBLE);
                viewsbutton.setVisibility(INVISIBLE);
                //setting.setVisibility(INVISIBLE);
                setting.setVisibility(VISIBLE);
            }
            if (Process.equals("底漆")) {
                textView2.setText("A001");
            } else if (Process.equals("花蓮電鍍")) {
                textView2.invalidate();
                textView2.setText("選擇廠別");
            } else {

                if (Process.equals("花蓮切割") || Process.equals("花蓮外檢") || Process.equals("花蓮加壓") ||
                        Process.equals("花蓮外檢") || Process.equals("花蓮全檢") || Process.equals("全檢1") ||
                        Process.equals("全檢2") || Process.equals("外檢1") || Process.equals("外檢2")) {
                } else {

                    spinner.setVisibility(VISIBLE);
                }
                if (Process.equals("底漆")) {
                    textView2.setText("A001");
                } else {
                    textView2.setVisibility(VISIBLE);
                }
            }
            edit_buttom.setVisibility(VISIBLE);
            /*if(Process.equals("花蓮電鍍")){
                imageView11.performClick();
            }*/
            finsh_thai.setVisibility(VISIBLE);
            def_thai.setVisibility(VISIBLE);
        }
        }
    };
    final Handler clolr = new Handler() {
        public void handleMessage(Message msg1) {
            super.handleMessage(msg1);

            ImageView bg = (ImageView) findViewById(R.id.imageView);
            ImageView bg2 = (ImageView) findViewById(R.id.imageView);
            ImageView color_left = (ImageView) findViewById(R.id.color_left);
            ImageView color_left2 = (ImageView) findViewById(R.id.color_left2);
            ImageView color_left3 = (ImageView) findViewById(R.id.color_left3);
            ImageView color_right = (ImageView) findViewById(R.id.color_right);
            ImageView color_right2 = (ImageView) findViewById(R.id.color_right2);
            ImageView color_right3 = (ImageView) findViewById(R.id.color_right3);
            ImageView last = (ImageView) findViewById(R.id.imageView7);
            last.setVisibility(VISIBLE);
            if (COLOR_inverse == 0) {  //左至右
                bg2 = (ImageView) findViewById(R.id.imageView);
                bg = (ImageView) findViewById(R.id.imageViewb);
                color_right.setVisibility(VISIBLE);
                color_right2.setVisibility(VISIBLE);
                color_right3.setVisibility(VISIBLE);
                color_left.setVisibility(INVISIBLE);
                color_left2.setVisibility(INVISIBLE);
                color_left3.setVisibility(INVISIBLE);
            } else {//右至左
                bg2 = (ImageView) findViewById(R.id.imageView);
                bg = (ImageView) findViewById(R.id.imageViewb);
                color_left.setVisibility(VISIBLE);
                color_left2.setVisibility(VISIBLE);
                color_left3.setVisibility(VISIBLE);
                color_right.setVisibility(INVISIBLE);
                color_right2.setVisibility(INVISIBLE);
                color_right3.setVisibility(INVISIBLE);
            }
            if (Process.equals("花蓮色碼")|| Process.equals("花蓮塗裝")){
                bg.setVisibility(VISIBLE);  // 秀底色
            }
            bg2.setVisibility(INVISIBLE);
            TextView bg_t = (TextView) findViewById(R.id.textView17);
            TextView last_t;
            TextView Colorinfo = (TextView) findViewById(R.id.Colorinfo);
            Colorinfo.setText("");
            ImageView[] letters = new ImageView[6];

            TextView[] VColor = new TextView[6];
            letters[0] = (ImageView) findViewById(R.id.imageView2);
            letters[0].setVisibility(INVISIBLE);
            letters[1] = (ImageView) findViewById(R.id.imageView3);
            letters[1].setVisibility(INVISIBLE);
            letters[2] = (ImageView) findViewById(R.id.imageView4);
            letters[2].setVisibility(INVISIBLE);
            letters[3] = (ImageView) findViewById(R.id.imageView5);
            letters[3].setVisibility(INVISIBLE);
            letters[4] = (ImageView) findViewById(R.id.imageView7);
            letters[4].setVisibility(INVISIBLE);
            letters[5] = (ImageView) findViewById(R.id.imageView6);
            letters[5].setVisibility(INVISIBLE);
            VColor[0] = (TextView) findViewById(R.id.textView5);
            VColor[0].setVisibility(INVISIBLE);
            VColor[1] = (TextView) findViewById(R.id.textView13);
            VColor[1].setVisibility(INVISIBLE);
            VColor[2] = (TextView) findViewById(R.id.textView21);
            VColor[2].setVisibility(INVISIBLE);
            VColor[3] = (TextView) findViewById(R.id.textView16);
            VColor[3].setVisibility(INVISIBLE);
            VColor[4] = (TextView) findViewById(R.id.textView18);
            VColor[4].setVisibility(INVISIBLE);
            VColor[4] = (TextView) findViewById(R.id.textView53);
            VColor[4].setVisibility(INVISIBLE);
            VColor[5] = (TextView) findViewById(R.id.textView54);
            VColor[5].setVisibility(INVISIBLE);
            last_t = (TextView) findViewById(R.id.textView14);
            last_t.setVisibility(INVISIBLE);
            last = (ImageView) findViewById(R.id.imageView7);
            if (COLOR_inverse == 0) {  //左至右
                letters[0] = (ImageView) findViewById(R.id.imageView2);
                letters[0].setVisibility(INVISIBLE);
                letters[1] = (ImageView) findViewById(R.id.imageView3);
                letters[1].setVisibility(INVISIBLE);
                letters[2] = (ImageView) findViewById(R.id.imageView4);
                letters[2].setVisibility(INVISIBLE);
                letters[3] = (ImageView) findViewById(R.id.imageView5);
                letters[3].setVisibility(INVISIBLE);
                letters[4] = (ImageView) findViewById(R.id.imageView7);
                letters[4].setVisibility(INVISIBLE);
                letters[5] = (ImageView) findViewById(R.id.imageView6);
                letters[5].setVisibility(INVISIBLE);
                VColor[0] = (TextView) findViewById(R.id.textView5);
                VColor[0].setVisibility(INVISIBLE);
                VColor[1] = (TextView) findViewById(R.id.textView13);
                VColor[1].setVisibility(INVISIBLE);
                VColor[2] = (TextView) findViewById(R.id.textView21);
                VColor[2].setVisibility(INVISIBLE);
                VColor[3] = (TextView) findViewById(R.id.textView16);
                VColor[3].setVisibility(INVISIBLE);
                VColor[4] = (TextView) findViewById(R.id.textView18);
                VColor[4].setVisibility(INVISIBLE);
                VColor[4] = (TextView) findViewById(R.id.textView53);
                VColor[4].setVisibility(INVISIBLE);
                VColor[5] = (TextView) findViewById(R.id.textView54);
                VColor[5].setVisibility(INVISIBLE);
                last_t = (TextView) findViewById(R.id.textView14);
                last_t.setVisibility(INVISIBLE);
                last = (ImageView) findViewById(R.id.imageView7);
            }else
            {
                letters[0] = (ImageView) findViewById(R.id.imageView6);
                letters[0].setVisibility(INVISIBLE);
                letters[1] = (ImageView) findViewById(R.id.imageView7);
                letters[1].setVisibility(INVISIBLE);
                letters[2] = (ImageView) findViewById(R.id.imageView5);
                letters[2].setVisibility(INVISIBLE);
                letters[3] = (ImageView) findViewById(R.id.imageView4);
                letters[3].setVisibility(INVISIBLE);
                letters[4] = (ImageView) findViewById(R.id.imageView3);
                letters[4].setVisibility(INVISIBLE);
                letters[5] = (ImageView) findViewById(R.id.imageView2);
                letters[5].setVisibility(INVISIBLE);//add//add
                VColor[0] = (TextView) findViewById(R.id.textView54);
                VColor[0].setVisibility(INVISIBLE);
                VColor[1] = (TextView) findViewById(R.id.textView14);
                VColor[1].setVisibility(INVISIBLE);
                VColor[2] = (TextView) findViewById(R.id.textView53);
                VColor[2].setVisibility(INVISIBLE);
                VColor[3] = (TextView) findViewById(R.id.textView16);
                VColor[3].setVisibility(INVISIBLE);
                VColor[4] = (TextView) findViewById(R.id.textView13);
                VColor[4].setVisibility(INVISIBLE);
                VColor[5] = (TextView) findViewById(R.id.textView5);
                VColor[5].setVisibility(INVISIBLE);//add
                last_t = (TextView) findViewById(R.id.textView12);
                last = (ImageView) findViewById(R.id.imageView3);
                last_t.setVisibility(INVISIBLE);//add

            }
            int rcolor_w = Color.parseColor("#ffffff"); //白
            int rcolor_blue = Color.parseColor("#73C3AA"); //7921 藍色B
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
            int rcolor_pink = Color.parseColor("#ff60af"); //MP106 粉紅B
            int mcolor_Red = Color.parseColor("#FF0000"); //紅
            int mcolor_Orange = Color.parseColor("#FF6600"); //橙
            int mcolor_Yellow = Color.parseColor("#FFFF00"); //黃
            int mcolor_Green = Color.parseColor("#009900"); //綠
            int mcolor_Blue = Color.parseColor("#0000FF"); //藍
            int mcolor_Purple = Color.parseColor("#9900FF"); //藍
            int mcolor_Gray = Color.parseColor("#999999"); //灰
            int mcolor_White = Color.parseColor("#FFFFFF"); //白
            int mcolor_Gold = Color.parseColor("#FFCC00"); //金
            int mcolor_Silver = Color.parseColor("#CCCCCC"); //銀
            int mcolor_pinkb = Color.parseColor("#FACCBA"); //MP106漆-MP106 粉紅B(250, 204, 186)- #FACCBA-pinkb
            int mcolor_bluea = Color.parseColor("#1E82C8"); //2070-   MM02 藍色A(30, 130, 200)-        #1E82C8-bluea
            int mcolor_blue2 = Color.parseColor("#73C3AA"); //7921漆- 7921 藍色(115, 195, 170)-         #73C3AA-blue2
            int mcolor_pinka = Color.parseColor("#FFCCAF"); //Z0415-  粉紅A(255, 204, 175)-                #FFCCAF-pinka
            int mcolor_yellow = Color.parseColor("#FFFF00"); //Z360-   CM02 碳膜乳黃(255, 224, 160)-  #FFE0A0-yellow
            int mcolor_apple = Color.parseColor("#9BFFAA"); //蘋果綠不燃性漆-蘋果綠(155, 255, 170)-  #9BFFAA-apple
            int mcolor_green2 = Color.parseColor("#4B854B"); //綠色不燃性漆-  綠色(75, 133, 75)-           #4B854B-green2
            int mcolor_bluem = Color.parseColor("#64A6CE"); //藍色不燃性漆-  MO 藍色(100, 166, 206)-#64A6CE-bluem
            int mcolor_purple2 = Color.parseColor("#CE99CC"); //紫色不燃性漆-  紫色(204, 153, 204)-       #CE99CC-purple2
            int mcolor_red = Color.parseColor("#FFBEBE"); //磚紅不燃性漆-  紅磚(255, 190, 190)-       #FFBEBE-red
            int mcolor_metal = Color.parseColor("#73AD8F"); // 金屬塗料-      金屬 墨綠(115, 173, 143)-  #73AD8F-metal
            //COLOR_NUM="紅紅黑-黑-MP106 粉紅";
            String input = COLOR_NUM;
            String[] parts = input.split("-");
            int i = parts[0].length();
            String first = parts[0];
            String reverse = new StringBuffer(first).reverse().toString();
            char content[] = first.toCharArray();
            if (Process.equals("花蓮底漆")) {
                color_right.setVisibility(INVISIBLE);
                color_right2.setVisibility(INVISIBLE);
                color_right3.setVisibility(INVISIBLE);
                color_left.setVisibility(INVISIBLE);
                color_left2.setVisibility(INVISIBLE);
                color_left3.setVisibility(INVISIBLE);
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
                            cerro2(content[j]);
                            Colorinfo.setText("查無色碼請通知系統資訊部");
                            break;
                    }
                }

            try{

            if (parts[1].length() != 0) { //TYPE2imageView7
                last_t.setVisibility(VISIBLE);
                last.setVisibility(VISIBLE);
                String in = parts[1].toString();
                char content2[] = in.toCharArray();
                switch (content2[0]) {
                    case '棕':
                        last.setColorFilter(Color.parseColor("#993300"));
                        last.setVisibility(VISIBLE);
                        last_t.setText("棕");
                        break;
                    case '黑':
                        last.setColorFilter(Color.parseColor("#000000"));
                        last.setVisibility(VISIBLE);
                        last_t.setText("黑");
                        break;
                    case '紅':
                        last.setColorFilter(mcolor_Red);
                        last.setVisibility(VISIBLE);
                        last_t.setText("紅");
                        break;
                    case '橙':
                        last.setColorFilter(mcolor_Orange);
                        last.setVisibility(VISIBLE);
                        last_t.setText("橙");
                        break;
                    case '黃':
                        last.setColorFilter(mcolor_Yellow);
                        last.setVisibility(VISIBLE);
                        last_t.setText("黃");
                        break;
                    case '綠':
                        last.setColorFilter(mcolor_Green);
                        last.setVisibility(VISIBLE);
                        last_t.setText("綠");
                        break;
                    case '藍':
                        last.setColorFilter(mcolor_Blue);
                        last.setVisibility(VISIBLE);
                        last_t.setText("藍");
                        break;
                    case '紫':
                        last.setColorFilter(mcolor_Purple);
                        last.setVisibility(VISIBLE);
                        last_t.setText("紫");
                        break;
                    case '灰':
                        last.setColorFilter(mcolor_Gray);
                        last.setVisibility(VISIBLE);
                        last_t.setText("灰");
                        break;
                    case '白':
                        last.setColorFilter(mcolor_White);
                        last.setVisibility(VISIBLE);
                        last_t.setText("白");
                        break;
                    case '金':
                        last.setColorFilter(mcolor_Gold);
                        last.setVisibility(VISIBLE);
                        last_t.setText("金");
                        break;
                    case '銀':
                        last.setColorFilter(mcolor_Silver);
                        last.setVisibility(VISIBLE);
                        last_t.setText("銀");
                        break;
                    default:
                        cerro2(content2[0]);
                        Colorinfo.setText("查無色碼請通知系統資訊部");
                        break;
                }
            } else {
                last_t.setVisibility(INVISIBLE);
                last.setVisibility(INVISIBLE);
            }
            }catch  (Exception e) {
                }
            String secpart;
            try {
                secpart = parts[2];
            }catch  (Exception e) {
                secpart="";
            }
            try{
                if (parts[3].length() != 0) { //TYPE2
                    letters[5].setVisibility(VISIBLE);
                    VColor[5].setVisibility(VISIBLE);
                    String in = parts[3].toString();
                    char content2[] = in.toCharArray();
                    switch (content2[0]) {
                        case '棕':
                            letters[5].setColorFilter(Color.parseColor("#993300"));
                            VColor[5].setText("棕");
                            break;
                        case '黑':
                            letters[5].setColorFilter(Color.parseColor("#000000"));
                            VColor[5].setText("黑");
                            break;
                        case '紅':
                            letters[5].setColorFilter(mcolor_Red);
                            VColor[5].setText("紅");
                            break;
                        case '橙':
                            letters[5].setColorFilter(mcolor_Orange);
                            VColor[5].setText("橙");
                            break;
                        case '黃':
                            letters[5].setColorFilter(mcolor_Yellow);
                            VColor[5].setText("黃");
                            break;
                        case '綠':
                            letters[5].setColorFilter(mcolor_Green);
                            VColor[5].setText("綠");
                            break;
                        case '藍':
                            letters[5].setColorFilter(mcolor_Blue);
                            VColor[5].setText("藍");
                            break;
                        case '紫':
                            letters[5].setColorFilter(mcolor_Purple);
                            VColor[5].setText("紫");
                            break;
                        case '灰':
                            letters[5].setColorFilter(mcolor_Gray);
                            VColor[5].setText("灰");
                            break;
                        case '白':
                            letters[5].setColorFilter(mcolor_White);
                            VColor[5].setText("白");
                            break;
                        case '金':
                            letters[5].setColorFilter(mcolor_Gold);
                            VColor[5].setText("金");
                            break;
                        case '銀':
                            letters[5].setColorFilter(mcolor_Silver);
                            VColor[5].setText("銀");
                            break;
                        default:
                            //cerro2(content2[0]);
                            VColor[5].setText("查無色碼請通知系統資訊部");
                            break;
                    }
                } else {
                    VColor[5].setVisibility(INVISIBLE);
                    letters[5].setVisibility(INVISIBLE);
                }
            }catch  (Exception e) {
            }
            ///////////////\
            bg_t.setVisibility(VISIBLE);
            bg.setVisibility(VISIBLE);
            bg_t.setText("底漆 : " + secpart);
            switch (secpart) {  //底色
                case "MM02-藍色A":
                    bg.setColorFilter(rcolor_blue);
                    bg_t.setText("底色 : MM02-藍色A");
                    break;
                case "蘋果綠":
                    bg.setColorFilter(rcolor_ag);
                    bg_t.setText("底色 : 蘋果綠");
                    break;
                case "磚紅":
                    bg.setColorFilter(rcolor_bred);
                    bg_t.setText("底色 : 磚紅");
                    break;
                case "MO 藍色":
                    bg.setColorFilter(rcolor_mblue);
                    bg_t.setText("底色 : MO 藍色");
                    break;
                case "粉紅B":
                    bg.setColorFilter(rcolor_pink);
                    bg_t.setText("底色 : 粉紅B");
                    break;
                case "紫色":
                    bg.setColorFilter(rcolor_purple);
                    bg_t.setText("底色 : 紫色");
                    break;
                case "MP106 粉紅":
                    bg.setColorFilter(rcolor_mp106);
                    bg_t.setText("底色 : MP106 粉紅");
                    break;
                case "金屬 墨綠":
                    bg.setColorFilter(rcolor_gd);
                    bg_t.setText("底色 : 金屬 墨綠");
                    break;
                case "內 MP106":
                    bg.setColorFilter(rcolor_mp1062);
                    bg_t.setText("底色 : 內 MP106");
                    break;
                case "綠色":
                    bg.setColorFilter(rcolor_green);
                    bg_t.setText("底色 : 綠色");
                    break;
                case "碳膜 乳黃":
                    bg.setColorFilter(rcolor_my);
                    bg_t.setText("底色 : 碳膜 乳黃");
                    break;
                case "CM02 碳膜乳黃":
                    bg.setColorFilter(rcolor_cm02my);
                    bg_t.setText("底色 : CM02 碳膜乳黃");
                    break;
                case "粉紅A":
                    bg.setColorFilter(rcolor_pa);
                    bg_t.setText("底色 : 粉紅A");
                    break;
                case "粉紅A ":
                    bg.setColorFilter(rcolor_pa);
                    bg_t.setText("底色 : 粉紅A");
                    break;
                case "MM02 藍色A":
                    bg.setColorFilter(rcolor_mm02);
                    bg_t.setText("底色 : MM02 藍色A");
                    break;
                case "7921 藍色B":
                    bg.setColorFilter(rcolor_blue);
                    bg_t.setText("底色 : 7921 藍色B");
                    break;
                case "MP106 粉紅B":
                    bg.setColorFilter(rcolor_106b);
                    bg_t.setText("底色 : MP106 粉紅B");
                    break;
                case "藍":
                    bg.setColorFilter(mcolor_Blue);
                    bg_t.setText("底色 :藍");
                    break;
                case "MP106漆":
                    bg.setColorFilter( mcolor_pinkb);
                    bg_t.setText("底色 : MP106漆");
                    break;

                case "MP106":
                    bg.setColorFilter( mcolor_pinkb);
                    bg_t.setText("底色 : MP106");
                    break;
                case "2070":
                    bg.setColorFilter(mcolor_bluea);
                    bg_t.setText("底色 : 2070");
                    break;
                case "7921漆":
                    bg.setColorFilter(mcolor_blue2);
                    bg_t.setText("底色 : 7921漆");
                    break;
                case "7921":
                    bg.setColorFilter(mcolor_blue2);
                    bg_t.setText("底色 : 7921漆");
                    break;
                case "Z0415":
                    bg.setColorFilter(mcolor_pinka);
                    bg_t.setText("底色 : Z0415");
                    break;
                case "Z360":
                    bg.setColorFilter(mcolor_yellow);
                    bg_t.setText("底色 : Z360");
                    break;
                case "蘋果綠不燃性漆":
                    bg.setColorFilter(mcolor_apple);
                    bg_t.setText("底色 : 蘋果綠不燃性漆");
                    break;
                case "綠色不燃性漆":
                    bg.setColorFilter(mcolor_green2);
                    bg_t.setText("底色 : 綠色不燃性漆");
                    break;
                case "藍色不燃性漆":
                    bg.setColorFilter(mcolor_bluem);
                    bg_t.setText("底色 : 藍色不燃性漆");
                    break;
                case "紫色不燃性漆":
                    bg.setColorFilter(mcolor_purple2);
                    bg_t.setText("底色 : 紫色不燃性漆");
                    break;
                case "磚紅不燃性漆":
                    bg.setColorFilter(mcolor_red);
                    bg_t.setText("底色 : 磚紅不燃性漆");
                    break;
                case "金屬塗料":
                    bg.setColorFilter(mcolor_metal);
                    bg_t.setText("底色 : 金屬塗料");
                    break;
                default:
                    System.out.println("查無==>"+secpart);
                    bg.setColorFilter(rcolor_w);
                    //LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(100, 100);
                    //bg.setLayoutParams(layoutParams);
                    bg_t.setText("底色 : ");
                    notfind_c=secpart;
                    Colorinfo.setText("查無底色碼請通知系統資訊部");
                    break;
            }
        }
    };
    final Handler myMessageHandler = new Handler() {
        public void handleMessage(Message msg1) {
            super.handleMessage(msg1);
            messageview.invalidate();
            messageview.setText("訊息:" + Message); if(Message.indexOf("外檢1")>-1){
                DEPT_Texted.setText("外檢底漆");
            }else if(Message.indexOf("外檢2")>-1){
                DEPT_Texted.setText("外檢色碼");
            }
            url_Texted.invalidate();
            url_Texted.setText(url_stting);
            InputQuan_Texted.setText("");
            AccQuan_Texted.setText("");
            final_Texted.setText("");
            furyu_Texted.setText("");
            if (!Process.equals("花蓮貼帶")) {
                try {
                    float i2 = Float.parseFloat(AccQuan);
                    v_flow_title.setText("本製程已完成" + i2);
                } catch (NullPointerException e) {
                    v_flow_title.setText(AccQuan);
                }
            }


        }
    };
    final Handler delpent = new Handler() {
        public void myMessageHandler(Message msg) {
            ifLeader = "0";
            AccQuan_Texted.setText("");
            url_Texted.setText("  " + url_stting);
            VAL_text_value.setText("  ");
            note_value.invalidate();
            note_value.setText("  ");
            mfo_id_text_value.setText("  ");
            BATCH_QTY_text_value.setText("  ");
            DELDATE_text_value.setText("  ");
            RTYPE_text_value.setText("  ");
            BATCH_NO_text_value.setText("  ");
            TOL_text_value.setText("  ");
            v_flow_title.setText("  ");
            PPM_text_value.setText("  "); if(Message.indexOf("外檢1")>-1){
                DEPT_Texted.setText("外檢底漆");
            }else if(Message.indexOf("外檢2")>-1){
                DEPT_Texted.setText("外檢色碼");
            }
            messageview.setText("訊息:");
            url_Texted.invalidate();
            url_Texted.setText(url_stting);
            AccQuan_Texted.setText(StepLeft);
            testbutton.setVisibility(VISIBLE);
            accident.setText("開始");
            accident.setVisibility(VISIBLE);
            sptest.setVisibility(INVISIBLE);
            part_finish_bnt.setVisibility(INVISIBLE);
            startflig = 0;
        }
    };
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {
            try {
                if (final_Texted.getText().toString().equals("") || furyu_Texted.getText().toString().equals(""))
                {}else{
                    int in =  Integer.valueOf(InputQuan_Texted.getText().toString());
                }
            } catch (Exception e) {

            }

            // TODO Auto-generated method stub
            try {
                if (final_Texted.getText().toString().equals("")
                        || furyu_Texted.getText().toString().equals(""))
                {}else{
                    int fi=0;
                    int in =  Integer.valueOf(InputQuan_Texted.getText().toString());
                    fi = Integer.valueOf(final_Texted.getText().toString());
                    int fu1 = Integer.valueOf(final_Texted.getText().toString().replaceAll("\\.", ""));

                    if (final_Texted.getText().toString().indexOf(".0")>-1){
                        fu1 = Integer.valueOf(final_Texted.getText().toString().replaceAll("\\.0", ""));
                    }else{
                        fu1 = Integer.valueOf(final_Texted.getText().toString().replaceAll("\\.", ""));
                    }

                    // int fu = Integer.valueOf(furyu_Texted.getText().toString());
                    //int acc = Integer.valueOf(AccQuan_Texted.getText().toString());

                    if (Process.equals("花蓮貼帶")) {//貼帶完成選支數或捲數
                        sumacc = in - fi ;
                        int selected = TieDaigroup.getCheckedRadioButtonId();
                        RadioButton radioBtn1 = (RadioButton) findViewById(selected);
                        float in1 = Float.parseFloat(tdRollQty.toString());
                        if (radioBtn1.getText().equals("支數")){
                            Message m = new Message();
                            m.what = MEG_INVALIDATE;
                            updateacc.sendMessage(m);
                        }else{

                            if (final_Texted.getText().toString().indexOf(".0")>-1){
                                fi = Integer.valueOf(final_Texted.getText().toString().replaceAll("\\.0", ""));
                            }else{
                                fi = Integer.valueOf(final_Texted.getText().toString().replaceAll("\\.", ""));
                            }
                            sumacc = in  -  ((fi*in1*1000));
                            System.out.println("in=>  "+in+"sumaccsumacc=>  "+sumacc+"  fi=>  "+fi+"  inl=>"+in1);
                            Message m = new Message();
                            m.what = MEG_INVALIDATE;
                            updateacc.sendMessage(m);
                        }
                        //System.out.println("0000000" + sumacc +" | " + in +" | "+ fu +" | "+ fi);

                    } else {
                        int fu = Integer.valueOf(furyu_Texted.getText().toString());

                        if (furyu_Texted.getText().toString().indexOf(".0")>-1){
                            fu = Integer.valueOf(furyu_Texted.getText().toString().replaceAll("\\.0", ""));
                        }else{
                            fu = Integer.valueOf(furyu_Texted.getText().toString().replaceAll("\\.", ""));
                        }
                        sumacc = in - fi- fu;
                        Message m = new Message();
                        m.what = MEG_INVALIDATE;
                        updateacc.sendMessage(m);
                    }
                }
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
    private TextWatcher textWatcher2 = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {
            try {
                int fu = Integer.valueOf(furyu_Texted.getText().toString());
                int fi=0;
                String f=InputQuan_Texted.getText().toString();
                f=f.replaceAll("\\.", "");
                int in =  Integer.valueOf(f);
                int fu1 = Integer.valueOf(final_Texted.getText().toString().replaceAll("\\.", ""));
                int fi1 = Integer.valueOf(AccQuan_Texted.getText().toString().replaceAll("\\.", ""));
                sumacc = in - fi1- fu1;

                Message m = new Message();
                m.what = MEG_INVALIDATE;
                updateacc2.sendMessage(m);
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
    final Handler updateacc = new Handler() {
        public void handleMessage(Message msg1) {
            super.handleMessage(msg1);
            if (sumacc < 0) {
                sumacc = 0;
            }
            String k = Float.toString(sumacc);
            AccQuan_Texted = (EditText) findViewById(R.id.AccQuan_Texted);
            final_Texted = (EditText) findViewById(R.id.final_Texted);
            AccQuan_Texted.setText(k.toString());
            AccQuan_Texted.setFocusable(false);
        }
    };
    final Handler updateacc2 = new Handler() {
        public void handleMessage(Message msg1) {
            super.handleMessage(msg1);
            if (sumacc < 0) {
                sumacc = 0;
            }
            String k = Float.toString(sumacc);
            final_Texted.setText(k.toString());
        }
    };
    final Handler FinshMessageHandler = new Handler() {
        public void handleMessage(Message msg1) {
            super.handleMessage(msg1);
            InputQuan_Texted.setText("");
            AccQuan_Texted.setText("");
            final_Texted.setText("");
            furyu_Texted.setText("");
            if(ifLeader.equals("0")|| start_edit!=1 || !InputQuan.equals("0") || Process.equals("花蓮色碼")){
                InputQuan_Texted.setFocusable(true);
            }else {
                InputQuan_Texted.setFocusable(true);
                InputQuan_Texted.setFocusableInTouchMode(true);
            }
        }
    };

    final Handler FinshMessageHandleurl = new Handler() {
        public void handleMessage(Message msg1) {
            super.handleMessage(msg1);
            url_Texted.setText("  " + url_stting);

        }
    };

    final Handler AfterFinshMessageHandle = new Handler() {
        public void handleMessage(Message msg1) {
            super.handleMessage(msg1);
            outa=0;
            //final_Texted = (EditText) view.findViewById(R.id.final_Texted);
            float i2 = Float.parseFloat(AccQuan);
            //float newf=finalint+i2;
            if (cut_flag==1){  //切割測試 完成=0
                cut_flag=0; //切割測試 完成=0
                final_Texted.setText("0");
            }
            if (!Process.equals("花蓮貼帶")) {
                v_flow_title.setText("本製程已完成" + i2);
            }
            //System.out.println("0000000000000000000000000");
            InputQuan_Texted.setText(InputQuan);
            final_Texted.setText("");
            popMsg=popMsg+conf_flag;
            if (popMsg.length() > 1) {
                popMsg = popMsg.replaceAll("\"", "");
                popMsg = popMsg.replaceAll("\\\\", "");
                popMsg = popMsg.replaceAll("\\[", "");
                popMsg = popMsg.replaceAll("\\]", "");
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage(popMsg);
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //getinfo = (Button) findViewById(R.id.GET_INFO);
                        //getinfo.performClick();
                    }
                });
                if (popMsg.indexOf("null") > -1) {
                    popMsg = "";
                } else {
                    builder.show();
                    getinfo = (Button) findViewById(R.id.GET_INFO);
                    //自動取得
                    //getinfo.performClick();
                }
            } else {
                url_Texted.setText("  " + url_stting);
                chang_color = 0;
            }
            if (Process.equals("全檢備註")){
                Process="花蓮全檢";
            }
            if (Process.equals("切割檢驗")){
                Process="花蓮切割";
            }
            if (Process.indexOf("全")>-1||Process.indexOf("外")>-1){
                getinfo = (Button) findViewById(R.id.GET_INFO);
                //全檢時自動取得
                getinfo.performClick();
            }
            View rootView = getWindow().getDecorView().getRootView();
            getg(rootView);
            //全檢1.2改回花蓮
            //getinfo = (Button) findViewById(R.id.GET_INFO);
            //getinfo.performClick();
        }
    };
    int r=0;

    public void myPodRecords(View view) {

        final String[] result_title = {""};
        final ArrayList<String> mylist = new ArrayList<String>();
        Thread thread_myPrdRecords = new Thread(new Runnable() {
            public void run() {
                try {
                    String encodedUrl = "", encodedUr2 = "";
                    if (!(userBar.indexOf("*") > -1)) {
                        userBar = "*" + userBar;
                    }
                    //select_size="&size="+my_size_spinner.getSelectedItem().toString();
                    encodedUrl = URLEncoder.encode(userBar, "UTF-8");
                    call_rest restObj = new call_rest();
                    //select_size= "&size="+my_size_spinner.getSelectedItem().toString();
                    String u=host +
                            "PrdMgn/myPrdRecords?userBar=" + encodedUrl
                            +shiftType+select_size;

                        u=u+"&dept="+Process;

                    JSONObject rtnRestObj = restObj.callRest(u);//
                    //JSONArray array = new JSONArray(rtnRestObj.getString("Data"));
                    select_size= select_size.replaceAll("&size=", "");
////////////////////////////////////////
                    /*String sb="{\n" +
                            "    \"Succ\": true,\n" +
                            "    \"Code\": \"0000\",\n" +
                            "    \"Message\": \"我的本日生產紀錄\",\n" +
                            "    \"DataTime\": \"2020/07/23 04:13\",\n" +
                            "    \"Data\": \"已完成筆數 ： 0， 未完成筆數 ： 1；[{\\\"MASTER_MFO_ID\\\":\\\"F-8-EFPJB195A\\\",\\\"SIZE\\\":\\\"1.7x5.4\\\",\\\"VAL\\\":\\\"2K\\\",\\\"Tol\\\":\\\"5\\\",\\\"batch\\\":\\\"1/28\\\",\\\"MachineID\\\":\\\"5-116\\\",\\\"InputQuan\\\":28000,\\\"OutputQuan\\\":13750,\\\"StepLeft\\\":14250,\\\"signStart\\\":\\\"\\\\/Date(1595477241000)\\\\/\\\"}]\"\n" +
                            "}";
                    JSONObject rtnRestObj=new JSONObject(sb.toString());*/

////////////////////////////////
                    /////////////////////////
                    String d=rtnRestObj.getString("Data");
                    String[] separated = d.split("；");
                    JSONArray array = new JSONArray(separated[1]);
                    result_title[0] =separated[0];
                    ////////////////
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject jsonObject = array.getJSONObject(i);
                        String myPrd_MASTER_MFO_ID = jsonObject.getString("MASTER_MFO_ID");
                        String myPrd_batch = jsonObject.getString("batch");
                        String myPrd_MachineID = jsonObject.getString("MachineID");
                        String myPrd_InputQuan = jsonObject.getString("InputQuan");
                        String myPrd_OutputQuan = jsonObject.getString("OutputQuan");
                        //20200818
                        String myPrd_Tol = jsonObject.getString("Tol").equals("null")  ? "" : jsonObject.getString("Tol");
                        String myPrd_Val = jsonObject.getString("VAL") .equals("null") ? "" : jsonObject.getString("VAL");
                        String myPrd_Rtype = jsonObject.getString("RTYPE") .equals("null") ? "" : jsonObject.getString("RTYPE");
                        String myPrd_ng2= "",myPrd_ng3= "",myPrd_ng1 = "";
                        if (Process.indexOf("外")>-1){
                            myPrd_ng2 = jsonObject.getString("NG3") .equals("null") ? "" : jsonObject.getString("NG3");
                            myPrd_ng3 = jsonObject.getString("NG2") .equals("null") ? "" : jsonObject.getString("NG2");
                            myPrd_ng1 = jsonObject.getString("NG1") .equals("null") ? "" : jsonObject.getString("NG1");
                        }
//                        String myPrd_DefectQuan = jsonObject.getString("DefectQuan");
                        String myPrd_StepLeft = jsonObject.getString("StepLeft");
                        String my="工令單號:" + myPrd_MASTER_MFO_ID + "\t\t\t流程單號:" + myPrd_batch + "\t\t" + "機台:" + myPrd_MachineID + "\n" +
                                myPrd_Val+"\t\t"+myPrd_Tol+"%"+"\t\t"+"開始量:" + myPrd_InputQuan + "\t\t完成量:" + myPrd_OutputQuan + "\t\t" +
                                /* "不良品:" + myPrd_DefectQuan + */"交接量:" + myPrd_StepLeft;
                        if (Process.indexOf("外")>-1){
                            //NG 2.3 DB 撈顛倒
                            my=my+"\nNG1: "+myPrd_ng1+"   NG2: "+myPrd_ng3+"   NG3: "+myPrd_ng2;
                        }
                        System.out.println(my+"my");
                        mylist.add(my);
                        if (i== array.length()-1)
                        {

                            mylist.add("  ");
                            mylist.add("  ");
                            mylist.add("  ");
                        }
                    }
                } catch (Exception e) {

                    CharArrayWriter cw = new CharArrayWriter();
                    PrintWriter w = new PrintWriter(cw);
                    e.printStackTrace(w);
                    w.close();
                    trace = cw.toString();
                    e.printStackTrace();
                    View rootView = getWindow().getDecorView().getRootView();
                    send_urlsting(rootView); e.printStackTrace();
                }
            }
        });  //thread_ver
        thread_myPrdRecords.start();
        Message msg1 = new Message();
        msg1.what = MEG_INVALIDATE;
        HSmoreprogressBar.sendMessage(msg1);
        int i = 0;
        while (true) {
            try {
                Thread.sleep(2000);
                i++;
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                final View v = inflater.inflate(R.layout.mypodrecords, null);   //   get viwe layout
                final Button Time_button_1,Time_button_2,Time_button_3,Time_button_4,logout;
                Time_button_1=(Button) v.findViewById(R.id.Time_button_1);
                Time_button_2=(Button) v.findViewById(R.id.Time_button_2);
                Time_button_3=(Button) v.findViewById(R.id.Time_button_3);
                Time_button_4=(Button) v.findViewById(R.id.Time_button_4);  
                final AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                final AlertDialog OptionDialog = dialog.create();


                ListView listview = (ListView) v.findViewById(R.id.dynamicmy);
                my_size_spinner=(Spinner) v.findViewById(R.id.my_size_spinner);
                String[] arraySpinner = new String[] {
                        "全尺寸","1x3.15","0.8x1.9","1.7x5.4","其他"
                };
                ArrayAdapter<String> adapter_size = new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, arraySpinner);
                adapter_size.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                final TextView my_info=(TextView) v.findViewById(R.id.my_info);
                ArrayAdapter adapter = new ArrayAdapter(this,
                        android.R.layout.simple_list_item_1,
                        mylist) {
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        View view = super.getView(position, convertView, parent);
                        TextView tv = (TextView) view.findViewById(android.R.id.text1);
                        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
                        return view;
                    }
                };my_size_spinner.setAdapter(adapter_size);
                my_info.setText("查詢結果 : "+result_title[0]+" 　　 "+select_size);

                if (!select_size.equals("")) {
                    int spinnerPosition = adapter_size.getPosition(select_size);
                    my_size_spinner.setSelection(spinnerPosition,true);
                }
                TextView title = new TextView(this);
                title.setText("我的生產查詢");
                title.setGravity(Gravity.CENTER);
                title.setTextSize(24);
                dialog.setCustomTitle(title);
                dialog.setView(v);
                listview.setAdapter(adapter);
                dialog.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        r=0; //mothing
                        select_size="";
                        shiftType="";
                        Message msg1 = new Message();
                        msg1.what = MEG_INVALIDATE;
                        HmoreprogressBar.sendMessage(msg1);
                    }
                });
                if (logout_flag==1){

                    Message msg = new Message();
                    msg.what = MEG_INVALIDATE;
                    loading1.sendMessage(msg);
                  /*  dialog.setPositiveButton("登出", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            View rootView = getWindow().getDecorView().getRootView();
                            exit(rootView);
                        }
                    });*/
                }
                if (r==0){
                final AlertDialog dlg = dialog.show();

                    my_size_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                            select_size=parentView.getItemAtPosition(position).toString();
                            //moreprogressBar.setVisibility(VISIBLE);

                            System.out.println("==="+select_size);
                            if (select_size.indexOf("全")>-1){select_size="&size=全尺寸";}else{
                                select_size="&size="+select_size;
                                dlg.dismiss();
                                View rootView = getWindow().getDecorView().getRootView();
                                myPodRecords(rootView);
                            }


                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parentView) {
                            select_size="";
                        }

                    });
                    Time_button_1.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub

                            Message msg1 = new Message();
                            msg1.what = MEG_INVALIDATE;
                            HSmoreprogressBar.sendMessage(msg1);
                            shiftType="&shiftType=1";
                            //r=1;
                            dlg.dismiss();
                            View rootView = getWindow().getDecorView().getRootView();
                            myPodRecords(rootView);
                        }
                    });

                    Time_button_2.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            shiftType="&shiftType=2";
                            //r=1;
                            dlg.dismiss();

                            Message msg1 = new Message();
                            msg1.what = MEG_INVALIDATE;
                            HSmoreprogressBar.sendMessage(msg1);
                            View rootView = getWindow().getDecorView().getRootView();
                            myPodRecords(rootView);
                        }
                    });

                    Time_button_3.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            shiftType="&shiftType=3";

                            Message msg1 = new Message();
                            msg1.what = MEG_INVALIDATE;
                            HSmoreprogressBar.sendMessage(msg1);
                            dlg.dismiss();
                            //r=1;
                            View rootView = getWindow().getDecorView().getRootView();
                            myPodRecords(rootView);
                        }
                    });

                    Time_button_4.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            shiftType="&shiftType=4";
                            Message msg1 = new Message();
                            msg1.what = MEG_INVALIDATE;
                            HSmoreprogressBar.sendMessage(msg1);
                            //r=1;
                            dlg.dismiss();
                            View rootView = getWindow().getDecorView().getRootView();
                            myPodRecords(rootView);
                        }
                    });
                WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
                //視窗長寬
                params.width = 1500;
                params.height = 600;
                //button text size
                dlg.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
                dlg.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
                dlg.getWindow().setAttributes(params);}
                else{
                    adapter.notifyDataSetChanged();
                }
                break;
            } catch (InterruptedException e) {

            }
        }
    }/*
    public void Time_button_1(View view) {
        shiftType="&shiftType=1";
        myPodRecords(view);
    }
    public void Time_button_2(View view) {
        shiftType="&shiftType=2";
        myPodRecords(view);
    }
    public void Time_button_3(View view) {
        shiftType="&shiftType=3";
        myPodRecords(view);
    }
    public void Time_button_4(View view) {
        shiftType="&shiftType=4";
        myPodRecords(view);
    }*/
    public void part_finish(View view) {//小批完成
        part_finish = 1;
        temp_int = 1;
        float c_input = 0, c_final = 0, c_furtu = 0, c_acc = 0;
        try {
            c_input = Float.parseFloat(InputQuan_Texted.getText().toString());
            c_final = Float.parseFloat(final_Texted.getText().toString());
            c_furtu = Float.parseFloat(furyu_Texted.getText().toString());
            c_acc = Float.parseFloat(AccQuan_Texted.getText().toString());
        } catch (NumberFormatException e) {
        }
        Thread thread = new Thread(new Runnable() {
            public void run() {
                String note, new_MachineID, new_DEPT, new_MachineParams, new_FLOW_STEP, new_Start_TIME, new_Finish_Time, new_InputQuan = "0", new_AccQuan = "0", new_final = "0", new_furtu = "0", old_InputQuan;
               // new_MachineID = spinner.getSelectedItem().toString();
                //new_DEPT = DEPT_Texted.getText().toString();
                note = note_value.getText().toString();
                try {
                    perf = 1;
                    new_MachineParams = MachineParams_Texted.getText().toString();
                    new_InputQuan = InputQuan_Texted.getText().toString();
                    new_AccQuan = AccQuan_Texted.getText().toString();
                    new_final = final_Texted.getText().toString();
                    new_furtu = furyu_Texted.getText().toString();
                    if (new_InputQuan.equals("") || new_InputQuan.equals(null)) {
                        new_InputQuan = "0";
                    }
                    if (new_final.equals("") || new_final.equals(null)) {
                        new_final = "0";
                    }
                    if (new_furtu.equals("") || new_furtu.equals(null)) {
                        new_furtu = "0";
                    }
                    newacc = Float.parseFloat(new_InputQuan.toString());
                    finalint = Float.parseFloat(new_final.toString());
                    furtu = Float.parseFloat(new_furtu.toString());
                    input_int = Float.parseFloat(new_InputQuan.toString());
                    newACCDefect = newacc + furtu;
                    String ACCsrt = valueOf(newACCDefect);//newACCDefect.toString()
                } catch (NumberFormatException e) {

                }
                String new_uid = userBar.replaceAll("\\*", "");
                try {
                    if (new_final.equals("")) {
                        new_final = "0";
                    }
                    if (new_furtu.equals("")) {
                        new_furtu = "0";
                    }
                    if (new_AccQuan.equals("")) {
                        new_AccQuan = "0";
                    }
                    g_list.put("InputQuan", new_InputQuan);
                    g_list.put("OutputQuan", new_final);
                    g_list.put("DefectQuan", new_furtu);
                    g_list.put("StepLeft", new_AccQuan);
                    g_list.put("FLOW_STEP", URLEncoder.encode(FLOW_STEP, "UTF-8"));
                    g_list.put("Note", URLEncoder.encode(note, "UTF-8"));
                    g_list.put("SIGNID", SIGNID);
                    String encodedUrl = "", encodedUr2 = "", encodedUr3 = "", encodedUr4 = "";
                    encodedUrl = URLEncoder.encode(flowBar, "UTF-8");
                    encodedUr2 = URLEncoder.encode(userBar, "UTF-8");
                    encodedUr3 = URLEncoder.encode(machineBar, "UTF-8");
                    encodedUr4 = URLEncoder.encode(Process, "UTF-8");
                    String u = host + "PrdMgn/ScanOperate?command=9&UID=" + encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3;
                    url = host + "PrdMgn/ScanOperate?command=9&UID=" + encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3;
                    HttpClient http = new DefaultHttpClient();
                    HttpPost post = new HttpPost(u);
                    //完成送出
                    Message msg = new Message();
                    msg.what = MEG_INVALIDATE;
                    myMessageHandler.sendMessage(msg);
                    String g_list2 = g_list.toString();//小批完成
                    url_stting = host + "PrdMgn/ScanOperate?command=9&UID=" + encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3 + "&jsonStr" + g_list2;
                    System.out.println(url_stting);
                    List params = new ArrayList();
                    params.add(new BasicNameValuePair("jsonStr", g_list2));
                    UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params, HTTP.UTF_8);
                    post.setEntity(ent);
                    HttpResponse responsePOST = http.execute(post);
                    HttpEntity resEntity = responsePOST.getEntity();
                    String result = EntityUtils.toString(resEntity);
                    JSONObject loginJson = new JSONObject(result.toString());
                    Message = loginJson.getString("Message");
                    code = loginJson.getString("Code");
                    Succ = loginJson.getString("Succ");
                    g_json_string = loginJson.getString("Data");
                    update_ui(loginJson);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });  //Thread  end
        thread.start();//送出完成
        int i = 0;
        while (true) {
            i++;
            if (i == 10) {
                getinfo = (Button) findViewById(R.id.GET_INFO);
                //getinfo.performClick();
                break;
            }
        }
    }
    public void more(View view) {
        logout_flag=0;

        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        final View v = inflater.inflate(R.layout.more, null);   //   get viwe layout\
        final AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        TextView title = new TextView(this);
        title.setText("more");
        title.setGravity(Gravity.CENTER);
        title.setTextSize(24);
        dialog.setCustomTitle(title);
        dialog.setView(v);
        dialog.setNeutralButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //mothing
            }
        });
        Button button22=(Button) v.findViewById(R.id.button22);
        Button button23=(Button) v.findViewById(R.id.button23);
        moreprogressBar=(ProgressBar) v.findViewById(R.id.moreprogressBar);

    if (Process.equals("花蓮電鍍")&&facroryNo==1){
            button22.setVisibility(VISIBLE);
        }else{
            button22.setVisibility(GONE);
        }
        final AlertDialog dlg = dialog.show();
        button23.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                myUnfinishedRecords(v);
                dlg.dismiss();
            }

        });
        WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
        //視窗長寬
        params.width = 1200;
        params.height = 800;
        //button text size
        dlg.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
        dlg.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
        dlg.getWindow().setAttributes(params);
    }
    public void prdStepRecords(View view) {
        //2021.11.20
        final ArrayList<String> mylist = new ArrayList<String>();
        Thread thread_myPrdRecords = new Thread(new Runnable() {
            public void run() {
                try {
                    String encodedUrl = "", encodedUr2 = "";
                    if (!(userBar.indexOf("*") > -1)) {
                        userBar = "*" + userBar;
                    }
                    encodedUrl = URLEncoder.encode(userBar, "UTF-8");
                    call_rest restObj = new call_rest();
                    JSONObject rtnRestObj = restObj.callRest( host+"PrdMgn/prdStepRecords?signID="+SIGNID );
                    JSONArray array = new JSONArray(rtnRestObj.getString("Data"));
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject jsonObject = array.getJSONObject(i);
                        String myPrd_Start_TIME = jsonObject.getString("Start_TIME");
                        String myPrd_Finish_Time = jsonObject.getString("Finish_Time");
                        String myPrd_InputQuan = jsonObject.getString("InputQuan");
                        String myPrd_EMPNAME = jsonObject.getString("EMPNAME");
                        String myPrd_MachineID = jsonObject.getString("MachineID");
                        String myPrd_OutputQuan = jsonObject.getString("OutputQuan");
                        String myPrd_SIGNID = jsonObject.getString("SIGNID");
                        String naiBeiComplete = jsonObject.getString("naiBeiComplete");
                        //20200818 flow step
                        String myPrd_flowstep = jsonObject.getString("Flow_Step") .equals("null") ? "" : jsonObject.getString("Flow_Step");
                        String edit="";
                        if (naiBeiComplete.equals("null")) naiBeiComplete = "0";
                        String DefectQuan1 = jsonObject.getString("DefectQuan1");
                        if (DefectQuan1.equals("null")) DefectQuan1 = "0";
                        if (name.equals(myPrd_EMPNAME)||ifLeader.equals("1")){
                            edit="\t<可修改>";
                        }else{
                            edit="\t<不可修改>";
                        }
                        mylist.add("姓名:" + myPrd_EMPNAME + "\t\t\t" + myPrd_flowstep+ "\t\t\t"  + myPrd_MachineID+edit
                                + "\r\n開始:" + myPrd_Start_TIME + "\t\t\t完成:" + myPrd_Finish_Time + "\r\n"
                                + "開始量:" + myPrd_InputQuan + "\t\t\t完成量:" + myPrd_OutputQuan + "\t\t\t小批完成量:" + naiBeiComplete +
                                "\t\t\tSIGNID:"+ myPrd_SIGNID
                        );
                    }
                    mylist.add( ""               );
                } catch (Exception e) {

                    CharArrayWriter cw = new CharArrayWriter();
                    PrintWriter w = new PrintWriter(cw);
                    e.printStackTrace(w);
                    w.close();
                    trace = cw.toString();
                    e.printStackTrace();
                    View rootView = getWindow().getDecorView().getRootView();
                    send_urlsting(rootView);
                }
            }
        });
        try{
        if(SIGNID.equals("")){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("未掃描工令單");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
            builder.show();
        }else{

            thread_myPrdRecords.start();  //thread_ver
            int i = 0;
            while (true) {
                try {
                    Thread.sleep(1000);
                    i++;
                    LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                    final View v = inflater.inflate(R.layout.mysteprecords, null);   //   get viwe layout
                    final ListView listview2 = (ListView) v.findViewById(R.id.mydynamicmy2);
                    final AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    TextView title = new TextView(this);
                    final Button closebnt=v.findViewById(R.id.closebnt);
                    dialog.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //mothing
                        }
                    });
                    title.setText("本流程單製程查詢");
                    ArrayAdapter adapter = new ArrayAdapter(this,
                            android.R.layout.simple_list_item_1,
                            mylist) {
                        @Override
                        public View getView(int position, View convertView, ViewGroup parent) {
                            View view = super.getView(position, convertView, parent);
                            TextView tv = (TextView) view.findViewById(android.R.id.text1);
                            tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
                            return view;
                        }
                    };

                    listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                            String itemValue    = (String) listview2.getItemAtPosition(position);
                            final String[] nurl = itemValue.split("ID:");
                            SIGNID=nurl[1];
                            if(itemValue.indexOf(name)>-1||ifLeader_user.equals("1")){
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage("是否修改");
                                builder.setCancelable(false);
                                builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog2, int id) {
                                        closebnt.performClick();
                                        View rootView = getWindow().getDecorView().getRootView();
                                        userselect_flag="1";
                                        admin(rootView);
                                    }
                                });
                                builder.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });
                                builder.show();
                            }else {

                            }



                            //Toast.makeText(SuggestionActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                        }
                    });

                    title.setGravity(Gravity.CENTER);
                    title.setTextSize(24);
                    dialog.setCustomTitle(title);
                    dialog.setView(v);
                    listview2.setAdapter(adapter);
                    final AlertDialog dlg = dialog.show();
                    closebnt.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dlg.dismiss();
                        }
                    });
                    WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
                    //視窗長寬
                    params.width = 1200;
                    params.height = 600;
                    //button text size
                    dlg.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
                    dlg.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
                    dlg.getWindow().setAttributes(params);

                    break;
                } catch (InterruptedException e) {

                }
            }
        }

        }catch (Exception e) {
        }
    }

    public void mid_select_map(View view) {
        //9*7
        midflag = 0;
        upmid();
        while (midflag == 0) {
            try {
                Thread.sleep(500); //1000為1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        final LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        int subi = 0;
        final View v = inflater.inflate(R.layout.mid_select_map, null);
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        TextView title = new TextView(this);
        title.setGravity(Gravity.CENTER);
        title.setTextSize(24);
        dialog.setCustomTitle(title);
        dialog.setView(v);
        /////////////////////////
        final Button[] myButton = new Button[200];
        final Button[] myButtonund = new Button[200];
        final LinearLayout[] bnt_layout = new LinearLayout[20];
        bnt_layout[0] = (LinearLayout) v.findViewById(R.id.buttonlayout);
        bnt_layout[1] = (LinearLayout) v.findViewById(R.id.buttonlayout2);
        bnt_layout[2] = (LinearLayout) v.findViewById(R.id.buttonlayout3);
        bnt_layout[3] = (LinearLayout) v.findViewById(R.id.buttonlayout4);
        bnt_layout[4] = (LinearLayout) v.findViewById(R.id.buttonlayout5);
        bnt_layout[5] = (LinearLayout) v.findViewById(R.id.buttonlayout6);
        bnt_layout[6] = (LinearLayout) v.findViewById(R.id.buttonlayout7);
        bnt_layout[7] = (LinearLayout) v.findViewById(R.id.buttonlayout8);
        bnt_layout[8] = (LinearLayout) v.findViewById(R.id.buttonlayout9);
        bnt_layout[9] = (LinearLayout) v.findViewById(R.id.buttonlayout10);
        //                 dialog window size ssetting
        final AlertDialog dlg = dialog.show();
        WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
        //視窗長寬
        if (facroryNo == 1) {//一廠配置
            bnt_layout[0] = (LinearLayout) v.findViewById(R.id.buttonlayout);
            bnt_layout[1] = (LinearLayout) v.findViewById(R.id.buttonlayout2);
            bnt_layout[2] = (LinearLayout) v.findViewById(R.id.buttonlayout3);
            bnt_layout[3] = (LinearLayout) v.findViewById(R.id.buttonlayout4);
            bnt_layout[4] = (LinearLayout) v.findViewById(R.id.buttonlayout5);
            bnt_layout[5] = (LinearLayout) v.findViewById(R.id.buttonlayout6);
            bnt_layout[6] = (LinearLayout) v.findViewById(R.id.buttonlayout7);
            bnt_layout[7] = (LinearLayout) v.findViewById(R.id.buttonlayout8);
            bnt_layout[8] = (LinearLayout) v.findViewById(R.id.buttonlayout9);
            bnt_layout[9] = (LinearLayout) v.findViewById(R.id.buttonlayout10);
            params.width = 1500;
        } else {//二廠配置
            bnt_layout[6] = (LinearLayout) v.findViewById(R.id.buttonlayout);
            bnt_layout[7] = (LinearLayout) v.findViewById(R.id.buttonlayout2);
            bnt_layout[8] = (LinearLayout) v.findViewById(R.id.buttonlayout3);
            bnt_layout[0] = (LinearLayout) v.findViewById(R.id.buttonlayout4);
            bnt_layout[1] = (LinearLayout) v.findViewById(R.id.buttonlayout5);
            bnt_layout[2] = (LinearLayout) v.findViewById(R.id.buttonlayout6);
            bnt_layout[3] = (LinearLayout) v.findViewById(R.id.buttonlayout7);
            bnt_layout[4] = (LinearLayout) v.findViewById(R.id.buttonlayout8);
            bnt_layout[5] = (LinearLayout) v.findViewById(R.id.buttonlayout9);
            params.width = 1500;
        }
        params.height = 1000;
        //button text size
        dlg.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
        dlg.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
        dlg.getWindow().setAttributes(params);
        ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        int list1 = 0, list2 = 0, list3 = 0, j = 0;
        final int sub_i = 1;
        String midv = "";
        try {
            for (int i = 0; i < midlist.size(); i++) {
                if (midlist.get(i).equals("new")) {
                    j++;
                } else {
                    myButton[i] = new Button(this);
                    myButton[i].setTextSize(16);
                    //myButton[i].setHeight(300);
                    myButton[i].setHeight(100);
                    if (Process.indexOf("全")>-1){
                        myButton[i].setWidth(150);
                    }else{
                        myButton[i].setWidth(90);
                    }

                    midv = midlist.get(i).toString();
                    midv = midv.replaceAll("status0", "");
                    midv = midv.replaceAll("status-1", "");
                    midv = midv.replaceAll("status1", "");
                    midv = midv.replaceAll("status2", "");
                    midv = midv.replaceAll("status3", "");
                    midv = midv.replaceAll("status4", "");
                    midv = midv.replaceAll("statusN", "");
                    //[上午11:04] ICD-曾建明
                    //    //machine_status : -1:無機, 0:待機 1:別人生產中  +2:故障  N:NA(不能於本製程使用的機台)
                    ////machine_status+2 本人操作, +3:正常運作本人操作本人\ , 4:故障
                    if (midlist.get(i).indexOf("status-1") > -1) {
                        myButton[i].setBackgroundColor(Color.WHITE);
                    } else if (midlist.get(i).indexOf("status0") > -1) {
                        //myButton[i].setBackgroundColor(Color.WHITE);
                    } else if (midlist.get(i).indexOf("status1") > -1) {
                        myButton[i].setBackgroundColor(Color.YELLOW);//非本人使用生產中=1
                    } else if (midlist.get(i).indexOf("status2") > -1) {//非本人故障
                        myButton[i].setBackgroundColor(Color.RED);
                    } else if (midlist.get(i).indexOf("status3") > -1) {
                        myButton[i].setBackgroundColor(Color.GREEN);//本人使用=3
                        //myButton[i].setEnabled(false);
                    } else if (midlist.get(i).indexOf("status4") > -1) {//本人故障
                        myButton[i].setBackgroundColor(Color.parseColor("#FF8000"));
                    } else if (midlist.get(i).indexOf("statusN") > -1) {//全檢不可使用機台
                        myButton[i].setBackgroundColor(Color.parseColor("#a8a7a5"));
                        //myButton[i].setEnabled(false);
                    } else if (midlist.get(i).indexOf("NULL") > -1) {
                        ///myButton[i].setBackgroundColor(Color.WHITE);
                        myButton[i].setText("null");
                    } else if (midlist.get(i).indexOf("null") > -1) {
                        myButton[i].setBackgroundColor(Color.WHITE);
                        myButton[i].setText("");
                        myButton[i].setEnabled(false);
                    }
                    if (!midv.equals("null")) {
                        myButton[i].setText(midv);
                    } else {
                        // myButton[i].setText("x");
                        //  myButton[i].setEnabled(false);
                    }
                    System.out.println("=========="+midv);
                    bnt_layout[j].addView(myButton[i], lp);

                    final int finalSubi = subi;
                    myButton[i].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            machineBar = myButton[finalSubi].getText().toString();
                            spinner.setVisibility(INVISIBLE);
                            String[] separated = machineBar.split("\\s+");
                            //mid 文字處理  切割 ==> o x o - 1
                            //              外檢 ==> o o o x
                            //              全檢 ==> o x
                            if (Process.equals("花蓮切割")){
                                if (separated[1].indexOf("-") > -1){

                                    machineBar = separated[1];
                                }
                                    else if (separated[1].indexOf("-") > -1) {
                                    machineBar = separated[1];
                                } else {
                                    machineBar = separated[2];
                                }
                            }else if (Process.equals("花蓮外檢")){
                                machineBar = separated[1];
                            }else if (Process.equals("花蓮全檢")){
                                machineBar = separated[1];
                            }else{
                                machineBar = separated[1];
                            }
                            TextView midtext = (TextView) findViewById(R.id.midtext);
                            midtext.setVisibility(VISIBLE);
                            midtext.setText("\t" + machineBar);
                            machine_but_flag = 1;
                            GetMachinStatus();
                            dlg.cancel();
                        }
                    });
                }
                subi++;
            }
            dialog.setPositiveButton("送出", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
        } catch (Exception e) {
            CharArrayWriter cw = new CharArrayWriter();
            PrintWriter w = new PrintWriter(cw);
            e.printStackTrace(w);
            w.close();
            trace = cw.toString();
            e.printStackTrace();
            View rootView = getWindow().getDecorView().getRootView();
            send_urlsting(rootView);
        }
    }
    private void GetMachinStatus() {//取得機台狀態
        Thread thread_GetMachinStatus = new Thread(new Runnable() {
            public void run() {
                try {
                    String userBar_encode = "", Process_encode = "", flowBar_encode = "";
                    Process_encode = URLEncoder.encode(Process, "UTF-8");
                    call_rest restObj = new call_rest();
                    JSONObject rtnRestObj = restObj.callRest(
                            host + "PrdMgn/apiGetMachinStatus?dept=" + Process_encode + "&MID=" + machineBar);
                    setting_status = Integer.valueOf(rtnRestObj.getString("Data"));
                    Message m = new Message();
                    m.what = MEG_INVALIDATE;
                    midhandler.sendMessage(m);
                } catch (Exception e) {
                    CharArrayWriter cw = new CharArrayWriter();
                    PrintWriter w = new PrintWriter(cw);
                    e.printStackTrace(w);
                    w.close();
                    trace = cw.toString();
                    e.printStackTrace();
                    View rootView = getWindow().getDecorView().getRootView();
                    send_urlsting(rootView);
                    e.printStackTrace();
                }
            }
        });
        if (!machineBar.equals("")){
            thread_GetMachinStatus.start();  //thread_ver
        }

    }
    final Handler midhandler = new Handler() {
        public void handleMessage(Message msg1) {
            super.handleMessage(msg1);
            ImageButton report = (ImageButton) findViewById(R.id.report);
            if (setting_status == 2) {
                report.setImageResource(R.drawable.ic_buildr);
            } else {
                report.setImageResource(R.drawable.ic_build);
            }
        }
    };
    final Handler midhandler1 = new Handler() {
        public void handleMessage(Message msg1) {
            super.handleMessage(msg1);

            AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
            builder2.setMessage("此機台在使用中，確定要讓此機台改為待機嗎?");
            builder2.setCancelable(false);
            builder2.setPositiveButton("是", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    call_rest restObj = new call_rest();
                    try{
                        encodedUrl = URLEncoder.encode(flowBar, "UTF-8");
                        String encodedUr2 = URLEncoder.encode(userBar, "UTF-8");
                        String encodedUr3 = URLEncoder.encode(Process, "UTF-8");

                        url = host + "PrdMgn/ScanOperate?command=10&UID=" + userBar + "&flowBar=" + flowBar +
                                "&DEPT=" + encodedUr3 + "&MID=" + machineBar + "&mStatus=0";
                        System.out.println(url);
                        JSONObject rtnRestObj = restObj.callRest(url);
                        View rootView = getWindow().getDecorView().getRootView();
                        getg(rootView);
                        //  testbnt = (Button) findViewById(R.id.testbnt);
                        //testbnt.performClick();
                    }catch (Exception e) {
                    }
                }
            });
            builder2.setNegativeButton("否", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // TODO Auto-generated method stub
                    dialog.cancel();
                }
            });
            builder2.show();
        }
    };

    private void pushmid() {//更新主畫面機台名稱
        spinner.setVisibility(INVISIBLE);
        TextView midtext = (TextView) findViewById(R.id.midtext);
        midtext.setVisibility(VISIBLE);
        midtext.setText("\t" + machineBar);
        machine_but_flag = 1;
    }

    private void upmid() {//更新機台狀態
        if(Process.equals("")){}
        Thread thread_upmid = new Thread(new Runnable() {
            public void run() {
                try {
                    midlist.clear();
                    call_rest restObj = new call_rest();
                    String encodedUrl = "", Process1 = "",check_pr="";
                    if (Process.equals("外檢1")) {Process1 = "花蓮外檢";}else {Process1=Process;}
                    if(Process.indexOf("全檢2") > -1){
                        check_pr="&flowStep=全檢2&subflowID="+SUBFLOWID;
                        Process1 = "花蓮全檢";
                    }
                    if(Process.indexOf("全檢1") > -1){
                        check_pr="&flowStep=全檢1&subflowID="+SUBFLOWID;
                        Process1 = "花蓮全檢";
                    }
                    if (Process.equals("全檢備註")){
                        Process1 = "花蓮全檢";
                    }
                    encodedUrl = URLEncoder.encode(Process, "UTF-8");
                    userBar=userBar.replaceAll("\\*", "");
                    JSONObject rtnRestObj = restObj.callRest(host
                            + "PrdMgn/apiGetMachinList?dept="+Process1+"&factoryNo="
                            + facroryNo + "&empID=" + userBar+check_pr);
                    System.out.println("20200417>>"+host
                            + "PrdMgn/apiGetMachinList?dept="+Process1+"&factoryNo="
                            + facroryNo + "&empID=" + userBar+check_pr);

                    JSONArray data = new JSONArray(rtnRestObj.getString("Data"));
                    for (int j = 0; j < data.length(); j++) {
                        String Jasonobject = data.getString(j);//O
                        JSONArray array2 = new JSONArray(Jasonobject);//o
                        for (int k = 0; k < array2.length(); k++) {
                            String Jasonobject2 = array2.getString(k);//O
                            JSONObject ob2 = array2.getJSONObject(k);
                            String mid = ob2.getString("mid");
                            String attr2 = ob2.getString("attr2");
                            String status = ob2.getString("status");
                            if (mid.equals("null")) {
                                midlist.add("null");
                            } else {
                                attr2 = attr2.replaceAll("\\\\", "");
                                attr2 = attr2.replaceAll("n", "  ");
                                midlist.add(attr2 + "  " + mid + "status" + status);
                                System.out.println((attr2 + "  " + mid + "status==" + status));
                            }

                        }
                        midlist.add("null");midlist.add("null");
                        midlist.add("null");
                        midlist.add("new");
                        //System.out.println("upmid");
                        midflag = 1;
                    }
                } catch (Exception e) {
                    CharArrayWriter cw = new CharArrayWriter();
                    PrintWriter w = new PrintWriter(cw);
                    e.printStackTrace(w);
                    w.close();
                    trace = cw.toString();
                    e.printStackTrace();
                    View rootView = getWindow().getDecorView().getRootView();
                    send_urlsting(rootView);
                    e.printStackTrace();
                }
            }
        });
        thread_upmid.start();  //thread_ver
    }
    public void maintain(View view) { //維修  setting_status
        ImageButton report = (ImageButton) findViewById(R.id.report);
        Thread thread_maintain = new Thread(new Runnable() {
            public void run() {
                try {
                    String g_list2 = g_list.toString();
                    call_rest restObj = new call_rest();
                    String Process_encode = URLEncoder.encode(Process, "UTF-8");

                    url = host + "PrdMgn/ScanOperate?command=10&UID=" + userBar + "&flowBar=" + flowBar +
                            "&DEPT=" + Process_encode + "&MID=" + machineBar + "&mStatus=" + setting_status;
                    System.out.println(url);
                    JSONObject rtnRestObj = restObj.callRest(url);
                    Message = rtnRestObj.getString("Message");
                    code = rtnRestObj.getString("Code");
                    Succ = rtnRestObj.getString("Succ");
                    Message m = new Message();
                    m.what = MEG_INVALIDATE;
                    messagehandler.sendMessage(m);
                } catch (Exception e) {
                    CharArrayWriter cw = new CharArrayWriter();
                    PrintWriter w = new PrintWriter(cw);
                    e.printStackTrace(w);
                    w.close();
                    trace = cw.toString();
                    e.printStackTrace();
                    View rootView = getWindow().getDecorView().getRootView();
                    send_urlsting(rootView);
                    e.printStackTrace();
                }
            }
        });
        if (setting_status != 2) {
            report.setImageResource(R.drawable.ic_buildr);
            setting_status = 2;
            thread_maintain.start();  //thread_ver
        } else {
            report.setImageResource(R.drawable.ic_build);
            setting_status = 0;
            thread_maintain.start();  //thread_ver
        }
    }

    public void admin(View view) {//改單
        //new一個intent物件，並指定Activity切換的class
        Intent intent = new Intent();
        intent.setClass(this, adminActivity.class);
        //new一個Bundle物件，並將要傳遞的資料傳入
        Bundle bundle = new Bundle();
        bundle.putString("userBar", userBar);
        bundle.putString("name", name);
        bundle.putString("host", host);
        bundle.putString("userselect_flag", userselect_flag);
        if (userselect_flag.equals("1")){
            userselect_flag="0";
            bundle.putString("SIGNID", SIGNID);
        }else{
            bundle.putString("SIGNID", "0");
        }
        //將Bundle物件assign給intent
        intent.putExtras(bundle);
        //切換Activity
        startActivity(intent);
    }

    public void user_select(View view) {// 外檢user list底漆人員
        final ArrayList<String> mylist = new ArrayList<String>();
        mList.clear();

        final int[] sum_out = {0};
        final ArrayList NewsArrayList = new ArrayList<HashMap<String, String>>();
        Thread thread_ver = new Thread(new Runnable() {
            public void run() {
                try {
                    g_list.put("FLOW_STEP", "外檢1");
                    String encodedUrl = "", encodedUr2 = "";
                    encodedUrl = URLEncoder.encode("花蓮底漆", "UTF-8");
                    encodedUr2 = URLEncoder.encode(flowBar, "UTF-8");
                    call_rest restObj = new call_rest();
                    JSONObject rtnRestObj = restObj.callRest(host + "PrdMgn/getOpertorInfoByDept?flowBar=" + encodedUr2 + "&DEPT=花蓮底漆" + encodedUrl);
                    JSONArray array = new JSONArray(rtnRestObj.getString("Data"));
                    testdata = "";String name_temp="",colorIn="",colorOut="",outchkCnt="",FLOW_STEP="";

                    for (int i = 0; i < array.length(); i++) {
                        Map<String, Object> itemBooks =  new HashMap<String, Object>();
                        JSONObject jsonObject = array.getJSONObject(i);
                        String EMPNAME = jsonObject.getString("EMPNAME");
                        String USER_ID1= jsonObject.getString("USER_ID");
                        colorIn= jsonObject.getString("colorIn");
                        outchkCnt= jsonObject.getString("outchkCnt");
                        FLOW_STEP= jsonObject.getString("FLOW_STEP");
                        colorOut= jsonObject.getString("colorOut");
                        nameout= jsonObject.getString("EMPNAME");

                        if(!name_temp.equals(EMPNAME)) {
                            mylist.add(SIGNID + " " + EMPNAME + " " + InputQuan);
                            itemBooks.put("check_user",USER_ID1);
                            itemBooks.put("nameout",nameout);
                            itemBooks.put("colorIn",colorIn);
                            itemBooks.put("outchkCnt",outchkCnt);
                            itemBooks.put("colorOut",colorOut);
                            mList.add(itemBooks);
                        }
                        name_temp=EMPNAME;
                    }
                } catch (Exception e) {
                    CharArrayWriter cw = new CharArrayWriter();
                    PrintWriter w = new PrintWriter(cw);
                    e.printStackTrace(w);
                    w.close();
                    trace = cw.toString();
                    e.printStackTrace();
                    View rootView = getWindow().getDecorView().getRootView();
                    send_urlsting(rootView);
                    e.printStackTrace();
                }
            }
        });
        thread_ver.start();  //thread_ver
        int i = 0;
        while (true) {
            try {
                Thread.sleep(1000);
                i++;
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                final View v = inflater.inflate(R.layout.views, null);   //   get viwe layout\
                final AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setCancelable(true);
                final AlertDialog dlg;
                final ListView listview = (ListView) v.findViewById(R.id.dynamic);
                TextView title = new TextView(this);
                title.setText("外檢");
                ListAdapter adapter2 =new SimpleAdapter(this, mList, R.layout.content_booking_locaton_dtl,
                        new String[]{"OutputQuan","InputQuan","nameout","check_user"},
                        new int[]{R.id.textView40,R.id.textView41,R.id.textView42,R.id.textView43});
                ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, mylist) {
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        View view = super.getView(position, convertView, parent);
                        TextView tv = (TextView) view.findViewById(android.R.id.text1);
                        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
                        return view;
                    }
                };
                listview.setAdapter(adapter2);

                title.setGravity(Gravity.CENTER);
                title.setTextSize(24);
                dialog.setCustomTitle(title);
                dialog.setView(v);
                dialog.setNeutralButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dlg = dialog.show();
                listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //Toast.makeText(getApplicationContext(), mList.get(position).get("SIGNID").toString(),Toast.LENGTH_LONG).show();

                        check_user=mList.get(position).get("check_user").toString();
                        user_select.setText(mList.get(position).get("nameout").toString()+
                                "完成 : "+mList.get(position).get("colorOut").toString());
                        check_userid=mList.get(position).get("check_user").toString();
                        if (mList.get(position).get("outchkCnt").toString().equals("0")){

                            try {
                                g_list.put("colorUser", check_userid);
                                //g_list.put("colorUser", check_user);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            InputQuan_Texted.setText(mList.get(position).get("colorOut").toString());
                            chkinput=mList.get(position).get("colorOut").toString();
                            NGselecdt.setVisibility(GONE);
                            NGselecdt.setSelection(0);
                        }else{
                            InputQuan_Texted.setText(mList.get(position).get("colorOut").toString());

                            NGselecdt.setVisibility(VISIBLE);
                        }
                        dlg.dismiss();
                    }
                });
                WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
                //視窗長寬
                params.width = 1200;
                params.height = 600;
                //button text size
                dlg.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
                dlg.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
                dlg.getWindow().setAttributes(params);
                break;
            } catch (InterruptedException e) {

            }
        }
    }
    public void user_select2(View view) {// 外2  色碼人
        final ArrayList<String> mylist = new ArrayList<String>();
        final HashMap<String,String> data = new HashMap<String,String>();
        mList.clear();

        final int[] sum_out = {0};
        final ArrayList NewsArrayList = new ArrayList<HashMap<String, String>>();
        Thread thread_ver = new Thread(new Runnable() {
            public void run() {
                try {

                    g_list.put("FLOW_STEP", "外檢2");
                    String encodedUrl = "", encodedUr2 = "";
                    encodedUrl = URLEncoder.encode("花蓮色碼", "UTF-8");
                    encodedUr2 = URLEncoder.encode(flowBar, "UTF-8");
                    call_rest restObj = new call_rest();
                    //取得色碼人 固定色碼
                    JSONObject rtnRestObj = restObj.callRest(host + "PrdMgn/getOpertorInfoByDept?flowBar=" + encodedUr2 + "&DEPT=" + encodedUrl);
                    JSONArray array = new JSONArray(rtnRestObj.getString("Data"));
                    // "[{\"USER_ID\":\"B_007\",\"EMPNAME\":\"彭詠傑\",\"FLOW_STEP\":\"外檢2\",\"colorIn\":29000,\"colorOut\":28300,\"outchkCnt\":0}]"
                    testdata = "";String name_temp="",colorIn="",colorOut="",outchkCnt="",FLOW_STEP="";

                    for (int i = 0; i < array.length(); i++) {
                        Map<String, Object> itemBooks =  new HashMap<String, Object>();
                        JSONObject jsonObject = array.getJSONObject(i);
                        String EMPNAME = jsonObject.getString("EMPNAME");
                        String USER_ID= jsonObject.getString("USER_ID");
                        colorIn= jsonObject.getString("colorIn");
                        outchkCnt= jsonObject.getString("outchkCnt");
                        FLOW_STEP= jsonObject.getString("FLOW_STEP");
                        colorOut= jsonObject.getString("colorOut");
                        nameout= jsonObject.getString("EMPNAME");

                        if(!name_temp.equals(EMPNAME)) {
                            mylist.add(SIGNID + " " + EMPNAME + " " + InputQuan);
                            itemBooks.put("USER_ID",USER_ID);
                            itemBooks.put("nameout",colorIn);
                            itemBooks.put("colorIn",colorIn);
                            itemBooks.put("outchkCnt",outchkCnt);
                            itemBooks.put("colorOut",colorOut);
                            itemBooks.put("EMPNAME",EMPNAME);
                            mList.add(itemBooks);
                        }
                        name_temp=EMPNAME;
                    }
                } catch (Exception e) {
                    CharArrayWriter cw = new CharArrayWriter();
                    PrintWriter w = new PrintWriter(cw);
                    e.printStackTrace(w);
                    w.close();
                    trace = cw.toString();
                    e.printStackTrace();
                    View rootView = getWindow().getDecorView().getRootView();
                    send_urlsting(rootView);
                    e.printStackTrace();
                }
            }
        });
        thread_ver.start();  //thread_ver
        int i = 0;
        while (true) {
            try {
                Thread.sleep(200);
                i++;
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                final View v = inflater.inflate(R.layout.views, null);   //   get viwe layout\
                final AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setCancelable(true);
                final AlertDialog dlg;
                final ListView listview = (ListView) v.findViewById(R.id.dynamic);
                TextView title = new TextView(this);
                title.setText("外檢");
                ListAdapter adapter2 =new SimpleAdapter(this, mList, R.layout.content_booking_locaton_dtl,
                        new String[]{"OutputQuan","InputQuan","EMPNAME","EMPNAME"},
                        new int[]{R.id.textView40,R.id.textView41,R.id.textView42,R.id.textView43});
                ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, mylist) {
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        View view = super.getView(position, convertView, parent);
                        TextView tv = (TextView) view.findViewById(android.R.id.text1);
                        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
                        return view;
                    }
                };
                listview.setAdapter(adapter2);

                title.setGravity(Gravity.CENTER);
                title.setTextSize(24);
                dialog.setCustomTitle(title);
                dialog.setView(v);
                dialog.setNeutralButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dlg = dialog.show();
                listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //Toast.makeText(getApplicationContext(), mList.get(position).get("SIGNID").toString(),Toast.LENGTH_LONG).show();

                        check_user=mList.get(position).get("USER_ID").toString();
                        color_userbnt.setText(mList.get(position).get("EMPNAME").toString());
                        Toast.makeText(getApplicationContext(), check_user,Toast.LENGTH_LONG).show();
                        check_userid=mList.get(position).get("USER_ID").toString();
                        try {
                            g_list.put("colorUser", check_user);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (mList.get(position).get("outchkCnt").toString().equals("0")){

                            InputQuan_Texted.setText(mList.get(position).get("colorOut").toString());
                            NGselecdt.setVisibility(GONE);
                            NGselecdt.setSelection(0);
                        }else{
                            NGselecdt.setVisibility(VISIBLE);
                            NGselecdt.setSelection(0);
                        }
                        dlg.dismiss();
                    }
                });
                WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
                //視窗長寬
                params.width = 1200;
                params.height = 600;
                //button text size
                dlg.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
                dlg.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
                dlg.getWindow().setAttributes(params);
                break;
            } catch (InterruptedException e) {

            }
        }
    }

    public void checkout_finsh(View view) {//外檢完成
        Thread thread_ver = new Thread(new Runnable() {
            public void run() {
                try {
                    String encodedUr2 = "";
                    encodedUr2 = URLEncoder.encode(flowBar, "UTF-8");
                    call_rest restObj = new call_rest();
                    int checkourSeq=1;
                    if (FLOW_STEP_CURR.indexOf("2")>-1){checkourSeq=2;}
                    //checkourSeq   外檢次數
                    JSONObject rtnRestObj = restObj.postRest(host + "PrdMgn/updOutCheckLog?" + "flowBar="+encodedUr2+"&NG1="+ng1+"&NG2="+ng2 +"&NG3="+ng3+"&checkourSeq="+checkourSeq+"&signID="+SIGNID
                            +"&preOperatorID="+check_userid, g_list.toString());
                    Message = rtnRestObj.getString("Message");
                    Succ = rtnRestObj.getString("Succ");
                    code = rtnRestObj.getString("Code");
                    Message m = new Message();
                    m.what = MEG_INVALIDATE;
                    checkhandler.sendMessage(m);

                } catch (Exception e) {
                    CharArrayWriter cw = new CharArrayWriter();
                    PrintWriter w = new PrintWriter(cw);
                    e.printStackTrace(w);
                    w.close();
                    trace = cw.toString();
                    e.printStackTrace();
                    View rootView = getWindow().getDecorView().getRootView();
                    send_urlsting(rootView);
                    e.printStackTrace();
                }
            }
        });
        thread_ver.start();  //thread_ver
    }

    final Handler checkhandler = new Handler() {
        public void handleMessage(Message m) {
            super.handleMessage(m);
        }
    };

    public void Defect_input(View view) {//外檢輸入不良
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        final View v = inflater.inflate(R.layout.defectquan, null);   //   get viwe layout\
        final View rv = inflater.inflate(R.layout.activity_main, null);   //   get viwe layout\
        final AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setCancelable(true);
        final AlertDialog dlg;
        TextView title = new TextView(this);
        title.setText("外檢");
        title.setGravity(Gravity.CENTER);
        title.setTextSize(24);
        dialog.setCustomTitle(title);
        dialog.setView(v);
        dialog.setNeutralButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                NG1 = (EditText) v.findViewById(R.id.NG1);
                NG2 = (EditText) v.findViewById(R.id.NG2);
                NG3 = (EditText) v.findViewById(R.id.NG3);
                if(NG1.getText().toString().equals(""))NG1.setText("0");
                if(NG2.getText().toString().equals(""))NG2.setText("0");
                if(NG3.getText().toString().equals(""))NG3.setText("0");
                ng1 = Integer.valueOf(NG1.getText().toString());
                ng2 = Integer.valueOf(NG2.getText().toString());
                ng3 = Integer.valueOf(NG3.getText().toString());
                ngsum=ng1+ng2+ng3;
                ngsunt= Integer.toString(ngsum);
                Message m = new Message();
                m.what = MEG_INVALIDATE;
                sumh.sendMessage(m);
            }
        });
        dlg = dialog.show();
        WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
        //視窗長寬
        params.width = 1200;
        params.height = 800;
        //button text size
        dlg.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
        dlg.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
        dlg.getWindow().setAttributes(params);
    }
    final Handler sumh = new Handler() {
        public void handleMessage(Message m) {
            super.handleMessage(m);
            furyu_Texted = (EditText) findViewById(R.id.furyu_Texted);
            furyu_Texted.setText(ngsunt);
        }
    };

    public void send(View view) {//send note
        note_value = (EditText) findViewById(R.id.note_value);
        String note = note_value.getText().toString();
        call_rest restObj = new call_rest();
        JSONObject rtnRestObj = restObj.callRest(host + "/PrdMgn/updComment?signID="+SIGNID+"&comment="+note);
        //http://172.168.1.33:1119/firstohmWebapi/PrdMgn/updComment?signID=5682&comment=this is a test
        Message m = new Message();
        m.what = MEG_INVALIDATE;
        clsnote.sendMessage(m);
    }
    final Handler clsnote = new Handler() {
        public void handleMessage(Message msg1) {
            super.handleMessage(msg1);
            note_value = (EditText) findViewById(R.id.note_value);
            note_value.setText("");
        }
    };
    private String getMyIp(){
        check_loc=0;
        Thread thread_ver = new Thread(new Runnable() {
            public void run() {
                try {
                    URLConnection connection = (new URL(MainActivity.host + "appver.html")).openConnection();
                    connection.setConnectTimeout(3000);
                    connection.setReadTimeout(3000);
                    connection.connect();
                    InputStream in = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder html = new StringBuilder();
                    for (String line; (line = reader.readLine()) != null; ) {
                        html.append(line);
                    }
                    MainActivity.new_version = html.toString();
                    if (html.toString().equals("") || html.toString().equals("null")) {
                      //  ip_str="220.128.234.48:1119";
                        check_loc=0;
                    }else{
                        ip_str="192.168.1.33:1119";
                        check_loc=1;
                    }
                } catch (Exception e) {
                   // ip_str="220.128.234.48:1119";
                    check_loc=0;
                }
            }
        });
        thread_ver.start();
        int i=0;
        while (true){
            try {
                Thread.sleep(100); //1000為1秒
            } catch (InterruptedException e) {
                return ip_str;
            }catch (Exception e) {
                return ip_str;
            }
            i++;
            if (check_loc==0){
            }else {
                return ip_str;
            }
        }
    }

    public void portal(View view) {
        String url="http://192.168.1.114/Portal20200211/hualien?user=ppp&pwd=pppp";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }

    public void plating_views(View view) {//電鍍開始
        Intent intent = new Intent();
        intent.setClass(this, platingActivity.class);
        Bundle bundle = new Bundle();

        bundle.putString("userBar", userBar);
        bundle.putString("name", name);
        bundle.putString("MachineID", machineBar);
        bundle.putString("startday", "");
        bundle.putString("host", host);
        bundle.putString("action", "start");
        bundle.putString("error_range", error_range);
        intent.putExtras(bundle);
        //切換Activity
        startActivity(intent);

    }
    public void plating_views_f(View view) {//電鍍finsh
        Intent intent = new Intent();
        intent.setClass(this, platingActivity.class);
        String d=date_spinner.getSelectedItem().toString();
        Bundle bundle = new Bundle();
        String machineBar = spinner.getSelectedItem().toString();
        bundle.putString("userBar", userBar);
        bundle.putString("startday", d);
        bundle.putString("MachineID", machineBar);
        bundle.putString("name", name);
        bundle.putString("host", host);
        bundle.putString("error_range", error_range);
        bundle.putString("action", "finsh");
        intent.putExtras(bundle);
        //切換Activity
        startActivity(intent);
    }

    public void warehouse(View view) {//取庫
        warehouse_flag=1;
        initGldPent(view);
        try {
            String encodedUrl = "", encodedUr2 = "", encodedUr3 = "";
            encodedUrl = URLEncoder.encode(flowBar, "UTF-8");
            url_stting = host + "PrdMgn/getColorFromWareHouseBarCode?warehouseBar="+encodedUrl;
            call_rest restObj = new call_rest();
            JSONObject rtnRestObj = restObj.callRest(url_stting);
            fillGldPent_getColorFromWareHouseBarCode(rtnRestObj, view);
        } catch (Exception e) {
            CharArrayWriter cw = new CharArrayWriter();
            PrintWriter w = new PrintWriter(cw);
            e.printStackTrace(w);
            w.close();
            trace = cw.toString();
            e.printStackTrace();
            View rootView = getWindow().getDecorView().getRootView();
            send_urlsting(rootView);
        }
    }
    public void fillGldPent_getColorFromWareHouseBarCode(JSONObject g_json, View view) {
        try {
            g_json_string = g_json.getString("Data");
            Message = g_json.getString("Message");
            Succ = g_json.getString("Succ");
            code = g_json.getString("Code");
            if (g_json_string.length()>100)
            {
                g_json_string=g_listTE;
            }
            if (Message.indexOf("錯誤") > -1 || g_json_string.indexOf("錯誤") > -1) {
                Message = Message+g_json_string;
            }
            SIGNID = null;barCodeType = null;FINISH_TIME = null;g_list = null;jsonStr = null;g_list = null;
            g_list = new JSONObject(g_json_string);
            mfo_id = g_list.getString("MFO_ID") == null ? "" : g_list.getString("MFO_ID");
            RTYPE = g_list.getString("RTYPE") == null ? "" : g_list.getString("RTYPE");
            TOL = g_list.getString("Tol") == null ? "" : g_list.getString("Tol");
            VAL = g_list.getString("VAL") == null ? "" : g_list.getString("VAL");
            PPM = g_list.getString("PPM") == null ? "" : g_list.getString("PPM");
            COLOR_NUM = g_list.getString("Color") == null ? "" : g_list.getString("Color");
            sumOfNaiBei="null";
            Message m = new Message();
            m.what = MEG_INVALIDATE;
            handler.sendMessage(m);
            Message m2 = new Message();
            m2.what = MEG_INVALIDATE;
            clolr.sendMessage(m2);
        } catch (Exception e) {
            CharArrayWriter cw = new CharArrayWriter();
            PrintWriter w = new PrintWriter(cw);
            e.printStackTrace(w);
            w.close();
            trace = cw.toString();
            e.printStackTrace();
            View rootView = getWindow().getDecorView().getRootView();
            send_urlsting(rootView);
            e.printStackTrace();
        }
    }

    public void color(View view) {
        Intent intent = new Intent();
        intent.setClass(this, colorActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("host", host);
        bundle.putInt("COLOR_inverse", COLOR_inverse);
        intent.putExtras(bundle);
        //切換Activity
        startActivity(intent);
    }

    public void QueryNaibei(View view) {
        final ArrayList<String> mylist = new ArrayList<String>();
        Thread thread_myPrdRecords = new Thread(new Runnable() {
            public void run() {
                try {
                    String encodedUrl = "", encodedUr2 = "";
                    if (!(userBar.indexOf("*") > -1)) {
                        userBar = "*" + userBar;
                    }
                    encodedUrl = URLEncoder.encode(userBar, "UTF-8");
                    call_rest restObj = new call_rest();
                    JSONObject rtnRestObj = restObj.callRest(host + "PrdMgn/apiQueryNaibei?dept=花蓮電鍍");
                    JSONArray array = new JSONArray(rtnRestObj.getString("Data"));
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject jsonObject = array.getJSONObject(i);
                        String myPrd_InputQuan = jsonObject.getString("InputQuan");
                        String myPrd_Tol = jsonObject.getString("Tol");
                        String myPrd_MASTER_MFO_ID = jsonObject.getString("MASTER_MFO_ID");
                        String myPrd_VAL = jsonObject.getString("VAL");
                        String myPrd_batchNO = jsonObject.getString("batchNo");
                        String myPrd_note = jsonObject.getString("note");
                        mylist.add( myPrd_note+"\t\t\t"+ myPrd_MASTER_MFO_ID
                                + "\t\t\t流程單號:"  + myPrd_batchNO +"\t\t\t"
                                + myPrd_VAL +"\t\t\t"
                                + myPrd_Tol  + "%\t\t\t送出量:" + myPrd_InputQuan                       );
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread_myPrdRecords.start();  //thread_ver
        int i = 0;
        while (true) {
            try {
                Thread.sleep(1000);
                i++;
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                final View v = inflater.inflate(R.layout.mysteprecords, null);   //   get viwe layout
                ListView listview2 = (ListView) v.findViewById(R.id.mydynamicmy2);
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                TextView title = new TextView(this);
                title.setText("本日電鍍查詢");
                ArrayAdapter adapter = new ArrayAdapter(this,
                        android.R.layout.simple_list_item_1,
                        mylist) {
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        View view = super.getView(position, convertView, parent);
                        TextView tv = (TextView) view.findViewById(android.R.id.text1);
                        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
                        return view;
                    }
                };
                title.setGravity(Gravity.CENTER);
                title.setTextSize(24);
                dialog.setCustomTitle(title);
                dialog.setView(v);
                listview2.setAdapter(adapter);
                dialog.setNegativeButton("離開", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //mothingsetNegativeButton
                    }
                });
                AlertDialog dlg = dialog.show();
                WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
                //視窗長寬
                params.width = 1500;
                params.height = 600;
                //button text size
                dlg.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
                dlg.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
                dlg.getButton(AlertDialog.BUTTON_NEGATIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
                dlg.getWindow().setAttributes(params);
                break;
            } catch (InterruptedException e) {

                CharArrayWriter cw = new CharArrayWriter();
                PrintWriter w = new PrintWriter(cw);
                e.printStackTrace(w);
                w.close();
                trace = cw.toString();
                e.printStackTrace();
                View rootView = getWindow().getDecorView().getRootView();
                send_urlsting(rootView);
            }
        }
    }
    public void myUnfinishedRecords(View view) {
        //登出前顯示未完成工令單
        final int[] fin = {0};
        final ArrayList<String> mylist = new ArrayList<String>();
        Thread thread_myPrdRecords = new Thread(new Runnable() {
            public void run() {
                try {

                    String encodedUrl = "", encodedUr2 = "";
                    if (!(userBar.indexOf("*") > -1)) {
                        userBar = "*" + userBar;
                    }
                    encodedUrl = URLEncoder.encode(userBar, "UTF-8");
                    call_rest restObj = new call_rest();
                    //[昨天 下午6:35] ICD-曾建明
                    //
                    //http://localhost:54791/PrdMgn/myUnfinishedRecords?userBar=*B_004\
                    JSONObject rtnRestObj = restObj.callRest(host + "PrdMgn/myUnfinishedRecords?userBar="+encodedUrl);
                    JSONArray array = new JSONArray(rtnRestObj.getString("Data"));
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject jsonObject = array.getJSONObject(i);
                        String myPrd_MASTER_MFO_ID = jsonObject.getString("工令單號");
                        String myPrd_MID = jsonObject.getString("機台號碼");
                        String myPrd_ID = jsonObject.getString("型號");
                        String myPrd_VAL = jsonObject.getString("阻值");
                        String myPrd_VOL = jsonObject.getString("阻值範圍");
                        String myPrd_SIZR = jsonObject.getString("尺寸");
                        String myPrd_INPUT = jsonObject.getString("起始量");
                        String myPrd_TIME = jsonObject.getString("製程開始時間");
                        String myPrd_SIGNOD = jsonObject.getString("SIGNID");
                        mylist.add( "工令單號:"  + myPrd_MASTER_MFO_ID +"\t\t\t"
                                +"機台號碼:"  + myPrd_MID +"\t\t\t"
                                + "型號:" + myPrd_ID+"\n"
                                + "阻值:" + myPrd_VAL+"\t\t\t"
                                + "阻值範圍:" + myPrd_VOL+"\t\t\t"
                                + "尺寸:" + myPrd_SIZR+"\t\t\t"
                                + "開始量:" + myPrd_INPUT+"\n"
                                + "開始時間:" + myPrd_TIME+"\t"+"ID:" + myPrd_SIGNOD                     );
                    }
                    mylist.add("");
                    fin[0] =1;
                } catch (Exception e) {
                    fin[0] =1;
                }
            }
        });
        thread_myPrdRecords.start();  //thread_ver
        //logout waitting
        int i = 0;
        while (true) {
            if(fin[0] ==0){

            }else{
            try {
                //Thread.sleep(3000);
                i++;
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                final View v = inflater.inflate(R.layout.mysteprecords, null);   //   get viwe layout
                final ListView listview2 = (ListView) v.findViewById(R.id.mydynamicmy2);
                out_shift1 = (Button) v.findViewById(R.id.out_shift1);
                out_shift2= (Button) v.findViewById(R.id.out_shift2);
                out_shift3= (Button) v.findViewById(R.id.out_shift3);
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                TextView title = new TextView(this);
                title.setText("未完成流程單");
                if (logout_flag==1){
                    title.setText("");
                }
                ArrayAdapter adapter = new ArrayAdapter(this,
                        android.R.layout.simple_list_item_1,
                        mylist) {
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        View view = super.getView(position, convertView, parent);
                        TextView tv = (TextView) view.findViewById(android.R.id.text1);
                        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
                        return view;
                    }
                };
                title.setGravity(Gravity.CENTER);
                title.setTextSize(24);
                dialog.setCustomTitle(title);
                dialog.setView(v);
                listview2.setAdapter(adapter);

                if (logout_flag==1){
                    out_shift1.setVisibility(VISIBLE);
                    out_shift2.setVisibility(VISIBLE);
                    out_shift3.setVisibility(VISIBLE);
                    out_shift1.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View v) {

                            logouttype="早班";
                            View rootView = getWindow().getDecorView().getRootView();
                            exit(rootView);
                        }
                    });
                    out_shift2.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View v) {

                            logouttype="中班";
                            View rootView = getWindow().getDecorView().getRootView();
                            exit(rootView);
                        }
                    });
                    out_shift3.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View v) {

                            logouttype="晚班";
                            View rootView = getWindow().getDecorView().getRootView();
                            exit(rootView);
                        }
                    });
                    if (adapter.getCount() == 0){
                        View rootView = getWindow().getDecorView().getRootView();
                        //exit(rootView);
                    }
                }else {
                    dialog.setNegativeButton("離開", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //mothingsetNegativeButton
                        }
                    });
                }
                final AlertDialog dlg = dialog.show();
                listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                        String itemValue    = (String) listview2.getItemAtPosition(position);
                        final String[] nurl = itemValue.split("ID:");
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("是否修改");
                        builder.setCancelable(false);
                        builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                edit_sign=nurl[1];
                                View rootView = getWindow().getDecorView().getRootView();
                                edit_signs(rootView);
                                dlg.dismiss();
                            }
                        });
                        builder.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.show();

                        //Toast.makeText(SuggestionActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                    }
                });
                WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
                //視窗長寬
                params.width = 1200;
                params.height = 700;
                //button text size
                dlg.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
                dlg.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
                dlg.getButton(AlertDialog.BUTTON_NEGATIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
                dlg.getWindow().setAttributes(params);

                //Message msg2 = new Message();
                //msg1.what = MEG_INVALIDATE;
                //HmoreprogressBar.sendMessage(msg2);

                break;
            } catch (Exception e) {

                CharArrayWriter cw = new CharArrayWriter();
                PrintWriter w = new PrintWriter(cw);
                e.printStackTrace(w);
                w.close();
                trace = cw.toString();
                e.printStackTrace();
                View rootView = getWindow().getDecorView().getRootView();
                send_urlsting(rootView);
            }
        }

        }
    }
    @Override
    public void onBackPressed(){
    }

    public void testclick(View view) {//測試輸出
        int selected = TieDaigroup.getCheckedRadioButtonId();
        RadioButton radioBtn1 = (RadioButton) findViewById(selected);
        Toast.makeText(MainActivity.this,
                radioBtn1.getText(), Toast.LENGTH_SHORT).show();
    }

    public void rd_quty_chk(View view) {//支
        finsh_thai.setVisibility(INVISIBLE);
        def_thai.setVisibility(INVISIBLE);
        System.out.println("o2   ");
        Message msg1 = new Message();
        msg1.what = MEG_INVALIDATE;
        roll.sendMessage(msg1);
    }

    public void rd_roll_chk(View view) {
        finsh_thai.setVisibility(VISIBLE);
        def_thai.setVisibility(VISIBLE);

            Message msg1 = new Message();
            msg1.what = MEG_INVALIDATE;
        roll2.sendMessage(msg1);

    }
    final Handler roll = new Handler() {
        public void handleMessage(Message msg1) {
            super.handleMessage(msg1);
            try {
                final_Texted = (EditText) findViewById(R.id.final_Texted);
                furyu_Texted= (EditText) findViewById(R.id.furyu_Texted);
                AccQuan_Texted= (EditText) findViewById(R.id.AccQuan_Texted);
                float ac=Float.parseFloat(AccQuan);
                float r=Float.parseFloat(tdRollQty);
                float temp=ac/r;
                float out= Float.parseFloat(AccQuan.toString());
                float o2=out/r;
                furyu_Texted.setText(String.valueOf(tdDoneQty));
                final_Texted.setText(String.valueOf(o2));
                System.out.println("o2   =="+tdDoneQty);

        } catch (Exception e) {

                CharArrayWriter cw = new CharArrayWriter();
                PrintWriter w = new PrintWriter(cw);
                e.printStackTrace(w);
                w.close();
                trace = cw.toString();
                e.printStackTrace();
                View rootView = getWindow().getDecorView().getRootView();
                send_urlsting(rootView);
        }
        }
    };
    final Handler roll2 = new Handler() {
        public void handleMessage(Message msg1) {
            super.handleMessage(msg1);
            try {
                final_Texted = (EditText) findViewById(R.id.final_Texted);
                furyu_Texted= (EditText) findViewById(R.id.furyu_Texted);
                float ac=Float.parseFloat(AccQuan);
                float r= Float.parseFloat(tdRollQty);
                float tempout=Float.parseFloat(tdDoneQty);
                int out=(int)tempout;
//                 Integer.valueOf();
                float o2=tempout/r/1000;
                System.out.println("==>  "+o2+"==>  "+tempout+"==>  "+r+"==>  "+out+"==>  "+tempout+"==>  "+ac);
                System.out.println("o2   ");
                final_Texted.setText("");
                furyu_Texted.setText(String.valueOf(o2));
            } catch (Exception e) {

                CharArrayWriter cw = new CharArrayWriter();
                PrintWriter w = new PrintWriter(cw);
                e.printStackTrace(w);
                w.close();
                trace = cw.toString();
                e.printStackTrace();
                View rootView = getWindow().getDecorView().getRootView();
                send_urlsting(rootView);
            }
        }
    };
    public static String readCpuInfo() {
        String result = "";
        try {
            String[] args = {"/system/bin/cat", "/proc/cpuinfo"};
            ProcessBuilder cmd = new ProcessBuilder(args);

            Process process = cmd.start();
            StringBuffer sb = new StringBuffer();
            String readLine = "";
            BufferedReader responseReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "utf-8"));
            while ((readLine = responseReader.readLine()) != null) {
                sb.append(readLine);
            }
            responseReader.close();
            result = sb.toString().toLowerCase();
        } catch (IOException ex) {
        }
        return result;
    }

    public void syncTime() {
        try {
            Process process = Runtime.getRuntime().exec("su");
            DataOutputStream os = new DataOutputStream(process.getOutputStream());
            String year="2020";
            String month="10";
            String day="22";
            String hour="17";
            String minute="20";
            String second="20";
            String command = "date -s "+year+month+day+"."+hour+minute+second+"\n";

            os.writeBytes(command);
            os.flush();
            os.writeBytes("exit\n");
            os.flush();
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void shift_flow(View view) {
        //new一個intent物件，並指定Activity切換的class
        Intent intent = new Intent();
        intent.setClass(this, ShiftFlowActivity.class);
        //new一個Bundle物件，並將要傳遞的資料傳入camera_str
        Bundle bundle = new Bundle();
        bundle.putString("userBar", userBar);
        bundle.putInt("camera_str", camera_str);
        bundle.putString("name", name);
        bundle.putString("host", host);
        bundle.putString("flowBar", flowBar);
        //將Bundle物件assign給intent
        intent.putExtras(bundle);
        //切換Activity
        startActivity(intent);
    }

    public void usedingmid(View view) {//使用中機台查詢
        final ArrayList<String> mylist = new ArrayList<String>();
        Thread thread_myPrdRecords = new Thread(new Runnable() {
            public void run() {
                try {
                    String encodedUrl = "", encodedUr2 = "";
                    if (!(userBar.indexOf("*") > -1)) {
                        userBar = "*" + userBar;
                    }
                    encodedUrl = URLEncoder.encode(userBar, "UTF-8");
                    encodedUr2 = URLEncoder.encode(Process, "UTF-8");
                    call_rest restObj = new call_rest();
                    //PrdMgn/apiGetMachinsByDept?dept=花蓮切割&factoryNo=1
                    JSONObject rtnRestObj = restObj.callRest(host + "PrdMgn/apiGetMachinsByDept?dept="+encodedUr2+"&factoryNo="+facroryNo);
                    JSONArray array = new JSONArray(rtnRestObj.getString("Data"));
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject jsonObject = array.getJSONObject(i);
                        String myPrd_InputQuan = jsonObject.getString("機台號碼");
                        //String myPrd_Tol = jsonObject.getString("屬性");
                        //String myPrd_MASTER_MFO_ID = jsonObject.getString("參數");
                        String myPrd_VAL = jsonObject.getString("狀態");
                        String myPrd_user = jsonObject.getString("操作人");
                        String myPrd_flow = jsonObject.getString("工令單號");
                        String myPrd_starttime = jsonObject.getString("最後記錄時間");
                        String myPrd_no = jsonObject.getString("單號");
                        //工令單、流程單號、使用者、開始時間
                        //{\"機台號碼\":\"5-001\",\"屬性\":\"{\\\"切割機\\\":\\\"雷射\\\"}\",\"參數\":\"1.7x5
                        // .4\\\\n雷射\",\"狀態\":\"待機\",\"操作人\":null,\"最後記錄
                        // 時間\":\"\\/Date(1581103574000)\\/\",\"SIGNID\":null,\"SUBFLOWID
                        // \":null,\"FLOWID\":null,\"工令單號\":null,\"單號\":null}
                        if (myPrd_VAL.equals("使用中")){
                            mylist.add( "機台號碼:"+myPrd_InputQuan
                                    + "\t\t\t使用者:"  + myPrd_user
                                    + "\t\t\t工令單:"  + myPrd_flow
                                    + "\t\t\t流程單號:"  + myPrd_no
                                    + "\n\t\t\t開始時間:"  + myPrd_starttime
                                   // + "\t\t\t屬性:"  + myPrd_Tol
                                   // + "\t\t\t參數:"  + myPrd_MASTER_MFO_ID
                                    +"\t\t\t狀態" + myPrd_VAL);
                            //
                        }
                    }
                } catch (Exception e) {
                    CharArrayWriter cw = new CharArrayWriter();
                    PrintWriter w = new PrintWriter(cw);
                    e.printStackTrace(w);
                    w.close();
                    trace = cw.toString();
                    View rootView = getWindow().getDecorView().getRootView();
                    send_urlsting(rootView);
                }
            }
        });
        thread_myPrdRecords.start();  //thread_ver
        int i = 0;
        while (true) {
            try {
                Thread.sleep(1000);
                i++;
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                final View v = inflater.inflate(R.layout.mysteprecords, null);   //   get viwe layout
                ListView listview2 = (ListView) v.findViewById(R.id.mydynamicmy2);
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                TextView title = new TextView(this);
                title.setText("使用中機台查詢");
                ArrayAdapter adapter = new ArrayAdapter(this,
                        android.R.layout.simple_list_item_1,
                        mylist) {
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        View view = super.getView(position, convertView, parent);
                        TextView tv = (TextView) view.findViewById(android.R.id.text1);
                        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
                        return view;
                    }
                };
                title.setGravity(Gravity.CENTER);
                title.setTextSize(24);
                dialog.setCustomTitle(title);
                dialog.setView(v);
                listview2.setAdapter(adapter);
                //listview2.layout();
                // LayoutParams list = (LayoutParams) mListView.getLayoutParams();
                //   list.height = set the height acc to you;//like int  200
                //   mListView.setLayoutParams(list);
                //listview2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, theSizeIWant));

                dialog.setNegativeButton("離開", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //mothingsetNegativeButton
                    }
                });
                AlertDialog dlg = dialog.show();
                WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
                //視窗長寬
                params.width = 1500;
                params.height = 600;
                //button text size
                dlg.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
                dlg.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
                dlg.getButton(AlertDialog.BUTTON_NEGATIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
                dlg.getWindow().setAttributes(params);
                break;
            } catch (InterruptedException e) {
                CharArrayWriter cw = new CharArrayWriter();
                PrintWriter w = new PrintWriter(cw);
                e.printStackTrace(w);
                w.close();
                trace = cw.toString();
                e.printStackTrace();
                View rootView = getWindow().getDecorView().getRootView();
                send_urlsting(rootView);
            }
        }
    }

    public void finsh_lastsign(View view) {
        try {
            g_list.put("OutputQuan", ng1_afinsh);
            g_list.put("DefectQuan", ng2_afinsh);
            g_list.put("StepLeft", ng3_afinsh);
            String encodedUrl = "", encodedUr2 = "", encodedUr3 = "", encodedUr4 = "";
            encodedUrl = URLEncoder.encode(flowBar, "UTF-8");
            encodedUr2 = URLEncoder.encode(userBar, "UTF-8");
            encodedUr3 = URLEncoder.encode(machineBar, "UTF-8");
            encodedUr4 = URLEncoder.encode(Process, "UTF-8");
            url_stting = host + "PrdMgn/ScanOperate?command=50&UID=" + encodedUr2 + "&flowBar=" + encodedUrl + "&DEPT=" + encodedUr4 + "&MID=" + encodedUr3;
            call_rest restObj = new call_rest();
            JSONObject rtnRestObj = restObj.postRest(url_stting, g_list.toString());
            update_ui(rtnRestObj);
            View rootView = getWindow().getDecorView().getRootView();

            getg(rootView);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch (Exception e) {
            CharArrayWriter cw = new CharArrayWriter();
            PrintWriter w = new PrintWriter(cw);
            e.printStackTrace(w);
            w.close();
            trace = cw.toString();
            View rootView = getWindow().getDecorView().getRootView();
            send_urlsting(rootView);
        }
    }

    public void tcheck_cilck(View view) {
        Message msg1 = new Message();
        msg1.what = MEG_INVALIDATE;
        acc.sendMessage(msg1);
    }
    Handler acc = new Handler() {
        public void handleMessage(Message msg) {
            if(TieDaiL_check.isChecked()){
                shift_bnt.setVisibility(VISIBLE);
                AccQuan_Texted.setText("0");
                AccQuan_Texted.setFocusable(false);
                AccQuan_Texted.setBackgroundColor(Color.parseColor("#BFBFBF"));
            }else{
                shift_bnt.setVisibility(GONE);
                AccQuan_Texted.setFocusableInTouchMode(true);
                AccQuan_Texted.setFocusable(true);
                AccQuan_Texted.setBackgroundColor(Color.WHITE);;
            }
            super.handleMessage(msg);
        }

    };
    public void send_line_click_Exception(final View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("是否送出");
        builder.setCancelable(false);
        builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                try {
                    urlclick=1;
                    send_linemsg(view,"其他錯誤Exception已發送至E-mail");
                    send_urlsting(view);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
            }
        });
        builder.show();
    }
    public void send_line_click_login(final View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("是否送出");
        builder.setCancelable(false);
        builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                try {
                    send_linemsg(view,"無法登入");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
            }
        });
        builder.show();
    }
    public void send_line_click_logout(final View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("是否送出");
        builder.setCancelable(false);
        builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                try {
                    send_linemsg(view,"無法登出");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
            }
        });
        builder.show();
    }
    public void send_line_click_start(final View view) {


        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("是否送出");
        builder.setCancelable(false);
        builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                try {
                    send_linemsg(view,"無法開始");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
            }
        });
        builder.show();
    }
    public void send_line_click_finsh(final View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("是否送出");
        builder.setCancelable(false);
        builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                try {
                    send_linemsg(view,"無法完成");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
            }
        });
        builder.show();
    }
    public void send_line_click_report(final View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("是否送出");
        builder.setCancelable(false);
        builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                try {
                    send_linemsg(view,"無法列印工作日報");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
            }
        });
        builder.show();
    }
    public void send_urlsting_click(View view) {
        urlclick=1;//flag
        send_urlsting(view);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("已傳送");
        builder.setCancelable(false);
        builder.setPositiveButton("離開", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        builder.show();
    }

    public void send_linemsg(View view,String msg) {
        try {
            if(name==null)name="-";
            if(!(facroryNo==1))facroryNo=1;
            if(deptp==null)deptp="-";
            if(userBar.equals(""))userBar="-";
            msg=msg+"flow_bar"+flowBar+"  舊版 version  "+now_version;
            url_stting = host + "PrdMgn/emergencyLine?UserID=" +userBar+
                    "&empName=" +name+
                    "&factory=" +facroryNo+
                    "&flowStep=" +deptp+
                    "&issue="+msg;
            call_rest restObj = new call_rest();
            JSONObject rtnRestObj = restObj.callRest(url_stting);
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("已傳送");
            builder.setCancelable(false);
            builder.setPositiveButton("離開", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
            builder.show();
        } catch (Exception e) {
        }
    }
    public void send_urlsting(View view) {
        try {
            call_rest restObj = new call_rest();
            String urlt = host + "PrdMgn/SendNotification";
            if (url_stting==null) {
                url_stting=host + "PrdMgn/SendNotification";
            }
            try {
                if (url_stting.indexOf("jsonStr") > -1) {
                    url_stting = url_stting.replace("jsonStr{", "jsonStr={");
                }
                url_stting = url_stting.replace("&", "[scott]");

            } catch (Exception e) {
            }

            String[] nurl = url_stting.split("PrdMgn/");
            Calendar mCal = Calendar.getInstance();
            String dateformat = "yyyy-MM-dd kk:mm:ss";
            SimpleDateFormat df = new SimpleDateFormat(dateformat);
            df.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
            String today = df.format(mCal.getTime());
            if ((cpuInfo.contains("intel") || cpuInfo.contains("amd"))) {
                JSONObject rtnRestObj = restObj.postRestsend(urlt, "Android Pad USER" + userBar + "flow" + flowBar + "Process" + Process +" version "+now_version +"Message" + Message + "Exception " + trace + nurl[1], "Android Exception"+today, code);
            } else if (urlclick == 1) {
                JSONObject rtnRestObj = restObj.postRestsend(urlt, "Android Pad USER" + userBar + "flow" + flowBar + "Process" + Process +" version "+now_version +"Message" + Message + "Exception " + trace + nurl[1], "Android Exception"+today, code);
            } else if (trace.indexOf("NullPointerException") > -1
                    || trace.indexOf("For input string") > -1
                    || trace.indexOf("失敗") > -1
                    || trace.indexOf("機台選取錯誤") > -1
                    || trace.indexOf("查無") > -1
                    || trace.indexOf("無法") > -1
            ) {
            } else {
                JSONObject rtnRestObj = restObj.postRestsend(urlt, "Android Pad USER" + userBar + "flow" + flowBar + "Process" + Process +" version "+now_version +"Message" + Message + "Exception " + trace + nurl[1], "Android Exception"+today, code);

            }
            trace = "";
            urlclick = 0;//flag  失敗
        } catch (Exception e) {
        }
    }

    public void material_issue(View view) {
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        final View v = inflater.inflate(R.layout.material_issue, null);   //   get viwe layout\
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        TextView title = new TextView(this);
        title.setText("不合格");;
        material_issue.clear();
        CheckBox issue_1,issue_2,issue_3,issue_4,issue_5,issue_6,issue_7,issue_8;

        issue_1=(CheckBox) v.findViewById(R.id.issue_1);//線紋跳溝
        issue_2=(CheckBox) v.findViewById(R.id.issue_2);//線紋毛邊
        issue_3=(CheckBox) v.findViewById(R.id.issue_3);//切帽
        issue_4=(CheckBox) v.findViewById(R.id.issue_4);//測試資料
        issue_5=(CheckBox) v.findViewById(R.id.issue_5);//線紋太長
        issue_6=(CheckBox) v.findViewById(R.id.issue_6);//線紋太短
        issue_7=(CheckBox) v.findViewById(R.id.issue_7);//線紋太細
        issue_8=(CheckBox) v.findViewById(R.id.issue_8);//線紋太粗
        if (Process.equals("花蓮切割")) {
            issue_1.setText("線紋太粗");//過胖、過瘦、針孔、沾帽、塗膜硬度不足、測試資料
            issue_2.setText("線紋太細");
            issue_3.setText("線紋太長");
            issue_4.setText("線紋太短");
            issue_5.setText("線紋跳溝");
            issue_6.setText("線紋毛邊");
            issue_7.setText("切帽");
            issue_8.setVisibility(GONE);
        }else if (Process.equals("花蓮底漆")) {
            issue_1.setText("酒瓶");//過胖、過瘦、針孔、沾帽、塗膜硬度不足、測試資料
            issue_2.setText("過胖");
            issue_3.setText("過瘦");
            issue_4.setText("針孔");
            issue_5.setText("沾帽");
            issue_6.setText("塗膜硬度不足");
            issue_7.setVisibility(GONE);
            issue_8.setText("");issue_8.setVisibility(GONE);
        }else if (Process.equals("花蓮色碼")|| Process.equals("花蓮塗裝")) {
            issue_1.setText("色碼核對");//色碼核對、、、、、、
            issue_2.setText("斷線");
            issue_3.setText("暈開");
            issue_4.setText("粗細");
            issue_5.setText("起泡");
            issue_6.setText("底漆未乾");
            issue_7.setVisibility(GONE);
            issue_8.setText("");issue_8.setVisibility(GONE);
        }else if  (Process.equals("花蓮全檢")) {
            issue_1.setText("混料");//、、測試資料
            issue_2.setText("四點測試");
            issue_3.setVisibility(GONE);
            issue_4.setText("");issue_4.setVisibility(GONE);
            issue_5.setText("");issue_5.setVisibility(GONE);
            issue_6.setText("");issue_6.setVisibility(GONE);
            issue_7.setText("");issue_7.setVisibility(GONE);
            issue_8.setText("");issue_8.setVisibility(GONE);
        }else if (Process.equals("花蓮加壓")) {
            issue_1.setText("不合格");
            issue_2.setVisibility(GONE);
            issue_3.setText("");issue_3.setVisibility(GONE);
            issue_4.setText("");issue_4.setVisibility(GONE);
            issue_5.setText("");issue_5.setVisibility(GONE);
            issue_6.setText("");issue_6.setVisibility(GONE);
            issue_7.setText("");issue_7.setVisibility(GONE);
            issue_8.setText("");issue_8.setVisibility(GONE);
        }else {
            issue_1.setText("測試資料");
            material_issue.add(issue_1.getText().toString());
            Message msg1 = new Message();
            msg1.what = MEG_INVALIDATE;
            test_renew.sendMessage(msg1);
            AlertDialog dlg = dialog.show();
            dlg.dismiss();
            issue_2.setText("");issue_2.setVisibility(GONE);
            issue_3.setText("");issue_3.setVisibility(GONE);
            issue_4.setText("");issue_4.setVisibility(GONE);
            issue_5.setText("");issue_5.setVisibility(GONE);
            issue_6.setText("");issue_6.setVisibility(GONE);
            issue_7.setText("");issue_7.setVisibility(GONE);
            issue_8.setText("");issue_8.setVisibility(GONE);
        }
        title.setGravity(Gravity.CENTER);
        title.setTextSize(24);
        dialog.setCustomTitle(title);
        dialog.setView(v);
        dialog.setPositiveButton("送出", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                CheckBox issue_1,issue_2,issue_3,issue_4,issue_5,issue_6,issue_7,issue_8;
                issue_1=(CheckBox) v.findViewById(R.id.issue_1);//線紋跳溝
                issue_2=(CheckBox) v.findViewById(R.id.issue_2);//線紋毛邊
                issue_3=(CheckBox) v.findViewById(R.id.issue_3);//切帽
                issue_4=(CheckBox) v.findViewById(R.id.issue_4);//測試資料
                issue_5=(CheckBox) v.findViewById(R.id.issue_5);//線紋太長
                issue_6=(CheckBox) v.findViewById(R.id.issue_6);//線紋太短
                issue_7=(CheckBox) v.findViewById(R.id.issue_7);//線紋太細
                issue_8=(CheckBox) v.findViewById(R.id.issue_8);//線紋太粗
                if(issue_1.isChecked()==true){
                    material_issue.add(issue_1.getText().toString());
                }
                if(issue_2.isChecked()==true){
                    material_issue.add(issue_2.getText().toString());
                }
                if(issue_3.isChecked()==true){
                    material_issue.add(issue_3.getText().toString());
                }
                if(issue_4.isChecked()==true){
                    material_issue.add(issue_4.getText().toString());
                }
                if(issue_5.isChecked()==true){
                    material_issue.add(issue_5.getText().toString());
                }
                if(issue_6.isChecked()==true){
                    material_issue.add(issue_6.getText().toString());
                }
                if(issue_7.isChecked()==true){
                    material_issue.add(issue_7.getText().toString());
                }
                if(issue_8.isChecked()==true){
                    material_issue.add(issue_8.getText().toString());
                }
                Message msg1 = new Message();
                msg1.what = MEG_INVALIDATE;
                test_renew.sendMessage(msg1);

            }
        });
        dialog.setNeutralButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //mothing
            }
        });
        if (Process.equals("花蓮切割") ||
                Process.equals("花蓮全檢") ||
                Process.equals("花蓮加壓") ||
                Process.equals("花蓮色碼") ||
                Process.equals("花蓮底漆") ||
                Process.equals("花蓮塗裝"))//有測試資料以外才顯示不合格視窗
        {
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

    }

    Handler test_renew = new Handler() {
        public void handleMessage(Message msg) {
            if (material_issue_bnt.getText().toString().indexOf("測試")>-1){
                material_issue.clear();
                material_issue_bnt.setText("不合格");
            }else{
                if(material_issue.toString().indexOf("測試")>-1){
                    material_issue_bnt.setText("測試資料");
                }else {
                    material_issue_bnt.setText("不合格");
                }
            }
            super.handleMessage(msg);
        }

    };
    Handler setstart = new Handler() {
        public void handleMessage(Message msg) {

            accident.setVisibility(VISIBLE);
            accident_text.setVisibility(VISIBLE);
            accident.setText("開始");          //  6213559680000
            accident.setVisibility(VISIBLE);
            test.setVisibility(INVISIBLE);
            sptest.setVisibility(INVISIBLE);
            part_finish_bnt.setVisibility(INVISIBLE);
            startflig = 0; // 機.performClick();.performClick();台狀態    已經開始為 1  尚未開始為0

            super.handleMessage(msg);
        }

    };
    Handler agent = new Handler() {
        public void handleMessage(Message msg) {
            accident.setVisibility(VISIBLE);
            accident_text.setVisibility(VISIBLE);
            accident.setText("開始");          //  6213559680000
            accident.setVisibility(VISIBLE);
            test.setVisibility(INVISIBLE);
            sptest.setVisibility(INVISIBLE);
            part_finish_bnt.setVisibility(INVISIBLE);
            startflig = 0; // 機.performClick();.performClick();台狀態    已經開始為 1  尚未開始為0
            View rootView = getWindow().getDecorView().getRootView();
            Message_show(rootView);

            super.handleMessage(msg);
        }

    };

    static Handler loading1 = new Handler() {
        public void handleMessage(Message msg) {
            MainActivity.messageview.setText("訊息:伺服器沒有回應");
            MainActivity.progressBar.setVisibility(View.VISIBLE);
            super.handleMessage(msg);
        }
    };
    Handler progressBar_S = new Handler() {
        public void handleMessage(Message msg) {
            try {
                Thread.sleep(3000); //1000為1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            progressBar.setVisibility(View.GONE);
            super.handleMessage(msg);
        }
    };
    Handler progressBar_T = new Handler() {
        public void handleMessage(Message msg) {
            progressBar.setVisibility(VISIBLE);
            Message m2 = new Message();
            m2.what = MEG_INVALIDATE;
            progressBar_S.sendMessage(m2);
            super.handleMessage(msg);
        }
    };
    Handler cow = new Handler() {
        public void handleMessage(Message msg) {
            TextView textView59=(TextView) findViewById(R.id.textView52);
            textView59.setText(COW_name);
            super.handleMessage(msg);
        }
    };
    Handler HmoreprogressBar = new Handler() {
        public void handleMessage(Message msg) {
/*
            if (logout_flag==1){
                progressBar.setVisibility(GONE);
            }

            else {
                progressBar.setVisibility(GONE);
                moreprogressBar.setVisibility(GONE);
            }*/
            super.handleMessage(msg);
        }
    };
    Handler HSmoreprogressBar = new Handler() {
        public void handleMessage(Message msg) {
/*
            if (logout_flag == 1){
                progressBar.setVisibility(VISIBLE);
        }
            else {
                progressBar.setVisibility(VISIBLE);
                moreprogressBar.setVisibility(VISIBLE);
            }*/

            super.handleMessage(msg);
        }
    };
    Handler cls_user = new Handler() {
        public void handleMessage(Message msg) {

            user_select.setText("選擇人員");

            super.handleMessage(msg);
        }
    };
    Handler box = new Handler() {
        public void handleMessage(Message msg) {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("message");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
            builder.show();
            super.handleMessage(msg);
        }
    };
    //不合格moreprogressBar       HSmoreprogressBarHSmoreprogressBar
    public void testerr(View view) {
        Random rand = new Random();
        int MAX = 5;
        ArrayList<Double> myList = new ArrayList<Double>(5);
        try{
            for (int i = 0; i < 8; i++)// to throw IndexOutOfBoundsException
            {
                if(myList.size()>MAX)
                    throw new IndexOutOfBoundsException("My message");
                myList.add(0.0);
            }
    } catch (NullPointerException  e) {
            CharArrayWriter cw = new CharArrayWriter();
            PrintWriter w = new PrintWriter(cw);
            e.printStackTrace(w);
            w.close();
            trace = cw.toString();
            e.printStackTrace();
            View rootView = getWindow().getDecorView().getRootView();
            send_urlsting(rootView);
        }catch (IndexOutOfBoundsException  e) {
            CharArrayWriter cw = new CharArrayWriter();
            PrintWriter w = new PrintWriter(cw);
            e.printStackTrace(w);
            w.close();
            trace = cw.toString();
            e.printStackTrace();
            View rootView = getWindow().getDecorView().getRootView();
            send_urlsting(rootView);
        }catch (Exception e) {
            CharArrayWriter cw = new CharArrayWriter();
            PrintWriter w = new PrintWriter(cw);
            e.printStackTrace(w);
            w.close();
            trace = cw.toString();
            e.printStackTrace();
            View rootView = getWindow().getDecorView().getRootView();
            send_urlsting(rootView);
        }
    }

    //重登紀錄ip
    public void login_again(View view) {
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        int ip = wifiInfo.getIpAddress();
        ipString = String.format(
                "%d.%d.%d.%d",
                (ip & 0xff),
                (ip >> 8 & 0xff),
                (ip >> 16 & 0xff),
                (ip >> 24 & 0xff));
        System.out.println(ipString);
        View rootView = getWindow().getDecorView().getRootView();
        relogin=1;

        Button button4 = (Button) findViewById(R.id.button4);
        Button accident = (Button) findViewById(R.id.accident);
        Button sptest = (Button) findViewById(R.id.sptest);
        Button part_finish_bnt = (Button) findViewById(R.id.part_finish);
        Button test = (Button) findViewById(R.id.test);
        Button logout = (Button) findViewById(R.id.logout);
        ImageView imageView8 = (ImageView) findViewById(R.id.imageView8);
        ImageView report = (ImageView) findViewById(R.id.report);
        report.setVisibility(INVISIBLE);
        TextView version = (TextView) findViewById(R.id.version);
        version.setVisibility(INVISIBLE);
        button4.setVisibility(VISIBLE);
        //accident.setVisibility(VISIBLE);
        sptest.setVisibility(VISIBLE);
        if (Process.equals("花蓮切割") ){
            part_finish_bnt.setVisibility(VISIBLE);
        }else {
            part_finish_bnt.setVisibility(INVISIBLE);
        }
        logout.setVisibility(VISIBLE);
        imageView8.setVisibility(INVISIBLE);
        button1 = (Button) findViewById(R.id.button2);
        button1.setVisibility(INVISIBLE);
        button41 = (Button) findViewById(R.id.button41);
        button41.setVisibility(INVISIBLE);
        //////////
        SharedPreferences saveip = getPreferences(Activity.MODE_PRIVATE);
        String last_user = saveip.getString("last_user", "");
        if (!last_user.equals("")) {//代理登出
            try {
                encodedUrl2 = URLEncoder.encode(last_user, "UTF-8");
                encodedUrl3 = URLEncoder.encode(Process, "UTF-8");//製程
                userBar = userBar.replaceAll("\\*", "");
                //user Logout start
                url_stting = host + "PrdMgn/Logout?userBar=" + encodedUrl2 + "&Dept=" + encodedUrl3
                +"&agentUser="+encodedUrl2;
                System.out.println(url_stting);
                call_rest restObj = new call_rest();
                JSONObject rtnRestObj = restObj.callRest(url_stting);
            } catch (Exception e) {

            }
        }

        ///////////
        getu(rootView);
    }

    public void getshort2(View view) {
//initGldPent(view);
        try {//掃描
            String encodedUrl = "", encodedUr2 = "", encodedUr3 = "";
            encodedUrl = URLEncoder.encode(flowBar, "UTF-8");
            encodedUr2 = URLEncoder.encode(userBar, "UTF-8");
            encodedUr3 = URLEncoder.encode(Process, "UTF-8");
            call_rest restObj = new call_rest();
            JSONObject rtnRestObj = restObj.callRest(
                    host+"PrdMgn/ScanOperate?command=0&UID="+userBar
                            +"&DEPT="+Process+"&shortSubFlow="+shotsub_text.getText().toString());
            if(rtnRestObj.getString("Message").indexOf("完成")>-1){
                fillGldPent(rtnRestObj, view);
            }else{
                getshort(view);
            }
        } catch (Exception e) {
            e.printStackTrace();
            CharArrayWriter cw = new CharArrayWriter();
            PrintWriter w = new PrintWriter(cw);
            e.printStackTrace(w);
            w.close();
            trace = cw.toString();
            View rootView = getWindow().getDecorView().getRootView();
            send_urlsting(rootView);
        }
    }
    public void getshort(View view) {
        try{
        final int[] fin = {0};mylist.clear();
            Thread thread_myPrdRecords = new Thread(new Runnable() {
                public void run() {
                    try {
                        call_rest restObj = new call_rest();
                        JSONObject rtnRestObj = restObj.callRest(
                                host+"PrdMgn/ScanOperate?command=0&UID="+userBar
                                        +"&DEPT="+Process+"&shortSubFlow="+shotsub_text.getText().toString());

                        JSONArray array = new JSONArray(rtnRestObj.getString("Data"));
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject jsonObject = array.getJSONObject(i);
                            String myPrd_MASTER_MFO_ID = jsonObject.getString("SUBFLOWID");
                            String MASTER_MFO_ID = jsonObject.getString("MASTER_MFO_ID");
                            String RTYPE = jsonObject.getString("RTYPE");
                            String VAL = jsonObject.getString("VAL");
                            String Tol = jsonObject.getString("Tol");
                            String batchNo = jsonObject.getString("batchNo");
                            String barCode = jsonObject.getString("barCode");
                            if (RTYPE.equals("null"))RTYPE="";

                            if (VAL.equals("null"))VAL="";

                            if (Tol.equals("null"))Tol="";
                            if (batchNo.equals("null"))batchNo="";
                            if (barCode.equals("null"))barCode="";
                            if (MASTER_MFO_ID.equals("null"))MASTER_MFO_ID="";
                            if (!MASTER_MFO_ID.equals("")){
                            mylist.add( "速碼:" +" "+myPrd_MASTER_MFO_ID+"  "+"工令單號:" +" "+ MASTER_MFO_ID+" |  "+
                                    "" +"  "+ RTYPE+"  "+
                                    ""+"  " + VAL+"  "+
                                    ""+"  "+ Tol+"%  "+
                                    ""+"  "+ batchNo+"\n\n"+
                                    "barCode:" + barCode+"\t"
                            );}
                            System.out.println( "工令單號:" + myPrd_MASTER_MFO_ID);
                        }fin[0]=1;
                        mylist.add( "" );
                    } catch (Exception e) {

                    }
                }
            });
            if(shotsub_text.getText().toString().equals("")){

            }else{
                thread_myPrdRecords.start();  //thread_ver

                int i=0;
                while (true) {
                    if(fin[0] ==0){

                    }else{
                        try {
                            //Thread.sleep(3000);
                            i++;
                            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                            final View v = inflater.inflate(R.layout.mysteprecords, null);   //   get viwe layout
                            final ListView listview2 = (ListView) v.findViewById(R.id.mydynamicmy2);
                            out_shift1 = (Button) v.findViewById(R.id.out_shift1);
                            out_shift2= (Button) v.findViewById(R.id.out_shift2);
                            out_shift3= (Button) v.findViewById(R.id.out_shift3);
                            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                            TextView title = new TextView(this);
                            title.setText("");
                            if (logout_flag==1){
                                title.setText("");
                            }
                            ArrayAdapter adapter = new ArrayAdapter(this,
                                    android.R.layout.simple_list_item_1,
                                    mylist) {
                                @Override
                                public View getView(int position, View convertView, ViewGroup parent) {
                                    View view = super.getView(position, convertView, parent);
                                    TextView tv = (TextView) view.findViewById(android.R.id.text1);
                                    tv.setHeight(20);
                                    tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
                                    return view;
                                }
                            };
                            title.setGravity(Gravity.CENTER);
                            title.setTextSize(24);
                            dialog.setCustomTitle(title);
                            dialog.setView(v);
                            listview2.setAdapter(adapter);

                            dialog.setNegativeButton("離開", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //mothingsetNegativeButton
                                }
                            });

                            final AlertDialog dlg = dialog.show();
                            listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                                    String itemValue    = (String) listview2.getItemAtPosition(position);
                                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                    String[] barnurl = itemValue.split("barCode:");
                                    String[] barnur2 = itemValue.split("\\|");

                                    barnur2[0]=barnur2[0].replaceAll("工令單號:", "");

                                    builder.setMessage("是否取得流程單資訊 : "+barnur2[0]);
                                    builder.setCancelable(false);
                                    flowBar=barnurl[1];
                                    builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            View rootView = getWindow().getDecorView().getRootView();
                                            getg(rootView);
                                            dlg.dismiss();
                                        }
                                    });
                                    builder.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                        }
                                    });
                                    builder.show();
                                }
                            });
                            WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
                            //視窗長寬
                            params.width = 1500;
                            params.height = 700;
                            //button text size
                            dlg.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
                            dlg.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
                            dlg.getButton(AlertDialog.BUTTON_NEGATIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
                            dlg.getWindow().setAttributes(params);

                            //Message msg2 = new Message();
                            //msg1.what = MEG_INVALIDATE;
                            //HmoreprogressBar.sendMessage(msg2);

                            break;
                        } catch (Exception e) {

                            CharArrayWriter cw = new CharArrayWriter();
                            PrintWriter w = new PrintWriter(cw);
                            e.printStackTrace(w);
                            w.close();
                            trace = cw.toString();
                            e.printStackTrace();
                            View rootView = getWindow().getDecorView().getRootView();
                            send_urlsting(rootView);
                        }
                    }

                }
            }
} catch (Exception e) {}
    }


    public void coworker(View view) {//共同生產
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        final View v = inflater.inflate(R.layout.coworker, null);   //   get viwe layout\
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        TextView title = new TextView(this);
        title.setText("共同生產");
        title.setGravity(Gravity.CENTER);
        title.setTextSize(24);
        dialog.setCustomTitle(title);
        dialog.setView(v);
        final AlertDialog dlg = dialog.show();

        if (!COW_name.equals("")) {
            TextView textView59 = (TextView) v.findViewById(R.id.textView59);
            textView59.setText("共同生產人\t"+COW_name.toString());
        }
        Button cobnt= (Button) v.findViewById(R.id.cobnt);
        Button cobnt2= (Button) v.findViewById(R.id.cobnt2);
        if (!COW_name.equals("")) {
            cobnt2.setEnabled(true);
        }else{
            cobnt2.setEnabled(false);
        }
        cobnt.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                coworker_flag=1;
                IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
                if (camera_str == 1) {
                    integrator.setCameraId(1);
                } else {
                    integrator.setCameraId(0);
                }
                integrator.initiateScan();
                dlg.dismiss();
            }
        });
        final TextView textView59 = (TextView) v.findViewById(R.id.textView59);

        cobnt2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                textView59.setText("共同生產人\t");

                coworker_bnt.setBackgroundResource(R.drawable.ic_people_outline);
                COW_name="";
                SharedPreferences remdname = getPreferences(Activity.MODE_PRIVATE);
                SharedPreferences.Editor edit = remdname.edit();
                edit.putString("coworker", coworker_bar);
                edit.putString("COW_name", COW_name);
                edit.commit();
                try
                {
                    call_rest restObj = new call_rest();
                    String encodedUrl2 = "", encodedUrl3 = "";
                    encodedUrl3 = URLEncoder.encode(Process, "UTF-8");//製程
                    JSONObject rtnRestObj=restObj.callRest(host+"PrdMgn/Login?userBar=" +
                            coworker_bar + "&Dept=" + encodedUrl3 + "&facroryNo=" + facroryNo+"&coworker="+coworker_bar);//+192.168.1.1);
                    JSONArray array = new JSONArray(rtnRestObj.getString("Data"));
                    COW_name="";coworker_bar="";
                    Message m = new Message();
                    m.what = MEG_INVALIDATE;
                    cow.sendMessage(m);
                }catch (Exception e) {

                }
                dlg.dismiss();
            }
        });

        dialog.setNeutralButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //mothing
            }
        });
        //AlertDialog dlg = dialog.show();
        WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
        //視窗長寬
        params.width = 1200;
        params.height = 700;
        //button text size
        dlg.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
        dlg.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
        dlg.getWindow().setAttributes(params);
    }
    public void edit_signs(View view) {//修改未完成流程單
            try {
                //PrdMgn/ScanOperate?command=8&UID=B_004&DEPT=%E8%8A%B1%E8%93%AE%E5%88%87%E5%89%B2&signID=1602      edit_sign
                String encodedUrl = "", encodedUr2 = "", encodedUr3 = "", encodedUr4 = "";
                userBar = userBar.replaceAll("\\*", "");
                encodedUr2 = URLEncoder.encode(userBar, "UTF-8");
                encodedUr4 = URLEncoder.encode(Process, "UTF-8");
                if (!Process_SWT.equals(""))
                {
                    encodedUr4 = URLEncoder.encode("花蓮塗裝", "UTF-8");

                }
                String command="8";
                if(Process.equals("花蓮貼帶")) {
                    command="38";
                }
                if(Process.equals("花蓮外檢")) {
                    command="48";
                }
                url_stting = host + "PrdMgn/ScanOperate?command="+command+"&UID=" + encodedUr2 +"&DEPT="+encodedUr4+"&signID="+edit_sign;
                call_rest restObj = new call_rest();
                JSONObject rtnRestObj = restObj.callRest(url_stting);
                fillGldPent(rtnRestObj, view);
            } catch (Exception e) {
                CharArrayWriter cw = new CharArrayWriter();
                PrintWriter w = new PrintWriter(cw);
                e.printStackTrace(w);
                w.close();
                trace = cw.toString();
                e.printStackTrace();
                View rootView = getWindow().getDecorView().getRootView();
                //send_urlsting(rootView);
            }
        }


    public void changtostart(View view) { //修改為未完成

        try
        {
            call_rest restObj = new call_rest();
            String encodedUrl2 = "", encodedUrl3 = "";
            encodedUrl3 = URLEncoder.encode(Process, "UTF-8");//製程
            JSONObject rtnRestObj=restObj.callRest(host+"/PrdMgn/updSignStatus?flowBar="+flowBar+"&dept="+encodedUrl3);//+192.168.1.1);
            JSONArray array = new JSONArray(rtnRestObj.getString("Data"));
            COW_name="";
            Message m = new Message();
            m.what = MEG_INVALIDATE;
            chang.sendMessage(m);
        }catch (Exception e) {

        }
    }

    Handler chang = new Handler() {//修改為未完成
        public void handleMessage(Message msg) {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("修改完成");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    View rootView = getWindow().getDecorView().getRootView();

                    localtest(rootView);
                }
            });
            builder.show();
            super.handleMessage(msg);
        }
    };

    public void st(View view) {//貼 交接
        si_f=1;
    }

    public void si(View view) {//貼入庫
        si_f=0;
    }
    public void Process_sw(View view) {  //塗裝切換製程
        if (Process_bnt.getText().equals("底漆")){
            Process_bnt.setText("色碼");
            Process="花蓮色碼";
            Process_SWT="花蓮塗裝";
        }else{
            Process_bnt.setText("底漆");
            Process="花蓮底漆";
            Process_SWT="花蓮塗裝";
        }
        Process_SWT="花蓮塗裝";
        url_Texted.invalidate();
        url_Texted.setText("  " + url_stting);
        VAL_text_title.invalidate();
        VAL_text_value.invalidate();
        VAL_text_value.setText("  ");
        note_value.invalidate();
        note_value.setText("  " );
        mfo_id_text_value.setText("  " );
        BATCH_QTY_text_value.invalidate();
        BATCH_QTY_text_value.setText("  ");
        DELDATE_text_value.invalidate();
        BATCH_NO_text_value.setText("  ");
        RTYPE_text_value.invalidate();
        RTYPE_text_value.setText("  ");
        TOL_text_value.invalidate();
        TOL_text_value.setText("  ");
        PPM_text_value.invalidate();
        PPM_text_value.setText("  ");
        COLOR_NUM_text_value.invalidate();
        COLOR_NUM_text_value.setText("");
        getu(view);
    }

    public void wifi(View view) {
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        wifiManager.setWifiEnabled(false);
        wifiManager.setWifiEnabled(true);
        try
        {
            call_rest restObj = new call_rest();
            String encodedUrl2 = "", encodedUrl3 = "";
            encodedUrl3 = URLEncoder.encode(Process, "UTF-8");//製程
            JSONObject rtnRestObj=restObj.callRest(host+"/ProdFlow/TestConnection");//+192.168.1.1);
            TestConnection = rtnRestObj.getString("Data");

            Message m = new Message();
            m.what = MEG_INVALIDATE;
            TestConn.sendMessage(m);
        }catch (Exception e) {

            Message m = new Message();
            m.what = MEG_INVALIDATE;
            TestConn.sendMessage(m);
        }
    }
    Handler TestConn = new Handler() {//修改為未完成
        public void handleMessage(Message msg) {
            String meg;
            progressBar.setVisibility(View.GONE);
            if (TestConnection.equals("This is FirstohmWebAPI Test")){
                meg="連線成功";
                wifi_bnt.setVisibility(GONE);
            }else{
                meg="連線失敗請重試";
            }
            TestConnection="";
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage(meg);
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                }
            });
            builder.show();
            super.handleMessage(msg);
        }
    };

    public void todef(View view) {
        Message m = new Message();
        m.what = MEG_INVALIDATE;
        Handtodef.sendMessage(m);
    }

    Handler Handtodef = new Handler() {
        public void handleMessage(Message msg) {
            furyu_Texted.setText(AccQuan_Texted.getText());
            AccQuan_Texted.setText("0");
            super.handleMessage(msg);
        }
    };

    public void send_line(View view) {

        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        final View v = inflater.inflate(R.layout.send_line, null);   //   get viwe layout\
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        TextView title = new TextView(this);
        title.setText("通知");
        title.setGravity(Gravity.CENTER);
        title.setTextSize(24);
        dialog.setCustomTitle(title);
        dialog.setView(v);
        Button btn_sendline_report = (Button) v.findViewById(R.id.btn_sendline_report);
        Button reset_mid = (Button) v.findViewById(R.id.reset_mid);
        Button btn_sendline_start = (Button) v.findViewById(R.id.btn_sendline_start);
        Button btn_sendline_finsh = (Button) v.findViewById(R.id.btn_sendline_finsh);
        Button btn_sendline_logout = (Button) v.findViewById(R.id.btn_sendline_logout);
        Button btn_sendline_login = (Button) v.findViewById(R.id.btn_sendline_login);

        dialog.setNeutralButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //mothing
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
}
