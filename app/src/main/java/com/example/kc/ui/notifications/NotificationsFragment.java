package com.example.kc.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.kc.ui_related.MsgCard;
import com.example.kc.ui_related.MsgCardAdapter;
import com.example.kc.R;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;

    private List<MsgCard> cardList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        ListView lv = root.findViewById(R.id.lv);
        for (int i = 0; i < 10; ++i) {
            MsgCard card = new MsgCard();
            card.setTitle("提交被采纳");
            card.setContent("你在“晚霞”中的提交被abc123采纳，积分+24");
            card.setDate("2021/08/29");
            cardList.add(card);
        }

        MsgCardAdapter adapter = new MsgCardAdapter(getActivity().getBaseContext(), R.layout.msg_card, cardList);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "你点击了" + id, Toast.LENGTH_LONG).show();
            }
        });

        return root;
    }
}