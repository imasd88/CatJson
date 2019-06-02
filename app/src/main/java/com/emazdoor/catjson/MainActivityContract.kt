package com.emazdoor.catjson

import com.emazdoor.catjson.data.PetOwnerShip

/**
 * Created by Ahmed on 2019-06-01.
 */
interface MainActivityContract {


    interface MainActivityView {
        fun resultsReady(list: ArrayList<PetOwnerShip>)
        fun showAllMaleOwnerCats(list: ArrayList<String>)
        fun showAllFemaleOwnerCats(list: ArrayList<String>)
    }

    interface MainActivityPresenter {
        fun fetchJSON(url: String): ArrayList<PetOwnerShip>
        fun getAllMaleOwnerCats(petList: ArrayList<PetOwnerShip>): ArrayList<String>
        fun getAllFemaleOwnerCats(petList: ArrayList<PetOwnerShip>): ArrayList<String>
    }

}