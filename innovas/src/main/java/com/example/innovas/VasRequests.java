package com.example.innovas;

import com.example.innovas.model.ResponseOtpRequest;
import com.example.innovas.model.ResponseSubscribtion;
import com.example.innovas.model.post_model.CharkhoonePurchasePostModel;
import com.example.innovas.model.post_model.IsUserPostModel;
import com.example.innovas.model.post_model.OtpPostModel;
import com.example.innovas.model.post_model.VerifyPostModel;
import com.example.innovas.network.ApiUtils;
import com.example.innovas.network.RetrofitInterface;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by amirhesni on 9/9/2018.
 */

public class VasRequests {
    private static final String CONTENT_TYPE = "application/json";
    private static final String ACCEPT = "application/json";

    private static String CLIENT_SECRET ;
    private static Integer applicationId;
    private static String uuid;

    private static RetrofitInterface retrofitInterface;
    private static Gson gson;
    private static isUserListener listener;
    private static OtpListener otpListener;

    public interface isUserListener {
        void isSubscribed(Boolean subscribed);

        void unAuthorization();

        void serverError();

        void badRequest();

        void connectionError();

        void unExpectedError();

    }

    public interface OtpListener {
        void onSuccess(Integer failureCode, Integer otpId);

        void unAuthorization();

        void serverError();

        void badRequest();

        void connectionError();

        void unExpectedError();

    }


    private static String encryptCheckSum(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        password = password + "." + CLIENT_SECRET;
        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
        crypt.reset();
        crypt.update(password.getBytes("UTF-8"));

        return new BigInteger(1, crypt.digest()).toString(16);
    }

    public static void isUser(String msisdn, isUserListener isUserListener) {
        listener = isUserListener;
        IsUserPostModel isUserPostModel = new IsUserPostModel(uuid, formatPhone(msisdn), "pak");
        try {
            retrofitInterface.isUser(applicationId, encryptCheckSum(gson.toJson(isUserPostModel)), CONTENT_TYPE, ACCEPT, isUserPostModel).enqueue(new Callback<ResponseSubscribtion>() {
                @Override
                public void onResponse(Call<ResponseSubscribtion> call, Response<ResponseSubscribtion> response) {
                    if (response.isSuccessful()) {
                        listener.isSubscribed(response.body().getData().getSubscribed());
                    } else if (response.code() == 400) {
                        listener.badRequest();
                    } else if (response.code() == 500) {
                        listener.serverError();
                    } else if (response.code() == 401) {
                        listener.unAuthorization();
                    }
                }

                @Override
                public void onFailure(Call<ResponseSubscribtion> call, Throwable throwable) {
                    if (throwable instanceof ConnectException || throwable instanceof UnknownHostException)
                        listener.connectionError();
                    else {
                        listener.unExpectedError();
                    }
                }
            });
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private static String formatPhone(String msisdn) {
        if (msisdn.startsWith("0")) {
            return "98" + msisdn.substring(1);
        }
        return msisdn;
    }

    public static void otpRequest(String msisdn, OtpListener listener) {
        otpListener = listener;
        OtpPostModel otpPostModel = new OtpPostModel(uuid, formatPhone(msisdn));
        try {
            retrofitInterface.PakOtpRequest(applicationId, encryptCheckSum(gson.toJson(otpPostModel)), CONTENT_TYPE, ACCEPT, otpPostModel).enqueue(new Callback<ResponseOtpRequest>() {
                @Override
                public void onResponse(Call<ResponseOtpRequest> call, Response<ResponseOtpRequest> response) {
                    if (response.isSuccessful()) {
                        otpListener.onSuccess(response.body().getData().getFailureCode() , response.body().getData().getOtpId());
                    } else if (response.code() == 400) {
                        otpListener.badRequest();
                    } else if (response.code() == 500) {
                        otpListener.serverError();
                    } else if (response.code() == 401) {
                        otpListener.unAuthorization();
                    }else {
                        otpListener.unExpectedError();
                    }
                }

                @Override
                public void onFailure(Call<ResponseOtpRequest> call, Throwable throwable) {
                    if (throwable instanceof ConnectException || throwable instanceof UnknownHostException)
                        otpListener.connectionError();
                    else {
                        otpListener.unExpectedError();
                    }
                }
            });
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void verifyRequest(String msisdn, int otpId, String pin, OtpListener listener) {
        otpListener = listener;
        VerifyPostModel verifyPostModel = new VerifyPostModel(uuid, formatPhone(msisdn), otpId, pin);
        try {
            retrofitInterface.PakVerifyRequest(applicationId, encryptCheckSum(gson.toJson(verifyPostModel)), CONTENT_TYPE, ACCEPT, verifyPostModel).enqueue(new Callback<ResponseOtpRequest>() {
                @Override
                public void onResponse(Call<ResponseOtpRequest> call, Response<ResponseOtpRequest> response) {
                    if (response.isSuccessful()) {
                        otpListener.onSuccess(response.body().getData().getFailureCode() , response.body().getData().getOtpId());
                    } else if (response.code() == 400) {
                        otpListener.badRequest();
                    } else if (response.code() == 500) {
                        otpListener.serverError();
                    } else if (response.code() == 401) {
                        otpListener.unAuthorization();
                    }
                }

                @Override
                public void onFailure(Call<ResponseOtpRequest> call, Throwable throwable) {
                    if (throwable instanceof ConnectException || throwable instanceof UnknownHostException)
                        otpListener.connectionError();
                    else {
                        otpListener.unExpectedError();
                    }
                }
            });
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void charkhoonePurchase(String msisdn, String purchaseToken, isUserListener isUserListener) {
        listener = isUserListener;
        CharkhoonePurchasePostModel postModel = new CharkhoonePurchasePostModel(uuid, formatPhone(msisdn), purchaseToken);
        try {
            retrofitInterface.CharkhoonePurchase(applicationId, encryptCheckSum(gson.toJson(postModel)), CONTENT_TYPE, ACCEPT, postModel).enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()) {
                        listener.isSubscribed(false);
                    } else if (response.code() == 400) {
                        listener.badRequest();
                    } else if (response.code() == 500) {
                        listener.serverError();
                    } else if (response.code() == 401) {
                        listener.unAuthorization();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                    if (throwable instanceof ConnectException || throwable instanceof UnknownHostException)
                        listener.connectionError();
                    else {
                        listener.unExpectedError();
                    }
                }
            });
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void init(int Application_ID, String uuidApplication , String ClientSecret) {
        retrofitInterface = ApiUtils.GetRetrofit();
        gson = new Gson();
        applicationId = Application_ID;
        uuid = uuidApplication;
        CLIENT_SECRET = ClientSecret;
    }

    public static String checkOperator(String phone) {
        String[] mci_array = {"0910", "0911", "0912", "0913", "0914", "0915", "0916", "0917", "0918", "0919", "0990"};
        String[] mtn_array = {"0901", "0902", "0903", "0904", "0905", "0906", "0907", "0908", "0909", "0930", "0931", "0932", "0933", "0934", "0935", "0936", "0937", "0938", "0939"};
        for (int i = 0; i < mci_array.length - 1; i++) {
            if (phone.startsWith(mci_array[i]))
                return "mci";
        }
        for (int i = 0; i < mtn_array.length - 1; i++) {
            if (phone.startsWith(mtn_array[i]))
                return "mtn";
        }
        return "";
    }

}
