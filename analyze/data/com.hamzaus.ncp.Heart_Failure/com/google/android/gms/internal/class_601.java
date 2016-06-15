package com.google.android.gms.internal;

import com.google.android.gms.internal.class_246;
import com.google.android.gms.internal.class_638;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

// $FF: renamed from: com.google.android.gms.internal.ma
public final class class_601 {
   private final int amT;
   private final byte[] buffer;
   private int position;

   private class_601(byte[] var1, int var2, int var3) {
      this.buffer = var1;
      this.position = var2;
      this.amT = var2 + var3;
   }

   // $FF: renamed from: D (long) int
   public static int method_3482(long var0) {
      return method_3484(var0);
   }

   // $FF: renamed from: E (long) int
   public static int method_3483(long var0) {
      return method_3484(method_3485(var0));
   }

   // $FF: renamed from: G (long) int
   public static int method_3484(long var0) {
      return (-128L & var0) == 0L?1:((-16384L & var0) == 0L?2:((-2097152L & var0) == 0L?3:((-268435456L & var0) == 0L?4:((-34359738368L & var0) == 0L?5:((-4398046511104L & var0) == 0L?6:((-562949953421312L & var0) == 0L?7:((-72057594037927936L & var0) == 0L?8:((Long.MIN_VALUE & var0) == 0L?9:10))))))));
   }

   // $FF: renamed from: I (long) long
   public static long method_3485(long var0) {
      return var0 << 1 ^ var0 >> 63;
   }

   // $FF: renamed from: J (boolean) int
   public static int method_3486(boolean var0) {
      return 1;
   }

   // $FF: renamed from: b (int, double) int
   public static int method_3487(int var0, double var1) {
      return method_3500(var0) + method_3503(var1);
   }

   // $FF: renamed from: b (int, com.google.android.gms.internal.mf) int
   public static int method_3488(int var0, class_246 var1) {
      return method_3500(var0) + method_3493(var1);
   }

   // $FF: renamed from: b (int, boolean) int
   public static int method_3489(int var0, boolean var1) {
      return method_3500(var0) + method_3486(var1);
   }

   // $FF: renamed from: b (int, byte[]) int
   public static int method_3490(int var0, byte[] var1) {
      return method_3500(var0) + method_3508(var1);
   }

   // $FF: renamed from: b (byte[], int, int) com.google.android.gms.internal.ma
   public static class_601 method_3491(byte[] var0, int var1, int var2) {
      return new class_601(var0, var1, var2);
   }

   // $FF: renamed from: c (int, float) int
   public static int method_3492(int var0, float var1) {
      return method_3500(var0) + method_3496(var1);
   }

   // $FF: renamed from: c (com.google.android.gms.internal.mf) int
   public static int method_3493(class_246 var0) {
      int var1 = var0.method_1725();
      return var1 + method_3501(var1);
   }

   // $FF: renamed from: cz (java.lang.String) int
   public static int method_3494(String var0) {
      int var3;
      int var4;
      try {
         byte[] var2 = var0.getBytes("UTF-8");
         var3 = method_3501(var2.length);
         var4 = var2.length;
      } catch (UnsupportedEncodingException var5) {
         throw new RuntimeException("UTF-8 not supported.");
      }

      return var4 + var3;
   }

   // $FF: renamed from: d (int, long) int
   public static int method_3495(int var0, long var1) {
      return method_3500(var0) + method_3482(var1);
   }

   // $FF: renamed from: e (float) int
   public static int method_3496(float var0) {
      return 4;
   }

   // $FF: renamed from: e (int, long) int
   public static int method_3497(int var0, long var1) {
      return method_3500(var0) + method_3483(var1);
   }

   // $FF: renamed from: eE (int) int
   public static int method_3498(int var0) {
      return var0 >= 0?method_3501(var0):10;
   }

   // $FF: renamed from: eF (int) int
   public static int method_3499(int var0) {
      return method_3501(method_3502(var0));
   }

   // $FF: renamed from: eH (int) int
   public static int method_3500(int var0) {
      return method_3501(class_638.method_3659(var0, 0));
   }

