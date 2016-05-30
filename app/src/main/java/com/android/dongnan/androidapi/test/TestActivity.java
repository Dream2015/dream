package com.android.dongnan.androidapi.test;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by dream on 16/5/29.
 */
public class TestActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView view = new TextView(this);
        view.setText("Test 1");

        setContentView(view);
    }
}
