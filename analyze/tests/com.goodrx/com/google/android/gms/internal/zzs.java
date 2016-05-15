package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class zzs {
   public static boolean DEBUG;
   public static String TAG = "Volley";

   static {
      DEBUG = Log.isLoggable(TAG, 2);
   }

   public static void zza(String var0, Object... var1) {
      if(DEBUG) {
         Log.v(TAG, zzd(var0, var1));
      }

   }

   public static void zza(Throwable var0, String var1, Object... var2) {
      Log.e(TAG, zzd(var1, var2), var0);
   }

   public static void zzb(String var0, Object... var1) {
      Log.d(TAG, zzd(var0, var1));
   }

   public static void zzc(String var0, Object... var1) {
      Log.e(TAG, zzd(var0, var1));
   }

   private static String zzd(String var0, Object... var1) {
      if(var1 != null) {
         var0 = String.format(Locale.US, var0, var1);
      }

      StackTraceElement[] var2 = (new Throwable()).fillInStackTrace().getStackTrace();
      int var3 = 2;

      String var4;
      while(true) {
         if(var3 >= var2.length) {
            var4 = "<unknown>";
            break;
         }

         if(!var2[var3].getClass().equals(zzs.class)) {
            String var7 = var2[var3].getClassName();
            String var8 = var7.substring(1 + var7.lastIndexOf(46));
            String var9 = var8.substring(1 + var8.lastIndexOf(36));
            var4 = var9 + "." + var2[var3].getMethodName();
            break;
         }

         ++var3;
      }

      Locale var5 = Locale.US;
      Object[] var6 = new Object[]{Long.valueOf(Thread.currentThread().getId()), var4, var0};
      return String.format(var5, "[%d] %s: %s", var6);
   }

   static class zza {
      public static final boolean zzak;
      private final List<zzs.zza> zzal = new ArrayList();
      private boolean zzam = false;

      static {
         zzak = zzs.DEBUG;
      }

      private long zzx() {
         if(this.zzal.size() == 0) {
            return 0L;
         } else {
            long var1 = ((zzs.zza)this.zzal.get(0)).time;
            return ((zzs.zza)this.zzal.get(-1 + this.zzal.size())).time - var1;
         }
      }

      protected void finalize() throws Throwable {
         if(!this.zzam) {
            this.zzd("Request on the loose");
            zzs.zzc("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
         }

      }

      public void zza(String var1, long var2) {
         synchronized(this){}

         try {
            if(this.zzam) {
               throw new IllegalStateException("Marker added to finished log");
            }

            this.zzal.add(new zzs.zza(var1, var2, SystemClock.elapsedRealtime()));
         } finally {
            ;
         }

      }

      public void zzd(String param1) {
         // $FF: Couldn't be decompiled
      }
   }

   private static class zza {
      public final String name;
      public final long time;
      public final long zzan;

      public zza(String var1, long var2, long var4) {
         this.name = var1;
         this.zzan = var2;
         this.time = var4;
      }
   }
}