   // $FF: renamed from: eJ (int) int
   public static int method_3501(int var0) {
      return (var0 & -128) == 0?1:((var0 & -16384) == 0?2:((-2097152 & var0) == 0?3:((-268435456 & var0) == 0?4:5)));
   }

   // $FF: renamed from: eL (int) int
   public static int method_3502(int var0) {
      return var0 << 1 ^ var0 >> 31;
   }

   // $FF: renamed from: f (double) int
   public static int method_3503(double var0) {
      return 8;
   }

   // $FF: renamed from: h (int, java.lang.String) int
   public static int method_3504(int var0, String var1) {
      return method_3500(var0) + method_3494(var1);
   }

   // $FF: renamed from: q (byte[]) com.google.android.gms.internal.ma
   public static class_601 method_3505(byte[] var0) {
      return method_3491(var0, 0, var0.length);
   }

   // $FF: renamed from: r (int, int) int
   public static int method_3506(int var0, int var1) {
      return method_3500(var0) + method_3498(var1);
   }

   // $FF: renamed from: s (int, int) int
   public static int method_3507(int var0, int var1) {
      return method_3500(var0) + method_3499(var1);
   }

   // $FF: renamed from: s (byte[]) int
   public static int method_3508(byte[] var0) {
      return method_3501(var0.length) + var0.length;
   }

   // $FF: renamed from: B (long) void
   public void method_3509(long var1) throws IOException {
      this.method_3511(var1);
   }

   // $FF: renamed from: C (long) void
   public void method_3510(long var1) throws IOException {
      this.method_3511(method_3485(var1));
   }

   // $FF: renamed from: F (long) void
   public void method_3511(long var1) throws IOException {
      while((-128L & var1) != 0L) {
         this.method_3530(128 | 127 & (int)var1);
         var1 >>>= 7;
      }

      this.method_3530((int)var1);
   }

   // $FF: renamed from: H (long) void
   public void method_3512(long var1) throws IOException {
      this.method_3530(255 & (int)var1);
      this.method_3530(255 & (int)(var1 >> 8));
      this.method_3530(255 & (int)(var1 >> 16));
      this.method_3530(255 & (int)(var1 >> 24));
      this.method_3530(255 & (int)(var1 >> 32));
      this.method_3530(255 & (int)(var1 >> 40));
      this.method_3530(255 & (int)(var1 >> 48));
      this.method_3530(255 & (int)(var1 >> 56));
   }

   // $FF: renamed from: I (boolean) void
   public void method_3513(boolean var1) throws IOException {
      byte var2;
      if(var1) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      this.method_3530(var2);
   }

   // $FF: renamed from: a (int, double) void
   public void method_3514(int var1, double var2) throws IOException {
      this.method_3538(var1, 1);
      this.method_3527(var2);
   }

   // $FF: renamed from: a (int, com.google.android.gms.internal.mf) void
   public void method_3515(int var1, class_246 var2) throws IOException {
      this.method_3538(var1, 2);
      this.method_3522(var2);
   }

   // $FF: renamed from: a (int, boolean) void
   public void method_3516(int var1, boolean var2) throws IOException {
      this.method_3538(var1, 0);
      this.method_3513(var2);
   }

   // $FF: renamed from: a (int, byte[]) void
   public void method_3517(int var1, byte[] var2) throws IOException {
      this.method_3538(var1, 2);
      this.method_3537(var2);
   }

   // $FF: renamed from: b (byte) void
   public void method_3518(byte var1) throws IOException {
      if(this.position == this.amT) {
         throw new class_601.class_874(this.position, this.amT);
      } else {
         byte[] var2 = this.buffer;
         int var3 = this.position;
         this.position = var3 + 1;
         var2[var3] = var1;
      }
   }

   // $FF: renamed from: b (int, float) void
   public void method_3519(int var1, float var2) throws IOException {
      this.method_3538(var1, 5);
      this.method_3526(var2);
   }

