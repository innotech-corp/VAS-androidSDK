package com.example.innovas.network;

import com.example.innovas.model.ResponseOtpRequest;
import com.example.innovas.model.ResponseSubscribtion;
import com.example.innovas.model.post_model.CharkhoonePurchasePostModel;
import com.example.innovas.model.post_model.IsUserPostModel;
import com.example.innovas.model.post_model.OtpPostModel;
import com.example.innovas.model.post_model.VerifyPostModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Android on 9/4/2017.
 */

public interface RetrofitInterface {
    @POST(ApiUtils.API_V1 + "clients/is-user")
    Call<ResponseSubscribtion> isUser(@Header("Vw-Application-ID") Integer id, @Header("Vw-Checksum") String checksum
            , @Header("Content-Type") String Content_Type, @Header("Accept") String Accept, @Body IsUserPostModel postModel);

    @POST(ApiUtils.API_V1 + "clients/pak/otp/request")
    Call<ResponseOtpRequest> PakOtpRequest(@Header("Vw-Application-ID") Integer id, @Header("Vw-Checksum") String checksum
            , @Header("Content-Type") String Content_Type, @Header("Accept") String Accept, @Body OtpPostModel postModel);

    @POST(ApiUtils.API_V1 + "clients/pak/otp/verify")
    Call<ResponseOtpRequest> PakVerifyRequest(@Header("Vw-Application-ID") Integer id, @Header("Vw-Checksum") String checksum
            , @Header("Content-Type") String Content_Type, @Header("Accept") String Accept, @Body VerifyPostModel postModel);

    @POST(ApiUtils.API_V1 + "clients/pak/otp/request")
    Call<ResponseBody> CharkhoonePurchase(@Header("Vw-Application-ID") Integer id, @Header("Vw-Checksum") String checksum
            , @Header("Content-Type") String Content_Type, @Header("Accept") String Accept, @Body CharkhoonePurchasePostModel postModel);
}