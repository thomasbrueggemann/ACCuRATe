package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public abstract class DowngradeableSafeParcel implements SafeParcelable {
   private static final Object zzalh = new Object();
   private static ClassLoader zzali = null;
   private static Integer zzalj = null;
   private boolean zzalk = false;

   private static boolean zza(Class<?> var0) {
      try {
         boolean var3 = "SAFE_PARCELABLE_NULL_STRING".equals(var0.getField("NULL").get((Object)null));
         return var3;
      } catch (NoSuchFieldException var4) {
         return false;
      } catch (IllegalAccessException var5) {
         return false;
      }
   }

   protected static boolean zzcF(String var0) {
      ClassLoader var1 = zzqA();
      if(var1 == null) {
         return true;
      } else {
         try {
            boolean var3 = zza(var1.loadClass(var0));
            return var3;
         } catch (Exception var4) {
            return false;
         }
      }
   }

   protected static ClassLoader zzqA() {
      // $FF: Couldn't be decompiled
   }

   protected static Integer zzqB() {
      // $FF: Couldn't be decompiled
   }

   protected boolean zzqC() {
      return this.zzalk;
   }
}