   // $FF: renamed from: b (int, long) void
   public void method_3520(int var1, long var2) throws IOException {
      this.method_3538(var1, 0);
      this.method_3509(var2);
   }

   // $FF: renamed from: b (int, java.lang.String) void
   public void method_3521(int var1, String var2) throws IOException {
      this.method_3538(var1, 2);
      this.method_3525(var2);
   }

   // $FF: renamed from: b (com.google.android.gms.internal.mf) void
   public void method_3522(class_246 var1) throws IOException {
      this.method_3531(var1.method_1724());
      var1.method_1721(this);
   }

   // $FF: renamed from: c (int, long) void
   public void method_3523(int var1, long var2) throws IOException {
      this.method_3538(var1, 0);
      this.method_3510(var2);
   }

   // $FF: renamed from: c (byte[], int, int) void
   public void method_3524(byte[] var1, int var2, int var3) throws IOException {
      if(this.amT - this.position >= var3) {
         System.arraycopy(var1, var2, this.buffer, this.position, var3);
         this.position += var3;
      } else {
         throw new class_601.class_874(this.position, this.amT);
      }
   }

   // $FF: renamed from: cy (java.lang.String) void
   public void method_3525(String var1) throws IOException {
      byte[] var2 = var1.getBytes("UTF-8");
      this.method_3531(var2.length);
      this.method_3539(var2);
   }

   // $FF: renamed from: d (float) void
   public void method_3526(float var1) throws IOException {
      this.method_3532(Float.floatToIntBits(var1));
   }

   // $FF: renamed from: e (double) void
   public void method_3527(double var1) throws IOException {
      this.method_3512(Double.doubleToLongBits(var1));
   }

   // $FF: renamed from: eC (int) void
   public void method_3528(int var1) throws IOException {
      if(var1 >= 0) {
         this.method_3531(var1);
      } else {
         this.method_3511((long)var1);
      }
   }

   // $FF: renamed from: eD (int) void
   public void method_3529(int var1) throws IOException {
      this.method_3531(method_3502(var1));
   }

   // $FF: renamed from: eG (int) void
   public void method_3530(int var1) throws IOException {
      this.method_3518((byte)var1);
   }

   // $FF: renamed from: eI (int) void
   public void method_3531(int var1) throws IOException {
      while((var1 & -128) != 0) {
         this.method_3530(128 | var1 & 127);
         var1 >>>= 7;
      }

      this.method_3530(var1);
   }

   // $FF: renamed from: eK (int) void
   public void method_3532(int var1) throws IOException {
      this.method_3530(var1 & 255);
      this.method_3530(255 & var1 >> 8);
      this.method_3530(255 & var1 >> 16);
      this.method_3530(255 & var1 >> 24);
   }

   // $FF: renamed from: nL () int
   public int method_3533() {
      return this.amT - this.position;
   }

   // $FF: renamed from: nM () void
   public void method_3534() {
      if(this.method_3533() != 0) {
         throw new IllegalStateException("Did not write as much data as expected.");
      }
   }

   // $FF: renamed from: p (int, int) void
   public void method_3535(int var1, int var2) throws IOException {
      this.method_3538(var1, 0);
      this.method_3528(var2);
   }

   // $FF: renamed from: q (int, int) void
   public void method_3536(int var1, int var2) throws IOException {
      this.method_3538(var1, 0);
      this.method_3529(var2);
   }

   // $FF: renamed from: r (byte[]) void
   public void method_3537(byte[] var1) throws IOException {
      this.method_3531(var1.length);
      this.method_3539(var1);
   }

   // $FF: renamed from: t (int, int) void
   public void method_3538(int var1, int var2) throws IOException {
      this.method_3531(class_638.method_3659(var1, var2));
   }

   // $FF: renamed from: t (byte[]) void
   public void method_3539(byte[] var1) throws IOException {
      this.method_3524(var1, 0, var1.length);
   }

   public static class class_874 extends IOException {
      class_874(int var1, int var2) {
         super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + var1 + " limit " + var2 + ").");
      }
   }
}
