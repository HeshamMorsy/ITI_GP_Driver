package app.iti.driver.screens.terms

import app.iti.driver.contracts.TermsContract.*

class TermsModel : Model {
    //reference to presenter
    lateinit var mPresenter: Presenter

    override fun initModel(presenter: Presenter) {
        mPresenter = presenter
    }
}