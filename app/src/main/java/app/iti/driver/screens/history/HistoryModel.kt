package app.iti.driver.screens.history

import app.iti.driver.contracts.HistoryContract.*

class HistoryModel : Model {
    //reference to presenter
    lateinit var mPresenter: Presenter

    override fun initModel(presenter: Presenter) {
        mPresenter = presenter
    }
}