package yyworkshop.com.myassignment.login.model

import java.util.*

/**
 * Title: yyworkshop.com.myassignment.login.model.Login<br></br>
 * Description: Login
 *
 * @author chris
 * @version 1.0
 */
data class Login(val objectId: String,
                 val username: String,
                 val timezone: Int,
                 val email: String,
                 val code: String,
                 val createdAt: Date,
                 val updatedAt: Date,
                 val reportEmail: String,
                 val ACL: ACL,
                 val sessionToken: String)


//{
//    "objectId":"WNfAIJO3v6",
//    "username":"test2@qq.com",
//    "timezone":10,
//    "email":"test2@qq.com",
//    "code":"YAH0M2PF",
//    "createdAt":"2018-03-15T03:06:43.411Z",
//    "updatedAt":"2018-03-15T03:07:02.405Z",
//    "reportEmail":"test2@qq.com",
//    "ACL":{
//        "WNfAIJO3v6":{
//        "read":true,
//        "write":true
//        }
//    },
//    "sessionToken":"r:4c4975eb8b07b401970acb47069ebb57"
//}