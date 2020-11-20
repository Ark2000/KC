package com.example.kc;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

public class myThread extends Thread {
    private HttpURLConnection connection;
    private Handler handler;
    private String jsonRequest;
    public myThread(Handler handler, String jsonRequest) {
        this.handler = handler;
        this.jsonRequest = jsonRequest;
    }
    @Override
    public void run() {
        try {
            //封装成传输数据的键值对,无论get还是post,传输中文时都要进行url编码（RULEncoder）
            // 如果是在浏览器端的话，它会自动进行帮我们转码，不用我们进行手动设置
//            jsonRequest = URLEncoder.encode(jsonRequest, "utf-8");
            Log.d("AAA.SEND", jsonRequest);
            connection= HttpConnectionUtils.getConnection(jsonRequest);//设置请求

            int code = connection.getResponseCode();
            if(code==200){
                InputStream inputStream = connection.getInputStream();
                String str = StreamChangeStrUtils.toChange(inputStream);//写个工具类流转换成字符串
                Message message = Message.obtain();//更新UI就要向消息机制发送消息
                message.obj=str;//消息主体
                Log.d("AAA.RECEIVE", str);
                handler.sendMessage(message);
            } else {
                Message message = Message.obtain();
                message.obj="Error Code: " + code;
                handler.sendMessage(message);
            }
        } catch (Exception e) {//会抛出很多个异常，这里抓一个大的异常
            e.printStackTrace();
            Message message = Message.obtain();
            message.obj="Something is wrong...";
            handler.sendMessage(message);
        }
    }
}
