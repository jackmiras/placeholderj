package com.placeholderj.example.activities;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.placeholderj.example.R;

/**
 * Created by jackson on 26/12/15.
 */
public class BaseActivity extends AppCompatActivity {

    public void setActionBar(Toolbar toolbar, int titleRes, boolean isDisplayHomeAsUp) {
        toolbar.setTitle("");
        ((TextView) toolbar.findViewById(R.id.textview_toolbar_title)).setText(titleRes);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(isDisplayHomeAsUp);
    }
}
