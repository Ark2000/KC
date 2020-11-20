package com.example.kc.ui_related;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.kc.R;

import java.util.List;

public class MsgCardAdapter extends ArrayAdapter<MsgCard> {
    private int resourceId;

    public MsgCardAdapter(Context context, int textViewResourceId, List<MsgCard> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MsgCard card = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);

        TextView title = view.findViewById(R.id.msgcard_title);
        TextView content = view.findViewById(R.id.msgcard_content);
        TextView date = view.findViewById(R.id.msgcard_date);

        title.setText(card.getTitle());
        content.setText(card.getContent());
        date.setText(card.getDate());

        return view;
    }

}
