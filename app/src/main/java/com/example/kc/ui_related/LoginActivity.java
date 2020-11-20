package com.example.kc.ui_related;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Message;
import android.os.Handler;

import com.example.kc.GlobalHelper;
import com.example.kc.R;
import com.example.kc.myThread;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private EditText userName;
    private EditText password;

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName = findViewById(R.id.username_et);
        password = findViewById(R.id.password_et);

        Button btn1 = findViewById(R.id.visitor_login);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onRegisterBtnClick(View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    @SuppressLint("HandlerLeak")
    public void onLoginBtnClick(View v) {
        String userNameStr = userName.getText().toString();
        String passwordStr = password.getText().toString();

        if (!GlobalHelper.isUsernameValid(userNameStr)) {
            Toast.makeText(this, R.string.username_format_invalid, Toast.LENGTH_SHORT).show();
            return;
        }

        if (!GlobalHelper.isPasswordValid(passwordStr)) {
            Toast.makeText(this, R.string.password_format_invalid, Toast.LENGTH_SHORT).show();
            return;
        }

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("action", "login");
            jsonObject.put("username", userNameStr);
            jsonObject.put("password", passwordStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new myThread(new Handler(){
            @Override
            public void handleMessage(Message msg) {
                Toast.makeText(getApplicationContext(),(String)msg.obj,Toast.LENGTH_SHORT).show();
                try {
                    JSONObject response = new JSONObject((String)msg.obj);
                    boolean success = response.getBoolean("success");
                    String mesg = response.getString("msg");
                    Toast.makeText(LoginActivity.this, mesg, Toast.LENGTH_SHORT).show();
                    if ( success ) {
                        Log.d("login", "success");
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, jsonObject.toString()).start();
    }
}

