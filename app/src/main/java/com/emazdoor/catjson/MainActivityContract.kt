package com.emazdoor.catjson

/**
 * Created by Ahmed on 2019-06-01.
 */
interface MainActivityContract {


    interface MainActivityView {
        fun resultsReady()
        fun showAllMaleOwnerCats(list: ArrayList<String>)
        fun showAllFemaleOwnerCats(list: ArrayList<String>)
    }

    interface MainActivityPresenter {
        fun fetchJSON(url: String)
        fun getAllMaleOwnerCats(): ArrayList<String>
        fun getAllFemaleOwnerCats() : ArrayList<String>
    }

}