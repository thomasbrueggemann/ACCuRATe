package com.google.android.gms.internal;

import com.google.android.gms.internal.class_826;
import java.io.IOException;
import java.util.Arrays;

// $FF: renamed from: com.google.android.gms.internal.qy
final class class_821 {
   final byte[] azi;
   final int tag;

   class_821(int var1, byte[] var2) {
      this.tag = var1;
      this.azi = var2;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.qp) void
   void method_4482(class_826 var1) throws IOException {
      var1.method_4549(this.tag);
      var1.method_4555(this.azi);
   }

   // $FF: renamed from: c () int
   int method_4483() {
      return 0 + class_826.method_4519(this.tag) + this.azi.length;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof class_821)) {
            return false;
         }

         class_821 var2 = (class_821)var1;
         if(this.tag != var2.tag || !Arrays.equals(this.azi, var2.azi)) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      return 31 * (527 + this.tag) + Arrays.hashCode(this.azi);
   }
}
