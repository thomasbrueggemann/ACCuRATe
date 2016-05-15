package com.google.android.gms.internal;

import com.google.android.gms.internal.zzsr;

public final class zzsq implements Cloneable {
   private static final zzsr zzbum = new zzsr();
   private int mSize;
   private boolean zzbun;
   private int[] zzbuo;
   private zzsr[] zzbup;

   zzsq() {
      this(10);
   }

   zzsq(int var1) {
      this.zzbun = false;
      int var2 = this.idealIntArraySize(var1);
      this.zzbuo = new int[var2];
      this.zzbup = new zzsr[var2];
      this.mSize = 0;
   }

   // $FF: renamed from: gc () void
   private void method_29() {
      int var1 = this.mSize;
      int[] var2 = this.zzbuo;
      zzsr[] var3 = this.zzbup;
      int var4 = 0;

      int var5;
      for(var5 = 0; var4 < var1; ++var4) {
         zzsr var6 = var3[var4];
         if(var6 != zzbum) {
            if(var4 != var5) {
               var2[var5] = var2[var4];
               var3[var5] = var6;
               var3[var4] = null;
            }

            ++var5;
         }
      }

      this.zzbun = false;
      this.mSize = var5;
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

   private boolean zza(int[] var1, int[] var2, int var3) {
      for(int var4 = 0; var4 < var3; ++var4) {
         if(var1[var4] != var2[var4]) {
            return false;
         }
      }

      return true;
   }

   private boolean zza(zzsr[] var1, zzsr[] var2, int var3) {
      for(int var4 = 0; var4 < var3; ++var4) {
         if(!var1[var4].equals(var2[var4])) {
            return false;
         }
      }

      return true;
   }

   private int zzmH(int var1) {
      int var2 = 0;
      int var3 = -1 + this.mSize;

      while(var2 <= var3) {
         int var4 = var2 + var3 >>> 1;
         int var5 = this.zzbuo[var4];
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

   // $FF: synthetic method
   public Object clone() throws CloneNotSupportedException {
      return this.zzJq();
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof zzsq)) {
            return false;
         }

         zzsq var2 = (zzsq)var1;
         if(this.size() != var2.size()) {
            return false;
         }

         if(!this.zza(this.zzbuo, var2.zzbuo, this.mSize) || !this.zza(this.zzbup, var2.zzbup, this.mSize)) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      if(this.zzbun) {
         this.method_29();
      }

      int var1 = 17;

      for(int var2 = 0; var2 < this.mSize; ++var2) {
         var1 = 31 * (var1 * 31 + this.zzbuo[var2]) + this.zzbup[var2].hashCode();
      }

      return var1;
   }

   public boolean isEmpty() {
      return this.size() == 0;
   }

   int size() {
      if(this.zzbun) {
         this.method_29();
      }

      return this.mSize;
   }

   public final zzsq zzJq() {
      int var1 = 0;
      int var2 = this.size();
      zzsq var3 = new zzsq(var2);
      System.arraycopy(this.zzbuo, 0, var3.zzbuo, 0, var2);

      for(; var1 < var2; ++var1) {
         if(this.zzbup[var1] != null) {
            var3.zzbup[var1] = this.zzbup[var1].zzJr();
         }
      }

      var3.mSize = var2;
      return var3;
   }

   void zza(int var1, zzsr var2) {
      int var3 = this.zzmH(var1);
      if(var3 >= 0) {
         this.zzbup[var3] = var2;
      } else {
         int var4 = ~var3;
         if(var4 < this.mSize && this.zzbup[var4] == zzbum) {
            this.zzbuo[var4] = var1;
            this.zzbup[var4] = var2;
         } else {
            if(this.zzbun && this.mSize >= this.zzbuo.length) {
               this.method_29();
               var4 = ~this.zzmH(var1);
            }

            if(this.mSize >= this.zzbuo.length) {
               int var5 = this.idealIntArraySize(1 + this.mSize);
               int[] var6 = new int[var5];
               zzsr[] var7 = new zzsr[var5];
               System.arraycopy(this.zzbuo, 0, var6, 0, this.zzbuo.length);
               System.arraycopy(this.zzbup, 0, var7, 0, this.zzbup.length);
               this.zzbuo = var6;
               this.zzbup = var7;
            }

            if(this.mSize - var4 != 0) {
               System.arraycopy(this.zzbuo, var4, this.zzbuo, var4 + 1, this.mSize - var4);
               System.arraycopy(this.zzbup, var4, this.zzbup, var4 + 1, this.mSize - var4);
            }

            this.zzbuo[var4] = var1;
            this.zzbup[var4] = var2;
            ++this.mSize;
         }
      }
   }

   zzsr zzmF(int var1) {
      int var2 = this.zzmH(var1);
      return var2 >= 0 && this.zzbup[var2] != zzbum?this.zzbup[var2]:null;
   }

   zzsr zzmG(int var1) {
      if(this.zzbun) {
         this.method_29();
      }

      return this.zzbup[var1];
   }
}
