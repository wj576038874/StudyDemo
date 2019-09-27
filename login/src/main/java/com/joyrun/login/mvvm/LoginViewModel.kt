package com.joyrun.login.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.joyrun.base.entity.login.UserInfo
import com.joyrun.base.http.ResponseResource

/**
 * author: wneJie
 * date: 2019-09-25 12:01
 * desc:
 */
class LoginViewModel(private val loginModel: LoginModel = LoginModel()) : ViewModel() {


    val mutableLiveData = MutableLiveData<ResponseResource<UserInfo>>()

    fun login() {
        loginModel.login(mutableLiveData)
    }

    fun login2(){
        loginModel.login2(mutableLiveData)
    }
}