package com.alankin.yunyun.fragments;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by QYM on 2018/11/12.
 */

public abstract class BaseFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getContentView(), container, false);
        //注入控件
        ButterKnife.bind(this, view);

        //初始化
        init();

        setListener();

        return view;
    }


    public abstract
    @LayoutRes
    int getContentView();

    public abstract void init();

    public void setListener() {
    }
}
