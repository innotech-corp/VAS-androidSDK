package com.example.innovas.model.post_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 9/9/2018.
 */

public class IsUserPostModel {

    @SerializedName("application")
    @Expose
    private String application;
    @SerializedName("msisdn")
    @Expose
    private String msisdn;
    @SerializedName("vas_provider")
    @Expose
    private String vasProvider;

    public IsUserPostModel(String application, String msisdn, String vasProvider) {
        this.application = application;
        this.msisdn = msisdn;
        this.vasProvider = vasProvider;
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

    public String getVasProvider() {
        return vasProvider;
    }

    public void setVasProvider(String vasProvider) {
        this.vasProvider = vasProvider;
    }

}
