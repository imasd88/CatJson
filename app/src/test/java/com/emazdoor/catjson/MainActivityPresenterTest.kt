package com.emazdoor.catjson

import org.junit.Assert
import org.junit.Test

/**
 * Created by Ahmed on 2019-06-02.
 */
class MainActivityPresenterTest {

    val mainActivityPresenter = MainActivityPresenter(MainActivity())

    @Test
    fun fetchJSON() {
        mainActivityPresenter.fetchJSON("http://agl-developer-test.azurewebsites.net/people.json")
    }

    @Test
    fun getAllMaleOwnerCats() {
        val list = mainActivityPresenter.fetchJSON("http://agl-developer-test.azurewebsites.net/people.json")
        val sublist = mainActivityPresenter.getAllMaleOwnerCats(list)
        Assert.assertEquals(sublist[0].toString(), "Garfield")
    }

    @Test
    fun getAllFemaleOwnerCats() {
    }
}