package com.emazdoor.catjson

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.emazdoor.catjson.api.ApiClient
import com.loopj.android.http.JsonHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONArray
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        ApiClient.get("http://agl-developer-test.azurewebsites.net/people.json", object: JsonHttpResponseHandler(){
            override fun onSuccess(statusCode: Int, headers: Array<out Header>?, response: JSONArray?) {
                super.onSuccess(statusCode, headers, response)

                Log.d("ASD", "${response?.optJSONObject(0)?.getJSONArray("pets")}")

                var pet = response?.optJSONObject(0)?.getJSONArray("pets")
            }
        })

    }

}
