package com.google.android.gms.analytics.internal;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.internal.zza;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzag;
import com.google.android.gms.analytics.internal.zzah;
import com.google.android.gms.analytics.internal.zzai;
import com.google.android.gms.analytics.internal.zzan;
import com.google.android.gms.analytics.internal.zzb;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzi;
import com.google.android.gms.analytics.internal.zzj;
import com.google.android.gms.analytics.internal.zzk;
import com.google.android.gms.analytics.internal.zzl;
import com.google.android.gms.analytics.internal.zzn;
import com.google.android.gms.analytics.internal.zzr;
import com.google.android.gms.analytics.internal.zzu;
import com.google.android.gms.analytics.internal.zzv;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;

public class zzg {
   private final Context zzQC;
   private final Context zzsa;

   public zzg(Context var1) {
      com.google.android.gms.common.internal.zzx.zzz(var1);
      Context var3 = var1.getApplicationContext();
      com.google.android.gms.common.internal.zzx.zzb(var3, "Application context can\'t be null");
      this.zzsa = var3;
      this.zzQC = var3;
   }

   public Context getApplicationContext() {
      return this.zzsa;
   }

   protected zzu zza(zzf var1) {
      return new zzu(var1);
   }

   protected com.google.android.gms.measurement.zzg zzab(Context var1) {
      return com.google.android.gms.measurement.zzg.zzaS(var1);
   }

   protected zzk zzb(zzf var1) {
      return new zzk(var1);
   }

   protected zza zzc(zzf var1) {
      return new zza(var1);
   }

   protected zzn zzd(zzf var1) {
      return new zzn(var1);
   }

   protected zzan zze(zzf var1) {
      return new zzan(var1);
   }

   protected zzaf zzf(zzf var1) {
      return new zzaf(var1);
   }

   protected zzr zzg(zzf var1) {
      return new zzr(var1);
   }

   protected zzmq zzh(zzf var1) {
      return zzmt.zzsc();
   }

   protected GoogleAnalytics zzi(zzf var1) {
      return new GoogleAnalytics(var1);
   }

   zzl zzj(zzf var1) {
      return new zzl(var1, this);
   }

   public Context zzjx() {
      return this.zzQC;
   }

   zzag zzk(zzf var1) {
      return new zzag(var1);
   }

   protected zzb zzl(zzf var1) {
      return new zzb(var1, this);
   }

   public zzj zzm(zzf var1) {
      return new zzj(var1);
   }

   public zzah zzn(zzf var1) {
      return new zzah(var1);
   }

   public zzi zzo(zzf var1) {
      return new zzi(var1);
   }

   public zzv zzp(zzf var1) {
      return new zzv(var1);
   }

   public zzai zzq(zzf var1) {
      return new zzai(var1);
   }
}
