package yyworkshop.com.myassignment.user.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import yyworkshop.com.myassignment.R
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

    // Time Zone Label
    var timeZoneTextView: TextView? = null

    // Time Zone Edit Text
    var timeZoneEditText: EditText? = null

    // Login Button
    var updateButton: Button? = null

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

        timeZoneTextView = this.findViewById(R.id.timeZoneTextView)
        timeZoneEditText = this.findViewById(R.id.timeZoneEditText)

        updateButton = this.findViewById(R.id.updateButton)
        updateButton?.setOnClickListener(this)

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
