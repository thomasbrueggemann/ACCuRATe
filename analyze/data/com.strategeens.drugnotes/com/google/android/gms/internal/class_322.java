package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Locale;

// $FF: renamed from: com.google.android.gms.internal.in
public final class class_322 {
   // $FF: renamed from: a (java.lang.Object, java.lang.Object) boolean
   public static <T> boolean method_2262(T var0, T var1) {
      return var0 == null && var1 == null || var0 != null && var1 != null && var0.equals(var1);
   }

   // $FF: renamed from: aF (java.lang.String) void
   public static void method_2263(String var0) throws IllegalArgumentException {
      if(TextUtils.isEmpty(var0)) {
         throw new IllegalArgumentException("Namespace cannot be null or empty");
      } else if(var0.length() > 128) {
         throw new IllegalArgumentException("Invalid namespace length");
      } else if(!var0.startsWith("urn:x-cast:")) {
         throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\"");
      } else if(var0.length() == "urn:x-cast:".length()) {
         throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\" and have non-empty suffix");
      }
   }

   // $FF: renamed from: aG (java.lang.String) java.lang.String
   public static String method_2264(String var0) {
      return "urn:x-cast:" + var0;
   }

   // $FF: renamed from: b (double) long
   public static long method_2265(double var0) {
      return (long)(1000.0D * var0);
   }

   // $FF: renamed from: b (java.util.Locale) java.lang.String
   public static String method_2266(Locale var0) {
      StringBuilder var1 = new StringBuilder(20);
      var1.append(var0.getLanguage());
      String var3 = var0.getCountry();
      if(!TextUtils.isEmpty(var3)) {
         var1.append('-').append(var3);
      }

      String var4 = var0.getVariant();
      if(!TextUtils.isEmpty(var4)) {
         var1.append('-').append(var4);
      }

      return var1.toString();
   }

   // $FF: renamed from: o (long) double
   public static double method_2267(long var0) {
      return (double)var0 / 1000.0D;
   }
}
