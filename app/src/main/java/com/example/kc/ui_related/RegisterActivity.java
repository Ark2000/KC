package com.example.kc.ui_related;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kc.GlobalHelper;
import com.example.kc.R;
import com.example.kc.myThread;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
    private EditText usernameet;
    private EditText password1et;
    private EditText password2et;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        usernameet = findViewById(R.id.editText1);
        password1et = findViewById(R.id.editText4);
        password2et = findViewById(R.id.editText2);

    }

    @SuppressLint("HandlerLeak")
    public void onRegisterBtnClick(View v) {
        String username = usernameet.getText().toString();
        String password1 = password1et.getText().toString();
        String password2 = password2et.getText().toString();

        if (!password1.equals(password2)) {
            Toast.makeText(this, "两次输入的密码不一致", Toast.LENGTH_LONG).show();
            return;
        }

        if (!GlobalHelper.isUsernameValid(username)) {
            Toast.makeText(this, R.string.username_format_invalid, Toast.LENGTH_SHORT).show();
            return;
        }

        if (!GlobalHelper.isPasswordValid(password1)) {
            Toast.makeText(this, R.string.password_format_invalid, Toast.LENGTH_SHORT).show();
            return;
        }


        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("action", "register");
            jsonObject.put("username", username);
            jsonObject.put("password", password1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new myThread(new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                try {
                    JSONObject response = new JSONObject((String)msg.obj);
                    boolean success = response.getBoolean("success");
                    String mesg = response.getString("msg");
                    Toast.makeText(RegisterActivity.this, mesg, Toast.LENGTH_SHORT).show();
                    if ( success ) {
                        Log.d("register", "success");
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, jsonObject.toString()).start();
    }
}