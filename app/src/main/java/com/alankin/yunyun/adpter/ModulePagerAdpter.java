package com.alankin.yunyun.adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.alankin.yunyun.fragments.ModuleFragment;

import java.util.List;

/**
 * Created by QYM on 2018/11/9.
 */

public class ModulePagerAdpter extends FragmentStatePagerAdapter {
    List<ModuleFragment> fragments;

    public ModulePagerAdpter(FragmentManager fm) {
        this(fm, null);
    }

    public ModulePagerAdpter(FragmentManager fm, List<ModuleFragment> fragments) {
        super(fm);
    }

    public void setFragments(List<ModuleFragment> fragments) {
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getModuleName();
    }
}
