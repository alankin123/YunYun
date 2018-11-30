package com.alankin.yunyun.fragments.subfrags;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alankin.yunyun.R;
import com.alankin.yunyun.adpter.NearByAdapter;
import com.alankin.yunyun.decorations.NearByDecoration;
import com.alankin.yunyun.entity.NewsBean;
import com.alankin.yunyun.fragments.ModuleFragment;
import com.alankin.yunyun.util.StatusBarUtil1;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends ModuleFragment {
    @BindColor(R.color.colorPrimary)
    int colorPrimary;
    @BindView(R.id.rv_content_list)
    RecyclerView rvContentList;

    NearByAdapter nearByAdapter;

    public RecommendFragment() {
        // Required empty public constructor
    }

    @Override
    public String getModuleName() {
        return "推荐";
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void init() {
        StatusBarUtil1.setStatusBarColor(getActivity(), colorPrimary);
        List<NewsBean> datas = getDatas();
        nearByAdapter = new NearByAdapter(getContext(), datas);
        rvContentList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvContentList.setAdapter(nearByAdapter);
        rvContentList.addItemDecoration(new NearByDecoration());
    }

    @BindString(R.string.test_item_content1)
    String content1;
    @BindString(R.string.test_item_content2)
    String content2;
    @BindString(R.string.test_item_content3)
    String content3;
    @BindString(R.string.test_item_content4)
    String content4;
    @BindString(R.string.test_item_title1)
    String itemTitle1;
    @BindString(R.string.test_item_title2)
    String itemTitle2;
    @BindString(R.string.test_item_title3)
    String itemTitle3;
    @BindString(R.string.test_item_title4)
    String itemTitle4;

    private List<NewsBean> getDatas() {
        List<NewsBean> ret = new ArrayList<>();
        NewsBean newsBean1 = new NewsBean().setNewsTitle(itemTitle1).setContent(content1).setLabels(getLabels1()).setImgs(getImgs1());
        NewsBean newsBean2 = new NewsBean().setNewsTitle(itemTitle2).setContent(content2).setLabels(getLabels2()).setImgs(getImgs2());
        NewsBean newsBean3 = new NewsBean().setNewsTitle(itemTitle3).setContent(content3).setLabels(getLabels3()).setImgs(getImgs3());
        NewsBean newsBean4 = new NewsBean().setNewsTitle(itemTitle4).setContent(content4).setLabels(getLabels4()).setImgs(getImgs4());
        ret.add(newsBean1);
        ret.add(newsBean2);
        ret.add(newsBean3);
        ret.add(newsBean4);
        return ret;
    }

    private List<Integer> getImgs1() {
        List<Integer> ret = new ArrayList<>();
        ret.add(R.drawable.jellyfish);
        ret.add(R.drawable.jellyfish);
        ret.add(R.drawable.tulips);
        return ret;
    }

    private List<Integer> getImgs2() {
        List<Integer> ret = new ArrayList<>();
        ret.add(R.drawable.hydrangeas);
        ret.add(R.drawable.jellyfish);
        ret.add(R.drawable.koala);
        return ret;
    }

    private List<Integer> getImgs3() {
        List<Integer> ret = new ArrayList<>();
        ret.add(R.drawable.tulips);
        ret.add(R.drawable.chrysanthemum);
        ret.add(R.drawable.jellyfish);
        return ret;
    }

    private List<Integer> getImgs4() {
        List<Integer> ret = new ArrayList<>();

        ret.add(R.drawable.koala);
        ret.add(R.drawable.jellyfish);
        ret.add(R.drawable.hydrangeas);
        return ret;
    }

    private List<NewsBean.Label> getLabels1() {
        List<NewsBean.Label> ret = new ArrayList<>();
        ret.add(new NewsBean.Label().setCount(111).setName("标签"));
        ret.add(new NewsBean.Label().setCount(111).setName("标签"));
        ret.add(new NewsBean.Label().setCount(111).setName("标签"));
        ret.add(new NewsBean.Label().setCount(222).setName("标签"));
        ret.add(new NewsBean.Label().setCount(165).setName("标签"));
        return ret;
    }

    private List<NewsBean.Label> getLabels2() {
        List<NewsBean.Label> ret = new ArrayList<>();
        ret.add(new NewsBean.Label().setCount(333).setName("标签"));
        ret.add(new NewsBean.Label().setCount(134).setName("标签"));
        ret.add(new NewsBean.Label().setCount(134).setName("标签"));
        ret.add(new NewsBean.Label().setCount(3).setName("标签"));
        return ret;
    }

    private List<NewsBean.Label> getLabels3() {
        List<NewsBean.Label> ret = new ArrayList<>();
        ret.add(new NewsBean.Label().setCount(4).setName("标签"));
        ret.add(new NewsBean.Label().setCount(7).setName("标签"));
        ret.add(new NewsBean.Label().setCount(66).setName("标签"));
        return ret;
    }

    private List<NewsBean.Label> getLabels4() {
        List<NewsBean.Label> ret = new ArrayList<>();
        ret.add(new NewsBean.Label().setCount(66).setName("标签"));
        ret.add(new NewsBean.Label().setCount(66).setName("标签"));
        ret.add(new NewsBean.Label().setCount(88).setName("标签"));
        ret.add(new NewsBean.Label().setCount(888).setName("标签"));
        return ret;
    }
}
