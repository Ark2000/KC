package com.example.kc.ui.userinfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.kc.ui_related.AboutActivity;
import com.example.kc.R;
import com.example.kc.ui_related.SettingsActivity;
import com.example.kc.ui_related.SubmissionListActivity;
import com.example.kc.ui_related.TaskListActivity;

public class UserInfoFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_userinfo, container, false);

        Button settings = root.findViewById(R.id.settings_btn);
        Button about = root.findViewById(R.id.about_btn);
        Button myposts = root.findViewById(R.id.myposts);
        Button myquests = root.findViewById(R.id.myquests);
        Button checkin = root.findViewById(R.id.checkin);

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getBaseContext(), SettingsActivity.class);
                startActivity(intent);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getBaseContext(), AboutActivity.class);
                startActivity(intent);
            }
        });

        checkin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getBaseContext(), "签到成功", Toast.LENGTH_SHORT).show();
            }
        });

        myposts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getBaseContext(), TaskListActivity.class);
                startActivity(intent);
            }
        });

        myquests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getBaseContext(), TaskListActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }
}