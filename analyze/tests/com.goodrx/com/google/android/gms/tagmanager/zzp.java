package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;
import com.google.android.gms.internal.zzrq;
import com.google.android.gms.internal.zzrr;
import com.google.android.gms.internal.zzrs;
import com.google.android.gms.tagmanager.Container;
import com.google.android.gms.tagmanager.ContainerHolder;
import com.google.android.gms.tagmanager.TagManager;
import com.google.android.gms.tagmanager.zzbe;
import com.google.android.gms.tagmanager.zzbf;
import com.google.android.gms.tagmanager.zzbg;
import com.google.android.gms.tagmanager.zzcb;
import com.google.android.gms.tagmanager.zzcd;
import com.google.android.gms.tagmanager.zzcm;
import com.google.android.gms.tagmanager.zzcn;
import com.google.android.gms.tagmanager.zzo;
import com.google.android.gms.tagmanager.zzs;

public class zzp extends com.google.android.gms.common.api.internal.zzb<ContainerHolder> {
   private final Context mContext;
   private final Looper zzagr;
   private final String zzbhM;
   private long zzbhR;
   private final TagManager zzbhY;
   private final zzp.zzd zzbib;
   private final zzcd zzbic;
   private final int zzbid;
   private zzp.zzf zzbie;
   private zzrr zzbif;
   private volatile zzo zzbig;
   private volatile boolean zzbih;
   private com.google.android.gms.internal.zzaf.zzj zzbii;
   private String zzbij;
   private zzp.zze zzbik;
   private zzp.zza zzbil;
   private final zzmq zzqW;

   zzp(Context var1, TagManager var2, Looper var3, String var4, int var5, zzp.zzf var6, zzp.zze var7, zzrr var8, zzmq var9, zzcd var10) {
      Looper var11;
      if(var3 == null) {
         var11 = Looper.getMainLooper();
      } else {
         var11 = var3;
      }

      super(var11);
      this.mContext = var1;
      this.zzbhY = var2;
      if(var3 == null) {
         var3 = Looper.getMainLooper();
      }

      this.zzagr = var3;
      this.zzbhM = var4;
      this.zzbid = var5;
      this.zzbie = var6;
      this.zzbik = var7;
      this.zzbif = var8;
      this.zzbib = new zzp.zzd(null);
      this.zzbii = new com.google.android.gms.internal.zzaf.zzj();
      this.zzqW = var9;
      this.zzbic = var10;
      if(this.zzGj()) {
         this.zzfT(zzcb.zzGU().zzGW());
      }

   }

   public zzp(Context var1, TagManager var2, Looper var3, String var4, int var5, zzs var6) {
      this(var1, var2, var3, var4, var5, new zzcn(var1, var4), new zzcm(var1, var4, var6), new zzrr(var1), zzmt.zzsc(), new zzbe(30, 900000L, 5000L, "refreshing", zzmt.zzsc()));
      this.zzbif.zzgB(var6.zzGm());
   }

   private boolean zzGj() {
      zzcb var1 = zzcb.zzGU();
      return (var1.zzGV() == zzcb.zza.zzbjV || var1.zzGV() == zzcb.zza.zzbjW) && this.zzbhM.equals(var1.getContainerId());
   }

   private void zza(com.google.android.gms.internal.zzaf.zzj var1) {
      synchronized(this){}

      try {
         if(this.zzbie != null) {
            zzrq.zza var3 = new zzrq.zza();
            var3.zzbmd = this.zzbhR;
            var3.zzju = new com.google.android.gms.internal.zzaf.zzf();
            var3.zzbme = var1;
            this.zzbie.zzb(var3);
         }
      } finally {
         ;
      }

   }

   private void zza(com.google.android.gms.internal.zzaf.zzj param1, long param2, boolean param4) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static void zza(zzp var0, com.google.android.gms.internal.zzaf.zzj var1) {
      var0.zza(var1);
   }

   // $FF: synthetic method
   static void zza(zzp var0, com.google.android.gms.internal.zzaf.zzj var1, long var2, boolean var4) {
      var0.zza(var1, var2, var4);
   }

   private void zzak(long var1) {
      synchronized(this){}

      try {
         if(this.zzbik == null) {
            zzbg.zzaK("Refresh requested, but no network load scheduler.");
         } else {
            this.zzbik.zzf(var1, this.zzbii.zzjv);
         }
      } finally {
         ;
      }

   }

