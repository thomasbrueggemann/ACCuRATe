package com.google.android.gms.internal;

import com.google.android.gms.internal.class_300;
import com.google.android.gms.internal.class_822;
import com.google.android.gms.internal.class_833;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.qo
public final class class_827 {
   private int ayM;
   private int ayN;
   private int ayO;
   private int ayP;
   private int ayQ;
   private int ayR = Integer.MAX_VALUE;
   private int ayS;
   private int ayT = 64;
   private int ayU = 67108864;
   private final byte[] buffer;

   private class_827(byte[] var1, int var2, int var3) {
      this.buffer = var1;
      this.ayM = var2;
      this.ayN = var2 + var3;
      this.ayP = var2;
   }

   // $FF: renamed from: A (long) long
   public static long method_4558(long var0) {
      return var0 >>> 1 ^ -(1L & var0);
   }

   // $FF: renamed from: a (byte[], int, int) com.google.android.gms.internal.qo
   public static class_827 method_4559(byte[] var0, int var1, int var2) {
      return new class_827(var0, var1, var2);
   }

   // $FF: renamed from: gR (int) int
   public static int method_4560(int var0) {
      return var0 >>> 1 ^ -(var0 & 1);
   }

   // $FF: renamed from: p (byte[]) com.google.android.gms.internal.qo
   public static class_827 method_4561(byte[] var0) {
      return method_4559(var0, 0, var0.length);
   }

