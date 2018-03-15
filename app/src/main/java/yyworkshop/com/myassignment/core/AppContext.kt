package yyworkshop.com.myassignment.core

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.util.Log
import com.google.gson.Gson
import yyworkshop.com.myassignment.core.config.ConfigurationLoader
import yyworkshop.com.myassignment.core.config.IAppConfiguration
import yyworkshop.com.myassignment.core.constant.PreferenceKey

@SuppressLint("StaticFieldLeak")
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

    private var sessionToken: String? = null

    // Server
    var host: String? = null

    var context: Context? = null

    fun setup(context: Context) {

        this.context = context

        Log.d(TAG, "setup")

        ConfigurationLoader.setup(IAppConfiguration.CONFIG_FILE, context)

        this.host = config(IAppConfiguration.HOST)
    }

    fun config(key: String): String? {
        return ConfigurationLoader.getProperty(key)
    }

    private fun storeDataToPreference(key: String, data: Any) {

        val gson = Gson()
        val json = gson.toJson(data)

        val sharedPreferences = getDefaultPreference()
        val editor = sharedPreferences.edit()
        editor.putString(key, json)
        editor.apply()
    }

    private fun getDefaultPreference(): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    @Synchronized
    fun setToken(token: String) {
        storeDataToPreference(PreferenceKey.TOKEN.name, token)
    }

    @Synchronized
    fun getToken(): String? {

        val token: String?

        if (sessionToken != null) {
            token = sessionToken
        } else {
            token = getDataFromPreference(PreferenceKey.TOKEN.name, String::class.java)
        }

        return token
    }

    private fun <T> getDataFromPreference(key: String, classOfT: Class<T>): T? {

        val sharedPreferences = getDefaultPreference()
        val json = sharedPreferences.getString(key, null)

        if (json != null) {
            val gson = Gson()
            return gson.fromJson(json, classOfT)
        }

        return null
    }

}