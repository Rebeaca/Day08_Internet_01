package com.example.user.day08_internet_01.utils;

import android.graphics.Bitmap;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by user on 2016/11/30.
 * 工具类
 * 网络连接
 */

public class NetworkTools {
    private void NetworkTools(){}
    public static InputStream getImage(String pUrl){
        try {
            URL _URL = new URL(pUrl);
            HttpURLConnection _Connection = (HttpURLConnection) _URL.openConnection();
            //建立连接
            _Connection.connect();
            //从连接中获取输入流
            return  _Connection.getInputStream();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
