package com.ls.sspsdk;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.blast.rival.Rival;
import com.blast.rival.RivalUtils;
import com.blast.rival.content.NativeBanner;
import com.blast.rival.listener.BannerListener;

public class RivalBannerPlayer implements BannerListener {

    private Activity _activity;

    private NativeBanner   _banner;
    private RelativeLayout _container;

    public RivalBannerPlayer(Activity activity)
    {
        _activity = activity;
    }

    public void showBanner(String code, RelativeLayout container, String sizeType)
    {
        _banner = new NativeBanner(code , this, 600, 300);
        _banner.setSizeType(sizeType);
        _banner.load();
        _container = container;
    }

    @Override
    public void onLoad() {

    }

    @Override
    public void onRender(View view, int width, int height) {
        bannerRender(view, width, height);
    }


    private void bannerRender(View view, int width, int height)
    {
        Log.i(RivalUtils.SDK_TAG, "banner render..." + width + "," + height + "," + _container.getWidth() + "," + _container.getHeight());

        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) Rival._activity.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        float density = dm.density;

        float y = _container.getHeight() -height;
        view.setY(y);
        _container.addView(view);
    }


    public void onClick()
    {
        Log.i(RivalUtils.SDK_TAG, "banner clicked...");
    }

    public void onDownloadStart()
    {
        Log.i(RivalUtils.SDK_TAG, "banner onDownloadStart...");
    }


    public void onDownloadSuccess()
    {
        Log.i(RivalUtils.SDK_TAG, "banner onDownloadSuccess...");
    }


    public void onInstallStart()
    {
        Log.i(RivalUtils.SDK_TAG, "banner onInstallStart...");
    }


    public void onInstallSuccess()
    {
        Log.i(RivalUtils.SDK_TAG, "banner onInstallSuccess...");
    }

}
