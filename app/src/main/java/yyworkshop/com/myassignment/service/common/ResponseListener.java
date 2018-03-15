package yyworkshop.com.myassignment.service.common;

/**
 * Title: yyworkshop.com.myassignment.service.SessionService<br></br>
 * Description: SessionService
 *
 * @author chris
 * @version 1.0
 */
public interface ResponseListener<T> {

    void onResponse(T data);

    void onError();
}
