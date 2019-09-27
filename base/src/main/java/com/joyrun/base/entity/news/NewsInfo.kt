package com.joyrun.base.entity.news

import com.joyrun.base.entity.login.UserInfo

/**
 * author: wneJie
 * date: 2019-09-24 19:30
 * desc:
 */
data class NewsInfo(

    val id: Int = 0,

    val title: String? = null,

    val created_at: String? = null,

    val updated_at: String? = null,

    val node_name: String? = null,

    val user: UserInfo? = null,

    val node_id: Int = 0,

    val last_reply_user_id: Int = 0,

    val last_reply_user_login: String? = null,

    val replied_at: String? = null,

    val replies_count: Int = 0,
    val address: String? = null
)