package com.joyrun.collection.mvvm

import androidx.lifecycle.MutableLiveData
import com.joyrun.base.core.result
import com.joyrun.base.exceptionHandler
import com.joyrun.base.http.NetImpl
import com.joyrun.base.http.ResponseResource
import com.joyrun.base.coroutine.RetrofitHelper
import com.joyrun.base.entity.login.UserInfo
import com.joyrun.collection.CollectionApi
import com.joyrun.base.entity.collection.Topic
import com.joyrun.base.entity.collection.TopicContent
import com.joyrun.base.entity.collection.TopicWithNews
import com.joyrun.base.entity.news.NewsInfo
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


    fun getTopicWithNews(mutableLiveData: MutableLiveData<ResponseResource<TopicWithNews>>){
        GlobalScope.launch {
            val api = RetrofitHelper.getApiService(CollectionApi::class.java)
            val news = async { api.getNewsList(1,20) }
            val topics = async { api.getTopics("wj576038874") }
            val result = suspendingMerge(news ,topics)
            mutableLiveData.value = ResponseResource.success(result)
        }
    }

    private  suspend fun suspendingMerge(news: Deferred<List<NewsInfo>>, topics: Deferred<List<Topic>>): TopicWithNews {
        return TopicWithNews(topics.await() , news.await())
    }


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