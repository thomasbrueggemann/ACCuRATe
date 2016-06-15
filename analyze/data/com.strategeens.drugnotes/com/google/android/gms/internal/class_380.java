package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.gms.internal.class_218;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.gb
@ey
public class class_380 {
   // $FF: renamed from: mH java.lang.Object
   private final Object field_1157 = new Object();
   // $FF: renamed from: vZ java.lang.String
   private final String field_1158;
   // $FF: renamed from: wm int
   private int field_1159 = 0;
   // $FF: renamed from: wn long
   private long field_1160 = -1L;
   // $FF: renamed from: wo long
   private long field_1161 = -1L;
   // $FF: renamed from: wp int
   private int field_1162 = 0;
   // $FF: renamed from: wq int
   private int field_1163 = -1;

   public class_380(String var1) {
      this.field_1158 = var1;
   }

   // $FF: renamed from: m (android.content.Context) boolean
   public static boolean method_2595(Context var0) {
      int var1 = var0.getResources().getIdentifier("Theme.Translucent", "style", "android");
      if(var1 == 0) {
         class_368.method_2504("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
         return false;
      } else {
         ComponentName var2 = new ComponentName(var0.getPackageName(), "com.google.android.gms.ads.AdActivity");

         try {
            if(var1 == var0.getPackageManager().getActivityInfo(var2, 0).theme) {
               return true;
            } else {
               class_368.method_2504("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
               return false;
            }
         } catch (NameNotFoundException var4) {
            class_368.method_2506("Fail to fetch AdActivity theme");
            class_368.method_2504("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
         }
      }
   }

   // $FF: renamed from: b (android.content.Context, java.lang.String) android.os.Bundle
   public Bundle method_2596(Context param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (com.google.android.gms.internal.av, long) void
   public void method_2597(class_218 param1, long param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: cW () void
   public void method_2598() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: cX () void
   public void method_2599() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: dq () long
   public long method_2600() {
      return this.field_1161;
   }
}
