package com.google.android.gms.internal;

import android.util.Base64;

public final class zzmo {
   public static String zzj(byte[] var0) {
      return var0 == null?null:Base64.encodeToString(var0, 0);
   }

   public static String zzk(byte[] var0) {
      return var0 == null?null:Base64.encodeToString(var0, 10);
   }
}
