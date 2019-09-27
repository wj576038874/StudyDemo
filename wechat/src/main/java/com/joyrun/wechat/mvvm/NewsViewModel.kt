package com.joyrun.wechat.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.joyrun.base.entity.news.NewsInfo
import com.joyrun.base.http.ResponseResource

/**
 * author: wneJie
 * date: 2019-09-25 09:20
 * desc:
 */
class NewsViewModel(private val newsModel: NewsModel = NewsModel()) : ViewModel() {


    var mutableLiveData: MutableLiveData<ResponseResource<List<NewsInfo>>> = MutableLiveData()

    fun getNews() {
        newsModel.getNews(mutableLiveData)
    }

}