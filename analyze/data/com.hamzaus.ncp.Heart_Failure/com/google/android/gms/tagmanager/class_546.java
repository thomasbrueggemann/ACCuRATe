package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.tagmanager.ap;
import com.google.android.gms.tagmanager.class_515;
import com.google.android.gms.tagmanager.class_518;
import com.google.android.gms.tagmanager.class_84;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

// $FF: renamed from: com.google.android.gms.tagmanager.da
class class_546 implements class_84 {
   private final Context ahH;
   private final String ahY;
   private final HttpClient ahZ;
   private class_546.class_1208 aia;

   class_546(HttpClient var1, Context var2, class_546.class_1208 var3) {
      this.ahH = var2.getApplicationContext();
      this.ahY = this.method_3088("GoogleTagManager", "4.00", VERSION.RELEASE, method_3087(Locale.getDefault()), Build.MODEL, Build.ID);
      this.ahZ = var1;
      this.aia = var3;
   }

   // $FF: renamed from: a (java.net.URL) org.apache.http.HttpEntityEnclosingRequest
   private HttpEntityEnclosingRequest method_3085(URL var1) {
      BasicHttpEntityEnclosingRequest var2;
      URISyntaxException var3;
      label17: {
         try {
            var2 = new BasicHttpEntityEnclosingRequest("GET", var1.toURI().toString());
         } catch (URISyntaxException var6) {
            var2 = null;
            var3 = var6;
            break label17;
         }

         try {
            var2.addHeader("User-Agent", this.ahY);
            return var2;
         } catch (URISyntaxException var5) {
            var3 = var5;
         }
      }

      class_515.method_2919("Exception sending hit: " + var3.getClass().getSimpleName());
      class_515.method_2919(var3.getMessage());
      return var2;
   }

   // $FF: renamed from: a (org.apache.http.HttpEntityEnclosingRequest) void
   private void method_3086(HttpEntityEnclosingRequest param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: c (java.util.Locale) java.lang.String
   static String method_3087(Locale var0) {
      if(var0 != null && var0.getLanguage() != null && var0.getLanguage().length() != 0) {
         StringBuilder var1 = new StringBuilder();
         var1.append(var0.getLanguage().toLowerCase());
         if(var0.getCountry() != null && var0.getCountry().length() != 0) {
            var1.append("-").append(var0.getCountry().toLowerCase());
         }

         return var1.toString();
      } else {
         return null;
      }
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String) java.lang.String
   String method_3088(String var1, String var2, String var3, String var4, String var5, String var6) {
      return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{var1, var2, var3, var4, var5, var6});
   }

   // $FF: renamed from: cx () boolean
   public boolean method_395() {
      NetworkInfo var1 = ((ConnectivityManager)this.ahH.getSystemService("connectivity")).getActiveNetworkInfo();
      if(var1 != null && var1.isConnected()) {
         return true;
      } else {
         class_515.method_2918("...no network connectivity");
         return false;
      }
   }

   // $FF: renamed from: d (com.google.android.gms.tagmanager.ap) java.net.URL
   URL method_3089(class_518 var1) {
      String var2 = var1.method_2936();

      try {
         URL var3 = new URL(var2);
         return var3;
      } catch (MalformedURLException var5) {
         class_515.method_2916("Error trying to parse the GTM url.");
         return null;
      }
   }

   // $FF: renamed from: g (java.util.List) void
   public void method_396(List<ap> param1) {
      // $FF: Couldn't be decompiled
   }

   public interface class_1208 {
      // $FF: renamed from: a (com.google.android.gms.tagmanager.ap) void
      void method_674(class_518 var1);

      // $FF: renamed from: b (com.google.android.gms.tagmanager.ap) void
      void method_675(class_518 var1);

      // $FF: renamed from: c (com.google.android.gms.tagmanager.ap) void
      void method_676(class_518 var1);
   }
}
