package com.example.jackmiras.placeholderj.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jackson on 14/12/15.
 */
public class Coupon implements Serializable {

    @JsonProperty("id")
    public long id;
    @JsonProperty("user_id")
    public long userId;
    @JsonProperty("company_name")
    public String companyName;
    @JsonProperty("title")
    public String title;
    @JsonProperty("description")
    public String description;
    @JsonProperty("logo_url")
    public String logoUrl;
    @JsonProperty("img_url")
    public String imgUrl;
    @JsonProperty("code")
    public String code;
    @JsonProperty("expiration_date")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    public Date exprirationDate;
    @JsonProperty("redeem_phone")
    public String redeemPhone;
    @JsonProperty("type")
    public Type type;

}
