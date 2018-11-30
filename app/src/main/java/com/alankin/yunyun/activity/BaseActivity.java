package com.alankin.yunyun.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by QYM on 2018/11/9.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        //注入控件
        ButterKnife.bind(this);

        //初始化
        init();

        setListener();
    }

    public abstract
    @LayoutRes
    int getContentView();

    public abstract void init();

    public void setListener() {
    }
}
