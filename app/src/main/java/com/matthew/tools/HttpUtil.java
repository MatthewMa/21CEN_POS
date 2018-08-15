package com.matthew.tools;

import android.content.SharedPreferences;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Matthew Ma on 2018/08/13.
 */

public class HttpUtil {
    private OkHttpClient client;
    private String token;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    private HttpUtil() {
        client = new OkHttpClient();
//        sp = ContextApplication.getContext()
//                .getSharedPreferences("login_data", Context.MODE_PRIVATE);
//        editor = sp.edit();
//        token = sp.getString("token", "");
    }

    private static HttpUtil httpUtil = null;

    // Single instance
    public static HttpUtil getInstance() {
        if (httpUtil == null) {
            httpUtil = new HttpUtil();
        }
        return httpUtil;
    }

    public void sendRequestWithCallback(final RequestTypeEnum method, final String address, final RequestBody body, final HttpCallbackListener listener
    ) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Request.Builder builder = new Request.Builder()
                        .url(address);

                switch (method) {
                    case POST:
                        builder.post(body);
                        break;
                    case PUT:
                        builder.put(body);
                        break;
                    case DELETE:
                        builder.delete(body);
                        break;
                    default:
                        builder.get();
                        break;
                }

                Request request = builder.build();
                try {
                    //Actual request code
                    Log.i("url = ", address);
                    Response response = client.newCall(request).execute();
                    token = response.header("token");
                    if (token == null) {
                        token = "b06804b910ea4f96a714a84d686d8583";
                        Log.i("", "No token, using default token!");
                    } else {
                        Log.i("", "receive token：" + token);
                    }


                    String result = response.body().string();
                    if (result != null && listener != null) {
                        if (response.isSuccessful()) {
                            listener.onFinish(result);
                        } else {
                            listener.onError(new ServerException(result));
                        }
                    }

                } catch (IOException e) {
                    if (listener != null) {
                        listener.onError(e);
                    }
                }
            }
        }).start();

    }

    public void post(final String address, RequestBody body, final HttpCallbackListener listener) {
        sendRequestWithCallback(RequestTypeEnum.POST, address, body, listener);
    }

    public void get(String address, HttpCallbackListener listener) {
        sendRequestWithCallback(RequestTypeEnum.GET, address, null, listener);
    }

    public void delete(String address, RequestBody body, HttpCallbackListener listener) {
        sendRequestWithCallback(RequestTypeEnum.DELETE, address, body, listener);
    }

    public void put(String address, RequestBody body, HttpCallbackListener listener) {
        sendRequestWithCallback(RequestTypeEnum.PUT, address, body, listener);
    }
}

enum RequestTypeEnum {
    GET, POST, PUT, DELETE
}
