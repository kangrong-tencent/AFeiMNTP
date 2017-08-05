package com.mntp.ui.main.page.browse;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * fragment数据源
 * Created by hyx on 2016/4/13.
 */
public class BrowseAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentList;

    public BrowseAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList=fragmentList;
    }
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
