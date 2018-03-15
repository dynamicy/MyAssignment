package yyworkshop.com.myassignment.core.constant

/**
 * Title: yyworkshop.com.myassignment.core.constant.RequestHeaderValue
 * Description: RequestHeaderValue
 *
 * @author chris
 * @version 1.0
 */
enum class RequestHeaderValue(val paramName: String, val value: String) {

    X_PARSE_APPLICATION_ID("X-Parse-Application-Id", "vqYuKPOkLQLYHhk4QTGsGKFwATT4mBIGREI2m8eD"),
    X_PARSE_REST_API_KEY("X-Parse-REST-API-Key", ""),
    AUTHORIZATION("Authorization", "")
}
