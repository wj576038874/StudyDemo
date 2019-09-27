package com.joyrun.base.http

/**
 * author: wneJie
 * date: 2019-09-27 12:43
 * desc:  结果集包装类 具体看接口文档的规定字段
 */

data class BaseResponse<T>(
    var data: T,
    var errorMsg: String,
    var errorCode: Int
)