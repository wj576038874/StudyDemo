package com.joyrun.base.entity.login

import java.io.Serializable

/**
 * author: wneJie
 * date: 2019-09-25 12:13
 * desc:
 */

data class UserInfo(
    val id: Int = 0   ,          // 唯一 id
    val login: String? = null  ,     // 登录用户名
    val name: String? = null   ,     // 昵称
    val avatar_url: String? = null  // 头像链接
) : Serializable