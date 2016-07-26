package com.tacademy.sampletab;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.Toast;

public class FragmentTabActivity extends AppCompatActivity {

    //MainActivity처럼 했을 경우 event를 받아 값을 주고받을 때 문제가 생김.

    FragmentTabHost tabHost;

    public final static String TAB_ONE = "tab1";
    public final static String TAB_TWO = "tab2";
    public final static String TAB_THREE = "tab3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_tab);

        tabHost = (FragmentTabHost)findViewById(R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        tabHost.addTab(tabHost.newTabSpec(TAB_ONE).setIndicator("TAB1"), OneFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec(TAB_TWO).setIndicator("TAB2"), TwoFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec(TAB_THREE).setIndicator("TAB3"), TwoFragment.class, null);

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                if (TAB_TWO.equals(s))
                    Toast.makeText(FragmentTabActivity.this, "TAB_TWO", Toast.LENGTH_SHORT).show();
            }
        });

        tabHost.setCurrentTabByTag(TAB_TWO);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_fragment_tab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menu_am1) {
            Toast.makeText(this, "AM1 click", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