   // $FF: renamed from: rK () void
   private void method_4562() {
      this.ayN += this.ayO;
      int var1 = this.ayN;
      if(var1 > this.ayR) {
         this.ayO = var1 - this.ayR;
         this.ayN -= this.ayO;
      } else {
         this.ayO = 0;
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.qw) void
   public void method_4563(class_300 var1) throws IOException {
      int var2 = this.method_4578();
      if(this.ayS >= this.ayT) {
         throw class_833.method_4623();
      } else {
         int var3 = this.method_4567(var2);
         ++this.ayS;
         var1.method_2090(this);
         this.method_4565(0);
         this.ayS += -1;
         this.method_4568(var3);
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.qw, int) void
   public void method_4564(class_300 var1, int var2) throws IOException {
      if(this.ayS >= this.ayT) {
         throw class_833.method_4623();
      } else {
         ++this.ayS;
         var1.method_2090(this);
         this.method_4565(class_822.method_4487(var2, 4));
         this.ayS += -1;
      }
   }

   // $FF: renamed from: gP (int) void
   public void method_4565(int var1) throws class_833 {
      if(this.ayQ != var1) {
         throw class_833.method_4621();
      }
   }

   // $FF: renamed from: gQ (int) boolean
   public boolean method_4566(int var1) throws IOException {
      switch(class_822.method_4485(var1)) {
      case 0:
         this.method_4574();
         return true;
      case 1:
         this.method_4581();
         return true;
      case 2:
         this.method_4571(this.method_4578());
         return true;
      case 3:
         this.method_4572();
         this.method_4565(class_822.method_4487(class_822.method_4486(var1), 4));
         return true;
      case 4:
         return false;
      case 5:
         this.method_4580();
         return true;
      default:
         throw class_833.method_4622();
      }
   }

   // $FF: renamed from: gS (int) int
   public int method_4567(int var1) throws class_833 {
      if(var1 < 0) {
         throw class_833.method_4618();
      } else {
         int var2 = var1 + this.ayP;
         int var3 = this.ayR;
         if(var2 > var3) {
            throw class_833.method_4617();
         } else {
            this.ayR = var2;
            this.method_4562();
            return var3;
         }
      }
   }

   // $FF: renamed from: gT (int) void
   public void method_4568(int var1) {
      this.ayR = var1;
      this.method_4562();
   }

   // $FF: renamed from: gU (int) void
   public void method_4569(int var1) {
      if(var1 > this.ayP - this.ayM) {
         throw new IllegalArgumentException("Position " + var1 + " is beyond current " + (this.ayP - this.ayM));
      } else if(var1 < 0) {
         throw new IllegalArgumentException("Bad position " + var1);
      } else {
         this.ayP = var1 + this.ayM;
      }
   }

   // $FF: renamed from: gV (int) byte[]
   public byte[] method_4570(int var1) throws IOException {
      if(var1 < 0) {
         throw class_833.method_4618();
      } else if(var1 + this.ayP > this.ayR) {
         this.method_4571(this.ayR - this.ayP);
         throw class_833.method_4617();
      } else if(var1 <= this.ayN - this.ayP) {
         byte[] var2 = new byte[var1];
         System.arraycopy(this.buffer, this.ayP, var2, 0, var1);
         this.ayP += var1;
         return var2;
      } else {
         throw class_833.method_4617();
      }
   }

   // $FF: renamed from: gW (int) void
   public void method_4571(int var1) throws IOException {
      if(var1 < 0) {
         throw class_833.method_4618();
      } else if(var1 + this.ayP > this.ayR) {
         this.method_4571(this.ayR - this.ayP);
         throw class_833.method_4617();
      } else if(var1 <= this.ayN - this.ayP) {
         this.ayP += var1;
      } else {
         throw class_833.method_4617();
      }
   }

   public int getPosition() {
      return this.ayP - this.ayM;
   }

   // $FF: renamed from: rA () void
   public void method_4572() throws IOException {
      int var1;
      do {
         var1 = this.method_4585();
      } while(var1 != 0 && this.method_4566(var1));

   }

   // $FF: renamed from: rB () long
   public long method_4573() throws IOException {
      return this.method_4579();
   }

   // $FF: renamed from: rC () int
   public int method_4574() throws IOException {
      return this.method_4578();
   }

   // $FF: renamed from: rD () boolean
   public boolean method_4575() throws IOException {
      return this.method_4578() != 0;
   }

   // $FF: renamed from: rE () int
   public int method_4576() throws IOException {
      return method_4560(this.method_4578());
   }

   // $FF: renamed from: rF () long
   public long method_4577() throws IOException {
      return method_4558(this.method_4579());
   }

   // $FF: renamed from: rG () int
   public int method_4578() throws IOException {
      int var1 = this.method_4584();
      if(var1 < 0) {
         int var2 = var1 & 127;
         byte var3 = this.method_4584();
         if(var3 >= 0) {
            return var2 | var3 << 7;
         }

         int var4 = var2 | (var3 & 127) << 7;
         byte var5 = this.method_4584();
         if(var5 >= 0) {
            return var4 | var5 << 14;
         }

         int var6 = var4 | (var5 & 127) << 14;
         byte var7 = this.method_4584();
         if(var7 >= 0) {
            return var6 | var7 << 21;
         }

         int var8 = var6 | (var7 & 127) << 21;
         byte var9 = this.method_4584();
         var1 = var8 | var9 << 28;
         if(var9 < 0) {
            int var10 = 0;

            while(true) {
               if(var10 >= 5) {
                  throw class_833.method_4619();
               }

               if(this.method_4584() >= 0) {
                  break;
               }

               ++var10;
            }
         }
      }

      return var1;
   }

   // $FF: renamed from: rH () long
   public long method_4579() throws IOException {
      int var1 = 0;

      for(long var2 = 0L; var1 < 64; var1 += 7) {
         byte var4 = this.method_4584();
         var2 |= (long)(var4 & 127) << var1;
         if((var4 & 128) == 0) {
            return var2;
         }
      }

      throw class_833.method_4619();
   }

   // $FF: renamed from: rI () int
   public int method_4580() throws IOException {
      byte var1 = this.method_4584();
      byte var2 = this.method_4584();
      byte var3 = this.method_4584();
      byte var4 = this.method_4584();
      return var1 & 255 | (var2 & 255) << 8 | (var3 & 255) << 16 | (var4 & 255) << 24;
   }

   // $FF: renamed from: rJ () long
   public long method_4581() throws IOException {
      byte var1 = this.method_4584();
      byte var2 = this.method_4584();
      byte var3 = this.method_4584();
      byte var4 = this.method_4584();
      byte var5 = this.method_4584();
      byte var6 = this.method_4584();
      byte var7 = this.method_4584();
      byte var8 = this.method_4584();
      return 255L & (long)var1 | (255L & (long)var2) << 8 | (255L & (long)var3) << 16 | (255L & (long)var4) << 24 | (255L & (long)var5) << 32 | (255L & (long)var6) << 40 | (255L & (long)var7) << 48 | (255L & (long)var8) << 56;
   }

   // $FF: renamed from: rL () int
   public int method_4582() {
      if(this.ayR == Integer.MAX_VALUE) {
         return -1;
      } else {
         int var1 = this.ayP;
         return this.ayR - var1;
      }
   }

   // $FF: renamed from: rM () boolean
   public boolean method_4583() {
      return this.ayP == this.ayN;
   }

   // $FF: renamed from: rN () byte
   public byte method_4584() throws IOException {
      if(this.ayP == this.ayN) {
         throw class_833.method_4617();
      } else {
         byte[] var1 = this.buffer;
         int var2 = this.ayP;
         this.ayP = var2 + 1;
         return var1[var2];
      }
   }

   public byte[] readBytes() throws IOException {
      int var1 = this.method_4578();
      if(var1 <= this.ayN - this.ayP && var1 > 0) {
         byte[] var2 = new byte[var1];
         System.arraycopy(this.buffer, this.ayP, var2, 0, var1);
         this.ayP += var1;
         return var2;
      } else {
         return this.method_4570(var1);
      }
   }

   public double readDouble() throws IOException {
      return Double.longBitsToDouble(this.method_4581());
   }

   public float readFloat() throws IOException {
      return Float.intBitsToFloat(this.method_4580());
   }

   public String readString() throws IOException {
      int var1 = this.method_4578();
      if(var1 <= this.ayN - this.ayP && var1 > 0) {
         String var2 = new String(this.buffer, this.ayP, var1, "UTF-8");
         this.ayP += var1;
         return var2;
      } else {
         return new String(this.method_4570(var1), "UTF-8");
      }
   }

   // $FF: renamed from: rz () int
   public int method_4585() throws IOException {
      if(this.method_4583()) {
         this.ayQ = 0;
         return 0;
      } else {
         this.ayQ = this.method_4578();
         if(this.ayQ == 0) {
            throw class_833.method_4620();
         } else {
            return this.ayQ;
         }
      }
   }

   // $FF: renamed from: s (int, int) byte[]
   public byte[] method_4586(int var1, int var2) {
      if(var2 == 0) {
         return class_822.azq;
      } else {
         byte[] var3 = new byte[var2];
         int var4 = var1 + this.ayM;
         System.arraycopy(this.buffer, var4, var3, 0, var2);
         return var3;
      }
   }
}
