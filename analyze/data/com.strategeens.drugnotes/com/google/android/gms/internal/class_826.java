package com.google.android.gms.internal;

import com.google.android.gms.internal.class_300;
import com.google.android.gms.internal.class_822;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

// $FF: renamed from: com.google.android.gms.internal.qp
public final class class_826 {
   private final int ayV;
   private final byte[] buffer;
   private int position;

   private class_826(byte[] var1, int var2, int var3) {
      this.buffer = var1;
      this.position = var2;
      this.ayV = var2 + var3;
   }

   // $FF: renamed from: D (long) int
   public static int method_4497(long var0) {
      return method_4499(var0);
   }

   // $FF: renamed from: E (long) int
   public static int method_4498(long var0) {
      return method_4499(method_4500(var0));
   }

   // $FF: renamed from: G (long) int
   public static int method_4499(long var0) {
      return (-128L & var0) == 0L?1:((-16384L & var0) == 0L?2:((-2097152L & var0) == 0L?3:((-268435456L & var0) == 0L?4:((-34359738368L & var0) == 0L?5:((-4398046511104L & var0) == 0L?6:((-562949953421312L & var0) == 0L?7:((-72057594037927936L & var0) == 0L?8:((Long.MIN_VALUE & var0) == 0L?9:10))))))));
   }

   // $FF: renamed from: I (long) long
   public static long method_4500(long var0) {
      return var0 << 1 ^ var0 >> 63;
   }

   // $FF: renamed from: X (boolean) int
   public static int method_4501(boolean var0) {
      return 1;
   }

   // $FF: renamed from: b (int, double) int
   public static int method_4502(int var0, double var1) {
      return method_4518(var0) + method_4515(var1);
   }

   // $FF: renamed from: b (int, com.google.android.gms.internal.qw) int
   public static int method_4503(int var0, class_300 var1) {
      return 2 * method_4518(var0) + method_4510(var1);
   }

   // $FF: renamed from: b (int, byte[]) int
   public static int method_4504(int var0, byte[] var1) {
      return method_4518(var0) + method_4523(var1);
   }

   // $FF: renamed from: b (byte[], int, int) com.google.android.gms.internal.qp
   public static class_826 method_4505(byte[] var0, int var1, int var2) {
      return new class_826(var0, var1, var2);
   }

   // $FF: renamed from: c (int, float) int
   public static int method_4506(int var0, float var1) {
      return method_4518(var0) + method_4512(var1);
   }

   // $FF: renamed from: c (int, com.google.android.gms.internal.qw) int
   public static int method_4507(int var0, class_300 var1) {
      return method_4518(var0) + method_4514(var1);
   }

   // $FF: renamed from: c (int, boolean) int
   public static int method_4508(int var0, boolean var1) {
      return method_4518(var0) + method_4501(var1);
   }

   // $FF: renamed from: d (int, long) int
   public static int method_4509(int var0, long var1) {
      return method_4518(var0) + method_4497(var1);
   }

   // $FF: renamed from: d (com.google.android.gms.internal.qw) int
   public static int method_4510(class_300 var0) {
      return var0.method_2093();
   }

   // $FF: renamed from: dk (java.lang.String) int
   public static int method_4511(String var0) {
      int var3;
      int var4;
      try {
         byte[] var2 = var0.getBytes("UTF-8");
         var3 = method_4519(var2.length);
         var4 = var2.length;
      } catch (UnsupportedEncodingException var5) {
         throw new RuntimeException("UTF-8 not supported.");
      }

      return var4 + var3;
   }

   // $FF: renamed from: e (float) int
   public static int method_4512(float var0) {
      return 4;
   }

   // $FF: renamed from: e (int, long) int
   public static int method_4513(int var0, long var1) {
      return method_4518(var0) + method_4498(var1);
   }

   // $FF: renamed from: e (com.google.android.gms.internal.qw) int
   public static int method_4514(class_300 var0) {
      int var1 = var0.method_2093();
      return var1 + method_4519(var1);
   }

   // $FF: renamed from: f (double) int
   public static int method_4515(double var0) {
      return 8;
   }

   // $FF: renamed from: gZ (int) int
   public static int method_4516(int var0) {
      return var0 >= 0?method_4519(var0):10;
   }

