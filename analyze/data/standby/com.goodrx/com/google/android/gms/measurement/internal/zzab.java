package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.EventParams;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import com.google.android.gms.measurement.internal.zzaj;
import com.google.android.gms.measurement.internal.zzw;
import com.google.android.gms.measurement.internal.zzz;
import java.lang.reflect.Method;
import java.util.Iterator;

public class zzab extends zzz {
   private zzab.zza zzaYD;
   private AppMeasurement.zza zzaYE;
   private boolean zzaYF;

   protected zzab(zzw var1) {
      super(var1);
   }

   @WorkerThread
   private void zzDm() {
      try {
         this.zzh(Class.forName(this.zzDn()));
      } catch (ClassNotFoundException var2) {
         this.zzAo().zzCI().zzfg("Tag Manager is not found and thus will not be used");
      }
   }

   private String zzDn() {
      return "com.google.android.gms.tagmanager.TagManagerService";
   }

   // $FF: synthetic method
   static void zza(zzab var0, String var1, String var2, long var3, Bundle var5, boolean var6, String var7) {
      var0.zzb(var1, var2, var3, var5, var6, var7);
   }

   // $FF: synthetic method
   static void zza(zzab var0, boolean var1) {
      var0.zzas(var1);
   }

   private void zza(String var1, String var2, Bundle var3, boolean var4, String var5) {
      this.zza(var1, var2, var3, var4, var5, this.zzjl().currentTimeMillis());
   }

   private void zza(String var1, String var2, Bundle var3, boolean var4, String var5, long var6) {
      com.google.android.gms.common.internal.zzx.zzcM(var1);
      this.zzCk().zzfr(var2);
      Bundle var9 = new Bundle();
      if(var3 != null) {
         int var12 = this.zzCp().zzBA();
         Iterator var13 = var3.keySet().iterator();
         int var14 = 0;

         while(var13.hasNext()) {
            String var15 = (String)var13.next();
            this.zzCk().zzft(var15);
            if(zzaj.zzfq(var15)) {
               int var17 = var14 + 1;
               boolean var18;
               if(var17 <= var12) {
                  var18 = true;
               } else {
                  var18 = false;
               }

               com.google.android.gms.common.internal.zzx.zzb(var18, "Event can\'t contain more then " + var12 + " params");
               var14 = var17;
            }

            Object var16 = this.zzCk().zzk(var15, var3.get(var15));
            if(var16 != null) {
               this.zzCk().zza(var9, var15, var16);
            }
         }
      }

      int var10 = this.zzCp().zzBD();
      String var11;
      if(var1.length() <= var10) {
         var11 = var1;
      } else {
         var11 = var1.substring(0, var10);
      }

      var9.putString("_o", var11);
      this.zza(var1, var2, var6, var9, var4, var5);
   }

   @WorkerThread
   private void zza(String var1, String var2, Object var3, long var4) {
      com.google.android.gms.common.internal.zzx.zzcM(var1);
      com.google.android.gms.common.internal.zzx.zzcM(var2);
      this.zzjk();
      this.zzjj();
      this.zzjv();
      if(!this.zzCo().zzAr()) {
         this.zzAo().zzCJ().zzfg("User property not set since app measurement is disabled");
      } else if(this.zzaTV.zzCS()) {
         this.zzAo().zzCJ().zze("Setting user property (FE)", var2, var3);
         UserAttributeParcel var8 = new UserAttributeParcel(var2, var4, var3, var1);
         this.zzCi().zza(var8);
         return;
      }

   }

   @WorkerThread
   private void zzas(boolean var1) {
      this.zzjk();
      this.zzjj();
      this.zzjv();
      this.zzAo().zzCJ().zzj("Setting app measurement enabled (FE)", Boolean.valueOf(var1));
      this.zzCo().setMeasurementEnabled(var1);
      this.zzCi().zzDo();
   }

