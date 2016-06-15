package com.google.android.gms.internal;

import com.google.android.gms.internal.class_221;
import com.google.android.gms.internal.class_222;
import java.security.MessageDigest;

// $FF: renamed from: com.google.android.gms.internal.ar
public class class_223 extends class_222 {
   // $FF: renamed from: nZ java.security.MessageDigest
   private MessageDigest field_371;

   // $FF: renamed from: a (java.lang.String[]) byte[]
   byte[] method_1544(String[] var1) {
      byte[] var2 = new byte[var1.length];

      for(int var3 = 0; var3 < var1.length; ++var3) {
         var2[var3] = this.method_1545(class_221.method_1540(var1[var3]));
      }

      return var2;
   }

   // $FF: renamed from: e (int) byte
   byte method_1545(int var1) {
      return (byte)(var1 & 255 ^ ('\uff00' & var1) >> 8 ^ (16711680 & var1) >> 16 ^ (-16777216 & var1) >> 24);
   }

   // $FF: renamed from: l (java.lang.String) byte[]
   public byte[] method_1543(String param1) {
      // $FF: Couldn't be decompiled
   }
}
