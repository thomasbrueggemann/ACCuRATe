package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionEvent;
import com.google.android.gms.common.stats.zzc;
import com.google.android.gms.common.stats.zzd;
import com.google.android.gms.common.stats.zze;
import com.google.android.gms.internal.zzmp;
import com.google.android.gms.internal.zznf;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class zzb {
   private static final Object zzalX = new Object();
   private static zzb zzanp;
   private static Integer zzanv;
   private final List<String> zzanq;
   private final List<String> zzanr;
   private final List<String> zzans;
   private final List<String> zzant;
   private zze zzanu;
   private zze zzanw;

   private zzb() {
      if(getLogLevel() == zzd.LOG_LEVEL_OFF) {
         this.zzanq = Collections.EMPTY_LIST;
         this.zzanr = Collections.EMPTY_LIST;
         this.zzans = Collections.EMPTY_LIST;
         this.zzant = Collections.EMPTY_LIST;
      } else {
         String var1 = (String)zzc.zza.zzanA.get();
         List var2;
         if(var1 == null) {
            var2 = Collections.EMPTY_LIST;
         } else {
            var2 = Arrays.asList(var1.split(","));
         }

         this.zzanq = var2;
         String var3 = (String)zzc.zza.zzanB.get();
         List var4;
         if(var3 == null) {
            var4 = Collections.EMPTY_LIST;
         } else {
            var4 = Arrays.asList(var3.split(","));
         }

         this.zzanr = var4;
         String var5 = (String)zzc.zza.zzanC.get();
         List var6;
         if(var5 == null) {
            var6 = Collections.EMPTY_LIST;
         } else {
            var6 = Arrays.asList(var5.split(","));
         }

         this.zzans = var6;
         String var7 = (String)zzc.zza.zzanD.get();
         List var8;
         if(var7 == null) {
            var8 = Collections.EMPTY_LIST;
         } else {
            var8 = Arrays.asList(var7.split(","));
         }

         this.zzant = var8;
         this.zzanu = new zze(1024, ((Long)zzc.zza.zzanE.get()).longValue());
         this.zzanw = new zze(1024, ((Long)zzc.zza.zzanE.get()).longValue());
      }
   }

   private static int getLogLevel() {
      // $FF: Couldn't be decompiled
   }

   private void zza(Context var1, String var2, int var3, String var4, String var5, String var6, String var7) {
      long var8 = System.currentTimeMillis();
      int var10 = getLogLevel() & zzd.zzanJ;
      String var11 = null;
      if(var10 != 0) {
         var11 = null;
         if(var3 != 13) {
            var11 = zznf.zzn(3, 5);
         }
      }

      long var12 = 0L;
      if((getLogLevel() & zzd.zzanL) != 0) {
         var12 = Debug.getNativeHeapAllocatedSize();
      }

      ConnectionEvent var14;
      if(var3 != 1 && var3 != 4 && var3 != 14) {
         var14 = new ConnectionEvent(var8, var3, var4, var5, var6, var7, var11, var2, SystemClock.elapsedRealtime(), var12);
      } else {
         var14 = new ConnectionEvent(var8, var3, (String)null, (String)null, (String)null, (String)null, var11, var2, SystemClock.elapsedRealtime(), var12);
      }

      var1.startService((new Intent()).setComponent(zzd.zzanF).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", var14));
   }

   private void zza(Context var1, String var2, String var3, Intent var4, int var5) {
      String var6 = null;
      if(this.zzrQ() && this.zzanu != null) {
         String var7;
         String var8;
         if(var5 != 4 && var5 != 1) {
            ServiceInfo var9 = zzd(var1, var4);
            if(var9 == null) {
               Object[] var11 = new Object[]{var3, var4.toUri(0)};
               Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", var11));
               return;
            }

            var8 = var9.processName;
            var7 = var9.name;
            var6 = zznf.zzaz(var1);
            if(!this.zzb(var6, var3, var8, var7)) {
               return;
            }

            this.zzanu.zzcS(var2);
         } else {
            if(!this.zzanu.zzcT(var2)) {
               return;
            }

            var7 = null;
            var8 = null;
         }

         this.zza(var1, var2, var5, var6, var3, var8, var7);
      }
   }

   private String zzb(ServiceConnection var1) {
      return String.valueOf((long)Process.myPid() << 32 | (long)System.identityHashCode(var1));
   }

   private boolean zzb(String var1, String var2, String var3, String var4) {
      int var5 = getLogLevel();
      return !this.zzanq.contains(var1) && !this.zzanr.contains(var2) && !this.zzans.contains(var3) && !this.zzant.contains(var4) && (!var3.equals(var1) || (var5 & zzd.zzanK) == 0);
   }

   private boolean zzc(Context var1, Intent var2) {
      ComponentName var3 = var2.getComponent();
      return var3 != null && (!com.google.android.gms.common.internal.zzd.zzakE || !"com.google.android.gms".equals(var3.getPackageName()))?zzmp.zzk(var1, var3.getPackageName()):false;
   }

   private static ServiceInfo zzd(Context var0, Intent var1) {
      List var2 = var0.getPackageManager().queryIntentServices(var1, 128);
      if(var2 != null && var2.size() != 0) {
         if(var2.size() > 1) {
            Object[] var5 = new Object[]{var1.toUri(0), zznf.zzn(3, 20)};
            Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", var5));
            Iterator var7 = var2.iterator();
            if(var7.hasNext()) {
               Log.w("ConnectionTracker", ((ResolveInfo)var7.next()).serviceInfo.name);
               return null;
            }
         }

         return ((ResolveInfo)var2.get(0)).serviceInfo;
      } else {
         Object[] var3 = new Object[]{var1.toUri(0), zznf.zzn(3, 20)};
         Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", var3));
         return null;
      }
   }

   public static zzb zzrP() {
      // $FF: Couldn't be decompiled
   }

   private boolean zzrQ() {
      return com.google.android.gms.common.internal.zzd.zzakE && getLogLevel() != zzd.LOG_LEVEL_OFF;
   }

   @SuppressLint({"UntrackedBindService"})
   public void zza(Context var1, ServiceConnection var2) {
      var1.unbindService(var2);
      this.zza(var1, this.zzb(var2), (String)null, (Intent)null, 1);
   }

   public void zza(Context var1, ServiceConnection var2, String var3, Intent var4) {
      this.zza(var1, this.zzb(var2), (String)var3, (Intent)var4, 3);
   }

   public boolean zza(Context var1, Intent var2, ServiceConnection var3, int var4) {
      return this.zza(var1, var1.getClass().getName(), var2, var3, var4);
   }

   @SuppressLint({"UntrackedBindService"})
   public boolean zza(Context var1, String var2, Intent var3, ServiceConnection var4, int var5) {
      if(this.zzc(var1, var3)) {
         Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
         return false;
      } else {
         boolean var6 = var1.bindService(var3, var4, var5);
         if(var6) {
            this.zza(var1, this.zzb(var4), (String)var2, (Intent)var3, 2);
         }

         return var6;
      }
   }

   public void zzb(Context var1, ServiceConnection var2) {
      this.zza(var1, this.zzb(var2), (String)null, (Intent)null, 4);
   }
}
