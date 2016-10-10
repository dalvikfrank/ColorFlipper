package com.meizu.power.colorflipper;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ColorFlipper extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "ColorFlipper";
    private int mUiMode = Configuration.UI_MODE_NIGHT_UNDEFINED;
    private NightModeHelper mHelper = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_flipper);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initHelper();
        initViews();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initHelper() {
        if (null == mHelper) {
            mHelper = new NightModeHelper(this, Configuration.UI_MODE_NIGHT_NO);
        }
    }

    private void initViews() {
        Button bt1 = (Button) findViewById(R.id.button1);
        bt1.setOnClickListener(this);

        Button bt2 = (Button) findViewById(R.id.button2);
//        bt2.setBackground(getResources().getDrawable(R.drawable.red, null));
//        bt2.setTextColor(0Xffffff00);//  must be 0xxxxxxxxx
        bt2.setOnClickListener(this);

        Button bt3 = (Button) findViewById(R.id.button3);
        bt3.setOnClickListener(this);

        Button bt4 = (Button) findViewById(R.id.button4);
        bt4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.button1:
                Log.i(TAG, " jump to NOT night mode!");
                handleNotNightMode();
                break;
            case R.id.button2:
                Log.i(TAG, " jump to night mode!");
                handleNightMode();
                break;
            case R.id.button3:
                Log.i(TAG, " jump to editview activity!");
                break;
            case R.id.button4:
                Log.i(TAG, " jump to listview activity!");
                break;
            default:
                break;
        }
    }

    public void handleNightMode() {
        mHelper.night();
    }

    public void handleNotNightMode() {
        mHelper.notNight();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_color_flipper, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
