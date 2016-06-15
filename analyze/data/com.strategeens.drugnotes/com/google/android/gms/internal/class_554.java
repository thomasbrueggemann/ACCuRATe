package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.internal.class_521;
import com.google.android.gms.internal.class_56;
import com.google.android.gms.internal.class_71;
import com.google.android.gms.internal.class_72;
import com.google.android.gms.internal.class_828;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

// $FF: renamed from: com.google.android.gms.internal.h
public abstract class class_554 implements class_56 {
   // $FF: renamed from: kw android.view.MotionEvent
   protected MotionEvent field_2541;
   // $FF: renamed from: kx android.util.DisplayMetrics
   protected DisplayMetrics field_2542;
   // $FF: renamed from: ky com.google.android.gms.internal.m
   protected class_71 field_2543;
   // $FF: renamed from: kz com.google.android.gms.internal.n
   private class_72 field_2544;

   protected class_554(Context var1, class_71 var2, class_72 var3) {
      this.field_2543 = var2;
      this.field_2544 = var3;

      try {
         this.field_2542 = var1.getResources().getDisplayMetrics();
      } catch (UnsupportedOperationException var5) {
         this.field_2542 = new DisplayMetrics();
         this.field_2542.density = 1.0F;
      }
   }

   // $FF: renamed from: a (android.content.Context, java.lang.String, boolean) java.lang.String
   private String method_3361(Context param1, String param2, boolean param3) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: t () void
   private void method_3362() {
      this.field_2544.reset();
   }

   // $FF: renamed from: u () byte[]
   private byte[] method_3363() throws IOException {
      return this.field_2544.method_386();
   }

   // $FF: renamed from: a (android.content.Context) java.lang.String
   public String method_286(Context var1) {
      return this.method_3361(var1, (String)null, false);
   }

   // $FF: renamed from: a (android.content.Context, java.lang.String) java.lang.String
   public String method_287(Context var1, String var2) {
      return this.method_3361(var1, var2, true);
   }

   // $FF: renamed from: a (byte[], java.lang.String) java.lang.String
   String method_3364(byte[] var1, String var2) throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
      if(var1.length > 239) {
         this.method_3362();
         this.method_3365(20, 1L);
         var1 = this.method_3363();
      }

      byte[] var3;
      if(var1.length < 239) {
         byte[] var8 = new byte[239 - var1.length];
         (new SecureRandom()).nextBytes(var8);
         var3 = ByteBuffer.allocate(240).put((byte)var1.length).put(var1).put(var8).array();
      } else {
         var3 = ByteBuffer.allocate(240).put((byte)var1.length).put(var1).array();
      }

      MessageDigest var4 = MessageDigest.getInstance("MD5");
      var4.update(var3);
      byte[] var5 = var4.digest();
      byte[] var6 = ByteBuffer.allocate(256).put(var5).put(var3).array();
      byte[] var7 = new byte[256];
      (new class_521()).method_3229(var6, var7);
      if(var2 != null && var2.length() > 0) {
         this.method_3367(var2, var7);
      }

      return this.field_2543.method_384(var7, true);
   }

   // $FF: renamed from: a (int, int, int) void
   public void method_288(int var1, int var2, int var3) {
      if(this.field_2541 != null) {
         this.field_2541.recycle();
      }

      this.field_2541 = MotionEvent.obtain(0L, (long)var3, 1, (float)var1 * this.field_2542.density, (float)var2 * this.field_2542.density, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
   }

   // $FF: renamed from: a (int, long) void
   protected void method_3365(int var1, long var2) throws IOException {
      this.field_2544.method_387(var1, var2);
   }

   // $FF: renamed from: a (int, java.lang.String) void
   protected void method_3366(int var1, String var2) throws IOException {
      this.field_2544.method_388(var1, var2);
   }

   // $FF: renamed from: a (android.view.MotionEvent) void
   public void method_289(MotionEvent var1) {
      if(var1.getAction() == 1) {
         if(this.field_2541 != null) {
            this.field_2541.recycle();
         }

         this.field_2541 = MotionEvent.obtain(var1);
      }

   }

   // $FF: renamed from: a (java.lang.String, byte[]) void
   void method_3367(String var1, byte[] var2) throws UnsupportedEncodingException {
      if(var1.length() > 32) {
         var1 = var1.substring(0, 32);
      }

      (new class_828(var1.getBytes("UTF-8"))).method_4587(var2);
   }

   // $FF: renamed from: b (android.content.Context) void
   protected abstract void method_3368(Context var1);

   // $FF: renamed from: c (android.content.Context) void
   protected abstract void method_3369(Context var1);
}
