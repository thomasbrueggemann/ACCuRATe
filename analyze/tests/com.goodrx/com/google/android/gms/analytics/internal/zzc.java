package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.internal.zza;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzai;
import com.google.android.gms.analytics.internal.zzan;
import com.google.android.gms.analytics.internal.zzb;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzk;
import com.google.android.gms.analytics.internal.zzn;
import com.google.android.gms.analytics.internal.zzr;
import com.google.android.gms.analytics.internal.zzu;
import com.google.android.gms.analytics.internal.zzv;
import com.google.android.gms.analytics.internal.zzy;
import com.google.android.gms.internal.zzmq;

public class zzc {
   private final zzf zzQj;

   protected zzc(zzf var1) {
      com.google.android.gms.common.internal.zzx.zzz(var1);
      this.zzQj = var1;
   }

   private void zza(int var1, String var2, Object var3, Object var4, Object var5) {
      zzf var6 = this.zzQj;
      zzaf var7 = null;
      if(var6 != null) {
         var7 = this.zzQj.zzjy();
      }

      if(var7 != null) {
         var7.zza(var1, var2, var3, var4, var5);
      } else {
         String var8 = (String)zzy.zzRL.get();
         if(Log.isLoggable(var8, var1)) {
            Log.println(var1, var8, zzc(var2, var3, var4, var5));
            return;
         }
      }

   }

   protected static String zzc(String var0, Object var1, Object var2, Object var3) {
      if(var0 == null) {
         var0 = "";
      }

      String var4 = zzj(var1);
      String var5 = zzj(var2);
      String var6 = zzj(var3);
      StringBuilder var7 = new StringBuilder();
      String var8 = "";
      if(!TextUtils.isEmpty(var0)) {
         var7.append(var0);
         var8 = ": ";
      }

      if(!TextUtils.isEmpty(var4)) {
         var7.append(var8);
         var7.append(var4);
         var8 = ", ";
      }

      if(!TextUtils.isEmpty(var5)) {
         var7.append(var8);
         var7.append(var5);
         var8 = ", ";
      }

      if(!TextUtils.isEmpty(var6)) {
         var7.append(var8);
         var7.append(var6);
      }

      return var7.toString();
   }

   private static String zzj(Object var0) {
      if(var0 == null) {
         return "";
      } else if(var0 instanceof String) {
         return (String)var0;
      } else if(var0 instanceof Boolean) {
         String var1;
         if(var0 == Boolean.TRUE) {
            var1 = "true";
         } else {
            var1 = "false";
         }

         return var1;
      } else {
         return var0 instanceof Throwable?((Throwable)var0).toString():var0.toString();
      }
   }

   protected Context getContext() {
      return this.zzQj.getContext();
   }

   public void zza(String var1, Object var2) {
      this.zza(2, var1, var2, (Object)null, (Object)null);
   }

   public void zza(String var1, Object var2, Object var3) {
      this.zza(2, var1, var2, var3, (Object)null);
   }

   public void zza(String var1, Object var2, Object var3, Object var4) {
      this.zza(3, var1, var2, var3, var4);
   }

   public void zzb(String var1, Object var2) {
      this.zza(3, var1, var2, (Object)null, (Object)null);
   }

   public void zzb(String var1, Object var2, Object var3) {
      this.zza(3, var1, var2, var3, (Object)null);
   }

   public void zzb(String var1, Object var2, Object var3, Object var4) {
      this.zza(5, var1, var2, var3, var4);
   }

   public void zzbd(String var1) {
      this.zza(2, var1, (Object)null, (Object)null, (Object)null);
   }

   public void zzbe(String var1) {
      this.zza(3, var1, (Object)null, (Object)null, (Object)null);
   }

   public void zzbf(String var1) {
      this.zza(4, var1, (Object)null, (Object)null, (Object)null);
   }

   public void zzbg(String var1) {
      this.zza(5, var1, (Object)null, (Object)null, (Object)null);
   }

   public void zzbh(String var1) {
      this.zza(6, var1, (Object)null, (Object)null, (Object)null);
   }

   public void zzc(String var1, Object var2) {
      this.zza(4, var1, var2, (Object)null, (Object)null);
   }

   public void zzc(String var1, Object var2, Object var3) {
      this.zza(5, var1, var2, var3, (Object)null);
   }

   public void zzd(String var1, Object var2) {
      this.zza(5, var1, var2, (Object)null, (Object)null);
   }

   public void zzd(String var1, Object var2, Object var3) {
      this.zza(6, var1, var2, var3, (Object)null);
   }

   public void zze(String var1, Object var2) {
      this.zza(6, var1, var2, (Object)null, (Object)null);
   }

   public boolean zzhp() {
      return Log.isLoggable((String)zzy.zzRL.get(), 2);
   }

   public GoogleAnalytics zziC() {
      return this.zzQj.zzjz();
   }

   protected zzb zziH() {
      return this.zzQj.zziH();
   }

   protected zzan zziI() {
      return this.zzQj.zziI();
   }

   public zzf zzji() {
      return this.zzQj;
   }

   protected void zzjj() {
      if(this.zzjn().zzkr()) {
         throw new IllegalStateException("Call only supported on the client side");
      }
   }

   protected void zzjk() {
      this.zzQj.zzjk();
   }

   protected zzmq zzjl() {
      return this.zzQj.zzjl();
   }

   protected zzaf zzjm() {
      return this.zzQj.zzjm();
   }

   protected zzr zzjn() {
      return this.zzQj.zzjn();
   }

   protected com.google.android.gms.measurement.zzg zzjo() {
      return this.zzQj.zzjo();
   }

   protected zzv zzjp() {
      return this.zzQj.zzjp();
   }

   protected zzai zzjq() {
      return this.zzQj.zzjq();
   }

   protected zzn zzjr() {
      return this.zzQj.zzjC();
   }

   protected zza zzjs() {
      return this.zzQj.zzjB();
   }

   protected zzk zzjt() {
      return this.zzQj.zzjt();
   }

   protected zzu zzju() {
      return this.zzQj.zzju();
   }
}
