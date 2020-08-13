package com.ls.sspsdk;

import android.app.Activity;
import android.util.Log;

import com.blast.rival.RivalUtils;
import com.blast.rival.content.NativeIntersTitial;
import com.blast.rival.listener.InterstitialListener;


public class RivalInterstitialPlayer implements InterstitialListener {
    private Activity           _activity;
    private NativeIntersTitial _interstitial;

    public RivalInterstitialPlayer(Activity activity)
    {
        _activity = activity;
    }

    public void load(String code, int scaleType)
    {
        _interstitial = new NativeIntersTitial(code, this, scaleType);
        _interstitial.load();
    }

    public void onLoad()
    {
        _interstitial.show();
    }

    public void show()
    {

    }


    public void onClick()
    {
        Log.i(RivalUtils.SDK_TAG, "interstitial onClick...");
    }


    public void onDownloadStart()
    {
        Log.i(RivalUtils.SDK_TAG, "interstitial onDownloadStart...");
    }


    public void onDownloadSuccess()
    {
        Log.i(RivalUtils.SDK_TAG, "interstitial onDownloadSuccess...");
    }

    public void onInstallStart()
    {
        Log.i(RivalUtils.SDK_TAG, "interstitial onInstallStart...");
    }

    public void onInstallSuccess()
    {
        Log.i(RivalUtils.SDK_TAG, "interstitial onInstallSuccess...");
    }

    public void onClose()
    {
        Log.i(RivalUtils.SDK_TAG, "interstitial onClose...");
    }
}
