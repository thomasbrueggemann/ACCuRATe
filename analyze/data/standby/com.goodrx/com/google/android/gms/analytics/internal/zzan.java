package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.gms.analytics.internal.zzaa;
import com.google.android.gms.analytics.internal.zzd;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzz;

public class zzan extends zzd {
   protected boolean zzPi;
   protected int zzRB;
   protected String zzSE;
   protected String zzSF;
   protected int zzSH;
   protected boolean zzTv;
   protected boolean zzTw;
   protected boolean zzTx;

   public zzan(zzf var1) {
      super(var1);
   }

   private static int zzby(String var0) {
      String var1 = var0.toLowerCase();
      return "verbose".equals(var1)?0:("info".equals(var1)?1:("warning".equals(var1)?2:("error".equals(var1)?3:-1)));
   }

   public int getLogLevel() {
      this.zzjv();
      return this.zzRB;
   }

   void zza(zzaa var1) {
      this.zzbd("Loading global XML config values");
      if(var1.zzlf()) {
         String var6 = var1.zzlg();
         this.zzSE = var6;
         this.zzb("XML config - app name", var6);
      }

      if(var1.zzlh()) {
         String var5 = var1.zzli();
         this.zzSF = var5;
         this.zzb("XML config - app version", var5);
      }

      if(var1.zzlj()) {
         int var4 = zzby(var1.zzlk());
         if(var4 >= 0) {
            this.zzRB = var4;
            this.zza("XML config - log level", Integer.valueOf(var4));
         }
      }

      if(var1.zzll()) {
         int var3 = var1.zzlm();
         this.zzSH = var3;
         this.zzTw = true;
         this.zzb("XML config - dispatch period (sec)", Integer.valueOf(var3));
      }

      if(var1.zzln()) {
         boolean var2 = var1.zzlo();
         this.zzPi = var2;
         this.zzTx = true;
         this.zzb("XML config - dry run", Boolean.valueOf(var2));
      }

   }

   protected void zziJ() {
      this.zzmd();
   }

   public String zzlg() {
      this.zzjv();
      return this.zzSE;
   }

   public String zzli() {
      this.zzjv();
      return this.zzSF;
   }

   public boolean zzlj() {
      this.zzjv();
      return this.zzTv;
   }

   public boolean zzll() {
      this.zzjv();
      return this.zzTw;
   }

   public boolean zzln() {
      this.zzjv();
      return this.zzTx;
   }

   public boolean zzlo() {
      this.zzjv();
      return this.zzPi;
   }

   public int zzmc() {
      this.zzjv();
      return this.zzSH;
   }

   protected void zzmd() {
      Context var1 = this.getContext();

      ApplicationInfo var3;
      label24: {
         ApplicationInfo var7;
         try {
            var7 = var1.getPackageManager().getApplicationInfo(var1.getPackageName(), 129);
         } catch (NameNotFoundException var8) {
            this.zzd("PackageManager doesn\'t know about the app package", var8);
            var3 = null;
            break label24;
         }

         var3 = var7;
      }

      if(var3 == null) {
         this.zzbg("Couldn\'t get ApplicationInfo to load global config");
      } else {
         Bundle var4 = var3.metaData;
         if(var4 != null) {
            int var5 = var4.getInt("com.google.android.gms.analytics.globalConfigResource");
            if(var5 > 0) {
               zzaa var6 = (zzaa)(new zzz(this.zzji())).zzah(var5);
               if(var6 != null) {
                  this.zza(var6);
                  return;
               }
            }
         }
      }

   }
}
