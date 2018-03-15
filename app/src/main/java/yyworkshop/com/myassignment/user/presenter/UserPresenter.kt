package yyworkshop.com.myassignment.user.presenter

import android.util.Log
import yyworkshop.com.myassignment.core.AppContext
import yyworkshop.com.myassignment.service.UserService
import yyworkshop.com.myassignment.service.common.ResponseListener
import yyworkshop.com.myassignment.user.model.User
import yyworkshop.com.myassignment.user.view.IUserView

/**
 * Title: yyworkshop.com.myassignment.user.presenter.UserPresenter<br>
 * Description: UserPresenter
 *
 * @author chris
 * @version 1.0
 */
class UserPresenter(var userView: IUserView) : IUserPresenter {

    private val TAG: String = UserPresenter::class.java.getSimpleName()

    private var userService: UserService? = null

    init {
        userService = UserService()
    }

    override fun doUpdateTimeZone() {
        userService?.updateUser(userView.getTimeZoneText()!!, object : ResponseListener<User> {
            override fun onResponse(data: User?) {
                val user = data
                Log.i(TAG, AppContext.getToken())
            }

            override fun onError() {
                Log.e(TAG, "onError")
            }
        })
    }
}