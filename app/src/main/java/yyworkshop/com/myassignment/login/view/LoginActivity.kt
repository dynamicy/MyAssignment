package yyworkshop.com.myassignment.login.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import yyworkshop.com.myassignment.R
import yyworkshop.com.myassignment.login.presenter.ILoginPresenter
import yyworkshop.com.myassignment.login.presenter.LoginPresenter
import yyworkshop.com.myassignment.ui.base.BaseActivity
import yyworkshop.com.myassignment.user.view.UserActivity

/**
 * Title: yyworkshop.com.myassignment.login.view.LoginActivity<br>
 * Description: LoginActivity
 *
 * @author chris
 * @version 1.0
 */
class LoginActivity : BaseActivity(), ILoginView, View.OnClickListener {

    private val TAG: String = LoginActivity::class.java.getSimpleName()

    internal lateinit var presenter: ILoginPresenter

    // Account Label
    var accountTextView: TextView? = null

    // Account Edit Text
    var accountEditText: EditText? = null

    // Passwords Label
    var passwordTextView: TextView? = null

    // Passwords Edit Text
    var passwordEditText: EditText? = null

    // Login Button
    var loginButton: Button? = null

    // Is in foreground
    var isForeground: Boolean = false

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.i(TAG, "onCreate")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this@LoginActivity)

        initView()

    }

    override fun onPause() {
        super.onPause()

        isForeground = false
    }

    override fun onResume() {
        super.onResume()

        isForeground = true
    }

    override fun onStart() {

        Log.i(TAG, "onStart")

        super.onStart()

    }

    /**
     *
     */
    private fun initView() {

        Log.i(TAG, "initView")

        setToolbarVisibility(false)

        accountTextView = this.findViewById(R.id.accountTextView)
        accountEditText = this.findViewById(R.id.accountEditText)
        passwordTextView = this.findViewById(R.id.passwordTextView)
        passwordEditText = this.findViewById(R.id.passwordEditText)
        loginButton = this.findViewById(R.id.loginButton)
        loginButton?.setOnClickListener(this)
    }

    override fun getAccountdText(): String? {
        return accountEditText?.getText()?.toString()
    }

    override fun getPasswordText(): String? {
        return passwordEditText?.getText()?.toString()
    }

    override fun gotoUserActivity() {
        val intent = Intent(this@LoginActivity, UserActivity::class.java)
        startActivity(intent)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.loginButton -> {
                presenter.doLogin()
            }

        }
    }

    override fun isForeground(): Boolean? {
        return this.isForeground
    }
}
