package com.android.dongnan.androidapi.tab;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dream on 16/6/5.
 */
public class TabPageActivity extends Activity {

    private static final String TAG = TabPageActivity.class.getSimpleName();

    private LinearLayout mScrollView;
    private ViewPager mViewPager;

    private ArrayList<ViewHolder> mViewHolders = new ArrayList<>();
    private SimplePagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        HorizontalScrollView scrollView = new HorizontalScrollView(this);
        mScrollView = new LinearLayout(this);
        mScrollView.setOrientation(LinearLayout.HORIZONTAL);


        mViewPager = new ViewPager(this);

        mViewHolders = makeContentViews();
        mPagerAdapter = new SimplePagerAdapter(mViewHolders);

        mViewPager.setAdapter(mPagerAdapter);

        scrollView.addView(mScrollView);
        linearLayout.addView(scrollView);
        linearLayout.addView(mViewPager);

        setContentView(linearLayout);

    }

    private ArrayList<ViewHolder> makeContentViews() {
        ArrayList<ViewHolder> holders = new ArrayList<>();

        for (int i=0; i<10; i++) {
            TextView view = new TextView(this);
            view.setText("Tab-" + i);
            mScrollView.addView(view);

            LinearLayout layout = new LinearLayout(this);
            layout.setOrientation(LinearLayout.VERTICAL);
            TextView content = new TextView(this);
            content.setText("Content-" + i);
            layout.addView(content);

            ViewHolder holder = new ViewHolder().setId(i)
                    .setTabView(view).setPagerView(layout);
            holders.add(holder);
        }
        return holders;

    }

    private class SimplePagerAdapter extends PagerAdapter {

        private ArrayList<ViewHolder> mHolders;

        public SimplePagerAdapter(ArrayList<ViewHolder> holders) {
            mHolders = holders;
        }

        public void updateData(ArrayList<ViewHolder> holders) {
            mHolders = holders;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return mHolders.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return mHolders.get(position).getPagerView();
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

        public ViewHolder setId(int i) {
            this.id = i;
            return this;
        }

        public ViewHolder setTabView(TextView view) {
            this.tabView = view;
            return this;
        }

        public ViewHolder setPagerView(LinearLayout layout) {
            this.pagerView = layout;
            return this;
        }

    }
}
