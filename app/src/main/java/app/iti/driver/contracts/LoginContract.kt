package app.iti.driver.contracts

import app.iti.driver.entities.LoginResponse


/**
 * Created by Hesham on 5/29/2018.
 * define the contract between the view [LoginActivity], the model [LoginModel] and the presenter [LoginPresenter]
 */
interface LoginContract {
    interface Model {
        fun requestToApi(email: String, password: String)
    }

    interface View {
        fun setEmailError(error:String)
        fun setPasswordError(error:String)
        fun goToHomeScreen()
        fun startLoading(mes:String)
        fun endLoading()
        fun goToSignUpScreen()
    }

    interface Presenter {
        fun initPresenter(view: View)
        fun login(email: String, password: String)
        fun receiveResponse(response: LoginResponse)
        fun errorResponse()
        fun isEmailValid(email: String)
        fun isPasswordValid(email: String)

    }
}