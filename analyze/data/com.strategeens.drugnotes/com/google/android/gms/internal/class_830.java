package com.google.android.gms.internal;

import com.google.android.gms.internal.class_829;

// $FF: renamed from: com.google.android.gms.internal.qs
class class_830 {
   private static final class_829 ayZ = new class_829();
   private boolean aza;
   private int[] azb;
   private class_829[] azc;
   private int mSize;

   public class_830() {
      this(10);
   }

   public class_830(int var1) {
      this.aza = false;
      int var2 = this.idealIntArraySize(var1);
      this.azb = new int[var2];
      this.azc = new class_829[var2];
      this.mSize = 0;
   }

   // $FF: renamed from: a (int[], int[], int) boolean
   private boolean method_4592(int[] var1, int[] var2, int var3) {
      for(int var4 = 0; var4 < var3; ++var4) {
         if(var1[var4] != var2[var4]) {
            return false;
         }
      }

      return true;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.qt[], com.google.android.gms.internal.qt[], int) boolean
   private boolean method_4593(class_829[] var1, class_829[] var2, int var3) {
      for(int var4 = 0; var4 < var3; ++var4) {
         if(!var1[var4].equals(var2[var4])) {
            return false;
         }
      }

      return true;
   }

   // $FF: renamed from: gc () void
   private void method_4594() {
      int var1 = this.mSize;
      int[] var2 = this.azb;
      class_829[] var3 = this.azc;
      int var4 = 0;

      int var5;
      for(var5 = 0; var4 < var1; ++var4) {
         class_829 var6 = var3[var4];
         if(var6 != ayZ) {
            if(var4 != var5) {
               var2[var5] = var2[var4];
               var3[var5] = var6;
               var3[var4] = null;
            }

            ++var5;
         }
      }

      this.aza = false;
      this.mSize = var5;
   }

   // $FF: renamed from: hj (int) int
   private int method_4595(int var1) {
      int var2 = 0;
      int var3 = -1 + this.mSize;

      while(var2 <= var3) {
         int var4 = var2 + var3 >>> 1;
         int var5 = this.azb[var4];
         if(var5 < var1) {
            var2 = var4 + 1;
         } else {
            if(var5 <= var1) {
               return var4;
            }

            var3 = var4 - 1;
         }
      }

      return ~var2;
   }

   private int idealByteArraySize(int var1) {
      for(int var2 = 4; var2 < 32; ++var2) {
         if(var1 <= -12 + (1 << var2)) {
            var1 = -12 + (1 << var2);
            break;
         }
      }

      return var1;
   }

   private int idealIntArraySize(int var1) {
      return this.idealByteArraySize(var1 * 4) / 4;
   }

   // $FF: renamed from: a (int, com.google.android.gms.internal.qt) void
   public void method_4596(int var1, class_829 var2) {
      int var3 = this.method_4595(var1);
      if(var3 >= 0) {
         this.azc[var3] = var2;
      } else {
         int var4 = ~var3;
         if(var4 < this.mSize && this.azc[var4] == ayZ) {
            this.azb[var4] = var1;
            this.azc[var4] = var2;
         } else {
            if(this.aza && this.mSize >= this.azb.length) {
               this.method_4594();
               var4 = ~this.method_4595(var1);
            }

            if(this.mSize >= this.azb.length) {
               int var5 = this.idealIntArraySize(1 + this.mSize);
               int[] var6 = new int[var5];
               class_829[] var7 = new class_829[var5];
               System.arraycopy(this.azb, 0, var6, 0, this.azb.length);
               System.arraycopy(this.azc, 0, var7, 0, this.azc.length);
               this.azb = var6;
               this.azc = var7;
            }

            if(this.mSize - var4 != 0) {
               System.arraycopy(this.azb, var4, this.azb, var4 + 1, this.mSize - var4);
               System.arraycopy(this.azc, var4, this.azc, var4 + 1, this.mSize - var4);
            }

            this.azb[var4] = var1;
            this.azc[var4] = var2;
            ++this.mSize;
         }
      }
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof class_830)) {
            return false;
         }

         class_830 var2 = (class_830)var1;
         if(this.size() != var2.size()) {
            return false;
         }

         if(!this.method_4592(this.azb, var2.azb, this.mSize) || !this.method_4593(this.azc, var2.azc, this.mSize)) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      if(this.aza) {
         this.method_4594();
      }

      int var1 = 17;

      for(int var2 = 0; var2 < this.mSize; ++var2) {
         var1 = 31 * (var1 * 31 + this.azb[var2]) + this.azc[var2].hashCode();
      }

      return var1;
   }

   // $FF: renamed from: hh (int) com.google.android.gms.internal.qt
   public class_829 method_4597(int var1) {
      int var2 = this.method_4595(var1);
      return var2 >= 0 && this.azc[var2] != ayZ?this.azc[var2]:null;
   }

   // $FF: renamed from: hi (int) com.google.android.gms.internal.qt
   public class_829 method_4598(int var1) {
      if(this.aza) {
         this.method_4594();
      }

      return this.azc[var1];
   }

   public boolean isEmpty() {
      return this.size() == 0;
   }

   public int size() {
      if(this.aza) {
         this.method_4594();
      }

      return this.mSize;
   }
}
