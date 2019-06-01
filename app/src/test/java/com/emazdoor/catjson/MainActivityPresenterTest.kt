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
        fetchJSON()
        val list = mainActivityPresenter.getAllMaleOwnerCats()
        Assert.assertEquals(list[0].toString(), "Garfield")
    }

    @Test
    fun getAllFemaleOwnerCats() {
    }
}