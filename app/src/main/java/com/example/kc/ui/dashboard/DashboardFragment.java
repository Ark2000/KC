package com.example.kc.ui.dashboard;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.kc.R;
import com.example.kc.myThread;
import com.example.kc.ui_related.LoginActivity;
import com.example.kc.ui_related.RegisterActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    private View root;
    private EditText title;
    private EditText detail;
    private EditText reward;
    private EditText deadline;
    private EditText location_longitude;
    private EditText location_latitude;

    @SuppressLint("HandlerLeak")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final Button postBtn = root.findViewById(R.id.postBtn);

        title = root.findViewById(R.id.et1);
        detail = root.findViewById(R.id.et2);
        reward = root.findViewById(R.id.et3);
        deadline = root.findViewById(R.id.et4);
        location_longitude = root.findViewById(R.id.et5);
        location_latitude = root.findViewById(R.id.et6);

        postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //构造json
                JSONObject json = new JSONObject();
                try {
                    json.put("action", "publish-quest");
                    json.put("title", title.getText().toString());
                    json.put("detail", detail.getText().toString());
                    json.put("deadline", deadline.getText().toString());
                    json.put("location_lon", Double.parseDouble(location_longitude.getText().toString()));
                    json.put("location_lat", Double.parseDouble(location_latitude.getText().toString()));
                    json.put("reward", Double.parseDouble(reward.getText().toString()));
                    //发布者，暂时还没有设置
                    json.put("publisher", "k2kra");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //向服务器发送
                new myThread(new Handler(){
                    @Override
                    //处理响应
                    public void handleMessage(@NonNull Message msg) {
                        try {
                            JSONObject response = new JSONObject((String)msg.obj);
                            String mesg = response.getString("msg");
                            Toast.makeText(getContext(), mesg, Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, json.toString()).start();
            }
        });
        return root;
    }
}