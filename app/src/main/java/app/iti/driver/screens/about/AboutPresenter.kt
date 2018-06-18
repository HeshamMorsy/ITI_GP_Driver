package app.iti.driver.screens.about


import app.iti.driver.contracts.AboutContract.*
import app.iti.driver.entities.AboutResponse

/**
 * Responsible for getting data from the view [AboutActivity] and send it to the model [AboutModel] to send it to backend
 * , handling actions in the screen and update UI if needed
 */


class AboutPresenter : Presenter {
    // reference to the model and the view
    private lateinit var mView:View
    private lateinit var mModel: Model

    override fun initPresenter(view: View) {
        mView = view
        mModel = AboutModel()
        mModel.initModel(this)
    }

    override fun receiveResponse(response: AboutResponse) {
        mView.onRequestSuccess(response)
    }

    override fun errorResponse(error: Throwable) {
            mView.onRequestError(error)
    }

    override fun getDataFromModel(){
        mModel.requestToApi()
    }
}