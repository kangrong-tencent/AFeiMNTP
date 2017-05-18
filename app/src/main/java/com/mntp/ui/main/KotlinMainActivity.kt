package com.mntp.ui.main

import android.app.Activity
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.widget.Toast
import com.example.administrator.afeimntp.R
import com.mntp.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class KotlinMainActivity : BaseActivity<MainContract.Presenter>(), MainContract.View {
    /**
     * Activity实例
     */
    override fun getActivity(): Activity {
        return this
    }

    /**
     * xml布局文件
     */
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    /**
     * 初始化，代替onCreate
     */
    override fun initData() {
        mPresenter.loadPager()
        id_main_vp.offscreenPageLimit = 10
    }

    /**
     * loading界面
     */
    override fun loading() {
    }

    /**
     * 内容显示界面
     */
    override fun showContent() {
    }

    /**
     * 提示
     */
    override fun toastShow(msg: String?) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
    }

    /**
     * 设置标题
     * @param tab
     */
    override fun setTab(tab: MutableList<String>?) {
        id_main_tab.tabMode = TabLayout.MODE_FIXED
        if(tab == null) return
            for (tebStr  in tab)
                id_main_tab.addTab(id_main_tab.newTab().setText(tebStr))
    }

    /**
     * 设置页面
     * @param lists
     */
    override fun setPager(lists: MutableList<Fragment>?) {
        id_main_vp.adapter=MainAdapter(supportFragmentManager,lists)
    }

}
