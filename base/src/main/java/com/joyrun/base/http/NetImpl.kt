package com.joyrun.base.http

import android.text.TextUtils
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.ParameterizedType
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.util.concurrent.TimeUnit

/**
 * author: wneJie
 * date: 2019-09-24 19:03
 * desc:
 */
open class NetImpl<ApiService> {

    protected var mApiService: ApiService

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private var mOkHttpClient: OkHttpClient? = null

    companion object {
        private var mRetrofit: Retrofit? = null
    }

    init {
        initRetrofit()
        this.mApiService = mRetrofit!!.create<ApiService>(getServiceClass())
    }

    private fun initRetrofit() {
        if (mRetrofit != null) return
        // 配置 Retrofit
        mRetrofit = Retrofit.Builder()
            .baseUrl("https://www.wanandroid.com/")
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    private fun getOkHttpClient(): OkHttpClient {
        if (mOkHttpClient == null) {
            val builder: OkHttpClient.Builder = OkHttpClient.Builder()
            builder.addInterceptor(LoggerInterceptor())
            builder.addInterceptor(RequestHeaderInterceptor())
            builder.readTimeout(30, TimeUnit.SECONDS)
            builder.connectTimeout(30, TimeUnit.SECONDS)
            builder.writeTimeout(30, TimeUnit.SECONDS)
            mOkHttpClient = builder.build()
        }
        return mOkHttpClient!!
    }




    @SuppressWarnings("unchecked")
    private fun getServiceClass(): Class<ApiService> {
        return (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<ApiService>
    }


    public fun <T> subscribe(observable: Observable<T>, callback: ResponseCallback<T>) {
        compositeDisposable.add(innerSubscribe(observable, callback))
    }


    private fun <T> innerSubscribe(
        observable: Observable<T>,
        callback: ResponseCallback<T>
    ): Disposable {
        return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .unsubscribeOn(Schedulers.io()).subscribe({
                if (it != null) {
                    callback.success(it)
                } else {
                    callback.error("data is null")
                }
            }, { throwable ->
                val msg: String = when (throwable) {
                    is HttpException -> {
                        when (throwable.code()) {
                            400 -> "手机号或验证码错误"
                            401 ->
                                //启动登录页面
                                "token失效,请重新登录"
                            else -> "请求出错了，错误代码" + throwable.code()
                        }
                    }
                    is SocketTimeoutException -> "请求超时。请稍后重试！"
                    is ConnectException -> "请求超时。请稍后重试！"
                    else -> "请求出错了。请稍后重试！"
                }
                if (!TextUtils.isEmpty(msg)) {
                    callback.error("", msg)
                }
            })
    }

}