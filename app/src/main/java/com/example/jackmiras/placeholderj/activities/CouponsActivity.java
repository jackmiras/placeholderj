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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    public void showErrorView(Throwable t) {
        placeHolderJ.hideLoading();
        placeHolderJ.showError(t, new View.OnClickListener() {
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
            //Used to delay and make the loading view visible for a while.
            waitToRequest();
        } else if (getIntent().getExtras().containsKey(Constants.SAMPLE_EMPTY)) {
            //Used to make the empty view visible.
            isListEmpty = true;
            ApiClient.getService().getUserCoupons().enqueue(this);
        } else if (getIntent().getExtras().containsKey(Constants.SAMPLE_EMPTY_WITH_TRY_AGAIN)) {
            //Used to make the empty view with try again button visible.
            isListEmpty = true;
            isListEmptyTryAgainEnabled = true;
            ApiClient.getService().getUserCoupons().enqueue(this);
        } else {
            //Used to make the error view visible.
            ApiClient.getService().getUserCouponsWithError().enqueue(this);
        }
    }

    private void waitToRequest() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ApiClient.getService().getUserCoupons().enqueue(CouponsActivity.this);
            }
        }, 2000);
    }

    @Override
    public void onResponse(Call<CouponResponse> call, Response<CouponResponse> response) {
        placeHolderJ.hideLoading();
        if (response.isSuccessful() && response.body() != null) {
            //If isListEmpty is true, so the couponResponse.result receives an empty array to make the view empty visible.
            response.body().result = isListEmpty ? new ArrayList<Coupon>() : response.body().result;
            if (response.body().result != null && response.body().result.size() > 0) {
                recyclerView.setAdapter(new MenuAdapter(CouponsActivity.this, response.body().result));
            } else if (isListEmptyTryAgainEnabled) {
                //If isListEmptyTryAgainEnabled is true, so the empty view with try again button will be shown.
                placeHolderJ.showEmpty(R.string.activity_coupons_empty, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        placeHolderJ.hideEmpty();
                        requestUserCoupons();
                    }
                });
            } else {
                //If isListEmptyTryAgainEnabled is false, so the empty view without try again button will be shown.
                placeHolderJ.showEmpty(R.string.activity_coupons_empty, null);
            }
        } else {
            onFailure(null, null);
        }
    }

    @Override
    public void onFailure(Call<CouponResponse> call, Throwable t) {
        showErrorView(t);
    }
}
