package com.example.jackmiras.placeholderj.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jackson on 15/12/15.
 */
public class CouponResponse implements Serializable {
    @SerializedName("result")
    public List<Coupon> result;
}
