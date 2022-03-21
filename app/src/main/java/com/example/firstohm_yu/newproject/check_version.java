package com.example.firstohm_yu.newproject;

import android.app.Activity;
import android.os.Looper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class check_version extends Activity {
    public static String getLatestVersion() {
        final String[] ver = new String[1];
        Thread thread_ver = new Thread(new Runnable() {
            public void run() {
                try {
                    URLConnection connection = (new URL(MainActivity.host + "appver.html")).openConnection();
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);
                    connection.connect();

                    InputStream in = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder html = new StringBuilder();
                    for (String line; (line = reader.readLine()) != null; ) {
                        html.append(line);
                    }
                    System.out.println("version from ver java==>" + html.toString());
                    MainActivity.new_version = html.toString();
                    ver[0] = html.toString();
                    in.close();

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread_ver.start();
        int i=0;
        while (true) {
            i++;
            if (!(ver[0] == null)) {
                return ver[0];
            }
            if (!(ver[0] == null)) {
                break;
            }
            if(i==20)break;
        }

        return null;
    }
}


