package app.iti.driver.screens.history

import app.iti.driver.contracts.HistoryContract.*

class HistoryPresenter : Presenter {
    // reference to view and model
    lateinit var mModel: Model
    lateinit var mView: View

    override fun initPresenter(view: View) {
        mView = view
        mModel = HistoryModel()
        mModel.initModel(this)
    }
}