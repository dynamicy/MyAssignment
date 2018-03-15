package yyworkshop.com.myassignment.service

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import yyworkshop.com.myassignment.core.AppContext
import yyworkshop.com.myassignment.data.RestResourceProvider
import yyworkshop.com.myassignment.service.common.ResponseListener
import yyworkshop.com.myassignment.user.model.TimeZone
import yyworkshop.com.myassignment.user.model.User

/**
 * Title: yyworkshop.com.myassignment.service.UserService<br></br>
 * Description: UserService
 *
 * @author chris
 * @version 1.0
 */
class UserService {

    fun updateUser(timeZone: TimeZone?, listener: ResponseListener<User>) {

        val userResource = RestResourceProvider.userResource()

        var objId: String? = AppContext.getObjectId()

        val call = userResource.updateUser(AppContext.getObjectId(), timeZone)
        call.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.body() != null && response.code().equals(200)) {
                    listener.onResponse(response.body())
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                listener.onError()
            }
        })
    }
}