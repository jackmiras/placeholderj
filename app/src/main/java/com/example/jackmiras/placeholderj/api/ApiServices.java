package com.example.jackmiras.placeholderj.api;

import com.example.jackmiras.placeholderj.models.CouponResponse;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by jackson on 14/12/15.
 */
public interface ApiServices {

    @GET("/placeholder/coupon")
    void getUserCoupons(Callback<CouponResponse> callback);

    @GET("/placeholder/coupon")
    void getUserCouponsEmptyList(Callback<CouponResponse> callback);

    @GET("/placeholder/couponn")
    void getUserCouponsWithError(Callback<CouponResponse> callback);
}
