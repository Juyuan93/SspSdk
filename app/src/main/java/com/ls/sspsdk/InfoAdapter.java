package com.ls.sspsdk;

import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.List;

/**
 * Author ：juyuan
 * Date ：  2020/7/27
 * Description ：
 */

public class InfoAdapter extends BaseQuickAdapter<DataBean, BaseViewHolder> {


    public InfoAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final DataBean dataBean) {
        holder.setText(R.id.tv_name, dataBean.getTitle());
        holder.setText(R.id.tv_id, dataBean.getId() );

    }
}
