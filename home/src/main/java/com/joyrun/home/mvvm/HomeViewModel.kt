package com.joyrun.home.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.joyrun.base.http.ResponseResource
import com.joyrun.base.entity.home.WelfareInfo

/**
 * author: wneJie
 * date: 2019-09-25 10:48
 * desc:
 */
class HomeViewModel(private val homeModel: HomeModel = HomeModel()) : ViewModel() {

    var mutableLiveData: MutableLiveData<ResponseResource<List<WelfareInfo>>> = MutableLiveData()

    var mutableLiveData2: MutableLiveData<ResponseResource<List<WelfareInfo>>> = MutableLiveData()

    fun getData() {
        homeModel.getData(1,mutableLiveData)
    }


    fun getpage(page:Int){
        homeModel.getData(page,mutableLiveData2)
    }

//    fun getdata2(){
//        homeModel.getdata2(mutableLiveData)
//    }

}