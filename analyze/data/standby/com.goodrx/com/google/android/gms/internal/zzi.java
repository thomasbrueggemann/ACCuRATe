package com.google.android.gms.internal;

import java.util.Map;

public class zzi {
   public final byte[] data;
   public final int statusCode;
   public final Map<String, String> zzA;
   public final boolean zzB;
   public final long zzC;

   public zzi(int var1, byte[] var2, Map<String, String> var3, boolean var4, long var5) {
      this.statusCode = var1;
      this.data = var2;
      this.zzA = var3;
      this.zzB = var4;
      this.zzC = var5;
   }

   public zzi(byte[] var1, Map<String, String> var2) {
      this(200, var1, var2, false, 0L);
   }
}
