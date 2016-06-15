package com.google.android.gms.internal;

import com.google.android.gms.internal.class_826;
import com.google.android.gms.internal.class_827;
import com.google.android.gms.internal.class_832;
import com.google.android.gms.internal.class_833;
import com.google.android.gms.internal.qw;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.qw
public abstract class class_300 {
   protected volatile int azh = -1;

   // $FF: renamed from: a (com.google.android.gms.internal.qw, byte[]) com.google.android.gms.internal.qw
   public static final <T extends qw> T method_2085(T var0, byte[] var1) throws class_833 {
      return method_2087(var0, var1, 0, var1.length);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.qw, byte[], int, int) void
   public static final void method_2086(class_300 var0, byte[] var1, int var2, int var3) {
      try {
         class_826 var5 = class_826.method_4505(var1, var2, var3);
         var0.method_2089(var5);
         var5.method_4553();
      } catch (IOException var6) {
         throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", var6);
      }
   }

   // $FF: renamed from: b (com.google.android.gms.internal.qw, byte[], int, int) com.google.android.gms.internal.qw
   public static final <T extends qw> T method_2087(T var0, byte[] var1, int var2, int var3) throws class_833 {
      try {
         class_827 var6 = class_827.method_4559(var1, var2, var3);
         var0.method_2090(var6);
         var6.method_4565(0);
         return var0;
      } catch (class_833 var7) {
         throw var7;
      } catch (IOException var8) {
         throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
      }
   }

   // $FF: renamed from: f (com.google.android.gms.internal.qw) byte[]
   public static final byte[] method_2088(class_300 var0) {
      byte[] var1 = new byte[var0.method_2093()];
      method_2086(var0, var1, 0, var1.length);
      return var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.qp) void
   public void method_2089(class_826 var1) throws IOException {
   }

   // $FF: renamed from: b (com.google.android.gms.internal.qo) com.google.android.gms.internal.qw
   public abstract class_300 method_2090(class_827 var1) throws IOException;

   // $FF: renamed from: c () int
   protected int method_2091() {
      return 0;
   }

   // $FF: renamed from: rY () int
   public int method_2092() {
      if(this.azh < 0) {
         this.method_2093();
      }

      return this.azh;
   }

   // $FF: renamed from: rZ () int
   public int method_2093() {
      int var1 = this.method_2091();
      this.azh = var1;
      return var1;
   }

   public String toString() {
      return class_832.method_4616(this);
   }
}
