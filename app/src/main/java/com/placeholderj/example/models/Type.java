package com.placeholderj.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by jackson on 14/12/15.
 */
public class Type implements Serializable {

    @JsonProperty("type_code")
    public int typeCode;
    @JsonProperty("status")
    public int status;
    @JsonProperty("description")
    public String description;
}
