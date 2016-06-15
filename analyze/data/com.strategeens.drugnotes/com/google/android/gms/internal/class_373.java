package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.gg
@ey
public final class class_373 {
   // $FF: renamed from: a (android.content.Context, boolean) void
   public static void method_2540(Context var0, boolean var1) {
      Editor var2 = method_2541(var0).edit();
      var2.putBoolean("use_https", var1);
      var2.commit();
   }

   // $FF: renamed from: n (android.content.Context) android.content.SharedPreferences
   private static SharedPreferences method_2541(Context var0) {
      return var0.getSharedPreferences("admob", 0);
   }

   // $FF: renamed from: o (android.content.Context) boolean
   public static boolean method_2542(Context var0) {
      return method_2541(var0).getBoolean("use_https", true);
   }
}
