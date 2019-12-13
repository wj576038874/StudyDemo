package com.joyrun.collection

import androidx.lifecycle.MutableLiveData
import com.joyrun.base.coroutine.BaseViewModel
import com.joyrun.base.entity.login.UserInfo

/**
 * author: wneJie
 * date: 2019-09-30 10:09
 * desc:
 */

class TestViewModel(private val testRepository: TestRepository = TestRepository()) : BaseViewModel(){

    val data = MutableLiveData<UserInfo>()

    fun login(){
//        loadData2 {
//            data.value = testRepository.login()
//        }
    }

}