package com.google.android.gms.internal;

// $FF: renamed from: com.google.android.gms.internal.qn
public class class_828 {
   private final byte[] ayJ = new byte[256];
   private int ayK;
   private int ayL;

   public class_828(byte[] var1) {
      for(int var2 = 0; var2 < 256; ++var2) {
         this.ayJ[var2] = (byte)var2;
      }

      int var3 = 0;

      for(int var4 = 0; var4 < 256; ++var4) {
         var3 = 255 & var3 + this.ayJ[var4] + var1[var4 % var1.length];
         byte var5 = this.ayJ[var4];
         this.ayJ[var4] = this.ayJ[var3];
         this.ayJ[var3] = var5;
      }

      this.ayK = 0;
      this.ayL = 0;
   }

   // $FF: renamed from: o (byte[]) void
   public void method_4587(byte[] var1) {
      int var2 = this.ayK;
      int var3 = this.ayL;

      for(int var4 = 0; var4 < var1.length; ++var4) {
         var2 = 255 & var2 + 1;
         var3 = 255 & var3 + this.ayJ[var2];
         byte var5 = this.ayJ[var2];
         this.ayJ[var2] = this.ayJ[var3];
         this.ayJ[var3] = var5;
         var1[var4] ^= this.ayJ[255 & this.ayJ[var2] + this.ayJ[var3]];
      }

      this.ayK = var2;
      this.ayL = var3;
   }
}
