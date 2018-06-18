package app.iti.driver.screens.login

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.util.Log
import android.widget.Toast
import app.iti.driver.R
import app.iti.driver.contracts.LoginContract.*
import app.iti.driver.entities.LoginResponse
import app.iti.driver.utilities.PreferenceHelper
import app.iti.driver.utilities.PreferenceHelper.setValue
import app.iti.driver.utilities.getAlertDialog
import java.util.regex.Pattern

/**
 * Created by Hesham on 5/29/2018.
 * Responsible for handling actions from login view and updating UI if required
 */
class LoginPresenter : Presenter {
    // references to model and view
    lateinit var mView:View
    var mModel:Model?=null

    // booleans to check if email and password are valid
    var checkEmail:Boolean = false
    var checkPassword:Boolean = false

    // initialize mView and mModel
    override fun initPresenter(view: View) {
        // initializing mView as LoginActivity and mModel as LoginModel
        mView = view

        mModel= LoginModel(this)
    }

    // send email and password to model to check if the user email and password exists and matches in the login api
    override fun login(email: String, password: String) {
        isEmailValid(email)
//        isPasswordValid(password)
//        if(checkEmail && checkPassword) {
            mView.startLoading((mView as Activity).resources.getString(R.string.wait))
            mModel?.requestToApi(email, password)
//        }
//        else {
//            Log.i("LoginPresenter", "unvalid email or password!!")
//        }
    }

    // check regular expression for email
    override fun isEmailValid(email: String){
        val check:Boolean= Pattern.compile(
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                        + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                        + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches()
        if(check){
            checkEmail = true
        }else{
            mView.setEmailError("Invalid Email")
            checkEmail = false
        }
    }

    override fun isPasswordValid(pass:String){
        val passwordRegex = "^((?!.*\\s)(?=.*[a-zA-Z])(?=.*\\d)).{6,12}$"
        val check:Boolean= pass.matches(passwordRegex.toRegex())
        if(check){
            checkPassword = true
        }else{
            mView.setPasswordError("Invalid Password")
            checkPassword = false
        }
    }

    // response from login api model
    override fun receiveResponse(response: LoginResponse) {
            mView.endLoading()
            mView.goToHomeScreen(response)

    }

    override fun errorResponse(error: Throwable) {
        mView?.endLoading()
        Toast.makeText(mView as Activity , error.localizedMessage , Toast.LENGTH_SHORT).show()
        val alert = getAlertDialog(mView!! as Activity, (mView as Activity).resources.getString(R.string.error)
                ,(mView as Activity).resources.getString(R.string.invalid))
                alert.setPositiveButton((mView as Activity).resources.getString(R.string.ok)
                        , DialogInterface.OnClickListener{dialog, which ->
                    alert.setCancelable(true)
                 })
        alert.show()
    }

}