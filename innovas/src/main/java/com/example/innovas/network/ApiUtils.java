package com.example.innovas.network;

/**
 * Created by amirhesni on 9/11/17.
 */

public class ApiUtils {
    public static final String API_V1 = "api/v1";
    public static final String BASE_URL = "http://vas.theinnotech.ir/";


    public static RetrofitInterface GetCacheableRetrofit() {
        return RetrofitClient
                .getCacheableClient(BASE_URL)
                .create(RetrofitInterface.class);
    }

    public static RetrofitInterface GetRetrofit() {
        return RetrofitClient.getClient(BASE_URL).create(RetrofitInterface.class);
    }


}
