package yyworkshop.com.myassignment.login.view

import android.widget.EditText

/**
 * Title: yyworkshop.com.myassignment.login.view<br></br>
 * Description: ILoginView
 *
 * @author chris
 * @version 1.0
 */
interface ILoginView {

    fun getAccountdText(): String?

    fun getPasswordText(): String?

    fun gotoUserActivity()

}
