package com.example.innovas.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by User on 9/11/2018.
 */

public class ResponseSubscribtion {
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("data")
    @Expose
    private SubscriptionData data;
    @SerializedName("errors")
    @Expose
    private List<Object> errors = null;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public SubscriptionData  getData() {
        return data;
    }

    public void setData(SubscriptionData  data) {
        this.data = data;
    }

    public List<Object> getErrors() {
        return errors;
    }

    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

}
