package com.grouter;

import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

@SuppressWarnings("unused")
public class GRouterInitializer extends GRouter {
  private static HashMap<String, String> activityMap = new HashMap<>();

  private static HashMap<String, String> componentMap = new HashMap<>();

  private static HashMap<String, String> taskMap = new HashMap<>();

  static {
    // collection
    activityMap.put("collection/CollectionActivity", "com.joyrun.collection.CollectionActivity");
    activityMap.put("collection/WalletActivity", "com.joyrun.collection.WalletActivity");
    // login
    activityMap.put("login/LoginActivity", "com.joyrun.login.LoginActivity");
    // mine
    activityMap.put("personal/UserActivity", "com.joyrun.mine.UserActivity");
  }
  static {
  }
  static {
    componentMap.put("androidx.fragment.app.Fragment", "com.joyrun.home.HomeFragment");
    componentMap.put("com.joyrun.base.service.IHomeService", "com.joyrun.home.HomeService");
    componentMap.put("HomeService", "com.joyrun.home.HomeService");
    componentMap.put("com.joyrun.base.service.IMineService", "com.joyrun.mine.MineService");
    componentMap.put("MineService", "com.joyrun.mine.MineService");
    componentMap.put("com.joyrun.base.service.IWachatService", "com.joyrun.wechat.WechatService");
    componentMap.put("WechatService", "com.joyrun.wechat.WechatService");
  }

  public GRouterInitializer() {
    super("grouter","",activityMap,componentMap,taskMap);
    addInterceptor("com.joyrun.study.interceptor.LoginInterceptor");
  }
}
