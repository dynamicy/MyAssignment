package yyworkshop.com.myassignment.login.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import yyworkshop.com.myassignment.R
import yyworkshop.com.myassignment.core.AppContext
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

    private val TAG: String = LoginActivity::class.java.getSimpleName()

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

        Log.i(TAG, "onCreate")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sessionService = SessionService()

        initView()
    }

    override fun onStart() {

        Log.i(TAG, "onStart")

        super.onStart()

        sessionService!!.doLogin(object : ResponseListener<Login> {
            override fun onResponse(data: Login) {
                val login = data
                AppContext.setToken(login.sessionToken)
                Log.i(TAG, AppContext.getToken())
            }

            override fun onError() {
                Log.e(TAG, "onError")
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

        Log.i(TAG, "initView")

        accountTextView = this.findViewById(R.id.accountTextView)
        accountEditText = this.findViewById(R.id.accountEditText)
        passwordTextView = this.findViewById(R.id.passwordTextView)
        passwordEditText = this.findViewById(R.id.passwordEditText)
    }
}
