package com.android.dongnan.androidapi.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Toast;

import com.android.dongnan.androidapi.common.Logger;

/**
 * Created by dream on 16/6/4.
 */
public class RatingTest extends Activity implements RatingBar.OnRatingBarChangeListener{
    private static final String TAG = RatingTest.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Logger.v(TAG, "onCreate");

        LinearLayout layout = new LinearLayout(this);
//        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);

        RatingBar ratingBar = new RatingBar(this);
        ratingBar.setNumStars(5);
        ratingBar.setRating(2);
        ratingBar.setOnRatingBarChangeListener(this);

        layout.addView(ratingBar);
        setContentView(layout);
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        Toast.makeText(this, "rating is:" + rating + ", fromUser=" + fromUser, Toast.LENGTH_LONG)
                .show();
    }
}
