package com.google.android.gms.internal;

import com.google.android.gms.internal.class_246;
import com.google.android.gms.internal.class_637;
import com.google.android.gms.internal.class_638;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.lz
public final class class_605 {
   private int amK;
   private int amL;
   private int amM;
   private int amN;
   private int amO;
   private int amP = Integer.MAX_VALUE;
   private int amQ;
   private int amR = 64;
   private int amS = 67108864;
   private final byte[] buffer;

   private class_605(byte[] var1, int var2, int var3) {
      this.buffer = var1;
      this.amK = var2;
      this.amL = var2 + var3;
      this.amN = var2;
   }

   // $FF: renamed from: A (long) long
   public static long method_3546(long var0) {
      return var0 >>> 1 ^ -(1L & var0);
   }

   // $FF: renamed from: a (byte[], int, int) com.google.android.gms.internal.lz
   public static class_605 method_3547(byte[] var0, int var1, int var2) {
      return new class_605(var0, var1, var2);
   }

   // $FF: renamed from: ew (int) int
   public static int method_3548(int var0) {
      return var0 >>> 1 ^ -(var0 & 1);
   }

   // $FF: renamed from: nH () void
   private void method_3549() {
      this.amL += this.amM;
      int var1 = this.amL;
      if(var1 > this.amP) {
         this.amM = var1 - this.amP;
         this.amL -= this.amM;
      } else {
         this.amM = 0;
      }
   }

