package com.joyrun.base.coroutine

import com.joyrun.base.http.LoggerInterceptor
import com.joyrun.base.http.RequestHeaderInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * author: wneJie
 * date: 2019-09-26 15:00
 * desc:
 */

object RetrofitHelper {
    private var mRetrofit: Retrofit? = null

    private var mOkHttpClient: OkHttpClient? = null


    fun <ApiService> getApiService(service: Class<ApiService>): ApiService {

        return getRetrofit().create(service)

    }

    private fun getRetrofit(): Retrofit {

        return mRetrofit?.let {
            return it
        } ?: let {
            mRetrofit = Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com/")
                .client(getOkHttpClient())// 配置 Retrofit
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
            return mRetrofit!!
        }
    }

    private fun getOkHttpClient(): OkHttpClient {

        return mOkHttpClient?.let {
            return it
        } ?: let {
            val builder: OkHttpClient.Builder = OkHttpClient.Builder()
            builder.addInterceptor(LoggerInterceptor())
            builder.addInterceptor(RequestHeaderInterceptor())
            builder.readTimeout(30, TimeUnit.SECONDS)
            builder.connectTimeout(30, TimeUnit.SECONDS)
            builder.writeTimeout(30, TimeUnit.SECONDS)
            mOkHttpClient = builder.build()
            return mOkHttpClient!!
        }

    }


}