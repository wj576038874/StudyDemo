package com.joyrun.collection.mvvm

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Environment
import android.widget.ImageView
import com.joyrun.base.UserManager
import com.joyrun.base.coroutine.RetrofitHelper
import com.joyrun.base.coroutine.log
import com.joyrun.base.entity.collection.Topic
import com.joyrun.base.entity.collection.TopicWithNews
import com.joyrun.base.entity.login.UserInfo
import com.joyrun.collection.CollectionApi
import kotlinx.coroutines.*
import java.io.File
import java.lang.Exception

/**
 * author: wneJie
 * date: 2019-09-29 09:53
 * desc:  launch  async并发  作用域
 */
class WalletRepository(private val api: CollectionApi = RetrofitHelper.getApiService(CollectionApi::class.java)) {


    /**
     * 普通请求
     */
    suspend fun fun1(): List<Topic> {
        return api.getTopics("wj576038874")
    }


    suspend fun test(){
        try {
            val result = api.getTopics("")
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    /**
     * 连续请求 ->登录
     */
    suspend fun fun2(): UserInfo {
        val token = api.getToken("", "", "password", "wj576038874", "1rujiwang")
        UserManager.get().saveToken(token.access_token)
        return api.getMe()
    }

    /**
     * 并发请求
     * coroutineScope+async 结构化并发  调用await()方法可以获取异常  当其中任何一个子协程出现异常的时候  会取消所有的协程
     */
    suspend fun fun3(): TopicWithNews {

        return coroutineScope {
            val topicList = async { api.getTopics("j576038874") }
            val newsList = async { api.getNewsList(1, 30) }
            println("The answer is ${topicList.await() + newsList.await()}")
            TopicWithNews(topicList.await(), newsList.await())
        }
    }

    /**
     * supervisorScope 结构化并发 调用await()方法可以获取异常 ，当其中一个任何子协程出现异常， 不会取消其他的子协程
     *
     */
    suspend fun fun3_1(): TopicWithNews {
        return supervisorScope {
            val topicList = async {
                api.getTopics("j576038874")
            }
            val newsList = async {
                api.getNewsList(1, 30)
            }

            TopicWithNews(topicList.await(), newsList.await())
        }
    }

    /**
     * 不推荐这种  因为retrofit的挂机函数已经是做了线程切换来保证主线程安全 我们没必要在切换一次 这样只会浪费资源
     */
    suspend fun fun3_2(): TopicWithNews {

//        val topicList = withContext(Dispatchers.IO) {
//            api.getTopics("wj576038874")
//        }
//
//        val newsList = withContext(Dispatchers.IO) {
//            api.getNewsList(1, 30)
            //dbflow
//        }
//
        val topicList = api.getTopics("wj576038874")
        val newsList = api.getNewsList(1, 30)

        return TopicWithNews(topicList, newsList)
    }

    /**
     * 读取文件 耗时操作
     */
    suspend fun fun_file(): Bitmap {

        return withContext(Dispatchers.Main) {
            Thread.currentThread().name.log()
            val file = File(Environment.getExternalStorageDirectory(), "img.jpg")
            withContext(Dispatchers.IO){
                Thread.currentThread().name.log()
                BitmapFactory.decodeFile(file.absolutePath)
            }
        }

    }

    suspend fun getFile(){
        withContext(Dispatchers.IO){
            //
        }
        GlobalScope.launch {  }
        GlobalScope.async {  }

    }


    suspend fun aa(){

        val imgview =ImageView(null)
        GlobalScope.launch {
            val file = File(Environment.getExternalStorageDirectory(), "img.jpg")
            val bitmap = withContext(Dispatchers.IO){
                val file = File(Environment.getExternalStorageDirectory(), "img.jpg")
                BitmapFactory.decodeFile(file.absolutePath)
            }
            MainScope().launch {

            }
            imgview.setImageBitmap(bitmap)

        }
    }


}