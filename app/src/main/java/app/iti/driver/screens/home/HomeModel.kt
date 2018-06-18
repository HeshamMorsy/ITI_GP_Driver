package app.iti.driver.screens.home

import app.iti.driver.contracts.HomeContract.*

class HomeModel : Model {
    // reference to presenter
    lateinit var mPresenter: Presenter

    override fun initModel(presenter: Presenter) {
     mPresenter = presenter
    }
}