package com.alankin.yunyun.fragments;


import android.support.v4.app.Fragment;

import com.alankin.yunyun.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CatFragment extends ModuleFragment {
    @Override
    public int getContentView() {
        return R.layout.fragment_cat;
    }

    @Override
    public void init() {
    }

    @Override
    public String getModuleName() {
        return "分类";
    }
}
