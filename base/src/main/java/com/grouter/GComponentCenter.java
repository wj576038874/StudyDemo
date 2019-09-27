package com.grouter;

import androidx.fragment.app.Fragment;
import com.joyrun.base.service.IHomeService;
import com.joyrun.base.service.IMineService;
import com.joyrun.base.service.IWachatService;

public class GComponentCenter {
  public static Fragment HomeFragment() {
    return ComponentUtils.getInstance(Fragment.class,"com.joyrun.home.HomeFragment");
  }

  public static IHomeService HomeService() {
    return ComponentUtils.getInstance(IHomeService.class,"com.joyrun.home.HomeService");
  }

  public static Fragment MineFragment() {
    return ComponentUtils.getInstance(Fragment.class,"com.joyrun.mine.MineFragment");
  }

  public static IMineService MineService() {
    return ComponentUtils.getInstance(IMineService.class,"com.joyrun.mine.MineService");
  }

  public static Fragment WechatFragment() {
    return ComponentUtils.getInstance(Fragment.class,"com.joyrun.wechat.WechatFragment");
  }

  public static IWachatService WechatService() {
    return ComponentUtils.getInstance(IWachatService.class,"com.joyrun.wechat.WechatService");
  }
}
