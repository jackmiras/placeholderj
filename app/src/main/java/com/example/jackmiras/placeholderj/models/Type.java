package com.example.jackmiras.placeholderj.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jackson on 14/12/15.
 */
public class Type implements Serializable {

    @SerializedName("type_code")
    public int typeCode;
    @SerializedName("status")
    public int status;
    @SerializedName("description")
    public String description;
}
