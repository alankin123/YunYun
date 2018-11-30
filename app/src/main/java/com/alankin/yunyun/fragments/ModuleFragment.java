package com.alankin.yunyun.fragments;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by QYM on 2018/11/9.
 */

public abstract class ModuleFragment extends Fragment {
    private String moduleName = "none";
    Unbinder unbinder;

    public ModuleFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.moduleName = getModuleName();
        View view = inflater.inflate(getContentView(), container, false);
        //注入控件
        unbinder= ButterKnife.bind(this, view);

        //初始化
        init();

        setListener();

        return view;
    }

    public abstract String getModuleName();

    public ModuleFragment setModuleName(String moduleName) {
        this.moduleName = moduleName;
        return this;
    }


    public abstract
    @LayoutRes
    int getContentView();

    public abstract void init();

    public void setListener() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
