package com.liuguilin.smartviewpager;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * FileName: SmartPagerAdapter
 * Founder: LiuGuiLin
 * Create Date: 2019/7/31 13:31
 * Email: lgl@szokl.com.cn
 * Profile:
 */
public class SmartPagerAdapter extends PagerAdapter {

    private List<View> mList;

    public SmartPagerAdapter(List<View> mList) {
        this.mList = mList;
    }

    @Override
    public int getCount() {
        //mList.size()
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int i = position % mList.size();
        ((ViewPager) container).addView(mList.get(i));
        return mList.get(i);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        int i = position % mList.size();
        ((ViewPager) container).removeView(mList.get(i));
    }
}
