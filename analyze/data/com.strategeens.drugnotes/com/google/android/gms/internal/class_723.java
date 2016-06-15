package com.google.android.gms.internal;

import android.util.Base64;

// $FF: renamed from: com.google.android.gms.internal.lb
public final class class_723 {
   // $FF: renamed from: d (byte[]) java.lang.String
   public static String method_4204(byte[] var0) {
      return var0 == null?null:Base64.encodeToString(var0, 0);
   }

   // $FF: renamed from: e (byte[]) java.lang.String
   public static String method_4205(byte[] var0) {
      return var0 == null?null:Base64.encodeToString(var0, 10);
   }
}
