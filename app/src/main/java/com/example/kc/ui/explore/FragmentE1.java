package com.example.kc.ui.explore;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kc.R;
import com.example.kc.ui_related.TaskCard;
import com.example.kc.ui_related.TaskCardAdapter;
import com.example.kc.ui_related.TaskDetailActivity;

import java.util.ArrayList;
import java.util.List;

public class FragmentE1 extends Fragment {
    private List<TaskCard> taskCardList = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_e1, container, false);
        ListView lv = root.findViewById(R.id.e1_lv);

        initTaskCards();
        TaskCardAdapter adapter = new TaskCardAdapter(getActivity().getBaseContext(), R.layout.task_card, taskCardList);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "你点击了" + id, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getContext(), TaskDetailActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }

    private void initTaskCards() {
        for (int i = 0; i < 3; i++) {
            TaskCard card = new TaskCard();
            card.setTitle("晚霞（距离1.6km）");
            card.setAuthor("abc321");
            card.setContent("听说今天南京的晚霞很美丽，请帮我在新街口的最高点拍摄一张日落的照片，谢谢。");
            card.setReward(240);
            card.setDeadline("2021/08/29");
            taskCardList.add(card);

            card = new TaskCard();
            card.setTitle("机场高速车流情况（距离1.2km）");
            card.setAuthor("yak123");
            card.setContent("请帮我拍摄一段至少一分钟长的机场高速路段车流情况的视频");
            card.setReward(120);
            card.setDeadline("2021/08/24");
            taskCardList.add(card);

            card = new TaskCard();
            card.setTitle("教工楼16栋的告示（距离2.8km）");
            card.setAuthor("666");
            card.setContent("在教工楼16栋一层内部，应该有一张红色的告示贴在墙上，这对我很重要，请帮我拍摄一张清晰的照片");
            card.setReward(1.2);
            card.setDeadline("2021/09/30");
            taskCardList.add(card);
        }
    }

}