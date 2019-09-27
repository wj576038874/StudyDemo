package com.joyrun.base.coroutine


import android.content.Context
import android.util.Log

/**
 * author: wneJie
 * date: 2019-09-27 14:34
 * desc:
 */

fun showToast(msg: String?) {
    ToastUtils.showToast(msg)
}

fun Any.log() {
    Log.e("asd" , this.toString())
}

fun dip2px(context: Context, dpValue: Float): Int {
    val scale = context.resources.displayMetrics.density
    return (dpValue * scale + 0.5f).toInt()
}