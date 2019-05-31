package com.emazdoor.catjson.api

import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler

/**
 * Created by Ahmed on 2019-05-31.
 */
object ApiClient {
    var client = AsyncHttpClient()
    fun get(url: String, responseHandler: JsonHttpResponseHandler) {
        client.get(url, responseHandler)
    }
}