package yyworkshop.com.myassignment.data

import yyworkshop.com.myassignment.core.AppContext
import java.util.concurrent.ConcurrentHashMap

/**
 * Title: yyworkshop.com.myassignment.data.RestResourceProvider</br>
 * Description: RestResourceProvider
 *
 * @author chris
 * @version 1.0
 */
object RestResourceProvider {

    private var resourceMap: ConcurrentHashMap<String, Any>? = null

    init {
        setup()
    }

    fun setup() {
        resourceMap = ConcurrentHashMap<String, Any>()

        resetHost()
    }

    fun resetHost() {
        val host = AppContext.host

        RestResourceFactory.setBaseUrl(host!!)
        resourceMap!!.clear()
    }

    fun sessionResource(): ISessionResource {
        return createService<ISessionResource>(ISessionResource::class.java) as ISessionResource
    }

    private fun <S> createService(serviceClass: Class<S>): Any? {

        return if (resourceMap!!.contains(serviceClass.simpleName)) {
            resourceMap!!.get(serviceClass.simpleName)
        } else {
            RestResourceFactory.createService(serviceClass)
        }
    }
}