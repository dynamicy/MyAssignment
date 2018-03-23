package yyworkshop.com.myassignment.user.view

import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_user.*
import yyworkshop.com.myassignment.R
import yyworkshop.com.myassignment.core.AppContext
import yyworkshop.com.myassignment.service.UserService
import yyworkshop.com.myassignment.ui.base.BaseActivity
import yyworkshop.com.myassignment.user.model.TimeZone
import yyworkshop.com.myassignment.user.presenter.IUserPresenter
import yyworkshop.com.myassignment.user.presenter.UserPresenter

/**
 * Title: yyworkshop.com.myassignment.user.view.UserActivity<br>
 * Description: UserActivity
 *
 * @author chris
 * @version 1.0
 */
class UserActivity : BaseActivity(), IUserView, View.OnClickListener {

    private val TAG: String = UserActivity::class.java.getSimpleName()

    internal lateinit var presenter: IUserPresenter

    private var userService: UserService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userService = UserService()

        presenter = UserPresenter(this@UserActivity)

        initView()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_user
    }

    private fun initView() {

        Log.i(TAG, "initView")

        setToolbarVisibility(false)

        timeZoneEditText.setText(AppContext.getTimeZone()?.toString())

        updateButton.setOnClickListener(this)
    }

    override fun getTimeZoneText(): TimeZone? {
        val timeZoneValue: Int = timeZoneEditText?.getText()?.toString()!!.toInt()
        return TimeZone(timeZoneValue)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.updateButton -> {
                presenter.doUpdateTimeZone()
            }

        }
    }
}
