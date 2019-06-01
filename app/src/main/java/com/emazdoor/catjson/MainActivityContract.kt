package com.emazdoor.catjson

import com.emazdoor.catjson.data.Details

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
        fun fetchJSON()
        fun getAllMaleOwnerCats()
        fun getAllFemaleOwnerCats()
    }

}