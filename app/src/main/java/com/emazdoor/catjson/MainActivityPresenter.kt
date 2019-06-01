package com.emazdoor.catjson

import android.util.Log
import com.emazdoor.catjson.api.ApiClient
import com.loopj.android.http.JsonHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONArray

/**
 * Created by Ahmed on 2019-06-01.
 */
class MainActivityPresenter : MainActivityContract.MainActivityPresenter {

    override fun fetchJSON() {
        ApiClient.get("http://agl-developer-test.azurewebsites.net/people.json", object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<out Header>?, response: JSONArray) {
                super.onSuccess(statusCode, headers, response)

                Log.d("ASD", "${response?.optJSONObject(0)?.getJSONArray("pets")}")
                for (i in 0 until (response?.length() - 1)) {
                    val item = response.getJSONObject(i).getString("gender").takeWhile { it.equals("Male") }

                    Log.e("ASD", "$item")
                }
            }
        })
    }

    override fun getAllMaleOwnerCats() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllFemaleOwnerCats() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}