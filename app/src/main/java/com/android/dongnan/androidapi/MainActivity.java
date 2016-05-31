package com.android.dongnan.androidapi;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends ListActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String path = intent.getStringExtra(MainConstant.FILTER_EXTRA);

        if(path == null) {
            path = this.getPackageName();
        } else {
            String defName = this.getPackageName();
            String title = path.substring(defName.length());
            ActionBar actionBar = getActionBar();
            actionBar.setTitle(title);
        }

        setListAdapter(new SimpleAdapter(this, getPathData(path), android.R.layout.simple_list_item_1, new String[] {"title"}, new int[]{android.R.id.text1}));
        getListView().setTextFilterEnabled(true);
    }

    private List<Map<String, Object>> getPathData(String path) {
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

        Intent mainIntent = new Intent(MainConstant.FILTER_ACTION, null);
        mainIntent.addCategory(MainConstant.FILTER_CATEGORY);

        PackageManager pm = getPackageManager();
        List<ResolveInfo> infos = pm.queryIntentActivities(mainIntent, 0);

        if(infos == null) {
            return data;
        }

        Map<String, Boolean> recorder = new HashMap<String, Boolean>();

        String[] defPath = path.split("\\.");
        for(ResolveInfo info : infos) {
            String name = info.activityInfo.name;
            if(!name.contains(path)) continue;
            String[] lablePath = name.split("\\.");

            Map<String, Object> temp = new HashMap<String, Object>();
            if(lablePath.length - defPath.length == 1) {
                Intent intent = new Intent();
                intent.setClassName(info.activityInfo.applicationInfo.packageName, info.activityInfo.name);
                temp.put("intent", intent);
            } else {
                Intent intent = new Intent();
                intent.setClass(this, MainActivity.class);
                intent.putExtra(MainConstant.FILTER_EXTRA, path + "." + lablePath[defPath.length]);
                temp.put("intent", intent);
            }

            String title = lablePath[defPath.length];
            title = title.substring(0, 1).toUpperCase() + title.substring(1);
            if(recorder.get(title) == null) {
                temp.put("title", title);
                recorder.put(title, true);
                data.add(temp);
            }
        }

        Collections.sort(data, sDisplayNameComparator);

        return data;
    }

    private final static Comparator<Map<String, Object>> sDisplayNameComparator =
            new Comparator<Map<String, Object>>() {
                private final Collator   collator = Collator.getInstance();

                public int compare(Map<String, Object> map1, Map<String, Object> map2) {
                    return collator.compare(map1.get("title"), map2.get("title"));
                }
            };

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        @SuppressWarnings("unchecked")
        Map<String, Object> map = (Map<String, Object>)l.getItemAtPosition(position);

        Log.v("dongnan", "list Click");
        Intent intent = new Intent((Intent) map.get("intent"));
        startActivity(intent);
        super.onListItemClick(l, v, position, id);
    }
}
