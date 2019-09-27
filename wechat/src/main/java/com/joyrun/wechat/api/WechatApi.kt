package com.joyrun.wechat.api

import com.joyrun.base.entity.news.NewsInfo
import com.joyrun.base.entity.wechat.WxArticleBean
import com.joyrun.base.http.BaseResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * author: wneJie
 * date: 2019-09-25 09:21
 * desc:
 */
interface WechatApi {


    /**
     * 获取 news 列表
     *
     * @param node_id 如果你需要只看某个节点的，请传此参数, 如果不传 则返回全部
     * @param offset  偏移数值，默认值 0
     * @param limit   数量极限，默认值 20，值范围 1..150
     * @see GetNewsListEvent
     */
    @GET("https://diycode.cc/api/v3/news.json")
    fun getNewsList(@Query("offset") offset: Int?, @Query("limit") limit: Int?): Observable<List<NewsInfo>>


    @GET("wxarticle/chapters/json")
    fun getWxlist() : Observable<BaseResponse<WxArticleBean>>

}