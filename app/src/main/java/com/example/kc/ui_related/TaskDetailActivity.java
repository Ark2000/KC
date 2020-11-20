package com.example.kc.ui_related;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kc.R;

public class TaskDetailActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        Button b1 = (Button) findViewById(R.id.update_submission_btn);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TaskDetailActivity.this, SubmitActivity.class);
                startActivity(intent);
            }
        });

        Button b2 = (Button) findViewById(R.id.view_submissions_btn);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TaskDetailActivity.this, SubmissionListActivity.class);
                startActivity(intent);
            }
        });
    }
}
