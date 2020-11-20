package com.example.kc.ui_related;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kc.R;

import java.util.ArrayList;
import java.util.List;

public class TaskListActivity extends AppCompatActivity {
    private List<TaskCard> taskCardList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission_list);

        ListView lv = findViewById(R.id.submission_lv);

        initCards();
        TaskCardAdapter adapter = new TaskCardAdapter(this, R.layout.task_card, taskCardList);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(TaskListActivity.this, "你点击了" + id, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(TaskListActivity.this, TaskDetailActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initCards() {
        for (int i = 0; i < 10; ++i) {
            TaskCard card = new TaskCard();
            card.setAuthor("xiaoming");
            card.setContent("this is content");
            card.setDeadline("2020-05-19");
            card.setReward(123.4);
            card.setTitle("Task Title");
            taskCardList.add(card);
        }
    }
}
