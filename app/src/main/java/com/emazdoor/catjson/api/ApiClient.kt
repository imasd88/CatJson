package com.emazdoor.catjson.api

import android.os.Handler
import android.os.Looper
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler


/**
 * Created by Ahmed on 2019-05-31.
 */
object ApiClient {
    var client = AsyncHttpClient()
    fun get(url: String, responseHandler: JsonHttpResponseHandler) {
        val mainHandler = Handler(Looper.getMainLooper())
        val myRunnable = Runnable {
            client.get(url, responseHandler)
        }
        mainHandler.post(myRunnable)
    }
}