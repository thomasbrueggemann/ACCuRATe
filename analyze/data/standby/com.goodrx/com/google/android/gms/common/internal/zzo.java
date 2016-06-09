package com.google.android.gms.common.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzx;

public final class zzo {
   public static final int zzaml = 23 - " PII_LOG".length();
   private static final String zzamm = null;
   private final String zzamn;
   private final String zzamo;

   public zzo(String var1) {
      this(var1, zzamm);
   }

   public zzo(String var1, String var2) {
      zzx.zzb(var1, "log tag cannot be null");
      boolean var4;
      if(var1.length() <= 23) {
         var4 = true;
      } else {
         var4 = false;
      }

      Object[] var5 = new Object[]{var1, Integer.valueOf(23)};
      zzx.zzb(var4, "tag \"%s\" is longer than the %d character maximum", var5);
      this.zzamn = var1;
      if(var2 != null && var2.length() > 0) {
         this.zzamo = var2;
      } else {
         this.zzamo = zzamm;
      }
   }

   private String zzcK(String var1) {
      return this.zzamo == null?var1:this.zzamo.concat(var1);
   }

   public void zzA(String var1, String var2) {
      if(this.zzbU(6)) {
         Log.e(var1, this.zzcK(var2));
      }

   }

   public boolean zzbU(int var1) {
      return Log.isLoggable(this.zzamn, var1);
   }

   public void zzz(String var1, String var2) {
      if(this.zzbU(5)) {
         Log.w(var1, this.zzcK(var2));
      }

   }
}
