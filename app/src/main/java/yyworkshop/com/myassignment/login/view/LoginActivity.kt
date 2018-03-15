package yyworkshop.com.myassignment.login.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import yyworkshop.com.myassignment.R
import yyworkshop.com.myassignment.login.model.Login
import yyworkshop.com.myassignment.service.SessionService
import yyworkshop.com.myassignment.service.common.ResponseListener

/**
 * Title: yyworkshop.com.myassignment.login.view.LoginActivity<br>
 * Description: LoginActivity
 *
 * @author chris
 * @version 1.0
 */
class LoginActivity : AppCompatActivity(), ILoginView {

    // Account Label
    var accountTextView: TextView? = null

    // Account Edit Text
    var accountEditText: EditText? = null

    // Passwords Label
    var passwordTextView: TextView? = null

    // Passwords Edit Text
    var passwordEditText: EditText? = null

    private var sessionService: SessionService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initView()
    }

    override fun onStart() {
        super.onStart()
        sessionService = SessionService()

        sessionService!!.doLogin(object : ResponseListener<Login> {
            override fun onResponse(data: Login) {
                val login = data
                Log.i("ef3rgr", "")
            }

            override fun onError() {
                Log.i("ef3rgr", "")
            }
        })
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()


    }

    override fun onStop() {
        super.onStop()


    }

    override fun onDestroy() {
        super.onDestroy()

    }

    /**
     *
     */
    private fun initView() {
        accountTextView = this.findViewById(R.id.accountTextView)
        accountEditText = this.findViewById(R.id.accountEditText)
        passwordTextView = this.findViewById(R.id.passwordTextView)
        passwordEditText = this.findViewById(R.id.passwordEditText)
    }
}
