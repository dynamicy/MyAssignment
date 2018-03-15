package yyworkshop.com.myassignment.core.http

import okhttp3.Interceptor
import okhttp3.RequestBody
import okhttp3.Response
import okio.Buffer
import org.apache.commons.lang3.StringUtils
import yyworkshop.com.myassignment.core.AppContext
import yyworkshop.com.myassignment.core.constant.RequestHeaderValue
import java.nio.charset.Charset

/**
 * Title: yyworkshop.com.myassignment.data.RequestInterceptor</br>
 * Description: RequestInterceptor
 *
 * @author chris
 * @version 1.0
 */
class RequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response {

        // Header Parts
        // Fetch request
        val request = chain!!.request()

        // Build the last request
        val requestBuilder = request.newBuilder()
                .addHeader(RequestHeaderValue.X_PARSE_APPLICATION_ID.paramName, RequestHeaderValue.X_PARSE_APPLICATION_ID.value)
                .addHeader(RequestHeaderValue.X_PARSE_REST_API_KEY.paramName, RequestHeaderValue.X_PARSE_REST_API_KEY.value)

        val token = AppContext.getToken()

        if (StringUtils.isNotBlank(token)) {
            requestBuilder.addHeader(RequestHeaderValue.X_Parse_Session_Token.paramName, token)
        }

        // Body Parts
        val requestBody: RequestBody? = request.body()

        requestBuilder.method(request.method(), requestBody)

        return chain.proceed(requestBuilder.build())
    }

}