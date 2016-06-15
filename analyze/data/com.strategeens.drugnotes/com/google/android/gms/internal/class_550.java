package com.google.android.gms.internal;

import com.google.android.gms.internal.class_72;
import com.google.android.gms.internal.class_826;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.p
class class_550 implements class_72 {
   // $FF: renamed from: lb com.google.android.gms.internal.qp
   private class_826 field_2534;
   // $FF: renamed from: lc byte[]
   private byte[] field_2535;
   // $FF: renamed from: ld int
   private final int field_2536;

   public class_550(int var1) {
      this.field_2536 = var1;
      this.reset();
   }

   // $FF: renamed from: D () byte[]
   public byte[] method_386() throws IOException {
      int var1 = this.field_2534.method_4552();
      if(var1 < 0) {
         throw new IOException();
      } else if(var1 == 0) {
         return this.field_2535;
      } else {
         byte[] var2 = new byte[this.field_2535.length - var1];
         System.arraycopy(this.field_2535, 0, var2, 0, var2.length);
         return var2;
      }
   }

   // $FF: renamed from: b (int, long) void
   public void method_387(int var1, long var2) throws IOException {
      this.field_2534.method_4536(var1, var2);
   }

   // $FF: renamed from: b (int, java.lang.String) void
   public void method_388(int var1, String var2) throws IOException {
      this.field_2534.method_4537(var1, var2);
   }

   public void reset() {
      this.field_2535 = new byte[this.field_2536];
      this.field_2534 = class_826.method_4522(this.field_2535);
   }
}
