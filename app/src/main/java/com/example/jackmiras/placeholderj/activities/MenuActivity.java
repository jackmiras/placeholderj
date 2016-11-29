package com.example.jackmiras.placeholderj.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.jackmiras.placeholderj.Constants;
import com.example.jackmiras.placeholderj.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jackson on 26/12/15.
 */
public class MenuActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
        setActionBar(toolbar, R.string.activity_main_label, false);
    }

    @OnClick({R.id.button_loading, R.id.button_empty, R.id.button_empty_try_again, R.id.button_error})
    public void onMenuOptionsSelected(View v) {
        switch (v.getId()) {
            case R.id.button_loading:
                startActivity(new Intent(this, CouponsActivity.class).putExtra(Constants.SAMPLE_LOADING, Constants.SAMPLE_LOADING).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                break;
            case R.id.button_empty:
                startActivity(new Intent(this, CouponsActivity.class).putExtra(Constants.SAMPLE_EMPTY, Constants.SAMPLE_EMPTY).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                break;
            case R.id.button_empty_try_again:
                startActivity(new Intent(this, CouponsActivity.class).putExtra(Constants.SAMPLE_EMPTY_WITH_TRY_AGAIN, Constants.SAMPLE_EMPTY_WITH_TRY_AGAIN).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                break;
            case R.id.button_error:
                startActivity(new Intent(this, CouponsActivity.class).putExtra(Constants.SAMPLE_ERROR, Constants.SAMPLE_ERROR).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                break;
        }
    }
}
