package com.alankin.yunyun.fragments;


import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alankin.yunyun.R;
import com.alankin.yunyun.util.StatusBarUtil1;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserInfoFragment extends ModuleFragment {
    @BindView(R.id.civ_portrait)
    CircleImageView civPortrait;
    @BindView(R.id.tv_nickname)
    TextView tvNickname;

    public UserInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public String getModuleName() {
        return "我的";
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_user_info;
    }

    @Override
    public void init() {
        StatusBarUtil1.setStatusBarColor(getActivity(), Color.TRANSPARENT);
    }


    @OnClick({R.id.civ_portrait, R.id.rl_msg, R.id.rl_collection, R.id.rl_history, R.id.rl_subscribe, R.id.rl_setting, R.id.rl_suggestion})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.civ_portrait:
                break;
            case R.id.rl_msg:
                break;
            case R.id.rl_collection:
                break;
            case R.id.rl_history:
                break;
            case R.id.rl_subscribe:
                break;
            case R.id.rl_setting:
                break;
            case R.id.rl_suggestion:
                break;
        }
    }
}
