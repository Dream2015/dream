package com.android.dongnan.androidapi.view;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.android.dongnan.androidapi.R;

/**
 * Created by dream on 16/6/19.
 */
public class SettingTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new TestFragment())
                .commit();
    }

    public static class TestFragment extends PreferenceFragment {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }
    }
}

