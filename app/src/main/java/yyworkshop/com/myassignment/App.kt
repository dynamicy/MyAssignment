package yyworkshop.com.myassignment

import android.app.Application
import android.util.Log
import yyworkshop.com.myassignment.core.AppContext

/**
 * Title: yyworkshop.com.myassignment.App<br>
 * Description: App
 *
 * @author chris
 * @version 1.0
 */
class App : Application() {

    private val TAG: String = App::class.java.getSimpleName()

    override fun onCreate() {

        Log.i(TAG, "onCreate")

        super.onCreate()

        // Initial AppContext
        AppContext.setup(getApplicationContext())
    }

    override fun onTerminate() {

        Log.i(TAG, "onTerminate")

        super.onTerminate()
    }
}