package com.liuguilin.smartviewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tv_index;
    private ViewPager mViewPager;
    private List<View> mList = new ArrayList<>();
    private SmartPagerAdapter mSmartPagerAdapter;

    private int[] mDrawable = {R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initData() {
        for (int i = 0; i < mDrawable.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundColor(getResources().
                    getColor(R.color.colorPrimaryDark));
            imageView.setImageResource(mDrawable[i]);
            mList.add(imageView);
        }
    }

    private void initView() {
        tv_index = (TextView) findViewById(R.id.tv_index);
        mViewPager = (ViewPager) findViewById(R.id.mViewPager);
        mSmartPagerAdapter = new SmartPagerAdapter(mList);
        mViewPager.setAdapter(mSmartPagerAdapter);

        mViewPager.setCurrentItem(Integer.MAX_VALUE / 2 - (Integer.MAX_VALUE / 2 % mList.size()));

        tv_index.setText("1 / " + mList.size());

        mViewPager.addOnPageChangeListener(
                new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                int position = i % mList.size();
                tv_index.setText((position + 1) + " / " + mList.size());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
