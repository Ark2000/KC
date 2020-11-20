package com.example.kc.ui_related;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.kc.R;

import java.util.List;

public class SubmissionCardAdapter extends ArrayAdapter<SubmissionCard> {
    private int resourceId;

    public SubmissionCardAdapter(Context context, int textViewResourceId, List<SubmissionCard> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SubmissionCard card = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);

        TextView title = (TextView) view.findViewById(R.id.subcard_title);
        TextView content = (TextView) view.findViewById(R.id.subcard_content);
        TextView date = (TextView) view.findViewById(R.id.subcard_date);

        title.setText(card.getTitle());
        content.setText(card.getContent());
        date.setText(card.getDate());

        return view;
    }

}
