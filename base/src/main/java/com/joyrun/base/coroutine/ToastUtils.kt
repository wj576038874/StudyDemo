package com.joyrun.base.coroutine


import android.widget.Toast

import com.joyrun.base.BaseApplication

/**
 * author: wneJie
 * date: 2019-09-27 14:34
 * desc:
 */

object ToastUtils {

    private var oldMsg: String? = null
    private var toast: Toast? = null
    private var oneTime: Long = 0
    private var twoTime: Long = 0

    /**
     * 吐出一个显示时间较短的提示
     *
     * @param s 文本内容
     */
    fun showToast(s: String?) {
        if (toast == null) {
            toast = Toast.makeText(BaseApplication.globalApplicationContext, s, Toast.LENGTH_SHORT)
            toast?.show()
            oneTime = System.currentTimeMillis()
        } else {
            twoTime = System.currentTimeMillis()
            if (s == oldMsg) {
                if (twoTime - oneTime > Toast.LENGTH_SHORT) {
                    toast?.show()
                }
            } else {
                oldMsg = s
                toast?.setText(s)
                toast?.show()
            }
        }
        oneTime = twoTime
    }
}

