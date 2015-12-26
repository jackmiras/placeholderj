package com.example.jackmiras.placeholderj.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.jackmiras.placeholderj.Constants;
import com.example.jackmiras.placeholderj.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jackson on 26/12/15.
 */
public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_loading, R.id.button_empty, R.id.button_error})
    public void onMenuOptionsSelected(View v) {
        switch (v.getId()) {
            case R.id.button_loading:
                    startActivity(new Intent(this, CouponsActivity.class).putExtra(Constants.SAMPLE_LOADING, Constants.SAMPLE_LOADING).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                break;
            case R.id.button_empty:
                    startActivity(new Intent(this, CouponsActivity.class).putExtra(Constants.SAMPLE_EMPTY, Constants.SAMPLE_EMPTY).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                break;
            case R.id.button_error:
                    startActivity(new Intent(this, CouponsActivity.class).putExtra(Constants.SAMPLE_ERROR, Constants.SAMPLE_ERROR).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                break;
        }
    }
}
