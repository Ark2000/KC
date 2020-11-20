package com.example.kc.ui_related;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.kc.R;

import java.util.List;

public class TaskCardAdapter extends ArrayAdapter<TaskCard> {
    private int resourceId;

    public TaskCardAdapter(Context context, int textViewResourceId, List<TaskCard> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TaskCard card = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        TextView card_title = view.findViewById(R.id.card_title);
        TextView card_author = view.findViewById(R.id.card_author);
        TextView card_reward = view.findViewById(R.id.card_reward);
        TextView card_deadline = view.findViewById(R.id.card_deadline);
        TextView card_content = view.findViewById(R.id.card_content);
        card_title.setText(card.getTitle());
        card_author.setText(card.getAuthor());
        card_reward.setText("悬赏：" + card.getReward());
        card_deadline.setText("截止日期：" + card.getDeadline());
        card_content.setText(card.getContent());
        return view;
    }
}
