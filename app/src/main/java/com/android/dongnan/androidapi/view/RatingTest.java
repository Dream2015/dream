package com.android.dongnan.androidapi.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RatingBar;

import com.android.dongnan.androidapi.R;

/**
 * Created by dream on 16/6/4.
 */
public class RatingTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);

        RatingBar ratingBar = new RatingBar(this);
        ratingBar.setNumStars(5);
        ratingBar.setRating(2);

        layout.addView(ratingBar);

        setContentView(layout);
    }
}
