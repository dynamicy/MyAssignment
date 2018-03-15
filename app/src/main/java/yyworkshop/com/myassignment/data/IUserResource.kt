package yyworkshop.com.myassignment.data

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.PUT
import retrofit2.http.Path
import yyworkshop.com.myassignment.user.model.TimeZone
import yyworkshop.com.myassignment.user.model.User


/**
 * Title: yyworkshop.com.myassignment.data.IUserResource<br></br>
 * Description: IUserResource
 *
 * @author chris
 * @version 1.0
 */
interface IUserResource {

    //    https://watch-master-staging.herokuapp.com/api/users/WNfAIJO3v6

    @PUT("users/{objectId}")
    fun updateUser(@Path("objectId") objectId: String?, @Body timezone: TimeZone?): Call<User>
}