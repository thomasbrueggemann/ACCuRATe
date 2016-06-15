package com.google.android.gms.internal;

import com.google.android.gms.internal.class_601;
import com.google.android.gms.internal.class_66;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.q
class class_455 implements class_66 {
   // $FF: renamed from: kl com.google.android.gms.internal.ma
   private class_601 field_2737;
   // $FF: renamed from: km byte[]
   private byte[] field_2738;
   // $FF: renamed from: kn int
   private final int field_2739;

   public class_455(int var1) {
      this.field_2739 = var1;
      this.reset();
   }

   // $FF: renamed from: b (int, long) void
   public void method_340(int var1, long var2) throws IOException {
      this.field_2737.method_3520(var1, var2);
   }

   // $FF: renamed from: b (int, java.lang.String) void
   public void method_341(int var1, String var2) throws IOException {
      this.field_2737.method_3521(var1, var2);
   }

   public void reset() {
      this.field_2738 = new byte[this.field_2739];
      this.field_2737 = class_601.method_3505(this.field_2738);
   }

   // $FF: renamed from: z () byte[]
   public byte[] method_342() throws IOException {
      int var1 = this.field_2737.method_3533();
      if(var1 < 0) {
         throw new IOException();
      } else if(var1 == 0) {
         return this.field_2738;
      } else {
         byte[] var2 = new byte[this.field_2738.length - var1];
         System.arraycopy(this.field_2738, 0, var2, 0, var2.length);
         return var2;
      }
   }
}
