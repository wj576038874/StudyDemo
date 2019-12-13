package com.joyrun.base.coroutine

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders

/**
 * author: wneJie
 * date: 2019-09-30 09:20
 * desc:
 */

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {

    protected lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(getViewModelClass())
    }


    abstract fun getViewModelClass(): Class<VM>

}