package com.loopj.android.http;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.SerializableCookie;
import cz.msebera.android.httpclient.client.CookieStore;
import cz.msebera.android.httpclient.cookie.Cookie;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class PersistentCookieStore implements CookieStore {
   private final SharedPreferences cookiePrefs;
   private final ConcurrentHashMap<String, Cookie> cookies;
   private boolean omitNonPersistentCookies;

   public PersistentCookieStore(Context var1) {
      int var2 = 0;
      super();
      this.omitNonPersistentCookies = false;
      this.cookiePrefs = var1.getSharedPreferences("CookiePrefsFile", 0);
      this.cookies = new ConcurrentHashMap();
      String var3 = this.cookiePrefs.getString("names", (String)null);
      if(var3 != null) {
         String[] var4 = TextUtils.split(var3, ",");

         for(int var5 = var4.length; var2 < var5; ++var2) {
            String var7 = var4[var2];
            String var8 = this.cookiePrefs.getString("cookie_" + var7, (String)null);
            if(var8 != null) {
               Cookie var9 = this.decodeCookie(var8);
               if(var9 != null) {
                  this.cookies.put(var7, var9);
               }
            }
         }

         this.clearExpired(new Date());
      }

   }

   public void addCookie(Cookie var1) {
      if(!this.omitNonPersistentCookies || var1.isPersistent()) {
         String var2 = var1.getName() + var1.getDomain();
         if(!var1.isExpired(new Date())) {
            this.cookies.put(var2, var1);
         } else {
            this.cookies.remove(var2);
         }

         Editor var4 = this.cookiePrefs.edit();
         var4.putString("names", TextUtils.join(",", this.cookies.keySet()));
         var4.putString("cookie_" + var2, this.encodeCookie(new SerializableCookie(var1)));
         var4.commit();
      }
   }

   protected String byteArrayToHexString(byte[] var1) {
      StringBuilder var2 = new StringBuilder(2 * var1.length);
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 255 & var1[var4];
         if(var5 < 16) {
            var2.append('0');
         }

         var2.append(Integer.toHexString(var5));
      }

      return var2.toString().toUpperCase(Locale.US);
   }

   public boolean clearExpired(Date var1) {
      boolean var2 = false;
      Editor var3 = this.cookiePrefs.edit();
      Iterator var4 = this.cookies.entrySet().iterator();

      while(var4.hasNext()) {
         Entry var7 = (Entry)var4.next();
         String var8 = (String)var7.getKey();
         if(((Cookie)var7.getValue()).isExpired(var1)) {
            this.cookies.remove(var8);
            var3.remove("cookie_" + var8);
            var2 = true;
         }
      }

      if(var2) {
         var3.putString("names", TextUtils.join(",", this.cookies.keySet()));
      }

      var3.commit();
      return var2;
   }

   protected Cookie decodeCookie(String var1) {
      ByteArrayInputStream var2 = new ByteArrayInputStream(this.hexStringToByteArray(var1));

      try {
         Cookie var5 = ((SerializableCookie)(new ObjectInputStream(var2)).readObject()).getCookie();
         return var5;
      } catch (IOException var6) {
         AsyncHttpClient.log.method_2("PersistentCookieStore", "IOException in decodeCookie", var6);
         return null;
      } catch (ClassNotFoundException var7) {
         AsyncHttpClient.log.method_2("PersistentCookieStore", "ClassNotFoundException in decodeCookie", var7);
         return null;
      }
   }

   protected String encodeCookie(SerializableCookie var1) {
      if(var1 == null) {
         return null;
      } else {
         ByteArrayOutputStream var2 = new ByteArrayOutputStream();

         try {
            (new ObjectOutputStream(var2)).writeObject(var1);
         } catch (IOException var4) {
            AsyncHttpClient.log.method_2("PersistentCookieStore", "IOException in encodeCookie", var4);
            return null;
         }

         return this.byteArrayToHexString(var2.toByteArray());
      }
   }

   public List<Cookie> getCookies() {
      return new ArrayList(this.cookies.values());
   }

   protected byte[] hexStringToByteArray(String var1) {
      int var2 = var1.length();
      byte[] var3 = new byte[var2 / 2];

      for(int var4 = 0; var4 < var2; var4 += 2) {
         var3[var4 / 2] = (byte)((Character.digit(var1.charAt(var4), 16) << 4) + Character.digit(var1.charAt(var4 + 1), 16));
      }

      return var3;
   }
}
