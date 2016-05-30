package com.example.jackmiras.placeholderj.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jackson on 15/12/15.
 */
public class CouponResponse implements Serializable {

    @JsonProperty("result")
    public List<Coupon> result;
}
