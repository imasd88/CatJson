package com.emazdoor.catjson

import com.emazdoor.catjson.api.ApiClient
import com.emazdoor.catjson.data.Details
import com.google.gson.Gson
import com.loopj.android.http.JsonHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONArray

/**
 * Created by Ahmed on 2019-06-01.
 */
class MainActivityPresenter(private val mainActivity: MainActivity) : MainActivityContract.MainActivityPresenter {

    val gson = Gson()
    private val list = ArrayList<Details>()

    override fun fetchJSON() {
        ApiClient.get("http://agl-developer-test.azurewebsites.net/people.json", object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<out Header>?, response: JSONArray) {
                super.onSuccess(statusCode, headers, response)
                for (i in 0 until response.length()) {
                    val localResponse = response.getJSONObject(i)
                    if (hasPets(localResponse.getString("pets"))) {
                        val details = gson.fromJson(localResponse.toString(), Details::class.java)
                        list.add(details)
                    }
                }
                mainActivity.resultsReady()
            }
        })
    }

    override fun getAllMaleOwnerCats() {
        val subList = ArrayList<String>()
        for (i in 0 until list.size) {
            if (list[i].gender.equals("Male")) {
                for (j in 0 until list[i].pets.size) if (list[i].pets[j].type.equals("Cat")) subList.add(
                    list[i].pets[j].name
                )
            }
        }
        mainActivity.showAllMaleOwnerCats(makeListAlphabetical(subList))
    }

    override fun getAllFemaleOwnerCats() {
        val subList = ArrayList<String>()
        for (i in 0 until list.size) {
            if (list[i].gender.equals("Female")) {
                for (j in 0 until list[i].pets.size) if (list[i].pets[j].type.equals("Cat")) subList.add(
                    list[i].pets[j].name
                )
            }
        }
        mainActivity.showAllFemaleOwnerCats(makeListAlphabetical(subList))
    }

    private fun hasPets(value: String): Boolean {
        return !value.equals("null")
    }

    private fun makeListAlphabetical(list: ArrayList<String>): ArrayList<String> {
        list.sort()
        return list
    }

}