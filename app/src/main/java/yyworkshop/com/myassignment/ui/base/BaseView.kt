package yyworkshop.com.myassignment.ui.base

/**
 * Title: yyworkshop.com.myassignment.ui.base.BaseView<br>
 * Description: BaseView
 *
 * @author chris
 * @version 1.0
 */
interface BaseView<T> {
    fun setPresenter(presenter: T)
}