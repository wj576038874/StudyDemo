package com.joyrun.base.entity.login

/**
 * author: wneJie
 * date: 2019-09-25 12:02
 * desc:
 */
data class Token(
    val access_token: String,     // 用户令牌(获取相关数据使用)
    val token_type: String,       // 令牌类型
    val expires_in: Int,          // 过期时间
    val refresh_token: String,    // 刷新令牌(获取新的令牌)
    val created_at: Int
)