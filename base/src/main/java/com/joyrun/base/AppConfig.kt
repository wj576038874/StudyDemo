package com.joyrun.base

/**
 * author: wneJie
 * date: 2019-09-25 14:18
 * desc:
 */
class AppConfig {

    companion object {
        const val login_application = "com.joyrun.login.LoginApplication"
        private const val news_application = "com.joyrun.news.NewsApplication"
        private const val home_application = "com.joyrun.home.HomeApplication"
        private const val personal_application = "com.joyrun.personnal.PersonalApplication"


        val componentApplications = arrayOf(
            login_application, news_application,
            home_application, personal_application
        )
    }

}