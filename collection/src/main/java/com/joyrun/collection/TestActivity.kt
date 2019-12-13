package com.joyrun.collection

import android.os.Bundle
import androidx.lifecycle.Observer
import com.grouter.RouterActivity
import com.joyrun.base.coroutine.BaseActivity
import com.joyrun.base.coroutine.log
import com.joyrun.base.coroutine.showToast
import com.joyrun.collection.mvvm.WalletViewModel
import kotlinx.android.synthetic.main.collection_desc_activity.*

/**
 * author: wneJie
 * date: 2019-09-30 09:41
 * desc:
 */
@RouterActivity(value = "collection/TestActivity")
class TestActivity : BaseActivity<TestViewModel>() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.collection_desc_activity)


        viewModel.data.observe(this , Observer {
            showToast(it.toString())
        })


        btn_co.setOnClickListener {
            viewModel.login()
        }

    }

    override fun getViewModelClass(): Class<TestViewModel> = TestViewModel::class.java


}