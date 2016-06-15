package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.tagmanager.ap;
import com.google.android.gms.tagmanager.class_613;
import com.google.android.gms.tagmanager.class_616;
import com.google.android.gms.tagmanager.class_89;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

// $FF: renamed from: com.google.android.gms.tagmanager.db
class class_633 implements class_89 {
   private final String atQ;
   private final HttpClient atR;
   private class_633.class_1679 atS;
   private final Context atz;

   class_633(HttpClient var1, Context var2, class_633.class_1679 var3) {
      this.atz = var2.getApplicationContext();
      this.atQ = this.method_3568("GoogleTagManager", "4.00", VERSION.RELEASE, method_3567(Locale.getDefault()), Build.MODEL, Build.ID);
      this.atR = var1;
      this.atS = var3;
   }

   // $FF: renamed from: a (java.net.URL) org.apache.http.HttpEntityEnclosingRequest
   private HttpEntityEnclosingRequest method_3565(URL var1) {
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
            var2.addHeader("User-Agent", this.atQ);
            return var2;
         } catch (URISyntaxException var5) {
            var3 = var5;
         }
      }

      class_613.method_3494("Exception sending hit: " + var3.getClass().getSimpleName());
      class_613.method_3494(var3.getMessage());
      return var2;
   }

   // $FF: renamed from: a (org.apache.http.HttpEntityEnclosingRequest) void
   private void method_3566(HttpEntityEnclosingRequest param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: c (java.util.Locale) java.lang.String
   static String method_3567(Locale var0) {
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
   String method_3568(String var1, String var2, String var3, String var4, String var5, String var6) {
      return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{var1, var2, var3, var4, var5, var6});
   }

   // $FF: renamed from: d (com.google.android.gms.tagmanager.ap) java.net.URL
   URL method_3569(class_616 var1) {
      String var2 = var1.method_3511();

      try {
         URL var3 = new URL(var2);
         return var3;
      } catch (MalformedURLException var5) {
         class_613.method_3491("Error trying to parse the GTM url.");
         return null;
      }
   }

   // $FF: renamed from: ea () boolean
   public boolean method_436() {
      NetworkInfo var1 = ((ConnectivityManager)this.atz.getSystemService("connectivity")).getActiveNetworkInfo();
      if(var1 != null && var1.isConnected()) {
         return true;
      } else {
         class_613.method_3493("...no network connectivity");
         return false;
      }
   }

   // $FF: renamed from: k (java.util.List) void
   public void method_437(List<ap> param1) {
      // $FF: Couldn't be decompiled
   }

   public interface class_1679 {
      // $FF: renamed from: a (com.google.android.gms.tagmanager.ap) void
      void method_935(class_616 var1);

      // $FF: renamed from: b (com.google.android.gms.tagmanager.ap) void
      void method_936(class_616 var1);

      // $FF: renamed from: c (com.google.android.gms.tagmanager.ap) void
      void method_937(class_616 var1);
   }
}
