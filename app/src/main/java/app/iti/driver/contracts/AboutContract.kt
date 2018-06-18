package app.iti.driver.contracts

import app.iti.driver.entities.AboutResponse

interface AboutContract {
    interface Model {
        fun initModel(presenter: Presenter)
        fun requestToApi()
    }
    interface View {
        fun onRequestSuccess(response: AboutResponse)
        fun onRequestError(error: Throwable)
    }
    interface Presenter {
        fun initPresenter(view: View)
        fun receiveResponse(response: AboutResponse)
        fun errorResponse(error: Throwable)
        fun getDataFromModel()
    }
}