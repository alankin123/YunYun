package com.alankin.yunyun.entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.alankin.yunyun.BR;

/**
 * Created by QYM on 2018/11/26.
 */

public class TestBean extends BaseObservable{
    private String name;
    private String book;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
        notifyPropertyChanged(BR.book);
    }
}
