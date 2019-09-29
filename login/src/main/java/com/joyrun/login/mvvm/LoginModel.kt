package com.joyrun.login.mvvm

import androidx.lifecycle.MutableLiveData
import com.joyrun.base.entity.login.UserInfo
import com.joyrun.base.http.ResponseCallback
import com.joyrun.base.http.ResponseResource
import retrofit2.Response

/**
 * author: wneJie
 * date: 2019-09-25 12:01
 * desc:
 */
class LoginModel(private val loginRepository: LoginRepository = LoginRepository()) {

    fun login(mutableLiveData: MutableLiveData<ResponseResource<UserInfo>>){
        loginRepository.login(object : ResponseCallback<Response<UserInfo>>(){
            override fun success(data: Response<UserInfo>) {
                //业务处理
                if (data.isSuccessful){
                    data.body()?.let {
                        mutableLiveData.value = ResponseResource.success(it)
                    }?:let {
                        mutableLiveData.value = ResponseResource.error("body is null")
                    }
                }else{
                    mutableLiveData.value = ResponseResource.error(data.message())
                }
            }

            override fun error(msg: String?) {
                mutableLiveData.value = ResponseResource.error(msg)
            }

        })
    }


//    fun login2(mutableLiveData: MutableLiveData<ResponseResource<UserInfo>>){
//        loginRepository.login2(object : ResponseCallback<Response<UserInfo>>(){
//            override fun success(data: Response<UserInfo>) {
//                //业务处理
//                if (data.isSuccessful){
//                    data.body()?.let {
//                        mutableLiveData.value = ResponseResource.success(it)
//                    }?:let {
//                        mutableLiveData.value = ResponseResource.error("body is null")
//                    }
//                }else{
//                    mutableLiveData.value = ResponseResource.error(data.message())
//                }
//            }
//
//            override fun error(msg: String?) {
//                mutableLiveData.value = ResponseResource.error(msg)
//            }
//
//        })
//    }
}