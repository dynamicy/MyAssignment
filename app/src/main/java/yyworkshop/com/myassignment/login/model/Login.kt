package yyworkshop.com.myassignment.login.model

import java.util.*
import com.google.gson.annotations.SerializedName
import kotlin.collections.HashMap

/**
 * Title: yyworkshop.com.myassignment.login.model.Login<br></br>
 * Description: Login
 *
 * @author chris
 * @version 1.0
 */
data class Login(
        @SerializedName("objectId") val objectId: String,
        @SerializedName("username") val username: String,
        @SerializedName("timezone") val timezone: Long,
        @SerializedName("email") val email: String,
        @SerializedName("code") val code: String,
        @SerializedName("createdAt") val createdAt: String,
        @SerializedName("updatedAt") val updatedAt: String,
        @SerializedName("reportEmail") val reportEmail: String,
        @SerializedName("ACL") val acl: HashMap<String, Any>,
        @SerializedName("sessionToken") val sessionToken: String)

//{
//    "objectId":"WNfAIJO3v6",
//    "username":"test2@qq.com",
//    "timezone":10,
//    "email":"test2@qq.com",
//    "code":"YAH0M2PF",
//    "createdAt":"2018-03-15T03:06:43.411Z",
//    "updatedAt":"2018-03-15T08:28:25.858Z",
//    "reportEmail":"test2@qq.com",
//    "ACL":{
//    "WNfAIJO3v6":{
//        "read":true,
//        "write":true
//    }
//},
//    "sessionToken":"r:063b84667b18b0f6016bf214b08ff361"
//}
