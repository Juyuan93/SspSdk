package com.ls.sspsdk;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.blast.rival.Rival;
import com.blast.rival.RivalUtils;
import com.blast.rival.content.NativeExpress;
import com.blast.rival.listener.ExpressListener;

public class RivalExpressPlayer implements ExpressListener {

    private Activity _activity;

    private NativeExpress _express;
    private ViewGroup     _container;

    public RivalExpressPlayer(Activity activity)
    {
        _activity = activity;
    }

    public void showExpress(String code, ViewGroup parent, int width, int height)
    {
        _container = parent;

        _express = new NativeExpress(code , this, width, height);
        _express.load();
    }


    public void onLoad()
    {
        _express.show();
    }

    public void onRender(View view, int width, int height)
    {
        _container.setVisibility(View.VISIBLE);


        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) Rival._activity.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);

        int sw = dm.widthPixels;
        int sh = dm.heightPixels;

        RivalUtils.showLog("on ExpressRender:"+ width + "," + height + ":" + sw + "," + sh);

        float y = sh / 2 - height/2;
        float x = sw / 2 - width/2;
        view.setY(y);
        view.setX(x);

        _container.addView(view);
    }


    public void onClick()
    {
        Log.i(RivalUtils.SDK_TAG, "ex onClick...");
    }

    public void onCloseClicked() {_container.removeAllViews(); _container.setVisibility(View.GONE);}


    public void onDownloadStart()
    {
        Log.i(RivalUtils.SDK_TAG, "video onDownloadStart...");
    }


    public void onDownloadSuccess()
    {
        Log.i(RivalUtils.SDK_TAG, "video onDownloadSuccess...");
    }

    public void onInstallStart()
    {
        Log.i(RivalUtils.SDK_TAG, "video onInstallStart...");
    }

    public void onInstallSuccess()
    {
        Log.i(RivalUtils.SDK_TAG, "video onInstallSuccess...");
    }

    public void onVideoLoad()
    {
        Log.i(RivalUtils.SDK_TAG, "video onVideoLoad...");
    }


    public void onStart()
    {
        Log.i(RivalUtils.SDK_TAG, "video onStart...");
    }

    public void onClose()
    {
        Log.i(RivalUtils.SDK_TAG, "video onClose...");
    }
}
