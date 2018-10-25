package com.example.innovas.model.post_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 9/9/2018.
 */

public class CharkhoonePurchasePostModel {

    @SerializedName("application")
    @Expose
    private String application;
    @SerializedName("msisdn")
    @Expose
    private String msisdn;
    @SerializedName("purchase_token")
    @Expose
    private String purchaseToken;

    public CharkhoonePurchasePostModel(String application, String msisdn, String purchaseToken) {
        this.application = application;
        this.msisdn = msisdn;
        this.purchaseToken = purchaseToken;
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

    public String getPurchaseToken() {
        return purchaseToken;
    }

    public void setPurchaseToken(String purchaseToken) {
        this.purchaseToken = purchaseToken;
    }
}
