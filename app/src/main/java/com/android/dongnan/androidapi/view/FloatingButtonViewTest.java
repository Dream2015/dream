package com.android.dongnan.androidapi.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Outline;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.dongnan.androidapi.R;

/**
 * Created by dream on 16/6/3.
 */
public class FloatingButtonViewTest extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView view = new TextView(this);
        view.setText("Good Luck");



        setContentView(R.layout.floating_action_button);

    }
}
