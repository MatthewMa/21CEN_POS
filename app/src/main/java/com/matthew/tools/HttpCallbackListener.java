package com.matthew.tools;


import android.util.Log;
import java.io.IOException;
public abstract class HttpCallbackListener {

    public abstract void onFinish(String response);//Call back for finishing

    public void onError(Exception e) {//Call back for error
        if (e instanceof IOException) {
            // io 异常
            Log.e("Network error", e.getMessage());
            return;
        }
    }
}

