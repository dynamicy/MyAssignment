package yyworkshop.com.myassignment.core

import android.content.Context
import android.util.Log
import yyworkshop.com.myassignment.core.config.ConfigurationLoader
import yyworkshop.com.myassignment.core.config.IAppConfiguration

/**
 * Title: yyworkshop.com.myassignment.core.AppContext<br></br>
 * Description: AppContext
 *
 * @author chris
 * @version 1.0
 */
object AppContext {

    private val TAG: String = AppContext::class.java.getSimpleName()

    // Terminal
    const val TERMINAL: String = "ANDROID"

    // Server
    var host: String? = null

    fun setup(context: Context) {

        Log.d(TAG, "setup")

        ConfigurationLoader.setup(IAppConfiguration.CONFIG_FILE, context)

        this.host = config(IAppConfiguration.HOST)
    }

    fun config(key: String): String? {
        return ConfigurationLoader.getProperty(key)
    }
}