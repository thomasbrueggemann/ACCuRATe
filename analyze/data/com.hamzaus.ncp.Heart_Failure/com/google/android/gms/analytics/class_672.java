package com.google.android.gms.analytics;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.ab;
import com.google.android.gms.analytics.class_139;
import com.google.android.gms.analytics.class_654;
import com.google.android.gms.analytics.class_667;
import com.google.android.gms.analytics.class_669;
import com.google.android.gms.analytics.class_671;
import com.google.android.gms.analytics.x;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

// $FF: renamed from: com.google.android.gms.analytics.ah
class class_672 implements class_139 {
   private final Context mContext;
   // $FF: renamed from: ui com.google.android.gms.analytics.GoogleAnalytics
   private GoogleAnalytics field_3592;
   // $FF: renamed from: wX java.lang.String
   private final String field_3593;
   // $FF: renamed from: wY org.apache.http.client.HttpClient
   private final HttpClient field_3594;
   // $FF: renamed from: wZ java.net.URL
   private URL field_3595;

   class_672(HttpClient var1, Context var2) {
      this(var1, GoogleAnalytics.getInstance(var2), var2);
   }

   class_672(HttpClient var1, GoogleAnalytics var2, Context var3) {
      this.mContext = var3.getApplicationContext();
      this.field_3593 = this.method_3916("GoogleAnalytics", "3.0", VERSION.RELEASE, class_671.method_3909(Locale.getDefault()), Build.MODEL, Build.ID);
      this.field_3594 = var1;
      this.field_3592 = var2;
   }

   // $FF: renamed from: a (com.google.android.gms.analytics.ab, java.net.URL, boolean) void
   private void method_3913(class_667 param1, URL param2, boolean param3) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (org.apache.http.HttpEntityEnclosingRequest) void
   private void method_3914(HttpEntityEnclosingRequest param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: e (java.lang.String, java.lang.String) org.apache.http.HttpEntityEnclosingRequest
   private HttpEntityEnclosingRequest method_3915(String var1, String var2) {
      if(TextUtils.isEmpty(var1)) {
         class_669.method_3891("Empty hit, discarding.");
         return null;
      } else {
         String var3 = var2 + "?" + var1;
         BasicHttpEntityEnclosingRequest var4;
         if(var3.length() < 2036) {
            var4 = new BasicHttpEntityEnclosingRequest("GET", var3);
         } else {
            var4 = new BasicHttpEntityEnclosingRequest("POST", var2);

            try {
               var4.setEntity(new StringEntity(var1));
            } catch (UnsupportedEncodingException var6) {
               class_669.method_3891("Encoding error, discarding hit");
               return null;
            }
         }

         var4.addHeader("User-Agent", this.field_3593);
         return var4;
      }
   }

   // $FF: renamed from: M (java.lang.String) void
   public void method_708(String var1) {
      try {
         this.field_3595 = new URL(var1);
      } catch (MalformedURLException var3) {
         this.field_3595 = null;
      }
   }

   // $FF: renamed from: a (java.util.List, com.google.android.gms.analytics.ab, boolean) int
   public int method_709(List<x> param1, ab param2, boolean param3) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String) java.lang.String
   String method_3916(String var1, String var2, String var3, String var4, String var5, String var6) {
      return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{var1, var2, var3, var4, var5, var6});
   }

   // $FF: renamed from: a (com.google.android.gms.analytics.x) java.net.URL
   URL method_3917(class_654 param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: cx () boolean
   public boolean method_710() {
      NetworkInfo var1 = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if(var1 != null && var1.isConnected()) {
         return true;
      } else {
         class_669.method_3890("...no network connectivity");
         return false;
      }
   }

   // $FF: renamed from: ds () boolean
   boolean method_3918() {
      return 100.0D * Math.random() <= 1.0D;
   }
}
