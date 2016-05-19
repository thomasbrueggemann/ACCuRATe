package com.google.android.gms.internal;

import com.google.android.gms.internal.zznd;

public class zzoz {
   private static final ThreadLocal<String> zzazL = new ThreadLocal();

   public static String zzD(String var0, String var1) {
      if(var0 != null && var1 != null) {
         byte[] var2 = new byte[var0.length() + var1.length()];
         System.arraycopy(var0.getBytes(), 0, var2, 0, var0.length());
         System.arraycopy(var1.getBytes(), 0, var2, var0.length(), var1.length());
         return Integer.toHexString(zznd.zza(var2, 0, var2.length, 0));
      } else {
         return var0;
      }
   }

   public static String zzdF(String var0) {
      return zzuH()?var0:zzD(var0, (String)zzazL.get());
   }

   public static boolean zzuH() {
      String var0 = (String)zzazL.get();
      return var0 == null || var0.startsWith("com.google");
   }
}
