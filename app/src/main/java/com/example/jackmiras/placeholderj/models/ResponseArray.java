package com.example.jackmiras.placeholderj.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jackson on 14/12/15.
 */
public class ResponseArray<T> {
    @SerializedName("result")
    public ArrayList<T> result;
}
