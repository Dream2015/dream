package com.android.dongnan.androidapi.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by dream on 16/6/3.
 */
public class FloatingButtonViewTest extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FloatingButton button = new FloatingButton(this);
        setContentView(button);

    }

    private class FloatingButton extends FrameLayout {

        public FloatingButton(Context context) {
            this(context, null);
        }

        public FloatingButton(Context context, AttributeSet attrs) {
            this(context, attrs, 0);
        }

        public FloatingButton(Context context, AttributeSet attrs, int defStyleAttr) {
            this(context, attrs, defStyleAttr, 0);
        }

        public FloatingButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr);
        }
    }
}
