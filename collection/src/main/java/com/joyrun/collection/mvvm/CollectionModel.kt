package com.joyrun.collection.mvvm

import androidx.lifecycle.MutableLiveData
import com.joyrun.base.exceptionHandler
import com.joyrun.base.http.NetImpl
import com.joyrun.base.http.ResponseResource
import com.joyrun.base.coroutine.RetrofitHelper
import com.joyrun.base.entity.login.UserInfo
import com.joyrun.collection.CollectionApi
import com.joyrun.base.entity.collection.Topic
import com.joyrun.base.entity.collection.TopicWithNews
import kotlinx.coroutines.*


/**
 * author: wneJie
 * date: 2019-09-25 16:03
 * desc:
 */
class CollectionModel : NetImpl<CollectionApi>() {

    fun getTopis(login: String, mutableLiveData: MutableLiveData<ResponseResource<List<Topic>>>) {
        MainScope().launch(exceptionHandler) {

            try {

                mutableLiveData.value = ResponseResource.success(mApiService.getTopics(login))

            } catch (e: Exception) {
                e.printStackTrace()

            }
        }

    }


    suspend fun getTopicList(login: String): List<Topic> {
        return RetrofitHelper.getApiService(CollectionApi::class.java).getTopics(login)
    }


    suspend fun login(): UserInfo {
        val api = RetrofitHelper.getApiService(CollectionApi::class.java)
        api.getToken("", "", "password", "wj576038874", "1rujiwang")
        return api.getMe()
    }


    suspend fun getTopicWithNews(): TopicWithNews {
        val api = RetrofitHelper.getApiService(CollectionApi::class.java)
        //coroutineScope async结构化并发
        //特点 数据返回时保证所有的子协程都会执行完毕 不会造成泄漏
        return coroutineScope {
            val news = async { api.getNewsList(1,20) }
            val topics = async { api.getTopics("wj576038874") }
            TopicWithNews(topics.await() , news.await())
        }
    }





//    private  suspend fun suspendingMerge(news: Deferred<List<NewsInfo>>, topics: Deferred<List<Topic>>): TopicWithNews {
//        return TopicWithNews(topics.await() , news.await())
//    }


//    suspend fun getUserCoroutine() = suspendCoroutine<String> {
//            continuation ->
//        getUser(object : ResponseCallback<String>(){
//            override fun success(data: String) {
//                continuation.resume(data)
//            }
//
//            override fun error(msg: String?) {
//               continuation.resumeWithException(Exception(msg))
//            }
//        })
//    }
//
//    private fun getUser(callback: ResponseCallback<String>){
//        mApiService.getTopics("")
//    }

}