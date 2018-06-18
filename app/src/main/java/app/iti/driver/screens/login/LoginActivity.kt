package app.iti.driver.screens.login

import android.app.AlertDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import app.iti.driver.R
import app.iti.driver.contracts.LoginContract.*
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

    // method to handle on click on register now textView and go to SignUpActivity
    fun toRegisterScreen(view:android.view.View){
        /*val intent = Intent(this, SignUpActivity::class.java)
        // start your register activity
        startActivity(intent)
        finish()*/
    }

    // method to handle on click on forgot password textView and go to ForgotPasswordActivity
    fun toForgotPassword(view:android.view.View){
        /*val intent = Intent(this, ForgotPasswordActivity::class.java)
        // start your forgot password activity
        startActivity(intent)*/
    }

    // login button action when clicked
    fun loginBtnEvent(view:android.view.View){
        val email:String = login_emailEditText.text.toString()
        val password:String = login_passwordEditText.text.toString()
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
        if(v == login_passwordEditText && hasFocus == false){
            mPresenter?.isPasswordValid(login_passwordEditText.text.toString())
        }
    }


    override fun goToHomeScreen() {
        /*val myIntent = Intent(this, HomeActivity::class.java)
        // start home activity
        startActivity(myIntent)
        finish()*/
    }

    override fun goToSignUpScreen() {
        /*val myIntent = Intent(this, SignUpActivity::class.java)
        myIntent.putExtra("is_verified",false)
        // start home activity
        startActivity(myIntent)
        finish()*/
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
