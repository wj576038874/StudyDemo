package com.joyrun.wechat.mvvm

import androidx.lifecycle.MutableLiveData
import com.joyrun.base.entity.news.NewsInfo
import com.joyrun.base.http.ResponseCallback
import com.joyrun.base.http.ResponseResource

/**
 * author: wneJie
 * date: 2019-09-25 09:21
 * desc:
 */
class NewsModel(private val newsRepository: NewsRepository = NewsRepository()) {


    fun getNews(mutableLiveData: MutableLiveData<ResponseResource<List<NewsInfo>>>){
        newsRepository.getNewslist(0,50,object : ResponseCallback<List<NewsInfo>>(){

            override fun success(data: List<NewsInfo>) {
                mutableLiveData.value = ResponseResource.success(data)
            }

            override fun error(msg: String?) {
                mutableLiveData.value = ResponseResource.error(msg)
            }

        })
    }


}