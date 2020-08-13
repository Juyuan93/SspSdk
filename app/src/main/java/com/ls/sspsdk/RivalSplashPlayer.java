package com.ls.sspsdk;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.blast.rival.RivalUtils;
import com.blast.rival.content.NativeSplash;
import com.blast.rival.listener.SplashListener;

public class RivalSplashPlayer implements SplashListener {

    private Activity _activity;

    private NativeSplash   _splash;
    private RelativeLayout _container;

    public RivalSplashPlayer(Activity activity)
    {
        _activity = activity;
    }

    public void show(String code, RelativeLayout container)
    {
        _splash = new NativeSplash(code , this);
        _splash.load();

        _container = container;
    }

    @Override
    public void onLoad() {

    }

    @Override
    public void onRender(View view) {
        render(view);
    }


    private void render(View view)
    {
        Log.i(RivalUtils.SDK_TAG, "splash render..." + view.getWidth() + "," + view.getHeight() + "," + _container.getWidth() + "," + _container.getHeight());

        _container.addView(view);
    }


    public void onClick()
    {
        Log.i(RivalUtils.SDK_TAG, "splash clicked...");
    }

    public void onDownloadStart()
    {
        Log.i(RivalUtils.SDK_TAG, "splash onDownloadStart...");
    }


    public void onDownloadSuccess()
    {
        Log.i(RivalUtils.SDK_TAG, "splash onDownloadSuccess...");
    }


    public void onInstallStart()
    {
        Log.i(RivalUtils.SDK_TAG, "splash onInstallStart...");
    }

    public void onInstallSuccess()
    {
        Log.i(RivalUtils.SDK_TAG, "splash onInstallSuccess...");
    }

    public void onSkip()
    {
        Log.i(RivalUtils.SDK_TAG, "splash onSkip...");
    }

    public void onComplete()
    {
        Log.i(RivalUtils.SDK_TAG, "splash onComplete...");
    }

}
