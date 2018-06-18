package app.iti.driver.screens.terms

import app.iti.driver.contracts.TermsContract.*

class TermsPresenter : Presenter {
    // reference to view and model
    lateinit var mModel: Model
    lateinit var mView: View

    override fun initPresenter(view: View) {
        mView = view
        mModel = TermsModel()
        mModel.initModel(this)
    }
}