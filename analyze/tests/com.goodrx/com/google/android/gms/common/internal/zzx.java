package com.google.android.gms.common.internal;

import android.os.Looper;
import android.text.TextUtils;

public final class zzx {
   public static int zza(int var0, Object var1) {
      if(var0 == 0) {
         throw new IllegalArgumentException(String.valueOf(var1));
      } else {
         return var0;
      }
   }

   public static void zza(boolean var0, Object var1) {
      if(!var0) {
         throw new IllegalStateException(String.valueOf(var1));
      }
   }

   public static void zza(boolean var0, String var1, Object... var2) {
      if(!var0) {
         throw new IllegalStateException(String.format(var1, var2));
      }
   }

   public static void zzab(boolean var0) {
      if(!var0) {
         throw new IllegalStateException();
      }
   }

   public static void zzac(boolean var0) {
      if(!var0) {
         throw new IllegalArgumentException();
      }
   }

   public static <T> T zzb(T var0, Object var1) {
      if(var0 == null) {
         throw new NullPointerException(String.valueOf(var1));
      } else {
         return var0;
      }
   }

   public static void zzb(boolean var0, Object var1) {
      if(!var0) {
         throw new IllegalArgumentException(String.valueOf(var1));
      }
   }

   public static void zzb(boolean var0, String var1, Object... var2) {
      if(!var0) {
         throw new IllegalArgumentException(String.format(var1, var2));
      }
   }

   public static int zzbV(int var0) {
      if(var0 == 0) {
         throw new IllegalArgumentException("Given Integer is zero");
      } else {
         return var0;
      }
   }

   public static void zzcD(String var0) {
      if(Looper.myLooper() != Looper.getMainLooper()) {
         throw new IllegalStateException(var0);
      }
   }

   public static void zzcE(String var0) {
      if(Looper.myLooper() == Looper.getMainLooper()) {
         throw new IllegalStateException(var0);
      }
   }

   public static String zzcM(String var0) {
      if(TextUtils.isEmpty(var0)) {
         throw new IllegalArgumentException("Given String is empty or null");
      } else {
         return var0;
      }
   }

   public static String zzh(String var0, Object var1) {
      if(TextUtils.isEmpty(var0)) {
         throw new IllegalArgumentException(String.valueOf(var1));
      } else {
         return var0;
      }
   }

   public static <T> T zzz(T var0) {
      if(var0 == null) {
         throw new NullPointerException("null reference");
      } else {
         return var0;
      }
   }
}
