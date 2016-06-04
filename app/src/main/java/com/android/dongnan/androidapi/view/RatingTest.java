package com.android.dongnan.androidapi.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Toast;

/**
 * Created by dream on 16/6/4.
 */
public class RatingTest extends Activity implements RatingBar.OnRatingBarChangeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setGravity(Gravity.CENTER);
        layout.setOrientation(LinearLayout.VERTICAL);

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
