package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.internal.zzrs;
import com.google.android.gms.internal.zzrv;
import com.google.android.gms.internal.zzrw;
import com.google.android.gms.tagmanager.zzbf;
import com.google.android.gms.tagmanager.zzbg;
import com.google.android.gms.tagmanager.zzcb;
import com.google.android.gms.tagmanager.zzs;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

class zzcl implements Runnable {
   private final Context mContext;
   private final String zzbhM;
   private volatile String zzbij;
   private final zzrw zzbke;
   private final String zzbkf;
   private zzbf<com.google.android.gms.internal.zzaf.zzj> zzbkg;
   private volatile zzs zzbkh;
   private volatile String zzbki;

   zzcl(Context var1, String var2, zzrw var3, zzs var4) {
      this.mContext = var1;
      this.zzbke = var3;
      this.zzbhM = var2;
      this.zzbkh = var4;
      this.zzbkf = "/r?id=" + var2;
      this.zzbij = this.zzbkf;
      this.zzbki = null;
   }

   public zzcl(Context var1, String var2, zzs var3) {
      this(var1, var2, new zzrw(), var3);
   }

   private boolean zzGX() {
      NetworkInfo var1 = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if(var1 != null && var1.isConnected()) {
         return true;
      } else {
         zzbg.method_354("...no network connectivity");
         return false;
      }
   }

   private void zzGY() {
      if(!this.zzGX()) {
         this.zzbkg.zza(zzbf.zza.zzbju);
      } else {
         zzbg.method_354("Start loading resource from network ...");
         String var1 = this.zzGZ();
         zzrv var2 = this.zzbke.zzIa();

         try {
            InputStream var6;
            try {
               var6 = var2.zzgI(var1);
            } catch (FileNotFoundException var15) {
               zzbg.zzaK("No data is retrieved from the given url: " + var1 + ". Make sure container_id: " + this.zzbhM + " is correct.");
               this.zzbkg.zza(zzbf.zza.zzbjw);
               return;
            } catch (IOException var16) {
               zzbg.zzd("Error when loading resources from url: " + var1 + " " + var16.getMessage(), var16);
               this.zzbkg.zza(zzbf.zza.zzbjv);
               return;
            }

            try {
               ByteArrayOutputStream var7 = new ByteArrayOutputStream();
               zzrs.zzb(var6, var7);
               com.google.android.gms.internal.zzaf.zzj var9 = com.google.android.gms.internal.zzaf.zzj.zzd(var7.toByteArray());
               zzbg.method_354("Successfully loaded supplemented resource: " + var9);
               if(var9.zzju == null && var9.zzjt.length == 0) {
                  zzbg.method_354("No change for container: " + this.zzbhM);
               }

               this.zzbkg.zzI(var9);
            } catch (IOException var14) {
               zzbg.zzd("Error when parsing downloaded resources from url: " + var1 + " " + var14.getMessage(), var14);
               this.zzbkg.zza(zzbf.zza.zzbjw);
               return;
            }
         } finally {
            var2.close();
         }

         zzbg.method_354("Load resource from network finished.");
      }
   }

   public void run() {
      if(this.zzbkg == null) {
         throw new IllegalStateException("callback must be set before execute");
      } else {
         this.zzbkg.zzGk();
         this.zzGY();
      }
   }

   String zzGZ() {
      String var1 = this.zzbkh.zzGm() + this.zzbij + "&v=a65833898";
      if(this.zzbki != null && !this.zzbki.trim().equals("")) {
         var1 = var1 + "&pv=" + this.zzbki;
      }

      if(zzcb.zzGU().zzGV().equals(zzcb.zza.zzbjW)) {
         var1 = var1 + "&gtm_debug=x";
      }

      return var1;
   }

   void zza(zzbf<com.google.android.gms.internal.zzaf.zzj> var1) {
      this.zzbkg = var1;
   }

   void zzfW(String var1) {
      if(var1 == null) {
         this.zzbij = this.zzbkf;
      } else {
         zzbg.zzaI("Setting CTFE URL path: " + var1);
         this.zzbij = var1;
      }
   }

   void zzgl(String var1) {
      zzbg.zzaI("Setting previous container version: " + var1);
      this.zzbki = var1;
   }
}
