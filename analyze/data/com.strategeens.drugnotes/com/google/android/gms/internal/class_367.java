package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.internal.class_237;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.ey;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

// $FF: renamed from: com.google.android.gms.internal.gq
@ey
public final class class_367 {
   // $FF: renamed from: wR android.os.Handler
   public static final Handler field_1120 = new Handler(Looper.getMainLooper());

   // $FF: renamed from: R (java.lang.String) java.lang.String
   public static String method_2493(String var0) {
      int var1 = 0;

      while(var1 < 2) {
         try {
            MessageDigest var3 = MessageDigest.getInstance("MD5");
            var3.update(var0.getBytes());
            Locale var4 = Locale.US;
            Object[] var5 = new Object[]{new BigInteger(1, var3.digest())};
            String var6 = String.format(var4, "%032X", var5);
            return var6;
         } catch (NoSuchAlgorithmException var7) {
            ++var1;
         }
      }

      return null;
   }

   // $FF: renamed from: a (android.content.Context, int) int
   public static int method_2494(Context var0, int var1) {
      return method_2495(var0.getResources().getDisplayMetrics(), var1);
   }

   // $FF: renamed from: a (android.util.DisplayMetrics, int) int
   public static int method_2495(DisplayMetrics var0, int var1) {
      return (int)TypedValue.applyDimension(1, (float)var1, var0);
   }

   // $FF: renamed from: a (android.view.ViewGroup, com.google.android.gms.internal.ay, java.lang.String) void
   public static void method_2496(ViewGroup var0, class_237 var1, String var2) {
      method_2497(var0, var1, var2, -16777216, -1);
   }

   // $FF: renamed from: a (android.view.ViewGroup, com.google.android.gms.internal.ay, java.lang.String, int, int) void
   private static void method_2497(ViewGroup var0, class_237 var1, String var2, int var3, int var4) {
      if(var0.getChildCount() == 0) {
         Context var5 = var0.getContext();
         TextView var6 = new TextView(var5);
         var6.setGravity(17);
         var6.setText(var2);
         var6.setTextColor(var3);
         var6.setBackgroundColor(var4);
         FrameLayout var7 = new FrameLayout(var5);
         var7.setBackgroundColor(var3);
         int var8 = method_2494(var5, 3);
         var7.addView(var6, new LayoutParams(var1.widthPixels - var8, var1.heightPixels - var8, 17));
         var0.addView(var7, var1.widthPixels, var1.heightPixels);
      }
   }

   // $FF: renamed from: a (android.view.ViewGroup, com.google.android.gms.internal.ay, java.lang.String, java.lang.String) void
   public static void method_2498(ViewGroup var0, class_237 var1, String var2, String var3) {
      class_368.method_2506(var3);
      method_2497(var0, var1, var2, -65536, -16777216);
   }

   // $FF: renamed from: dA () boolean
   public static boolean method_2499() {
      return Build.DEVICE.startsWith("generic");
   }

   // $FF: renamed from: dB () boolean
   public static boolean method_2500() {
      return Looper.myLooper() == Looper.getMainLooper();
   }

   // $FF: renamed from: v (android.content.Context) java.lang.String
   public static String method_2501(Context var0) {
      String var1 = Secure.getString(var0.getContentResolver(), "android_id");
      if(var1 == null || method_2499()) {
         var1 = "emulator";
      }

      return method_2493(var1);
   }
}
