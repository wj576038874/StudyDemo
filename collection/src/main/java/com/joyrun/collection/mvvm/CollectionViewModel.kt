package com.joyrun.collection.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.joyrun.base.coroutine.BaseViewModel
import com.joyrun.base.coroutine.RetrofitHelper
import com.joyrun.base.entity.login.UserInfo
import com.joyrun.base.http.ResponseResource
import com.joyrun.base.entity.collection.Topic
import com.joyrun.base.entity.collection.TopicWithNews
import com.joyrun.base.entity.news.NewsInfo
import com.joyrun.collection.CollectionApi
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 * author: wneJie
 * date: 2019-09-25 16:03
 * desc:使用协程集合retrofit请求接口返回数据 并做异常处理
 */
class CollectionViewModel(private val collectionModel: CollectionModel = CollectionModel()) :
    BaseViewModel() {


    val mutableLiveData = MutableLiveData<ResponseResource<List<Topic>>>()

    val userInfoLiveData = MutableLiveData<ResponseResource<UserInfo>>()

    val data = MutableLiveData<ResponseResource<TopicWithNews>>()


    fun get(login: String) {
        collectionModel.getTopis(login, mutableLiveData)
    }


    fun get2(login: String) {


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

    fun login() {
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


    /**
     * 结构化并发 实现请求并发处理
     */
    fun getTopicWithNews() {
        loadData<TopicWithNews> {

            onStart {
                mutableLiveData.value = ResponseResource.loading()
            }

            request {
                collectionModel.getTopicWithNews()
            }

            onSuccess {
                data.value = ResponseResource.success(it)
            }


            onError { msg, _ ->
                data.value = ResponseResource.error(msg)
            }
        }
    }


}