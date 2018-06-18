package app.iti.driver.screens.terms

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import app.iti.driver.R
import app.iti.driver.contracts.TermsContract.*


class TermsActivity : AppCompatActivity(), View {
    // reference to presenter
    lateinit var mPresenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms)
        mPresenter = TermsPresenter()
        mPresenter.initPresenter(this)
    }
}
