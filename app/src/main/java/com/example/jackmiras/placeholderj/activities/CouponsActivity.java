package com.example.jackmiras.placeholderj.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.jackmiras.placeholderj.Constants;
import com.example.jackmiras.placeholderj.R;
import com.example.jackmiras.placeholderj.adapter.MenuAdapter;
import com.example.jackmiras.placeholderj.api.ApiClient;
import com.example.jackmiras.placeholderj.library.PlaceHolderJ;
import com.example.jackmiras.placeholderj.models.Coupon;
import com.example.jackmiras.placeholderj.models.CouponResponse;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class CouponsActivity extends BaseActivity implements Callback<CouponResponse> {

    private final static int NUM_COLUMNS = 2;

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.recyclerview_coupon)
    RecyclerView recyclerView;

    private PlaceHolderJ placeHolderJ;
    private boolean isListEmpty;
    private boolean isListEmptyTryAgainEnabled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupons);
        ButterKnife.bind(this);
        setActionBar(toolbar, R.string.activity_coupons_label, true);

        placeHolderJ = new PlaceHolderJ(this, R.id.recyclerview_coupon);
        placeHolderJ.init(R.id.view_loading, R.id.view_empty, R.id.view_error);

        setupViews();
    }

    public void setupViews() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, NUM_COLUMNS));
        requestUserCoupons();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void showErrorView(RetrofitError error) {
        placeHolderJ.hideLoading();
        placeHolderJ.showError(error, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                placeHolderJ.hideError();
                placeHolderJ.showLoading();
                requestUserCoupons();
            }
        });
    }

    private void requestUserCoupons() {
        placeHolderJ.showLoading();
        if (getIntent().getExtras().containsKey(Constants.SAMPLE_LOADING)) {
            //Used to make some delay to make the loading view visible for a while.
            waitToRequest();
        } else if (getIntent().getExtras().containsKey(Constants.SAMPLE_EMPTY)) {
            //Used to make the empty view visible.
            isListEmpty = true;
            ApiClient.getServices().getUserCoupons(this);
        } else if (getIntent().getExtras().containsKey(Constants.SAMPLE_EMPTY_WITH_TRY_AGAIN)) {
            //Used to make the empty view with try again button visible.
            isListEmpty = true;
            isListEmptyTryAgainEnabled = true;
            ApiClient.getServices().getUserCoupons(this);
        } else {
            //Used to make the error view visible.
            ApiClient.getServices().getUserCouponsWithError(this);
        }
    }

    private void waitToRequest() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ApiClient.getServices().getUserCoupons(CouponsActivity.this);
            }
        }, 2000);
    }

    @Override
    public void success(CouponResponse couponResponse, Response response) {
        placeHolderJ.hideLoading();
        //If isListEmpty is true than couponResponse.result receives an empty array to make the view empty visible.
        couponResponse.result = isListEmpty ? new ArrayList<Coupon>() : couponResponse.result;
        if (couponResponse.result != null && couponResponse.result.size() > 0) {
            recyclerView.setAdapter(new MenuAdapter(CouponsActivity.this, couponResponse.result));
        } else if (isListEmptyTryAgainEnabled) {
            //If isListEmptyTryAgainEnabled is true, than the empty view with try again button will be shown.
            placeHolderJ.showEmpty(R.string.activity_coupons_empty, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    placeHolderJ.hideEmpty();
                    requestUserCoupons();
                }
            });
        } else {
            //If isListEmptyTryAgainEnabled is false, than the empty view without try again button will be shown.
            placeHolderJ.showEmpty(R.string.activity_coupons_empty, null);
        }
    }

    @Override
    public void failure(RetrofitError error) {
        showErrorView(error);
    }
}
