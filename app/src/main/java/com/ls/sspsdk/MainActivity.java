package com.ls.sspsdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blast.rival.Rival;
import com.blast.rival.RivalUtils;
import com.blast.rival.content.NativeBanner;
import com.blast.rival.content.NativeIntersTitial;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_packagename)
    EditText     etPackagename;
    @BindView(R.id.et_appname)
    EditText     etAppname;
    @BindView(R.id.et_appid)
    EditText     etAppid;
    @BindView(R.id.rv_balance)
    RecyclerView mRecyclerView;

    String packageName;
    String appName;
    String appId;

    private InfoAdapter    mAdapter;
    private RelativeLayout _bannerContainer;

    private RelativeLayout _expressContainer;

    private RivalBannerPlayer       _bannerPlayer;
    private RivalVideoPlayer        _videoPlayer;
    private RivalSplashPlayer       _splashPlayer;
    private RivalInterstitialPlayer _intersPlayer;
    private RivalExpressPlayer      _expressPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);// 设置默认键盘不弹出
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initRivalSdk();

        packageName = DataBean.getAppData().getPackageName();
        appName = DataBean.getAppData().getAppName();
        appId = DataBean.getAppData().getAppId();
        etPackagename.setText(packageName);
        etAppname.setText(appName);
        etAppid.setText(appId);

        _bannerPlayer = new RivalBannerPlayer(this);
        _videoPlayer = new RivalVideoPlayer(this);
        _splashPlayer = new RivalSplashPlayer(this);
        _intersPlayer = new RivalInterstitialPlayer(this);
        _expressPlayer = new RivalExpressPlayer(this);

        initBannerContainer();
        initExpressContainer();

        mAdapter = new InfoAdapter(R.layout.activity_main_item, DataBean.getData());
        mRecyclerView.setPadding(0, 0, 0, 0);
        mRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2, RecyclerView.VERTICAL, false));
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                Log.i(RivalUtils.SDK_TAG, "onClick...");
                Rival.APP_PKGNAME = packageName;
                Rival.APP_NAME = appName;
                Rival.APP_ID = appId;

                switch (DataBean.getData().get(position).getTitle()) {
                    case "流三图并列":
                    case "流左文右图":
                    case "流左图右文":
                        setExpress(DataBean.getData().get(position).getId(), _expressContainer, 350, 0);
                        break;

                    case "流文字浮层":
                    case "流上文浮层":
                    case "流上文附加":
                    case "流上文下图":
                        setExpress(DataBean.getData().get(position).getId(), _expressContainer, 300, 0);
                        break;


                    case "插屏2:3":
                        setInters(DataBean.getData().get(position).getId(), NativeIntersTitial.PORTRAIT);
                        break;
                    case "插屏1:1":
                        setInters(DataBean.getData().get(position).getId(), NativeIntersTitial.SQUARE);
                        break;
                    case "插屏3:2":
                        setInters(DataBean.getData().get(position).getId(), NativeIntersTitial.LANDSCAPE);
                        break;


                    case "开屏":
                        _bannerContainer.removeAllViews();
                        _splashPlayer.show(DataBean.getData().get(position).getId(), _bannerContainer);
                        break;


                    case "banner600x100轮播":
                    case "banner600x100":
                        setBanner(DataBean.getData().get(position).getId(), NativeBanner.BANNER_640_100);
                        break;
                    case "banner600x150轮播":
                    case "banner600x150":
                        setBanner(DataBean.getData().get(position).getId(), NativeBanner.BANNER_600_150);
                        break;
                    case "banner600x90轮播":
                    case "banner600x90":
                        setBanner(DataBean.getData().get(position).getId(), NativeBanner.BANNER_600_90);
                        break;


                    case "激励视频竖屏":
                        _videoPlayer.load(DataBean.getData().get(position).getId());
                        break;


                }
            }
        });
    }

    private void setExpress(String id, RelativeLayout expressContainer, int width, int height) {
        _expressPlayer.showExpress(id, expressContainer, width, height);
    }

    private void setInters(String id, int portrait) {
        _intersPlayer.load(id, portrait);
    }

    private void setBanner(String id, String size) {
        _bannerContainer.removeAllViews();
        _bannerPlayer.showBanner(id, _bannerContainer, size);
    }

    private void initRivalSdk() {
        Rival.init(this, appId, packageName, appName);
    }

    private void initBannerContainer() {
        RelativeLayout.LayoutParams frameLayout = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );//设置帧布局的高宽属性

        _bannerContainer = new RelativeLayout(getApplicationContext());
        LayoutInflater.from(getBaseContext()).inflate(R.layout.activity_banner, _bannerContainer, true);
        addContentView(_bannerContainer, frameLayout);
    }

    private void initExpressContainer() {
        RelativeLayout.LayoutParams frameLayout = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );//设置帧布局的高宽属性

        _expressContainer = new RelativeLayout(getApplicationContext());
        LayoutInflater.from(getBaseContext()).inflate(R.layout.activity_express, _bannerContainer, true);
        addContentView(_expressContainer, frameLayout);

        _expressContainer.setVisibility(View.GONE);
    }


}
