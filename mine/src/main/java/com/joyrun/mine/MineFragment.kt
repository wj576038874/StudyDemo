package com.joyrun.mine

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.grouter.GActivityCenter
import com.grouter.RouterComponent
import com.joyrun.base.UserManager
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.mine_fragment_personal.*
import java.lang.Exception

/**
 * author: wneJie
 * date: 2019-09-24 18:10
 * desc:
 */
@RouterComponent(protocol = Fragment::class)
class MineFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.mine_fragment_personal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_1.setOnClickListener {
            GActivityCenter.UserActivity().name("123").start(this)
        }

        btn_4.setOnClickListener {
            UserManager.get().loginout()
            tv_loginstatus.text = if (UserManager.get().getLoginStatus()) {
                "已经登陆"
            } else {
                "未登录"
            }
        }

        btn_2.setOnClickListener {
            GActivityCenter.CollectionActivity().start(this)
        }

        btn_3.setOnClickListener {

            //----------------------------------------------------------
//            val observable1: Observable<String> = Observable.create {
////                Log.e("asd" , "observable1："+Thread.currentThread().name)
////                Thread.sleep(5000)
////                it.onNext("1111")
////                it.onComplete()
////            }
////            val observable2: Observable<String> = Observable.create {
////                Log.e("asd" , "observable2："+Thread.currentThread().name)
////                Thread.sleep(10000)
////                it.onNext("2222")
////                it.onComplete()
////            }
            //----------------------------------------------------------


            //**********************************************************
            //每个子Observable都要加subscribeOn(Schedulers.io())指定为异步线程 不同线程来处理请求达到并发
            val observable1: Observable<String> = Observable.create(ObservableOnSubscribe<String> {
                Log.e("asd" , "observable1："+Thread.currentThread().name)
                Thread.sleep(5000)
                it.onError(Exception("error"))
            }).subscribeOn(Schedulers.io()).onErrorResumeNext(
                ObservableSource { observer ->
                    observer.onNext("observer")
                    observer.onComplete()
//                    observer.onError(Exception("error"))
                })



            val observable2: Observable<String> = Observable.create(ObservableOnSubscribe<String>{
                Log.e("asd" , "observable2："+Thread.currentThread().name)
                Thread.sleep(10000)
                it.onNext("2222")
                it.onComplete()
            }).subscribeOn(Schedulers.io())
            //**********************************************************



            //zip
            val start = System.currentTimeMillis()
            Observable.combineLatest(observable1, observable2,BiFunction<String, String, String> { t1, t2 ->
                    Log.e("asd" , "zip："+Thread.currentThread().name)
                    //这里是两个请求都返回了之后 执行到这里 把数据封装到一个类中返回，这里只是简单的吧他们加起来返回了
                    t1 + t2
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val end = System.currentTimeMillis() - start
                    Log.e("asd" , "请求的数据：${it}---耗时：${end}---observable："+Thread.currentThread().name)
                },{
                    Log.e("asd" , "请求的数据：${it.message}---observable："+Thread.currentThread().name)
                })


            //merge
//            Observable.merge(observable1, observable2).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread()).subscribe (
//                    {
//                        Log.e("asd" , "请求的数据：${it}---observable："+Thread.currentThread().name)
//                    },{
//                        Log.e("asd" , "请求的数据：${it.message}---observable："+Thread.currentThread().name)
//                    }
//                )

        }


    }

//    override fun onResume() {
//        super.onResume()
//        tv_loginstatus.text = if (UserManager.get().getLoginStatus()) {
//            "已经登陆"
//        } else {
//            "未登录"
//        }
//    }
}