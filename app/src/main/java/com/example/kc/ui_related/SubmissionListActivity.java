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

public class SubmissionListActivity extends AppCompatActivity{
    private List<SubmissionCard> submissionCardList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission_list);

        ListView lv = findViewById(R.id.submission_lv);

        initCards();
        SubmissionCardAdapter adapter = new SubmissionCardAdapter(this, R.layout.submission_card, submissionCardList);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SubmissionListActivity.this, "你点击了" + id, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SubmissionListActivity.this, SubmissionDetailActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initCards() {
        for (int i = 0; i < 10; ++i) {
            SubmissionCard card = new SubmissionCard();
            card.setTitle("我是标题");
            card.setContent("我是内容");
            card.setDate("我是日期");
            submissionCardList.add(card);
        }
    }
}
