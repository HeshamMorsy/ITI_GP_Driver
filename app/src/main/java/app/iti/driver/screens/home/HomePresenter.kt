package app.iti.driver.screens.home

import app.iti.driver.contracts.HomeContract.*

class HomePresenter : Presenter {
    // references to model and view
    lateinit var mView: View
    lateinit var mModel: Model

    override fun initPresenter(view: View) {
        mView = view
        mModel = HomeModel()
        mModel.initModel(this)
    }
}