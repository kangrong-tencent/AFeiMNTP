package com.mntp.ui.main.page.browse;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.afeimntp.R;
import com.mntp.ui.base.BaseActivity;

import java.util.List;

import butterknife.BindView;

import static com.mntp.utils.IntentUtils.INTENT_KEY;

/**
 * 首页
 */
public class BrowseActivity extends BaseActivity<BrowsePresenter>
        implements BrowseContract.View {

    @BindView(R.id.id_return_img)
    ImageView returnImg;
    @BindView(R.id.id_browse_vp)
    ViewPager browseVp;
    BrowseAdapter browseAdapter;

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
        return R.layout.activity_browse;
    }

    /**
     * 初始化，代替onCreate
     */
    @Override
    protected void initData() {
        String infoImg = getIntent().getStringExtra(INTENT_KEY);
        if (TextUtils.isEmpty(infoImg)) {
            finish();
            return;
        }
        mPresenter.setUrl(infoImg);
        mPresenter.loadPager();
        returnImg.setOnClickListener(v -> finish());
    }


    /**
     * 设置页面
     *
     * @param lists
     */
    @Override
    public void setPager(List<Fragment> lists) {
        browseAdapter = new BrowseAdapter(getSupportFragmentManager(), lists);
        browseVp.setAdapter(browseAdapter);
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