   // $FF: renamed from: ha (int) int
   public static int method_4517(int var0) {
      return method_4519(method_4520(var0));
   }

   // $FF: renamed from: hc (int) int
   public static int method_4518(int var0) {
      return method_4519(class_822.method_4487(var0, 0));
   }

   // $FF: renamed from: he (int) int
   public static int method_4519(int var0) {
      return (var0 & -128) == 0?1:((var0 & -16384) == 0?2:((-2097152 & var0) == 0?3:((-268435456 & var0) == 0?4:5)));
   }

   // $FF: renamed from: hg (int) int
   public static int method_4520(int var0) {
      return var0 << 1 ^ var0 >> 31;
   }

   // $FF: renamed from: j (int, java.lang.String) int
   public static int method_4521(int var0, String var1) {
      return method_4518(var0) + method_4511(var1);
   }

   // $FF: renamed from: q (byte[]) com.google.android.gms.internal.qp
   public static class_826 method_4522(byte[] var0) {
      return method_4505(var0, 0, var0.length);
   }

   // $FF: renamed from: s (byte[]) int
   public static int method_4523(byte[] var0) {
      return method_4519(var0.length) + var0.length;
   }

   // $FF: renamed from: v (int, int) int
   public static int method_4524(int var0, int var1) {
      return method_4518(var0) + method_4516(var1);
   }

   // $FF: renamed from: w (int, int) int
   public static int method_4525(int var0, int var1) {
      return method_4518(var0) + method_4517(var1);
   }

   // $FF: renamed from: B (long) void
   public void method_4526(long var1) throws IOException {
      this.method_4528(var1);
   }

   // $FF: renamed from: C (long) void
   public void method_4527(long var1) throws IOException {
      this.method_4528(method_4500(var1));
   }

   // $FF: renamed from: F (long) void
   public void method_4528(long var1) throws IOException {
      while((-128L & var1) != 0L) {
         this.method_4548(128 | 127 & (int)var1);
         var1 >>>= 7;
      }

      this.method_4548((int)var1);
   }

   // $FF: renamed from: H (long) void
   public void method_4529(long var1) throws IOException {
      this.method_4548(255 & (int)var1);
      this.method_4548(255 & (int)(var1 >> 8));
      this.method_4548(255 & (int)(var1 >> 16));
      this.method_4548(255 & (int)(var1 >> 24));
      this.method_4548(255 & (int)(var1 >> 32));
      this.method_4548(255 & (int)(var1 >> 40));
      this.method_4548(255 & (int)(var1 >> 48));
      this.method_4548(255 & (int)(var1 >> 56));
   }

   // $FF: renamed from: W (boolean) void
   public void method_4530(boolean var1) throws IOException {
      byte var2;
      if(var1) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      this.method_4548(var2);
   }

   // $FF: renamed from: a (int, double) void
   public void method_4531(int var1, double var2) throws IOException {
      this.method_4557(var1, 1);
      this.method_4545(var2);
   }

   // $FF: renamed from: a (int, com.google.android.gms.internal.qw) void
   public void method_4532(int var1, class_300 var2) throws IOException {
      this.method_4557(var1, 2);
      this.method_4541(var2);
   }

   // $FF: renamed from: a (int, byte[]) void
   public void method_4533(int var1, byte[] var2) throws IOException {
      this.method_4557(var1, 2);
      this.method_4551(var2);
   }

   // $FF: renamed from: b (byte) void
   public void method_4534(byte var1) throws IOException {
      if(this.position == this.ayV) {
         throw new class_826.class_1660(this.position, this.ayV);
      } else {
         byte[] var2 = this.buffer;
         int var3 = this.position;
         this.position = var3 + 1;
         var2[var3] = var1;
      }
   }

   // $FF: renamed from: b (int, float) void
   public void method_4535(int var1, float var2) throws IOException {
      this.method_4557(var1, 5);
      this.method_4543(var2);
   }

   // $FF: renamed from: b (int, long) void
   public void method_4536(int var1, long var2) throws IOException {
      this.method_4557(var1, 0);
      this.method_4526(var2);
   }

