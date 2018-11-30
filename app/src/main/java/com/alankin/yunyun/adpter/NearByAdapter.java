package com.alankin.yunyun.adpter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alankin.yunyun.R;
import com.alankin.yunyun.entity.NewsBean;
import com.alankin.yunyun.views.RoundTextView;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by QYM on 2018/11/12.
 */

public class NearByAdapter extends RecyclerView.Adapter<NearByAdapter.NearByVH> {
    private Context context;
    int colorDefault;
    int colorPrimary;
    int colorSuccess;
    int colorInfo;
    int colorWarning;
    int colorDanger;
    int colorContentBg;

    public List<NewsBean> getDatas() {
        return datas;
    }

    public void setDatas(List<NewsBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    private List<NewsBean> datas;

    public NearByAdapter(Context context) {
        this(context, null);
    }

    public NearByAdapter(Context context, List<NewsBean> datas) {
        this.context = context;
        this.datas = datas;

        colorDefault = this.context.getResources().getColor(R.color.alert_default);
        colorPrimary = this.context.getResources().getColor(R.color.alert_primary);
        colorSuccess = this.context.getResources().getColor(R.color.alert_success);
        colorInfo = this.context.getResources().getColor(R.color.alert_info);
        colorWarning = this.context.getResources().getColor(R.color.alert_warning);
        colorDanger = this.context.getResources().getColor(R.color.alert_danger);
        colorContentBg = this.context.getResources().getColor(R.color.colorContentBg);
    }

    @Override
    public NearByVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_nearby, parent, false);
        return new NearByVH(itemView);
    }

    @Override
    public void onBindViewHolder(NearByVH holder, int position) {
        holder.tvTitle.setText("");
        holder.tvContent.setText("");
        holder.llLabelContainer.removeAllViews();

        NewsBean newsBean = datas.get(position);
        List<Integer> imgs = newsBean.getImgs();
        Glide.with(context).load(imgs.get(0)).centerCrop().into(holder.iv1);
        Glide.with(context).load(imgs.get(1)).centerCrop().into(holder.iv2);
        Glide.with(context).load(imgs.get(2)).centerCrop().into(holder.iv3);
        holder.tvTitle.setText(newsBean.getNewsTitle());
        holder.tvContent.setText(newsBean.getContent());

        List<NewsBean.Label> labels = newsBean.getLabels();
        for (NewsBean.Label label : labels) {
            RoundTextView roundTextView = new RoundTextView(context);
            roundTextView.setText(label.getName() + " " + label.getCount());
            roundTextView.setRtvBgColor(chooseColor(label.getCount()));
            roundTextView.setRtvRadius(100);
            roundTextView.setTextColor(colorContentBg);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 0, 16, 0);
            roundTextView.setLayoutParams(params);
            holder.llLabelContainer.addView(roundTextView);
        }
    }

    private int chooseColor(int count) {
        if (count > 0 && count < 50) {
            return colorDefault;
        } else if (count < 100) {
            return colorPrimary;
        } else if (count < 150) {
            return colorSuccess;
        } else if (count < 200) {
            return colorInfo;
        } else if (count < 250) {
            return colorWarning;
        }
        return colorDanger;
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public static class NearByVH extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.ll_label_container)
        LinearLayout llLabelContainer;
        @BindView(R.id.tv_content)
        TextView tvContent;
        @BindView(R.id.iv_loc_icon)
        ImageView ivLocIcon;
        @BindView(R.id.iv_1)
        ImageView iv1;
        @BindView(R.id.iv_2)
        ImageView iv2;
        @BindView(R.id.iv_3)
        ImageView iv3;

        public NearByVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
