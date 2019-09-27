package com.joyrun.login

import com.joyrun.base.entity.login.Token
import com.joyrun.base.entity.login.UserInfo
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.GET


/**
 * author: wneJie
 * date: 2019-09-25 12:01
 * desc:
 */
interface LoginApi {

    @POST("https://www.diycode.cc/oauth/token")
    @FormUrlEncoded
    fun getToken(
        @Field("client_id") client_id: String, @Field("client_secret") client_secret: String,
        @Field("grant_type") grant_type: String, @Field("username") username: String,
        @Field("password") password: String
    ): Observable<Response<Token>>


    /**
     * 获取当前登录者的详细资料
     *
     * @return 用户详情
     */
    @GET("https://diycode.cc/api/v3/users/me.json")
    fun getMe(): Observable<Response<UserInfo>>


    @POST("https://www.diycode.cc/oauth/token")
    @FormUrlEncoded
    suspend fun getToken2(
        @Field("client_id") client_id: String, @Field("client_secret") client_secret: String,
        @Field("grant_type") grant_type: String, @Field("username") username: String,
        @Field("password") password: String
    ): Response<Token>


    /**
     * 获取当前登录者的详细资料
     *
     * @return 用户详情
     */
    @GET("https://diycode.cc/api/v3/users/me.json")
    suspend fun getMe2(): Response<UserInfo>

}