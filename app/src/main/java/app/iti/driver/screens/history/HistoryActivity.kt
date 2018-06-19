package app.iti.driver.screens.history

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import app.iti.driver.R
import app.iti.driver.contracts.HistoryContract.*


class HistoryActivity : AppCompatActivity(), View{

    // reference to presenter
    lateinit var mPresenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        mPresenter = HistoryPresenter()
        mPresenter.initPresenter(this)
    }
}
