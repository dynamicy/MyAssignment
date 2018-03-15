package yyworkshop.com.myassignment.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import yyworkshop.com.myassignment.core.http.RequestInterceptor
import java.util.concurrent.TimeUnit

/**
 * Title: yyworkshop.com.myassignment.data.RestResourceFactory</br>
 * Description: RestResourceFactory
 *
 * @author chris
 * @version 1.0
 */
object RestResourceFactory {

    private val DEFAULT_READ_TIMEOUT: Long = 30L

    // Http client
    private var httpClient: OkHttpClient? = null

    // Base URL
    private var baseUrl: String? = null

    fun RestResourceFactory(baseUrl: String) {
        this.baseUrl = baseUrl
    }

    @Synchronized
    private fun getHttpClient(): OkHttpClient {

        val client: OkHttpClient

        if (httpClient == null) {
            httpClient = buildHttpClient(RequestInterceptor())
        }
        client = httpClient as OkHttpClient

        return client
    }

    private fun buildHttpClient(requestInterceptor: RequestInterceptor): OkHttpClient {

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(httpLoggingInterceptor)
                .readTimeout(DEFAULT_READ_TIMEOUT, TimeUnit.SECONDS)
                .build()

    }
}
