package com.loopj.android.http;

import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.impl.cookie.BasicClientCookie;
import java.io.Serializable;

public class SerializableCookie implements Serializable {
   private transient BasicClientCookie clientCookie;
   private final transient Cookie cookie;

   public SerializableCookie(Cookie var1) {
      this.cookie = var1;
   }

   public Cookie getCookie() {
      Object var1 = this.cookie;
      if(this.clientCookie != null) {
         var1 = this.clientCookie;
      }

      return (Cookie)var1;
   }
}
