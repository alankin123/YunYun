package com.alankin.yunyun.fragments;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alankin.yunyun.R;
import com.alankin.yunyun.adpter.ModulePagerAdpter;
import com.alankin.yunyun.fragments.subfrags.NearByFragment;
import com.alankin.yunyun.fragments.subfrags.RecommendFragment;
import com.alankin.yunyun.util.StatusBarUtil1;

import java.util.ArrayList;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends ModuleFragment {
    public HomeFragment() {
    }

    @Override
    public String getModuleName() {
        return "首页";
    }

    @BindColor(R.color.colorPrimary)
    int colorPrimary;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @BindView(R.id.tv_search)
    TextView tv_search;

    @BindView(R.id.tl_subtab)
    TabLayout tl_subtab;

    @Override
    public int getContentView() {
        return R.layout.fragment_home;
    }

    @Override
    public void init() {
        StatusBarUtil1.setStatusBarColor(getActivity(), colorPrimary);
        //初始化viewPager
        initViewPager();
        tl_subtab.setupWithViewPager(viewPager);
    }

    private void initViewPager() {
        ModulePagerAdpter adapter = new ModulePagerAdpter(getChildFragmentManager());
        ArrayList<ModuleFragment> fragments = new ArrayList<>();
        fragments.add(new RecommendFragment());
        fragments.add(new NearByFragment());
        adapter.setFragments(fragments);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void setListener() {

    }

    @OnClick({R.id.tv_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_search:
                Toast.makeText(getContext(), "点击了搜索", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
