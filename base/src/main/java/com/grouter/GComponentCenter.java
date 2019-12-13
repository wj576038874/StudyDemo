package com.grouter;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.joyrun.base.service.IHomeService;
import com.joyrun.base.service.IMineService;
import com.joyrun.base.service.IWachatService;

public class GComponentCenter {
  public static Fragment HomeFragment() {
    return ComponentUtils.getInstance(Fragment.class,"com.joyrun.home.HomeFragment");
  }

  public static IHomeService HomeService(Context context) {
    Class[] classes = new Class[1];
    Object[] objects = new Object[1];
    classes[0] = Context.class;
    objects[0] = context;
    return ComponentUtils.getInstance(IHomeService.class,"com.joyrun.home.HomeService",classes,objects);
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
