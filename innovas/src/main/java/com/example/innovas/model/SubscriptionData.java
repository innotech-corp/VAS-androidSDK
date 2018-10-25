package com.example.innovas.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 9/11/2018.
 */

public class SubscriptionData {
    @SerializedName("subscribed")
    @Expose
    private Boolean subscribed;

    public Boolean getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(Boolean subscribed) {
        this.subscribed = subscribed;
    }


}
