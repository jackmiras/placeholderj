package com.example.jackmiras.placeholderj.api;

import com.example.jackmiras.placeholderj.models.Coupon;
import com.example.jackmiras.placeholderj.models.ResponseArray;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by jackson on 14/12/15.
 */
public interface ApiServices {

    @GET("/coupon")
    void getUserCoupons(Callback<ResponseArray<Coupon>> callback);
}
