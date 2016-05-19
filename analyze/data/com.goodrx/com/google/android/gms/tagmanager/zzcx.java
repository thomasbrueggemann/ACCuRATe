package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.tagmanager.zzac;
import com.google.android.gms.tagmanager.zzaq;
import com.google.android.gms.tagmanager.zzbg;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;

class zzcx implements zzac {
   private final Context mContext;
   private final zzcx.zzb zzblh;
   private final zzcx.zza zzbli;
   private final String zzzN;

   zzcx(Context var1, zzcx.zza var2) {
      this(new zzcx.zzb() {
         public HttpURLConnection zzd(URL var1) throws IOException {
            return (HttpURLConnection)((HttpURLConnection)HttpInstrumentation.openConnection(var1.openConnection()));
         }
      }, var1, var2);
   }

   zzcx(zzcx.zzb var1, Context var2, zzcx.zza var3) {
      this.zzblh = var1;
      this.mContext = var2.getApplicationContext();
      this.zzbli = var3;
      this.zzzN = this.zza("GoogleTagManager", "4.00", VERSION.RELEASE, zzc(Locale.getDefault()), Build.MODEL, Build.ID);
   }

   static String zzc(Locale var0) {
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

   public void zzE(List<zzaq> param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean zzGw() {
      NetworkInfo var1 = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if(var1 != null && var1.isConnected()) {
         return true;
      } else {
         zzbg.method_354("...no network connectivity");
         return false;
      }
   }

   String zza(String var1, String var2, String var3, String var4, String var5, String var6) {
      return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{var1, var2, var3, var4, var5, var6});
   }

   URL zzd(zzaq var1) {
      String var2 = var1.zzGF();

      try {
         URL var3 = new URL(var2);
         return var3;
      } catch (MalformedURLException var5) {
         zzbg.method_353("Error trying to parse the GTM url.");
         return null;
      }
   }

   public interface zza {
      void zza(zzaq var1);

      void zzb(zzaq var1);

      void zzc(zzaq var1);
   }

   interface zzb {
      HttpURLConnection zzd(URL var1) throws IOException;
   }
}
