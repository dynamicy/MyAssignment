package yyworkshop.com.myassignment.user.model

import com.google.gson.annotations.SerializedName

/**
 * Title: yyworkshop.com.myassignment.user.model.User<br>
 * Description: User
 *
 * @author chris
 * @version 1.0
 */
data class User(@SerializedName("updatedAt") val updatedAt: String,
                @SerializedName("role") val role: Any)


//{
//    "updatedAt": "2018-03-15T18:18:30.513Z",
//    "role": {
//    "__op": "Delete"
//}
//}