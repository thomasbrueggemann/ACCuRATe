package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.tagmanager.zzbf;
import com.google.android.gms.tagmanager.zzbg;
import com.google.android.gms.tagmanager.zzcl;
import com.google.android.gms.tagmanager.zzp;
import com.google.android.gms.tagmanager.zzs;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class zzcm implements zzp.zze {
   private boolean mClosed;
   private final Context mContext;
   private final String zzbhM;
   private String zzbij;
   private zzbf<com.google.android.gms.internal.zzaf.zzj> zzbkg;
   private zzs zzbkh;
   private final ScheduledExecutorService zzbkj;
   private final zzcm.zza zzbkk;
   private ScheduledFuture<?> zzbkl;

   public zzcm(Context var1, String var2, zzs var3) {
      this(var1, var2, var3, (zzcm.zzb)null, (zzcm.zza)null);
   }

   zzcm(Context var1, String var2, zzs var3, zzcm.zzb var4, zzcm.zza var5) {
      this.zzbkh = var3;
      this.mContext = var1;
      this.zzbhM = var2;
      if(var4 == null) {
         var4 = new zzcm.zzb() {
            public ScheduledExecutorService zzHb() {
               return Executors.newSingleThreadScheduledExecutor();
            }
         };
      }

      this.zzbkj = var4.zzHb();
      if(var5 == null) {
         this.zzbkk = new zzcm.zza() {
            public zzcl zza(zzs var1) {
               return new zzcl(zzcm.this.mContext, zzcm.this.zzbhM, var1);
            }
         };
      } else {
         this.zzbkk = var5;
      }
   }

   private void zzHa() {
      synchronized(this){}

      try {
         if(this.mClosed) {
            throw new IllegalStateException("called method after closed");
         }
      } finally {
         ;
      }

   }

   private zzcl zzgm(String var1) {
      zzcl var2 = this.zzbkk.zza(this.zzbkh);
      var2.zza(this.zzbkg);
      var2.zzfW(this.zzbij);
      var2.zzgl(var1);
      return var2;
   }

   public void release() {
      synchronized(this){}

      try {
         this.zzHa();
         if(this.zzbkl != null) {
            this.zzbkl.cancel(false);
         }

         this.zzbkj.shutdown();
         this.mClosed = true;
      } finally {
         ;
      }

   }

   public void zza(zzbf<com.google.android.gms.internal.zzaf.zzj> var1) {
      synchronized(this){}

      try {
         this.zzHa();
         this.zzbkg = var1;
      } finally {
         ;
      }

   }

   public void zzf(long var1, String var3) {
      synchronized(this){}

      try {
         zzbg.method_354("loadAfterDelay: containerId=" + this.zzbhM + " delay=" + var1);
         this.zzHa();
         if(this.zzbkg == null) {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
         }

         if(this.zzbkl != null) {
            this.zzbkl.cancel(false);
         }

         this.zzbkl = this.zzbkj.schedule(this.zzgm(var3), var1, TimeUnit.MILLISECONDS);
      } finally {
         ;
      }

   }

   public void zzfW(String var1) {
      synchronized(this){}

      try {
         this.zzHa();
         this.zzbij = var1;
      } finally {
         ;
      }

   }

   interface zza {
      zzcl zza(zzs var1);
   }

   interface zzb {
      ScheduledExecutorService zzHb();
   }
}
