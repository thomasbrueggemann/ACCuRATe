package com.google.android.gms.internal;

import java.util.Arrays;

// $FF: renamed from: com.google.android.gms.internal.mh
public final class class_636 {
   final byte[] amZ;
   final int tag;

   class_636(int var1, byte[] var2) {
      this.tag = var1;
      this.amZ = var2;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof class_636)) {
            return false;
         }

         class_636 var2 = (class_636)var1;
         if(this.tag != var2.tag || !Arrays.equals(this.amZ, var2.amZ)) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      return 31 * (527 + this.tag) + Arrays.hashCode(this.amZ);
   }
}
