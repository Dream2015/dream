package com.android.dongnan.androidapi.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;


/**
 * Created by dream on 16/6/2.
 */
public class TextSwitcherTest extends Activity {

    private TextSwitcher mSwitcher;
    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);

        Button button = new Button(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        button.setText("Next");
        layout.addView(button);

        mSwitcher = new TextSwitcher(this);
        mSwitcher.setFactory(mViewFactory);
        mSwitcher.setText(String.valueOf(mCount));
        layout.addView(mSwitcher);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mCount++;
                mSwitcher.setText(String.valueOf(mCount));
            }
        });

        setContentView(layout);
    }

    ViewSwitcher.ViewFactory mViewFactory = new ViewSwitcher.ViewFactory() {
        @Override
        public View makeView() {
            TextView view = new TextView(TextSwitcherTest.this);
            view.setGravity(Gravity.CENTER);
            return view;
        }
    };
}
