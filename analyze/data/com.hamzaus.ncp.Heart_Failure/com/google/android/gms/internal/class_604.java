package com.google.android.gms.internal;

// $FF: renamed from: com.google.android.gms.internal.ly
public class class_604 {
   private final byte[] amH = new byte[256];
   private int amI;
   private int amJ;

   public class_604(byte[] var1) {
      for(int var2 = 0; var2 < 256; ++var2) {
         this.amH[var2] = (byte)var2;
      }

      int var3 = 0;

      for(int var4 = 0; var4 < 256; ++var4) {
         var3 = 255 & var3 + this.amH[var4] + var1[var4 % var1.length];
         byte var5 = this.amH[var4];
         this.amH[var4] = this.amH[var3];
         this.amH[var3] = var5;
      }

      this.amI = 0;
      this.amJ = 0;
   }

   // $FF: renamed from: o (byte[]) void
   public void method_3545(byte[] var1) {
      int var2 = this.amI;
      int var3 = this.amJ;

      for(int var4 = 0; var4 < var1.length; ++var4) {
         var2 = 255 & var2 + 1;
         var3 = 255 & var3 + this.amH[var2];
         byte var5 = this.amH[var2];
         this.amH[var2] = this.amH[var3];
         this.amH[var3] = var5;
         var1[var4] ^= this.amH[255 & this.amH[var2] + this.amH[var3]];
      }

      this.amI = var2;
      this.amJ = var3;
   }
}
