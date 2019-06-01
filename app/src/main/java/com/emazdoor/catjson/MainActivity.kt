package com.emazdoor.catjson

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.emazdoor.catjson.data.Details


class MainActivity : AppCompatActivity(), MainActivityContract.MainActivityView {

    lateinit var details: Details
    lateinit var mainActivityPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityPresenter = MainActivityPresenter(this)

        mainActivityPresenter.fetchJSON()
    }

    override fun resultsReady() {
        mainActivityPresenter.getAllMaleOwnerCats()
        mainActivityPresenter.getAllFemaleOwnerCats()
    }

    override fun showAllMaleOwnerCats(list: ArrayList<String>) {
        for(l in list){
            Log.e("list", "$l")
        }
    }

    override fun showAllFemaleOwnerCats(list: ArrayList<String>) {
        for(f in list){
            Log.e("list", "female $f")
        }
    }
}
