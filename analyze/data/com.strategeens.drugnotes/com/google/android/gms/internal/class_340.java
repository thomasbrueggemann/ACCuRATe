package com.google.android.gms.internal;

import android.content.Intent;
import android.net.Uri;

// $FF: renamed from: com.google.android.gms.internal.jo
public class class_340 {
   // $FF: renamed from: No android.net.Uri
   private static final Uri field_899 = Uri.parse("http://plus.google.com/");
   // $FF: renamed from: Np android.net.Uri
   private static final Uri field_900;

   static {
      field_900 = field_899.buildUpon().appendPath("circles").appendPath("find").build();
   }

   // $FF: renamed from: aY (java.lang.String) android.content.Intent
   public static Intent method_2332(String var0) {
      Uri var1 = Uri.fromParts("package", var0, (String)null);
      Intent var2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      var2.setData(var1);
      return var2;
   }

   // $FF: renamed from: aZ (java.lang.String) android.net.Uri
   private static Uri method_2333(String var0) {
      return Uri.parse("market://details").buildUpon().appendQueryParameter("id", var0).build();
   }

   // $FF: renamed from: ba (java.lang.String) android.content.Intent
   public static Intent method_2334(String var0) {
      Intent var1 = new Intent("android.intent.action.VIEW");
      var1.setData(method_2333(var0));
      var1.setPackage("com.android.vending");
      var1.addFlags(524288);
      return var1;
   }

   // $FF: renamed from: hE () android.content.Intent
   public static Intent method_2335() {
      Intent var0 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
      var0.setPackage("com.google.android.wearable.app");
      return var0;
   }
}
