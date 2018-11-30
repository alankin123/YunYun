package com.alankin.yunyun.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;

import com.alankin.yunyun.R;

/**
 * Created by QYM on 2018/11/13.
 */

public class RoundTextView extends android.support.v7.widget.AppCompatTextView {

    private float rtvRadius;
    private int offset;
    private int rtvBorderWidth;
    private int rtvBorderColor;
    private int rtvBgColor;
    GradientDrawable gd;

    public RoundTextView(Context context) {
        this(context, null);
    }

    public RoundTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        gd = new GradientDrawable();//创建drawable
        TypedArray attributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.RoundTextView, defStyleAttr, 0);
        if (attributes != null) {
            rtvBorderWidth = attributes.getDimensionPixelSize(R.styleable.RoundTextView_rtvBorderWidth, 0);
            rtvBorderColor = attributes.getColor(R.styleable.RoundTextView_rtvBorderColor, Color.BLACK);
            rtvRadius = attributes.getDimension(R.styleable.RoundTextView_rtvRadius, 0);
            rtvBgColor = attributes.getColor(R.styleable.RoundTextView_rtvBgColor, Color.WHITE);
            attributes.recycle();
        }
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
    }

    public int getRtvBorderWidth() {
        return rtvBorderWidth;
    }

    public void setRtvBorderWidth(int rtvBorderWidth) {
        this.rtvBorderWidth = rtvBorderWidth;
    }

    public int getRtvBorderColor() {
        return rtvBorderColor;
    }

    public void setRtvBorderColor(int rtvBorderColor) {
        this.rtvBorderColor = rtvBorderColor;
    }

    public int getRtvBgColor() {
        return rtvBgColor;
    }

    public void setRtvBgColor(int rtvBgColor) {
        this.rtvBgColor = rtvBgColor;
    }

    public float getRtvRadius() {
        return rtvRadius;
    }

    public void setRtvRadius(float rtvRadius) {
        this.rtvRadius = rtvRadius;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        offset = (int) Math.min(height / 2, rtvRadius);
        setMeasuredDimension(width + offset, height);
        setPadding(getPaddingLeft() + offset / 2, getPaddingTop(), getPaddingRight() + offset / 2, getPaddingBottom());

        gd.setColor(rtvBgColor);
        gd.setCornerRadius(rtvRadius);
        if (rtvBorderWidth > 0) {
            gd.setStroke(rtvBorderWidth, rtvBorderColor);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.setBackgroundDrawable(gd);
    }

    public void setBackgroungColor(@ColorInt int color) {
        GradientDrawable myGrad = (GradientDrawable) getBackground();
        myGrad.setColor(color);
    }
}
