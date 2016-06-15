package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.gms.internal.class_182;
import com.google.android.gms.internal.class_370;

// $FF: renamed from: com.google.android.gms.internal.ej
public class class_379 {
   // $FF: renamed from: lq java.lang.Object
   private final Object field_1674 = new Object();
   // $FF: renamed from: rO java.lang.String
   private final String field_1675;
   // $FF: renamed from: rU int
   private int field_1676 = 0;
   // $FF: renamed from: rV long
   private long field_1677 = -1L;
   // $FF: renamed from: rW long
   private long field_1678 = -1L;
   // $FF: renamed from: rX int
   private int field_1679 = 0;
   // $FF: renamed from: rY int
   private int field_1680 = -1;

   public class_379(String var1) {
      this.field_1675 = var1;
   }

   // $FF: renamed from: i (android.content.Context) boolean
   public static boolean method_2418(Context var0) {
      int var1 = var0.getResources().getIdentifier("Theme.Translucent", "style", "android");
      if(var1 == 0) {
         class_370.method_2356("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
         return false;
      } else {
         ComponentName var2 = new ComponentName(var0.getPackageName(), "com.google.android.gms.ads.AdActivity");

         try {
            if(var1 == var0.getPackageManager().getActivityInfo(var2, 0).theme) {
               return true;
            } else {
               class_370.method_2356("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
               return false;
            }
         } catch (NameNotFoundException var4) {
            class_370.method_2358("Fail to fetch AdActivity theme");
            class_370.method_2356("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
         }
      }
   }

   // $FF: renamed from: b (android.content.Context, java.lang.String) android.os.Bundle
   public Bundle method_2419(Context param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (com.google.android.gms.internal.aj, long) void
   public void method_2420(class_182 param1, long param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: bJ () long
   public long method_2421() {
      return this.field_1678;
   }

   // $FF: renamed from: bw () void
   public void method_2422() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: bx () void
   public void method_2423() {
      // $FF: Couldn't be decompiled
   }
}
