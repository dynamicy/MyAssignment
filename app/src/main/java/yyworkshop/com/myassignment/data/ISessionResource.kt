package yyworkshop.com.myassignment.data

import retrofit2.Call
import retrofit2.http.GET
import yyworkshop.com.myassignment.login.model.Login

/**
 * Title: yyworkshop.com.myassignment.data.ISessionResource<br></br>
 * Description: ISessionResource
 *
 * @author chris
 * @version 1.0
 */
interface ISessionResource {

//    https://watch-master-staging.herokuapp.com/api/login

    @GET("login")
    fun login(): Call<Login>

}