   // $FF: renamed from: p (byte[]) com.google.android.gms.internal.lz
   public static class_605 method_3550(byte[] var0) {
      return method_3547(var0, 0, var0.length);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.mf) void
   public void method_3551(class_246 var1) throws IOException {
      int var2 = this.method_3563();
      if(this.amQ >= this.amR) {
         throw class_637.method_3655();
      } else {
         int var3 = this.method_3557(var2);
         ++this.amQ;
         var1.method_1722(this);
         this.method_3555(0);
         this.amQ += -1;
         this.method_3558(var3);
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.mf, int) void
   public void method_3552(class_246 var1, int var2) throws IOException {
      if(this.amQ >= this.amR) {
         throw class_637.method_3655();
      } else {
         ++this.amQ;
         var1.method_1722(this);
         this.method_3555(class_638.method_3659(var2, 4));
         this.amQ += -1;
      }
   }

   // $FF: renamed from: eA (int) byte[]
   public byte[] method_3553(int var1) throws IOException {
      if(var1 < 0) {
         throw class_637.method_3650();
      } else if(var1 + this.amN > this.amP) {
         this.method_3554(this.amP - this.amN);
         throw class_637.method_3649();
      } else if(var1 <= this.amL - this.amN) {
         byte[] var2 = new byte[var1];
         System.arraycopy(this.buffer, this.amN, var2, 0, var1);
         this.amN += var1;
         return var2;
      } else {
         throw class_637.method_3649();
      }
   }

   // $FF: renamed from: eB (int) void
   public void method_3554(int var1) throws IOException {
      if(var1 < 0) {
         throw class_637.method_3650();
      } else if(var1 + this.amN > this.amP) {
         this.method_3554(this.amP - this.amN);
         throw class_637.method_3649();
      } else if(var1 <= this.amL - this.amN) {
         this.amN += var1;
      } else {
         throw class_637.method_3649();
      }
   }

   // $FF: renamed from: eu (int) void
   public void method_3555(int var1) throws class_637 {
      if(this.amO != var1) {
         throw class_637.method_3653();
      }
   }

   // $FF: renamed from: ev (int) boolean
   public boolean method_3556(int var1) throws IOException {
      switch(class_638.method_3657(var1)) {
      case 0:
         this.method_3573();
         return true;
      case 1:
         this.method_3566();
         return true;
      case 2:
         this.method_3554(this.method_3563());
         return true;
      case 3:
         this.method_3571();
         this.method_3555(class_638.method_3659(class_638.method_3658(var1), 4));
         return true;
      case 4:
         return false;
      case 5:
         this.method_3565();
         return true;
      default:
         throw class_637.method_3654();
      }
   }

   // $FF: renamed from: ex (int) int
   public int method_3557(int var1) throws class_637 {
      if(var1 < 0) {
         throw class_637.method_3650();
      } else {
         int var2 = var1 + this.amN;
         int var3 = this.amP;
         if(var2 > var3) {
            throw class_637.method_3649();
         } else {
            this.amP = var2;
            this.method_3549();
            return var3;
         }
      }
   }

   // $FF: renamed from: ey (int) void
   public void method_3558(int var1) {
      this.amP = var1;
      this.method_3549();
   }

   // $FF: renamed from: ez (int) void
   public void method_3559(int var1) {
      if(var1 > this.amN - this.amK) {
         throw new IllegalArgumentException("Position " + var1 + " is beyond current " + (this.amN - this.amK));
      } else if(var1 < 0) {
         throw new IllegalArgumentException("Bad position " + var1);
      } else {
         this.amN = var1 + this.amK;
      }
   }

   public int getPosition() {
      return this.amN - this.amK;
   }

   // $FF: renamed from: nA () boolean
   public boolean method_3560() throws IOException {
      return this.method_3563() != 0;
   }

   // $FF: renamed from: nB () int
   public int method_3561() throws IOException {
      return method_3548(this.method_3563());
   }

   // $FF: renamed from: nC () long
   public long method_3562() throws IOException {
      return method_3546(this.method_3564());
   }

   // $FF: renamed from: nD () int
   public int method_3563() throws IOException {
      int var1 = this.method_3569();
      if(var1 < 0) {
         int var2 = var1 & 127;
         byte var3 = this.method_3569();
         if(var3 >= 0) {
            return var2 | var3 << 7;
         }

         int var4 = var2 | (var3 & 127) << 7;
         byte var5 = this.method_3569();
         if(var5 >= 0) {
            return var4 | var5 << 14;
         }

         int var6 = var4 | (var5 & 127) << 14;
         byte var7 = this.method_3569();
         if(var7 >= 0) {
            return var6 | var7 << 21;
         }

         int var8 = var6 | (var7 & 127) << 21;
         byte var9 = this.method_3569();
         var1 = var8 | var9 << 28;
         if(var9 < 0) {
            int var10 = 0;

            while(true) {
               if(var10 >= 5) {
                  throw class_637.method_3651();
               }

               if(this.method_3569() >= 0) {
                  break;
               }

               ++var10;
            }
         }
      }

      return var1;
   }

   // $FF: renamed from: nE () long
   public long method_3564() throws IOException {
      int var1 = 0;

      for(long var2 = 0L; var1 < 64; var1 += 7) {
         byte var4 = this.method_3569();
         var2 |= (long)(var4 & 127) << var1;
         if((var4 & 128) == 0) {
            return var2;
         }
      }

      throw class_637.method_3651();
   }

   // $FF: renamed from: nF () int
   public int method_3565() throws IOException {
      byte var1 = this.method_3569();
      byte var2 = this.method_3569();
      byte var3 = this.method_3569();
      byte var4 = this.method_3569();
      return var1 & 255 | (var2 & 255) << 8 | (var3 & 255) << 16 | (var4 & 255) << 24;
   }

   // $FF: renamed from: nG () long
   public long method_3566() throws IOException {
      byte var1 = this.method_3569();
      byte var2 = this.method_3569();
      byte var3 = this.method_3569();
      byte var4 = this.method_3569();
      byte var5 = this.method_3569();
      byte var6 = this.method_3569();
      byte var7 = this.method_3569();
      byte var8 = this.method_3569();
      return 255L & (long)var1 | (255L & (long)var2) << 8 | (255L & (long)var3) << 16 | (255L & (long)var4) << 24 | (255L & (long)var5) << 32 | (255L & (long)var6) << 40 | (255L & (long)var7) << 48 | (255L & (long)var8) << 56;
   }

   // $FF: renamed from: nI () int
   public int method_3567() {
      if(this.amP == Integer.MAX_VALUE) {
         return -1;
      } else {
         int var1 = this.amN;
         return this.amP - var1;
      }
   }

   // $FF: renamed from: nJ () boolean
   public boolean method_3568() {
      return this.amN == this.amL;
   }

   // $FF: renamed from: nK () byte
   public byte method_3569() throws IOException {
      if(this.amN == this.amL) {
         throw class_637.method_3649();
      } else {
         byte[] var1 = this.buffer;
         int var2 = this.amN;
         this.amN = var2 + 1;
         return var1[var2];
      }
   }

   // $FF: renamed from: nw () int
   public int method_3570() throws IOException {
      if(this.method_3568()) {
         this.amO = 0;
         return 0;
      } else {
         this.amO = this.method_3563();
         if(this.amO == 0) {
            throw class_637.method_3652();
         } else {
            return this.amO;
         }
      }
   }

   // $FF: renamed from: nx () void
   public void method_3571() throws IOException {
      int var1;
      do {
         var1 = this.method_3570();
      } while(var1 != 0 && this.method_3556(var1));

   }

   // $FF: renamed from: ny () long
   public long method_3572() throws IOException {
      return this.method_3564();
   }

   // $FF: renamed from: nz () int
   public int method_3573() throws IOException {
      return this.method_3563();
   }

   // $FF: renamed from: o (int, int) byte[]
   public byte[] method_3574(int var1, int var2) {
      if(var2 == 0) {
         return class_638.anh;
      } else {
         byte[] var3 = new byte[var2];
         int var4 = var1 + this.amK;
         System.arraycopy(this.buffer, var4, var3, 0, var2);
         return var3;
      }
   }

   public byte[] readBytes() throws IOException {
      int var1 = this.method_3563();
      if(var1 <= this.amL - this.amN && var1 > 0) {
         byte[] var2 = new byte[var1];
         System.arraycopy(this.buffer, this.amN, var2, 0, var1);
         this.amN += var1;
         return var2;
      } else {
         return this.method_3553(var1);
      }
   }

   public double readDouble() throws IOException {
      return Double.longBitsToDouble(this.method_3566());
   }

   public float readFloat() throws IOException {
      return Float.intBitsToFloat(this.method_3565());
   }

   public String readString() throws IOException {
      int var1 = this.method_3563();
      if(var1 <= this.amL - this.amN && var1 > 0) {
         String var2 = new String(this.buffer, this.amN, var1, "UTF-8");
         this.amN += var1;
         return var2;
      } else {
         return new String(this.method_3553(var1), "UTF-8");
      }
   }
}
