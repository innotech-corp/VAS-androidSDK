package com.example.innovas.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by User on 9/11/2018.
 */

public class ResponseOtpRequest {
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("data")
    @Expose
    private Data data;
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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public List<Object> getErrors() {
        return errors;
    }

    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    public class Data{
        @SerializedName("failure_code")
        @Expose
        private Integer failureCode;
        @SerializedName("failure_reason")
        @Expose
        private String failureReason;
        @SerializedName("hashed_key")
        @Expose
        private String hashed_key;
        @SerializedName("otp_id")
        @Expose
        private Integer otpId;

        public String getHashed_key() {
            return hashed_key;
        }

        public void setHashed_key(String hashed_key) {
            this.hashed_key = hashed_key;
        }

        public Integer getFailureCode() {
            return failureCode;
        }

        public void setFailureCode(Integer failureCode) {
            this.failureCode = failureCode;
        }

        public String getFailureReason() {
            return failureReason;
        }

        public void setFailureReason(String failureReason) {
            this.failureReason = failureReason;
        }

        public Integer getOtpId() {
            return otpId;
        }

        public void setOtpId(Integer otpId) {
            this.otpId = otpId;
        }

    }
}
