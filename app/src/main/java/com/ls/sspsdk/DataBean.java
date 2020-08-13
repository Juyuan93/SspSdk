package com.ls.sspsdk;

import java.util.ArrayList;
import java.util.List;

/**
 * Author ：juyuan
 * Date ：  2020/7/27
 * Description ：
 */

public class DataBean {

    private String packageName;
    private String appName;
    private String appId;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public DataBean(String packageName, String appName, String appId) {
        this.packageName = packageName;
        this.appName = appName;
        this.appId = appId;
    }

    public String title;
    public String id;

    public DataBean(String title, String id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static DataBean getAppData() {
        DataBean mdata = new DataBean("com.leshu.superbrain", "脑力王者", "518705");
        return mdata;
    }

    public static List<DataBean> getData() {
        List<DataBean> list = new ArrayList<>();
        list.add(new DataBean("流三图并列", "519025"));
        list.add(new DataBean("流左文右图", "519024"));
        list.add(new DataBean("流左图右文", "519023"));
        list.add(new DataBean("流文字浮层", "519022"));
        list.add(new DataBean("流上文浮层", "519021"));
        list.add(new DataBean("流上文附加", "519020"));
        list.add(new DataBean("流上文下图", "519019"));

        list.add(new DataBean("插屏2:3", "519018"));
        list.add(new DataBean("插屏1:1", "519017"));
        list.add(new DataBean("插屏3:2", "519016"));
        list.add(new DataBean("开屏", "519015"));

        list.add(new DataBean("banner600x100轮播", "519014"));
        list.add(new DataBean("banner600x100", "519013"));
        list.add(new DataBean("banner600x150轮播", "519012"));
        list.add(new DataBean("banner600x150", "519011"));
        list.add(new DataBean("banner600x90轮播", "519010"));
        list.add(new DataBean("banner600x90", "519009"));

        list.add(new DataBean("激励视频竖屏", "519008"));

        return list;
    }

}