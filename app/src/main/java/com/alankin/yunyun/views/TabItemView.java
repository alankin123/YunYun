package com.alankin.yunyun.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alankin.yunyun.R;

/**
 * Created by QYM on 2018/11/9.
 */

public class TabItemView extends RelativeLayout {
    View container;
    ImageView iv_icon;
    TextView tv_title;

    public TabItemView(Context context) {
        this(context, null);
    }

    public TabItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TabItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        container = LayoutInflater.from(context).inflate(R.layout.tabitem, this);
        iv_icon = container.findViewById(R.id.iv_icon);
        tv_title = container.findViewById(R.id.tv_title);
    }

    public TabItemView setDrawerble(@DrawableRes int res) {
        iv_icon.setImageDrawable(getResources().getDrawable(res));
        return this;
    }

    public TabItemView setText(String text) {
        tv_title.setText(text);
        return this;
    }

    public TabItemView setTextColor(ColorStateList textColor) {
        tv_title.setTextColor(textColor);
        return this;
    }

    public TabItemView setTextColor(@ColorInt int textColor) {
        tv_title.setTextColor(textColor);
        return this;
    }
}
