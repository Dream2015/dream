package com.android.dongnan.androidapi;

import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
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

public class MainActivity extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String path = intent.getStringExtra(MainConstant.FILTER_EXTRA);

        if (path == null) {
            path = "";
        }

        setListAdapter(new SimpleAdapter(this, getData(path),
                android.R.layout.simple_list_item_1, new String[] { "title" },
                new int[] { android.R.id.text1 }));
        getListView().setTextFilterEnabled(true);
    }

    protected List<Map<String, Object>> getData(String path) {
        List<Map<String, Object>> myData = new ArrayList<Map<String, Object>>();

        Intent mainIntent = new Intent(MainConstant.FILTER_ACTION, null);
        mainIntent.addCategory(Intent.CATEGORY_DEFAULT);

        PackageManager pm = getPackageManager();
        List<ResolveInfo> infos = pm.queryIntentActivities(mainIntent, 0);

        if (null == list)
            return myData;

        Map<String, Boolean> entries = new HashMap<String, Boolean>();

        String[] defPath = path.split("\\.");
        for(ResolveInfo info : infos) {
            String name = info.activityInfo.name;
            if(!name.contains(path)) {
                continue;
            }

            String[] lablePath = name.split("\\.");

            Map<String, Object> temp = new HashMap<>();
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

            String  title = lablePath[defPath.length];
            title = title.substring(0, 1).toUpperCase() + title.substring(1);

            if(entries.get(title) == null) {
                temp.put("title", title);
                entries.put(title, true);
                myData.add(temp);
            }


        }
        Collections.sort(myData, sDisplayNameComparator);

        return myData;
    }

    private final static Comparator<Map<String, Object>> sDisplayNameComparator =
            new Comparator<Map<String, Object>>() {
                private final Collator collator = Collator.getInstance();

                public int compare(Map<String, Object> map1, Map<String, Object> map2) {
                    return collator.compare(map1.get("title"), map2.get("title"));
                }
            };

    protected Intent activityIntent(String pkg, String componentName) {
        Intent result = new Intent();
        result.setClassName(pkg, componentName);
        return result;
    }

    protected Intent browseIntent(String path) {
        Intent result = new Intent();
        result.setClass(this, MainActivity.class);
        result.putExtra(MainConstant.FILTER_EXTRA, path);
        return result;
    }

    protected void addItem(List<Map<String, Object>> data, String name, Intent intent) {
        Map<String, Object> temp = new HashMap<String, Object>();
        temp.put("title", name);
        temp.put("intent", intent);
        data.add(temp);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Map<String, Object> map = (Map<String, Object>)l.getItemAtPosition(position);

        Intent intent = new Intent((Intent) map.get("intent"));
        intent.addCategory(Intent.CATEGORY_SAMPLE_CODE);
        startActivity(intent);
    }
}
