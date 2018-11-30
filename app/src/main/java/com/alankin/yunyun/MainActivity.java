package com.alankin.yunyun;

import android.content.res.ColorStateList;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import com.alankin.yunyun.activity.BaseActivity;
import com.alankin.yunyun.adpter.ModulePagerAdpter;
import com.alankin.yunyun.entity.TestBean;
import com.alankin.yunyun.fragments.CatFragment;
import com.alankin.yunyun.fragments.HomeFragment;
import com.alankin.yunyun.fragments.ModuleFragment;
import com.alankin.yunyun.fragments.UserInfoFragment;
import com.alankin.yunyun.listener.OnSimpleTabSelectedListener;
import com.alankin.yunyun.views.TabItemView;

import java.util.ArrayList;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.tl_tab)
    TabLayout tl_tab;

    @BindView(R.id.home_viewpager)
    ViewPager viewPager;

    @BindColor(R.color.colorPrimary)
    int colorPrimary;

    @BindColor(R.color.colorTextGray)
    int colorTextGray;

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        TestBean testBean = new TestBean();
        testBean.setName("这是名字1");
        testBean.setBook("这是book1");
        //初始化tab
        initTab();
        initViewPager();
    }

    private void initViewPager() {
        viewPager.setEnabled(false);
        ModulePagerAdpter adapter = new ModulePagerAdpter(getSupportFragmentManager());
        ArrayList<ModuleFragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new CatFragment().setModuleName("分类"));
        fragments.add(new CatFragment().setModuleName("消息"));
        fragments.add(new UserInfoFragment().setModuleName("我的"));
        adapter.setFragments(fragments);
        viewPager.setAdapter(adapter);
    }

    private void initTab() {
        ColorStateList textColorList = new ColorStateList(new int[][]{{android.R.attr.state_selected},
                new int[]{}}, new int[]{colorPrimary, colorTextGray});
        TabLayout.Tab tab1 = tl_tab.newTab();
        TabLayout.Tab tab2 = tl_tab.newTab();
        TabLayout.Tab tab3 = tl_tab.newTab();
        TabLayout.Tab tab4 = tl_tab.newTab();

        TabItemView tabItemView1 = new TabItemView(this);
        tabItemView1.setDrawerble(R.drawable.home_icon_selector).setText("首页").setTextColor(textColorList);
        tab1.setCustomView(tabItemView1);
        tl_tab.addTab(tab1);

        TabItemView tabItemView2 = new TabItemView(this);
        tabItemView2.setDrawerble(R.drawable.home_icon_selector).setText("分类").setTextColor(textColorList);
        tab2.setCustomView(tabItemView2);
        tl_tab.addTab(tab2);

        TabItemView tabItemView3 = new TabItemView(this);
        tabItemView3.setDrawerble(R.drawable.home_icon_selector).setText("消息").setTextColor(textColorList);
        tab3.setCustomView(tabItemView3);
        tl_tab.addTab(tab3);

        TabItemView tabItemView4 = new TabItemView(this);
        tabItemView4.setDrawerble(R.drawable.home_icon_selector).setText("我的").setTextColor(textColorList);
        tab4.setCustomView(tabItemView4);
        tl_tab.addTab(tab4);
    }

    @Override
    public void setListener() {
        tl_tab.addOnTabSelectedListener(new OnSimpleTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition(), false);
            }
        });
    }

    @OnClick(R.id.fab_subscribe)
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.fab_subscribe:
                Toast.makeText(this, "点击了发布", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
