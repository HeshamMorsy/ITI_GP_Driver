package app.iti.driver.screens.login

import android.util.Log
import app.iti.driver.contracts.LoginContract.*
import app.iti.driver.entities.LoginResponse
import app.iti.driver.services.createLoginRequest
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * Created by Hesham on 5/29/2018.
 * Responsible for checking if the email and password exists and matches together in the login api, if requested from LoginPresenter
 */
class LoginModel(val presenter: LoginPresenter) : Model {

    // check if the user email and password exists and matches in the login api
    override fun requestToApi(email: String, password: String) {
        val loginRequest = createLoginRequest()

        // set user data in a hash map to send it in a map query
        val options:Map<String, String> = hashMapOf("email" to email, "password" to password)

            loginRequest.getTokin(options)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(this::handleResponse, this::handleError)

    }

    private fun handleResponse(response: LoginResponse) {
        presenter.receiveResponse(response)
    }

    private fun handleError(error: Throwable) {
        Log.i("error Response", "error receiving data"+error.message)
        presenter.errorResponse()
//        Toast.makeText(this, "Error ${error.localizedMessage}", Toast.LENGTH_SHORT).show()
    }
}