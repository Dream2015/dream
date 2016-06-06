package com.android.dongnan.androidapi.tab;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
        mViewPager.setAdapter(new SimplePagerAdapter());
    }

    private class SimplePagerAdapter extends PagerAdapter {

        public SimplePagerAdapter() {
        }

        public void setData() {

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

    private class ViewHolder {
        private int id;
        private TextView tabView;
        private LinearLayout pagerView;

        public int getId() {
            return id;
        }

        public TextView getTabView() {
            return tabView;
        }

        public LinearLayout getPagerView() {
            return pagerView;
        }

        public class Builder {
            public Builder(){
            }

            public Builder setId(int id) {
                ViewHolder.this.id = id;
                return this;
            }

            public Builder setTabView(TextView view) {
                ViewHolder.this.tabView = view;
                return this;
            }

            public Builder setPagerView(LinearLayout layout) {
                ViewHolder.this.pagerView = layout;
                return this;
            }

        }
    }
}
