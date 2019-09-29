package com.joyrun.collection.mvvm

import android.graphics.Bitmap
import androidx.lifecycle.MutableLiveData
import com.joyrun.base.coroutine.BaseViewModel
import com.joyrun.base.entity.collection.Topic
import com.joyrun.base.entity.collection.TopicWithNews
import com.joyrun.base.entity.login.UserInfo
import com.joyrun.base.http.ResponseResource

/**
 * author: wneJie
 * date: 2019-09-29 09:51
 * desc:
 */
class WalletViewModel(private val walletRepository: WalletRepository = WalletRepository()) : BaseViewModel() {


    val liveData1 = MutableLiveData<ResponseResource<List<Topic>>>()

    val liveData2 = MutableLiveData<ResponseResource<UserInfo>>()

    val liveData3 = MutableLiveData<ResponseResource<TopicWithNews>>()


    val liveDataFile = MutableLiveData<ResponseResource<Bitmap>>()

    fun fun1(){

        loadData<List<Topic>> {
            onStart {
                liveData1.value = ResponseResource.loading()
            }

            request {
                walletRepository.fun1()
            }

            onSuccess {
                liveData1.value = ResponseResource.success(it)
            }

            onError { msg, code ->
                liveData1.value = ResponseResource.error(msg)
            }
        }
    }


    fun fun2(){
        loadData<UserInfo> {

            onStart { liveData2.value = ResponseResource.loading() }
            request { walletRepository.fun2() }
            onSuccess { liveData2.value = ResponseResource.success(it) }
            onError { msg, code -> liveData2.value = ResponseResource.error(msg) }
        }
    }


    fun fun3(){
        loadData<TopicWithNews> {
            onStart { liveData3.value = ResponseResource.loading() }
            request { walletRepository.fun3() }
            onSuccess { liveData3.value = ResponseResource.success(it) }
            onError { msg, code -> liveData3.value = ResponseResource.error(msg) }
        }
    }

    fun fun3_1(){
        loadData<TopicWithNews> {
            onStart { liveData3.value = ResponseResource.loading() }
            request { walletRepository.fun3_1() }
            onSuccess { liveData3.value = ResponseResource.success(it) }
            onError { msg, code -> liveData3.value = ResponseResource.error(msg) }
        }
    }

    fun fun3_2(){
        loadData<TopicWithNews> {
            request {
                walletRepository.fun3_2()
            }
            onSuccess { liveData3.value = ResponseResource.success(it) }
            onError { msg, code -> liveData3.value = ResponseResource.error(msg) }
        }
    }

    fun fun_file(){
        loadData<Bitmap> {
            request { walletRepository.fun_file() }
            onSuccess { liveDataFile.value = ResponseResource.success(it) }
            onError { msg, code -> liveDataFile.value = ResponseResource.error(msg) }
        }
    }

}