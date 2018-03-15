package yyworkshop.com.myassignment.service

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import yyworkshop.com.myassignment.data.RestResourceProvider
import yyworkshop.com.myassignment.login.model.Login
import yyworkshop.com.myassignment.service.common.ResponseListener

/**
 * Title: yyworkshop.com.myassignment.service.SessionService</br>
 * Description: SessionService
 *
 * @author chris
 * @version 1.0
 */
class SessionService {

    fun doLogin(listener: ResponseListener<Login>) {

        val sessionResource = RestResourceProvider.sessionResource()

        val call = sessionResource.login()
        call.enqueue(object : Callback<Login> {
            override fun onResponse(call: Call<Login>, response: Response<Login>) {
                val res = response.body()!!.toString()
                val temp = res
            }

            override fun onFailure(call: Call<Login>, t: Throwable) {
                listener.onError()
            }
        })
    }
}