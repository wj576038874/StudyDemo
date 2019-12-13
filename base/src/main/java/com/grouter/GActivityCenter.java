package com.grouter;

import java.lang.String;

public class GActivityCenter {
  public static BuilderSet.CollectionActivityHelper CollectionActivity() {
    return new BuilderSet.CollectionActivityHelper();
  }

  public static BuilderSet.TestActivityHelper TestActivity() {
    return new BuilderSet.TestActivityHelper();
  }

  public static BuilderSet.WalletActivityHelper WalletActivity() {
    return new BuilderSet.WalletActivityHelper();
  }

  public static BuilderSet.LoginActivityHelper LoginActivity() {
    return new BuilderSet.LoginActivityHelper();
  }

  public static BuilderSet.UserActivityHelper UserActivity() {
    return new BuilderSet.UserActivityHelper();
  }

  public static class BuilderSet {
    public static class CollectionActivityHelper extends GActivityBuilder {
      CollectionActivityHelper() {
        super("com.joyrun.collection.CollectionActivity");
      }
    }

    public static class TestActivityHelper extends GActivityBuilder {
      TestActivityHelper() {
        super("com.joyrun.collection.TestActivity");
      }
    }

    public static class WalletActivityHelper extends GActivityBuilder {
      WalletActivityHelper() {
        super("com.joyrun.collection.WalletActivity");
      }
    }

    public static class LoginActivityHelper extends GActivityBuilder {
      LoginActivityHelper() {
        super("com.joyrun.login.LoginActivity");
      }
    }

    public static class UserActivityHelper extends GActivityBuilder {
      UserActivityHelper() {
        super("com.joyrun.mine.UserActivity");
      }

      public UserActivityHelper name(String name) {
        put("name",name);
        return this;
      }
    }
  }
}
