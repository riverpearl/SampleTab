package com.tacademy.sampletab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TabHost tabHost;

    public final static String TAB_ONE = "tab1";
    public final static String TAB_TWO = "tab2";
    public final static String TAB_THREE = "tab3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabHost = (TabHost)findViewById(R.id.tabHost);
        tabHost.setup();

        TextView tabSpec = (TextView)getLayoutInflater().inflate(R.layout.tab_spec, tabHost.getTabWidget(), false);
        tabSpec.setText("TAB1");
        tabHost.addTab(tabHost.newTabSpec(TAB_ONE).setIndicator(tabSpec).setContent(R.id.tab1));

        tabSpec = (TextView)getLayoutInflater().inflate(R.layout.tab_spec, tabHost.getTabWidget(), false);
        tabSpec.setText("TAB2");
        tabHost.addTab(tabHost.newTabSpec(TAB_TWO).setIndicator(tabSpec).setContent(R.id.tab2));

        tabSpec = (TextView)getLayoutInflater().inflate(R.layout.tab_spec, tabHost.getTabWidget(), false);
        tabSpec.setText("TAB3");
        tabHost.addTab(tabHost.newTabSpec(TAB_THREE).setIndicator(tabSpec).setContent(R.id.tab3));

        tabHost.setCurrentTabByTag(TAB_TWO);
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                if (TAB_ONE.equals(s))
                    Toast.makeText(MainActivity.this, "TAB_ONE", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
