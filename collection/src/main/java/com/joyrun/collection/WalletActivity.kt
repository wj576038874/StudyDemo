package com.joyrun.collection

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProviders
import com.grouter.RouterActivity
import com.joyrun.base.coroutine.log
import com.joyrun.base.coroutine.showToast
import com.joyrun.base.entity.collection.Topic
import com.joyrun.base.entity.collection.TopicWithNews
import com.joyrun.base.entity.login.UserInfo
import com.joyrun.base.http.ResponseCallback
import com.joyrun.collection.mvvm.WalletViewModel
import kotlinx.android.synthetic.main.collection_desc_activity.*
import kotlinx.coroutines.*
import java.io.File

@RouterActivity(value = "collection/WalletActivity", exported = false)
class WalletActivity : AppCompatActivity() {
    private lateinit var job:Job
    private lateinit var walletViewModel: WalletViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.collection_desc_activity)

        walletViewModel = ViewModelProviders.of(this).get(WalletViewModel::class.java)



        btn_pt.setOnClickListener {
            walletViewModel.fun1()
        }

        btn_login.setOnClickListener {
            walletViewModel.fun2()
        }

        btn_async.setOnClickListener {
            walletViewModel.fun3_2()
        }

        btn_file.setOnClickListener {
            walletViewModel.fun_file()
        }

        btn_co.setOnClickListener {
            test()
        }


        walletViewModel.liveData1.observe(this, object : ResponseCallback<List<Topic>>() {

            override fun success(data: List<Topic>) {
                showToast(data.size.toString())
                for (item in data) {
                    item.toString().log()
                }
            }

            override fun error(msg: String?) {
                showToast(msg)
                msg.log()
            }

        })

        walletViewModel.liveData2.observe(this, object : ResponseCallback<UserInfo>() {


            override fun success(data: UserInfo) {
                showToast(data.toString())
                data.log()
            }

            override fun error(msg: String?) {
                showToast(msg)
                msg.log()
            }

        })


        walletViewModel.liveData3.observe(this, object : ResponseCallback<TopicWithNews>() {

            override fun success(data: TopicWithNews) {
                showToast(data.news.size.toString())
                for (item in data.news) {
                    item.log()
                }

            }

            override fun error(msg: String?) {
                showToast(msg)
                msg.log()
            }

        })

        walletViewModel.liveDataFile.observe(this , object : ResponseCallback<Bitmap>() {

            override fun success(data: Bitmap) {
                img.setImageBitmap(data)
            }

            override fun error(msg: String?) {
                showToast(msg)
                msg.log()
            }

        })

    }

    fun test(){//asnyc
//        MainScope().launch {  }
//        GlobalScope.launch {
//            "thread 1${Thread.currentThread().name}".log()
//            launch(Dispatchers.Main) {
//                "thread 2${Thread.currentThread().name}".log()
//            }
//        }

//        GlobalScope.launch(Dispatchers.Main) {
//            "thread 3${Thread.currentThread().name}".log()
//            val str = get()
//            btn_co.text = str
//            "thread 4${Thread.currentThread().name}".log()
//        }


//        GlobalScope.launch {
//            Log.e("asd1" , System.currentTimeMillis().toString()+"")
//            val s = async { get2() }//De
//            val ss = async {get2() }
//            Log.e("asd2" , System.currentTimeMillis().toString()+"")
////            val s2 = s.await()+ss.await()
////            Log.e("asd3" , System.currentTimeMillis().toString()+"")
////            btn_co.text = s2
//        }

        job = MainScope().launch (Dispatchers.IO){
            delay(5000)

            Toast.makeText(this@WalletActivity , "111",Toast.LENGTH_SHORT).show()
        }

//        get()
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

    suspend fun ss(){
        withContext(Dispatchers.IO){

        }
        withContext(Dispatchers.IO){

        }
        withContext(Dispatchers.IO){

        }
        withContext(Dispatchers.IO){

        }
    }

    suspend fun get():String{
        return withContext(Dispatchers.IO){
            "thread 5${Thread.currentThread().name}".log()
            "111111"
        }
    }


    suspend fun get2():String{
        return withContext(Dispatchers.IO){
            "print".log()
            delay(1000)
            "222222"
        }
    }
}
