package yyworkshop.com.myassignment.login.presenter

import android.util.Log
import yyworkshop.com.myassignment.core.AppContext
import yyworkshop.com.myassignment.login.model.Login
import yyworkshop.com.myassignment.login.view.ILoginView
import yyworkshop.com.myassignment.service.SessionService
import yyworkshop.com.myassignment.service.common.ResponseListener

/**
 * Title: yyworkshop.com.myassignment.user.presenter.LoginPresenter<br>
 * Description: LoginPresenter
 *
 * @author chris
 * @version 1.0
 */
class LoginPresenter(var loginView: ILoginView) : ILoginPresenter {

    private val TAG: String = LoginPresenter::class.java.getSimpleName()

    private var sessionService: SessionService? = null

    init {
        sessionService = SessionService()
    }

    override fun doLogin() {

        // Check if it's not in foreground
        val isForeground: Boolean? = loginView.isForeground()

        if(isForeground!!) {
            sessionService!!.doLogin(loginView.getAccountdText(), loginView.getPasswordText(), object : ResponseListener<Login> {
                override fun onResponse(data: Login) {
                    val login = data
                    AppContext.setToken(login.sessionToken)
                    AppContext.setObjectId(login.objectId)
                    AppContext.setTimeZone(login.timezone)
                    Log.i(TAG, AppContext.getToken())

                    loginView.gotoUserActivity()
                }

                override fun onError() {
                    Log.e(TAG, "onError")
                }
            })
        }
    }
}