package yyworkshop.com.myassignment.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

    private const val DEFAULT_READ_TIMEOUT: Long = 30L

    // Http client
    private var httpClient: OkHttpClient? = null

    // Base URL
    private var baseUrl: String? = null

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

    fun <S> createService(serviceClass: Class<S>): S {

        val okHttpClient = getHttpClient()


//        val retrofit = Retrofit.Builder()
//                .baseUrl("http://ws.audioscrobbler.com")
//                .client(client)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()

        val builder = Retrofit.Builder().baseUrl(baseUrl)

        builder.addConverterFactory(RestConverterFactory).addConverterFactory(GsonConverterFactory.create())

        val retrofit = builder.client(okHttpClient).build()
        return retrofit.create(serviceClass)
    }

    fun setBaseUrl(baseUrl: String) {
        this.baseUrl = baseUrl
    }
}