   // $FF: renamed from: b (int, java.lang.String) void
   public void method_4537(int var1, String var2) throws IOException {
      this.method_4557(var1, 2);
      this.method_4544(var2);
   }

   // $FF: renamed from: b (int, boolean) void
   public void method_4538(int var1, boolean var2) throws IOException {
      this.method_4557(var1, 0);
      this.method_4530(var2);
   }

   // $FF: renamed from: b (com.google.android.gms.internal.qw) void
   public void method_4539(class_300 var1) throws IOException {
      var1.method_2089(this);
   }

   // $FF: renamed from: c (int, long) void
   public void method_4540(int var1, long var2) throws IOException {
      this.method_4557(var1, 0);
      this.method_4527(var2);
   }

   // $FF: renamed from: c (com.google.android.gms.internal.qw) void
   public void method_4541(class_300 var1) throws IOException {
      this.method_4549(var1.method_2092());
      var1.method_2089(this);
   }

   // $FF: renamed from: c (byte[], int, int) void
   public void method_4542(byte[] var1, int var2, int var3) throws IOException {
      if(this.ayV - this.position >= var3) {
         System.arraycopy(var1, var2, this.buffer, this.position, var3);
         this.position += var3;
      } else {
         throw new class_826.class_1660(this.position, this.ayV);
      }
   }

   // $FF: renamed from: d (float) void
   public void method_4543(float var1) throws IOException {
      this.method_4550(Float.floatToIntBits(var1));
   }

   // $FF: renamed from: dj (java.lang.String) void
   public void method_4544(String var1) throws IOException {
      byte[] var2 = var1.getBytes("UTF-8");
      this.method_4549(var2.length);
      this.method_4555(var2);
   }

   // $FF: renamed from: e (double) void
   public void method_4545(double var1) throws IOException {
      this.method_4529(Double.doubleToLongBits(var1));
   }

   // $FF: renamed from: gX (int) void
   public void method_4546(int var1) throws IOException {
      if(var1 >= 0) {
         this.method_4549(var1);
      } else {
         this.method_4528((long)var1);
      }
   }

   // $FF: renamed from: gY (int) void
   public void method_4547(int var1) throws IOException {
      this.method_4549(method_4520(var1));
   }

   // $FF: renamed from: hb (int) void
   public void method_4548(int var1) throws IOException {
      this.method_4534((byte)var1);
   }

   // $FF: renamed from: hd (int) void
   public void method_4549(int var1) throws IOException {
      while((var1 & -128) != 0) {
         this.method_4548(128 | var1 & 127);
         var1 >>>= 7;
      }

      this.method_4548(var1);
   }

   // $FF: renamed from: hf (int) void
   public void method_4550(int var1) throws IOException {
      this.method_4548(var1 & 255);
      this.method_4548(255 & var1 >> 8);
      this.method_4548(255 & var1 >> 16);
      this.method_4548(255 & var1 >> 24);
   }

   // $FF: renamed from: r (byte[]) void
   public void method_4551(byte[] var1) throws IOException {
      this.method_4549(var1.length);
      this.method_4555(var1);
   }

   // $FF: renamed from: rO () int
   public int method_4552() {
      return this.ayV - this.position;
   }

   // $FF: renamed from: rP () void
   public void method_4553() {
      if(this.method_4552() != 0) {
         throw new IllegalStateException("Did not write as much data as expected.");
      }
   }

   // $FF: renamed from: t (int, int) void
   public void method_4554(int var1, int var2) throws IOException {
      this.method_4557(var1, 0);
      this.method_4546(var2);
   }

   // $FF: renamed from: t (byte[]) void
   public void method_4555(byte[] var1) throws IOException {
      this.method_4542(var1, 0, var1.length);
   }

   // $FF: renamed from: u (int, int) void
   public void method_4556(int var1, int var2) throws IOException {
      this.method_4557(var1, 0);
      this.method_4547(var2);
   }

   // $FF: renamed from: x (int, int) void
   public void method_4557(int var1, int var2) throws IOException {
      this.method_4549(class_822.method_4487(var1, var2));
   }

   public static class class_1660 extends IOException {
      class_1660(int var1, int var2) {
         super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + var1 + " limit " + var2 + ").");
      }
   }
}
