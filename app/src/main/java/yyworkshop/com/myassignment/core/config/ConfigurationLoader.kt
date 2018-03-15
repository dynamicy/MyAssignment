package yyworkshop.com.myassignment.core.config

import android.content.Context
import java.io.IOException
import java.util.*

/**
 * Title: yyworkshop.com.myassignment.core.config.ConfigurationLoader<br>
 * Description: ConfigurationLoader
 *
 * @author chris
 * @version 1.0
 */
object ConfigurationLoader {

    private lateinit var properties: Properties

    fun setup(file: String, context: Context) {
        this.properties = Properties()

        val assetManager = context.assets
        try {
            properties.load(assetManager.open(file))
        } catch (e: IOException) {
            throw RuntimeException(e.message, e)
        }
    }

    fun getProperty(key: String): String {
        return properties.getProperty(key)
    }

    fun getProperty(key: String, defaultVal: Any): String {
        return properties.getProperty(key, defaultVal.toString())
    }

    fun getInt(key: String): Int {
        return Integer.parseInt(properties.getProperty(key))
    }

    fun getLong(key: String): Long {
        return java.lang.Long.parseLong(properties.getProperty(key))
    }
}