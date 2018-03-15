package yyworkshop.com.myassignment.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import yyworkshop.com.myassignment.R

/**
 * Title: yyworkshop.com.myassignment.ui.base.BaseActivity<br>
 * Description: BaseActivity
 *
 * @author chris
 * @version 1.0
 */
abstract class BaseActivity : AppCompatActivity() {

    // Toolbar
    private var toolbar: Toolbar? = null

    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(getLayoutId())
        initializeToolbar()
    }

    protected fun initializeToolbar() {

        toolbar = findViewById(R.id.toolbar)

        if (toolbar != null) {
            setSupportActionBar(toolbar)
            supportActionBar!!.setTitle("")
        }
    }

    protected fun setToolbarVisibility(visible: Boolean) {

        val actionBar = supportActionBar

        if (actionBar != null) {
            if (visible) {
                actionBar.show()
            } else {
                actionBar.hide()
            }
        }
    }

    fun getToolbar(): Toolbar? {
        return toolbar
    }

}