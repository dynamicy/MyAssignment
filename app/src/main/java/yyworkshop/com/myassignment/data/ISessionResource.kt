package yyworkshop.com.myassignment.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import yyworkshop.com.myassignment.login.model.Login

/**
 * Title: yyworkshop.com.myassignment.data.ISessionResource<br></br>
 * Description: ISessionResource
 *
 * @author chris
 * @version 1.0
 */
interface ISessionResource {

    @GET("login")
    fun login(@Query("username") account: String, @Query("password") password: String): Call<Login>

}