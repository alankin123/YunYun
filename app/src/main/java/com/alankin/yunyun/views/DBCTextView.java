package com.alankin.yunyun.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by QYM on 2018/11/13.
 */

public class DBCTextView extends TextView {
    public DBCTextView(Context context) {
        this(context, null);
    }

    public DBCTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DBCTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
//        super.setText(ToDBC(text.toString()), type);
        super.setText(text, type);
    }

    public String ToDBC(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                c[i] = (char) 32;
                continue;
            }
            if (c[i] > 65280 && c[i] < 65375)
                c[i] = (char) (c[i] - 65248);
        }
        return new String(c);
    }
}