   private void zzaw(final boolean var1) {
      this.zzbie.zza(new zzp.zzb(null));
      this.zzbik.zza(new zzp.zzc(null));
      zzrs.zzc var2 = this.zzbie.zzke(this.zzbid);
      if(var2 != null) {
         this.zzbig = new zzo(this.zzbhY, this.zzagr, new Container(this.mContext, this.zzbhY.getDataLayer(), this.zzbhM, 0L, var2), this.zzbib);
      }

      this.zzbil = new zzp.zza() {
         public boolean zzb(Container var1x) {
            if(var1) {
               if(43200000L + var1x.getLastRefreshTime() < zzp.this.zzqW.currentTimeMillis()) {
                  return false;
               }
            } else if(var1x.isDefault()) {
               return false;
            }

            return true;
         }
      };
      if(this.zzGj()) {
         this.zzbik.zzf(0L, "");
      } else {
         this.zzbie.zzGl();
      }
   }

   // $FF: synthetic method
   static zzo zzb(zzp var0) {
      return var0.zzbig;
   }

   // $FF: synthetic method
   static com.google.android.gms.internal.zzaf.zzj zze(zzp var0) {
      return var0.zzbii;
   }

   // $FF: synthetic method
   static long zzf(zzp var0) {
      return var0.zzbhR;
   }

   // $FF: synthetic method
   static boolean zzg(zzp var0) {
      return var0.zzGj();
   }

   String zzGd() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.zzbij;
      } finally {
         ;
      }

      return var2;
   }

   public void zzGh() {
      this.zzaw(false);
   }

   protected ContainerHolder zzbn(Status var1) {
      if(this.zzbig != null) {
         return this.zzbig;
      } else {
         if(var1 == Status.zzagF) {
            zzbg.method_353("timer expired: setting result to failure");
         }

         return new zzo(var1);
      }
   }

   // $FF: synthetic method
   protected Result zzc(Status var1) {
      return this.zzbn(var1);
   }

   void zzfT(String var1) {
      synchronized(this){}

      try {
         this.zzbij = var1;
         if(this.zzbik != null) {
            this.zzbik.zzfW(var1);
         }
      } finally {
         ;
      }

   }

   interface zza {
      boolean zzb(Container var1);
   }

   private class zzb implements zzbf<zzrq.zza> {
      private zzb() {
      }

      // $FF: synthetic method
      zzb(Object var2) {
         this();
      }

      public void zzGk() {
      }

      // $FF: synthetic method
      public void zzI(Object var1) {
         this.zza((zzrq.zza)var1);
      }

      public void zza(zzrq.zza var1) {
         com.google.android.gms.internal.zzaf.zzj var3;
         if(var1.zzbme != null) {
            var3 = var1.zzbme;
         } else {
            com.google.android.gms.internal.zzaf.zzf var2 = var1.zzju;
            var3 = new com.google.android.gms.internal.zzaf.zzj();
            var3.zzju = var2;
            var3.zzjt = null;
            var3.zzjv = var2.version;
         }

         zzp.zza(zzp.this, var3, var1.zzbmd, true);
      }

      public void zza(zzbf.zza var1) {
         if(!zzp.this.zzbih) {
            zzp.this.zzak(0L);
         }

      }
   }

   private class zzc implements zzbf<com.google.android.gms.internal.zzaf.zzj> {
      private zzc() {
      }

      // $FF: synthetic method
      zzc(Object var2) {
         this();
      }

      public void zzGk() {
      }

      // $FF: synthetic method
      public void zzI(Object var1) {
         this.zzb((com.google.android.gms.internal.zzaf.zzj)var1);
      }

      public void zza(zzbf.zza param1) {
         // $FF: Couldn't be decompiled
      }

      public void zzb(com.google.android.gms.internal.zzaf.zzj param1) {
         // $FF: Couldn't be decompiled
      }
   }

   private class zzd implements zzo.zza {
      private zzd() {
      }

      // $FF: synthetic method
      zzd(Object var2) {
         this();
      }

      public String zzGd() {
         return zzp.this.zzGd();
      }

      public void zzGf() {
         if(zzp.this.zzbic.zzlw()) {
            zzp.this.zzak(0L);
         }

      }

      public void zzfT(String var1) {
         zzp.this.zzfT(var1);
      }
   }

   interface zze extends Releasable {
      void zza(zzbf<com.google.android.gms.internal.zzaf.zzj> var1);

      void zzf(long var1, String var3);

      void zzfW(String var1);
   }

   interface zzf extends Releasable {
      void zzGl();

      void zza(zzbf<zzrq.zza> var1);

      void zzb(zzrq.zza var1);

      zzrs.zzc zzke(int var1);
   }
}
