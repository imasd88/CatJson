package com.emazdoor.catjson

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.emazdoor.catjson.data.Details


class MainActivity : AppCompatActivity(), MainActivityContract.MainActivityView {

    lateinit var details: Details
    private val mainActivityPresenter = MainActivityPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityPresenter.fetchJSON()
    }

    override fun showAllMaleOwnerCats(): ArrayList<Details> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showAllFemaleOwnerCats(): ArrayList<Details> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
