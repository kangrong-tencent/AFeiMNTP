package com.mntp.ui.main;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.afeimntp.R;
import com.mntp.ui.base.BaseActivity;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.id_main_v)
    View mainV;
    @BindView(R.id.id_main_tab)
    TabLayout mainTab;
    @BindView(R.id.id_main_vp)
    ViewPager mainVp;
    MainAdapter mainAdapter;

    /**
     * Activity实例
     */
    @Override
    protected Activity getActivity() {
        return this;
    }

    /**
     * xml布局文件
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    /**
     * 初始化，代替onCreate
     */
    @Override
    protected void initData() {
        mPresenter.loadPager();
        mainVp.setOffscreenPageLimit(1);
    }

    /**
     * 设置标题
     *
     * @param tabs
     */
    @Override
    public void setTab(List<String> tabs) {
        mainTab.setTabMode(TabLayout.MODE_FIXED);
        for (String tab : tabs)
            mainTab.addTab(mainTab.newTab().setText(tab));
        mainTab.setOnTabSelectedListener(listener);
    }

    /**
     * tablayout 点击事件
     */
    TabLayout.OnTabSelectedListener listener=new TabLayout.OnTabSelectedListener(){
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            int position = tab.getPosition();
            mainVp.setCurrentItem(position);
        }
        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
        }
        @Override
        public void onTabReselected(TabLayout.Tab tab) {
        }
    };

    /**
     * 设置页面
     *
     * @param lists
     */
    @Override
    public void setPager(List<Fragment> lists) {
        mainAdapter = new MainAdapter(getSupportFragmentManager(), lists);
        mainVp.setAdapter(mainAdapter);
        mainVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mainTab));
    }

    /**
     * loading界面
     */
    @Override
    public void loading() {

    }

    /**
     * 内容显示界面
     */
    @Override
    public void showContent() {

    }

    /**
     * 提示
     *
     * @param msg
     */
    @Override
    public void toastShow(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
