package com.joyrun.collection.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joyrun.base.coroutine.RetrofitHelper
import com.joyrun.base.coroutine.loadData
import com.joyrun.base.entity.login.UserInfo
import com.joyrun.base.http.ResponseResource
import com.joyrun.base.entity.collection.Topic
import com.joyrun.base.entity.collection.TopicWithNews
import com.joyrun.base.entity.news.NewsInfo
import com.joyrun.collection.CollectionApi
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 * author: wneJie
 * date: 2019-09-25 16:03
 * desc:
 */
class CollectionViewModel(private val collectionModel: CollectionModel = CollectionModel()) :
    ViewModel() {


    val mutableLiveData = MutableLiveData<ResponseResource<List<Topic>>>()

    val userInfoLiveData = MutableLiveData<ResponseResource<UserInfo>>()

    val data = MutableLiveData<ResponseResource<TopicWithNews>>()


    fun get(login: String) {
        collectionModel.getTopis(login, mutableLiveData)
    }


    fun get2(login: String){

        loadData<List<Topic>> {
            onStart {
                mutableLiveData.value = ResponseResource.loading()
            }

            request {
                collectionModel.getTopicList(login)
            }

            onSuccess {
                mutableLiveData.value = ResponseResource.success(it)
            }

            onError { msg, _ ->
                mutableLiveData.value = ResponseResource.error(msg)
            }
        }
    }

    fun login(){
        loadData<UserInfo> {

            onStart {
                mutableLiveData.value = ResponseResource.loading()
            }

            request {
                collectionModel.login()
            }

            onSuccess {
                userInfoLiveData.value = ResponseResource.success(it)
            }

            onError { msg, _ ->
                userInfoLiveData.value = ResponseResource.error(msg)
            }
        }
    }

    fun getTopicWithNews(){
        viewModelScope.launch {
            val api = RetrofitHelper.getApiService(CollectionApi::class.java)
            val news = async { api.getNewsList(1,20) }
            val topics = async { api.getTopics("wj576038874") }
            val result = suspendingMerge(news ,topics)
            data.value = ResponseResource.success(result)
        }
    }

    private  suspend fun suspendingMerge(news: Deferred<List<NewsInfo>>, topics: Deferred<List<Topic>>): TopicWithNews {
        return TopicWithNews(topics.await() , news.await())
    }

}