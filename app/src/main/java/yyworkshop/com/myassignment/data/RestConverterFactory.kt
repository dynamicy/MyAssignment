package yyworkshop.com.myassignment.data

import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

/**
 * Title: yyworkshop.com.myassignment.data.RestConverterFactory</br>
 * Description: RestConverterFactory
 *
 * @author chris
 * @version 1.0
 */
object RestConverterFactory : Converter.Factory() {
    private val MEDIA_TYPE = MediaType.parse("text/plain")

    override fun responseBodyConverter(type: Type?, annotations: Array<Annotation>?, retrofit: Retrofit?): Converter<ResponseBody, *>? {

        if (String::class.equals(type)) {
            return { value: Converter<ResponseBody, String> -> value.toString() } as Converter<ResponseBody, String>
        } else {
            return null
        }
    }

    override fun requestBodyConverter(type: Type?, parameterAnnotations: Array<Annotation>?, methodAnnotations: Array<Annotation>?, retrofit: Retrofit?): Converter<*, RequestBody>? {
        if (String::class.equals(type)) {
            return { value: Converter<ResponseBody, String> -> RequestBody.create(MEDIA_TYPE, value as String) } as Converter<String, RequestBody>
        } else {
            return null
        }
    }
}