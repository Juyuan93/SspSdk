package com.ls.sspsdk;

import android.app.Activity;
import android.util.Log;

import com.blast.rival.RivalUtils;
import com.blast.rival.content.RewardVideo;
import com.blast.rival.listener.RewardVideoListener;

public class RivalVideoPlayer implements RewardVideoListener {
    private Activity    _activity;
    private RewardVideo _rewardVideo;

    public RivalVideoPlayer(Activity activity)
    {
        _activity = activity;
    }

    public void load(String code)
    {
        _rewardVideo = new RewardVideo(code, this);
        _rewardVideo.load();
    }

    @Override
    public void onClick() {
        Log.i(RivalUtils.SDK_TAG, "video onClick...");
    }

    @Override
    public void onDownloadStart() {
        Log.i(RivalUtils.SDK_TAG, "video onDownloadStart...");
    }

    @Override
    public void onDownloadSuccess() {
        Log.i(RivalUtils.SDK_TAG, "video onDownloadSuccess...");
    }

    @Override
    public void onInstallStart() {
        Log.i(RivalUtils.SDK_TAG, "video onInstallStart...");
    }

    @Override
    public void onInstallSuccess() {
        Log.i(RivalUtils.SDK_TAG, "video onInstallSuccess...");
    }

    @Override
    public void onLoad(String info) {
        _rewardVideo.play();
    }

    @Override
    public void onVideoLoad() {
        Log.i(RivalUtils.SDK_TAG, "video onVideoLoad...");
    }

    @Override
    public void onStart() {
        Log.i(RivalUtils.SDK_TAG, "video onStart...");
    }

    @Override
    public void onComplete() {
        Log.i(RivalUtils.SDK_TAG, "video onComplete...");
    }

    @Override
    public void onClose() {
        Log.i(RivalUtils.SDK_TAG, "video onClose...");
    }
}
