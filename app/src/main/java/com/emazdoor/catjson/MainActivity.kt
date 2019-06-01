package com.emazdoor.catjson

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.emazdoor.catjson.data.PetOwnerShip


class MainActivity : AppCompatActivity(), MainActivityContract.MainActivityView {

    lateinit var PetOwnerShip: PetOwnerShip
    lateinit var mainActivityPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityPresenter = MainActivityPresenter(this)

        mainActivityPresenter.fetchJSON("http://agl-developer-test.azurewebsites.net/people.json")
    }

    override fun resultsReady() {
        mainActivityPresenter.getAllMaleOwnerCats()
        mainActivityPresenter.getAllFemaleOwnerCats()
    }

    override fun showAllMaleOwnerCats(list: ArrayList<String>) {
    }

    override fun showAllFemaleOwnerCats(list: ArrayList<String>) {
    }
}
