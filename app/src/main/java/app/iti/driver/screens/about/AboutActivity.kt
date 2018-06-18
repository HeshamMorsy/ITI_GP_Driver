package app.iti.driver.screens.about

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import app.iti.driver.R
import app.iti.driver.contracts.AboutContract.*
import app.iti.driver.entities.AboutResponse
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity(), View {
    //reference to presenter
    private lateinit var mPresneter:Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        // initialize about presenter
        mPresneter = AboutPresenter()
        mPresneter.initPresenter(this)
        mPresneter.getDataFromModel()
    }


    override fun onRequestSuccess(response: AboutResponse) {
        if(response.message == "success")
            about_msg.text = response.about_us
    }

    override fun onRequestError(error: Throwable) {
        about_msg.text = resources.getString(R.string.wrongMsg)
    }

}
