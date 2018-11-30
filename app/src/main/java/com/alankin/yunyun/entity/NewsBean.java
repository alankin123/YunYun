package com.alankin.yunyun.entity;

import java.util.List;

/**
 * Created by QYM on 2018/11/13.
 */

public class NewsBean {
    private String newsTitle;
    private String content;
    private List<Integer> imgs;
    private List<Label> labels;

    public String getNewsTitle() {
        return newsTitle;
    }

    public NewsBean setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
        return this;
    }

    public String getContent() {
        return content;
    }

    public NewsBean setContent(String content) {
        this.content = content;
        return this;
    }

    public List<Integer> getImgs() {
        return imgs;
    }

    public NewsBean setImgs(List<Integer> imgs) {
        this.imgs = imgs;
        return this;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public NewsBean setLabels(List<Label> labels) {
        this.labels = labels;
        return this;
    }

    public static class Label {
        private int count;
        private String name;

        public Label() {
        }

        public int getCount() {
            return count;
        }

        public Label setCount(int count) {
            this.count = count;
            return this;
        }

        public String getName() {
            return name;
        }

        public Label setName(String name) {
            this.name = name;
            return this;
        }
    }
}
