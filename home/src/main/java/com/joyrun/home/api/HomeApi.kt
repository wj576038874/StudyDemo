package com.joyrun.home.api

import com.joyrun.base.entity.home.GankIoWelfareListBean
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * author: wneJie
 * date: 2019-09-25 10:49
 * desc:
 */
interface HomeApi {

    @GET("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/100/1")
    fun getData() : Observable<GankIoWelfareListBean>

    @GET("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/100/1")
    suspend fun getData2() : GankIoWelfareListBean
}