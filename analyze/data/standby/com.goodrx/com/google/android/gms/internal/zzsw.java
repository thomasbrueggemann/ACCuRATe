package com.google.android.gms.internal;

import com.google.android.gms.internal.zzsn;
import java.io.IOException;
import java.util.Arrays;

final class zzsw {
   final int tag;
   final byte[] zzbuv;

   zzsw(int var1, byte[] var2) {
      this.tag = var1;
      this.zzbuv = var2;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof zzsw)) {
            return false;
         }

         zzsw var2 = (zzsw)var1;
         if(this.tag != var2.tag || !Arrays.equals(this.zzbuv, var2.zzbuv)) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      return 31 * (527 + this.tag) + Arrays.hashCode(this.zzbuv);
   }

   void writeTo(zzsn var1) throws IOException {
      var1.zzmB(this.tag);
      var1.zzH(this.zzbuv);
   }

   int zzz() {
      return 0 + zzsn.zzmC(this.tag) + this.zzbuv.length;
   }
}
