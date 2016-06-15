package com.google.android.gms.internal;

import com.google.android.gms.internal.class_601;
import com.google.android.gms.internal.class_605;
import com.google.android.gms.internal.class_635;
import com.google.android.gms.internal.class_637;
import com.google.android.gms.internal.mf;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.mf
public abstract class class_246 {
   protected volatile int amY = -1;

   // $FF: renamed from: a (com.google.android.gms.internal.mf, byte[]) com.google.android.gms.internal.mf
   public static final <T extends mf> T method_1717(T var0, byte[] var1) throws class_637 {
      return method_1719(var0, var1, 0, var1.length);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.mf, byte[], int, int) void
   public static final void method_1718(class_246 var0, byte[] var1, int var2, int var3) {
      try {
         class_601 var5 = class_601.method_3491(var1, var2, var3);
         var0.method_1721(var5);
         var5.method_3534();
      } catch (IOException var6) {
         throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", var6);
      }
   }

   // $FF: renamed from: b (com.google.android.gms.internal.mf, byte[], int, int) com.google.android.gms.internal.mf
   public static final <T extends mf> T method_1719(T var0, byte[] var1, int var2, int var3) throws class_637 {
      try {
         class_605 var6 = class_605.method_3547(var1, var2, var3);
         var0.method_1722(var6);
         var6.method_3555(0);
         return var0;
      } catch (class_637 var7) {
         throw var7;
      } catch (IOException var8) {
         throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
      }
   }

   // $FF: renamed from: d (com.google.android.gms.internal.mf) byte[]
   public static final byte[] method_1720(class_246 var0) {
      byte[] var1 = new byte[var0.method_1725()];
      method_1718(var0, var1, 0, var1.length);
      return var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.ma) void
   public void method_1721(class_601 var1) throws IOException {
   }

   // $FF: renamed from: b (com.google.android.gms.internal.lz) com.google.android.gms.internal.mf
   public abstract class_246 method_1722(class_605 var1) throws IOException;

   // $FF: renamed from: c () int
   protected int method_1723() {
      return 0;
   }

   // $FF: renamed from: nU () int
   public int method_1724() {
      if(this.amY < 0) {
         this.method_1725();
      }

      return this.amY;
   }

   // $FF: renamed from: nV () int
   public int method_1725() {
      int var1 = this.method_1723();
      this.amY = var1;
      return var1;
   }

   public String toString() {
      return class_635.method_3648(this);
   }
}
