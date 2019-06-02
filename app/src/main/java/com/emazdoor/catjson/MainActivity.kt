package com.emazdoor.catjson

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.emazdoor.catjson.data.PetOwnerShip
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainActivityContract.MainActivityView {

    lateinit var mainActivityPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityPresenter = MainActivityPresenter(this)

        mainActivityPresenter.fetchJSON("http://agl-developer-test.azurewebsites.net/people.json")
    }

    override fun resultsReady(list: ArrayList<PetOwnerShip>) {
        mainActivityPresenter.getAllMaleOwnerCats(list)
        mainActivityPresenter.getAllFemaleOwnerCats(list)
    }

    override fun showAllMaleOwnerCats(list: ArrayList<String>) {
        maleTVItem1.text = list[0]
        maleTVItem2.text = list[1]
        maleTVItem3.text = list[2]
        maleTVItem4.text = list[3]
    }

    override fun showAllFemaleOwnerCats(list: ArrayList<String>) {
        femaleTVItem1.text = list[0]
        femaleTVItem2.text = list[1]
    }
}
