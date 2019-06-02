package com.emazdoor.catjson

import com.emazdoor.catjson.api.ApiClient
import com.emazdoor.catjson.data.PetOwnerShip
import com.google.gson.Gson
import com.loopj.android.http.JsonHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONArray

/**
 * Created by Ahmed on 2019-06-01.
 */
class MainActivityPresenter(private val mainActivity: MainActivity) : MainActivityContract.MainActivityPresenter {

    val gson = Gson()

    override fun fetchJSON(url: String): ArrayList<PetOwnerShip> {
        val list = ArrayList<PetOwnerShip>()
        ApiClient.get(url, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<out Header>?, response: JSONArray) {
                super.onSuccess(statusCode, headers, response)
                for (i in 0 until response.length()) {
                    val localResponse = response.getJSONObject(i)
                    if (hasPets(localResponse.getString("pets"))) {
                        val petOwnerShip = gson.fromJson(localResponse.toString(), PetOwnerShip::class.java)
                        list.add(petOwnerShip)
                    }
                }
                mainActivity.resultsReady(list)
            }
        })
        return list
    }

    override fun getAllMaleOwnerCats(petList: ArrayList<PetOwnerShip>): ArrayList<String> {
        val subList = ArrayList<String>()
        for (i in 0 until petList.size) {
            if (petList[i].gender.equals("Male")) {
                for (j in 0 until petList[i].pets.size) if (petList[i].pets[j].type.equals("Cat")) subList.add(
                    petList[i].pets[j].name
                )
            }
        }
        mainActivity.showAllMaleOwnerCats(makeListAlphabetical(subList))
        return subList
    }

    override fun getAllFemaleOwnerCats(petList: ArrayList<PetOwnerShip>): ArrayList<String> {
        val subList = ArrayList<String>()
        for (i in 0 until petList.size) {
            if (petList[i].gender.equals("Female")) {
                for (j in 0 until petList[i].pets.size) if (petList[i].pets[j].type.equals("Cat")) subList.add(
                    petList[i].pets[j].name
                )
            }
        }
        mainActivity.showAllFemaleOwnerCats(makeListAlphabetical(subList))
        return subList
    }

    private fun hasPets(value: String): Boolean {
        return !value.equals("null")
    }

    private fun makeListAlphabetical(list: ArrayList<String>): ArrayList<String> {
        list.sort()
        return list
    }

}