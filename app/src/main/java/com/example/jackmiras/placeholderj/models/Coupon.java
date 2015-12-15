package com.example.jackmiras.placeholderj.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jackson on 14/12/15.
 */
public class Coupon implements Serializable {

    @SerializedName("id")
    public long id;
    @SerializedName("user_id")
    public long userId;
    @SerializedName("company_name")
    public String companyName;
    @SerializedName("title")
    public String title;
    @SerializedName("description")
    public String description;
    @SerializedName("logo_url")
    public String logoUrl;
    @SerializedName("img_url")
    public String imgUrl;
    @SerializedName("code")
    public String code;
    @SerializedName("expiration_date")
    public Date exprirationDate;
    @SerializedName("redeem_phone")
    public String redeemPhone;
    @SerializedName("type")
    public Type type;

}
