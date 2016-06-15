package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.content.Context;
import com.google.android.gms.internal.iy;

// $FF: renamed from: com.google.android.gms.internal.iy
public abstract class class_315<T> {
   // $FF: renamed from: KO com.google.android.gms.internal.iy$a
   private static class_315.class_1587 field_760 = null;
   // $FF: renamed from: mH java.lang.Object
   private static final Object field_761 = new Object();
   // $FF: renamed from: KP java.lang.String
   protected final String field_762;
   // $FF: renamed from: KQ java.lang.Object
   protected final T field_763;
   // $FF: renamed from: KR java.lang.Object
   private T field_764 = null;

   protected class_315(String var1, T var2) {
      this.field_762 = var1;
      this.field_763 = var2;
   }

   // $FF: renamed from: H (android.content.Context) void
   public static void method_2210(Context param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (java.lang.String, java.lang.Integer) com.google.android.gms.internal.iy
   public static iy<Integer> method_2211(final String var0, final Integer var1) {
      return new class_315(var0, var1) {
      };
   }

   // $FF: renamed from: h (java.lang.String, boolean) com.google.android.gms.internal.iy
   public static iy<Boolean> method_2212(final String var0, boolean var1) {
      return new class_315(var0, Boolean.valueOf(var1)) {
      };
   }

   // $FF: renamed from: l (java.lang.String, java.lang.String) com.google.android.gms.internal.iy
   public static iy<String> method_2213(final String var0, final String var1) {
      return new class_315(var0, var1) {
      };
   }

   public String getKey() {
      return this.field_762;
   }

   private interface class_1587 {
   }

   private static class class_1588 implements class_315.class_1587 {
      private final ContentResolver mContentResolver;

      public class_1588(ContentResolver var1) {
         this.mContentResolver = var1;
      }
   }
}
