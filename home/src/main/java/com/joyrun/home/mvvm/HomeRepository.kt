package com.joyrun.home.mvvm

import com.joyrun.base.http.NetImpl
import com.joyrun.base.http.ResponseCallback
import com.joyrun.home.api.HomeApi
import com.joyrun.base.entity.home.GankIoWelfareListBean
import kotlinx.coroutines.*

/**
 * author: wneJie
 * date: 2019-09-25 10:49
 * desc:
 */
class HomeRepository : NetImpl<HomeApi>() {

    fun getData(responseCallback: ResponseCallback<GankIoWelfareListBean>){
        subscribe(mApiService.getData() , object : ResponseCallback<GankIoWelfareListBean>(){
            override fun success(data: GankIoWelfareListBean) {
                responseCallback.success(data)
            }

            override fun error(msg: String?) {
                responseCallback.error(msg)
            }
        })
    }

//    fun getdata2(responseCallback: ResponseCallback<GankIoWelfareListBean>){
//        val mainScope = MainScope()
//        mainScope.launch(Dispatchers.Main){
//            val datas = mApiService.getData2()
//            responseCallback.success(datas)
//        }
//    }
}