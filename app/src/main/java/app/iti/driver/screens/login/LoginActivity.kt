package app.iti.driver.screens.login

import android.app.AlertDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import app.iti.driver.R
import app.iti.driver.contracts.LoginContract.*
import app.iti.driver.entities.LoginResponse
import app.iti.driver.screens.home.HomeActivity
import app.iti.driver.utilities.PreferenceHelper
import app.iti.driver.utilities.PreferenceHelper.setValue
import kotlinx.android.synthetic.main.activity_login.*


/**
 * Displays the login screen
 */

class LoginActivity : AppCompatActivity(), View, android.view.View.OnFocusChangeListener {
    // reference to presenter
    var mPresenter:Presenter?=null
    // progress dialog
    var dialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // initialize presenter as LoginPresenter
        mPresenter = LoginPresenter()
        mPresenter?.initPresenter(this)
        // set focus on email and password edit text
        login_emailEditText.onFocusChangeListener = this
        login_passwordEditText.onFocusChangeListener= this


    }

    // login button action when clicked
    fun loginBtnEvent(view:android.view.View){
        val email:String = login_emailEditText.text.toString()
        val password:String = login_passwordEditText.text.toString()
        Log.i("Login email", email)
        Log.i("Login password", password)
        mPresenter?.login(email,password)

    }

    override fun setEmailError(error:String) {
        login_emailEditText.error = error
    }

    override fun setPasswordError(error:String) {
        login_passwordEditText.error = error
    }

    // on focus on edit texts fields
    override fun onFocusChange(v: android.view.View?, hasFocus: Boolean) {
        if (v == login_emailEditText && hasFocus == false) {
            mPresenter?.isEmailValid(login_emailEditText.text.toString())
        }
//        if(v == login_passwordEditText && hasFocus == false){
//            mPresenter?.isPasswordValid(login_passwordEditText.text.toString())
//        }
    }


    override fun goToHomeScreen(response: LoginResponse) {
        // save authentication token in shared preferences
        val defaultPref = PreferenceHelper.defaultPrefs(this)
        defaultPref.setValue("auth_token",response.auth_token)
        defaultPref.setValue("email",response.driver.email)
        defaultPref.setValue("phone",response.driver.phone)
        defaultPref.setValue("name",response.driver.name)
        defaultPref.setValue("latitude",response.driver.latitude)
        defaultPref.setValue("longitude",response.driver.longitude)
        defaultPref.setValue("city",response.driver.city)
        defaultPref.setValue("created_at",response.driver.created_at)
        defaultPref.setValue("updated_at",response.driver.updated_at)
        defaultPref.setValue("device_token",response.driver.device_token)
        defaultPref.setValue("id",response.driver.id)
        defaultPref.setValue("password_digest",response.driver.password_digest)
        defaultPref.setValue("status",response.driver.status)
        defaultPref.setValue("vehicle_kind",response.driver.vehicle_kind)
        Log.i("response","sata inside presenter: " + response)
        Log.i("response","inside view")
        val myIntent = Intent(this, HomeActivity::class.java)
        // start home activity
        startActivity(myIntent)
        finish()
    }

    override fun startLoading(mes:String){
        Log.i("response", "start loading function")
        val builder = AlertDialog.Builder(this)
        val dialougeView = layoutInflater.inflate(R.layout.progress_dialouge,null)
        val message = dialougeView.findViewById<TextView>(R.id.loadingmessage)
        message.text = mes
        builder.setView(dialougeView)
        builder.setCancelable(false)
        dialog = builder.create()
        dialog?.show()
    }

    override fun endLoading(){
        Log.i("response", "end loading function")
        dialog?.dismiss()
    }

}
