package com.emazdoor.catjson

import com.emazdoor.catjson.data.Details

/**
 * Created by Ahmed on 2019-06-01.
 */
interface MainActivityContract {


    interface MainActivityView {
        fun showAllMaleOwnerCats(): ArrayList<Details>
        fun showAllFemaleOwnerCats(): ArrayList<Details>
    }

    interface MainActivityPresenter {
        fun fetchJSON()
        fun getAllMaleOwnerCats()
        fun getAllFemaleOwnerCats()
    }

}