   @WorkerThread
   private void zzb(String var1, String var2, long var3, Bundle var5, boolean var6, String var7) {
      com.google.android.gms.common.internal.zzx.zzcM(var1);
      com.google.android.gms.common.internal.zzx.zzcM(var2);
      com.google.android.gms.common.internal.zzx.zzz(var5);
      this.zzjk();
      this.zzjv();
      if(!this.zzCo().zzAr()) {
         this.zzAo().zzCJ().zzfg("Event not sent since app measurement is disabled");
      } else {
         if(!this.zzaYF) {
            this.zzaYF = true;
            this.zzDm();
         }

         if(var6 && this.zzaYE != null && !zzaj.zzfv(var2)) {
            this.zzAo().zzCJ().zze("Passing event to registered event handler (FE)", var2, var5);
            this.zzaYE.zza(var1, var2, var5, var3);
            return;
         }

         if(this.zzaTV.zzCS()) {
            this.zzAo().zzCJ().zze("Logging event (FE)", var2, var5);
            EventParcel var11 = new EventParcel(var2, new EventParams(var5), var1, var3);
            this.zzCi().zzb(var11, var7);
            return;
         }
      }

   }

   @TargetApi(14)
   public void zzDk() {
      if(this.getContext().getApplicationContext() instanceof Application) {
         Application var1 = (Application)this.getContext().getApplicationContext();
         if(this.zzaYD == null) {
            this.zzaYD = new zzab.zza(null);
         }

         var1.unregisterActivityLifecycleCallbacks(this.zzaYD);
         var1.registerActivityLifecycleCallbacks(this.zzaYD);
         this.zzAo().zzCK().zzfg("Registered activity lifecycle callback");
      }

   }

   @WorkerThread
   public void zzDl() {
      this.zzjk();
      this.zzjj();
      this.zzjv();
      if(this.zzaTV.zzCS()) {
         this.zzCi().zzDl();
         String var1 = this.zzCo().zzCQ();
         if(!TextUtils.isEmpty(var1) && !var1.equals(this.zzCh().zzCy())) {
            Bundle var2 = new Bundle();
            var2.putString("_po", var1);
            this.zze("auto", "_ou", var2);
            return;
         }
      }

   }

   protected void zza(final String var1, final String var2, final long var3, final Bundle var5, final boolean var6, final String var7) {
      com.google.android.gms.common.internal.zzx.zzz(var5);
      this.zzCn().zzg(new Runnable() {
         public void run() {
            zzab.zza(zzab.this, var1, var2, var3, var5, var6, var7);
         }
      });
   }

   void zza(final String var1, final String var2, final long var3, final Object var5) {
      this.zzCn().zzg(new Runnable() {
         public void run() {
            zzab.this.zza(var1, var2, var5, var3);
         }
      });
   }

   public void zza(String var1, String var2, Object var3) {
      com.google.android.gms.common.internal.zzx.zzcM(var1);
      long var5 = this.zzjl().currentTimeMillis();
      this.zzCk().zzfs(var2);
      if(var3 != null) {
         this.zzCk().zzl(var2, var3);
         Object var7 = this.zzCk().zzm(var2, var3);
         if(var7 != null) {
            this.zza(var1, var2, var5, var7);
         }

      } else {
         this.zza(var1, var2, var5, (Object)null);
      }
   }

   public void zze(String var1, String var2, Bundle var3) {
      this.zzjj();
      this.zza(var1, var2, var3, true, (String)null);
   }

   @WorkerThread
   public void zzh(Class<?> var1) {
      try {
         Method var3 = var1.getDeclaredMethod("initialize", new Class[]{Context.class});
         Object[] var4 = new Object[]{this.getContext()};
         var3.invoke((Object)null, var4);
      } catch (Exception var5) {
         this.zzAo().zzCF().zzj("Failed to invoke Tag Manager\'s initialize() method", var5);
      }
   }

   protected void zziJ() {
   }

   @TargetApi(14)
   @MainThread
   private class zza implements ActivityLifecycleCallbacks {
      private zza() {
      }

      // $FF: synthetic method
      zza(Object var2) {
         this();
      }

      private boolean zzfo(String var1) {
         if(!TextUtils.isEmpty(var1)) {
            zzab.this.zza("auto", "_ldl", var1);
            return true;
         } else {
            return false;
         }
      }

      public void onActivityCreated(Activity param1, Bundle param2) {
         // $FF: Couldn't be decompiled
      }

      public void onActivityDestroyed(Activity var1) {
      }

      @MainThread
      public void onActivityPaused(Activity var1) {
         zzab.this.zzCm().zzDw();
      }

      @MainThread
      public void onActivityResumed(Activity var1) {
         zzab.this.zzCm().zzDu();
      }

      public void onActivitySaveInstanceState(Activity var1, Bundle var2) {
      }

      public void onActivityStarted(Activity var1) {
      }

      public void onActivityStopped(Activity var1) {
      }
   }
}
