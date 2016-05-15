package com.google.android.gms.internal;

import com.google.android.gms.internal.zzbg;
import com.google.android.gms.internal.zzbi;
import com.google.android.gms.internal.zzhb;
import java.security.MessageDigest;

@zzhb
public class zzbj extends zzbg {
   private MessageDigest zztw;

   byte[] zza(String[] var1) {
      byte[] var2 = new byte[var1.length];

      for(int var3 = 0; var3 < var1.length; ++var3) {
         var2[var3] = this.zzk(zzbi.zzx(var1[var3]));
      }

      return var2;
   }

   byte zzk(int var1) {
      return (byte)(var1 & 255 ^ ('\uff00' & var1) >> 8 ^ (16711680 & var1) >> 16 ^ (-16777216 & var1) >> 24);
   }

   public byte[] zzu(String param1) {
      // $FF: Couldn't be decompiled
   }
}
