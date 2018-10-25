package com.example.innovas.model.post_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 9/9/2018.
 */

public class VerifyPostModel {
    @SerializedName("application")
    @Expose
    private String application;
    @SerializedName("msisdn")
    @Expose
    private String msisdn;
    @SerializedName("otp_id")
    @Expose
    private Integer otpId;
    @SerializedName("pin")
    @Expose
    private String pin;

    public VerifyPostModel(String application, String msisdn, Integer otpId, String pin) {
        this.application = application;
        this.msisdn = msisdn;
        this.otpId = otpId;
        this.pin = pin;
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

    public Integer getOtpId() {
        return otpId;
    }

    public void setOtpId(Integer otpId) {
        this.otpId = otpId;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }


}
