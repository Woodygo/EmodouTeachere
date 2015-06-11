package com.emodou.teacher.emodouteacher.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by woody on 2015/6/2.
 */
public class ClassFragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragmentsList;

    public ClassFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public ClassFragmentAdapter(FragmentManager fm, ArrayList<Fragment> fragmentsList) {
        super(fm);
        this.fragmentsList = fragmentsList;
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }
}
