package com.joyrun.home.mvvm

import androidx.lifecycle.MutableLiveData
import com.joyrun.base.http.ResponseCallback
import com.joyrun.base.http.ResponseResource
import com.joyrun.base.entity.home.GankIoWelfareListBean
import com.joyrun.base.entity.home.WelfareInfo

/**
 * author: wneJie
 * date: 2019-09-25 10:48
 * desc:
 */
class HomeModel(private val homeRepository: HomeRepository = HomeRepository()) {

    fun getData(mutableLiveData: MutableLiveData<ResponseResource<List<WelfareInfo>>>){
        homeRepository.getData(object : ResponseCallback<GankIoWelfareListBean>(){
            override fun success(data: GankIoWelfareListBean) {
                mutableLiveData.value = ResponseResource.success(data.results)
            }

            override fun error(msg: String?) {
                mutableLiveData.value = ResponseResource.error(msg)
            }
        })
    }

    fun getdata2(mutableLiveData: MutableLiveData<ResponseResource<List<WelfareInfo>>>){
        homeRepository.getdata2(object : ResponseCallback<GankIoWelfareListBean>(){
            override fun success(data: GankIoWelfareListBean) {
                mutableLiveData.value = ResponseResource.success(data.results)
            }

            override fun error(msg: String?) {
                mutableLiveData.value = ResponseResource.error(msg)
            }
        })
    }

}