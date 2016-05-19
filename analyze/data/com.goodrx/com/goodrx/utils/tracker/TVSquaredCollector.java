package com.goodrx.utils.tracker;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Proxy;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TVSquaredCollector {
   private static final boolean IS_ICS_OR_LATER;
   private String hostname;
   private HttpHost proxy;
   private Random random;
   private boolean secure;
   private String siteid;
   private String userId;
   private String visitorid;

   static {
      boolean var0;
      if(VERSION.SDK_INT >= 14) {
         var0 = true;
      } else {
         var0 = false;
      }

      IS_ICS_OR_LATER = var0;
   }

   public TVSquaredCollector(Activity var1, String var2, String var3) throws NoSuchAlgorithmException {
      this(var1, var2, var3, false);
   }

   public TVSquaredCollector(Activity var1, String var2, String var3, boolean var4) throws NoSuchAlgorithmException {
      this.hostname = null;
      this.siteid = null;
      this.secure = false;
      this.visitorid = null;
      this.userId = null;
      this.random = new Random((new Date()).getTime());
      this.proxy = null;
      this.hostname = var2;
      this.siteid = var3;
      this.secure = var4;
      this.visitorid = this.getVisitorId(var1);
      this.proxy = this.getProxy(var1);
   }

   private void appendActionDetails(Builder var1, String var2, String var3, String var4, float var5, String var6) throws JSONException {
      JSONObject var7 = new JSONObject();
      if(var3 != null) {
         var7.put("prod", var3);
      }

      if(var4 != null) {
         var7.put("id", var4);
      }

      var7.put("rev", (double)var5);
      if(var6 != null) {
         var7.put("promo", var6);
      }

      JSONArray var9 = new JSONArray();
      var9.put(var2);
      String var11;
      if(!(var7 instanceof JSONObject)) {
         var11 = var7.toString();
      } else {
         var11 = JSONObjectInstrumentation.toString((JSONObject)var7);
      }

      var9.put(var11);
      JSONObject var13 = new JSONObject();
      var13.put("5", var9);
      String var15;
      if(!(var13 instanceof JSONObject)) {
         var15 = var13.toString();
      } else {
         var15 = JSONObjectInstrumentation.toString((JSONObject)var13);
      }

      var1.appendQueryParameter("cvar", var15);
   }

   private void appendSessionDetails(Builder var1) throws JSONException {
      JSONObject var2 = new JSONObject();
      var2.put("medium", "app");
      var2.put("dev", "android");
      if(this.userId != null) {
         var2.put("user", this.userId);
      }

      JSONArray var5 = new JSONArray();
      var5.put("session");
      String var7;
      if(!(var2 instanceof JSONObject)) {
         var7 = var2.toString();
      } else {
         var7 = JSONObjectInstrumentation.toString((JSONObject)var2);
      }

      var5.put(var7);
      JSONObject var9 = new JSONObject();
      var9.put("5", var5);
      String var11;
      if(!(var9 instanceof JSONObject)) {
         var11 = var9.toString();
      } else {
         var11 = JSONObjectInstrumentation.toString((JSONObject)var9);
      }

      var1.appendQueryParameter("_cvar", var11);
   }

   private HttpHost getProxy(Context var1) {
      String var2;
      int var3;
      if(IS_ICS_OR_LATER) {
         var2 = System.getProperty("http.proxyHost");
         String var4 = System.getProperty("http.proxyPort");
         if(var4 == null) {
            var4 = "-1";
         }

         var3 = Integer.parseInt(var4);
      } else {
         var2 = Proxy.getHost(var1);
         var3 = Proxy.getPort(var1);
      }

      return var2 == null?null:new HttpHost(var2, var3);
   }

   private String getVisitorId(Activity var1) throws NoSuchAlgorithmException {
      String var2 = "visitor" + this.siteid;
      SharedPreferences var3 = var1.getSharedPreferences("TVSquaredTracker", 0);
      String var4 = var3.getString(var2, (String)null);
      if(var4 == null) {
         var4 = this.md5(UUID.randomUUID().toString()).substring(0, 16);
         var3.edit().putString(var2, var4).commit();
      }

      return var4;
   }

   private String md5(String var1) throws NoSuchAlgorithmException {
      MessageDigest var2 = MessageDigest.getInstance("MD5");
      var2.update(var1.getBytes());
      byte[] var3 = var2.digest();
      StringBuilder var4 = new StringBuilder();
      int var5 = var3.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         String var7;
         for(var7 = Integer.toHexString(255 & var3[var6]); var7.length() < 2; var7 = "0" + var7) {
            ;
         }

         var4.append(var7);
      }

      return var4.toString();
   }

   public void setUserId(String var1) {
      this.userId = var1;
   }

   public void track() {
      this.track((String)null, (String)null, (String)null, 0.0F, (String)null);
   }

   public void track(String param1, String param2, String param3, float param4, String param5) {
      // $FF: Couldn't be decompiled
   }

   class AsyncTrack implements Runnable {
      private HttpHost proxy;
      private String url;

      public AsyncTrack(HttpHost var2, String var3) {
         this.proxy = var2;
         this.url = var3;
      }

      public void run() {
         try {
            DefaultHttpClient var1 = new DefaultHttpClient();
            if(this.proxy != null) {
               var1.getParams().setParameter("http.route.default-proxy", this.proxy);
            }

            HttpGet var3 = new HttpGet(this.url);
            var3.setHeader("User-Agent", "TVSquared Android Collector Client 1.0");
            HttpResponse var4 = var1.execute(var3);
            if(var4.getStatusLine().getStatusCode() != 200) {
               System.err.println("Failed to track request: " + var4.getStatusLine().toString());
            }

         } catch (Throwable var5) {
            var5.printStackTrace();
         }
      }
   }
}
