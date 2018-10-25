package com.example.innovas.model.post_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 9/9/2018.
 */

public class OtpPostModel {
    @SerializedName("application")
    @Expose
    private String application;
    @SerializedName("msisdn")
    @Expose
    private String msisdn;

    public OtpPostModel(String application, String msisdn) {
        this.application = application;
        this.msisdn = msisdn;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }
}
