package com.joyrun.collection

import com.joyrun.base.entity.login.Token
import com.joyrun.base.entity.login.UserInfo
import com.joyrun.base.entity.collection.Topic
import com.joyrun.base.entity.collection.TopicContent
import com.joyrun.base.entity.news.NewsInfo
import io.reactivex.Observable
import retrofit2.http.*

/**
 * author: wneJie
 * date: 2019-09-25 16:36
 * desc:
 */
interface CollectionApi {







    @GET("https://diycode.cc/api/v3/users/{login}/favorites.json")
    suspend fun getTopics(@Path("login") login: String): List<Topic>



    @POST("https://www.diycode.cc/oauth/token")
    @FormUrlEncoded
    suspend fun getToken(
        @Field("client_id") client_id: String, @Field("client_secret") client_secret: String,
        @Field("grant_type") grant_type: String, @Field("username") username: String,
        @Field("password") password: String
    ): Token


    /**
     * 获取当前登录者的详细资料
     *
     * @return 用户详情
     */
    @GET("https://diycode.cc/api/v3/users/me.json")
    suspend fun getMe(): UserInfo


    /**
     * 获取 topic 内容
     *
     * @param id topic 的 id
     * @return 内容详情
     */
    @GET("https://diycode.cc/api/v3/topics/{id}.json")
    suspend fun getTopic(@Path("id") id: Int): TopicContent

    /**
     * 获取 news 列表
     *
     * @param node_id 如果你需要只看某个节点的，请传此参数, 如果不传 则返回全部
     * @param offset  偏移数值，默认值 0
     * @param limit   数量极限，默认值 20，值范围 1..150
     */
    @GET("https://diycode.cc/api/v3/news.json")
    suspend fun getNewsList(@Query("offset") offset: Int?, @Query("limit") limit: Int?): List<NewsInfo>

}