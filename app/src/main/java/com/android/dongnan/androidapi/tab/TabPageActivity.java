package com.android.dongnan.androidapi.tab;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

/**
 * Created by dream on 16/6/5.
 */
public class TabPageActivity extends Activity {

    private static final String TAG = TabPageActivity.class.getSimpleName();

    private HorizontalScrollView mScrollView;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        mScrollView = new HorizontalScrollView(this);
        mViewPager = new ViewPager(this);
    }

    private class SimplePagerAdapter extends PagerAdapter {

        public SimplePagerAdapter() {
        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return false;
        }


    }
}
