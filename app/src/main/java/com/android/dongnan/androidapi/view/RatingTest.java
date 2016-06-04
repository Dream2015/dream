package com.android.dongnan.androidapi.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Toast;

import com.android.dongnan.androidapi.R;

/**
 * Created by dream on 16/6/4.
 */
public class RatingTest extends Activity implements View.OnClickListener, RatingBar.OnRatingBarChangeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);

        RatingBar ratingBar = new RatingBar(this);
        ratingBar.setNumStars(5);
        ratingBar.setRating(2);
        ratingBar.setOnRatingBarChangeListener(this);
        ratingBar.setOnClickListener(this);

        layout.addView(ratingBar);
        setContentView(layout);
    }

    @Override
    public void onClick(View v) {
        if(v instanceof RatingBar) {
            RatingBar bar = (RatingBar)v;
            Toast.makeText(this,
                    "Value is:" + bar.getRating() + bar.getNumStars(),
                    Toast.LENGTH_LONG)
                    .show();
        }
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        Toast.makeText(this, "rating is:" + rating + ", fromUser=" + fromUser, Toast.LENGTH_LONG)
                .show();
    }
}
