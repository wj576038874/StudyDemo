package com.joyrun.base.entity.collection

import com.joyrun.base.entity.news.NewsInfo

/**
 * author: wneJie
 * date: 2019-09-27 15:36
 * desc:
 */
class TopicWithNews(
    val topic: List<Topic>,
    val news: List<NewsInfo>
)