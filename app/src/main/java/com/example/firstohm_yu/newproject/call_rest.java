package com.example.firstohm_yu.newproject;

import android.os.Handler;
import android.os.Message;
import android.view.View;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static com.example.firstohm_yu.newproject.MainActivity.MEG_INVALIDATE;

public class call_rest {
    static JSONObject rtnJson=null;
    static CountDownLatch latch;
    static String result=null;
    //有無 Post Data, 都可以呼叫此 Post Function
    public static JSONObject postRest(final String url_stting, final String postData) {
        latch = new CountDownLatch(1);
        result=null;
        Message m = new Message();
        m.what = MEG_INVALIDATE;
        loading1.sendMessage(m);
        //MainActivity.progressBar.setVisibility(VISIBLE);


        Thread thread5 = new Thread(new Runnable() {
            public void run() {
                try {

                    HttpClient http = new DefaultHttpClient();
                    HttpPost post = new HttpPost(url_stting);
                    List params = null;
                    if(postData != null) {
                        params = new ArrayList();
                        params.add(new BasicNameValuePair("jsonStr", postData));
                        UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params, HTTP.UTF_8);
                        post.setEntity(ent);
                    }
                    System.out.println(url_stting+"&jsonStr="+postData);
                    HttpResponse responsePOST = http.execute(post);

                    HttpEntity resEntity = responsePOST.getEntity();
                    result = EntityUtils.toString(resEntity);
                    System.out.println("result"+result);
                    rtnJson = new JSONObject(result.toString());
                    Message m2 = new Message();
                    m2.what = MEG_INVALIDATE;
                    loading2.sendMessage(m2);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("INTERNET ERROR");

                } finally {
                    latch.countDown();
                }
            }
        });
        thread5.start();  //user inf
        try {
            latch.await(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
        return rtnJson;
    }
    //電鍍post
    public static JSONObject postRest_platingJson(final String url_stting, final String postData) {
        latch = new CountDownLatch(1);
        result=null;
        Message m = new Message();
        m.what = MEG_INVALIDATE;
        loading1.sendMessage(m);
        Thread thread5 = new Thread(new Runnable() {
            public void run() {
                try {

                    HttpClient http = new DefaultHttpClient();
                    HttpPost post = new HttpPost(url_stting);
                    List params = null;
                    if(postData != null) {
                        params = new ArrayList();
                        params.add(new BasicNameValuePair("platingJson", postData));
                        UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params, HTTP.UTF_8);
                        post.setEntity(ent);
                    }
                    System.out.println(url_stting+"&platingJson="+postData);
                    HttpResponse responsePOST = http.execute(post);
                    HttpEntity resEntity = responsePOST.getEntity();
                    result = EntityUtils.toString(resEntity);
                    System.out.println("result"+result);
                    rtnJson = new JSONObject(result.toString());
                    Message m2 = new Message();
                    m2.what = MEG_INVALIDATE;
                    loading2.sendMessage(m2);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            }
        });
        thread5.start();  //user inf
        try {
            latch.await(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
        return rtnJson;
    }
    //電鍍post
    public static JSONObject postRest_platingdata(final String url_stting,final String key, final String postData) {
        final String[] u = new String[1];
        final  JSONObject response = null;
        final JSONObject[] obj = {null};
        new Thread(new Runnable() {
            public void run() {
                JSONObject jsonObjectResp = null;
                try {
                    StringBuilder stringBuilder = new StringBuilder ();
                    HttpURLConnection httpURLConnection;
                    DataOutputStream printout;
                    httpURLConnection = (HttpURLConnection) new URL (url_stting).openConnection ();
                    httpURLConnection.setRequestMethod ("POST");
                    httpURLConnection.setReadTimeout (1500);
                    httpURLConnection.setConnectTimeout (1500);
                    httpURLConnection.setDoInput (true);
                    httpURLConnection.setDoOutput (true);
                    httpURLConnection.setUseCaches (false);
                    httpURLConnection.connect ();
                    // Send POST output.
                    printout = new DataOutputStream(httpURLConnection.getOutputStream ());
                    printout.writeBytes (key+"=" + URLEncoder.encode (postData.toString (), "UTF-8"));
                    printout.flush ();
                    printout.close ();
                    InputStreamReader inputStreamReader = new InputStreamReader (httpURLConnection.getInputStream ());
                    int read;
                    char[] buff = new char[4096];
                    while ((read = inputStreamReader.read (buff)) != -1) {
                        stringBuilder.append (buff, 0, read);
                    }
                    httpURLConnection.disconnect ();
                    u[0] =stringBuilder.toString();
                     obj[0] = new JSONObject(u[0]);
                } catch (Exception ex) {
                    System.out.println("======"+ex);
                    String err = String.format("{\"result\":\"false\",\"error\":\"%s\"}", ex.getMessage());
                }
                // call send message here
            }
        }).start();
        int i=0;

        while (true){
            i++;
            if(!(obj[0] ==null)){
                return obj[0];
            }else if(i==10){return null;}
        }


    }
    public static final void runOnUiThread(Runnable action) {

    }
    public static JSONObject postRest_forpla(final String url_stting, final String postData) {
        latch = new CountDownLatch(1);
        result=null;
        Message m = new Message();
        m.what = MEG_INVALIDATE;
        loading1.sendMessage(m);
        //MainActivity.progressBar.setVisibility(VISIBLE);
        Thread thread5 = new Thread(new Runnable() {
            public void run() {
                try {
                    HttpClient http = new DefaultHttpClient();
                    HttpPost post = new HttpPost(url_stting);
                    List params = null;
                    if(postData != null) {
                        params = new ArrayList();
                        params.add(new BasicNameValuePair("selectedJson", postData));
                        UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params, HTTP.UTF_8);
                        post.setEntity(ent);
                    }
                    System.out.println(url_stting+"&selectedJson="+postData);
                    HttpResponse responsePOST = http.execute(post);
                    HttpEntity resEntity = responsePOST.getEntity();
                    result = EntityUtils.toString(resEntity);
                    rtnJson = new JSONObject(result.toString());
                    Message m2 = new Message();
                    m2.what = MEG_INVALIDATE;
                    loading2.sendMessage(m2);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            }
        });
        thread5.start();  //user inf
        int i = 0;  //等待時間
        try {
            latch.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
        //MainActivity.progressBar.setVisibility(View.GONE);
        return rtnJson;
    }
    public static JSONObject postRestsend(final String url_stting, final String postData, final String sub, final String code) {
        latch = new CountDownLatch(1);
        result=null;
        Message m = new Message();
        m.what = MEG_INVALIDATE;
        loading1.sendMessage(m);
        try {
            Thread.sleep(300); //1000為1秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //MainActivity.progressBar.setVisibility(VISIBLE);
        Thread thread5 = new Thread(new Runnable() {
            public void run() {
                try {
                    HttpClient http = new DefaultHttpClient();
                    HttpPost post = new HttpPost(url_stting);
                    List params = null;
                    if(postData != null) {
                        params = new ArrayList();
                        params.add(new BasicNameValuePair("subject", sub ));
                        params.add(new BasicNameValuePair("body", postData));
                        //params.add(new BasicNameValuePair("subject", code));
                        UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params, HTTP.UTF_8);
                        post.setEntity(ent);
                    }
                    System.out.println(url_stting+"?body="+postData+"&subject="+sub);
                    HttpResponse responsePOST = http.execute(post);
                    HttpEntity resEntity = responsePOST.getEntity();
                    result = EntityUtils.toString(resEntity);
                    rtnJson = new JSONObject(result.toString());
                    Message m2 = new Message();
                    m2.what = MEG_INVALIDATE;
                    loading2.sendMessage(m2);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            }
        });
        thread5.start();  //user inf
        int i = 0;  //等待時間
        try {
            latch.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
        //MainActivity.progressBar.setVisibility(View.GONE);
        return rtnJson;
    }
    public static JSONObject callRest(final String url_stting) {
        latch = new CountDownLatch(1);
        Message m = new Message();
        m.what = MEG_INVALIDATE;
        loading1.sendMessage(m);
        Thread thread5 = new Thread(new Runnable() {
            public void run() {
                try {
                    URL url = new URL(url_stting);
                    System.out.println("==>"+url_stting);
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

                    System.out.println("==>"+sb.toString());
                    rtnJson = new JSONObject(sb.toString());
                    Message m2 = new Message();
                    m2.what = MEG_INVALIDATE;
                    loading2.sendMessage(m2);
                } catch (MalformedURLException e) {
                    MainActivity.messageview.setText("訊息:伺服器沒有回應");
                } catch (IOException e) {

                    MainActivity.messageview.setText("訊息:伺服器沒有回應");
                } catch (Exception e) {

                    MainActivity.messageview.setText("訊息:伺服器沒有回應");
                } finally {
                    latch.countDown();
                }
            }
        });
        thread5.start();  //user inf
        try {
            latch.await(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
        //MainActivity.progressBar.setVisibility(View.GONE);

        return rtnJson;
    }
    static Handler loading1 = new Handler() {
        public void handleMessage(Message msg) {
            MainActivity.progressBar.setVisibility(View.VISIBLE);
            super.handleMessage(msg);
        }
    };
    static Handler loading2 = new Handler() {
        public void handleMessage(Message msg) {
            MainActivity.messageview.setText("訊息:完成");
            MainActivity.progressBar.setVisibility(View.GONE);
            super.handleMessage(msg);
        }
    };
}