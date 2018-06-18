package app.iti.driver.screens.about

import android.util.Log
import app.iti.driver.contracts.AboutContract.*
import app.iti.driver.entities.AboutResponse
import app.iti.driver.services.createAboutRequest
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Responsible for handling actions on the view [AboutActivity] and update UI with the data requested from the model [AboutModel]
 */

class AboutModel : Model {
    // reference to about presenter
    private lateinit var mPresenter:Presenter


    override fun initModel(presenter: Presenter) {
        mPresenter = presenter
    }

    override fun requestToApi() {
        val aboutRequest = createAboutRequest()

        aboutRequest.getAbout()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError)

    }

    private fun handleResponse(response: AboutResponse) {
        mPresenter.receiveResponse(response)
    }

    private fun handleError(error: Throwable) {
        Log.i("error Response", "error receiving data "+error.message)
        mPresenter.errorResponse(error)
    }
}